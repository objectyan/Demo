package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.a.a.a.a.g;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.b.s;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static int A;
  private static String B;
  private static String C;
  private static String D;
  private static String E;
  private static int F;
  private static int G;
  private static long H;
  private static long I;
  private static volatile String J = "http://pingma.qq.com:80/mstat/report";
  private static int K = 0;
  private static volatile int L = 0;
  private static int M = 20;
  private static int N = 0;
  private static boolean O = false;
  private static int P = 4096;
  private static boolean Q = false;
  private static String R = null;
  private static boolean S = false;
  private static au T = null;
  static at a;
  static at b;
  static String c;
  static String d;
  static String e;
  static String f;
  static boolean g;
  static int h;
  static long i;
  static boolean j;
  public static boolean k;
  static volatile String l;
  static boolean m = true;
  static int n = 0;
  static long o = 10000L;
  static int p = 512;
  private static b q = ;
  private static h r;
  private static boolean s;
  private static boolean t;
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  private static int y;
  private static int z;
  
  static
  {
    a = new at(2);
    b = new at(1);
    r = h.d;
    s = false;
    t = true;
    u = 30000;
    v = 100000;
    w = 30;
    x = 10;
    y = 100;
    z = 30;
    A = 1;
    c = "__HIBERNATE__";
    d = "__HIBERNATE__TIME";
    e = "__MTA_KILL__";
    B = null;
    E = "mta_channel";
    f = "";
    F = 180;
    g = false;
    h = 100;
    i = 10000L;
    G = 1024;
    j = true;
    H = 0L;
    I = 300000L;
    k = true;
    l = "pingma.qq.com:80";
  }
  
  public static au A()
  {
    return T;
  }
  
  public static boolean B()
  {
    return m;
  }
  
  public static int C()
  {
    return n;
  }
  
  public static long D()
  {
    return o;
  }
  
  public static int E()
  {
    return p;
  }
  
  public static h a()
  {
    return r;
  }
  
  static String a(Context paramContext)
  {
    return s.a(r.a(paramContext, "_mta_ky_tag_", null));
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a.b.getString(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      q.b(paramString);
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a.b.getString(paramString1);
      if (paramString1 != null) {
        paramString2 = paramString1;
      }
      return paramString2;
    }
    catch (Throwable paramString1)
    {
      q.b(paramString1);
    }
    return paramString2;
  }
  
  public static void a(int paramInt)
  {
    if (!a(paramInt, 1000, 86400000))
    {
      q.g("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
      return;
    }
    u = paramInt;
  }
  
  public static void a(int paramInt, long paramLong)
  {
    h = paramInt;
    if (paramLong >= 1000L) {
      i = paramLong;
    }
  }
  
  static void a(long paramLong)
  {
    r.b(aw.a(), c, paramLong);
    b(false);
    q.e("MTA is disable for current SDK version");
  }
  
  static void a(Context paramContext, at paramat)
  {
    if (paramat.a == b.a)
    {
      b = paramat;
      a(paramat.b);
      if (!b.b.isNull("iplist")) {
        l.a(paramContext).a(b.b.getString("iplist"));
      }
    }
    while (paramat.a != a.a) {
      return;
    }
    a = paramat;
  }
  
  static void a(Context paramContext, at paramat, JSONObject paramJSONObject)
  {
    int i1 = 0;
    label210:
    for (;;)
    {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("v"))
          {
            int i2 = paramJSONObject.getInt(str);
            if (paramat.d == i2) {
              break label210;
            }
            i1 = 1;
            paramat.d = i2;
            continue;
          }
          if (str.equalsIgnoreCase("c"))
          {
            str = paramJSONObject.getString("c");
            if (str.length() <= 0) {
              continue;
            }
            paramat.b = new JSONObject(str);
            continue;
          }
        }
      }
      catch (JSONException paramContext)
      {
        String str;
        q.b(paramContext);
        return;
        if (!str.equalsIgnoreCase("m")) {
          continue;
        }
        paramat.c = paramJSONObject.getString("m");
        continue;
      }
      catch (Throwable paramContext)
      {
        q.b(paramContext);
        return;
      }
      if (i1 == 1)
      {
        paramJSONObject = ag.a(aw.a());
        if (paramJSONObject != null) {
          paramJSONObject.a(paramat);
        }
        if (paramat.a == b.a)
        {
          a(paramat.b);
          b(paramat.b);
        }
      }
      a(paramContext, paramat);
      return;
    }
  }
  
  static void a(Context paramContext, String paramString)
  {
    if (paramString != null) {
      r.b(paramContext, "_mta_ky_tag_", s.b(paramString));
    }
  }
  
  static void a(Context paramContext, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (((String)localObject).equalsIgnoreCase(Integer.toString(b.a)))
          {
            localObject = paramJSONObject.getJSONObject((String)localObject);
            a(paramContext, b, (JSONObject)localObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramContext)
      {
        q.b(paramContext);
      }
      do
      {
        if (((String)localObject).equalsIgnoreCase(Integer.toString(a.a)))
        {
          localObject = paramJSONObject.getJSONObject((String)localObject);
          a(paramContext, a, (JSONObject)localObject);
          break;
        }
      } while (!((String)localObject).equalsIgnoreCase("rs"));
      Object localObject = h.a(paramJSONObject.getInt((String)localObject));
      if (localObject != null)
      {
        r = (h)localObject;
        if (b()) {
          q.j("Change to ReportStrategy:" + ((h)localObject).name());
        }
      }
    }
  }
  
  public static void a(au paramau)
  {
    T = paramau;
  }
  
  public static void a(h paramh)
  {
    r = paramh;
    if (paramh != h.f) {
      j.c = 0L;
    }
    if (b()) {
      q.j("Change to statSendStrategy: " + paramh);
    }
  }
  
  static void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = h.a(paramJSONObject.getInt("rs"));
      if (paramJSONObject != null) {
        a(paramJSONObject);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!b()) {}
      q.b("rs not found.");
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    s = paramBoolean;
    m.b().a(paramBoolean);
  }
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 <= paramInt3);
  }
  
  static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!paramJSONObject.isNull(paramString1))
    {
      paramJSONObject = paramJSONObject.optString(paramString1);
      if ((m.c(paramString2)) && (m.c(paramJSONObject)) && (paramString2.equalsIgnoreCase(paramJSONObject))) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 385	com/tencent/wxop/stat/f:C	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 385	com/tencent/wxop/stat/f:C	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: ifnull +16 -> 35
    //   22: getstatic 385	com/tencent/wxop/stat/f:C	Ljava/lang/String;
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: invokestatic 387	com/tencent/wxop/stat/b/m:f	(Landroid/content/Context;)Ljava/lang/String;
    //   32: putstatic 385	com/tencent/wxop/stat/f:C	Ljava/lang/String;
    //   35: getstatic 385	com/tencent/wxop/stat/f:C	Ljava/lang/String;
    //   38: ifnull +15 -> 53
    //   41: getstatic 385	com/tencent/wxop/stat/f:C	Ljava/lang/String;
    //   44: invokevirtual 390	java/lang/String:trim	()Ljava/lang/String;
    //   47: invokevirtual 297	java/lang/String:length	()I
    //   50: ifne +12 -> 62
    //   53: getstatic 65	com/tencent/wxop/stat/f:q	Lcom/tencent/wxop/stat/b/b;
    //   56: ldc_w 392
    //   59: invokevirtual 226	com/tencent/wxop/stat/b/b:g	(Ljava/lang/Object;)V
    //   62: getstatic 385	com/tencent/wxop/stat/f:C	Ljava/lang/String;
    //   65: astore_0
    //   66: goto -53 -> 13
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	13	69	finally
    //   22	35	69	finally
    //   35	53	69	finally
    //   53	62	69	finally
    //   62	66	69	finally
  }
  
  static String b(String paramString1, String paramString2)
  {
    try
    {
      String str = b.b.getString(paramString1);
      if (str != null) {
        paramString2 = str;
      }
      return paramString2;
    }
    catch (Throwable localThrowable)
    {
      q.f("can't find custom key:" + paramString1);
    }
    return paramString2;
  }
  
  public static void b(int paramInt)
  {
    if (paramInt > 100) {
      y = paramInt;
    }
  }
  
  public static void b(long paramLong)
  {
    if (paramLong > 0L) {
      o = paramLong;
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      q.g("ctx in StatConfig.setAppKey() is null");
    }
    do
    {
      return;
      if ((paramString == null) || (paramString.length() > 256))
      {
        q.g("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        return;
      }
      if (C == null) {
        C = a(paramContext);
      }
    } while (!(e(paramString) | e(m.f(paramContext))));
    a(paramContext, C);
  }
  
  static void b(Context paramContext, JSONObject paramJSONObject)
  {
    for (;;)
    {
      Object localObject;
      int i1;
      try
      {
        paramJSONObject = paramJSONObject.optString(e);
        if (!m.c(paramJSONObject)) {
          break;
        }
        paramJSONObject = new JSONObject(paramJSONObject);
        if (paramJSONObject.length() == 0) {
          return;
        }
        if (!paramJSONObject.isNull("sm"))
        {
          localObject = paramJSONObject.get("sm");
          if (!(localObject instanceof Integer)) {
            break label531;
          }
          i1 = ((Integer)localObject).intValue();
          if (i1 > 0)
          {
            if (b()) {
              q.b("match sleepTime:" + i1 + " minutes");
            }
            long l1 = System.currentTimeMillis();
            long l2 = i1 * 60 * 1000;
            r.b(paramContext, d, l1 + l2);
            b(false);
            q.e("MTA is disable for current SDK version");
          }
        }
        if (!a(paramJSONObject, "sv", "2.0.3")) {
          break label554;
        }
        q.b("match sdk version:2.0.3");
        i1 = 1;
        if (a(paramJSONObject, "md", Build.MODEL))
        {
          q.b("match MODEL:" + Build.MODEL);
          i1 = 1;
        }
        if (a(paramJSONObject, "av", m.j(paramContext)))
        {
          q.b("match app version:" + m.j(paramContext));
          i1 = 1;
        }
        if (a(paramJSONObject, "mf", Build.MANUFACTURER))
        {
          q.b("match MANUFACTURER:" + Build.MANUFACTURER);
          i1 = 1;
        }
        if (a(paramJSONObject, "osv", Build.VERSION.SDK_INT))
        {
          q.b("match android SDK version:" + Build.VERSION.SDK_INT);
          i1 = 1;
        }
        if (a(paramJSONObject, "ov", Build.VERSION.SDK_INT))
        {
          q.b("match android SDK version:" + Build.VERSION.SDK_INT);
          i1 = 1;
        }
        if (a(paramJSONObject, "ui", ag.a(paramContext).b(paramContext).b()))
        {
          q.b("match imei:" + ag.a(paramContext).b(paramContext).b());
          i1 = 1;
        }
        if (a(paramJSONObject, "mid", g(paramContext)))
        {
          q.b("match mid:" + g(paramContext));
          i1 = 1;
        }
        if (i1 == 0) {
          break;
        }
        a(m.b("2.0.3"));
        return;
      }
      catch (Exception paramContext)
      {
        q.b(paramContext);
        return;
      }
      label531:
      if ((localObject instanceof String))
      {
        i1 = Integer.valueOf((String)localObject).intValue();
        continue;
        label554:
        i1 = 0;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public static void b(String paramString)
  {
    if (paramString == null)
    {
      q.g("appkey in StatConfig.setAppKey() is null");
      return;
    }
    if (paramString.length() > 256)
    {
      q.g("The length of appkey cann't exceed 256 bytes.");
      return;
    }
    C = paramString;
  }
  
  static void b(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        b(aw.a(), paramJSONObject);
        paramJSONObject = paramJSONObject.getString(c);
        if (b()) {
          q.j("hibernateVer:" + paramJSONObject + ", current version:2.0.3");
        }
        long l1 = m.b(paramJSONObject);
        if (m.b("2.0.3") <= l1)
        {
          a(l1);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        q.j("__HIBERNATE__ not found.");
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    t = paramBoolean;
    if (!paramBoolean) {
      q.e("!!!!!!MTA StatService has been disabled!!!!!!");
    }
  }
  
  public static boolean b()
  {
    return s;
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: getstatic 118	com/tencent/wxop/stat/f:E	Ljava/lang/String;
    //   22: ldc 120
    //   24: invokestatic 196	com/tencent/wxop/stat/b/r:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: putstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   32: aload_1
    //   33: ifnull +15 -> 48
    //   36: getstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   39: invokevirtual 390	java/lang/String:trim	()Ljava/lang/String;
    //   42: invokevirtual 297	java/lang/String:length	()I
    //   45: ifne +10 -> 55
    //   48: aload_0
    //   49: invokestatic 515	com/tencent/wxop/stat/b/m:g	(Landroid/content/Context;)Ljava/lang/String;
    //   52: putstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   55: getstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   58: ifnull +15 -> 73
    //   61: getstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   64: invokevirtual 390	java/lang/String:trim	()Ljava/lang/String;
    //   67: invokevirtual 297	java/lang/String:length	()I
    //   70: ifne +12 -> 82
    //   73: getstatic 65	com/tencent/wxop/stat/f:q	Lcom/tencent/wxop/stat/b/b;
    //   76: ldc_w 517
    //   79: invokevirtual 396	com/tencent/wxop/stat/b/b:f	(Ljava/lang/Object;)V
    //   82: getstatic 514	com/tencent/wxop/stat/f:D	Ljava/lang/String;
    //   85: astore_0
    //   86: goto -73 -> 13
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   27	6	1	str	String
    // Exception table:
    //   from	to	target	type
    //   3	13	89	finally
    //   18	32	89	finally
    //   36	48	89	finally
    //   48	55	89	finally
    //   55	73	89	finally
    //   73	82	89	finally
    //   82	86	89	finally
  }
  
  public static void c(int paramInt)
  {
    if (!a(paramInt, 2, 1000))
    {
      q.g("setMaxBatchReportCount can not exceed the range of [2,1000].");
      return;
    }
    z = paramInt;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (paramString.length() > 128)
    {
      q.g("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    D = paramString;
    r.b(paramContext, E, paramString);
  }
  
  public static void c(String paramString)
  {
    if (paramString.length() > 128)
    {
      q.g("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    D = paramString;
  }
  
  public static void c(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static boolean c()
  {
    return t;
  }
  
  public static int d()
  {
    return u;
  }
  
  public static String d(Context paramContext)
  {
    return r.a(paramContext, "mta.acc.qq", f);
  }
  
  public static void d(int paramInt)
  {
    if (!a(paramInt, 1, 1000))
    {
      q.g("setMaxSendRetryCount can not exceed the range of [1,1000].");
      return;
    }
    x = paramInt;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    r.b(paramContext, "mta.acc.qq", paramString);
    f = paramString;
  }
  
  public static void d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      q.g("statReportUrl cannot be null or empty.");
    }
    for (;;)
    {
      return;
      J = paramString;
      try
      {
        l = new URI(J).getHost();
        if (!b()) {
          continue;
        }
        q.b("url:" + J + ", domain:" + l);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          q.f(paramString);
        }
      }
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public static int e()
  {
    return y;
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext == null)
    {
      q.g("Context for getCustomUid is null.");
      return null;
    }
    if (R == null) {
      R = r.a(paramContext, "MTA_CUSTOM_UID", "");
    }
    return R;
  }
  
  public static void e(int paramInt)
  {
    if (paramInt > 0) {
      A = paramInt;
    }
  }
  
  public static void e(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      q.g("Context for setCustomUid is null.");
      return;
    }
    r.b(paramContext, "MTA_CUSTOM_UID", paramString);
    R = paramString;
  }
  
  public static void e(boolean paramBoolean)
  {
    Q = paramBoolean;
  }
  
  private static boolean e(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (C == null)
      {
        C = paramString;
        return true;
      }
    } while (C.contains(paramString));
    C = C + "|" + paramString;
    return true;
  }
  
  public static int f()
  {
    return z;
  }
  
  public static String f(Context paramContext)
  {
    return g(paramContext);
  }
  
  public static void f(int paramInt)
  {
    if (!a(paramInt, 0, 500000))
    {
      q.g("setMaxStoreEventCount can not exceed the range of [0, 500000].");
      return;
    }
    v = paramInt;
  }
  
  public static void f(boolean paramBoolean)
  {
    S = paramBoolean;
  }
  
  public static int g()
  {
    return x;
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext != null) {
      return g.a(paramContext).a().a();
    }
    return "0";
  }
  
  public static void g(int paramInt)
  {
    if (!a(paramInt, 1, 10080))
    {
      q.g("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
      return;
    }
    F = paramInt;
  }
  
  public static void g(boolean paramBoolean)
  {
    m = paramBoolean;
  }
  
  public static int h()
  {
    return A;
  }
  
  public static void h(int paramInt)
  {
    if (!a(paramInt, 1, 4096))
    {
      q.g("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
      return;
    }
    G = paramInt;
  }
  
  static int i()
  {
    return w;
  }
  
  public static void i(int paramInt)
  {
    if (paramInt < 0)
    {
      q.g("maxSessionStatReportCount cannot be less than 0.");
      return;
    }
    K = paramInt;
  }
  
  public static int j()
  {
    return v;
  }
  
  static void j(int paramInt)
  {
    try
    {
      L = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int k()
  {
    return h;
  }
  
  public static void k(int paramInt)
  {
    if (paramInt <= 0)
    {
      q.h("maxDaySessionNumbers must be greater than 0.");
      return;
    }
    M = paramInt;
  }
  
  public static long l()
  {
    return i;
  }
  
  static void l(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    N = paramInt;
  }
  
  public static int m()
  {
    return F;
  }
  
  public static void m(int paramInt)
  {
    if (paramInt <= 0)
    {
      q.g("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
      return;
    }
    P = paramInt;
  }
  
  public static int n()
  {
    return G;
  }
  
  public static void n(int paramInt)
  {
    if (paramInt >= 0) {
      n = paramInt;
    }
  }
  
  public static void o(int paramInt)
  {
    if (paramInt > 0) {
      p = paramInt;
    }
  }
  
  public static boolean o()
  {
    return j;
  }
  
  public static boolean p()
  {
    return k;
  }
  
  public static String q()
  {
    return J;
  }
  
  public static String r()
  {
    return l;
  }
  
  public static int s()
  {
    return K;
  }
  
  public static int t()
  {
    return L;
  }
  
  public static int u()
  {
    return M;
  }
  
  static void v()
  {
    N += 1;
  }
  
  static int w()
  {
    return N;
  }
  
  public static int x()
  {
    return P;
  }
  
  public static boolean y()
  {
    return Q;
  }
  
  public static boolean z()
  {
    return S;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */