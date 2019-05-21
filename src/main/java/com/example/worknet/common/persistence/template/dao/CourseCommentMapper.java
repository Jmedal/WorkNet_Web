package com.example.worknet.common.persistence.template.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.worknet.common.persistence.template.modal.CourseComment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程评价表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Component
public interface CourseCommentMapper extends BaseMapper<CourseComment> {

    @Select({"SELECT\n" +
            "\tCOUNT(*) AS starsCount\n" +
            "FROM\n" +
            "\tsys_course_comment\n" +
            "WHERE\n" +
            "\tcourse_id = #{id} and stars = #{star}"})
    HashMap<String,Object> getCourseStarCount(@Param("id") long id, @Param("star")Integer star);

    @Select({"SELECT\n" +
            "\tAVG(stars) AS avgStar\n" +
            "FROM\n" +
            "\tsys_course_comment\n" +
            "WHERE\n" +
            "\tcourse_id = #{id}"})
    HashMap<String,Object> getCourseAvgStar(@Param("id") long id);

    @Select({"SELECT\n" +
            "\tsys_course_comment.user_id,\n" +
            "\tsys_learner_info.nickname,\n" +
            "\tsys_course_comment.stars,\n" +
            "\tsys_course_comment.content\n" +
            "FROM\n" +
            "\tsys_course_comment\n" +
            "JOIN sys_learner_info\n" +
            "WHERE\n" +
            "\tsys_course_comment.course_id = #{id}\n" +
            "AND sys_course_comment.user_id = sys_learner_info.user_id\n" +
            "ORDER BY sys_course_comment.time DESC"})
    @Results(id = "courseCommentResultMap",value = {
            @Result(property = "uid",column = "user_id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "stars",column = "stars"),
            @Result(property = "content",column = "content"),
    })
    List<HashMap<String,Object>> getCourseComments(Pagination pagination, @Param("id") long id);
}
