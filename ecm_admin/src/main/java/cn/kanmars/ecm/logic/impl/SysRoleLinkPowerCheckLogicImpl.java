package cn.kanmars.ecm.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.kanmars.ecm.dao.TblSysmenuInfoMapper;
import cn.kanmars.ecm.dao.TblSysroleMenuInfoMapper;
import cn.kanmars.ecm.dao.TblSysuserRoleInfoMapper;
import cn.kanmars.ecm.entity.TblSysmenuInfo;
import cn.kanmars.ecm.entity.TblSysroleMenuInfo;
import cn.kanmars.ecm.entity.TblSysuserRoleInfo;

@Service
@Transactional
public class SysRoleLinkPowerCheckLogicImpl implements cn.kanmars.ecm.logic.SysRoleLinkPowerCheckLogic {
	protected HLogger logger = LoggerManager.getLoger("SysRoleLinkPowerCheckLogicImpl");

	@Autowired
	private TblSysuserRoleInfoMapper tblSysuserRoleInfoMapper;

	@Autowired
	private TblSysmenuInfoMapper tblSysmenuInfoMapper;

	@Autowired
	private TblSysroleMenuInfoMapper tblSysroleMenuInfoMapper;

	public String querySysRoleLinkPower(String userNo, String menuUrl) throws Exception {
		logger.debug("querySysRoleLinkPower:start");

		// 查询菜单ID
		String[] urls = menuUrl.split(",");
		StringBuffer responseStr = new StringBuffer();
		
		for (int i = 0; i < urls.length; i++) {
			boolean hasPowerFlag = false;
			TblSysmenuInfo sysInfo = new TblSysmenuInfo();
			sysInfo.setMenuUrl(urls[i]);
			TblSysmenuInfo menuInfo = tblSysmenuInfoMapper.select(sysInfo);
			if("030".equals(menuInfo.getMenuType())){
				// 根据用户查询角色
				TblSysuserRoleInfo tsriUserNo = new TblSysuserRoleInfo();
				tsriUserNo.setUserNo(userNo);
				List<TblSysuserRoleInfo> roleNoList = tblSysuserRoleInfoMapper.selectList(tsriUserNo);
				if (roleNoList != null && roleNoList.size() > 0) {
					for (TblSysuserRoleInfo roleInfo : roleNoList) {
						//用户对应的每个角色，只要有一个角色关联当前传入的菜单，则说明该用户具备访问权限，即可跳出循环
						TblSysroleMenuInfo menuInfoObj = new TblSysroleMenuInfo();
						menuInfoObj.setRoleNo(roleInfo.getRoleNo());
						menuInfoObj.setMenuNo(menuInfo.getMenuNo());
						List<TblSysroleMenuInfo> list = tblSysroleMenuInfoMapper.selectList(menuInfoObj);
						if (list != null && list.size() > 0) {
							hasPowerFlag = true;
							break;
						}
					}
				}
			}else{
				//无须管制的菜单，说明谁都有访问权限
				hasPowerFlag = true;
			}
			
			responseStr.append(Boolean.valueOf(hasPowerFlag));
			if (i != urls.length - 1) {
				responseStr.append(",");
			}
		}
		
		logger.debug("responseStr值为：" + responseStr.toString());
		return responseStr.toString();
	}
}
