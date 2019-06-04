package com.example.worknet.common.persistence.template.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.worknet.common.persistence.template.modal.CompanyContest;
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
 * 公司笔试表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
@Component
public interface CompanyContestMapper extends BaseMapper<CompanyContest> {

    @Select({"SELECT\n" +
            "\tsys_company_contest.id,\n" +
            "\tsys_company_contest.title,\n" +
            "\tsys_company.`name`,\n" +
            "\tsys_company.id as id1,\n" +
            "\tsys_company_contest.start_time,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(*)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_company_contest_question\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_company_contest_question.contest_id = sys_company_contest.id\n" +
            "\t) AS questionNum\n" +
            "FROM\n" +
            "\tsys_company_contest\n" +
            "JOIN sys_company\n" +
            "WHERE\n" +
            "\t(\n" +
            "\t\tsys_company_contest.title LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t\tOR sys_company.`name` LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t\tOR sys_company_contest.start_time LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t)\n" +
            "AND sys_company_contest.company_id = sys_company.id"})
    @Results(id = "defaultContestInfoResultMap",value = {
            @Result(property = "examId",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "companyName",column = "name"),
            @Result(property = "companyId",column = "id1"),
            @Result(property = "startTime",column = "start_time", javaType = String.class),
            @Result(property = "questionNum",column = "questionNum"),
    })
    List<HashMap<String,Object>> getDefaultContestPage(Pagination pagination, @Param("keyword")String keyword);

    @Select({"SELECT\n" +
            "\tsys_company_contest.id,\n" +
            "\tsys_company_contest.title,\n" +
            "\tsys_company.`name`,\n" +
            "\tsys_company.id as id1,\n" +
            "\tsys_company_contest.start_time,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(*)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_company_contest_question\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_company_contest_question.contest_id = sys_company_contest.id\n" +
            "\t) AS questionNum,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(*)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_company_contest_apply\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_company_contest_apply.contest_id = sys_company_contest.id\n" +
            "\t) AS joinNum\n" +
            "FROM\n" +
            "\tsys_company_contest\n" +
            "JOIN sys_company\n" +
            "WHERE\n" +
            "\t(\n" +
            "\t\tsys_company_contest.title LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t\tOR sys_company.`name` LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t\tOR sys_company_contest.start_time LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t)\n" +
            "AND sys_company_contest.company_id = sys_company.id\n" +
            "ORDER BY\n" +
            "\tjoinNum DESC"})
    @Results(id = "mostContestInfoResultMap",value = {
            @Result(property = "examId",column = "sys_company_contest.id"),
            @Result(property = "title",column = "title"),
            @Result(property = "companyName",column = "name"),
            @Result(property = "companyId",column = "id1"),
            @Result(property = "startTime",column = "start_time", javaType = String.class),
            @Result(property = "questionNum",column = "questionNum"),
    })
    List<HashMap<String,Object>> getMostContestPage(Pagination pagination, @Param("keyword")String keyword);


    @Select({"SELECT\n" +
            "\tsys_company_contest.id,\n" +
            "\tsys_company_contest.title,\n" +
            "\tsys_company.`name`,\n" +
            "\tsys_company.id as id1,\n" +
            "\tsys_company_contest.start_time,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(*)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_company_contest_question\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_company_contest_question.contest_id = sys_company_contest.id\n" +
            "\t) AS questionNum\n" +
            "FROM\n" +
            "\tsys_company_contest\n" +
            "JOIN sys_company\n" +
            "WHERE\n" +
            "\t(\n" +
            "\t\tsys_company_contest.title LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t\tOR sys_company.`name` LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t\tOR sys_company_contest.start_time LIKE CONCAT('%', #{keyword}, '%')\n" +
            "\t)\n" +
            "AND sys_company_contest.company_id = sys_company.id\n" +
            "ORDER BY\n" +
            "\tsys_company_contest.id DESC"})
    @Results(id = "newContestInfoResultMap",value = {
            @Result(property = "examId",column = "sys_company_contest.id"),
            @Result(property = "title",column = "title"),
            @Result(property = "companyName",column = "name"),
            @Result(property = "companyId",column = "id1"),
            @Result(property = "startTime",column = "start_time", javaType = String.class),
            @Result(property = "questionNum",column = "questionNum"),
    })
    List<HashMap<String,Object>> getNewContestPage(Pagination pagination, @Param("keyword")String keyword);

    @Select("SELECT\n" +
            "\tsys_company_contest.id,\n" +
            "\tsys_company_contest.start_time,\n" +
            "\tsys_company_contest.end_time,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(*)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_company_contest_question\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_company_contest_question.contest_id = sys_company_contest.id\n" +
            "\t) AS question_num,\n" +
            "(\n" +
            "\t\tSELECT\n" +
            "\t\t\tSUM(question_type)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_company_contest_question\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_company_contest_question.contest_id = sys_company_contest.id\n" +
            "\t) AS question_core,\n" +
            "\tsys_company_contest.title,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(*)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_company_contest_apply\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_company_contest_apply.contest_id = sys_company_contest.id AND sys_company_contest_apply.user_id = #{uid}\n" +
            "\t) AS joined\n" +
            "FROM\n" +
            "\tsys_company_contest\n" +
            "WHERE\n" +
            "\tsys_company_contest.id = #{eid}")
    @Results(id = "ContestInfoResultMap",value = {
            @Result(property = "examId",column = "id"),
            @Result(property = "Stime",column = "start_time"),
            @Result(property = "Etime",column = "end_time"),
            @Result(property = "Qnumber",column = "question_num"),
            @Result(property = "Ascore",column = "question_core"),
            @Result(property = "name",column = "title"),
            @Result(property = "joined",column = "joined",javaType = Boolean.class),
    })
    HashMap<String,Object> getContestInfo( @Param("eid")long eid, @Param("uid")long uid);
}
