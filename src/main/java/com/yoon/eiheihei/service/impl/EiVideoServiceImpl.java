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

/**
 * 视频业务逻辑层实现
 *
 * @author yinkai
 */
@Service
public class EiVideoServiceImpl implements EiVideoService {

    @Autowired
    private EiVideoMapper eiVideoMapper;

    @Override
    public List<EiVideo> getVideoList() {
        EiVideoExample eiVideoExample = new EiVideoExample();
        return eiVideoMapper.selectByExample(eiVideoExample);
    }

    @Override
    public void uploadVideo(MultipartFile file) {
        try {
            checkParam(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileName = file.getOriginalFilename();
        String id = IDUtils.uuid();
        String suffix = FileUploadUtils.getSuffix(fileName);
        String videoUrl = Global.getProperties("server_url") + id + "." + suffix;
        String videoName = FileUploadUtils.getFileName(fileName);

        if (!file.isEmpty()) {
            FileUploadUtils.uploadFile(file, id + "." + suffix);
        }
        EiVideo eiVideo = new EiVideo();
        eiVideo.setId(id);
        eiVideo.setVideoUrl(videoUrl);
        eiVideo.setSuffixs(suffix);
        eiVideo.setVideoName(videoName);
        eiVideoMapper.insert(eiVideo);
    }

    private void checkParam(MultipartFile file) throws Exception {
        if (file == null) {
            throw new Exception("00000001");
        }
    }
}
