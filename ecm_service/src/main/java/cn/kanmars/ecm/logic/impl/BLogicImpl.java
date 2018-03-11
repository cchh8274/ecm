package cn.kanmars.ecm.logic.impl;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.logic.ResultEnum;
import cn.kanmars.ecm.logic.BLogic;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by baolong on 2016/12/15.
 */
@Component
@Transactional
public class BLogicImpl implements BLogic {

    private HLogger logger = LoggerManager.getLoger("BLogic");

    @Override
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public ResultEnum exec(Object o) throws Exception {
        logger.info("BLogic.exec.start");
        logger.info("BLogic.exec.end");
        return ResultEnum.PartOK;
    }

}
