package cn.kanmars.ecm.logic;

import cn.kanmars.ecm.entity.TblSysmenuInfo;

import java.util.List;


public interface MenuInfoLogic {
	
	/*
	 * 查询当前用户所有菜单
	 */
	public List<TblSysmenuInfo> queryUserMenu (String userNo)throws Exception;;
	

}
