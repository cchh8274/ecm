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
import cn.kanmars.ecm.entity.TblTaskDetailLog;
import cn.kanmars.ecm.dao.TblTaskDetailLogMapper;
/**
 * 任务执行日志表
 * tbl_task_detail_log
 */
@Service
@Transactional
public class TaskDetailLogLogicImpl implements cn.kanmars.ecm.logic.TaskDetailLogLogic{

    protected HLogger logger = LoggerManager.getLoger("TaskDetailLogLogicImpl");

    @Autowired
    private TblTaskDetailLogMapper tblTaskDetailLogMapper;

    /*
     * 查询信息
     */
    public TblTaskDetailLog queryTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception {
        logger.debug("queryTaskDetailLog:start");
        logger.debug("传入参数:tblTaskDetailLog:" + (tblTaskDetailLog != null ? JSONObject.fromObject(tblTaskDetailLog).toString() : "null"));
        TblTaskDetailLog result = tblTaskDetailLogMapper.select(tblTaskDetailLog);
        logger.debug("查询结果:tblTaskDetailLog:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryTaskDetailLog:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception {
        logger.debug("insertTaskDetailLog:start");
        logger.debug("传入参数:tblTaskDetailLog:" + (tblTaskDetailLog != null ? JSONObject.fromObject(tblTaskDetailLog).toString() : "null"));
        int insertNum = tblTaskDetailLogMapper.insert(tblTaskDetailLog);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertTaskDetailLog:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception {
        logger.debug("updateTaskDetailLog:start");
        logger.debug("传入参数:tblTaskDetailLog:" + (tblTaskDetailLog != null ? JSONObject.fromObject(tblTaskDetailLog).toString() : "null"));
        int updateNum = tblTaskDetailLogMapper.updateByPrimaryKey(tblTaskDetailLog);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateTaskDetailLog:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteTaskDetailLog(TblTaskDetailLog tblTaskDetailLog) throws Exception {
        logger.debug("deleteTaskDetailLog:start");
        logger.debug("传入参数:tblTaskDetailLog:" + (tblTaskDetailLog != null ? JSONObject.fromObject(tblTaskDetailLog).toString() : "null"));
        int deleteNum = tblTaskDetailLogMapper.delete(tblTaskDetailLog);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteTaskDetailLog:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageTaskDetailLog(HashMap paramMap) throws Exception {
        logger.debug("queryPageTaskDetailLog:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblTaskDetailLogMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageTaskDetailLog:end");
        return result;
    }
}

