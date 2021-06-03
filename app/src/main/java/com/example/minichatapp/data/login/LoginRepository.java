package com.example.minichatapp.data.login;

import android.os.AsyncTask;
import android.util.Log;

import com.example.minichatapp.App;
import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.LoggedInUser;
import com.example.minichatapp.db.APPDataBase;
import com.example.minichatapp.db.model.UserRoom;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }


    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        UserRoom u=new UserRoom();
        u.uid=user.getUserId();
        u.userName=user.getDisplayName();
        u.isLog=1;
        APPDataBase db=App.getInstance().getDataBase();
        //先修改isLog=true用于切换账号
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                db.userDao().updateLog().blockingSubscribe();
                db.userDao().delete(u.uid).blockingSubscribe();
                Log.d("userRoomLogin",u.toString());
                db.userDao().insertOne(u).blockingSubscribe();
            }
        });
    }

    public Result<LoggedInUser> login(String username, String password) {
        // handle login
        Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            LoggedInUser loggedInUser=((Result.Success<LoggedInUser>) result).getData();
            if(loggedInUser.isOk()){
                setLoggedInUser(loggedInUser);
            }
        }
        return result;
    }
}