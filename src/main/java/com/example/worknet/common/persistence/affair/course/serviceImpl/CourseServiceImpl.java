package com.example.worknet.common.persistence.affair.course.serviceImpl;

import com.example.worknet.common.persistence.affair.course.serivce.*;
import com.example.worknet.common.persistence.template.modal.Course;
import com.example.worknet.common.persistence.template.dao.CourseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.common.persistence.template.modal.CourseClick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-30
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public boolean insertCourse(Course course){
        return courseService.insert(course);
    }

    /**
     * 更新课程信息
     * @param course
     * @return
     */
    @Override
    public boolean updateCourse(Course course){
        return courseService.updateById(course);
    }

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseClickService courseClickService;

    @Autowired
    private CourseCommentService courseCommentService;

    @Autowired
    private CourseIndexService courseIndexService;

    @Autowired
    private CourseStudiedService courseStudiedService;
}
