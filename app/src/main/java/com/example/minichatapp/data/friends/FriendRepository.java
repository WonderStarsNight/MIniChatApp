package com.example.minichatapp.data.friends;

import androidx.lifecycle.LiveData;

import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.db.model.FriendRoom;

import java.util.List;

public class FriendRepository {
    private static volatile FriendRepository instance;
    private FriendDataSource dataSource;

    public static FriendRepository getInstance(FriendDataSource dataSource) {
        if(instance==null){
            instance=new FriendRepository(dataSource);
        }
        return instance;
    }
    private FriendRepository(FriendDataSource dataSource){
        this.dataSource=dataSource;
    }

    public Result<List<Friend>> getFriends(String uid){
        return dataSource.getFriends(uid);
    }
    public LiveData<List<FriendRoom>> getFriendLiveData(){
        return dataSource.getFriendsLiveData();
    }
}
