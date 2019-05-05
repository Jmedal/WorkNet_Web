package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 讲师信息登记表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_teacher_info")
public class TeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 讲师id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 讲师用户账号id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 身份证号
     */
    private String identity;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 讲师头衔
     */
    private String tag;
    /**
     * 经历简介
     */
    private String introduction;
    /**
     * github帐号
     */
    private String github;


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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
        ", id=" + id +
        ", userId=" + userId +
        ", realname=" + realname +
        ", identity=" + identity +
        ", phone=" + phone +
        ", email=" + email +
        ", tag=" + tag +
        ", introduction=" + introduction +
        ", github=" + github +
        "}";
    }
}
