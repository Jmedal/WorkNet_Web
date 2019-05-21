package com.example.worknet.common.persistence.affair.video.serviceImpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.VideoDiscussion;
import com.example.worknet.common.persistence.template.dao.VideoDiscussionMapper;
import com.example.worknet.common.persistence.affair.video.serivce.VideoDiscussionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讨论表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class VideoDiscussionServiceImpl extends ServiceImpl<VideoDiscussionMapper, VideoDiscussion> implements VideoDiscussionService {

    /**
     * 获取课程视频的评价
     * @param vid
     * @return
     */
    @Override
    public Page<HashMap<String,Object>> getCourseVideoComments(Page<HashMap<String, Object>> page, long vid){
        return page.setRecords(videoDiscussionMapper.getVideoComments(page,vid));
    }


    /**
     * 获得课程视频的评价的回复
     * @param commentId
     * @return
     */
    @Override
    public Page<HashMap<String,Object>> getCourseVideoSubComments(Page<HashMap<String, Object>> page, long commentId){
        return page.setRecords(videoDiscussionMapper.getVideoSubComments(page,commentId));
    }

    /**
     * 添加课程视频的评价
     * @param userId
     * @param content
     * @param val
     * @return
     */
    @Override
    public boolean insertComment(long userId, String content, long... val){ //val[0] = vid, val[1] = replyToId, val[2] = replyUserId,
        if(val[0] == 0 && val[1] != 0)
            val[0] = super.selectById(val[1]).getVideoId();
        VideoDiscussion videoDiscussion = new VideoDiscussion();
        videoDiscussion.setUserId(userId);
        videoDiscussion.setVideoId(val[0]);
        videoDiscussion.setReplyToId(val[1]);
        videoDiscussion.setReplyUserId(val[2]);
        videoDiscussion.setReplyTime(DateUtil.getSqlNowDateTime());
        videoDiscussion.setContent(content);
        return super.insert(videoDiscussion);
    }

    @Autowired
    private VideoDiscussionMapper videoDiscussionMapper;
}
