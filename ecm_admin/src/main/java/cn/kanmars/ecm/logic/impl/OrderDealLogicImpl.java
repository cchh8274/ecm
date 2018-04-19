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
import cn.kanmars.ecm.entity.TblOrderDeal;
import cn.kanmars.ecm.dao.TblOrderDealMapper;
/**
 * 订单支付临时表
 * tbl_order_deal
 */
@Service
@Transactional
public class OrderDealLogicImpl implements cn.kanmars.ecm.logic.OrderDealLogic{

    protected HLogger logger = LoggerManager.getLoger("OrderDealLogicImpl");

    @Autowired
    private TblOrderDealMapper tblOrderDealMapper;

    /*
     * 查询信息
     */
    public TblOrderDeal queryOrderDeal(TblOrderDeal tblOrderDeal) throws Exception {
        logger.debug("queryOrderDeal:start");
        logger.debug("传入参数:tblOrderDeal:" + (tblOrderDeal != null ? JSONObject.fromObject(tblOrderDeal).toString() : "null"));
        TblOrderDeal result = tblOrderDealMapper.select(tblOrderDeal);
        logger.debug("查询结果:tblOrderDeal:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryOrderDeal:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertOrderDeal(TblOrderDeal tblOrderDeal) throws Exception {
        logger.debug("insertOrderDeal:start");
        logger.debug("传入参数:tblOrderDeal:" + (tblOrderDeal != null ? JSONObject.fromObject(tblOrderDeal).toString() : "null"));
        int insertNum = tblOrderDealMapper.insert(tblOrderDeal);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertOrderDeal:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateOrderDeal(TblOrderDeal tblOrderDeal) throws Exception {
        logger.debug("updateOrderDeal:start");
        logger.debug("传入参数:tblOrderDeal:" + (tblOrderDeal != null ? JSONObject.fromObject(tblOrderDeal).toString() : "null"));
        int updateNum = tblOrderDealMapper.updateByPrimaryKey(tblOrderDeal);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateOrderDeal:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteOrderDeal(TblOrderDeal tblOrderDeal) throws Exception {
        logger.debug("deleteOrderDeal:start");
        logger.debug("传入参数:tblOrderDeal:" + (tblOrderDeal != null ? JSONObject.fromObject(tblOrderDeal).toString() : "null"));
        int deleteNum = tblOrderDealMapper.delete(tblOrderDeal);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteOrderDeal:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageOrderDeal(HashMap paramMap) throws Exception {
        logger.debug("queryPageOrderDeal:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblOrderDealMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageOrderDeal:end");
        return result;
    }
}

