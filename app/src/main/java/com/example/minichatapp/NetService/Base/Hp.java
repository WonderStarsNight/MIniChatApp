package com.example.minichatapp.NetService.Base;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public interface Hp {
    Gson gson=new Gson();
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    default String get(final String url) throws IOException, ExecutionException, InterruptedException {

        HttpGet get=new HttpGet(url);
        ExecutorService service= Executors.newFixedThreadPool(1);
        Future<String> future_get=service.submit(get);
        return future_get.get();

    }
    default String post(final String url,final String json) throws IOException, ExecutionException, InterruptedException {

        HttpPost post=new HttpPost(url,json);
        ExecutorService service= Executors.newFixedThreadPool(1);
        Future<String> future_post=service.submit(post);
        return future_post.get();
    }
//    default String getRong(final String url) throws IOException, ExecutionException, InterruptedException {
//
//        HttpGetRong get=new HttpGetRong(url);
//        ExecutorService service= Executors.newFixedThreadPool(1);
//        Future<String> future_get=service.submit(get);
//        return future_get.get();
//
//    }
    default String postRong(final String url, final RequestBody body) throws IOException, ExecutionException, InterruptedException {

        HttpPostRong post=new HttpPostRong(url,body);
        ExecutorService service= Executors.newFixedThreadPool(1);
        Future<String> future_post=service.submit(post);
        return future_post.get();
    }


}
