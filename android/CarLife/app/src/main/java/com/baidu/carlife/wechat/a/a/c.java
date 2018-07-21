package com.baidu.carlife.wechat.a.a;

import android.os.Handler;
import android.os.Looper;
import b.ab;
import b.ab.a;
import b.ac;
import b.ad;
import b.ae;
import b.e;
import b.f;
import b.m;
import b.n;
import b.p;
import b.r.a;
import b.u;
import b.w;
import b.y;
import b.y.a;
import com.baidu.carlife.wechat.a.b.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private y a = new y.a().a(new n()
  {
    public List<m> a(u paramAnonymousu)
    {
      if (c.a(c.this, paramAnonymousu.i()))
      {
        paramAnonymousu = (List)c.a(c.this).get("webwx_cookie");
        if (paramAnonymousu != null) {
          return paramAnonymousu;
        }
        return new ArrayList();
      }
      return new ArrayList();
    }
    
    public void a(u paramAnonymousu, List<m> paramAnonymousList)
    {
      if (c.a(c.this, paramAnonymousu.i())) {
        c.a(c.this).put("webwx_cookie", paramAnonymousList);
      }
    }
  }).a(10L, TimeUnit.SECONDS).c(30L, TimeUnit.SECONDS).b(30L, TimeUnit.SECONDS).c();
  private Handler b = new Handler(Looper.getMainLooper());
  private final ConcurrentHashMap<String, List<m>> c = new ConcurrentHashMap();
  
  private ab a(String paramString1, String paramString2)
  {
    com.baidu.carlife.wechat.a.b.c.c("post request  url = \n" + paramString1);
    paramString2 = ac.a(w.a("application/json; charset=utf-8"), paramString2);
    return new ab.a().a(paramString1).b("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36").a(paramString2).d();
  }
  
  private ab a(String paramString, b[] paramArrayOfb)
  {
    int i = 0;
    com.baidu.carlife.wechat.a.b.c.c("post request  url = \n" + paramString);
    b[] arrayOfb = paramArrayOfb;
    if (paramArrayOfb == null) {
      arrayOfb = new b[0];
    }
    paramArrayOfb = new r.a();
    int j = arrayOfb.length;
    while (i < j)
    {
      b localb = arrayOfb[i];
      paramArrayOfb.a(localb.a, localb.b);
      i += 1;
    }
    paramArrayOfb = paramArrayOfb.a();
    return new ab.a().a(paramString).b("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36").a(paramArrayOfb).d();
  }
  
  private ad a(String paramString)
    throws IOException
  {
    paramString = c(paramString);
    return this.a.a(paramString).b();
  }
  
  public static y a()
  {
    return b().a;
  }
  
  private Map<String, String> a(ad paramad)
  {
    localHashMap = new HashMap();
    try
    {
      paramad = paramad.a("Set-Cookie");
      int i = 0;
      int j = paramad.size();
      while (i < j)
      {
        String str = ((String)paramad.get(i)).split(";")[0].trim();
        localHashMap.put(str.split("=")[0], str.split("=")[1]);
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramad)
    {
      paramad.printStackTrace();
    }
  }
  
  private void a(ab paramab, final c paramc)
  {
    this.a.a(paramab).a(new f()
    {
      public void a(e paramAnonymouse, ad paramAnonymousad)
      {
        paramAnonymouse = new a();
        try
        {
          paramAnonymouse.a(paramAnonymousad.c());
          paramAnonymouse.a(paramAnonymousad.h().g());
          paramAnonymouse.a(c.a(c.this, paramAnonymousad));
          c.a(c.this, paramAnonymouse, paramc);
          return;
        }
        catch (IOException paramAnonymouse)
        {
          c.a(c.this, paramAnonymouse, paramc);
          return;
        }
        finally
        {
          paramAnonymousad.close();
        }
      }
      
      public void a(e paramAnonymouse, IOException paramAnonymousIOException)
      {
        c.a(c.this, paramAnonymousIOException, paramc);
      }
    });
  }
  
  private void a(final a parama, final c paramc)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        if (paramc != null) {
          paramc.a(parama);
        }
      }
    });
  }
  
  private void a(final Exception paramException, final c paramc)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        if (paramc != null) {
          paramc.a(paramException);
        }
      }
    });
  }
  
  public static void a(String paramString, c paramc)
  {
    b().b(paramString, paramc);
  }
  
  public static void a(String paramString1, c paramc, String paramString2)
  {
    b().b(paramString1, paramc, paramString2);
  }
  
  public static void a(String paramString, c paramc, Map<String, String> paramMap)
  {
    b().b(paramString, paramc, paramMap);
  }
  
  public static void a(String paramString1, String paramString2, c paramc)
  {
    b().b(paramString1, paramString2, paramc);
  }
  
  public static void a(boolean paramBoolean)
  {
    com.baidu.carlife.wechat.a.b.c.c("clearCookie = " + paramBoolean);
    b().a.u().d();
    if (paramBoolean) {
      b().c.clear();
    }
  }
  
  private b[] a(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      paramMap = new b[0];
      return paramMap;
    }
    b[] arrayOfb = new b[paramMap.size()];
    paramMap = paramMap.entrySet();
    int i = 0;
    Iterator localIterator = paramMap.iterator();
    for (;;)
    {
      paramMap = arrayOfb;
      if (!localIterator.hasNext()) {
        break;
      }
      paramMap = (Map.Entry)localIterator.next();
      arrayOfb[i] = new b((String)paramMap.getKey(), (String)paramMap.getValue());
      i += 1;
    }
  }
  
  private static c b()
  {
    return a.a;
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = d.a(paramString) + ".dat";
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return System.currentTimeMillis() + ".dat";
  }
  
  private void b(String paramString, c paramc)
  {
    a(c(paramString), paramc);
  }
  
  private void b(String paramString1, c paramc, String paramString2)
  {
    a(a(paramString1, paramString2), paramc);
  }
  
  private void b(String paramString, c paramc, Map<String, String> paramMap)
  {
    a(a(paramString, a(paramMap)), paramc);
  }
  
  private void b(final String paramString1, final String paramString2, final c paramc)
  {
    ab localab = c(paramString1);
    this.a.a(localab).a(new f()
    {
      /* Error */
      public void a(e paramAnonymouse, ad paramAnonymousad)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 6
        //   3: aconst_null
        //   4: astore 4
        //   6: sipush 2048
        //   9: newarray <illegal type>
        //   11: astore 9
        //   13: aconst_null
        //   14: astore 7
        //   16: aconst_null
        //   17: astore 8
        //   19: aload 7
        //   21: astore 5
        //   23: aload_2
        //   24: invokevirtual 40	b/ad:h	()Lb/ae;
        //   27: invokevirtual 45	b/ae:d	()Ljava/io/InputStream;
        //   30: astore_1
        //   31: aload 7
        //   33: astore 5
        //   35: aload_1
        //   36: astore 4
        //   38: aload_1
        //   39: astore 6
        //   41: aload_0
        //   42: getfield 21	com/baidu/carlife/wechat/a/a/c$2:d	Lcom/baidu/carlife/wechat/a/a/c;
        //   45: aload_0
        //   46: getfield 25	com/baidu/carlife/wechat/a/a/c$2:b	Ljava/lang/String;
        //   49: invokestatic 48	com/baidu/carlife/wechat/a/a/c:b	(Lcom/baidu/carlife/wechat/a/a/c;Ljava/lang/String;)Ljava/lang/String;
        //   52: astore 10
        //   54: aload 7
        //   56: astore 5
        //   58: aload_1
        //   59: astore 4
        //   61: aload_1
        //   62: astore 6
        //   64: new 50	java/io/File
        //   67: dup
        //   68: aload_0
        //   69: getfield 27	com/baidu/carlife/wechat/a/a/c$2:c	Ljava/lang/String;
        //   72: aload 10
        //   74: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   77: astore 10
        //   79: aload 7
        //   81: astore 5
        //   83: aload_1
        //   84: astore 4
        //   86: aload_1
        //   87: astore 6
        //   89: aload 10
        //   91: invokevirtual 57	java/io/File:exists	()Z
        //   94: ifne +19 -> 113
        //   97: aload 7
        //   99: astore 5
        //   101: aload_1
        //   102: astore 4
        //   104: aload_1
        //   105: astore 6
        //   107: aload 10
        //   109: invokevirtual 60	java/io/File:createNewFile	()Z
        //   112: pop
        //   113: aload 7
        //   115: astore 5
        //   117: aload_1
        //   118: astore 4
        //   120: aload_1
        //   121: astore 6
        //   123: new 62	java/lang/StringBuilder
        //   126: dup
        //   127: invokespecial 63	java/lang/StringBuilder:<init>	()V
        //   130: ldc 65
        //   132: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   135: aload 10
        //   137: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   140: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   143: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   146: invokestatic 81	com/baidu/carlife/wechat/a/b/c:c	(Ljava/lang/String;)I
        //   149: pop
        //   150: aload 7
        //   152: astore 5
        //   154: aload_1
        //   155: astore 4
        //   157: aload_1
        //   158: astore 6
        //   160: new 83	java/io/FileOutputStream
        //   163: dup
        //   164: aload 10
        //   166: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   169: astore 7
        //   171: aload_1
        //   172: aload 9
        //   174: invokevirtual 92	java/io/InputStream:read	([B)I
        //   177: istore_3
        //   178: iload_3
        //   179: iconst_m1
        //   180: if_icmpeq +82 -> 262
        //   183: aload 7
        //   185: aload 9
        //   187: iconst_0
        //   188: iload_3
        //   189: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
        //   192: goto -21 -> 171
        //   195: astore 4
        //   197: aload_1
        //   198: astore 6
        //   200: aload 7
        //   202: astore_1
        //   203: aload 4
        //   205: astore 7
        //   207: aload_1
        //   208: astore 5
        //   210: aload 6
        //   212: astore 4
        //   214: aload 7
        //   216: invokevirtual 99	java/io/IOException:printStackTrace	()V
        //   219: aload_1
        //   220: astore 5
        //   222: aload 6
        //   224: astore 4
        //   226: aload_0
        //   227: getfield 21	com/baidu/carlife/wechat/a/a/c$2:d	Lcom/baidu/carlife/wechat/a/a/c;
        //   230: aload 7
        //   232: aload_0
        //   233: getfield 23	com/baidu/carlife/wechat/a/a/c$2:a	Lcom/baidu/carlife/wechat/a/a/c$c;
        //   236: invokestatic 102	com/baidu/carlife/wechat/a/a/c:a	(Lcom/baidu/carlife/wechat/a/a/c;Ljava/lang/Exception;Lcom/baidu/carlife/wechat/a/a/c$c;)V
        //   239: aload 6
        //   241: ifnull +8 -> 249
        //   244: aload 6
        //   246: invokevirtual 105	java/io/InputStream:close	()V
        //   249: aload_1
        //   250: ifnull +7 -> 257
        //   253: aload_1
        //   254: invokevirtual 106	java/io/FileOutputStream:close	()V
        //   257: aload_2
        //   258: invokevirtual 107	b/ad:close	()V
        //   261: return
        //   262: aload 7
        //   264: invokevirtual 110	java/io/FileOutputStream:flush	()V
        //   267: new 112	com/baidu/carlife/wechat/a/a/a
        //   270: dup
        //   271: invokespecial 113	com/baidu/carlife/wechat/a/a/a:<init>	()V
        //   274: astore 4
        //   276: aload 4
        //   278: aload 10
        //   280: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   283: invokevirtual 116	com/baidu/carlife/wechat/a/a/a:b	(Ljava/lang/String;)V
        //   286: aload_0
        //   287: getfield 21	com/baidu/carlife/wechat/a/a/c$2:d	Lcom/baidu/carlife/wechat/a/a/c;
        //   290: aload 4
        //   292: aload_0
        //   293: getfield 23	com/baidu/carlife/wechat/a/a/c$2:a	Lcom/baidu/carlife/wechat/a/a/c$c;
        //   296: invokestatic 119	com/baidu/carlife/wechat/a/a/c:a	(Lcom/baidu/carlife/wechat/a/a/c;Lcom/baidu/carlife/wechat/a/a/a;Lcom/baidu/carlife/wechat/a/a/c$c;)V
        //   299: aload_1
        //   300: ifnull +7 -> 307
        //   303: aload_1
        //   304: invokevirtual 105	java/io/InputStream:close	()V
        //   307: aload 7
        //   309: ifnull +8 -> 317
        //   312: aload 7
        //   314: invokevirtual 106	java/io/FileOutputStream:close	()V
        //   317: aload_2
        //   318: invokevirtual 107	b/ad:close	()V
        //   321: return
        //   322: astore_1
        //   323: aload_1
        //   324: invokevirtual 99	java/io/IOException:printStackTrace	()V
        //   327: goto -20 -> 307
        //   330: astore_1
        //   331: aload_1
        //   332: invokevirtual 99	java/io/IOException:printStackTrace	()V
        //   335: goto -18 -> 317
        //   338: astore 4
        //   340: aload 4
        //   342: invokevirtual 99	java/io/IOException:printStackTrace	()V
        //   345: goto -96 -> 249
        //   348: astore_1
        //   349: aload_1
        //   350: invokevirtual 99	java/io/IOException:printStackTrace	()V
        //   353: goto -96 -> 257
        //   356: astore_1
        //   357: aload 4
        //   359: ifnull +8 -> 367
        //   362: aload 4
        //   364: invokevirtual 105	java/io/InputStream:close	()V
        //   367: aload 5
        //   369: ifnull +8 -> 377
        //   372: aload 5
        //   374: invokevirtual 106	java/io/FileOutputStream:close	()V
        //   377: aload_2
        //   378: invokevirtual 107	b/ad:close	()V
        //   381: aload_1
        //   382: athrow
        //   383: astore 4
        //   385: aload 4
        //   387: invokevirtual 99	java/io/IOException:printStackTrace	()V
        //   390: goto -23 -> 367
        //   393: astore 4
        //   395: aload 4
        //   397: invokevirtual 99	java/io/IOException:printStackTrace	()V
        //   400: goto -23 -> 377
        //   403: astore 6
        //   405: aload 7
        //   407: astore 5
        //   409: aload_1
        //   410: astore 4
        //   412: aload 6
        //   414: astore_1
        //   415: goto -58 -> 357
        //   418: astore 7
        //   420: aload 8
        //   422: astore_1
        //   423: goto -216 -> 207
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	426	0	this	2
        //   0	426	1	paramAnonymouse	e
        //   0	426	2	paramAnonymousad	ad
        //   177	12	3	i	int
        //   4	152	4	locale1	e
        //   195	9	4	localIOException1	IOException
        //   212	79	4	localObject1	Object
        //   338	25	4	localIOException2	IOException
        //   383	3	4	localIOException3	IOException
        //   393	3	4	localIOException4	IOException
        //   410	1	4	locale2	e
        //   21	387	5	localObject2	Object
        //   1	244	6	locale3	e
        //   403	10	6	localObject3	Object
        //   14	392	7	localObject4	Object
        //   418	1	7	localIOException5	IOException
        //   17	404	8	localObject5	Object
        //   11	175	9	arrayOfByte	byte[]
        //   52	227	10	localObject6	Object
        // Exception table:
        //   from	to	target	type
        //   171	178	195	java/io/IOException
        //   183	192	195	java/io/IOException
        //   262	299	195	java/io/IOException
        //   303	307	322	java/io/IOException
        //   312	317	330	java/io/IOException
        //   244	249	338	java/io/IOException
        //   253	257	348	java/io/IOException
        //   23	31	356	finally
        //   41	54	356	finally
        //   64	79	356	finally
        //   89	97	356	finally
        //   107	113	356	finally
        //   123	150	356	finally
        //   160	171	356	finally
        //   214	219	356	finally
        //   226	239	356	finally
        //   362	367	383	java/io/IOException
        //   372	377	393	java/io/IOException
        //   171	178	403	finally
        //   183	192	403	finally
        //   262	299	403	finally
        //   23	31	418	java/io/IOException
        //   41	54	418	java/io/IOException
        //   64	79	418	java/io/IOException
        //   89	97	418	java/io/IOException
        //   107	113	418	java/io/IOException
        //   123	150	418	java/io/IOException
        //   160	171	418	java/io/IOException
      }
      
      public void a(e paramAnonymouse, IOException paramAnonymousIOException)
      {
        c.a(c.this, paramAnonymousIOException, paramc);
      }
    });
  }
  
  private ab c(String paramString)
  {
    com.baidu.carlife.wechat.a.b.c.c("get request  url = \n" + paramString);
    return new ab.a().a(paramString).b("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36").d();
  }
  
  private boolean d(String paramString)
  {
    return Pattern.compile("wechat.com|(wx[0-9]*|weixin).qq.com").matcher(paramString).find();
  }
  
  private static class a
  {
    public static final c a = new c(null);
  }
  
  private static final class b
  {
    String a;
    String b;
    
    b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(a parama);
    
    public abstract void a(Exception paramException);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */