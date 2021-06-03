package com.example.minichatapp.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private boolean isOk;
    private String userId;
    private String displayName;
    private String token;

    public LoggedInUser(boolean isOk, String userId, String displayName, String token) {
        this.isOk = isOk;
        this.userId = userId;
        this.displayName = displayName;
        this.token = token;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public LoggedInUser(boolean isOk) {
        this.isOk = isOk;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isOk() {
        return isOk;
    }
}