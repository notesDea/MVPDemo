package com.notesdea.mvpdemo.data;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
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

    //URL转换成Query string 的形式
    public String toQueryString(String url) {
        String paramString = getEncodedParamString();
        if (TextUtils.isEmpty(paramString)) {
            return url;
        }

        if (url.indexOf("?") == -1) {
            url += "?" + paramString;
        } else {
            url += "&" + paramString;
        }
        return url;
    }

    private String getEncodedParamString() {
        StringBuilder result = new StringBuilder();
        Iterator it = params.keys();
        //todo 继续写下去
    }
}
