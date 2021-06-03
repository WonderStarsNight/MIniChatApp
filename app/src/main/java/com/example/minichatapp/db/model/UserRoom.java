package com.example.minichatapp.db.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "user")
public class UserRoom {
    @PrimaryKey
    @ColumnInfo(name = "uid")
    @NonNull
    public String  uid = null;
    @ColumnInfo(name = "user_name")
    public String userName;
    @ColumnInfo(name = "is_log")
    public int isLog;

    @Override
    public String toString() {
        return "UserRoom{" +
                "uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                ", isLog=" + isLog +
                '}';
    }
}
