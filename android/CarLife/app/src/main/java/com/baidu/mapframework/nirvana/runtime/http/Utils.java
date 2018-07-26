package com.baidu.mapframework.nirvana.runtime.http;

import android.os.Looper;
import android.text.TextUtils;
import com.facebook.common.p141m.C2924g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

class Utils {
    Utils() {
    }

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void assertOnUiThread() {
        if (!isOnUiThread()) {
            throw new RuntimeException("Expected to run on UI thread!");
        }
    }

    public static void assertNotOnUiThread() {
        if (isOnUiThread()) {
            throw new RuntimeException("Expected to run on UI thread!");
        }
    }

    public static boolean isUrlLegal(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        try {
            String scheme = "";
            scheme = new URL(url).getProtocol();
            if ("http".equals(scheme) || C2924g.f12888b.equals(scheme)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static Object reflectionInvokeStaticMethod(String className, String methodName, Class<?>[] parameterTypes, Object[] args) {
        Object obj = null;
        try {
            Class targetClass = Class.forName(className);
            if (targetClass != null) {
                Method method = targetClass.getMethod(methodName, parameterTypes);
                if (method != null) {
                    obj = method.invoke(null, args);
                }
            }
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (InvocationTargetException e4) {
        }
        return obj;
    }
}
