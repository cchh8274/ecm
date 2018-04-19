/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblUniversityInfo;
/**
 * 大学表
 * tbl_university_info
 */
public interface UniversityInfoLogic {

    /*
     * 查询信息
     */
    public TblUniversityInfo queryUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteUniversityInfo(TblUniversityInfo tblUniversityInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUniversityInfo(HashMap paramMap) throws Exception;

}

