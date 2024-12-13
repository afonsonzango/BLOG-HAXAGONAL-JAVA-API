package com.blog.api.root.utils;

public class ValueUtilities {
    public static boolean isNumber (String x) {
        if (x == null || x.isEmpty()) return false;

        try {
            Long.parseLong(x);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNotNumber (String x) {
        if (x == null || x.isEmpty()) return true;

        try {
            Long.parseLong(x);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}