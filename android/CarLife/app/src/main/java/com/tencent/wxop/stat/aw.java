package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.a.e;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.m;
import java.util.Arrays;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

class aw
{
  private static b d = ;
  private static aw e = null;
  private static Context f = null;
  DefaultHttpClient a;
  com.tencent.wxop.stat.b.g b;
  StringBuilder c;
  private long g;
  
  /* Error */
  private aw(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 40	com/tencent/wxop/stat/aw:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 42	com/tencent/wxop/stat/aw:b	Lcom/tencent/wxop/stat/b/g;
    //   14: aload_0
    //   15: new 44	java/lang/StringBuilder
    //   18: dup
    //   19: sipush 4096
    //   22: invokespecial 47	java/lang/StringBuilder:<init>	(I)V
    //   25: putfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: lconst_0
    //   30: putfield 51	com/tencent/wxop/stat/aw:g	J
    //   33: aload_1
    //   34: invokevirtual 57	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   37: putstatic 31	com/tencent/wxop/stat/aw:f	Landroid/content/Context;
    //   40: aload_0
    //   41: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   44: ldc2_w 64
    //   47: ldiv
    //   48: putfield 51	com/tencent/wxop/stat/aw:g	J
    //   51: aload_0
    //   52: new 67	com/tencent/wxop/stat/b/g
    //   55: dup
    //   56: invokespecial 68	com/tencent/wxop/stat/b/g:<init>	()V
    //   59: putfield 42	com/tencent/wxop/stat/aw:b	Lcom/tencent/wxop/stat/b/g;
    //   62: invokestatic 73	com/tencent/wxop/stat/f:b	()Z
    //   65: istore_2
    //   66: iload_2
    //   67: ifeq +65 -> 132
    //   70: ldc 75
    //   72: invokestatic 81	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   75: getstatic 87	java/util/logging/Level:FINER	Ljava/util/logging/Level;
    //   78: invokevirtual 91	java/util/logging/Logger:setLevel	(Ljava/util/logging/Level;)V
    //   81: ldc 93
    //   83: invokestatic 81	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   86: getstatic 87	java/util/logging/Level:FINER	Ljava/util/logging/Level;
    //   89: invokevirtual 91	java/util/logging/Logger:setLevel	(Ljava/util/logging/Level;)V
    //   92: ldc 95
    //   94: ldc 97
    //   96: invokestatic 101	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: pop
    //   100: ldc 103
    //   102: ldc 105
    //   104: invokestatic 101	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: pop
    //   108: ldc 107
    //   110: ldc 109
    //   112: invokestatic 101	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   115: pop
    //   116: ldc 111
    //   118: ldc 109
    //   120: invokestatic 101	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: pop
    //   124: ldc 113
    //   126: ldc 109
    //   128: invokestatic 101	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: pop
    //   132: new 115	org/apache/http/params/BasicHttpParams
    //   135: dup
    //   136: invokespecial 116	org/apache/http/params/BasicHttpParams:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: iconst_0
    //   142: invokestatic 122	org/apache/http/params/HttpConnectionParams:setStaleCheckingEnabled	(Lorg/apache/http/params/HttpParams;Z)V
    //   145: aload_1
    //   146: sipush 10000
    //   149: invokestatic 126	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   152: aload_1
    //   153: sipush 10000
    //   156: invokestatic 129	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   159: aload_0
    //   160: new 131	org/apache/http/impl/client/DefaultHttpClient
    //   163: dup
    //   164: aload_1
    //   165: invokespecial 134	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   168: putfield 40	com/tencent/wxop/stat/aw:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   171: aload_0
    //   172: getfield 40	com/tencent/wxop/stat/aw:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   175: new 136	com/tencent/wxop/stat/ax
    //   178: dup
    //   179: aload_0
    //   180: invokespecial 139	com/tencent/wxop/stat/ax:<init>	(Lcom/tencent/wxop/stat/aw;)V
    //   183: invokevirtual 143	org/apache/http/impl/client/DefaultHttpClient:setKeepAliveStrategy	(Lorg/apache/http/conn/ConnectionKeepAliveStrategy;)V
    //   186: return
    //   187: astore_1
    //   188: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   191: aload_1
    //   192: invokevirtual 148	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   195: return
    //   196: astore_1
    //   197: goto -65 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	aw
    //   0	200	1	paramContext	Context
    //   65	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	66	187	java/lang/Throwable
    //   132	186	187	java/lang/Throwable
    //   70	132	196	java/lang/Throwable
  }
  
  static Context a()
  {
    return f;
  }
  
  static void a(Context paramContext)
  {
    f = paramContext.getApplicationContext();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.optString("mid");
      if (h.b((String)localObject))
      {
        if (f.b()) {
          d.b("update mid:" + (String)localObject);
        }
        com.tencent.a.a.a.a.g.a(f).a((String)localObject);
      }
      if (!paramJSONObject.isNull("cfg"))
      {
        localObject = paramJSONObject.getJSONObject("cfg");
        f.a(f, (JSONObject)localObject);
      }
      if (!paramJSONObject.isNull("ncts"))
      {
        int i = paramJSONObject.getInt("ncts");
        int j = (int)(i - System.currentTimeMillis() / 1000L);
        if (f.b()) {
          d.b("server time:" + i + ", diff time:" + j);
        }
        m.z(f);
        m.a(f, j);
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      d.f(paramJSONObject);
    }
  }
  
  static aw b(Context paramContext)
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new aw(paramContext);
      }
      return e;
    }
    finally {}
  }
  
  void a(e parame, av paramav)
  {
    b(Arrays.asList(new String[] { parame.g() }), paramav);
  }
  
  /* Error */
  void a(List<?> paramList, av paramav)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: invokeinterface 242 1 0
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: invokeinterface 246 1 0
    //   23: istore 5
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 250 2 0
    //   32: pop
    //   33: aload_0
    //   34: getfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   42: invokevirtual 253	java/lang/StringBuilder:length	()I
    //   45: invokevirtual 257	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_0
    //   50: getfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   53: ldc_w 259
    //   56: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: iconst_0
    //   61: istore_3
    //   62: iload_3
    //   63: iload 5
    //   65: if_icmpge +43 -> 108
    //   68: aload_0
    //   69: getfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: iload_3
    //   74: invokeinterface 250 2 0
    //   79: invokevirtual 260	java/lang/Object:toString	()Ljava/lang/String;
    //   82: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: iload_3
    //   87: iload 5
    //   89: iconst_1
    //   90: isub
    //   91: if_icmpeq +1095 -> 1186
    //   94: aload_0
    //   95: getfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   98: ldc_w 262
    //   101: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: goto +1081 -> 1186
    //   108: aload_0
    //   109: getfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   112: ldc_w 264
    //   115: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: getfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   123: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 265	java/lang/String:length	()I
    //   131: istore 6
    //   133: new 44	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   140: invokestatic 269	com/tencent/wxop/stat/f:q	()Ljava/lang/String;
    //   143: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 271
    //   149: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 51	com/tencent/wxop/stat/aw:g	J
    //   156: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore 9
    //   164: aload_0
    //   165: aload_0
    //   166: getfield 51	com/tencent/wxop/stat/aw:g	J
    //   169: lconst_1
    //   170: ladd
    //   171: putfield 51	com/tencent/wxop/stat/aw:g	J
    //   174: invokestatic 73	com/tencent/wxop/stat/f:b	()Z
    //   177: ifeq +48 -> 225
    //   180: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   183: new 44	java/lang/StringBuilder
    //   186: dup
    //   187: ldc_w 259
    //   190: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload 9
    //   195: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 276
    //   201: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 6
    //   206: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: ldc_w 278
    //   212: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 178	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   225: new 280	org/apache/http/client/methods/HttpPost
    //   228: dup
    //   229: aload 9
    //   231: invokespecial 281	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   234: astore 11
    //   236: aload 11
    //   238: ldc_w 283
    //   241: ldc_w 285
    //   244: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 11
    //   249: ldc_w 291
    //   252: ldc_w 293
    //   255: invokevirtual 296	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 11
    //   260: ldc_w 298
    //   263: invokevirtual 301	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   266: getstatic 31	com/tencent/wxop/stat/aw:f	Landroid/content/Context;
    //   269: invokestatic 306	com/tencent/wxop/stat/l:a	(Landroid/content/Context;)Lcom/tencent/wxop/stat/l;
    //   272: invokevirtual 309	com/tencent/wxop/stat/l:a	()Lorg/apache/http/HttpHost;
    //   275: astore 12
    //   277: aload 11
    //   279: ldc_w 311
    //   282: ldc_w 313
    //   285: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 12
    //   290: ifnonnull +417 -> 707
    //   293: aload_0
    //   294: getfield 40	com/tencent/wxop/stat/aw:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   297: invokevirtual 317	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   300: ldc_w 319
    //   303: invokeinterface 324 2 0
    //   308: pop
    //   309: new 326	java/io/ByteArrayOutputStream
    //   312: dup
    //   313: iload 6
    //   315: invokespecial 327	java/io/ByteArrayOutputStream:<init>	(I)V
    //   318: astore 10
    //   320: aload_1
    //   321: ldc_w 329
    //   324: invokevirtual 333	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   327: astore 9
    //   329: aload 9
    //   331: arraylength
    //   332: istore 5
    //   334: iload 4
    //   336: istore_3
    //   337: iload 6
    //   339: getstatic 337	com/tencent/wxop/stat/f:p	I
    //   342: if_icmple +5 -> 347
    //   345: iconst_1
    //   346: istore_3
    //   347: aload 9
    //   349: astore_1
    //   350: iload_3
    //   351: ifeq +167 -> 518
    //   354: aload 11
    //   356: ldc_w 311
    //   359: invokevirtual 301	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   362: new 44	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 313
    //   372: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 339
    //   378: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: astore_1
    //   385: aload 11
    //   387: ldc_w 311
    //   390: aload_1
    //   391: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 12
    //   396: ifnull +20 -> 416
    //   399: aload 11
    //   401: ldc_w 341
    //   404: invokevirtual 301	org/apache/http/client/methods/HttpPost:removeHeaders	(Ljava/lang/String;)V
    //   407: aload 11
    //   409: ldc_w 341
    //   412: aload_1
    //   413: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload 10
    //   418: iconst_4
    //   419: newarray <illegal type>
    //   421: invokevirtual 345	java/io/ByteArrayOutputStream:write	([B)V
    //   424: new 347	java/util/zip/GZIPOutputStream
    //   427: dup
    //   428: aload 10
    //   430: invokespecial 350	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   433: astore_1
    //   434: aload_1
    //   435: aload 9
    //   437: invokevirtual 351	java/util/zip/GZIPOutputStream:write	([B)V
    //   440: aload_1
    //   441: invokevirtual 354	java/util/zip/GZIPOutputStream:close	()V
    //   444: aload 10
    //   446: invokevirtual 358	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   449: astore 9
    //   451: aload 9
    //   453: iconst_0
    //   454: iconst_4
    //   455: invokestatic 364	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   458: iload 5
    //   460: invokevirtual 368	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   463: pop
    //   464: aload 9
    //   466: astore_1
    //   467: invokestatic 73	com/tencent/wxop/stat/f:b	()Z
    //   470: ifeq +48 -> 518
    //   473: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   476: new 44	java/lang/StringBuilder
    //   479: dup
    //   480: ldc_w 370
    //   483: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   486: iload 5
    //   488: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc_w 372
    //   494: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 9
    //   499: arraylength
    //   500: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: ldc_w 374
    //   506: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 377	com/tencent/wxop/stat/b/b:j	(Ljava/lang/Object;)V
    //   515: aload 9
    //   517: astore_1
    //   518: aload 11
    //   520: new 379	org/apache/http/entity/ByteArrayEntity
    //   523: dup
    //   524: aload_1
    //   525: invokestatic 384	com/tencent/wxop/stat/b/h:a	([B)[B
    //   528: invokespecial 386	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   531: invokevirtual 390	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   534: aload_0
    //   535: getfield 40	com/tencent/wxop/stat/aw:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   538: aload 11
    //   540: invokevirtual 394	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   543: astore_1
    //   544: aload_1
    //   545: invokeinterface 400 1 0
    //   550: astore 9
    //   552: aload_1
    //   553: invokeinterface 404 1 0
    //   558: invokeinterface 409 1 0
    //   563: istore_3
    //   564: aload 9
    //   566: invokeinterface 414 1 0
    //   571: lstore 7
    //   573: invokestatic 73	com/tencent/wxop/stat/f:b	()Z
    //   576: ifeq +37 -> 613
    //   579: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   582: new 44	java/lang/StringBuilder
    //   585: dup
    //   586: ldc_w 416
    //   589: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   592: iload_3
    //   593: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: ldc_w 418
    //   599: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: lload 7
    //   604: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   607: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokevirtual 178	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   613: lload 7
    //   615: lconst_0
    //   616: lcmp
    //   617: ifgt +191 -> 808
    //   620: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   623: ldc_w 420
    //   626: invokevirtual 423	com/tencent/wxop/stat/b/b:h	(Ljava/lang/Object;)V
    //   629: aload_2
    //   630: ifnull +9 -> 639
    //   633: aload_2
    //   634: invokeinterface 427 1 0
    //   639: aload 9
    //   641: invokestatic 432	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   644: pop
    //   645: return
    //   646: astore_1
    //   647: aload_1
    //   648: ifnull -632 -> 16
    //   651: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   654: aload_1
    //   655: invokevirtual 434	com/tencent/wxop/stat/b/b:a	(Ljava/lang/Throwable;)V
    //   658: aload_2
    //   659: ifnull +9 -> 668
    //   662: aload_2
    //   663: invokeinterface 427 1 0
    //   668: aload_1
    //   669: instanceof 436
    //   672: ifeq +25 -> 697
    //   675: invokestatic 439	java/lang/System:gc	()V
    //   678: aload_0
    //   679: aconst_null
    //   680: putfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   683: aload_0
    //   684: new 44	java/lang/StringBuilder
    //   687: dup
    //   688: sipush 2048
    //   691: invokespecial 47	java/lang/StringBuilder:<init>	(I)V
    //   694: putfield 49	com/tencent/wxop/stat/aw:c	Ljava/lang/StringBuilder;
    //   697: getstatic 31	com/tencent/wxop/stat/aw:f	Landroid/content/Context;
    //   700: invokestatic 306	com/tencent/wxop/stat/l:a	(Landroid/content/Context;)Lcom/tencent/wxop/stat/l;
    //   703: invokevirtual 441	com/tencent/wxop/stat/l:d	()V
    //   706: return
    //   707: invokestatic 73	com/tencent/wxop/stat/f:b	()Z
    //   710: ifeq +30 -> 740
    //   713: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   716: new 44	java/lang/StringBuilder
    //   719: dup
    //   720: ldc_w 443
    //   723: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload 12
    //   728: invokevirtual 448	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   731: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokevirtual 377	com/tencent/wxop/stat/b/b:j	(Ljava/lang/Object;)V
    //   740: aload 11
    //   742: ldc_w 341
    //   745: ldc_w 313
    //   748: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload_0
    //   752: getfield 40	com/tencent/wxop/stat/aw:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   755: invokevirtual 317	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   758: ldc_w 319
    //   761: aload 12
    //   763: invokeinterface 452 3 0
    //   768: pop
    //   769: aload 11
    //   771: ldc_w 454
    //   774: getstatic 458	com/tencent/wxop/stat/f:l	Ljava/lang/String;
    //   777: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   780: aload 11
    //   782: ldc_w 460
    //   785: ldc_w 462
    //   788: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload 11
    //   793: ldc_w 464
    //   796: ldc_w 466
    //   799: invokevirtual 289	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: goto -493 -> 309
    //   805: astore_1
    //   806: aload_1
    //   807: athrow
    //   808: lload 7
    //   810: lconst_0
    //   811: lcmp
    //   812: ifle +354 -> 1166
    //   815: aload 9
    //   817: invokeinterface 470 1 0
    //   822: astore 11
    //   824: new 472	java/io/DataInputStream
    //   827: dup
    //   828: aload 11
    //   830: invokespecial 475	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   833: astore 12
    //   835: aload 9
    //   837: invokeinterface 414 1 0
    //   842: l2i
    //   843: newarray <illegal type>
    //   845: astore 9
    //   847: aload 12
    //   849: aload 9
    //   851: invokevirtual 478	java/io/DataInputStream:readFully	([B)V
    //   854: aload 11
    //   856: invokevirtual 481	java/io/InputStream:close	()V
    //   859: aload 12
    //   861: invokevirtual 482	java/io/DataInputStream:close	()V
    //   864: aload_1
    //   865: ldc_w 311
    //   868: invokeinterface 486 2 0
    //   873: astore 12
    //   875: aload 9
    //   877: astore_1
    //   878: aload 12
    //   880: ifnull +28 -> 908
    //   883: aload 12
    //   885: invokeinterface 491 1 0
    //   890: ldc_w 493
    //   893: invokevirtual 496	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   896: ifeq +115 -> 1011
    //   899: aload 9
    //   901: invokestatic 497	com/tencent/wxop/stat/b/m:a	([B)[B
    //   904: invokestatic 499	com/tencent/wxop/stat/b/h:b	([B)[B
    //   907: astore_1
    //   908: new 224	java/lang/String
    //   911: dup
    //   912: aload_1
    //   913: ldc_w 329
    //   916: invokespecial 502	java/lang/String:<init>	([BLjava/lang/String;)V
    //   919: astore 9
    //   921: invokestatic 73	com/tencent/wxop/stat/f:b	()Z
    //   924: ifeq +27 -> 951
    //   927: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   930: new 44	java/lang/StringBuilder
    //   933: dup
    //   934: ldc_w 504
    //   937: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   940: aload 9
    //   942: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokevirtual 178	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   951: new 153	org/json/JSONObject
    //   954: dup
    //   955: aload 9
    //   957: invokespecial 505	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   960: astore 9
    //   962: iload_3
    //   963: sipush 200
    //   966: if_icmpne +144 -> 1110
    //   969: aload_0
    //   970: aload 9
    //   972: invokespecial 507	com/tencent/wxop/stat/aw:a	(Lorg/json/JSONObject;)V
    //   975: aload_2
    //   976: ifnull +20 -> 996
    //   979: aload 9
    //   981: ldc_w 509
    //   984: invokevirtual 512	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   987: ifne +105 -> 1092
    //   990: aload_2
    //   991: invokeinterface 514 1 0
    //   996: aload 11
    //   998: invokevirtual 481	java/io/InputStream:close	()V
    //   1001: aload 10
    //   1003: invokevirtual 515	java/io/ByteArrayOutputStream:close	()V
    //   1006: aconst_null
    //   1007: astore_1
    //   1008: goto -361 -> 647
    //   1011: aload 12
    //   1013: invokeinterface 491 1 0
    //   1018: ldc_w 517
    //   1021: invokevirtual 496	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1024: ifeq +15 -> 1039
    //   1027: aload 9
    //   1029: invokestatic 499	com/tencent/wxop/stat/b/h:b	([B)[B
    //   1032: invokestatic 497	com/tencent/wxop/stat/b/m:a	([B)[B
    //   1035: astore_1
    //   1036: goto -128 -> 908
    //   1039: aload 12
    //   1041: invokeinterface 491 1 0
    //   1046: ldc_w 285
    //   1049: invokevirtual 496	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1052: ifeq +12 -> 1064
    //   1055: aload 9
    //   1057: invokestatic 497	com/tencent/wxop/stat/b/m:a	([B)[B
    //   1060: astore_1
    //   1061: goto -153 -> 908
    //   1064: aload 9
    //   1066: astore_1
    //   1067: aload 12
    //   1069: invokeinterface 491 1 0
    //   1074: ldc_w 313
    //   1077: invokevirtual 496	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1080: ifeq -172 -> 908
    //   1083: aload 9
    //   1085: invokestatic 499	com/tencent/wxop/stat/b/h:b	([B)[B
    //   1088: astore_1
    //   1089: goto -181 -> 908
    //   1092: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   1095: ldc_w 519
    //   1098: invokevirtual 521	com/tencent/wxop/stat/b/b:g	(Ljava/lang/Object;)V
    //   1101: aload_2
    //   1102: invokeinterface 427 1 0
    //   1107: goto -111 -> 996
    //   1110: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   1113: new 44	java/lang/StringBuilder
    //   1116: dup
    //   1117: ldc_w 523
    //   1120: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1123: iload_3
    //   1124: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1127: ldc_w 525
    //   1130: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: new 224	java/lang/String
    //   1136: dup
    //   1137: aload_1
    //   1138: ldc_w 329
    //   1141: invokespecial 502	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1144: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokevirtual 521	com/tencent/wxop/stat/b/b:g	(Ljava/lang/Object;)V
    //   1153: aload_2
    //   1154: ifnull -158 -> 996
    //   1157: aload_2
    //   1158: invokeinterface 427 1 0
    //   1163: goto -167 -> 996
    //   1166: aload 9
    //   1168: invokestatic 432	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1171: pop
    //   1172: goto -171 -> 1001
    //   1175: astore_2
    //   1176: getstatic 27	com/tencent/wxop/stat/aw:d	Lcom/tencent/wxop/stat/b/b;
    //   1179: aload_2
    //   1180: invokevirtual 148	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   1183: goto -515 -> 668
    //   1186: iload_3
    //   1187: iconst_1
    //   1188: iadd
    //   1189: istore_3
    //   1190: goto -1128 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1193	0	this	aw
    //   0	1193	1	paramList	List<?>
    //   0	1193	2	paramav	av
    //   61	1129	3	i	int
    //   1	334	4	j	int
    //   23	464	5	k	int
    //   131	212	6	m	int
    //   571	238	7	l	long
    //   162	1005	9	localObject1	Object
    //   318	684	10	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   234	763	11	localObject2	Object
    //   275	793	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   33	60	646	java/lang/Throwable
    //   68	86	646	java/lang/Throwable
    //   94	105	646	java/lang/Throwable
    //   108	225	646	java/lang/Throwable
    //   225	288	646	java/lang/Throwable
    //   293	309	646	java/lang/Throwable
    //   309	334	646	java/lang/Throwable
    //   337	345	646	java/lang/Throwable
    //   354	394	646	java/lang/Throwable
    //   399	416	646	java/lang/Throwable
    //   416	464	646	java/lang/Throwable
    //   467	515	646	java/lang/Throwable
    //   518	613	646	java/lang/Throwable
    //   620	629	646	java/lang/Throwable
    //   633	639	646	java/lang/Throwable
    //   639	645	646	java/lang/Throwable
    //   707	740	646	java/lang/Throwable
    //   740	802	646	java/lang/Throwable
    //   815	875	646	java/lang/Throwable
    //   883	908	646	java/lang/Throwable
    //   908	951	646	java/lang/Throwable
    //   951	962	646	java/lang/Throwable
    //   969	975	646	java/lang/Throwable
    //   979	996	646	java/lang/Throwable
    //   996	1001	646	java/lang/Throwable
    //   1001	1006	646	java/lang/Throwable
    //   1011	1036	646	java/lang/Throwable
    //   1039	1061	646	java/lang/Throwable
    //   1067	1089	646	java/lang/Throwable
    //   1092	1107	646	java/lang/Throwable
    //   1110	1153	646	java/lang/Throwable
    //   1157	1163	646	java/lang/Throwable
    //   1166	1172	646	java/lang/Throwable
    //   33	60	805	finally
    //   68	86	805	finally
    //   94	105	805	finally
    //   108	225	805	finally
    //   225	288	805	finally
    //   293	309	805	finally
    //   309	334	805	finally
    //   337	345	805	finally
    //   354	394	805	finally
    //   399	416	805	finally
    //   416	464	805	finally
    //   467	515	805	finally
    //   518	613	805	finally
    //   620	629	805	finally
    //   633	639	805	finally
    //   639	645	805	finally
    //   707	740	805	finally
    //   740	802	805	finally
    //   815	875	805	finally
    //   883	908	805	finally
    //   908	951	805	finally
    //   951	962	805	finally
    //   969	975	805	finally
    //   979	996	805	finally
    //   996	1001	805	finally
    //   1001	1006	805	finally
    //   1011	1036	805	finally
    //   1039	1061	805	finally
    //   1067	1089	805	finally
    //   1092	1107	805	finally
    //   1110	1153	805	finally
    //   1157	1163	805	finally
    //   1166	1172	805	finally
    //   662	668	1175	java/lang/Throwable
  }
  
  void b(List<?> paramList, av paramav)
  {
    if (this.b != null) {
      this.b.a(new ay(this, paramList, paramav));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */