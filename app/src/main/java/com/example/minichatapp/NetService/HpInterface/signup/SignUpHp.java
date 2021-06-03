package com.example.minichatapp.NetService.HpInterface.signup;

import com.example.minichatapp.NetService.Base.Hp;
import com.example.minichatapp.NetService.Base.HpException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public interface SignUpHp extends Hp {
    boolean signUp(String uid,String password,String u_name) throws HpException, InterruptedException, ExecutionException, IOException;
}
