package com.example.minichatapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BottomViewModel extends ViewModel {
    private MutableLiveData<String> uid;
    private MutableLiveData<String> u_name;
    private MutableLiveData<Boolean> is_logout;
    private String token;


    public BottomViewModel(){
        uid=new MutableLiveData<>();
        u_name=new MutableLiveData<>();
        is_logout=new MutableLiveData<>();
        is_logout.setValue(false);
    }

    public MutableLiveData<String> getUid() {
        return uid;
    }

    public MutableLiveData<String> getU_name() {
        return u_name;
    }

    public MutableLiveData<Boolean> getIs_logout() {
        return is_logout;
    }

    public void logout(){
        is_logout.setValue(true);
    }

    public void setToken(String token) {
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "BottomViewModel{" +
                "uid=" + uid.getValue() +
                ", u_name=" + u_name.getValue() +
                ", is_logout=" + is_logout.getValue() +
                ", token='" + token + '\'' +
                '}';
    }
}
