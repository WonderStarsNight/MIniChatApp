package com.example.minichatapp.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private boolean isOk;
    private String uid;
    private String displayName;
    private String token;
    //... other data fields that may be accessible to the UI


    public LoggedInUserView(boolean isOk, String uid, String displayName, String token) {
        this.isOk = isOk;
        this.uid = uid;
        this.displayName = displayName;
        this.token = token;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoggedInUserView(boolean isOk) {
        this.isOk = isOk;
    }

    public boolean isOk() {
        return isOk;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUid() {
        return uid;
    }
}