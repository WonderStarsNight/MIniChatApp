package com.example.minichatapp.NetService.Base;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class HpException extends Exception implements Serializable {
    private static final long serialVersionUID=19192L;
    private String message;
    public HpException(String message) {
        super(message);
        this.message = message;
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HpException{" +
                "message='" + message + '\'' +
                '}';
    }
}
