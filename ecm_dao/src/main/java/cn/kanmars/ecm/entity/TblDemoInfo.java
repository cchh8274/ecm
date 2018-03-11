/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * DEMO表
 * tbl_demo_info
 */
public class TblDemoInfo implements java.io.Serializable{
    /**
     * 表ID
     * tbl_demo_info.demo_id
     */
    private Integer demoId;

    /**
     * 演示名称
     * tbl_demo_info.demo_nm
     */
    private String demoNm;

    /**
     * 演示金额
     * tbl_demo_info.demo_money
     */
    private java.math.BigDecimal demoMoney;

    /**
     * 创建日期
     * tbl_demo_info.create_date
     */
    private String createDate;

    /**
     * 创建时间
     * tbl_demo_info.create_time
     */
    private String createTime;

    /**
     * 静态选择框
     * tbl_demo_info.select_static
     */
    private String selectStatic;

    /**
     * 动态选择框
     * tbl_demo_info.select_dynamic
     */
    private String selectDynamic;

    /**
     * 静态单选按钮
     * tbl_demo_info.radio_static
     */
    private String radioStatic;

    /**
     * 动态单选按钮
     * tbl_demo_info.radio_dynamic
     */
    private String radioDynamic;

    /**
     * 静态复选框
     * tbl_demo_info.checkbox_static
     */
    private String checkboxStatic;

    /**
     * 动态复选框
     * tbl_demo_info.checkbox_dynamic
     */
    private String checkboxDynamic;

    /**
     * 网址
     * tbl_demo_info.net_address
     */
    private String netAddress;

    /**
     * 整数
     * tbl_demo_info.count_number
     */
    private Integer countNumber;


    public TblDemoInfo(){super();}
    public TblDemoInfo(Integer demoId,String demoNm,java.math.BigDecimal demoMoney,String createDate,String createTime,String selectStatic,String selectDynamic,String radioStatic,String radioDynamic,String checkboxStatic,String checkboxDynamic,String netAddress,Integer countNumber) {
        this.demoId = demoId;
        this.demoNm = demoNm;
        this.demoMoney = demoMoney;
        this.createDate = createDate;
        this.createTime = createTime;
        this.selectStatic = selectStatic;
        this.selectDynamic = selectDynamic;
        this.radioStatic = radioStatic;
        this.radioDynamic = radioDynamic;
        this.checkboxStatic = checkboxStatic;
        this.checkboxDynamic = checkboxDynamic;
        this.netAddress = netAddress;
        this.countNumber = countNumber;
    }
    /**
     * 表ID
     * tbl_demo_info.demo_id
     */
    public Integer getDemoId(){
        return demoId;
    }

    /**
     * 表ID
     * tbl_demo_info.demo_id
     */
    public void setDemoId(Integer demoId){
        this.demoId=demoId;
    }

    /**
     * 演示名称
     * tbl_demo_info.demo_nm
     */
    public String getDemoNm(){
        return demoNm;
    }

    /**
     * 演示名称
     * tbl_demo_info.demo_nm
     */
    public void setDemoNm(String demoNm){
        this.demoNm=demoNm;
    }

    /**
     * 演示金额
     * tbl_demo_info.demo_money
     */
    public java.math.BigDecimal getDemoMoney(){
        return demoMoney;
    }

    /**
     * 演示金额
     * tbl_demo_info.demo_money
     */
    public void setDemoMoney(java.math.BigDecimal demoMoney){
        this.demoMoney=demoMoney;
    }

    /**
     * 创建日期
     * tbl_demo_info.create_date
     */
    public String getCreateDate(){
        return createDate;
    }

    /**
     * 创建日期
     * tbl_demo_info.create_date
     */
    public void setCreateDate(String createDate){
        this.createDate=createDate;
    }

    /**
     * 创建时间
     * tbl_demo_info.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 创建时间
     * tbl_demo_info.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 静态选择框
     * tbl_demo_info.select_static
     */
    public String getSelectStatic(){
        return selectStatic;
    }

    /**
     * 静态选择框
     * tbl_demo_info.select_static
     */
    public void setSelectStatic(String selectStatic){
        this.selectStatic=selectStatic;
    }

    /**
     * 动态选择框
     * tbl_demo_info.select_dynamic
     */
    public String getSelectDynamic(){
        return selectDynamic;
    }

    /**
     * 动态选择框
     * tbl_demo_info.select_dynamic
     */
    public void setSelectDynamic(String selectDynamic){
        this.selectDynamic=selectDynamic;
    }

    /**
     * 静态单选按钮
     * tbl_demo_info.radio_static
     */
    public String getRadioStatic(){
        return radioStatic;
    }

    /**
     * 静态单选按钮
     * tbl_demo_info.radio_static
     */
    public void setRadioStatic(String radioStatic){
        this.radioStatic=radioStatic;
    }

    /**
     * 动态单选按钮
     * tbl_demo_info.radio_dynamic
     */
    public String getRadioDynamic(){
        return radioDynamic;
    }

    /**
     * 动态单选按钮
     * tbl_demo_info.radio_dynamic
     */
    public void setRadioDynamic(String radioDynamic){
        this.radioDynamic=radioDynamic;
    }

    /**
     * 静态复选框
     * tbl_demo_info.checkbox_static
     */
    public String getCheckboxStatic(){
        return checkboxStatic;
    }

    /**
     * 静态复选框
     * tbl_demo_info.checkbox_static
     */
    public void setCheckboxStatic(String checkboxStatic){
        this.checkboxStatic=checkboxStatic;
    }

    /**
     * 动态复选框
     * tbl_demo_info.checkbox_dynamic
     */
    public String getCheckboxDynamic(){
        return checkboxDynamic;
    }

    /**
     * 动态复选框
     * tbl_demo_info.checkbox_dynamic
     */
    public void setCheckboxDynamic(String checkboxDynamic){
        this.checkboxDynamic=checkboxDynamic;
    }

    /**
     * 网址
     * tbl_demo_info.net_address
     */
    public String getNetAddress(){
        return netAddress;
    }

    /**
     * 网址
     * tbl_demo_info.net_address
     */
    public void setNetAddress(String netAddress){
        this.netAddress=netAddress;
    }

    /**
     * 整数
     * tbl_demo_info.count_number
     */
    public Integer getCountNumber(){
        return countNumber;
    }

    /**
     * 整数
     * tbl_demo_info.count_number
     */
    public void setCountNumber(Integer countNumber){
        this.countNumber=countNumber;
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

