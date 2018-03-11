/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblUnionDemoSlavebInfo;
/**
 * 联表查询DEMO-从表b
 * tbl_union_demo_slaveb_info
 */
public interface UnionDemoSlavebInfoLogic {

    /*
     * 查询信息
     */
    public TblUnionDemoSlavebInfo queryUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteUnionDemoSlavebInfo(TblUnionDemoSlavebInfo tblUnionDemoSlavebInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoSlavebInfo(HashMap paramMap) throws Exception;

}

