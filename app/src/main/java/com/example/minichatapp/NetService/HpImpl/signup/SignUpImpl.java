package com.example.minichatapp.NetService.HpImpl.signup;

import android.util.Log;

import com.example.minichatapp.NetService.Base.HpException;
import com.example.minichatapp.NetService.HpInterface.signup.SignUpHp;
import com.example.minichatapp.NetService.HpModel.Base.Message;
import com.example.minichatapp.NetService.HpModel.Request.SignUpRequest;
import com.example.minichatapp.NetService.HpModelForRong.Request.SignUpRongRequest;
import com.example.minichatapp.NetService.HpModelForRong.Response.SignUpRongResponse;
import com.example.minichatapp.NetService.UrlPatterns;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class SignUpImpl implements SignUpHp {
    @Override
    public boolean signUp(String uid, String password, String u_name) throws HpException, InterruptedException, ExecutionException, IOException {
        SignUpRequest signUpRequest=new SignUpRequest(uid,password,u_name);
        String rq=gson.toJson(signUpRequest);
        Log.d("signupMessage","start to send");
        String rp=post(UrlPatterns.SIGN_UP,rq);
        Log.d("signupMessage","receive");
        Message message=new Gson().fromJson(rp,Message.class);
        Log.d("signupMessage","convert");
        if(message.getCode()>0){
            //app server注册成功
            List<String> params=new ArrayList<>();
            params.add("userId");
            params.add("name");
            List<String> paramsValues=new ArrayList<>();
            paramsValues.add(uid);
            paramsValues.add(u_name);
            RequestBody body=new FormBody(params,paramsValues);
            String rpRong=postRong(UrlPatterns.RONG_SIGN_UP,body);
            SignUpRongResponse signUpRongResponse=gson.fromJson(rpRong,SignUpRongResponse.class);
            Log.d("signUpRongResponse",String.valueOf(signUpRongResponse.getCode()));
            return signUpRongResponse.getCode()==200;
        }else {
            return false;
        }
    }
}
