package com.baidu.navisdk.util.common;

import android.os.Build.VERSION;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;

public class WebviewUtils {
    public static void resumeWebview(WebView viewview) {
        if (viewview != null) {
            try {
                WebView.class.getMethod("onResume", new Class[0]).invoke(viewview, new Object[0]);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            } catch (NoSuchMethodException e4) {
            }
            viewview.resumeTimers();
        }
    }

    public static void pauseWebview(WebView viewview) {
        if (viewview != null) {
            try {
                WebView.class.getMethod("onPause", new Class[0]).invoke(viewview, new Object[0]);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            } catch (NoSuchMethodException e4) {
            }
            viewview.pauseTimers();
        }
    }

    public static void disableJsInterface(WebView webView) {
        if (VERSION.SDK_INT >= 11 && webView != null) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
    }
}
