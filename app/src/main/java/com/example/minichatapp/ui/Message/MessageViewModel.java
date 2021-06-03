package com.example.minichatapp.ui.Message;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.minichatapp.data.model.Message;

import java.util.List;

public class MessageViewModel extends ViewModel {
    private MutableLiveData<List<Message>> messageList;

    public MessageViewModel(){
        messageList=new MutableLiveData<>();
    }

}