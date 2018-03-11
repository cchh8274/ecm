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
import cn.kanmars.ecm.entity.TblUnionDemoSlaveaInfo;
import cn.kanmars.ecm.dao.TblUnionDemoSlaveaInfoMapper;
/**
 * 联表查询DEMO-从表a
 * tbl_union_demo_slavea_info
 */
@Service
@Transactional
public class UnionDemoSlaveaInfoLogicImpl implements cn.kanmars.ecm.logic.UnionDemoSlaveaInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("UnionDemoSlaveaInfoLogicImpl");

    @Autowired
    private TblUnionDemoSlaveaInfoMapper tblUnionDemoSlaveaInfoMapper;

    /*
     * 查询信息
     */
    public TblUnionDemoSlaveaInfo queryUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception {
        logger.debug("queryUnionDemoSlaveaInfo:start");
        logger.debug("传入参数:tblUnionDemoSlaveaInfo:" + (tblUnionDemoSlaveaInfo != null ? JSONObject.fromObject(tblUnionDemoSlaveaInfo).toString() : "null"));
        TblUnionDemoSlaveaInfo result = tblUnionDemoSlaveaInfoMapper.select(tblUnionDemoSlaveaInfo);
        logger.debug("查询结果:tblUnionDemoSlaveaInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryUnionDemoSlaveaInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception {
        logger.debug("insertUnionDemoSlaveaInfo:start");
        logger.debug("传入参数:tblUnionDemoSlaveaInfo:" + (tblUnionDemoSlaveaInfo != null ? JSONObject.fromObject(tblUnionDemoSlaveaInfo).toString() : "null"));
        int insertNum = tblUnionDemoSlaveaInfoMapper.insert(tblUnionDemoSlaveaInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertUnionDemoSlaveaInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception {
        logger.debug("updateUnionDemoSlaveaInfo:start");
        logger.debug("传入参数:tblUnionDemoSlaveaInfo:" + (tblUnionDemoSlaveaInfo != null ? JSONObject.fromObject(tblUnionDemoSlaveaInfo).toString() : "null"));
        int updateNum = tblUnionDemoSlaveaInfoMapper.updateByPrimaryKey(tblUnionDemoSlaveaInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateUnionDemoSlaveaInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception {
        logger.debug("deleteUnionDemoSlaveaInfo:start");
        logger.debug("传入参数:tblUnionDemoSlaveaInfo:" + (tblUnionDemoSlaveaInfo != null ? JSONObject.fromObject(tblUnionDemoSlaveaInfo).toString() : "null"));
        int deleteNum = tblUnionDemoSlaveaInfoMapper.delete(tblUnionDemoSlaveaInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteUnionDemoSlaveaInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoSlaveaInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageUnionDemoSlaveaInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblUnionDemoSlaveaInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageUnionDemoSlaveaInfo:end");
        return result;
    }
}

