package cn.group.xudy.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FilesUtils {
    /**
     * 上传
     * @param request
     * @return
     */

    public static Map upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
        MultipartFile file = multipartRequest.getFile("file");//file是页面input的name名
        String basePath = "D:/upload";
        try {
            MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (resolver.isMultipart(request)) {
               // String fileStoredPath =  "d:/fileupload/";
                //随机生成文件名
                String randomName = UUID.randomUUID().toString();
                String uploadFileName = file.getOriginalFilename();
                if (StringUtils.isNotBlank(uploadFileName)) {
                    //截取文件格式名
                    String suffix = uploadFileName.substring(uploadFileName.indexOf("."));
                    //重新拼装文件名
                    String newFileName = randomName + suffix;
                    String savePath = basePath + "/" + newFileName;
                    File saveFile = new File(savePath);
                    File parentFile = saveFile.getParentFile();
                    if (saveFile.exists()) {
                        saveFile.delete();
                    } else {
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                    }
                    //复制文件到指定路径
                    FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
                    //上传文件到服务器
                   // FTPClientUtil.upload(saveFile, fileStoredPath);
                    Map map = new HashMap<String,Object>();
                    map.put("savefile",saveFile);
                   // map.put("fileStoredPath",fileStoredPath);
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
