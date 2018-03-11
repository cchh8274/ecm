/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 联表查询DEMO-从表a
 * tbl_union_demo_slavea_info
 */
public class TblUnionDemoSlaveaInfo implements java.io.Serializable{
    /**
     * 表ID
     * tbl_union_demo_slavea_info.demo_ida
     */
    private Long demoIda;

    /**
     * 表ID
     * tbl_union_demo_slavea_info.forgien_id
     */
    private Long forgienId;

    /**
     * 演示名称
     * tbl_union_demo_slavea_info.demo_nma
     */
    private String demoNma;

    /**
     * 创建时间
     * tbl_union_demo_slavea_info.create_timea
     */
    private String createTimea;

    /**
     * 整数
     * tbl_union_demo_slavea_info.count_numbera
     */
    private Integer countNumbera;

    /**
     * 演示金额
     * tbl_union_demo_slavea_info.demo_moneya
     */
    private java.math.BigDecimal demoMoneya;

    /**
     * 静态选择框
     * tbl_union_demo_slavea_info.select_statica
     */
    private String selectStatica;

    /**
     * 动态选择框
     * tbl_union_demo_slavea_info.select_dynamica
     */
    private String selectDynamica;

    /**
     * 静态单选按钮
     * tbl_union_demo_slavea_info.radio_statica
     */
    private String radioStatica;

    /**
     * 动态单选按钮
     * tbl_union_demo_slavea_info.radio_dynamica
     */
    private String radioDynamica;

    /**
     * 静态复选框
     * tbl_union_demo_slavea_info.checkbox_statica
     */
    private String checkboxStatica;

    /**
     * 动态复选框
     * tbl_union_demo_slavea_info.checkbox_dynamica
     */
    private String checkboxDynamica;

    /**
     * 创建日期
     * tbl_union_demo_slavea_info.create_datea
     */
    private String createDatea;


    public TblUnionDemoSlaveaInfo(){super();}
    public TblUnionDemoSlaveaInfo(Long demoIda,Long forgienId,String demoNma,String createTimea,Integer countNumbera,java.math.BigDecimal demoMoneya,String selectStatica,String selectDynamica,String radioStatica,String radioDynamica,String checkboxStatica,String checkboxDynamica,String createDatea) {
        this.demoIda = demoIda;
        this.forgienId = forgienId;
        this.demoNma = demoNma;
        this.createTimea = createTimea;
        this.countNumbera = countNumbera;
        this.demoMoneya = demoMoneya;
        this.selectStatica = selectStatica;
        this.selectDynamica = selectDynamica;
        this.radioStatica = radioStatica;
        this.radioDynamica = radioDynamica;
        this.checkboxStatica = checkboxStatica;
        this.checkboxDynamica = checkboxDynamica;
        this.createDatea = createDatea;
    }
    /**
     * 表ID
     * tbl_union_demo_slavea_info.demo_ida
     */
    public Long getDemoIda(){
        return demoIda;
    }

    /**
     * 表ID
     * tbl_union_demo_slavea_info.demo_ida
     */
    public void setDemoIda(Long demoIda){
        this.demoIda=demoIda;
    }

    /**
     * 表ID
     * tbl_union_demo_slavea_info.forgien_id
     */
    public Long getForgienId(){
        return forgienId;
    }

    /**
     * 表ID
     * tbl_union_demo_slavea_info.forgien_id
     */
    public void setForgienId(Long forgienId){
        this.forgienId=forgienId;
    }

    /**
     * 演示名称
     * tbl_union_demo_slavea_info.demo_nma
     */
    public String getDemoNma(){
        return demoNma;
    }

    /**
     * 演示名称
     * tbl_union_demo_slavea_info.demo_nma
     */
    public void setDemoNma(String demoNma){
        this.demoNma=demoNma;
    }

    /**
     * 创建时间
     * tbl_union_demo_slavea_info.create_timea
     */
    public String getCreateTimea(){
        return createTimea;
    }

    /**
     * 创建时间
     * tbl_union_demo_slavea_info.create_timea
     */
    public void setCreateTimea(String createTimea){
        this.createTimea=createTimea;
    }

    /**
     * 整数
     * tbl_union_demo_slavea_info.count_numbera
     */
    public Integer getCountNumbera(){
        return countNumbera;
    }

    /**
     * 整数
     * tbl_union_demo_slavea_info.count_numbera
     */
    public void setCountNumbera(Integer countNumbera){
        this.countNumbera=countNumbera;
    }

    /**
     * 演示金额
     * tbl_union_demo_slavea_info.demo_moneya
     */
    public java.math.BigDecimal getDemoMoneya(){
        return demoMoneya;
    }

    /**
     * 演示金额
     * tbl_union_demo_slavea_info.demo_moneya
     */
    public void setDemoMoneya(java.math.BigDecimal demoMoneya){
        this.demoMoneya=demoMoneya;
    }

    /**
     * 静态选择框
     * tbl_union_demo_slavea_info.select_statica
     */
    public String getSelectStatica(){
        return selectStatica;
    }

    /**
     * 静态选择框
     * tbl_union_demo_slavea_info.select_statica
     */
    public void setSelectStatica(String selectStatica){
        this.selectStatica=selectStatica;
    }

    /**
     * 动态选择框
     * tbl_union_demo_slavea_info.select_dynamica
     */
    public String getSelectDynamica(){
        return selectDynamica;
    }

    /**
     * 动态选择框
     * tbl_union_demo_slavea_info.select_dynamica
     */
    public void setSelectDynamica(String selectDynamica){
        this.selectDynamica=selectDynamica;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_slavea_info.radio_statica
     */
    public String getRadioStatica(){
        return radioStatica;
    }

    /**
     * 静态单选按钮
     * tbl_union_demo_slavea_info.radio_statica
     */
    public void setRadioStatica(String radioStatica){
        this.radioStatica=radioStatica;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_slavea_info.radio_dynamica
     */
    public String getRadioDynamica(){
        return radioDynamica;
    }

    /**
     * 动态单选按钮
     * tbl_union_demo_slavea_info.radio_dynamica
     */
    public void setRadioDynamica(String radioDynamica){
        this.radioDynamica=radioDynamica;
    }

    /**
     * 静态复选框
     * tbl_union_demo_slavea_info.checkbox_statica
     */
    public String getCheckboxStatica(){
        return checkboxStatica;
    }

    /**
     * 静态复选框
     * tbl_union_demo_slavea_info.checkbox_statica
     */
    public void setCheckboxStatica(String checkboxStatica){
        this.checkboxStatica=checkboxStatica;
    }

    /**
     * 动态复选框
     * tbl_union_demo_slavea_info.checkbox_dynamica
     */
    public String getCheckboxDynamica(){
        return checkboxDynamica;
    }

    /**
     * 动态复选框
     * tbl_union_demo_slavea_info.checkbox_dynamica
     */
    public void setCheckboxDynamica(String checkboxDynamica){
        this.checkboxDynamica=checkboxDynamica;
    }

    /**
     * 创建日期
     * tbl_union_demo_slavea_info.create_datea
     */
    public String getCreateDatea(){
        return createDatea;
    }

    /**
     * 创建日期
     * tbl_union_demo_slavea_info.create_datea
     */
    public void setCreateDatea(String createDatea){
        this.createDatea=createDatea;
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

