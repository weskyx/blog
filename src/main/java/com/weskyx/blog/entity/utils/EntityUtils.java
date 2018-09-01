package com.weskyx.blog.entity.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.weskyx.blog.common.BlogConsts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class EntityUtils {
    private static final String CGetStatusMethodName = "getStatus";
    private static final String CGetPrefix = "get";


    public static JSONObject generateJsonObject(Class clazz, Object obj) {
        if (obj == null) {
            return null;
        }

        return doGenerateJsonObject(clazz, obj);
    }

    public static String generateJsonObjectString(Class clazz, Object obj) {
        if (obj == null) {
            return "";
        }

        JSONObject jsonObj = doGenerateJsonObject(clazz, obj);
        return JSONObject.toJSONString(jsonObj, SerializerFeature.WriteMapNullValue);
    }

    public static JSONArray generateJsonArray(Class clazz, List<?> objList) {
        if (objList.size() <= 0) {
            return null;
        }

        JSONArray jsonArray = new JSONArray();
        for (Object obj : objList) {
            JSONObject jsonObj = doGenerateJsonObject(clazz, obj);
            jsonArray.add(jsonObj);
        }
        return jsonArray;
    }

    public static String generateJsonArrayString(Class clazz, List<? extends Object> objList) {
        if (objList.size() <= 0) {
            return "";
        }

        JSONArray jsonArray = new JSONArray();
        for (Object obj : objList) {
            JSONObject jsonObj = doGenerateJsonObject(clazz, obj);
            jsonArray.add(jsonObj);
        }
        return JSONArray.toJSONString(jsonArray, SerializerFeature.WriteMapNullValue);
    }

    private static JSONObject doGenerateJsonObject(Class clazz, Object obj) {
        JSONObject jsonObj = new JSONObject();
        Method[] methods = clazz.getDeclaredMethods();
        try {
            for (Method method : methods) {
                String methodName = method.getName();
                if (!methodName.startsWith(CGetPrefix)) {
                    continue;
                }

                Class type = method.getReturnType();
                // 这里有一个潜规则存在：所有字段命名都是小写字母，采用“_”分隔单词
                String fieldName = methodName.replaceFirst(CGetPrefix, "").toLowerCase();
                Object value = method.invoke(obj);
                if (type.equals(String.class)) {
                    jsonObj.put(fieldName, (String) value);
                } else if (type.equals(Boolean.class)) {
                    jsonObj.put(fieldName, (Boolean) value);
                } else if (type.equals(Double.class)) {
                    jsonObj.put(fieldName, (Double) value);
                } else if (type.equals(Integer.class)) {
                    jsonObj.put(fieldName, (Integer) value);
                } else if (type.equals(Byte.class)) {
                    jsonObj.put(fieldName, (Byte) value);
                } else if (type.equals(Short.class)) {
                    jsonObj.put(fieldName, (Short) value);
                } else if (type.equals(Long.class)) {
                    jsonObj.put(fieldName, (Long) value);
                } else if (type.equals(Float.class)) {
                    jsonObj.put(fieldName, (Float) value);
                } else if (type.equals(Date.class)) {
                    jsonObj.put(fieldName, (Date) value);
                }
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonObj;
    }
}
