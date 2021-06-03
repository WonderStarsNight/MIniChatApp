package com.example.minichatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minichatapp.NetService.Base.HpException;
import com.example.minichatapp.NetService.HpImpl.signup.SignUpImpl;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {

    public static void ActionStart(Context context){
        Intent intent=new Intent(context,SignUpActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText phone=findViewById(R.id.phone_number);
        final EditText name=findViewById(R.id.person_name);
        final EditText password=findViewById(R.id.password);
        final EditText password2=findViewById(R.id.password2);
        final Button button=findViewById(R.id.rigster);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_v=phone.getText().toString();
                String name_v=name.getText().toString();
                String password_v=password.getText().toString();
                String password_v2=password2.getText().toString();

                if(phone_v.equals("")||name_v.equals("")||password_v.equals("")||password_v2.equals("")){
                    Toast.makeText(SignUpActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    if(!password_v.equals(password_v2)){
                        Toast.makeText(SignUpActivity.this,"密码不同",Toast.LENGTH_SHORT).show();
                    }else {
                        try {
                            boolean isOk=new SignUpImpl().signUp(phone_v,password_v2,name_v);
                            if(isOk){
                                Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                                SignUpActivity.this.finish();
                            }else {
                                Toast.makeText(getApplicationContext(),"该账号已注册",Toast.LENGTH_SHORT).show();
                            }
                        } catch (HpException hpException) {
                            Toast.makeText(getApplicationContext(),"服务器错误hp",Toast.LENGTH_SHORT).show();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"服务器错误interrupt",Toast.LENGTH_SHORT).show();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"服务器错误execu",Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"服务器错误io",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


    }
}