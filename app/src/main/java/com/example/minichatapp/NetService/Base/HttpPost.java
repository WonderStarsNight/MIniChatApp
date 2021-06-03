package com.example.minichatapp.NetService.Base;

import android.util.Log;

import java.util.Objects;
import java.util.concurrent.Callable;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpPost implements Callable<String> {
    private String url;
    private String json;
    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public HttpPost(String url, String json) {
        this.url = url;
        this.json = json;
    }

    @Override
    public String call() throws Exception {
        OkHttpClient client=new OkHttpClient();
        Log.d("httpPost",url+" start for json:"+json);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Log.d("httpPost",url+" build:"+body.contentType());
        Response response= client.newCall(request).execute();
        Log.d("httpPost",url+" receive");
        return Objects.requireNonNull(response.body()).string();
    }
}
