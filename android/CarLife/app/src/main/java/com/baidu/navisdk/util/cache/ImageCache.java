package com.baidu.navisdk.util.cache;

import android.graphics.Bitmap;
import com.baidu.navisdk.util.common.MD5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ImageCache
  extends LinkedHashMap<String, Bitmap>
{
  private static final float DEFAULT_LOAD_FACTOR = 0.75F;
  private static final long serialVersionUID = 1L;
  private String mDiskCacheDirectory;
  protected Object mLock = new Object();
  private int mMaxEntries = 0;
  private boolean mNeedRecycle = true;
  
  public ImageCache(String paramString, int paramInt)
  {
    super(paramInt, 0.75F, true);
    this.mMaxEntries = paramInt;
    this.mDiskCacheDirectory = paramString;
    paramString = new File(this.mDiskCacheDirectory);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  /* Error */
  public boolean cache2Disk(java.io.ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 36	com/baidu/navisdk/util/cache/ImageCache:mLock	Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: new 40	java/io/File
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 43	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 47	java/io/File:exists	()Z
    //   26: ifeq +16 -> 42
    //   29: aload_2
    //   30: invokevirtual 63	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +7 -> 42
    //   38: aload_3
    //   39: monitorexit
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_2
    //   43: invokevirtual 66	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 68	java/io/FileOutputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_2
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 77	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   61: aload_1
    //   62: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   65: aload_2
    //   66: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   69: aload_3
    //   70: monitorexit
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   78: goto -9 -> 69
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   86: aload_3
    //   87: monitorexit
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_1
    //   91: aload_3
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   100: goto -14 -> 86
    //   103: astore_1
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	ImageCache
    //   0	106	1	paramByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   0	106	2	paramString	String
    //   10	82	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	69	73	java/lang/Exception
    //   42	61	81	java/io/FileNotFoundException
    //   61	69	81	java/io/FileNotFoundException
    //   74	78	81	java/io/FileNotFoundException
    //   13	40	90	finally
    //   69	71	90	finally
    //   86	88	90	finally
    //   91	93	90	finally
    //   104	106	90	finally
    //   42	61	95	java/io/IOException
    //   61	69	95	java/io/IOException
    //   74	78	95	java/io/IOException
    //   42	61	103	finally
    //   61	69	103	finally
    //   74	78	103	finally
    //   82	86	103	finally
    //   96	100	103	finally
  }
  
  public boolean cache2Disk(InputStream paramInputStream, String paramString)
  {
    synchronized (this.mLock)
    {
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          long l = paramString.length();
          if (l > 0L) {
            return true;
          }
        }
        paramString.createNewFile();
        paramString = new FileOutputStream(paramString);
        byte[] arrayOfByte = new byte['က'];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramString.write(arrayOfByte, 0, i);
        }
        paramString.flush();
      }
      catch (Throwable paramInputStream)
      {
        paramInputStream.printStackTrace();
        return false;
      }
      paramString.close();
      return true;
    }
  }
  
  /* Error */
  public boolean cache2Disk(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 36	com/baidu/navisdk/util/cache/ImageCache:mLock	Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: new 40	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 43	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 47	java/io/File:exists	()Z
    //   26: ifeq +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 63	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +7 -> 42
    //   38: aload_3
    //   39: monitorexit
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_1
    //   43: invokevirtual 66	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 68	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: new 73	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 105	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore 4
    //   65: aload_2
    //   66: getstatic 111	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   69: bipush 100
    //   71: aload 4
    //   73: invokevirtual 117	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: pop
    //   77: aload 4
    //   79: aload_1
    //   80: invokevirtual 77	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   83: aload 4
    //   85: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_1
    //   89: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   92: aload_3
    //   93: monitorexit
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   101: goto -9 -> 92
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   109: aload_3
    //   110: monitorexit
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: aload_3
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   123: goto -14 -> 109
    //   126: astore_1
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ImageCache
    //   0	129	1	paramString	String
    //   0	129	2	paramBitmap	Bitmap
    //   10	105	3	localObject	Object
    //   63	21	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   83	92	96	java/lang/Exception
    //   42	83	104	java/io/FileNotFoundException
    //   83	92	104	java/io/FileNotFoundException
    //   97	101	104	java/io/FileNotFoundException
    //   13	40	113	finally
    //   92	94	113	finally
    //   109	111	113	finally
    //   114	116	113	finally
    //   127	129	113	finally
    //   42	83	118	java/io/IOException
    //   83	92	118	java/io/IOException
    //   97	101	118	java/io/IOException
    //   42	83	126	finally
    //   83	92	126	finally
    //   97	101	126	finally
    //   105	109	126	finally
    //   119	123	126	finally
  }
  
  public void clear()
  {
    synchronized (this.mLock)
    {
      if (this.mNeedRecycle)
      {
        Iterator localIterator = entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
        }
      }
    }
    super.clear();
  }
  
  public Bitmap get(Object paramObject)
  {
    try
    {
      paramObject = (Bitmap)super.get(paramObject);
      return (Bitmap)paramObject;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return null;
  }
  
  public String getCachePath(String paramString)
  {
    return this.mDiskCacheDirectory + File.separator + getFileNameForKey(paramString);
  }
  
  public String getDiskCacheDirectory()
  {
    return this.mDiskCacheDirectory;
  }
  
  public String getFileNameForKey(String paramString)
  {
    return MD5.toMD5(paramString);
  }
  
  public Bitmap put(String paramString, Bitmap paramBitmap)
  {
    synchronized (this.mLock)
    {
      paramString = (Bitmap)super.put(paramString, paramBitmap);
      return paramString;
    }
  }
  
  /* Error */
  public Bitmap readFromDiskCache(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 14
    //   15: aconst_null
    //   16: astore 10
    //   18: aload_0
    //   19: getfield 36	com/baidu/navisdk/util/cache/ImageCache:mLock	Ljava/lang/Object;
    //   22: astore 21
    //   24: aload 21
    //   26: monitorenter
    //   27: aconst_null
    //   28: astore 18
    //   30: aconst_null
    //   31: astore 16
    //   33: aconst_null
    //   34: astore 19
    //   36: aconst_null
    //   37: astore 17
    //   39: aconst_null
    //   40: astore 11
    //   42: aconst_null
    //   43: astore 6
    //   45: aconst_null
    //   46: astore 15
    //   48: aconst_null
    //   49: astore 20
    //   51: aconst_null
    //   52: astore 7
    //   54: aload 19
    //   56: astore 5
    //   58: aload 20
    //   60: astore 4
    //   62: new 40	java/io/File
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 43	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore 22
    //   72: aload 19
    //   74: astore 5
    //   76: aload 20
    //   78: astore 4
    //   80: aload 22
    //   82: invokevirtual 47	java/io/File:exists	()Z
    //   85: istore_3
    //   86: iload_3
    //   87: ifne +45 -> 132
    //   90: iconst_0
    //   91: ifeq +11 -> 102
    //   94: new 197	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: iconst_0
    //   103: ifeq +11 -> 114
    //   106: new 197	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: aload 21
    //   116: monitorexit
    //   117: aconst_null
    //   118: areturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   124: goto -10 -> 114
    //   127: aload 21
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: aload 19
    //   134: astore 5
    //   136: aload 20
    //   138: astore 4
    //   140: new 73	java/io/ByteArrayOutputStream
    //   143: dup
    //   144: invokespecial 105	java/io/ByteArrayOutputStream:<init>	()V
    //   147: astore_1
    //   148: new 200	java/io/FileInputStream
    //   151: dup
    //   152: aload 22
    //   154: invokespecial 201	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   157: astore 5
    //   159: aload 10
    //   161: astore 6
    //   163: aload 12
    //   165: astore 7
    //   167: aload 9
    //   169: astore 8
    //   171: sipush 1024
    //   174: newarray <illegal type>
    //   176: astore 4
    //   178: aload 10
    //   180: astore 6
    //   182: aload 12
    //   184: astore 7
    //   186: aload 9
    //   188: astore 8
    //   190: aload 5
    //   192: aload 4
    //   194: invokevirtual 202	java/io/FileInputStream:read	([B)I
    //   197: istore_2
    //   198: iload_2
    //   199: iconst_m1
    //   200: if_icmpne +178 -> 378
    //   203: aload 10
    //   205: astore 6
    //   207: aload 12
    //   209: astore 7
    //   211: aload 9
    //   213: astore 8
    //   215: aload_1
    //   216: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   219: astore 11
    //   221: aload 10
    //   223: astore 6
    //   225: aload 12
    //   227: astore 7
    //   229: aload 9
    //   231: astore 8
    //   233: aload_1
    //   234: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   237: aload 10
    //   239: astore 6
    //   241: aload 12
    //   243: astore 7
    //   245: aload 9
    //   247: astore 8
    //   249: aload 5
    //   251: invokevirtual 207	java/io/FileInputStream:close	()V
    //   254: aload 10
    //   256: astore 6
    //   258: aload 12
    //   260: astore 7
    //   262: aload 9
    //   264: astore 8
    //   266: aload 11
    //   268: invokestatic 213	com/baidu/navisdk/util/cache/ImageTools:getBitmapFromByteArray	([B)Landroid/graphics/Bitmap;
    //   271: astore 4
    //   273: aload 4
    //   275: astore 6
    //   277: aload 4
    //   279: ifnonnull +73 -> 352
    //   282: aconst_null
    //   283: astore 6
    //   285: aconst_null
    //   286: astore 7
    //   288: new 215	java/io/ObjectInputStream
    //   291: dup
    //   292: new 200	java/io/FileInputStream
    //   295: dup
    //   296: aload 22
    //   298: invokespecial 201	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   301: invokespecial 218	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   304: astore 8
    //   306: aload 8
    //   308: invokevirtual 221	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   311: checkcast 223	[B
    //   314: checkcast 223	[B
    //   317: invokestatic 213	com/baidu/navisdk/util/cache/ImageTools:getBitmapFromByteArray	([B)Landroid/graphics/Bitmap;
    //   320: astore 6
    //   322: aload 6
    //   324: astore 4
    //   326: aload 4
    //   328: astore 6
    //   330: aload 8
    //   332: ifnull +20 -> 352
    //   335: aload 4
    //   337: astore 6
    //   339: aload 4
    //   341: astore 7
    //   343: aload 8
    //   345: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   348: aload 4
    //   350: astore 6
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   360: aload 5
    //   362: ifnull +8 -> 370
    //   365: aload 5
    //   367: invokevirtual 207	java/io/FileInputStream:close	()V
    //   370: aload 6
    //   372: astore_1
    //   373: aload 21
    //   375: monitorexit
    //   376: aload_1
    //   377: areturn
    //   378: aload 10
    //   380: astore 6
    //   382: aload 12
    //   384: astore 7
    //   386: aload 9
    //   388: astore 8
    //   390: aload_1
    //   391: aload 4
    //   393: iconst_0
    //   394: iload_2
    //   395: invokevirtual 225	java/io/ByteArrayOutputStream:write	([BII)V
    //   398: goto -220 -> 178
    //   401: astore 8
    //   403: aload 5
    //   405: astore 7
    //   407: aload_1
    //   408: astore 5
    //   410: aload 7
    //   412: astore 4
    //   414: aload 8
    //   416: invokevirtual 226	java/io/StreamCorruptedException:printStackTrace	()V
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   427: aload 6
    //   429: astore_1
    //   430: aload 7
    //   432: ifnull -59 -> 373
    //   435: aload 7
    //   437: invokevirtual 207	java/io/FileInputStream:close	()V
    //   440: aload 6
    //   442: astore_1
    //   443: goto -70 -> 373
    //   446: astore_1
    //   447: aload_1
    //   448: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   451: aload 6
    //   453: astore_1
    //   454: goto -81 -> 373
    //   457: astore 4
    //   459: aload 10
    //   461: astore 6
    //   463: aload 12
    //   465: astore 7
    //   467: aload 9
    //   469: astore 8
    //   471: aload 4
    //   473: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   476: goto -222 -> 254
    //   479: astore 8
    //   481: aload 5
    //   483: astore 6
    //   485: aload_1
    //   486: astore 5
    //   488: aload 6
    //   490: astore 4
    //   492: aload 8
    //   494: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   497: aload_1
    //   498: ifnull +7 -> 505
    //   501: aload_1
    //   502: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   505: aload 7
    //   507: astore_1
    //   508: aload 6
    //   510: ifnull -137 -> 373
    //   513: aload 6
    //   515: invokevirtual 207	java/io/FileInputStream:close	()V
    //   518: aload 7
    //   520: astore_1
    //   521: goto -148 -> 373
    //   524: astore_1
    //   525: aload_1
    //   526: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   529: aload 7
    //   531: astore_1
    //   532: goto -159 -> 373
    //   535: astore 9
    //   537: aload 4
    //   539: astore 6
    //   541: aload 4
    //   543: astore 7
    //   545: aload 4
    //   547: astore 8
    //   549: aload 9
    //   551: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   554: aload 4
    //   556: astore 6
    //   558: goto -206 -> 352
    //   561: astore 7
    //   563: aload 5
    //   565: astore 6
    //   567: aload_1
    //   568: astore 5
    //   570: aload 6
    //   572: astore 4
    //   574: aload 7
    //   576: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   579: aload_1
    //   580: ifnull +7 -> 587
    //   583: aload_1
    //   584: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   587: aload 8
    //   589: astore_1
    //   590: aload 6
    //   592: ifnull -219 -> 373
    //   595: aload 6
    //   597: invokevirtual 207	java/io/FileInputStream:close	()V
    //   600: aload 8
    //   602: astore_1
    //   603: goto -230 -> 373
    //   606: astore_1
    //   607: aload_1
    //   608: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   611: aload 8
    //   613: astore_1
    //   614: goto -241 -> 373
    //   617: astore 6
    //   619: aload 7
    //   621: astore 8
    //   623: aload 6
    //   625: astore 7
    //   627: aload 8
    //   629: astore 6
    //   631: aload 7
    //   633: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   636: aload 4
    //   638: astore 6
    //   640: aload 8
    //   642: ifnull -290 -> 352
    //   645: aload 4
    //   647: astore 6
    //   649: aload 4
    //   651: astore 7
    //   653: aload 8
    //   655: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   658: aload 4
    //   660: astore 6
    //   662: goto -310 -> 352
    //   665: astore 9
    //   667: aload 4
    //   669: astore 6
    //   671: aload 4
    //   673: astore 7
    //   675: aload 4
    //   677: astore 8
    //   679: aload 9
    //   681: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   684: aload 4
    //   686: astore 6
    //   688: goto -336 -> 352
    //   691: astore 6
    //   693: aload 5
    //   695: astore 4
    //   697: aload_1
    //   698: astore 5
    //   700: aload 6
    //   702: astore_1
    //   703: aload 5
    //   705: ifnull +8 -> 713
    //   708: aload 5
    //   710: invokevirtual 80	java/io/ByteArrayOutputStream:close	()V
    //   713: aload 4
    //   715: ifnull +8 -> 723
    //   718: aload 4
    //   720: invokevirtual 207	java/io/FileInputStream:close	()V
    //   723: aload_1
    //   724: athrow
    //   725: astore 9
    //   727: aload 6
    //   729: astore 8
    //   731: aload 8
    //   733: ifnull +16 -> 749
    //   736: aload 4
    //   738: astore 6
    //   740: aload 4
    //   742: astore 7
    //   744: aload 8
    //   746: invokevirtual 224	java/io/ObjectInputStream:close	()V
    //   749: aload 4
    //   751: astore 6
    //   753: aload 4
    //   755: astore 7
    //   757: aload 4
    //   759: astore 8
    //   761: aload 9
    //   763: athrow
    //   764: astore 10
    //   766: aload 4
    //   768: astore 6
    //   770: aload 4
    //   772: astore 7
    //   774: aload 4
    //   776: astore 8
    //   778: aload 10
    //   780: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   783: goto -34 -> 749
    //   786: astore_1
    //   787: aload_1
    //   788: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   791: aload 6
    //   793: astore_1
    //   794: goto -421 -> 373
    //   797: astore 4
    //   799: aload 4
    //   801: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   804: goto -81 -> 723
    //   807: astore_1
    //   808: goto -681 -> 127
    //   811: astore_1
    //   812: goto -109 -> 703
    //   815: astore 6
    //   817: aload_1
    //   818: astore 5
    //   820: aload 15
    //   822: astore 4
    //   824: aload 6
    //   826: astore_1
    //   827: goto -124 -> 703
    //   830: astore 7
    //   832: aload 14
    //   834: astore 8
    //   836: aload 16
    //   838: astore_1
    //   839: goto -272 -> 567
    //   842: astore 7
    //   844: aload 14
    //   846: astore 8
    //   848: goto -281 -> 567
    //   851: astore 8
    //   853: aload 13
    //   855: astore 7
    //   857: aload 18
    //   859: astore_1
    //   860: aload 11
    //   862: astore 6
    //   864: goto -379 -> 485
    //   867: astore 8
    //   869: aload 13
    //   871: astore 7
    //   873: aload 11
    //   875: astore 6
    //   877: goto -392 -> 485
    //   880: astore 4
    //   882: aload 8
    //   884: astore 6
    //   886: aload 17
    //   888: astore_1
    //   889: aload 4
    //   891: astore 8
    //   893: goto -486 -> 407
    //   896: astore 4
    //   898: aload 8
    //   900: astore 6
    //   902: aload 4
    //   904: astore 8
    //   906: goto -499 -> 407
    //   909: astore 9
    //   911: goto -180 -> 731
    //   914: astore 7
    //   916: goto -289 -> 627
    //   919: astore_1
    //   920: goto -793 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	923	0	this	ImageCache
    //   0	923	1	paramString	String
    //   197	198	2	i	int
    //   85	2	3	bool	boolean
    //   60	353	4	localObject1	Object
    //   457	15	4	localException1	Exception
    //   490	285	4	localObject2	Object
    //   797	3	4	localIOException1	java.io.IOException
    //   822	1	4	localObject3	Object
    //   880	10	4	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   896	7	4	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   56	763	5	localObject4	Object
    //   43	553	6	localObject5	Object
    //   617	7	6	localException2	Exception
    //   629	58	6	localObject6	Object
    //   691	37	6	localObject7	Object
    //   738	54	6	localObject8	Object
    //   815	10	6	localObject9	Object
    //   862	39	6	localObject10	Object
    //   52	492	7	localObject11	Object
    //   561	59	7	localIOException2	java.io.IOException
    //   625	148	7	localObject12	Object
    //   830	1	7	localIOException3	java.io.IOException
    //   842	1	7	localIOException4	java.io.IOException
    //   855	17	7	localObject13	Object
    //   914	1	7	localException3	Exception
    //   1	388	8	localObject14	Object
    //   401	14	8	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   469	1	8	localObject15	Object
    //   479	14	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   547	300	8	localObject16	Object
    //   851	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   867	16	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   891	14	8	localObject17	Object
    //   10	458	9	localObject18	Object
    //   535	15	9	localIOException5	java.io.IOException
    //   665	15	9	localIOException6	java.io.IOException
    //   725	37	9	localObject19	Object
    //   909	1	9	localObject20	Object
    //   16	444	10	localObject21	Object
    //   764	15	10	localIOException7	java.io.IOException
    //   40	834	11	arrayOfByte	byte[]
    //   4	460	12	localObject22	Object
    //   7	863	13	localObject23	Object
    //   13	832	14	localObject24	Object
    //   46	775	15	localObject25	Object
    //   31	806	16	localObject26	Object
    //   37	850	17	localObject27	Object
    //   28	830	18	localObject28	Object
    //   34	99	19	localObject29	Object
    //   49	88	20	localObject30	Object
    //   22	352	21	localObject31	Object
    //   70	227	22	localFile	File
    // Exception table:
    //   from	to	target	type
    //   94	102	119	java/io/IOException
    //   106	114	119	java/io/IOException
    //   171	178	401	java/io/StreamCorruptedException
    //   190	198	401	java/io/StreamCorruptedException
    //   215	221	401	java/io/StreamCorruptedException
    //   233	237	401	java/io/StreamCorruptedException
    //   249	254	401	java/io/StreamCorruptedException
    //   266	273	401	java/io/StreamCorruptedException
    //   343	348	401	java/io/StreamCorruptedException
    //   390	398	401	java/io/StreamCorruptedException
    //   471	476	401	java/io/StreamCorruptedException
    //   549	554	401	java/io/StreamCorruptedException
    //   653	658	401	java/io/StreamCorruptedException
    //   679	684	401	java/io/StreamCorruptedException
    //   744	749	401	java/io/StreamCorruptedException
    //   761	764	401	java/io/StreamCorruptedException
    //   778	783	401	java/io/StreamCorruptedException
    //   423	427	446	java/io/IOException
    //   435	440	446	java/io/IOException
    //   233	237	457	java/lang/Exception
    //   249	254	457	java/lang/Exception
    //   171	178	479	java/io/FileNotFoundException
    //   190	198	479	java/io/FileNotFoundException
    //   215	221	479	java/io/FileNotFoundException
    //   233	237	479	java/io/FileNotFoundException
    //   249	254	479	java/io/FileNotFoundException
    //   266	273	479	java/io/FileNotFoundException
    //   343	348	479	java/io/FileNotFoundException
    //   390	398	479	java/io/FileNotFoundException
    //   471	476	479	java/io/FileNotFoundException
    //   549	554	479	java/io/FileNotFoundException
    //   653	658	479	java/io/FileNotFoundException
    //   679	684	479	java/io/FileNotFoundException
    //   744	749	479	java/io/FileNotFoundException
    //   761	764	479	java/io/FileNotFoundException
    //   778	783	479	java/io/FileNotFoundException
    //   501	505	524	java/io/IOException
    //   513	518	524	java/io/IOException
    //   343	348	535	java/io/IOException
    //   171	178	561	java/io/IOException
    //   190	198	561	java/io/IOException
    //   215	221	561	java/io/IOException
    //   233	237	561	java/io/IOException
    //   249	254	561	java/io/IOException
    //   266	273	561	java/io/IOException
    //   390	398	561	java/io/IOException
    //   471	476	561	java/io/IOException
    //   549	554	561	java/io/IOException
    //   679	684	561	java/io/IOException
    //   761	764	561	java/io/IOException
    //   778	783	561	java/io/IOException
    //   583	587	606	java/io/IOException
    //   595	600	606	java/io/IOException
    //   288	306	617	java/lang/Exception
    //   653	658	665	java/io/IOException
    //   171	178	691	finally
    //   190	198	691	finally
    //   215	221	691	finally
    //   233	237	691	finally
    //   249	254	691	finally
    //   266	273	691	finally
    //   343	348	691	finally
    //   390	398	691	finally
    //   471	476	691	finally
    //   549	554	691	finally
    //   653	658	691	finally
    //   679	684	691	finally
    //   744	749	691	finally
    //   761	764	691	finally
    //   778	783	691	finally
    //   288	306	725	finally
    //   631	636	725	finally
    //   744	749	764	java/io/IOException
    //   356	360	786	java/io/IOException
    //   365	370	786	java/io/IOException
    //   708	713	797	java/io/IOException
    //   718	723	797	java/io/IOException
    //   356	360	807	finally
    //   365	370	807	finally
    //   787	791	807	finally
    //   62	72	811	finally
    //   80	86	811	finally
    //   140	148	811	finally
    //   414	419	811	finally
    //   492	497	811	finally
    //   574	579	811	finally
    //   148	159	815	finally
    //   62	72	830	java/io/IOException
    //   80	86	830	java/io/IOException
    //   140	148	830	java/io/IOException
    //   148	159	842	java/io/IOException
    //   62	72	851	java/io/FileNotFoundException
    //   80	86	851	java/io/FileNotFoundException
    //   140	148	851	java/io/FileNotFoundException
    //   148	159	867	java/io/FileNotFoundException
    //   62	72	880	java/io/StreamCorruptedException
    //   80	86	880	java/io/StreamCorruptedException
    //   140	148	880	java/io/StreamCorruptedException
    //   148	159	896	java/io/StreamCorruptedException
    //   306	322	909	finally
    //   306	322	914	java/lang/Exception
    //   94	102	919	finally
    //   106	114	919	finally
    //   114	117	919	finally
    //   120	124	919	finally
    //   127	130	919	finally
    //   373	376	919	finally
    //   423	427	919	finally
    //   435	440	919	finally
    //   447	451	919	finally
    //   501	505	919	finally
    //   513	518	919	finally
    //   525	529	919	finally
    //   583	587	919	finally
    //   595	600	919	finally
    //   607	611	919	finally
    //   708	713	919	finally
    //   718	723	919	finally
    //   723	725	919	finally
    //   799	804	919	finally
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, Bitmap> paramEntry)
  {
    if (size() > this.mMaxEntries)
    {
      if (this.mNeedRecycle)
      {
        paramEntry = (Bitmap)paramEntry.getValue();
        if ((paramEntry != null) && (!paramEntry.isRecycled())) {
          paramEntry.recycle();
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean removeFromDiskCache(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/cache/ImageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */