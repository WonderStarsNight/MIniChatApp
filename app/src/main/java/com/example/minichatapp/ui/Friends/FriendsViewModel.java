package com.example.minichatapp.ui.Friends;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.friends.FriendRepository;
import com.example.minichatapp.data.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class FriendsViewModel extends ViewModel {
    public MutableLiveData<List<Friend>> getFriendListData() {
        return friendListData;
    }

    public FriendRepository getRepository() {
        return repository;
    }

    private final MutableLiveData<List<Friend>> friendListData;
    private final FriendRepository repository;

    public FriendsViewModel(FriendRepository repository) {
        friendListData=new MutableLiveData<>();
        this.repository=repository;
    }
    public void init(String uid){
        Result<List<Friend>> result=repository.getFriends(uid);
        if(result instanceof Result.Success){
            List<Friend> friendList= ((Result.Success<List<Friend>>) result).getData();
            friendListData.setValue(friendList);
        }
        //test
        /*List<Friend> friendList=new ArrayList<>();
        friendList.add(new Friend("1234","1234567","xiaoming","nick1"));
        friendList.add(new Friend("12345","1234567","xiaming",null));
        friendListData.setValue(friendList);*/
    }

}