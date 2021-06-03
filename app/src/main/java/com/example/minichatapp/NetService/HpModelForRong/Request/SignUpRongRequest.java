package com.example.minichatapp.NetService.HpModelForRong.Request;

public class SignUpRongRequest {
    String userId;
    String name;

    public SignUpRongRequest(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public SignUpRongRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
