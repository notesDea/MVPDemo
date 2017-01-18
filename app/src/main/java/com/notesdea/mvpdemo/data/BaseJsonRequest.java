package com.notesdea.mvpdemo.data;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by notesdea on 1/16/17.
 */

public class BaseJsonRequest extends JsonRequest<String> {

    private String mUrl;

    public BaseJsonRequest(int method, String url, JsonParams params,
                           Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, null == params ? null : params.toString(), listener, errorListener);
        this.mUrl = url;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<>();
        headers.put("App-Version", Config.getVersionName());
        headers.put("App-Device", "Android");
        headers.put("Version-Code", Config.getVersionCode());
        return headers;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        if (response == null) return null;

        String parsed = null;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        //添加缓存
        FileCache.put(mUrl, parsed);
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

}
