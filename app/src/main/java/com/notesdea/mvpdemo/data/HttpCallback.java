package com.notesdea.mvpdemo.data;

import com.android.volley.BuildConfig;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by notesdea on 1/15/17.
 */

public class HttpCallback implements Response.Listener<String>, Response.ErrorListener{

    private String mCache;
    private Mock mMock;

    @Override
    public void onResponse(String response) {
        ok(response);
        if (BuildConfig.DEBUG && mMock != null) {
            mock(mMock);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String errorMessage = error.getMessage();
        if (mCache != null) {
            ok(mCache);
        }
        fail(errorMessage);

        if (BuildConfig.DEBUG && mMock != null) {
            mock(mMock);
        }
    }

    public void ok(String response) {
    }

    public void fail(String errorMessage) {
    }

    public void mock(Mock mock) {
    }

    public void setMock(Mock mock) {
        this.mMock = mock;
    }

    public void setCache(String cache) {
        this.mCache = cache;
    }
}
