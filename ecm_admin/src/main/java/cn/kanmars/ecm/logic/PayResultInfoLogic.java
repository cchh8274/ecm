/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblPayResultInfo;
/**
 * 支付结果通知表
 * tbl_pay_result_info
 */
public interface PayResultInfoLogic {

    /*
     * 查询信息
     */
    public TblPayResultInfo queryPayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertPayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updatePayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deletePayResultInfo(TblPayResultInfo tblPayResultInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPagePayResultInfo(HashMap paramMap) throws Exception;

}

