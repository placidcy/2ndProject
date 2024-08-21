package com.project.model.request;

import java.util.List;

public class editProfileRequest {
    private String user_id;
    private String name;
    private String nickname;
    private String email;
    private List<Career> careers; // 경력 항목 리스트 추가

    // 기본 생성자
    public editProfileRequest() {
    }

    // 게터 및 세터
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Career> getCareers() {
        return careers;
    }

    public void setCareers(List<Career> careers) {
        this.careers = careers;
    }
}
