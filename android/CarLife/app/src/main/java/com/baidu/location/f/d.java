package com.baidu.location.f;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GnssStatus.Callback;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.Jni;
import com.baidu.location.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class d
{
  private static d c = null;
  private static int m = 0;
  private static int n = 0;
  private static String u = null;
  private int A;
  private int B;
  private HashMap<Integer, List<GpsSatellite>> C;
  private double D = 100.0D;
  private long E = 0L;
  private final long a = 1000L;
  private final long b = 9000L;
  private Context d;
  private LocationManager e = null;
  private Location f;
  private c g = null;
  private d h = null;
  private GpsStatus i;
  private a j;
  private boolean k = false;
  private b l = null;
  private long o = 0L;
  private boolean p = false;
  private boolean q = false;
  private String r = null;
  private boolean s = false;
  private long t = 0L;
  private Handler v = null;
  private final int w = 1;
  private final int x = 2;
  private final int y = 3;
  private final int z = 4;
  
  private d()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      Class.forName("android.location.GnssStatus");
      this.k = true;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      this.k = false;
    }
  }
  
  public static d a()
  {
    try
    {
      if (c == null) {
        c = new d();
      }
      d locald = c;
      return locald;
    }
    finally {}
  }
  
  public static String a(Location paramLocation)
  {
    float f3 = -1.0F;
    if (paramLocation == null) {
      return null;
    }
    float f1 = (float)(paramLocation.getSpeed() * 3.6D);
    if (!paramLocation.hasSpeed()) {
      f1 = -1.0F;
    }
    float f2;
    int i1;
    if (paramLocation.hasAccuracy())
    {
      f2 = paramLocation.getAccuracy();
      i1 = (int)f2;
      if (!paramLocation.hasAltitude()) {
        break label194;
      }
    }
    label194:
    for (double d1 = paramLocation.getAltitude();; d1 = 555.0D)
    {
      f2 = f3;
      if (paramLocation.hasBearing()) {
        f2 = paramLocation.getBearing();
      }
      return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d", new Object[] { Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getLatitude()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(m), Double.valueOf(d1), Long.valueOf(paramLocation.getTime() / 1000L), Integer.valueOf(m), Integer.valueOf(n) });
      f2 = -1.0F;
      break;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i2 = 0;
    if (!com.baidu.location.b.d.a().f) {}
    for (;;)
    {
      return;
      int i1 = i2;
      if (paramDouble1 >= 73.146973D)
      {
        i1 = i2;
        if (paramDouble1 <= 135.252686D)
        {
          i1 = i2;
          if (paramDouble2 <= 54.258807D)
          {
            i1 = i2;
            if (paramDouble2 >= 14.604847D)
            {
              if (paramFloat <= 18.0F) {
                break label87;
              }
              i1 = i2;
            }
          }
        }
      }
      while (com.baidu.location.h.g.u != i1)
      {
        com.baidu.location.h.g.u = i1;
        return;
        label87:
        double d1 = com.baidu.location.h.g.s;
        double d2 = com.baidu.location.h.g.t;
        i1 = (int)((paramDouble1 - d1) * 1000.0D);
        int i3 = (int)((d2 - paramDouble2) * 1000.0D);
        if ((i1 > 0) && (i1 < 50) && (i3 > 0) && (i3 < 50))
        {
          i3 = i1 + i3 * 50;
          i1 = i2;
          if (com.baidu.location.h.g.w) {
            i1 = com.baidu.location.h.g.v[(i3 >> 2)] >> (i3 & 0x3) * 2 & 0x3;
          }
        }
        else
        {
          String str = String.format(Locale.CHINA, "&ll=%.5f|%.5f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
          str = str + "&im=" + com.baidu.location.h.b.a().c();
          com.baidu.location.h.g.q = paramDouble1;
          com.baidu.location.h.g.r = paramDouble2;
          com.baidu.location.b.d.a().a(str);
          i1 = i2;
        }
      }
    }
  }
  
  private void a(String paramString, Location paramLocation)
  {
    if (paramLocation == null) {}
    boolean bool;
    do
    {
      return;
      paramString = paramString + com.baidu.location.a.a.a().f();
      bool = f.a().f();
      k.a(new a(b.a().f()));
      k.a(System.currentTimeMillis());
      k.a(new Location(paramLocation));
      k.a(paramString);
    } while (bool);
    com.baidu.location.a.m.a(k.c(), null, k.d(), paramString);
  }
  
  public static boolean a(Location paramLocation1, Location paramLocation2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramLocation1 == paramLocation2) {
      bool1 = false;
    }
    float f2;
    do
    {
      do
      {
        float f1;
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (paramLocation1 == null);
              bool1 = bool2;
            } while (paramLocation2 == null);
            f1 = paramLocation2.getSpeed();
            if ((!paramBoolean) || ((com.baidu.location.h.g.u != 3) && (com.baidu.location.h.d.a().a(paramLocation2.getLongitude(), paramLocation2.getLatitude())))) {
              break;
            }
            bool1 = bool2;
          } while (f1 < 5.0F);
          f2 = paramLocation2.distanceTo(paramLocation1);
          if (f1 <= com.baidu.location.h.g.K) {
            break;
          }
          bool1 = bool2;
        } while (f2 > com.baidu.location.h.g.M);
        return false;
        if (f1 <= com.baidu.location.h.g.J) {
          break;
        }
        bool1 = bool2;
      } while (f2 > com.baidu.location.h.g.L);
      return false;
      bool1 = bool2;
    } while (f2 > 5.0F);
    return false;
  }
  
  public static String b(Location paramLocation)
  {
    String str = a(paramLocation);
    paramLocation = str;
    if (str != null) {
      paramLocation = str + "&g_tp=0";
    }
    return paramLocation;
  }
  
  private void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if ((paramBoolean) && (!m())) {}
  }
  
  public static String c(Location paramLocation)
  {
    String str = a(paramLocation);
    paramLocation = str;
    if (str != null) {
      paramLocation = str + u;
    }
    return paramLocation;
  }
  
  private void d(Location paramLocation)
  {
    paramLocation = this.v.obtainMessage(1, paramLocation);
    this.v.sendMessage(paramLocation);
  }
  
  /* Error */
  private void e(Location paramLocation)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +38 -> 39
    //   4: getstatic 67	com/baidu/location/f/d:m	I
    //   7: istore 4
    //   9: iload 4
    //   11: istore_3
    //   12: iload 4
    //   14: ifne +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 415	android/location/Location:getExtras	()Landroid/os/Bundle;
    //   21: ldc_w 417
    //   24: invokevirtual 423	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   27: istore_3
    //   28: iload_3
    //   29: ifne +16 -> 45
    //   32: getstatic 425	com/baidu/location/h/g:l	Z
    //   35: ifne +10 -> 45
    //   38: return
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   44: return
    //   45: invokestatic 432	com/baidu/location/d/g:a	()Lcom/baidu/location/d/g;
    //   48: invokevirtual 435	com/baidu/location/d/g:c	()Lcom/baidu/location/d/m;
    //   51: invokevirtual 439	com/baidu/location/d/m:b	()J
    //   54: lconst_0
    //   55: lcmp
    //   56: ifne +21 -> 77
    //   59: invokestatic 432	com/baidu/location/d/g:a	()Lcom/baidu/location/d/g;
    //   62: invokevirtual 435	com/baidu/location/d/g:c	()Lcom/baidu/location/d/m;
    //   65: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   68: invokevirtual 441	com/baidu/location/d/m:f	(J)V
    //   71: invokestatic 432	com/baidu/location/d/g:a	()Lcom/baidu/location/d/g;
    //   74: invokevirtual 443	com/baidu/location/d/g:e	()V
    //   77: aload_0
    //   78: aload_1
    //   79: putfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   82: getstatic 67	com/baidu/location/f/d:m	I
    //   85: istore 4
    //   87: aload_0
    //   88: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   91: ifnonnull +182 -> 273
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 103	com/baidu/location/f/d:r	Ljava/lang/String;
    //   99: aconst_null
    //   100: astore_1
    //   101: invokestatic 448	com/baidu/location/a/d:a	()Lcom/baidu/location/a/d;
    //   104: aload_0
    //   105: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   108: invokevirtual 451	com/baidu/location/a/d:a	(Landroid/location/Location;)Z
    //   111: pop
    //   112: aload_1
    //   113: ifnull +13 -> 126
    //   116: invokestatic 456	com/baidu/location/d/d:a	()Lcom/baidu/location/d/d;
    //   119: aload_1
    //   120: getstatic 67	com/baidu/location/f/d:m	I
    //   123: invokevirtual 459	com/baidu/location/d/d:a	(Landroid/location/Location;I)V
    //   126: aload_0
    //   127: invokevirtual 395	com/baidu/location/f/d:m	()Z
    //   130: ifeq -92 -> 38
    //   133: aload_0
    //   134: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   137: ifnull -99 -> 38
    //   140: invokestatic 464	com/baidu/location/indoor/d:a	()Lcom/baidu/location/indoor/d;
    //   143: invokevirtual 466	com/baidu/location/indoor/d:g	()Z
    //   146: ifeq +316 -> 462
    //   149: invokestatic 464	com/baidu/location/indoor/d:a	()Lcom/baidu/location/indoor/d;
    //   152: aload_0
    //   153: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   156: invokevirtual 467	com/baidu/location/indoor/d:a	(Landroid/location/Location;)Z
    //   159: ifne +303 -> 462
    //   162: aload_1
    //   163: ifnull +286 -> 449
    //   166: invokestatic 472	com/baidu/location/d/c:a	()Lcom/baidu/location/d/c;
    //   169: aload_1
    //   170: getstatic 69	com/baidu/location/f/d:n	I
    //   173: aload_0
    //   174: getfield 121	com/baidu/location/f/d:D	D
    //   177: invokevirtual 475	com/baidu/location/d/c:a	(Landroid/location/Location;ID)V
    //   180: getstatic 67	com/baidu/location/f/d:m	I
    //   183: iconst_2
    //   184: if_icmple -146 -> 38
    //   187: aload_0
    //   188: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   191: iconst_1
    //   192: invokestatic 478	com/baidu/location/a/m:a	(Landroid/location/Location;Z)Z
    //   195: ifeq -157 -> 38
    //   198: invokestatic 315	com/baidu/location/f/f:a	()Lcom/baidu/location/f/f;
    //   201: invokevirtual 317	com/baidu/location/f/f:f	()Z
    //   204: istore 5
    //   206: new 319	com/baidu/location/f/a
    //   209: dup
    //   210: invokestatic 324	com/baidu/location/f/b:a	()Lcom/baidu/location/f/b;
    //   213: invokevirtual 327	com/baidu/location/f/b:f	()Lcom/baidu/location/f/a;
    //   216: invokespecial 330	com/baidu/location/f/a:<init>	(Lcom/baidu/location/f/a;)V
    //   219: invokestatic 334	com/baidu/location/a/k:a	(Lcom/baidu/location/f/a;)V
    //   222: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   225: invokestatic 342	com/baidu/location/a/k:a	(J)V
    //   228: new 151	android/location/Location
    //   231: dup
    //   232: aload_0
    //   233: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   236: invokespecial 344	android/location/Location:<init>	(Landroid/location/Location;)V
    //   239: invokestatic 346	com/baidu/location/a/k:a	(Landroid/location/Location;)V
    //   242: invokestatic 308	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
    //   245: invokevirtual 310	com/baidu/location/a/a:f	()Ljava/lang/String;
    //   248: invokestatic 347	com/baidu/location/a/k:a	(Ljava/lang/String;)V
    //   251: iload 5
    //   253: ifne -215 -> 38
    //   256: invokestatic 349	com/baidu/location/a/k:c	()Lcom/baidu/location/f/a;
    //   259: aconst_null
    //   260: invokestatic 352	com/baidu/location/a/k:d	()Landroid/location/Location;
    //   263: invokestatic 308	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
    //   266: invokevirtual 310	com/baidu/location/a/a:f	()Ljava/lang/String;
    //   269: invokestatic 357	com/baidu/location/a/m:a	(Lcom/baidu/location/f/a;Lcom/baidu/location/f/e;Landroid/location/Location;Ljava/lang/String;)V
    //   272: return
    //   273: new 151	android/location/Location
    //   276: dup
    //   277: aload_0
    //   278: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   281: invokespecial 344	android/location/Location:<init>	(Landroid/location/Location;)V
    //   284: astore_1
    //   285: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   288: lstore 6
    //   290: aload_0
    //   291: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   294: lload 6
    //   296: invokevirtual 481	android/location/Location:setTime	(J)V
    //   299: aload_0
    //   300: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   303: invokevirtual 155	android/location/Location:getSpeed	()F
    //   306: f2d
    //   307: ldc2_w 156
    //   310: dmul
    //   311: d2f
    //   312: fstore_2
    //   313: aload_0
    //   314: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   317: invokevirtual 161	android/location/Location:hasSpeed	()Z
    //   320: ifne +6 -> 326
    //   323: ldc -107
    //   325: fstore_2
    //   326: iload 4
    //   328: istore_3
    //   329: iload 4
    //   331: ifne +17 -> 348
    //   334: aload_0
    //   335: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   338: invokevirtual 415	android/location/Location:getExtras	()Landroid/os/Bundle;
    //   341: ldc_w 417
    //   344: invokevirtual 423	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   347: istore_3
    //   348: aload_0
    //   349: getstatic 186	java/util/Locale:CHINA	Ljava/util/Locale;
    //   352: ldc_w 483
    //   355: bipush 6
    //   357: anewarray 4	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: aload_0
    //   363: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   366: invokevirtual 191	android/location/Location:getLongitude	()D
    //   369: invokestatic 197	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   372: aastore
    //   373: dup
    //   374: iconst_1
    //   375: aload_0
    //   376: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   379: invokevirtual 200	android/location/Location:getLatitude	()D
    //   382: invokestatic 197	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   385: aastore
    //   386: dup
    //   387: iconst_2
    //   388: fload_2
    //   389: invokestatic 205	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   392: aastore
    //   393: dup
    //   394: iconst_3
    //   395: aload_0
    //   396: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   399: invokevirtual 180	android/location/Location:getBearing	()F
    //   402: invokestatic 205	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   405: aastore
    //   406: dup
    //   407: iconst_4
    //   408: iload_3
    //   409: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   412: aastore
    //   413: dup
    //   414: iconst_5
    //   415: lload 6
    //   417: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   420: aastore
    //   421: invokestatic 225	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   424: putfield 103	com/baidu/location/f/d:r	Ljava/lang/String;
    //   427: aload_0
    //   428: aload_0
    //   429: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   432: invokevirtual 191	android/location/Location:getLongitude	()D
    //   435: aload_0
    //   436: getfield 427	com/baidu/location/f/d:f	Landroid/location/Location;
    //   439: invokevirtual 200	android/location/Location:getLatitude	()D
    //   442: fload_2
    //   443: invokespecial 485	com/baidu/location/f/d:a	(DDF)V
    //   446: goto -345 -> 101
    //   449: invokestatic 308	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
    //   452: aload_0
    //   453: invokevirtual 487	com/baidu/location/f/d:j	()Ljava/lang/String;
    //   456: invokevirtual 488	com/baidu/location/a/a:a	(Ljava/lang/String;)V
    //   459: goto -279 -> 180
    //   462: invokestatic 464	com/baidu/location/indoor/d:a	()Lcom/baidu/location/indoor/d;
    //   465: invokevirtual 466	com/baidu/location/indoor/d:g	()Z
    //   468: ifne +41 -> 509
    //   471: aload_1
    //   472: ifnull +24 -> 496
    //   475: invokestatic 472	com/baidu/location/d/c:a	()Lcom/baidu/location/d/c;
    //   478: aload_1
    //   479: getstatic 69	com/baidu/location/f/d:n	I
    //   482: aload_0
    //   483: getfield 121	com/baidu/location/f/d:D	D
    //   486: invokevirtual 475	com/baidu/location/d/c:a	(Landroid/location/Location;ID)V
    //   489: goto -309 -> 180
    //   492: astore_1
    //   493: goto -313 -> 180
    //   496: invokestatic 308	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
    //   499: aload_0
    //   500: invokevirtual 487	com/baidu/location/f/d:j	()Ljava/lang/String;
    //   503: invokevirtual 488	com/baidu/location/a/a:a	(Ljava/lang/String;)V
    //   506: goto -326 -> 180
    //   509: invokestatic 308	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
    //   512: aload_0
    //   513: invokevirtual 487	com/baidu/location/f/d:j	()Ljava/lang/String;
    //   516: invokevirtual 488	com/baidu/location/a/a:a	(Ljava/lang/String;)V
    //   519: goto -339 -> 180
    //   522: astore_1
    //   523: goto -343 -> 180
    //   526: astore 8
    //   528: goto -402 -> 126
    //   531: astore 8
    //   533: goto -421 -> 112
    //   536: astore 8
    //   538: iload 4
    //   540: istore_3
    //   541: goto -193 -> 348
    //   544: astore 8
    //   546: iload 4
    //   548: istore_3
    //   549: goto -521 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	d
    //   0	552	1	paramLocation	Location
    //   312	131	2	f1	float
    //   11	538	3	i1	int
    //   7	540	4	i2	int
    //   204	48	5	bool	boolean
    //   288	128	6	l1	long
    //   526	1	8	localException1	Exception
    //   531	1	8	localException2	Exception
    //   536	1	8	localException3	Exception
    //   544	1	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   475	489	492	java/lang/Exception
    //   166	180	522	java/lang/Exception
    //   116	126	526	java/lang/Exception
    //   101	112	531	java/lang/Exception
    //   334	348	536	java/lang/Exception
    //   17	28	544	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c();
      return;
    }
    e();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = com.baidu.location.f.isServing;
        if (!bool) {
          return;
        }
        this.d = com.baidu.location.f.getServiceContext();
      }
      finally {}
      try
      {
        this.e = ((LocationManager)this.d.getSystemService("location"));
        if (this.k) {
          break label120;
        }
        this.l = new b(null);
        this.e.addGpsStatusListener(this.l);
        this.h = new d(null);
        this.e.requestLocationUpdates("passive", 9000L, 0.0F, this.h);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.v = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (!com.baidu.location.f.isServing) {
            return;
          }
          switch (paramAnonymousMessage.what)
          {
          case 2: 
          default: 
            return;
          case 1: 
            d.a(d.this, (Location)paramAnonymousMessage.obj);
            return;
          case 3: 
            d.a(d.this, "&og=1", (Location)paramAnonymousMessage.obj);
            return;
          }
          d.a(d.this, "&og=2", (Location)paramAnonymousMessage.obj);
        }
      };
      continue;
      label120:
      this.j = new a(null);
      this.e.registerGnssStatusCallback(this.j);
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: getstatic 540	com/baidu/location/h/a:a	Ljava/lang/String;
    //   3: ldc_w 542
    //   6: invokestatic 547	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield 101	com/baidu/location/f/d:q	Z
    //   14: ifeq +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: new 14	com/baidu/location/f/d$c
    //   22: dup
    //   23: aload_0
    //   24: aconst_null
    //   25: invokespecial 548	com/baidu/location/f/d$c:<init>	(Lcom/baidu/location/f/d;Lcom/baidu/location/f/d$1;)V
    //   28: putfield 89	com/baidu/location/f/d:g	Lcom/baidu/location/f/d$c;
    //   31: new 419	android/os/Bundle
    //   34: dup
    //   35: invokespecial 549	android/os/Bundle:<init>	()V
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 87	com/baidu/location/f/d:e	Landroid/location/LocationManager;
    //   43: ldc_w 551
    //   46: ldc_w 553
    //   49: aload_1
    //   50: invokevirtual 557	android/location/LocationManager:sendExtraCommand	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 87	com/baidu/location/f/d:e	Landroid/location/LocationManager;
    //   58: ldc_w 551
    //   61: ldc2_w 78
    //   64: fconst_0
    //   65: aload_0
    //   66: getfield 89	com/baidu/location/f/d:g	Lcom/baidu/location/f/d$c;
    //   69: invokevirtual 526	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   72: aload_0
    //   73: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   76: putfield 123	com/baidu/location/f/d:E	J
    //   79: invokestatic 432	com/baidu/location/d/g:a	()Lcom/baidu/location/d/g;
    //   82: invokevirtual 435	com/baidu/location/d/g:c	()Lcom/baidu/location/d/m;
    //   85: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   88: invokevirtual 559	com/baidu/location/d/m:e	(J)V
    //   91: aload_0
    //   92: iconst_1
    //   93: putfield 101	com/baidu/location/f/d:q	Z
    //   96: return
    //   97: astore_1
    //   98: return
    //   99: astore_1
    //   100: goto -46 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	d
    //   38	12	1	localBundle	Bundle
    //   97	1	1	localException1	Exception
    //   99	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   18	31	97	java/lang/Exception
    //   54	96	97	java/lang/Exception
    //   31	54	99	java/lang/Exception
  }
  
  public boolean d()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.E;
    boolean bool = false;
    if (Math.abs(l1 - l2) < 1700L) {
      bool = true;
    }
    return bool;
  }
  
  public void e()
  {
    if (!this.q) {
      return;
    }
    if (this.e != null) {}
    try
    {
      if (this.g != null)
      {
        this.e.removeUpdates(this.g);
        com.baidu.location.d.g.a().c().a();
      }
      com.baidu.location.h.g.d = 0;
      com.baidu.location.h.g.u = 0;
      this.g = null;
      this.q = false;
      b(false);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void f()
  {
    for (;;)
    {
      try
      {
        e();
        LocationManager localLocationManager = this.e;
        if (localLocationManager == null) {
          return;
        }
      }
      finally {}
      try
      {
        if (this.l != null) {
          this.e.removeGpsStatusListener(this.l);
        }
        if ((this.k) && (this.j != null)) {
          this.e.unregisterGnssStatusCallback(this.j);
        }
        this.e.removeUpdates(this.h);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.l = null;
      this.e = null;
    }
  }
  
  public boolean g()
  {
    return this.q;
  }
  
  public String h()
  {
    if ((m()) && (this.f != null)) {
      return a(this.f);
    }
    return null;
  }
  
  public String i()
  {
    if ((m()) && (this.f != null)) {
      return String.format("%s&idgps_tp=%s", new Object[] { a(this.f).replaceAll("ll", "idll").replaceAll("&d=", "&idd=").replaceAll("&s", "&ids="), this.f.getProvider() });
    }
    return null;
  }
  
  public String j()
  {
    Object localObject = null;
    String str;
    float f1;
    int i2;
    int i1;
    if (this.f != null)
    {
      str = "{\"result\":{\"time\":\"" + com.baidu.location.h.g.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"";
      if (!this.f.hasAccuracy()) {
        break label348;
      }
      f1 = this.f.getAccuracy();
      i2 = (int)f1;
      f1 = (float)(this.f.getSpeed() * 3.6D);
      if (!this.f.hasSpeed()) {
        f1 = -1.0F;
      }
      if (!com.baidu.location.h.d.a().a(this.f.getLongitude(), this.f.getLatitude())) {
        break label355;
      }
      localObject = Jni.coorEncrypt(this.f.getLongitude(), this.f.getLatitude(), "gps2gcj");
      if ((localObject[0] > 0.0D) || (localObject[1] > 0.0D)) {
        break label407;
      }
      localObject[0] = this.f.getLongitude();
      localObject[1] = this.f.getLatitude();
      i1 = 1;
    }
    for (;;)
    {
      str = String.format(Locale.CHINA, str, new Object[] { Double.valueOf(localObject[0]), Double.valueOf(localObject[1]), Integer.valueOf(i2), Float.valueOf(this.f.getBearing()), Float.valueOf(f1), Integer.valueOf(m) });
      localObject = str;
      if (i1 == 0) {
        localObject = str + ",\"in_cn\":\"0\"";
      }
      if (this.f.hasAltitude())
      {
        localObject = (String)localObject + String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[] { Double.valueOf(this.f.getAltitude()) });
        return (String)localObject;
        label348:
        f1 = 10.0F;
        break;
        label355:
        localObject = new double[] { this.f.getLongitude(), this.f.getLatitude() };
        i1 = 0;
        continue;
      }
      return (String)localObject + "}}";
      label407:
      i1 = 1;
    }
  }
  
  public Location k()
  {
    if (this.f == null) {}
    while (Math.abs(System.currentTimeMillis() - this.f.getTime()) > 60000L) {
      return null;
    }
    return this.f;
  }
  
  public boolean l()
  {
    try
    {
      if ((this.f == null) || (this.f.getLatitude() == 0.0D) || (this.f.getLongitude() == 0.0D)) {
        break label60;
      }
      if (m <= 2)
      {
        int i1 = this.f.getExtras().getInt("satellites", 3);
        if (i1 <= 2) {
          break label60;
        }
      }
    }
    catch (Exception localException)
    {
      label60:
      do
      {
        if ((this.f == null) || (this.f.getLatitude() == 0.0D)) {
          break;
        }
      } while (this.f.getLongitude() != 0.0D);
    }
    return true;
    return false;
    return false;
  }
  
  public boolean m()
  {
    if (!l()) {}
    while (System.currentTimeMillis() - this.t > 10000L) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    if ((this.p) && (l1 - this.o < 3000L)) {
      return true;
    }
    return this.s;
  }
  
  private class a
    extends GnssStatus.Callback
  {
    private a() {}
    
    public void onFirstFix(int paramInt) {}
    
    public void onSatelliteStatusChanged(GnssStatus paramGnssStatus)
    {
      int k = 0;
      if (d.c(d.this) == null) {
        return;
      }
      int i1 = paramGnssStatus.getSatelliteCount();
      int i = 0;
      int j;
      for (int m = 0; i < i1; m = j)
      {
        int n = k;
        j = m;
        if (paramGnssStatus.usedInFix(i))
        {
          m += 1;
          n = k;
          j = m;
          if (paramGnssStatus.getConstellationType(i) == 1)
          {
            n = k + 1;
            j = m;
          }
        }
        i += 1;
        k = n;
      }
      d.a(m);
      d.b(k);
    }
    
    public void onStarted() {}
    
    public void onStopped()
    {
      d.b(d.this, null);
      d.a(d.this, false);
      d.a(0);
    }
  }
  
  private class b
    implements GpsStatus.Listener
  {
    long a = 0L;
    private long c = 0L;
    private final int d = 400;
    private boolean e = false;
    private List<String> f = new ArrayList();
    private String g = null;
    private String h = null;
    private String i = null;
    private long j = 0L;
    
    private b() {}
    
    public void onGpsStatusChanged(int paramInt)
    {
      if (d.c(d.this) == null) {}
      for (;;)
      {
        return;
        switch (paramInt)
        {
        case 3: 
        default: 
          return;
        case 2: 
          d.b(d.this, null);
          d.a(d.this, false);
          d.a(0);
          return;
        }
        if (d.a(d.this)) {
          try
          {
            if (d.d(d.this) == null) {
              d.a(d.this, d.c(d.this).getGpsStatus(null));
            }
            double d1;
            int k;
            for (;;)
            {
              Iterator localIterator = d.d(d.this).getSatellites().iterator();
              d.a(d.this, 0);
              d.b(d.this, 0);
              d.a(d.this, new HashMap());
              paramInt = 0;
              d1 = 0.0D;
              k = 0;
              while (localIterator.hasNext())
              {
                GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
                if (localGpsSatellite.usedInFix())
                {
                  int n = paramInt + 1;
                  double d2 = d1 + localGpsSatellite.getSnr();
                  int m = k;
                  if (localGpsSatellite.getPrn() <= 65) {
                    m = k + 1;
                  }
                  k = m;
                  d1 = d2;
                  paramInt = n;
                  if (localGpsSatellite.getSnr() >= com.baidu.location.h.g.G)
                  {
                    d.e(d.this);
                    k = m;
                    d1 = d2;
                    paramInt = n;
                  }
                }
              }
              d.c(d.this).getGpsStatus(d.d(d.this));
            }
            if (k > 0) {
              d.b(k);
            }
            if (paramInt > 0)
            {
              this.j = System.currentTimeMillis();
              d.a(d.this, d1 / paramInt);
              d.a(paramInt);
              return;
            }
            if (System.currentTimeMillis() - this.j > 100L)
            {
              this.j = System.currentTimeMillis();
              d.a(paramInt);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    }
  }
  
  private class c
    implements LocationListener
  {
    private c() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      d.a(d.this, System.currentTimeMillis());
      d.a(d.this, true);
      d.b(d.this, paramLocation);
      d.b(d.this, false);
    }
    
    public void onProviderDisabled(String paramString)
    {
      d.b(d.this, null);
      d.a(d.this, false);
    }
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        d.b(d.this, null);
        d.a(d.this, false);
        return;
      case 1: 
        d.b(d.this, System.currentTimeMillis());
        d.b(d.this, true);
        d.a(d.this, false);
        return;
      }
      d.b(d.this, false);
    }
  }
  
  private class d
    implements LocationListener
  {
    private long b = 0L;
    
    private d() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      if (d.a(d.this)) {}
      while ((paramLocation == null) || (paramLocation.getProvider() != "gps") || (System.currentTimeMillis() - this.b < 10000L) || (!com.baidu.location.a.m.a(paramLocation, false))) {
        return;
      }
      this.b = System.currentTimeMillis();
      paramLocation = d.b(d.this).obtainMessage(4, paramLocation);
      d.b(d.this).sendMessage(paramLocation);
    }
    
    public void onProviderDisabled(String paramString) {}
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */