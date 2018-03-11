/**
 * ecm Generator 
 */
package cn.kanmars.ecm.dao;


import java.util.List;
import java.util.HashMap;
/**
 * 联表查询DEMO
 * union_Demo_Info
 */
@cn.kanmars.ecm.MybatisRepository
public interface UnionUnionDemoInfoMapper {
    /**
     * 分页查询
     * 参数有两种情况：
     *     1、传递countFlag=Y标记,则返回的是计数
     *     2、传递countFlag=N标记、limitStart、limitSize,则返回的是分页结果,字段未驼峰化
     */
    public List<HashMap> queryForPage(HashMap paramMap);
}

