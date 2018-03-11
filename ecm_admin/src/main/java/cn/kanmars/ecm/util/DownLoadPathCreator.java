package cn.kanmars.ecm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by baolong on 2017/1/25.
 */
@Component
public class DownLoadPathCreator {

    @Value("${upload_base_path}")
    private String upload_base_path_;//文件上传根路径
    private static String upload_base_path;//文件上传根路径

    @Value("${download_base_path}")
    private String download_base_path_;//文件下载根路径
    private static String download_base_path;//文件下载根路径

    @Value("${file_base_path:D:/}")
    private String file_base_path_;//文件储存根路径
    private static String file_base_path;//文件储存根路径

    @Value("${file_sub_path:temp}")
    private String file_sub_path_;//文件储存子路径
    private static String file_sub_path;//文件储存子路径

    @PostConstruct
    public void init(){
        upload_base_path = upload_base_path_;
        download_base_path = download_base_path_;
        file_base_path = file_base_path_;
        file_sub_path = file_sub_path_;
    }

    public static String getDownLoadPath(String fileNo){
        return download_base_path + "?fileNo="+fileNo;
    }
}
