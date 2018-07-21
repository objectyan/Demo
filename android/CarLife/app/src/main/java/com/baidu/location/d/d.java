package com.baidu.location.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.a.a;
import com.baidu.location.a.h;
import com.baidu.location.f;
import com.baidu.location.h.b;
import com.baidu.location.h.g;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class d
{
  public static String f = "0";
  public static int g = 6;
  private static final char[] q = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private boolean A = false;
  private int B = 0;
  private int C = 0;
  private byte[] D = null;
  private List<b> E = new ArrayList();
  private byte F = 0;
  private byte G = 0;
  private boolean H = false;
  private a I;
  boolean a = true;
  long b = 0L;
  Location c = null;
  StringBuilder d = null;
  long e = 0L;
  FileChannel h = null;
  FileLock i = null;
  RandomAccessFile j = null;
  boolean k = false;
  int l = 0;
  double m = 116.22345545D;
  double n = 40.245667323D;
  private int o = 500;
  private int p = 15000;
  private Handler r = null;
  private byte[] s = new byte[4];
  private byte[] t = null;
  private byte[] u = null;
  private boolean v = true;
  private int w = 0;
  private List<Byte> x = null;
  private List<Byte> y = null;
  private long z = 0L;
  
  private d()
  {
    if (!this.A) {
      d();
    }
  }
  
  public static d a()
  {
    return c.a;
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  private String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: invokestatic 215	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   3: invokevirtual 218	java/util/UUID:toString	()Ljava/lang/String;
    //   6: astore 4
    //   8: new 220	java/net/URL
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 223	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 227	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 229	java/net/HttpURLConnection
    //   22: astore_2
    //   23: aload_2
    //   24: sipush 10000
    //   27: invokevirtual 233	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   30: aload_2
    //   31: sipush 10000
    //   34: invokevirtual 236	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   37: aload_2
    //   38: iconst_1
    //   39: invokevirtual 240	java/net/HttpURLConnection:setDoInput	(Z)V
    //   42: aload_2
    //   43: iconst_1
    //   44: invokevirtual 243	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   47: aload_2
    //   48: iconst_0
    //   49: invokevirtual 246	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   52: aload_2
    //   53: ldc -8
    //   55: invokevirtual 251	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   58: aload_2
    //   59: ldc -3
    //   61: ldc -1
    //   63: invokevirtual 259	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_2
    //   67: ldc_w 261
    //   70: ldc_w 263
    //   73: invokevirtual 259	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_2
    //   77: ldc_w 265
    //   80: new 267	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 270
    //   90: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 276
    //   96: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 4
    //   101: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokevirtual 259	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ifnull +194 -> 305
    //   114: aload_1
    //   115: invokevirtual 283	java/io/File:exists	()Z
    //   118: ifeq +187 -> 305
    //   121: aload_2
    //   122: invokevirtual 287	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   125: astore 5
    //   127: new 289	java/io/DataOutputStream
    //   130: dup
    //   131: aload 5
    //   133: invokespecial 292	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   136: astore 6
    //   138: new 294	java/lang/StringBuffer
    //   141: dup
    //   142: invokespecial 295	java/lang/StringBuffer:<init>	()V
    //   145: astore 7
    //   147: aload 7
    //   149: ldc_w 297
    //   152: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   155: pop
    //   156: aload 7
    //   158: aload 4
    //   160: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   163: pop
    //   164: aload 7
    //   166: ldc_w 302
    //   169: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   172: pop
    //   173: aload 7
    //   175: new 267	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 304
    //   185: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 307	java/io/File:getName	()Ljava/lang/String;
    //   192: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 309
    //   198: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 302
    //   204: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   213: pop
    //   214: aload 7
    //   216: new 267	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 311
    //   226: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 302
    //   232: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   241: pop
    //   242: aload 7
    //   244: ldc_w 302
    //   247: invokevirtual 300	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   250: pop
    //   251: aload 6
    //   253: aload 7
    //   255: invokevirtual 312	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   258: invokevirtual 318	java/lang/String:getBytes	()[B
    //   261: invokevirtual 322	java/io/DataOutputStream:write	([B)V
    //   264: new 324	java/io/FileInputStream
    //   267: dup
    //   268: aload_1
    //   269: invokespecial 327	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   272: astore_1
    //   273: sipush 1024
    //   276: newarray <illegal type>
    //   278: astore 7
    //   280: aload_1
    //   281: aload 7
    //   283: invokevirtual 333	java/io/InputStream:read	([B)I
    //   286: istore_3
    //   287: iload_3
    //   288: iconst_m1
    //   289: if_icmpeq +19 -> 308
    //   292: aload 6
    //   294: aload 7
    //   296: iconst_0
    //   297: iload_3
    //   298: invokevirtual 336	java/io/DataOutputStream:write	([BII)V
    //   301: goto -21 -> 280
    //   304: astore_1
    //   305: ldc 90
    //   307: areturn
    //   308: aload_1
    //   309: invokevirtual 338	java/io/InputStream:close	()V
    //   312: aload 6
    //   314: ldc_w 302
    //   317: invokevirtual 318	java/lang/String:getBytes	()[B
    //   320: invokevirtual 322	java/io/DataOutputStream:write	([B)V
    //   323: aload 6
    //   325: new 267	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 297
    //   335: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 4
    //   340: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: ldc_w 297
    //   346: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc_w 302
    //   352: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 318	java/lang/String:getBytes	()[B
    //   361: invokevirtual 322	java/io/DataOutputStream:write	([B)V
    //   364: aload 6
    //   366: invokevirtual 341	java/io/DataOutputStream:flush	()V
    //   369: aload 6
    //   371: invokevirtual 342	java/io/DataOutputStream:close	()V
    //   374: aload_2
    //   375: invokevirtual 346	java/net/HttpURLConnection:getResponseCode	()I
    //   378: istore_3
    //   379: aload 5
    //   381: invokevirtual 349	java/io/OutputStream:close	()V
    //   384: aload_2
    //   385: invokevirtual 352	java/net/HttpURLConnection:disconnect	()V
    //   388: iload_3
    //   389: sipush 200
    //   392: if_icmpne -87 -> 305
    //   395: ldc_w 354
    //   398: areturn
    //   399: astore_1
    //   400: goto -95 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	d
    //   0	403	1	paramFile	File
    //   0	403	2	paramString	String
    //   286	107	3	i1	int
    //   6	333	4	str	String
    //   125	255	5	localOutputStream	java.io.OutputStream
    //   136	234	6	localDataOutputStream	java.io.DataOutputStream
    //   145	150	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	110	304	java/net/MalformedURLException
    //   114	280	304	java/net/MalformedURLException
    //   280	287	304	java/net/MalformedURLException
    //   292	301	304	java/net/MalformedURLException
    //   308	388	304	java/net/MalformedURLException
    //   8	110	399	java/lang/Exception
    //   114	280	399	java/lang/Exception
    //   280	287	399	java/lang/Exception
    //   292	301	399	java/lang/Exception
    //   308	388	399	java/lang/Exception
  }
  
  private void a(Location paramLocation)
  {
    int i2 = 1;
    this.e = System.currentTimeMillis();
    b((int)(paramLocation.getTime() / 1000L));
    b((int)(paramLocation.getLongitude() * 1000000.0D));
    b((int)(paramLocation.getLatitude() * 1000000.0D));
    int i1;
    if (paramLocation.hasBearing())
    {
      i1 = 0;
      if (paramLocation.hasSpeed()) {
        i2 = 0;
      }
      if (i1 <= 0) {
        break label169;
      }
      this.x.add(Byte.valueOf((byte)32));
      label87:
      if (i2 <= 0) {
        break label205;
      }
      this.x.add(Byte.valueOf((byte)Byte.MIN_VALUE));
    }
    for (;;)
    {
      if (com.baidu.location.f.d.a().m())
      {
        l.a().b();
        l.a().e();
        if ((this.H) && (this.I != null))
        {
          this.r.removeCallbacks(this.I);
          this.H = false;
        }
      }
      this.c = paramLocation;
      return;
      i1 = 1;
      break;
      label169:
      byte b1 = (byte)((byte)((int)(paramLocation.getBearing() / 15.0F) & 0xFF) & 0xFFFFFFDF);
      this.x.add(Byte.valueOf(b1));
      break label87;
      label205:
      b1 = (byte)((byte)((int)(paramLocation.getSpeed() * 3.6D / 4.0D) & 0xFF) & 0x7F);
      this.x.add(Byte.valueOf(b1));
    }
  }
  
  private byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
  }
  
  private byte[] a(String paramString)
  {
    int i4 = 0;
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getBytes();
    int i1 = (byte)new Random().nextInt(255);
    int i2 = (byte)new Random().nextInt(255);
    byte[] arrayOfByte = new byte[paramString.length + 2];
    int i5 = paramString.length;
    int i3 = 0;
    while (i4 < i5)
    {
      arrayOfByte[i3] = ((byte)(paramString[i4] ^ i1));
      i4 += 1;
      i3 += 1;
    }
    i4 = i3 + 1;
    arrayOfByte[i3] = i1;
    arrayOfByte[i4] = i2;
    return arrayOfByte;
  }
  
  private void b(int paramInt)
  {
    byte[] arrayOfByte = a(paramInt);
    paramInt = 0;
    while (paramInt < 4)
    {
      this.x.add(Byte.valueOf(arrayOfByte[paramInt]));
      paramInt += 1;
    }
  }
  
  private void b(Location paramLocation)
  {
    int i4 = 0;
    int i6 = (int)((paramLocation.getLongitude() - this.c.getLongitude()) * 1000000.0D);
    int i5 = (int)((paramLocation.getLatitude() - this.c.getLatitude()) * 1000000.0D);
    int i1;
    int i2;
    label61:
    int i3;
    label69:
    label81:
    byte b2;
    if (paramLocation.hasBearing())
    {
      i1 = 0;
      if (!paramLocation.hasSpeed()) {
        break label250;
      }
      i2 = 0;
      if (i6 <= 0) {
        break label256;
      }
      i3 = 0;
      i6 = Math.abs(i6);
      if (i5 <= 0) {
        break label262;
      }
      i5 = Math.abs(i5);
      this.c = paramLocation;
      this.x.add(Byte.valueOf((byte)(i6 & 0xFF)));
      this.x.add(Byte.valueOf((byte)((i6 & 0xFF00) >> 8)));
      this.x.add(Byte.valueOf((byte)(i5 & 0xFF)));
      this.x.add(Byte.valueOf((byte)((i5 & 0xFF00) >> 8)));
      if (i1 <= 0) {
        break label268;
      }
      b1 = 32;
      if (i4 > 0) {
        b1 = (byte)96;
      }
      b2 = b1;
      if (i3 > 0) {
        b2 = (byte)(b1 | 0xFFFFFF80);
      }
      this.x.add(Byte.valueOf(b2));
    }
    for (;;)
    {
      if (i2 <= 0) {
        break label330;
      }
      this.x.add(Byte.valueOf((byte)Byte.MIN_VALUE));
      return;
      i1 = 1;
      break;
      label250:
      i2 = 1;
      break label61;
      label256:
      i3 = 1;
      break label69;
      label262:
      i4 = 1;
      break label81;
      label268:
      b2 = (byte)((byte)((int)(paramLocation.getBearing() / 15.0F) & 0xFF) & 0x1F);
      b1 = b2;
      if (i4 > 0) {
        b1 = (byte)(b2 | 0x40);
      }
      b2 = b1;
      if (i3 > 0) {
        b2 = (byte)(b1 | 0xFFFFFF80);
      }
      this.x.add(Byte.valueOf(b2));
    }
    label330:
    byte b1 = (byte)((byte)((int)(paramLocation.getSpeed() * 3.6D / 4.0D) & 0xFF) & 0x7F);
    this.x.add(Byte.valueOf(b1));
  }
  
  private void b(Location paramLocation, int paramInt)
  {
    c(paramLocation, paramInt);
    f();
    h();
  }
  
  private void c(Location paramLocation, int paramInt)
  {
    if ((System.currentTimeMillis() - this.b < this.o) || (paramLocation == null)) {
      return;
    }
    this.b = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (this.x != null) {
          continue;
        }
        this.x = new ArrayList();
        g();
        a(paramLocation);
        if (this.y != null)
        {
          this.y.clear();
          this.y = null;
        }
        this.y = new ArrayList();
        if (!paramLocation.hasAccuracy()) {
          continue;
        }
        if (paramLocation.getAccuracy() <= 127.0F) {
          continue;
        }
        this.y.add(Byte.valueOf((byte)Byte.MAX_VALUE));
        if (paramInt <= 0) {
          continue;
        }
        this.y.add(Byte.valueOf((byte)(paramInt & 0xFF)));
      }
      catch (Exception paramLocation)
      {
        continue;
      }
      this.w += 1;
      if (this.w != 9) {
        break;
      }
      j.b().c();
      return;
      this.y.add(Byte.valueOf((byte)((int)paramLocation.getAccuracy() & 0x7F)));
      continue;
      this.y.add(Byte.valueOf((byte)-1));
      continue;
      this.y.add(Byte.valueOf((byte)0));
      continue;
      b(paramLocation);
      if (this.y != null)
      {
        if (paramLocation.hasAccuracy())
        {
          if (paramLocation.getAccuracy() > 127.0F)
          {
            this.y.add(Byte.valueOf((byte)Byte.MAX_VALUE));
            if (paramInt > 0) {
              this.y.add(Byte.valueOf((byte)(paramInt & 0xFF)));
            }
          }
          else
          {
            this.y.add(Byte.valueOf((byte)((int)paramLocation.getAccuracy() & 0x7F)));
            continue;
          }
        }
        else
        {
          this.y.add(Byte.valueOf((byte)-1));
          continue;
        }
        this.y.add(Byte.valueOf((byte)0));
      }
    }
  }
  
  private void f()
  {
    if ((this.e == 0L) || (System.currentTimeMillis() - this.e < this.p)) {}
    do
    {
      return;
      if (!this.H)
      {
        if (this.I == null) {
          this.I = new a(null);
        }
        this.H = true;
        this.r.postDelayed(this.I, 10000L);
      }
    } while (this.x == null);
    if (this.D != null)
    {
      this.x.add(Byte.valueOf((byte)85));
      this.x.add(Byte.valueOf((byte)(this.B & 0xFF)));
      this.x.add(Byte.valueOf((byte)(this.C & 0xFF)));
      i1 = 0;
      while (i1 < this.D.length)
      {
        this.x.add(Byte.valueOf(this.D[i1]));
        i1 += 1;
      }
    }
    Object localObject2;
    if ((this.E != null) && (this.E.size() > 0))
    {
      this.x.add(Byte.valueOf((byte)86));
      this.x.add(Byte.valueOf((byte)(this.E.size() & 0xFF)));
      localObject1 = this.E.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        this.x.add(Byte.valueOf((byte)(((b)localObject2).a & 0xFF)));
        this.x.add(Byte.valueOf(((b)localObject2).b));
        this.x.add(Byte.valueOf((byte)(((b)localObject2).c & 0xFF)));
        this.x.add(Byte.valueOf((byte)((((b)localObject2).c & 0xFF00) >> 8)));
      }
      this.E.clear();
    }
    if ((this.u != null) && (this.z != 0L))
    {
      this.x.add(Byte.valueOf((byte)83));
      if (this.v) {
        this.v = false;
      }
      for (;;)
      {
        i1 = 0;
        while (i1 < 6)
        {
          this.x.add(Byte.valueOf(this.u[i1]));
          i1 += 1;
        }
        if (com.baidu.location.f.d.a().m())
        {
          this.u[0] = ((byte)(this.u[0] & 0x7F));
          i1 = (byte)((byte)(this.w - 1 & 0xFF) << 2);
          this.u[5] = ((byte)(i1 | 0x2));
        }
        else
        {
          this.u[0] = ((byte)(this.u[0] | 0x80));
          i1 = (byte)((byte)(this.w - 1 & 0xFF) << 2);
          this.u[5] = ((byte)(i1 | 0x2));
        }
      }
      if (System.currentTimeMillis() - this.z > 7200000L) {
        this.u = null;
      }
    }
    Object localObject1 = l.a().d();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      i2 = ((List)localObject1).size();
      i1 = 0;
      while (i1 < i2)
      {
        this.x.add(((List)localObject1).get(i1));
        i1 += 1;
      }
    }
    if (this.y != null)
    {
      i2 = this.y.size();
      if (i2 == this.w * 2)
      {
        this.x.add(Byte.valueOf((byte)81));
        this.x.add(Byte.valueOf((byte)(this.w & 0xFF)));
        i1 = 0;
        while (i1 < i2)
        {
          this.x.add(this.y.get(i1));
          i1 += 1;
        }
      }
    }
    int i2 = this.x.size();
    this.x.set(0, Byte.valueOf((byte)(i2 & 0xFF)));
    this.x.set(1, Byte.valueOf((byte)((0xFF00 & i2) >> 8)));
    this.x.set(3, Byte.valueOf((byte)(this.w & 0xFF)));
    if ((!f.equals("0")) && (!a.a().c())) {
      this.x.set(2, Byte.valueOf((byte)-71));
    }
    localObject1 = new byte[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      localObject1[i1] = ((Byte)this.x.get(i1)).byteValue();
      i1 += 1;
    }
    if (a.a().c())
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putByteArray("gpsintimedata", (byte[])localObject1);
      a.a().a((Bundle)localObject2, 501);
    }
    for (;;)
    {
      this.x = null;
      this.y = null;
      this.e = 0L;
      this.w = 0;
      this.B = 0;
      this.C = 0;
      this.D = null;
      return;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localObject2 = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (((File)localObject2).exists())
        {
          localObject2 = new File((File)localObject2, "intime.dat");
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          try
          {
            localObject2 = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            ((BufferedOutputStream)localObject2).write((byte[])localObject1);
            ((BufferedOutputStream)localObject2).flush();
            ((BufferedOutputStream)localObject2).close();
            new Thread()
            {
              public void run()
              {
                File localFile = new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat");
                d.a(d.this, localFile, "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
              }
            }.start();
          }
          catch (Exception localException) {}
        }
      }
    }
  }
  
  private void g()
  {
    int i1 = 0;
    this.x.add(Byte.valueOf((byte)0));
    this.x.add(Byte.valueOf((byte)0));
    if (f.equals("0")) {
      this.x.add(Byte.valueOf((byte)-86));
    }
    for (;;)
    {
      this.x.add(Byte.valueOf((byte)0));
      this.x.add(Byte.valueOf(this.s[0]));
      this.x.add(Byte.valueOf(this.s[1]));
      this.x.add(Byte.valueOf(this.s[2]));
      this.x.add(Byte.valueOf(this.s[3]));
      int i2 = this.t.length;
      this.x.add(Byte.valueOf((byte)(i2 + 1 & 0xFF)));
      while (i1 < i2)
      {
        this.x.add(Byte.valueOf(this.t[i1]));
        i1 += 1;
      }
      this.x.add(Byte.valueOf((byte)-70));
    }
  }
  
  private void h()
  {
    if (this.k) {
      return;
    }
    this.r.postDelayed(new Runnable()
    {
      public void run()
      {
        d.this.k = false;
        if (!d.this.a) {}
        do
        {
          return;
          d.h(d.this);
        } while (!com.baidu.location.f.d.a().g());
        d.j(d.this).postDelayed(this, d.i(d.this) + 5000);
        d.this.k = true;
      }
    }, this.p + 3000);
    this.k = true;
  }
  
  public void a(final Location paramLocation, final int paramInt)
  {
    if (!this.a) {
      return;
    }
    d();
    this.r.post(new Runnable()
    {
      public void run()
      {
        d.a(d.this, paramLocation, paramInt);
      }
    });
  }
  
  public void a(BDLocation paramBDLocation)
  {
    if ((!com.baidu.location.f.d.a().m()) && (this.u != null))
    {
      Object localObject = new BDLocation(paramBDLocation);
      paramBDLocation = new Location("network");
      double[] arrayOfDouble = new double[2];
      localObject = Jni.coorEncrypt(((BDLocation)localObject).getLongitude(), ((BDLocation)localObject).getLatitude(), "gcj2wgs");
      paramBDLocation.setLatitude(localObject[1]);
      paramBDLocation.setLongitude(localObject[0]);
      a(paramBDLocation, -1);
    }
  }
  
  public void b()
  {
    try
    {
      File localFile = new File(g.k() + File.separator + "gflk.dat");
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      if (this.j == null)
      {
        this.j = new RandomAccessFile(localFile, "rw");
        this.h = this.j.getChannel();
        this.i = this.h.tryLock();
      }
      return;
    }
    catch (Exception localException)
    {
      c();
    }
  }
  
  public void c()
  {
    try
    {
      if (this.i != null)
      {
        this.i.release();
        this.i = null;
      }
      if (this.h != null)
      {
        this.h.close();
        this.h = null;
      }
      if (this.j != null)
      {
        this.j.close();
        this.j = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d()
  {
    if (this.A) {
      return;
    }
    this.A = true;
    String str = a(f.getServiceContext());
    Object localObject = str;
    if (str == null) {
      localObject = "7.3.2";
    }
    localObject = ((String)localObject).split("\\.");
    int i2 = localObject.length;
    this.s[0] = 0;
    this.s[1] = 0;
    this.s[2] = 0;
    this.s[3] = 0;
    int i1 = i2;
    if (i2 >= 4) {
      i1 = 4;
    }
    i2 = 0;
    while (i2 < i1) {
      try
      {
        this.s[i2] = ((byte)(Integer.valueOf(localObject[i2]).intValue() & 0xFF));
        i2 += 1;
      }
      catch (Exception localException) {}
    }
    this.t = a(b.a().b);
    this.r = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        int j = 0;
        if (!f.isServing) {}
        int i;
        Object localObject;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (paramAnonymousMessage.what)
                {
                default: 
                  return;
                }
              } while (d.a(d.this) < 9);
              d.a(d.this, d.a(d.this));
              paramAnonymousMessage = paramAnonymousMessage.getData();
              d.b(d.this, paramAnonymousMessage.getInt("num", 0));
            } while ((d.b(d.this) <= 0) || (d.b(d.this) > 3));
            if (d.c(d.this) == null) {
              d.a(d.this, new byte[d.b(d.this) * 6]);
            }
            i = 0;
            while (i < d.b(d.this))
            {
              localObject = paramAnonymousMessage.getByteArray("mac" + i);
              j = 0;
              while (j < 6)
              {
                d.c(d.this)[(i * 6 + j)] = localObject[j];
                j += 1;
              }
              i += 1;
            }
            paramAnonymousMessage = paramAnonymousMessage.getData();
          } while (paramAnonymousMessage == null);
          paramAnonymousMessage = paramAnonymousMessage.getString("ugcInfo");
        } while (paramAnonymousMessage == null);
        d.a(d.this, (byte)0);
        d.b(d.this, (byte)0);
        if (paramAnonymousMessage.equals("0"))
        {
          d.f = "0";
          return;
        }
        d.f = "1";
        int m = d.a(d.this);
        int k;
        if (paramAnonymousMessage.contains("d"))
        {
          localObject = paramAnonymousMessage.split("d");
          if (localObject.length == 2)
          {
            i = Integer.valueOf(localObject[1]).intValue();
            if (localObject[0].equals("1"))
            {
              d.a(d.this, (byte)1);
              k = i;
            }
          }
        }
        for (;;)
        {
          label349:
          if (paramAnonymousMessage.equals("9")) {
            d.a(d.this, (byte)9);
          }
          if (paramAnonymousMessage.contains("g1")) {}
          for (i = 32;; i = 0)
          {
            if (paramAnonymousMessage.contains("f1")) {
              j = 16;
            }
            if (paramAnonymousMessage.contains("f0")) {
              j = 64;
            }
            if (paramAnonymousMessage.contains("g0")) {
              i = -128;
            }
            d.b(d.this, (byte)(j | i));
            byte b = (byte)(d.d(d.this) | d.e(d.this));
            if (b == 0) {
              break;
            }
            paramAnonymousMessage = new d.b(d.this, m, b, k);
            d.f(d.this).add(paramAnonymousMessage);
            return;
            if (localObject[0].equals("2"))
            {
              d.a(d.this, (byte)2);
              k = i;
              break label349;
            }
            if (localObject[0].equals("3"))
            {
              d.a(d.this, (byte)3);
              k = i;
              break label349;
            }
            if (localObject[0].equals("4"))
            {
              d.a(d.this, (byte)4);
              k = i;
              break label349;
            }
            if (localObject[0].equals("5"))
            {
              d.a(d.this, (byte)5);
              k = i;
              break label349;
            }
            if (localObject[0].equals("6"))
            {
              d.a(d.this, (byte)6);
              k = i;
              break label349;
            }
            if (localObject[0].equals("7"))
            {
              d.a(d.this, (byte)7);
              k = i;
              break label349;
            }
            k = i;
            if (!localObject[0].equals("8")) {
              break label349;
            }
            d.a(d.this, (byte)8);
            k = i;
            break label349;
            try
            {
              paramAnonymousMessage = paramAnonymousMessage.getData();
              k = paramAnonymousMessage.getInt("plan_order", -1);
              i = paramAnonymousMessage.getInt("type_value", -1);
              j = paramAnonymousMessage.getInt("time_stamp", 0);
              if ((k <= -1) || (i <= -1)) {
                break;
              }
              if ((i == 0) && (j > 0))
              {
                d.a(d.this, System.currentTimeMillis());
                if (d.a(d.this) > 0)
                {
                  if (d.g(d.this) == null) {
                    d.b(d.this, new byte[6]);
                  }
                  k = (byte)((byte)(k & 0xFF) << 4);
                  d.g(d.this)[0] = ((byte)(k | 0x1));
                  k = (byte)((byte)(d.a(d.this) - 1 & 0xFF) << 2);
                  d.g(d.this)[5] = ((byte)(k | (byte)(i & 0xFF)));
                  paramAnonymousMessage = d.c(d.this, j);
                  d.g(d.this)[1] = paramAnonymousMessage[0];
                  d.g(d.this)[2] = paramAnonymousMessage[1];
                  d.g(d.this)[3] = paramAnonymousMessage[2];
                  d.g(d.this)[4] = paramAnonymousMessage[3];
                  return;
                }
                paramAnonymousMessage = h.c().l();
                if ((paramAnonymousMessage == null) || (paramAnonymousMessage.getLatitude() <= 0.0D)) {
                  break;
                }
                if (d.g(d.this) == null) {
                  d.b(d.this, new byte[6]);
                }
                k = (byte)((byte)((byte)(k & 0xFF) | 0x8) << 4);
                d.g(d.this)[0] = ((byte)(k | 0x1));
                d.g(d.this)[5] = ((byte)(0x0 | (byte)(i & 0xFF)));
                localObject = d.c(d.this, j);
                d.g(d.this)[1] = localObject[0];
                d.g(d.this)[2] = localObject[1];
                d.g(d.this)[3] = localObject[2];
                d.g(d.this)[4] = localObject[3];
                d.this.a(paramAnonymousMessage);
                return;
              }
              if (i != 1) {
                break;
              }
              d.b(d.this, null);
              d.a(d.this, true);
              d.a(d.this, 0L);
              return;
            }
            catch (Exception paramAnonymousMessage) {}
          }
          k = 0;
        }
      }
    };
  }
  
  public Handler e()
  {
    return this.r;
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      d.b(d.this, false);
      l.a().c();
    }
  }
  
  private class b
  {
    int a = 0;
    byte b = 0;
    int c = 0;
    
    b(int paramInt1, byte paramByte, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramByte;
      this.c = paramInt2;
    }
  }
  
  private static class c
  {
    public static final d a = new d(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */