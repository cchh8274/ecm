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
import cn.kanmars.ecm.entity.TblAmountInfo;
import cn.kanmars.ecm.dao.TblAmountInfoMapper;
/**
 * 用户账户表
 * tbl_amount_info
 */
@Service
@Transactional
public class AmountInfoLogicImpl implements cn.kanmars.ecm.logic.AmountInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("AmountInfoLogicImpl");

    @Autowired
    private TblAmountInfoMapper tblAmountInfoMapper;

    /*
     * 查询信息
     */
    public TblAmountInfo queryAmountInfo(TblAmountInfo tblAmountInfo) throws Exception {
        logger.debug("queryAmountInfo:start");
        logger.debug("传入参数:tblAmountInfo:" + (tblAmountInfo != null ? JSONObject.fromObject(tblAmountInfo).toString() : "null"));
        TblAmountInfo result = tblAmountInfoMapper.select(tblAmountInfo);
        logger.debug("查询结果:tblAmountInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryAmountInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertAmountInfo(TblAmountInfo tblAmountInfo) throws Exception {
        logger.debug("insertAmountInfo:start");
        logger.debug("传入参数:tblAmountInfo:" + (tblAmountInfo != null ? JSONObject.fromObject(tblAmountInfo).toString() : "null"));
        int insertNum = tblAmountInfoMapper.insert(tblAmountInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertAmountInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateAmountInfo(TblAmountInfo tblAmountInfo) throws Exception {
        logger.debug("updateAmountInfo:start");
        logger.debug("传入参数:tblAmountInfo:" + (tblAmountInfo != null ? JSONObject.fromObject(tblAmountInfo).toString() : "null"));
        int updateNum = tblAmountInfoMapper.updateByPrimaryKey(tblAmountInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateAmountInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteAmountInfo(TblAmountInfo tblAmountInfo) throws Exception {
        logger.debug("deleteAmountInfo:start");
        logger.debug("传入参数:tblAmountInfo:" + (tblAmountInfo != null ? JSONObject.fromObject(tblAmountInfo).toString() : "null"));
        int deleteNum = tblAmountInfoMapper.delete(tblAmountInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteAmountInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageAmountInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageAmountInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblAmountInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageAmountInfo:end");
        return result;
    }
}

