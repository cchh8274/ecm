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
import cn.kanmars.ecm.entity.TblUniversityInfo;
import cn.kanmars.ecm.dao.TblUniversityInfoMapper;
/**
 * 大学表
 * tbl_university_info
 */
@Service
@Transactional
public class UniversityInfoLogicImpl implements cn.kanmars.ecm.logic.UniversityInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("UniversityInfoLogicImpl");

    @Autowired
    private TblUniversityInfoMapper tblUniversityInfoMapper;

    /*
     * 查询信息
     */
    public TblUniversityInfo queryUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception {
        logger.debug("queryUniversityInfo:start");
        logger.debug("传入参数:tblUniversityInfo:" + (tblUniversityInfo != null ? JSONObject.fromObject(tblUniversityInfo).toString() : "null"));
        TblUniversityInfo result = tblUniversityInfoMapper.select(tblUniversityInfo);
        logger.debug("查询结果:tblUniversityInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryUniversityInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception {
        logger.debug("insertUniversityInfo:start");
        logger.debug("传入参数:tblUniversityInfo:" + (tblUniversityInfo != null ? JSONObject.fromObject(tblUniversityInfo).toString() : "null"));
        int insertNum = tblUniversityInfoMapper.insert(tblUniversityInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertUniversityInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception {
        logger.debug("updateUniversityInfo:start");
        logger.debug("传入参数:tblUniversityInfo:" + (tblUniversityInfo != null ? JSONObject.fromObject(tblUniversityInfo).toString() : "null"));
        int updateNum = tblUniversityInfoMapper.updateByPrimaryKey(tblUniversityInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateUniversityInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception {
        logger.debug("deleteUniversityInfo:start");
        logger.debug("传入参数:tblUniversityInfo:" + (tblUniversityInfo != null ? JSONObject.fromObject(tblUniversityInfo).toString() : "null"));
        int deleteNum = tblUniversityInfoMapper.delete(tblUniversityInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteUniversityInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUniversityInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageUniversityInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblUniversityInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageUniversityInfo:end");
        return result;
    }
}

