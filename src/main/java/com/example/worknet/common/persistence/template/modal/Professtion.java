package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 职业表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_professtion")
public class Professtion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职业id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 职业名称
     */
    private String name;
    /**
     * 职业薪资
     */
    private Float salary;
    /**
     * 职业分类id
     */
    @TableField("type_id")
    private Long typeId;


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

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Professtion{" +
        ", id=" + id +
        ", name=" + name +
        ", salary=" + salary +
        ", typeId=" + typeId +
        "}";
    }
}
