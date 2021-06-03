package com.example.minichatapp.NetService.HpModel.Base;

import java.io.Serializable;

public class Message implements Serializable {
    //@param: code 1成功 0未初始化 -1错误
    //@param: message 错误信息提示或其他信息
    private int code;
    private String message;

    public Message() {
        code=0;
        message=null;
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
