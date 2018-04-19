/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblOrderInfo;
/**
 * 订单表
 * tbl_order_info
 */
public interface OrderInfoLogic {

    /*
     * 查询信息
     */
    public TblOrderInfo queryOrderInfo(TblOrderInfo tblOrderInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertOrderInfo(TblOrderInfo tblOrderInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateOrderInfo(TblOrderInfo tblOrderInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteOrderInfo(TblOrderInfo tblOrderInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageOrderInfo(HashMap paramMap) throws Exception;

}

