/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblUnionDemoMainInfo;
/**
 * 联表查询DEMO-主表
 * tbl_union_demo_main_info
 */
public interface UnionDemoMainInfoLogic {

    /*
     * 查询信息
     */
    public TblUnionDemoMainInfo queryUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteUnionDemoMainInfo(TblUnionDemoMainInfo tblUnionDemoMainInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoMainInfo(HashMap paramMap) throws Exception;

}

