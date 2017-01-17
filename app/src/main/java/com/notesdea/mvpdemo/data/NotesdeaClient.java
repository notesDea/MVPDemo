package com.notesdea.mvpdemo.data;


import com.android.volley.Request;
import com.notesdea.mvpdemo.BuildConfig;

/**
 * Created by notesdea on 1/16/17.
 */

public class NotesdeaClient {
    //debug时用的url
    public static final String QA = "http://1.notesdea.applinzi.com";
    //正式发布时用的url
    public static final String PRODUCTION = "http://1.notesdea.applinzi.com";

    public static String getHost() {
        return BuildConfig.DEBUG ? QA : PRODUCTION;
    }

    public static String getAbsoluteUrl(String url) {
        return getHost() + url;
    }

    //不带参数的GET
    public static void get(String url, HttpCallback callback) {
        get(url, callback, null);
    }

    //带参数的GET
    public static void get(String url, HttpCallback callback, JsonParams params) {
        RequestManager.sendRequest(Request.Method.GET, getAbsoluteUrl(url), callback, params);
    }

    //不带参数的POST
    public static void post(String url, HttpCallback callback) {
        post(url, callback, null);
    }

    //带参数的POST
    public static void post(String url, HttpCallback callback, JsonParams params) {
        RequestManager.sendRequest(Request.Method.POST, getAbsoluteUrl(url), callback, params);
    }


}
