/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 任务执行实例表
 * tbl_task_detail_report
 */
public class TblTaskDetailReport implements java.io.Serializable{
    /**
     * ID
     * tbl_task_detail_report.id
     */
    private Integer id;

    /**
     * 中文名称
     * tbl_task_detail_report.task_cn_name
     */
    private String taskCnName;

    /**
     * 业务对象名称
     * tbl_task_detail_report.business_obj_name
     */
    private String businessObjName;

    /**
     * 注册组
     * tbl_task_detail_report.register_group
     */
    private String registerGroup;

    /**
     * 执行IP
     * tbl_task_detail_report.ip_info
     */
    private String ipInfo;

    /**
     * 全局名称
     * tbl_task_detail_report.global_task_name
     */
    private String globalTaskName;

    /**
     * 全局数量
     * tbl_task_detail_report.global_task_count
     */
    private Integer globalTaskCount;

    /**
     * 全局序号
     * tbl_task_detail_report.global_task_index
     */
    private Integer globalTaskIndex;

    /**
     * 上次开始于
     * tbl_task_detail_report.last_begin_time
     */
    private String lastBeginTime;

    /**
     * 上次结束于
     * tbl_task_detail_report.last_end_time
     */
    private String lastEndTime;

    /**
     * 十次平均耗时
     * tbl_task_detail_report.last_10_avg_cost
     */
    private Integer last10AvgCost;

    /**
     * 五次平均耗时
     * tbl_task_detail_report.last_5_avg_cost
     */
    private Integer last5AvgCost;

    /**
     * 应执行次数
     * tbl_task_detail_report.exec_need_count
     */
    private Integer execNeedCount;

    /**
     * 应成功次数
     * tbl_task_detail_report.exec_succ_count
     */
    private Integer execSuccCount;

    /**
     * 执行历史记录
     * tbl_task_detail_report.exec_history
     */
    private String execHistory;

    /**
     * 添加时间
     * tbl_task_detail_report.create_time
     */
    private String createTime;

    /**
     * 更新时间
     * tbl_task_detail_report.up_time
     */
    private String upTime;


    public TblTaskDetailReport(){super();}
    public TblTaskDetailReport(Integer id,String taskCnName,String businessObjName,String registerGroup,String ipInfo,String globalTaskName,Integer globalTaskCount,Integer globalTaskIndex,String lastBeginTime,String lastEndTime,Integer last10AvgCost,Integer last5AvgCost,Integer execNeedCount,Integer execSuccCount,String execHistory,String createTime,String upTime) {
        this.id = id;
        this.taskCnName = taskCnName;
        this.businessObjName = businessObjName;
        this.registerGroup = registerGroup;
        this.ipInfo = ipInfo;
        this.globalTaskName = globalTaskName;
        this.globalTaskCount = globalTaskCount;
        this.globalTaskIndex = globalTaskIndex;
        this.lastBeginTime = lastBeginTime;
        this.lastEndTime = lastEndTime;
        this.last10AvgCost = last10AvgCost;
        this.last5AvgCost = last5AvgCost;
        this.execNeedCount = execNeedCount;
        this.execSuccCount = execSuccCount;
        this.execHistory = execHistory;
        this.createTime = createTime;
        this.upTime = upTime;
    }
    /**
     * ID
     * tbl_task_detail_report.id
     */
    public Integer getId(){
        return id;
    }

    /**
     * ID
     * tbl_task_detail_report.id
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * 中文名称
     * tbl_task_detail_report.task_cn_name
     */
    public String getTaskCnName(){
        return taskCnName;
    }

    /**
     * 中文名称
     * tbl_task_detail_report.task_cn_name
     */
    public void setTaskCnName(String taskCnName){
        this.taskCnName=taskCnName;
    }

    /**
     * 业务对象名称
     * tbl_task_detail_report.business_obj_name
     */
    public String getBusinessObjName(){
        return businessObjName;
    }

    /**
     * 业务对象名称
     * tbl_task_detail_report.business_obj_name
     */
    public void setBusinessObjName(String businessObjName){
        this.businessObjName=businessObjName;
    }

    /**
     * 注册组
     * tbl_task_detail_report.register_group
     */
    public String getRegisterGroup(){
        return registerGroup;
    }

    /**
     * 注册组
     * tbl_task_detail_report.register_group
     */
    public void setRegisterGroup(String registerGroup){
        this.registerGroup=registerGroup;
    }

    /**
     * 执行IP
     * tbl_task_detail_report.ip_info
     */
    public String getIpInfo(){
        return ipInfo;
    }

    /**
     * 执行IP
     * tbl_task_detail_report.ip_info
     */
    public void setIpInfo(String ipInfo){
        this.ipInfo=ipInfo;
    }

    /**
     * 全局名称
     * tbl_task_detail_report.global_task_name
     */
    public String getGlobalTaskName(){
        return globalTaskName;
    }

    /**
     * 全局名称
     * tbl_task_detail_report.global_task_name
     */
    public void setGlobalTaskName(String globalTaskName){
        this.globalTaskName=globalTaskName;
    }

    /**
     * 全局数量
     * tbl_task_detail_report.global_task_count
     */
    public Integer getGlobalTaskCount(){
        return globalTaskCount;
    }

    /**
     * 全局数量
     * tbl_task_detail_report.global_task_count
     */
    public void setGlobalTaskCount(Integer globalTaskCount){
        this.globalTaskCount=globalTaskCount;
    }

    /**
     * 全局序号
     * tbl_task_detail_report.global_task_index
     */
    public Integer getGlobalTaskIndex(){
        return globalTaskIndex;
    }

    /**
     * 全局序号
     * tbl_task_detail_report.global_task_index
     */
    public void setGlobalTaskIndex(Integer globalTaskIndex){
        this.globalTaskIndex=globalTaskIndex;
    }

    /**
     * 上次开始于
     * tbl_task_detail_report.last_begin_time
     */
    public String getLastBeginTime(){
        return lastBeginTime;
    }

    /**
     * 上次开始于
     * tbl_task_detail_report.last_begin_time
     */
    public void setLastBeginTime(String lastBeginTime){
        this.lastBeginTime=lastBeginTime;
    }

    /**
     * 上次结束于
     * tbl_task_detail_report.last_end_time
     */
    public String getLastEndTime(){
        return lastEndTime;
    }

    /**
     * 上次结束于
     * tbl_task_detail_report.last_end_time
     */
    public void setLastEndTime(String lastEndTime){
        this.lastEndTime=lastEndTime;
    }

    /**
     * 十次平均耗时
     * tbl_task_detail_report.last_10_avg_cost
     */
    public Integer getLast10AvgCost(){
        return last10AvgCost;
    }

    /**
     * 十次平均耗时
     * tbl_task_detail_report.last_10_avg_cost
     */
    public void setLast10AvgCost(Integer last10AvgCost){
        this.last10AvgCost=last10AvgCost;
    }

    /**
     * 五次平均耗时
     * tbl_task_detail_report.last_5_avg_cost
     */
    public Integer getLast5AvgCost(){
        return last5AvgCost;
    }

    /**
     * 五次平均耗时
     * tbl_task_detail_report.last_5_avg_cost
     */
    public void setLast5AvgCost(Integer last5AvgCost){
        this.last5AvgCost=last5AvgCost;
    }

    /**
     * 应执行次数
     * tbl_task_detail_report.exec_need_count
     */
    public Integer getExecNeedCount(){
        return execNeedCount;
    }

    /**
     * 应执行次数
     * tbl_task_detail_report.exec_need_count
     */
    public void setExecNeedCount(Integer execNeedCount){
        this.execNeedCount=execNeedCount;
    }

    /**
     * 应成功次数
     * tbl_task_detail_report.exec_succ_count
     */
    public Integer getExecSuccCount(){
        return execSuccCount;
    }

    /**
     * 应成功次数
     * tbl_task_detail_report.exec_succ_count
     */
    public void setExecSuccCount(Integer execSuccCount){
        this.execSuccCount=execSuccCount;
    }

    /**
     * 执行历史记录
     * tbl_task_detail_report.exec_history
     */
    public String getExecHistory(){
        return execHistory;
    }

    /**
     * 执行历史记录
     * tbl_task_detail_report.exec_history
     */
    public void setExecHistory(String execHistory){
        this.execHistory=execHistory;
    }

    /**
     * 添加时间
     * tbl_task_detail_report.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 添加时间
     * tbl_task_detail_report.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 更新时间
     * tbl_task_detail_report.up_time
     */
    public String getUpTime(){
        return upTime;
    }

    /**
     * 更新时间
     * tbl_task_detail_report.up_time
     */
    public void setUpTime(String upTime){
        this.upTime=upTime;
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

