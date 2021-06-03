package com.example.minichatapp.data.friends;

import android.os.AsyncTask;

import com.example.minichatapp.App;
import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.db.APPDataBase;
import com.example.minichatapp.db.model.FriendRoom;

public class FriendAddRepository {
    private static volatile FriendAddRepository instance;
    private FriendAddDataSource dataSource;

    public static FriendAddRepository getInstance(FriendAddDataSource source) {
        if(instance==null){
            instance=new FriendAddRepository(source);
        }
        return instance;
    }

    public FriendAddRepository(FriendAddDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setFriend(Friend friend){
        //load into local storage
        FriendRoom friendRoom=new FriendRoom(friend.getFid(),friend.getUid(),friend.getF_name(),friend.getNick_name());
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                APPDataBase db= App.getInstance().getDataBase();
                db.friendDao().insertFriendOne(friendRoom).blockingSubscribe();
            }
        });

    }
    public Result<Friend> addFriend(String uid,String f_id){
        Result<Friend> friendResult=dataSource.addFriend(uid,f_id);
        if(friendResult instanceof Result.Success){
            setFriend(((Result.Success<Friend>) friendResult).getData());
        }
        return friendResult;
    }
}
