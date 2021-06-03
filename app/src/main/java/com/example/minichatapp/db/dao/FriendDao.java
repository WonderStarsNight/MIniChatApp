package com.example.minichatapp.db.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.minichatapp.db.model.FriendRoom;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface FriendDao {
    @Query("select * from friend where uid=:uid")
    LiveData<List<FriendRoom>> getFriendsByUId(String uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertFriends(List<FriendRoom> roomList);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertFriendOne(FriendRoom friendRoom);
}
