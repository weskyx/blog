package com.weskyx.blog.common;

import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.List;

public class BatisSqlUtils {

    public static String updateBatchSql(String tableName, List<Object> list) {
        String sql = "";
        if (list.size() > 0) {
            Field[] fields = list.get(0).getClass().getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            sb.append("replace into " + tableName + "");
            sb.append("(" + getColumns(fields) + ")");
            sb.append("values");
            sb.append(getBatchValue(fields, list.size()));
            sql = sb.toString();
        }
        System.out.println(sql);
        return sql;
    }

    public static String updateSql(String tableName, Object item, String key) {
        Field[] fields = item.getClass().getDeclaredFields();
        SQL sql = new SQL();
        sql.UPDATE(tableName);
        sql.SET(getSetValue(fields));
        sql.WHERE(key + "=#{" + key + "}");
        System.out.println(sql);
        return sql.toString();
    }

    public static String insertSql(String tableName, Object item) {
        Field[] fields = item.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("insert into " + tableName + "");
        sb.append("(" + getColumns(fields) + ")");
        sb.append("values");
        sb.append("(");
        sb.append(getOneValue(fields));
        sb.append(")");
        String sql = sb.toString();
        System.out.println(sql);
        return sql;
    }

    public static String insertBatchSql(String tableName, List<Object> list) {
        String sql = "";
        if (list.size() > 0) {
            Field[] fields = list.get(0).getClass().getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            sb.append("insert into " + tableName + "");
            sb.append("(" + getColumns(fields) + ")");
            sb.append("values");
            sb.append(getBatchValue(fields, list.size()));
            sql = sb.toString();
        }
        System.out.println(sql);
        return sql;
    }

    public static String updateByINSql(String tableName, String key, List<String> range) {
        String sql = "";
        if (range.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("update " + tableName);
            sb.append(" where ");
            sb.append(key + " in (" + getRangeValue(range) + ")");
            sql = sb.toString();
        }
        System.out.println(sql);
        return sql;
    }

    public static String selectByInSql(String tableName, String key, List<String> range, String orderByKey, String orderByType) {
        String sql = "";
        if (range.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("select * from " + tableName);
            sb.append(" where ");
            sb.append(key + " in (" + getRangeValue(range) + ")");
            sb.append(" order by " + orderByKey + " " + orderByType);
            sql = sb.toString();
        }
        return sql;
    }

    public static String clearRelationSql(String tableName, String key, List<String> ids) {
        SQL sql = new SQL();
        sql.DELETE_FROM(tableName);
        sql.WHERE(key + " in (" + getRangeValue(ids) + ")");
        System.out.println(sql);
        return sql.toString();
    }

    public static String deleteBatchSql(String tableName, String key, List<String> range) {
        String sql = "";
        if (range.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("update " + tableName + " set status = 0");
            sb.append(" where ");
            sb.append(key + " in ( " + getRangeValue(range) + ")");
            sql = sb.toString();
        }
        System.out.println(sql);
        return sql;
    }

    private static String getColumns(Field[] fields) {
        String columns = "";
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            columns += "," + field.getName();
        }
        return columns.substring(1);
    }

    private static String getBatchValue(Field[] fields, int size) {
        if (size == 0) {
            return "";
        }
        String batchValue = "";
        String formatStr = "";
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            formatStr += ",#'{'list[{0}]." + field.getName() + "'}'";
        }
        MessageFormat mf = new MessageFormat(formatStr.substring(1));
        for (int i = 0; i < size; i++) {
            batchValue += ",(" + mf.format(new Object[]{i + ""}) + ")";
        }
        return batchValue.substring(1);
    }

    private static String getOneValue(Field[] fields) {
        String oneValue = "";
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            oneValue += ",#{" + field.getName() + "}";
        }
        return oneValue.substring(1);
    }

    private static String getSetValue(Field[] fields) {
        String setValue = "";
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            setValue += "," + field.getName() + "=#{" + field.getName() + "}";
        }
        return setValue.substring(1);
    }

    private static String getRangeValue(List<String> range) {
        String rangeValue = "";
        for (int i = 0; i < range.size(); i++) {
            rangeValue += ",\"" + range.get(i) + "\"";
        }
        return rangeValue.substring(1);
    }
}
