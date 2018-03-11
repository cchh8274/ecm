/**
 * ecm Generator 
 */
package cn.kanmars.ecm.entity;


/**
 * 文件储存表
 * tbl_file_store
 */
public class TblFileStore implements java.io.Serializable{
    /**
     * 文件编号
     * tbl_file_store.file_no
     */
    private Long fileNo;

    /**
     * 文件块
     * tbl_file_store.file_blob
     */
    private byte[] fileBlob;

    /**
     * 文件MD5
     * tbl_file_store.file_md5
     */
    private String fileMd5;

    /**
     * 添加时间
     * tbl_file_store.create_time
     */
    private String createTime;

    /**
     * 更新时间
     * tbl_file_store.up_time
     */
    private String upTime;


    public TblFileStore(){super();}
    public TblFileStore(Long fileNo,byte[] fileBlob,String fileMd5,String createTime,String upTime) {
        this.fileNo = fileNo;
        this.fileBlob = fileBlob;
        this.fileMd5 = fileMd5;
        this.createTime = createTime;
        this.upTime = upTime;
    }
    /**
     * 文件编号
     * tbl_file_store.file_no
     */
    public Long getFileNo(){
        return fileNo;
    }

    /**
     * 文件编号
     * tbl_file_store.file_no
     */
    public void setFileNo(Long fileNo){
        this.fileNo=fileNo;
    }

    /**
     * 文件块
     * tbl_file_store.file_blob
     */
    public byte[] getFileBlob(){
        return fileBlob;
    }

    /**
     * 文件块
     * tbl_file_store.file_blob
     */
    public void setFileBlob(byte[] fileBlob){
        this.fileBlob=fileBlob;
    }

    /**
     * 文件MD5
     * tbl_file_store.file_md5
     */
    public String getFileMd5(){
        return fileMd5;
    }

    /**
     * 文件MD5
     * tbl_file_store.file_md5
     */
    public void setFileMd5(String fileMd5){
        this.fileMd5=fileMd5;
    }

    /**
     * 添加时间
     * tbl_file_store.create_time
     */
    public String getCreateTime(){
        return createTime;
    }

    /**
     * 添加时间
     * tbl_file_store.create_time
     */
    public void setCreateTime(String createTime){
        this.createTime=createTime;
    }

    /**
     * 更新时间
     * tbl_file_store.up_time
     */
    public String getUpTime(){
        return upTime;
    }

    /**
     * 更新时间
     * tbl_file_store.up_time
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

