package com.kevinavy.easyaccount.model.common.context;

import java.util.Map;

public class UserContext {
    private static final ThreadLocal<Map<String, Object>> threadLocal;

    static {
        threadLocal = new ThreadLocal<>();
    }

    public static Map<String, Object> getLocalStorage() {
        return threadLocal.get();
    }

    public static void saveLocalStorage(Map<String, Object> getLocalStorage) {
        threadLocal.set(getLocalStorage);
    }

    public static void removeLocalStorage() {
        threadLocal.remove();
    }

}
