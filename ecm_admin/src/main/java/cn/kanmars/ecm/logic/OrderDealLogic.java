/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblOrderDeal;
/**
 * 订单支付临时表
 * tbl_order_deal
 */
public interface OrderDealLogic {

    /*
     * 查询信息
     */
    public TblOrderDeal queryOrderDeal(TblOrderDeal tblOrderDeal) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertOrderDeal(TblOrderDeal tblOrderDeal) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateOrderDeal(TblOrderDeal tblOrderDeal) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteOrderDeal(TblOrderDeal tblOrderDeal) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageOrderDeal(HashMap paramMap) throws Exception;

}

