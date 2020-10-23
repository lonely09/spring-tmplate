package com.smec.template.configuration;

import java.util.Map;

public class UserProfile {
    private String uid;
    private String userName;
    private String token;
    private Map<String, String> attributes;
    private boolean isAnonymous = true;
    public static final UserProfile anonymous = new UserProfile("anonymous");

    public UserProfile() {
    }

    public UserProfile(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.isAnonymous = anonymous;
    }
}
