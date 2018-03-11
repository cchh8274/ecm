/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import java.util.List;

import cn.kanmars.ecm.entity.TblUnionDemoSubInfo;
/**
 * 联表查询DEMO-子表
 * tbl_union_demo_sub_info
 */
public interface UnionDemoSubInfoLogic {

    /*
     * 查询信息
     */
    public TblUnionDemoSubInfo queryUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteUnionDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoSubInfo(HashMap paramMap) throws Exception;
    
    /*
     * 查询信息queryList
     */
    public List<TblUnionDemoSubInfo> queryListDemoSubInfo(TblUnionDemoSubInfo tblUnionDemoSubInfo) throws Exception;

}

