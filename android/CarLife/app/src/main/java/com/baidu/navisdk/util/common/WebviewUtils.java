package com.baidu.navisdk.util.common;

import android.os.Build.VERSION;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebviewUtils
{
  public static void disableJsInterface(WebView paramWebView)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramWebView != null)) {
      paramWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public static void pauseWebview(WebView paramWebView)
  {
    if (paramWebView == null) {
      return;
    }
    try
    {
      WebView.class.getMethod("onPause", new Class[0]).invoke(paramWebView, new Object[0]);
      paramWebView.pauseTimers();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public static void resumeWebview(WebView paramWebView)
  {
    if (paramWebView == null) {
      return;
    }
    try
    {
      WebView.class.getMethod("onResume", new Class[0]).invoke(paramWebView, new Object[0]);
      paramWebView.resumeTimers();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/WebviewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */