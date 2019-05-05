package com.example.worknet.common.persistence.affair.course.serivce;

import com.example.worknet.common.persistence.template.modal.Course;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-30
 */
public interface CourseService extends IService<Course> {


    boolean insertCourse(Course course);

    boolean updateCourse(Course course);
}
