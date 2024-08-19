package com.project.model.response;

public class LoginUserResponse {
    private String user_id;
    private String nickname;

    public LoginUserResponse(String user_id, String nickname) {
        this.user_id = user_id;
        this.nickname = nickname;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }
}
