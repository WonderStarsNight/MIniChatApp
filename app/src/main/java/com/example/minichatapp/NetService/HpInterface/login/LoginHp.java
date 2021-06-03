package com.example.minichatapp.NetService.HpInterface.login;

import com.example.minichatapp.NetService.Base.Hp;
import com.example.minichatapp.NetService.HpModel.Response.LoginResponse;

public interface LoginHp extends Hp {
    LoginResponse login(String uid, String password);
}
