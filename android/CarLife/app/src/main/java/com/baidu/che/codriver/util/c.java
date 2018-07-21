package com.baidu.che.codriver.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.carlife.bluetooth.i;
import com.baidu.mobstat.StatService;
import java.util.ArrayList;
import java.util.Iterator;

public class c
{
  private static final String a = "CoDriverUtil";
  private static final String b = "unknow";
  private static String c;
  private static String d;
  private static int e = -1;
  private static int f;
  private static int g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static Context q;
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static Context a()
  {
    return q;
  }
  
  public static void a(Context paramContext)
  {
    q = paramContext;
    try
    {
      paramContext = q.getPackageManager().getPackageInfo(q.getPackageName(), 0);
      c = paramContext.packageName;
      d = paramContext.versionName;
      e = paramContext.versionCode;
      paramContext = new DisplayMetrics();
      ((WindowManager)q.getSystemService("window")).getDefaultDisplay().getMetrics(paramContext);
      f = Math.max(paramContext.widthPixels, paramContext.heightPixels);
      g = Math.min(paramContext.widthPixels, paramContext.heightPixels);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    StatService.onEvent(paramContext.getApplicationContext(), paramString, "StatOnEvent", 1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    StatService.onEvent(paramContext.getApplicationContext(), paramString1, paramString2, 1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramContext);
    b(paramString1);
    c(paramString2);
    a(paramString3);
    e(paramString4);
  }
  
  public static void a(String paramString)
  {
    h = paramString;
    com.baidu.che.codriver.i.a.a(paramString);
  }
  
  public static String b()
  {
    return f + "*" + g;
  }
  
  private static void b(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (!paramContext.isScreenOn())
    {
      paramContext = paramContext.newWakeLock(268435462, "bright");
      paramContext.acquire();
      paramContext.release();
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    StatService.onEventStart(paramContext.getApplicationContext(), paramString, "StatOnEvent");
    h.b("CoDriver_TAG", "Send mtj event start：" + paramString);
  }
  
  public static void b(String paramString)
  {
    i = paramString;
  }
  
  public static int c()
  {
    return f;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    StatService.onEventEnd(paramContext.getApplicationContext(), paramString, "StatOnEvent");
    h.b("CoDriver_TAG", "Send mtj event end：" + paramString);
  }
  
  public static void c(String paramString)
  {
    j = paramString;
    com.baidu.che.codriver.i.a.b(paramString);
  }
  
  public static int d()
  {
    return g;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    StatService.onEventDuration(paramContext.getApplicationContext(), paramString, "StatOnEvent", 1L);
    h.b("CoDriver_TAG", "Send mtj event duration：" + paramString);
  }
  
  public static void d(String paramString)
  {
    p = paramString;
  }
  
  public static String e()
  {
    if (TextUtils.isEmpty(c)) {
      return "unknow";
    }
    return c;
  }
  
  public static void e(String paramString)
  {
    k = paramString;
  }
  
  public static String f()
  {
    if (TextUtils.isEmpty(d)) {
      return "unknow";
    }
    return d;
  }
  
  public static String f(String paramString)
  {
    Object localObject = g.a().a(paramString);
    paramString = new StringBuilder();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        g.a locala = (g.a)((Iterator)localObject).next();
        if (2 == locala.e) {
          paramString.append(locala.g);
        } else {
          paramString.append(locala.f);
        }
      }
    }
    return paramString.toString().toUpperCase();
  }
  
  public static int g()
  {
    return e;
  }
  
  public static String h()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String i()
  {
    return Build.MODEL;
  }
  
  public static String j()
  {
    if (TextUtils.isEmpty(h)) {
      h = v();
    }
    return h;
  }
  
  public static String k()
  {
    if (TextUtils.isEmpty(i)) {
      i = "3";
    }
    return i;
  }
  
  public static String l()
  {
    if (TextUtils.isEmpty(j)) {
      j = "nc";
    }
    return j;
  }
  
  public static String m()
  {
    return p;
  }
  
  public static String n()
  {
    return k;
  }
  
  public static boolean o()
  {
    return com.baidu.che.codriver.a.j < 6;
  }
  
  public static String p()
  {
    if (TextUtils.isEmpty(l)) {
      l = ((TelephonyManager)a().getSystemService("phone")).getDeviceId();
    }
    if (l == null) {
      l = "";
    }
    return l;
  }
  
  public static String q()
  {
    if (TextUtils.isEmpty(m)) {
      m = ((TelephonyManager)a().getSystemService("phone")).getSubscriberId();
    }
    if (m == null) {
      m = "";
    }
    return m;
  }
  
  public static String r()
  {
    n = ((WifiManager)a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
    if (!TextUtils.isEmpty(n))
    {
      n = n.replace(":", "");
      return n;
    }
    return "";
  }
  
  public static String s()
  {
    o = i.a();
    if (!TextUtils.isEmpty(o))
    {
      o = o.replace(":", "");
      return o;
    }
    return "";
  }
  
  public static String t()
  {
    return Settings.Secure.getString(a().getContentResolver(), "android_id");
  }
  
  public static boolean u()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)a().getSystemService("connectivity");
    NetworkInfo localNetworkInfo = null;
    if (localConnectivityManager != null) {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    }
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1);
  }
  
  /* Error */
  private static String v()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aload 5
    //   13: astore_3
    //   14: getstatic 59	com/baidu/che/codriver/util/c:q	Landroid/content/Context;
    //   17: invokevirtual 43	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc_w 376
    //   23: invokevirtual 380	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   26: astore_1
    //   27: aload 5
    //   29: astore_3
    //   30: aload_1
    //   31: astore_2
    //   32: aload_1
    //   33: astore 4
    //   35: new 382	java/io/ByteArrayOutputStream
    //   38: dup
    //   39: invokespecial 383	java/io/ByteArrayOutputStream:<init>	()V
    //   42: astore 5
    //   44: sipush 1024
    //   47: newarray <illegal type>
    //   49: astore_2
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 389	java/io/InputStream:read	([B)I
    //   55: istore_0
    //   56: iload_0
    //   57: iconst_m1
    //   58: if_icmpeq +53 -> 111
    //   61: aload 5
    //   63: aload_2
    //   64: iconst_0
    //   65: iload_0
    //   66: invokevirtual 393	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -19 -> 50
    //   72: astore 6
    //   74: aload 5
    //   76: astore_3
    //   77: aload_1
    //   78: astore_2
    //   79: ldc 8
    //   81: aload 6
    //   83: invokevirtual 394	java/lang/Exception:toString	()Ljava/lang/String;
    //   86: invokestatic 396	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 5
    //   91: ifnull +8 -> 99
    //   94: aload 5
    //   96: invokevirtual 399	java/io/ByteArrayOutputStream:close	()V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 400	java/io/InputStream:close	()V
    //   107: ldc_w 402
    //   110: areturn
    //   111: new 275	java/lang/String
    //   114: dup
    //   115: aload 5
    //   117: invokevirtual 406	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   120: invokespecial 409	java/lang/String:<init>	([B)V
    //   123: invokevirtual 412	java/lang/String:trim	()Ljava/lang/String;
    //   126: astore_2
    //   127: aload 5
    //   129: ifnull +8 -> 137
    //   132: aload 5
    //   134: invokevirtual 399	java/io/ByteArrayOutputStream:close	()V
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 400	java/io/InputStream:close	()V
    //   145: aload_2
    //   146: areturn
    //   147: astore_3
    //   148: ldc 8
    //   150: aload_3
    //   151: invokevirtual 413	java/io/IOException:toString	()Ljava/lang/String;
    //   154: invokestatic 396	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: goto -20 -> 137
    //   160: astore_1
    //   161: ldc 8
    //   163: aload_1
    //   164: invokevirtual 413	java/io/IOException:toString	()Ljava/lang/String;
    //   167: invokestatic 396	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: goto -25 -> 145
    //   173: astore_2
    //   174: ldc 8
    //   176: aload_2
    //   177: invokevirtual 413	java/io/IOException:toString	()Ljava/lang/String;
    //   180: invokestatic 396	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: goto -84 -> 99
    //   186: astore_1
    //   187: ldc 8
    //   189: aload_1
    //   190: invokevirtual 413	java/io/IOException:toString	()Ljava/lang/String;
    //   193: invokestatic 396	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: goto -89 -> 107
    //   199: astore_1
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 399	java/io/ByteArrayOutputStream:close	()V
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 400	java/io/InputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_3
    //   219: ldc 8
    //   221: aload_3
    //   222: invokevirtual 413	java/io/IOException:toString	()Ljava/lang/String;
    //   225: invokestatic 396	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: goto -20 -> 208
    //   231: astore_2
    //   232: ldc 8
    //   234: aload_2
    //   235: invokevirtual 413	java/io/IOException:toString	()Ljava/lang/String;
    //   238: invokestatic 396	com/baidu/che/codriver/util/h:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: goto -25 -> 216
    //   244: astore 4
    //   246: aload 5
    //   248: astore_3
    //   249: aload_1
    //   250: astore_2
    //   251: aload 4
    //   253: astore_1
    //   254: goto -54 -> 200
    //   257: astore_1
    //   258: aload 6
    //   260: astore 5
    //   262: aload_1
    //   263: astore 6
    //   265: aload 4
    //   267: astore_1
    //   268: goto -194 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	11	0	i1	int
    //   26	116	1	localInputStream	java.io.InputStream
    //   160	4	1	localIOException1	java.io.IOException
    //   186	4	1	localIOException2	java.io.IOException
    //   199	51	1	localObject1	Object
    //   253	1	1	localObject2	Object
    //   257	6	1	localException1	Exception
    //   267	1	1	localObject3	Object
    //   4	142	2	localObject4	Object
    //   173	40	2	localIOException3	java.io.IOException
    //   231	4	2	localIOException4	java.io.IOException
    //   250	1	2	localObject5	Object
    //   13	64	3	localObject6	Object
    //   147	58	3	localIOException5	java.io.IOException
    //   218	4	3	localIOException6	java.io.IOException
    //   248	1	3	localObject7	Object
    //   1	33	4	localObject8	Object
    //   244	22	4	localObject9	Object
    //   6	255	5	localObject10	Object
    //   9	1	6	localObject11	Object
    //   72	187	6	localException2	Exception
    //   263	1	6	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	72	java/lang/Exception
    //   50	56	72	java/lang/Exception
    //   61	69	72	java/lang/Exception
    //   111	127	72	java/lang/Exception
    //   132	137	147	java/io/IOException
    //   141	145	160	java/io/IOException
    //   94	99	173	java/io/IOException
    //   103	107	186	java/io/IOException
    //   14	27	199	finally
    //   35	44	199	finally
    //   79	89	199	finally
    //   204	208	218	java/io/IOException
    //   212	216	231	java/io/IOException
    //   44	50	244	finally
    //   50	56	244	finally
    //   61	69	244	finally
    //   111	127	244	finally
    //   14	27	257	java/lang/Exception
    //   35	44	257	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */