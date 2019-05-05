package com.example.worknet.common.persistence.template.modal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 播放记录表
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@TableName("sys_video_watched")
public class VideoWatched implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 播放记录id
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
     * 观看时长
     */
    @TableField("videl_watched_length")
    private Long videlWatchedLength;


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

    public Long getVidelWatchedLength() {
        return videlWatchedLength;
    }

    public void setVidelWatchedLength(Long videlWatchedLength) {
        this.videlWatchedLength = videlWatchedLength;
    }

    @Override
    public String toString() {
        return "VideoWatched{" +
        ", id=" + id +
        ", userId=" + userId +
        ", videoId=" + videoId +
        ", videlWatchedLength=" + videlWatchedLength +
        "}";
    }
}
