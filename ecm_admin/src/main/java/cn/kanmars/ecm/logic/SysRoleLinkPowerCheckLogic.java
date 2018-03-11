package cn.kanmars.ecm.logic;


public interface SysRoleLinkPowerCheckLogic {
	/*
	 * 查询当前用户对应角色是否有管制url
	 */
	public String querySysRoleLinkPower(String userNo,String menuUrl) throws Exception;
}
