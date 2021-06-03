package com.example.minichatapp.NetService.HpModel.Response;

import com.example.minichatapp.NetService.HpModel.Base.Message;

public class FriendAddResponse extends Message {
    String id;
    String name;
    public FriendAddResponse() {
    }

    public FriendAddResponse(int code, String message) {
        super(code, message);
    }

    public FriendAddResponse(int code, String message, String id, String name) {
        super(code, message);
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
