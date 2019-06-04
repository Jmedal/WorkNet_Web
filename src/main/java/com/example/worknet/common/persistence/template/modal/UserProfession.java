package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户选择职业表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-06-04
 */
@TableName("sys_user_profession")
public class UserProfession implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户选择id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 职业id
     */
    @TableField("profession_id")
    private Long professionId;


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

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    @Override
    public String toString() {
        return "UserProfession{" +
        ", id=" + id +
        ", userId=" + userId +
        ", professionId=" + professionId +
        "}";
    }
}
