package com.notesdea.mvpdemo.data;

import android.text.TextUtils;
import android.util.Log;

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

    private static final String TAG = RequestManager.class.getSimpleName();

    public static RequestQueue mQueue = Volley.newRequestQueue(BaseApplication.getContext());

    public static void addRequest(Request<?> request) {
        mQueue.add(request);
    }

    public static void sendRequest(int method, String url, HttpCallback callback, JsonParams jsonParams) {
        String fullURL = url;
        // 注意下面代码，用来处理 get 方法的参数
        if (Request.Method.GET == method && jsonParams != null) {
            fullURL = jsonParams.toQueryString(fullURL);
        }

        BaseJsonRequest request = new BaseJsonRequest(method, fullURL, jsonParams, callback, callback);
        RequestManager.addRequest(request);
    }
}
