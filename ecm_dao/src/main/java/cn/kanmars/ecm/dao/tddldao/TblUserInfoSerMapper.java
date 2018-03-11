package cn.kanmars.ecm.dao.tddldao;



import cn.kanmars.ecm.entity.UserInfo;

import java.util.List;

/**
 * Created by zhaojiuyang on 2015/12/8.
 */
@cn.kanmars.ecm.MybatisRepository
public interface TblUserInfoSerMapper {
    List<UserInfo> getUserInfoList();
    UserInfo getUserInfo(Long pk);
    void insertUserInfo(UserInfo userInfo);
}
