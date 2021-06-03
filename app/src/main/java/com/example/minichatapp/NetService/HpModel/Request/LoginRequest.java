package com.example.minichatapp.NetService.HpModel.Request;

import com.example.minichatapp.NetService.HpModel.Base.Message;

public class LoginRequest {
    private String uid;
    private String password;
    public LoginRequest(String uid,String password) {
        this.uid=uid;
        this.password=password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
