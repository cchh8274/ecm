/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic.impl;

import cn.com.xbase.frame.exception.SnCommonException;
import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.logic.ResultEnum;
import cn.com.xbase.frame.util.MapObjTransUtils;
import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.dao.TblSysDicMapper;
import cn.kanmars.ecm.logic.SysDicGetListLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 根据l1_code、l2_code获取List
 */
@Component
@Transactional
public class SysDicGetListLogicImpl implements SysDicGetListLogic{

    protected HLogger logger = LoggerManager.getLoger("SysDicGetListLogicImpl");

    @Autowired
    private TblSysDicMapper tblSysDicMapper;

    @Override
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public ResultEnum exec(Object o) throws Exception {
        logger.info("SysDicGetListLogicImpl.exec.start");
        if(((HashMap) o).get("l1_code")==null||((HashMap) o).get("l2_code")==null){
            throw new SnCommonException("访问数据字典数据时l1_code["+((HashMap) o).get("l1_code")+"]" +
                    "或者l2_code["+((HashMap) o).get("l2_code")+"]无值");
        }

        String l1_code = ((HashMap)o).get("l1_code").toString();
        String l2_code = ((HashMap)o).get("l2_code").toString();
        HashMap param = new HashMap();
        param.put("l1Code",l1_code);
        param.put("l2Code",l2_code);
        List<HashMap> list = tblSysDicMapper.queryListMap(param);
        if(list == null){
            list = new ArrayList<HashMap>();
        }
        ((HashMap) o).put("result", list);
        logger.info("SysDicGetListLogicImpl.exec.end");
        return ResultEnum.PartOK;
    }
}


