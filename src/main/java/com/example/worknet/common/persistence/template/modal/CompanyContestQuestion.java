package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 公司笔试问题表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-02
 */
@TableName("sys_company_contest_question")
public class CompanyContestQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属笔试id
     */
    @TableField("contest_id")
    private Long contestId;
    /**
     * 问题内容
     */
    private String question;
    /**
     * 正确选项id
     */
    @TableField("correct_option_id")
    private Long correctOptionId;
    /**
     * 问题序号
     */
    @TableField("order_no")
    private Integer orderNo;
    /**
     * 问题类型
     */
    @TableField("question_type")
    private Integer questionType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(Long correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "CompanyContestQuestion{" +
        ", id=" + id +
        ", contestId=" + contestId +
        ", question=" + question +
        ", correctOptionId=" + correctOptionId +
        ", orderNo=" + orderNo +
        ", questionType=" + questionType +
        "}";
    }
}
