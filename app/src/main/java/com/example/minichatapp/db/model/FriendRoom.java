package com.example.minichatapp.db.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "friend",primaryKeys = {"fid","uid"})
public class FriendRoom {

    @ColumnInfo(name = "fid")
    @NonNull
    public String fid="-1";
    @ColumnInfo(name = "uid")
    @NonNull
    public String uid="-1";
    @ColumnInfo(name = "f_name")
    public String f_name;
    @ColumnInfo(name = "nick_name")
    public String nick_name;

    public FriendRoom(@NonNull String fid, @NonNull String uid, String f_name, String nick_name) {
        this.fid = fid;
        this.uid = uid;
        this.f_name = f_name;
        this.nick_name = nick_name;
    }
}
