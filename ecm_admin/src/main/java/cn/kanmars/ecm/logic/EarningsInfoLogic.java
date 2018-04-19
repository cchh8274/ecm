/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblEarningsInfo;
/**
 * 收益表
 * tbl_earnings_info
 */
public interface EarningsInfoLogic {

    /*
     * 查询信息
     */
    public TblEarningsInfo queryEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteEarningsInfo(TblEarningsInfo tblEarningsInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageEarningsInfo(HashMap paramMap) throws Exception;

}

