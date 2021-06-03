package com.example.minichatapp.data.friends;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;


import com.example.minichatapp.App;
import com.example.minichatapp.NetService.Base.HpException;
import com.example.minichatapp.NetService.HpImpl.friend.FriendHpImpl;
import com.example.minichatapp.NetService.HpModel.Response.FriendResponse;
import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.db.dao.FriendDao;
import com.example.minichatapp.db.model.FriendRoom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendDataSource {
    private LiveData<List<FriendRoom>> friendsLiveData;
    private final FriendDao dao;
    public FriendDataSource() {
        dao= App.getInstance().getDataBase().friendDao();
        //friendsLiveData=dao.getFriendsByUId(uid);
    }
    public Result<List<Friend>> getFriends(String uid){
        List<Friend> friendList=new ArrayList<>();
        //if (friendsLiveData==null||friendsLiveData.getValue()==null){
            List<FriendRoom> friendRoomList=new ArrayList<>();
            //remote
            try{
                List<FriendResponse> responseList=new FriendHpImpl().getFriendsById(uid);
                for(FriendResponse response:responseList){
                    if (response.getCode()>0){
                        friendList.add(new Friend(response.getFid(),response.getUid(),response.getF_name(),response.getNick_name()));
                        friendRoomList.add(new FriendRoom(response.getFid(),response.getUid(),response.getF_name(),response.getNick_name()));
                    }else {
                        return new Result.Error(new IOException("Error fetching friends"));
                    }
                }
                //load into room
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        if(friendRoomList.size()>0){
                            dao.insertFriends(friendRoomList).blockingSubscribe();
                            friendsLiveData=dao.getFriendsByUId(uid);
                        }
                    }
                });
            }catch (HpException hp){
                return new Result.Error(new Exception("NetService was shut down."));
            }
        for (Friend f:friendList
             ) {
            Log.d("friendListItme",f.toString());
        }
//        }else {
//            //room
//            List<FriendRoom> friendRoomList=friendsLiveData.getValue();
//            for (FriendRoom friendRoom:friendRoomList){
//                friendList.add(new Friend(friendRoom.fid,friendRoom.uid,friendRoom.f_name,friendRoom.nick_name));
//            }
//        }
        return new Result.Success<>(friendList);
    }

    public LiveData<List<FriendRoom>> getFriendsLiveData() {
        return friendsLiveData;
    }
}
