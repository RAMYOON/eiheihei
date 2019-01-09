package com.yoon.eiheihei.utils;

import com.yoon.eiheihei.conf.Global;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 上传文件工具类
 */
public class FileUploadUtils {

    /**
     * 上传文件
     *
     * @param file
     */
    public static void uploadFile(MultipartFile file,String id) {

        String path = Global.getProperties("video_upload_path");
        String fileName = id;
        File filePath = new File(path, fileName);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(path + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSuffix(String fullFileName) {
        return fullFileName.substring(fullFileName.lastIndexOf(".") + 1);
    }

    public static String getFileName(String fullFileName) {
        return fullFileName.substring(0,fullFileName.lastIndexOf("."));
    }
}
