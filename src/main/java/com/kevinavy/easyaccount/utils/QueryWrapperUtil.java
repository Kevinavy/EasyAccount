package com.kevinavy.easyaccount.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryWrapperUtil {
    private static final Pattern linePattern = Pattern.compile("_(\\w)");
    private static final Pattern humPattern = Pattern.compile("[A-Z]");

    public static String humpToLine(String str) {
        Matcher matcher = humPattern.matcher(str);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(stringBuilder);
        return stringBuilder.toString();
    }
}
