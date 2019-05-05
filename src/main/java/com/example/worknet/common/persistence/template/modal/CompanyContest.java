package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 公司笔试表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_company_contest")
public class CompanyContest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司笔试id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 公司id
     */
    @TableField("company_id")
    private Long companyId;
    /**
     * 笔试开始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 笔试结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 是否激活
     */
    private Integer activity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "CompanyContest{" +
        ", id=" + id +
        ", companyId=" + companyId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", activity=" + activity +
        "}";
    }
}
