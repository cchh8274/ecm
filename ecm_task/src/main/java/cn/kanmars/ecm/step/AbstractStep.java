package cn.kanmars.ecm.step;

import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.bean.TaskBasicConfig;
import cn.kanmars.ecm.cache.SystemConfigInfoCache;
import cn.kanmars.ecm.utils.QueryServerInfo;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/** 
 * @ClassName: AbstractStep，具有加强功能的:
 *     获取
 *     taskName            任务序号            JOBID_序号
 *     businessObjName        业务对象名称        BUSINESS_OBJ_NAME
 *     globalTaskName        全局任务名称        例如:syncProductDetailTask_HOSTNAMEBAOLONG_IP10.144.33.185_PID9260_TASKNAME530_2
 *     globalTaskCount        全局任务数量        共有多少任务        (用于分片与建立监听，默认为1)
 *     globalTaskIndex        当前全局任务索引    当前任务的全局序号    (用于分片与建立监听，默认为0)
 *
 * @Description:
 * @author baolong
 * @date 2016年4月8日 下午10:09:50
 */
@SuppressWarnings("unchecked")
public abstract class AbstractStep<T> implements IStep<T>{

    private ThreadLocal<String> taskName_tl = new ThreadLocal<String>();

    private String businessObjName;

    private ThreadLocal<ConcurrentHashMap<String,Object>> kernel_obj_tl = new ThreadLocal<ConcurrentHashMap<String,Object>>();

    protected ThreadLocal<List<String>> logRecord_tl = new ThreadLocal<List<String>>();

    public String getGlobalTaskName(){
        if(getKernel_obj()!=null){
            String GLOBAL_TASK_NAME = (String)getKernel_obj().get("GLOBAL_TASK_NAME");
            if(StringUtils.isEmpty(GLOBAL_TASK_NAME)){
                GLOBAL_TASK_NAME = businessObjName+"_HOSTNAME"+ QueryServerInfo.getHostName()+"_IP"+QueryServerInfo.getIp()+"_PID"+ QueryServerInfo.getPid()+"_TASKNAME"+ taskName_tl.get();
                getKernel_obj().put("GLOBAL_TASK_NAME",GLOBAL_TASK_NAME);
            }
            return GLOBAL_TASK_NAME;
        }
        return businessObjName+"_HOSTNAME"+ QueryServerInfo.getHostName()+"_IP"+QueryServerInfo.getIp()+"_PID"+ QueryServerInfo.getPid()+"_TASKNAME"+ taskName_tl.get();
    }

    /**
     * 获取全局task数量
     * @return
     */
    public int getGlobalTaskCount(){
        if(getKernel_obj()!=null){
            try{
                String GLOBAL_TASK_COUNT = (String)getKernel_obj().get("GLOBAL_TASK_COUNT");
                Integer globalTaskCount = Integer.parseInt(GLOBAL_TASK_COUNT);
                return globalTaskCount;
            }catch (Exception e){}
        }
        return 1;
    }

    /**
     * 获取当前task的序号
     * @return
     */
    public int getGlobalTaskIndex(){
        if(getKernel_obj()!=null){
            try{
                String GLOBAL_TASK_INDEX = (String)getKernel_obj().get("GLOBAL_TASK_INDEX");
                Integer globalTaskIndex = Integer.parseInt(GLOBAL_TASK_INDEX);
                return globalTaskIndex;
            }catch (Exception e){}
        }
        return 0;
    }

    /**
     * 获取该线程在此进程内部的总运行数
     * @return
     */
        public int getThreadTaskCount(TaskBasicConfig taskBasicConfig){
        return taskBasicConfig.getTaskCount();
    }

    /**
     * 获取该线程在此进程内部的序号
     * @return
     */
    public int getThreadTaskIndex(){
        String taskName = taskName_tl.get();
        String index = taskName.substring(taskName.lastIndexOf("_")+1);
        int result = Integer.parseInt(index);
        return result;
    }


    public String getBusinessObjName() {
        return businessObjName;
    }

    public void setBusinessObjName(String businessObjName) {
        this.businessObjName = businessObjName;
    }

    public String getTaskName() {
        return taskName_tl.get();
    }

    public void setTaskName(String taskName) {
        this.taskName_tl.set(taskName);
    }

    public ConcurrentHashMap<String, Object> getKernel_obj() {
        return kernel_obj_tl.get();
    }

    public void setKernel_obj(ConcurrentHashMap<String, Object> kernel_obj){
        this.kernel_obj_tl.set(kernel_obj);
    }

    /**
     * 最多增加1800的日志,此日志会记录入tbl_task_detail_log中
     * @param logStr
     * @return
     */
    public boolean addLogRecord(String logStr){
        if(logRecord_tl.get().toString().getBytes().length-logStr.getBytes().length>1800){
            return false;
        }
        this.logRecord_tl.get().add(logStr);
        return true;
    }

    public String getLogRecord(){
        List<String> logRecord = logRecord_tl.get();
        if(logRecord==null){
            logRecord = new ArrayList<String>();
        }
        return logRecord.toString();
    }

}
