package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 职业分类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_profession_type")
public class ProfessionType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职业id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 职业分类名称
     */
    @TableField("type_name")
    private String typeName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "ProfessionType{" +
        ", id=" + id +
        ", typeName=" + typeName +
        "}";
    }
}
