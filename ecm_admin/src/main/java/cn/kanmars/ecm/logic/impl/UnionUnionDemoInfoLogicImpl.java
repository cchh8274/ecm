/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.MapObjTransUtils;
import cn.com.xbase.frame.util.DateUtils;
import cn.kanmars.ecm.util.PageQueryUtil;
import cn.kanmars.ecm.util.SysSequenceUtils;
import cn.kanmars.ecm.dao.UnionUnionDemoInfoMapper;
import cn.kanmars.ecm.entity.TblUnionDemoMainInfo;
import cn.kanmars.ecm.dao.TblUnionDemoMainInfoMapper;
import cn.kanmars.ecm.entity.TblUnionDemoSlaveaInfo;
import cn.kanmars.ecm.dao.TblUnionDemoSlaveaInfoMapper;
import cn.kanmars.ecm.entity.TblUnionDemoSlavebInfo;
import cn.kanmars.ecm.dao.TblUnionDemoSlavebInfoMapper;
import cn.kanmars.ecm.entity.TblUnionDemoSubInfo;
import cn.kanmars.ecm.dao.TblUnionDemoSubInfoMapper;
/**
 * 联表查询DEMO
 * union_Demo_Info
 */
@Service
@Transactional
public class UnionUnionDemoInfoLogicImpl implements cn.kanmars.ecm.logic.UnionUnionDemoInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("UnionUnionDemoInfoLogicImpl");

    @Autowired
    private UnionUnionDemoInfoMapper unionUnionDemoInfoMapper;
    @Autowired
    private TblUnionDemoMainInfoMapper tblUnionDemoMainInfoMapper;
    @Autowired
    private TblUnionDemoSlaveaInfoMapper tblUnionDemoSlaveaInfoMapper;
    @Autowired
    private TblUnionDemoSlavebInfoMapper tblUnionDemoSlavebInfoMapper;
    @Autowired
    private TblUnionDemoSubInfoMapper tblUnionDemoSubInfoMapper;
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void insertUnionUnionDemoInfo(HashMap paramMap) throws Exception {
        logger.debug("insertUnionUnionDemoInfo:start");
        logger.debug("传入参数:paramMap["+paramMap+"]");
        int count =0;
        TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoMainInfo, paramMap);
        String pk0 = SysSequenceUtils.generateStringId("tbl_demo_info");
        tblUnionDemoMainInfo.setDemoId(Long.parseLong(pk0));
        tblUnionDemoMainInfo.setCreateTime(DateUtils.getCurrDateTime());
        tblUnionDemoMainInfo.setCreateDate(DateUtils.getCurrDate());
        count = tblUnionDemoMainInfoMapper.insert(tblUnionDemoMainInfo);
        logger.debug("操作[tbl_union_demo_main_info]结果:count["+count+"]");
        if(count<=0){
            throw new Exception("插入主表[tbl_union_demo_main_info]异常!");
        }
        TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo = new TblUnionDemoSlaveaInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoSlaveaInfo, paramMap);
        String pk1 = SysSequenceUtils.generateStringId("tbl_union_demo_slavea_info");
        tblUnionDemoSlaveaInfo.setDemoIda(Long.parseLong(pk1));
        tblUnionDemoSlaveaInfo.setCreateTimea(DateUtils.getCurrDateTime());
        tblUnionDemoSlaveaInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
        count = tblUnionDemoSlaveaInfoMapper.insert(tblUnionDemoSlaveaInfo);
        logger.debug("操作[tbl_union_demo_slavea_info]结果:count["+count+"]");
        if(count<=0){
            throw new Exception("插入从表[tbl_union_demo_slavea_info]异常!");
        }
        TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo = new TblUnionDemoSlavebInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoSlavebInfo, paramMap);
        String pk2 = SysSequenceUtils.generateStringId("tbl_union_demo_slaveb_info");
        tblUnionDemoSlavebInfo.setDemoIdb(Long.parseLong(pk2));
        tblUnionDemoSlavebInfo.setCreateTimeb(DateUtils.getCurrDateTime());
        tblUnionDemoSlavebInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
        count = tblUnionDemoSlavebInfoMapper.insert(tblUnionDemoSlavebInfo);
        logger.debug("操作[tbl_union_demo_slaveb_info]结果:count["+count+"]");
        if(count<=0){
            throw new Exception("插入从表[tbl_union_demo_slaveb_info]异常!");
        }
        List list = (List) paramMap.get(PageQueryUtil.SUBARRAY);
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> recordsMap = (HashMap<String, Object>) list.get(i);
            TblUnionDemoSubInfo tblUnionDemoSubInfo = new TblUnionDemoSubInfo();
            MapObjTransUtils.mapToObj(tblUnionDemoSubInfo, recordsMap);
            String pk3 = SysSequenceUtils.generateStringId("tbl_demo_info");
            tblUnionDemoSubInfo.setDemoIdc(Long.parseLong(pk3));
            tblUnionDemoSubInfo.setCreateTimec(DateUtils.getCurrDateTime());
            tblUnionDemoSubInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
            count = tblUnionDemoSubInfoMapper.insert(tblUnionDemoSubInfo);
            logger.debug("操作[tbl_union_demo_sub_info]结果:count["+count+"]");
            if(count<=0){
                throw new Exception("插入子表[tbl_union_demo_sub_info]异常!");
            }
        }
        logger.debug("insertUnionUnionDemoInfo:end");
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateUnionUnionDemoInfo(HashMap paramMap) throws Exception {
        logger.debug("updateUnionUnionDemoInfo:start");
        logger.debug("传入参数:paramMap["+paramMap+"]");
        int count =0;
        TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoMainInfo, paramMap);
        String id_key = (String)paramMap.get("id_key");
        tblUnionDemoMainInfo.setDemoId(Long.parseLong(id_key));
        tblUnionDemoMainInfo.setCreateTime(DateUtils.getCurrDateTime());
        count = tblUnionDemoMainInfoMapper.updateByPrimaryKey(tblUnionDemoMainInfo);
        logger.debug("操作[tbl_union_demo_main_info]结果:count["+count+"]");
        if(count<=0){
            throw new Exception("修改主表[tbl_union_demo_main_info]异常!");
        }
        TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo = new TblUnionDemoSlaveaInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoSlaveaInfo, paramMap);
        tblUnionDemoSlaveaInfo.setCreateTimea(DateUtils.getCurrDateTime());
        count = tblUnionDemoSlaveaInfoMapper.updateByPrimaryKey(tblUnionDemoSlaveaInfo);
        logger.debug("操作[tbl_union_demo_slavea_info]结果:count["+count+"]");
        if(count<=0){
            throw new Exception("修改从表[tbl_union_demo_slavea_info]异常!");
        }
        TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo = new TblUnionDemoSlavebInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoSlavebInfo, paramMap);
        tblUnionDemoSlavebInfo.setCreateTimeb(DateUtils.getCurrDateTime());
        count = tblUnionDemoSlavebInfoMapper.updateByPrimaryKey(tblUnionDemoSlavebInfo);
        logger.debug("操作[tbl_union_demo_slaveb_info]结果:count["+count+"]");
        if(count<=0){
            throw new Exception("修改从表[tbl_union_demo_slaveb_info]异常!");
        }
        //先删除子表数据  重新添加
        TblUnionDemoSubInfo tblUnionDemoSubInfo_tmp = new TblUnionDemoSubInfo();
        tblUnionDemoSubInfo_tmp.setForgienId(tblUnionDemoMainInfo.getDemoId());
        int delCount = tblUnionDemoSubInfoMapper.delete(tblUnionDemoSubInfo_tmp);
        logger.debug("删除[tbl_union_demo_sub_info]结果:count["+delCount+"]");
        List list = (List) paramMap.get(PageQueryUtil.SUBARRAY);
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> recordsMap = (HashMap<String, Object>) list.get(i);
            TblUnionDemoSubInfo tblUnionDemoSubInfo = new TblUnionDemoSubInfo();
            MapObjTransUtils.mapToObj(tblUnionDemoSubInfo, recordsMap);
            String pk0 = SysSequenceUtils.generateStringId("tbl_demo_info");
            tblUnionDemoSubInfo.setDemoIdc(Long.parseLong(pk0));
            tblUnionDemoSubInfo.setCreateTimec(DateUtils.getCurrDateTime());
            tblUnionDemoSubInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
            count = tblUnionDemoSubInfoMapper.insert(tblUnionDemoSubInfo);
            logger.debug("操作[tbl_union_demo_sub_info]结果:count["+count+"]");
            if(count<=0){
                throw new Exception("插入子表[tbl_union_demo_sub_info]异常!");
            }
        }

        logger.debug("updateUnionUnionDemoInfo:end");
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteUnionUnionDemoInfo(HashMap paramMap) throws Exception {
        logger.debug("deleteUnionUnionDemoInfo:start");
        logger.debug("传入参数:paramMap["+paramMap+"]");
        String id_keys = (String)paramMap.get("id_key");
        int count = 0;
        for(String id_key:id_keys.split(";")){
            TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
            tblUnionDemoMainInfo.setDemoId(Long.parseLong(id_key.split(",")[0]));
            //此处查询代码，功能为为了自动生成时，自动生成关联查询条件；如果确认此处代码无用，可以删除
            tblUnionDemoMainInfo = tblUnionDemoMainInfoMapper.select(tblUnionDemoMainInfo);
            count = tblUnionDemoMainInfoMapper.delete(tblUnionDemoMainInfo);
            logger.debug("操作[tbl_union_demo_main_info]结果:count["+count+"]");
            if(count<=0){
                throw new Exception("删除主表[tbl_union_demo_main_info]异常!");
            }
            TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo = new TblUnionDemoSlaveaInfo();
            tblUnionDemoSlaveaInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
            //此处查询代码，功能为为了自动生成时，自动生成关联查询条件；如果确认此处代码无用，可以删除
            tblUnionDemoSlaveaInfo = tblUnionDemoSlaveaInfoMapper.select(tblUnionDemoSlaveaInfo);
            count = tblUnionDemoSlaveaInfoMapper.delete(tblUnionDemoSlaveaInfo);
            logger.debug("操作[tbl_union_demo_slavea_info]结果:count["+count+"]");
            TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo = new TblUnionDemoSlavebInfo();
            tblUnionDemoSlavebInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
            //此处查询代码，功能为为了自动生成时，自动生成关联查询条件；如果确认此处代码无用，可以删除
            tblUnionDemoSlavebInfo = tblUnionDemoSlavebInfoMapper.select(tblUnionDemoSlavebInfo);
            count = tblUnionDemoSlavebInfoMapper.delete(tblUnionDemoSlavebInfo);
            logger.debug("操作[tbl_union_demo_slaveb_info]结果:count["+count+"]");
            TblUnionDemoSubInfo tblUnionDemoSubInfo = new TblUnionDemoSubInfo();
            tblUnionDemoSubInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
            count = tblUnionDemoSubInfoMapper.delete(tblUnionDemoSubInfo);
            logger.debug("操作[tbl_union_demo_sub_info]结果:count["+count+"]");
        }
        logger.debug("deleteUnionUnionDemoInfo:end");
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionUnionDemoInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageUnionUnionDemoInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(unionUnionDemoInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageUnionUnionDemoInfo:end");
        return result;
    }
    /*
     * 查询信息query
     */
    public HashMap queryUnionUnionDemoInfo(HashMap paramMap) throws Exception {
        logger.debug("queryUnionUnionDemoInfo:start");
        logger.debug("传入参数:paramMap:" + paramMap);
        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        String id_key = (String)paramMap.get("id_key");
        TblUnionDemoMainInfo tblUnionDemoMainInfo = new TblUnionDemoMainInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoMainInfo, paramMap);
        tblUnionDemoMainInfo.setDemoId(Long.parseLong(id_key.split(",")[0]));
        tblUnionDemoMainInfo = tblUnionDemoMainInfoMapper.select(tblUnionDemoMainInfo);
        logger.debug("查询结果:tblUnionDemoMainInfo:" + (tblUnionDemoMainInfo != null ? JSONObject.fromObject(tblUnionDemoMainInfo).toString() : "null"));
        if(tblUnionDemoMainInfo==null){
            throw new Exception("未查询到指定的主表[tbl_union_demo_main_info]信息");
        }
        resultMap.putAll(MapObjTransUtils.objectToMap(tblUnionDemoMainInfo));

        TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo = new TblUnionDemoSlaveaInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoSlaveaInfo, paramMap);
        tblUnionDemoSlaveaInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
        tblUnionDemoSlaveaInfo=tblUnionDemoSlaveaInfoMapper.select(tblUnionDemoSlaveaInfo);
        logger.debug("查询结果:tblUnionDemoSlaveaInfo:" + (tblUnionDemoSlaveaInfo != null ? JSONObject.fromObject(tblUnionDemoSlaveaInfo).toString() : "null"));
        if(tblUnionDemoSlaveaInfo==null){
            throw new Exception("未查询到指定的从表[tbl_union_demo_slavea_info]信息");
        }
        resultMap.putAll(MapObjTransUtils.objectToMap(tblUnionDemoSlaveaInfo));

        TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo = new TblUnionDemoSlavebInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoSlavebInfo, paramMap);
        tblUnionDemoSlavebInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
        tblUnionDemoSlavebInfo=tblUnionDemoSlavebInfoMapper.select(tblUnionDemoSlavebInfo);
        logger.debug("查询结果:tblUnionDemoSlavebInfo:" + (tblUnionDemoSlavebInfo != null ? JSONObject.fromObject(tblUnionDemoSlavebInfo).toString() : "null"));
        if(tblUnionDemoSlavebInfo==null){
            throw new Exception("未查询到指定的从表[tbl_union_demo_slaveb_info]信息");
        }
        resultMap.putAll(MapObjTransUtils.objectToMap(tblUnionDemoSlavebInfo));

        TblUnionDemoSubInfo tblUnionDemoSubInfo = new TblUnionDemoSubInfo();
        MapObjTransUtils.mapToObj(tblUnionDemoSubInfo, paramMap);
        tblUnionDemoSubInfo.setForgienId(tblUnionDemoMainInfo.getDemoId());
        List<HashMap<String,Object>> list =tblUnionDemoSubInfoMapper.queryListMap(MapObjTransUtils.objectToMap(tblUnionDemoSubInfo));
        list = PageQueryUtil.formatHashMapKeyInList(list);
        logger.debug("查询到子表:"+list.size()+"条");
        resultMap.put(PageQueryUtil.PAGERECORDS,list);

        logger.debug("查询结果:["+resultMap+"]");
        logger.debug("queryUnionUnionDemoInfo:end");
        return resultMap;
    }
}

