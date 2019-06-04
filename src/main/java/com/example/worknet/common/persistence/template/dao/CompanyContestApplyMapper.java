package com.example.worknet.common.persistence.template.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.worknet.common.persistence.template.modal.CompanyContestApply;
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
 * 公司笔试报名表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
@Component
public interface CompanyContestApplyMapper extends BaseMapper<CompanyContestApply> {

    @Select("SELECT\n" +
            "\tsys_company_contest.id,\n" +
            "\tsys_company_contest.title,\n" +
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
            "\t) AS joinNum,\n" +
            "\tsys_company_contest.company_id\n" +
            "FROM\n" +
            "\tsys_company_contest\n" +
            "JOIN sys_company_contest_apply\n" +
            "WHERE\n" +
            "\tsys_company_contest_apply.user_id = #{id}\n" +
            "AND sys_company_contest_apply.contest_id = sys_company_contest.id\n" +
            "ORDER BY\n" +
            "\tsys_company_contest_apply.sign_up_time DESC")
    @Results(id = "teacherInfoResultMap",value = {
            @Result(property = "cid",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "startTime",column = "start_time"),
            @Result(property = "questionNum",column = "questionNum"),
            @Result(property = "joinNum",column = "joinNum"),
            @Result(property = "companyId",column = "company_id"),
    })
    List<HashMap<String,Object>> getUserCompanyContestPage(Pagination pagination, @Param("id") Long id);
}
