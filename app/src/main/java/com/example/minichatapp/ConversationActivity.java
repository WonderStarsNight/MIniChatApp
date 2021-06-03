package com.example.minichatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.minichatapp.ui.conversation.ConversationFragment;

public class ConversationActivity extends AppCompatActivity {

    public static void ActionStart(Context context,String f_id,String u_id){
        Intent intent=new Intent(context,ConversationActivity.class);
        intent.putExtra("f_id",f_id);
        intent.putExtra("u_id",u_id);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ConversationFragment.newInstance())
                    .commitNow();
        }
    }
}