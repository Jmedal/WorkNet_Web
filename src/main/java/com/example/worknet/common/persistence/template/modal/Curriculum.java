package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 科目表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_curriculum")
public class Curriculum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 科目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 科目名称
     */
    private String name;
    /**
     * 科目介绍
     */
    private String introduction;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
        ", id=" + id +
        ", name=" + name +
        ", introduction=" + introduction +
        "}";
    }
}
