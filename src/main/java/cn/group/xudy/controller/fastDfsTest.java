package cn.group.xudy.controller;


import cn.group.xudy.utils.FastdfsClientUtils;
import cn.group.xudy.utils.FilesUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/fileUploads")
public class fastDfsTest {
    private static final Logger log = LogManager.getLogger(TestController.class);
    /**
     * 文件上传测试
     */
    @RequestMapping("/upload")
    public Map fileUpload(@RequestParam("file") MultipartFile file,
                          HttpServletRequest request) {
       // String contentType = file.getContentType();   //图片文件类型
        //String fileName = file.getOriginalFilename();  //图片名字
        Map filemap = FilesUtils.upload(request);
        System.out.println(filemap.get(""));
        log.info("开始上传");
        String filepath = request.getParameter("filename");
        File files = new File(filepath);//"D:\\MyFile\\mine\\img\\koala.jpg" 暂时注掉
        Map<String,String> metaList = new HashMap<String, String>();
        metaList.put("width","1024");
        metaList.put("height","768");
        metaList.put("author","");
        metaList.put("date","");
        String fid = FastdfsClientUtils.uploadFile(files,file.getName(),metaList);
        System.out.println("upload local file " + files.getPath() + " ok, fileid=" + fid);
        //上传成功返回的文件ID： group1/M00/00/00/wKgAyVgFk9aAB8hwAA-8Q6_7tHw351.jpg
        Map map = new HashMap();
        map.put("fid",fid);
        return map;
    }

    /**
     * 文件下载测试
     */
    @RequestMapping("/fileDownload")
    public Map fileDownload(@PathVariable(name = "filename") String filename) {
        String result = FastdfsClientUtils.downloadFile(filename, new File(filename));//"group1/M00/00/00/wKgAyVgFk9aAB8hwAA-8Q6_7tHw351.jpg"
        System.out.println(result == null ? "下载失败" : "下载成功");
        Map map = new HashMap();
        if(result!=null){
            map.put("msg","下载成功");
        }else{
            map.put("msg","下载失败");
        }
        return map;

    }

    /**
     * 获取文件元数据测试
     */
    @Test
    public void testGetFileMetadata() {
        Map<String,String> metaList = FastdfsClientUtils.getFileMetadata("group1/M00/00/00/wKgAyVgFk9aAB8hwAA-8Q6_7tHw351.jpg");
        for (Iterator<Map.Entry<String,String>>  iterator = metaList.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String,String> entry = iterator.next();
            String name = entry.getKey();
            String value = entry.getValue();
            System.out.println(name + " = " + value );
        }
    }

    /**
     * 文件删除测试
     */
    @Test
    public void testDelete() {
        int r = FastdfsClientUtils.deleteFile("group1/M00/00/00/wKgAyVgFk9aAB8hwAA-8Q6_7tHw351.jpg");
        System.out.println(r == 0 ? "删除成功" : "删除失败");
    }
}
