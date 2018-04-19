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
import cn.kanmars.ecm.entity.TblBankamountInfo;
import cn.kanmars.ecm.dao.TblBankamountInfoMapper;
/**
 * 银行账户表
 * tbl_bankamount_info
 */
@Service
@Transactional
public class BankamountInfoLogicImpl implements cn.kanmars.ecm.logic.BankamountInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("BankamountInfoLogicImpl");

    @Autowired
    private TblBankamountInfoMapper tblBankamountInfoMapper;

    /*
     * 查询信息
     */
    public TblBankamountInfo queryBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception {
        logger.debug("queryBankamountInfo:start");
        logger.debug("传入参数:tblBankamountInfo:" + (tblBankamountInfo != null ? JSONObject.fromObject(tblBankamountInfo).toString() : "null"));
        TblBankamountInfo result = tblBankamountInfoMapper.select(tblBankamountInfo);
        logger.debug("查询结果:tblBankamountInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryBankamountInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception {
        logger.debug("insertBankamountInfo:start");
        logger.debug("传入参数:tblBankamountInfo:" + (tblBankamountInfo != null ? JSONObject.fromObject(tblBankamountInfo).toString() : "null"));
        int insertNum = tblBankamountInfoMapper.insert(tblBankamountInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertBankamountInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception {
        logger.debug("updateBankamountInfo:start");
        logger.debug("传入参数:tblBankamountInfo:" + (tblBankamountInfo != null ? JSONObject.fromObject(tblBankamountInfo).toString() : "null"));
        int updateNum = tblBankamountInfoMapper.updateByPrimaryKey(tblBankamountInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateBankamountInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteBankamountInfo(TblBankamountInfo tblBankamountInfo) throws Exception {
        logger.debug("deleteBankamountInfo:start");
        logger.debug("传入参数:tblBankamountInfo:" + (tblBankamountInfo != null ? JSONObject.fromObject(tblBankamountInfo).toString() : "null"));
        int deleteNum = tblBankamountInfoMapper.delete(tblBankamountInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteBankamountInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageBankamountInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageBankamountInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblBankamountInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageBankamountInfo:end");
        return result;
    }
}

