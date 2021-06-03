package com.example.minichatapp.NetService.HpModel.Response;

import com.example.minichatapp.NetService.HpModel.Base.Message;

public class FriendResponse extends Message {
    String fid;
    String uid;
    String f_name;
    String nick_name;

    public FriendResponse(int code, String message, String fid, String uid, String f_name, String nick_name) {
        super(code, message);
        this.fid = fid;
        this.uid = uid;
        this.f_name = f_name;
        this.nick_name = nick_name;
    }

    public FriendResponse(int code, String message) {
        super(code, message);
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
}
