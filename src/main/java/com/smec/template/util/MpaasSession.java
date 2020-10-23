package com.smec.template.util;

import com.smec.template.configuration.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class MpaasSession {
    private static ThreadLocal<UserProfile> session = new ThreadLocal();

    private static ThreadLocal<Map<String, Object>> data = new ThreadLocal();
    /**
     * 设置用户信息
     * @param userProfile 用户信息
     */
    public static void setUserProfile(UserProfile userProfile) {
        session.set(userProfile);
    }

    /**
     * 获取用户登录信息
     * @return 用户信息
     */
    public static UserProfile getUserProfile() {
        return session.get();
    }

    /**
     * 获取当前用户工号
     * @return 用户工号
     */
    public static String getCurrentUser() {
        return session.get() == null ? "anonymous" : session.get().getUid();
    }


    public static void put(String key, Object value) {
        Map<String, Object> params = data.get();
        if (params == null) {
            params = new HashMap<>();
        }
        (params).put(key, value);
        data.set(params);
    }

    public static Object get(String key) {
        return data.get() == null ? null : (data.get()).get(key);
    }

    private MpaasSession() {
        throw new UnsupportedOperationException();
    }
}
