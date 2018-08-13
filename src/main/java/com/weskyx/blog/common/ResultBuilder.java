package com.weskyx.blog.common;

import com.alibaba.fastjson.JSONObject;

public class ResultBuilder {

    public static String getResult(Boolean success, String data, String message, String extra) {
        JSONObject result = new JSONObject();
        result.put("success", success);
        result.put("data", data);
        result.put("message", message);
        result.put("extra", extra);
        return result.toString();
    }
}
