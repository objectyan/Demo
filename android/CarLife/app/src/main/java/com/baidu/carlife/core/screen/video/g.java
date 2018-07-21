package com.baidu.carlife.core.screen.video;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import com.baidu.carlife.core.b.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import java.nio.ByteBuffer;

public class g
  extends Thread
{
  private static final String a = "Recorder";
  private static final long b = 50000L;
  private static boolean c = false;
  private static e d = e.b();
  private static MediaCodec e = d.w();
  private static final Object f = d.x();
  private static final Object g = d.y();
  private static int h = 0;
  private static byte[] i;
  private static byte[] j = new byte[1];
  private static MediaCodec.BufferInfo k = new MediaCodec.BufferInfo();
  private boolean l = true;
  private boolean m = false;
  private int n = 0;
  private int o = 0;
  private long p = e.e / 2;
  private long q = e.e;
  
  public g()
  {
    e = d.w();
  }
  
  /* Error */
  public static int a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ifnonnull +12 -> 15
    //   6: ldc 8
    //   8: ldc 96
    //   10: invokestatic 101	com/baidu/carlife/core/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: iconst_0
    //   14: ireturn
    //   15: ldc 8
    //   17: new 103	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   24: ldc 106
    //   26: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: arraylength
    //   31: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   43: ifnonnull +12 -> 55
    //   46: ldc 8
    //   48: ldc 121
    //   50: invokestatic 123	com/baidu/carlife/core/i:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: iconst_0
    //   54: ireturn
    //   55: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   58: lstore 5
    //   60: aconst_null
    //   61: astore 10
    //   63: aconst_null
    //   64: astore 11
    //   66: aconst_null
    //   67: astore 9
    //   69: iload_2
    //   70: istore_3
    //   71: aload 10
    //   73: astore 8
    //   75: iload_2
    //   76: istore_1
    //   77: aload 11
    //   79: astore 7
    //   81: getstatic 57	com/baidu/carlife/core/screen/video/g:f	Ljava/lang/Object;
    //   84: astore 12
    //   86: iload_2
    //   87: istore_3
    //   88: aload 10
    //   90: astore 8
    //   92: iload_2
    //   93: istore_1
    //   94: aload 11
    //   96: astore 7
    //   98: aload 12
    //   100: monitorenter
    //   101: iload_2
    //   102: istore_1
    //   103: aload 9
    //   105: astore 7
    //   107: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   110: invokevirtual 135	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   113: astore 10
    //   115: iload_2
    //   116: istore_1
    //   117: aload 9
    //   119: astore 7
    //   121: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   124: invokevirtual 138	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   127: astore 8
    //   129: iload_2
    //   130: istore_1
    //   131: aload 8
    //   133: astore 7
    //   135: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   138: ldc2_w 11
    //   141: invokevirtual 142	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   144: istore_3
    //   145: iload_3
    //   146: iflt +306 -> 452
    //   149: aload 10
    //   151: iload_3
    //   152: aaload
    //   153: astore 9
    //   155: iload_2
    //   156: istore_1
    //   157: aload 8
    //   159: astore 7
    //   161: aload 9
    //   163: invokevirtual 148	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   166: pop
    //   167: iload_2
    //   168: istore_1
    //   169: aload 8
    //   171: astore 7
    //   173: aload 9
    //   175: aload_0
    //   176: invokevirtual 152	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   179: pop
    //   180: iload_2
    //   181: istore_1
    //   182: aload 8
    //   184: astore 7
    //   186: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   189: iload_3
    //   190: iconst_0
    //   191: aload_0
    //   192: arraylength
    //   193: getstatic 45	com/baidu/carlife/core/screen/video/g:d	Lcom/baidu/carlife/core/screen/video/e;
    //   196: invokevirtual 155	com/baidu/carlife/core/screen/video/e:z	()J
    //   199: iconst_0
    //   200: invokevirtual 159	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   203: iload_2
    //   204: istore_1
    //   205: aload 8
    //   207: astore 7
    //   209: ldc 8
    //   211: ldc -95
    //   213: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: iload_2
    //   217: istore_1
    //   218: aload 8
    //   220: astore 7
    //   222: new 68	android/media/MediaCodec$BufferInfo
    //   225: dup
    //   226: invokespecial 71	android/media/MediaCodec$BufferInfo:<init>	()V
    //   229: astore 9
    //   231: iload_2
    //   232: istore_1
    //   233: aload 8
    //   235: astore 7
    //   237: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   240: aload 9
    //   242: ldc2_w 11
    //   245: invokevirtual 165	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   248: istore 4
    //   250: iload 4
    //   252: iflt +349 -> 601
    //   255: aload 8
    //   257: iload 4
    //   259: aaload
    //   260: astore 10
    //   262: iload_2
    //   263: istore_1
    //   264: aload 8
    //   266: astore 7
    //   268: aload 10
    //   270: invokestatic 168	com/baidu/carlife/core/screen/video/g:a	(Ljava/nio/ByteBuffer;)Z
    //   273: ifeq +259 -> 532
    //   276: iload_2
    //   277: istore_1
    //   278: aload 8
    //   280: astore 7
    //   282: aload 9
    //   284: getfield 171	android/media/MediaCodec$BufferInfo:size	I
    //   287: istore_2
    //   288: iload_2
    //   289: istore_1
    //   290: aload 8
    //   292: astore 7
    //   294: getstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   297: ifnull +22 -> 319
    //   300: iload_2
    //   301: istore_1
    //   302: aload 8
    //   304: astore 7
    //   306: getstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   309: arraylength
    //   310: getstatic 173	com/baidu/carlife/core/screen/video/g:i	[B
    //   313: arraylength
    //   314: iload_2
    //   315: iadd
    //   316: if_icmpge +20 -> 336
    //   319: iload_2
    //   320: istore_1
    //   321: aload 8
    //   323: astore 7
    //   325: getstatic 173	com/baidu/carlife/core/screen/video/g:i	[B
    //   328: arraylength
    //   329: iload_2
    //   330: iadd
    //   331: newarray <illegal type>
    //   333: putstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   336: iload_2
    //   337: istore_1
    //   338: aload 8
    //   340: astore 7
    //   342: getstatic 173	com/baidu/carlife/core/screen/video/g:i	[B
    //   345: iconst_0
    //   346: getstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   349: iconst_0
    //   350: getstatic 173	com/baidu/carlife/core/screen/video/g:i	[B
    //   353: arraylength
    //   354: invokestatic 177	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   357: iload_2
    //   358: istore_1
    //   359: aload 8
    //   361: astore 7
    //   363: aload 10
    //   365: getstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   368: getstatic 173	com/baidu/carlife/core/screen/video/g:i	[B
    //   371: arraylength
    //   372: iload_2
    //   373: invokevirtual 181	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   376: pop
    //   377: iload_2
    //   378: istore_1
    //   379: aload 8
    //   381: astore 7
    //   383: aload 10
    //   385: invokevirtual 148	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   388: pop
    //   389: iload_2
    //   390: istore_1
    //   391: aload 8
    //   393: astore 7
    //   395: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   398: iload 4
    //   400: iconst_0
    //   401: invokevirtual 185	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   404: iload_2
    //   405: istore_1
    //   406: aload 8
    //   408: astore 7
    //   410: iload_2
    //   411: getstatic 173	com/baidu/carlife/core/screen/video/g:i	[B
    //   414: arraylength
    //   415: iadd
    //   416: istore_2
    //   417: iload_2
    //   418: istore_1
    //   419: aload 8
    //   421: astore 7
    //   423: aload 12
    //   425: monitorexit
    //   426: iload_2
    //   427: ifeq +9 -> 436
    //   430: getstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   433: ifnonnull +196 -> 629
    //   436: ldc 8
    //   438: ldc -69
    //   440: invokestatic 101	com/baidu/carlife/core/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: getstatic 45	com/baidu/carlife/core/screen/video/g:d	Lcom/baidu/carlife/core/screen/video/e;
    //   446: invokevirtual 191	com/baidu/carlife/core/screen/video/e:L	()I
    //   449: pop
    //   450: iconst_0
    //   451: ireturn
    //   452: iload_2
    //   453: istore_1
    //   454: aload 8
    //   456: astore 7
    //   458: ldc 8
    //   460: ldc -63
    //   462: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: goto -249 -> 216
    //   468: astore 9
    //   470: aload 12
    //   472: monitorexit
    //   473: iload_1
    //   474: istore_3
    //   475: aload 7
    //   477: astore 8
    //   479: aload 9
    //   481: athrow
    //   482: astore 7
    //   484: ldc 8
    //   486: ldc -61
    //   488: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload 7
    //   493: invokevirtual 198	java/lang/IllegalStateException:printStackTrace	()V
    //   496: iload_3
    //   497: istore_2
    //   498: aload 8
    //   500: astore 7
    //   502: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   505: ifnull +86 -> 591
    //   508: iload_3
    //   509: istore_2
    //   510: aload 8
    //   512: astore 7
    //   514: invokestatic 201	com/baidu/carlife/core/screen/video/g:i	()Z
    //   517: ifne +74 -> 591
    //   520: getstatic 45	com/baidu/carlife/core/screen/video/g:d	Lcom/baidu/carlife/core/screen/video/e;
    //   523: iconst_1
    //   524: invokevirtual 204	com/baidu/carlife/core/screen/video/e:a	(I)V
    //   527: iload_3
    //   528: istore_2
    //   529: goto -103 -> 426
    //   532: iconst_0
    //   533: istore_3
    //   534: iconst_0
    //   535: istore_2
    //   536: iload_2
    //   537: istore_1
    //   538: aload 8
    //   540: astore 7
    //   542: aload 10
    //   544: invokevirtual 148	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   547: pop
    //   548: iload_2
    //   549: istore_1
    //   550: aload 8
    //   552: astore 7
    //   554: getstatic 51	com/baidu/carlife/core/screen/video/g:e	Landroid/media/MediaCodec;
    //   557: iload 4
    //   559: iconst_0
    //   560: invokevirtual 185	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   563: iload_2
    //   564: istore_1
    //   565: aload 8
    //   567: astore 7
    //   569: ldc 8
    //   571: ldc -50
    //   573: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: iload_3
    //   577: istore_2
    //   578: iload_2
    //   579: istore_1
    //   580: aload 8
    //   582: astore 7
    //   584: aload 12
    //   586: monitorexit
    //   587: aload 8
    //   589: astore 7
    //   591: lload 5
    //   593: aload 7
    //   595: invokestatic 209	com/baidu/carlife/core/screen/video/g:a	(J[Ljava/nio/ByteBuffer;)V
    //   598: goto -538 -> 60
    //   601: iload_2
    //   602: istore_1
    //   603: aload 8
    //   605: astore 7
    //   607: ldc 8
    //   609: ldc -45
    //   611: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: goto -36 -> 578
    //   617: astore 8
    //   619: aload 8
    //   621: invokevirtual 212	java/lang/Throwable:printStackTrace	()V
    //   624: iload_1
    //   625: istore_2
    //   626: goto -35 -> 591
    //   629: ldc 8
    //   631: new 103	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   638: ldc -42
    //   640: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: getstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   646: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   649: ldc -37
    //   651: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload_2
    //   655: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: getstatic 45	com/baidu/carlife/core/screen/video/g:d	Lcom/baidu/carlife/core/screen/video/e;
    //   667: getstatic 66	com/baidu/carlife/core/screen/video/g:j	[B
    //   670: iload_2
    //   671: invokevirtual 222	com/baidu/carlife/core/screen/video/e:a	([BI)I
    //   674: pop
    //   675: ldc 8
    //   677: ldc -32
    //   679: invokestatic 119	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: iload_2
    //   683: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	paramArrayOfByte	byte[]
    //   76	549	1	i1	int
    //   1	682	2	i2	int
    //   70	507	3	i3	int
    //   248	310	4	i4	int
    //   58	534	5	l1	long
    //   79	397	7	localObject1	Object
    //   482	10	7	localIllegalStateException	IllegalStateException
    //   500	106	7	localObject2	Object
    //   73	531	8	localObject3	Object
    //   617	3	8	localThrowable	Throwable
    //   67	216	9	localObject4	Object
    //   468	12	9	localObject5	Object
    //   61	482	10	arrayOfByteBuffer	ByteBuffer[]
    //   64	31	11	localObject6	Object
    //   84	501	12	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   107	115	468	finally
    //   121	129	468	finally
    //   135	145	468	finally
    //   161	167	468	finally
    //   173	180	468	finally
    //   186	203	468	finally
    //   209	216	468	finally
    //   222	231	468	finally
    //   237	250	468	finally
    //   268	276	468	finally
    //   282	288	468	finally
    //   294	300	468	finally
    //   306	319	468	finally
    //   325	336	468	finally
    //   342	357	468	finally
    //   363	377	468	finally
    //   383	389	468	finally
    //   395	404	468	finally
    //   410	417	468	finally
    //   423	426	468	finally
    //   458	465	468	finally
    //   470	473	468	finally
    //   542	548	468	finally
    //   554	563	468	finally
    //   569	576	468	finally
    //   584	587	468	finally
    //   607	614	468	finally
    //   81	86	482	java/lang/IllegalStateException
    //   98	101	482	java/lang/IllegalStateException
    //   479	482	482	java/lang/IllegalStateException
    //   81	86	617	java/lang/Throwable
    //   98	101	617	java/lang/Throwable
    //   479	482	617	java/lang/Throwable
  }
  
  private static void a(long paramLong, ByteBuffer[] paramArrayOfByteBuffer)
  {
    if ((System.currentTimeMillis() - paramLong > 2000L) && (!c))
    {
      c = true;
      int i1;
      if (paramArrayOfByteBuffer != null) {
        i1 = paramArrayOfByteBuffer.length;
      }
      for (;;)
      {
        int i2 = 0;
        label32:
        if (i2 < i1) {
          try
          {
            e.releaseOutputBuffer(i2, false);
            i2 += 1;
            break label32;
            i1 = 8;
          }
          catch (IllegalStateException paramArrayOfByteBuffer)
          {
            for (;;)
            {
              paramArrayOfByteBuffer.printStackTrace();
            }
          }
          catch (Throwable paramArrayOfByteBuffer)
          {
            for (;;)
            {
              paramArrayOfByteBuffer.printStackTrace();
            }
          }
        }
      }
      k.a(1037, "缓冲区已清空");
    }
  }
  
  private static boolean a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {}
    while ((paramByteBuffer.get(4) & 0x1F) != 5) {
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    return i == null;
  }
  
  public static void c()
  {
    i = null;
  }
  
  private int d()
  {
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    if (e == null)
    {
      i.d("Recorder", "还没完成初始化, 或已经被释放");
      return -1;
    }
    int i1 = i4;
    for (;;)
    {
      try
      {
        if (d.J())
        {
          i1 = i4;
          Thread.sleep(5L);
        }
        i1 = i4;
        localObject1 = g;
        i1 = i4;
        i1 = i3;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2;
        localThrowable.printStackTrace();
        i.e("Recorder", "outputSpsPpsAndFirstFrame" + localThrowable.toString());
        continue;
      }
      try
      {
        i4 = e.dequeueOutputBuffer(k, 50000L);
        i1 = i3;
        localObject2 = e.getOutputBuffers();
        if (i4 >= 0)
        {
          Object localObject4 = localObject2[i4];
          i1 = i3;
          if (j.length < k.size)
          {
            i1 = i3;
            j = new byte[k.size];
          }
          i1 = i3;
          ((ByteBuffer)localObject4).get(j, 0, k.size);
          i1 = i3;
          i3 = k.size;
          i1 = i3;
          ((ByteBuffer)localObject4).clear();
          i1 = i3;
          e.releaseOutputBuffer(i4, false);
          i2 = i3;
          i1 = i3;
          if (d.r())
          {
            i1 = i3;
            i2 = e.dequeueOutputBuffer(k, 50000L);
            if (i2 < 0)
            {
              i1 = i3;
              if (this.l)
              {
                i1 = i3;
                i2 = e.dequeueOutputBuffer(k, 50000L);
                continue;
              }
            }
            i1 = i3;
            if (i == null)
            {
              i1 = i3;
              i = new byte[i3];
              i1 = i3;
              System.arraycopy(j, 0, i, 0, i3);
            }
            localObject2 = localObject2[i2];
            i1 = i3;
            j = new byte[i.length + k.size];
            i1 = i3;
            i3 = i.length + k.size;
            i1 = i3;
            System.arraycopy(i, 0, j, 0, i.length);
            i1 = i3;
            if (!a((ByteBuffer)localObject2)) {
              continue;
            }
            i1 = i3;
            ((ByteBuffer)localObject2).get(j, i.length, k.size);
            i1 = i3;
            ((ByteBuffer)localObject2).clear();
            i1 = i3;
            e.releaseOutputBuffer(i2, false);
            i1 = i3;
            d.f(false);
            i1 = i3;
            i.b("Recorder", "VideoOutputThread outputSpsPpsAndFirstFrame isFirstEncodeFrame");
            i2 = i3;
          }
        }
        i1 = i2;
        i1 = i2;
        i.b("Recorder", "VideoOutputThread  outputSpsPpsAndFirstFrame outDataLength=" + i1);
        if ((i1 == 0) || (j == null))
        {
          return 0;
          i1 = i3;
          ((ByteBuffer)localObject2).clear();
          i1 = i3;
          e.releaseOutputBuffer(i2, false);
          i1 = i3;
          d.f(false);
          i1 = i3;
          g();
          i1 = i3;
          i.b("Recorder", "isTEST true, return 20!");
          i1 = i3;
          return 20;
        }
      }
      finally {}
    }
    return d.a(j, i1);
  }
  
  private int e()
  {
    int i1 = -1;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (e == null) {
      i.d("Recorder", "还没完成初始化, 或已经被释放");
    }
    for (;;)
    {
      return i1;
      i1 = i4;
      try
      {
        if (d.J())
        {
          i1 = i4;
          Thread.sleep(5L);
        }
        i1 = i4;
        if (d.E())
        {
          i1 = i4;
          if (h > 65280)
          {
            i1 = i4;
            if (e != null)
            {
              i1 = i4;
              if (!i())
              {
                i1 = i4;
                d.a(1);
                return -1;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        Object localObject1;
        for (;;)
        {
          if ((i1 != 0) && (j != null)) {
            break label444;
          }
          return 0;
          i1 = i4;
          h = 0;
          int i5;
          do
          {
            i1 = i4;
            if (!this.l) {
              break;
            }
            i1 = i4;
            i5 = h();
          } while ((i5 == 0) || (i5 == 12));
          i1 = i5;
          if (i5 >= 0) {
            break;
          }
          return i5;
          i1 = i4;
          localObject1 = g;
          i1 = i4;
          i1 = i3;
          try
          {
            Object localObject2 = e.getOutputBuffers();
            i1 = i3;
            i4 = e.dequeueOutputBuffer(k, 50000L);
            if (i4 >= 0)
            {
              localObject2 = localObject2[i4];
              i1 = i3;
              if (j.length < k.size)
              {
                i1 = i3;
                j = new byte[k.size];
              }
              i1 = i3;
              if (d.E())
              {
                i1 = i3;
                if (a((ByteBuffer)localObject2))
                {
                  i1 = i3;
                  h += 1;
                }
              }
              i1 = i3;
              if (this.m)
              {
                i1 = i3;
                if (a((ByteBuffer)localObject2))
                {
                  i1 = i3;
                  if (this.n > 10)
                  {
                    i1 = i3;
                    this.m = false;
                    i1 = i3;
                    this.n = 0;
                  }
                }
              }
              else
              {
                i1 = i3;
                ((ByteBuffer)localObject2).get(j, 0, k.size);
                i1 = i3;
                i2 = k.size;
                i1 = i2;
                ((ByteBuffer)localObject2).clear();
                i1 = i2;
                e.releaseOutputBuffer(i4, false);
              }
            }
            else
            {
              i1 = i2;
              i1 = i2;
              continue;
            }
          }
          finally {}
        }
        i1 = i3;
        ((ByteBuffer)localObject3).clear();
        i1 = i3;
        e.releaseOutputBuffer(i4, false);
        i1 = i3;
        this.n += 1;
        i1 = i3;
        if (this.n % 3 == 0)
        {
          i1 = i3;
          d.L();
        }
        i1 = i3;
        return 0;
      }
    }
    label444:
    return d.a(j, i1);
  }
  
  private int f()
  {
    int i1;
    if (e == null)
    {
      i.d("Recorder", "还没完成初始化, 或已经被释放");
      i1 = -1;
    }
    int i2;
    for (;;)
    {
      return i1;
      try
      {
        if (d.J()) {
          Thread.sleep(5L);
        }
        if ((d.E()) && (h > 65280) && (e != null))
        {
          if (!i())
          {
            d.a(1);
            return -1;
          }
          h = 0;
          do
          {
            i2 = h();
          } while ((i2 == 0) || (i2 == 12));
          i1 = i2;
          if (i2 < 0) {
            return i2;
          }
        }
        else
        {
          synchronized (g)
          {
            Object localObject2 = e.getOutputBuffers();
            i1 = e.dequeueOutputBuffer(k, this.p);
            if (i1 >= 0)
            {
              this.o = 0;
              localObject2 = localObject2[i1];
              if (j.length < k.size) {
                j = new byte[k.size];
              }
              if ((d.E()) && (a((ByteBuffer)localObject2))) {
                h += 1;
              }
              if (this.m)
              {
                if (this.n % 10 == 0) {
                  k.b(1038);
                }
                if ((a((ByteBuffer)localObject2)) && (this.n > 15))
                {
                  this.m = false;
                  this.n = 0;
                }
              }
              else
              {
                ((ByteBuffer)localObject2).get(j, 0, k.size);
                i2 = k.size;
                ((ByteBuffer)localObject2).clear();
                e.releaseOutputBuffer(i1, false);
                if (!d.e()) {
                  break label409;
                }
                return d.M();
              }
              ((ByteBuffer)localObject2).clear();
              e.releaseOutputBuffer(i1, false);
              this.n += 1;
              return 0;
            }
          }
          this.o += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i.e("Recorder", "outputFromEncoder50 " + localThrowable.toString());
        return -1;
      }
    }
    if (this.o > 5)
    {
      k.b(1038);
      this.o = 0;
      i1 = d.L();
      return i1;
    }
    return 0;
    label409:
    return d.a(j, i2);
  }
  
  private int g()
  {
    int i1 = 0;
    int i2 = 0;
    int i3;
    int i4;
    int i5;
    int i6;
    synchronized (g)
    {
      if (e == null)
      {
        i.d("Recorder", "还没完成初始化, 或已经被释放");
        return 0;
      }
      do
      {
        i7 = 0;
        int i8 = 0;
        i1 = 0;
        i3 = i2;
        i4 = i7;
        i5 = i2;
        i6 = i8;
        try
        {
          ((ByteBuffer)localObject2).clear();
          i3 = i2;
          i4 = i7;
          i5 = i2;
          i6 = i8;
          e.releaseOutputBuffer(i9, false);
        }
        catch (IllegalStateException localIllegalStateException)
        {
          for (;;)
          {
            Object localObject2;
            int i9;
            boolean bool;
            localIllegalStateException.printStackTrace();
            i2 = i3;
            i1 = i4;
            if (e != null)
            {
              i2 = i3;
              i1 = i4;
              if (this.l)
              {
                i2 = i3;
                i1 = i4;
                if (!i()) {
                  d.a(1);
                }
              }
            }
          }
          localObject3 = finally;
          throw ((Throwable)localObject3);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
            i2 = i5;
            i1 = i6;
          }
          d.a(j, i4);
        }
        bool = this.l;
        i4 = i1;
        if (bool)
        {
          i3 = i2;
          i4 = i1;
          i5 = i2;
          i6 = i1;
          localObject2 = e.getOutputBuffers();
          i3 = i2;
          i4 = i1;
          i5 = i2;
          i6 = i1;
          i9 = e.dequeueOutputBuffer(k, 50000L);
          i3 = i2;
          i4 = i1;
          i5 = i2;
          i6 = i1;
          i.e("Recorder", "firstSendEncodeFrame() outputBufferIndex=" + i9);
          if (i9 < 0) {
            break;
          }
          localObject2 = localObject2[i9];
          i3 = i2;
          i4 = i1;
          i5 = i2;
          i6 = i1;
          if (a((ByteBuffer)localObject2))
          {
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            i.c("Recorder", "firstSendEncodeFrame() isIFrame yes");
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            i1 = k.size;
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            if (j != null)
            {
              i3 = i2;
              i4 = i1;
              i5 = i2;
              i6 = i1;
              if (j.length >= i.length + i1) {}
            }
            else
            {
              i3 = i2;
              i4 = i1;
              i5 = i2;
              i6 = i1;
              j = new byte[i.length + i1];
            }
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            System.arraycopy(i, 0, j, 0, i.length);
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            ((ByteBuffer)localObject2).get(j, i.length, k.size);
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            ((ByteBuffer)localObject2).clear();
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            e.releaseOutputBuffer(i9, false);
            i3 = i2;
            i4 = i1;
            i5 = i2;
            i6 = i1;
            i2 = i.length;
            i4 = i1 + i2;
          }
        }
        else
        {
          i.e("Recorder", "firstSendEncodeFrame() data=" + j + ", outDataLength=" + i4);
          if ((i4 != 0) && (j != null)) {
            break label737;
          }
          d.L();
          return 0;
        }
        i3 = i2;
        i4 = i1;
        i5 = i2;
        i6 = i1;
        i.c("Recorder", "firstSendEncodeFrame() isIFrame no");
        i3 = i2;
        i4 = i1;
        i5 = i2;
        i6 = i1;
      } while (d.L() >= 0);
      i3 = i2;
      i4 = i1;
      i5 = i2;
      i6 = i1;
      i.e("Recorder", "firstSendEncodeFrame() sendEmptyPacketForeground failed");
      return -1;
      int i7 = i2 + 1;
      i2 = i7;
      if (i7 > 5)
      {
        i3 = i7;
        i4 = i1;
        i5 = i7;
        i6 = i1;
        if (d.L() < 0)
        {
          i3 = i7;
          i4 = i1;
          i5 = i7;
          i6 = i1;
          i.e("Recorder", "firstSendEncodeFrame() sendEmptyPacketForeground failed");
          return -1;
        }
        i3 = 0;
        i5 = 0;
        i2 = 0;
        i4 = i1;
        i6 = i1;
        k.b(1038);
      }
      i3 = i2;
      i4 = i1;
      i5 = i2;
      i6 = i1;
      i.e("Recorder", "firstSendEncodeFrame() emptyCount=" + i2);
    }
    label737:
    return i4;
  }
  
  private int h()
  {
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        synchronized (g)
        {
          Object localObject2 = e.getOutputBuffers();
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          int i3 = e.dequeueOutputBuffer(localBufferInfo, 50000L);
          if (i3 >= 0)
          {
            this.o = 0;
            localObject2 = localObject2[i3];
            if (j.length < k.size) {
              j = new byte[k.size];
            }
            if (a((ByteBuffer)localObject2))
            {
              h += 1;
              ((ByteBuffer)localObject2).get(j, 0, k.size);
              i1 = k.size;
              ((ByteBuffer)localObject2).clear();
              e.releaseOutputBuffer(i3, false);
              if (i1 != 0) {
                break;
              }
              i1 = i2;
              if (this.o > 5)
              {
                if (a.a()) {
                  k.b(1038);
                }
                this.o = 0;
                i1 = d.M();
              }
              return i1;
            }
            ((ByteBuffer)localObject2).clear();
            e.releaseOutputBuffer(i3, false);
            return 0;
          }
        }
        this.o += 1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i.e("Recorder", "getFirstIFrameAfterReset " + localThrowable.toString());
        return -1;
      }
    }
    return d.a(j, i1);
  }
  
  private static boolean i()
  {
    e = null;
    d.I();
    e = d.w();
    return e != null;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("VideoOutputThread ifStopInputThread=");
    if (!a.a()) {}
    for (boolean bool = true;; bool = false)
    {
      i.b("Recorder", bool);
      this.l = false;
      d.a(null);
      if (!a.a()) {
        break;
      }
      return;
    }
    d.B();
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
    this.q = (paramInt * 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.m == true) {
      return;
    }
    this.m = paramBoolean;
    this.n = 0;
  }
  
  public void run()
  {
    this.q = e.e;
    if (a.a())
    {
      h = 0;
      i.b("Recorder", "VideoOutputThread  isFirstEncodeFrame=" + d.r() + ", isRunning=" + this.l);
      if (d.r())
      {
        while ((d() == 0) && (this.l)) {}
        i.b("Recorder", "VideoOutputThread  isRunning=" + this.l);
      }
      for (;;)
      {
        if (!this.l) {
          break label190;
        }
        if (f() < 0)
        {
          a();
          continue;
          g();
          break;
        }
        try
        {
          Thread.sleep(this.q);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
        }
      }
    }
    if (d.N()) {
      if (!d.Q()) {
        if (d.M() < 0) {
          a();
        }
      }
    }
    for (;;)
    {
      label190:
      return;
      try
      {
        Thread.sleep(40L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
      break;
      d.R();
      if (d.r()) {
        while ((d() == 0) && (this.l)) {}
      }
      while (this.l) {
        if (!e.b().e())
        {
          if (f() < 0)
          {
            a();
            continue;
            g();
          }
          else
          {
            try
            {
              Thread.sleep(this.q);
            }
            catch (InterruptedException localInterruptedException3)
            {
              localInterruptedException3.printStackTrace();
            }
          }
        }
        else
        {
          if (d.M() < 0) {
            a();
          }
          try
          {
            Thread.sleep(40L);
          }
          catch (InterruptedException localInterruptedException4)
          {
            localInterruptedException4.printStackTrace();
          }
        }
      }
      continue;
      while ((d.r()) && (d() == 0) && (this.l)) {}
      while (this.l) {
        if (e() < 0) {
          a();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */