/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblMachineInfo;
/**
 * 机器信息表
 * tbl_machine_info
 */
public interface MachineInfoLogic {

    /*
     * 查询信息
     */
    public TblMachineInfo queryMachineInfo(TblMachineInfo tblMachineInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertMachineInfo(TblMachineInfo tblMachineInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateMachineInfo(TblMachineInfo tblMachineInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteMachineInfo(TblMachineInfo tblMachineInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageMachineInfo(HashMap paramMap) throws Exception;

}

