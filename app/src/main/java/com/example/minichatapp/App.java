package com.example.minichatapp;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.example.minichatapp.db.APPDataBase;

import io.rong.imkit.RongIM;

public class App extends Application {
    private static App instance;
    private APPDataBase dataBase;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        dataBase= Room.databaseBuilder(getApplicationContext(),APPDataBase.class,"mini-chat").allowMainThreadQueries().build();

        RongIM.init(this,"8luwapkv86p3l",false);
    }

    public static App getInstance() {
        return instance;
    }

    public APPDataBase getDataBase() {
        return dataBase;
    }
}

