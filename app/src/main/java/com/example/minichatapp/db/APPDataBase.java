package com.example.minichatapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.db.dao.FriendDao;
import com.example.minichatapp.db.dao.UserDao;
import com.example.minichatapp.db.model.FriendRoom;
import com.example.minichatapp.db.model.UserRoom;

@Database(entities = {UserRoom.class, FriendRoom.class},version = 1,exportSchema = false)
public abstract class APPDataBase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract FriendDao friendDao();
}
