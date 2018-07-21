package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.util.Log;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;

public class g
{
  private static final String a = "Audio-" + g.class.getSimpleName();
  private int b;
  private int c;
  private int d;
  private AudioTrack e;
  private int f = 0;
  private d g = new l();
  private p h = new p();
  private p i = new p();
  private byte[] j = null;
  private Object k = new Object();
  
  private boolean g()
  {
    this.b = this.g.a();
    if (this.b == 8000) {
      this.b *= 2;
    }
    this.c = this.g.b();
    this.d = this.g.c();
    if (this.e != null) {
      this.e.flush();
    }
    if (this.c == 1) {}
    for (int m = 4;; m = 12)
    {
      i.b(a, "samplerate = " + this.b);
      if ((this.b >= 4000) && (this.b <= 48000)) {
        break;
      }
      this.e = null;
      i.b(a, "4000>sample rate || sample rate>48000: " + this.b);
      return false;
    }
    int n = AudioTrack.getMinBufferSize(this.b, m, 2);
    i.b(a, "audioMinBufSizeLocal= " + n);
    try
    {
      this.e = new AudioTrack(3, this.b, m, 2, n * 2, 1);
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      this.e = null;
      i.b(a, "IllegalArgumentException: mAudioTrack =new AudioTrack");
    }
    return false;
  }
  
  private void h()
  {
    if (this.e == null) {
      return;
    }
    if (this.e.getPlayState() != 3) {
      try
      {
        i.b(a, "Play WeChat voice!");
        this.e.play();
        synchronized (this.k)
        {
          this.k.notify();
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          k.b(415);
          localIllegalStateException.printStackTrace();
        }
      }
    }
    i.b(a, "play music has been triggered");
  }
  
  private void i()
  {
    synchronized (this.k)
    {
      if (this.e != null)
      {
        int m = this.e.getPlayState();
        if (m == 3) {
          break label34;
        }
      }
      try
      {
        this.k.wait();
        label34:
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    if (m <= 0)
    {
      i.e(a, "Data size 0!!!");
      return;
    }
    synchronized (this.k)
    {
      if ((this.e != null) && (this.e.getPlayState() == 3))
      {
        i.e(a, "Trace size:  " + m);
        this.e.write(paramArrayOfByte, 0, m);
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.k)
    {
      i.b(a, "init() is called");
      if (this.g.a(paramString, null) == -1)
      {
        Log.i(a, "MediaCodec initialization is failed!");
        if (8000 != this.g.a()) {
          return false;
        }
      }
      else
      {
        Log.i(a, "wechat initialization is successed!");
      }
    }
    return true;
  }
  
  /* Error */
  public byte[] a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   7: iload_1
    //   8: iconst_5
    //   9: if_icmpge +56 -> 65
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 66	com/baidu/carlife/core/audio/g:g	Lcom/baidu/carlife/core/audio/d;
    //   17: aload_0
    //   18: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   21: iconst_0
    //   22: invokeinterface 175 3 0
    //   27: putfield 50	com/baidu/carlife/core/audio/g:f	I
    //   30: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   33: new 26	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   40: ldc -79
    //   42: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   49: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 101	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   62: ifle +69 -> 131
    //   65: aload_0
    //   66: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   69: invokevirtual 178	com/baidu/carlife/core/audio/p:b	()I
    //   72: aload_0
    //   73: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   76: if_icmpeq +46 -> 122
    //   79: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   82: new 26	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   89: ldc -76
    //   91: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   98: invokevirtual 178	com/baidu/carlife/core/audio/p:b	()I
    //   101: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc -74
    //   106: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   113: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 150	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   126: ifgt +71 -> 197
    //   129: aconst_null
    //   130: areturn
    //   131: iconst_m1
    //   132: aload_0
    //   133: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   136: if_icmpne +47 -> 183
    //   139: aload_0
    //   140: getfield 61	com/baidu/carlife/core/audio/g:k	Ljava/lang/Object;
    //   143: astore_2
    //   144: aload_2
    //   145: monitorenter
    //   146: aload_0
    //   147: getfield 61	com/baidu/carlife/core/audio/g:k	Ljava/lang/Object;
    //   150: invokevirtual 144	java/lang/Object:wait	()V
    //   153: aload_2
    //   154: monitorexit
    //   155: iload_1
    //   156: iconst_1
    //   157: iadd
    //   158: istore_1
    //   159: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   162: ldc -72
    //   164: invokestatic 101	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: goto -160 -> 7
    //   170: astore_3
    //   171: aload_2
    //   172: monitorexit
    //   173: aload_3
    //   174: athrow
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 145	java/lang/InterruptedException:printStackTrace	()V
    //   180: goto -25 -> 155
    //   183: aload_0
    //   184: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   187: ifne -180 -> 7
    //   190: iload_1
    //   191: iconst_1
    //   192: iadd
    //   193: istore_1
    //   194: goto -187 -> 7
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   202: invokevirtual 178	com/baidu/carlife/core/audio/p:b	()I
    //   205: iconst_2
    //   206: imul
    //   207: newarray <illegal type>
    //   209: putfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   212: aload_0
    //   213: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   216: invokevirtual 186	com/baidu/carlife/core/audio/p:a	()[B
    //   219: astore_2
    //   220: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   223: new 26	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   230: ldc -68
    //   232: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   239: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 101	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: iconst_0
    //   249: istore_1
    //   250: iload_1
    //   251: aload_0
    //   252: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   255: if_icmpge +64 -> 319
    //   258: aload_0
    //   259: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   262: iload_1
    //   263: iconst_2
    //   264: imul
    //   265: aload_2
    //   266: iload_1
    //   267: baload
    //   268: bastore
    //   269: aload_0
    //   270: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   273: iload_1
    //   274: iconst_2
    //   275: imul
    //   276: iconst_1
    //   277: iadd
    //   278: aload_2
    //   279: iload_1
    //   280: iconst_1
    //   281: iadd
    //   282: baload
    //   283: bastore
    //   284: aload_0
    //   285: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   288: iload_1
    //   289: iconst_2
    //   290: imul
    //   291: iconst_2
    //   292: iadd
    //   293: aload_2
    //   294: iload_1
    //   295: baload
    //   296: bastore
    //   297: aload_0
    //   298: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   301: iload_1
    //   302: iconst_2
    //   303: imul
    //   304: iconst_3
    //   305: iadd
    //   306: aload_2
    //   307: iload_1
    //   308: iconst_1
    //   309: iadd
    //   310: baload
    //   311: bastore
    //   312: iload_1
    //   313: iconst_2
    //   314: iadd
    //   315: istore_1
    //   316: goto -66 -> 250
    //   319: aload_0
    //   320: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   323: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	g
    //   1	315	1	m	int
    //   175	2	2	localInterruptedException	InterruptedException
    //   219	88	2	arrayOfByte	byte[]
    //   170	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   146	155	170	finally
    //   171	173	170	finally
    //   139	146	175	java/lang/InterruptedException
    //   173	175	175	java/lang/InterruptedException
  }
  
  public void b()
  {
    if (!g())
    {
      i.b(a, "audio Track Init Error!!!");
      return;
    }
    b.a().b();
    h();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: bipush 8
    //   5: if_icmpge +354 -> 359
    //   8: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   11: lstore_3
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 66	com/baidu/carlife/core/audio/g:g	Lcom/baidu/carlife/core/audio/d;
    //   17: aload_0
    //   18: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   21: iconst_0
    //   22: invokeinterface 175 3 0
    //   27: putfield 50	com/baidu/carlife/core/audio/g:f	I
    //   30: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   33: new 26	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   40: ldc -79
    //   42: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   49: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 101	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: iconst_m1
    //   59: aload_0
    //   60: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   63: if_icmpne +55 -> 118
    //   66: aload_0
    //   67: getfield 61	com/baidu/carlife/core/audio/g:k	Ljava/lang/Object;
    //   70: astore 7
    //   72: aload 7
    //   74: monitorenter
    //   75: aload_0
    //   76: getfield 61	com/baidu/carlife/core/audio/g:k	Ljava/lang/Object;
    //   79: invokevirtual 144	java/lang/Object:wait	()V
    //   82: aload 7
    //   84: monitorexit
    //   85: iload_1
    //   86: iconst_1
    //   87: iadd
    //   88: istore_1
    //   89: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   92: ldc -72
    //   94: invokestatic 101	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: goto -95 -> 2
    //   100: astore 8
    //   102: aload 7
    //   104: monitorexit
    //   105: aload 8
    //   107: athrow
    //   108: astore 7
    //   110: aload 7
    //   112: invokevirtual 145	java/lang/InterruptedException:printStackTrace	()V
    //   115: goto -30 -> 85
    //   118: aload_0
    //   119: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   122: ifne +10 -> 132
    //   125: iload_1
    //   126: iconst_1
    //   127: iadd
    //   128: istore_1
    //   129: goto -127 -> 2
    //   132: aload_0
    //   133: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   136: invokevirtual 178	com/baidu/carlife/core/audio/p:b	()I
    //   139: aload_0
    //   140: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   143: if_icmpeq +46 -> 189
    //   146: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   149: new 26	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   156: ldc -76
    //   158: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   165: invokevirtual 178	com/baidu/carlife/core/audio/p:b	()I
    //   168: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc -74
    //   173: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   180: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 150	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: iconst_0
    //   190: istore_2
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   196: invokevirtual 178	com/baidu/carlife/core/audio/p:b	()I
    //   199: iconst_2
    //   200: imul
    //   201: newarray <illegal type>
    //   203: putfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   206: aload_0
    //   207: getfield 57	com/baidu/carlife/core/audio/g:i	Lcom/baidu/carlife/core/audio/p;
    //   210: aload_0
    //   211: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   214: invokevirtual 178	com/baidu/carlife/core/audio/p:b	()I
    //   217: iconst_2
    //   218: imul
    //   219: invokevirtual 208	com/baidu/carlife/core/audio/p:a	(I)V
    //   222: aload_0
    //   223: getfield 57	com/baidu/carlife/core/audio/g:i	Lcom/baidu/carlife/core/audio/p;
    //   226: aload_0
    //   227: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   230: invokevirtual 210	com/baidu/carlife/core/audio/p:a	([B)V
    //   233: aload_0
    //   234: getfield 55	com/baidu/carlife/core/audio/g:h	Lcom/baidu/carlife/core/audio/p;
    //   237: invokevirtual 186	com/baidu/carlife/core/audio/p:a	()[B
    //   240: astore 7
    //   242: iconst_0
    //   243: istore_1
    //   244: iload_1
    //   245: aload_0
    //   246: getfield 50	com/baidu/carlife/core/audio/g:f	I
    //   249: if_icmpge +68 -> 317
    //   252: aload_0
    //   253: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   256: iload_1
    //   257: iconst_2
    //   258: imul
    //   259: aload 7
    //   261: iload_1
    //   262: baload
    //   263: bastore
    //   264: aload_0
    //   265: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   268: iload_1
    //   269: iconst_2
    //   270: imul
    //   271: iconst_1
    //   272: iadd
    //   273: aload 7
    //   275: iload_1
    //   276: iconst_1
    //   277: iadd
    //   278: baload
    //   279: bastore
    //   280: aload_0
    //   281: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   284: iload_1
    //   285: iconst_2
    //   286: imul
    //   287: iconst_2
    //   288: iadd
    //   289: aload 7
    //   291: iload_1
    //   292: baload
    //   293: bastore
    //   294: aload_0
    //   295: getfield 59	com/baidu/carlife/core/audio/g:j	[B
    //   298: iload_1
    //   299: iconst_2
    //   300: imul
    //   301: iconst_3
    //   302: iadd
    //   303: aload 7
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: baload
    //   309: bastore
    //   310: iload_1
    //   311: iconst_2
    //   312: iadd
    //   313: istore_1
    //   314: goto -70 -> 244
    //   317: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   320: lstore 5
    //   322: getstatic 46	com/baidu/carlife/core/audio/g:a	Ljava/lang/String;
    //   325: new 26	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   332: ldc -44
    //   334: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: lload 5
    //   339: lload_3
    //   340: lsub
    //   341: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   344: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 101	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload_0
    //   351: invokevirtual 217	com/baidu/carlife/core/audio/g:f	()V
    //   354: iload_2
    //   355: istore_1
    //   356: goto -354 -> 2
    //   359: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	g
    //   1	355	1	m	int
    //   190	165	2	n	int
    //   11	329	3	l1	long
    //   320	18	5	l2	long
    //   108	3	7	localInterruptedException	InterruptedException
    //   240	64	7	arrayOfByte	byte[]
    //   100	6	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   75	85	100	finally
    //   102	105	100	finally
    //   66	75	108	java/lang/InterruptedException
    //   105	108	108	java/lang/InterruptedException
  }
  
  public void d()
  {
    synchronized (this.k)
    {
      i.b(a, "stop() is called");
      if (this.e == null) {
        return;
      }
    }
    try
    {
      this.e.stop();
      this.e.release();
      this.e = null;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        k.b(415);
        localIllegalStateException.printStackTrace();
      }
    }
  }
  
  public void e()
  {
    synchronized (this.k)
    {
      b.a().b();
      i.b(a, "play() is called");
      if ((this.e != null) && (this.e.getPlayState() != 3))
      {
        h();
        return;
      }
      i.b(a, "play music has been triggered");
    }
  }
  
  public void f()
  {
    int m = this.i.b();
    if (m <= 0)
    {
      i.e(a, "Out size 0!!!");
      return;
    }
    synchronized (this.k)
    {
      if ((this.e != null) && (this.e.getPlayState() == 3))
      {
        i.e(a, "size  " + m);
        this.e.write(this.i.a(), 0, m);
      }
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */