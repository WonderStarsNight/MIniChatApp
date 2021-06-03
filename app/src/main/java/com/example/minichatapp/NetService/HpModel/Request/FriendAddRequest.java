package com.example.minichatapp.NetService.HpModel.Request;

public class FriendAddRequest {
    String uid;
    String f_id;

    public FriendAddRequest(String uid, String f_id) {
        this.uid = uid;
        this.f_id = f_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }
}
