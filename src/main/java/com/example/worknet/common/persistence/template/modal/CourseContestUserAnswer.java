package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户单元测试答题表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_course_contest_user_answer")
public class CourseContestUserAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单元测试答题id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 单元测试结果id
     */
    @TableField("contest_result_id")
    private Long contestResultId;
    /**
     * 问题id
     */
    @TableField("question_id")
    private Long questionId;
    /**
     * 回答选项id
     */
    @TableField("answer_id")
    private Long answerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestResultId() {
        return contestResultId;
    }

    public void setContestResultId(Long contestResultId) {
        this.contestResultId = contestResultId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "CourseContestUserAnswer{" +
        ", id=" + id +
        ", contestResultId=" + contestResultId +
        ", questionId=" + questionId +
        ", answerId=" + answerId +
        "}";
    }
}
