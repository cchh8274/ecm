package cn.kanmars.ecm.service.impl;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.kanmars.ecm.dao.TaskInfoDAO;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * @ClassName: TaskDeadlockImpl 
 * @Description: 死锁任务解锁执行器实现 
 */
public class TaskDeadlockRunImpl  implements Job{
	
	private HLogger logger = LoggerManager.getLoger("TaskDeadlockRunImpl");

	/**
	 * 死锁任务解锁执行器实现 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Object obj = context.getJobDetail().getJobDataMap().get("taskInfoDAO");
		if(obj != null){
			TaskInfoDAO taskInfoDAO = (TaskInfoDAO) obj;
			taskInfoDAO.getDieTaskOpenConfigRun();
			logger.info("死锁任务解锁执行成功。。。");
		}
	}

}
