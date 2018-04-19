/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 账户明细表
 * tbl_amount_detail
 */
public class TblAmountDetail implements java.io.Serializable{
    /**
     * id
     * tbl_amount_detail.id
     */
    private Integer id;

    /**
     * 账户ID
     * tbl_amount_detail.account_id
     */
    private String accountId;

    /**
     * 大学名称
     * tbl_amount_detail.unversity_name
     */
    private String unversityName;

    /**
     * 大学ID
     * tbl_amount_detail.unversity_id
     */
    private String unversityId;

    /**
     * 月份收益
     * tbl_amount_detail.earning_month
     */
    private String earningMonth;

    /**
     * 区域ID
     * tbl_amount_detail.area_id
     */
    private String areaId;

    /**
     * 区域名称
     * tbl_amount_detail.area_name
     */
    private String areaName;

    /**
     * 是否冻结
     * tbl_amount_detail.is_freeze
     */
    private String isFreeze;

    /**
     * 收益类型
     * tbl_amount_detail.earning_type
     */
    private String earningType;

    /**
     * 收益金额
     * tbl_amount_detail.earnings_money
     */
    private String earningsMoney;

    /**
     * 创建时间
     * tbl_amount_detail.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_amount_detail.create_user
     */
    private String createUser;


    public TblAmountDetail(){super();}
    public TblAmountDetail(Integer id,String accountId,String unversityName,String unversityId,String earningMonth,String areaId,String areaName,String isFreeze,String earningType,String earningsMoney,String createTime,String createUser) {
        this.id = id;
        this.accountId = accountId;
        this.unversityName = unversityName;
        this.unversityId = unversityId;
        this.earningMonth = earningMonth;
        this.areaId = areaId;
        this.areaName = areaName;
        this.isFreeze = isFreeze;
        this.earningType = earningType;
        this.earningsMoney = earningsMoney;
        this.createTime = createTime;
        this.createUser = createUser;
    }
    /**
     * id
     * tbl_amount_detail.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_amount_detail.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 账户ID
     * tbl_amount_detail.account_id
     */
    public String getAccountId(){
        return accountId;
    }

    /**
     * 账户ID
     * tbl_amount_detail.account_id
     */
    public void setAccountId(String accountId){
        this.accountId=accountId;
    }

    /**
     * 大学名称
     * tbl_amount_detail.unversity_name
     */
    public String getUnversityName(){
        return unversityName;
    }

    /**
     * 大学名称
     * tbl_amount_detail.unversity_name
     */
    public void setUnversityName(String unversityName){
        this.unversityName=unversityName;
    }

    /**
     * 大学ID
     * tbl_amount_detail.unversity_id
     */
    public String getUnversityId(){
        return unversityId;
    }

    /**
     * 大学ID
     * tbl_amount_detail.unversity_id
     */
    public void setUnversityId(String unversityId){
        this.unversityId=unversityId;
    }

    /**
     * 月份收益
     * tbl_amount_detail.earning_month
     */
    public String getEarningMonth(){
        return earningMonth;
    }

    /**
     * 月份收益
     * tbl_amount_detail.earning_month
     */
    public void setEarningMonth(String earningMonth){
        this.earningMonth=earningMonth;
    }

    /**
     * 区域ID
     * tbl_amount_detail.area_id
     */
    public String getAreaId(){
        return areaId;
    }

    /**
     * 区域ID
     * tbl_amount_detail.area_id
     */
    public void setAreaId(String areaId){
        this.areaId=areaId;
    }

    /**
     * 区域名称
     * tbl_amount_detail.area_name
     */
    public String getAreaName(){
        return areaName;
    }

    /**
     * 区域名称
     * tbl_amount_detail.area_name
     */
    public void setAreaName(String areaName){
        this.areaName=areaName;
    }

    /**
     * 是否冻结
     * tbl_amount_detail.is_freeze
     */
    public String getIsFreeze(){
        return isFreeze;
    }

    /**
     * 是否冻结
     * tbl_amount_detail.is_freeze
     */
    public void setIsFreeze(String isFreeze){
        this.isFreeze=isFreeze;
    }

    /**
     * 收益类型
     * tbl_amount_detail.earning_type
     */
    public String getEarningType(){
        return earningType;
    }

    /**
     * 收益类型
     * tbl_amount_detail.earning_type
     */
    public void setEarningType(String earningType){
        this.earningType=earningType;
    }

    /**
     * 收益金额
     * tbl_amount_detail.earnings_money
     */
    public String getEarningsMoney(){
        return earningsMoney;
    }

    /**
     * 收益金额
     * tbl_amount_detail.earnings_money
     */
    public void setEarningsMoney(String earningsMoney){
        this.earningsMoney=earningsMoney;
    }

    /**
     * 创建时间
     * tbl_amount_detail.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_amount_detail.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_amount_detail.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_amount_detail.create_user
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

