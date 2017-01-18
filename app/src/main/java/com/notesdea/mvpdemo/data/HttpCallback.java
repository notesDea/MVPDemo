package com.notesdea.mvpdemo.data;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.notesdea.mvpdemo.BuildConfig;

/**
 * Created by notesdea on 1/15/17.
 */

public class HttpCallback implements Response.Listener<String>, Response.ErrorListener{

    private static final String TAG = HttpCallback.class.getSimpleName();

    private String mCache;
    private String mMock;

    @Override
    public void onResponse(String response) {
        ok(response);
        if (BuildConfig.DEBUG && mMock != null ) {
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

        if (BuildConfig.DEBUG && mMock != null ) {
            mock(mMock);
        }
    }

    public void ok(String response) {
    }

    public void fail(String errorMessage) {
    }

    public void mock(String mock) {
    }

    public void setMock(String mock) {
        this.mMock = mock;
        Log.d(TAG, "setMock: " + mMock);
    }

    public void setCache(String cache) {
        this.mCache = cache;
    }
}
