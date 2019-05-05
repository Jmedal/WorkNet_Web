package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 课程视频表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_course_video")
public class CourseVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 视频id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属课程id
     */
    @TableField("course_Index_id")
    private Long courseIndexId;
    /**
     * 课程标题
     */
    @TableField("video_title")
    private String videoTitle;
    /**
     * 发布时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 视频时长
     */
    @TableField("video_len")
    private Long videoLen;
    /**
     * 视频文件路径
     */
    @TableField("video_path")
    private String videoPath;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseIndexId() {
        return courseIndexId;
    }

    public void setCourseIndexId(Long courseIndexId) {
        this.courseIndexId = courseIndexId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getVideoLen() {
        return videoLen;
    }

    public void setVideoLen(Long videoLen) {
        this.videoLen = videoLen;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        return "CourseVideo{" +
        ", id=" + id +
        ", courseIndexId=" + courseIndexId +
        ", videoTitle=" + videoTitle +
        ", updateTime=" + updateTime +
        ", videoLen=" + videoLen +
        ", videoPath=" + videoPath +
        "}";
    }
}
