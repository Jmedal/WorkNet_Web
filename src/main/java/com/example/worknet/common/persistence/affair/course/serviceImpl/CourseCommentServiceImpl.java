package com.example.worknet.common.persistence.affair.course.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.CourseComment;
import com.example.worknet.common.persistence.template.dao.CourseCommentMapper;
import com.example.worknet.common.persistence.affair.course.serivce.CourseCommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程评价表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class CourseCommentServiceImpl extends ServiceImpl<CourseCommentMapper, CourseComment> implements CourseCommentService {

    /**
     * 获取课程的评分
     * @param cid
     * @return
     */
    @Override
    public HashMap<String,Object> getCourseStarCount(long cid){
        HashMap<String,Object> star = courseCommentMapper.getCourseAvgStar(cid);
        if(star == null || star.get("avgStar") == null || star.get("avgStar").equals("")){
            star = new HashMap<>();
            star.put("avgStar",0);
        }
        for(int i=1;i<=5;i++){
            HashMap<String,Object> map = courseCommentMapper.getCourseStarCount(cid,i);
            if(map.get("starsCount") != null && !map.get("starsCount").equals(""))
                star.put("star"+i,map.get("starsCount"));
            else
                star.put("star"+i,0);
        }
        return star;
    }

    /**
     * 获取课程的评价
     * @param cid
     * @return
     */
    @Override
    public Page<HashMap<String,Object>> getCourseComments(Page<HashMap<String, Object>> page, long cid){
        return page.setRecords(courseCommentMapper.getCourseComments(page,cid));
    }

    /**
     * 添加课程评分评价
     * @param uid
     * @param cid
     * @param star
     * @param comment
     * @return
     */
    @Override
    public boolean insertCourseComment(long uid, long cid, float star, String comment){
        CourseComment courseComment = new CourseComment();
        courseComment.setUserId(uid);
        courseComment.setCourseId(cid);
        courseComment.setStars(star);
        courseComment.setContent(comment);
        courseComment.setTime(DateUtil.getSqlNowDateTime());
       return super.insert(courseComment);
    }

    @Autowired
    private CourseCommentMapper courseCommentMapper;
}
