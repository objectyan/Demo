package com.baidu.android.pushservice.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class a
{
  public static String a()
  {
    return "QM/LurxEwvmX7RXA7cj5A6YOE9UNth30QE0T/8ZIdzn+9n7bHEY83yXrh+PjawH+NvooDz6aiM/AHshDo/AvNNyF5eOIihFbRNb4SSf56B6CFneI7NUf9VlyZVKcyfwfJbxO8YS4KG8y891gB5xNw+La7Ib4auEcw5yQdePhK1lvCJdWCbMJUUelU9uEihUy5Pjdt5apgOkU0+TrgJtJ3pr4JJdzrbEJGfruCK1tcACGqKK5KnPI50uXEGc3F0cXPMed6Y3x+9cj9p9/G8nMMkklQUJHTYlLd2Kt470Ipf68c7hlVZ6nESJznJcAjM6DreiD+c/MMXV3mMAEqM9EBh0EPk8ymMj1Ej+1+HfHLgHEz0mIP1y/GGooVglxvrbfLFuHAmKXcSThHYhjv+kVmMZQ71Iyj6Pkdq6LFDuSEFU57tCkBBBRcn5Lol62xz3y15o9/xoSp8vvfyi92YvXRHSdrAC7lTUhUqe9dXSUMO7HiO+gdBwYf9EDiTPom2lcwuEfjyThWKDTEPTF2cishBSYgtRQuXRHkc4wsrhGMPhUZOKZNFHLlMzGQMVoRhU5gs7PB+B/9r5LfFh9+YTrNuLt50orgsGM+/zVgexNgBP73fPLuyfNqJv8zNWc/ZiUPA+0h5KPK+7rYH9xqn1ywA==";
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 18	com/baidu/android/pushservice/c/a:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +7 -> 13
    //   9: invokestatic 20	com/baidu/android/pushservice/c/a:a	()Ljava/lang/String;
    //   12: areturn
    //   13: new 22	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: new 28	java/io/BufferedReader
    //   24: dup
    //   25: new 30	java/io/InputStreamReader
    //   28: dup
    //   29: aload_1
    //   30: ldc 32
    //   32: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   35: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 41	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +17 -> 62
    //   48: aload_2
    //   49: aload_0
    //   50: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 41	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: astore_0
    //   59: goto -15 -> 44
    //   62: iconst_1
    //   63: anewarray 47	java/io/Closeable
    //   66: dup
    //   67: iconst_0
    //   68: aload_3
    //   69: aastore
    //   70: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   73: iconst_1
    //   74: anewarray 47	java/io/Closeable
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   84: aload_2
    //   85: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: areturn
    //   89: astore_0
    //   90: iconst_1
    //   91: anewarray 47	java/io/Closeable
    //   94: dup
    //   95: iconst_0
    //   96: aload_3
    //   97: aastore
    //   98: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   101: goto -28 -> 73
    //   104: astore_0
    //   105: iconst_1
    //   106: anewarray 47	java/io/Closeable
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   116: goto -32 -> 84
    //   119: astore_0
    //   120: iconst_1
    //   121: anewarray 47	java/io/Closeable
    //   124: dup
    //   125: iconst_0
    //   126: aload_3
    //   127: aastore
    //   128: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   131: aload_0
    //   132: athrow
    //   133: astore_0
    //   134: iconst_1
    //   135: anewarray 47	java/io/Closeable
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: aastore
    //   142: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   145: aload_0
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   4	137	1	localInputStream	InputStream
    //   20	65	2	localStringBuilder	StringBuilder
    //   38	89	3	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   39	44	89	java/io/IOException
    //   48	59	89	java/io/IOException
    //   21	39	104	java/io/UnsupportedEncodingException
    //   62	73	104	java/io/UnsupportedEncodingException
    //   90	101	104	java/io/UnsupportedEncodingException
    //   120	133	104	java/io/UnsupportedEncodingException
    //   39	44	119	finally
    //   48	59	119	finally
    //   21	39	133	finally
    //   62	73	133	finally
    //   90	101	133	finally
    //   120	133	133	finally
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 60	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 67	java/io/File:exists	()Z
    //   15: ifne +16 -> 31
    //   18: aload_2
    //   19: invokevirtual 71	java/io/File:getParentFile	()Ljava/io/File;
    //   22: invokevirtual 74	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: aload_2
    //   27: invokevirtual 77	java/io/File:createNewFile	()Z
    //   30: pop
    //   31: new 79	java/io/FileWriter
    //   34: dup
    //   35: aload_0
    //   36: iconst_0
    //   37: invokespecial 82	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   40: astore_0
    //   41: new 84	java/io/BufferedWriter
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 87	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   49: astore_2
    //   50: aload_2
    //   51: aload_1
    //   52: invokevirtual 90	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   55: iconst_2
    //   56: anewarray 47	java/io/Closeable
    //   59: dup
    //   60: iconst_0
    //   61: aload_2
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_0
    //   66: aastore
    //   67: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_3
    //   76: astore_1
    //   77: iconst_2
    //   78: anewarray 47	java/io/Closeable
    //   81: dup
    //   82: iconst_0
    //   83: aload_1
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: aload_0
    //   88: aastore
    //   89: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_1
    //   95: aconst_null
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_2
    //   99: iconst_2
    //   100: anewarray 47	java/io/Closeable
    //   103: dup
    //   104: iconst_0
    //   105: aload_2
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_0
    //   110: aastore
    //   111: invokestatic 52	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_2
    //   119: goto -20 -> 99
    //   122: astore_1
    //   123: goto -24 -> 99
    //   126: astore_1
    //   127: aload_3
    //   128: astore_1
    //   129: goto -52 -> 77
    //   132: astore_1
    //   133: aload_2
    //   134: astore_1
    //   135: goto -58 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString1	String
    //   0	138	1	paramString2	String
    //   10	124	2	localObject1	Object
    //   1	127	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	72	java/lang/Exception
    //   31	41	72	java/lang/Exception
    //   2	31	94	finally
    //   31	41	94	finally
    //   41	50	116	finally
    //   50	55	122	finally
    //   41	50	126	java/lang/Exception
    //   50	55	132	java/lang/Exception
  }
  
  private static InputStream b(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        paramString = new FileInputStream(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      return null;
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */