package com.example.worknet.common.persistence.template.modal;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司id
     */
    private Long id;
    /**
     * 公司帐号id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 公司简介
     */
    private String introduction;
    /**
     * 公司名称
     */
    private String address;
    /**
     * 注册时间
     */
    @TableField("registe_time")
    private Date registeTime;


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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisteTime() {
        return registeTime;
    }

    public void setRegisteTime(Date registeTime) {
        this.registeTime = registeTime;
    }

    @Override
    public String toString() {
        return "Company{" +
        ", id=" + id +
        ", userId=" + userId +
        ", introduction=" + introduction +
        ", address=" + address +
        ", registeTime=" + registeTime +
        "}";
    }
}
