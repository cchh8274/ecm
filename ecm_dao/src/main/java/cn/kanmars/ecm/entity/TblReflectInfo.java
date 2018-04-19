/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 体现记录表
 * tbl_reflect_info
 */
public class TblReflectInfo implements java.io.Serializable{
    /**
     * id
     * tbl_reflect_info.id
     */
    private Integer id;

    /**
     * 体现流水号
     * tbl_reflect_info.trans_no
     */
    private String transNo;

    /**
     * openid
     * tbl_reflect_info.openid
     */
    private String openid;

    /**
     * 微信用户
     * tbl_reflect_info.wx_user
     */
    private String wxUser;

    /**
     * 体现用户
     * tbl_reflect_info.reflect_user
     */
    private String reflectUser;

    /**
     * 银行卡号
     * tbl_reflect_info.bank_card
     */
    private String bankCard;

    /**
     * 银行名称
     * tbl_reflect_info.bank_name
     */
    private String bankName;

    /**
     * 提现金额
     * tbl_reflect_info.reflect_money
     */
    private String reflectMoney;

    /**
     * 是否到账
     * tbl_reflect_info.is_account
     */
    private String isAccount;

    /**
     * 是否冻结
     * tbl_reflect_info.is_freeze
     */
    private String isFreeze;

    /**
     * 到账时间
     * tbl_reflect_info.account_time
     */
    private String accountTime;

    /**
     * 创建时间
     * tbl_reflect_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_reflect_info.create_user
     */
    private String createUser;


    public TblReflectInfo(){super();}
    public TblReflectInfo(Integer id,String transNo,String openid,String wxUser,String reflectUser,String bankCard,String bankName,String reflectMoney,String isAccount,String isFreeze,String accountTime,String createTime,String createUser) {
        this.id = id;
        this.transNo = transNo;
        this.openid = openid;
        this.wxUser = wxUser;
        this.reflectUser = reflectUser;
        this.bankCard = bankCard;
        this.bankName = bankName;
        this.reflectMoney = reflectMoney;
        this.isAccount = isAccount;
        this.isFreeze = isFreeze;
        this.accountTime = accountTime;
        this.createTime = createTime;
        this.createUser = createUser;
    }
    /**
     * id
     * tbl_reflect_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_reflect_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 体现流水号
     * tbl_reflect_info.trans_no
     */
    public String getTransNo(){
        return transNo;
    }

    /**
     * 体现流水号
     * tbl_reflect_info.trans_no
     */
    public void setTransNo(String transNo){
        this.transNo=transNo;
    }

    /**
     * openid
     * tbl_reflect_info.openid
     */
    public String getOpenid(){
        return openid;
    }

    /**
     * openid
     * tbl_reflect_info.openid
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }

    /**
     * 微信用户
     * tbl_reflect_info.wx_user
     */
    public String getWxUser(){
        return wxUser;
    }

    /**
     * 微信用户
     * tbl_reflect_info.wx_user
     */
    public void setWxUser(String wxUser){
        this.wxUser=wxUser;
    }

    /**
     * 体现用户
     * tbl_reflect_info.reflect_user
     */
    public String getReflectUser(){
        return reflectUser;
    }

    /**
     * 体现用户
     * tbl_reflect_info.reflect_user
     */
    public void setReflectUser(String reflectUser){
        this.reflectUser=reflectUser;
    }

    /**
     * 银行卡号
     * tbl_reflect_info.bank_card
     */
    public String getBankCard(){
        return bankCard;
    }

    /**
     * 银行卡号
     * tbl_reflect_info.bank_card
     */
    public void setBankCard(String bankCard){
        this.bankCard=bankCard;
    }

    /**
     * 银行名称
     * tbl_reflect_info.bank_name
     */
    public String getBankName(){
        return bankName;
    }

    /**
     * 银行名称
     * tbl_reflect_info.bank_name
     */
    public void setBankName(String bankName){
        this.bankName=bankName;
    }

    /**
     * 提现金额
     * tbl_reflect_info.reflect_money
     */
    public String getReflectMoney(){
        return reflectMoney;
    }

    /**
     * 提现金额
     * tbl_reflect_info.reflect_money
     */
    public void setReflectMoney(String reflectMoney){
        this.reflectMoney=reflectMoney;
    }

    /**
     * 是否到账
     * tbl_reflect_info.is_account
     */
    public String getIsAccount(){
        return isAccount;
    }

    /**
     * 是否到账
     * tbl_reflect_info.is_account
     */
    public void setIsAccount(String isAccount){
        this.isAccount=isAccount;
    }

    /**
     * 是否冻结
     * tbl_reflect_info.is_freeze
     */
    public String getIsFreeze(){
        return isFreeze;
    }

    /**
     * 是否冻结
     * tbl_reflect_info.is_freeze
     */
    public void setIsFreeze(String isFreeze){
        this.isFreeze=isFreeze;
    }

    /**
     * 到账时间
     * tbl_reflect_info.account_time
     */
    public String getAccountTime(){
        return accountTime;
    }

    /**
     * 到账时间
     * tbl_reflect_info.account_time
     */
    public void setAccountTime(String accountTime){
        this.accountTime=accountTime;
    }

    /**
     * 创建时间
     * tbl_reflect_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_reflect_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_reflect_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_reflect_info.create_user
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

