package com.example.minichatapp.NetService;

public  class UrlPatterns {
    //host
    //@example: public static final String SERVER_URL="http://10.27.217.136:8080/BookstoreServer/";
    public static final String SERVER_URL="http://192.168.31.19:8080/MiniChatAppServer/";
    public static final String RONG_SERVER_URL="http://api-cn.ronghub.com/";
    public static final String SIGN_UP=SERVER_URL+"signup";
    public static final String RONG_SIGN_UP=RONG_SERVER_URL+"user/getToken.json";
    public static final String LOGIN=SERVER_URL+"login";
    public static final String TOKEN_GET=RONG_SIGN_UP;
    public static final String FRIEND_ADD=SERVER_URL+"addFriend";
    public static final String FRIENDS_GET=SERVER_URL+"getFriends?uid=";

}
