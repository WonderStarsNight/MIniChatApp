package com.example.minichatapp.NetService.HpImpl.login;

import com.example.minichatapp.NetService.HpImpl.friend.FriendHpImpl;
import com.example.minichatapp.NetService.HpInterface.login.LoginHp;
import com.example.minichatapp.NetService.HpModel.Request.LoginRequest;
import com.example.minichatapp.NetService.HpModel.Response.LoginResponse;
import com.example.minichatapp.NetService.HpModelForRong.Response.TokenGetResponse;
import com.example.minichatapp.NetService.UrlPatterns;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.FormBody;

public class LoginHpImpl implements LoginHp {
    @Override
    public LoginResponse login(String uid, String password) {
        LoginRequest loginRequest=new LoginRequest(uid,password);
        LoginResponse loginResponse=new LoginResponse(-1,null);
        try {
            String response=post(UrlPatterns.LOGIN,new Gson().toJson(loginRequest));
            loginResponse=gson.fromJson(response,LoginResponse.class);
            if(loginResponse.getCode()>0){
                List<String> params=new ArrayList<>();
                params.add("userId");
                params.add("name");
                List<String> paramsValues=new ArrayList<>();
                paramsValues.add(uid);
                paramsValues.add(loginResponse.getName());
                String rpRong=postRong(UrlPatterns.TOKEN_GET,new FormBody(params,paramsValues));
                TokenGetResponse tokenGetResponse=gson.fromJson(rpRong,TokenGetResponse.class);
                loginResponse.setToken(tokenGetResponse.getToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return loginResponse;



    }
}
