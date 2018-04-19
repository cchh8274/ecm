/**
 * ecm Generator 
 */
package cn.kanmars.ecm.logic;


import java.util.HashMap;
import cn.kanmars.ecm.entity.TblWxUserInfo;
/**
 * 微信用户表
 * tbl_wx_user_info
 */
public interface WxUserInfoLogic {

    /*
     * 查询信息
     */
    public TblWxUserInfo queryWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception;

    /*
     * 新增信息
     */
    public Integer insertWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception;

    /*
     * 修改信息
     */
    public Integer updateWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception;

    /*
     * 删除信息
     */
    public Integer deleteWxUserInfo(TblWxUserInfo tblWxUserInfo) throws Exception;

    /*
     * 查询信息queryPage
     */
    public HashMap queryPageWxUserInfo(HashMap paramMap) throws Exception;

}

