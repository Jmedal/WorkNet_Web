package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 公司笔试报名表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
@TableName("sys_company_contest_apply")
public class CompanyContestApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报名id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 笔试id
     */
    @TableField("contest_id")
    private Long contestId;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 是否有效（考试时间、作弊等）
     */
    private Integer permission;
    /**
     * 报名时间
     */
    @TableField("sign_up_time")
    private Date signUpTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Date getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    @Override
    public String toString() {
        return "CompanyContestApply{" +
        ", id=" + id +
        ", contestId=" + contestId +
        ", userId=" + userId +
        ", permission=" + permission +
        ", signUpTime=" + signUpTime +
        "}";
    }
}
