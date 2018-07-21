package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataCore
{
  private static JSONObject a = new JSONObject();
  private static DataCore b = new DataCore();
  private JSONArray c = new JSONArray();
  private JSONArray d = new JSONArray();
  private JSONArray e = new JSONArray();
  private boolean f = false;
  private volatile int g = 0;
  private StatService.WearListener h;
  
  private int a(JSONObject paramJSONObject)
  {
    int k = 0;
    if (paramJSONObject == null) {
      return k;
    }
    for (;;)
    {
      try
      {
        localJSONObject = paramJSONObject.getJSONObject("he");
        l1 = localJSONObject.getLong("sq");
        l2 = localJSONObject.getLong("ss");
        if ((l2 <= 0L) || (l1 != 0L)) {
          break label156;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("pr");
          if (paramJSONObject == null) {
            break label154;
          }
          j = paramJSONObject.length();
          if (j == 0) {
            break label154;
          }
          j = 0;
          k = i;
        }
        catch (Exception paramJSONObject)
        {
          JSONObject localJSONObject;
          long l1;
          long l2;
          int j;
          return i;
        }
        try
        {
          if (j >= paramJSONObject.length()) {
            break;
          }
          localJSONObject = (JSONObject)paramJSONObject.get(j);
          l1 = localJSONObject.getLong("c");
          l2 = localJSONObject.getLong("e");
          if ((l2 == 0L) || (l1 != 0L)) {
            break label151;
          }
          i += 1;
          j += 1;
        }
        catch (Exception paramJSONObject)
        {
          return i;
        }
        localException = localException;
        i = 0;
        continue;
      }
      label151:
      continue;
      label154:
      return i;
      label156:
      int i = 0;
    }
  }
  
  private JSONArray a(Context paramContext, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = cq.a().f(paramContext);
    int i;
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = new JSONArray(paramContext);
        if ((paramContext != null) && (paramContext.length() != 0))
        {
          i = 0;
          while (i < paramContext.length())
          {
            localArrayList.add((JSONObject)paramContext.get(i));
            i += 1;
          }
        }
        paramContext = localArrayList.iterator();
      }
      catch (Exception paramContext) {}
    }
    JSONObject localJSONObject;
    if (paramContext.hasNext()) {
      localJSONObject = (JSONObject)paramContext.next();
    }
    for (;;)
    {
      try
      {
        long l = localJSONObject.getLong("day");
        if (l != paramLong1) {
          break;
        }
        i = 0;
        if (i != 0) {}
        try
        {
          paramContext = new JSONObject();
          paramContext.put("day", paramLong1);
          paramContext.put("count", paramLong2);
          localArrayList.add(paramContext);
          i = localArrayList.size();
          if (i > 5)
          {
            paramContext = localArrayList.subList(i - 5, i);
            return new JSONArray(paramContext);
          }
        }
        catch (Exception paramContext)
        {
          continue;
        }
      }
      catch (Exception localException) {}
      paramContext = localArrayList;
      continue;
      i = 1;
    }
  }
  
  private void a(Context paramContext)
  {
    synchronized (this.d)
    {
      this.d = new JSONArray();
      synchronized (this.c)
      {
        this.c = new JSONArray();
      }
    }
    synchronized (this.e)
    {
      this.e = new JSONArray();
      flush(paramContext);
      return;
      paramContext = finally;
      throw paramContext;
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    if ((this.h != null) && (this.h.onSendLogData(paramString)))
    {
      db.a("log data has been passed to app level");
      return;
    }
    by.a().a(paramContext, paramString);
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject, long paramLong, int paramInt)
  {
    long l2 = cq.a().b(paramContext).longValue();
    long l1 = l2;
    if (l2 <= 0L)
    {
      l1 = l2;
      if (paramInt != 0)
      {
        cq.a().a(paramContext, paramLong);
        l1 = paramLong;
      }
    }
    a(paramJSONObject, "first", Long.valueOf(l1));
    String str1;
    Object localObject1;
    if (paramInt != 0)
    {
      l2 = cq.a().c(paramContext).longValue();
      l1 = paramLong - l2;
      if ((l2 != 0L) && (l1 <= 0L))
      {
        l1 = -1L;
        cq.a().b(paramContext, paramLong);
        cq.a().c(paramContext, l1);
        a(paramJSONObject, "session_last_interval", Long.valueOf(l1));
        String str2 = "";
        String str3 = "";
        Object localObject2 = cq.a().e(paramContext);
        str1 = str3;
        localObject1 = str2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          str1 = str3;
          localObject1 = str2;
          if (((String)localObject2).contains(":"))
          {
            localObject2 = ((String)localObject2).split(":");
            str1 = str3;
            localObject1 = str2;
            if (localObject2 != null)
            {
              str1 = str3;
              localObject1 = str2;
              if (localObject2.length == 2)
              {
                localObject1 = localObject2[0];
                str1 = localObject2[1];
              }
            }
          }
        }
        if (TextUtils.isEmpty(str1)) {
          break label524;
        }
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.valueOf(str1).intValue();
        str1 = dg.a(paramLong);
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (str1.equals(localObject1)))
        {
          j = paramInt + i;
          if (paramInt != 0) {
            cq.a().a(paramContext, str1 + ":" + j);
          }
          a(paramJSONObject, "session_today_cnt", Integer.valueOf(j));
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            try
            {
              j = Integer.valueOf((String)localObject1).intValue();
              paramLong = j;
            }
            catch (Exception localException2)
            {
              paramLong = 0L;
              continue;
              paramContext = cq.a().f(paramContext);
              if (TextUtils.isEmpty(paramContext)) {
                continue;
              }
            }
            if ((paramLong != 0L) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!str1.equals(localObject1)) && (paramInt != 0))
            {
              localObject1 = a(paramContext, paramLong, i);
              cq.a().b(paramContext, ((JSONArray)localObject1).toString());
              a(paramJSONObject, "recent", localObject1);
              return;
              if (l2 != 0L) {
                break;
              }
              l1 = 0L;
              break;
              l1 = cq.a().d(paramContext).longValue();
            }
          }
        }
      }
      catch (Exception localException1)
      {
        i = 0;
        continue;
        try
        {
          paramContext = new JSONArray(paramContext);
          localObject1 = paramContext;
          if (paramContext == null) {
            localObject1 = new JSONArray();
          }
          a(paramJSONObject, "recent", localObject1);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext = null;
          continue;
        }
        paramContext = null;
        continue;
        paramLong = 0L;
        continue;
        int j = paramInt;
        continue;
      }
      label524:
      int i = 0;
    }
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    int i = a(paramJSONObject1);
    try
    {
      paramJSONObject1 = paramJSONObject1.getJSONObject("he");
      if (paramJSONObject1 == null) {
        break label60;
      }
      l1 = paramJSONObject1.getLong("ss");
    }
    catch (Exception paramJSONObject1)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
        continue;
        l1 = 0L;
      }
    }
    l2 = l1;
    if (l1 == 0L) {
      l2 = System.currentTimeMillis();
    }
    a(paramContext, paramJSONObject2, l2, i);
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = 1;
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      int i;
      if (paramBoolean) {
        i = 1;
      }
      try
      {
        localJSONObject.put("app_session", i);
        try
        {
          localJSONObject.put("failed_cnt", 0);
          try
          {
            paramJSONObject.put("trace", localJSONObject);
            i = j;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              i = 0;
            }
          }
          if (i == 0) {
            continue;
          }
          a(paramContext, paramJSONObject, localJSONObject);
          return;
          i = 0;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (!paramJSONObject.has("visit")) {}
    try
    {
      paramJSONObject.put("visit", new JSONObject());
      try
      {
        ((JSONObject)paramJSONObject.get("visit")).put(paramString, paramObject);
        return;
      }
      catch (Exception paramJSONObject) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, int paramInt, boolean paramBoolean)
  {
    int n;
    int i;
    int j;
    JSONObject localJSONObject;
    long l1;
    boolean bool;
    do
    {
      int i1;
      do
      {
        String str3;
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  synchronized (this.d)
                  {
                    n = this.d.length();
                    if (paramString3 != null) {}
                    try
                    {
                      if (paramString3.equals("")) {
                        paramJSONObject.put("s", "0|");
                      }
                    }
                    catch (JSONException paramString3)
                    {
                      try
                      {
                        localJSONObject = this.d.getJSONObject(i);
                        paramString3 = localJSONObject.getString("i");
                        str1 = localJSONObject.getString("l");
                        l1 = localJSONObject.getLong("t") / 3600000L;
                        m = 0;
                        try
                        {
                          k = localJSONObject.getInt("d");
                          m = k;
                        }
                        catch (JSONException localJSONException)
                        {
                          String str2;
                          db.a("old version data, No duration Tag");
                          continue;
                        }
                        str2 = localJSONObject.optString("h");
                        str3 = localJSONObject.optString("p");
                        i1 = localJSONObject.optInt("v");
                        bool = localJSONObject.optBoolean("at");
                        k = j;
                        if (l1 == paramLong)
                        {
                          if (m == 0) {
                            break;
                          }
                          k = j;
                        }
                        i += 1;
                        j = k;
                      }
                      catch (JSONException paramString3) {}
                      paramString3 = paramString3;
                      db.a("event put s fail");
                      continue;
                    }
                    i = 0;
                    j = n;
                    if (i >= n) {
                      break label486;
                    }
                  }
                  db.a(paramString3);
                  k = j;
                }
                k = j;
              } while (!paramString3.equals(paramString1));
              k = j;
            } while (!str1.equals(paramString2));
            k = j;
          } while (!localJSONException.equals(paramString4));
          k = j;
        } while (!str3.equals(paramString5));
        k = j;
      } while (i1 != paramInt);
      k = j;
    } while (bool != paramBoolean);
    int k = paramJSONObject.getInt("c");
    int m = localJSONObject.getInt("c");
    String str1 = localJSONObject.optString("s");
    if (str1 != null)
    {
      paramString3 = str1;
      if (str1.equalsIgnoreCase("")) {}
    }
    for (;;)
    {
      l1 = paramJSONObject.getLong("t");
      long l2 = localJSONObject.getLong("t");
      paramString3 = paramString3 + (l1 - l2) + "|";
      for (;;)
      {
        try
        {
          localJSONObject.remove("c");
          localJSONObject.put("c", m + k);
          localJSONObject.put("s", paramString3);
          if (i < n) {
            return;
          }
          try
          {
            this.d.put(n, paramJSONObject);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            db.a(paramJSONObject);
            continue;
          }
        }
        catch (JSONException paramString3)
        {
          j = i;
        }
        label486:
        i = j;
      }
      paramString3 = "0|";
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  private boolean a()
  {
    return this.f;
  }
  
  private boolean a(String paramString)
  {
    return paramString.getBytes().length + ch.a().b() + this.g > 204800;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      try
      {
        i = paramString.getBytes().length;
        if (i <= paramInt) {
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
  
  public static DataCore instance()
  {
    return b;
  }
  
  public void clearCache(Context paramContext)
  {
    a(false);
    synchronized (a)
    {
      a = new JSONObject();
      installHeader(paramContext);
      a(paramContext);
      return;
    }
  }
  
  public String constructLogWithEmptyBody(Context paramContext, String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    bu localbu = CooperService.a().getHeadObject();
    if (TextUtils.isEmpty(localbu.f)) {
      localbu.a(paramContext, localJSONObject2);
    }
    for (;;)
    {
      paramContext = new JSONArray();
      long l = System.currentTimeMillis();
      try
      {
        localJSONObject2.put("t", l);
        localJSONObject2.put("ss", l);
        localJSONObject2.put("wl2", paramContext);
        localJSONObject2.put("sq", 0);
        localJSONObject2.put("sign", CooperService.a().getUUID());
        localJSONObject2.put("k", paramString);
        localJSONObject1.put("he", localJSONObject2);
      }
      catch (Exception paramContext)
      {
        db.a(paramContext);
        return null;
      }
      try
      {
        localJSONObject1.put("pr", paramContext);
      }
      catch (JSONException paramContext)
      {
        db.a(paramContext);
        return null;
      }
      try
      {
        localJSONObject1.put("ev", paramContext);
      }
      catch (JSONException paramContext)
      {
        db.a(paramContext);
        return null;
      }
      try
      {
        localJSONObject1.put("ex", paramContext);
        return localJSONObject1.toString();
      }
      catch (JSONException paramContext)
      {
        db.a(paramContext);
      }
      localbu.b(paramContext, localJSONObject2);
    }
    return null;
  }
  
  /* Error */
  public void flush(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 22	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 25	org/json/JSONObject:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 37	com/baidu/mobstat/DataCore:c	Lorg/json/JSONArray;
    //   14: astore 4
    //   16: aload 4
    //   18: monitorenter
    //   19: aload_3
    //   20: ldc 64
    //   22: new 34	org/json/JSONArray
    //   25: dup
    //   26: aload_0
    //   27: getfield 37	com/baidu/mobstat/DataCore:c	Lorg/json/JSONArray;
    //   30: invokevirtual 249	org/json/JSONArray:toString	()Ljava/lang/String;
    //   33: invokespecial 99	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload 4
    //   42: monitorexit
    //   43: aload_0
    //   44: getfield 39	com/baidu/mobstat/DataCore:d	Lorg/json/JSONArray;
    //   47: astore 4
    //   49: aload 4
    //   51: monitorenter
    //   52: aload_3
    //   53: ldc_w 406
    //   56: new 34	org/json/JSONArray
    //   59: dup
    //   60: aload_0
    //   61: getfield 39	com/baidu/mobstat/DataCore:d	Lorg/json/JSONArray;
    //   64: invokevirtual 249	org/json/JSONArray:toString	()Ljava/lang/String;
    //   67: invokespecial 99	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   70: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload 4
    //   76: monitorexit
    //   77: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   80: astore 4
    //   82: aload 4
    //   84: monitorenter
    //   85: aload_3
    //   86: ldc 50
    //   88: new 22	org/json/JSONObject
    //   91: dup
    //   92: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   95: invokevirtual 409	org/json/JSONObject:toString	()Ljava/lang/String;
    //   98: invokespecial 412	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload 4
    //   107: monitorexit
    //   108: aload_3
    //   109: invokevirtual 409	org/json/JSONObject:toString	()Ljava/lang/String;
    //   112: astore_3
    //   113: aload_0
    //   114: invokespecial 414	com/baidu/mobstat/DataCore:a	()Z
    //   117: ifeq +52 -> 169
    //   120: ldc_w 416
    //   123: invokestatic 156	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: astore 5
    //   131: aload 4
    //   133: monitorexit
    //   134: aload 5
    //   136: athrow
    //   137: astore 4
    //   139: ldc_w 418
    //   142: invokestatic 156	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   145: goto -37 -> 108
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    //   153: astore 5
    //   155: aload 4
    //   157: monitorexit
    //   158: aload 5
    //   160: athrow
    //   161: astore 5
    //   163: aload 4
    //   165: monitorexit
    //   166: aload 5
    //   168: athrow
    //   169: aload_3
    //   170: invokevirtual 357	java/lang/String:getBytes	()[B
    //   173: arraylength
    //   174: istore_2
    //   175: iload_2
    //   176: ldc_w 365
    //   179: if_icmplt +11 -> 190
    //   182: aload_0
    //   183: iconst_1
    //   184: invokespecial 371	com/baidu/mobstat/DataCore:a	(Z)V
    //   187: goto -61 -> 126
    //   190: aload_0
    //   191: iload_2
    //   192: putfield 45	com/baidu/mobstat/DataCore:g	I
    //   195: new 228	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 420
    //   205: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 45	com/baidu/mobstat/DataCore:g	I
    //   212: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: ldc_w 422
    //   218: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 365
    //   224: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 156	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   233: aload_1
    //   234: invokestatic 427	com/baidu/mobstat/de:q	(Landroid/content/Context;)Ljava/lang/String;
    //   237: astore 4
    //   239: aload_1
    //   240: new 228	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   247: aload 4
    //   249: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc_w 429
    //   255: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: aload_3
    //   262: iconst_0
    //   263: invokestatic 434	com/baidu/mobstat/cu:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   266: aload_0
    //   267: getfield 41	com/baidu/mobstat/DataCore:e	Lorg/json/JSONArray;
    //   270: astore_3
    //   271: aload_3
    //   272: monitorenter
    //   273: aload_0
    //   274: getfield 41	com/baidu/mobstat/DataCore:e	Lorg/json/JSONArray;
    //   277: invokevirtual 249	org/json/JSONArray:toString	()Ljava/lang/String;
    //   280: astore 4
    //   282: new 228	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 436
    //   292: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 4
    //   297: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 156	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   306: aload_1
    //   307: ldc_w 438
    //   310: aload 4
    //   312: iconst_0
    //   313: invokestatic 434	com/baidu/mobstat/cu:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   316: aload_3
    //   317: monitorexit
    //   318: goto -192 -> 126
    //   321: astore_1
    //   322: aload_3
    //   323: monitorexit
    //   324: aload_1
    //   325: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	DataCore
    //   0	326	1	paramContext	Context
    //   174	18	2	i	int
    //   137	27	4	localException	Exception
    //   237	74	4	str	String
    //   129	6	5	localObject3	Object
    //   153	6	5	localObject4	Object
    //   161	6	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   19	43	129	finally
    //   131	134	129	finally
    //   10	19	137	java/lang/Exception
    //   43	52	137	java/lang/Exception
    //   77	85	137	java/lang/Exception
    //   134	137	137	java/lang/Exception
    //   158	161	137	java/lang/Exception
    //   166	169	137	java/lang/Exception
    //   2	10	148	finally
    //   10	19	148	finally
    //   43	52	148	finally
    //   77	85	148	finally
    //   108	126	148	finally
    //   134	137	148	finally
    //   139	145	148	finally
    //   158	161	148	finally
    //   166	169	148	finally
    //   169	175	148	finally
    //   182	187	148	finally
    //   190	273	148	finally
    //   324	326	148	finally
    //   52	77	153	finally
    //   155	158	153	finally
    //   85	108	161	finally
    //   163	166	161	finally
    //   273	318	321	finally
    //   322	324	321	finally
  }
  
  public int getCacheFileSzie()
  {
    return this.g;
  }
  
  public void installHeader(Context paramContext)
  {
    synchronized (a)
    {
      CooperService.a().getHeadObject().a(paramContext, a);
      return;
    }
  }
  
  public boolean isPartEmpty()
  {
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.c.length() == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void loadLastSession(Context paramContext)
  {
    if (paramContext == null) {}
    String str1;
    do
    {
      return;
      str1 = de.q(paramContext);
      str1 = str1 + "__local_last_session.json";
    } while (!cu.c(paramContext, str1));
    String str2 = cu.a(paramContext, str1);
    if (TextUtils.isEmpty(str2))
    {
      db.a("loadLastSession(): last_session.json file not found.");
      return;
    }
    cu.a(paramContext, str1, new JSONObject().toString(), false);
    putSession(str2);
    flush(paramContext);
  }
  
  public void loadStatData(Context arg1)
  {
    int j = 0;
    if (??? == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = de.q(???);
      localObject1 = (String)localObject1 + "__local_stat_cache.json";
    } while (!cu.c(???, (String)localObject1));
    Object localObject3 = cu.a(???, (String)localObject1);
    if (((String)localObject3).equals(""))
    {
      db.a("stat_cache file not found.");
      return;
    }
    db.a("loadStatData, ");
    long l;
    label163:
    JSONObject localJSONObject;
    try
    {
      this.g = ((String)localObject3).getBytes().length;
      db.a("load Stat Data:cacheFileSize is:" + this.g);
      localObject1 = new JSONObject((String)localObject3);
      db.a("Load cache:" + (String)localObject3);
      l = System.currentTimeMillis();
      localObject3 = ((JSONObject)localObject1).getJSONArray("pr");
      i = 0;
      if (i < ((JSONArray)localObject3).length())
      {
        localJSONObject = ((JSONArray)localObject3).getJSONObject(i);
        if (l - localJSONObject.getLong("s") > 604800000L) {
          break label343;
        }
        putSession(localJSONObject);
      }
    }
    catch (JSONException ???)
    {
      db.a("Load stat data error:" + ???);
      return;
    }
    localObject3 = ((JSONObject)localObject1).getJSONArray("ev");
    int i = j;
    for (;;)
    {
      if (i < ((JSONArray)localObject3).length())
      {
        localJSONObject = ((JSONArray)localObject3).getJSONObject(i);
        if (l - localJSONObject.getLong("t") <= 604800000L) {
          putEvent(???, localJSONObject, true);
        }
      }
      else
      {
        boolean bool = isPartEmpty();
        if (bool) {
          break;
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("he");
          synchronized (a)
          {
            a = (JSONObject)localObject1;
            return;
          }
          i += 1;
        }
        catch (JSONException ???)
        {
          db.a(???);
          return;
        }
        label343:
        break label163;
      }
      i += 1;
    }
  }
  
  public void loadWifiData(Context arg1)
  {
    if (??? == null) {}
    while (!cu.c(???, "__local_ap_info_cache.json")) {
      return;
    }
    Object localObject1 = cu.a(???, "__local_ap_info_cache.json");
    for (;;)
    {
      try
      {
        JSONArray localJSONArray1 = new JSONArray((String)localObject1);
        int j = localJSONArray1.length();
        if (j >= 10)
        {
          JSONArray localJSONArray2 = new JSONArray();
          int i = j - 10;
          localObject1 = localJSONArray2;
          if (i < j)
          {
            localJSONArray2.put(localJSONArray1.get(i));
            i += 1;
            continue;
          }
          ??? = de.g(1, ???);
          if (!TextUtils.isEmpty(???)) {
            ((JSONArray)localObject1).put(???);
          }
          synchronized (this.e)
          {
            this.e = ((JSONArray)localObject1);
            db.a("wifiPart: " + this.e.toString());
            return;
          }
        }
        Object localObject3 = localJSONArray1;
      }
      catch (JSONException ???)
      {
        db.b(???);
        return;
      }
    }
  }
  
  public void putEvent(Context paramContext, String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean, ExtraInfo paramExtraInfo, Map<String, String> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("i", paramString1);
        localJSONObject.put("l", paramString2);
        localJSONObject.put("c", paramInt1);
        localJSONObject.put("t", paramLong1);
        localJSONObject.put("d", paramLong2);
        localJSONObject.put("h", paramString3);
        localJSONObject.put("p", paramString4);
        localJSONObject.put("v", paramInt2);
        if (paramBoolean)
        {
          paramInt1 = 1;
          localJSONObject.put("at", paramInt1);
          if ((paramExtraInfo != null) && (paramExtraInfo.dumpToJson().length() != 0)) {
            localJSONObject.put("ext", paramExtraInfo.dumpToJson());
          }
          if (paramMap == null) {
            break label310;
          }
          paramString1 = paramMap.entrySet().iterator();
          paramString2 = new JSONArray();
          if (!paramString1.hasNext()) {
            break;
          }
          paramString4 = (Map.Entry)paramString1.next();
          paramString3 = (String)paramString4.getKey();
          paramString4 = (String)paramString4.getValue();
          if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (a(paramString4, 1024))) {
            continue;
          }
          paramExtraInfo = new JSONObject();
          paramExtraInfo.put("k", paramString3);
          paramExtraInfo.put("v", paramString4);
          paramString2.put(paramExtraInfo);
          continue;
        }
        paramInt1 = 0;
      }
      catch (JSONException paramContext)
      {
        db.a(paramContext);
        return;
      }
    }
    if (paramString2.length() != 0) {
      localJSONObject.put("attribute", paramString2);
    }
    label310:
    putEvent(paramContext, localJSONObject, false);
    db.a("put event:" + localJSONObject.toString());
  }
  
  public void putEvent(Context arg1, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (a(paramJSONObject.toString()))
    {
      db.b("data to put exceed limit, will not put");
      return;
    }
    int i = 0;
    try
    {
      ??? = paramJSONObject.getString("i");
      str1 = paramJSONObject.getString("l");
      l = paramJSONObject.getLong("t") / 3600000L;
      str2 = paramJSONObject.optString("s");
      str3 = paramJSONObject.optString("h");
      str4 = paramJSONObject.optString("p");
      m = paramJSONObject.optInt("v");
      paramBoolean = paramJSONObject.optBoolean("at");
      str5 = paramJSONObject.optString("ext");
      str6 = paramJSONObject.optString("attribute");
    }
    catch (JSONException ???)
    {
      String str1;
      long l;
      String str2;
      String str3;
      String str4;
      int m;
      String str5;
      String str6;
      int j;
      label131:
      int k;
      db.a(???);
      return;
    }
    try
    {
      j = paramJSONObject.getInt("d");
      i = j;
    }
    catch (JSONException localJSONException)
    {
      db.a("old version data, No duration Tag");
      break label131;
      synchronized (this.d)
      {
        i = this.d.length();
      }
    }
    k = 0;
    j = k;
    if (!TextUtils.isEmpty(str5))
    {
      j = k;
      if (!new JSONObject().toString().equals(str5)) {
        j = 1;
      }
    }
    k = 0;
    if (!TextUtils.isEmpty(str6)) {
      k = 1;
    }
    if ((i == 0) && (j == 0) && (k == 0))
    {
      a(paramJSONObject, ???, str1, str2, l, str3, str4, m, paramBoolean);
      return;
    }
    try
    {
      paramJSONObject.put("s", "0");
      this.d.put(i, paramJSONObject);
      return;
      paramJSONObject = finally;
      throw paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        db.a(paramJSONObject);
      }
    }
  }
  
  public void putSession(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(new JSONObject().toString()))) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      putSession(paramString);
      db.a("Load last session:" + paramString);
      return;
    }
    catch (JSONException paramString)
    {
      db.a(paramString);
    }
  }
  
  public void putSession(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (a(paramJSONObject.toString()))
    {
      db.b("data to put exceed limit, will not put");
      return;
    }
    int i;
    synchronized (this.c)
    {
      i = this.c.length();
    }
    try
    {
      this.c.put(i, paramJSONObject);
      return;
      paramJSONObject = finally;
      throw paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        db.a(paramJSONObject);
      }
    }
  }
  
  /* Error */
  public void saveLogDataToSend(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 539
    //   3: invokestatic 156	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   6: invokestatic 383	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   9: invokevirtual 387	com/baidu/mobstat/CooperService:getHeadObject	()Lcom/baidu/mobstat/bu;
    //   12: astore 8
    //   14: aload 8
    //   16: ifnull +104 -> 120
    //   19: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   22: astore 7
    //   24: aload 7
    //   26: monitorenter
    //   27: aload 8
    //   29: getfield 392	com/baidu/mobstat/bu:f	Ljava/lang/String;
    //   32: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +67 -> 102
    //   38: aload 8
    //   40: aload_1
    //   41: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   44: invokevirtual 395	com/baidu/mobstat/bu:a	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   47: new 228	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 541
    //   57: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   63: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   69: invokevirtual 496	org/json/JSONObject:length	()I
    //   72: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 156	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   81: aload 7
    //   83: monitorexit
    //   84: aload 8
    //   86: getfield 392	com/baidu/mobstat/bu:f	Ljava/lang/String;
    //   89: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifeq +28 -> 120
    //   95: ldc_w 543
    //   98: invokestatic 545	com/baidu/mobstat/db:c	(Ljava/lang/String;)V
    //   101: return
    //   102: aload 8
    //   104: aload_1
    //   105: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   108: invokevirtual 411	com/baidu/mobstat/bu:b	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   111: goto -64 -> 47
    //   114: astore_1
    //   115: aload 7
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    //   120: new 22	org/json/JSONObject
    //   123: dup
    //   124: invokespecial 25	org/json/JSONObject:<init>	()V
    //   127: astore 10
    //   129: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   132: astore 7
    //   134: aload 7
    //   136: monitorenter
    //   137: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   140: lstore 5
    //   142: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   145: ldc_w 308
    //   148: lload 5
    //   150: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   153: pop
    //   154: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   157: astore 8
    //   159: iload_2
    //   160: ifeq +210 -> 370
    //   163: iconst_0
    //   164: istore 4
    //   166: aload 8
    //   168: ldc 56
    //   170: iload 4
    //   172: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   175: pop
    //   176: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   179: ldc 62
    //   181: invokestatic 362	com/baidu/mobstat/ch:a	()Lcom/baidu/mobstat/ch;
    //   184: invokevirtual 547	com/baidu/mobstat/ch:e	()J
    //   187: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_0
    //   192: getfield 41	com/baidu/mobstat/DataCore:e	Lorg/json/JSONArray;
    //   195: astore 8
    //   197: aload 8
    //   199: monitorenter
    //   200: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   203: ldc_w 397
    //   206: aload_0
    //   207: getfield 41	com/baidu/mobstat/DataCore:e	Lorg/json/JSONArray;
    //   210: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload 8
    //   216: monitorexit
    //   217: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   220: ldc_w 399
    //   223: invokestatic 383	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   226: invokevirtual 402	com/baidu/mobstat/CooperService:getUUID	()Ljava/lang/String;
    //   229: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload 10
    //   235: ldc 50
    //   237: getstatic 27	com/baidu/mobstat/DataCore:a	Lorg/json/JSONObject;
    //   240: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload_0
    //   245: getfield 37	com/baidu/mobstat/DataCore:c	Lorg/json/JSONArray;
    //   248: astore 8
    //   250: aload 8
    //   252: monitorenter
    //   253: aload 10
    //   255: ldc 64
    //   257: aload_0
    //   258: getfield 37	com/baidu/mobstat/DataCore:c	Lorg/json/JSONArray;
    //   261: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload_0
    //   266: getfield 39	com/baidu/mobstat/DataCore:d	Lorg/json/JSONArray;
    //   269: astore 9
    //   271: aload 9
    //   273: monitorenter
    //   274: aload 10
    //   276: ldc_w 406
    //   279: aload_0
    //   280: getfield 39	com/baidu/mobstat/DataCore:d	Lorg/json/JSONArray;
    //   283: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   286: pop
    //   287: aload 10
    //   289: ldc_w 408
    //   292: new 34	org/json/JSONArray
    //   295: dup
    //   296: invokespecial 35	org/json/JSONArray:<init>	()V
    //   299: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload_0
    //   304: aload_1
    //   305: aload 10
    //   307: iload_3
    //   308: invokespecial 549	com/baidu/mobstat/DataCore:a	(Landroid/content/Context;Lorg/json/JSONObject;Z)V
    //   311: aload 10
    //   313: invokevirtual 409	org/json/JSONObject:toString	()Ljava/lang/String;
    //   316: astore 10
    //   318: new 228	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 551
    //   328: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 156	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   342: aload_0
    //   343: aload_1
    //   344: aload 10
    //   346: invokespecial 552	com/baidu/mobstat/DataCore:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual 554	com/baidu/mobstat/DataCore:clearCache	(Landroid/content/Context;)V
    //   354: aload 9
    //   356: monitorexit
    //   357: aload 8
    //   359: monitorexit
    //   360: aload 7
    //   362: monitorexit
    //   363: return
    //   364: astore_1
    //   365: aload 7
    //   367: monitorexit
    //   368: aload_1
    //   369: athrow
    //   370: iconst_1
    //   371: istore 4
    //   373: goto -207 -> 166
    //   376: astore_1
    //   377: aload 8
    //   379: monitorexit
    //   380: aload_1
    //   381: athrow
    //   382: astore_1
    //   383: aload_1
    //   384: invokestatic 338	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   387: aload 7
    //   389: monitorexit
    //   390: return
    //   391: astore_1
    //   392: aload_1
    //   393: invokestatic 338	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   396: aload 8
    //   398: monitorexit
    //   399: aload 7
    //   401: monitorexit
    //   402: return
    //   403: astore_1
    //   404: aload_1
    //   405: invokestatic 338	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   408: aload 9
    //   410: monitorexit
    //   411: aload 8
    //   413: monitorexit
    //   414: aload 7
    //   416: monitorexit
    //   417: return
    //   418: astore_1
    //   419: aload_1
    //   420: invokestatic 338	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   423: aload 9
    //   425: monitorexit
    //   426: aload 8
    //   428: monitorexit
    //   429: aload 7
    //   431: monitorexit
    //   432: return
    //   433: astore_1
    //   434: aload 9
    //   436: monitorexit
    //   437: aload_1
    //   438: athrow
    //   439: astore_1
    //   440: aload 8
    //   442: monitorexit
    //   443: aload_1
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	DataCore
    //   0	445	1	paramContext	Context
    //   0	445	2	paramBoolean1	boolean
    //   0	445	3	paramBoolean2	boolean
    //   164	208	4	i	int
    //   140	9	5	l	long
    //   22	408	7	localJSONObject	JSONObject
    //   12	429	8	localObject1	Object
    //   127	218	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	47	114	finally
    //   47	84	114	finally
    //   102	111	114	finally
    //   115	118	114	finally
    //   137	142	364	finally
    //   142	159	364	finally
    //   166	200	364	finally
    //   217	244	364	finally
    //   244	253	364	finally
    //   360	363	364	finally
    //   365	368	364	finally
    //   380	382	364	finally
    //   383	390	364	finally
    //   399	402	364	finally
    //   414	417	364	finally
    //   429	432	364	finally
    //   443	445	364	finally
    //   200	217	376	finally
    //   377	380	376	finally
    //   142	159	382	java/lang/Exception
    //   166	200	382	java/lang/Exception
    //   217	244	382	java/lang/Exception
    //   380	382	382	java/lang/Exception
    //   253	265	391	org/json/JSONException
    //   274	287	403	org/json/JSONException
    //   287	303	418	org/json/JSONException
    //   274	287	433	finally
    //   287	303	433	finally
    //   303	357	433	finally
    //   404	411	433	finally
    //   419	426	433	finally
    //   434	437	433	finally
    //   253	265	439	finally
    //   265	274	439	finally
    //   357	360	439	finally
    //   392	399	439	finally
    //   411	414	439	finally
    //   426	429	439	finally
    //   437	439	439	finally
    //   440	443	439	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/DataCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */