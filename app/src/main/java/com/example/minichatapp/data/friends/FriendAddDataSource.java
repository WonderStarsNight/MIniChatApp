package com.example.minichatapp.data.friends;

import com.example.minichatapp.NetService.Base.HpException;
import com.example.minichatapp.NetService.HpImpl.friend.FriendHpImpl;
import com.example.minichatapp.NetService.HpModel.Response.FriendAddResponse;
import com.example.minichatapp.NetService.HpModel.Response.FriendResponse;
import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.model.Friend;
import com.example.minichatapp.ui.BottomViewModel;

import java.io.IOException;

public class FriendAddDataSource {
    Result<Friend> addFriend(String uid,String f_id){
        //net
        try {
            FriendAddResponse response = new FriendHpImpl().addFriend(uid, f_id);
            if(response.getCode()>0){
                Friend friend=new Friend(response.getId(),uid,response.getName(),null);
                return new Result.Success<>(friend);
            }else {
                return new Result.Error(new Exception("had added"));
            }
        }catch (HpException hpException){
            return new Result.Error(new Exception("NetService wsa shut down"));
        }

    }
}
