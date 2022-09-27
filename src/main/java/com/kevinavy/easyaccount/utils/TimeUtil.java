package com.kevinavy.easyaccount.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    private static final SimpleDateFormat standardDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentDateTime() {
        Date date = new Date(System.currentTimeMillis());
        return standardDateTime.format(date);
    }

    public static String getCurrentDate() {
        Date date = new Date(System.currentTimeMillis());
        return standardDateTime.format(date).substring(0, 10);
    }

    public static String getCurrentTime() {
        Date date = new Date(System.currentTimeMillis());
        return standardDateTime.format(date).substring(11);
    }
}
