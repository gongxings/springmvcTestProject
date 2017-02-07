package com.kevindai.web;

import com.kevindai.pojo.PackageApkPojo;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

/**
 * Created by daiwenkai on 2017/2/7.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }


    /**
     * 方法写的很粗糙,就是接收上传文件并保存返回下载文件
     * @param packageApkPojo
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/packagedApk")
    @ResponseBody
    public ResponseEntity<byte[]> packagedApk(PackageApkPojo packageApkPojo) throws IOException {
        System.out.println(packageApkPojo.getChannelNum());
        InputStream inputStream = packageApkPojo.getFileMsg().getInputStream();
        String fileName = packageApkPojo.getFileMsg().getOriginalFilename();

        OutputStream outputStream = new FileOutputStream("d:" + File.separator + fileName);
        byte[] b = new byte[1024];
        int c;
        while((c = inputStream.read(b)) > 0){
            outputStream.write(b);
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();




        File file = new File("d:" + File.separator + fileName);
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
        //return "upload success";
    }
}
