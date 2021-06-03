package com.example.minichatapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.friends.FriendAddRepository;
import com.example.minichatapp.data.model.Friend;


public class FriendAddViewModel extends ViewModel {
    private FriendAddRepository repository;
    public FriendAddViewModel(FriendAddRepository repository){
        this.repository=repository;
    }
    public boolean addFriend(String uid,String f_id){
        Result<Friend> result=repository.addFriend(uid,f_id);
        return result instanceof Result.Success;
    }
}
