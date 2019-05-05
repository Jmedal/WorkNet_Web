package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 公司笔试选项表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-02
 */
@TableName("sys_company_contest_choice_option")
public class CompanyContestChoiceOption implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 笔试选项id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 问题id
     */
    @TableField("question_id")
    private Long questionId;
    /**
     * 选项内容
     */
    private String option;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "CompanyContestChoiceOption{" +
        ", id=" + id +
        ", questionId=" + questionId +
        ", option=" + option +
        "}";
    }
}
