/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic.impl;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.logic.ResultEnum;
import cn.kanmars.ecm.dao.TblSysDicMapper;
import cn.kanmars.ecm.entity.TblSysDic;
import cn.kanmars.ecm.logic.SysDicGetAllLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 查询全量数据字典表
 */
@Component
@Transactional
public class SysDicGetAllLogicImpl implements SysDicGetAllLogic{

    protected HLogger logger = LoggerManager.getLoger("SysDicGetAllLogicImpl");

    @Autowired
    private TblSysDicMapper tblSysDicMapper;

    @Override
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public ResultEnum exec(Object o) throws Exception {
        logger.info("SysDicGetAllLogicImpl.exec.start");
        List<HashMap> list = tblSysDicMapper.queryListMap(new HashMap());
        if(list == null){
            list = new ArrayList<HashMap>();
        }
        ((HashMap)o).put("result",list);
        logger.info("SysDicGetAllLogicImpl.exec.end");
        return ResultEnum.PartOK;
    }
}


