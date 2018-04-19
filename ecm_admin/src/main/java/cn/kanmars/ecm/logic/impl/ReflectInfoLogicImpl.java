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
import cn.kanmars.ecm.entity.TblReflectInfo;
import cn.kanmars.ecm.dao.TblReflectInfoMapper;
/**
 * 体现记录表
 * tbl_reflect_info
 */
@Service
@Transactional
public class ReflectInfoLogicImpl implements cn.kanmars.ecm.logic.ReflectInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("ReflectInfoLogicImpl");

    @Autowired
    private TblReflectInfoMapper tblReflectInfoMapper;

    /*
     * 查询信息
     */
    public TblReflectInfo queryReflectInfo(TblReflectInfo tblReflectInfo) throws Exception {
        logger.debug("queryReflectInfo:start");
        logger.debug("传入参数:tblReflectInfo:" + (tblReflectInfo != null ? JSONObject.fromObject(tblReflectInfo).toString() : "null"));
        TblReflectInfo result = tblReflectInfoMapper.select(tblReflectInfo);
        logger.debug("查询结果:tblReflectInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryReflectInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertReflectInfo(TblReflectInfo tblReflectInfo) throws Exception {
        logger.debug("insertReflectInfo:start");
        logger.debug("传入参数:tblReflectInfo:" + (tblReflectInfo != null ? JSONObject.fromObject(tblReflectInfo).toString() : "null"));
        int insertNum = tblReflectInfoMapper.insert(tblReflectInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertReflectInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateReflectInfo(TblReflectInfo tblReflectInfo) throws Exception {
        logger.debug("updateReflectInfo:start");
        logger.debug("传入参数:tblReflectInfo:" + (tblReflectInfo != null ? JSONObject.fromObject(tblReflectInfo).toString() : "null"));
        int updateNum = tblReflectInfoMapper.updateByPrimaryKey(tblReflectInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateReflectInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteReflectInfo(TblReflectInfo tblReflectInfo) throws Exception {
        logger.debug("deleteReflectInfo:start");
        logger.debug("传入参数:tblReflectInfo:" + (tblReflectInfo != null ? JSONObject.fromObject(tblReflectInfo).toString() : "null"));
        int deleteNum = tblReflectInfoMapper.delete(tblReflectInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteReflectInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageReflectInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageReflectInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblReflectInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageReflectInfo:end");
        return result;
    }
}

