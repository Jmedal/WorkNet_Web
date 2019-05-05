package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 单元测试成绩表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_course_contest_score")
public class CourseContestScore implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单元测试成绩id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 所属课程单元id
     */
    @TableField("course_index_id")
    private Long courseIndexId;
    /**
     * 测试成绩
     */
    private Float score;
    /**
     * 参考时间
     */
    @TableField("take_time")
    private Date takeTime;


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

    public Long getCourseIndexId() {
        return courseIndexId;
    }

    public void setCourseIndexId(Long courseIndexId) {
        this.courseIndexId = courseIndexId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Date getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Date takeTime) {
        this.takeTime = takeTime;
    }

    @Override
    public String toString() {
        return "CourseContestScore{" +
        ", id=" + id +
        ", userId=" + userId +
        ", courseIndexId=" + courseIndexId +
        ", score=" + score +
        ", takeTime=" + takeTime +
        "}";
    }
}
