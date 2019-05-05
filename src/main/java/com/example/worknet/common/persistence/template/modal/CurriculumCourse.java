package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 科目_课程关系表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_curriculum_course")
public class CurriculumCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关系id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 课程id
     */
    @TableField("course_id")
    private Long courseId;
    /**
     * 科目id
     */
    @TableField("curriculum_id")
    private Long curriculumId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    @Override
    public String toString() {
        return "CurriculumCourse{" +
        ", id=" + id +
        ", courseId=" + courseId +
        ", curriculumId=" + curriculumId +
        "}";
    }
}
