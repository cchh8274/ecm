package cn.kanmars.ecm.logic.impl;

import cn.com.xbase.frame.exception.SnCommonException;
import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.logic.ResultEnum;
import cn.kanmars.ecm.logic.ALogic;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by baolong on 2016/12/15.
 */
@Component
@Transactional
public class ALogicImpl implements ALogic {

    private HLogger logger = LoggerManager.getLoger("ALogic");

    @Override
    @Transactional(value="ecm-txManager",propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public ResultEnum exec(Object o) throws Exception {
        logger.info("ALogic.exec.start");
        logger.info("ALogic.exec.end");
        return ResultEnum.PartOK;
    }

}
