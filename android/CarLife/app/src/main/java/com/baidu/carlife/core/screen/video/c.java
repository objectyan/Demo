package com.baidu.carlife.core.screen.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.LocalSocket;
import com.baidu.carlife.core.i;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

class c
  extends a
{
  private static final String h = "ReceiverAndConverter";
  private static final String i = "--QA-TEST--";
  private static final String j = "/data/local/tmp/sc.sock";
  private static byte[] k;
  private static e l = ;
  private long m = e.e;
  private LocalSocket n;
  
  private void a(boolean paramBoolean, int paramInt)
    throws IOException
  {
    if (!l.s())
    {
      this.c.write(1);
      l.g(true);
    }
    this.b.readFully(d, 0, paramInt);
    this.c.write(1);
    if (paramBoolean) {
      JniMethod.convert(d, k, e.b, e.c);
    }
  }
  
  private void b(int paramInt)
    throws IOException
  {
    if (l.e())
    {
      if (l.s())
      {
        this.b.readFully(d, 0, paramInt);
        l.g(false);
      }
      if (l.M() == -1) {
        c();
      }
      try
      {
        Thread.sleep(50L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
    }
    if (!l.s())
    {
      this.c.write(1);
      l.g(true);
    }
    long l1 = System.currentTimeMillis();
    this.b.readFully(d, 0, paramInt);
    i.c("--QA-TEST--", "JAVA got frame time = " + (System.currentTimeMillis() - l1));
    e.rewind();
    f.copyPixelsFromBuffer(e);
    f.compress(Bitmap.CompressFormat.JPEG, 70, this.g);
    paramInt = this.g.size();
    if (l.a(this.g.toByteArray(), paramInt) == -1)
    {
      this.c.write(2);
      c();
    }
    this.c.write(1);
    this.g.reset();
    i.c("--QA-TEST--", "JAVA jpeg time = " + (System.currentTimeMillis() - l1) + ", length = " + paramInt);
  }
  
  private void c()
  {
    this.a = false;
    d();
    l.v();
    l.C();
  }
  
  private void c(int paramInt)
    throws IOException
  {
    if (l.e())
    {
      if (l.s())
      {
        this.b.readFully(d, 0, paramInt);
        l.g(false);
      }
      if (l.M() == -1) {
        c();
      }
      try
      {
        Thread.sleep(50L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
    }
    if (!l.s())
    {
      this.c.write(1);
      l.g(true);
    }
    long l1 = System.currentTimeMillis();
    this.b.readFully(d, 0, paramInt);
    i.c("--QA-TEST--", "JAVA got frame time = " + (System.currentTimeMillis() - l1));
    this.c.write(1);
    l1 = System.currentTimeMillis();
    JniMethod.convert(d, k, e.b, e.c);
    i.c("--QA-TEST--", "JAVA native convert time = " + (System.currentTimeMillis() - l1) + "~~~~~");
    l1 = System.currentTimeMillis();
    paramInt = l.a(k);
    long l2 = System.currentTimeMillis();
    long l3 = l.u();
    if (this.m * l.t() < l2 - l3) {
      paramInt = l.a(k);
    }
    if ((paramInt == -2) && (this.n == null)) {
      c();
    }
    i.c("--QA-TEST--", "JAVA input2Encoder time = " + (System.currentTimeMillis() - l1));
  }
  
  private void d()
  {
    if (this.n == null) {
      return;
    }
    try
    {
      if (!l.s())
      {
        this.c.write(1);
        l.g(true);
      }
      this.c.write(2);
      this.b.readFully(d, 0, d.length);
      this.c.close();
      this.b.close();
      this.n.close();
      this.c = null;
      this.b = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    this.n = null;
  }
  
  private void d(int paramInt)
    throws IOException
  {
    if (l.e())
    {
      if (l.s())
      {
        this.b.readFully(d, 0, paramInt);
        l.g(false);
      }
      if (l.M() == -1) {
        c();
      }
      try
      {
        Thread.sleep(50L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
    }
    if (!l.s())
    {
      this.c.write(1);
      l.g(true);
    }
    long l1 = System.currentTimeMillis();
    this.b.readFully(d, 0, paramInt);
    i.c("--QA-TEST--", "JAVA got frame time = " + (System.currentTimeMillis() - l1));
    this.c.write(1);
    l1 = System.currentTimeMillis();
    paramInt = l.a(d);
    long l2 = System.currentTimeMillis();
    long l3 = l.u();
    if (this.m * l.t() < l2 - l3) {
      paramInt = l.a(d);
    }
    if ((paramInt == -2) && (this.n == null)) {
      c();
    }
    i.c("--QA-TEST--", "JAVA encode time = " + (System.currentTimeMillis() - l1));
  }
  
  public void a()
  {
    this.a = false;
    l.v();
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {}
    while (this.c == null) {
      return;
    }
    try
    {
      this.c.write((byte)(paramInt + 100));
      this.m = (1000 / paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      i.e("--QA-TEST--", "changeFrameRate Writer error");
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   3: invokevirtual 241	com/baidu/carlife/core/screen/video/e:j	()Z
    //   6: ifne +17 -> 23
    //   9: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   12: invokevirtual 244	com/baidu/carlife/core/screen/video/e:G	()Z
    //   15: ifne +8 -> 23
    //   18: aload_0
    //   19: invokespecial 99	com/baidu/carlife/core/screen/video/c:c	()V
    //   22: return
    //   23: aload_0
    //   24: getstatic 40	com/baidu/carlife/core/screen/video/e:e	I
    //   27: i2l
    //   28: putfield 42	com/baidu/carlife/core/screen/video/c:m	J
    //   31: aload_0
    //   32: new 227	android/net/LocalSocket
    //   35: dup
    //   36: invokespecial 245	android/net/LocalSocket:<init>	()V
    //   39: putfield 217	com/baidu/carlife/core/screen/video/c:n	Landroid/net/LocalSocket;
    //   42: new 247	android/net/LocalSocketAddress
    //   45: dup
    //   46: ldc 14
    //   48: invokespecial 250	android/net/LocalSocketAddress:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 217	com/baidu/carlife/core/screen/video/c:n	Landroid/net/LocalSocket;
    //   56: aload_3
    //   57: invokevirtual 254	android/net/LocalSocket:connect	(Landroid/net/LocalSocketAddress;)V
    //   60: ldc 11
    //   62: ldc_w 256
    //   65: invokestatic 137	com/baidu/carlife/core/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: new 72	java/io/DataInputStream
    //   72: dup
    //   73: aload_0
    //   74: getfield 217	com/baidu/carlife/core/screen/video/c:n	Landroid/net/LocalSocket;
    //   77: invokevirtual 260	android/net/LocalSocket:getInputStream	()Ljava/io/InputStream;
    //   80: invokespecial 263	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: putfield 67	com/baidu/carlife/core/screen/video/c:b	Ljava/io/DataInputStream;
    //   86: aload_0
    //   87: new 56	java/io/DataOutputStream
    //   90: dup
    //   91: aload_0
    //   92: getfield 217	com/baidu/carlife/core/screen/video/c:n	Landroid/net/LocalSocket;
    //   95: invokevirtual 267	android/net/LocalSocket:getOutputStream	()Ljava/io/OutputStream;
    //   98: invokespecial 270	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   101: putfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   104: aload_0
    //   105: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   108: getstatic 80	com/baidu/carlife/core/screen/video/e:b	I
    //   111: invokevirtual 273	java/io/DataOutputStream:writeInt	(I)V
    //   114: aload_0
    //   115: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   118: getstatic 82	com/baidu/carlife/core/screen/video/e:c	I
    //   121: invokevirtual 273	java/io/DataOutputStream:writeInt	(I)V
    //   124: aload_0
    //   125: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   128: invokestatic 278	com/baidu/carlife/core/d:a	()Lcom/baidu/carlife/core/d;
    //   131: invokevirtual 280	com/baidu/carlife/core/d:h	()I
    //   134: invokevirtual 273	java/io/DataOutputStream:writeInt	(I)V
    //   137: aload_0
    //   138: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   141: invokestatic 278	com/baidu/carlife/core/d:a	()Lcom/baidu/carlife/core/d;
    //   144: invokevirtual 282	com/baidu/carlife/core/d:i	()I
    //   147: invokevirtual 273	java/io/DataOutputStream:writeInt	(I)V
    //   150: aload_0
    //   151: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   154: iconst_0
    //   155: invokevirtual 273	java/io/DataOutputStream:writeInt	(I)V
    //   158: aload_0
    //   159: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   162: getstatic 284	com/baidu/carlife/core/screen/video/e:d	I
    //   165: bipush 100
    //   167: iadd
    //   168: i2b
    //   169: invokevirtual 60	java/io/DataOutputStream:write	(I)V
    //   172: aload_0
    //   173: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   176: iconst_1
    //   177: invokevirtual 60	java/io/DataOutputStream:write	(I)V
    //   180: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   183: iconst_1
    //   184: invokevirtual 64	com/baidu/carlife/core/screen/video/e:g	(Z)V
    //   187: getstatic 80	com/baidu/carlife/core/screen/video/e:b	I
    //   190: getstatic 82	com/baidu/carlife/core/screen/video/e:c	I
    //   193: imul
    //   194: iconst_4
    //   195: imul
    //   196: istore_1
    //   197: getstatic 70	com/baidu/carlife/core/screen/video/c:d	[B
    //   200: ifnull +11 -> 211
    //   203: getstatic 70	com/baidu/carlife/core/screen/video/c:d	[B
    //   206: arraylength
    //   207: iload_1
    //   208: if_icmpeq +9 -> 217
    //   211: iload_1
    //   212: newarray <illegal type>
    //   214: putstatic 70	com/baidu/carlife/core/screen/video/c:d	[B
    //   217: invokestatic 289	com/baidu/carlife/core/c:a	()Lcom/baidu/carlife/core/c;
    //   220: invokevirtual 290	com/baidu/carlife/core/c:e	()Z
    //   223: ifne +48 -> 271
    //   226: aload_0
    //   227: getfield 194	com/baidu/carlife/core/screen/video/c:a	Z
    //   230: ifeq +41 -> 271
    //   233: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   236: invokevirtual 50	com/baidu/carlife/core/screen/video/e:s	()Z
    //   239: ifeq +22 -> 261
    //   242: aload_0
    //   243: getfield 67	com/baidu/carlife/core/screen/video/c:b	Ljava/io/DataInputStream;
    //   246: getstatic 70	com/baidu/carlife/core/screen/video/c:d	[B
    //   249: iconst_0
    //   250: iload_1
    //   251: invokevirtual 76	java/io/DataInputStream:readFully	([BII)V
    //   254: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   257: iconst_0
    //   258: invokevirtual 64	com/baidu/carlife/core/screen/video/e:g	(Z)V
    //   261: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   264: invokevirtual 293	com/baidu/carlife/core/screen/video/e:L	()I
    //   267: iconst_m1
    //   268: if_icmpne +165 -> 433
    //   271: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   274: invokevirtual 50	com/baidu/carlife/core/screen/video/e:s	()Z
    //   277: ifne +18 -> 295
    //   280: aload_0
    //   281: getfield 54	com/baidu/carlife/core/screen/video/c:c	Ljava/io/DataOutputStream;
    //   284: iconst_1
    //   285: invokevirtual 60	java/io/DataOutputStream:write	(I)V
    //   288: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   291: iconst_1
    //   292: invokevirtual 64	com/baidu/carlife/core/screen/video/e:g	(Z)V
    //   295: aload_0
    //   296: invokevirtual 295	com/baidu/carlife/core/screen/video/c:b	()V
    //   299: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   302: invokevirtual 298	com/baidu/carlife/core/screen/video/e:q	()I
    //   305: istore_2
    //   306: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   309: invokevirtual 241	com/baidu/carlife/core/screen/video/e:j	()Z
    //   312: ifeq +150 -> 462
    //   315: getstatic 140	com/baidu/carlife/core/screen/video/c:e	Ljava/nio/ByteBuffer;
    //   318: ifnull +33 -> 351
    //   321: getstatic 150	com/baidu/carlife/core/screen/video/c:f	Landroid/graphics/Bitmap;
    //   324: ifnull +27 -> 351
    //   327: getstatic 150	com/baidu/carlife/core/screen/video/c:f	Landroid/graphics/Bitmap;
    //   330: invokevirtual 301	android/graphics/Bitmap:getWidth	()I
    //   333: getstatic 80	com/baidu/carlife/core/screen/video/e:b	I
    //   336: if_icmpne +15 -> 351
    //   339: getstatic 150	com/baidu/carlife/core/screen/video/c:f	Landroid/graphics/Bitmap;
    //   342: invokevirtual 304	android/graphics/Bitmap:getHeight	()I
    //   345: getstatic 82	com/baidu/carlife/core/screen/video/e:c	I
    //   348: if_icmpeq +27 -> 375
    //   351: getstatic 70	com/baidu/carlife/core/screen/video/c:d	[B
    //   354: invokestatic 308	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   357: putstatic 140	com/baidu/carlife/core/screen/video/c:e	Ljava/nio/ByteBuffer;
    //   360: getstatic 80	com/baidu/carlife/core/screen/video/e:b	I
    //   363: getstatic 82	com/baidu/carlife/core/screen/video/e:c	I
    //   366: getstatic 314	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   369: invokestatic 318	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   372: putstatic 150	com/baidu/carlife/core/screen/video/c:f	Landroid/graphics/Bitmap;
    //   375: aload_0
    //   376: getfield 194	com/baidu/carlife/core/screen/video/c:a	Z
    //   379: ifeq +24 -> 403
    //   382: aload_0
    //   383: iload_1
    //   384: invokespecial 320	com/baidu/carlife/core/screen/video/c:b	(I)V
    //   387: goto -12 -> 375
    //   390: astore_3
    //   391: ldc 8
    //   393: ldc_w 322
    //   396: invokestatic 235	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload_3
    //   400: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   403: aload_0
    //   404: invokespecial 99	com/baidu/carlife/core/screen/video/c:c	()V
    //   407: return
    //   408: astore_3
    //   409: ldc 8
    //   411: ldc_w 324
    //   414: invokestatic 235	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   420: invokevirtual 199	com/baidu/carlife/core/screen/video/e:v	()V
    //   423: aload_0
    //   424: aconst_null
    //   425: putfield 217	com/baidu/carlife/core/screen/video/c:n	Landroid/net/LocalSocket;
    //   428: aload_3
    //   429: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   432: return
    //   433: ldc2_w 100
    //   436: invokestatic 107	java/lang/Thread:sleep	(J)V
    //   439: goto -222 -> 217
    //   442: astore_3
    //   443: aload_3
    //   444: invokevirtual 110	java/lang/InterruptedException:printStackTrace	()V
    //   447: goto -230 -> 217
    //   450: astore_3
    //   451: ldc 8
    //   453: ldc_w 326
    //   456: invokestatic 137	com/baidu/carlife/core/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: goto -56 -> 403
    //   462: iload_2
    //   463: bipush 15
    //   465: if_icmpeq +9 -> 474
    //   468: iload_2
    //   469: bipush 16
    //   471: if_icmpne +62 -> 533
    //   474: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   477: invokevirtual 329	com/baidu/carlife/core/screen/video/e:D	()Z
    //   480: ifne +9 -> 489
    //   483: invokestatic 333	com/baidu/carlife/core/screen/video/g:b	()Z
    //   486: ifeq +31 -> 517
    //   489: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   492: iconst_0
    //   493: invokevirtual 335	com/baidu/carlife/core/screen/video/e:h	(Z)V
    //   496: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   499: invokevirtual 338	com/baidu/carlife/core/screen/video/e:A	()V
    //   502: aload_0
    //   503: getfield 194	com/baidu/carlife/core/screen/video/c:a	Z
    //   506: ifeq -103 -> 403
    //   509: aload_0
    //   510: iload_1
    //   511: invokespecial 340	com/baidu/carlife/core/screen/video/c:d	(I)V
    //   514: goto -12 -> 502
    //   517: aload_0
    //   518: iconst_0
    //   519: iload_1
    //   520: invokespecial 342	com/baidu/carlife/core/screen/video/c:a	(ZI)V
    //   523: getstatic 70	com/baidu/carlife/core/screen/video/c:d	[B
    //   526: invokestatic 343	com/baidu/carlife/core/screen/video/g:a	([B)I
    //   529: pop
    //   530: goto -34 -> 496
    //   533: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   536: invokevirtual 329	com/baidu/carlife/core/screen/video/e:D	()Z
    //   539: ifeq +9 -> 548
    //   542: getstatic 78	com/baidu/carlife/core/screen/video/c:k	[B
    //   545: ifnull +89 -> 634
    //   548: invokestatic 333	com/baidu/carlife/core/screen/video/g:b	()Z
    //   551: ifeq +67 -> 618
    //   554: goto +80 -> 634
    //   557: getstatic 80	com/baidu/carlife/core/screen/video/e:b	I
    //   560: getstatic 82	com/baidu/carlife/core/screen/video/e:c	I
    //   563: imul
    //   564: iconst_2
    //   565: imul
    //   566: newarray <illegal type>
    //   568: putstatic 78	com/baidu/carlife/core/screen/video/c:k	[B
    //   571: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   574: iconst_0
    //   575: invokevirtual 335	com/baidu/carlife/core/screen/video/e:h	(Z)V
    //   578: getstatic 32	com/baidu/carlife/core/screen/video/c:l	Lcom/baidu/carlife/core/screen/video/e;
    //   581: invokevirtual 338	com/baidu/carlife/core/screen/video/e:A	()V
    //   584: aload_0
    //   585: getfield 194	com/baidu/carlife/core/screen/video/c:a	Z
    //   588: ifeq -185 -> 403
    //   591: aload_0
    //   592: iload_1
    //   593: invokespecial 345	com/baidu/carlife/core/screen/video/c:c	(I)V
    //   596: goto -12 -> 584
    //   599: getstatic 80	com/baidu/carlife/core/screen/video/e:b	I
    //   602: getstatic 82	com/baidu/carlife/core/screen/video/e:c	I
    //   605: imul
    //   606: iconst_3
    //   607: imul
    //   608: iconst_2
    //   609: idiv
    //   610: newarray <illegal type>
    //   612: putstatic 78	com/baidu/carlife/core/screen/video/c:k	[B
    //   615: goto -44 -> 571
    //   618: aload_0
    //   619: iconst_1
    //   620: iload_1
    //   621: invokespecial 342	com/baidu/carlife/core/screen/video/c:a	(ZI)V
    //   624: getstatic 78	com/baidu/carlife/core/screen/video/c:k	[B
    //   627: invokestatic 343	com/baidu/carlife/core/screen/video/g:a	([B)I
    //   630: pop
    //   631: goto -53 -> 578
    //   634: iload_2
    //   635: bipush 6
    //   637: if_icmpeq -80 -> 557
    //   640: iload_2
    //   641: bipush 7
    //   643: if_icmpne -44 -> 599
    //   646: goto -89 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	c
    //   196	425	1	i1	int
    //   305	339	2	i2	int
    //   51	6	3	localLocalSocketAddress	android.net.LocalSocketAddress
    //   390	10	3	localIOException1	IOException
    //   408	21	3	localIOException2	IOException
    //   442	2	3	localInterruptedException	InterruptedException
    //   450	1	3	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   60	211	390	java/io/IOException
    //   211	217	390	java/io/IOException
    //   217	261	390	java/io/IOException
    //   261	271	390	java/io/IOException
    //   271	295	390	java/io/IOException
    //   295	351	390	java/io/IOException
    //   351	375	390	java/io/IOException
    //   375	387	390	java/io/IOException
    //   433	439	390	java/io/IOException
    //   443	447	390	java/io/IOException
    //   474	489	390	java/io/IOException
    //   489	496	390	java/io/IOException
    //   496	502	390	java/io/IOException
    //   502	514	390	java/io/IOException
    //   517	530	390	java/io/IOException
    //   533	548	390	java/io/IOException
    //   548	554	390	java/io/IOException
    //   557	571	390	java/io/IOException
    //   571	578	390	java/io/IOException
    //   578	584	390	java/io/IOException
    //   584	596	390	java/io/IOException
    //   599	615	390	java/io/IOException
    //   618	631	390	java/io/IOException
    //   31	60	408	java/io/IOException
    //   433	439	442	java/lang/InterruptedException
    //   60	211	450	java/lang/NullPointerException
    //   211	217	450	java/lang/NullPointerException
    //   217	261	450	java/lang/NullPointerException
    //   261	271	450	java/lang/NullPointerException
    //   271	295	450	java/lang/NullPointerException
    //   295	351	450	java/lang/NullPointerException
    //   351	375	450	java/lang/NullPointerException
    //   375	387	450	java/lang/NullPointerException
    //   433	439	450	java/lang/NullPointerException
    //   443	447	450	java/lang/NullPointerException
    //   474	489	450	java/lang/NullPointerException
    //   489	496	450	java/lang/NullPointerException
    //   496	502	450	java/lang/NullPointerException
    //   502	514	450	java/lang/NullPointerException
    //   517	530	450	java/lang/NullPointerException
    //   533	548	450	java/lang/NullPointerException
    //   548	554	450	java/lang/NullPointerException
    //   557	571	450	java/lang/NullPointerException
    //   571	578	450	java/lang/NullPointerException
    //   578	584	450	java/lang/NullPointerException
    //   584	596	450	java/lang/NullPointerException
    //   599	615	450	java/lang/NullPointerException
    //   618	631	450	java/lang/NullPointerException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */