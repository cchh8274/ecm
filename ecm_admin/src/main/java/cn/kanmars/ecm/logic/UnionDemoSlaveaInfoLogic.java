/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblUnionDemoSlaveaInfo;
/**
 * 联表查询DEMO-从表a
 * tbl_union_demo_slavea_info
 */
public interface UnionDemoSlaveaInfoLogic {

    /*
     * 查询信息
     */
    public TblUnionDemoSlaveaInfo queryUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteUnionDemoSlaveaInfo(TblUnionDemoSlaveaInfo tblUnionDemoSlaveaInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageUnionDemoSlaveaInfo(HashMap paramMap) throws Exception;

}

