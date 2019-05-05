package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 课程表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-30
 */
@TableName("sys_course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 发布者id
     */
    @TableField("teacher_id")
    private Long teacherId;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程介绍
     */
    private String introduction;
    /**
     * 综合评分
     */
    private Float stars;
    /**
     * 课程开设时间
     */
    @TableField("upload_time")
    private Date uploadTime;
    /**
     * 封面图片路径
     */
    @TableField("picture_path")
    private String picturePath;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Course{" +
        ", id=" + id +
        ", teacherId=" + teacherId +
        ", name=" + name +
        ", introduction=" + introduction +
        ", stars=" + stars +
        ", uploadTime=" + uploadTime +
        ", picturePath=" + picturePath +
        ", activity=" + activity +
        "}";
    }
}
