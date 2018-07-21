package com.baidu.location.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class d
{
  public static final String a = com.baidu.location.h.a.a;
  static final String b = "http://ofloc.map.baidu.com/offline_loc";
  static final String c = "com.baidu.lbs.offlinelocationprovider";
  private static Context d;
  private static volatile d e;
  private final File f;
  private final f g;
  private final b h;
  private final g i;
  private final c j;
  
  private d()
  {
    for (;;)
    {
      File localFile3;
      try
      {
        localFile3 = new File(d.getFilesDir(), "ofld");
        localFile1 = localFile3;
      }
      catch (Exception localException1)
      {
        File localFile1;
        Object localObject = null;
        continue;
      }
      try
      {
        if (!localFile3.exists())
        {
          localFile3.mkdir();
          localFile1 = localFile3;
        }
      }
      catch (Exception localException2)
      {
        File localFile2 = localFile3;
      }
    }
    this.f = localFile1;
    this.h = new b(this);
    this.g = new f(this.h.a());
    this.j = new c(this, this.h.a());
    this.i = new g(this, this.h.a(), this.j.o());
  }
  
  public static d a()
  {
    if (e == null) {}
    try
    {
      if (e == null)
      {
        if (d == null) {
          a(com.baidu.location.f.getServiceContext());
        }
        e = new d();
      }
      e.r();
      return e;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    if (d == null)
    {
      d = paramContext;
      com.baidu.location.h.b.a().a(d);
    }
  }
  
  private BDLocation b(final String[] paramArrayOfString)
  {
    new BDLocation();
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    paramArrayOfString = (FutureTask)localExecutorService.submit(new Callable()
    {
      /* Error */
      public BDLocation a()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: aconst_null
        //   3: astore 7
        //   5: aconst_null
        //   6: astore 6
        //   8: aconst_null
        //   9: astore 5
        //   11: new 30	com/baidu/location/BDLocation
        //   14: dup
        //   15: invokespecial 31	com/baidu/location/BDLocation:<init>	()V
        //   18: astore_2
        //   19: aload_2
        //   20: astore 4
        //   22: aload_0
        //   23: getfield 21	com/baidu/location/e/d$1:a	[Ljava/lang/String;
        //   26: arraylength
        //   27: ifle +106 -> 133
        //   30: invokestatic 35	com/baidu/location/e/d:q	()Landroid/content/Context;
        //   33: invokevirtual 41	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
        //   36: getstatic 45	com/baidu/location/e/d:c	Ljava/lang/String;
        //   39: iconst_0
        //   40: invokevirtual 51	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
        //   43: astore_3
        //   44: aload_3
        //   45: ifnull +97 -> 142
        //   48: aload_3
        //   49: astore 4
        //   51: aload 4
        //   53: ifnull +182 -> 235
        //   56: invokestatic 35	com/baidu/location/e/d:q	()Landroid/content/Context;
        //   59: invokevirtual 55	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
        //   62: aload 4
        //   64: getfield 60	android/content/pm/ProviderInfo:authority	Ljava/lang/String;
        //   67: invokestatic 63	com/baidu/location/e/d:c	(Ljava/lang/String;)Landroid/net/Uri;
        //   70: aload_0
        //   71: getfield 21	com/baidu/location/e/d$1:a	[Ljava/lang/String;
        //   74: aconst_null
        //   75: aconst_null
        //   76: aconst_null
        //   77: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   80: astore_3
        //   81: aload_3
        //   82: invokestatic 74	com/baidu/location/e/e:a	(Landroid/database/Cursor;)Lcom/baidu/location/BDLocation;
        //   85: astore 4
        //   87: aload 4
        //   89: astore_2
        //   90: aload_3
        //   91: ifnull +12 -> 103
        //   94: aload_3
        //   95: invokeinterface 79 1 0
        //   100: aload 4
        //   102: astore_2
        //   103: aload_2
        //   104: astore_3
        //   105: aload_3
        //   106: astore 4
        //   108: aload_3
        //   109: ifnull +24 -> 133
        //   112: aload_3
        //   113: astore 4
        //   115: aload_3
        //   116: invokevirtual 83	com/baidu/location/BDLocation:getLocType	()I
        //   119: bipush 67
        //   121: if_icmpeq +12 -> 133
        //   124: aload_3
        //   125: bipush 66
        //   127: invokevirtual 87	com/baidu/location/BDLocation:setLocType	(I)V
        //   130: aload_3
        //   131: astore 4
        //   133: aload 4
        //   135: areturn
        //   136: astore_3
        //   137: aconst_null
        //   138: astore_3
        //   139: goto -95 -> 44
        //   142: aload_0
        //   143: getfield 19	com/baidu/location/e/d$1:b	Lcom/baidu/location/e/d;
        //   146: invokestatic 90	com/baidu/location/e/d:a	(Lcom/baidu/location/e/d;)Lcom/baidu/location/e/c;
        //   149: invokevirtual 96	com/baidu/location/e/c:p	()[Ljava/lang/String;
        //   152: astore 8
        //   154: aload_3
        //   155: astore 4
        //   157: iload_1
        //   158: aload 8
        //   160: arraylength
        //   161: if_icmpge -110 -> 51
        //   164: invokestatic 35	com/baidu/location/e/d:q	()Landroid/content/Context;
        //   167: invokevirtual 41	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
        //   170: aload 8
        //   172: iload_1
        //   173: aaload
        //   174: iconst_0
        //   175: invokevirtual 51	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
        //   178: astore_3
        //   179: aload_3
        //   180: astore 4
        //   182: aload_3
        //   183: ifnonnull -132 -> 51
        //   186: iload_1
        //   187: iconst_1
        //   188: iadd
        //   189: istore_1
        //   190: goto -36 -> 154
        //   193: astore_3
        //   194: aconst_null
        //   195: astore_3
        //   196: goto -17 -> 179
        //   199: astore_3
        //   200: aconst_null
        //   201: astore_3
        //   202: aload_3
        //   203: ifnull +171 -> 374
        //   206: aload_3
        //   207: invokeinterface 79 1 0
        //   212: goto -109 -> 103
        //   215: astore_3
        //   216: goto -113 -> 103
        //   219: astore_2
        //   220: aload 5
        //   222: astore_3
        //   223: aload_3
        //   224: ifnull +9 -> 233
        //   227: aload_3
        //   228: invokeinterface 79 1 0
        //   233: aload_2
        //   234: athrow
        //   235: new 98	com/baidu/location/e/e$a
        //   238: dup
        //   239: aload_0
        //   240: getfield 21	com/baidu/location/e/d$1:a	[Ljava/lang/String;
        //   243: invokespecial 101	com/baidu/location/e/e$a:<init>	([Ljava/lang/String;)V
        //   246: astore 5
        //   248: aload 7
        //   250: astore 4
        //   252: aload 6
        //   254: astore_3
        //   255: aload_0
        //   256: getfield 19	com/baidu/location/e/d$1:b	Lcom/baidu/location/e/d;
        //   259: invokestatic 104	com/baidu/location/e/d:b	(Lcom/baidu/location/e/d;)Lcom/baidu/location/e/b;
        //   262: aload 5
        //   264: invokevirtual 109	com/baidu/location/e/b:a	(Lcom/baidu/location/e/e$a;)Landroid/database/Cursor;
        //   267: astore 5
        //   269: aload 5
        //   271: astore 4
        //   273: aload 5
        //   275: astore_3
        //   276: aload 5
        //   278: invokestatic 74	com/baidu/location/e/e:a	(Landroid/database/Cursor;)Lcom/baidu/location/BDLocation;
        //   281: astore 6
        //   283: aload 6
        //   285: astore_2
        //   286: aload_2
        //   287: astore_3
        //   288: aload 5
        //   290: ifnull -185 -> 105
        //   293: aload 5
        //   295: invokeinterface 79 1 0
        //   300: aload_2
        //   301: astore_3
        //   302: goto -197 -> 105
        //   305: astore_3
        //   306: aload_2
        //   307: astore_3
        //   308: goto -203 -> 105
        //   311: astore_3
        //   312: aload_2
        //   313: astore_3
        //   314: aload 4
        //   316: ifnull -211 -> 105
        //   319: aload 4
        //   321: invokeinterface 79 1 0
        //   326: aload_2
        //   327: astore_3
        //   328: goto -223 -> 105
        //   331: astore_3
        //   332: aload_2
        //   333: astore_3
        //   334: goto -229 -> 105
        //   337: astore_2
        //   338: aload_3
        //   339: ifnull +9 -> 348
        //   342: aload_3
        //   343: invokeinterface 79 1 0
        //   348: aload_2
        //   349: athrow
        //   350: astore_2
        //   351: aload 4
        //   353: astore_2
        //   354: goto -251 -> 103
        //   357: astore_3
        //   358: goto -125 -> 233
        //   361: astore_3
        //   362: goto -14 -> 348
        //   365: astore_2
        //   366: goto -143 -> 223
        //   369: astore 4
        //   371: goto -169 -> 202
        //   374: goto -271 -> 103
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	377	0	this	1
        //   1	189	1	i	int
        //   18	86	2	localObject1	Object
        //   219	15	2	localObject2	Object
        //   285	48	2	localBDLocation1	BDLocation
        //   337	12	2	localObject3	Object
        //   350	1	2	localException1	Exception
        //   353	1	2	localObject4	Object
        //   365	1	2	localObject5	Object
        //   43	88	3	localObject6	Object
        //   136	1	3	localException2	Exception
        //   138	45	3	localProviderInfo	ProviderInfo
        //   193	1	3	localException3	Exception
        //   195	1	3	localObject7	Object
        //   199	1	3	localException4	Exception
        //   201	6	3	localObject8	Object
        //   215	1	3	localException5	Exception
        //   222	80	3	localObject9	Object
        //   305	1	3	localException6	Exception
        //   307	1	3	localBDLocation2	BDLocation
        //   311	1	3	localException7	Exception
        //   313	15	3	localBDLocation3	BDLocation
        //   331	1	3	localException8	Exception
        //   333	10	3	localBDLocation4	BDLocation
        //   357	1	3	localException9	Exception
        //   361	1	3	localException10	Exception
        //   20	332	4	localObject10	Object
        //   369	1	4	localException11	Exception
        //   9	285	5	localObject11	Object
        //   6	278	6	localBDLocation5	BDLocation
        //   3	246	7	localObject12	Object
        //   152	19	8	arrayOfString	String[]
        // Exception table:
        //   from	to	target	type
        //   30	44	136	java/lang/Exception
        //   164	179	193	java/lang/Exception
        //   56	81	199	java/lang/Exception
        //   206	212	215	java/lang/Exception
        //   56	81	219	finally
        //   293	300	305	java/lang/Exception
        //   255	269	311	java/lang/Exception
        //   276	283	311	java/lang/Exception
        //   319	326	331	java/lang/Exception
        //   255	269	337	finally
        //   276	283	337	finally
        //   94	100	350	java/lang/Exception
        //   227	233	357	java/lang/Exception
        //   342	348	361	java/lang/Exception
        //   81	87	365	finally
        //   81	87	369	java/lang/Exception
      }
    });
    try
    {
      BDLocation localBDLocation = (BDLocation)paramArrayOfString.get(2000L, TimeUnit.MILLISECONDS);
      return localBDLocation;
    }
    catch (InterruptedException localInterruptedException)
    {
      paramArrayOfString.cancel(true);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      paramArrayOfString.cancel(true);
      return null;
    }
    catch (TimeoutException localTimeoutException)
    {
      com.baidu.location.d.g.a().a("offlineLocation Timeout Exception!");
      paramArrayOfString.cancel(true);
      return null;
    }
    finally
    {
      localExecutorService.shutdown();
    }
  }
  
  private static final Uri d(String paramString)
  {
    return Uri.parse(String.format("content://%s/", new Object[] { paramString }));
  }
  
  private void r()
  {
    this.j.g();
  }
  
  private boolean s()
  {
    boolean bool = false;
    String str = d.getPackageName();
    for (;;)
    {
      try
      {
        localProviderInfo = d.getPackageManager().resolveContentProvider(c, 0);
        if (localProviderInfo == null)
        {
          arrayOfString = this.j.p();
          k = 0;
          if (k >= arrayOfString.length) {}
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        try
        {
          String[] arrayOfString;
          ProviderInfo localProviderInfo = d.getPackageManager().resolveContentProvider(arrayOfString[k], 0);
          if (localProviderInfo != null)
          {
            if (localProviderInfo != null) {
              continue;
            }
            bool = true;
            return bool;
            localException1 = localException1;
            Object localObject1 = null;
          }
        }
        catch (Exception localException2)
        {
          int k;
          localObject2 = null;
          continue;
          k += 1;
        }
        continue;
        if (str.equals(((ProviderInfo)localObject2).packageName)) {
          return true;
        }
      }
    }
  }
  
  public long a(String paramString)
  {
    return this.j.a(paramString);
  }
  
  public Cursor a(String[] paramArrayOfString)
  {
    paramArrayOfString = new e.a(paramArrayOfString);
    return this.h.a(paramArrayOfString);
  }
  
  public BDLocation a(com.baidu.location.f.a parama, com.baidu.location.f.e parame, BDLocation paramBDLocation, b paramb, a parama1)
  {
    int k;
    if (paramb == b.a)
    {
      k = this.j.a();
      paramb = com.baidu.location.h.b.a().g() + "&mixMode=1";
      if (parama1 != a.a) {
        break label120;
      }
    }
    label120:
    for (parama1 = Boolean.valueOf(true);; parama1 = Boolean.valueOf(false))
    {
      parame = e.a(parama, parame, paramBDLocation, paramb, parama1.booleanValue(), k);
      parama = null;
      if (parame.length > 0)
      {
        parame = b(parame);
        parama = parame;
        if (parame != null)
        {
          parama = parame;
          if (parame.getLocType() == 67) {}
        }
      }
      return parama;
      paramb = com.baidu.location.h.b.a().g();
      k = 0;
      break;
    }
  }
  
  public Context b()
  {
    return d;
  }
  
  public boolean b(String paramString)
  {
    return this.j.b(paramString);
  }
  
  File c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.j.h();
  }
  
  public boolean e()
  {
    return this.j.i();
  }
  
  public boolean f()
  {
    return this.j.j();
  }
  
  public boolean g()
  {
    return this.j.k();
  }
  
  public boolean h()
  {
    return this.j.l();
  }
  
  public boolean i()
  {
    return this.j.n();
  }
  
  public void j()
  {
    this.g.a();
  }
  
  f k()
  {
    return this.g;
  }
  
  g l()
  {
    return this.i;
  }
  
  c m()
  {
    return this.j;
  }
  
  public void n()
  {
    if (s()) {
      this.h.b();
    }
  }
  
  public void o() {}
  
  public double p()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)d.getSystemService("connectivity")).getActiveNetworkInfo();
    c localc2 = c.a;
    c localc1 = localc2;
    int k;
    if (localNetworkInfo != null)
    {
      localc1 = localc2;
      if (localNetworkInfo.isConnected())
      {
        if (localNetworkInfo.getType() == 1) {
          localc2 = c.b;
        }
        localc1 = localc2;
        if (localNetworkInfo.getType() == 0)
        {
          k = localNetworkInfo.getSubtype();
          if ((k != 1) && (k != 2) && (k != 4) && (k != 7) && (k != 11)) {
            break label113;
          }
          localc1 = c.c;
        }
      }
    }
    while (localc1 == c.a)
    {
      return this.j.b();
      label113:
      if ((k == 3) || (k == 5) || (k == 6) || (k == 8) || (k == 9) || (k == 10) || (k == 12) || (k == 14) || (k == 15))
      {
        localc1 = c.d;
      }
      else
      {
        localc1 = localc2;
        if (k == 13) {
          localc1 = c.e;
        }
      }
    }
    if (localc1 == c.b) {
      return this.j.c();
    }
    if (localc1 == c.c) {
      return this.j.d();
    }
    if (localc1 == c.d) {
      return this.j.e();
    }
    if (localc1 == c.e) {
      return this.j.f();
    }
    return 0.0D;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  private static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */