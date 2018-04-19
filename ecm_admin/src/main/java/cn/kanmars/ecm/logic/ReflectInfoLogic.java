/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblReflectInfo;
/**
 * 体现记录表
 * tbl_reflect_info
 */
public interface ReflectInfoLogic {

    /*
     * 查询信息
     */
    public TblReflectInfo queryReflectInfo(TblReflectInfo tblReflectInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertReflectInfo(TblReflectInfo tblReflectInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateReflectInfo(TblReflectInfo tblReflectInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteReflectInfo(TblReflectInfo tblReflectInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageReflectInfo(HashMap paramMap) throws Exception;

}

