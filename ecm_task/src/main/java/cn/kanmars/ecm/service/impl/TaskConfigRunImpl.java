package cn.kanmars.ecm.service.impl;

import java.util.List;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.SpringBeanFactory;
import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.bean.TaskBasicConfig;
import cn.kanmars.ecm.cache.SystemConfigInfoCache;
import cn.kanmars.ecm.dao.TaskInfoDAO;
import cn.kanmars.ecm.service.TimerBuildService;
import cn.kanmars.ecm.utils.BasisConstants;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName: TaskConfigRunImpl 
 * @Description: 任务参数变更执行器业务实现 
 * @date 2015年1月21日 上午10:29:17
 */
public class TaskConfigRunImpl implements Job {
	
	private HLogger logger = LoggerManager.getLoger("TaskConfigRunImpl");

	/* (非 Javadoc) 
	 * <p>Title: execute</p> 
	 * <p>Description: 任务参数变更执行器业务实现 </p> 
	 * @param context
	 * @throws JobExecutionException 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext) 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Object obj = context.getJobDetail().getJobDataMap().get("taskInfoDAO");
		try{
			if(obj != null){
				TaskInfoDAO taskInfoDAO = (TaskInfoDAO) obj;
				List<TaskBasicConfig> tbcList = taskInfoDAO.getTaskBasicConfig();
				upTaskBasicConfig(tbcList);
				logger.info("任务参数变更执行成功。。。");
				
				//读取站点推送配置到缓存
				SystemConfigInfoCache.setSiteList(taskInfoDAO.getSiteChildTask());
			}
		}catch(Exception e){
			logger.error("任务参数变更异常",e);
		}
	}

	/**
	* @Title: upTaskBasicConfig 
	* @Description: 执行任务配置信息变更 
	* @param tbcList    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void upTaskBasicConfig(List<TaskBasicConfig> tbcList){
		if(tbcList.size()>0){
			TimerBuildService timerBuildService = (TimerBuildService) SpringBeanFactory.getBean("childTimerBuildServiceImpl");
			for(TaskBasicConfig config : tbcList){
				String key = SystemConfigInfoCache.getUpdateTaskTimeMap().get(config.getId()+"_"+ BasisConstants.CHILD_TASK_RUN);
				if(StringUtils.isEmpty(key)){
					timerBuildService.createTimer(config);
				}else{
					if("1".equals(config.getStatus())){
						if(!key.equals(config.getUpTime())){
							timerBuildService.updateTimer(config);
						}
					}else{
						timerBuildService.deleteTimer(config);
					}
				}
			}
		}
		SystemConfigInfoCache.setRuleList(tbcList);
	}
}
