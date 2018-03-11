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
import cn.kanmars.ecm.entity.TblUnionDemoSlavebInfo;
import cn.kanmars.ecm.dao.TblUnionDemoSlavebInfoMapper;
/**
 * 联表查询DEMO-从表b
 * tbl_union_demo_slaveb_info
 */
@Service
@Transactional
public class UnionDemoSlavebInfoLogicImpl implements cn.kanmars.ecm.logic.UnionDemoSlavebInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("UnionDemoSlavebInfoLogicImpl");

    @Autowired
    private TblUnionDemoSlavebInfoMapper tblUnionDemoSlavebInfoMapper;

    /*
     * 查询信息
     */
    public TblUnionDemoSlavebInfo queryUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception {
        logger.debug("queryUnionDemoSlavebInfo:start");
        logger.debug("传入参数:tblUnionDemoSlavebInfo:" + (tblUnionDemoSlavebInfo != null ? JSONObject.fromObject(tblUnionDemoSlavebInfo).toString() : "null"));
        TblUnionDemoSlavebInfo result = tblUnionDemoSlavebInfoMapper.select(tblUnionDemoSlavebInfo);
        logger.debug("查询结果:tblUnionDemoSlavebInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryUnionDemoSlavebInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception {
        logger.debug("insertUnionDemoSlavebInfo:start");
        logger.debug("传入参数:tblUnionDemoSlavebInfo:" + (tblUnionDemoSlavebInfo != null ? JSONObject.fromObject(tblUnionDemoSlavebInfo).toString() : "null"));
        int insertNum = tblUnionDemoSlavebInfoMapper.insert(tblUnionDemoSlavebInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertUnionDemoSlavebInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception {
        logger.debug("updateUnionDemoSlavebInfo:start");
        logger.debug("传入参数:tblUnionDemoSlavebInfo:" + (tblUnionDemoSlavebInfo != null ? JSONObject.fromObject(tblUnionDemoSlavebInfo).toString() : "null"));
        int updateNum = tblUnionDemoSlavebInfoMapper.updateByPrimaryKey(tblUnionDemoSlavebInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateUnionDemoSlavebInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception {
        logger.debug("deleteUnionDemoSlavebInfo:start");
        logger.debug("传入参数:tblUnionDemoSlavebInfo:" + (tblUnionDemoSlavebInfo != null ? JSONObject.fromObject(tblUnionDemoSlavebInfo).toString() : "null"));
        int deleteNum = tblUnionDemoSlavebInfoMapper.delete(tblUnionDemoSlavebInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteUnionDemoSlavebInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoSlavebInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageUnionDemoSlavebInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblUnionDemoSlavebInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageUnionDemoSlavebInfo:end");
        return result;
    }
}

