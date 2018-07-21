package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.android.pushservice.a;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.k.e;
import java.util.HashMap;
import org.json.JSONObject;

public class x
  implements Runnable
{
  private Context a;
  private int b = 3;
  private int c = 0;
  private boolean d = false;
  private boolean e = true;
  private a.a f;
  
  public x(Context paramContext, a.a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.f = parama;
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: invokestatic 50	com/baidu/android/pushservice/h:d	()Ljava/lang/String;
    //   3: astore 4
    //   5: aload 4
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 25	com/baidu/android/pushservice/e/x:c	I
    //   12: iconst_2
    //   13: if_icmple +61 -> 74
    //   16: aload_0
    //   17: getfield 37	com/baidu/android/pushservice/e/x:a	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 29	com/baidu/android/pushservice/e/x:e	Z
    //   24: invokestatic 53	com/baidu/android/pushservice/h:b	(Landroid/content/Context;Z)Ljava/lang/String;
    //   27: astore 5
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 29	com/baidu/android/pushservice/e/x:e	Z
    //   34: aload 4
    //   36: astore_3
    //   37: aload 5
    //   39: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +32 -> 74
    //   45: aload 4
    //   47: invokestatic 61	com/baidu/android/pushservice/h:b	()Ljava/lang/String;
    //   50: new 63	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   57: ldc 66
    //   59: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 5
    //   64: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 79	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   73: astore_3
    //   74: aconst_null
    //   75: astore 8
    //   77: aconst_null
    //   78: astore 9
    //   80: aconst_null
    //   81: astore 7
    //   83: aload 7
    //   85: astore 5
    //   87: aload 8
    //   89: astore 4
    //   91: aload 9
    //   93: astore 6
    //   95: aload_3
    //   96: ldc 81
    //   98: aload_0
    //   99: invokespecial 84	com/baidu/android/pushservice/e/x:c	()Ljava/util/HashMap;
    //   102: invokestatic 89	com/baidu/android/pushservice/f/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)Lcom/baidu/android/pushservice/f/a;
    //   105: astore_3
    //   106: aload 7
    //   108: astore 5
    //   110: aload 8
    //   112: astore 4
    //   114: aload 9
    //   116: astore 6
    //   118: aload_3
    //   119: invokevirtual 94	com/baidu/android/pushservice/f/a:b	()I
    //   122: istore_1
    //   123: aload 7
    //   125: astore 5
    //   127: aload 8
    //   129: astore 4
    //   131: aload 9
    //   133: astore 6
    //   135: aload_3
    //   136: invokevirtual 97	com/baidu/android/pushservice/f/a:a	()Ljava/io/InputStream;
    //   139: astore_3
    //   140: iload_1
    //   141: sipush 200
    //   144: if_icmpne +182 -> 326
    //   147: aload_3
    //   148: astore 5
    //   150: aload_3
    //   151: astore 4
    //   153: aload_3
    //   154: astore 6
    //   156: new 99	org/json/JSONObject
    //   159: dup
    //   160: aload_3
    //   161: invokestatic 104	com/baidu/android/pushservice/h/a/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   164: invokespecial 107	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   167: ldc 109
    //   169: invokevirtual 113	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   172: astore 8
    //   174: aload 8
    //   176: ifnull +259 -> 435
    //   179: aload_3
    //   180: astore 5
    //   182: aload_3
    //   183: astore 4
    //   185: aload_3
    //   186: astore 6
    //   188: aload 8
    //   190: ldc 115
    //   192: invokevirtual 119	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 9
    //   197: aload_3
    //   198: astore 5
    //   200: aload_3
    //   201: astore 4
    //   203: aload_3
    //   204: astore 6
    //   206: invokestatic 121	com/baidu/android/pushservice/h:f	()Z
    //   209: ifeq +96 -> 305
    //   212: aload_3
    //   213: astore 5
    //   215: aload_3
    //   216: astore 4
    //   218: aload_3
    //   219: astore 6
    //   221: aload 8
    //   223: ldc 123
    //   225: invokevirtual 119	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   228: astore 7
    //   230: aload_3
    //   231: astore 5
    //   233: aload_3
    //   234: astore 4
    //   236: aload_3
    //   237: astore 6
    //   239: aload 8
    //   241: ldc 125
    //   243: invokevirtual 119	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: pop
    //   247: aload_3
    //   248: astore 5
    //   250: aload_3
    //   251: astore 4
    //   253: aload_3
    //   254: astore 6
    //   256: aload_0
    //   257: getfield 37	com/baidu/android/pushservice/e/x:a	Landroid/content/Context;
    //   260: invokestatic 130	com/baidu/android/pushservice/j:a	(Landroid/content/Context;)Lcom/baidu/android/pushservice/j;
    //   263: aload 9
    //   265: aload 7
    //   267: invokevirtual 133	com/baidu/android/pushservice/j:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iconst_1
    //   271: istore_2
    //   272: aload_3
    //   273: astore 4
    //   275: aload_0
    //   276: iconst_0
    //   277: putfield 25	com/baidu/android/pushservice/e/x:c	I
    //   280: aload_3
    //   281: ifnonnull +64 -> 345
    //   284: aload_3
    //   285: astore 4
    //   287: aload_0
    //   288: iconst_1
    //   289: putfield 27	com/baidu/android/pushservice/e/x:d	Z
    //   292: iconst_1
    //   293: anewarray 135	java/io/Closeable
    //   296: dup
    //   297: iconst_0
    //   298: aload_3
    //   299: aastore
    //   300: invokestatic 138	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   303: iload_2
    //   304: ireturn
    //   305: aload_3
    //   306: astore 5
    //   308: aload_3
    //   309: astore 4
    //   311: aload_3
    //   312: astore 6
    //   314: aload 8
    //   316: ldc -116
    //   318: invokevirtual 119	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   321: astore 7
    //   323: goto -93 -> 230
    //   326: aload_3
    //   327: astore 5
    //   329: aload_3
    //   330: astore 4
    //   332: aload_3
    //   333: astore 6
    //   335: aload_3
    //   336: invokestatic 104	com/baidu/android/pushservice/h/a/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   339: pop
    //   340: iconst_0
    //   341: istore_2
    //   342: goto -70 -> 272
    //   345: aload_3
    //   346: astore 4
    //   348: aload_0
    //   349: iconst_0
    //   350: putfield 27	com/baidu/android/pushservice/e/x:d	Z
    //   353: goto -61 -> 292
    //   356: astore 4
    //   358: aload_3
    //   359: astore 4
    //   361: aload_0
    //   362: iconst_1
    //   363: putfield 27	com/baidu/android/pushservice/e/x:d	Z
    //   366: iconst_1
    //   367: anewarray 135	java/io/Closeable
    //   370: dup
    //   371: iconst_0
    //   372: aload_3
    //   373: aastore
    //   374: invokestatic 138	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   377: iload_2
    //   378: ireturn
    //   379: astore_3
    //   380: iconst_0
    //   381: istore_2
    //   382: aload 5
    //   384: astore_3
    //   385: aload_3
    //   386: astore 4
    //   388: aload_0
    //   389: iconst_0
    //   390: putfield 27	com/baidu/android/pushservice/e/x:d	Z
    //   393: iconst_1
    //   394: anewarray 135	java/io/Closeable
    //   397: dup
    //   398: iconst_0
    //   399: aload_3
    //   400: aastore
    //   401: invokestatic 138	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   404: iload_2
    //   405: ireturn
    //   406: astore_3
    //   407: iconst_1
    //   408: anewarray 135	java/io/Closeable
    //   411: dup
    //   412: iconst_0
    //   413: aload 4
    //   415: aastore
    //   416: invokestatic 138	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   419: aload_3
    //   420: athrow
    //   421: astore 4
    //   423: goto -38 -> 385
    //   426: astore_3
    //   427: iconst_0
    //   428: istore_2
    //   429: aload 6
    //   431: astore_3
    //   432: goto -74 -> 358
    //   435: iconst_0
    //   436: istore_2
    //   437: goto -165 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	x
    //   122	23	1	i	int
    //   271	166	2	bool	boolean
    //   7	366	3	localObject1	Object
    //   379	1	3	localException1	Exception
    //   384	16	3	localObject2	Object
    //   406	14	3	localObject3	Object
    //   426	1	3	localIOException1	java.io.IOException
    //   431	1	3	localObject4	Object
    //   3	344	4	localObject5	Object
    //   356	1	4	localIOException2	java.io.IOException
    //   359	55	4	localObject6	Object
    //   421	1	4	localException2	Exception
    //   27	356	5	localObject7	Object
    //   93	337	6	localObject8	Object
    //   81	241	7	str1	String
    //   75	240	8	localJSONObject	JSONObject
    //   78	186	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   275	280	356	java/io/IOException
    //   287	292	356	java/io/IOException
    //   348	353	356	java/io/IOException
    //   95	106	379	java/lang/Exception
    //   118	123	379	java/lang/Exception
    //   135	140	379	java/lang/Exception
    //   156	174	379	java/lang/Exception
    //   188	197	379	java/lang/Exception
    //   206	212	379	java/lang/Exception
    //   221	230	379	java/lang/Exception
    //   239	247	379	java/lang/Exception
    //   256	270	379	java/lang/Exception
    //   314	323	379	java/lang/Exception
    //   335	340	379	java/lang/Exception
    //   95	106	406	finally
    //   118	123	406	finally
    //   135	140	406	finally
    //   156	174	406	finally
    //   188	197	406	finally
    //   206	212	406	finally
    //   221	230	406	finally
    //   239	247	406	finally
    //   256	270	406	finally
    //   275	280	406	finally
    //   287	292	406	finally
    //   314	323	406	finally
    //   335	340	406	finally
    //   348	353	406	finally
    //   361	366	406	finally
    //   388	393	406	finally
    //   275	280	421	java/lang/Exception
    //   287	292	421	java/lang/Exception
    //   348	353	421	java/lang/Exception
    //   95	106	426	java/io/IOException
    //   118	123	426	java/io/IOException
    //   135	140	426	java/io/IOException
    //   156	174	426	java/io/IOException
    //   188	197	426	java/io/IOException
    //   206	212	426	java/io/IOException
    //   221	230	426	java/io/IOException
    //   239	247	426	java/io/IOException
    //   256	270	426	java/io/IOException
    //   314	323	426	java/io/IOException
    //   335	340	426	java/io/IOException
  }
  
  private HashMap<String, String> c()
    throws Exception
  {
    int j = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("method", "token");
    b.a(localHashMap);
    localHashMap.put("device_type", "3");
    Object localObject = e.b(this.a);
    label134:
    JSONObject localJSONObject;
    String str;
    if (h.f())
    {
      localHashMap.put("rsa_device_id", com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptR(((String)localObject).getBytes(), 1), "utf-8"));
      localHashMap.put("device_name", Build.MODEL);
      i = m.b(this.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", -1);
      localObject = m.a(this.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
      if (i != 2) {
        break label350;
      }
      localHashMap.put("bduss", m.a(this.a, "com.baidu.android.pushservice.PushManager.BDUSS"));
      localHashMap.put("appid", localObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("api_level", Build.VERSION.SDK_INT);
      localObject = p.b(this.a);
      localJSONObject.put("screen_height", localObject[0]);
      localJSONObject.put("screen_width", localObject[1]);
      str = Build.MODEL;
      localObject = str;
      if (str.length() > 128) {
        localObject = str.substring(0, 127);
      }
      localJSONObject.put("model", localObject);
      if (!p.a(this.a)) {
        break label381;
      }
      i = 1;
      label233:
      localJSONObject.put("isroot", i);
      if (!p.e(this.a, this.a.getPackageName())) {
        break label386;
      }
    }
    label350:
    label381:
    label386:
    for (int i = j;; i = 0)
    {
      localJSONObject.put("is_baidu_app", i);
      localJSONObject.put("push_sdk_version", a.a());
      str = Build.MANUFACTURER;
      localObject = str;
      if (str.length() > 128) {
        localObject = str.substring(0, 127);
      }
      localJSONObject.put("manufacturer", localObject);
      localHashMap.put("info", localJSONObject.toString());
      return localHashMap;
      localHashMap.put("device_id", localObject);
      break;
      if (i == 1)
      {
        localHashMap.put("access_token", localObject);
        break label134;
      }
      localHashMap.put("apikey", localObject);
      break label134;
      i = 0;
      break label233;
    }
  }
  
  private void d()
  {
    this.c += 1;
    long l;
    if (this.c < this.b) {
      l = (1 << this.c - 1) * 5 * 1000;
    }
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
    this.d = false;
    return;
  }
  
  protected void a()
  {
    boolean bool;
    do
    {
      bool = b();
      if (this.d) {
        d();
      }
    } while ((this.b > 0) && (this.d));
    if (this.f != null)
    {
      this.f.a(Boolean.valueOf(bool));
      p.b("TokenRequester#execute-->RequestTokenThread connectResult: " + bool, this.a);
      if (bool) {
        break label100;
      }
      p.e(this.a);
    }
    label100:
    do
    {
      return;
      p.b("TokenRequester#execute-->mListener is null !!!!!", this.a);
      break;
      b.a(this.a);
    } while (g.a == null);
    p.b("TokenRequester#execute-->TokenRequester start PushService after Request finish. ", this.a);
    o.a(this.a, new Intent());
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */