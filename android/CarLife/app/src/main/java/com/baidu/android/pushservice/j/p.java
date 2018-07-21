package com.baidu.android.pushservice.j;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.d.c;
import com.baidu.android.pushservice.h.j;
import com.baidu.android.pushservice.i;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.g;
import com.coloros.mcssdk.callback.PushCallback;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

@SuppressLint({"WorldReadableFiles"})
public final class p
{
  private static final String[] a = { "android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE" };
  private static int b = -1;
  private static boolean c = false;
  
  public static int A(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        i = paramContext.applicationInfo.targetSdkVersion;
      }
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static void A(Context paramContext)
  {
    Intent localIntent = new Intent("com.baidu.android.pushservice.action.METHOD");
    localIntent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
    i.a(paramContext.getApplicationContext()).a(localIntent);
  }
  
  public static String B(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      String str = c.g(paramContext);
      Object localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (E(paramContext)) {
          localObject = q.a(paramContext, paramContext.getPackageName() + ".push_sync", "r_v2");
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label125;
      }
      paramContext = com.baidu.android.pushservice.b.b.e(com.baidu.android.pushservice.b.b.a((String)localObject));
      if (paramContext == null) {
        break label125;
      }
      paramContext = paramContext.iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        localObject = (com.baidu.android.pushservice.b.f)paramContext.next();
      } while (!((com.baidu.android.pushservice.b.f)localObject).c().equals(paramString));
      paramContext = ((com.baidu.android.pushservice.b.f)localObject).a();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
        continue;
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static void B(Context paramContext)
  {
    com.baidu.android.pushservice.message.a.d.a(paramContext);
    Intent localIntent = new Intent("com.baidu.android.pushservice.action.METHOD");
    localIntent.putExtra("method", "com.baidu.android.pushservice.action.SEND_LBS");
    i.a(paramContext.getApplicationContext()).a(localIntent);
  }
  
  public static int C(Context paramContext, String paramString)
  {
    try
    {
      String str = c.f(paramContext);
      Object localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (E(paramContext)) {
          localObject = q.a(paramContext, paramContext.getPackageName() + ".push_sync", "r_v2");
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramContext = com.baidu.android.pushservice.b.b.e(com.baidu.android.pushservice.b.b.a((String)localObject));
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            localObject = (com.baidu.android.pushservice.b.f)paramContext.next();
            if (TextUtils.equals(((com.baidu.android.pushservice.b.f)localObject).c(), paramString))
            {
              int i = ((com.baidu.android.pushservice.b.f)localObject).e();
              return i;
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      return 0;
    }
    return 0;
  }
  
  public static String C(Context paramContext)
  {
    paramContext = "";
    String str = Build.MANUFACTURER.toUpperCase();
    if (str.contains("XIAOMI")) {
      paramContext = "ro.build.version.incremental";
    }
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.os.SystemProperties");
        paramContext = (String)localClass.getDeclaredMethod("get", new Class[] { String.class }).invoke(localClass, new Object[] { paramContext });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        if ((Build.VERSION.SDK_INT < 21) || (!str.contains("HUAWEI"))) {
          continue;
        }
        return "EmotionUI_notfound";
        if (!str.contains("XIAOMI")) {
          continue;
        }
        return "MIUI_notfound";
        if (!str.contains("OPPO")) {
          break label149;
        }
        return "ColorOS_notfound";
      }
      if (str.contains("HUAWEI"))
      {
        paramContext = "ro.build.version.emui";
      }
      else
      {
        if (str.contains("MEIZU")) {
          return Build.DISPLAY;
        }
        if (str.contains("OPPO")) {
          paramContext = "ro.build.version.opporom";
        }
      }
    }
    label149:
    return "";
  }
  
  /* Error */
  public static String D(Context paramContext)
  {
    // Byte code:
    //   0: ldc -75
    //   2: astore_0
    //   3: invokestatic 244	com/baidu/android/pushservice/j/p:e	()Z
    //   6: ifeq +392 -> 398
    //   9: ldc -75
    //   11: astore_0
    //   12: getstatic 187	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   15: invokevirtual 190	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   18: astore 4
    //   20: aload 4
    //   22: ldc -64
    //   24: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +115 -> 142
    //   30: ldc -10
    //   32: astore_0
    //   33: ldc -57
    //   35: invokestatic 205	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore_1
    //   39: aload_1
    //   40: ldc -49
    //   42: iconst_1
    //   43: anewarray 201	java/lang/Class
    //   46: dup
    //   47: iconst_0
    //   48: ldc 17
    //   50: aastore
    //   51: invokevirtual 211	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   54: aload_1
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: aastore
    //   63: invokevirtual 217	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast 17	java/lang/String
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: aload 4
    //   74: ldc -37
    //   76: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   79: ifeq +112 -> 191
    //   82: aload_3
    //   83: astore_2
    //   84: aload_3
    //   85: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +103 -> 191
    //   91: aload_3
    //   92: astore_2
    //   93: aload_3
    //   94: aload_3
    //   95: ldc -8
    //   97: invokevirtual 252	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   100: iconst_1
    //   101: iadd
    //   102: aload_3
    //   103: invokevirtual 255	java/lang/String:length	()I
    //   106: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: aload_1
    //   113: astore_0
    //   114: aload_1
    //   115: ldc_w 261
    //   118: invokevirtual 265	java/lang/String:matches	(Ljava/lang/String;)Z
    //   121: ifne +277 -> 398
    //   124: aload_3
    //   125: astore_2
    //   126: aload_1
    //   127: astore_0
    //   128: getstatic 235	android/os/Build$VERSION:SDK_INT	I
    //   131: bipush 21
    //   133: if_icmplt +265 -> 398
    //   136: ldc_w 267
    //   139: astore_0
    //   140: aload_0
    //   141: areturn
    //   142: aload 4
    //   144: ldc -37
    //   146: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   149: ifeq +9 -> 158
    //   152: ldc -35
    //   154: astore_0
    //   155: goto -122 -> 33
    //   158: aload 4
    //   160: ldc -33
    //   162: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +10 -> 175
    //   168: ldc_w 269
    //   171: astore_0
    //   172: goto -139 -> 33
    //   175: aload 4
    //   177: ldc -28
    //   179: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   182: ifeq -149 -> 33
    //   185: ldc -26
    //   187: astore_0
    //   188: goto -155 -> 33
    //   191: aload_3
    //   192: astore_2
    //   193: aload 4
    //   195: ldc -33
    //   197: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   200: ifeq +51 -> 251
    //   203: aload_3
    //   204: astore_1
    //   205: aload_3
    //   206: astore_2
    //   207: aload_3
    //   208: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifeq +9 -> 220
    //   214: aload_3
    //   215: astore_2
    //   216: getstatic 226	android/os/Build:DISPLAY	Ljava/lang/String;
    //   219: astore_1
    //   220: aload_1
    //   221: astore_2
    //   222: ldc_w 271
    //   225: invokestatic 277	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   228: aload_1
    //   229: invokevirtual 281	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   232: astore_3
    //   233: aload_1
    //   234: astore_0
    //   235: aload_1
    //   236: astore_2
    //   237: aload_3
    //   238: invokevirtual 286	java/util/regex/Matcher:find	()Z
    //   241: ifeq -101 -> 140
    //   244: aload_1
    //   245: astore_2
    //   246: aload_3
    //   247: invokevirtual 289	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   250: areturn
    //   251: aload_3
    //   252: astore_0
    //   253: aload_3
    //   254: astore_2
    //   255: aload 4
    //   257: ldc -28
    //   259: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   262: ifeq -122 -> 140
    //   265: aload_3
    //   266: astore_0
    //   267: aload_3
    //   268: astore_2
    //   269: aload_3
    //   270: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   273: ifne -133 -> 140
    //   276: aload_3
    //   277: astore_2
    //   278: ldc_w 291
    //   281: invokestatic 277	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   284: aload_3
    //   285: invokevirtual 281	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   288: astore_1
    //   289: aload_3
    //   290: astore_0
    //   291: aload_3
    //   292: astore_2
    //   293: aload_1
    //   294: invokevirtual 286	java/util/regex/Matcher:find	()Z
    //   297: ifeq -157 -> 140
    //   300: aload_3
    //   301: astore_2
    //   302: aload_1
    //   303: iconst_1
    //   304: invokevirtual 294	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   307: astore_0
    //   308: aload_0
    //   309: areturn
    //   310: astore_0
    //   311: ldc -75
    //   313: astore_0
    //   314: getstatic 235	android/os/Build$VERSION:SDK_INT	I
    //   317: bipush 21
    //   319: if_icmplt +17 -> 336
    //   322: aload 4
    //   324: ldc -37
    //   326: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   329: ifeq +7 -> 336
    //   332: ldc_w 267
    //   335: areturn
    //   336: aload 4
    //   338: ldc -37
    //   340: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   343: ifeq +7 -> 350
    //   346: ldc_w 296
    //   349: areturn
    //   350: aload 4
    //   352: ldc -64
    //   354: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   357: ifeq +7 -> 364
    //   360: ldc_w 298
    //   363: areturn
    //   364: aload 4
    //   366: ldc -33
    //   368: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   371: ifeq +7 -> 378
    //   374: ldc_w 300
    //   377: areturn
    //   378: aload 4
    //   380: ldc -28
    //   382: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   385: ifeq -245 -> 140
    //   388: ldc_w 302
    //   391: areturn
    //   392: astore_0
    //   393: aload_2
    //   394: astore_0
    //   395: goto -81 -> 314
    //   398: aload_0
    //   399: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	paramContext	Context
    //   38	265	1	localObject1	Object
    //   71	323	2	localObject2	Object
    //   69	232	3	localObject3	Object
    //   18	361	4	str	String
    // Exception table:
    //   from	to	target	type
    //   33	70	310	java/lang/Exception
    //   72	82	392	java/lang/Exception
    //   84	91	392	java/lang/Exception
    //   93	110	392	java/lang/Exception
    //   114	124	392	java/lang/Exception
    //   128	136	392	java/lang/Exception
    //   193	203	392	java/lang/Exception
    //   207	214	392	java/lang/Exception
    //   216	220	392	java/lang/Exception
    //   222	233	392	java/lang/Exception
    //   237	244	392	java/lang/Exception
    //   246	251	392	java/lang/Exception
    //   255	265	392	java/lang/Exception
    //   269	276	392	java/lang/Exception
    //   278	289	392	java/lang/Exception
    //   293	300	392	java/lang/Exception
    //   302	308	392	java/lang/Exception
  }
  
  /* Error */
  public static boolean D(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: invokestatic 305	com/baidu/android/pushservice/j/p:c	()Z
    //   12: ifne +17 -> 29
    //   15: invokestatic 307	com/baidu/android/pushservice/j/p:a	()Z
    //   18: ifne +11 -> 29
    //   21: invokestatic 309	com/baidu/android/pushservice/j/p:b	()Z
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload 7
    //   31: astore 5
    //   33: aload_0
    //   34: invokevirtual 313	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   37: astore 8
    //   39: aload 8
    //   41: ifnull +288 -> 329
    //   44: aload 7
    //   46: astore 5
    //   48: aload 8
    //   50: new 106	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 315
    //   60: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 317
    //   70: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 319
    //   76: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 321
    //   82: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 327	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   91: aconst_null
    //   92: aconst_null
    //   93: aconst_null
    //   94: aconst_null
    //   95: invokevirtual 333	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +92 -> 192
    //   103: aload_0
    //   104: astore 6
    //   106: aload_0
    //   107: astore 5
    //   109: aload_0
    //   110: invokeinterface 338 1 0
    //   115: ifeq +214 -> 329
    //   118: aload_0
    //   119: astore 5
    //   121: aload_0
    //   122: aload_0
    //   123: getstatic 343	com/baidu/android/pushservice/d/c$e:c	Lcom/baidu/android/pushservice/d/c$e;
    //   126: invokevirtual 346	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   129: invokeinterface 349 2 0
    //   134: invokeinterface 353 2 0
    //   139: istore_2
    //   140: aload_0
    //   141: astore 5
    //   143: aload_0
    //   144: aload_0
    //   145: getstatic 355	com/baidu/android/pushservice/d/c$e:b	Lcom/baidu/android/pushservice/d/c$e;
    //   148: invokevirtual 346	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   151: invokeinterface 349 2 0
    //   156: invokeinterface 353 2 0
    //   161: istore_3
    //   162: iload_2
    //   163: ifle +23 -> 186
    //   166: iload_3
    //   167: ifne +19 -> 186
    //   170: iconst_1
    //   171: istore 4
    //   173: aload_0
    //   174: ifnull +9 -> 183
    //   177: aload_0
    //   178: invokeinterface 358 1 0
    //   183: iload 4
    //   185: ireturn
    //   186: iconst_0
    //   187: istore 4
    //   189: goto -16 -> 173
    //   192: aload_0
    //   193: astore 5
    //   195: aload 8
    //   197: new 106	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 315
    //   207: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 317
    //   217: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 319
    //   223: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 360
    //   229: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 327	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   238: aconst_null
    //   239: aconst_null
    //   240: aconst_null
    //   241: aconst_null
    //   242: invokevirtual 333	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   245: astore_1
    //   246: aload_1
    //   247: astore_0
    //   248: aload_0
    //   249: ifnull +77 -> 326
    //   252: aload_0
    //   253: invokeinterface 338 1 0
    //   258: ifeq +68 -> 326
    //   261: aload_0
    //   262: aload_0
    //   263: getstatic 343	com/baidu/android/pushservice/d/c$e:c	Lcom/baidu/android/pushservice/d/c$e;
    //   266: invokevirtual 346	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   269: invokeinterface 349 2 0
    //   274: invokeinterface 353 2 0
    //   279: istore_2
    //   280: aload_0
    //   281: aload_0
    //   282: getstatic 355	com/baidu/android/pushservice/d/c$e:b	Lcom/baidu/android/pushservice/d/c$e;
    //   285: invokevirtual 346	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   288: invokeinterface 349 2 0
    //   293: invokeinterface 353 2 0
    //   298: istore_3
    //   299: iload_2
    //   300: ifle +20 -> 320
    //   303: iload_3
    //   304: ifne +16 -> 320
    //   307: aload_0
    //   308: ifnull +9 -> 317
    //   311: aload_0
    //   312: invokeinterface 358 1 0
    //   317: iload 4
    //   319: ireturn
    //   320: iconst_0
    //   321: istore 4
    //   323: goto -16 -> 307
    //   326: aload_0
    //   327: astore 6
    //   329: aload 6
    //   331: ifnull -304 -> 27
    //   334: aload 6
    //   336: invokeinterface 358 1 0
    //   341: iconst_0
    //   342: ireturn
    //   343: astore_0
    //   344: iconst_0
    //   345: ireturn
    //   346: astore_0
    //   347: aconst_null
    //   348: astore_0
    //   349: aload_0
    //   350: ifnull -323 -> 27
    //   353: aload_0
    //   354: invokeinterface 358 1 0
    //   359: iconst_0
    //   360: ireturn
    //   361: astore_0
    //   362: iconst_0
    //   363: ireturn
    //   364: astore_0
    //   365: aload 5
    //   367: astore_1
    //   368: aload_1
    //   369: ifnull +9 -> 378
    //   372: aload_1
    //   373: invokeinterface 358 1 0
    //   378: aload_0
    //   379: athrow
    //   380: astore_0
    //   381: goto -198 -> 183
    //   384: astore_0
    //   385: goto -68 -> 317
    //   388: astore_1
    //   389: goto -11 -> 378
    //   392: astore 5
    //   394: aload_0
    //   395: astore_1
    //   396: aload 5
    //   398: astore_0
    //   399: goto -31 -> 368
    //   402: astore_1
    //   403: goto -54 -> 349
    //   406: astore_1
    //   407: goto -58 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramContext	Context
    //   0	410	1	paramString	String
    //   139	161	2	i	int
    //   161	143	3	j	int
    //   1	321	4	bool	boolean
    //   31	335	5	localObject1	Object
    //   392	5	5	localObject2	Object
    //   7	328	6	localContext	Context
    //   4	41	7	localObject3	Object
    //   37	159	8	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   334	341	343	java/lang/Exception
    //   33	39	346	java/lang/Exception
    //   48	99	346	java/lang/Exception
    //   353	359	361	java/lang/Exception
    //   33	39	364	finally
    //   48	99	364	finally
    //   109	118	364	finally
    //   121	140	364	finally
    //   143	162	364	finally
    //   195	246	364	finally
    //   177	183	380	java/lang/Exception
    //   311	317	384	java/lang/Exception
    //   372	378	388	java/lang/Exception
    //   252	299	392	finally
    //   109	118	402	java/lang/Exception
    //   121	140	402	java/lang/Exception
    //   143	162	402	java/lang/Exception
    //   195	246	402	java/lang/Exception
    //   252	299	406	java/lang/Exception
  }
  
  private static int E(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext.getPackageName(), paramString));
  }
  
  public static boolean E(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if (paramContext == null) {
          break label49;
        }
        i = paramContext.applicationInfo.targetSdkVersion;
        if (i >= 24)
        {
          i = Build.VERSION.SDK_INT;
          if (i >= 24) {
            return false;
          }
        }
      }
      catch (Exception paramContext) {}
      return true;
      label49:
      int i = 0;
    }
  }
  
  public static boolean F(Context paramContext)
  {
    return !E(paramContext);
  }
  
  public static boolean G(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        bool1 = bool2;
        if (paramContext != null)
        {
          int i = paramContext.applicationInfo.targetSdkVersion;
          bool1 = bool2;
          if (i >= 26) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean H(Context paramContext)
  {
    return (com.baidu.android.pushservice.c.d.a(paramContext).b() == 3) && (Build.MANUFACTURER.equalsIgnoreCase("koobee"));
  }
  
  private static boolean I(Context paramContext)
  {
    Object localObject = new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      localObject = localPackageManager.queryBroadcastReceivers((Intent)localObject, 576);
      if (((List)localObject).size() < 1) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        boolean bool = "com.meizu.cloud.pushsdk.SystemReceiver".equals(((ResolveInfo)((Iterator)localObject).next()).activityInfo.name);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      com.baidu.android.pushservice.g.a.b("Utility", "error  " + localException.getMessage(), paramContext);
    }
    return false;
  }
  
  private static String J(Context paramContext)
  {
    if (!a(paramContext, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true))
    {
      Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW");
      return "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW";
    }
    if (!a(paramContext, "android.net.conn.CONNECTIVITY_CHANGE", "com.baidu.android.pushservice.PushServiceReceiver", true))
    {
      Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared android.net.conn.CONNECTIVITY_CHANGE");
      return "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared android.net.conn.CONNECTIVITY_CHANGE";
    }
    if (!a(paramContext, "com.baidu.android.pushservice.action.METHOD", "com.baidu.android.pushservice.RegistrationReceiver", true))
    {
      Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD");
      return "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD";
    }
    return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
  }
  
  private static String K(Context paramContext)
  {
    if (L(paramContext))
    {
      Log.e("BDPushSDK-Utility", "xiaomi service is not found or wrong  declared, please check!");
      return "xiaomi service is not found or wrong  declared, please check!";
    }
    if (M(paramContext))
    {
      Log.e("BDPushSDK-Utility", "meizu service is not found or wrong  declared, please check!");
      return "meizu service is not found or wrong  declared, please check!";
    }
    if (N(paramContext))
    {
      Log.e("BDPushSDK-Utility", "oppo service is not found or wrong  declared, please check!");
      return "oppo service is not found or wrong  declared, please check!";
    }
    if (a(paramContext, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false)) {
      return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
    }
    return "com.baidu.android.pushservice.PushService is not exist or did not declared com.baidu.android.pushservice.action.PUSH_SERVICE";
  }
  
  private static boolean L(Context paramContext)
  {
    bool = true;
    try
    {
      if ((a()) && (PushSettings.m(paramContext))) {}
      for (int i = 1; i != 0; i = 0)
      {
        Object localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4);
        if (((PackageInfo)localObject1).services == null) {
          break;
        }
        localObject1 = ((PackageInfo)localObject1).services;
        int n = localObject1.length;
        i = 0;
        int j = 0;
        int k;
        for (int m = 0;; m = k)
        {
          Object localObject2;
          if (i < n)
          {
            localObject2 = localObject1[i];
            k = m;
            if (((ServiceInfo)localObject2).name.equals("com.xiaomi.mipush.sdk.PushMessageHandler"))
            {
              k = E(paramContext, "com.xiaomi.mipush.sdk.PushMessageHandler");
              if (!((ServiceInfo)localObject2).exported) {
                break label176;
              }
              if (k == 1) {
                break label257;
              }
              if ((k != 0) || (!((ServiceInfo)localObject2).enabled)) {
                break label176;
              }
              break label257;
            }
          }
          for (;;)
          {
            m = j;
            if (!((ServiceInfo)localObject2).name.equals("com.xiaomi.mipush.sdk.MessageHandleService")) {
              break label265;
            }
            m = E(paramContext, "com.xiaomi.mipush.sdk.MessageHandleService");
            if (m == 1) {
              break;
            }
            if ((m == 0) && (((ServiceInfo)localObject2).enabled))
            {
              break;
              label176:
              Log.e("BDPushSDK-Utility", "com.xiaomi.mipush.sdk.PushMessageHandler" + " is disable, please check!");
              k = m;
            }
            else
            {
              Log.e("BDPushSDK-Utility", "com.xiaomi.mipush.sdk.MessageHandleService" + " is disable, please check!");
              m = j;
              break label265;
              if (j == 0) {
                break label287;
              }
              if (m != 0) {
                break label284;
              }
              return true;
              label257:
              k = 1;
            }
          }
          m = 1;
          label265:
          i += 1;
          j = m;
        }
      }
      label284:
      return bool;
    }
    catch (Exception paramContext)
    {
      bool = false;
    }
  }
  
  private static boolean M(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if ((!b()) || (!PushSettings.n(paramContext))) {
          break label167;
        }
        i = 1;
        if (i != 0)
        {
          Object localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4);
          if (((PackageInfo)localObject1).services != null)
          {
            localObject1 = ((PackageInfo)localObject1).services;
            int m = localObject1.length;
            i = 0;
            j = 0;
            if (i >= m) {
              break label150;
            }
            Object localObject2 = localObject1[i];
            k = j;
            if (!((ServiceInfo)localObject2).name.equals("com.meizu.cloud.pushsdk.NotificationService")) {
              break label158;
            }
            k = E(paramContext, "com.meizu.cloud.pushsdk.NotificationService");
            if ((k == 1) || ((k == 0) && (((ServiceInfo)localObject2).enabled))) {
              break label156;
            }
            Log.e("BDPushSDK-Utility", "com.meizu.cloud.pushsdk.NotificationService" + " is disable, please check!");
            k = j;
          }
        }
      }
      catch (Exception paramContext) {}
      label150:
      do
      {
        return false;
      } while (j != 0);
      return true;
      label156:
      int k = 1;
      label158:
      i += 1;
      int j = k;
      continue;
      label167:
      int i = 0;
    }
  }
  
  private static boolean N(Context paramContext)
  {
    try
    {
      int i;
      Object localObject1;
      int j;
      if ((d()) && (PushSettings.o(paramContext)))
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4);
          if (((PackageInfo)localObject1).services != null)
          {
            localObject1 = ((PackageInfo)localObject1).services;
            j = localObject1.length;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i >= j) {
            break label142;
          }
          Object localObject2 = localObject1[i];
          if (((ServiceInfo)localObject2).name.equals("com.coloros.mcssdk.PushService"))
          {
            i = E(paramContext, "com.coloros.mcssdk.PushService");
            if ((i == 1) || ((i == 0) && (((ServiceInfo)localObject2).enabled))) {
              break label142;
            }
            Log.e("BDPushSDK-Utility", "com.coloros.mcssdk.PushService" + " is disable, please check!");
            return true;
            i = 0;
            break;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
  }
  
  private static boolean O(Context paramContext)
  {
    try
    {
      Object localObject1 = paramContext.getPackageManager();
      Object localObject2 = new ComponentName(paramContext, "com.baidu.android.pushservice.PushInfoProvider");
      new ProviderInfo();
      localObject1 = ((PackageManager)localObject1).getProviderInfo((ComponentName)localObject2, 128);
      localObject2 = ((ProviderInfo)localObject1).name;
      String str = ((ProviderInfo)localObject1).authority;
      com.baidu.android.pushservice.g.a.c("Utility", "provider name  = " + (String)localObject2 + "  export  = " + ((ProviderInfo)localObject1).exported + " provider authorities = " + str, paramContext.getApplicationContext());
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider did not declared, please check ! ");
        return false;
      }
      if ((TextUtils.isEmpty(str)) || (!str.endsWith("bdpush")))
      {
        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider bdpush authority is required, please check !");
        return false;
      }
      if (!((ProviderInfo)localObject1).exported) {
        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider exported declared wrong, please check ! ");
      }
      if (TextUtils.isEmpty(((ProviderInfo)localObject1).writePermission)) {
        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider writePermission did not decleared, please check !");
      }
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private static boolean P(Context paramContext)
  {
    if (b == -1) {
      if (!u(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
        break label31;
      }
    }
    label31:
    for (int i = 0;; i = 1)
    {
      b = i;
      if (b != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static boolean Q(Context paramContext)
  {
    try
    {
      paramContext = Build.DISPLAY;
      if ((!TextUtils.isEmpty(paramContext)) && (paramContext.contains("VIBEUI_V3.1_1614_5.294.1_ST_K50-T5"))) {
        return true;
      }
      paramContext = Build.MODEL;
      if (!TextUtils.isEmpty(paramContext))
      {
        if ((paramContext.contains("Lenovo K50-t5")) || (paramContext.contains("Lenovo_K50-t5")) || (paramContext.contains("Lenovo X3c50"))) {
          break label82;
        }
        boolean bool = paramContext.contains("Lenovo_X3c50");
        if (bool) {
          break label82;
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return false;
    label82:
    return true;
  }
  
  public static int a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    paramIntent.setFlags(32);
    if (m(paramContext, paramString2) >= 50)
    {
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.setAction(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramIntent.setPackage(paramString2);
        paramIntent.setClassName(paramString2, "com.baidu.android.pushservice.CommandService");
      }
      paramIntent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_DELIVER");
      paramIntent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");
      return new e(paramContext, paramIntent).b().a();
    }
    b(paramContext, paramIntent, paramString1, paramString2);
    return 0;
  }
  
  public static Intent a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (com.baidu.android.pushservice.a.a() < 32) {}
    do
    {
      return paramIntent;
      paramIntent.setFlags(32);
      paramIntent.setAction(paramString);
      paramContext = paramContext.getPackageName();
    } while (TextUtils.isEmpty(paramContext));
    paramIntent.setClassName(paramContext, "com.baidu.android.pushservice.PushService");
    return paramIntent;
  }
  
  public static PackageInfo a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getPackageInfo(paramString, 64);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static j a(j paramj, Context paramContext, String paramString)
  {
    PackageInfo localPackageInfo = a(paramContext, paramString);
    if (localPackageInfo != null)
    {
      paramj.c(localPackageInfo.applicationInfo.loadLabel(paramContext.getPackageManager()).toString());
      paramj.e(localPackageInfo.versionName);
      paramj.a(localPackageInfo.versionCode);
      paramj.d(n(paramContext, paramString));
      paramj.b(m(paramContext, paramString));
    }
    return paramj;
  }
  
  public static String a(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l4 = System.currentTimeMillis() - paramLong;
    long l1 = Math.ceil(l4 * 1.0D / 1000.0D);
    long l2 = Math.ceil((float)(l4 / 60L) / 1000.0F);
    long l3 = Math.ceil((float)(l4 / 60L / 60L) / 1000.0F);
    l4 = Math.ceil((float)(l4 / 24L / 60L / 60L) / 1000.0F);
    if (l4 - 1L > 3L) {
      localStringBuffer.append(new SimpleDateFormat("MM月dd日").format(new Date(paramLong)));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (l4 - 1L > 0L) {
        localStringBuffer.append(l4 + "天前");
      } else if (l3 - 1L > 0L)
      {
        if (l3 >= 24L) {
          localStringBuffer.append("1天前");
        } else {
          localStringBuffer.append(l3 + "小时前");
        }
      }
      else if (l2 - 1L > 0L)
      {
        if (l2 == 60L) {
          localStringBuffer.append("1小时前");
        } else {
          localStringBuffer.append(l2 + "分钟前");
        }
      }
      else if (l1 - 1L > 0L)
      {
        if (l1 == 60L) {
          localStringBuffer.append("1分钟前");
        } else {
          localStringBuffer.append(l1 + "秒前");
        }
      }
      else {
        localStringBuffer.append("刚刚");
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          paramContext = paramContext.getPackageManager();
          if (paramContext != null) {
            paramContext = paramContext.getApplicationInfo(paramString1, 128);
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext = null;
          }
        }
      }
    } while ((paramContext == null) || (paramContext.metaData == null));
    return paramContext.metaData.getString(paramString2);
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString))) {
      return "0";
    }
    paramString = new BigInteger(paramString);
    try
    {
      if (!paramString.and(new BigInteger("0800000000000000", 16)).equals(BigInteger.ZERO))
      {
        System.out.println("encode =  1");
        paramString = paramString.xor(new BigInteger("22727017042830095"));
      }
      for (paramString = paramString.and(new BigInteger("000000ff00000000", 16)).shiftLeft(16).add(paramString.and(new BigInteger("000000000000ffff", 16)).shiftLeft(32)).add(paramString.and(new BigInteger("00ffff0000000000", 16)).shiftRight(24).and(new BigInteger("00000000ffff0000", 16))).add(paramString.and(new BigInteger("00000000ffff0000", 16)).shiftRight(16)).add(paramString.and(new BigInteger("ff00000000000000", 16)));; paramString = paramString.and(new BigInteger("00ff0000", 16)).shiftLeft(8).add(paramString.and(new BigInteger("000000ff", 16)).shiftLeft(16)).add(paramString.and(new BigInteger("ff000000", 16)).shiftRight(16).and(new BigInteger("0000ff00", 16))).add(paramString.and(new BigInteger("0000ff00", 16)).shiftRight(8)))
      {
        return paramString.toString();
        paramString = paramString.xor(new BigInteger("282335"));
      }
      return "0";
    }
    catch (Exception paramString) {}
  }
  
  public static String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    return localStringWriter.toString();
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getApplicationContext();
    Intent localIntent = o.c(paramContext);
    String str1 = paramContext.getPackageName();
    String str2 = c(paramContext, str1, localIntent.getAction());
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      localIntent.setClassName(str1, str2);
    }
    a(paramContext, localIntent, paramLong);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getData();
      if (localObject != null)
      {
        localObject = f(((Uri)localObject).toString());
        Intent localIntent = new Intent();
        String str1 = paramIntent.getStringExtra("bdpush_hwmsgid");
        String str2 = paramIntent.getStringExtra("hwtitle");
        paramIntent = paramIntent.getStringExtra("hwcontent");
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramIntent)))
        {
          localIntent.putExtra("notification_title", str2);
          localIntent.putExtra("notification_content", paramIntent);
        }
        if (!TextUtils.isEmpty(str1)) {
          localIntent.putExtra("msgid", str1);
        }
        localIntent.putExtra("extra_extra_custom_content", (String)localObject);
        a(paramContext, str1, "", str2, paramIntent, (String)localObject);
        b(paramContext, localIntent, "com.baidu.android.pushservice.action.notification.CLICK", paramContext.getPackageName());
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    paramIntent = PendingIntent.getBroadcast(paramContext, 0, paramIntent, 268435456);
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    paramContext.cancel(paramIntent);
    paramContext.set(3, SystemClock.elapsedRealtime() + paramLong, paramIntent);
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, com.baidu.android.pushservice.message.k paramk, byte[] paramArrayOfByte)
  {
    int i = 0;
    com.baidu.android.pushservice.h.a locala = new com.baidu.android.pushservice.h.a();
    locala.a = paramk.h();
    locala.b = paramk.b();
    locala.c = paramk.c();
    locala.d = paramk.d();
    locala.e = 1;
    locala.f = 1;
    com.baidu.android.pushservice.d.a.a(paramContext, locala);
    try
    {
      int j = Long.valueOf(System.currentTimeMillis()).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      Intent localIntent;
      for (;;) {}
    }
    localIntent = a(paramContext, new Intent(), "com.baidu.android.pushservice.action.alarm.message");
    localIntent.putExtra("tinyMessageHead", paramk);
    localIntent.putExtra("msgBody", paramArrayOfByte);
    paramk = PendingIntent.getService(paramContext, i, localIntent, 134217728);
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    try
    {
      if (Build.VERSION.SDK_INT < 19)
      {
        paramContext.set(0, locala.c, paramk);
        return;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramContext.setExact(0, locala.c, paramk);
        return;
      }
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("r_sync_type", paramInt);
    localIntent.putExtra("r_sync_rdata_v2", paramString);
    localIntent.putExtra("r_sync_from", paramContext.getPackageName());
    localIntent.setFlags(32);
    if (F(paramContext))
    {
      paramString = o(paramContext);
      if (paramString != null) {
        break label70;
      }
    }
    for (;;)
    {
      return;
      paramString = n(paramContext);
      break;
      label70:
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramString.next();
        if (i(paramContext, localResolveInfo.activityInfo.packageName)) {
          b(paramContext, localIntent, "com.baidu.android.pushservice.action.BIND_SYNC", localResolveInfo.activityInfo.packageName);
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, PushCallback paramPushCallback)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationContext();
      n.a(paramContext, 8, "");
      com.coloros.mcssdk.PushManager.getInstance().register(paramContext, paramString1, paramString2, paramPushCallback);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.baidu.android.pushservice.g.a.a("Utility", paramContext.getPackageName() + ": updateServiceInfo isForce = " + paramBoolean1 + ",isSend = " + paramBoolean2, paramContext.getApplicationContext());
    Object localObject = paramContext.getSharedPreferences("pst", 0);
    int i = d(paramContext, paramContext.getPackageName());
    SharedPreferences.Editor localEditor;
    if ((((SharedPreferences)localObject).getInt("pr_app_v", 0) < i) || (paramBoolean1))
    {
      if ((!c(paramContext)) && (!com.baidu.android.pushservice.c.d.g(paramContext))) {
        break label239;
      }
      c.a(paramContext, 0L);
      if (E(paramContext))
      {
        localEditor = paramContext.getSharedPreferences(paramContext.getPackageName() + ".push_sync", 5).edit();
        if ((!c(paramContext)) && (!com.baidu.android.pushservice.c.d.g(paramContext))) {
          break label250;
        }
        localEditor.putLong("priority2", 0L);
      }
    }
    for (;;)
    {
      localEditor.putInt("version2", com.baidu.android.pushservice.a.a());
      localEditor.commit();
      c.b(paramContext, com.baidu.android.pushservice.a.a());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("pr_app_v", i);
      ((SharedPreferences.Editor)localObject).commit();
      if (paramBoolean2) {
        o.d(paramContext);
      }
      return;
      label239:
      c.a(paramContext, f(paramContext));
      break;
      label250:
      localEditor.putLong("priority2", f(paramContext));
    }
  }
  
  public static void a(Intent paramIntent, Context paramContext)
  {
    try
    {
      String str1 = paramContext.getPackageName();
      String str2 = c(paramContext, paramContext.getPackageName(), "com.baidu.android.pushservice.action.MESSAGE");
      Object localObject2 = Class.forName(str2);
      Object localObject1 = ((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]);
      localObject2 = ((Class)localObject2).getMethod("onReceive", new Class[] { Context.class, Intent.class });
      paramIntent.setClassName(str1, str2);
      ((Method)localObject2).invoke(localObject1, new Object[] { paramContext, paramIntent });
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 5
    //   6: new 683	java/text/SimpleDateFormat
    //   9: dup
    //   10: ldc_w 1074
    //   13: invokestatic 1080	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   16: invokespecial 1083	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   19: new 688	java/util/Date
    //   22: dup
    //   23: invokespecial 1084	java/util/Date:<init>	()V
    //   26: invokevirtual 695	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   29: astore 6
    //   31: aload 6
    //   33: invokevirtual 255	java/lang/String:length	()I
    //   36: ifle +335 -> 371
    //   39: aload 6
    //   41: iconst_0
    //   42: iconst_4
    //   43: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
    //   46: aload 6
    //   48: iconst_5
    //   49: bipush 7
    //   51: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
    //   54: invokevirtual 1087	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   57: aload 6
    //   59: bipush 8
    //   61: bipush 10
    //   63: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
    //   66: invokevirtual 1087	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 4
    //   71: new 106	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   78: aload 6
    //   80: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 1089
    //   86: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 1091
    //   96: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: astore_1
    //   103: invokestatic 1097	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   106: invokevirtual 1102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: astore 6
    //   111: new 1099	java/io/File
    //   114: dup
    //   115: aload 6
    //   117: ldc_w 1104
    //   120: invokespecial 1105	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: astore 8
    //   125: aload 8
    //   127: invokevirtual 1108	java/io/File:exists	()Z
    //   130: ifne +91 -> 221
    //   133: aload 8
    //   135: invokevirtual 1111	java/io/File:mkdirs	()Z
    //   138: pop
    //   139: new 1099	java/io/File
    //   142: dup
    //   143: aload 6
    //   145: new 106	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 1113
    //   155: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 4
    //   164: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 1115
    //   170: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 1105	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 1108	java/io/File:exists	()Z
    //   184: ifeq +182 -> 366
    //   187: new 1117	java/io/FileOutputStream
    //   190: dup
    //   191: aload_0
    //   192: iconst_1
    //   193: invokespecial 1120	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   196: astore_0
    //   197: aload_0
    //   198: aload_1
    //   199: invokevirtual 1124	java/lang/String:getBytes	()[B
    //   202: invokevirtual 1128	java/io/FileOutputStream:write	([B)V
    //   205: aload_0
    //   206: invokevirtual 1129	java/io/FileOutputStream:close	()V
    //   209: aload_0
    //   210: ifnull +7 -> 217
    //   213: aload_0
    //   214: invokevirtual 1129	java/io/FileOutputStream:close	()V
    //   217: ldc 2
    //   219: monitorexit
    //   220: return
    //   221: new 683	java/text/SimpleDateFormat
    //   224: dup
    //   225: ldc_w 1131
    //   228: invokestatic 1080	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   231: invokespecial 1083	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   234: astore 7
    //   236: aload 8
    //   238: invokevirtual 1135	java/io/File:listFiles	()[Ljava/io/File;
    //   241: astore 8
    //   243: aload 8
    //   245: arraylength
    //   246: istore_3
    //   247: iconst_0
    //   248: istore_2
    //   249: iload_2
    //   250: iload_3
    //   251: if_icmpge -112 -> 139
    //   254: aload 8
    //   256: iload_2
    //   257: aaload
    //   258: astore 9
    //   260: aload 9
    //   262: invokevirtual 1138	java/io/File:getName	()Ljava/lang/String;
    //   265: aload_0
    //   266: invokevirtual 1141	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   269: ifeq +36 -> 305
    //   272: aload 4
    //   274: invokestatic 1146	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   277: aload 7
    //   279: aload 9
    //   281: invokevirtual 1149	java/io/File:lastModified	()J
    //   284: invokestatic 931	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   287: invokevirtual 1152	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   290: invokestatic 1146	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   293: isub
    //   294: bipush 7
    //   296: if_icmplt +9 -> 305
    //   299: aload 9
    //   301: invokevirtual 1155	java/io/File:delete	()Z
    //   304: pop
    //   305: iload_2
    //   306: iconst_1
    //   307: iadd
    //   308: istore_2
    //   309: goto -60 -> 249
    //   312: astore_0
    //   313: aload 5
    //   315: astore_0
    //   316: aload_0
    //   317: ifnull -100 -> 217
    //   320: aload_0
    //   321: invokevirtual 1129	java/io/FileOutputStream:close	()V
    //   324: goto -107 -> 217
    //   327: astore_0
    //   328: goto -111 -> 217
    //   331: astore_1
    //   332: aconst_null
    //   333: astore_0
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 1129	java/io/FileOutputStream:close	()V
    //   342: aload_1
    //   343: athrow
    //   344: astore_0
    //   345: ldc 2
    //   347: monitorexit
    //   348: aload_0
    //   349: athrow
    //   350: astore_0
    //   351: goto -134 -> 217
    //   354: astore_0
    //   355: goto -13 -> 342
    //   358: astore_1
    //   359: goto -25 -> 334
    //   362: astore_1
    //   363: goto -47 -> 316
    //   366: aconst_null
    //   367: astore_0
    //   368: goto -159 -> 209
    //   371: aconst_null
    //   372: astore 4
    //   374: goto -303 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString1	String
    //   0	377	1	paramString2	String
    //   248	61	2	i	int
    //   246	6	3	j	int
    //   69	304	4	str1	String
    //   4	310	5	localObject1	Object
    //   29	115	6	str2	String
    //   234	44	7	localSimpleDateFormat	SimpleDateFormat
    //   123	132	8	localObject2	Object
    //   258	42	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	71	312	java/lang/Throwable
    //   71	139	312	java/lang/Throwable
    //   139	197	312	java/lang/Throwable
    //   221	247	312	java/lang/Throwable
    //   260	305	312	java/lang/Throwable
    //   320	324	327	java/io/IOException
    //   6	71	331	finally
    //   71	139	331	finally
    //   139	197	331	finally
    //   221	247	331	finally
    //   260	305	331	finally
    //   213	217	344	finally
    //   320	324	344	finally
    //   338	342	344	finally
    //   342	344	344	finally
    //   213	217	350	java/io/IOException
    //   338	342	354	java/io/IOException
    //   197	209	358	finally
    //   197	209	362	java/lang/Throwable
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toUpperCase().contains("XIAOMI");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Calendar.getInstance(Locale.CHINA).get(11);
    int j = Calendar.getInstance(Locale.CHINA).get(12);
    if (paramInt1 < paramInt3)
    {
      if ((paramInt1 < i) && (i < paramInt3)) {}
      while (((i == paramInt1) && (j >= paramInt2)) || ((i == paramInt3) && (j <= paramInt4))) {
        return true;
      }
    }
    label121:
    do
    {
      do
      {
        return false;
        if (paramInt1 <= paramInt3) {
          break label121;
        }
        if (((i > paramInt1) && (i < 24)) || (i < paramInt3) || ((i == paramInt1) && (j >= paramInt2))) {
          break;
        }
      } while ((i != paramInt3) || (j > paramInt4));
      return true;
    } while ((paramInt1 != i) || (j < paramInt2) || (paramInt4 < j));
    return true;
  }
  
  @SuppressLint({"SdCardPath"})
  public static boolean a(Context paramContext)
  {
    File localFile = new File("/data/data/root");
    try
    {
      localFile.createNewFile();
      if (localFile.exists()) {
        localFile.delete();
      }
      return true;
    }
    catch (IOException localIOException)
    {
      while ((a(paramContext, "com.noshufou.android.su") != null) || (a(paramContext, "com.miui.uac") != null)) {}
    }
    return false;
  }
  
  private static boolean a(Context paramContext, PackageManager paramPackageManager, String[] paramArrayOfString)
  {
    int i;
    if ((a()) && (PushSettings.m(paramContext))) {
      i = 1;
    }
    int j;
    while (i != 0) {
      try
      {
        String str = paramContext.getPackageName() + ".permission.MIPUSH_RECEIVE";
        int m;
        if (a(str, paramArrayOfString))
        {
          paramContext = paramPackageManager.getPackageInfo(paramContext.getPackageName(), 4096).permissions;
          if ((paramContext != null) && (paramContext.length > 0))
          {
            m = paramContext.length;
            i = 0;
            j = 0;
          }
        }
        else
        {
          while (i < m)
          {
            paramPackageManager = paramContext[i];
            int k = j;
            if (paramPackageManager.name.equals(str)) {
              if (paramPackageManager.protectionLevel == 2)
              {
                k = 1;
              }
              else
              {
                Log.e("BDPushSDK-Utility", "xiaomi proxy permission is not signature,  please check!");
                k = j;
                break label185;
                com.baidu.android.pushservice.g.a.b("Utility", "the permission [ " + str + " ] for " + "xiaomi proxy need is not exist, please check!", paramContext);
                return true;
              }
            }
            label185:
            i += 1;
            j = k;
            continue;
            i = 0;
          }
        }
      }
      catch (Exception paramContext) {}
    }
    do
    {
      return false;
    } while (j != 0);
    return true;
  }
  
  public static boolean a(Context paramContext, PublicMsg paramPublicMsg)
  {
    String str3 = com.baidu.android.pushservice.k.f.a((paramPublicMsg.mAppId + paramPublicMsg.mMsgId + paramPublicMsg.mUrl + paramPublicMsg.mDescription + paramPublicMsg.mTitle + paramPublicMsg.mOpenType).getBytes(), true);
    String str1 = m.b(paramContext, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
    int i;
    if (TextUtils.isEmpty(str1))
    {
      i = 0;
      str1 = str3;
    }
    for (;;)
    {
      if (i == 0) {
        m.b(paramContext, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS", str1);
      }
      if (com.baidu.android.pushservice.c.d.a(paramContext).b() == 3) {
        c.a(paramContext, new com.baidu.android.pushservice.d.e(paramPublicMsg.mMsgId, str3, paramPublicMsg.mAppId));
      }
      return true;
      if (str1.contains(str3))
      {
        i = 1;
      }
      else
      {
        String str2 = str1;
        if (str1.length() > 3000) {
          str2 = str1.substring(1000);
        }
        str1 = str2 + ":" + str3;
        i = 0;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str2 = PushSettings.b(paramContext);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString2;
    }
    boolean bool = false;
    paramString5 = com.baidu.android.pushservice.k.f.a((str1 + paramString1 + paramString3 + paramString4 + paramString5).getBytes(), true);
    paramString3 = m.b(paramContext, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = paramString5;
    }
    for (;;)
    {
      if (!bool) {
        m.b(paramContext, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS", paramString3);
      }
      if ((com.baidu.android.pushservice.c.d.a(paramContext).b() == 3) && (!TextUtils.isEmpty(paramString1))) {
        c.a(paramContext, new com.baidu.android.pushservice.d.e(paramString1, paramString5, paramString2));
      }
      return bool;
      if (paramString3.contains(paramString5))
      {
        bool = true;
      }
      else
      {
        paramString4 = paramString3;
        if (paramString3.length() > 3000) {
          paramString4 = paramString3.substring(1000);
        }
        paramString3 = paramString4 + ":" + paramString5;
      }
    }
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new Intent(paramString1);
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      if (paramBoolean)
      {
        localObject = localPackageManager.queryBroadcastReceivers((Intent)localObject, 576);
        if (((List)localObject).size() < 1)
        {
          Log.e("BDPushSDK-Utility", paramString2 + " is not exist or did not declared " + paramString1);
          return false;
        }
        paramString1 = ((List)localObject).iterator();
        do
        {
          if (!paramString1.hasNext()) {
            break;
          }
        } while (!paramString2.equals(((ResolveInfo)paramString1.next()).activityInfo.name));
        return true;
      }
      localObject = localPackageManager.queryIntentServices((Intent)localObject, 576);
      if (((List)localObject).size() < 1)
      {
        Log.e("BDPushSDK-Utility", paramString2 + " is not exist or did not declared " + paramString1);
        return false;
      }
      paramString1 = ((List)localObject).iterator();
      while (paramString1.hasNext())
      {
        localObject = (ResolveInfo)paramString1.next();
        if (paramString2.equals(((ResolveInfo)localObject).serviceInfo.name))
        {
          int i = E(paramContext, paramString2);
          if (!((ResolveInfo)localObject).serviceInfo.exported)
          {
            Log.e("BDPushSDK-Utility", paramString2 + " exported is false , please check!");
            return false;
          }
          if ((i == 1) || ((i == 0) && (((ResolveInfo)localObject).serviceInfo.enabled))) {
            break label368;
          }
          Log.e("BDPushSDK-Utility", paramString2 + " is disable, please check!");
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      com.baidu.android.pushservice.g.a.b("Utility", "error  " + paramString1.getMessage(), paramContext);
    }
    label368:
    return true;
  }
  
  public static boolean a(Context paramContext, byte[] paramArrayOfByte1, String paramString1, String paramString2, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramString2 == null) || (paramArrayOfByte2 == null)) {}
    for (;;)
    {
      return false;
      try
      {
        String str2 = PushSettings.b(paramContext);
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          com.baidu.android.pushservice.b.f localf = com.baidu.android.pushservice.b.b.a(paramContext).d(paramString1);
          str1 = str2;
          if (localf != null) {
            str1 = localf.a();
          }
        }
        if ((TextUtils.isEmpty(str1)) || (!str1.equals(paramString1)))
        {
          com.baidu.android.pushservice.g.a.a("Utility", "walnutShellVerify error, appId not equal: " + paramString1 + "  stored: " + str1, paramContext);
          return false;
        }
        paramContext = BaiduAppSSOJni.decryptR(paramArrayOfByte1, 0);
        paramArrayOfByte1 = com.baidu.android.pushservice.k.f.a(a(a(paramString1.getBytes(), paramString2.getBytes()), paramArrayOfByte2), false);
        paramContext = new String(paramContext);
        if (paramArrayOfByte1 != null)
        {
          boolean bool = paramArrayOfByte1.equals(paramContext);
          if (bool) {
            return true;
          }
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  private static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int i;
    if ((d()) && (PushSettings.o(paramContext))) {
      i = 1;
    }
    while (i != 0) {
      try
      {
        boolean bool = a("com.coloros.mcs.permission.RECIEVE_MCS_MESSAGE", paramArrayOfString);
        if (!bool)
        {
          return true;
          i = 0;
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.contains(" ")))
    {
      Log.e("BDPushSDK-Utility", "api_key is  incorrect, please check ! ");
      return false;
    }
    return true;
  }
  
  static boolean a(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramArrayOfString.length)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static byte[] a(Context paramContext, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2)
  {
    int i = m(paramContext, paramString2);
    paramContext = paramArrayOfByte2;
    if (i > 45)
    {
      paramContext = paramArrayOfByte2;
      if (i >= 50) {}
    }
    try
    {
      paramContext = BaiduAppSSOJni.encryptR(com.baidu.android.pushservice.k.f.a(a(paramString1.getBytes(), paramArrayOfByte1), false).getBytes(), 0);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return paramArrayOfByte2;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static int b(String paramString)
  {
    try
    {
      l = Long.parseLong(paramString);
      return (int)l;
    }
    catch (Exception localException)
    {
      long l;
      String str = paramString;
      try
      {
        if (paramString.length() > 0) {
          str = paramString.substring(1);
        }
        l = Long.parseLong(str);
        return (int)l;
      }
      catch (Exception paramString) {}
    }
    return 0;
  }
  
  public static void b(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    paramIntent.setFlags(32);
    int i = m(paramContext, paramString2);
    if (i >= 32) {}
    try
    {
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.setAction(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramIntent.setPackage(paramString2);
        paramIntent.setClassName(paramString2, "com.baidu.android.pushservice.CommandService");
      }
      paramIntent.putExtra("command_type", "reflect_receiver");
      if (paramContext.startService(paramIntent) != null) {
        return;
      }
      b("sendRedirecctionIntent#intergratedPushVersion=" + i + ", packageName=" + paramString2 + ", intent=" + paramIntent.toUri(0), paramContext);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!G(paramContext))
    {
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.setAction(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        paramIntent.setPackage(paramString2);
      }
      paramString1 = c(paramContext, paramString2, paramString1);
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.setClassName(paramString2, paramString1);
      }
      paramContext.sendBroadcast(paramIntent);
      return;
    }
  }
  
  /* Error */
  public static void b(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 1333	com/baidu/android/pushservice/j/p:P	(Landroid/content/Context;)Z
    //   7: istore 4
    //   9: iload 4
    //   11: ifne +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: invokestatic 1334	com/baidu/android/pushservice/a:b	()I
    //   21: ifle +17 -> 38
    //   24: aload_0
    //   25: aload_1
    //   26: invokestatic 1336	com/baidu/android/pushservice/j/p:c	(Ljava/lang/String;Landroid/content/Context;)V
    //   29: goto -15 -> 14
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: aload_1
    //   39: invokestatic 1338	com/baidu/android/pushservice/a:a	(Landroid/content/Context;)Z
    //   42: istore 4
    //   44: iload 4
    //   46: ifeq -32 -> 14
    //   49: aconst_null
    //   50: astore_1
    //   51: new 683	java/text/SimpleDateFormat
    //   54: dup
    //   55: ldc_w 1074
    //   58: invokespecial 686	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   61: new 688	java/util/Date
    //   64: dup
    //   65: invokespecial 1084	java/util/Date:<init>	()V
    //   68: invokevirtual 695	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   71: astore 5
    //   73: new 106	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   80: aload 5
    //   82: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 1089
    //   88: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 1091
    //   98: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore 5
    //   106: invokestatic 1097	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   109: invokevirtual 1102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: astore 7
    //   114: new 1099	java/io/File
    //   117: dup
    //   118: aload 7
    //   120: ldc_w 1104
    //   123: invokespecial 1105	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: astore 8
    //   128: aload 8
    //   130: invokevirtual 1108	java/io/File:exists	()Z
    //   133: ifne +9 -> 142
    //   136: aload 8
    //   138: invokevirtual 1111	java/io/File:mkdirs	()Z
    //   141: pop
    //   142: new 683	java/text/SimpleDateFormat
    //   145: dup
    //   146: ldc_w 1131
    //   149: invokespecial 686	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   152: astore_0
    //   153: new 688	java/util/Date
    //   156: dup
    //   157: invokespecial 1084	java/util/Date:<init>	()V
    //   160: astore 6
    //   162: aload_0
    //   163: aload 6
    //   165: invokevirtual 695	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   168: astore 9
    //   170: new 1099	java/io/File
    //   173: dup
    //   174: aload 7
    //   176: new 106	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 1340
    //   186: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload 9
    //   191: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc_w 1115
    //   197: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokespecial 1105	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: astore 7
    //   208: aload 7
    //   210: invokevirtual 1108	java/io/File:exists	()Z
    //   213: ifne +102 -> 315
    //   216: aload 8
    //   218: invokevirtual 1135	java/io/File:listFiles	()[Ljava/io/File;
    //   221: astore 8
    //   223: aload 8
    //   225: arraylength
    //   226: istore_3
    //   227: iconst_0
    //   228: istore_2
    //   229: iload_2
    //   230: iload_3
    //   231: if_icmpge +78 -> 309
    //   234: aload 8
    //   236: iload_2
    //   237: aaload
    //   238: astore 9
    //   240: aload 9
    //   242: invokevirtual 1138	java/io/File:getName	()Ljava/lang/String;
    //   245: astore 10
    //   247: aload 10
    //   249: ldc_w 1342
    //   252: invokevirtual 1141	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   255: ifeq +139 -> 394
    //   258: aload 10
    //   260: invokevirtual 255	java/lang/String:length	()I
    //   263: ifle +131 -> 394
    //   266: aload_0
    //   267: aload 10
    //   269: iconst_3
    //   270: bipush 11
    //   272: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
    //   275: invokevirtual 1345	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   278: invokevirtual 1348	java/util/Date:getTime	()J
    //   281: aload 6
    //   283: invokevirtual 1348	java/util/Date:getTime	()J
    //   286: lsub
    //   287: ldc2_w 1349
    //   290: ldiv
    //   291: invokestatic 1354	java/lang/Math:abs	(J)J
    //   294: l2i
    //   295: bipush 7
    //   297: if_icmplt +97 -> 394
    //   300: aload 9
    //   302: invokevirtual 1155	java/io/File:delete	()Z
    //   305: pop
    //   306: goto +88 -> 394
    //   309: aload 7
    //   311: invokevirtual 1174	java/io/File:createNewFile	()Z
    //   314: pop
    //   315: aload 7
    //   317: invokevirtual 1108	java/io/File:exists	()Z
    //   320: ifeq +69 -> 389
    //   323: new 1356	java/io/FileWriter
    //   326: dup
    //   327: aload 7
    //   329: iconst_1
    //   330: invokespecial 1357	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   333: astore_0
    //   334: aload_0
    //   335: aload 5
    //   337: invokevirtual 1359	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   340: iconst_1
    //   341: anewarray 1361	java/io/Closeable
    //   344: dup
    //   345: iconst_0
    //   346: aload_0
    //   347: aastore
    //   348: invokestatic 1366	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   351: goto -337 -> 14
    //   354: iconst_1
    //   355: anewarray 1361	java/io/Closeable
    //   358: dup
    //   359: iconst_0
    //   360: aload_0
    //   361: aastore
    //   362: invokestatic 1366	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   365: goto -351 -> 14
    //   368: iconst_1
    //   369: anewarray 1361	java/io/Closeable
    //   372: dup
    //   373: iconst_0
    //   374: aload_0
    //   375: aastore
    //   376: invokestatic 1366	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   379: aload_1
    //   380: athrow
    //   381: astore_1
    //   382: goto -14 -> 368
    //   385: astore_1
    //   386: goto -32 -> 354
    //   389: aconst_null
    //   390: astore_0
    //   391: goto -51 -> 340
    //   394: iload_2
    //   395: iconst_1
    //   396: iadd
    //   397: istore_2
    //   398: goto -169 -> 229
    //   401: astore_0
    //   402: aload_1
    //   403: astore_0
    //   404: goto -50 -> 354
    //   407: astore_1
    //   408: aconst_null
    //   409: astore_0
    //   410: goto -42 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramString	String
    //   0	413	1	paramContext	Context
    //   228	170	2	i	int
    //   226	6	3	j	int
    //   7	38	4	bool	boolean
    //   71	265	5	str1	String
    //   160	122	6	localDate	Date
    //   112	216	7	localObject1	Object
    //   126	109	8	localObject2	Object
    //   168	133	9	str2	String
    //   245	23	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   3	9	32	finally
    //   18	29	32	finally
    //   38	44	32	finally
    //   340	351	32	finally
    //   354	365	32	finally
    //   368	381	32	finally
    //   334	340	381	finally
    //   334	340	385	java/lang/Throwable
    //   51	142	401	java/lang/Throwable
    //   142	227	401	java/lang/Throwable
    //   240	306	401	java/lang/Throwable
    //   309	315	401	java/lang/Throwable
    //   315	334	401	java/lang/Throwable
    //   51	142	407	finally
    //   142	227	407	finally
    //   240	306	407	finally
    //   309	315	407	finally
    //   315	334	407	finally
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toUpperCase().contains("MEIZU");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean b(Context paramContext, PublicMsg paramPublicMsg)
  {
    if (paramPublicMsg != null)
    {
      String str2 = com.baidu.android.pushservice.k.f.a((paramPublicMsg.mAppId + paramPublicMsg.mMsgId + paramPublicMsg.mUrl + paramPublicMsg.mDescription + paramPublicMsg.mTitle + paramPublicMsg.mOpenType).getBytes(), true);
      String str1 = m.b(paramContext, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.contains(str2))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!TextUtils.isEmpty(str2)) {
            if (com.baidu.android.pushservice.c.d.a(paramContext).b() != 4) {
              break label169;
            }
          }
        }
        label169:
        for (str1 = com.baidu.android.pushservice.c.d.a(paramContext).c();; str1 = v(paramContext))
        {
          paramContext = c.a(paramContext, str1, paramPublicMsg.mMsgId);
          if ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(str2))) {
            break;
          }
          bool2 = true;
          return bool2;
        }
        return false;
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.getApplicationInfo(paramString, 0).flags;
      if ((i & 0x1) != 0) {
        return true;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getApplicationInfo(paramString1, 128);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
    if ((paramContext != null) && (paramContext.metaData != null) && (paramContext.metaData.containsKey(paramString2))) {
      return paramContext.metaData.getBoolean(paramString2);
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = PushSettings.b(paramContext);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      paramString1 = paramString2 + paramString1 + paramString3 + paramString4 + paramString5;
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      paramString2 = com.baidu.android.pushservice.k.f.a(paramString1.getBytes(), true);
      paramString1 = m.b(paramContext, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.contains(paramString2))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramString2))
          {
            if (com.baidu.android.pushservice.c.d.a(paramContext).b() != 4) {
              break label165;
            }
            paramString1 = com.baidu.android.pushservice.c.d.a(paramContext).c();
            paramContext = c.b(paramContext, paramString1, paramString2);
            if ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(paramString2))) {
              break label173;
            }
          }
        }
        label165:
        label173:
        for (bool2 = true;; bool2 = false)
        {
          return bool2;
          paramString1 = v(paramContext);
          break;
        }
      }
      paramString2 = str;
    }
  }
  
  public static int[] b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new int[] { localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels };
  }
  
  public static int c(String paramString)
  {
    int k = 0;
    int j;
    for (;;)
    {
      j = k;
      try
      {
        int m = paramString.indexOf("#Intent;");
        int i = k;
        String str = paramString;
        if (m != -1)
        {
          j = k;
          i = k + ("#Intent;".length() + m);
          j = i;
          str = paramString.substring("#Intent;".length() + m);
        }
        k = i;
        paramString = str;
        if (m == -1)
        {
          j = i;
          if (i > 0)
          {
            j = i;
            k = "#Intent;".length();
            j = i - k;
          }
          return j;
        }
      }
      catch (Exception paramString) {}
    }
    return j;
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      for (;;)
      {
        return null;
        paramString2 = new Intent(paramString2);
        paramString2.setPackage(paramString1);
        try
        {
          paramContext = paramContext.getPackageManager();
          if (paramContext != null) {
            paramContext = paramContext.queryBroadcastReceivers(paramString2, 576);
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext = null;
          }
        }
      }
    } while ((paramContext == null) || (paramContext.size() <= 0));
    return ((ResolveInfo)paramContext.get(0)).activityInfo.name;
  }
  
  private static void c(String paramString, Context paramContext)
  {
    if (paramContext != null)
    {
      String str1;
      String str2;
      int i;
      try
      {
        str1 = "samonitor" + com.baidu.android.pushservice.k.e.b(paramContext);
        str2 = s(paramContext);
        i = t(paramContext);
        if (c) {
          break label157;
        }
        Object localObject = q(paramContext);
        paramContext = new StringBuffer();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str3 = (String)((Iterator)localObject).next();
          paramContext.append(str3 + ";");
        }
        a(str1, "#AllPackagesUsingPush:" + paramContext.toString());
      }
      finally {}
      c = true;
      label157:
      a(str1, "#IMEI:" + null + "#networkType:" + str2 + "#mobileType:" + i + "#" + paramString);
    }
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toUpperCase().contains("HUAWEI");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    String str = com.baidu.android.pushservice.a.c(paramContext);
    if ("enabled".equals(str)) {
      return false;
    }
    if ("disabled".equals(str)) {
      return true;
    }
    return b(paramContext, paramContext.getPackageName(), "DisableService");
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static int d(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    if (paramContext != null) {
      return paramContext.versionCode;
    }
    return 0;
  }
  
  /* Error */
  private static int d(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 1455	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: new 106	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 1457
    //   16: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokevirtual 1461	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   29: astore 4
    //   31: new 1463	java/io/InputStreamReader
    //   34: dup
    //   35: aload 4
    //   37: invokevirtual 1469	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 1472	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: astore 5
    //   45: new 1474	java/io/BufferedReader
    //   48: dup
    //   49: aload 5
    //   51: invokespecial 1477	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore 7
    //   56: new 17	java/lang/String
    //   59: dup
    //   60: invokespecial 1478	java/lang/String:<init>	()V
    //   63: pop
    //   64: iconst_0
    //   65: istore_1
    //   66: aload 7
    //   68: invokevirtual 1481	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore 6
    //   73: aload 6
    //   75: ifnull +73 -> 148
    //   78: iload_1
    //   79: iconst_1
    //   80: iadd
    //   81: istore_2
    //   82: aload 6
    //   84: new 106	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 1483
    //   94: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokevirtual 195	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   107: istore_3
    //   108: iload_3
    //   109: ifeq +32 -> 141
    //   112: iconst_2
    //   113: anewarray 1361	java/io/Closeable
    //   116: dup
    //   117: iconst_0
    //   118: aload 7
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload 5
    //   125: aastore
    //   126: invokestatic 1366	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   129: aload 4
    //   131: ifnull +8 -> 139
    //   134: aload 4
    //   136: invokevirtual 1486	java/lang/Process:destroy	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: iload_2
    //   142: istore_1
    //   143: iload_2
    //   144: iconst_3
    //   145: if_icmple -79 -> 66
    //   148: iconst_2
    //   149: anewarray 1361	java/io/Closeable
    //   152: dup
    //   153: iconst_0
    //   154: aload 7
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload 5
    //   161: aastore
    //   162: invokestatic 1366	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   165: aload 4
    //   167: ifnull +8 -> 175
    //   170: aload 4
    //   172: invokevirtual 1486	java/lang/Process:destroy	()V
    //   175: iconst_m1
    //   176: ireturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_0
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 6
    //   185: astore 5
    //   187: iconst_2
    //   188: anewarray 1361	java/io/Closeable
    //   191: dup
    //   192: iconst_0
    //   193: aload_0
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 5
    //   199: aastore
    //   200: invokestatic 1366	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   203: aload 4
    //   205: ifnull +8 -> 213
    //   208: aload 4
    //   210: invokevirtual 1486	java/lang/Process:destroy	()V
    //   213: iconst_1
    //   214: ireturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore 5
    //   219: aconst_null
    //   220: astore 4
    //   222: aconst_null
    //   223: astore 6
    //   225: iconst_2
    //   226: anewarray 1361	java/io/Closeable
    //   229: dup
    //   230: iconst_0
    //   231: aload 5
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload 6
    //   238: aastore
    //   239: invokestatic 1366	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   242: aload 4
    //   244: ifnull +8 -> 252
    //   247: aload 4
    //   249: invokevirtual 1486	java/lang/Process:destroy	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_0
    //   255: aconst_null
    //   256: astore 5
    //   258: aconst_null
    //   259: astore 6
    //   261: goto -36 -> 225
    //   264: astore_0
    //   265: aconst_null
    //   266: astore 7
    //   268: aload 5
    //   270: astore 6
    //   272: aload 7
    //   274: astore 5
    //   276: goto -51 -> 225
    //   279: astore_0
    //   280: aload 5
    //   282: astore 6
    //   284: aload 7
    //   286: astore 5
    //   288: goto -63 -> 225
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_0
    //   294: aload 6
    //   296: astore 5
    //   298: goto -111 -> 187
    //   301: astore_0
    //   302: aconst_null
    //   303: astore_0
    //   304: goto -117 -> 187
    //   307: astore_0
    //   308: aload 7
    //   310: astore_0
    //   311: goto -124 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramString	String
    //   65	78	1	i	int
    //   81	65	2	j	int
    //   107	2	3	bool	boolean
    //   29	219	4	localProcess	Process
    //   43	254	5	localObject1	Object
    //   1	294	6	localObject2	Object
    //   54	255	7	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   3	31	177	java/lang/Exception
    //   3	31	215	finally
    //   31	45	254	finally
    //   45	56	264	finally
    //   56	64	279	finally
    //   66	73	279	finally
    //   82	108	279	finally
    //   31	45	291	java/lang/Exception
    //   45	56	301	java/lang/Exception
    //   56	64	307	java/lang/Exception
    //   66	73	307	java/lang/Exception
    //   82	108	307	java/lang/Exception
  }
  
  static String d(Context paramContext)
  {
    PackageManager localPackageManager;
    String[] arrayOfString;
    try
    {
      localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return "pm is null";
      }
      arrayOfString = localPackageManager.getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
      if (arrayOfString == null)
      {
        Log.e("BDPushSDK-Utility", "Permissions Push-SDK need are not exist !");
        return "Permissions Push-SDK need are not exist !";
      }
    }
    catch (Exception paramContext)
    {
      return "checkSDKPermissions exception " + paramContext.getMessage();
    }
    if (a(paramContext, localPackageManager, arrayOfString))
    {
      Log.e("BDPushSDK-Utility", "permission Push-SDK for xiaomi proxy need is not exist !");
      return "permission Push-SDK for xiaomi proxy need is not exist !";
    }
    if (a(paramContext, arrayOfString))
    {
      Log.e("BDPushSDK-Utility", "permission Push-SDK for oppo proxy need is not exist !");
      return "permission Push-SDK for oppo proxy need is not exist !";
    }
    paramContext = a;
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      localPackageManager = paramContext[i];
      if (!a(localPackageManager, arrayOfString))
      {
        paramContext = localPackageManager + " permission Push-SDK need is not exist !";
        Log.e("BDPushSDK-Utility", paramContext);
        return paramContext;
      }
      i += 1;
    }
    return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationContext();
      n.a(paramContext, 6, "");
      MiPushClient.registerPush(paramContext, paramString1, paramString2);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean d()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toUpperCase().contains("OPPO");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static String e(String paramString)
  {
    String str2 = "";
    String str1 = paramString;
    try
    {
      if (paramString.startsWith("http://")) {
        str1 = paramString.replace("http://", "");
      }
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(str1);
      str1 = str2;
      if (arrayOfInetAddress != null)
      {
        str1 = str2;
        if (arrayOfInetAddress.length > 0)
        {
          int j = arrayOfInetAddress.length;
          int i = 0;
          paramString = str2;
          while (i < j)
          {
            str1 = arrayOfInetAddress[i];
            paramString = paramString + ":" + str1.getHostAddress();
            i += 1;
          }
          str1 = paramString;
          if (paramString.length() > 1) {
            str1 = paramString.substring(1);
          }
        }
      }
      return str1;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static void e(Context paramContext)
  {
    a(paramContext, 300000L);
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationContext();
      n.a(paramContext, 7, "");
      com.meizu.cloud.pushsdk.PushManager.register(paramContext, paramString1, paramString2);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean e()
  {
    return (a()) || (c()) || (b()) || (d());
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getApplicationInfo(paramString, 128);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
    if ((paramContext != null) && (paramContext.metaData != null)) {
      return paramContext.metaData.getBoolean("IsBaiduApp");
    }
    return false;
  }
  
  public static long f(Context paramContext)
  {
    int i = 5;
    String str = paramContext.getPackageName();
    if ((H(paramContext)) && (str.equalsIgnoreCase("com.baidu.push4manufacture"))) {
      return 10000L;
    }
    long l1 = com.baidu.android.pushservice.a.a();
    int j = com.baidu.android.pushservice.a.b();
    if (j > 0) {
      if (j <= 5) {
        break label138;
      }
    }
    for (;;)
    {
      return i + ((l1 << 4) + 10L);
      if (paramContext.getPackageName().equals("com.baidu.searchbox")) {
        return (l1 << 4) + 10L;
      }
      long l2 = l1 << 2;
      l1 = l2;
      if (e(paramContext, paramContext.getPackageName())) {
        l1 = l2 + 1L;
      }
      l2 = l1 << 1;
      l1 = l2;
      if (b(paramContext, paramContext.getPackageName())) {
        l1 = l2 + 1L;
      }
      return (l1 << 1) + l(paramContext);
      label138:
      i = j;
    }
  }
  
  private static String f(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody="))) {
        if (paramString.contains("bdpush_hwsigninfo"))
        {
          int i = c(paramString);
          if (i > 0) {
            return paramString.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), i);
          }
        }
        else
        {
          paramString = paramString.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), paramString.length());
          return paramString;
        }
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void f(Context paramContext, String paramString)
  {
    if (!i(paramContext, paramString)) {
      return;
    }
    Intent localIntent = o.c(paramContext);
    if (!F(paramContext))
    {
      localIntent.putExtra("method", "pushservice_restart_v2");
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(u(paramContext)))) {
        localIntent.putExtra("priority2", Long.MAX_VALUE);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localIntent.setPackage(paramString);
        localIntent.setClassName(paramString, "com.baidu.android.pushservice.CommandService");
      }
      localIntent.putExtra("command_type", "reflect_receiver");
      try
      {
        localObject = paramContext.startService(localIntent);
        if ((localObject != null) || (G(paramContext))) {
          break;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        for (;;) {}
      }
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.setPackage(paramString);
      }
      localObject = c(paramContext, paramString, "com.baidu.android.pushservice.action.METHOD");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localIntent.setClassName(paramString, (String)localObject);
      }
      paramContext.sendBroadcast(localIntent);
      com.baidu.android.pushservice.a.a(paramContext, false);
      return;
      localIntent.putExtra("priority2", h(paramContext));
      continue;
      localIntent.putExtra("method", "pushservice_restart_v3");
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(u(paramContext)))) {
        localIntent.putExtra("priority3", Long.MAX_VALUE);
      } else {
        localIntent.putExtra("priority3", h(paramContext));
      }
    }
  }
  
  /* Error */
  public static long g(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: lload_3
    //   3: lstore 5
    //   5: aload_0
    //   6: ifnull +13 -> 19
    //   9: aload_1
    //   10: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +9 -> 22
    //   16: lload_3
    //   17: lstore 5
    //   19: lload 5
    //   21: lreturn
    //   22: aload_0
    //   23: invokestatic 104	com/baidu/android/pushservice/j/p:E	(Landroid/content/Context;)Z
    //   26: ifeq +87 -> 113
    //   29: aload_0
    //   30: aload_1
    //   31: invokestatic 1580	com/baidu/android/pushservice/j/p:v	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Context;
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull +75 -> 113
    //   41: aload 7
    //   43: new 106	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   50: aload_1
    //   51: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 118
    //   56: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: iconst_5
    //   63: invokevirtual 1009	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   66: astore 7
    //   68: aload 7
    //   70: ifnull +43 -> 113
    //   73: aload 7
    //   75: ldc_w 1030
    //   78: lconst_0
    //   79: invokeinterface 1584 4 0
    //   84: lstore_3
    //   85: lload_3
    //   86: lstore 5
    //   88: lload_3
    //   89: ldc2_w 1585
    //   92: lcmp
    //   93: ifne -74 -> 19
    //   96: aload_0
    //   97: aload_1
    //   98: invokestatic 1590	com/baidu/android/pushservice/d/d:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   101: istore_2
    //   102: iload_2
    //   103: i2l
    //   104: lreturn
    //   105: astore_0
    //   106: ldc2_w 1585
    //   109: lreturn
    //   110: astore_0
    //   111: lload_3
    //   112: lreturn
    //   113: ldc2_w 1585
    //   116: lstore_3
    //   117: goto -32 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramString	String
    //   101	2	2	i	int
    //   1	116	3	l1	long
    //   3	84	5	l2	long
    //   34	40	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	36	105	java/lang/Exception
    //   41	68	105	java/lang/Exception
    //   73	85	105	java/lang/Exception
    //   96	102	110	java/lang/Exception
  }
  
  public static void g(Context paramContext)
  {
    a(paramContext, false, false);
  }
  
  public static long h(Context paramContext)
  {
    long l2 = 0L;
    if (paramContext == null) {
      return l2;
    }
    for (;;)
    {
      try
      {
        if (E(paramContext))
        {
          SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramContext.getPackageName() + ".push_sync", 5);
          if (localSharedPreferences != null)
          {
            l1 = localSharedPreferences.getLong("priority2", 0L);
            l2 = l1;
            if (l1 != -1L) {
              break;
            }
          }
        }
        int i;
        long l1 = -1L;
      }
      catch (Exception paramContext)
      {
        try
        {
          i = c.b(paramContext);
          return i;
        }
        catch (Exception paramContext)
        {
          return l1;
        }
        paramContext = paramContext;
        return -1L;
      }
    }
  }
  
  public static boolean h(Context paramContext, String paramString)
  {
    Object localObject = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
    ((Intent)localObject).setPackage(paramString);
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext == null) {
          return false;
        }
        localObject = paramContext.queryIntentServices((Intent)localObject, 576);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          continue;
        }
        i = 0;
        if (i >= ((List)localObject).size()) {
          continue;
        }
        if (("com.baidu.android.pushservice.PushService".equals(((ResolveInfo)((List)localObject).get(i)).serviceInfo.name)) && (((ResolveInfo)((List)localObject).get(i)).serviceInfo.exported)) {
          bool = ((ResolveInfo)((List)localObject).get(i)).serviceInfo.enabled;
        }
      }
      catch (Exception paramContext)
      {
        boolean bool = false;
        int i = 2;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
      }
      try
      {
        i = paramContext.getComponentEnabledSetting(new ComponentName(paramString, "com.baidu.android.pushservice.PushService"));
        if ((i != 1) && ((i != 0) || (!bool))) {
          continue;
        }
        bool = true;
        return bool;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      i += 1;
    }
  }
  
  static boolean i(Context paramContext)
  {
    return j(paramContext, paramContext.getPackageName());
  }
  
  public static boolean i(Context paramContext, String paramString)
  {
    localObject = null;
    Intent localIntent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
    localIntent.setPackage(paramString);
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.queryIntentServices(localIntent, 576);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
    return (paramContext != null) && (paramContext.size() > 0);
  }
  
  static boolean j(Context paramContext)
  {
    return k(paramContext, paramContext.getPackageName());
  }
  
  public static boolean j(Context paramContext, String paramString)
  {
    boolean bool;
    for (;;)
    {
      try
      {
        paramString = new Intent("com.baidu.android.pushservice.action.notification.CLICK");
        paramString.setPackage(paramContext.getPackageName());
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null) {
          return false;
        }
        paramString = localPackageManager.queryBroadcastReceivers(paramString, 576);
        if (paramString.size() < 1) {
          return false;
        }
        paramString = paramString.iterator();
        if (paramString.hasNext())
        {
          ResolveInfo localResolveInfo = (ResolveInfo)paramString.next();
          paramString = localResolveInfo.activityInfo.name;
          bool = localResolveInfo.activityInfo.enabled;
          if ((!a(paramContext, "com.baidu.android.pushservice.action.MESSAGE", paramString, true)) || (!a(paramContext, "com.baidu.android.pushservice.action.RECEIVE", paramString, true)))
          {
            Log.e("BDPushSDK-Utility", paramString + " did not declared " + "com.baidu.android.pushservice.action.MESSAGE" + " or " + "com.baidu.android.pushservice.action.RECEIVE");
            return false;
          }
          if ((c()) && (PushSettings.p(paramContext)))
          {
            if (!a(paramContext, "com.huawei.intent.action.PUSH", paramString, true))
            {
              Log.e("BDPushSDK-Utility", paramString + " did not declared " + "com.huawei.intent.action.PUSH");
              return false;
            }
            if (!a(paramContext, "com.huawei.android.push.intent.RECEIVE", paramString, true))
            {
              Log.e("BDPushSDK-Utility", paramString + " did not declared " + "com.huawei.android.push.intent.RECEIVE");
              return false;
            }
            if (!a(paramContext, "com.huawei.android.push.intent.REGISTRATION", paramString, true))
            {
              Log.e("BDPushSDK-Utility", paramString + " did not declared " + "com.huawei.android.push.intent.REGISTRATION");
              return false;
            }
          }
          else if ((a()) && (PushSettings.m(paramContext)))
          {
            if (!a(paramContext, "com.xiaomi.mipush.RECEIVE_MESSAGE", "com.baidu.android.pushservice.PushPatchMessageReceiver", true))
            {
              Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver" + " did not declared " + "com.xiaomi.mipush.RECEIVE_MESSAGE");
              return false;
            }
            if (!a(paramContext, "com.xiaomi.mipush.MESSAGE_ARRIVED", "com.baidu.android.pushservice.PushPatchMessageReceiver", true))
            {
              Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver" + " did not declared " + "com.xiaomi.mipush.MESSAGE_ARRIVED");
              return false;
            }
            if (!a(paramContext, "com.xiaomi.mipush.ERROR", "com.baidu.android.pushservice.PushPatchMessageReceiver", true))
            {
              Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushPatchMessageReceiver" + " did not declared " + "com.xiaomi.mipush.ERROR");
              return false;
            }
          }
          else if ((b()) && (PushSettings.n(paramContext)))
          {
            if (!a(paramContext, "com.meizu.flyme.push.intent.MESSAGE", "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true))
            {
              Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver" + " did not declared " + "com.meizu.flyme.push.intent.MESSAGE");
              return false;
            }
            if (!a(paramContext, "com.meizu.flyme.push.intent.REGISTER.FEEDBACK", "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true))
            {
              Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver" + " did not declared " + "com.meizu.flyme.push.intent.REGISTER.FEEDBACK");
              return false;
            }
            if (!a(paramContext, "com.meizu.flyme.push.intent.UNREGISTER.FEEDBACK", "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true))
            {
              Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver" + " did not declared " + "com.meizu.flyme.push.intent.UNREGISTER.FEEDBACK");
              return false;
            }
            if (!I(paramContext))
            {
              Log.e("BDPushSDK-Utility", "com.meizu.cloud.pushsdk.SystemReceiver did not declared com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
              return false;
            }
          }
          else if ((d()) && (PushSettings.o(paramContext)) && (!a(paramContext, "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE", "com.coloros.mcssdk.PushService", false)))
          {
            Log.e("BDPushSDK-Utility", "com.coloros.mcssdk.PushService" + " did not declared " + "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
            return false;
          }
          int i = localPackageManager.getComponentEnabledSetting(new ComponentName(paramContext.getPackageName(), paramString));
          if ((i == 1) || ((i == 0) && (bool)))
          {
            bool = true;
            if (bool) {
              break;
            }
            try
            {
              Log.e("BDPushSDK-Utility", paramString + " is disable, please check!");
              return bool;
            }
            catch (Exception paramContext)
            {
              return bool;
            }
          }
          bool = false;
          continue;
        }
        paramString = null;
      }
      catch (Exception paramContext)
      {
        return false;
      }
      bool = false;
    }
    return bool;
  }
  
  public static String k(Context paramContext)
  {
    Object localObject = d(paramContext);
    if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", (CharSequence)localObject)) {}
    do
    {
      String str;
      do
      {
        return (String)localObject;
        str = J(paramContext);
        localObject = str;
      } while (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", str));
      localObject = K(paramContext);
      if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", (CharSequence)localObject)) {
        break;
      }
    } while (!Q(paramContext));
    return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
    return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
  }
  
  public static boolean k(Context paramContext, String paramString)
  {
    boolean bool = true;
    try
    {
      if ((E(paramContext)) && (paramContext.getSharedPreferences(paramContext.getPackageName() + ".push_sync", 5).getInt("version2", 0) < 29)) {
        return true;
      }
      paramString = new ComponentName(paramContext, "com.baidu.android.pushservice.CommandService");
      paramContext = paramContext.getPackageManager();
      new ServiceInfo();
      paramContext = paramContext.getServiceInfo(paramString, 128);
      if (TextUtils.isEmpty(paramContext.name))
      {
        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService did not declared ");
        return false;
      }
      if (!paramContext.exported)
      {
        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService  exported declared wrong");
        return true;
      }
    }
    catch (Exception paramContext)
    {
      bool = false;
    }
    return bool;
  }
  
  static int l(Context paramContext)
  {
    int j = 0;
    if (a(paramContext, "android.intent.action.USER_PRESENT", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
      j = 1;
    }
    int i = j;
    if (a(paramContext, "android.intent.action.MEDIA_MOUNTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
      i = j + 1;
    }
    j = i;
    if (a(paramContext, "android.intent.action.ACTION_POWER_CONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
      j = i + 1;
    }
    i = j;
    if (a(paramContext, "android.intent.action.ACTION_POWER_DISCONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
      i = j + 1;
    }
    return i;
  }
  
  public static String l(Context paramContext, String paramString)
  {
    if (!PushSocket.a(paramContext))
    {
      Log.e("BDPushSDK-Utility", "check socket library failed");
      return "check socket library failed";
    }
    String str = k(paramContext);
    if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", str))
    {
      Log.e("BDPushSDK-Utility", str);
      return str;
    }
    if (!a(paramString, paramContext))
    {
      Log.e("BDPushSDK-Utility", "check Apikey failed");
      return "check Apikey failed";
    }
    if (!i(paramContext)) {
      Log.e("BDPushSDK-Utility", "check SelfConfiged Receiver failed");
    }
    if ((!j(paramContext)) && (!Q(paramContext)))
    {
      Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
      return "check CommandService Enable failed";
    }
    if (!O(paramContext))
    {
      Log.e("BDPushSDK-Utility", "check CommandService Enable failed");
      return "check CommandService Enable failed";
    }
    return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
  }
  
  public static int m(Context paramContext, String paramString)
  {
    int j = 0;
    int i = j;
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        i = j;
      }
    }
    else {
      return i;
    }
    for (;;)
    {
      try
      {
        if (paramString.equals(paramContext.getPackageName())) {
          return com.baidu.android.pushservice.a.a();
        }
        boolean bool = E(paramContext);
        if (bool) {
          try
          {
            Object localObject1 = v(paramContext, paramString);
            if (localObject1 == null) {
              break label141;
            }
            localObject1 = ((Context)localObject1).getSharedPreferences(paramString + ".push_sync", 5);
            if (localObject1 != null)
            {
              i = ((SharedPreferences)localObject1).getInt("version2", 0);
              j = i;
              if (i != -1) {}
            }
          }
          catch (Exception localException)
          {
            try
            {
              j = com.baidu.android.pushservice.d.d.d(paramContext, paramString);
              i = j;
              if (j != 0) {
                break;
              }
              return 50;
            }
            catch (Exception paramContext)
            {
              return i;
            }
            localException = localException;
            i = -1;
            continue;
          }
        }
        i = -1;
      }
      catch (Exception paramContext)
      {
        return -1;
      }
      continue;
      label141:
      Object localObject2 = null;
    }
  }
  
  public static List<String> m(Context paramContext)
  {
    localArrayList = new ArrayList();
    Intent localIntent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.queryBroadcastReceivers(localIntent, 576);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localArrayList;
      }
    }
    localArrayList = new ArrayList();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      localArrayList.add(((ResolveInfo)paramContext.next()).activityInfo.packageName);
    }
    return localArrayList;
  }
  
  public static String n(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return a(paramContext, paramString, "BaiduPush_CHANNEL");
  }
  
  public static List<ResolveInfo> n(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localObject1 = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
    try
    {
      Object localObject2 = paramContext.getPackageManager();
      if (localObject2 == null) {
        return null;
      }
      localObject1 = ((PackageManager)localObject2).queryBroadcastReceivers((Intent)localObject1, 576);
      ResolveInfo localResolveInfo;
      return (List<ResolveInfo>)localObject1;
    }
    catch (Exception paramContext)
    {
      try
      {
        localArrayList = new ArrayList();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localResolveInfo = (ResolveInfo)((Iterator)localObject2).next();
          if (z(paramContext, localResolveInfo.activityInfo.packageName)) {
            localArrayList.add(localResolveInfo);
          }
        }
        ((List)localObject1).removeAll(localArrayList);
        return (List<ResolveInfo>)localObject1;
      }
      catch (Exception paramContext) {}
      paramContext = paramContext;
      return localArrayList;
    }
  }
  
  public static List<ResolveInfo> o(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
      Object localObject2 = paramContext.getPackageManager();
      if (localObject2 == null) {
        return null;
      }
      localObject1 = ((PackageManager)localObject2).queryBroadcastReceivers((Intent)localObject1, 576);
      ResolveInfo localResolveInfo;
      return (List<ResolveInfo>)localObject1;
    }
    catch (Exception paramContext)
    {
      try
      {
        localArrayList = new ArrayList();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localResolveInfo = (ResolveInfo)((Iterator)localObject2).next();
          if (!z(paramContext, localResolveInfo.activityInfo.packageName)) {
            localArrayList.add(localResolveInfo);
          }
        }
        ((List)localObject1).removeAll(localArrayList);
        return (List<ResolveInfo>)localObject1;
      }
      catch (Exception paramContext) {}
      paramContext = paramContext;
      return localArrayList;
    }
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    return a(paramContext, paramString) != null;
  }
  
  public static String p(Context paramContext)
  {
    String str = com.baidu.android.pushservice.k.e.b(paramContext);
    if (F(paramContext)) {
      return com.baidu.android.pushservice.k.f.a(("com.baidu.pushservice.singelinstancev3" + str).getBytes(), false);
    }
    return com.baidu.android.pushservice.k.f.a(("com.baidu.pushservice.singelinstancev2" + str).getBytes(), false);
  }
  
  public static String p(Context paramContext, String paramString)
  {
    int i = com.baidu.android.pushservice.c.d.a(paramContext).b();
    if ((i == 3) || (i == 4) || (i == 2))
    {
      localObject1 = com.baidu.android.pushservice.c.d.a(paramContext).c();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return (String)localObject1;
      }
    }
    if (F(paramContext)) {}
    for (Object localObject1 = o(paramContext.getApplicationContext()); (localObject1 != null) && (((List)localObject1).size() <= 1); localObject1 = n(paramContext.getApplicationContext())) {
      return paramContext.getPackageName();
    }
    if (E(paramContext)) {}
    for (;;)
    {
      try
      {
        localObject3 = paramContext.getSharedPreferences(paramContext.getPackageName() + ".push_sync", 5);
        if (localObject3 != null)
        {
          l1 = ((SharedPreferences)localObject3).getLong("priority2", 0L);
          l2 = l1;
          if (l1 == -1L) {
            l2 = c.b(paramContext);
          }
          str2 = u(paramContext);
          Iterator localIterator = ((List)localObject1).iterator();
          localObject1 = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = ((ResolveInfo)localIterator.next()).activityInfo.packageName;
          localContext = v(paramContext, (String)localObject3);
          if (E(paramContext)) {
            if (localContext == null) {
              continue;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          Object localObject3;
          localObject1 = localContext.getSharedPreferences((String)localObject3 + ".push_sync", 5);
          if (localObject1 != null)
          {
            l3 = ((SharedPreferences)localObject1).getLong("priority2", 0L);
            l1 = l3;
            if (l3 == -1L)
            {
              if (((String)localObject3).equals(paramContext.getPackageName())) {
                l1 = c.b(paramContext);
              }
            }
            else
            {
              if (l1 <= l2) {
                continue;
              }
              if (!h(localContext, (String)localObject3)) {
                continue;
              }
              paramString = (String)localObject3;
              l2 = l1;
              continue;
              localException2 = localException2;
              str1 = null;
            }
          }
        }
        catch (Exception localException1)
        {
          long l2;
          String str2;
          Context localContext;
          String str1;
          localObject2 = null;
          continue;
          l1 = com.baidu.android.pushservice.d.d.c(paramContext, str1);
          continue;
          if ((l1 == l2) && (((str1.equals(str2)) && (h(localContext, str1))) || ((str1.equals(paramContext.getPackageName())) && (!E(paramContext)))))
          {
            paramString = str1;
            continue;
          }
          l1 = l2;
          continue;
        }
        long l3 = -1L;
        continue;
        Object localObject2 = null;
        continue;
      }
      long l1 = -1L;
    }
  }
  
  public static ArrayList<String> q(Context paramContext)
  {
    if (F(paramContext)) {}
    ArrayList localArrayList;
    for (paramContext = o(paramContext.getApplicationContext());; paramContext = n(paramContext.getApplicationContext()))
    {
      localArrayList = new ArrayList();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramContext.next();
        if (!localArrayList.contains(localResolveInfo.activityInfo.packageName)) {
          localArrayList.add(localResolveInfo.activityInfo.packageName);
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean q(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramContext = com.baidu.android.pushservice.d.a.f(paramContext, paramString);
    } while ((paramContext == null) || (4 != paramContext.length));
    return a(paramContext[0], paramContext[1], paramContext[2], paramContext[3]);
  }
  
  public static String r(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return null;
      }
      paramContext = com.baidu.android.pushservice.k.f.a(paramContext.getPackageInfo(paramString, 64).signatures[0].toByteArray(), false);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static List<String> r(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      if (localObject == null) {}
      localObject = ((ActivityManager)localObject).getRunningServices(500);
      if ((localObject != null) && (((List)localObject).isEmpty())) {}
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
        if (localRunningServiceInfo.service.getClassName().contains("com.baidu.android.pushservice.PushService")) {
          localArrayList.add(localRunningServiceInfo.service.getPackageName());
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      b(com.baidu.android.pushservice.g.a.a(localException), paramContext);
    }
  }
  
  public static String s(Context paramContext)
  {
    Object localObject = k.c(paramContext);
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected()) && (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED))
    {
      if (((NetworkInfo)localObject).getTypeName().equals("WIFI")) {
        localObject = ((NetworkInfo)localObject).getTypeName();
      }
      do
      {
        return (String)localObject;
        paramContext = null;
        if (((NetworkInfo)localObject).getExtraInfo() != null) {
          paramContext = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
        }
        localObject = paramContext;
      } while (!TextUtils.isEmpty(paramContext));
      return "unknown";
    }
    return "unknown";
  }
  
  public static boolean s(Context paramContext, String paramString)
  {
    paramContext = m.a(paramContext, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
    return (!TextUtils.isEmpty(paramContext)) && (paramContext.contains(paramString));
  }
  
  public static int t(Context paramContext)
  {
    String str = "";
    Object localObject = str;
    NetworkInfo localNetworkInfo;
    if (paramContext != null)
    {
      localNetworkInfo = k.c(paramContext);
      localObject = str;
      if (localNetworkInfo != null)
      {
        localObject = str;
        if (localNetworkInfo.isConnectedOrConnecting())
        {
          if (!localNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
            break label61;
          }
          localObject = "WF";
        }
      }
    }
    while (((String)localObject).equals("WF"))
    {
      return 1;
      label61:
      paramContext = "2G";
      localObject = paramContext;
      switch (localNetworkInfo.getSubtype())
      {
      case 1: 
      case 2: 
      case 4: 
      case 11: 
      default: 
        localObject = paramContext;
        break;
      case 3: 
        localObject = "3G";
        break;
      case 7: 
        localObject = "3G";
        break;
      case 5: 
        localObject = "3G";
        break;
      case 6: 
        localObject = "3G";
        break;
      case 8: 
        localObject = "3G";
        break;
      case 10: 
        localObject = "3G";
        break;
      case 9: 
        localObject = "3G";
        break;
      case 14: 
        localObject = "3G";
        break;
      case 12: 
        localObject = "3G";
        break;
      case 15: 
        localObject = "3G";
        break;
      case 13: 
        localObject = "4G";
      }
    }
    if (((String)localObject).equals("2G")) {
      return 2;
    }
    if (((String)localObject).equals("3G")) {
      return 3;
    }
    if (((String)localObject).equals("4G")) {
      return 4;
    }
    return 0;
  }
  
  public static boolean t(Context paramContext, String paramString)
  {
    String str2 = m.a(paramContext, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
    if (TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      m.a(paramContext, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED", paramString);
      return false;
      if (str2.contains(paramString)) {
        return true;
      }
      String str1 = str2;
      if (str2.length() > 1000) {
        str1 = str2.substring(500);
      }
      paramString = str1 + ":" + paramString;
    }
  }
  
  public static String u(Context paramContext)
  {
    Object localObject2;
    Object localObject1;
    if (F(paramContext))
    {
      localObject2 = r(paramContext);
      localObject1 = o(paramContext);
      if (!((List)localObject2).isEmpty())
      {
        Iterator localIterator = ((List)localObject1).iterator();
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (ResolveInfo)localIterator.next();
          } while (!((List)localObject2).contains(((ResolveInfo)localObject1).activityInfo.packageName));
          localObject1 = com.baidu.android.pushservice.d.d.b(paramContext, ((ResolveInfo)localObject1).activityInfo.packageName);
        } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (!o(paramContext, (String)localObject1)) || (!h(paramContext, (String)localObject1)));
      }
    }
    else
    {
      do
      {
        return (String)localObject1;
        localObject2 = b.a(paramContext, "com.baidu.push.cur_pkg");
        localObject1 = r(paramContext);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((List)localObject1).contains(localObject2))) {
          break label155;
        }
        if (!o(paramContext, (String)localObject2)) {
          break;
        }
        localObject1 = localObject2;
      } while (h(paramContext, (String)localObject2));
    }
    label155:
    do
    {
      do
      {
        while (!((Iterator)localObject1).hasNext())
        {
          do
          {
            return null;
          } while (((List)localObject1).isEmpty());
          localObject1 = ((List)localObject1).iterator();
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (z(paramContext, (String)localObject2));
      localObject2 = com.baidu.android.pushservice.d.d.b(paramContext, (String)localObject2);
    } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (!o(paramContext, (String)localObject2)) || (!h(paramContext, (String)localObject2)));
    return (String)localObject2;
  }
  
  public static boolean u(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static Context v(Context paramContext, String paramString)
  {
    Context localContext = null;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localContext = paramContext.createPackageContext(paramString, 4);
      return localContext;
    }
    catch (Exception paramString)
    {
      com.baidu.android.pushservice.h.q.a(paramContext.getApplicationContext(), paramString);
    }
    return null;
  }
  
  public static String v(Context paramContext)
  {
    return p(paramContext, paramContext.getPackageName());
  }
  
  public static String w(Context paramContext)
  {
    int k = 1;
    if (k.a(paramContext)) {}
    for (int i = 0;; i = 1)
    {
      paramContext = k.c(paramContext);
      int j = k;
      if (paramContext != null)
      {
        j = k;
        if (paramContext.isAvailable()) {
          j = 0;
        }
      }
      k = d("220.181.112.244");
      int m = d("202.108.23.105");
      int n = d("202.108.23.109");
      paramContext = new JSONObject();
      try
      {
        paramContext.put("frontia_avail", i);
        paramContext.put("network_avail", j);
        paramContext.put("baidu_avail", k);
        paramContext.put("sa_avail", m);
        paramContext.put("logic_avail", n);
        return paramContext.toString();
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static String w(Context paramContext, String paramString)
  {
    String str = "";
    try
    {
      paramString = a(paramContext, paramString);
      paramContext = str;
      if (paramString != null)
      {
        paramContext = str;
        if (paramString.firstInstallTime > 0L)
        {
          long l = paramString.firstInstallTime;
          paramContext = String.valueOf(l);
        }
      }
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static String x(Context paramContext)
  {
    String str1 = e("www.baidu.com");
    String str2 = e("sa.tuisong.baidu.com");
    String str3 = e("api.tuisong.baidu.com");
    paramContext = new JSONObject();
    try
    {
      paramContext.put("baidu_ip", str1);
      paramContext.put("sa_ip", str2);
      paramContext.put("logic_ip", str3);
      if (com.baidu.android.pushservice.a.b() > 0) {}
      return paramContext.toString();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static boolean x(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    Object localObject = (ArrayList)com.baidu.android.pushservice.b.b.a(paramContext).a.clone();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!((ArrayList)localObject).isEmpty())
      {
        localObject = ((ArrayList)localObject).iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!paramString.equals(((com.baidu.android.pushservice.b.f)((Iterator)localObject).next()).c()));
        bool1 = true;
      }
    }
    if (!bool1)
    {
      String str = c.f(paramContext);
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (E(paramContext)) {
          localObject = q.a(paramContext, paramContext.getPackageName() + ".push_sync", "r_v2");
        }
      }
      paramContext = com.baidu.android.pushservice.b.b.a((String)localObject);
      if ((!TextUtils.isEmpty(paramContext)) && (paramContext.contains(paramString)))
      {
        paramContext = paramContext.replace(" ", "");
        if (paramContext.charAt(paramContext.indexOf(paramString) + paramString.length()) == ',') {
          return true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean y(Context paramContext)
  {
    try
    {
      boolean bool = paramContext.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false);
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean y(Context paramContext, String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      boolean bool1 = com.baidu.android.pushservice.d.a.e(paramContext, paramString);
      boolean bool2;
      return false;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          bool2 = t(paramContext, paramString);
          if ((bool1) || (!bool2)) {
            break;
          }
          return true;
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        bool1 = false;
        bool2 = false;
      }
    }
  }
  
  public static void z(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    n.a(paramContext, 5, "");
    paramContext = paramContext.getApplicationContext();
    Intent localIntent = new Intent("com.huawei.android.push.intent.REGISTER");
    localIntent.putExtra("pkg_name", paramContext.getPackageName());
    localIntent.setFlags(32);
    paramContext.sendBroadcast(localIntent);
    n.a(paramContext, "hasRequestToken", true);
  }
  
  public static boolean z(Context paramContext, String paramString)
  {
    int i;
    try
    {
      if ((A(paramContext, paramString) >= 24) && (Build.VERSION.SDK_INT >= 24)) {
        if (paramString.equals(paramContext.getPackageName())) {
          i = com.baidu.android.pushservice.a.a();
        } else {
          i = m(paramContext, paramString);
        }
      }
    }
    catch (Exception paramContext) {}
    do
    {
      return false;
    } while (i < 55);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */