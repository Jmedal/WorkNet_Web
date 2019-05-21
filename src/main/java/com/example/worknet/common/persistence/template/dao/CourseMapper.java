package com.example.worknet.common.persistence.template.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.worknet.common.persistence.template.modal.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-30
 */
@Component
public interface CourseMapper extends BaseMapper<Course> {

    @Select({"select\n" +
            "sys_course.id,\n" +
            "sys_course.name,\n" +
            "sys_course.introduction,\n" +
            "sys_course.stars,\n" +
            "sys_teacher_info.realname,\n" +
            "sys_course.teacher_id,\n" +
            "sys_course.upload_time,\n" +
            "(select count(*) \n" +
            "from sys_course_click \n" +
            "where sys_course.id = sys_course_click.course_id) as click_num\n" +
            "from sys_course join sys_teacher_info \n" +
            "where (sys_course.name like CONCAT('%',#{keyword},'%') or sys_teacher_info.realname like CONCAT('%',#{keyword},'%') or sys_course.introduction like CONCAT('%',#{keyword},'%')) and sys_course.teacher_id = sys_teacher_info.id \n" +
            "order by click_num desc"})
    @Results(id = "defaultCoursesInfoResultMap",value = {
            @Result(property = "cid",column = "id"),
            @Result(property = "title",column = "name"),
            @Result(property = "abstract",column = "introduction"),
            @Result(property = "stars",column = "stars"),
            @Result(property = "teacherName",column = "realname"),
            @Result(property = "teacherId",column = "teacher_id"),
            @Result(property = "startTime",column = "upload_time"),
            @Result(property = "clickNum",column = "click_num"),
    })
    List<HashMap<String,Object>> getDefaultCoursePage(Pagination pagination, @Param("keyword")String keyword);

    @Select({"select\n" +
            "sys_course.id,\n" +
            "sys_course.name,\n" +
            "sys_course.introduction,\n" +
            "sys_course.stars,\n" +
            "sys_teacher_info.realname,\n" +
            "sys_course.teacher_id,\n" +
            "sys_course.upload_time\n" +
            "from sys_course join sys_teacher_info \n" +
            "where(sys_course.name like CONCAT('%',#{keyword},'%') or sys_teacher_info.realname like CONCAT('%',#{keyword},'%') or sys_course.introduction like CONCAT('%',#{keyword},'%')) and  sys_course.teacher_id = sys_teacher_info.id\n" +
            "order by sys_course.upload_time desc"})
    @Results(id = "newCoursesInfoResultMap",value = {
            @Result(property = "cid",column = "id"),
            @Result(property = "title",column = "name"),
            @Result(property = "abstract",column = "introduction"),
            @Result(property = "stars",column = "stars"),
            @Result(property = "teacherName",column = "realname"),
            @Result(property = "teacherId",column = "teacher_id"),
            @Result(property = "startTime",column = "upload_time"),
    })
    List<HashMap<String,Object>> getNewCoursePage(Pagination pagination, @Param("keyword")String keyword);

    @Select({"select\n" +
            "sys_course.id,\n" +
            "sys_course.name,\n" +
            "sys_course.introduction,\n" +
            "sys_course.stars,\n" +
            "sys_teacher_info.realname,\n" +
            "sys_course.teacher_id,\n" +
            "sys_course.upload_time,\n" +
            "(select count(*) \n" +
            "from sys_course_studied \n" +
            "where sys_course.id = sys_course_studied.course_id) as studied_num\n" +
            "from sys_course join sys_teacher_info\n" +
            "where (sys_course.name like CONCAT('%',#{keyword},'%') or sys_teacher_info.realname like CONCAT('%',#{keyword},'%') or sys_course.introduction like CONCAT('%',#{keyword},'%')) and sys_course.teacher_id = sys_teacher_info.id\n" +
            "order by studied_num desc"})
    @Results(id = "studiedCoursesInfoResultMap",value = {
            @Result(property = "cid",column = "id"),
            @Result(property = "title",column = "name"),
            @Result(property = "abstract",column = "introduction"),
            @Result(property = "stars",column = "stars"),
            @Result(property = "teacherName",column = "realname"),
            @Result(property = "teacherId",column = "teacher_id"),
            @Result(property = "startTime",column = "upload_time"),
            @Result(property = "studiedNum",column = "studied_num"),
    })
    List<HashMap<String,Object>> getStudiedCoursePage(Pagination pagination, @Param("keyword")String keyword);

    @Select({"select\n" +
            "sys_course.id,\n" +
            "sys_course.name,\n" +
            "sys_course.introduction,\n" +
            "sys_course.stars,\n" +
            "sys_teacher_info.realname,\n" +
            "sys_course.teacher_id,\n" +
            "sys_course.upload_time\n" +
            "from sys_course join sys_teacher_info\n" +
            "where (sys_course.name like CONCAT('%',#{keyword},'%') or sys_teacher_info.realname like CONCAT('%',#{keyword},'%') or sys_course.introduction like CONCAT('%',#{keyword},'%')) and sys_course.teacher_id = sys_teacher_info.id\n" +
            "order by sys_course.stars desc"})
    @Results(id = "starCoursesInfoResultMap",value = {
            @Result(property = "cid",column = "id"),
            @Result(property = "title",column = "name"),
            @Result(property = "abstract",column = "introduction"),
            @Result(property = "stars",column = "stars"),
            @Result(property = "teacherName",column = "realname"),
            @Result(property = "teacherId",column = "teacher_id"),
            @Result(property = "startTime",column = "upload_time"),
    })
    List<HashMap<String,Object>> getStarCoursePage(Pagination pagination, @Param("keyword")String keyword);

    @Select({"SELECT\n" +
            "\tsys_course.id,\n" +
            "\tsys_course. NAME,\n" +
            "\tsys_course.introduction AS introduction1,\n" +
            "\tsys_teacher_info.realname,\n" +
            "\tsys_teacher_info.user_id,\n" +
            "\tsys_course.stars,\n" +
            "\tsys_course.upload_time,\n" +
            "\tsys_teacher_info.tag,\n" +
            "\tsys_teacher_info.introduction AS introduction2,\n" +
            "\tsys_curriculum. NAME AS curriculum_name\n" +
            "FROM\n" +
            "\tsys_course\n" +
            "JOIN sys_teacher_info,\n" +
            " sys_curriculum_course\n" +
            "JOIN sys_curriculum\n" +
            "WHERE\n" +
            "\tsys_course.id = #{id}\n" +
            "AND sys_course.teacher_id = sys_teacher_info.id\n" +
            "AND sys_course.id = sys_curriculum_course.course_id\n" +
            "AND sys_curriculum_course.curriculum_id = sys_curriculum.id"})
    @Results(id = "CourseInfoResultMap",value = {
            @Result(property = "cid",column = "id"),
            @Result(property = "title",column = "name"),
            @Result(property = "abstract",column = "introduction1"),
            @Result(property = "teacherName",column = "realname"),
            @Result(property = "teacherId",column = "user_id"),
            @Result(property = "stars",column = "stars"),
            @Result(property = "field",column = "curriculum_name"),
            @Result(property = "startTime",column = "upload_time"),
            @Result(property = "teacherTitle",column = "tag"),
            @Result(property = "teacherInfo",column = "introduction2"),
    })
    HashMap<String,Object> getCourseInfo( @Param("id")Long id);
}
