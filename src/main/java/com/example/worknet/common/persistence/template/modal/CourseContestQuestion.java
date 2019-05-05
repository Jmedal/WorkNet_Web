package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 问题表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-02
 */
@TableName("sys_course_contest_question")
public class CourseContestQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属课程单元测试id
     */
    @TableField("contest_question_id")
    private Long contestQuestionId;
    /**
     * 正确答案id
     */
    @TableField("correct_option_id")
    private Long correctOptionId;
    /**
     * 问题内容
     */
    @TableField("question_content")
    private String questionContent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestQuestionId() {
        return contestQuestionId;
    }

    public void setContestQuestionId(Long contestQuestionId) {
        this.contestQuestionId = contestQuestionId;
    }

    public Long getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(Long correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Override
    public String toString() {
        return "CourseContestQuestion{" +
        ", id=" + id +
        ", contestQuestionId=" + contestQuestionId +
        ", correctOptionId=" + correctOptionId +
        ", questionContent=" + questionContent +
        "}";
    }
}
