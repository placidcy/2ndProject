package com.project.model.request;

public class LoginRequest {
    String user_id;
    String password;
    boolean rememberId;

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

    public void setRememberId(boolean rememberId) {
        this.rememberId = rememberId;
    }

    public boolean isRememberId() {
        return rememberId;
    }
}
