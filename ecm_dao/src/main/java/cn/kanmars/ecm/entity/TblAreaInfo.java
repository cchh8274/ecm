/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 区域表
 * tbl_area_info
 */
public class TblAreaInfo implements java.io.Serializable{
    /**
     * id
     * tbl_area_info.id
     */
    private Integer id;

    /**
     * 区域名称
     * tbl_area_info.area_name
     */
    private String areaName;

    /**
     * 状态
     * tbl_area_info.status
     */
    private String status;

    /**
     * 启用等级
     * tbl_area_info.enable_levl
     */
    private String enableLevl;

    /**
     * 页面启用状态
     * tbl_area_info.page_status
     */
    private String pageStatus;

    /**
     * 创建时间
     * tbl_area_info.create_time
     */
    private String createTime;

    /**
     * 创建人
     * tbl_area_info.create_user
     */
    private String createUser;

    /**
     * 修改时间
     * tbl_area_info.update_time
     */
    private String updateTime;

    /**
     * 修改人
     * tbl_area_info.up_user
     */
    private String upUser;


    public TblAreaInfo(){super();}
    public TblAreaInfo(Integer id,String areaName,String status,String enableLevl,String pageStatus,String createTime,String createUser,String updateTime,String upUser) {
        this.id = id;
        this.areaName = areaName;
        this.status = status;
        this.enableLevl = enableLevl;
        this.pageStatus = pageStatus;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.upUser = upUser;
    }
    /**
     * id
     * tbl_area_info.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * id
     * tbl_area_info.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 区域名称
     * tbl_area_info.area_name
     */
    public String getAreaName(){
        return areaName;
    }

    /**
     * 区域名称
     * tbl_area_info.area_name
     */
    public void setAreaName(String areaName){
        this.areaName=areaName;
    }

    /**
     * 状态
     * tbl_area_info.status
     */
    public String getStatus(){
        return status;
    }

    /**
     * 状态
     * tbl_area_info.status
     */
    public void setStatus(String status){
        this.status=status;
    }

    /**
     * 启用等级
     * tbl_area_info.enable_levl
     */
    public String getEnableLevl(){
        return enableLevl;
    }

    /**
     * 启用等级
     * tbl_area_info.enable_levl
     */
    public void setEnableLevl(String enableLevl){
        this.enableLevl=enableLevl;
    }

    /**
     * 页面启用状态
     * tbl_area_info.page_status
     */
    public String getPageStatus(){
        return pageStatus;
    }

    /**
     * 页面启用状态
     * tbl_area_info.page_status
     */
    public void setPageStatus(String pageStatus){
        this.pageStatus=pageStatus;
    }

    /**
     * 创建时间
     * tbl_area_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_area_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 创建人
     * tbl_area_info.create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * 创建人
     * tbl_area_info.create_user
     */
    public void setCreateUser(String createUser){
        this.createUser=createUser;
    }

    /**
     * 修改时间
     * tbl_area_info.update_time
     */
    public String getUpdateTime(){
        return updateTime;
    }

    /**
     * 修改时间
     * tbl_area_info.update_time
     */
    public void setUpdateTime(String updateTime){
        this.updateTime=updateTime;
    }

    /**
     * 修改人
     * tbl_area_info.up_user
     */
    public String getUpUser(){
        return upUser;
    }

    /**
     * 修改人
     * tbl_area_info.up_user
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

