/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 机器信息表
 * tbl_machine_info
 */
public class TblMachineInfo implements java.io.Serializable{
    /**
     * id
     * tbl_machine_info.id
     */
    private String id;

    /**
     * 机器名称
     * tbl_machine_info.machine_name
     */
    private String machineName;

    /**
     * 投放位置
     * tbl_machine_info.adress
     */
    private String adress;

    /**
     * 是否使用
     * tbl_machine_info.is_use
     */
    private String isUse;

    /**
     * 单个名额价格
     * tbl_machine_info.price
     */
    private String price;

    /**
     * 总名额
     * tbl_machine_info.total_places
     */
    private String totalPlaces;

    /**
     * 剩余名额
     * tbl_machine_info.left_place
     */
    private String leftPlace;

    /**
     * 已售名额
     * tbl_machine_info.out_sale_place
     */
    private String outSalePlace;

    /**
     * 创建时间
     * tbl_machine_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_machine_info.create_user
     */
    private String createUser;

    /**
     * 修改时间
     * tbl_machine_info.update_time
     */
    private String updateTime;

    /**
     * 修改人
     * tbl_machine_info.update_user
     */
    private String updateUser;


    public TblMachineInfo(){super();}
    public TblMachineInfo(String id,String machineName,String adress,String isUse,String price,String totalPlaces,String leftPlace,String outSalePlace,String createTime,String createUser,String updateTime,String updateUser) {
        this.id = id;
        this.machineName = machineName;
        this.adress = adress;
        this.isUse = isUse;
        this.price = price;
        this.totalPlaces = totalPlaces;
        this.leftPlace = leftPlace;
        this.outSalePlace = outSalePlace;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }
    /**
     * id
     * tbl_machine_info.id
     */
    public String getId(){
        return id;
    }

    /**
     * id
     * tbl_machine_info.id
     */
    public void setId(String id){
        this.id=id;
    }

    /**
     * 机器名称
     * tbl_machine_info.machine_name
     */
    public String getMachineName(){
        return machineName;
    }

    /**
     * 机器名称
     * tbl_machine_info.machine_name
     */
    public void setMachineName(String machineName){
        this.machineName=machineName;
    }

    /**
     * 投放位置
     * tbl_machine_info.adress
     */
    public String getAdress(){
        return adress;
    }

    /**
     * 投放位置
     * tbl_machine_info.adress
     */
    public void setAdress(String adress){
        this.adress=adress;
    }

    /**
     * 是否使用
     * tbl_machine_info.is_use
     */
    public String getIsUse(){
        return isUse;
    }

    /**
     * 是否使用
     * tbl_machine_info.is_use
     */
    public void setIsUse(String isUse){
        this.isUse=isUse;
    }

    /**
     * 单个名额价格
     * tbl_machine_info.price
     */
    public String getPrice(){
        return price;
    }

    /**
     * 单个名额价格
     * tbl_machine_info.price
     */
    public void setPrice(String price){
        this.price=price;
    }

    /**
     * 总名额
     * tbl_machine_info.total_places
     */
    public String getTotalPlaces(){
        return totalPlaces;
    }

    /**
     * 总名额
     * tbl_machine_info.total_places
     */
    public void setTotalPlaces(String totalPlaces){
        this.totalPlaces=totalPlaces;
    }

    /**
     * 剩余名额
     * tbl_machine_info.left_place
     */
    public String getLeftPlace(){
        return leftPlace;
    }

    /**
     * 剩余名额
     * tbl_machine_info.left_place
     */
    public void setLeftPlace(String leftPlace){
        this.leftPlace=leftPlace;
    }

    /**
     * 已售名额
     * tbl_machine_info.out_sale_place
     */
    public String getOutSalePlace(){
        return outSalePlace;
    }

    /**
     * 已售名额
     * tbl_machine_info.out_sale_place
     */
    public void setOutSalePlace(String outSalePlace){
        this.outSalePlace=outSalePlace;
    }

    /**
     * 创建时间
     * tbl_machine_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_machine_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_machine_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_machine_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 修改时间
     * tbl_machine_info.update_time
     */
    public String getUpdateTime(){
        return updateTime;
    }

    /**
     * 修改时间
     * tbl_machine_info.update_time
     */
    public void setUpdateTime(String updateTime){
        this.updateTime=updateTime;
    }

    /**
     * 修改人
     * tbl_machine_info.update_user
     */
    public String getUpdateUser(){
        return updateUser;
    }

    /**
     * 修改人
     * tbl_machine_info.update_user
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

