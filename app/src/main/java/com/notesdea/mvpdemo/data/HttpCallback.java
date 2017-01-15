package com.notesdea.mvpdemo.data;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by notesdea on 1/15/17.
 */

public class HttpCallback implements Response.Listener<String>, Response.ErrorListener{

    private String mCache;
    private String mMock;

    @Override
    public void onResponse(String response) {
        ok(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public void ok(String response) {
    }

    public void fail(String errorMessage) {
    }

    public void mock(String mock) {
    }

    public void setMock(String mock) {
        this.mMock = mock;
    }

    public void setCache(String cache) {
        this.mCache = cache;
    }
}
