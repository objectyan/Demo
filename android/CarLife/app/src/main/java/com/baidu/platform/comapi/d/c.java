package com.baidu.platform.comapi.d;

import org.json.JSONArray;
import org.json.JSONObject;

final class c
{
  private JSONObject a;
  
  /* Error */
  public c(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 15	java/lang/Object:<init>	()V
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_1
    //   10: invokevirtual 21	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_2
    //   14: invokevirtual 27	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_1
    //   18: aload_1
    //   19: astore_3
    //   20: aload_1
    //   21: astore 4
    //   23: aload_0
    //   24: new 29	org/json/JSONObject
    //   27: dup
    //   28: aload_1
    //   29: invokestatic 32	com/baidu/platform/comapi/d/c:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   32: invokespecial 35	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   35: putfield 37	com/baidu/platform/comapi/d/c:a	Lorg/json/JSONObject;
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 42	java/io/InputStream:close	()V
    //   46: return
    //   47: astore_1
    //   48: aload_3
    //   49: astore 4
    //   51: new 44	java/lang/RuntimeException
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 47	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: astore_1
    //   61: aload 4
    //   63: ifnull +8 -> 71
    //   66: aload 4
    //   68: invokevirtual 42	java/io/InputStream:close	()V
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: return
    //   75: astore_2
    //   76: goto -5 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	c
    //   0	79	1	paramContext	android.content.Context
    //   0	79	2	paramString	String
    //   8	41	3	localContext	android.content.Context
    //   5	62	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	47	java/lang/Exception
    //   23	38	47	java/lang/Exception
    //   9	18	60	finally
    //   23	38	60	finally
    //   51	60	60	finally
    //   42	46	73	java/io/IOException
    //   66	71	75	java/io/IOException
  }
  
  /* Error */
  private static String a(java.io.InputStream paramInputStream)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: new 50	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_0
    //   22: new 55	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: invokespecial 56	java/io/ByteArrayOutputStream:<init>	()V
    //   29: astore_2
    //   30: sipush 512
    //   33: newarray <illegal type>
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 60	java/io/BufferedInputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_m1
    //   44: if_icmpeq +41 -> 85
    //   47: aload_2
    //   48: aload_3
    //   49: iconst_0
    //   50: iload_1
    //   51: invokevirtual 64	java/io/ByteArrayOutputStream:write	([BII)V
    //   54: goto -18 -> 36
    //   57: astore 4
    //   59: aload_2
    //   60: astore_3
    //   61: aload_0
    //   62: astore_2
    //   63: aload 4
    //   65: athrow
    //   66: astore_0
    //   67: aload_3
    //   68: ifnull +7 -> 75
    //   71: aload_3
    //   72: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: aload_2
    //   86: invokevirtual 69	java/io/ByteArrayOutputStream:flush	()V
    //   89: aload_2
    //   90: ldc 71
    //   92: invokevirtual 75	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_3
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 65	java/io/ByteArrayOutputStream:close	()V
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   112: aload_3
    //   113: areturn
    //   114: astore_2
    //   115: goto -11 -> 104
    //   118: astore_0
    //   119: aload_3
    //   120: areturn
    //   121: astore_3
    //   122: goto -47 -> 75
    //   125: astore_2
    //   126: goto -43 -> 83
    //   129: astore 5
    //   131: aload_0
    //   132: astore_2
    //   133: aload 4
    //   135: astore_3
    //   136: aload 5
    //   138: astore_0
    //   139: goto -72 -> 67
    //   142: astore 4
    //   144: aload_2
    //   145: astore_3
    //   146: aload_0
    //   147: astore_2
    //   148: aload 4
    //   150: astore_0
    //   151: goto -84 -> 67
    //   154: astore 4
    //   156: aload 6
    //   158: astore_0
    //   159: aload 5
    //   161: astore_3
    //   162: goto -101 -> 61
    //   165: astore 4
    //   167: aload 5
    //   169: astore_3
    //   170: goto -109 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramInputStream	java.io.InputStream
    //   41	10	1	i	int
    //   1	100	2	localObject1	Object
    //   114	1	2	localIOException1	java.io.IOException
    //   125	1	2	localIOException2	java.io.IOException
    //   132	16	2	localInputStream	java.io.InputStream
    //   6	114	3	localObject2	Object
    //   121	1	3	localIOException3	java.io.IOException
    //   135	35	3	localObject3	Object
    //   8	1	4	localObject4	Object
    //   57	77	4	localIOException4	java.io.IOException
    //   142	7	4	localObject5	Object
    //   154	1	4	localIOException5	java.io.IOException
    //   165	1	4	localIOException6	java.io.IOException
    //   11	1	5	localObject6	Object
    //   129	39	5	localObject7	Object
    //   3	154	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	36	57	java/io/IOException
    //   36	42	57	java/io/IOException
    //   47	54	57	java/io/IOException
    //   85	96	57	java/io/IOException
    //   13	22	66	finally
    //   63	66	66	finally
    //   100	104	114	java/io/IOException
    //   108	112	118	java/io/IOException
    //   71	75	121	java/io/IOException
    //   79	83	125	java/io/IOException
    //   22	30	129	finally
    //   30	36	142	finally
    //   36	42	142	finally
    //   47	54	142	finally
    //   85	96	142	finally
    //   13	22	154	java/io/IOException
    //   22	30	165	java/io/IOException
  }
  
  public byte[] a()
  {
    JSONArray localJSONArray = this.a.optJSONArray("ver");
    if (localJSONArray != null)
    {
      byte[] arrayOfByte2 = new byte[localJSONArray.length()];
      int i = 0;
      int j = localJSONArray.length();
      for (;;)
      {
        arrayOfByte1 = arrayOfByte2;
        if (i >= j) {
          break;
        }
        arrayOfByte2[i] = ((byte)localJSONArray.optInt(i));
        i += 1;
      }
    }
    byte[] arrayOfByte1 = null;
    return arrayOfByte1;
  }
  
  public String[] b()
  {
    JSONArray localJSONArray = this.a.optJSONArray("res");
    if (localJSONArray != null)
    {
      String[] arrayOfString2 = new String[localJSONArray.length()];
      int i = 0;
      int j = localJSONArray.length();
      for (;;)
      {
        arrayOfString1 = arrayOfString2;
        if (i >= j) {
          break;
        }
        arrayOfString2[i] = localJSONArray.optString(i);
        i += 1;
      }
    }
    String[] arrayOfString1 = null;
    return arrayOfString1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */