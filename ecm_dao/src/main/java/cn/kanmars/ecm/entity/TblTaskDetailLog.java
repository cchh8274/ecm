/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 任务执行日志表
 * tbl_task_detail_log
 */
public class TblTaskDetailLog implements java.io.Serializable{
    /**
     * 任务执行ID
     * tbl_task_detail_log.id
     */
    private Long id;

    /**
     * 中文名称
     * tbl_task_detail_log.task_cn_name
     */
    private String taskCnName;

    /**
     * 业务对象名称
     * tbl_task_detail_log.business_obj_name
     */
    private String businessObjName;

    /**
     * 注册组
     * tbl_task_detail_log.register_group
     */
    private String registerGroup;

    /**
     * 执行IP
     * tbl_task_detail_log.ip_info
     */
    private String ipInfo;

    /**
     * 全局名称
     * tbl_task_detail_log.global_task_name
     */
    private String globalTaskName;

    /**
     * 全局数量
     * tbl_task_detail_log.global_task_count
     */
    private Integer globalTaskCount;

    /**
     * 全局序号
     * tbl_task_detail_log.global_task_index
     */
    private Integer globalTaskIndex;

    /**
     * 批次总数
     * tbl_task_detail_log.batch_count
     */
    private Integer batchCount;

    /**
     * 批次序号
     * tbl_task_detail_log.batch_index
     */
    private Integer batchIndex;

    /**
     * 开始时间
     * tbl_task_detail_log.begin_time
     */
    private String beginTime;

    /**
     * 结束时间
     * tbl_task_detail_log.end_time
     */
    private String endTime;

    /**
     * 执行结果
     * tbl_task_detail_log.exec_result
     */
    private String execResult;

    /**
     * 执行日志
     * tbl_task_detail_log.exec_log
     */
    private String execLog;

    /**
     * 添加时间
     * tbl_task_detail_log.create_time
     */
    private String createTime;

    /**
     * 更新时间
     * tbl_task_detail_log.up_time
     */
    private String upTime;


    public TblTaskDetailLog(){super();}
    public TblTaskDetailLog(Long id,String taskCnName,String businessObjName,String registerGroup,String ipInfo,String globalTaskName,Integer globalTaskCount,Integer globalTaskIndex,Integer batchCount,Integer batchIndex,String beginTime,String endTime,String execResult,String execLog,String createTime,String upTime) {
        this.id = id;
        this.taskCnName = taskCnName;
        this.businessObjName = businessObjName;
        this.registerGroup = registerGroup;
        this.ipInfo = ipInfo;
        this.globalTaskName = globalTaskName;
        this.globalTaskCount = globalTaskCount;
        this.globalTaskIndex = globalTaskIndex;
        this.batchCount = batchCount;
        this.batchIndex = batchIndex;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.execResult = execResult;
        this.execLog = execLog;
        this.createTime = createTime;
        this.upTime = upTime;
    }
    /**
     * 任务执行ID
     * tbl_task_detail_log.id
     */
    public Long getId(){
        return id;
    }

    /**
     * 任务执行ID
     * tbl_task_detail_log.id
     */
    public void setId(Long id){
        this.id=id;
    }

    /**
     * 中文名称
     * tbl_task_detail_log.task_cn_name
     */
    public String getTaskCnName(){
        return taskCnName;
    }

    /**
     * 中文名称
     * tbl_task_detail_log.task_cn_name
     */
    public void setTaskCnName(String taskCnName){
        this.taskCnName=taskCnName;
    }

    /**
     * 业务对象名称
     * tbl_task_detail_log.business_obj_name
     */
    public String getBusinessObjName(){
        return businessObjName;
    }

    /**
     * 业务对象名称
     * tbl_task_detail_log.business_obj_name
     */
    public void setBusinessObjName(String businessObjName){
        this.businessObjName=businessObjName;
    }

    /**
     * 注册组
     * tbl_task_detail_log.register_group
     */
    public String getRegisterGroup(){
        return registerGroup;
    }

    /**
     * 注册组
     * tbl_task_detail_log.register_group
     */
    public void setRegisterGroup(String registerGroup){
        this.registerGroup=registerGroup;
    }

    /**
     * 执行IP
     * tbl_task_detail_log.ip_info
     */
    public String getIpInfo(){
        return ipInfo;
    }

    /**
     * 执行IP
     * tbl_task_detail_log.ip_info
     */
    public void setIpInfo(String ipInfo){
        this.ipInfo=ipInfo;
    }

    /**
     * 全局名称
     * tbl_task_detail_log.global_task_name
     */
    public String getGlobalTaskName(){
        return globalTaskName;
    }

    /**
     * 全局名称
     * tbl_task_detail_log.global_task_name
     */
    public void setGlobalTaskName(String globalTaskName){
        this.globalTaskName=globalTaskName;
    }

    /**
     * 全局数量
     * tbl_task_detail_log.global_task_count
     */
    public Integer getGlobalTaskCount(){
        return globalTaskCount;
    }

    /**
     * 全局数量
     * tbl_task_detail_log.global_task_count
     */
    public void setGlobalTaskCount(Integer globalTaskCount){
        this.globalTaskCount=globalTaskCount;
    }

    /**
     * 全局序号
     * tbl_task_detail_log.global_task_index
     */
    public Integer getGlobalTaskIndex(){
        return globalTaskIndex;
    }

    /**
     * 全局序号
     * tbl_task_detail_log.global_task_index
     */
    public void setGlobalTaskIndex(Integer globalTaskIndex){
        this.globalTaskIndex=globalTaskIndex;
    }

    /**
     * 批次总数
     * tbl_task_detail_log.batch_count
     */
    public Integer getBatchCount(){
        return batchCount;
    }

    /**
     * 批次总数
     * tbl_task_detail_log.batch_count
     */
    public void setBatchCount(Integer batchCount){
        this.batchCount=batchCount;
    }

    /**
     * 批次序号
     * tbl_task_detail_log.batch_index
     */
    public Integer getBatchIndex(){
        return batchIndex;
    }

    /**
     * 批次序号
     * tbl_task_detail_log.batch_index
     */
    public void setBatchIndex(Integer batchIndex){
        this.batchIndex=batchIndex;
    }

    /**
     * 开始时间
     * tbl_task_detail_log.begin_time
     */
    public String getBeginTime(){
        return beginTime;
    }

    /**
     * 开始时间
     * tbl_task_detail_log.begin_time
     */
    public void setBeginTime(String beginTime){
        this.beginTime=beginTime;
    }

    /**
     * 结束时间
     * tbl_task_detail_log.end_time
     */
    public String getEndTime(){
        return endTime;
    }

    /**
     * 结束时间
     * tbl_task_detail_log.end_time
     */
    public void setEndTime(String endTime){
        this.endTime=endTime;
    }

    /**
     * 执行结果
     * tbl_task_detail_log.exec_result
     */
    public String getExecResult(){
        return execResult;
    }

    /**
     * 执行结果
     * tbl_task_detail_log.exec_result
     */
    public void setExecResult(String execResult){
        this.execResult=execResult;
    }

    /**
     * 执行日志
     * tbl_task_detail_log.exec_log
     */
    public String getExecLog(){
        return execLog;
    }

    /**
     * 执行日志
     * tbl_task_detail_log.exec_log
     */
    public void setExecLog(String execLog){
        this.execLog=execLog;
    }

    /**
     * 添加时间
     * tbl_task_detail_log.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 添加时间
     * tbl_task_detail_log.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 更新时间
     * tbl_task_detail_log.up_time
     */
    public String getUpTime(){
        return upTime;
    }

    /**
     * 更新时间
     * tbl_task_detail_log.up_time
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

