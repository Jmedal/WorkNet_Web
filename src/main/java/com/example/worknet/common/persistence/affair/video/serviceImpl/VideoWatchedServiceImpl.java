package com.example.worknet.common.persistence.affair.video.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.example.worknet.common.persistence.template.modal.VideoWatched;
import com.example.worknet.common.persistence.template.dao.VideoWatchedMapper;
import com.example.worknet.common.persistence.affair.video.serivce.VideoWatchedService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 播放记录表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class VideoWatchedServiceImpl extends ServiceImpl<VideoWatchedMapper, VideoWatched> implements VideoWatchedService {

    /**
     * 获得视频观看历史进度
     * @param uid
     * @param vid
     * @param percent
     * @return
     */
    @Override
    public boolean insertWatched(long uid, long vid, String percent){
        VideoWatched videoWatched = new VideoWatched();
        videoWatched.setUserId(uid);
        videoWatched.setVideoId(vid);
        videoWatched.setVidelWatchedLength(Long.valueOf(percent.replaceAll("%","")));
        return super.insert(videoWatched);
    }
}
