package com.notesdea.mvpdemo.data;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by notesdea on 1/15/17.
 */

public class JsonParams {

    protected final JSONObject params = new JSONObject();

    public JsonParams() {
    }

    public void put(String key, String value) {
        if (key != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, boolean value) {
        if (key != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, int value) {
        if (key != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, String[] value) {
        if (key != null && value != null) {
            try {
                params.put(key, new JSONArray(Arrays.asList(value)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, JSONArray value) {
        if (key != null && value != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, JSONObject value) {
        if (key != null && value != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JsonParams remove(String key) {
        params.remove(key);
        return this;
    }

    public JSONObject toJSON() {
        return params;
    }

    public String toString() {
        return params.toString();
    }

    //URL 转换成Query string 的形式
    public String toQueryString(String url) {
        String paramString = getEncodedParamString();
        if (TextUtils.isEmpty(paramString)) return url;

        //拼接成 http://www.notesdea.com/?key1=value1&key2=value2 的形式
        if (url.indexOf("?") == -1) {
            url += "?" + paramString;
        } else {
            url += "&" + paramString;
        }
        return url;
    }

    private String getEncodedParamString() {
        StringBuilder result = new StringBuilder();
        //获取key的
        Iterator it = params.keys();
        //类似于解码成 "key1=value1&key2=value2" 的形式
        while (it.hasNext()) {
            if (result.length() > 0) result.append("&");

            String key = (String) it.next();
            String value = params.optString(key);
            result.append(URLEncoder.encode(key));
            result.append("=");
            result.append(URLEncoder.encode(value));
        }
        return result.toString();
    }
}
