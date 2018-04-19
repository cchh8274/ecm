/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 银行账户表
 * tbl_bankamount_info
 */
public class TblBankamountInfo implements java.io.Serializable{
    /**
     * id
     * tbl_bankamount_info.id
     */
    private Integer id;

    /**
     * 用户名称
     * tbl_bankamount_info.user_name
     */
    private String userName;

    /**
     * 身份证号
     * tbl_bankamount_info.idcard
     */
    private String idcard;

    /**
     * 电话
     * tbl_bankamount_info.phone
     */
    private String phone;

    /**
     * 微信用户名称
     * tbl_bankamount_info.wx_name
     */
    private String wxName;

    /**
     * openid
     * tbl_bankamount_info.openid
     */
    private String openid;

    /**
     * 银行账户
     * tbl_bankamount_info.bank_amount_no
     */
    private String bankAmountNo;

    /**
     * 银行名称
     * tbl_bankamount_info.bank_name
     */
    private String bankName;

    /**
     * 开户地址
     * tbl_bankamount_info.bank_adress
     */
    private String bankAdress;

    /**
     * 创建时间
     * tbl_bankamount_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_bankamount_info.create_user
     */
    private String createUser;

    /**
     * 修改时间
     * tbl_bankamount_info.update_time
     */
    private String updateTime;

    /**
     * 修改人
     * tbl_bankamount_info.update_user
     */
    private String updateUser;


    public TblBankamountInfo(){super();}
    public TblBankamountInfo(Integer id,String userName,String idcard,String phone,String wxName,String openid,String bankAmountNo,String bankName,String bankAdress,String createTime,String createUser,String updateTime,String updateUser) {
        this.id = id;
        this.userName = userName;
        this.idcard = idcard;
        this.phone = phone;
        this.wxName = wxName;
        this.openid = openid;
        this.bankAmountNo = bankAmountNo;
        this.bankName = bankName;
        this.bankAdress = bankAdress;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }
    /**
     * id
     * tbl_bankamount_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_bankamount_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 用户名称
     * tbl_bankamount_info.user_name
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 用户名称
     * tbl_bankamount_info.user_name
     */
    public void setUserName(String userName){
        this.userName=userName;
    }

    /**
     * 身份证号
     * tbl_bankamount_info.idcard
     */
    public String getIdcard(){
        return idcard;
    }

    /**
     * 身份证号
     * tbl_bankamount_info.idcard
     */
    public void setIdcard(String idcard){
        this.idcard=idcard;
    }

    /**
     * 电话
     * tbl_bankamount_info.phone
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 电话
     * tbl_bankamount_info.phone
     */
    public void setPhone(String phone){
        this.phone=phone;
    }

    /**
     * 微信用户名称
     * tbl_bankamount_info.wx_name
     */
    public String getWxName(){
        return wxName;
    }

    /**
     * 微信用户名称
     * tbl_bankamount_info.wx_name
     */
    public void setWxName(String wxName){
        this.wxName=wxName;
    }

    /**
     * openid
     * tbl_bankamount_info.openid
     */
    public String getOpenid(){
        return openid;
    }

    /**
     * openid
     * tbl_bankamount_info.openid
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }

    /**
     * 银行账户
     * tbl_bankamount_info.bank_amount_no
     */
    public String getBankAmountNo(){
        return bankAmountNo;
    }

    /**
     * 银行账户
     * tbl_bankamount_info.bank_amount_no
     */
    public void setBankAmountNo(String bankAmountNo){
        this.bankAmountNo=bankAmountNo;
    }

    /**
     * 银行名称
     * tbl_bankamount_info.bank_name
     */
    public String getBankName(){
        return bankName;
    }

    /**
     * 银行名称
     * tbl_bankamount_info.bank_name
     */
    public void setBankName(String bankName){
        this.bankName=bankName;
    }

    /**
     * 开户地址
     * tbl_bankamount_info.bank_adress
     */
    public String getBankAdress(){
        return bankAdress;
    }

    /**
     * 开户地址
     * tbl_bankamount_info.bank_adress
     */
    public void setBankAdress(String bankAdress){
        this.bankAdress=bankAdress;
    }

    /**
     * 创建时间
     * tbl_bankamount_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_bankamount_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_bankamount_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_bankamount_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 修改时间
     * tbl_bankamount_info.update_time
     */
    public String getUpdateTime(){
        return updateTime;
    }

    /**
     * 修改时间
     * tbl_bankamount_info.update_time
     */
    public void setUpdateTime(String updateTime){
        this.updateTime=updateTime;
    }

    /**
     * 修改人
     * tbl_bankamount_info.update_user
     */
    public String getUpdateUser(){
        return updateUser;
    }

    /**
     * 修改人
     * tbl_bankamount_info.update_user
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

