package com.example.minichatapp.NetService.HpModelForRong.Response;

public class TokenGetResponse {
    int code;
    String token;
    String userId;

    public TokenGetResponse(int code, String token, String userId) {
        this.code = code;
        this.token = token;
        this.userId = userId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
