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
import cn.kanmars.ecm.entity.TblWxUserInfo;
import cn.kanmars.ecm.dao.TblWxUserInfoMapper;
/**
 * 微信用户表
 * tbl_wx_user_info
 */
@Service
@Transactional
public class WxUserInfoLogicImpl implements cn.kanmars.ecm.logic.WxUserInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("WxUserInfoLogicImpl");

    @Autowired
    private TblWxUserInfoMapper tblWxUserInfoMapper;

    /*
     * 查询信息
     */
    public TblWxUserInfo queryWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception {
        logger.debug("queryWxUserInfo:start");
        logger.debug("传入参数:tblWxUserInfo:" + (tblWxUserInfo != null ? JSONObject.fromObject(tblWxUserInfo).toString() : "null"));
        TblWxUserInfo result = tblWxUserInfoMapper.select(tblWxUserInfo);
        logger.debug("查询结果:tblWxUserInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryWxUserInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception {
        logger.debug("insertWxUserInfo:start");
        logger.debug("传入参数:tblWxUserInfo:" + (tblWxUserInfo != null ? JSONObject.fromObject(tblWxUserInfo).toString() : "null"));
        int insertNum = tblWxUserInfoMapper.insert(tblWxUserInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertWxUserInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception {
        logger.debug("updateWxUserInfo:start");
        logger.debug("传入参数:tblWxUserInfo:" + (tblWxUserInfo != null ? JSONObject.fromObject(tblWxUserInfo).toString() : "null"));
        int updateNum = tblWxUserInfoMapper.updateByPrimaryKey(tblWxUserInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateWxUserInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception {
        logger.debug("deleteWxUserInfo:start");
        logger.debug("传入参数:tblWxUserInfo:" + (tblWxUserInfo != null ? JSONObject.fromObject(tblWxUserInfo).toString() : "null"));
        int deleteNum = tblWxUserInfoMapper.delete(tblWxUserInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteWxUserInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageWxUserInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageWxUserInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblWxUserInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageWxUserInfo:end");
        return result;
    }
}

