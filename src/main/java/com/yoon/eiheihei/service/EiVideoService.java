package com.yoon.eiheihei.service;

import com.yoon.eiheihei.domain.EiVideo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EiVideoService {

    @Transactional(readOnly = true)
    List<EiVideo> getVideoList();

    @Transactional
    void uploadVideo(MultipartFile file);

}
