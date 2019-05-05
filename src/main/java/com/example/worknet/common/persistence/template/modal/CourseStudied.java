package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户学习课程记录表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_course_studied")
public class CourseStudied implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户学习课程记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 课程id
     */
    @TableField("course_id")
    private Long courseId;
    /**
     * 课程综合成绩
     */
    private Float score;
    /**
     * 是否完成学习
     */
    @TableField("is_finished")
    private Integer isFinished;
    /**
     * 开始学习时间
     */
    @TableField("start_time")
    private Date startTime;


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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "CourseStudied{" +
        ", id=" + id +
        ", userId=" + userId +
        ", courseId=" + courseId +
        ", score=" + score +
        ", isFinished=" + isFinished +
        ", startTime=" + startTime +
        "}";
    }
}
