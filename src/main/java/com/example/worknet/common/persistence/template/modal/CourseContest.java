package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 课程单元测试表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_course_contest")
public class CourseContest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程单元测试id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属课程单元id
     */
    @TableField("course_index_id")
    private Long courseIndexId;
    /**
     * 测试标题
     */
    @TableField("contest_name")
    private String contestName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseIndexId() {
        return courseIndexId;
    }

    public void setCourseIndexId(Long courseIndexId) {
        this.courseIndexId = courseIndexId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    @Override
    public String toString() {
        return "CourseContest{" +
        ", id=" + id +
        ", courseIndexId=" + courseIndexId +
        ", contestName=" + contestName +
        "}";
    }
}
