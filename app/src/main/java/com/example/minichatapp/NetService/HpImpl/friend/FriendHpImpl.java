package com.example.minichatapp.NetService.HpImpl.friend;

import com.example.minichatapp.NetService.Base.HpException;
import com.example.minichatapp.NetService.Base.HttpPost;
import com.example.minichatapp.NetService.HpInterface.friend.FriendHp;
import com.example.minichatapp.NetService.HpModel.Request.FriendAddRequest;
import com.example.minichatapp.NetService.HpModel.Request.FriendRequest;
import com.example.minichatapp.NetService.HpModel.Response.FriendAddResponse;
import com.example.minichatapp.NetService.HpModel.Response.FriendResponse;
import com.example.minichatapp.NetService.UrlPatterns;
import com.example.minichatapp.data.model.Friend;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FriendHpImpl implements FriendHp {
    @Override
    public List<FriendResponse> getFriendsById(String id)throws HpException {
        List<FriendResponse> responseList=new ArrayList<>();
        try {
            String rp=get(UrlPatterns.FRIENDS_GET+id);
            Type listType=new TypeToken<List<FriendResponse>>(){}.getType();
            responseList=gson.fromJson(rp,listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO: handle request
        return responseList;
    }

    @Override
    public FriendAddResponse addFriend(String uid,String id)throws HpException {
        FriendAddRequest request=new FriendAddRequest(uid,id);
        FriendAddResponse response= new FriendAddResponse(-1,null);
        try {
            String rp = post(UrlPatterns.FRIEND_ADD,gson.toJson(request));
            response=gson.fromJson(rp,FriendAddResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }
}
