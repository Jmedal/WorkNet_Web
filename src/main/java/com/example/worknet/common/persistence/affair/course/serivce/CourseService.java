package com.example.worknet.common.persistence.affair.course.serivce;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.template.modal.Course;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.List;

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

    HashMap<String,Object> getCourseInfo(long cid);

    Page<HashMap<String,Object>> getCoursePage(Page<HashMap<String, Object>> page, Integer type, String keyword);

    List<HashMap<String,Object>> getCourseMenu(long cid);

    Resource getCoursePicture(long cid, String strDirPath);
}
