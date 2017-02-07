package com.kevindai.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by daiwenkai on 2017/2/7.
 */
public class PackageApkPojo {
    private String channelNum;
    private MultipartFile fileMsg;//与jsp中文件框id保持一致

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }

    public MultipartFile getFileMsg() {
        return fileMsg;
    }

    public void setFileMsg(MultipartFile fileMsg) {
        this.fileMsg = fileMsg;
    }
}
