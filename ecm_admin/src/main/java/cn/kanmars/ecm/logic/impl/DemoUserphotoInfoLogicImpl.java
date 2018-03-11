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
import cn.kanmars.ecm.entity.TblDemoUserphotoInfo;
import cn.kanmars.ecm.dao.TblDemoUserphotoInfoMapper;
/**
 * 用户照片表
 * tbl_demo_userphoto_info
 */
@Service
@Transactional
public class DemoUserphotoInfoLogicImpl implements cn.kanmars.ecm.logic.DemoUserphotoInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("DemoUserphotoInfoLogicImpl");

    @Autowired
    private TblDemoUserphotoInfoMapper tblDemoUserphotoInfoMapper;

    /*
     * 查询信息
     */
    public TblDemoUserphotoInfo queryDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception {
        logger.debug("queryDemoUserphotoInfo:start");
        logger.debug("传入参数:tblDemoUserphotoInfo:" + (tblDemoUserphotoInfo != null ? JSONObject.fromObject(tblDemoUserphotoInfo).toString() : "null"));
        TblDemoUserphotoInfo result = tblDemoUserphotoInfoMapper.select(tblDemoUserphotoInfo);
        logger.debug("查询结果:tblDemoUserphotoInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryDemoUserphotoInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception {
        logger.debug("insertDemoUserphotoInfo:start");
        logger.debug("传入参数:tblDemoUserphotoInfo:" + (tblDemoUserphotoInfo != null ? JSONObject.fromObject(tblDemoUserphotoInfo).toString() : "null"));
        int insertNum = tblDemoUserphotoInfoMapper.insert(tblDemoUserphotoInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertDemoUserphotoInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception {
        logger.debug("updateDemoUserphotoInfo:start");
        logger.debug("传入参数:tblDemoUserphotoInfo:" + (tblDemoUserphotoInfo != null ? JSONObject.fromObject(tblDemoUserphotoInfo).toString() : "null"));
        int updateNum = tblDemoUserphotoInfoMapper.updateByPrimaryKey(tblDemoUserphotoInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateDemoUserphotoInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception {
        logger.debug("deleteDemoUserphotoInfo:start");
        logger.debug("传入参数:tblDemoUserphotoInfo:" + (tblDemoUserphotoInfo != null ? JSONObject.fromObject(tblDemoUserphotoInfo).toString() : "null"));
        int deleteNum = tblDemoUserphotoInfoMapper.delete(tblDemoUserphotoInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteDemoUserphotoInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageDemoUserphotoInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageDemoUserphotoInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblDemoUserphotoInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageDemoUserphotoInfo:end");
        return result;
    }
}

