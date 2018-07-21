package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

public class StatService
{
  public static final int EXCEPTION_LOG = 1;
  public static final int JAVA_EXCEPTION_LOG = 16;
  private static boolean a = false;
  private static long b;
  
  private static String a(boolean paramBoolean)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    if (i < arrayOfStackTraceElement.length)
    {
      Object localObject2 = arrayOfStackTraceElement[i].getClassName();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      do
      {
        i += 1;
        break;
        Object localObject1 = null;
        try
        {
          localObject2 = Class.forName((String)localObject2);
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      } while ((localObject1 == null) || (!Activity.class.isAssignableFrom((Class)localObject1)));
      if (paramBoolean) {
        return ((Class)localObject1).getName();
      }
      return ((Class)localObject1).getSimpleName();
    }
    return "";
  }
  
  private static void a(Context paramContext)
  {
    bf.a().a(paramContext);
  }
  
  private static void a(Context paramContext, ExtraInfo paramExtraInfo)
  {
    for (;;)
    {
      try
      {
        boolean bool = a(paramContext, "onPause(...)");
        if (!bool) {
          return;
        }
        if (!a(Activity.class, "onPause")) {
          throw new SecurityException("onPause(Context context)不在Activity.onPause()中被调用||onPause(Context context)is not called in Activity.onPause().");
        }
      }
      finally {}
      ch.a().a(paramContext, System.currentTimeMillis(), false, paramExtraInfo);
    }
  }
  
  /* Error */
  private static void a(Context paramContext, String paramString, ExtraInfo paramExtraInfo)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +16 -> 20
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: ldc 66
    //   14: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +12 -> 29
    //   20: ldc 115
    //   22: invokestatic 120	com/baidu/mobstat/db:c	(Ljava/lang/String;)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: iconst_0
    //   30: invokestatic 122	com/baidu/mobstat/StatService:a	(Z)Ljava/lang/String;
    //   33: astore_3
    //   34: new 124	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   41: ldc 127
    //   43: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc -123
    //   52: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 138	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   65: invokestatic 97	com/baidu/mobstat/ch:a	()Lcom/baidu/mobstat/ch;
    //   68: aload_0
    //   69: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   72: aload_3
    //   73: aload_1
    //   74: aload_2
    //   75: invokevirtual 141	com/baidu/mobstat/ch:a	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;Lcom/baidu/mobstat/ExtraInfo;)V
    //   78: goto -53 -> 25
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramContext	Context
    //   0	87	1	paramString	String
    //   0	87	2	paramExtraInfo	ExtraInfo
    //   33	40	3	str	String
    // Exception table:
    //   from	to	target	type
    //   11	20	81	finally
    //   20	25	81	finally
    //   29	78	81	finally
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, int paramInt, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    if (!a(paramContext, "onEvent(...)")) {}
    while ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    boolean bool = dg.a(Application.class, "onCreate");
    if (bool) {
      db.c("method:onEvent() 被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
    }
    a(paramContext);
    bv.a().a(paramContext, bool);
    bm.a().a(paramContext.getApplicationContext(), paramString1, paramString2, paramInt, System.currentTimeMillis(), paramExtraInfo, dg.a(paramMap));
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, long paramLong, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    if (!a(paramContext, "onEventDuration(...)")) {}
    while ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    if (paramLong <= 0L)
    {
      db.b("onEventDuration: duration must be greater than zero");
      return;
    }
    a(paramContext);
    bv.a().a(paramContext);
    bm.a().b(paramContext.getApplicationContext(), paramString1, paramString2, paramLong, paramExtraInfo, dg.a(paramMap));
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, ExtraInfo paramExtraInfo)
  {
    a(paramContext, paramString1, paramString2, 1, paramExtraInfo, null);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    if (!a(paramContext, "onEventEnd(...)")) {}
    while ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    bm.a().a(paramContext.getApplicationContext(), paramString1, paramString2, System.currentTimeMillis(), paramExtraInfo, dg.a(paramMap));
  }
  
  private static void a(Context paramContext, boolean paramBoolean)
  {
    if (!a(paramContext, "onError(...)")) {
      return;
    }
    bt.a().a(paramContext.getApplicationContext(), paramBoolean);
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      db.b(paramString + ":context=null");
      return false;
    }
    return true;
  }
  
  private static boolean a(Class<?> paramClass, String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    boolean bool1 = false;
    int i = 2;
    boolean bool2;
    while (i < arrayOfStackTraceElement.length)
    {
      Object localObject = arrayOfStackTraceElement[i];
      bool2 = bool1;
      if (((StackTraceElement)localObject).getMethodName().equals(paramString)) {}
      try
      {
        for (localObject = Class.forName(((StackTraceElement)localObject).getClassName()); (((Class)localObject).getSuperclass() != null) && (((Class)localObject).getSuperclass() != paramClass); localObject = ((Class)localObject).getSuperclass()) {}
        bool2 = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          db.a(localException);
          bool2 = bool1;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  public static void bindJSInterface(Context paramContext, WebView paramWebView)
  {
    bindJSInterface(paramContext, paramWebView, null);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public static void bindJSInterface(Context paramContext, WebView paramWebView, WebViewClient paramWebViewClient)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context can't be null.");
    }
    if (paramWebView == null) {
      throw new IllegalArgumentException("webview can't be null.");
    }
    WebSettings localWebSettings = paramWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDefaultTextEncodingName("UTF-8");
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    paramWebView.setWebViewClient(new bi(paramContext, paramWebViewClient));
    a(paramContext);
  }
  
  public static void enableDeviceMac(Context paramContext, boolean paramBoolean)
  {
    CooperService.a().enableDeviceMac(paramContext, paramBoolean);
    a(paramContext);
  }
  
  public static String getAppKey(Context paramContext)
  {
    return PrefOperate.getAppKey(paramContext);
  }
  
  public static String getSdkVersion()
  {
    return CooperService.a().getMTJSDKVersion();
  }
  
  public static void onErised(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (bv.a().b()) {}
    long l;
    do
    {
      do
      {
        return;
      } while (!a(paramContext, "onErised(...)"));
      if ((paramString1 == null) || ("".equals(paramString1)))
      {
        db.c("AppKey is invalid");
        return;
      }
      bv.a().a(paramContext, false, false);
      l = System.currentTimeMillis();
      bm.a().a(paramContext, paramString2, paramString3, 1, l, 0L, null, null);
      DataCore.instance().saveLogDataToSend(paramContext, true, false);
    } while ((l - b <= 30000L) || (!de.n(paramContext)));
    by.a().a(paramContext);
    b = l;
  }
  
  public static void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, paramString2, null);
  }
  
  public static void onEvent(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramInt, null, null);
  }
  
  public static void onEvent(Context paramContext, String paramString1, String paramString2, int paramInt, Map<String, String> paramMap)
  {
    a(paramContext, paramString1, paramString2, paramInt, null, paramMap);
  }
  
  public static void onEventDuration(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    a(paramContext, paramString1, paramString2, paramLong, null, null);
  }
  
  public static void onEventDuration(Context paramContext, String paramString1, String paramString2, long paramLong, Map<String, String> paramMap)
  {
    a(paramContext, paramString1, paramString2, paramLong, null, paramMap);
  }
  
  public static void onEventEnd(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, paramString2, null, null);
  }
  
  public static void onEventEnd(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    a(paramContext.getApplicationContext(), paramString1, paramString2, null, paramMap);
  }
  
  public static void onEventStart(Context paramContext, String paramString1, String paramString2)
  {
    if (!a(paramContext, "onEventStart(...)")) {}
    while ((paramString1 == null) || (paramString1.equals(""))) {
      return;
    }
    a(paramContext);
    bv.a().a(paramContext);
    bm.a().a(paramContext.getApplicationContext(), paramString1, paramString2, System.currentTimeMillis());
  }
  
  public static void onPageEnd(Context paramContext, String paramString)
  {
    try
    {
      a(paramContext, paramString, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static void onPageStart(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +16 -> 20
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: ldc 66
    //   14: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +13 -> 30
    //   20: ldc_w 356
    //   23: invokestatic 120	com/baidu/mobstat/db:c	(Ljava/lang/String;)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: invokestatic 154	com/baidu/mobstat/StatService:a	(Landroid/content/Context;)V
    //   34: invokestatic 159	com/baidu/mobstat/bv:a	()Lcom/baidu/mobstat/bv;
    //   37: aload_0
    //   38: invokevirtual 189	com/baidu/mobstat/bv:a	(Landroid/content/Context;)V
    //   41: invokestatic 97	com/baidu/mobstat/ch:a	()Lcom/baidu/mobstat/ch;
    //   44: aload_0
    //   45: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   48: aload_1
    //   49: invokevirtual 359	com/baidu/mobstat/ch:a	(Landroid/content/Context;JLjava/lang/String;)V
    //   52: goto -26 -> 26
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	Context
    //   0	61	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   11	20	55	finally
    //   20	26	55	finally
    //   30	52	55	finally
  }
  
  @Deprecated
  @TargetApi(11)
  public static void onPause(android.app.Fragment paramFragment)
  {
    if (paramFragment == null) {}
    for (;;)
    {
      try
      {
        db.c("android.app.Fragment onResume :parame=null");
        return;
      }
      finally {}
      if (!a(paramFragment.getClass(), "onPause")) {
        throw new SecurityException("android.app.Fragment onPause(Context context)不在android.app.Fragment.onPause()中被调用||onPause(Context context)is not called in android.app.Fragment.onPause().");
      }
      ch.a().b(paramFragment, System.currentTimeMillis());
    }
  }
  
  public static void onPause(Context paramContext)
  {
    try
    {
      a(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  @Deprecated
  public static void onPause(android.support.v4.app.Fragment paramFragment)
  {
    if (paramFragment == null) {}
    for (;;)
    {
      try
      {
        db.c("onResume :parame=null");
        return;
      }
      finally {}
      if (!a(android.support.v4.app.Fragment.class, "onPause")) {
        throw new SecurityException("Fragment onPause(Context context)不在Fragment.onPause()中被调用||onPause(Context context)is not called in Fragment.onPause().");
      }
      ch.a().b(paramFragment, System.currentTimeMillis());
    }
  }
  
  @Deprecated
  @TargetApi(11)
  public static void onResume(android.app.Fragment paramFragment)
  {
    if (paramFragment == null) {}
    for (;;)
    {
      try
      {
        db.c("onResume :parame=null");
        return;
      }
      finally {}
      if (!a(paramFragment.getClass(), "onResume")) {
        throw new SecurityException("onResume(Context context)不在Fragment.onResume()中被调用||onResume(Context context)is not called in Fragment.onResume().");
      }
      Context localContext = ch.a(paramFragment);
      if (localContext == null)
      {
        db.c("can not get correct context, fragment may not attached to activity");
      }
      else
      {
        a(localContext);
        bv.a().a(localContext);
        ch.a().a(paramFragment, System.currentTimeMillis());
      }
    }
  }
  
  public static void onResume(Context paramContext)
  {
    for (;;)
    {
      try
      {
        boolean bool = a(paramContext, "onResume(...)");
        if (!bool) {
          return;
        }
        if (!a(Activity.class, "onResume")) {
          throw new SecurityException("onResume(Context context)不在Activity.onResume()中被调用||onResume(Context context)is not called in Activity.onResume().");
        }
      }
      finally {}
      a(paramContext);
      bv.a().a(paramContext);
      ch.a().a(paramContext, System.currentTimeMillis(), false);
    }
  }
  
  @Deprecated
  public static void onResume(android.support.v4.app.Fragment paramFragment)
  {
    if (paramFragment == null) {}
    for (;;)
    {
      try
      {
        db.c("onResume :parame=null");
        return;
      }
      finally {}
      if (!a(android.support.v4.app.Fragment.class, "onResume")) {
        throw new SecurityException("onResume(Context context)不在Fragment.onResume()中被调用||onResume(Context context)is not called in Fragment.onResume().");
      }
      FragmentActivity localFragmentActivity = paramFragment.getActivity();
      if (localFragmentActivity == null)
      {
        db.c("can not get correct fragmentActivity, fragment may not attached to activity");
      }
      else
      {
        a(localFragmentActivity);
        bv.a().a(localFragmentActivity);
        ch.a().a(paramFragment, System.currentTimeMillis());
      }
    }
  }
  
  public static void setAppChannel(Context paramContext, String paramString, boolean paramBoolean)
  {
    PrefOperate.setAppChannel(paramContext, paramString, paramBoolean);
    a(paramContext);
  }
  
  @Deprecated
  public static void setAppChannel(String paramString)
  {
    PrefOperate.setAppChannel(paramString);
  }
  
  public static void setAppKey(String paramString)
  {
    PrefOperate.setAppKey(paramString);
  }
  
  public static void setDebugOn(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 7)
    {
      db.a = i;
      return;
    }
  }
  
  public static void setForTv(Context paramContext, boolean paramBoolean)
  {
    bj.a().c(paramContext, paramBoolean);
    a(paramContext);
  }
  
  public static void setLogSenderDelayed(int paramInt)
  {
    by.a().a(paramInt);
  }
  
  public static void setOn(Context paramContext, int paramInt)
  {
    if (!a(paramContext, "setOn(...)")) {}
    while (a) {
      return;
    }
    a = true;
    if ((paramInt & 0x1) != 0) {
      a(paramContext, false);
    }
    for (;;)
    {
      a(paramContext);
      return;
      if ((paramInt & 0x10) != 0) {
        a(paramContext, true);
      }
    }
  }
  
  @Deprecated
  public static void setSendLogStrategy(Context paramContext, SendStrategyEnum paramSendStrategyEnum, int paramInt)
  {
    setSendLogStrategy(paramContext, paramSendStrategyEnum, paramInt, false);
  }
  
  @Deprecated
  public static void setSendLogStrategy(Context paramContext, SendStrategyEnum paramSendStrategyEnum, int paramInt, boolean paramBoolean)
  {
    if (!a(paramContext, "setSendLogStrategy(...)")) {
      return;
    }
    boolean bool = dg.a(Application.class, "onCreate");
    if (bool) {
      db.c("method:start() 被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
    }
    a(paramContext);
    bv.a().a(paramContext, bool);
    by.a().a(paramContext.getApplicationContext(), paramSendStrategyEnum, paramInt, paramBoolean);
  }
  
  public static void setSessionTimeOut(int paramInt)
  {
    if (paramInt <= 0)
    {
      db.b("SessionTimeOut is between 1 and 600. Default value[30] is used");
      return;
    }
    if (paramInt <= 600)
    {
      ch.a().a(paramInt);
      return;
    }
    db.b("SessionTimeOut is between 1 and 600. Value[600] is used");
    ch.a().a(600);
  }
  
  public static void start(Context paramContext)
  {
    if (!a(paramContext, "start(...)")) {
      return;
    }
    boolean bool = dg.a(Application.class, "onCreate");
    if (bool) {
      db.c("method:start() 被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
    }
    a(paramContext);
    bv.a().a(paramContext, bool);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/mobstat/StatService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */