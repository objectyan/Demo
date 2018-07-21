package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"HandlerLeak"})
public final class a
{
  public static a a;
  private static HashMap b;
  private static ExecutorService c;
  
  private a()
  {
    if (b == null) {
      b = new HashMap();
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_3
    //   8: astore_1
    //   9: new 32	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 35	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 39	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 41	java/net/HttpURLConnection
    //   23: astore_0
    //   24: aload_3
    //   25: astore_1
    //   26: aload_0
    //   27: sipush 10000
    //   30: invokevirtual 45	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   33: aload_3
    //   34: astore_1
    //   35: aload_0
    //   36: iconst_1
    //   37: invokevirtual 49	java/net/HttpURLConnection:setDoInput	(Z)V
    //   40: aload_3
    //   41: astore_1
    //   42: aload_0
    //   43: invokevirtual 52	java/net/HttpURLConnection:connect	()V
    //   46: aload_3
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 56	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   52: astore_0
    //   53: aload_0
    //   54: invokestatic 62	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +173 -> 232
    //   62: aload_1
    //   63: aload_1
    //   64: invokevirtual 68	android/graphics/Bitmap:getWidth	()I
    //   67: aload_1
    //   68: invokevirtual 71	android/graphics/Bitmap:getHeight	()I
    //   71: iconst_1
    //   72: invokestatic 75	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   75: astore_2
    //   76: aload_2
    //   77: astore_1
    //   78: aload_0
    //   79: ifnull +9 -> 88
    //   82: aload_0
    //   83: invokevirtual 80	java/io/InputStream:close	()V
    //   86: aload_2
    //   87: astore_1
    //   88: aload_1
    //   89: areturn
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_2
    //   94: astore_1
    //   95: invokestatic 85	java/lang/System:gc	()V
    //   98: aload_2
    //   99: astore_1
    //   100: aload_3
    //   101: invokevirtual 89	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   104: invokestatic 95	com/baidu/ufosdk/util/c:d	(Ljava/lang/String;)I
    //   107: pop
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: ifnull -23 -> 88
    //   114: aload_2
    //   115: invokevirtual 80	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: areturn
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   125: aload_0
    //   126: areturn
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_0
    //   130: aload 4
    //   132: astore_2
    //   133: aload_2
    //   134: astore_1
    //   135: aload_3
    //   136: invokevirtual 99	java/lang/Exception:toString	()Ljava/lang/String;
    //   139: invokestatic 95	com/baidu/ufosdk/util/c:d	(Ljava/lang/String;)I
    //   142: pop
    //   143: aload_0
    //   144: astore_1
    //   145: aload_2
    //   146: ifnull -58 -> 88
    //   149: aload_2
    //   150: invokevirtual 80	java/io/InputStream:close	()V
    //   153: aload_0
    //   154: areturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   160: aload_0
    //   161: areturn
    //   162: astore_0
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 80	java/io/InputStream:close	()V
    //   171: aload_0
    //   172: athrow
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   186: aload_2
    //   187: areturn
    //   188: astore_2
    //   189: aload_0
    //   190: astore_1
    //   191: aload_2
    //   192: astore_0
    //   193: goto -30 -> 163
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_0
    //   200: astore_2
    //   201: aload_1
    //   202: astore_0
    //   203: goto -70 -> 133
    //   206: astore_3
    //   207: aload_0
    //   208: astore_2
    //   209: aload_1
    //   210: astore_0
    //   211: goto -78 -> 133
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_0
    //   218: astore_2
    //   219: aload_1
    //   220: astore_0
    //   221: goto -128 -> 93
    //   224: astore_3
    //   225: aload_0
    //   226: astore_2
    //   227: aload_1
    //   228: astore_0
    //   229: goto -136 -> 93
    //   232: aload_1
    //   233: astore_2
    //   234: goto -158 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString	String
    //   8	102	1	localObject1	Object
    //   120	2	1	localIOException1	java.io.IOException
    //   134	11	1	localObject2	Object
    //   155	13	1	localIOException2	java.io.IOException
    //   173	2	1	localIOException3	java.io.IOException
    //   190	43	1	str	String
    //   6	181	2	localObject3	Object
    //   188	4	2	localObject4	Object
    //   200	34	2	localObject5	Object
    //   4	43	3	localObject6	Object
    //   90	11	3	localOutOfMemoryError1	OutOfMemoryError
    //   127	9	3	localException1	Exception
    //   196	1	3	localException2	Exception
    //   206	1	3	localException3	Exception
    //   214	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   224	1	3	localOutOfMemoryError3	OutOfMemoryError
    //   1	130	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   9	24	90	java/lang/OutOfMemoryError
    //   26	33	90	java/lang/OutOfMemoryError
    //   35	40	90	java/lang/OutOfMemoryError
    //   42	46	90	java/lang/OutOfMemoryError
    //   48	53	90	java/lang/OutOfMemoryError
    //   114	118	120	java/io/IOException
    //   9	24	127	java/lang/Exception
    //   26	33	127	java/lang/Exception
    //   35	40	127	java/lang/Exception
    //   42	46	127	java/lang/Exception
    //   48	53	127	java/lang/Exception
    //   149	153	155	java/io/IOException
    //   9	24	162	finally
    //   26	33	162	finally
    //   35	40	162	finally
    //   42	46	162	finally
    //   48	53	162	finally
    //   95	98	162	finally
    //   100	108	162	finally
    //   135	143	162	finally
    //   167	171	173	java/io/IOException
    //   82	86	181	java/io/IOException
    //   53	58	188	finally
    //   62	76	188	finally
    //   53	58	196	java/lang/Exception
    //   62	76	206	java/lang/Exception
    //   53	58	214	java/lang/OutOfMemoryError
    //   62	76	224	java/lang/OutOfMemoryError
  }
  
  public static a a()
  {
    try
    {
      if (a == null)
      {
        a = new a();
        if (c == null) {
          c = Executors.newFixedThreadPool(1);
        }
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public final Bitmap a(q paramq, String paramString)
  {
    String str = m.c(paramString);
    Bitmap localBitmap;
    if (b.containsKey(str))
    {
      localBitmap = (Bitmap)((SoftReference)b.get(str)).get();
      if (localBitmap != null) {
        return localBitmap;
      }
    }
    try
    {
      localBitmap = f.a(str);
      if (localBitmap != null)
      {
        b.put(str, new SoftReference(localBitmap));
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
        Object localObject = null;
      }
      c.execute(new b(this, paramString, str, paramq));
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */