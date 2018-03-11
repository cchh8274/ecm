/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblTaskDetailLog;
/**
 * 任务执行日志表
 * tbl_task_detail_log
 */
public interface TaskDetailLogLogic {

    /*
     * 查询信息
     */
    public TblTaskDetailLog queryTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageTaskDetailLog(HashMap paramMap) throws Exception;

}

