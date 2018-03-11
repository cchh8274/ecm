/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic.impl;


import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.kanmars.ecm.util.PageQueryUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import cn.kanmars.ecm.entity.TblTaskDetailReport;
import cn.kanmars.ecm.dao.TblTaskDetailReportMapper;
/**
 * 任务执行实例表
 * tbl_task_detail_report
 */
@Service
@Transactional
public class TaskDetailReportLogicImpl implements cn.kanmars.ecm.logic.TaskDetailReportLogic{

    protected HLogger logger = LoggerManager.getLoger("TaskDetailReportLogicImpl");

    @Autowired
    private TblTaskDetailReportMapper tblTaskDetailReportMapper;

    /*
     * 查询信息
     */
    public TblTaskDetailReport queryTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception {
        logger.debug("queryTaskDetailReport:start");
        logger.debug("传入参数:tblTaskDetailReport:" + (tblTaskDetailReport != null ? JSONObject.fromObject(tblTaskDetailReport).toString() : "null"));
        TblTaskDetailReport result = tblTaskDetailReportMapper.select(tblTaskDetailReport);
        logger.debug("查询结果:tblTaskDetailReport:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryTaskDetailReport:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception {
        logger.debug("insertTaskDetailReport:start");
        logger.debug("传入参数:tblTaskDetailReport:" + (tblTaskDetailReport != null ? JSONObject.fromObject(tblTaskDetailReport).toString() : "null"));
        int insertNum = tblTaskDetailReportMapper.insert(tblTaskDetailReport);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertTaskDetailReport:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception {
        logger.debug("updateTaskDetailReport:start");
        logger.debug("传入参数:tblTaskDetailReport:" + (tblTaskDetailReport != null ? JSONObject.fromObject(tblTaskDetailReport).toString() : "null"));
        int updateNum = tblTaskDetailReportMapper.updateByPrimaryKey(tblTaskDetailReport);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateTaskDetailReport:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteTaskDetailReport(TblTaskDetailReport tblTaskDetailReport) throws Exception {
        logger.debug("deleteTaskDetailReport:start");
        logger.debug("传入参数:tblTaskDetailReport:" + (tblTaskDetailReport != null ? JSONObject.fromObject(tblTaskDetailReport).toString() : "null"));
        int deleteNum = tblTaskDetailReportMapper.delete(tblTaskDetailReport);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteTaskDetailReport:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageTaskDetailReport(HashMap paramMap) throws Exception {
        logger.debug("queryPageTaskDetailReport:start");
        logger.debug("传入参数:paramMap:" + paramMap);
        String startIndex_s = (String)paramMap.get("startIndex");
        String pageSize_s =  (String)paramMap.get("pageSize");
        int startIndex = 1;
        int pageSize = 10;
        try{
            startIndex = Integer.parseInt(startIndex_s);
            pageSize = Integer.parseInt(pageSize_s);
        }catch(Exception e){
            logger.error("startIndex和pageSize解析异常",e);
        }
        HashMap result = PageQueryUtil.pageQuery(tblTaskDetailReportMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageTaskDetailReport:end");
        return result;
    }
}

