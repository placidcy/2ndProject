package com.project.model.response;

import java.io.Serializable;

public class LoginUserResponse implements Serializable {
    private String user_id;
    private String name;
    private String nickname;
    private String email;

    public LoginUserResponse(String user_id, String nickname) {
        this.user_id = user_id;
        this.nickname = nickname;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() { return name; }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() { return email; }
}
