package com.example.minichatapp.ui.Friends;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.minichatapp.data.friends.FriendDataSource;
import com.example.minichatapp.data.friends.FriendRepository;

import com.example.minichatapp.ui.home.HomeViewModel;

public class FriendsViewModelFactory implements ViewModelProvider.Factory{
    private String uid;

    public FriendsViewModelFactory(String uid) {
        this.uid = uid;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FriendsViewModel.class)) {
            return (T) new FriendsViewModel(FriendRepository.getInstance(new FriendDataSource()));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
