/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblDemoUserphotoInfo;
/**
 * 用户照片表
 * tbl_demo_userphoto_info
 */
public interface DemoUserphotoInfoLogic {

    /*
     * 查询信息
     */
    public TblDemoUserphotoInfo queryDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteDemoUserphotoInfo(TblDemoUserphotoInfo tblDemoUserphotoInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageDemoUserphotoInfo(HashMap paramMap) throws Exception;

}

