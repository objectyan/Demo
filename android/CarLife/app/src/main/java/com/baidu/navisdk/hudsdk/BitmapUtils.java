package com.baidu.navisdk.hudsdk;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class BitmapUtils
{
  public static byte[] bitmap2Bytes(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramBitmap != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      paramBitmap = localByteArrayOutputStream.toByteArray();
    }
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (IOException localIOException) {}
    return null;
    return paramBitmap;
  }
  
  public static Bitmap bytes2Bimap(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  public static byte[] decodeBase64Str(String paramString)
  {
    if (paramString != null) {
      return Base64.decode(paramString, 0);
    }
    return null;
  }
  
  public static String encodeToBase64Str(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return Base64.encodeToString(paramArrayOfByte, 0);
    }
    return null;
  }
  
  public static void mkdir(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.getParentFile().exists())
    {
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return;
    }
    mkdir(paramString.getParent());
  }
  
  public static Bitmap readBitmapFromFile(String paramString)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    if (paramString != null)
    {
      localBitmap1 = localBitmap2;
      if (paramString.length() != 0)
      {
        localBitmap2 = BitmapFactory.decodeFile(paramString);
        paramString = new File(paramString);
        localBitmap1 = localBitmap2;
        if (paramString.exists())
        {
          paramString.delete();
          localBitmap1 = localBitmap2;
        }
      }
    }
    return localBitmap1;
  }
  
  /* Error */
  public static void writeBitmapToFile(Bitmap paramBitmap, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 61	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: aload_3
    //   16: astore_1
    //   17: aload 5
    //   19: invokevirtual 71	java/io/File:exists	()Z
    //   22: ifeq +11 -> 33
    //   25: aload_3
    //   26: astore_1
    //   27: aload 5
    //   29: invokevirtual 93	java/io/File:delete	()Z
    //   32: pop
    //   33: aload_3
    //   34: astore_1
    //   35: aload 5
    //   37: invokevirtual 98	java/io/File:createNewFile	()Z
    //   40: pop
    //   41: aload_3
    //   42: astore_1
    //   43: new 100	java/io/FileOutputStream
    //   46: dup
    //   47: aload 5
    //   49: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore_3
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne +27 -> 82
    //   58: aload_0
    //   59: getstatic 106	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: bipush 100
    //   64: aload_3
    //   65: invokevirtual 28	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: aload_3
    //   70: invokevirtual 109	java/io/FileOutputStream:flush	()V
    //   73: aload_3
    //   74: ifnull +86 -> 160
    //   77: aload_3
    //   78: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   81: return
    //   82: aload_0
    //   83: getstatic 22	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 100
    //   88: aload_3
    //   89: invokevirtual 28	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: pop
    //   93: goto -24 -> 69
    //   96: astore_1
    //   97: aload_3
    //   98: astore_0
    //   99: aload_1
    //   100: astore_3
    //   101: aload_0
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: ifnull -27 -> 81
    //   111: aload_0
    //   112: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   115: return
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   127: return
    //   128: astore_0
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   137: aload_0
    //   138: athrow
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   144: goto -7 -> 137
    //   147: astore_0
    //   148: aload_3
    //   149: astore_1
    //   150: goto -21 -> 129
    //   153: astore_3
    //   154: aload 4
    //   156: astore_0
    //   157: goto -56 -> 101
    //   160: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramBitmap	Bitmap
    //   0	161	1	paramString	String
    //   0	161	2	paramInt	int
    //   1	148	3	localObject1	Object
    //   153	1	3	localIOException	IOException
    //   3	152	4	localObject2	Object
    //   13	35	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   58	69	96	java/io/IOException
    //   69	73	96	java/io/IOException
    //   82	93	96	java/io/IOException
    //   111	115	116	java/io/IOException
    //   77	81	122	java/io/IOException
    //   17	25	128	finally
    //   27	33	128	finally
    //   35	41	128	finally
    //   43	53	128	finally
    //   103	107	128	finally
    //   133	137	139	java/io/IOException
    //   58	69	147	finally
    //   69	73	147	finally
    //   82	93	147	finally
    //   17	25	153	java/io/IOException
    //   27	33	153	java/io/IOException
    //   35	41	153	java/io/IOException
    //   43	53	153	java/io/IOException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/hudsdk/BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */