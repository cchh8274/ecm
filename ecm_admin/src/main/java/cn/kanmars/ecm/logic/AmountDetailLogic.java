/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblAmountDetail;
/**
 * 账户明细表
 * tbl_amount_detail
 */
public interface AmountDetailLogic {

    /*
     * 查询信息
     */
    public TblAmountDetail queryAmountDetail(TblAmountDetail tblAmountDetail) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertAmountDetail(TblAmountDetail tblAmountDetail) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateAmountDetail(TblAmountDetail tblAmountDetail) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteAmountDetail(TblAmountDetail tblAmountDetail) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageAmountDetail(HashMap paramMap) throws Exception;

}

