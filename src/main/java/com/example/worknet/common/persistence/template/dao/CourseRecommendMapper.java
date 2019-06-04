package com.example.worknet.common.persistence.template.dao;

import com.example.worknet.common.persistence.template.modal.CourseRecommend;
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
 * 职业推荐课程表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-06-04
 */
@Component
public interface CourseRecommendMapper extends BaseMapper<CourseRecommend> {

    @Select("SELECT\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tsys_curriculum.`name`\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_curriculum\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_course_recommend.curriculum_id = sys_curriculum.id\n" +
            "\t) AS curriculum_name,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tsys_curriculum.`name`\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_curriculum\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_curriculum_tree.pre_curriculum_id = sys_curriculum.id\n" +
            "\t) AS p_curriculum_name\n" +
            "FROM\n" +
            "\tsys_course_recommend\n" +
            "JOIN sys_user_profession,\n" +
            " sys_curriculum_tree\n" +
            "WHERE\n" +
            "\tsys_user_profession.user_id = #{id}\n" +
            "AND sys_user_profession.profession_id = sys_course_recommend.profession_id\n" +
            "AND sys_course_recommend.curriculum_id = sys_curriculum_tree.curriculum_id;")
    @Results(id = "teacherInfoResultMap",value = {
            @Result(property = "courseName",column = "curriculum_name"),
            @Result(property = "preCourseName",column = "p_curriculum_name"),
    })
    List<HashMap<String,Object>> getUserRecommendCurriculum(@Param("id") Long id);
}
