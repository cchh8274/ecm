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
import cn.kanmars.ecm.entity.TblAreaInfo;
import cn.kanmars.ecm.dao.TblAreaInfoMapper;
/**
 * 区域表
 * tbl_area_info
 */
@Service
@Transactional
public class AreaInfoLogicImpl implements cn.kanmars.ecm.logic.AreaInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("AreaInfoLogicImpl");

    @Autowired
    private TblAreaInfoMapper tblAreaInfoMapper;

    /*
     * 查询信息
     */
    public TblAreaInfo queryAreaInfo(TblAreaInfo tblAreaInfo) throws Exception {
        logger.debug("queryAreaInfo:start");
        logger.debug("传入参数:tblAreaInfo:" + (tblAreaInfo != null ? JSONObject.fromObject(tblAreaInfo).toString() : "null"));
        TblAreaInfo result = tblAreaInfoMapper.select(tblAreaInfo);
        logger.debug("查询结果:tblAreaInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryAreaInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertAreaInfo(TblAreaInfo tblAreaInfo) throws Exception {
        logger.debug("insertAreaInfo:start");
        logger.debug("传入参数:tblAreaInfo:" + (tblAreaInfo != null ? JSONObject.fromObject(tblAreaInfo).toString() : "null"));
        int insertNum = tblAreaInfoMapper.insert(tblAreaInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertAreaInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateAreaInfo(TblAreaInfo tblAreaInfo) throws Exception {
        logger.debug("updateAreaInfo:start");
        logger.debug("传入参数:tblAreaInfo:" + (tblAreaInfo != null ? JSONObject.fromObject(tblAreaInfo).toString() : "null"));
        int updateNum = tblAreaInfoMapper.updateByPrimaryKey(tblAreaInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateAreaInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteAreaInfo(TblAreaInfo tblAreaInfo) throws Exception {
        logger.debug("deleteAreaInfo:start");
        logger.debug("传入参数:tblAreaInfo:" + (tblAreaInfo != null ? JSONObject.fromObject(tblAreaInfo).toString() : "null"));
        int deleteNum = tblAreaInfoMapper.delete(tblAreaInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteAreaInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageAreaInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageAreaInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblAreaInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageAreaInfo:end");
        return result;
    }
}

