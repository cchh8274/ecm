/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblAmountInfo;
/**
 * 用户账户表
 * tbl_amount_info
 */
public interface AmountInfoLogic {

    /*
     * 查询信息
     */
    public TblAmountInfo queryAmountInfo(TblAmountInfo tblAmountInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertAmountInfo(TblAmountInfo tblAmountInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateAmountInfo(TblAmountInfo tblAmountInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteAmountInfo(TblAmountInfo tblAmountInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageAmountInfo(HashMap paramMap) throws Exception;

}

