/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 大学表
 * tbl_university_info
 */
public class TblUniversityInfo implements java.io.Serializable{
    /**
     * ID
     * tbl_university_info.id
     */
    private Integer id;

    /**
     * 大学名称
     * tbl_university_info.univer_name
     */
    private String univerName;

    /**
     * 区域名称
     * tbl_university_info.area_name
     */
    private String areaName;

    /**
     * 区域ID
     * tbl_university_info.area_id
     */
    private String areaId;

    /**
     * 点的位置
     * tbl_university_info.location
     */
    private String location;

    /**
     * 创建时间
     * tbl_university_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_university_info.create_user
     */
    private String createUser;

    /**
     * 修改时间
     * tbl_university_info.up_time
     */
    private String upTime;

    /**
     * 修改人
     * tbl_university_info.up_user
     */
    private String upUser;


    public TblUniversityInfo(){super();}
    public TblUniversityInfo(Integer id,String univerName,String areaName,String areaId,String location,String createTime,String createUser,String upTime,String upUser) {
        this.id = id;
        this.univerName = univerName;
        this.areaName = areaName;
        this.areaId = areaId;
        this.location = location;
        this.createTime = createTime;
        this.createUser = createUser;
        this.upTime = upTime;
        this.upUser = upUser;
    }
    /**
     * ID
     * tbl_university_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * ID
     * tbl_university_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 大学名称
     * tbl_university_info.univer_name
     */
    public String getUniverName(){
        return univerName;
    }

    /**
     * 大学名称
     * tbl_university_info.univer_name
     */
    public void setUniverName(String univerName){
        this.univerName=univerName;
    }

    /**
     * 区域名称
     * tbl_university_info.area_name
     */
    public String getAreaName(){
        return areaName;
    }

    /**
     * 区域名称
     * tbl_university_info.area_name
     */
    public void setAreaName(String areaName){
        this.areaName=areaName;
    }

    /**
     * 区域ID
     * tbl_university_info.area_id
     */
    public String getAreaId(){
        return areaId;
    }

    /**
     * 区域ID
     * tbl_university_info.area_id
     */
    public void setAreaId(String areaId){
        this.areaId=areaId;
    }

    /**
     * 点的位置
     * tbl_university_info.location
     */
    public String getLocation(){
        return location;
    }

    /**
     * 点的位置
     * tbl_university_info.location
     */
    public void setLocation(String location){
        this.location=location;
    }

    /**
     * 创建时间
     * tbl_university_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_university_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_university_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_university_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 修改时间
     * tbl_university_info.up_time
     */
    public String getUpTime(){
        return upTime;
    }

    /**
     * 修改时间
     * tbl_university_info.up_time
     */
    public void setUpTime(String upTime){
        this.upTime=upTime;
    }

    /**
     * 修改人
     * tbl_university_info.up_user
     */
    public String getUpUser(){
        return upUser;
    }

    /**
     * 修改人
     * tbl_university_info.up_user
     */
    public void setUpUser(String upUser){
        this.upUser=upUser;
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

