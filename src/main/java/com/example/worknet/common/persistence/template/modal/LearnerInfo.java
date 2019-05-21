package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 学习者信息表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-07
 */
@TableName("sys_learner_info")
public class LearnerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学习者id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 学历
     */
    private String vacation;
    /**
     * github帐号
     */
    private String github;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 目标职业
     */
    private String professional;


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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getVacation() {
        return vacation;
    }

    public void setVacation(String vacation) {
        this.vacation = vacation;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "LearnerInfo{" +
        ", id=" + id +
        ", userId=" + userId +
        ", nickname=" + nickname +
        ", realname=" + realname +
        ", sex=" + sex +
        ", age=" + age +
        ", signature=" + signature +
        ", vacation=" + vacation +
        ", github=" + github +
        ", email=" + email +
        ", phone=" + phone +
        ", hobby=" + hobby +
        ", professional=" + professional +
        "}";
    }
}
