package com.example.worknet.common.persistence.affair.course.serivce;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.CourseComment;
import com.baomidou.mybatisplus.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程评价表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
public interface CourseCommentService extends IService<CourseComment> {

    HashMap<String,Object> getCourseStarCount(long cid);

    Page<HashMap<String,Object>> getCourseComments(Page<HashMap<String, Object>> page, long cid);

    boolean insertCourseComment(long uid, long cid, float star, String comment);
}
