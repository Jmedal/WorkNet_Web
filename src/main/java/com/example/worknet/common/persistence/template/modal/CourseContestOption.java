package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 选项表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-02
 */
@TableName("sys_course_contest_option")
public class CourseContestOption implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 选项id
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
    @TableField("option_content")
    private String optionContent;


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

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    @Override
    public String toString() {
        return "CourseContestOption{" +
        ", id=" + id +
        ", questionId=" + questionId +
        ", optionContent=" + optionContent +
        "}";
    }
}
