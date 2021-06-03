package com.example.minichatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.minichatapp.ui.FriendAddViewModel;
import com.example.minichatapp.ui.FriendAddViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;

public class FriendAddActivity extends AppCompatActivity {

    private String uid;
    private FriendAddViewModel viewModel;
    public static void ActionStart(Context context,String uid){
        Intent intent=new Intent(context,FriendAddActivity.class);
        intent.putExtra("uid",uid);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_add);
        final TextInputEditText inputEditText=findViewById(R.id.friend_add_input);
        final Button button=findViewById(R.id.friend_add_button);
        uid=getIntent().getStringExtra("uid");
        viewModel=new ViewModelProvider(this,new FriendAddViewModelFactory()).get(FriendAddViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=inputEditText.getText().toString();
                if(viewModel.addFriend(uid,id)){
                    Toast.makeText(FriendAddActivity.this,"成功添加",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(FriendAddActivity.this,"该成员不存在或已添加该好友",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}