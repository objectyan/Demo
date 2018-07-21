package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.h.i;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.j.k;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
  extends c
{
  protected Context a;
  protected l b;
  protected String c;
  private a d;
  
  public a(l paraml, Context paramContext)
  {
    this.b = paraml;
    this.a = paramContext.getApplicationContext();
    this.c = h.e();
    this.d = new a();
    a((short)100);
    c("http-" + paraml.a);
  }
  
  private void a(final String paramString, final int paramInt)
  {
    d.a().a(new c("insertHttpBehavior", (short)95)
    {
      public void a()
      {
        try
        {
          i locali = new i();
          locali.d = paramString;
          locali.e = System.currentTimeMillis();
          locali.f = com.baidu.android.pushservice.h.a.b.b(a.this.a);
          locali.g = paramInt;
          if (paramString.equals("030403")) {
            locali.i = p.w(a.this.a);
          }
          for (;;)
          {
            q.b(a.this.a, locali);
            return;
            if (paramString.equals("030401")) {
              locali.i = p.x(a.this.a);
            }
          }
          return;
        }
        catch (Exception localException) {}
      }
    });
  }
  
  /* Error */
  private int b(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifle +156 -> 157
    //   4: aload_0
    //   5: getfield 31	com/baidu/android/pushservice/e/a:a	Landroid/content/Context;
    //   8: astore 6
    //   10: iload_1
    //   11: iconst_1
    //   12: if_icmpne +24 -> 36
    //   15: iconst_1
    //   16: istore 5
    //   18: aload 6
    //   20: iload 5
    //   22: invokestatic 87	com/baidu/android/pushservice/h:b	(Landroid/content/Context;Z)Ljava/lang/String;
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +13 -> 42
    //   32: sipush 10002
    //   35: ireturn
    //   36: iconst_0
    //   37: istore 5
    //   39: goto -21 -> 18
    //   42: aload_0
    //   43: getfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   46: ldc 89
    //   48: invokevirtual 95	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   51: ifeq +106 -> 157
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   59: ldc 89
    //   61: ldc 97
    //   63: invokevirtual 101	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: putfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   73: ldc 103
    //   75: invokevirtual 107	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   78: istore_2
    //   79: iload_2
    //   80: ifle +15 -> 95
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   88: iload_2
    //   89: invokevirtual 111	java/lang/String:substring	(I)Ljava/lang/String;
    //   92: putfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   95: aload_0
    //   96: new 49	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   103: ldc 89
    //   105: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 6
    //   110: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   117: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: putfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   126: ldc 113
    //   128: new 49	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   135: ldc 115
    //   137: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   144: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: aload_0
    //   151: getfield 31	com/baidu/android/pushservice/e/a:a	Landroid/content/Context;
    //   154: invokestatic 120	com/baidu/android/pushservice/g/a:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   157: new 122	java/util/HashMap
    //   160: dup
    //   161: invokespecial 123	java/util/HashMap:<init>	()V
    //   164: astore 6
    //   166: aload_0
    //   167: aload 6
    //   169: invokevirtual 126	com/baidu/android/pushservice/e/a:a	(Ljava/util/HashMap;)V
    //   172: aload_0
    //   173: getfield 39	com/baidu/android/pushservice/e/a:c	Ljava/lang/String;
    //   176: ldc -128
    //   178: aload 6
    //   180: invokestatic 133	com/baidu/android/pushservice/f/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)Lcom/baidu/android/pushservice/f/a;
    //   183: astore 6
    //   185: aload 6
    //   187: invokevirtual 138	com/baidu/android/pushservice/f/a:b	()I
    //   190: istore 4
    //   192: aload 6
    //   194: invokevirtual 141	com/baidu/android/pushservice/f/a:a	()Ljava/io/InputStream;
    //   197: astore 6
    //   199: iload 4
    //   201: sipush 200
    //   204: if_icmpne +66 -> 270
    //   207: aload_0
    //   208: iconst_0
    //   209: aload_0
    //   210: aload 6
    //   212: invokestatic 146	com/baidu/android/pushservice/h/a/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   215: invokevirtual 149	com/baidu/android/pushservice/e/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokevirtual 153	java/lang/String:getBytes	()[B
    //   221: invokevirtual 156	com/baidu/android/pushservice/e/a:a	(I[B)V
    //   224: iconst_0
    //   225: istore_2
    //   226: iconst_0
    //   227: istore_3
    //   228: aload 6
    //   230: ifnull +8 -> 238
    //   233: iload 4
    //   235: ifne +21 -> 256
    //   238: iload_1
    //   239: iconst_2
    //   240: if_icmplt +12 -> 252
    //   243: iload_2
    //   244: istore_3
    //   245: aload_0
    //   246: sipush 10002
    //   249: invokevirtual 159	com/baidu/android/pushservice/e/a:a	(I)V
    //   252: sipush 10002
    //   255: istore_3
    //   256: iconst_1
    //   257: anewarray 161	java/io/Closeable
    //   260: dup
    //   261: iconst_0
    //   262: aload 6
    //   264: aastore
    //   265: invokestatic 164	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   268: iload_3
    //   269: ireturn
    //   270: iload 4
    //   272: sipush 503
    //   275: if_icmpne +189 -> 464
    //   278: iconst_1
    //   279: istore_2
    //   280: iload_2
    //   281: istore_3
    //   282: aload_0
    //   283: aload 6
    //   285: invokestatic 146	com/baidu/android/pushservice/h/a/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   288: invokevirtual 166	com/baidu/android/pushservice/e/a:a	(Ljava/lang/String;)V
    //   291: iload 4
    //   293: istore_3
    //   294: goto -66 -> 228
    //   297: astore 7
    //   299: aconst_null
    //   300: astore 6
    //   302: iconst_0
    //   303: istore_1
    //   304: ldc 113
    //   306: new 49	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   313: ldc -88
    //   315: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 7
    //   320: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   323: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: aload_0
    //   330: getfield 31	com/baidu/android/pushservice/e/a:a	Landroid/content/Context;
    //   333: invokestatic 173	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   336: iload_1
    //   337: ifeq +27 -> 364
    //   340: aload_0
    //   341: sipush 10003
    //   344: invokevirtual 159	com/baidu/android/pushservice/e/a:a	(I)V
    //   347: iconst_m1
    //   348: istore_3
    //   349: iconst_1
    //   350: anewarray 161	java/io/Closeable
    //   353: dup
    //   354: iconst_0
    //   355: aload 6
    //   357: aastore
    //   358: invokestatic 164	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   361: goto -93 -> 268
    //   364: new 49	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   371: ldc -81
    //   373: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 7
    //   378: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: aload_0
    //   388: getfield 31	com/baidu/android/pushservice/e/a:a	Landroid/content/Context;
    //   391: invokestatic 180	com/baidu/android/pushservice/j/p:b	(Ljava/lang/String;Landroid/content/Context;)V
    //   394: aload_0
    //   395: sipush 20001
    //   398: invokevirtual 159	com/baidu/android/pushservice/e/a:a	(I)V
    //   401: goto -54 -> 347
    //   404: astore 8
    //   406: aload 6
    //   408: astore 7
    //   410: aload 8
    //   412: astore 6
    //   414: iconst_1
    //   415: anewarray 161	java/io/Closeable
    //   418: dup
    //   419: iconst_0
    //   420: aload 7
    //   422: aastore
    //   423: invokestatic 164	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   426: aload 6
    //   428: athrow
    //   429: astore 6
    //   431: aconst_null
    //   432: astore 7
    //   434: goto -20 -> 414
    //   437: astore 8
    //   439: aload 6
    //   441: astore 7
    //   443: aload 8
    //   445: astore 6
    //   447: goto -33 -> 414
    //   450: astore 7
    //   452: iconst_0
    //   453: istore_1
    //   454: goto -150 -> 304
    //   457: astore 7
    //   459: iload_3
    //   460: istore_1
    //   461: goto -157 -> 304
    //   464: iconst_0
    //   465: istore_2
    //   466: goto -186 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	a
    //   0	469	1	paramInt	int
    //   78	388	2	i	int
    //   227	233	3	j	int
    //   190	102	4	k	int
    //   16	22	5	bool	boolean
    //   8	419	6	localObject1	Object
    //   429	11	6	localObject2	Object
    //   445	1	6	localObject3	Object
    //   297	80	7	localException1	Exception
    //   408	34	7	localObject4	Object
    //   450	1	7	localException2	Exception
    //   457	1	7	localException3	Exception
    //   404	7	8	localObject5	Object
    //   437	7	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   157	199	297	java/lang/Exception
    //   304	336	404	finally
    //   340	347	404	finally
    //   364	401	404	finally
    //   157	199	429	finally
    //   207	224	437	finally
    //   245	252	437	finally
    //   282	291	437	finally
    //   207	224	450	java/lang/Exception
    //   245	252	457	java/lang/Exception
    //   282	291	457	java/lang/Exception
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("com.baidu.android.pushservice.action.internal.RECEIVE");
    localIntent.putExtra("method", this.b.a);
    localIntent.putExtra("error_msg", paramInt);
    localIntent.putExtra("content", paramArrayOfByte);
    localIntent.putExtra("appid", this.b.f);
    localIntent.setFlags(32);
    a(localIntent);
    this.a.sendBroadcast(localIntent);
  }
  
  private boolean d(String paramString)
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "method_deal_lapp_bind_intent";
    arrayOfString[1] = "method_lapp_unbind";
    arrayOfString[2] = "method_set_lapp_tags";
    arrayOfString[3] = "method_del_lapp_tags";
    arrayOfString[4] = "method_list_lapp_tags";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void a()
  {
    b();
  }
  
  protected void a(int paramInt)
  {
    a(paramInt, PushConstants.a(paramInt).getBytes());
  }
  
  protected void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(this.b.b)) && (this.b.b.equals("internal"))) {
      b(paramInt, paramArrayOfByte);
    }
    while (!this.b.m) {
      return;
    }
    Intent localIntent = new Intent();
    label91:
    Object localObject1;
    com.baidu.android.pushservice.h.j localj;
    if ((this.b.a.equals("method_lapp_unbind")) || (this.b.a.equals("method_list_lapp_tags")))
    {
      localIntent.setAction("com.baidu.android.pushservice.action.lapp.RECEIVE");
      localIntent.putExtra("method", this.b.a);
      localIntent.putExtra("error_msg", paramInt);
      localIntent.putExtra("content", paramArrayOfByte);
      localIntent.setFlags(32);
      a(localIntent);
      localObject1 = new com.baidu.android.pushservice.h.b();
      ((com.baidu.android.pushservice.h.b)localObject1).g = paramInt;
      ((com.baidu.android.pushservice.h.b)localObject1).h = this.b.f;
      ((com.baidu.android.pushservice.h.b)localObject1).j = this.b.e;
      ((com.baidu.android.pushservice.h.b)localObject1).e = System.currentTimeMillis();
      ((com.baidu.android.pushservice.h.b)localObject1).f = com.baidu.android.pushservice.h.a.b.b(this.a);
      if (!this.b.a.equals("method_bind")) {
        break label734;
      }
      localIntent.putExtra("access_token", this.b.d);
      localIntent.putExtra("secret_key", this.b.i);
      localIntent.putExtra("real_bind", "real_bind");
      ((com.baidu.android.pushservice.h.b)localObject1).d = "020101";
      localj = new com.baidu.android.pushservice.h.j();
      localj.b(this.b.e);
      localj = p.a(localj, this.a, this.b.e);
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(new String(paramArrayOfByte));
        ((com.baidu.android.pushservice.h.b)localObject1).b = ((JSONObject)localObject2).getString("request_id");
        if (paramInt != 0) {
          ((com.baidu.android.pushservice.h.b)localObject1).a = ((JSONObject)localObject2).getString("error_msg");
        }
        localObject2 = ((JSONObject)localObject2).getJSONObject("response_params").getString("appid");
        ((com.baidu.android.pushservice.h.b)localObject1).h = ((String)localObject2);
        localj.a((String)localObject2);
      }
      catch (JSONException localJSONException2)
      {
        label734:
        continue;
      }
      try
      {
        q.a(this.a, (com.baidu.android.pushservice.h.b)localObject1);
        q.a(this.a, localj);
        if (com.baidu.android.pushservice.a.b() > 0)
        {
          localObject1 = new i();
          ((i)localObject1).j = this.b.e;
          ((i)localObject1).e = System.currentTimeMillis();
          ((i)localObject1).f = com.baidu.android.pushservice.h.a.b.b(this.a);
          ((i)localObject1).d = "039904";
          ((i)localObject1).g = paramInt;
          if (paramArrayOfByte.length > 0) {
            ((i)localObject1).i = new String(paramArrayOfByte);
          }
          q.a(this.a, (i)localObject1);
        }
        if ((TextUtils.isEmpty(this.b.e)) && (!d(this.b.a))) {
          break;
        }
        if (!d(this.b.a)) {
          localIntent.setPackage(this.b.e);
        }
        p.b("> sendResult to " + this.b.i + ", method:" + this.b.a + ", errorCode : " + paramInt + ", content : " + new String(paramArrayOfByte), this.a);
        if ((this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP")) || (!TextUtils.isEmpty(this.b.j))) {
          break;
        }
        p.b(this.a, localIntent, localIntent.getAction(), this.b.e);
        return;
        if (this.b.a.equals("method_sdk_bind"))
        {
          localIntent.setAction("com.baidu.android.pushservice.action.sdk.RECEIVE");
          break label91;
        }
        localIntent.setAction("com.baidu.android.pushservice.action.RECEIVE");
      }
      catch (Exception localException1)
      {
        com.baidu.android.pushservice.g.a.b("AbstractProcessor", "error " + localException1.getMessage(), this.a);
        continue;
      }
      if ((paramArrayOfByte == null) || ((!this.b.a.equals("method_unbind")) && (!this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP")))) {
        continue;
      }
      if (this.b.a.equals("method_unbind")) {
        localException1.d = "020301";
      }
      try
      {
        localException1.b = new JSONObject(new String(paramArrayOfByte)).getString("request_id");
        try
        {
          q.a(this.a, localException1);
        }
        catch (Exception localException2)
        {
          com.baidu.android.pushservice.g.a.b("AbstractProcessor", "error " + localException2.getMessage(), this.a);
        }
        continue;
        localException2.d = "020601";
      }
      catch (JSONException localJSONException1)
      {
        com.baidu.android.pushservice.g.a.b("AbstractProcessor", "unbind failed msg: " + new String(paramArrayOfByte), this.a);
        localException2.a = new String(paramArrayOfByte);
      }
    }
  }
  
  protected void a(Intent paramIntent) {}
  
  protected void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("{\"")) {
      localObject = paramString.substring(paramString.indexOf("{\""));
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).getInt("error_code");
      paramString = ((JSONObject)localObject).getString("error_msg");
      localObject = ((JSONObject)localObject).getString("request_id");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("error_msg", paramString);
      localJSONObject.put("request_id", localObject);
      a(i, localJSONObject.toString().getBytes());
      return;
    }
    catch (JSONException paramString)
    {
      com.baidu.android.pushservice.g.a.b("AbstractProcessor", "error : " + paramString.getMessage(), this.a);
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    b.a(paramHashMap);
    String str = this.b.a;
    if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase("method_bind"))) {
      if (!TextUtils.isEmpty(this.b.h)) {
        if (this.b.e.equals(this.a.getPackageName()))
        {
          paramHashMap.put("pure_bduss", this.b.h);
          paramHashMap.put("appid", this.b.f);
        }
      }
    }
    do
    {
      do
      {
        return;
        paramHashMap.put("rsa_bduss", this.b.h);
        break;
        if (!TextUtils.isEmpty(this.b.d))
        {
          if (this.b.e.equals(this.a.getPackageName()))
          {
            paramHashMap.put("pure_access_token", this.b.d);
            return;
          }
          paramHashMap.put("rsa_access_token", this.b.d);
          return;
        }
      } while (TextUtils.isEmpty(this.b.i));
      paramHashMap.put("apikey", this.b.i);
      return;
      if (!TextUtils.isEmpty(this.b.h))
      {
        paramHashMap.put("bduss", this.b.h);
        paramHashMap.put("appid", this.b.f);
        return;
      }
      if (!TextUtils.isEmpty(this.b.d))
      {
        paramHashMap.put("access_token", this.b.d);
        return;
      }
    } while (TextUtils.isEmpty(this.b.i));
    paramHashMap.put("apikey", this.b.i);
  }
  
  protected String b(String paramString)
  {
    return paramString;
  }
  
  protected void b()
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.b.a)))
    {
      p.b("AbstractProcessor#execute#mEvent = null or mEvent.method = null", this.a);
      return;
    }
    if ((!this.b.a.equals("com.baidu.android.pushservice.action.UNBIND")) && (!this.b.a.equals("method_sdk_unbind")) && (!this.b.a.equals("method_del_lapp_tags")) && (!this.b.a.equals("method_list_lapp_tags")) && (TextUtils.isEmpty(this.b.e)) && (!this.b.a.equals("com.baidu.android.pushservice.action.UNBINDAPP")))
    {
      p.b("AbstractProcessor#execute#Unknown method", this.a);
      return;
    }
    if (!k.e(this.a))
    {
      com.baidu.android.pushservice.g.a.b("AbstractProcessor", "Network is not useful!", this.a);
      p.b("AbstractProcessor#execute#Network is unuseful!", this.a);
      if (com.baidu.android.pushservice.a.b() > 0) {
        q.a(this.a, "039912");
      }
      a(10001);
      o.a(this.a, new Intent());
      return;
    }
    if (com.baidu.android.pushservice.a.b() > 0) {
      q.a(this.a, "039914");
    }
    for (;;)
    {
      synchronized (com.baidu.android.pushservice.j.a(this.a))
      {
        if ((???.d()) || (!???.c()))
        {
          ???.a(this.a, false, this.d);
          p.b("AbstractProcessor#requestToken#" + this.b.toString(), this.a);
          return;
        }
      }
      boolean bool = c();
      com.baidu.android.pushservice.g.a.c("AbstractProcessor", "netWorkConnect connectResult: " + bool, this.a);
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(this.c))
    {
      com.baidu.android.pushservice.g.a.b("AbstractProcessor", "mUrl is null", this.a);
      bool1 = bool2;
    }
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return bool1;
          i = 0;
          bool1 = bool2;
        } while (i > 2);
        j = b(i);
        if (j != 0) {
          break;
        }
        bool1 = true;
      } while (i <= 0);
      a("030402", j);
      return true;
      bool1 = bool2;
    } while (j != 10002);
    if (i > 0) {
      a("030403", j);
    }
    for (;;)
    {
      i += 1;
      break;
      a("030401", j);
    }
  }
  
  public class a
  {
    public a() {}
    
    public void a(Boolean paramBoolean)
    {
      p.b("RequetChannelListener#isGetChannelToken#isSucceed=" + paramBoolean, a.this.a);
      if (paramBoolean.booleanValue())
      {
        bool = a.this.c();
        com.baidu.android.pushservice.g.a.c("AbstractProcessor", "netWorkConnect connectResult: " + bool, a.this.a);
      }
      while (com.baidu.android.pushservice.j.a(a.this.a).c())
      {
        boolean bool;
        return;
      }
      a.this.a(10002);
      p.b("RequetChannelListener#isGetChannelToken#isSucceed=false, errorcode=10002", a.this.a);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */