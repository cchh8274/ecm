/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblAreaInfo;
/**
 * 区域表
 * tbl_area_info
 */
public interface AreaInfoLogic {

    /*
     * 查询信息
     */
    public TblAreaInfo queryAreaInfo(TblAreaInfo tblAreaInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertAreaInfo(TblAreaInfo tblAreaInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateAreaInfo(TblAreaInfo tblAreaInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteAreaInfo(TblAreaInfo tblAreaInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageAreaInfo(HashMap paramMap) throws Exception;

}

