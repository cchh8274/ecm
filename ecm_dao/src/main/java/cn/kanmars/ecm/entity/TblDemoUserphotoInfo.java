/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 用户照片表
 * tbl_demo_userphoto_info
 */
public class TblDemoUserphotoInfo implements java.io.Serializable{
    /**
     * 编号
     * tbl_demo_userphoto_info.id
     */
    private Long id;

    /**
     * 用户名称
     * tbl_demo_userphoto_info.user_nm
     */
    private String userNm;

    /**
     * 照片
     * tbl_demo_userphoto_info.photo
     */
    private Long photo;


    public TblDemoUserphotoInfo(){super();}
    public TblDemoUserphotoInfo(Long id,String userNm,Long photo) {
        this.id = id;
        this.userNm = userNm;
        this.photo = photo;
    }
    /**
     * 编号
     * tbl_demo_userphoto_info.id
     */
    public Long getId(){
        return id;
    }

    /**
     * 编号
     * tbl_demo_userphoto_info.id
     */
    public void setId(Long id){
        this.id=id;
    }

    /**
     * 用户名称
     * tbl_demo_userphoto_info.user_nm
     */
    public String getUserNm(){
        return userNm;
    }

    /**
     * 用户名称
     * tbl_demo_userphoto_info.user_nm
     */
    public void setUserNm(String userNm){
        this.userNm=userNm;
    }

    /**
     * 照片
     * tbl_demo_userphoto_info.photo
     */
    public Long getPhoto(){
        return photo;
    }

    /**
     * 照片
     * tbl_demo_userphoto_info.photo
     */
    public void setPhoto(Long photo){
        this.photo=photo;
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

