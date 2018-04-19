/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 收益表
 * tbl_earnings_info
 */
public class TblEarningsInfo implements java.io.Serializable{
    /**
     * id
     * tbl_earnings_info.id
     */
    private Integer id;

    /**
     * openid
     * tbl_earnings_info.openid
     */
    private String openid;

    /**
     * 微信用户
     * tbl_earnings_info.wx_user_name
     */
    private String wxUserName;

    /**
     * 机器ID
     * tbl_earnings_info.maniche_id
     */
    private String manicheId;

    /**
     * 大学名称
     * tbl_earnings_info.unversity_name
     */
    private String unversityName;

    /**
     * 大学ID
     * tbl_earnings_info.unversity_id
     */
    private String unversityId;

    /**
     * 机器名称
     * tbl_earnings_info.maniche_name
     */
    private String manicheName;

    /**
     * 收益单价
     * tbl_earnings_info.price
     */
    private String price;

    /**
     * 收益咖啡机数量
     * tbl_earnings_info.coffee_number
     */
    private String coffeeNumber;

    /**
     * 当月收益总金额
     * tbl_earnings_info.tolal_money
     */
    private String tolalMoney;

    /**
     * 收益时间
     * tbl_earnings_info.earing_month
     */
    private String earingMonth;

    /**
     * 收益开始时间
     * tbl_earnings_info.earning_start_time
     */
    private String earningStartTime;

    /**
     * 是否下发收益
     * tbl_earnings_info.is_eaning_status
     */
    private String isEaningStatus;

    /**
     * 收益下发时间
     * tbl_earnings_info.earning_send_time
     */
    private String earningSendTime;

    /**
     * 创建时间
     * tbl_earnings_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_earnings_info.create_user
     */
    private String createUser;

    /**
     * 修改时间
     * tbl_earnings_info.update_time
     */
    private String updateTime;

    /**
     * 修改人
     * tbl_earnings_info.update_user
     */
    private String updateUser;


    public TblEarningsInfo(){super();}
    public TblEarningsInfo(Integer id,String openid,String wxUserName,String manicheId,String unversityName,String unversityId,String manicheName,String price,String coffeeNumber,String tolalMoney,String earingMonth,String earningStartTime,String isEaningStatus,String earningSendTime,String createTime,String createUser,String updateTime,String updateUser) {
        this.id = id;
        this.openid = openid;
        this.wxUserName = wxUserName;
        this.manicheId = manicheId;
        this.unversityName = unversityName;
        this.unversityId = unversityId;
        this.manicheName = manicheName;
        this.price = price;
        this.coffeeNumber = coffeeNumber;
        this.tolalMoney = tolalMoney;
        this.earingMonth = earingMonth;
        this.earningStartTime = earningStartTime;
        this.isEaningStatus = isEaningStatus;
        this.earningSendTime = earningSendTime;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }
    /**
     * id
     * tbl_earnings_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_earnings_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * openid
     * tbl_earnings_info.openid
     */
    public String getOpenid(){
        return openid;
    }

    /**
     * openid
     * tbl_earnings_info.openid
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }

    /**
     * 微信用户
     * tbl_earnings_info.wx_user_name
     */
    public String getWxUserName(){
        return wxUserName;
    }

    /**
     * 微信用户
     * tbl_earnings_info.wx_user_name
     */
    public void setWxUserName(String wxUserName){
        this.wxUserName=wxUserName;
    }

    /**
     * 机器ID
     * tbl_earnings_info.maniche_id
     */
    public String getManicheId(){
        return manicheId;
    }

    /**
     * 机器ID
     * tbl_earnings_info.maniche_id
     */
    public void setManicheId(String manicheId){
        this.manicheId=manicheId;
    }

    /**
     * 大学名称
     * tbl_earnings_info.unversity_name
     */
    public String getUnversityName(){
        return unversityName;
    }

    /**
     * 大学名称
     * tbl_earnings_info.unversity_name
     */
    public void setUnversityName(String unversityName){
        this.unversityName=unversityName;
    }

    /**
     * 大学ID
     * tbl_earnings_info.unversity_id
     */
    public String getUnversityId(){
        return unversityId;
    }

    /**
     * 大学ID
     * tbl_earnings_info.unversity_id
     */
    public void setUnversityId(String unversityId){
        this.unversityId=unversityId;
    }

    /**
     * 机器名称
     * tbl_earnings_info.maniche_name
     */
    public String getManicheName(){
        return manicheName;
    }

    /**
     * 机器名称
     * tbl_earnings_info.maniche_name
     */
    public void setManicheName(String manicheName){
        this.manicheName=manicheName;
    }

    /**
     * 收益单价
     * tbl_earnings_info.price
     */
    public String getPrice(){
        return price;
    }

    /**
     * 收益单价
     * tbl_earnings_info.price
     */
    public void setPrice(String price){
        this.price=price;
    }

    /**
     * 收益咖啡机数量
     * tbl_earnings_info.coffee_number
     */
    public String getCoffeeNumber(){
        return coffeeNumber;
    }

    /**
     * 收益咖啡机数量
     * tbl_earnings_info.coffee_number
     */
    public void setCoffeeNumber(String coffeeNumber){
        this.coffeeNumber=coffeeNumber;
    }

    /**
     * 当月收益总金额
     * tbl_earnings_info.tolal_money
     */
    public String getTolalMoney(){
        return tolalMoney;
    }

    /**
     * 当月收益总金额
     * tbl_earnings_info.tolal_money
     */
    public void setTolalMoney(String tolalMoney){
        this.tolalMoney=tolalMoney;
    }

    /**
     * 收益时间
     * tbl_earnings_info.earing_month
     */
    public String getEaringMonth(){
        return earingMonth;
    }

    /**
     * 收益时间
     * tbl_earnings_info.earing_month
     */
    public void setEaringMonth(String earingMonth){
        this.earingMonth=earingMonth;
    }

    /**
     * 收益开始时间
     * tbl_earnings_info.earning_start_time
     */
    public String getEarningStartTime(){
        return earningStartTime;
    }

    /**
     * 收益开始时间
     * tbl_earnings_info.earning_start_time
     */
    public void setEarningStartTime(String earningStartTime){
        this.earningStartTime=earningStartTime;
    }

    /**
     * 是否下发收益
     * tbl_earnings_info.is_eaning_status
     */
    public String getIsEaningStatus(){
        return isEaningStatus;
    }

    /**
     * 是否下发收益
     * tbl_earnings_info.is_eaning_status
     */
    public void setIsEaningStatus(String isEaningStatus){
        this.isEaningStatus=isEaningStatus;
    }

    /**
     * 收益下发时间
     * tbl_earnings_info.earning_send_time
     */
    public String getEarningSendTime(){
        return earningSendTime;
    }

    /**
     * 收益下发时间
     * tbl_earnings_info.earning_send_time
     */
    public void setEarningSendTime(String earningSendTime){
        this.earningSendTime=earningSendTime;
    }

    /**
     * 创建时间
     * tbl_earnings_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_earnings_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_earnings_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_earnings_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 修改时间
     * tbl_earnings_info.update_time
     */
    public String getUpdateTime(){
        return updateTime;
    }

    /**
     * 修改时间
     * tbl_earnings_info.update_time
     */
    public void setUpdateTime(String updateTime){
        this.updateTime=updateTime;
    }

    /**
     * 修改人
     * tbl_earnings_info.update_user
     */
    public String getUpdateUser(){
        return updateUser;
    }

    /**
     * 修改人
     * tbl_earnings_info.update_user
     */
    public void setUpdateUser(String updateUser){
        this.updateUser=updateUser;
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

