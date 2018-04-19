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
import cn.kanmars.ecm.entity.TblOrderInfo;
import cn.kanmars.ecm.dao.TblOrderInfoMapper;
/**
 * 订单表
 * tbl_order_info
 */
@Service
@Transactional
public class OrderInfoLogicImpl implements cn.kanmars.ecm.logic.OrderInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("OrderInfoLogicImpl");

    @Autowired
    private TblOrderInfoMapper tblOrderInfoMapper;

    /*
     * 查询信息
     */
    public TblOrderInfo queryOrderInfo(TblOrderInfo tblOrderInfo) throws Exception {
        logger.debug("queryOrderInfo:start");
        logger.debug("传入参数:tblOrderInfo:" + (tblOrderInfo != null ? JSONObject.fromObject(tblOrderInfo).toString() : "null"));
        TblOrderInfo result = tblOrderInfoMapper.select(tblOrderInfo);
        logger.debug("查询结果:tblOrderInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryOrderInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertOrderInfo(TblOrderInfo tblOrderInfo) throws Exception {
        logger.debug("insertOrderInfo:start");
        logger.debug("传入参数:tblOrderInfo:" + (tblOrderInfo != null ? JSONObject.fromObject(tblOrderInfo).toString() : "null"));
        int insertNum = tblOrderInfoMapper.insert(tblOrderInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertOrderInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateOrderInfo(TblOrderInfo tblOrderInfo) throws Exception {
        logger.debug("updateOrderInfo:start");
        logger.debug("传入参数:tblOrderInfo:" + (tblOrderInfo != null ? JSONObject.fromObject(tblOrderInfo).toString() : "null"));
        int updateNum = tblOrderInfoMapper.updateByPrimaryKey(tblOrderInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateOrderInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteOrderInfo(TblOrderInfo tblOrderInfo) throws Exception {
        logger.debug("deleteOrderInfo:start");
        logger.debug("传入参数:tblOrderInfo:" + (tblOrderInfo != null ? JSONObject.fromObject(tblOrderInfo).toString() : "null"));
        int deleteNum = tblOrderInfoMapper.delete(tblOrderInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteOrderInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageOrderInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageOrderInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblOrderInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageOrderInfo:end");
        return result;
    }
}

