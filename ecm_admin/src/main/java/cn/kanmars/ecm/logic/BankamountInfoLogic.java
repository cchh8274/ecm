/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblBankamountInfo;
/**
 * 银行账户表
 * tbl_bankamount_info
 */
public interface BankamountInfoLogic {

    /*
     * 查询信息
     */
    public TblBankamountInfo queryBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageBankamountInfo(HashMap paramMap) throws Exception;

}

