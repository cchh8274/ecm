/**
 * ecm Generator
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import java.util.Map;

import cn.kanmars.ecm.entity.TblFileInfo;
import cn.kanmars.ecm.entity.TblFileStore;

/**
 * 文件信息
 * tbl_file_info
 */
public interface FileInfoLogic {

    /*
     * 查询信息
     */
    public TblFileInfo queryFileInfo(TblFileInfo tblFileInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertFileInfo(TblFileInfo tblFileInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateFileInfo(TblFileInfo tblFileInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteFileInfo(TblFileInfo tblFileInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageFileInfo(HashMap paramMap) throws Exception;


    /*
     * 新增DB级别信息
     */
    public Integer insertFileInfoAndDBInfo(TblFileInfo tblFileInfo,TblFileStore tblFileStore) throws Exception;

    /**
     * 根据fileNo，返回文件名称，文件内容等信息
     * @param fileNo
     * @return
     * @throws Exception
     */
    public Map<String,Object> getFileInfo(Long fileNo) throws Exception;
}

