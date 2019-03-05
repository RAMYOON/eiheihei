package com.yoon.eiheihei.utils;

import com.yoon.eiheihei.conf.Global;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 上传文件工具类
 *
 * @author yinkai
 */
public class FileUploadUtils {

    /**
     * 上传文件
     *
     * @param file 待上传的文件
     */
    public static boolean uploadFile(MultipartFile file, String fileName) {
        boolean result = false;
        String path = Global.getProperties("video_upload_path");
        File filePath = new File(path, fileName);
        if (!filePath.getParentFile().exists()) {
            result = filePath.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(path + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getSuffix(String fullFileName) {
        return fullFileName.substring(fullFileName.lastIndexOf(".") + 1);
    }

    public static String getFileName(String fullFileName) {
        return fullFileName.substring(0, fullFileName.lastIndexOf("."));
    }
}
