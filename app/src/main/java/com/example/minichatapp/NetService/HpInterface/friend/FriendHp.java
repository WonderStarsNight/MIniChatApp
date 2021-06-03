package com.example.minichatapp.NetService.HpInterface.friend;

import com.example.minichatapp.NetService.Base.Hp;
import com.example.minichatapp.NetService.Base.HpException;
import com.example.minichatapp.NetService.HpModel.Response.FriendAddResponse;
import com.example.minichatapp.NetService.HpModel.Response.FriendResponse;
import com.example.minichatapp.data.model.Friend;

import java.util.List;

public interface FriendHp extends Hp {
    List<FriendResponse> getFriendsById(String id)throws HpException;
    FriendAddResponse addFriend(String uid, String id)throws HpException;
}
