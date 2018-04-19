/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 用户咖啡机表
 * tbl_machine_gather_info
 */
public class TblMachineGatherInfo implements java.io.Serializable{
    /**
     * id
     * tbl_machine_gather_info.id
     */
    private Integer id;

    /**
     * openid
     * tbl_machine_gather_info.openid
     */
    private String openid;

    /**
     * 用户名称
     * tbl_machine_gather_info.wx_user_name
     */
    private String wxUserName;

    /**
     * 区域名称
     * tbl_machine_gather_info.area_id
     */
    private String areaId;

    /**
     * 区域ID
     * tbl_machine_gather_info.are_id
     */
    private String areId;

    /**
     * 大学名称
     * tbl_machine_gather_info.unversity_name
     */
    private String unversityName;

    /**
     * 大学ID
     * tbl_machine_gather_info.unversity_id
     */
    private String unversityId;

    /**
     * 购买金额
     * tbl_machine_gather_info.price
     */
    private String price;

    /**
     * 购买数量
     * tbl_machine_gather_info.number
     */
    private String number;

    /**
     * 购买时间
     * tbl_machine_gather_info.pay_time
     */
    private String payTime;

    /**
     * 创建时间
     * tbl_machine_gather_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_machine_gather_info.create_user
     */
    private String createUser;

    /**
     * 修改时间
     * tbl_machine_gather_info.update_time
     */
    private String updateTime;

    /**
     * 修改人
     * tbl_machine_gather_info.update_user
     */
    private String updateUser;


    public TblMachineGatherInfo(){super();}
    public TblMachineGatherInfo(Integer id,String openid,String wxUserName,String areaId,String areId,String unversityName,String unversityId,String price,String number,String payTime,String createTime,String createUser,String updateTime,String updateUser) {
        this.id = id;
        this.openid = openid;
        this.wxUserName = wxUserName;
        this.areaId = areaId;
        this.areId = areId;
        this.unversityName = unversityName;
        this.unversityId = unversityId;
        this.price = price;
        this.number = number;
        this.payTime = payTime;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }
    /**
     * id
     * tbl_machine_gather_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_machine_gather_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * openid
     * tbl_machine_gather_info.openid
     */
    public String getOpenid(){
        return openid;
    }

    /**
     * openid
     * tbl_machine_gather_info.openid
     */
    public void setOpenid(String openid){
        this.openid=openid;
    }

    /**
     * 用户名称
     * tbl_machine_gather_info.wx_user_name
     */
    public String getWxUserName(){
        return wxUserName;
    }

    /**
     * 用户名称
     * tbl_machine_gather_info.wx_user_name
     */
    public void setWxUserName(String wxUserName){
        this.wxUserName=wxUserName;
    }

    /**
     * 区域名称
     * tbl_machine_gather_info.area_id
     */
    public String getAreaId(){
        return areaId;
    }

    /**
     * 区域名称
     * tbl_machine_gather_info.area_id
     */
    public void setAreaId(String areaId){
        this.areaId=areaId;
    }

    /**
     * 区域ID
     * tbl_machine_gather_info.are_id
     */
    public String getAreId(){
        return areId;
    }

    /**
     * 区域ID
     * tbl_machine_gather_info.are_id
     */
    public void setAreId(String areId){
        this.areId=areId;
    }

    /**
     * 大学名称
     * tbl_machine_gather_info.unversity_name
     */
    public String getUnversityName(){
        return unversityName;
    }

    /**
     * 大学名称
     * tbl_machine_gather_info.unversity_name
     */
    public void setUnversityName(String unversityName){
        this.unversityName=unversityName;
    }

    /**
     * 大学ID
     * tbl_machine_gather_info.unversity_id
     */
    public String getUnversityId(){
        return unversityId;
    }

    /**
     * 大学ID
     * tbl_machine_gather_info.unversity_id
     */
    public void setUnversityId(String unversityId){
        this.unversityId=unversityId;
    }

    /**
     * 购买金额
     * tbl_machine_gather_info.price
     */
    public String getPrice(){
        return price;
    }

    /**
     * 购买金额
     * tbl_machine_gather_info.price
     */
    public void setPrice(String price){
        this.price=price;
    }

    /**
     * 购买数量
     * tbl_machine_gather_info.number
     */
    public String getNumber(){
        return number;
    }

    /**
     * 购买数量
     * tbl_machine_gather_info.number
     */
    public void setNumber(String number){
        this.number=number;
    }

    /**
     * 购买时间
     * tbl_machine_gather_info.pay_time
     */
    public String getPayTime(){
        return payTime;
    }

    /**
     * 购买时间
     * tbl_machine_gather_info.pay_time
     */
    public void setPayTime(String payTime){
        this.payTime=payTime;
    }

    /**
     * 创建时间
     * tbl_machine_gather_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_machine_gather_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_machine_gather_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_machine_gather_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 修改时间
     * tbl_machine_gather_info.update_time
     */
    public String getUpdateTime(){
        return updateTime;
    }

    /**
     * 修改时间
     * tbl_machine_gather_info.update_time
     */
    public void setUpdateTime(String updateTime){
        this.updateTime=updateTime;
    }

    /**
     * 修改人
     * tbl_machine_gather_info.update_user
     */
    public String getUpdateUser(){
        return updateUser;
    }

    /**
     * 修改人
     * tbl_machine_gather_info.update_user
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

