package com.example.minichatapp.data.model;

public class Friend {
    String fid;
    String uid;
    String f_name;
    String nick_name;

    public Friend(String fid, String uid, String f_name, String nick_name) {
        this.fid = fid;
        this.uid = uid;
        this.f_name = f_name;
        this.nick_name = nick_name;
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

    @Override
    public String toString() {
        return "Friend{" +
                "fid='" + fid + '\'' +
                ", uid='" + uid + '\'' +
                ", f_name='" + f_name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                '}';
    }
}
