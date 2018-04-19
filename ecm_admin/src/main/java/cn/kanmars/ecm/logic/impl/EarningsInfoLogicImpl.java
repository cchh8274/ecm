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
import cn.kanmars.ecm.entity.TblEarningsInfo;
import cn.kanmars.ecm.dao.TblEarningsInfoMapper;
/**
 * 收益表
 * tbl_earnings_info
 */
@Service
@Transactional
public class EarningsInfoLogicImpl implements cn.kanmars.ecm.logic.EarningsInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("EarningsInfoLogicImpl");

    @Autowired
    private TblEarningsInfoMapper tblEarningsInfoMapper;

    /*
     * 查询信息
     */
    public TblEarningsInfo queryEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception {
        logger.debug("queryEarningsInfo:start");
        logger.debug("传入参数:tblEarningsInfo:" + (tblEarningsInfo != null ? JSONObject.fromObject(tblEarningsInfo).toString() : "null"));
        TblEarningsInfo result = tblEarningsInfoMapper.select(tblEarningsInfo);
        logger.debug("查询结果:tblEarningsInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryEarningsInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception {
        logger.debug("insertEarningsInfo:start");
        logger.debug("传入参数:tblEarningsInfo:" + (tblEarningsInfo != null ? JSONObject.fromObject(tblEarningsInfo).toString() : "null"));
        int insertNum = tblEarningsInfoMapper.insert(tblEarningsInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertEarningsInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception {
        logger.debug("updateEarningsInfo:start");
        logger.debug("传入参数:tblEarningsInfo:" + (tblEarningsInfo != null ? JSONObject.fromObject(tblEarningsInfo).toString() : "null"));
        int updateNum = tblEarningsInfoMapper.updateByPrimaryKey(tblEarningsInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateEarningsInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception {
        logger.debug("deleteEarningsInfo:start");
        logger.debug("传入参数:tblEarningsInfo:" + (tblEarningsInfo != null ? JSONObject.fromObject(tblEarningsInfo).toString() : "null"));
        int deleteNum = tblEarningsInfoMapper.delete(tblEarningsInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteEarningsInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageEarningsInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageEarningsInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblEarningsInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageEarningsInfo:end");
        return result;
    }
}

