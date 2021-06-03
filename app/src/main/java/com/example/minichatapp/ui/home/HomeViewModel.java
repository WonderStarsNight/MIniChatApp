package com.example.minichatapp.ui.home;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.minichatapp.BottomActivity;
import com.example.minichatapp.data.Result;
import com.example.minichatapp.data.home.HomeRepository;
import com.example.minichatapp.data.model.User;

import java.util.concurrent.CompletableFuture;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> uid;
    private MutableLiveData<String> u_name;
    private HomeRepository homeRepository;

    public HomeViewModel(HomeRepository homeRepository) {
        uid=new MutableLiveData<>();
        u_name=new MutableLiveData<>();
        this.homeRepository=homeRepository;
        init();
    }

    public MutableLiveData<String> getUid() {
        return uid;
    }

    public MutableLiveData<String> getU_name() {
        return u_name;
    }


    private void init(){
        Result<User> userResult=homeRepository.getUser();
        if(userResult instanceof Result.Success){
            User user=((Result.Success<User>) userResult).getData();
            uid.setValue(user.getUid());
            u_name.setValue(user.getName());
        }else {
            uid.setValue("unknown error");
            u_name.setValue("unknown error");
        }
    }
}