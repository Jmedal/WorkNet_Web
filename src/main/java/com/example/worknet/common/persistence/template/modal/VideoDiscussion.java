package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 讨论表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_video_discussion")
public class VideoDiscussion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 讨论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 视频id
     */
    @TableField("video_id")
    private Long videoId;
    /**
     * 回复对象id（0：回复视频；非0：回复评论（值为最上级评论id））
     */
    @TableField("reply_to_id")
    private Long replyToId;
    /**
     * 回复用户id（0：回复视频或者回复最上级评论；非0：回复评论（值为被回复的用户id））
     */
    @TableField("reply_user_id")
    private Long replyUserId;
    /**
     * 回答时间
     */
    @TableField("reply_time")
    private Date replyTime;
    /**
     * 讨论内容
     */
    private String content;


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

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(Long replyToId) {
        this.replyToId = replyToId;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "VideoDiscussion{" +
        ", id=" + id +
        ", userId=" + userId +
        ", videoId=" + videoId +
        ", replyToId=" + replyToId +
        ", replyUserId=" + replyUserId +
        ", replyTime=" + replyTime +
        ", content=" + content +
        "}";
    }
}
