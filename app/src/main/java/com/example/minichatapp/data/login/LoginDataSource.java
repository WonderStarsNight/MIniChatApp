package com.example.minichatapp.data.login;

import com.example.minichatapp.NetService.HpImpl.login.LoginHpImpl;
import com.example.minichatapp.NetService.HpModel.Response.LoginResponse;
import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String uid, String password) {

        try {
            // 网络登录操作
            LoginResponse response=new LoginHpImpl().login(uid,password);
            LoggedInUser user=null;
            if(response.getCode()>0){
                user =
                        new LoggedInUser(true,
                                uid,response.getName(),response.getToken()
                        );
            }else {
                user =
                        new LoggedInUser(false,
                                null,null,null
                        );
            }
            return new Result.Success<>(user);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

}