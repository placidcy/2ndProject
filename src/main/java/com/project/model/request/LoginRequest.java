package com.project.model.request;

public class LoginRequest {
    String user_id;
    String password;

    public LoginRequest() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String userId) {
        this.user_id = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
