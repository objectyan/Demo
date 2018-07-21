package com.baidu.ufosdk.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.util.c;
import com.baidu.ufosdk.util.l;
import com.baidu.ufosdk.util.m;
import com.baidu.ufosdk.util.s;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public final class a
{
  public static boolean a(Context paramContext)
  {
    String str2 = com.baidu.ufosdk.a.at;
    c.b("postUrl is " + str2);
    Object localObject1 = UUID.randomUUID().toString();
    long l2 = System.currentTimeMillis();
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("os", "android");
    ((Map)localObject2).put("clientid", UfoSDK.clientid);
    ((Map)localObject2).put("appid", UfoSDK.appid);
    ((Map)localObject2).put("devid", UfoSDK.devid);
    ((Map)localObject2).put("pkgname", d.a());
    ((Map)localObject2).put("cuid", localObject1);
    ((Map)localObject2).put("appname", d.b());
    ((Map)localObject2).put("appvn", d.c());
    ((Map)localObject2).put("brand", Build.MANUFACTURER);
    ((Map)localObject2).put("model", Build.MODEL);
    ((Map)localObject2).put("osvn", Build.VERSION.RELEASE);
    ((Map)localObject2).put("osvc", String.valueOf(l.a()));
    long l1;
    if (s.a("android.permission.MOUNT_UNMOUNT_FILESYSTEMS"))
    {
      localObject1 = new StatFs(Environment.getDataDirectory().getPath());
      l1 = ((StatFs)localObject1).getBlockSize();
      l1 = ((StatFs)localObject1).getBlockCount() * l1;
    }
    for (;;)
    {
      ((Map)localObject2).put("totalspace", String.valueOf(l1));
      ((Map)localObject2).put("phonetime", String.valueOf(l2));
      localObject1 = paramContext.getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject1).widthPixels;
      int j = ((DisplayMetrics)localObject1).heightPixels;
      if ((i != 0) || (j != 0))
      {
        localObject1 = String.valueOf(i) + "*" + String.valueOf(j);
        ((Map)localObject2).put("screensize", localObject1);
        ((Map)localObject2).put("sdkvn", "1.7.13");
        localObject1 = m.a(com.baidu.ufosdk.c.a.a((Map)localObject2));
        c.b("## encryptAES:\n" + (String)localObject1);
      }
      try
      {
        localObject1 = "sdk_encrypt=" + URLEncoder.encode((String)localObject1, "UTF-8");
        try
        {
          localObject1 = b.a(str2, (String)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label684;
          }
          Object localObject3 = new JSONObject(m.b((String)localObject1));
          c.a("getAPIKey response is " + ((JSONObject)localObject3).toString());
          if (((Integer)((JSONObject)localObject3).get("errno")).intValue() != 0) {
            break label684;
          }
          localObject1 = ((JSONObject)localObject3).getString("clientid");
          str2 = ((JSONObject)localObject3).getString("appid");
          localObject2 = ((JSONObject)localObject3).getString("devid");
          localObject3 = ((JSONObject)localObject3).getString("product_line");
          SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("UfoSharePreference", 0).edit();
          UfoSDK.clientid = (String)localObject1;
          UfoSDK.appid = str2;
          UfoSDK.devid = (String)localObject2;
          UfoSDK.productid = (String)localObject3;
          localEditor.putString("UfoClientId", (String)localObject1);
          localEditor.putString("UfoAppId", str2);
          localEditor.putString("UfoDevId", (String)localObject2);
          localEditor.putString("UfoProductId", (String)localObject3);
          localEditor.commit();
          paramContext.sendBroadcast(new Intent("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag"));
          if ((UfoSDK.isUninstallFeedback) && (!UfoSDK.hasRegistered)) {
            UfoSDK.hasRegistered = UfoSDK.regUninstalledFeedback();
          }
          return true;
        }
        catch (Exception paramContext)
        {
          String str1;
          c.a("sendRecord fail.", paramContext);
        }
        l1 = -1L;
        continue;
        localObject1 = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          str1 = "";
        }
      }
    }
    label684:
    return false;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 322	com/baidu/ufosdk/a:ax	Ljava/lang/String;
    //   3: astore_2
    //   4: new 53	java/util/HashMap
    //   7: dup
    //   8: invokespecial 56	java/util/HashMap:<init>	()V
    //   11: astore_3
    //   12: aload_3
    //   13: ldc 68
    //   15: getstatic 72	com/baidu/ufosdk/UfoSDK:clientid	Ljava/lang/String;
    //   18: invokeinterface 66 3 0
    //   23: pop
    //   24: aload_3
    //   25: ldc 74
    //   27: getstatic 76	com/baidu/ufosdk/UfoSDK:appid	Ljava/lang/String;
    //   30: invokeinterface 66 3 0
    //   35: pop
    //   36: aload_3
    //   37: ldc 78
    //   39: getstatic 80	com/baidu/ufosdk/UfoSDK:devid	Ljava/lang/String;
    //   42: invokeinterface 66 3 0
    //   47: pop
    //   48: aload_3
    //   49: ldc_w 324
    //   52: getstatic 326	com/baidu/ufosdk/a:b	Ljava/lang/String;
    //   55: invokeinterface 66 3 0
    //   60: pop
    //   61: aload_3
    //   62: ldc_w 328
    //   65: aload_1
    //   66: invokeinterface 66 3 0
    //   71: pop
    //   72: aload_3
    //   73: invokestatic 200	com/baidu/ufosdk/c/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   76: invokestatic 205	com/baidu/ufosdk/util/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_1
    //   80: new 18	java/lang/StringBuilder
    //   83: dup
    //   84: ldc -47
    //   86: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_1
    //   90: ldc -45
    //   92: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_1
    //   102: aload_2
    //   103: aload_1
    //   104: invokestatic 221	com/baidu/ufosdk/e/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_1
    //   108: aload_1
    //   109: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +87 -> 199
    //   115: new 229	org/json/JSONObject
    //   118: dup
    //   119: aload_1
    //   120: invokestatic 231	com/baidu/ufosdk/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   126: ldc -17
    //   128: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   131: checkcast 245	java/lang/Integer
    //   134: invokevirtual 248	java/lang/Integer:intValue	()I
    //   137: ifne +31 -> 168
    //   140: aload_0
    //   141: new 288	android/content/Intent
    //   144: dup
    //   145: ldc_w 290
    //   148: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   151: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 310	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   161: ldc_w 312
    //   164: astore_1
    //   165: goto -63 -> 102
    //   168: aload_0
    //   169: new 288	android/content/Intent
    //   172: dup
    //   173: ldc_w 330
    //   176: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   179: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   182: invokestatic 335	android/os/Looper:prepare	()V
    //   185: aload_0
    //   186: ldc_w 337
    //   189: iconst_1
    //   190: invokestatic 343	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   193: invokevirtual 346	android/widget/Toast:show	()V
    //   196: invokestatic 349	android/os/Looper:loop	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_1
    //   202: ldc_w 314
    //   205: aload_1
    //   206: invokestatic 317	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   209: pop
    //   210: aload_0
    //   211: new 288	android/content/Intent
    //   214: dup
    //   215: ldc_w 330
    //   218: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   221: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   224: invokestatic 335	android/os/Looper:prepare	()V
    //   227: aload_0
    //   228: ldc_w 337
    //   231: iconst_1
    //   232: invokestatic 343	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   235: invokevirtual 346	android/widget/Toast:show	()V
    //   238: invokestatic 349	android/os/Looper:loop	()V
    //   241: goto -42 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	Context
    //   0	244	1	paramString	String
    //   3	100	2	str	String
    //   11	62	3	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   80	102	156	java/io/UnsupportedEncodingException
    //   102	154	201	java/lang/Exception
    //   168	199	201	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 353	com/baidu/ufosdk/a:aq	Ljava/lang/String;
    //   3: astore_3
    //   4: new 18	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 355
    //   11: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 38	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   24: pop
    //   25: new 53	java/util/HashMap
    //   28: dup
    //   29: invokespecial 56	java/util/HashMap:<init>	()V
    //   32: astore 4
    //   34: aload 4
    //   36: ldc 74
    //   38: getstatic 76	com/baidu/ufosdk/UfoSDK:appid	Ljava/lang/String;
    //   41: invokeinterface 66 3 0
    //   46: pop
    //   47: aload 4
    //   49: ldc_w 328
    //   52: aload_0
    //   53: invokeinterface 66 3 0
    //   58: pop
    //   59: aload 4
    //   61: ldc_w 357
    //   64: aload_1
    //   65: invokeinterface 66 3 0
    //   70: pop
    //   71: aload 4
    //   73: invokestatic 200	com/baidu/ufosdk/c/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   76: invokestatic 205	com/baidu/ufosdk/util/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_0
    //   80: new 18	java/lang/StringBuilder
    //   83: dup
    //   84: ldc -47
    //   86: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: ldc -45
    //   92: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_0
    //   102: aload_3
    //   103: aload_0
    //   104: invokestatic 221	com/baidu/ufosdk/e/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +111 -> 223
    //   115: aload_0
    //   116: invokestatic 231	com/baidu/ufosdk/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_0
    //   120: new 18	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 359
    //   127: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 361	com/baidu/ufosdk/util/c:c	(Ljava/lang/String;)I
    //   140: pop
    //   141: new 229	org/json/JSONObject
    //   144: dup
    //   145: aload_0
    //   146: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   149: ldc -17
    //   151: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   154: checkcast 245	java/lang/Integer
    //   157: invokevirtual 248	java/lang/Integer:intValue	()I
    //   160: istore_2
    //   161: iload_2
    //   162: ifne +24 -> 186
    //   165: ldc_w 363
    //   168: invokestatic 366	com/baidu/ufosdk/util/c:d	(Ljava/lang/String;)I
    //   171: pop
    //   172: iconst_1
    //   173: ireturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 310	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   179: ldc_w 312
    //   182: astore_0
    //   183: goto -81 -> 102
    //   186: ldc_w 363
    //   189: invokestatic 366	com/baidu/ufosdk/util/c:d	(Ljava/lang/String;)I
    //   192: pop
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_0
    //   196: ldc_w 314
    //   199: aload_0
    //   200: invokestatic 317	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   203: pop
    //   204: ldc_w 363
    //   207: invokestatic 366	com/baidu/ufosdk/util/c:d	(Ljava/lang/String;)I
    //   210: pop
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_0
    //   214: ldc_w 363
    //   217: invokestatic 366	com/baidu/ufosdk/util/c:d	(Ljava/lang/String;)I
    //   220: pop
    //   221: aload_0
    //   222: athrow
    //   223: ldc_w 363
    //   226: invokestatic 366	com/baidu/ufosdk/util/c:d	(Ljava/lang/String;)I
    //   229: pop
    //   230: goto -19 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramString1	String
    //   0	233	1	paramString2	String
    //   160	2	2	i	int
    //   3	100	3	str	String
    //   32	40	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   80	102	174	java/io/UnsupportedEncodingException
    //   102	161	195	java/lang/Exception
    //   102	161	213	finally
    //   196	204	213	finally
  }
  
  /* Error */
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 369	com/baidu/ufosdk/a:au	Ljava/lang/String;
    //   3: astore_3
    //   4: new 18	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 20
    //   10: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 38	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   23: pop
    //   24: new 53	java/util/HashMap
    //   27: dup
    //   28: invokespecial 56	java/util/HashMap:<init>	()V
    //   31: astore_2
    //   32: aload_2
    //   33: ldc 68
    //   35: getstatic 72	com/baidu/ufosdk/UfoSDK:clientid	Ljava/lang/String;
    //   38: invokeinterface 66 3 0
    //   43: pop
    //   44: aload_2
    //   45: ldc 74
    //   47: getstatic 76	com/baidu/ufosdk/UfoSDK:appid	Ljava/lang/String;
    //   50: invokeinterface 66 3 0
    //   55: pop
    //   56: aload_2
    //   57: ldc 78
    //   59: getstatic 80	com/baidu/ufosdk/UfoSDK:devid	Ljava/lang/String;
    //   62: invokeinterface 66 3 0
    //   67: pop
    //   68: aload_2
    //   69: ldc_w 324
    //   72: getstatic 326	com/baidu/ufosdk/a:b	Ljava/lang/String;
    //   75: invokeinterface 66 3 0
    //   80: pop
    //   81: aload_2
    //   82: invokestatic 200	com/baidu/ufosdk/c/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   85: invokestatic 205	com/baidu/ufosdk/util/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_2
    //   89: new 18	java/lang/StringBuilder
    //   92: dup
    //   93: ldc -47
    //   95: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_2
    //   99: ldc -45
    //   101: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   104: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_2
    //   111: aload_3
    //   112: aload_2
    //   113: invokestatic 221	com/baidu/ufosdk/e/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_2
    //   117: aload_2
    //   118: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifne +505 -> 626
    //   124: aload_2
    //   125: invokestatic 231	com/baidu/ufosdk/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_2
    //   129: new 18	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 371
    //   136: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload_2
    //   140: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   149: pop
    //   150: new 229	org/json/JSONObject
    //   153: dup
    //   154: aload_2
    //   155: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   158: astore 4
    //   160: aload 4
    //   162: ldc -17
    //   164: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   167: checkcast 245	java/lang/Integer
    //   170: invokevirtual 248	java/lang/Integer:intValue	()I
    //   173: istore_1
    //   174: iload_1
    //   175: ifne +426 -> 601
    //   178: ldc_w 373
    //   181: invokestatic 38	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   184: pop
    //   185: new 288	android/content/Intent
    //   188: dup
    //   189: ldc_w 375
    //   192: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   195: astore_2
    //   196: aload 4
    //   198: ldc_w 377
    //   201: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   204: ifle +276 -> 480
    //   207: iconst_0
    //   208: putstatic 383	com/baidu/ufosdk/UfoSDK:neverFeedback	Z
    //   211: aload_0
    //   212: ldc -1
    //   214: iconst_0
    //   215: invokevirtual 259	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   218: invokeinterface 265 1 0
    //   223: astore_3
    //   224: aload_3
    //   225: ldc_w 385
    //   228: iconst_0
    //   229: invokeinterface 389 3 0
    //   234: pop
    //   235: aload_3
    //   236: invokeinterface 286 1 0
    //   241: pop
    //   242: new 391	java/util/ArrayList
    //   245: dup
    //   246: invokespecial 392	java/util/ArrayList:<init>	()V
    //   249: astore_3
    //   250: aload 4
    //   252: ldc_w 394
    //   255: invokevirtual 398	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   258: astore 4
    //   260: iconst_0
    //   261: istore_1
    //   262: iload_1
    //   263: aload 4
    //   265: invokevirtual 403	org/json/JSONArray:length	()I
    //   268: if_icmplt +45 -> 313
    //   271: aload_2
    //   272: ldc_w 405
    //   275: aload_3
    //   276: invokevirtual 409	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   279: pop
    //   280: aload_0
    //   281: aload_2
    //   282: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   285: aload_0
    //   286: new 288	android/content/Intent
    //   289: dup
    //   290: ldc_w 330
    //   293: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   296: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 310	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   306: ldc_w 312
    //   309: astore_2
    //   310: goto -199 -> 111
    //   313: new 18	java/lang/StringBuilder
    //   316: dup
    //   317: ldc_w 411
    //   320: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: iload_1
    //   324: invokevirtual 414	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 416
    //   330: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 4
    //   335: iload_1
    //   336: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   339: invokevirtual 235	org/json/JSONObject:toString	()Ljava/lang/String;
    //   342: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   351: pop
    //   352: new 53	java/util/HashMap
    //   355: dup
    //   356: invokespecial 56	java/util/HashMap:<init>	()V
    //   359: astore 5
    //   361: aload 5
    //   363: ldc_w 328
    //   366: aload 4
    //   368: iload_1
    //   369: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   372: ldc_w 328
    //   375: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   381: pop
    //   382: aload 5
    //   384: ldc_w 423
    //   387: aload 4
    //   389: iload_1
    //   390: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   393: ldc_w 423
    //   396: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   399: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: aload 5
    //   405: ldc_w 425
    //   408: aload 4
    //   410: iload_1
    //   411: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   414: ldc_w 425
    //   417: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   423: pop
    //   424: aload 5
    //   426: ldc_w 427
    //   429: aload 4
    //   431: iload_1
    //   432: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   435: ldc_w 427
    //   438: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   444: pop
    //   445: aload 5
    //   447: ldc_w 429
    //   450: aload 4
    //   452: iload_1
    //   453: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   456: ldc_w 429
    //   459: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   462: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload_3
    //   467: aload 5
    //   469: invokevirtual 433	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   472: pop
    //   473: iload_1
    //   474: iconst_1
    //   475: iadd
    //   476: istore_1
    //   477: goto -215 -> 262
    //   480: iconst_1
    //   481: putstatic 383	com/baidu/ufosdk/UfoSDK:neverFeedback	Z
    //   484: aload_0
    //   485: ldc -1
    //   487: iconst_0
    //   488: invokevirtual 259	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   491: invokeinterface 265 1 0
    //   496: astore_3
    //   497: aload_3
    //   498: ldc_w 385
    //   501: iconst_1
    //   502: invokeinterface 389 3 0
    //   507: pop
    //   508: aload_3
    //   509: invokeinterface 286 1 0
    //   514: pop
    //   515: new 391	java/util/ArrayList
    //   518: dup
    //   519: invokespecial 392	java/util/ArrayList:<init>	()V
    //   522: astore_3
    //   523: new 435	android/os/Bundle
    //   526: dup
    //   527: invokespecial 436	android/os/Bundle:<init>	()V
    //   530: astore 4
    //   532: aload 4
    //   534: ldc_w 405
    //   537: aload_3
    //   538: invokevirtual 440	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   541: aload_2
    //   542: aload 4
    //   544: invokevirtual 444	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   547: pop
    //   548: aload_0
    //   549: aload_2
    //   550: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   553: goto -268 -> 285
    //   556: astore_2
    //   557: ldc_w 314
    //   560: aload_2
    //   561: invokestatic 317	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   564: pop
    //   565: invokestatic 335	android/os/Looper:prepare	()V
    //   568: aload_0
    //   569: new 288	android/content/Intent
    //   572: dup
    //   573: ldc_w 446
    //   576: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   579: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   582: invokestatic 349	android/os/Looper:loop	()V
    //   585: aload_0
    //   586: new 288	android/content/Intent
    //   589: dup
    //   590: ldc_w 330
    //   593: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   596: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   599: iconst_0
    //   600: ireturn
    //   601: iload_1
    //   602: ifeq +24 -> 626
    //   605: ldc_w 448
    //   608: invokestatic 38	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   611: pop
    //   612: aload_0
    //   613: new 288	android/content/Intent
    //   616: dup
    //   617: ldc_w 446
    //   620: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   623: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   626: aload_0
    //   627: new 288	android/content/Intent
    //   630: dup
    //   631: ldc_w 330
    //   634: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   637: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   640: goto -41 -> 599
    //   643: astore_2
    //   644: aload_0
    //   645: new 288	android/content/Intent
    //   648: dup
    //   649: ldc_w 330
    //   652: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   655: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   658: aload_2
    //   659: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	paramContext	Context
    //   173	429	1	i	int
    //   31	251	2	localObject1	Object
    //   301	2	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   309	241	2	str	String
    //   556	5	2	localException	Exception
    //   643	16	2	localObject2	Object
    //   3	535	3	localObject3	Object
    //   158	385	4	localObject4	Object
    //   359	109	5	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   89	111	301	java/io/UnsupportedEncodingException
    //   111	174	556	java/lang/Exception
    //   178	260	556	java/lang/Exception
    //   262	285	556	java/lang/Exception
    //   313	473	556	java/lang/Exception
    //   480	553	556	java/lang/Exception
    //   605	626	556	java/lang/Exception
    //   111	174	643	finally
    //   178	260	643	finally
    //   262	285	643	finally
    //   313	473	643	finally
    //   480	553	643	finally
    //   557	585	643	finally
    //   605	626	643	finally
  }
  
  /* Error */
  public static boolean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 451	com/baidu/ufosdk/a:ap	Ljava/lang/String;
    //   3: astore 4
    //   5: new 53	java/util/HashMap
    //   8: dup
    //   9: invokespecial 56	java/util/HashMap:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 74
    //   16: getstatic 76	com/baidu/ufosdk/UfoSDK:appid	Ljava/lang/String;
    //   19: invokeinterface 66 3 0
    //   24: pop
    //   25: aload_3
    //   26: ldc 94
    //   28: invokestatic 97	com/baidu/ufosdk/b/d:c	()Ljava/lang/String;
    //   31: invokeinterface 66 3 0
    //   36: pop
    //   37: aload_3
    //   38: ldc_w 453
    //   41: getstatic 455	com/baidu/ufosdk/a:c	Ljava/lang/String;
    //   44: invokeinterface 66 3 0
    //   49: pop
    //   50: aload_3
    //   51: ldc 68
    //   53: getstatic 72	com/baidu/ufosdk/UfoSDK:clientid	Ljava/lang/String;
    //   56: invokeinterface 66 3 0
    //   61: pop
    //   62: aload_3
    //   63: ldc 78
    //   65: getstatic 80	com/baidu/ufosdk/UfoSDK:devid	Ljava/lang/String;
    //   68: invokeinterface 66 3 0
    //   73: pop
    //   74: aload_3
    //   75: ldc_w 457
    //   78: getstatic 459	com/baidu/ufosdk/a:d	Ljava/lang/String;
    //   81: invokeinterface 66 3 0
    //   86: pop
    //   87: aload_3
    //   88: ldc_w 328
    //   91: aload_1
    //   92: invokeinterface 66 3 0
    //   97: pop
    //   98: aload_3
    //   99: ldc_w 461
    //   102: getstatic 464	com/baidu/ufosdk/a:an	I
    //   105: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   108: invokeinterface 66 3 0
    //   113: pop
    //   114: aload_3
    //   115: ldc 106
    //   117: getstatic 109	android/os/Build:MODEL	Ljava/lang/String;
    //   120: invokeinterface 66 3 0
    //   125: pop
    //   126: aload_3
    //   127: ldc 58
    //   129: ldc 60
    //   131: invokeinterface 66 3 0
    //   136: pop
    //   137: aload_3
    //   138: ldc -63
    //   140: invokestatic 97	com/baidu/ufosdk/b/d:c	()Ljava/lang/String;
    //   143: invokeinterface 66 3 0
    //   148: pop
    //   149: aload_3
    //   150: ldc_w 324
    //   153: getstatic 326	com/baidu/ufosdk/a:b	Ljava/lang/String;
    //   156: invokeinterface 66 3 0
    //   161: pop
    //   162: aload_3
    //   163: invokestatic 200	com/baidu/ufosdk/c/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   166: invokestatic 205	com/baidu/ufosdk/util/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore_3
    //   170: new 18	java/lang/StringBuilder
    //   173: dup
    //   174: ldc -47
    //   176: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: aload_3
    //   180: ldc -45
    //   182: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_3
    //   192: aload 4
    //   194: aload_3
    //   195: invokestatic 221	com/baidu/ufosdk/e/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   198: astore_3
    //   199: aload_3
    //   200: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifne +407 -> 610
    //   206: aload_3
    //   207: invokestatic 231	com/baidu/ufosdk/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   210: astore_3
    //   211: new 18	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 371
    //   218: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_3
    //   222: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   231: pop
    //   232: new 229	org/json/JSONObject
    //   235: dup
    //   236: aload_3
    //   237: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   240: astore_3
    //   241: aload_3
    //   242: ldc -17
    //   244: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   247: checkcast 245	java/lang/Integer
    //   250: invokevirtual 248	java/lang/Integer:intValue	()I
    //   253: istore_2
    //   254: iload_2
    //   255: ifne +337 -> 592
    //   258: new 391	java/util/ArrayList
    //   261: dup
    //   262: invokespecial 392	java/util/ArrayList:<init>	()V
    //   265: astore 4
    //   267: new 288	android/content/Intent
    //   270: dup
    //   271: ldc_w 466
    //   274: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   277: astore 5
    //   279: aload_3
    //   280: ldc_w 377
    //   283: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   286: ifle +53 -> 339
    //   289: aload_3
    //   290: ldc_w 394
    //   293: invokevirtual 398	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   296: astore 6
    //   298: iconst_0
    //   299: istore_2
    //   300: iload_2
    //   301: aload 6
    //   303: invokevirtual 403	org/json/JSONArray:length	()I
    //   306: if_icmplt +61 -> 367
    //   309: new 435	android/os/Bundle
    //   312: dup
    //   313: invokespecial 436	android/os/Bundle:<init>	()V
    //   316: astore_1
    //   317: aload_1
    //   318: ldc_w 405
    //   321: aload 4
    //   323: invokevirtual 440	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   326: aload 5
    //   328: aload_1
    //   329: invokevirtual 444	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   332: pop
    //   333: aload_0
    //   334: aload 5
    //   336: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   339: aload_0
    //   340: new 288	android/content/Intent
    //   343: dup
    //   344: ldc_w 330
    //   347: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   350: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   353: iconst_1
    //   354: ireturn
    //   355: astore_3
    //   356: aload_3
    //   357: invokevirtual 310	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   360: ldc_w 312
    //   363: astore_3
    //   364: goto -172 -> 192
    //   367: new 53	java/util/HashMap
    //   370: dup
    //   371: invokespecial 56	java/util/HashMap:<init>	()V
    //   374: astore 7
    //   376: aload 7
    //   378: ldc_w 328
    //   381: aload_1
    //   382: invokeinterface 66 3 0
    //   387: pop
    //   388: new 229	org/json/JSONObject
    //   391: dup
    //   392: aload 6
    //   394: iload_2
    //   395: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   398: ldc_w 457
    //   401: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   407: astore_3
    //   408: aload_3
    //   409: ldc_w 468
    //   412: invokevirtual 471	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   415: ifeq +229 -> 644
    //   418: aload_3
    //   419: ldc_w 468
    //   422: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   425: astore_3
    //   426: aload_3
    //   427: invokevirtual 472	java/lang/String:length	()I
    //   430: ifeq +27 -> 457
    //   433: aload_3
    //   434: ldc_w 312
    //   437: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   440: ifne +17 -> 457
    //   443: aload_3
    //   444: ldc_w 477
    //   447: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   450: ifne +7 -> 457
    //   453: aload_3
    //   454: ifnonnull +78 -> 532
    //   457: aload 7
    //   459: ldc_w 423
    //   462: aload 6
    //   464: iload_2
    //   465: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   468: ldc_w 423
    //   471: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   474: invokeinterface 66 3 0
    //   479: pop
    //   480: aload 7
    //   482: ldc_w 479
    //   485: ldc_w 481
    //   488: invokeinterface 66 3 0
    //   493: pop
    //   494: aload 7
    //   496: ldc_w 425
    //   499: aload 6
    //   501: iload_2
    //   502: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   505: ldc_w 425
    //   508: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   511: invokeinterface 66 3 0
    //   516: pop
    //   517: aload 4
    //   519: aload 7
    //   521: invokevirtual 433	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   524: pop
    //   525: iload_2
    //   526: iconst_1
    //   527: iadd
    //   528: istore_2
    //   529: goto -229 -> 300
    //   532: aload 7
    //   534: ldc_w 423
    //   537: aload_3
    //   538: invokeinterface 66 3 0
    //   543: pop
    //   544: goto -64 -> 480
    //   547: astore_1
    //   548: ldc_w 314
    //   551: aload_1
    //   552: invokestatic 317	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   555: pop
    //   556: invokestatic 335	android/os/Looper:prepare	()V
    //   559: aload_0
    //   560: new 288	android/content/Intent
    //   563: dup
    //   564: ldc_w 446
    //   567: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   570: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   573: invokestatic 349	android/os/Looper:loop	()V
    //   576: aload_0
    //   577: new 288	android/content/Intent
    //   580: dup
    //   581: ldc_w 330
    //   584: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   587: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   590: iconst_0
    //   591: ireturn
    //   592: iload_2
    //   593: ifeq +17 -> 610
    //   596: aload_0
    //   597: new 288	android/content/Intent
    //   600: dup
    //   601: ldc_w 446
    //   604: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   607: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   610: aload_0
    //   611: new 288	android/content/Intent
    //   614: dup
    //   615: ldc_w 330
    //   618: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   621: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   624: goto -34 -> 590
    //   627: astore_1
    //   628: aload_0
    //   629: new 288	android/content/Intent
    //   632: dup
    //   633: ldc_w 330
    //   636: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   639: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   642: aload_1
    //   643: athrow
    //   644: ldc_w 312
    //   647: astore_3
    //   648: goto -222 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	paramContext	Context
    //   0	651	1	paramString	String
    //   253	340	2	i	int
    //   12	278	3	localObject1	Object
    //   355	2	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   363	285	3	localObject2	Object
    //   3	515	4	localObject3	Object
    //   277	58	5	localIntent	Intent
    //   296	204	6	localJSONArray	org.json.JSONArray
    //   374	159	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   170	192	355	java/io/UnsupportedEncodingException
    //   192	254	547	java/lang/Exception
    //   258	298	547	java/lang/Exception
    //   300	339	547	java/lang/Exception
    //   367	426	547	java/lang/Exception
    //   426	453	547	java/lang/Exception
    //   457	480	547	java/lang/Exception
    //   480	525	547	java/lang/Exception
    //   532	544	547	java/lang/Exception
    //   596	610	547	java/lang/Exception
    //   192	254	627	finally
    //   258	298	627	finally
    //   300	339	627	finally
    //   367	426	627	finally
    //   426	453	627	finally
    //   457	480	627	finally
    //   480	525	627	finally
    //   532	544	627	finally
    //   548	576	627	finally
    //   596	610	627	finally
  }
  
  public static String c(Context paramContext)
  {
    String str2 = com.baidu.ufosdk.a.av;
    c.b("postUrl is " + str2);
    Object localObject = new HashMap();
    ((Map)localObject).put("clientid", UfoSDK.clientid);
    ((Map)localObject).put("appid", UfoSDK.appid);
    ((Map)localObject).put("devid", UfoSDK.devid);
    ((Map)localObject).put("uid", com.baidu.ufosdk.a.b);
    ((Map)localObject).put("interval", String.valueOf(com.baidu.ufosdk.a.ao));
    localObject = m.a(com.baidu.ufosdk.c.a.a((Map)localObject));
    try
    {
      localObject = "sdk_encrypt=" + URLEncoder.encode((String)localObject, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        try
        {
          localObject = b.a(str2, (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          localObject = m.b((String)localObject);
          c.a("response is " + (String)localObject);
          localObject = new JSONObject((String)localObject);
          c.a("response is " + ((JSONObject)localObject).toString());
          if (((Integer)((JSONObject)localObject).get("errno")).intValue() != 0) {
            break;
          }
          if (((Integer)((JSONObject)localObject).get("newmsg")).intValue() > 0) {
            paramContext.sendBroadcast(new Intent("com.baidu.ufosdk.getnewhistoryflag"));
          }
          if (((Integer)((JSONObject)localObject).get("update")).intValue() == 1) {
            com.baidu.ufosdk.a.ao = ((Integer)((JSONObject)localObject).get("interval")).intValue();
          }
          paramContext = String.valueOf(((JSONObject)localObject).get("newmsg"));
          return paramContext;
        }
        catch (Exception paramContext)
        {
          String str1;
          c.a("sendRecord fail.", paramContext);
        }
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
        str1 = "";
      }
    }
    return null;
  }
  
  /* Error */
  public static boolean c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 451	com/baidu/ufosdk/a:ap	Ljava/lang/String;
    //   3: astore 4
    //   5: new 18	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 20
    //   11: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload 4
    //   16: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 38	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   25: pop
    //   26: new 53	java/util/HashMap
    //   29: dup
    //   30: invokespecial 56	java/util/HashMap:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 68
    //   37: getstatic 72	com/baidu/ufosdk/UfoSDK:clientid	Ljava/lang/String;
    //   40: invokeinterface 66 3 0
    //   45: pop
    //   46: aload_3
    //   47: ldc 74
    //   49: getstatic 76	com/baidu/ufosdk/UfoSDK:appid	Ljava/lang/String;
    //   52: invokeinterface 66 3 0
    //   57: pop
    //   58: aload_3
    //   59: ldc 78
    //   61: getstatic 80	com/baidu/ufosdk/UfoSDK:devid	Ljava/lang/String;
    //   64: invokeinterface 66 3 0
    //   69: pop
    //   70: aload_3
    //   71: ldc_w 494
    //   74: aload_1
    //   75: invokeinterface 66 3 0
    //   80: pop
    //   81: aload_3
    //   82: ldc_w 461
    //   85: getstatic 464	com/baidu/ufosdk/a:an	I
    //   88: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   91: invokeinterface 66 3 0
    //   96: pop
    //   97: aload_3
    //   98: invokestatic 200	com/baidu/ufosdk/c/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   101: invokestatic 205	com/baidu/ufosdk/util/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: new 18	java/lang/StringBuilder
    //   108: dup
    //   109: ldc -47
    //   111: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_3
    //   115: ldc -45
    //   117: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: aload 4
    //   129: aload_3
    //   130: invokestatic 221	com/baidu/ufosdk/e/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: aload_3
    //   135: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +615 -> 753
    //   141: aload_3
    //   142: invokestatic 231	com/baidu/ufosdk/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore_3
    //   146: new 18	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 496
    //   153: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: aload_3
    //   157: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   166: pop
    //   167: new 229	org/json/JSONObject
    //   170: dup
    //   171: aload_3
    //   172: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: astore 4
    //   177: aload 4
    //   179: ldc -17
    //   181: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   184: checkcast 245	java/lang/Integer
    //   187: invokevirtual 248	java/lang/Integer:intValue	()I
    //   190: istore_2
    //   191: iload_2
    //   192: ifne +543 -> 735
    //   195: new 391	java/util/ArrayList
    //   198: dup
    //   199: invokespecial 392	java/util/ArrayList:<init>	()V
    //   202: astore 5
    //   204: new 288	android/content/Intent
    //   207: dup
    //   208: ldc_w 466
    //   211: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   214: astore 6
    //   216: aload 4
    //   218: ldc_w 377
    //   221: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   224: ifle +54 -> 278
    //   227: aload 4
    //   229: ldc_w 394
    //   232: invokevirtual 398	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   235: astore 7
    //   237: iconst_0
    //   238: istore_2
    //   239: iload_2
    //   240: aload 7
    //   242: invokevirtual 403	org/json/JSONArray:length	()I
    //   245: if_icmplt +96 -> 341
    //   248: new 435	android/os/Bundle
    //   251: dup
    //   252: invokespecial 436	android/os/Bundle:<init>	()V
    //   255: astore_1
    //   256: aload_1
    //   257: ldc_w 405
    //   260: aload 5
    //   262: invokevirtual 440	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   265: aload 6
    //   267: aload_1
    //   268: invokevirtual 444	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   271: pop
    //   272: aload_0
    //   273: aload 6
    //   275: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   278: aload 4
    //   280: ldc_w 492
    //   283: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   286: checkcast 245	java/lang/Integer
    //   289: invokevirtual 248	java/lang/Integer:intValue	()I
    //   292: iconst_1
    //   293: if_icmpne +20 -> 313
    //   296: aload 4
    //   298: ldc_w 461
    //   301: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   304: checkcast 245	java/lang/Integer
    //   307: invokevirtual 248	java/lang/Integer:intValue	()I
    //   310: putstatic 464	com/baidu/ufosdk/a:an	I
    //   313: aload_0
    //   314: new 288	android/content/Intent
    //   317: dup
    //   318: ldc_w 330
    //   321: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   324: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   327: iconst_1
    //   328: ireturn
    //   329: astore_3
    //   330: aload_3
    //   331: invokevirtual 310	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   334: ldc_w 312
    //   337: astore_3
    //   338: goto -211 -> 127
    //   341: new 53	java/util/HashMap
    //   344: dup
    //   345: invokespecial 56	java/util/HashMap:<init>	()V
    //   348: astore 8
    //   350: aload 8
    //   352: ldc_w 328
    //   355: aload_1
    //   356: invokeinterface 66 3 0
    //   361: pop
    //   362: aload 7
    //   364: iload_2
    //   365: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   368: ldc_w 457
    //   371: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore_3
    //   375: aload_3
    //   376: invokevirtual 472	java/lang/String:length	()I
    //   379: ifeq +7 -> 386
    //   382: aload_3
    //   383: ifnonnull +122 -> 505
    //   386: aload 8
    //   388: ldc_w 423
    //   391: new 18	java/lang/StringBuilder
    //   394: dup
    //   395: aload 7
    //   397: iload_2
    //   398: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   401: ldc_w 423
    //   404: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   407: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   410: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   413: ldc_w 498
    //   416: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokeinterface 66 3 0
    //   427: pop
    //   428: aload 8
    //   430: ldc_w 479
    //   433: ldc_w 500
    //   436: invokeinterface 66 3 0
    //   441: pop
    //   442: aload 8
    //   444: ldc_w 425
    //   447: aload 7
    //   449: iload_2
    //   450: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   453: ldc_w 425
    //   456: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   459: invokeinterface 66 3 0
    //   464: pop
    //   465: aload 5
    //   467: aload 8
    //   469: invokevirtual 433	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   472: pop
    //   473: new 18	java/lang/StringBuilder
    //   476: dup
    //   477: ldc_w 502
    //   480: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: aload 5
    //   485: invokevirtual 503	java/util/ArrayList:toString	()Ljava/lang/String;
    //   488: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   497: pop
    //   498: iload_2
    //   499: iconst_1
    //   500: iadd
    //   501: istore_2
    //   502: goto -263 -> 239
    //   505: new 229	org/json/JSONObject
    //   508: dup
    //   509: aload 7
    //   511: iload_2
    //   512: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   515: ldc_w 457
    //   518: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   521: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   524: astore_3
    //   525: aload_3
    //   526: ldc_w 468
    //   529: invokevirtual 471	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   532: ifeq +127 -> 659
    //   535: aload_3
    //   536: ldc_w 468
    //   539: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   542: astore_3
    //   543: aload_3
    //   544: invokevirtual 472	java/lang/String:length	()I
    //   547: ifeq +27 -> 574
    //   550: aload_3
    //   551: ldc_w 312
    //   554: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   557: ifne +17 -> 574
    //   560: aload_3
    //   561: ldc_w 477
    //   564: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifne +7 -> 574
    //   570: aload_3
    //   571: ifnonnull +95 -> 666
    //   574: aload 8
    //   576: ldc_w 423
    //   579: aload 7
    //   581: iload_2
    //   582: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   585: ldc_w 423
    //   588: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokeinterface 66 3 0
    //   596: pop
    //   597: aload 8
    //   599: ldc_w 479
    //   602: ldc_w 500
    //   605: invokeinterface 66 3 0
    //   610: pop
    //   611: goto -169 -> 442
    //   614: astore_1
    //   615: ldc_w 314
    //   618: aload_1
    //   619: invokestatic 317	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   622: pop
    //   623: invokestatic 335	android/os/Looper:prepare	()V
    //   626: aload_0
    //   627: new 288	android/content/Intent
    //   630: dup
    //   631: ldc_w 446
    //   634: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   637: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   640: invokestatic 349	android/os/Looper:loop	()V
    //   643: aload_0
    //   644: new 288	android/content/Intent
    //   647: dup
    //   648: ldc_w 330
    //   651: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   654: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   657: iconst_0
    //   658: ireturn
    //   659: ldc_w 312
    //   662: astore_3
    //   663: goto -120 -> 543
    //   666: aload 8
    //   668: ldc_w 423
    //   671: aload_3
    //   672: invokeinterface 66 3 0
    //   677: pop
    //   678: getstatic 506	com/baidu/ufosdk/UfoSDK:robotAnswer	Z
    //   681: ifeq +37 -> 718
    //   684: aload 8
    //   686: ldc_w 479
    //   689: ldc_w 481
    //   692: invokeinterface 66 3 0
    //   697: pop
    //   698: goto -256 -> 442
    //   701: astore_1
    //   702: aload_0
    //   703: new 288	android/content/Intent
    //   706: dup
    //   707: ldc_w 330
    //   710: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   713: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   716: aload_1
    //   717: athrow
    //   718: aload 8
    //   720: ldc_w 479
    //   723: ldc_w 500
    //   726: invokeinterface 66 3 0
    //   731: pop
    //   732: goto -290 -> 442
    //   735: iload_2
    //   736: ifeq +17 -> 753
    //   739: aload_0
    //   740: new 288	android/content/Intent
    //   743: dup
    //   744: ldc_w 446
    //   747: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   750: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   753: aload_0
    //   754: new 288	android/content/Intent
    //   757: dup
    //   758: ldc_w 330
    //   761: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   764: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   767: goto -110 -> 657
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	paramContext	Context
    //   0	770	1	paramString	String
    //   190	546	2	i	int
    //   33	139	3	localObject1	Object
    //   329	2	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   337	335	3	localObject2	Object
    //   3	294	4	localObject3	Object
    //   202	282	5	localArrayList	java.util.ArrayList
    //   214	60	6	localIntent	Intent
    //   235	345	7	localJSONArray	org.json.JSONArray
    //   348	371	8	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   105	127	329	java/io/UnsupportedEncodingException
    //   127	191	614	java/lang/Exception
    //   195	237	614	java/lang/Exception
    //   239	278	614	java/lang/Exception
    //   278	313	614	java/lang/Exception
    //   341	382	614	java/lang/Exception
    //   386	442	614	java/lang/Exception
    //   442	498	614	java/lang/Exception
    //   505	543	614	java/lang/Exception
    //   543	570	614	java/lang/Exception
    //   574	611	614	java/lang/Exception
    //   666	698	614	java/lang/Exception
    //   718	732	614	java/lang/Exception
    //   739	753	614	java/lang/Exception
    //   127	191	701	finally
    //   195	237	701	finally
    //   239	278	701	finally
    //   278	313	701	finally
    //   341	382	701	finally
    //   386	442	701	finally
    //   442	498	701	finally
    //   505	543	701	finally
    //   543	570	701	finally
    //   574	611	701	finally
    //   615	643	701	finally
    //   666	698	701	finally
    //   718	732	701	finally
    //   739	753	701	finally
  }
  
  /* Error */
  public static boolean d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 451	com/baidu/ufosdk/a:ap	Ljava/lang/String;
    //   3: astore 4
    //   5: new 18	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 20
    //   11: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload 4
    //   16: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 38	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   25: pop
    //   26: new 53	java/util/HashMap
    //   29: dup
    //   30: invokespecial 56	java/util/HashMap:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 68
    //   37: getstatic 72	com/baidu/ufosdk/UfoSDK:clientid	Ljava/lang/String;
    //   40: invokeinterface 66 3 0
    //   45: pop
    //   46: aload_3
    //   47: ldc 74
    //   49: getstatic 76	com/baidu/ufosdk/UfoSDK:appid	Ljava/lang/String;
    //   52: invokeinterface 66 3 0
    //   57: pop
    //   58: aload_3
    //   59: ldc 78
    //   61: getstatic 80	com/baidu/ufosdk/UfoSDK:devid	Ljava/lang/String;
    //   64: invokeinterface 66 3 0
    //   69: pop
    //   70: aload_3
    //   71: ldc_w 494
    //   74: aload_1
    //   75: invokeinterface 66 3 0
    //   80: pop
    //   81: aload_3
    //   82: ldc_w 461
    //   85: getstatic 464	com/baidu/ufosdk/a:an	I
    //   88: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   91: invokeinterface 66 3 0
    //   96: pop
    //   97: aload_3
    //   98: invokestatic 200	com/baidu/ufosdk/c/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   101: invokestatic 205	com/baidu/ufosdk/util/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: new 18	java/lang/StringBuilder
    //   108: dup
    //   109: ldc -47
    //   111: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_3
    //   115: ldc -45
    //   117: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: aload 4
    //   129: aload_3
    //   130: invokestatic 221	com/baidu/ufosdk/e/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: aload_3
    //   135: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +582 -> 720
    //   141: aload_3
    //   142: invokestatic 231	com/baidu/ufosdk/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore_3
    //   146: new 18	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 371
    //   153: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: aload_3
    //   157: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   166: pop
    //   167: new 229	org/json/JSONObject
    //   170: dup
    //   171: aload_3
    //   172: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: astore 4
    //   177: aload 4
    //   179: ldc -17
    //   181: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   184: checkcast 245	java/lang/Integer
    //   187: invokevirtual 248	java/lang/Integer:intValue	()I
    //   190: istore_2
    //   191: iload_2
    //   192: ifne +510 -> 702
    //   195: new 391	java/util/ArrayList
    //   198: dup
    //   199: invokespecial 392	java/util/ArrayList:<init>	()V
    //   202: astore 5
    //   204: new 288	android/content/Intent
    //   207: dup
    //   208: ldc_w 466
    //   211: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   214: astore 6
    //   216: aload 4
    //   218: ldc_w 377
    //   221: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   224: ifle +54 -> 278
    //   227: aload 4
    //   229: ldc_w 394
    //   232: invokevirtual 398	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   235: astore 7
    //   237: iconst_0
    //   238: istore_2
    //   239: iload_2
    //   240: aload 7
    //   242: invokevirtual 403	org/json/JSONArray:length	()I
    //   245: if_icmplt +96 -> 341
    //   248: new 435	android/os/Bundle
    //   251: dup
    //   252: invokespecial 436	android/os/Bundle:<init>	()V
    //   255: astore_1
    //   256: aload_1
    //   257: ldc_w 405
    //   260: aload 5
    //   262: invokevirtual 440	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   265: aload 6
    //   267: aload_1
    //   268: invokevirtual 444	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   271: pop
    //   272: aload_0
    //   273: aload 6
    //   275: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   278: aload 4
    //   280: ldc_w 492
    //   283: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   286: checkcast 245	java/lang/Integer
    //   289: invokevirtual 248	java/lang/Integer:intValue	()I
    //   292: iconst_1
    //   293: if_icmpne +20 -> 313
    //   296: aload 4
    //   298: ldc_w 461
    //   301: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   304: checkcast 245	java/lang/Integer
    //   307: invokevirtual 248	java/lang/Integer:intValue	()I
    //   310: putstatic 464	com/baidu/ufosdk/a:an	I
    //   313: aload_0
    //   314: new 288	android/content/Intent
    //   317: dup
    //   318: ldc_w 330
    //   321: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   324: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   327: iconst_1
    //   328: ireturn
    //   329: astore_3
    //   330: aload_3
    //   331: invokevirtual 310	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   334: ldc_w 312
    //   337: astore_3
    //   338: goto -211 -> 127
    //   341: new 53	java/util/HashMap
    //   344: dup
    //   345: invokespecial 56	java/util/HashMap:<init>	()V
    //   348: astore 8
    //   350: aload 8
    //   352: ldc_w 328
    //   355: aload_1
    //   356: invokeinterface 66 3 0
    //   361: pop
    //   362: aload 7
    //   364: iload_2
    //   365: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   368: ldc_w 457
    //   371: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore_3
    //   375: aload_3
    //   376: invokevirtual 472	java/lang/String:length	()I
    //   379: ifeq +7 -> 386
    //   382: aload_3
    //   383: ifnonnull +171 -> 554
    //   386: aload 8
    //   388: ldc_w 423
    //   391: aload 7
    //   393: iload_2
    //   394: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   397: ldc_w 423
    //   400: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   403: invokeinterface 66 3 0
    //   408: pop
    //   409: getstatic 506	com/baidu/ufosdk/UfoSDK:robotAnswer	Z
    //   412: ifeq +80 -> 492
    //   415: aload 8
    //   417: ldc_w 479
    //   420: ldc_w 481
    //   423: invokeinterface 66 3 0
    //   428: pop
    //   429: aload 8
    //   431: ldc_w 425
    //   434: aload 7
    //   436: iload_2
    //   437: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   440: ldc_w 425
    //   443: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokeinterface 66 3 0
    //   451: pop
    //   452: aload 5
    //   454: aload 8
    //   456: invokevirtual 433	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   459: pop
    //   460: new 18	java/lang/StringBuilder
    //   463: dup
    //   464: ldc_w 508
    //   467: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: aload 5
    //   472: invokevirtual 503	java/util/ArrayList:toString	()Ljava/lang/String;
    //   475: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   484: pop
    //   485: iload_2
    //   486: iconst_1
    //   487: iadd
    //   488: istore_2
    //   489: goto -250 -> 239
    //   492: aload 8
    //   494: ldc_w 479
    //   497: ldc_w 500
    //   500: invokeinterface 66 3 0
    //   505: pop
    //   506: goto -77 -> 429
    //   509: astore_1
    //   510: ldc_w 314
    //   513: aload_1
    //   514: invokestatic 317	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   517: pop
    //   518: invokestatic 335	android/os/Looper:prepare	()V
    //   521: aload_0
    //   522: new 288	android/content/Intent
    //   525: dup
    //   526: ldc_w 446
    //   529: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   532: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   535: invokestatic 349	android/os/Looper:loop	()V
    //   538: aload_0
    //   539: new 288	android/content/Intent
    //   542: dup
    //   543: ldc_w 330
    //   546: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   549: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   552: iconst_0
    //   553: ireturn
    //   554: new 229	org/json/JSONObject
    //   557: dup
    //   558: aload 7
    //   560: iload_2
    //   561: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   564: ldc_w 457
    //   567: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   573: astore_3
    //   574: aload_3
    //   575: ldc_w 468
    //   578: invokevirtual 471	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +99 -> 680
    //   584: aload_3
    //   585: ldc_w 468
    //   588: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   591: astore_3
    //   592: aload_3
    //   593: invokevirtual 472	java/lang/String:length	()I
    //   596: ifeq +27 -> 623
    //   599: aload_3
    //   600: ldc_w 312
    //   603: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   606: ifne +17 -> 623
    //   609: aload_3
    //   610: ldc_w 477
    //   613: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   616: ifne +7 -> 623
    //   619: aload_3
    //   620: ifnonnull +67 -> 687
    //   623: aload 8
    //   625: ldc_w 423
    //   628: aload 7
    //   630: iload_2
    //   631: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   634: ldc_w 423
    //   637: invokevirtual 251	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   640: invokeinterface 66 3 0
    //   645: pop
    //   646: aload 8
    //   648: ldc_w 479
    //   651: ldc_w 500
    //   654: invokeinterface 66 3 0
    //   659: pop
    //   660: goto -231 -> 429
    //   663: astore_1
    //   664: aload_0
    //   665: new 288	android/content/Intent
    //   668: dup
    //   669: ldc_w 330
    //   672: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   675: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   678: aload_1
    //   679: athrow
    //   680: ldc_w 312
    //   683: astore_3
    //   684: goto -92 -> 592
    //   687: aload 8
    //   689: ldc_w 423
    //   692: aload_3
    //   693: invokeinterface 66 3 0
    //   698: pop
    //   699: goto -270 -> 429
    //   702: iload_2
    //   703: ifeq +17 -> 720
    //   706: aload_0
    //   707: new 288	android/content/Intent
    //   710: dup
    //   711: ldc_w 446
    //   714: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   717: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   720: aload_0
    //   721: new 288	android/content/Intent
    //   724: dup
    //   725: ldc_w 330
    //   728: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   731: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   734: goto -182 -> 552
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	737	0	paramContext	Context
    //   0	737	1	paramString	String
    //   190	513	2	i	int
    //   33	139	3	localObject1	Object
    //   329	2	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   337	356	3	localObject2	Object
    //   3	294	4	localObject3	Object
    //   202	269	5	localArrayList	java.util.ArrayList
    //   214	60	6	localIntent	Intent
    //   235	394	7	localJSONArray	org.json.JSONArray
    //   348	340	8	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   105	127	329	java/io/UnsupportedEncodingException
    //   127	191	509	java/lang/Exception
    //   195	237	509	java/lang/Exception
    //   239	278	509	java/lang/Exception
    //   278	313	509	java/lang/Exception
    //   341	382	509	java/lang/Exception
    //   386	429	509	java/lang/Exception
    //   429	485	509	java/lang/Exception
    //   492	506	509	java/lang/Exception
    //   554	592	509	java/lang/Exception
    //   592	619	509	java/lang/Exception
    //   623	660	509	java/lang/Exception
    //   687	699	509	java/lang/Exception
    //   706	720	509	java/lang/Exception
    //   127	191	663	finally
    //   195	237	663	finally
    //   239	278	663	finally
    //   278	313	663	finally
    //   341	382	663	finally
    //   386	429	663	finally
    //   429	485	663	finally
    //   492	506	663	finally
    //   510	538	663	finally
    //   554	592	663	finally
    //   592	619	663	finally
    //   623	660	663	finally
    //   687	699	663	finally
    //   706	720	663	finally
  }
  
  /* Error */
  public static String e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 513	com/baidu/ufosdk/a:ar	Ljava/lang/String;
    //   3: astore_3
    //   4: new 18	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 20
    //   10: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 38	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   23: pop
    //   24: new 53	java/util/HashMap
    //   27: dup
    //   28: invokespecial 56	java/util/HashMap:<init>	()V
    //   31: astore 4
    //   33: aload 4
    //   35: ldc 68
    //   37: getstatic 72	com/baidu/ufosdk/UfoSDK:clientid	Ljava/lang/String;
    //   40: invokeinterface 66 3 0
    //   45: pop
    //   46: aload 4
    //   48: ldc 74
    //   50: getstatic 76	com/baidu/ufosdk/UfoSDK:appid	Ljava/lang/String;
    //   53: invokeinterface 66 3 0
    //   58: pop
    //   59: aload 4
    //   61: ldc 78
    //   63: getstatic 80	com/baidu/ufosdk/UfoSDK:devid	Ljava/lang/String;
    //   66: invokeinterface 66 3 0
    //   71: pop
    //   72: aload 4
    //   74: ldc_w 328
    //   77: aload_1
    //   78: invokeinterface 66 3 0
    //   83: pop
    //   84: aload 4
    //   86: invokestatic 200	com/baidu/ufosdk/c/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   89: invokestatic 205	com/baidu/ufosdk/util/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: new 18	java/lang/StringBuilder
    //   96: dup
    //   97: ldc -47
    //   99: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc -45
    //   105: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore_1
    //   115: aload_3
    //   116: aload_1
    //   117: invokestatic 221	com/baidu/ufosdk/e/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: astore_1
    //   121: aload_1
    //   122: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +108 -> 233
    //   128: aload_1
    //   129: invokestatic 231	com/baidu/ufosdk/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore_1
    //   133: new 18	java/lang/StringBuilder
    //   136: dup
    //   137: ldc_w 371
    //   140: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 237	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   153: pop
    //   154: new 229	org/json/JSONObject
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 232	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   162: astore_1
    //   163: aload_1
    //   164: ldc -17
    //   166: invokevirtual 243	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   169: checkcast 245	java/lang/Integer
    //   172: invokevirtual 248	java/lang/Integer:intValue	()I
    //   175: istore_2
    //   176: iload_2
    //   177: ifne +38 -> 215
    //   180: aload_1
    //   181: ldc_w 377
    //   184: invokevirtual 380	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   187: ifle +28 -> 215
    //   190: aload_1
    //   191: ldc_w 394
    //   194: invokevirtual 398	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   197: invokevirtual 514	org/json/JSONArray:toString	()Ljava/lang/String;
    //   200: astore_1
    //   201: aload_1
    //   202: areturn
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 310	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   208: ldc_w 312
    //   211: astore_1
    //   212: goto -97 -> 115
    //   215: iload_2
    //   216: ifeq +17 -> 233
    //   219: aload_0
    //   220: new 288	android/content/Intent
    //   223: dup
    //   224: ldc_w 446
    //   227: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   230: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_1
    //   236: ldc_w 314
    //   239: aload_1
    //   240: invokestatic 317	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   243: pop
    //   244: invokestatic 335	android/os/Looper:prepare	()V
    //   247: aload_0
    //   248: new 288	android/content/Intent
    //   251: dup
    //   252: ldc_w 446
    //   255: invokespecial 291	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   258: invokevirtual 295	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   261: invokestatic 349	android/os/Looper:loop	()V
    //   264: goto -31 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramContext	Context
    //   0	267	1	paramString	String
    //   175	41	2	i	int
    //   3	113	3	str	String
    //   31	54	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   93	115	203	java/io/UnsupportedEncodingException
    //   115	176	235	java/lang/Exception
    //   180	201	235	java/lang/Exception
    //   219	233	235	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */