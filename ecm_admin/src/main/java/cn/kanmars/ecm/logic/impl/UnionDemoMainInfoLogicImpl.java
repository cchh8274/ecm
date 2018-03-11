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
import cn.kanmars.ecm.entity.TblUnionDemoMainInfo;
import cn.kanmars.ecm.dao.TblUnionDemoMainInfoMapper;
/**
 * 联表查询DEMO-主表
 * tbl_union_demo_main_info
 */
@Service
@Transactional
public class UnionDemoMainInfoLogicImpl implements cn.kanmars.ecm.logic.UnionDemoMainInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("UnionDemoMainInfoLogicImpl");

    @Autowired
    private TblUnionDemoMainInfoMapper tblUnionDemoMainInfoMapper;

    /*
     * 查询信息
     */
    public TblUnionDemoMainInfo queryUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception {
        logger.debug("queryUnionDemoMainInfo:start");
        logger.debug("传入参数:tblUnionDemoMainInfo:" + (tblUnionDemoMainInfo != null ? JSONObject.fromObject(tblUnionDemoMainInfo).toString() : "null"));
        TblUnionDemoMainInfo result = tblUnionDemoMainInfoMapper.select(tblUnionDemoMainInfo);
        logger.debug("查询结果:tblUnionDemoMainInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryUnionDemoMainInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception {
        logger.debug("insertUnionDemoMainInfo:start");
        logger.debug("传入参数:tblUnionDemoMainInfo:" + (tblUnionDemoMainInfo != null ? JSONObject.fromObject(tblUnionDemoMainInfo).toString() : "null"));
        int insertNum = tblUnionDemoMainInfoMapper.insert(tblUnionDemoMainInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertUnionDemoMainInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception {
        logger.debug("updateUnionDemoMainInfo:start");
        logger.debug("传入参数:tblUnionDemoMainInfo:" + (tblUnionDemoMainInfo != null ? JSONObject.fromObject(tblUnionDemoMainInfo).toString() : "null"));
        int updateNum = tblUnionDemoMainInfoMapper.updateByPrimaryKey(tblUnionDemoMainInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateUnionDemoMainInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception {
        logger.debug("deleteUnionDemoMainInfo:start");
        logger.debug("传入参数:tblUnionDemoMainInfo:" + (tblUnionDemoMainInfo != null ? JSONObject.fromObject(tblUnionDemoMainInfo).toString() : "null"));
        int deleteNum = tblUnionDemoMainInfoMapper.delete(tblUnionDemoMainInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteUnionDemoMainInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoMainInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageUnionDemoMainInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblUnionDemoMainInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageUnionDemoMainInfo:end");
        return result;
    }
}

