package com.example.minichatapp.NetService.HpModel.Request;

public class FriendRequest {
    private String uid;


    public FriendRequest(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
