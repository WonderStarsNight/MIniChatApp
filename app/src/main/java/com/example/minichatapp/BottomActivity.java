package com.example.minichatapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.minichatapp.ui.BottomViewModel;
import com.example.minichatapp.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import io.rong.imkit.RongIM;
import io.rong.imkit.utils.RouteUtils;
import io.rong.imlib.RongIMClient;


public class BottomActivity extends AppCompatActivity {


    private BottomViewModel bottomViewModel;
    public static void actionStart(Context context,String uid,String token){
        Intent intent=new Intent(context,BottomActivity.class);
        intent.putExtra("uid",uid);
        intent.putExtra("token",token);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        bottomViewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(BottomViewModel.class);
        Intent intent=getIntent();
        String uid=intent.getStringExtra("uid");
        String token=intent.getStringExtra("token");
        bottomViewModel.getUid().setValue(uid);
        bottomViewModel.setToken(token);

        //Rong
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onSuccess(String s) {

            }

            @Override
            public void onError(RongIMClient.ConnectionErrorCode connectionErrorCode) {
                if(connectionErrorCode.equals(RongIMClient.ConnectionErrorCode.RC_CONN_TOKEN_INCORRECT)) {
                    //从 APP 服务获取新 token，并重连
                } else {
                    //无法连接 IM 服务器，请根据相应的错误码作出对应处理
                }
            }

            @Override
            public void onDatabaseOpened(RongIMClient.DatabaseOpenStatus databaseOpenStatus) {
                //消息数据库打开，可以进入到主页面
            }
        });

        bottomViewModel.getIs_logout().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    LoginActivity.ActionStart(BottomActivity.this);
                    finish();
                }
            }
        });
        Log.d("bottomViewModel",bottomViewModel.toString());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_conversation,R.id.navigation_friends,R.id.navigation_home )
                .build();
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(findViewById(R.id.toolbar),navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

}