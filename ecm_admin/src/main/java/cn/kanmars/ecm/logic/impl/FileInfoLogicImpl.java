/**
 * ecm Generator
 */
package cn.kanmars.ecm.logic.impl;


import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.kanmars.ecm.dao.TblFileStoreMapper;
import cn.kanmars.ecm.entity.TblFileStore;
import cn.kanmars.ecm.util.PageQueryUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import cn.kanmars.ecm.entity.TblFileInfo;
import cn.kanmars.ecm.dao.TblFileInfoMapper;
/**
 * 文件信息
 * tbl_file_info
 */
@Service
@Transactional
public class FileInfoLogicImpl implements cn.kanmars.ecm.logic.FileInfoLogic{

    protected HLogger logger = LoggerManager.getLoger("FileInfoLogicImpl");

    @Autowired
    private TblFileInfoMapper tblFileInfoMapper;

    @Autowired
    private TblFileStoreMapper tblFileStoreMapper;

    /*
     * 查询信息
     */
    public TblFileInfo queryFileInfo(TblFileInfo tblFileInfo) throws Exception {
        logger.debug("queryFileInfo:start");
        logger.debug("传入参数:tblFileInfo:" + (tblFileInfo != null ? JSONObject.fromObject(tblFileInfo).toString() : "null"));
        TblFileInfo result = tblFileInfoMapper.select(tblFileInfo);
        logger.debug("查询结果:tblFileInfo:" + (result != null ? JSONObject.fromObject(result).toString() : "null"));
        logger.debug("queryFileInfo:end");
        return result;
    }
    /*
     * 新增信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertFileInfo(TblFileInfo tblFileInfo) throws Exception {
        logger.debug("insertFileInfo:start");
        logger.debug("传入参数:tblFileInfo:" + (tblFileInfo != null ? JSONObject.fromObject(tblFileInfo).toString() : "null"));
        int insertNum = tblFileInfoMapper.insert(tblFileInfo);
        logger.debug("操作结果:insertNum["+insertNum+"]");
        logger.debug("insertFileInfo:end");
        return insertNum;
    }
    /*
     * 修改信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer updateFileInfo(TblFileInfo tblFileInfo) throws Exception {
        logger.debug("updateFileInfo:start");
        logger.debug("传入参数:tblFileInfo:" + (tblFileInfo != null ? JSONObject.fromObject(tblFileInfo).toString() : "null"));
        int updateNum = tblFileInfoMapper.updateByPrimaryKey(tblFileInfo);
        logger.debug("操作结果:updateNum["+updateNum+"]");
        logger.debug("updateFileInfo:end");
        return updateNum;
    }
    /*
     * 删除信息
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer deleteFileInfo(TblFileInfo tblFileInfo) throws Exception {
        logger.debug("deleteFileInfo:start");
        logger.debug("传入参数:tblFileInfo:" + (tblFileInfo != null ? JSONObject.fromObject(tblFileInfo).toString() : "null"));
        int deleteNum = tblFileInfoMapper.delete(tblFileInfo);
        logger.debug("操作结果:deleteNum["+deleteNum+"]");
        logger.debug("deleteFileInfo:end");
        return deleteNum;
    }
    /*
     * 查询信息queryPage
     */
    public HashMap queryPageFileInfo(HashMap paramMap) throws Exception {
        logger.debug("queryPageFileInfo:start");
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
        HashMap result = PageQueryUtil.pageQuery(tblFileInfoMapper, startIndex, pageSize, paramMap);
        logger.debug("查询结果:result:" + result);
        logger.debug("queryPageFileInfo:end");
        return result;
    }

    /**
     * 在数据库中插入FileInfo和文件本身
     * @param tblFileInfo
     * @param tblFileStore
     * @return
     * @throws Exception
     */
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertFileInfoAndDBInfo(TblFileInfo tblFileInfo, TblFileStore tblFileStore) throws Exception {
        logger.debug("insertFileInfoAndDBInfo:start");
        logger.debug("传入参数:tblFileInfo:" + (tblFileInfo != null ? JSONObject.fromObject(tblFileInfo).toString() : "null"));
        int insertNumOfFileInfo = tblFileInfoMapper.insert(tblFileInfo);
        logger.debug("操作结果:insertNumOfFileInfo["+insertNumOfFileInfo+"]");
        logger.debug("传入参数:tblFileStore:" + tblFileStore.getFileNo()+","+tblFileStore.getFileMd5());
        int insertNumOfFileStore = tblFileStoreMapper.insert(tblFileStore);
        logger.debug("操作结果:insertNum["+insertNumOfFileStore+"]");
        logger.debug("insertFileInfoAndDBInfo:end");
        if(insertNumOfFileInfo==1 && insertNumOfFileStore==1){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 将文件储存在文件系统中
     */
    public static final String STORETYPE_STOREFILE="f1";
    /**
     * 将文件储存在数据库中
     */
    public static final String STORETYPE_STOREDB="d1";

    /**
     * 根据fileNo，返回文件名称，文件内容等信息
     *
     * @param fileNo
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getFileInfo(Long fileNo) throws Exception {
        logger.debug("getFileInfo:start");
        Map result = new HashMap();
        TblFileInfo tblFileInfo = tblFileInfoMapper.selectByPrimaryKey(fileNo);
        if(tblFileInfo==null){
            throw new RuntimeException("["+fileNo+"]对应的FileInfo未找到!");
        }

        if(!tblFileInfo.getFileStat().equals("010")){
            logger.debug("["+fileNo+"]对应的FileInfo的状态为["+tblFileInfo.getFileStat()+"]未找到!");
            throw new RuntimeException("["+fileNo+"]对应的FileInfo未找到!");
        }
        byte[] fileBlob = null;
        String  filePath = tblFileInfo.getFilePath();
        if(filePath.startsWith(STORETYPE_STOREFILE+":")){
            String storeAllName = filePath.substring(STORETYPE_STOREFILE.length()+1);
            InputStream is = new FileInputStream(storeAllName);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            byte[] tmp = new byte[512];
            int count =0;
            while((count=is.read(tmp))>=0){
                bao.write(tmp,0,count);
            }
            is.close();
            fileBlob = bao.toByteArray();
            result.put("fileBlob",fileBlob);
        }
        if(filePath.equals(STORETYPE_STOREDB)){
            TblFileStore tblFileStore = tblFileStoreMapper.selectByPrimaryKey(fileNo);
            if(tblFileStore==null){
                throw new RuntimeException("["+fileNo+"]对应的FileStore未找到!");
            }
            result.put("fileBlob",tblFileStore.getFileBlob());
        }


        result.put("fileName",tblFileInfo.getFileName());
        result.put("fileRootPath",tblFileInfo.getFileRootPath());
        result.put("createTm",tblFileInfo.getCreateTm());
        logger.debug("getFileInfo:end");
        return result;
    }


}

