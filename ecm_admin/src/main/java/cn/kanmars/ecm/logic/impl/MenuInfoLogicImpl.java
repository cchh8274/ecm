package cn.kanmars.ecm.logic.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.kanmars.ecm.dao.TblSysmenuInfoMapper;
import cn.kanmars.ecm.entity.TblSysmenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MenuInfoLogicImpl implements cn.kanmars.ecm.logic.MenuInfoLogic {
	
	 @Autowired
	private TblSysmenuInfoMapper tblSysmenuInfoMapper;
	

	public List<TblSysmenuInfo> queryUserMenu(String userNo) throws Exception {
		
		List<TblSysmenuInfo>  list = new ArrayList<TblSysmenuInfo>();

		list =  tblSysmenuInfoMapper.queryList(userNo);

		return list;
	}
	
}
