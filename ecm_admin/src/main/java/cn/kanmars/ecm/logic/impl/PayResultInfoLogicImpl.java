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
import cn.kanmars.ecm.entity.TblPayResultInfo;
import cn.kanmars.ecm.dao.TblPayResultInfoMapper;
/**
 * 支付结果通知表
 * tbl_pay_result_info
 */
@Service
@Transactional
public class PayResultInfoLogicImpl implements cn.kanmars.ecm.logic.PayResultInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("PayResultInfoLogicImpl");

    @Autowired
    private TblPayResultInfoMapper tblPayResultInfoMapper;

    /*
     * 查询信息
     */
    public TblPayResultInfo queryPayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception {
        logger.debug("queryPayResultInfo:start");
        logger.debug("传入参数:tblPayResultInfo:" + (tblPayResultInfo != null ? JSONObject.fromObject(tblPayResultInfo).toString() : "null"));
        TblPayResultInfo result = tblPayResultInfoMapper.select(tblPayResultInfo);
        logger.debug("查询结果:tblPayResultInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryPayResultInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertPayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception {
        logger.debug("insertPayResultInfo:start");
        logger.debug("传入参数:tblPayResultInfo:" + (tblPayResultInfo != null ? JSONObject.fromObject(tblPayResultInfo).toString() : "null"));
        int insertNum = tblPayResultInfoMapper.insert(tblPayResultInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertPayResultInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updatePayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception {
        logger.debug("updatePayResultInfo:start");
        logger.debug("传入参数:tblPayResultInfo:" + (tblPayResultInfo != null ? JSONObject.fromObject(tblPayResultInfo).toString() : "null"));
        int updateNum = tblPayResultInfoMapper.updateByPrimaryKey(tblPayResultInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updatePayResultInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deletePayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception {
        logger.debug("deletePayResultInfo:start");
        logger.debug("传入参数:tblPayResultInfo:" + (tblPayResultInfo != null ? JSONObject.fromObject(tblPayResultInfo).toString() : "null"));
        int deleteNum = tblPayResultInfoMapper.delete(tblPayResultInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deletePayResultInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPagePayResultInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPagePayResultInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblPayResultInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPagePayResultInfo:end");
        return result;
    }
}

