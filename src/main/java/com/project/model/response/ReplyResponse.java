package com.project.model.response;

import com.project.model.ReplyDO;

public class ReplyResponse {
    private int reply_id;
    private String content;
    private String created_at;
    private int likes;
    private String user_id;
    private long post_id;

    private String nickname;

    public ReplyResponse(ReplyDO replyDO, String nickname) {
        this.reply_id = replyDO.getReply_id();
        this.content = replyDO.getContent();
        this.created_at = replyDO.getCreated_at();
        this.likes = replyDO.getLikes();
        this.user_id = replyDO.getUser_id();
        this.post_id = replyDO.getPost_id();
        this.nickname = nickname;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
