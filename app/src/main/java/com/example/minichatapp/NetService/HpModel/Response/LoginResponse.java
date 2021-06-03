package com.example.minichatapp.NetService.HpModel.Response;

import com.example.minichatapp.NetService.HpModel.Base.Message;

public class LoginResponse extends Message {

    private String uid;
    private String name;
    private String token;
    public LoginResponse() {
    }

    public LoginResponse(int code, String message) {
        super(code, message);
    }

    public LoginResponse(int code, String message, String uid, String name) {
        super(code, message);
        this.uid = uid;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
