/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 联表查询DEMO-子表
 * tbl_union_demo_sub_info
 */
public class TblUnionDemoSubInfo implements java.io.Serializable{
    /**
     * 表ID
     * tbl_union_demo_sub_info.demo_idc
     */
    private Long demoIdc;

    /**
     * 表ID
     * tbl_union_demo_sub_info.forgien_id
     */
    private Long forgienId;

    /**
     * 演示名称
     * tbl_union_demo_sub_info.demo_nmc
     */
    private String demoNmc;

    /**
     * 创建时间
     * tbl_union_demo_sub_info.create_timec
     */
    private String createTimec;

    /**
     * 整数
     * tbl_union_demo_sub_info.count_numberc
     */
    private Integer countNumberc;

    /**
     * 演示金额
     * tbl_union_demo_sub_info.demo_moneyc
     */
    private java.math.BigDecimal demoMoneyc;

    /**
     * 静态选择框
     * tbl_union_demo_sub_info.select_staticc
     */
    private String selectStaticc;

    /**
     * 动态选择框
     * tbl_union_demo_sub_info.select_dynamicc
     */
    private String selectDynamicc;

    /**
     * 静态单选按钮
     * tbl_union_demo_sub_info.radio_staticc
     */
    private String radioStaticc;

    /**
     * 动态单选按钮
     * tbl_union_demo_sub_info.radio_dynamicc
     */
    private String radioDynamicc;

    /**
     * 静态复选框
     * tbl_union_demo_sub_info.checkbox_staticc
     */
    private String checkboxStaticc;

    /**
     * 动态复选框
     * tbl_union_demo_sub_info.checkbox_dynamicc
     */
    private String checkboxDynamicc;

    /**
     * 创建日期
     * tbl_union_demo_sub_info.create_datec
     */
    private String createDatec;


    public TblUnionDemoSubInfo(){super();}
    public TblUnionDemoSubInfo(Long demoIdc,Long forgienId,String demoNmc,String createTimec,Integer countNumberc,java.math.BigDecimal demoMoneyc,String selectStaticc,String selectDynamicc,String radioStaticc,String radioDynamicc,String checkboxStaticc,String checkboxDynamicc,String createDatec) {
        this.demoIdc = demoIdc;
        this.forgienId = forgienId;
        this.demoNmc = demoNmc;
        this.createTimec = createTimec;
        this.countNumberc = countNumberc;
        this.demoMoneyc = demoMoneyc;
        this.selectStaticc = selectStaticc;
        this.selectDynamicc = selectDynamicc;
        this.radioStaticc = radioStaticc;
        this.radioDynamicc = radioDynamicc;
        this.checkboxStaticc = checkboxStaticc;
        this.checkboxDynamicc = checkboxDynamicc;
        this.createDatec = createDatec;
    }
    /**
     * 表ID
     * tbl_union_demo_sub_info.demo_idc
     */
    public Long getDemoIdc(){
        return demoIdc;
    }

    /**
     * 表ID
     * tbl_union_demo_sub_info.demo_idc
     */
    public void setDemoIdc(Long demoIdc){
        this.demoIdc=demoIdc;
    }

    /**
     * 表ID
     * tbl_union_demo_sub_info.forgien_id
     */
    public Long getForgienId(){
        return forgienId;
    }

    /**
     * 表ID
     * tbl_union_demo_sub_info.forgien_id
     */
    public void setForgienId(Long forgienId){
        this.forgienId=forgienId;
    }

    /**
     * 演示名称
     * tbl_union_demo_sub_info.demo_nmc
     */
    public String getDemoNmc(){
        return demoNmc;
    }

    /**
     * 演示名称
     * tbl_union_demo_sub_info.demo_nmc
     */
    public void setDemoNmc(String demoNmc){
        this.demoNmc=demoNmc;
    }

    /**
     * 创建时间
     * tbl_union_demo_sub_info.create_timec
     */
    public String getCreateTimec(){
        return createTimec;
    }

    /**
     * 创建时间
     * tbl_union_demo_sub_info.create_timec
     */
    public void setCreateTimec(String createTimec){
        this.createTimec=createTimec;
    }

    /**
     * 整数
     * tbl_union_demo_sub_info.count_numberc
     */
    public Integer getCountNumberc(){
        return countNumberc;
    }

    /**
     * 整数
     * tbl_union_demo_sub_info.count_numberc
     */
    public void setCountNumberc(Integer countNumberc){
        this.countNumberc=countNumberc;
    }

    /**
     * 演示金额
     * tbl_union_demo_sub_info.demo_moneyc
     */
    public java.math.BigDecimal getDemoMoneyc(){
        return demoMoneyc;
    }

    /**
     * 演示金额
     * tbl_union_demo_sub_info.demo_moneyc
     */
    public void setDemoMoneyc(java.math.BigDecimal demoMoneyc){
        this.demoMoneyc=demoMoneyc;
    }

    /**
     * 静态选择框
     * tbl_union_demo_sub_info.select_staticc
     */
    public String getSelectStaticc(){
        return selectStaticc;
    }

    /**
     * 静态选择框
     * tbl_union_demo_sub_info.select_staticc
     */
    public void setSelectStaticc(String selectStaticc){
        this.selectStaticc=selectStaticc;
    }

    /**
     * 动态选择框
     * tbl_union_demo_sub_info.select_dynamicc
     */
    public String getSelectDynamicc(){
        return selectDynamicc;
    }

    /**
     * 动态选择框
     * tbl_union_demo_sub_info.select_dynamicc
     */
    public void setSelectDynamicc(String selectDynamicc){
        this.selectDynamicc=selectDynamicc;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_sub_info.radio_staticc
     */
    public String getRadioStaticc(){
        return radioStaticc;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_sub_info.radio_staticc
     */
    public void setRadioStaticc(String radioStaticc){
        this.radioStaticc=radioStaticc;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_sub_info.radio_dynamicc
     */
    public String getRadioDynamicc(){
        return radioDynamicc;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_sub_info.radio_dynamicc
     */
    public void setRadioDynamicc(String radioDynamicc){
        this.radioDynamicc=radioDynamicc;
    }

    /**
     * 静态复选框
     * tbl_union_demo_sub_info.checkbox_staticc
     */
    public String getCheckboxStaticc(){
        return checkboxStaticc;
    }

    /**
     * 静态复选框
     * tbl_union_demo_sub_info.checkbox_staticc
     */
    public void setCheckboxStaticc(String checkboxStaticc){
        this.checkboxStaticc=checkboxStaticc;
    }

    /**
     * 动态复选框
     * tbl_union_demo_sub_info.checkbox_dynamicc
     */
    public String getCheckboxDynamicc(){
        return checkboxDynamicc;
    }

    /**
     * 动态复选框
     * tbl_union_demo_sub_info.checkbox_dynamicc
     */
    public void setCheckboxDynamicc(String checkboxDynamicc){
        this.checkboxDynamicc=checkboxDynamicc;
    }

    /**
     * 创建日期
     * tbl_union_demo_sub_info.create_datec
     */
    public String getCreateDatec(){
        return createDatec;
    }

    /**
     * 创建日期
     * tbl_union_demo_sub_info.create_datec
     */
    public void setCreateDatec(String createDatec){
        this.createDatec=createDatec;
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

