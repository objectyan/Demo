package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

class ch
{
  private static final ch a = new ch();
  private static HashMap<String, cm> o = new HashMap();
  private cn b = new cn();
  private cn c = new cn();
  private cn d = new cn();
  private cn e = new cn();
  private long f = 0L;
  private boolean g = true;
  private boolean h;
  private cf i = new cf();
  private int j = -1;
  private volatile int k;
  private volatile long l;
  private Handler m;
  private Runnable n = null;
  
  private ch()
  {
    HandlerThread localHandlerThread = new HandlerThread("SessionAnalysisThread");
    localHandlerThread.start();
    localHandlerThread.setPriority(10);
    this.m = new Handler(localHandlerThread.getLooper());
  }
  
  static Context a(Object paramObject)
  {
    try
    {
      paramObject = (Context)paramObject.getClass().getMethod("getActivity", new Class[0]).invoke(paramObject, new Object[0]);
      return (Context)paramObject;
    }
    catch (Throwable paramObject)
    {
      db.a(((Throwable)paramObject).getMessage());
    }
    return null;
  }
  
  public static ch a()
  {
    return a;
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    if (this.i.c() > 0L)
    {
      String str = this.i.d().toString();
      db.a("new session: " + str);
      DataCore.instance().putSession(str);
      DataCore.instance().flush(paramContext);
      this.i.d(0L);
    }
    if (paramBoolean) {
      d();
    }
    DataCore.instance().saveLogDataToSend(paramContext, paramBoolean, false);
    by.a().a(paramContext);
    b(paramContext);
  }
  
  private void a(String paramString)
  {
    localHashMap = o;
    if (paramString == null) {}
    try
    {
      db.c("page Object is null");
      return;
    }
    finally {}
    cm localcm = new cm(paramString);
    if (!o.containsKey(paramString)) {
      o.put(paramString, localcm);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  private cm b(String paramString)
  {
    synchronized (o)
    {
      if (!o.containsKey(paramString)) {
        a(paramString);
      }
      paramString = (cm)o.get(paramString);
      return paramString;
    }
  }
  
  private void c(Context paramContext)
  {
    String str1 = this.i.d().toString();
    this.k = str1.getBytes().length;
    db.a("cacheString = " + str1);
    String str2 = de.q(paramContext);
    cu.a(paramContext, str2 + "__local_last_session.json", str1, false);
  }
  
  private void c(String paramString)
  {
    localHashMap = o;
    if (paramString == null) {}
    try
    {
      db.c("pageName is null");
      return;
    }
    finally {}
    if (o.containsKey(paramString)) {
      o.remove(paramString);
    }
  }
  
  private boolean g()
  {
    return this.g;
  }
  
  private int h()
  {
    try
    {
      Class localClass1 = Class.forName("android.app.Fragment");
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        for (;;)
        {
          Class localClass2 = Class.forName("android.support.v4.app.Fragment");
          StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
          int i1 = 0;
          for (;;)
          {
            if (i1 >= arrayOfStackTraceElement.length) {
              break label156;
            }
            localObject3 = arrayOfStackTraceElement[i1].getClassName();
            String str = arrayOfStackTraceElement[i1].getMethodName();
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(str)) && (str.equals("onResume"))) {
              break;
            }
            i1 += 1;
          }
          localClassNotFoundException1 = localClassNotFoundException1;
          localObject1 = null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        Object localObject2;
        Class localClass3;
        do
        {
          for (;;)
          {
            Object localObject3;
            Object localObject1;
            localObject2 = null;
            continue;
            try
            {
              localObject3 = Class.forName((String)localObject3);
              if (localObject3 != null) {
                if (Activity.class.isAssignableFrom((Class)localObject3)) {
                  return 1;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                localClass3 = null;
              }
              if ((localObject1 != null) && (((Class)localObject1).isAssignableFrom(localClass3))) {
                return 2;
              }
            }
          }
        } while ((localObject2 == null) || (!((Class)localObject2).isAssignableFrom(localClass3)));
        return 2;
      }
    }
    label156:
    return 3;
  }
  
  private void i()
  {
    boolean bool = g();
    db.a("isFirstResume:" + bool);
    if (bool)
    {
      a(false);
      this.m.post(new ck(this));
    }
  }
  
  public void a(int paramInt)
  {
    this.j = (paramInt * 1000);
  }
  
  public void a(long paramLong)
  {
    this.i.a(paramLong);
  }
  
  @TargetApi(11)
  public void a(android.app.Fragment paramFragment, long paramLong)
  {
    db.a("post resume job");
    if (this.d.c) {
      db.c("遗漏StatService.onPause() || missing StatService.onPause()");
    }
    this.d.c = true;
    i();
    cp localcp = new cp(this, this.f, paramLong, this.l, null, null, paramFragment, 2, 3);
    this.m.post(localcp);
    this.d.b = new WeakReference(paramFragment);
    this.d.a = paramLong;
  }
  
  public void a(Context paramContext)
  {
    this.n = new cl(this, paramContext);
    this.m.postDelayed(this.n, c());
  }
  
  public void a(Context paramContext, long paramLong)
  {
    if (this.l == 0L)
    {
      paramContext = new ci(this, paramLong);
      this.m.post(paramContext);
    }
    this.l = paramLong;
  }
  
  public void a(Context paramContext, long paramLong, String paramString)
  {
    db.a("AnalysisPageStart");
    if (TextUtils.isEmpty(paramString))
    {
      db.c("自定义页面 pageName 为 null");
      return;
    }
    paramString = b(paramString);
    if (paramString == null)
    {
      db.c("get page info, PageInfo null");
      return;
    }
    if (paramString.b) {
      db.c("遗漏StatService.onPageEnd() || missing StatService.onPageEnd()");
    }
    paramString.b = true;
    paramString.c = paramLong;
    i();
    if (!this.h)
    {
      paramString = new cp(this, this.f, paramLong, this.l, paramContext, null, null, h(), 1);
      this.m.post(paramString);
      this.h = true;
    }
    this.b.b = new WeakReference(paramContext);
    this.b.a = paramLong;
  }
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, ExtraInfo paramExtraInfo)
  {
    db.a("post pause job");
    this.h = false;
    if (TextUtils.isEmpty(paramString2))
    {
      db.c("自定义页面 pageName 无效值");
      return;
    }
    cm localcm = b(paramString2);
    if (localcm == null)
    {
      db.c("get page info, PageInfo null");
      return;
    }
    if (!localcm.b)
    {
      db.c("Please check (1)遗漏StatService.onPageStart() || missing StatService.onPageStart()");
      return;
    }
    localcm.b = false;
    localcm.d = paramLong;
    paramContext = new co(this, paramLong, paramContext, null, localcm.c, (Context)this.b.b.get(), null, 1, paramString2, null, null, paramString1, false, paramExtraInfo, localcm);
    this.m.post(paramContext);
    c(paramString2);
    this.f = paramLong;
  }
  
  public void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.c = true;
      this.e.b = new WeakReference(paramContext);
      this.e.a = paramLong;
    }
    db.a("AnalysisResume job");
    if ((!paramBoolean) && (this.b.c)) {
      db.c("遗漏StatService.onPause() || missing StatService.onPause()");
    }
    if (!paramBoolean) {
      this.b.c = true;
    }
    i();
    if (!this.h)
    {
      cp localcp = new cp(this, this.f, paramLong, this.l, paramContext, null, null, 1, 1);
      this.m.post(localcp);
      this.h = true;
    }
    this.b.b = new WeakReference(paramContext);
    this.b.a = paramLong;
  }
  
  public void a(Context paramContext, long paramLong, boolean paramBoolean, ExtraInfo paramExtraInfo)
  {
    db.a("post pause job");
    this.h = false;
    if (paramBoolean)
    {
      this.e.c = false;
      paramContext = new co(this, paramLong, paramContext, null, this.e.a, (Context)this.e.b.get(), null, 1, null, null, null, null, paramBoolean, paramExtraInfo, null);
      this.m.post(paramContext);
      this.f = paramLong;
      return;
    }
    if (!this.b.c)
    {
      db.c("遗漏StatService.onResume() || missing StatService.onResume()");
      return;
    }
    this.b.c = false;
    paramContext = new co(this, paramLong, paramContext, null, this.b.a, (Context)this.b.b.get(), null, 1, null, null, null, null, paramBoolean, paramExtraInfo, null);
    this.m.post(paramContext);
    this.f = paramLong;
  }
  
  public void a(android.support.v4.app.Fragment paramFragment, long paramLong)
  {
    db.a("post resume job");
    if (this.c.c) {
      db.c("遗漏StatService.onPause() || missing StatService.onPause()");
    }
    this.c.c = true;
    i();
    cp localcp = new cp(this, this.f, paramLong, this.l, null, paramFragment, null, 2, 2);
    this.m.post(localcp);
    this.c.b = new WeakReference(paramFragment);
    this.c.a = paramLong;
  }
  
  public int b()
  {
    return this.k;
  }
  
  public void b(int paramInt)
  {
    this.i.a(paramInt);
  }
  
  public void b(long paramLong)
  {
    this.i.b(paramLong);
  }
  
  @TargetApi(11)
  public void b(android.app.Fragment paramFragment, long paramLong)
  {
    db.a("post pause job");
    if (!this.d.c)
    {
      db.c("遗漏android.app.Fragment StatService.onResume() || android.app.Fragment missing StatService.onResume()");
      return;
    }
    this.d.c = false;
    paramFragment = new co(this, paramLong, null, null, this.d.a, null, null, 3, null, this.d.b.get(), paramFragment, null, false, null, null);
    this.m.post(paramFragment);
    this.f = paramLong;
  }
  
  public void b(Context paramContext)
  {
    if (paramContext == null)
    {
      db.a("clearLastSession context is null, invalid");
      return;
    }
    String str1 = new JSONObject().toString();
    String str2 = de.q(paramContext);
    cu.a(paramContext, str2 + "__local_last_session.json", str1, false);
  }
  
  public void b(Context paramContext, long paramLong)
  {
    paramContext = new cj(this, paramLong, paramContext);
    this.m.post(paramContext);
  }
  
  public void b(android.support.v4.app.Fragment paramFragment, long paramLong)
  {
    db.a("post pause job");
    if (!this.c.c)
    {
      db.c("遗漏android.support.v4.app.Fragment StatService.onResume() || android.support.v4.app.Fragment missing StatService.onResume()");
      return;
    }
    this.c.c = false;
    paramFragment = new co(this, paramLong, null, paramFragment, this.c.a, null, (android.support.v4.app.Fragment)this.c.b.get(), 2, null, null, null, null, false, null, null);
    this.m.post(paramFragment);
    this.f = paramLong;
  }
  
  public int c()
  {
    if (this.j == -1) {
      this.j = 30000;
    }
    return this.j;
  }
  
  public void d()
  {
    this.i.a();
  }
  
  public long e()
  {
    return this.i.b();
  }
  
  public void f()
  {
    Runnable localRunnable = this.n;
    this.n = null;
    if (localRunnable != null) {
      this.m.removeCallbacks(localRunnable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */