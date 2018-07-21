package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private static Context a;
  private static h d = null;
  private static int e = 0;
  private static Hashtable<String, LBSAuthManagerListener> f = new Hashtable();
  private static g g;
  private d b = null;
  private e c = null;
  private final Handler h = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (a.a) {
        a.a("handleMessage !!");
      }
      Object localObject = paramAnonymousMessage.getData().getString("listenerKey");
      localObject = (LBSAuthManagerListener)g.a().get(localObject);
      if (a.a) {
        a.a("handleMessage listener = " + localObject);
      }
      if (localObject != null) {
        ((LBSAuthManagerListener)localObject).onAuthResult(paramAnonymousMessage.what, paramAnonymousMessage.obj.toString());
      }
    }
  };
  
  private g(Context paramContext)
  {
    a = paramContext;
    if ((d != null) && (!d.isAlive())) {
      d = null;
    }
    a.b("BaiduApiAuth SDK Version:1.0.20");
    d();
  }
  
  private int a(String paramString)
  {
    i = -1;
    int j = i;
    try
    {
      paramString = new JSONObject(paramString);
      j = i;
      if (!paramString.has("status"))
      {
        j = i;
        paramString.put("status", -1);
      }
      j = i;
      int k = paramString.getInt("status");
      i = k;
      j = k;
      long l1;
      long l2;
      if (paramString.has("current"))
      {
        i = k;
        if (k == 0)
        {
          j = k;
          l1 = paramString.getLong("current");
          j = k;
          l2 = System.currentTimeMillis();
          j = k;
          if ((l2 - l1) / 3600000.0D < 24.0D) {
            break label162;
          }
          i = 601;
        }
      }
      for (;;)
      {
        j = i;
        if ((!paramString.has("current")) || (i != 602)) {
          break;
        }
        j = i;
        l1 = paramString.getLong("current");
        j = i;
        if ((System.currentTimeMillis() - l1) / 1000L <= 180.0D) {
          break;
        }
        return 601;
        label162:
        j = k;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        j = k;
        boolean bool = localSimpleDateFormat.format(Long.valueOf(l2)).equals(localSimpleDateFormat.format(Long.valueOf(l1)));
        i = k;
        if (!bool) {
          i = 601;
        }
      }
      return i;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return j;
    }
  }
  
  public static g a(Context paramContext)
  {
    if (g == null) {}
    for (;;)
    {
      try
      {
        if (g == null) {
          g = new g(paramContext);
        }
        return g;
      }
      finally {}
      if (paramContext == null)
      {
        if (a.a)
        {
          a.c("input context is null");
          new RuntimeException("here").printStackTrace();
        }
      }
      else {
        a = paramContext;
      }
    }
  }
  
  /* Error */
  private String a(int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 166	java/io/FileInputStream
    //   6: dup
    //   7: new 168	java/io/File
    //   10: dup
    //   11: new 170	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   18: ldc -83
    //   20: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc -74
    //   29: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore 4
    //   43: new 192	java/io/InputStreamReader
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 195	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: astore 5
    //   54: new 197	java/io/BufferedReader
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore_3
    //   64: aload_3
    //   65: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_2
    //   69: aload_3
    //   70: ifnull +7 -> 77
    //   73: aload_3
    //   74: invokevirtual 206	java/io/BufferedReader:close	()V
    //   77: aload 5
    //   79: ifnull +8 -> 87
    //   82: aload 5
    //   84: invokevirtual 207	java/io/InputStreamReader:close	()V
    //   87: aload_2
    //   88: astore_3
    //   89: aload 4
    //   91: ifnull +10 -> 101
    //   94: aload 4
    //   96: invokevirtual 208	java/io/FileInputStream:close	()V
    //   99: aload_2
    //   100: astore_3
    //   101: aload_3
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_2
    //   106: aconst_null
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 206	java/io/BufferedReader:close	()V
    //   120: aload 5
    //   122: ifnull +8 -> 130
    //   125: aload 5
    //   127: invokevirtual 207	java/io/InputStreamReader:close	()V
    //   130: aload 6
    //   132: astore_3
    //   133: aload 4
    //   135: ifnull -34 -> 101
    //   138: aload 4
    //   140: invokevirtual 208	java/io/FileInputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_2
    //   148: aconst_null
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: aload_2
    //   155: ifnull +7 -> 162
    //   158: aload_2
    //   159: invokevirtual 206	java/io/BufferedReader:close	()V
    //   162: aload 5
    //   164: ifnull +8 -> 172
    //   167: aload 5
    //   169: invokevirtual 207	java/io/InputStreamReader:close	()V
    //   172: aload 6
    //   174: astore_3
    //   175: aload 4
    //   177: ifnull -76 -> 101
    //   180: aload 4
    //   182: invokevirtual 208	java/io/FileInputStream:close	()V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_2
    //   188: aconst_null
    //   189: astore 5
    //   191: aconst_null
    //   192: astore 4
    //   194: aconst_null
    //   195: astore_3
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 206	java/io/BufferedReader:close	()V
    //   204: aload 5
    //   206: ifnull +8 -> 214
    //   209: aload 5
    //   211: invokevirtual 207	java/io/InputStreamReader:close	()V
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 208	java/io/FileInputStream:close	()V
    //   224: aload_2
    //   225: athrow
    //   226: astore_2
    //   227: aconst_null
    //   228: astore 5
    //   230: aconst_null
    //   231: astore_3
    //   232: goto -36 -> 196
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -42 -> 196
    //   241: astore_2
    //   242: goto -46 -> 196
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_2
    //   248: aconst_null
    //   249: astore 5
    //   251: goto -97 -> 154
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_2
    //   257: goto -103 -> 154
    //   260: astore_2
    //   261: aload_3
    //   262: astore_2
    //   263: goto -109 -> 154
    //   266: astore_2
    //   267: aconst_null
    //   268: astore_2
    //   269: aconst_null
    //   270: astore 5
    //   272: goto -160 -> 112
    //   275: astore_2
    //   276: aconst_null
    //   277: astore_2
    //   278: goto -166 -> 112
    //   281: astore_2
    //   282: aload_3
    //   283: astore_2
    //   284: goto -172 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	g
    //   0	287	1	paramInt	int
    //   68	32	2	str	String
    //   103	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   105	12	2	localObject1	Object
    //   145	1	2	localIOException1	IOException
    //   147	12	2	localObject2	Object
    //   187	38	2	localObject3	Object
    //   226	1	2	localObject4	Object
    //   235	1	2	localObject5	Object
    //   241	1	2	localObject6	Object
    //   245	1	2	localIOException2	IOException
    //   247	1	2	localObject7	Object
    //   254	1	2	localIOException3	IOException
    //   256	1	2	localObject8	Object
    //   260	1	2	localIOException4	IOException
    //   262	1	2	localObject9	Object
    //   266	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   268	1	2	localObject10	Object
    //   275	1	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   277	1	2	localObject11	Object
    //   281	1	2	localFileNotFoundException4	java.io.FileNotFoundException
    //   283	1	2	localObject12	Object
    //   63	220	3	localObject13	Object
    //   41	179	4	localFileInputStream	java.io.FileInputStream
    //   52	219	5	localInputStreamReader	java.io.InputStreamReader
    //   1	172	6	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   3	43	103	java/io/FileNotFoundException
    //   3	43	145	java/io/IOException
    //   3	43	187	finally
    //   43	54	226	finally
    //   54	64	235	finally
    //   64	69	241	finally
    //   43	54	245	java/io/IOException
    //   54	64	254	java/io/IOException
    //   64	69	260	java/io/IOException
    //   43	54	266	java/io/FileNotFoundException
    //   54	64	275	java/io/FileNotFoundException
    //   64	69	281	java/io/FileNotFoundException
  }
  
  private String a(Context paramContext, String paramString)
  {
    String str2 = "";
    Object localObject = paramContext.getPackageName();
    String str1 = str2;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo((String)localObject, 128);
      str1 = str2;
      if (paramContext.metaData == null)
      {
        str1 = str2;
        paramContext = (LBSAuthManagerListener)f.get(paramString);
        if (paramContext == null) {
          break label197;
        }
        str1 = str2;
        paramContext.onAuthResult(101, c.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
        break label197;
      }
      str1 = str2;
      str2 = paramContext.metaData.getString("com.baidu.lbsapi.API_KEY");
      if (str2 != null)
      {
        paramContext = str2;
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        str1 = str2;
        localObject = (LBSAuthManagerListener)f.get(paramString);
        paramContext = str2;
        if (localObject != null)
        {
          str1 = str2;
          ((LBSAuthManagerListener)localObject).onAuthResult(101, c.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
          paramContext = str2;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramString = (LBSAuthManagerListener)f.get(paramString);
        paramContext = str1;
        if (paramString != null)
        {
          paramString.onAuthResult(101, c.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
          paramContext = str1;
        }
      }
    }
    return paramContext;
    label197:
    return "";
  }
  
  private void a(String paramString1, String paramString2)
  {
    int j = -1;
    Object localObject = paramString1;
    if (paramString1 == null) {}
    int i;
    try
    {
      localObject = e();
      paramString1 = this.h.obtainMessage();
      i = j;
      try
      {
        localObject = new JSONObject((String)localObject);
        i = j;
        if (!((JSONObject)localObject).has("status"))
        {
          i = j;
          ((JSONObject)localObject).put("status", -1);
        }
        i = j;
        if (!((JSONObject)localObject).has("current"))
        {
          i = j;
          ((JSONObject)localObject).put("current", System.currentTimeMillis());
        }
        i = j;
        c(((JSONObject)localObject).toString());
        i = j;
        if (((JSONObject)localObject).has("current"))
        {
          i = j;
          ((JSONObject)localObject).remove("current");
        }
        i = j;
        j = ((JSONObject)localObject).getInt("status");
        i = j;
        paramString1.what = j;
        i = j;
        paramString1.obj = ((JSONObject)localObject).toString();
        i = j;
        localObject = new Bundle();
        i = j;
        ((Bundle)localObject).putString("listenerKey", paramString2);
        i = j;
        paramString1.setData((Bundle)localObject);
        i = j;
        this.h.sendMessage(paramString1);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          paramString1.what = i;
          paramString1.obj = new JSONObject();
          Bundle localBundle = new Bundle();
          localBundle.putString("listenerKey", paramString2);
          paramString1.setData(localBundle);
          this.h.sendMessage(paramString1);
        }
      }
      d.c();
      e -= 1;
      if (a.a) {
        a.a("httpRequest called mAuthCounter-- = " + e);
      }
      if (e == 0)
      {
        d.a();
        if (d != null) {
          d = null;
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean, String paramString1, Hashtable<String, String> paramHashtable, final String paramString2)
  {
    String str = a(a, paramString2);
    if ((str == null) || (str.equals(""))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
    a.a("url:https://api.map.baidu.com/sdkcs/verify");
    localHashMap.put("output", "json");
    localHashMap.put("ak", str);
    a.a("ak:" + str);
    localHashMap.put("mcode", b.a(a));
    localHashMap.put("from", "lbs_yunsdk");
    if ((paramHashtable != null) && (paramHashtable.size() > 0))
    {
      paramHashtable = paramHashtable.entrySet().iterator();
      while (paramHashtable.hasNext())
      {
        Object localObject = (Map.Entry)paramHashtable.next();
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str, localObject);
        }
      }
    }
    paramHashtable = "";
    try
    {
      str = com.baidu.android.bbalbs.common.a.a.a(a);
      paramHashtable = str;
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
    a.a("cuid:" + paramHashtable);
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("cuid", paramHashtable);
      localHashMap.put("pcn", a.getPackageName());
      localHashMap.put("version", "1.0.20");
      paramHashtable = "";
    }
    try
    {
      str = b.c(a);
      paramHashtable = str;
    }
    catch (Exception localException2)
    {
      label334:
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("macaddr", paramHashtable);
      paramHashtable = "";
    }
    try
    {
      str = b.a();
      paramHashtable = str;
    }
    catch (Exception localException1)
    {
      label362:
      label374:
      label475:
      label482:
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("language", paramHashtable);
      if (paramBoolean)
      {
        if (!paramBoolean) {
          break label475;
        }
        paramHashtable = "1";
        localHashMap.put("force", paramHashtable);
      }
      if (paramString1 != null) {
        break label482;
      }
      localHashMap.put("from_service", "");
    }
    for (;;)
    {
      this.b = new d(a);
      this.b.a(localHashMap, new d.a()
      {
        public void a(String paramAnonymousString)
        {
          g.a(g.this, paramAnonymousString, paramString2);
        }
      });
      return;
      localHashMap.put("cuid", "");
      break;
      localHashMap.put("macaddr", "");
      break label334;
      localHashMap.put("language", "");
      break label362;
      paramHashtable = "0";
      break label374;
      localHashMap.put("from_service", paramString1);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, Hashtable<String, String> paramHashtable, String[] paramArrayOfString, final String paramString2)
  {
    String str = a(a, paramString2);
    if ((str == null) || (str.equals(""))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
    localHashMap.put("output", "json");
    localHashMap.put("ak", str);
    localHashMap.put("from", "lbs_yunsdk");
    if ((paramHashtable != null) && (paramHashtable.size() > 0))
    {
      paramHashtable = paramHashtable.entrySet().iterator();
      while (paramHashtable.hasNext())
      {
        Object localObject = (Map.Entry)paramHashtable.next();
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str, localObject);
        }
      }
    }
    paramHashtable = "";
    try
    {
      str = com.baidu.android.bbalbs.common.a.a.a(a);
      paramHashtable = str;
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("cuid", paramHashtable);
      localHashMap.put("pcn", a.getPackageName());
      localHashMap.put("version", "1.0.20");
      paramHashtable = "";
    }
    try
    {
      str = b.c(a);
      paramHashtable = str;
    }
    catch (Exception localException2)
    {
      label266:
      label294:
      label306:
      label409:
      label416:
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("macaddr", paramHashtable);
      paramHashtable = "";
    }
    try
    {
      str = b.a();
      paramHashtable = str;
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("language", paramHashtable);
      if (paramBoolean)
      {
        if (!paramBoolean) {
          break label409;
        }
        paramHashtable = "1";
        localHashMap.put("force", paramHashtable);
      }
      if (paramString1 != null) {
        break label416;
      }
      localHashMap.put("from_service", "");
    }
    for (;;)
    {
      this.c = new e(a);
      this.c.a(localHashMap, paramArrayOfString, new e.a()
      {
        public void a(String paramAnonymousString)
        {
          g.a(g.this, paramAnonymousString, paramString2);
        }
      });
      return;
      localHashMap.put("cuid", "");
      break;
      localHashMap.put("macaddr", "");
      break label266;
      localHashMap.put("language", "");
      break label294;
      paramHashtable = "0";
      break label306;
      localHashMap.put("from_service", paramString1);
    }
  }
  
  private String b(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    Object localObject;
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i) {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        }
      }
    }
    do
    {
      return (String)localObject;
      paramContext = null;
      try
      {
        localObject = a(i);
        paramContext = (Context)localObject;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      localObject = paramContext;
    } while (paramContext != null);
    return a.getPackageName();
  }
  
  private boolean b(String paramString)
  {
    String str = a(a, paramString);
    paramString = e();
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("ak")) {
        return true;
      }
      paramString = paramString.getString("ak");
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    return (str != null) && (paramString != null) && (!str.equals(paramString));
  }
  
  private void c(String paramString)
  {
    a.getSharedPreferences("authStatus_" + b(a), 0).edit().putString("status", paramString).commit();
  }
  
  private void d()
  {
    try
    {
      if (d == null)
      {
        d = new h("auth");
        d.start();
        for (;;)
        {
          Handler localHandler = d.a;
          if (localHandler != null) {
            break;
          }
          try
          {
            if (a.a) {
              a.a("wait for create auth thread.");
            }
            Thread.sleep(3L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    finally {}
  }
  
  private String e()
  {
    return a.getSharedPreferences("authStatus_" + b(a), 0).getString("status", "{\"status\":601}");
  }
  
  /* Error */
  public int a(final boolean paramBoolean, final String paramString, final Hashtable<String, String> paramHashtable, LBSAuthManagerListener paramLBSAuthManagerListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 170	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   13: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16: ldc -42
    //   18: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 6
    //   26: aload 4
    //   28: ifnull +14 -> 42
    //   31: getstatic 42	com/baidu/lbsapi/auth/g:f	Ljava/util/Hashtable;
    //   34: aload 6
    //   36: aload 4
    //   38: invokevirtual 533	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: getstatic 62	com/baidu/lbsapi/auth/g:a	Landroid/content/Context;
    //   46: aload 6
    //   48: invokespecial 328	com/baidu/lbsapi/auth/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +13 -> 68
    //   58: aload 4
    //   60: ldc -42
    //   62: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +9 -> 74
    //   68: ldc 2
    //   70: monitorexit
    //   71: bipush 101
    //   73: ireturn
    //   74: getstatic 35	com/baidu/lbsapi/auth/g:e	I
    //   77: iconst_1
    //   78: iadd
    //   79: putstatic 35	com/baidu/lbsapi/auth/g:e	I
    //   82: getstatic 149	com/baidu/lbsapi/auth/a:a	Z
    //   85: ifeq +28 -> 113
    //   88: new 170	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 535
    //   98: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 35	com/baidu/lbsapi/auth/g:e	I
    //   104: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 321	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: invokespecial 277	com/baidu/lbsapi/auth/g:e	()Ljava/lang/String;
    //   117: astore 4
    //   119: getstatic 149	com/baidu/lbsapi/auth/a:a	Z
    //   122: ifeq +27 -> 149
    //   125: new 170	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 537
    //   135: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 4
    //   140: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 321	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: aload 4
    //   152: invokespecial 539	com/baidu/lbsapi/auth/g:a	(Ljava/lang/String;)I
    //   155: istore 5
    //   157: iload 5
    //   159: sipush 601
    //   162: if_icmpne +25 -> 187
    //   165: aload_0
    //   166: new 82	org/json/JSONObject
    //   169: dup
    //   170: invokespecial 324	org/json/JSONObject:<init>	()V
    //   173: ldc 86
    //   175: sipush 602
    //   178: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   181: invokevirtual 287	org/json/JSONObject:toString	()Ljava/lang/String;
    //   184: invokespecial 288	com/baidu/lbsapi/auth/g:c	(Ljava/lang/String;)V
    //   187: aload_0
    //   188: invokespecial 77	com/baidu/lbsapi/auth/g:d	()V
    //   191: getstatic 149	com/baidu/lbsapi/auth/a:a	Z
    //   194: ifeq +31 -> 225
    //   197: new 170	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 541
    //   207: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: getstatic 33	com/baidu/lbsapi/auth/g:d	Lcom/baidu/lbsapi/auth/h;
    //   213: getfield 512	com/baidu/lbsapi/auth/h:a	Landroid/os/Handler;
    //   216: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 321	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   225: getstatic 33	com/baidu/lbsapi/auth/g:d	Lcom/baidu/lbsapi/auth/h;
    //   228: ifnull +12 -> 240
    //   231: getstatic 33	com/baidu/lbsapi/auth/g:d	Lcom/baidu/lbsapi/auth/h;
    //   234: getfield 512	com/baidu/lbsapi/auth/h:a	Landroid/os/Handler;
    //   237: ifnonnull +24 -> 261
    //   240: ldc 2
    //   242: monitorexit
    //   243: iconst_m1
    //   244: ireturn
    //   245: astore_2
    //   246: ldc 2
    //   248: monitorexit
    //   249: aload_2
    //   250: athrow
    //   251: astore 4
    //   253: aload 4
    //   255: invokevirtual 141	org/json/JSONException:printStackTrace	()V
    //   258: goto -71 -> 187
    //   261: getstatic 33	com/baidu/lbsapi/auth/g:d	Lcom/baidu/lbsapi/auth/h;
    //   264: getfield 512	com/baidu/lbsapi/auth/h:a	Landroid/os/Handler;
    //   267: new 8	com/baidu/lbsapi/auth/g$2
    //   270: dup
    //   271: aload_0
    //   272: iload 5
    //   274: iload_1
    //   275: aload 6
    //   277: aload_2
    //   278: aload_3
    //   279: invokespecial 547	com/baidu/lbsapi/auth/g$2:<init>	(Lcom/baidu/lbsapi/auth/g;IZLjava/lang/String;Ljava/lang/String;Ljava/util/Hashtable;)V
    //   282: invokevirtual 551	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   285: pop
    //   286: ldc 2
    //   288: monitorexit
    //   289: iload 5
    //   291: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	g
    //   0	292	1	paramBoolean	boolean
    //   0	292	2	paramString	String
    //   0	292	3	paramHashtable	Hashtable<String, String>
    //   0	292	4	paramLBSAuthManagerListener	LBSAuthManagerListener
    //   155	135	5	i	int
    //   24	252	6	str	String
    // Exception table:
    //   from	to	target	type
    //   3	26	245	finally
    //   31	42	245	finally
    //   42	53	245	finally
    //   58	68	245	finally
    //   68	71	245	finally
    //   74	113	245	finally
    //   113	149	245	finally
    //   149	157	245	finally
    //   165	187	245	finally
    //   187	225	245	finally
    //   225	240	245	finally
    //   240	243	245	finally
    //   246	249	245	finally
    //   253	258	245	finally
    //   261	289	245	finally
    //   165	187	251	org/json/JSONException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/lbsapi/auth/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */