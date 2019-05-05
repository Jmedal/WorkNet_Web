package com.example.worknet.common.persistence.template.modal;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 公司笔试回答表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_company_contest_result")
public class CompanyContestResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 笔试回答id
     */
    private Long id;
    /**
     * 回答所属笔试id
     */
    @TableField("contest_id")
    private Long contestId;
    /**
     * 回答用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 问题id
     */
    @TableField("question_id")
    private Long questionId;
    /**
     * 开始回答时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 结束回答时间
     */
    @TableField("end_time")
    private Date endTime;
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

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "CompanyContestResult{" +
        ", id=" + id +
        ", contestId=" + contestId +
        ", userId=" + userId +
        ", questionId=" + questionId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", answerId=" + answerId +
        "}";
    }
}
