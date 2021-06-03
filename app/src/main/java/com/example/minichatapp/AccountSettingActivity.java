package com.example.minichatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AccountSettingActivity extends AppCompatActivity {

    public static void ActionStart(Context context){
        Intent intent=new Intent(context,AccountSettingActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
    }
}