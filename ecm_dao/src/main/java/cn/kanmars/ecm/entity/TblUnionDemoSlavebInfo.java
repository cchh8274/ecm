/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 联表查询DEMO-从表b
 * tbl_union_demo_slaveb_info
 */
public class TblUnionDemoSlavebInfo implements java.io.Serializable{
    /**
     * 表ID
     * tbl_union_demo_slaveb_info.demo_idb
     */
    private Long demoIdb;

    /**
     * 表ID
     * tbl_union_demo_slaveb_info.forgien_id
     */
    private Long forgienId;

    /**
     * 演示名称
     * tbl_union_demo_slaveb_info.demo_nmb
     */
    private String demoNmb;

    /**
     * 创建时间
     * tbl_union_demo_slaveb_info.create_timeb
     */
    private String createTimeb;

    /**
     * 整数
     * tbl_union_demo_slaveb_info.count_numberb
     */
    private Integer countNumberb;

    /**
     * 演示金额
     * tbl_union_demo_slaveb_info.demo_moneyb
     */
    private java.math.BigDecimal demoMoneyb;

    /**
     * 静态选择框
     * tbl_union_demo_slaveb_info.select_staticb
     */
    private String selectStaticb;

    /**
     * 动态选择框
     * tbl_union_demo_slaveb_info.select_dynamicb
     */
    private String selectDynamicb;

    /**
     * 静态单选按钮
     * tbl_union_demo_slaveb_info.radio_staticb
     */
    private String radioStaticb;

    /**
     * 动态单选按钮
     * tbl_union_demo_slaveb_info.radio_dynamicb
     */
    private String radioDynamicb;

    /**
     * 静态复选框
     * tbl_union_demo_slaveb_info.checkbox_staticb
     */
    private String checkboxStaticb;

    /**
     * 动态复选框
     * tbl_union_demo_slaveb_info.checkbox_dynamicb
     */
    private String checkboxDynamicb;

    /**
     * 创建日期
     * tbl_union_demo_slaveb_info.create_dateb
     */
    private String createDateb;


    public TblUnionDemoSlavebInfo(){super();}
    public TblUnionDemoSlavebInfo(Long demoIdb,Long forgienId,String demoNmb,String createTimeb,Integer countNumberb,java.math.BigDecimal demoMoneyb,String selectStaticb,String selectDynamicb,String radioStaticb,String radioDynamicb,String checkboxStaticb,String checkboxDynamicb,String createDateb) {
        this.demoIdb = demoIdb;
        this.forgienId = forgienId;
        this.demoNmb = demoNmb;
        this.createTimeb = createTimeb;
        this.countNumberb = countNumberb;
        this.demoMoneyb = demoMoneyb;
        this.selectStaticb = selectStaticb;
        this.selectDynamicb = selectDynamicb;
        this.radioStaticb = radioStaticb;
        this.radioDynamicb = radioDynamicb;
        this.checkboxStaticb = checkboxStaticb;
        this.checkboxDynamicb = checkboxDynamicb;
        this.createDateb = createDateb;
    }
    /**
     * 表ID
     * tbl_union_demo_slaveb_info.demo_idb
     */
    public Long getDemoIdb(){
        return demoIdb;
    }

    /**
     * 表ID
     * tbl_union_demo_slaveb_info.demo_idb
     */
    public void setDemoIdb(Long demoIdb){
        this.demoIdb=demoIdb;
    }

    /**
     * 表ID
     * tbl_union_demo_slaveb_info.forgien_id
     */
    public Long getForgienId(){
        return forgienId;
    }

    /**
     * 表ID
     * tbl_union_demo_slaveb_info.forgien_id
     */
    public void setForgienId(Long forgienId){
        this.forgienId=forgienId;
    }

    /**
     * 演示名称
     * tbl_union_demo_slaveb_info.demo_nmb
     */
    public String getDemoNmb(){
        return demoNmb;
    }

    /**
     * 演示名称
     * tbl_union_demo_slaveb_info.demo_nmb
     */
    public void setDemoNmb(String demoNmb){
        this.demoNmb=demoNmb;
    }

    /**
     * 创建时间
     * tbl_union_demo_slaveb_info.create_timeb
     */
    public String getCreateTimeb(){
        return createTimeb;
    }

    /**
     * 创建时间
     * tbl_union_demo_slaveb_info.create_timeb
     */
    public void setCreateTimeb(String createTimeb){
        this.createTimeb=createTimeb;
    }

    /**
     * 整数
     * tbl_union_demo_slaveb_info.count_numberb
     */
    public Integer getCountNumberb(){
        return countNumberb;
    }

    /**
     * 整数
     * tbl_union_demo_slaveb_info.count_numberb
     */
    public void setCountNumberb(Integer countNumberb){
        this.countNumberb=countNumberb;
    }

    /**
     * 演示金额
     * tbl_union_demo_slaveb_info.demo_moneyb
     */
    public java.math.BigDecimal getDemoMoneyb(){
        return demoMoneyb;
    }

    /**
     * 演示金额
     * tbl_union_demo_slaveb_info.demo_moneyb
     */
    public void setDemoMoneyb(java.math.BigDecimal demoMoneyb){
        this.demoMoneyb=demoMoneyb;
    }

    /**
     * 静态选择框
     * tbl_union_demo_slaveb_info.select_staticb
     */
    public String getSelectStaticb(){
        return selectStaticb;
    }

    /**
     * 静态选择框
     * tbl_union_demo_slaveb_info.select_staticb
     */
    public void setSelectStaticb(String selectStaticb){
        this.selectStaticb=selectStaticb;
    }

    /**
     * 动态选择框
     * tbl_union_demo_slaveb_info.select_dynamicb
     */
    public String getSelectDynamicb(){
        return selectDynamicb;
    }

    /**
     * 动态选择框
     * tbl_union_demo_slaveb_info.select_dynamicb
     */
    public void setSelectDynamicb(String selectDynamicb){
        this.selectDynamicb=selectDynamicb;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_slaveb_info.radio_staticb
     */
    public String getRadioStaticb(){
        return radioStaticb;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_slaveb_info.radio_staticb
     */
    public void setRadioStaticb(String radioStaticb){
        this.radioStaticb=radioStaticb;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_slaveb_info.radio_dynamicb
     */
    public String getRadioDynamicb(){
        return radioDynamicb;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_slaveb_info.radio_dynamicb
     */
    public void setRadioDynamicb(String radioDynamicb){
        this.radioDynamicb=radioDynamicb;
    }

    /**
     * 静态复选框
     * tbl_union_demo_slaveb_info.checkbox_staticb
     */
    public String getCheckboxStaticb(){
        return checkboxStaticb;
    }

    /**
     * 静态复选框
     * tbl_union_demo_slaveb_info.checkbox_staticb
     */
    public void setCheckboxStaticb(String checkboxStaticb){
        this.checkboxStaticb=checkboxStaticb;
    }

    /**
     * 动态复选框
     * tbl_union_demo_slaveb_info.checkbox_dynamicb
     */
    public String getCheckboxDynamicb(){
        return checkboxDynamicb;
    }

    /**
     * 动态复选框
     * tbl_union_demo_slaveb_info.checkbox_dynamicb
     */
    public void setCheckboxDynamicb(String checkboxDynamicb){
        this.checkboxDynamicb=checkboxDynamicb;
    }

    /**
     * 创建日期
     * tbl_union_demo_slaveb_info.create_dateb
     */
    public String getCreateDateb(){
        return createDateb;
    }

    /**
     * 创建日期
     * tbl_union_demo_slaveb_info.create_dateb
     */
    public void setCreateDateb(String createDateb){
        this.createDateb=createDateb;
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

