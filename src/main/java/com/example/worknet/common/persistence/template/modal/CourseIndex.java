package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 课程目录表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_course_index")
public class CourseIndex implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程目录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属课程id
     */
    @TableField("course_id")
    private Long courseId;
    /**
     * 目录等级
     */
    private Integer scale;
    /**
     * 目录位置
     */
    @TableField("index_order")
    private Integer indexOrder;
    /**
     * 目录标题
     */
    @TableField("index_title")
    private String indexTitle;


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

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Integer getIndexOrder() {
        return indexOrder;
    }

    public void setIndexOrder(Integer indexOrder) {
        this.indexOrder = indexOrder;
    }

    public String getIndexTitle() {
        return indexTitle;
    }

    public void setIndexTitle(String indexTitle) {
        this.indexTitle = indexTitle;
    }

    @Override
    public String toString() {
        return "CourseIndex{" +
        ", id=" + id +
        ", courseId=" + courseId +
        ", scale=" + scale +
        ", indexOrder=" + indexOrder +
        ", indexTitle=" + indexTitle +
        "}";
    }
}
