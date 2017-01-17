package com.notesdea.mvpdemo.data;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.notesdea.mvpdemo.BaseApplication;

import org.w3c.dom.Text;

/**
 * Created by notesdea on 1/16/17.
 */

public class RequestManager {
    public static RequestQueue mQueue = Volley.newRequestQueue(BaseApplication.getContext());

    public static void addRequest(Request<?> request) {
        mQueue.add(request);
    }

    public static void sendRequest(int method, String url, HttpCallback callback, JsonParams params) {
        String fullURL = url;
        if (Request.Method.GET == method && params != null) {
            fullURL = params.toQueryString(url);
        }

        String cache = FileCache.get(fullURL);
        if (!TextUtils.isEmpty(cache)) {
            callback.setCache(cache);
        }

        BaseJsonRequest request = new BaseJsonRequest(method, fullURL, params, callback, callback);
        RequestManager.addRequest(request);
    }
}
