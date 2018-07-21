package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.a;
import com.tencent.wxop.stat.a.i;
import com.tencent.wxop.stat.b.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  static volatile int a;
  static volatile long b;
  static volatile long c = 0L;
  private static com.tencent.wxop.stat.b.g d;
  private static volatile Map<com.tencent.wxop.stat.a.c, Long> e = new ConcurrentHashMap();
  private static volatile Map<String, Properties> f = new ConcurrentHashMap();
  private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
  private static volatile long h = 0L;
  private static volatile long i = 0L;
  private static volatile long j = 0L;
  private static String k = "";
  private static volatile int l = 0;
  private static volatile String m = "";
  private static volatile String n = "";
  private static Map<String, Long> o = new ConcurrentHashMap();
  private static Map<String, Long> p = new ConcurrentHashMap();
  private static b q = com.tencent.wxop.stat.b.m.b();
  private static Thread.UncaughtExceptionHandler r = null;
  private static volatile boolean s = true;
  private static Context t;
  
  static
  {
    a = 0;
    b = 0L;
    t = null;
  }
  
  static int a(Context paramContext, boolean paramBoolean, k paramk)
  {
    int i2 = 1;
    long l1 = System.currentTimeMillis();
    if ((paramBoolean) && (l1 - i >= f.d())) {}
    for (int i1 = 1;; i1 = 0)
    {
      i = l1;
      if (j == 0L) {
        j = com.tencent.wxop.stat.b.m.c();
      }
      if (l1 >= j)
      {
        j = com.tencent.wxop.stat.b.m.c();
        if (ag.a(paramContext).b(paramContext).d() != 1) {
          ag.a(paramContext).b(paramContext).a(1);
        }
        f.l(0);
        a = 0;
        k = com.tencent.wxop.stat.b.m.a(0);
        i1 = 1;
      }
      String str = k;
      if (com.tencent.wxop.stat.b.m.a(paramk)) {
        str = paramk.c() + k;
      }
      if (!p.containsKey(str)) {
        i1 = i2;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (com.tencent.wxop.stat.b.m.a(paramk)) {
            break label232;
          }
          if (f.w() >= f.u()) {
            break label221;
          }
          com.tencent.wxop.stat.b.m.x(paramContext);
          a(paramContext, null);
        }
        for (;;)
        {
          p.put(str, Long.valueOf(1L));
          if (s)
          {
            h(paramContext);
            s = false;
          }
          return l;
          label221:
          q.h("Exceed StatConfig.getMaxDaySessionNumbers().");
          continue;
          label232:
          a(paramContext, paramk);
        }
      }
    }
  }
  
  public static Context a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext;
    }
    return t;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (!f.c()) {}
    do
    {
      return;
      if (f.b()) {
        q.b("commitEvents, maxNumber=" + paramInt);
      }
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.commitEvents() can not be null!");
        return;
      }
      if ((paramInt < -1) || (paramInt == 0))
      {
        q.g("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
        return;
      }
    } while ((!l.a(t).f()) || (e(paramContext) == null));
    d.a(new p(paramContext, paramInt));
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, String... paramVarArgs)
  {
    if (!f.c()) {}
    do
    {
      return;
      if (paramInt <= 0)
      {
        q.g("The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!");
        return;
      }
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomTimeIntervalEvent() can not be null!");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new n());
  }
  
  public static void a(Context paramContext, d paramd, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.h("context is null in reportAccount.");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new x(paramd, paramContext, paramk));
  }
  
  public static void a(Context paramContext, e parame, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      if (parame == null)
      {
        q.g("The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      if (parame.a() == null)
      {
        q.g("The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      parame = parame.h();
    } while (e(paramContext) == null);
    d.a(new m(paramContext, paramk, parame));
  }
  
  public static void a(Context paramContext, g paramg, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.reportGameUser() can not be null!");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new y(paramg, paramContext, paramk));
  }
  
  static void a(Context paramContext, k paramk)
  {
    if (e(paramContext) != null)
    {
      if (f.b()) {
        q.j("start new session.");
      }
      if ((paramk == null) || (l == 0)) {
        l = com.tencent.wxop.stat.b.m.a();
      }
      f.j(0);
      f.v();
      new ac(new com.tencent.wxop.stat.a.l(paramContext, l, b(), paramk)).a();
    }
  }
  
  public static void a(Context paramContext, String paramString, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        q.g("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
        return;
      }
      paramString = new String(paramString);
    } while (e(paramContext) == null);
    d.a(new bk(paramString, paramContext, paramk));
  }
  
  public static void a(Context paramContext, String paramString, k paramk, String... paramVarArgs)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.g("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      paramString = new com.tencent.wxop.stat.a.c(paramString, paramVarArgs, null);
    } while (e(paramContext) == null);
    d.a(new bg(paramContext, paramk, paramString));
  }
  
  public static void a(Context paramContext, String paramString, Properties paramProperties, int paramInt, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.g("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
        return;
      }
      paramString = new com.tencent.wxop.stat.a.c(paramString, null, paramProperties);
    } while (e(paramContext) == null);
    d.a(new o(paramContext, paramk, paramString, paramInt));
  }
  
  public static void a(Context paramContext, String paramString, Properties paramProperties, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.g("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      paramString = new com.tencent.wxop.stat.a.c(paramString, null, paramProperties);
    } while (e(paramContext) == null);
    d.a(new bi(paramContext, paramk, paramString));
  }
  
  static void a(Context paramContext, Throwable paramThrowable)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.reportSdkSelfException() can not be null!");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new be(paramContext, paramThrowable));
  }
  
  public static void a(Context paramContext, Throwable paramThrowable, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.reportException() can not be null!");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new bf(paramThrowable, paramContext, paramk));
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() > 512))
    {
      q.g("The map in setEnvAttributes can't be null or its size can't exceed 512.");
      return;
    }
    try
    {
      com.tencent.wxop.stat.b.d.a(paramContext, paramMap);
      return;
    }
    catch (JSONException paramContext)
    {
      q.b(paramContext);
    }
  }
  
  public static void a(Context paramContext, Map<String, Integer> paramMap, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.testSpeed() can not be null!");
        return;
      }
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        q.g("The domainMap of StatService.testSpeed() can not be null or empty!");
        return;
      }
      paramMap = new HashMap(paramMap);
    } while (e(paramContext) == null);
    d.a(new r(paramContext, paramMap, paramk));
  }
  
  public static void a(String paramString, Properties paramProperties)
  {
    if (com.tencent.wxop.stat.b.m.c(paramString))
    {
      if ((paramProperties != null) && (paramProperties.size() > 0))
      {
        f.put(paramString, (Properties)paramProperties.clone());
        return;
      }
      f.remove(paramString);
      return;
    }
    q.h("event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
  }
  
  static boolean a()
  {
    if (a >= 2)
    {
      b = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, k paramk)
  {
    for (;;)
    {
      try
      {
        if (!f.c())
        {
          q.g("MTA StatService is disable.");
          return false;
        }
        if (!f.b()) {
          break label219;
        }
        q.j("MTA SDK version, current: " + "2.0.3" + " ,required: " + paramString2);
      }
      catch (Throwable paramContext)
      {
        q.b(paramContext);
        return false;
      }
      q.g("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
      f.b(false);
      return false;
      label219:
      do
      {
        if (com.tencent.wxop.stat.b.m.b("2.0.3") < com.tencent.wxop.stat.b.m.b(paramString2))
        {
          paramContext = "MTA SDK version conflicted, current: " + "2.0.3" + ",required: " + paramString2;
          paramContext = paramContext + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
          q.g(paramContext);
          f.b(false);
          return false;
        }
        paramString2 = f.c(paramContext);
        if ((paramString2 == null) || (paramString2.length() == 0)) {
          f.c("-");
        }
        if (paramString1 != null) {
          f.b(paramContext, paramString1);
        }
        if (e(paramContext) != null) {
          d.a(new z(paramContext, paramk));
        }
        return true;
        if (paramContext == null) {
          break;
        }
      } while (paramString2 != null);
    }
  }
  
  static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static Properties b(String paramString)
  {
    return (Properties)f.get(paramString);
  }
  
  static JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (f.b.d != 0) {
        localJSONObject2.put("v", f.b.d);
      }
      localJSONObject1.put(Integer.toString(f.b.a), localJSONObject2);
      localJSONObject2 = new JSONObject();
      if (f.a.d != 0) {
        localJSONObject2.put("v", f.a.d);
      }
      localJSONObject1.put(Integer.toString(f.a.a), localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      q.b(localJSONException);
    }
    return localJSONObject1;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext != null) {
      t = paramContext.getApplicationContext();
    }
  }
  
  public static void b(Context paramContext, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.startNewSession() can not be null!");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new u(paramContext, paramk));
  }
  
  public static void b(Context paramContext, String paramString, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        q.g("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
        return;
      }
      paramString = new String(paramString);
    } while (e(paramContext) == null);
    d.a(new t(paramContext, paramString, paramk));
  }
  
  public static void b(Context paramContext, String paramString, k paramk, String... paramVarArgs)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomBeginEvent() can not be null!");
        return;
      }
      paramk = new com.tencent.wxop.stat.a.c(paramString, paramVarArgs, null);
    } while (e(paramContext) == null);
    d.a(new bj(paramString, paramk, paramContext));
  }
  
  public static void b(Context paramContext, String paramString, Properties paramProperties, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomBeginEvent() can not be null!");
        return;
      }
      paramProperties = new com.tencent.wxop.stat.a.c(paramString, null, paramProperties);
    } while (e(paramContext) == null);
    d.a(new bm(paramString, paramProperties, paramContext));
  }
  
  public static void c()
  {
    i = 0L;
  }
  
  static void c(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((d != null) || (!d(paramContext))) {
          continue;
        }
        paramContext = paramContext.getApplicationContext();
        t = paramContext;
        d = new com.tencent.wxop.stat.b.g();
        k = com.tencent.wxop.stat.b.m.a(0);
        h = System.currentTimeMillis() + f.i;
        d.a(new az(paramContext));
      }
      finally {}
    }
  }
  
  private static void c(Context paramContext, d paramd, k paramk)
  {
    try
    {
      new ac(new a(paramContext, a(paramContext, false, paramk), paramd, paramk)).a();
      return;
    }
    catch (Throwable paramd)
    {
      q.b(paramd);
      a(paramContext, paramd);
    }
  }
  
  public static void c(Context paramContext, k paramk)
  {
    if (!f.c()) {}
    while (e(paramContext) == null) {
      return;
    }
    d.a(new v(paramContext, paramk));
  }
  
  public static void c(Context paramContext, String paramString, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("context is null in reportQQ()");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new w(paramString, paramContext, paramk));
  }
  
  public static void c(Context paramContext, String paramString, k paramk, String... paramVarArgs)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      paramVarArgs = new com.tencent.wxop.stat.a.c(paramString, paramVarArgs, null);
    } while (e(paramContext) == null);
    d.a(new bl(paramString, paramVarArgs, paramContext, paramk));
  }
  
  public static void c(Context paramContext, String paramString, Properties paramProperties, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      paramProperties = new com.tencent.wxop.stat.a.c(paramString, null, paramProperties);
    } while (e(paramContext) == null);
    d.a(new bn(paramString, paramProperties, paramContext, paramk));
  }
  
  static void d()
  {
    a = 0;
    b = 0L;
  }
  
  public static void d(Context paramContext, k paramk)
  {
    if (!f.c()) {}
    while (e(paramContext) == null) {
      return;
    }
    d.a(new ba(paramContext, paramk));
  }
  
  public static void d(Context paramContext, String paramString, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.reportError() can not be null!");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new bd(paramString, paramContext, paramk));
  }
  
  static boolean d(Context paramContext)
  {
    boolean bool2 = false;
    long l1 = com.tencent.wxop.stat.b.r.a(paramContext, f.c, 0L);
    long l2 = com.tencent.wxop.stat.b.m.b("2.0.3");
    boolean bool1 = true;
    if (l2 <= l1)
    {
      q.g("MTA is disable for current version:" + l2 + ",wakeup version:" + l1);
      bool1 = false;
    }
    l1 = com.tencent.wxop.stat.b.r.a(paramContext, f.d, 0L);
    if (l1 > System.currentTimeMillis())
    {
      q.g("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + l1);
      bool1 = bool2;
    }
    for (;;)
    {
      f.b(bool1);
      return bool1;
    }
  }
  
  /* Error */
  static com.tencent.wxop.stat.b.g e(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 221	com/tencent/wxop/stat/j:d	Lcom/tencent/wxop/stat/b/g;
    //   3: ifnonnull +21 -> 24
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 221	com/tencent/wxop/stat/j:d	Lcom/tencent/wxop/stat/b/g;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +7 -> 21
    //   17: aload_0
    //   18: invokestatic 569	com/tencent/wxop/stat/j:c	(Landroid/content/Context;)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: getstatic 221	com/tencent/wxop/stat/j:d	Lcom/tencent/wxop/stat/b/g;
    //   27: areturn
    //   28: astore_0
    //   29: getstatic 80	com/tencent/wxop/stat/j:q	Lcom/tencent/wxop/stat/b/b;
    //   32: aload_0
    //   33: invokevirtual 571	com/tencent/wxop/stat/b/b:a	(Ljava/lang/Throwable;)V
    //   36: iconst_0
    //   37: invokestatic 424	com/tencent/wxop/stat/f:b	(Z)V
    //   40: goto -19 -> 21
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramContext	Context
    //   12	2	1	localg	com.tencent.wxop.stat.b.g
    // Exception table:
    //   from	to	target	type
    //   17	21	28	java/lang/Throwable
    //   9	13	43	finally
    //   17	21	43	finally
    //   21	24	43	finally
    //   29	40	43	finally
    //   44	47	43	finally
  }
  
  static void e()
  {
    a += 1;
    b = System.currentTimeMillis();
    i(t);
  }
  
  public static void e(Context paramContext, k paramk)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
    } while (e(paramContext) == null);
    d.a(new bb(paramContext));
  }
  
  public static void f(Context paramContext)
  {
    if (!f.c()) {}
    while (e(a(paramContext)) == null) {
      return;
    }
    d.a(new bc(paramContext));
  }
  
  static void g(Context paramContext)
  {
    if (!f.c()) {
      return;
    }
    paramContext = a(paramContext);
    if (paramContext == null)
    {
      q.g("The Context of StatService.sendNetworkDetector() can not be null!");
      return;
    }
    try
    {
      i locali = new i(paramContext);
      aw.b(paramContext).a(locali, new bh());
      return;
    }
    catch (Throwable paramContext)
    {
      q.b(paramContext);
    }
  }
  
  public static void h(Context paramContext)
  {
    if (!f.c()) {}
    do
    {
      return;
      paramContext = a(paramContext);
      if (paramContext == null)
      {
        q.g("The Context of StatService.testSpeed() can not be null!");
        return;
      }
    } while (e(paramContext) == null);
    d.a(new q(paramContext));
  }
  
  public static void i(Context paramContext)
  {
    if (!f.c()) {}
    while (f.n <= 0) {
      return;
    }
    paramContext = a(paramContext);
    if (paramContext == null)
    {
      q.g("The Context of StatService.testSpeed() can not be null!");
      return;
    }
    ag.a(paramContext).c();
  }
  
  static void j(Context paramContext)
  {
    c = System.currentTimeMillis() + 60000 * f.m();
    com.tencent.wxop.stat.b.r.b(paramContext, "last_period_ts", c);
    a(paramContext, -1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */