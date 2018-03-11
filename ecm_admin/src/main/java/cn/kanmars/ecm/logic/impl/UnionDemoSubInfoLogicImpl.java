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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.kanmars.ecm.entity.TblSysmenuInfo;
import cn.kanmars.ecm.entity.TblUnionDemoSubInfo;
import cn.kanmars.ecm.dao.TblUnionDemoSubInfoMapper;
/**
 * 联表查询DEMO-子表
 * tbl_union_demo_sub_info
 */
@Service
@Transactional
public class UnionDemoSubInfoLogicImpl implements cn.kanmars.ecm.logic.UnionDemoSubInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("UnionDemoSubInfoLogicImpl");

    @Autowired
    private TblUnionDemoSubInfoMapper tblUnionDemoSubInfoMapper;

    /*
     * 查询信息
     */
    public TblUnionDemoSubInfo queryUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception {
        logger.debug("queryUnionDemoSubInfo:start");
        logger.debug("传入参数:tblUnionDemoSubInfo:" + (tblUnionDemoSubInfo != null ? JSONObject.fromObject(tblUnionDemoSubInfo).toString() : "null"));
        TblUnionDemoSubInfo result = tblUnionDemoSubInfoMapper.select(tblUnionDemoSubInfo);
        logger.debug("查询结果:tblUnionDemoSubInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryUnionDemoSubInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception {
        logger.debug("insertUnionDemoSubInfo:start");
        logger.debug("传入参数:tblUnionDemoSubInfo:" + (tblUnionDemoSubInfo != null ? JSONObject.fromObject(tblUnionDemoSubInfo).toString() : "null"));
        int insertNum = tblUnionDemoSubInfoMapper.insert(tblUnionDemoSubInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertUnionDemoSubInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception {
        logger.debug("updateUnionDemoSubInfo:start");
        logger.debug("传入参数:tblUnionDemoSubInfo:" + (tblUnionDemoSubInfo != null ? JSONObject.fromObject(tblUnionDemoSubInfo).toString() : "null"));
        int updateNum = tblUnionDemoSubInfoMapper.updateByPrimaryKey(tblUnionDemoSubInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateUnionDemoSubInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception {
        logger.debug("deleteUnionDemoSubInfo:start");
        logger.debug("传入参数:tblUnionDemoSubInfo:" + (tblUnionDemoSubInfo != null ? JSONObject.fromObject(tblUnionDemoSubInfo).toString() : "null"));
        int deleteNum = tblUnionDemoSubInfoMapper.delete(tblUnionDemoSubInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteUnionDemoSubInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoSubInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageUnionDemoSubInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblUnionDemoSubInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageUnionDemoSubInfo:end");
        return result;
    }
    
    public List<TblUnionDemoSubInfo> queryListDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception {
		logger.debug("queryListDemoSubInfo:start");
        logger.debug("传入参数:tblUnionDemoSubInfo:" + tblUnionDemoSubInfo);
		List<TblUnionDemoSubInfo> list = new ArrayList<TblUnionDemoSubInfo>();
		list = tblUnionDemoSubInfoMapper.selectList(tblUnionDemoSubInfo);
		logger.debug("查询结果:list:" + list);
	    logger.debug("queryListDemoSubInfo:end");
		return list;
	}
}

