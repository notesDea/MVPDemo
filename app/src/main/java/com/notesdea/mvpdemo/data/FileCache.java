package com.notesdea.mvpdemo.data;

import com.notesdea.mvpdemo.BaseApplication;

/**
 * Created by notesdea on 1/16/17.
 */

public class FileCache {

    //缓存的目录
    private static final String CACHE_NAME = "volley";

    public static ACache cache = ACache.get(BaseApplication.getContext(), CACHE_NAME);

    //保存缓存数据
    public static void put(String key, String value) {
        cache.put(key, value);
    }

    //获取缓存数据
    public static String get(String key) {
        return cache.getAsString(key);
    }

    //清理缓存
    public static void clear() {
        cache.clear();
    }
}
