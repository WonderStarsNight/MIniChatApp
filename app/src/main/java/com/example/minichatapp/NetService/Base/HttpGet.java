package com.example.minichatapp.NetService.Base;

import android.util.Log;

import java.util.Objects;
import java.util.concurrent.Callable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpGet implements Callable<String> {
    private String url;

    public HttpGet(String url) {
        this.url = url;
    }


    @Override
    public String call() throws Exception {
        OkHttpClient client=new OkHttpClient();
        Log.d("httpGet",url+" start");
        Request request = new Request.Builder()
                .url(url)
                .build();
        Log.d("httpGet",url+" build");
        Response response=client.newCall(request).execute();
        Log.d("httpGet",url+" execute");
        return Objects.requireNonNull(response.body()).string();
    }
}
