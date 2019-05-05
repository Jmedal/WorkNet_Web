package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 课程树表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_curriculum_tree")
public class CurriculumTree implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 结点id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 科目id
     */
    @TableField("curriculum_id")
    private Long curriculumId;
    /**
     * 前置科目id
     */
    @TableField("pre_curriculum_id")
    private Long preCurriculumId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Long getPreCurriculumId() {
        return preCurriculumId;
    }

    public void setPreCurriculumId(Long preCurriculumId) {
        this.preCurriculumId = preCurriculumId;
    }

    @Override
    public String toString() {
        return "CurriculumTree{" +
        ", id=" + id +
        ", curriculumId=" + curriculumId +
        ", preCurriculumId=" + preCurriculumId +
        "}";
    }
}
