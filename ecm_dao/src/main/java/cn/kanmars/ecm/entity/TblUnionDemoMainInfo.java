/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 联表查询DEMO-主表
 * tbl_union_demo_main_info
 */
public class TblUnionDemoMainInfo implements java.io.Serializable{
    /**
     * 表ID
     * tbl_union_demo_main_info.demo_id
     */
    private Long demoId;

    /**
     * 表ID
     * tbl_union_demo_main_info.forgien_id
     */
    private Long forgienId;

    /**
     * 演示名称
     * tbl_union_demo_main_info.demo_nm
     */
    private String demoNm;

    /**
     * 创建时间
     * tbl_union_demo_main_info.create_time
     */
    private String createTime;

    /**
     * 整数
     * tbl_union_demo_main_info.count_number
     */
    private Integer countNumber;

    /**
     * 演示金额
     * tbl_union_demo_main_info.demo_money
     */
    private Integer demoMoney;

    /**
     * 静态选择框
     * tbl_union_demo_main_info.select_static
     */
    private String selectStatic;

    /**
     * 动态选择框
     * tbl_union_demo_main_info.select_dynamic
     */
    private String selectDynamic;

    /**
     * 静态单选按钮
     * tbl_union_demo_main_info.radio_static
     */
    private String radioStatic;

    /**
     * 动态单选按钮
     * tbl_union_demo_main_info.radio_dynamic
     */
    private String radioDynamic;

    /**
     * 静态复选框
     * tbl_union_demo_main_info.checkbox_static
     */
    private String checkboxStatic;

    /**
     * 动态复选框
     * tbl_union_demo_main_info.checkbox_dynamic
     */
    private String checkboxDynamic;

    /**
     * 创建日期
     * tbl_union_demo_main_info.create_date
     */
    private String createDate;


    public TblUnionDemoMainInfo(){super();}
    public TblUnionDemoMainInfo(Long demoId,Long forgienId,String demoNm,String createTime,Integer countNumber,Integer demoMoney,String selectStatic,String selectDynamic,String radioStatic,String radioDynamic,String checkboxStatic,String checkboxDynamic,String createDate) {
        this.demoId = demoId;
        this.forgienId = forgienId;
        this.demoNm = demoNm;
        this.createTime = createTime;
        this.countNumber = countNumber;
        this.demoMoney = demoMoney;
        this.selectStatic = selectStatic;
        this.selectDynamic = selectDynamic;
        this.radioStatic = radioStatic;
        this.radioDynamic = radioDynamic;
        this.checkboxStatic = checkboxStatic;
        this.checkboxDynamic = checkboxDynamic;
        this.createDate = createDate;
    }
    /**
     * 表ID
     * tbl_union_demo_main_info.demo_id
     */
    public Long getDemoId(){
        return demoId;
    }

    /**
     * 表ID
     * tbl_union_demo_main_info.demo_id
     */
    public void setDemoId(Long demoId){
        this.demoId=demoId;
    }

    /**
     * 表ID
     * tbl_union_demo_main_info.forgien_id
     */
    public Long getForgienId(){
        return forgienId;
    }

    /**
     * 表ID
     * tbl_union_demo_main_info.forgien_id
     */
    public void setForgienId(Long forgienId){
        this.forgienId=forgienId;
    }

    /**
     * 演示名称
     * tbl_union_demo_main_info.demo_nm
     */
    public String getDemoNm(){
        return demoNm;
    }

    /**
     * 演示名称
     * tbl_union_demo_main_info.demo_nm
     */
    public void setDemoNm(String demoNm){
        this.demoNm=demoNm;
    }

    /**
     * 创建时间
     * tbl_union_demo_main_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_union_demo_main_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 整数
     * tbl_union_demo_main_info.count_number
     */
    public Integer getCountNumber(){
        return countNumber;
    }

    /**
     * 整数
     * tbl_union_demo_main_info.count_number
     */
    public void setCountNumber(Integer countNumber){
        this.countNumber=countNumber;
    }

    /**
     * 演示金额
     * tbl_union_demo_main_info.demo_money
     */
    public Integer getDemoMoney(){
        return demoMoney;
    }

    /**
     * 演示金额
     * tbl_union_demo_main_info.demo_money
     */
    public void setDemoMoney(Integer demoMoney){
        this.demoMoney=demoMoney;
    }

    /**
     * 静态选择框
     * tbl_union_demo_main_info.select_static
     */
    public String getSelectStatic(){
        return selectStatic;
    }

    /**
     * 静态选择框
     * tbl_union_demo_main_info.select_static
     */
    public void setSelectStatic(String selectStatic){
        this.selectStatic=selectStatic;
    }

    /**
     * 动态选择框
     * tbl_union_demo_main_info.select_dynamic
     */
    public String getSelectDynamic(){
        return selectDynamic;
    }

    /**
     * 动态选择框
     * tbl_union_demo_main_info.select_dynamic
     */
    public void setSelectDynamic(String selectDynamic){
        this.selectDynamic=selectDynamic;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_main_info.radio_static
     */
    public String getRadioStatic(){
        return radioStatic;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_main_info.radio_static
     */
    public void setRadioStatic(String radioStatic){
        this.radioStatic=radioStatic;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_main_info.radio_dynamic
     */
    public String getRadioDynamic(){
        return radioDynamic;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_main_info.radio_dynamic
     */
    public void setRadioDynamic(String radioDynamic){
        this.radioDynamic=radioDynamic;
    }

    /**
     * 静态复选框
     * tbl_union_demo_main_info.checkbox_static
     */
    public String getCheckboxStatic(){
        return checkboxStatic;
    }

    /**
     * 静态复选框
     * tbl_union_demo_main_info.checkbox_static
     */
    public void setCheckboxStatic(String checkboxStatic){
        this.checkboxStatic=checkboxStatic;
    }

    /**
     * 动态复选框
     * tbl_union_demo_main_info.checkbox_dynamic
     */
    public String getCheckboxDynamic(){
        return checkboxDynamic;
    }

    /**
     * 动态复选框
     * tbl_union_demo_main_info.checkbox_dynamic
     */
    public void setCheckboxDynamic(String checkboxDynamic){
        this.checkboxDynamic=checkboxDynamic;
    }

    /**
     * 创建日期
     * tbl_union_demo_main_info.create_date
     */
    public String getCreateDate(){
        return createDate;
    }

    /**
     * 创建日期
     * tbl_union_demo_main_info.create_date
     */
    public void setCreateDate(String createDate){
        this.createDate=createDate;
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

