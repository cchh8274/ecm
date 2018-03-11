package cn.kanmars.ecm.dao;

import cn.kanmars.ecm.bean.DieTaskOpenConfig;
import cn.kanmars.ecm.bean.SiteChildTask;
import cn.kanmars.ecm.bean.TaskBasicConfig;

import java.util.List;

/**
 * @ClassName: TaskInfoDAO 
 * @Description: 查询系统配置表信息
 */
public interface TaskInfoDAO {
	
	/** 
	* @Title: getBasicList 
	* @Description: 查询任务基本信息配置表的所有信息
	* @return List<TaskBasicConfig>    返回类型 
	* @throws
	 */
	public List<TaskBasicConfig> getTaskBasicConfig();
	
	/** 
	* @Title: getSiteChildTask 
	* @Description: 查询站点子任务配置表的所有信息
	* @return List<SiteChildTask>    返回类型 
	* @throws
	 */
	public List<SiteChildTask> getSiteChildTask();
	
	/** 
	* @Title: getDieTaskOpenConfig
	* @Description: 查询死锁任务解锁SQL配置表的所有信息
	* @return List<TaskBasicConfig>    返回类型 
	* @throws
	 */
	public List<DieTaskOpenConfig> getDieTaskOpenConfig();
	
	/** 
	* @Title: getDieTaskOpenConfig
	* @Description: 解锁死锁任务
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean getDieTaskOpenConfigRun();
}
