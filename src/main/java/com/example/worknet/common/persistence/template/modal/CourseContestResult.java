package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 单元测试结果表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_course_contest_result")
public class CourseContestResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单元测试结果id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 所属课程测试id
     */
    @TableField("course_contest_id")
    private Long courseContestId;
    /**
     * 开始测试时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 结束测试时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 测试得分
     */
    private Integer score;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseContestId() {
        return courseContestId;
    }

    public void setCourseContestId(Long courseContestId) {
        this.courseContestId = courseContestId;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CourseContestResult{" +
        ", id=" + id +
        ", userId=" + userId +
        ", courseContestId=" + courseContestId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", score=" + score +
        "}";
    }
}
