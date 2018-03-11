package cn.kanmars.ecm.controller;

import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.xbase.security.md5.MD5Util;
import cn.com.xbase.tools.idgen.IDGeneratorTools;
import cn.com.xbase.tools.idgen.IDTransferTools;
import cn.com.xbase.frame.logger.HLogger;
import cn.com.xbase.frame.logger.LoggerManager;
import cn.com.xbase.frame.util.DateUtils;
import cn.com.xbase.frame.util.MimeTransferUtils;
import cn.com.xbase.frame.util.StringUtils;
import cn.kanmars.ecm.base.AdvancedAjaxBaseController;
import cn.kanmars.ecm.entity.TblFileInfo;
import cn.kanmars.ecm.entity.TblFileStore;
import cn.kanmars.ecm.logic.FileInfoLogic;
import cn.kanmars.ecm.util.DownLoadPathCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class FileUpDownloadController extends AdvancedAjaxBaseController {
    protected HLogger logger = LoggerManager.getLoger("FileUpDownloadController");

    /**
     * 将文件储存在文件系统中
     */
    public static final String STORETYPE_STOREFILE = "f1";
    /**
     * 将文件储存在数据库中
     */
    public static final String STORETYPE_STOREDB = "d1";

    @Autowired
    private FileInfoLogic fileInfoLogic;

    @Value("${upload_base_path}")
    private String upload_base_path;//文件上传根路径

    @Value("${download_base_path}")
    private String download_base_path;//文件下载根路径

    @Value("${showimage_base_path}")
    private String showimage_base_path;//图片显示根路径

    @Value("${file_base_path:D:/}")
    private String file_base_path;//文件储存根路径

    @Value("${file_sub_path:temp}")
    private String file_sub_path;//文件储存根路径

    @RequestMapping("/upLoad.dhtml")
    public void upLoad(@RequestParam("upFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        logger.info("FileUpDownloadController.upLoad--start");
        if (file == null) {
            logger.info("FileUpDownloadController.upLoad--end-nofile");
            return;
        }
        Map<String, Object> othMsg = new HashMap<String, Object>();

        try {
            String storeType = request.getParameter("store_type");
            if (StringUtils.isEmpty(storeType)) {
                storeType = STORETYPE_STOREFILE;
            }
            long fileNo = IDGeneratorTools.createSimpleLong();
//			String fileNo = SysSequenceUtils.generateStringIdNoneTopAndSuffixAndLength("tbl_file_info");
            String businessType = request.getParameter("business_type");
            String businessNo = request.getParameter("business_no");
            String originalFilename = request.getParameter("originalFilename");//原始名称
            String suffix = "";
            if (originalFilename.lastIndexOf(".") > 0) {
                suffix = originalFilename.substring(originalFilename.lastIndexOf("."));//后缀名
            }

            String newFileName = IDTransferTools.getStrFrom(IDGeneratorTools.createSimpleLong());//新名称

            String fileDesc = request.getParameter("file_desc");
            String createTm = DateUtils.getCurrDateTime();
            //统一创建downLoadPath，因为在上传下载图片时，需要根据fileNo去生成上传下载地址
            String downloadPath = DownLoadPathCreator.getDownLoadPath(fileNo + "");

            if (storeType.equals(STORETYPE_STOREFILE)) {

                String storePath = file_base_path + file_sub_path + DateUtils.getCurrDate() + "/";
                String storeAllName = file_base_path + file_sub_path + DateUtils.getCurrDate() + "/" + newFileName + suffix;

                File targetPath = new File(storePath);
                if (!targetPath.exists()) {
                    targetPath.mkdirs();
                }
                File targetFile = new File(storePath, newFileName + suffix);
                file.transferTo(targetFile);

                TblFileInfo tblFileInfo = new TblFileInfo();
                tblFileInfo.setFileNo(fileNo);//
                tblFileInfo.setBusinessType(businessType);
                tblFileInfo.setBusinessNo(businessNo);//业务编号，关联用
                tblFileInfo.setFileName(originalFilename);//文件原来名称

                tblFileInfo.setFilePath(STORETYPE_STOREFILE + ":" + storeAllName);//文件全路径
                tblFileInfo.setFileRootPath(downloadPath);//文件访问根路径
                tblFileInfo.setCreateTm(createTm);//创建时间
                tblFileInfo.setFileStat("010");//文件状态有效
                tblFileInfo.setFileSize(String.valueOf(file.getSize()) + "b");
                tblFileInfo.setFileDesc(request.getParameter(fileDesc));
                int flag = fileInfoLogic.insertFileInfo(tblFileInfo);

                othMsg.put("fileName", originalFilename);
                othMsg.put("file_path", downloadPath);
                othMsg.put("file_size", String.valueOf(file.getSize()) + "b");
                othMsg.put("file_desc", tblFileInfo.getFileDesc());//文件描述
                othMsg.put("file_no", tblFileInfo.getFileNo() + "");
                othMsg.put("business_no", tblFileInfo.getBusinessNo());//业务编号
                othMsg.put("business_type", tblFileInfo.getBusinessType());//业务类型
                ajaxJsonMessage(request, response, SUCCESS, "上传成功", "upload", othMsg);
            }
            if (storeType.equals(STORETYPE_STOREDB)) {
                InputStream is = file.getInputStream();
                ByteArrayOutputStream bao = new ByteArrayOutputStream();
                byte[] tmp = new byte[512];
                int count = 0;
                while ((count = is.read(tmp)) >= 0) {
                    bao.write(tmp, 0, count);
                }
                bao.close();
                is.close();

                byte[] fileBlob = bao.toByteArray();

                TblFileInfo tblFileInfo = new TblFileInfo();
                tblFileInfo.setFileNo(fileNo);//
                tblFileInfo.setBusinessType(businessType);
                tblFileInfo.setBusinessNo(businessNo);//业务编号，关联用
                tblFileInfo.setFileName(originalFilename);//文件原来名称
                tblFileInfo.setFilePath(STORETYPE_STOREDB);//文件全路径
                tblFileInfo.setFileRootPath(downloadPath);//文件访问根路径
                tblFileInfo.setCreateTm(createTm);//创建时间
                tblFileInfo.setFileStat("010");//文件状态有效
                tblFileInfo.setFileSize(String.valueOf(file.getSize()) + "b");
                tblFileInfo.setFileDesc(request.getParameter(fileDesc));


                TblFileStore tblFileStore = new TblFileStore();
                tblFileStore.setFileNo(fileNo);
                tblFileStore.setFileBlob(fileBlob);
                tblFileStore.setFileMd5(MD5Util.encodeMessage(fileBlob));
                tblFileStore.setCreateTime(createTm);
                tblFileStore.setUpTime(createTm);

                int flag = fileInfoLogic.insertFileInfoAndDBInfo(tblFileInfo, tblFileStore);
                othMsg.put("fileName", originalFilename);
                othMsg.put("file_path", downloadPath);
                othMsg.put("file_size", String.valueOf(file.getSize()) + "b");
                othMsg.put("file_desc", tblFileInfo.getFileDesc());//文件描述
                othMsg.put("file_no", tblFileInfo.getFileNo() + "");
                othMsg.put("business_no", tblFileInfo.getBusinessNo());//业务编号
                othMsg.put("business_type", tblFileInfo.getBusinessType());//业务类型
                ajaxJsonMessage(request, response, SUCCESS, "上传成功", "upload", othMsg);
            }
            logger.info("----------------文件上传成功------------------------------");
        } catch (Exception e) {
            logger.info("上传失败", e);
            ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", SAVE);
        }
    }

    @RequestMapping("/downLoad.dhtml")
    public void downLoad(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> othMsg = new HashMap<String, Object>();
        logger.info("FileUpDownloadController.downLoad--start");
        TblFileInfo tblFileInfo = new TblFileInfo();
        try {
            String fileNo = request.getParameter("fileNo");
            Map<String, Object> result = fileInfoLogic.getFileInfo(Long.parseLong(fileNo));
            String fileName = (String) result.get("fileName");
            byte[] fileBlob = (byte[]) result.get("fileBlob");
            String fileRootPath = (String) result.get("fileRootPath");
            String createTm = (String) result.get("createTm");
            String suffix = "";
            if (fileName.lastIndexOf(".") > 0) {
                suffix = fileName.substring(fileName.lastIndexOf("."));
            }
            setHeader(response, request, fileName);
            response.getOutputStream().write(fileBlob);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            logger.info("FileUpDownloadController.downLoad--end");
        } catch (Exception e) {
            logger.info("上传失败", e);
            ajaxJsonMessage(request, response, ERROR, "操作异常,请联系管理员！", SAVE);
        }
    }

    @RequestMapping("/fileDemo")
    public ModelAndView init() {
        ModelAndView mv = new ModelAndView("file/file");
        mv.addObject("upload_base_path", upload_base_path);
        mv.addObject("download_base_path", download_base_path);
        return mv;
    }
    // 在新的页签上展示图片
    @RequestMapping("/showImage")
    public void showImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileNo = request.getParameter("fileNo");
        Map<String, Object> result = fileInfoLogic.getFileInfo(Long.parseLong(fileNo));
        byte[] fileBlob = (byte[]) result.get("fileBlob");
        InputStream fis = new ByteArrayInputStream(fileBlob);
        OutputStream os = response.getOutputStream();
        try {
            int count = 0;
            byte[] buffer = new byte[1024 * 1024];
            while ((count = fis.read(buffer)) != -1)
                os.write(buffer, 0, count);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null)
                os.close();
            if (fis != null)
                fis.close();
        }
    }


    private void setHeader(HttpServletResponse response, HttpServletRequest request, String filename)
            throws UnsupportedEncodingException {
        response.reset();
        String suffix = "";
        if (filename.lastIndexOf(".") > 0) {
            suffix = filename.substring(filename.lastIndexOf("."));
        }
        if (StringUtils.isNotEmpty(suffix)) {
            // 设置为下载application/x-download
            response.setContentType(MimeTransferUtils.transfersuffix2Contenttype(suffix) + "; charset=UTF-8");
        } else {
            // 设置为下载application/x-download
            response.setContentType("application/x-download; charset=UTF-8");
        }

        // 通常解决汉字乱码方法用URLEncoder.encode(...)
        String filenamedisplay = URLEncoder.encode(filename, "UTF-8");
        if ("FF".equals(getBrowser(request))) {
            // 针对火狐浏览器处理方式不一样了
            filenamedisplay = new String(filename.getBytes("UTF-8"), "iso-8859-1");
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + filenamedisplay);
    }

    // 以下为服务器端判断客户端浏览器类型的方法
    private String getBrowser(HttpServletRequest request) {
        String UserAgent = request.getHeader("USER-AGENT").toLowerCase();
        if (UserAgent != null) {
            if (UserAgent.indexOf("msie") >= 0)
                return "IE";
            if (UserAgent.indexOf("firefox") >= 0)
                return "FF";
            if (UserAgent.indexOf("safari") >= 0)
                return "SF";
        }
        return null;
    }
}
