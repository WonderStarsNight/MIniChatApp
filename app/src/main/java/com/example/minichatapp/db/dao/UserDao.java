package com.example.minichatapp.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.minichatapp.db.model.UserRoom;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;


@Dao
public interface UserDao {
    @Query("select * from user")
    List<UserRoom> getAll();
    @Insert
    Completable insertOne(UserRoom userRoom);
    @Update
    Completable updateOne(UserRoom userRoom);
    @Query("delete from user where uid = :uid")
    Completable delete(String uid);
    @Query("select * from user where uid = :uid")
    Single<UserRoom> getById(String uid);
    @Query("update user set is_log=0 where is_log=1")
    Completable updateLog();
    @Query("select * from user where is_log=1")
    Single<UserRoom> getLogUser();

}
