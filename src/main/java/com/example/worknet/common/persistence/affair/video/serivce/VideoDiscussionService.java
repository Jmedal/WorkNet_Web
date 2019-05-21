package com.example.worknet.common.persistence.affair.video.serivce;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.VideoDiscussion;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * <p>
 * 讨论表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
public interface VideoDiscussionService extends IService<VideoDiscussion> {

    Page<HashMap<String,Object>> getCourseVideoComments(Page<HashMap<String, Object>> page, long vid);

    Page<HashMap<String,Object>> getCourseVideoSubComments(Page<HashMap<String, Object>> page, long commentId);

    boolean insertComment(long userId, String content, long... val);
}
