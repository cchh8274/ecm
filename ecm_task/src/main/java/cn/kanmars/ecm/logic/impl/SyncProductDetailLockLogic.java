package cn.kanmars.ecm.logic.impl;

import cn.com.xbase.frame.exception.SnCommonException;
import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.logic.ILogics;
import cn.com.xbase.frame.logic.ResultEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 
* @ClassName: SyncProductDetailLockLogic 
* @Description: 锁定商品记录
* @author fengcong 
* @date 2015年8月20日 下午3:08:35
 */

@Service
@Transactional
public class SyncProductDetailLockLogic implements ILogics<Map<String , Object>> {

	private HLogger logger = LoggerManager.getLoger("SyncProductDetailLockLogic");
	
	
	@Transactional(value="ecm-txManager",propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public ResultEnum exec(Map<String , Object> map) throws SnCommonException {
		logger.info("SyncProductDetailLockLogic.exec-start");
		logger.info("SyncProductDetailLockLogic.exec-end");
		return ResultEnum.PartCase01;
	}
	
}
