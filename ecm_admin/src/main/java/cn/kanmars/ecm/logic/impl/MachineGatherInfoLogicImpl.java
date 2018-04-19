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
import cn.kanmars.ecm.entity.TblMachineGatherInfo;
import cn.kanmars.ecm.dao.TblMachineGatherInfoMapper;
/**
 * 用户咖啡机表
 * tbl_machine_gather_info
 */
@Service
@Transactional
public class MachineGatherInfoLogicImpl implements cn.kanmars.ecm.logic.MachineGatherInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("MachineGatherInfoLogicImpl");

    @Autowired
    private TblMachineGatherInfoMapper tblMachineGatherInfoMapper;

    /*
     * 查询信息
     */
    public TblMachineGatherInfo queryMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception {
        logger.debug("queryMachineGatherInfo:start");
        logger.debug("传入参数:tblMachineGatherInfo:" + (tblMachineGatherInfo != null ? JSONObject.fromObject(tblMachineGatherInfo).toString() : "null"));
        TblMachineGatherInfo result = tblMachineGatherInfoMapper.select(tblMachineGatherInfo);
        logger.debug("查询结果:tblMachineGatherInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryMachineGatherInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception {
        logger.debug("insertMachineGatherInfo:start");
        logger.debug("传入参数:tblMachineGatherInfo:" + (tblMachineGatherInfo != null ? JSONObject.fromObject(tblMachineGatherInfo).toString() : "null"));
        int insertNum = tblMachineGatherInfoMapper.insert(tblMachineGatherInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertMachineGatherInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception {
        logger.debug("updateMachineGatherInfo:start");
        logger.debug("传入参数:tblMachineGatherInfo:" + (tblMachineGatherInfo != null ? JSONObject.fromObject(tblMachineGatherInfo).toString() : "null"));
        int updateNum = tblMachineGatherInfoMapper.updateByPrimaryKey(tblMachineGatherInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateMachineGatherInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception {
        logger.debug("deleteMachineGatherInfo:start");
        logger.debug("传入参数:tblMachineGatherInfo:" + (tblMachineGatherInfo != null ? JSONObject.fromObject(tblMachineGatherInfo).toString() : "null"));
        int deleteNum = tblMachineGatherInfoMapper.delete(tblMachineGatherInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteMachineGatherInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageMachineGatherInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageMachineGatherInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblMachineGatherInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageMachineGatherInfo:end");
        return result;
    }
}

