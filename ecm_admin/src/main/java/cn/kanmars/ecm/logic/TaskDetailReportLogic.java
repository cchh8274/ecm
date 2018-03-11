/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblTaskDetailReport;
/**
 * 任务执行实例表
 * tbl_task_detail_report
 */
public interface TaskDetailReportLogic {

    /*
     * 查询信息
     */
    public TblTaskDetailReport queryTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageTaskDetailReport(HashMap paramMap) throws Exception;

}

