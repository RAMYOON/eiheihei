package com.yoon.eiheihei.service;

import com.yoon.eiheihei.domain.EiVideo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 视频业务逻辑层接口
 *
 * @author yinkai
 */
public interface EiVideoService {

    /**
     * 获取文件列表（没有分页）
     *
     * @return 文件列表
     */
    @Transactional(readOnly = true)
    List<EiVideo> getVideoList();

    /**
     * 上传文件
     *
     * @param file 文件
     */
    @Transactional
    void uploadVideo(MultipartFile file);

}
