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
import cn.kanmars.ecm.entity.TblMachineInfo;
import cn.kanmars.ecm.dao.TblMachineInfoMapper;
/**
 * 机器信息表
 * tbl_machine_info
 */
@Service
@Transactional
public class MachineInfoLogicImpl implements cn.kanmars.ecm.logic.MachineInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("MachineInfoLogicImpl");

    @Autowired
    private TblMachineInfoMapper tblMachineInfoMapper;

    /*
     * 查询信息
     */
    public TblMachineInfo queryMachineInfo(TblMachineInfo tblMachineInfo) throws Exception {
        logger.debug("queryMachineInfo:start");
        logger.debug("传入参数:tblMachineInfo:" + (tblMachineInfo != null ? JSONObject.fromObject(tblMachineInfo).toString() : "null"));
        TblMachineInfo result = tblMachineInfoMapper.select(tblMachineInfo);
        logger.debug("查询结果:tblMachineInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryMachineInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertMachineInfo(TblMachineInfo tblMachineInfo) throws Exception {
        logger.debug("insertMachineInfo:start");
        logger.debug("传入参数:tblMachineInfo:" + (tblMachineInfo != null ? JSONObject.fromObject(tblMachineInfo).toString() : "null"));
        int insertNum = tblMachineInfoMapper.insert(tblMachineInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertMachineInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateMachineInfo(TblMachineInfo tblMachineInfo) throws Exception {
        logger.debug("updateMachineInfo:start");
        logger.debug("传入参数:tblMachineInfo:" + (tblMachineInfo != null ? JSONObject.fromObject(tblMachineInfo).toString() : "null"));
        int updateNum = tblMachineInfoMapper.updateByPrimaryKey(tblMachineInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateMachineInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteMachineInfo(TblMachineInfo tblMachineInfo) throws Exception {
        logger.debug("deleteMachineInfo:start");
        logger.debug("传入参数:tblMachineInfo:" + (tblMachineInfo != null ? JSONObject.fromObject(tblMachineInfo).toString() : "null"));
        int deleteNum = tblMachineInfoMapper.delete(tblMachineInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteMachineInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageMachineInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageMachineInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblMachineInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageMachineInfo:end");
        return result;
    }
}

