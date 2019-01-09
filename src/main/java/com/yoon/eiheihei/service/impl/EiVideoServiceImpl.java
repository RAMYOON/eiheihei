package com.yoon.eiheihei.service.impl;

import com.yoon.eiheihei.conf.Global;
import com.yoon.eiheihei.dao.EiVideoMapper;
import com.yoon.eiheihei.domain.EiVideo;
import com.yoon.eiheihei.domain.EiVideoExample;
import com.yoon.eiheihei.service.EiVideoService;
import com.yoon.eiheihei.utils.FileUploadUtils;
import com.yoon.eiheihei.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EiVideoServiceImpl implements EiVideoService {

    @Autowired
    private EiVideoMapper eiVideoMapper;

    @Override
    public List<EiVideo> getVideoList(){
        EiVideoExample eiVideoExample = new EiVideoExample();
        return eiVideoMapper.selectByExample(eiVideoExample);
    }

    @Override
    public void uploadVideo(MultipartFile file) {
        String id = IDUtils.uuid();
        if(!file.isEmpty()) {
            FileUploadUtils.uploadFile(file,id);
        }
        EiVideo eiVideo = new EiVideo();
        eiVideo.setId(id);
        eiVideo.setVideoUrl(Global.getProperties("server_url"));
        eiVideo.setSuffixs(FileUploadUtils.getSuffix(file.getOriginalFilename()));
        eiVideo.setVideoName(FileUploadUtils.getFileName(file.getOriginalFilename()));

        eiVideoMapper.insert(eiVideo);
    }
}
