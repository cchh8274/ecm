/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 微信用户表
 * tbl_wx_user_info
 */
public class TblWxUserInfo implements java.io.Serializable{
    /**
     * ID
     * tbl_wx_user_info.id
     */
    private Integer id;

    /**
     * openid
     * tbl_wx_user_info.openid
     */
    private String openid;

    /**
     * 用户的昵称
     * tbl_wx_user_info.nickname
     */
    private String nickname;

    /**
     * 性别
     * tbl_wx_user_info.sex
     */
    private String sex;

    /**
     * 用户所在城市
     * tbl_wx_user_info.city
     */
    private String city;

    /**
     * 用户所在国家
     * tbl_wx_user_info.country
     */
    private String country;

    /**
     * 用户所在省份
     * tbl_wx_user_info.province
     */
    private String province;

    /**
     * 用户的语言
     * tbl_wx_user_info.language
     */
    private String language;

    /**
     * 
     * tbl_wx_user_info.headimgurl
     */
    private String headimgurl;

    /**
     * 用户关注时间
     * tbl_wx_user_info.subscribe_time
     */
    private String subscribeTime;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     * tbl_wx_user_info.unionid
     */
    private String unionid;

    /**
     * 公众号运营者对粉丝的备注
     * tbl_wx_user_info.remark
     */
    private String remark;

    /**
     * 用户所在的分组ID
     * tbl_wx_user_info.groupid
     */
    private String groupid;

    /**
     * 用户被打上的标签ID列表
     * tbl_wx_user_info.tagid_list
     */
    private String tagidList;

    /**
     * 返回用户关注的渠道来源
     * tbl_wx_user_info.subscribe_scene
     */
    private String subscribeScene;

    /**
     * 二维码扫码场景
     * tbl_wx_user_info.qr_scene
     */
    private String qrScene;

    /**
     * 二维码扫码场景描述
     * tbl_wx_user_info.qr_scene_str
     */
    private String qrSceneStr;

    /**
     * 创建时间
     * tbl_wx_user_info.createt_time
     */
    private String createtTime;

    /**
     * 创建人
     * tbl_wx_user_info.create_user
     */
    private String createUser;


    public TblWxUserInfo(){super();}
    public TblWxUserInfo(Integer id,String openid,String nickname,String sex,String city,String country,String province,String language,String headimgurl,String subscribeTime,String unionid,String remark,String groupid,String tagidList,String subscribeScene,String qrScene,String qrSceneStr,String createtTime,String createUser) {
        this.id = id;
        this.openid = openid;
        this.nickname = nickname;
        this.sex = sex;
        this.city = city;
        this.country = country;
        this.province = province;
        this.language = language;
        this.headimgurl = headimgurl;
        this.subscribeTime = subscribeTime;
        this.unionid = unionid;
        this.remark = remark;
        this.groupid = groupid;
        this.tagidList = tagidList;
        this.subscribeScene = subscribeScene;
        this.qrScene = qrScene;
        this.qrSceneStr = qrSceneStr;
        this.createtTime = createtTime;
        this.createUser = createUser;
    }
    /**
     * ID
     * tbl_wx_user_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * ID
     * tbl_wx_user_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * openid
     * tbl_wx_user_info.openid
     */
    public String getOpenid(){
        return openid;
    }

    /**
     * openid
     * tbl_wx_user_info.openid
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }

    /**
     * 用户的昵称
     * tbl_wx_user_info.nickname
     */
    public String getNickname(){
        return nickname;
    }

    /**
     * 用户的昵称
     * tbl_wx_user_info.nickname
     */
    public void setNickname(String nickname){
        this.nickname=nickname;
    }

    /**
     * 性别
     * tbl_wx_user_info.sex
     */
    public String getSex(){
        return sex;
    }

    /**
     * 性别
     * tbl_wx_user_info.sex
     */
    public void setSex(String sex){
        this.sex=sex;
    }

    /**
     * 用户所在城市
     * tbl_wx_user_info.city
     */
    public String getCity(){
        return city;
    }

    /**
     * 用户所在城市
     * tbl_wx_user_info.city
     */
    public void setCity(String city){
        this.city=city;
    }

    /**
     * 用户所在国家
     * tbl_wx_user_info.country
     */
    public String getCountry(){
        return country;
    }

    /**
     * 用户所在国家
     * tbl_wx_user_info.country
     */
    public void setCountry(String country){
        this.country=country;
    }

    /**
     * 用户所在省份
     * tbl_wx_user_info.province
     */
    public String getProvince(){
        return province;
    }

    /**
     * 用户所在省份
     * tbl_wx_user_info.province
     */
    public void setProvince(String province){
        this.province=province;
    }

    /**
     * 用户的语言
     * tbl_wx_user_info.language
     */
    public String getLanguage(){
        return language;
    }

    /**
     * 用户的语言
     * tbl_wx_user_info.language
     */
    public void setLanguage(String language){
        this.language=language;
    }

    /**
     * 
     * tbl_wx_user_info.headimgurl
     */
    public String getHeadimgurl(){
        return headimgurl;
    }

    /**
     * 
     * tbl_wx_user_info.headimgurl
     */
    public void setHeadimgurl(String headimgurl){
        this.headimgurl=headimgurl;
    }

    /**
     * 用户关注时间
     * tbl_wx_user_info.subscribe_time
     */
    public String getSubscribeTime(){
        return subscribeTime;
    }

    /**
     * 用户关注时间
     * tbl_wx_user_info.subscribe_time
     */
    public void setSubscribeTime(String subscribeTime){
        this.subscribeTime=subscribeTime;
    }

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     * tbl_wx_user_info.unionid
     */
    public String getUnionid(){
        return unionid;
    }

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     * tbl_wx_user_info.unionid
     */
    public void setUnionid(String unionid){
        this.unionid=unionid;
    }

    /**
     * 公众号运营者对粉丝的备注
     * tbl_wx_user_info.remark
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 公众号运营者对粉丝的备注
     * tbl_wx_user_info.remark
     */
    public void setRemark(String remark){
        this.remark=remark;
    }

    /**
     * 用户所在的分组ID
     * tbl_wx_user_info.groupid
     */
    public String getGroupid(){
        return groupid;
    }

    /**
     * 用户所在的分组ID
     * tbl_wx_user_info.groupid
     */
    public void setGroupid(String groupid){
        this.groupid=groupid;
    }

    /**
     * 用户被打上的标签ID列表
     * tbl_wx_user_info.tagid_list
     */
    public String getTagidList(){
        return tagidList;
    }

    /**
     * 用户被打上的标签ID列表
     * tbl_wx_user_info.tagid_list
     */
    public void setTagidList(String tagidList){
        this.tagidList=tagidList;
    }

    /**
     * 返回用户关注的渠道来源
     * tbl_wx_user_info.subscribe_scene
     */
    public String getSubscribeScene(){
        return subscribeScene;
    }

    /**
     * 返回用户关注的渠道来源
     * tbl_wx_user_info.subscribe_scene
     */
    public void setSubscribeScene(String subscribeScene){
        this.subscribeScene=subscribeScene;
    }

    /**
     * 二维码扫码场景
     * tbl_wx_user_info.qr_scene
     */
    public String getQrScene(){
        return qrScene;
    }

    /**
     * 二维码扫码场景
     * tbl_wx_user_info.qr_scene
     */
    public void setQrScene(String qrScene){
        this.qrScene=qrScene;
    }

    /**
     * 二维码扫码场景描述
     * tbl_wx_user_info.qr_scene_str
     */
    public String getQrSceneStr(){
        return qrSceneStr;
    }

    /**
     * 二维码扫码场景描述
     * tbl_wx_user_info.qr_scene_str
     */
    public void setQrSceneStr(String qrSceneStr){
        this.qrSceneStr=qrSceneStr;
    }

    /**
     * 创建时间
     * tbl_wx_user_info.createt_time
     */
    public String getCreatetTime(){
        return createtTime;
    }

    /**
     * 创建时间
     * tbl_wx_user_info.createt_time
     */
    public void setCreatetTime(String createtTime){
        this.createtTime=createtTime;
    }

    /**
     * 创建人
     * tbl_wx_user_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_wx_user_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 自定义列，分页查询用
     */
    private Integer limitStart;
    public Integer getLimitStart(){
        return limitStart;
    }
    public void setLimitStart(Integer limitStart){
        this.limitStart = limitStart;
    }
    private Integer limitSize;
    public Integer getLimitSize(){
        return limitSize;
    }
    public void setLimitSize(Integer limitSize){
        this.limitSize = limitSize;
    }
}

