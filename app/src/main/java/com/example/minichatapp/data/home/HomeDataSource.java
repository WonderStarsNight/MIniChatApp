package com.example.minichatapp.data.home;

import com.example.minichatapp.App;
import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.User;
import com.example.minichatapp.db.APPDataBase;
import com.example.minichatapp.db.model.UserRoom;

import java.io.IOException;

import io.reactivex.rxjava3.core.Single;

public class HomeDataSource {
    public Result<User> getUser(){
        //访问数据库，并返回信息
        APPDataBase appDataBase= App.getInstance().getDataBase();
        Single<UserRoom> userSingle=appDataBase.userDao().getLogUser();
        try{
            UserRoom u=userSingle.blockingGet();
            User user=new User(u.uid,u.userName);
            return new Result.Success<>(user);
        }catch (NullPointerException e){
            return new Result.Error(new IOException("Error getUser in",e));
        }
    }
}
