package com.baidu.carlife.core.audio;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class l
  implements d
{
  private static final String a = "Audio-" + l.class.getSimpleName();
  private static final int b = 1;
  private static final int c = 0;
  private static final int d = -1;
  private static final int e = -2;
  private static final int f = -3;
  private static final int g = -4;
  private static final int h = -10;
  private static final int i = -11;
  private static final int j = -12;
  private static final int k = 1000;
  private static final int l = 10;
  private MediaCodec m;
  private MediaExtractor n;
  private MediaFormat o;
  private MediaCodec.BufferInfo p;
  private boolean q = false;
  private boolean r = false;
  private ByteBuffer[] s;
  private ByteBuffer[] t;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private byte[] x;
  private String y;
  
  l()
  {
    a(new byte['倀']);
  }
  
  private boolean b(String paramString)
  {
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    if (i1 < i3)
    {
      Object localObject = MediaCodecList.getCodecInfoAt(i1);
      i.b(a, "codecInfo = " + ((MediaCodecInfo)localObject).getName());
      if (((MediaCodecInfo)localObject).isEncoder()) {}
      for (;;)
      {
        i1 += 1;
        break;
        localObject = ((MediaCodecInfo)localObject).getSupportedTypes();
        int i2 = 0;
        while (i2 < localObject.length)
        {
          i.b(a, "support type = " + localObject[i2]);
          if (localObject[i2].equalsIgnoreCase(paramString)) {
            return true;
          }
          i2 += 1;
        }
      }
    }
    return false;
  }
  
  public static int d()
  {
    return 1000;
  }
  
  private int n()
  {
    int i5 = 0;
    int i1;
    int i2;
    int i4;
    int i6;
    int i3;
    if (e() == null)
    {
      return -1;
      for (;;)
      {
        try
        {
          if ((Build.VERSION.SDK_INT >= 21) || (i1 != -3)) {
            break;
          }
          b(e().getOutputBuffers());
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Object localObject;
          localIllegalStateException.printStackTrace();
          i.b(a, "IllegalStateException happen!-getDecodedAudioData");
          i1 = -10;
          break label482;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          i.b(a, "IllegalArgumentException happen!-getDecodedAudioData");
          i1 = -11;
          break label482;
        }
        catch (MediaCodec.CryptoException localCryptoException)
        {
          label183:
          label206:
          localCryptoException.printStackTrace();
          i.b(a, "MediaCodec.CryptoException happen!-getDecodedAudioData");
          i1 = -12;
          break label482;
        }
        i4 = i2 + 1;
        i1 = i5;
        if (i2 >= 10) {
          break label482;
        }
        i6 = e().dequeueInputBuffer(d());
        i.b(a, "inputBuffIndex = " + i6);
        if (i6 < 0) {
          break label508;
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject = e().getInputBuffer(i6);
          i1 = this.n.readSampleData((ByteBuffer)localObject, 0);
          i.b(a, "inputBuffIndex = " + i6 + "sampleSize = " + i1);
          if (i1 >= 0) {
            break label492;
          }
          i2 = 1;
          i1 = 0;
          localObject = e();
          if (i2 == 0) {
            break label497;
          }
          i3 = 4;
          ((MediaCodec)localObject).queueInputBuffer(i6, 0, i1, 0L, i3);
          if (i2 != 0) {
            break label502;
          }
          this.n.advance();
          i1 = e().dequeueOutputBuffer(g(), d());
          i.b(a, "outputBuffIndex = " + i1);
          if (i1 >= 0)
          {
            localObject = e().getOutputFormat(i1);
            i.b(a, "output format no change, sample rate = " + ((MediaFormat)localObject).getInteger("sample-rate"));
            e().releaseOutputBuffer(i1, false);
            i1 = 0;
            break label482;
          }
        }
        else
        {
          localObject = j()[i6];
          continue;
        }
        if (i1 == -2)
        {
          localObject = e().getOutputFormat();
          b(((MediaFormat)localObject).getInteger("sample-rate"));
          c(((MediaFormat)localObject).getInteger("channel-count"));
          i.b(a, "output format changed, sample rate = " + a() + ",channel count = " + b());
          k.b(425);
          i1 = 1;
          break label482;
        }
      }
    }
    label482:
    label492:
    label497:
    label502:
    label508:
    label518:
    for (;;)
    {
      return i1;
      i2 = 0;
      break;
      i2 = i4;
      break;
      for (;;)
      {
        if (i4 < 10) {
          break label518;
        }
        return -4;
        i2 = 0;
        break;
        i3 = 0;
        break label183;
        i1 = -2;
        continue;
        if (i6 == -1) {
          break label206;
        }
        i1 = -3;
      }
    }
  }
  
  private void o()
  {
    if (e() != null) {}
    try
    {
      e().flush();
      e().stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      return;
    }
    finally
    {
      e().release();
      this.m = null;
    }
  }
  
  public int a()
  {
    return this.u;
  }
  
  protected int a(int paramInt)
  {
    k.b(paramInt);
    if (paramInt == 404) {
      o();
    }
    return -1;
  }
  
  public int a(p paramp, int paramInt)
  {
    for (;;)
    {
      int i3;
      int i2;
      try
      {
        if (e() != null)
        {
          localObject = this.n;
          if (localObject != null) {}
        }
        else
        {
          paramInt = -1;
          return paramInt;
        }
        int i4 = 0;
        i3 = 0;
        paramp.a(m());
        paramp.a(0);
        try
        {
          i5 = e().dequeueInputBuffer(d());
          int i1;
          if ((i5 >= 0) && (!i()))
          {
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject = e().getInputBuffer(i5);
              i1 = this.n.readSampleData((ByteBuffer)localObject, 0);
              if (i1 >= 0) {
                continue;
              }
              b(true);
              i1 = 0;
              localObject = e();
              if (!i()) {
                continue;
              }
              i2 = 4;
              ((MediaCodec)localObject).queueInputBuffer(i5, 0, i1, 0L, i2);
              if (i()) {
                continue;
              }
              this.n.advance();
            }
          }
          else
          {
            i2 = e().dequeueOutputBuffer(g(), d());
            if (i2 < 0) {
              break label441;
            }
            if (Build.VERSION.SDK_INT < 21) {
              continue;
            }
            localObject = e().getOutputBuffer(i2);
            i1 = g().size;
            if (m().length < i1 + paramInt)
            {
              a(new byte[i1 + paramInt]);
              paramp.a(m());
            }
            ((ByteBuffer)localObject).get(m(), paramInt, i1);
            ((ByteBuffer)localObject).clear();
            paramInt = i4;
            if (i1 > 0)
            {
              paramp.a(i1);
              paramInt = i1;
            }
            e().releaseOutputBuffer(i2, false);
            if ((g().flags & 0x4) == 0) {
              continue;
            }
            a(true);
          }
        }
        catch (IllegalStateException paramp)
        {
          int i5;
          paramp.printStackTrace();
          i.b(a, "IllegalStateException happen!-getDecodedAudioData");
          a(404);
          paramInt = -1;
          continue;
          localObject = j()[i5];
          continue;
          this.n.getSampleTime();
          b(false);
          continue;
        }
        catch (IllegalArgumentException paramp)
        {
          paramp.printStackTrace();
          i.b(a, "IllegalArgumentException happen!-getDecodedAudioData");
          a(404);
          paramInt = -1;
          continue;
          i2 = 0;
          continue;
          a(417);
          continue;
        }
        catch (MediaCodec.CryptoException paramp)
        {
          paramp.printStackTrace();
          i.b(a, "MediaCodec.CryptoException happen!-getDecodedAudioData");
          a(404);
          paramInt = -1;
        }
        continue;
        Object localObject = k()[i2];
        continue;
        a(false);
        continue;
        if (Build.VERSION.SDK_INT >= 21) {
          break label485;
        }
      }
      finally {}
      label441:
      paramInt = i3;
      if (i2 == -3)
      {
        b(e().getOutputBuffers());
        i.b(a, "res = MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED");
        paramInt = i3;
        continue;
        label485:
        paramInt = i3;
        if (i2 == -2)
        {
          e().getOutputFormat().getInteger("sample-rate");
          i.b(a, "res = MediaCodec.INFO_OUTPUT_FORMAT_CHANGED");
          paramInt = i3;
        }
      }
    }
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 168	com/baidu/carlife/core/audio/l:n	Landroid/media/MediaExtractor;
    //   8: ifnull +10 -> 18
    //   11: aload_0
    //   12: getfield 168	com/baidu/carlife/core/audio/l:n	Landroid/media/MediaExtractor;
    //   15: invokevirtual 312	android/media/MediaExtractor:release	()V
    //   18: aload_0
    //   19: invokespecial 258	com/baidu/carlife/core/audio/l:o	()V
    //   22: aload_0
    //   23: new 170	android/media/MediaExtractor
    //   26: dup
    //   27: invokespecial 313	android/media/MediaExtractor:<init>	()V
    //   30: putfield 168	com/baidu/carlife/core/audio/l:n	Landroid/media/MediaExtractor;
    //   33: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   36: new 55	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 315
    //   46: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 168	com/baidu/carlife/core/audio/l:n	Landroid/media/MediaExtractor;
    //   63: aload_1
    //   64: invokevirtual 319	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 168	com/baidu/carlife/core/audio/l:n	Landroid/media/MediaExtractor;
    //   72: iconst_0
    //   73: invokevirtual 322	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   76: putfield 324	com/baidu/carlife/core/audio/l:o	Landroid/media/MediaFormat;
    //   79: aload_0
    //   80: aload_0
    //   81: invokevirtual 326	com/baidu/carlife/core/audio/l:f	()Landroid/media/MediaFormat;
    //   84: ldc_w 328
    //   87: invokevirtual 332	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: putfield 334	com/baidu/carlife/core/audio/l:y	Ljava/lang/String;
    //   93: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   96: new 55	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 336
    //   106: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 334	com/baidu/carlife/core/audio/l:y	Ljava/lang/String;
    //   113: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 334	com/baidu/carlife/core/audio/l:y	Ljava/lang/String;
    //   127: invokespecial 338	com/baidu/carlife/core/audio/l:b	(Ljava/lang/String;)Z
    //   130: ifne +15 -> 145
    //   133: aload_0
    //   134: sipush 404
    //   137: invokevirtual 297	com/baidu/carlife/core/audio/l:a	(I)I
    //   140: pop
    //   141: aload_0
    //   142: monitorexit
    //   143: iload_2
    //   144: ireturn
    //   145: aload_0
    //   146: aload_0
    //   147: invokevirtual 326	com/baidu/carlife/core/audio/l:f	()Landroid/media/MediaFormat;
    //   150: ldc -36
    //   152: invokevirtual 206	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   155: invokevirtual 222	com/baidu/carlife/core/audio/l:c	(I)V
    //   158: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   161: new 55	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 340
    //   171: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 230	com/baidu/carlife/core/audio/l:b	()I
    //   178: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: getstatic 345	android/os/Build:MODEL	Ljava/lang/String;
    //   190: ldc_w 347
    //   193: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +16 -> 212
    //   199: aload_0
    //   200: invokevirtual 230	com/baidu/carlife/core/audio/l:b	()I
    //   203: iconst_1
    //   204: if_icmpne +8 -> 212
    //   207: aload_0
    //   208: iconst_2
    //   209: invokevirtual 222	com/baidu/carlife/core/audio/l:c	(I)V
    //   212: aload_0
    //   213: aload_0
    //   214: invokevirtual 326	com/baidu/carlife/core/audio/l:f	()Landroid/media/MediaFormat;
    //   217: ldc -56
    //   219: invokevirtual 206	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   222: invokevirtual 218	com/baidu/carlife/core/audio/l:b	(I)V
    //   225: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   228: new 55	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 353
    //   238: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: invokevirtual 226	com/baidu/carlife/core/audio/l:a	()I
    //   245: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_0
    //   255: invokevirtual 226	com/baidu/carlife/core/audio/l:a	()I
    //   258: sipush 4000
    //   261: if_icmplt +13 -> 274
    //   264: aload_0
    //   265: invokevirtual 226	com/baidu/carlife/core/audio/l:a	()I
    //   268: ldc_w 354
    //   271: if_icmple +73 -> 344
    //   274: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   277: new 55	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 356
    //   287: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_0
    //   291: invokevirtual 226	com/baidu/carlife/core/audio/l:a	()I
    //   294: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload_0
    //   304: sipush 404
    //   307: invokevirtual 297	com/baidu/carlife/core/audio/l:a	(I)I
    //   310: pop
    //   311: goto -170 -> 141
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 357	java/io/IOException:printStackTrace	()V
    //   319: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   322: ldc_w 359
    //   325: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: aload_0
    //   329: sipush 404
    //   332: invokevirtual 297	com/baidu/carlife/core/audio/l:a	(I)I
    //   335: pop
    //   336: goto -195 -> 141
    //   339: astore_1
    //   340: aload_0
    //   341: monitorexit
    //   342: aload_1
    //   343: athrow
    //   344: aload_0
    //   345: bipush 16
    //   347: putfield 87	com/baidu/carlife/core/audio/l:w	I
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 334	com/baidu/carlife/core/audio/l:y	Ljava/lang/String;
    //   355: invokestatic 363	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   358: putfield 255	com/baidu/carlife/core/audio/l:m	Landroid/media/MediaCodec;
    //   361: aload_0
    //   362: iconst_0
    //   363: invokevirtual 295	com/baidu/carlife/core/audio/l:a	(Z)V
    //   366: aload_0
    //   367: iconst_0
    //   368: invokevirtual 272	com/baidu/carlife/core/audio/l:b	(Z)V
    //   371: aload_0
    //   372: invokevirtual 137	com/baidu/carlife/core/audio/l:e	()Landroid/media/MediaCodec;
    //   375: aload_0
    //   376: invokevirtual 326	com/baidu/carlife/core/audio/l:f	()Landroid/media/MediaFormat;
    //   379: aconst_null
    //   380: aconst_null
    //   381: iconst_0
    //   382: invokevirtual 367	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   385: aload_0
    //   386: invokevirtual 137	com/baidu/carlife/core/audio/l:e	()Landroid/media/MediaCodec;
    //   389: invokevirtual 370	android/media/MediaCodec:start	()V
    //   392: getstatic 142	android/os/Build$VERSION:SDK_INT	I
    //   395: bipush 21
    //   397: if_icmpge +25 -> 422
    //   400: aload_0
    //   401: aload_0
    //   402: invokevirtual 137	com/baidu/carlife/core/audio/l:e	()Landroid/media/MediaCodec;
    //   405: invokevirtual 373	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   408: invokevirtual 375	com/baidu/carlife/core/audio/l:a	([Ljava/nio/ByteBuffer;)V
    //   411: aload_0
    //   412: aload_0
    //   413: invokevirtual 137	com/baidu/carlife/core/audio/l:e	()Landroid/media/MediaCodec;
    //   416: invokevirtual 148	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   419: invokevirtual 151	com/baidu/carlife/core/audio/l:b	([Ljava/nio/ByteBuffer;)V
    //   422: aload_0
    //   423: new 277	android/media/MediaCodec$BufferInfo
    //   426: dup
    //   427: invokespecial 376	android/media/MediaCodec$BufferInfo:<init>	()V
    //   430: putfield 378	com/baidu/carlife/core/audio/l:p	Landroid/media/MediaCodec$BufferInfo;
    //   433: aload_0
    //   434: getfield 168	com/baidu/carlife/core/audio/l:n	Landroid/media/MediaExtractor;
    //   437: iconst_0
    //   438: invokevirtual 381	android/media/MediaExtractor:selectTrack	(I)V
    //   441: aload_0
    //   442: invokespecial 383	com/baidu/carlife/core/audio/l:n	()I
    //   445: istore_2
    //   446: iload_2
    //   447: iflt +132 -> 579
    //   450: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   453: new 55	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 385
    //   463: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: iload_2
    //   467: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: goto +129 -> 605
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 236	java/lang/IllegalStateException:printStackTrace	()V
    //   484: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   487: ldc_w 387
    //   490: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_0
    //   494: sipush 404
    //   497: invokevirtual 297	com/baidu/carlife/core/audio/l:a	(I)I
    //   500: pop
    //   501: goto -360 -> 141
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 239	java/lang/IllegalArgumentException:printStackTrace	()V
    //   509: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   512: ldc_w 389
    //   515: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload_0
    //   519: sipush 404
    //   522: invokevirtual 297	com/baidu/carlife/core/audio/l:a	(I)I
    //   525: pop
    //   526: goto -385 -> 141
    //   529: astore_1
    //   530: aload_1
    //   531: invokevirtual 242	android/media/MediaCodec$CryptoException:printStackTrace	()V
    //   534: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   537: ldc_w 391
    //   540: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: aload_0
    //   544: sipush 404
    //   547: invokevirtual 297	com/baidu/carlife/core/audio/l:a	(I)I
    //   550: pop
    //   551: goto -410 -> 141
    //   554: astore_1
    //   555: aload_1
    //   556: invokevirtual 392	java/lang/NullPointerException:printStackTrace	()V
    //   559: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   562: ldc_w 394
    //   565: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload_0
    //   569: sipush 404
    //   572: invokevirtual 297	com/baidu/carlife/core/audio/l:a	(I)I
    //   575: pop
    //   576: goto -435 -> 141
    //   579: getstatic 75	com/baidu/carlife/core/audio/l:a	Ljava/lang/String;
    //   582: new 55	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 396
    //   592: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iload_2
    //   596: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   599: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 113	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: iconst_0
    //   606: istore_2
    //   607: goto -466 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	this	l
    //   0	610	1	paramString	String
    //   1	606	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   4	18	314	java/io/IOException
    //   18	141	314	java/io/IOException
    //   145	212	314	java/io/IOException
    //   212	274	314	java/io/IOException
    //   274	311	314	java/io/IOException
    //   344	422	314	java/io/IOException
    //   422	441	314	java/io/IOException
    //   4	18	339	finally
    //   18	141	339	finally
    //   145	212	339	finally
    //   212	274	339	finally
    //   274	311	339	finally
    //   315	336	339	finally
    //   344	422	339	finally
    //   422	441	339	finally
    //   441	446	339	finally
    //   450	476	339	finally
    //   480	501	339	finally
    //   505	526	339	finally
    //   530	551	339	finally
    //   555	576	339	finally
    //   579	605	339	finally
    //   4	18	479	java/lang/IllegalStateException
    //   18	141	479	java/lang/IllegalStateException
    //   145	212	479	java/lang/IllegalStateException
    //   212	274	479	java/lang/IllegalStateException
    //   274	311	479	java/lang/IllegalStateException
    //   344	422	479	java/lang/IllegalStateException
    //   422	441	479	java/lang/IllegalStateException
    //   4	18	504	java/lang/IllegalArgumentException
    //   18	141	504	java/lang/IllegalArgumentException
    //   145	212	504	java/lang/IllegalArgumentException
    //   212	274	504	java/lang/IllegalArgumentException
    //   274	311	504	java/lang/IllegalArgumentException
    //   344	422	504	java/lang/IllegalArgumentException
    //   422	441	504	java/lang/IllegalArgumentException
    //   4	18	529	android/media/MediaCodec$CryptoException
    //   18	141	529	android/media/MediaCodec$CryptoException
    //   145	212	529	android/media/MediaCodec$CryptoException
    //   212	274	529	android/media/MediaCodec$CryptoException
    //   274	311	529	android/media/MediaCodec$CryptoException
    //   344	422	529	android/media/MediaCodec$CryptoException
    //   422	441	529	android/media/MediaCodec$CryptoException
    //   4	18	554	java/lang/NullPointerException
    //   18	141	554	java/lang/NullPointerException
    //   145	212	554	java/lang/NullPointerException
    //   212	274	554	java/lang/NullPointerException
    //   274	311	554	java/lang/NullPointerException
    //   344	422	554	java/lang/NullPointerException
    //   422	441	554	java/lang/NullPointerException
  }
  
  public int a(String paramString, ArrayList paramArrayList)
  {
    return 0;
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.x = paramArrayOfByte;
  }
  
  public void a(ByteBuffer[] paramArrayOfByteBuffer)
  {
    this.s = paramArrayOfByteBuffer;
  }
  
  public int b()
  {
    return this.v;
  }
  
  public void b(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void b(ByteBuffer[] paramArrayOfByteBuffer)
  {
    this.t = paramArrayOfByteBuffer;
  }
  
  public int c()
  {
    return l();
  }
  
  public void c(int paramInt)
  {
    this.v = paramInt;
  }
  
  public MediaCodec e()
  {
    return this.m;
  }
  
  public MediaFormat f()
  {
    return this.o;
  }
  
  public MediaCodec.BufferInfo g()
  {
    return this.p;
  }
  
  public boolean h()
  {
    return this.q;
  }
  
  public boolean i()
  {
    return this.r;
  }
  
  public ByteBuffer[] j()
  {
    return this.s;
  }
  
  public ByteBuffer[] k()
  {
    return this.t;
  }
  
  public int l()
  {
    return this.w;
  }
  
  public byte[] m()
  {
    return this.x;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */