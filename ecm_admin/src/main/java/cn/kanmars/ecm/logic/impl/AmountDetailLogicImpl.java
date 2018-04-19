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
import cn.kanmars.ecm.entity.TblAmountDetail;
import cn.kanmars.ecm.dao.TblAmountDetailMapper;
/**
 * 账户明细表
 * tbl_amount_detail
 */
@Service
@Transactional
public class AmountDetailLogicImpl implements cn.kanmars.ecm.logic.AmountDetailLogic{

    protected HLogger logger = LoggerManager.getLoger("AmountDetailLogicImpl");

    @Autowired
    private TblAmountDetailMapper tblAmountDetailMapper;

    /*
     * 查询信息
     */
    public TblAmountDetail queryAmountDetail(TblAmountDetail tblAmountDetail) throws Exception {
        logger.debug("queryAmountDetail:start");
        logger.debug("传入参数:tblAmountDetail:" + (tblAmountDetail != null ? JSONObject.fromObject(tblAmountDetail).toString() : "null"));
        TblAmountDetail result = tblAmountDetailMapper.select(tblAmountDetail);
        logger.debug("查询结果:tblAmountDetail:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryAmountDetail:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertAmountDetail(TblAmountDetail tblAmountDetail) throws Exception {
        logger.debug("insertAmountDetail:start");
        logger.debug("传入参数:tblAmountDetail:" + (tblAmountDetail != null ? JSONObject.fromObject(tblAmountDetail).toString() : "null"));
        int insertNum = tblAmountDetailMapper.insert(tblAmountDetail);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertAmountDetail:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateAmountDetail(TblAmountDetail tblAmountDetail) throws Exception {
        logger.debug("updateAmountDetail:start");
        logger.debug("传入参数:tblAmountDetail:" + (tblAmountDetail != null ? JSONObject.fromObject(tblAmountDetail).toString() : "null"));
        int updateNum = tblAmountDetailMapper.updateByPrimaryKey(tblAmountDetail);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateAmountDetail:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteAmountDetail(TblAmountDetail tblAmountDetail) throws Exception {
        logger.debug("deleteAmountDetail:start");
        logger.debug("传入参数:tblAmountDetail:" + (tblAmountDetail != null ? JSONObject.fromObject(tblAmountDetail).toString() : "null"));
        int deleteNum = tblAmountDetailMapper.delete(tblAmountDetail);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteAmountDetail:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageAmountDetail(HashMap paramMap) throws Exception {
        logger.debug("queryPageAmountDetail:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblAmountDetailMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageAmountDetail:end");
        return result;
    }
}

