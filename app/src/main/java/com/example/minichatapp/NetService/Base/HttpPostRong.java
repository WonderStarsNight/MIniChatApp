package com.example.minichatapp.NetService.Base;

import android.util.Log;

import com.example.minichatapp.util.SHA1;

import java.util.Objects;
import java.util.concurrent.Callable;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpPostRong implements Callable<String> {
    private String url;
    private String json;
    private RequestBody body;

    public HttpPostRong(String url, RequestBody requestBody) {
        this.url = url;
        this.body=requestBody;
    }

    @Override
    public String call() throws Exception {

        String app_secret="WrNyYbz419";
        String nonce="131415";
        String timestamp=String.valueOf(System.currentTimeMillis());
        String signature= SHA1.sha1(app_secret+nonce+timestamp);
        OkHttpClient client=new OkHttpClient();
        Log.d("httpPost",url+" start for body:"+body.contentType());
        Request request = new Request.Builder()
                .addHeader("App-Key","8luwapkv86p3l")
                .addHeader("Nonce",nonce)
                .addHeader("Timestamp",timestamp)
                .addHeader("Signature",signature)
                .url(url)
                .post(body)
                .build();
        Log.d("httpPost",url+" build:"+request.toString());
        Response response= client.newCall(request).execute();
        Log.d("httpPost",url+" receive");
        return Objects.requireNonNull(response.body()).string();
    }
}
