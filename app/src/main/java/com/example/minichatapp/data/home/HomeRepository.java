package com.example.minichatapp.data.home;

import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.User;

public class HomeRepository {
    private static volatile HomeRepository instance;
    private HomeDataSource dataSource;

    private HomeRepository(HomeDataSource dataSource)
    {
        this.dataSource=dataSource;
    }
    public static HomeRepository getInstance(HomeDataSource dataSource){
        if(instance==null){
            instance=new HomeRepository(dataSource);
        }
        return instance;
    }
    public Result<User> getUser(){
        Result<User> user=dataSource.getUser();
        return user;
    }

}
