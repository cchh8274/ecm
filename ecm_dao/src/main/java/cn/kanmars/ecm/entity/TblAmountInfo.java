/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 用户账户表
 * tbl_amount_info
 */
public class TblAmountInfo implements java.io.Serializable{
    /**
     * id
     * tbl_amount_info.id
     */
    private Integer id;

    /**
     * 用户名称
     * tbl_amount_info.user_name
     */
    private String userName;

    /**
     * openid
     * tbl_amount_info.openid
     */
    private String openid;

    /**
     * 账户金额
     * tbl_amount_info.account_money
     */
    private String accountMoney;

    /**
     * 是否启用
     * tbl_amount_info.is_start
     */
    private String isStart;

    /**
     * 账户ID
     * tbl_amount_info.account_id
     */
    private String accountId;

    /**
     * 账户创建时间
     * tbl_amount_info.account_time
     */
    private String accountTime;

    /**
     * 创建时间
     * tbl_amount_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_amount_info.create_user
     */
    private String createUser;

    /**
     * 是否冻结
     * tbl_amount_info.is_freeze
     */
    private String isFreeze;


    public TblAmountInfo(){super();}
    public TblAmountInfo(Integer id,String userName,String openid,String accountMoney,String isStart,String accountId,String accountTime,String createTime,String createUser,String isFreeze) {
        this.id = id;
        this.userName = userName;
        this.openid = openid;
        this.accountMoney = accountMoney;
        this.isStart = isStart;
        this.accountId = accountId;
        this.accountTime = accountTime;
        this.createTime = createTime;
        this.createUser = createUser;
        this.isFreeze = isFreeze;
    }
    /**
     * id
     * tbl_amount_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_amount_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 用户名称
     * tbl_amount_info.user_name
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 用户名称
     * tbl_amount_info.user_name
     */
    public void setUserName(String userName){
        this.userName=userName;
    }

    /**
     * openid
     * tbl_amount_info.openid
     */
    public String getOpenid(){
        return openid;
    }

    /**
     * openid
     * tbl_amount_info.openid
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }

    /**
     * 账户金额
     * tbl_amount_info.account_money
     */
    public String getAccountMoney(){
        return accountMoney;
    }

    /**
     * 账户金额
     * tbl_amount_info.account_money
     */
    public void setAccountMoney(String accountMoney){
        this.accountMoney=accountMoney;
    }

    /**
     * 是否启用
     * tbl_amount_info.is_start
     */
    public String getIsStart(){
        return isStart;
    }

    /**
     * 是否启用
     * tbl_amount_info.is_start
     */
    public void setIsStart(String isStart){
        this.isStart=isStart;
    }

    /**
     * 账户ID
     * tbl_amount_info.account_id
     */
    public String getAccountId(){
        return accountId;
    }

    /**
     * 账户ID
     * tbl_amount_info.account_id
     */
    public void setAccountId(String accountId){
        this.accountId=accountId;
    }

    /**
     * 账户创建时间
     * tbl_amount_info.account_time
     */
    public String getAccountTime(){
        return accountTime;
    }

    /**
     * 账户创建时间
     * tbl_amount_info.account_time
     */
    public void setAccountTime(String accountTime){
        this.accountTime=accountTime;
    }

    /**
     * 创建时间
     * tbl_amount_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_amount_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_amount_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_amount_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 是否冻结
     * tbl_amount_info.is_freeze
     */
    public String getIsFreeze(){
        return isFreeze;
    }

    /**
     * 是否冻结
     * tbl_amount_info.is_freeze
     */
    public void setIsFreeze(String isFreeze){
        this.isFreeze=isFreeze;
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

