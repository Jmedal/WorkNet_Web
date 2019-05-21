package com.example.worknet.common.persistence.template.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.worknet.common.persistence.template.modal.VideoDiscussion;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讨论表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Component
public interface VideoDiscussionMapper extends BaseMapper<VideoDiscussion> {

    @Select({"SELECT\n" +
            "\tsys_video_discussion.user_id,\n" +
            "\tsys_learner_info.nickname,\n" +
            "\tsys_video_discussion.id AS discussion_id,\n" +
            "\tsys_video_discussion.content,\n" +
            "\tsys_video_discussion.reply_time,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tCOUNT(*)\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_video_discussion\n" +
            "\t\tWHERE\n" +
            "\t\t\tsys_video_discussion.video_id = #{id}\n" +
            "\t\tAND sys_video_discussion.reply_to_id = discussion_id\n" +
            "\t) AS replyNum\n" +
            "FROM\n" +
            "\tsys_video_discussion\n" +
            "JOIN sys_learner_info\n" +
            "WHERE\n" +
            "\tsys_video_discussion.video_id = #{id}\n" +
            "AND sys_video_discussion.reply_to_id = 0\n" +
            "AND sys_video_discussion.user_id = sys_learner_info.user_id\n" +
            "ORDER BY\n" +
            "\tsys_video_discussion.reply_time DESC"})
    @Results(id = "VideoCommentResultMap",value = {
            @Result(property = "uid",column = "user_id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "commentId",column = "discussion_id"),
            @Result(property = "content",column = "content"),
            @Result(property = "commentTime",column = "reply_time"),
            @Result(property = "replyNum",column = "replyNum"),
    })
    List<HashMap<String,Object>> getVideoComments(Pagination pagination, @Param("id") long id);

    @Select({"SELECT\n" +
            "\tsys_video_discussion.id,\n" +
            "\tsys_video_discussion.reply_to_id,\n" +
            "\tsys_video_discussion.user_id,\n" +
            "\tsys_learner_info.nickname,\n" +
            "\tsys_video_discussion.reply_user_id,\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tsys_learner_info.nickname\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_learner_info \n" +
            "\t\tWHERE\n" +
            "\t\t\t sys_learner_info.user_id = sys_video_discussion.reply_user_id \n" +
            "\t) AS reply_user_nickname,\n" +
            "\tsys_video_discussion.content,\n" +
            "\tsys_video_discussion.reply_time\n" +
            "FROM\n" +
            "\tsys_video_discussion\n" +
            "JOIN sys_learner_info\n" +
            "WHERE\n" +
            "\tsys_video_discussion.reply_to_id = #{id}\n" +
            "AND sys_video_discussion.user_id = sys_learner_info.user_id\n" +
            "ORDER BY\n" +
            "\tsys_video_discussion.reply_time DESC"})
    @Results(id = "VideoSubCommentsResultMap",value = {
            @Result(property = "replyId",column = "id"),
            @Result(property = "commentId",column = "reply_to_id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "replyToUserId",column = "reply_user_id"),
            @Result(property = "replyToNickname",column = "reply_user_nickname"),
            @Result(property = "content",column = "content"),
            @Result(property = "replyTime",column = "reply_time"),
    })
    List<HashMap<String,Object>> getVideoSubComments(Pagination pagination, @Param("id") long id);
}
