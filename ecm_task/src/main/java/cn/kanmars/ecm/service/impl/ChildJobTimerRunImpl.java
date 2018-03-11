package cn.kanmars.ecm.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.DateUtils;
import cn.com.xbase.frame.util.SpringBeanFactory;
import cn.com.xbase.frame.util.StringUtils;
import cn.com.xbase.tools.idgen.IDGeneratorTools;
import cn.kanmars.ecm.bean.TaskBasicConfig;
import cn.kanmars.ecm.cache.SystemConfigInfoCache;
import cn.kanmars.ecm.dao.TblTaskDetailLogMapper;
import cn.kanmars.ecm.dao.TblTaskDetailReportMapper;
import cn.kanmars.ecm.entity.TblTaskDetailLog;
import cn.kanmars.ecm.entity.TblTaskDetailReport;
import cn.kanmars.ecm.step.AbstractStep;
import cn.kanmars.ecm.step.IStep;
import cn.kanmars.ecm.utils.BasisConstants;
import cn.kanmars.ecm.utils.QueryServerInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.io.output.StringBuilderWriter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * ChildJobTimerRunImpl
 * 执行子任务的执行器实现
 */
public class ChildJobTimerRunImpl implements Job{

    private HLogger logger = LoggerManager.getLoger("BaseJobTimerRunImpl");

    /**
     * 执行子任务的执行器实现
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Object obj = context.getJobDetail().getJobDataMap().get("TaskBasicConfig");
        //在ChildTimerBuildServiceImpl.timerGenerator时创建信号量
        Map<String,ConcurrentHashMap<String,Object>> kernel = SystemConfigInfoCache.getTaskInnerInfos();
        if(obj != null){
            TaskBasicConfig config = (TaskBasicConfig) obj;
            IStep istep = (IStep) SpringBeanFactory.getBean(config.getBusinessObjName());
            if(istep==null)return;
            String className = istep.getClass().getSuperclass().getSimpleName();
            //如果是AbstractStep，则设置kernelObj对象
            if(istep instanceof AbstractStep){
                String taskName = context.getJobDetail().getKey().getName();
                ConcurrentHashMap<String,Object> kernel_obj = SystemConfigInfoCache.getTaskInnerInfos().get(taskName);
                ((AbstractStep)istep).setKernel_obj(kernel_obj);
                ((AbstractStep)istep).setTaskName(taskName);
                ((AbstractStep)istep).setBusinessObjName(config.getBusinessObjName());
                //从context中尝试获取消息队列数据，返回结果可能有两种：1)字符串消息，2)null
                String trigerMessage = getTrigerMessage(context);
                //记录开始时间
                long allStart = System.currentTimeMillis();
                String allBeginTime = DateUtils.getCurrDateTime();
                int planCount = 0;//计划数量
                int execCount = 0;//执行成功数量
                int perAvgExecUseTime = 0 ;//计算单条记录平均耗时
                boolean continueFlgAndHasRecord;
                do {
                    //初始化循环执行标记
                    continueFlgAndHasRecord = false;
                    //执行主程序开始######################################################################################
                    {
                        //获取信号量，在ChildTimerBuildServiceImpl.timerGenerator时创建信号量
                        Semaphore semaphone = (Semaphore) kernel_obj.get(BasisConstants.KERNELOBJ_Semaphore);
                        int batchCount = 0;
                        int batchIndex = -1;
                        String perBeginTime = DateUtils.getCurrDateTime(), perEndTime;
                        try {
                            //如果runStatus=0，则同时运行taskCount个任务，当每个任务未执行完时，新任务触发则可以任意执行，不受限制，即：可能出现任务堆积线程数用尽的情况
                            //如果runStatus=1，则同时运行taskCount个任务，当每个任务未执行完时，新任务触发后会等待上一个任务执行完成，如果等待超时后(默认6000毫秒)，上一个任务未执行完，则需要抛弃此任务
                            //如果runStatus=2，则同时运行taskCount个任务，当每个任务未执行完时，新任务触发后则抛弃此任务
                            if ("1".equals(config.getRunStatus())) {
                                logger.debug("开始申请信号量" + semaphone);
                                boolean requireResult = semaphone.tryAcquire(6000, TimeUnit.MILLISECONDS);
                                if (!requireResult) {
                                    logger.debug("申请信号量失败");
                                    //如果6秒内没有获取到信号量，则停止当前任务执行
                                    return;
                                }
                                logger.debug("申请信号量成功");
                            } else if ("2".equals(config.getRunStatus())) {
                                int i = semaphone.availablePermits();//获取当前信号量可用的数量
                                if (i <= 0) {
                                    //如果已经信号量被别的线程占用，则停止任务执行
                                    return;
                                }
                            }
                            //按照统一流程执行
                            List<Object> list = istep.queryTaskInfo(config, trigerMessage);
                            //统计查询出多少要执行的数据
                            if (list != null) {
                                planCount = list.size();
                            } else {
                                planCount = 0;
                            }
                            if (list != null && list.size() > 0) {
                                batchCount = list.size();
                                for (int i = 0; i < list.size(); i++) {
                                    batchIndex = i;
                                    Object temp = list.get(i);
                                    //记录单条数据开始时间
                                    long perStart = System.currentTimeMillis();
                                    perBeginTime = DateUtils.getCurrDateTime();
                                    //此处不try，是为了保留在业务层任务执行到一半发现错误，进而暂停的能力
                                    //执行单条
                                    boolean execResult = istep.runTask(temp);
                                    //如果单条数据为true，则执行成功记录加一
                                    if (execResult) {
                                        execCount++;
                                    }
                                    //记录单条数据结束时间
                                    long perEnd = System.currentTimeMillis();
                                    perEndTime = DateUtils.getCurrDateTime();
                                    //计算单条数据平均时间
                                    perAvgExecUseTime = (perAvgExecUseTime + ((int) (perEnd - perStart)) / 1000) / 2;
                                    //储存日志
                                    storeExecutelog(config, (AbstractStep) istep, kernel_obj, batchCount, batchIndex, perBeginTime, perEndTime, Boolean.toString(execResult));
                                }
                                istep.editTaskInfo(list);
                            } else {
                                logger.info("没有查询到需要执行的记录：" + config.getTaskName());
                            }
                        } catch (Exception e) {
                            logger.error("处理异常", e);
                            StringBuilder sb = new StringBuilder();
                            e.printStackTrace(new PrintWriter(new StringBuilderWriter(sb)));
                            //添加异常消息，最长储存500个字符
                            ((AbstractStep) istep).addLogRecord(sb.toString().substring(0, 500));
                            //储存记录
                            storeExecutelog(config, (AbstractStep) istep, kernel_obj, batchCount, batchIndex, perBeginTime, null, "false");
                        } finally {
                            if ("1".equals(config.getRunStatus()) || "2".equals(config.getRunStatus())) {
                                semaphone.release();
                                logger.debug("释放信号量");
                            }
                        }
                    }
                    //执行主程序结束######################################################################################
                    long allEnd = System.currentTimeMillis();
                    String allEndTime = DateUtils.getCurrDateTime();
                    //计算总耗时
                    int execUseTime = (int) (allEnd - allStart);
                    //储存执行信息
                    storeExecuteReport(config, (AbstractStep) istep, kernel_obj, planCount, execCount, execUseTime, perAvgExecUseTime, allBeginTime, allEndTime);
                    //判断是否需要循环执行
                    if("010".equals(config.getContinueFlg())){
                        //如果循环执行标记为true，则尝试再次查询数据，如果数据不为空且不为0，则继续执行
                        List<Object> list = istep.queryTaskInfo(config, trigerMessage);
                        if(list!=null && list.size()>0){
                            continueFlgAndHasRecord=true;
                        }
                    }
                }while(continueFlgAndHasRecord);//如果果循环执行标记为true并且有数据，则继续执行
                // 该算法用于处理数据量较大，但是每次只能处理一小部分数据的情况，
                // 如：支付成功消息推送，支付推送期间可能会有新数据产生  等情况
                // 其功能在于：减少任务执行间隔、提高任务处理连续性
                // 常用配置为：并行限制run_status=2（新任务抛弃），continue_flg=010（连续执行）
                // 则可以轻松实现任务的连续执行功能
            }else{
                try{
                    //按照统一流程执行
                    List<Object> list = istep.queryTaskInfo(config,null);
                    if(list != null){
                        for(Object temp : list){
                            istep.runTask(temp);
                        }
                        istep.editTaskInfo(list);
                    }else{
                        logger.info("没有查询到需要执行的记录："+config.getTaskName());
                    }
                }catch(Exception e){
                    logger.error("处理异常",e);
                }
            }
        }
    }

    /**
     * 储存执行信息
     * @param kernel_obj    核心对象
     * @param planCount    计划执行数量
     * @param execCount    实际执行数量
     * @param execUseTime    当前任务执行时间
     * @param perAvgExecUseTime    平均每个数据执行时间
     */
    public void storeExecuteReport(TaskBasicConfig taskBasicConfig ,AbstractStep istep,ConcurrentHashMap<String,Object> kernel_obj,int planCount,int execCount,int execUseTime,int perAvgExecUseTime,String lastBeginTime,String lastEndTime){
        synchronized (kernel_obj){
            // 以每个任务的kernel_obj为监视器对象，作用是以线程任务为维度，防止读后写，导致数据丢失，
            // 但是此锁在进程级别将失效，其功能为：最大可能的降低丢数据概率
            // 如果想彻底解决丢数据问题，需要将同步锁换成分布式锁
            // 另，storeExecuteLog 中由于没有读后写，因此不会有此类问题，此同步锁作用为：和storeExecuteReport保持一致
            if("010".equals(taskBasicConfig.getLogFlg())){
                //如果需要储存到数据库中
                try{
                    TblTaskDetailReportMapper tblTaskDetailReportMapper = (TblTaskDetailReportMapper)SpringBeanFactory.getBean("tblTaskDetailReportMapper");
                    TblTaskDetailReport tblTaskDetailReport = new TblTaskDetailReport();
                    //以istep一个执行实体为唯一标识
                    tblTaskDetailReport.setGlobalTaskName(istep.getGlobalTaskName());
                    //根据全局唯一编号来查
                    tblTaskDetailReport = tblTaskDetailReportMapper.select(tblTaskDetailReport);
                    boolean saveFlag = true;
                    if(tblTaskDetailReport==null){
                        tblTaskDetailReport = new TblTaskDetailReport();
                        tblTaskDetailReport.setId((int)IDGeneratorTools.createSimpleLong());
                        tblTaskDetailReport.setExecHistory("[]");//空的JSONARRAY
                        tblTaskDetailReport.setCreateTime(DateUtils.getCurrDateTime());
                        saveFlag = true;
                        //不存在则直接插入
                    }else{
                        saveFlag = false;
                        //存在则更新
                    }
                    tblTaskDetailReport.setTaskCnName(taskBasicConfig.getTaskName());
                    tblTaskDetailReport.setBusinessObjName(taskBasicConfig.getBusinessObjName());
                    tblTaskDetailReport.setRegisterGroup(BasisConstants.registerGroup);
                    tblTaskDetailReport.setIpInfo(QueryServerInfo.getIp());
                    tblTaskDetailReport.setGlobalTaskName(istep.getGlobalTaskName());
                    tblTaskDetailReport.setGlobalTaskCount(istep.getGlobalTaskCount());//无感知状态此值为1
                    tblTaskDetailReport.setGlobalTaskIndex(istep.getGlobalTaskIndex());//无感知状态此值为0
                    tblTaskDetailReport.setLastBeginTime(lastBeginTime);
                    tblTaskDetailReport.setLastEndTime(lastEndTime);
                    tblTaskDetailReport.setExecNeedCount(planCount);
                    tblTaskDetailReport.setExecSuccCount(execCount);
                    String preHistory = tblTaskDetailReport.getExecHistory();
                    JSONArray execHistory = JSONArray.fromObject(preHistory);
                    HashMap history = new HashMap();
                    history.put("beginTime", lastBeginTime);//最近执行时间
                    history.put("endTime", lastEndTime);//最近执行时间
                    history.put("planCount", planCount + "");//查询出的应执行的任务数量
                    history.put("execCount", execCount + "");//实际执行成功的任务数量
                    history.put("execUseTime",execUseTime+"");
                    history.put("perAvgExecUseTime",perAvgExecUseTime+"");
                    execHistory.add(0, JSONObject.fromObject(history));
                    if(execHistory.size()>10){
                        for(int i=10;i<execHistory.size();i++){
                            execHistory.remove(i);
                        }
                    }//删除超出10条的数据
                    tblTaskDetailReport.setExecHistory(execHistory.toString());
                    //计算最近10次平均耗时
                    {
                        int all_10_cost = 0;
                        int count =0;
                        for(int i=0;i<execHistory.size();i++){
                            Map history_cell = (Map)execHistory.get(i);
                            String execUseTime_cell = (String)history_cell.get("execUseTime");
                            all_10_cost += Integer.parseInt(execUseTime_cell);
                            count++;
                        }
                        int last_10_avg_cost = all_10_cost/count;
                        tblTaskDetailReport.setLast10AvgCost(last_10_avg_cost);
                    }
                    //计算最近5次平均耗时
                    {
                        int all_5_avg_cost = 0;
                        int count =0;
                        for(int i=0;i<execHistory.size()&&i<5;i++){
                            Map history_cell = (Map)execHistory.get(i);
                            String execUseTime_cell = (String)history_cell.get("execUseTime");
                            all_5_avg_cost += Integer.parseInt(execUseTime_cell);
                            count++;
                        }
                        int last_10_avg_cost = all_5_avg_cost/count;
                        tblTaskDetailReport.setLast5AvgCost(all_5_avg_cost);
                    }

                    tblTaskDetailReport.setUpTime(DateUtils.getCurrDateTime());
                    int saveResult = 0;
                    if(saveFlag){
                        //保存
                        saveResult = tblTaskDetailReportMapper.insert(tblTaskDetailReport);
                    }else{
                        //更新
                        saveResult = tblTaskDetailReportMapper.updateByPrimaryKey(tblTaskDetailReport);
                    }
                    logger.info("任务执行实例表储存条数["+saveResult+"]");
                }catch (Exception e){
                    logger.error("定时任务日志记录失败：",e);
                }
            }
            if(1==1){//默认执行
                //如果需要储存到zookeeper上
                ZkClient zkCLient = null;
                if(kernel_obj!=null){
                    zkCLient = (ZkClient)kernel_obj.get("zkClient");
                }
                String GLOBAL_REGISTER_PATH = null;
                if(zkCLient!=null&&kernel_obj!=null){
                    String GLOBAL_REGISTER_PATH_tmp = (String)kernel_obj.get("GLOBAL_REGISTER_PATH");
                    if(zkCLient.exists(GLOBAL_REGISTER_PATH_tmp)){
                        GLOBAL_REGISTER_PATH = GLOBAL_REGISTER_PATH_tmp;
                    }
                }
                if(zkCLient!=null&&kernel_obj!=null&&GLOBAL_REGISTER_PATH!=null){
                    //保证历史对象存在
                    JSONArray execHistory = new JSONArray();
                    if(zkCLient.exists(GLOBAL_REGISTER_PATH)){
                        try{
                            String preData = zkCLient.readData(GLOBAL_REGISTER_PATH);
                            if(StringUtils.isNotEmpty(preData)&&preData.startsWith("{")){
                                JSONObject preData_json = JSONObject.fromObject(preData);
                                execHistory = preData_json.getJSONArray("execHistory");
                                if(execHistory==null){
                                    execHistory = new JSONArray();
                                }
                            }
                        }catch (Exception e){
                            logger.debug("处理异常可忽略",e);
                            execHistory = new JSONArray();
                        }
                    }
                    //将本次的信息存入历史对象
                    HashMap storeMap = new HashMap();
                    storeMap.put("execTime", DateUtils.getCurrDateTime());//最近执行时间
                    storeMap.put("planCount", planCount + "");//查询出的应执行的任务数量
                    storeMap.put("execCount", execCount + "");//实际执行成功的任务数量
                    storeMap.put("execUseTime",execUseTime+"");
                    storeMap.put("perAvgExecUseTime",perAvgExecUseTime+"");
                    execHistory.add(0, JSONObject.fromObject(storeMap));//再未把history序列化之前，放入execHistory
                    if(execHistory.size()>10){
                        for(int i=10;i<execHistory.size();i++){
                            execHistory.remove(i);
                        }
                    }//删除超出10条的数据
                    storeMap.put("execHistory", execHistory);
                    zkCLient.writeData(GLOBAL_REGISTER_PATH, JSONObject.fromObject(storeMap).toString());
                }
            }
            
        }
    }

    public void storeExecutelog(TaskBasicConfig taskBasicConfig ,AbstractStep istep,ConcurrentHashMap<String,Object> kernel_obj,int batchCount,int batchIndex,String beginTime,String endTime,String execResult){
        synchronized (kernel_obj){
            // 以每个任务的kernel_obj为监视器对象，作用是以线程任务为维度，防止读后写，导致数据丢失，
            // 但是此锁在进程级别将失效，其功能为：最大可能的降低丢数据概率
            // 如果想彻底解决丢数据问题，需要将同步锁换成分布式锁
            // 另，storeExecuteLog 中由于没有读后写，因此不会有此类问题，此同步锁作用为：和storeExecuteReport保持一致
            if("010".equals(taskBasicConfig.getLogFlg())){
                //如果需要储存到数据库中
                try{
                    TblTaskDetailLogMapper tblTaskDetailLogMapper = (TblTaskDetailLogMapper)SpringBeanFactory.getBean("tblTaskDetailLogMapper");
                    TblTaskDetailLog tblTaskDetailLog = new TblTaskDetailLog();
                    //以istep一个执行实体为唯一标识
                    tblTaskDetailLog.setId(IDGeneratorTools.createSimpleLong());
                    tblTaskDetailLog.setTaskCnName(taskBasicConfig.getTaskName());
                    tblTaskDetailLog.setBusinessObjName(taskBasicConfig.getBusinessObjName());
                    tblTaskDetailLog.setRegisterGroup(BasisConstants.registerGroup);
                    tblTaskDetailLog.setIpInfo(QueryServerInfo.getIp());
                    tblTaskDetailLog.setGlobalTaskName(istep.getGlobalTaskName());
                    tblTaskDetailLog.setGlobalTaskCount(istep.getGlobalTaskCount());//无感知状态此值为1
                    tblTaskDetailLog.setGlobalTaskIndex(istep.getGlobalTaskIndex());//无感知状态此值为0
                    tblTaskDetailLog.setBatchCount(batchCount);
                    tblTaskDetailLog.setBatchIndex(batchIndex);
                    tblTaskDetailLog.setBeginTime(beginTime);
                    tblTaskDetailLog.setEndTime(endTime);
                    tblTaskDetailLog.setExecResult(execResult);
                    tblTaskDetailLog.setExecLog(istep.getLogRecord());
                    tblTaskDetailLog.setCreateTime(DateUtils.getCurrDateTime());
                    tblTaskDetailLog.setUpTime(DateUtils.getCurrDateTime());
                    int saveResult = tblTaskDetailLogMapper.insert(tblTaskDetailLog);
                    logger.info("任务执行日志表储存条数["+saveResult+"]");
                }catch(Exception e){
                    logger.error("定时任务日志记录失败：",e);
                }
            }
        }
    }

    /**
     * 如果是触发的消息，可以从context中获取到触发对象
     * @param context
     * @return 转化后的消息字符串
     */
    public String getTrigerMessage(JobExecutionContext context){
        String topic = (String) context.getJobDetail().getJobDataMap().get("topic");
        String tags = (String) context.getJobDetail().getJobDataMap().get("tags");
        String keys = (String) context.getJobDetail().getJobDataMap().get("keys");
        byte[] body = (byte[]) context.getJobDetail().getJobDataMap().get("body");
        String message = null;
        if (topic != null && tags != null && body != null) {
            try {
                message = new String(body, "utf-8");
                logger.info("定时任务被消息触发topic[" + topic + "]tags[" + tags + "]keys[" + keys + "]message[" + message + "]");
                //debug打印二进制位图
                logger.debug("body", body);
                if (message.equals("NULLMESSAGE")) {
                    //如果是被TaskTrigerUtils放入了一个字符串是NULLMESSAGE，则直接设置message为null
                    message = null;
                }
            } catch (UnsupportedEncodingException e) {
                logger.error("消息转化异常", e);
            }
        }
        return message;
    }

}
