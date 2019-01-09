package com.yoon.eiheihei.controller;

import com.yoon.eiheihei.domain.EiVideo;
import com.yoon.eiheihei.service.EiVideoService;
import com.yoon.eiheihei.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/video")
public class EiVideoController {

    @Autowired
    private EiVideoService eiVideoService;

    /**
     * 获取列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<EiVideo> getVideoList() {
        return eiVideoService.getVideoList();
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String uploadVideo(@RequestParam("file") MultipartFile file) {
        eiVideoService.uploadVideo(file);
        return "success";
    }

}
