/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblMachineGatherInfo;
/**
 * 用户咖啡机表
 * tbl_machine_gather_info
 */
public interface MachineGatherInfoLogic {

    /*
     * 查询信息
     */
    public TblMachineGatherInfo queryMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteMachineGatherInfo(TblMachineGatherInfo tblMachineGatherInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageMachineGatherInfo(HashMap paramMap) throws Exception;

}

