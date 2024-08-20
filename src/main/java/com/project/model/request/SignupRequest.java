package com.project.model.request;

public class SignupRequest {
    String user_id;
    String password;
    String name;
    String nickname;
    String email;
    String preference;

    public SignupRequest() {
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPreference() { return preference; }

    public void setPreference(String preference) { this.preference = preference; }
}
