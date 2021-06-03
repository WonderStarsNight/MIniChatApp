package com.example.minichatapp.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.minichatapp.data.friends.FriendAddDataSource;
import com.example.minichatapp.data.friends.FriendAddRepository;
import com.example.minichatapp.data.friends.FriendDataSource;
import com.example.minichatapp.data.friends.FriendRepository;
import com.example.minichatapp.data.login.LoginDataSource;
import com.example.minichatapp.data.login.LoginRepository;
import com.example.minichatapp.ui.login.LoginViewModel;

public class FriendAddViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FriendAddViewModel.class)) {
            return (T) new FriendAddViewModel(FriendAddRepository.getInstance(new FriendAddDataSource()));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
