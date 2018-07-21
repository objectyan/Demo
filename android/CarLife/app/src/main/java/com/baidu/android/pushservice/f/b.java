package com.baidu.android.pushservice.f;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class b
{
  static
  {
    if (Build.VERSION.SDK_INT <= 8) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  public static a a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    str2 = null;
    str1 = null;
    locala = new a();
    try
    {
      paramString1 = a(paramString1, paramString2, null);
      str1 = paramString1;
      str2 = paramString1;
      a(paramString2, paramHashMap, paramString1);
      str1 = paramString1;
      str2 = paramString1;
      paramHashMap = a(paramString1);
      paramString2 = paramHashMap;
      if (paramString1 != null)
      {
        paramString1.disconnect();
        paramString2 = paramHashMap;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = locala;
      return locala;
    }
    finally
    {
      if (str2 == null) {
        break label82;
      }
      str2.disconnect();
    }
    return paramString2;
  }
  
  public static a a(String paramString1, String paramString2, HashMap<String, String> paramHashMap, String paramString3)
  {
    str2 = null;
    str1 = null;
    locala = new a();
    try
    {
      paramString1 = a(paramString1, paramString2, paramString3);
      str1 = paramString1;
      str2 = paramString1;
      a(paramString2, paramHashMap, paramString1);
      str1 = paramString1;
      str2 = paramString1;
      paramHashMap = a(paramString1);
      paramString2 = paramHashMap;
      if (paramString1 != null)
      {
        paramString1.disconnect();
        paramString2 = paramHashMap;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = locala;
      return locala;
    }
    finally
    {
      if (str2 == null) {
        break label87;
      }
      str2.disconnect();
    }
    return paramString2;
  }
  
  private static a a(HttpURLConnection paramHttpURLConnection)
    throws Exception
  {
    localObject2 = null;
    a locala = new a();
    i = 0;
    for (localObject1 = localObject2;; localObject1 = localObject2)
    {
      try
      {
        j = paramHttpURLConnection.getResponseCode();
        i = j;
        localObject1 = localObject2;
        if (a(j))
        {
          i = j;
          localObject1 = localObject2;
          localObject2 = paramHttpURLConnection.getErrorStream();
          localObject1 = localObject2;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        for (;;)
        {
          label101:
          paramHttpURLConnection = (HttpURLConnection)localObject1;
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = new BufferedInputStream((InputStream)localObject1);
          i = j;
          localObject1 = localObject2;
          if (!b(paramHttpURLConnection)) {
            continue;
          }
          i = j;
          localObject1 = localObject2;
          paramHttpURLConnection = new GZIPInputStream((InputStream)localObject2);
        }
        catch (Exception paramHttpURLConnection)
        {
          paramHttpURLConnection = (HttpURLConnection)localObject1;
          i = j;
          break label101;
          paramHttpURLConnection = (HttpURLConnection)localObject2;
          break;
        }
        try
        {
          localObject1 = new ByteArrayInputStream(a(paramHttpURLConnection));
          paramHttpURLConnection = (HttpURLConnection)localObject1;
          i = j;
        }
        catch (Exception localException)
        {
          i = j;
          break label101;
        }
      }
      locala.a(i);
      locala.a(paramHttpURLConnection);
      return locala;
      i = j;
      localObject1 = localObject2;
      localObject2 = paramHttpURLConnection.getInputStream();
    }
  }
  
  private static String a(HashMap<String, String> paramHashMap)
    throws Exception
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 0;
    if (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      if (i != 0) {
        localStringBuffer.append("&");
      }
      String str = (String)((Map.Entry)localObject).getKey();
      if (!TextUtils.isEmpty(str))
      {
        localStringBuffer.append(str).append("=");
        localObject = (String)((Map.Entry)localObject).getValue();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label118;
        }
        localStringBuffer.append(URLEncoder.encode((String)localObject, "UTF-8"));
      }
      for (;;)
      {
        i += 1;
        break;
        label118:
        localStringBuffer.append(URLEncoder.encode("", "UTF-8"));
      }
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  private static HttpURLConnection a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 158	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 159	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 163	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 43	java/net/HttpURLConnection
    //   14: astore_0
    //   15: aload_0
    //   16: sipush 30000
    //   19: invokevirtual 166	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   22: aload_0
    //   23: sipush 30000
    //   26: invokevirtual 169	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   29: ldc -85
    //   31: aload_1
    //   32: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne +12 -> 47
    //   38: ldc -79
    //   40: aload_1
    //   41: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   44: ifeq +66 -> 110
    //   47: aload_0
    //   48: iconst_1
    //   49: invokevirtual 181	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   52: aload_0
    //   53: iconst_1
    //   54: invokevirtual 184	java/net/HttpURLConnection:setDoInput	(Z)V
    //   57: aload_0
    //   58: iconst_0
    //   59: invokevirtual 187	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 190	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: ldc -64
    //   70: ldc -62
    //   72: invokevirtual 198	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: ldc -56
    //   78: ldc -54
    //   80: invokevirtual 198	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_2
    //   84: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +10 -> 97
    //   90: aload_0
    //   91: ldc -52
    //   93: aload_2
    //   94: invokevirtual 198	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: instanceof 206
    //   101: ifeq +3 -> 104
    //   104: aload_0
    //   105: invokevirtual 209	java/net/HttpURLConnection:connect	()V
    //   108: aload_0
    //   109: areturn
    //   110: ldc -45
    //   112: aload_1
    //   113: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifeq +11 -> 127
    //   119: aload_0
    //   120: iconst_1
    //   121: invokevirtual 181	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   124: goto -62 -> 62
    //   127: ldc -43
    //   129: aload_1
    //   130: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifeq -71 -> 62
    //   136: aload_0
    //   137: iconst_0
    //   138: invokevirtual 181	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   141: goto -79 -> 62
    //   144: astore_0
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: aload_0
    //   149: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString1	String
    //   0	150	1	paramString2	String
    //   0	150	2	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   0	15	144	java/lang/Exception
    //   15	47	147	java/lang/Exception
    //   47	62	147	java/lang/Exception
    //   62	97	147	java/lang/Exception
    //   97	104	147	java/lang/Exception
    //   104	108	147	java/lang/Exception
    //   110	124	147	java/lang/Exception
    //   127	141	147	java/lang/Exception
  }
  
  private static void a(String paramString, HashMap<String, String> paramHashMap, HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    if ((("POST".equals(paramString)) || ("PUT".equals(paramString)) || ("DELETE".equals(paramString))) && (!a(paramHttpURLConnection, paramHashMap))) {
      throw new IOException("failed to writeRequestParams");
    }
  }
  
  public static void a(Closeable... paramVarArgs)
  {
    if (paramVarArgs != null) {
      try
      {
        if (paramVarArgs.length > 0)
        {
          int j = paramVarArgs.length;
          int i = 0;
          while (i < j)
          {
            Closeable localCloseable = paramVarArgs[i];
            if (localCloseable != null) {
              localCloseable.close();
            }
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramVarArgs) {}
    }
  }
  
  private static boolean a(int paramInt)
  {
    paramInt /= 100;
    return (paramInt == 4) || (paramInt == 5) || (paramInt == 6);
  }
  
  /* Error */
  private static boolean a(HttpURLConnection paramHttpURLConnection, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: invokevirtual 230	java/util/HashMap:isEmpty	()Z
    //   10: ifeq +125 -> 135
    //   13: iconst_0
    //   14: istore_2
    //   15: aload_0
    //   16: invokevirtual 234	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   19: astore_0
    //   20: new 236	java/io/DataOutputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 239	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_3
    //   29: aload_3
    //   30: aload_1
    //   31: invokestatic 241	com/baidu/android/pushservice/f/b:a	(Ljava/util/HashMap;)Ljava/lang/String;
    //   34: ldc -110
    //   36: invokevirtual 245	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   39: invokevirtual 248	java/io/DataOutputStream:write	([B)V
    //   42: aload_3
    //   43: invokevirtual 251	java/io/DataOutputStream:flush	()V
    //   46: iconst_2
    //   47: anewarray 225	java/io/Closeable
    //   50: dup
    //   51: iconst_0
    //   52: aload_3
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 253	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   61: iload_2
    //   62: ireturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_3
    //   67: astore_1
    //   68: iconst_2
    //   69: anewarray 225	java/io/Closeable
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_1
    //   79: aastore
    //   80: invokestatic 253	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_0
    //   90: iconst_2
    //   91: anewarray 225	java/io/Closeable
    //   94: dup
    //   95: iconst_0
    //   96: aload_3
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_0
    //   101: aastore
    //   102: invokestatic 253	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_3
    //   110: goto -20 -> 90
    //   113: astore_1
    //   114: goto -24 -> 90
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_3
    //   120: aload_0
    //   121: astore_1
    //   122: aload_3
    //   123: astore_0
    //   124: goto -56 -> 68
    //   127: astore_1
    //   128: aload_0
    //   129: astore_1
    //   130: aload_3
    //   131: astore_0
    //   132: goto -64 -> 68
    //   135: iconst_1
    //   136: istore_2
    //   137: goto -122 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramHttpURLConnection	HttpURLConnection
    //   0	140	1	paramHashMap	HashMap<String, String>
    //   14	123	2	bool	boolean
    //   1	130	3	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   15	20	63	java/lang/Exception
    //   15	20	85	finally
    //   20	29	107	finally
    //   29	46	113	finally
    //   20	29	117	java/lang/Exception
    //   29	46	127	java/lang/Exception
  }
  
  /* Error */
  public static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 256	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 257	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: sipush 1024
    //   11: newarray <illegal type>
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: invokevirtual 263	java/io/InputStream:read	([B)I
    //   19: istore_1
    //   20: iload_1
    //   21: iconst_m1
    //   22: if_icmpeq +34 -> 56
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: iload_1
    //   29: invokevirtual 266	java/io/ByteArrayOutputStream:write	([BII)V
    //   32: goto -18 -> 14
    //   35: astore_3
    //   36: iconst_2
    //   37: anewarray 225	java/io/Closeable
    //   40: dup
    //   41: iconst_0
    //   42: aload_2
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_0
    //   47: aastore
    //   48: invokestatic 253	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   51: aload_2
    //   52: invokevirtual 270	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   55: areturn
    //   56: iconst_2
    //   57: anewarray 225	java/io/Closeable
    //   60: dup
    //   61: iconst_0
    //   62: aload_2
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_0
    //   67: aastore
    //   68: invokestatic 253	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   71: goto -20 -> 51
    //   74: astore_3
    //   75: iconst_2
    //   76: anewarray 225	java/io/Closeable
    //   79: dup
    //   80: iconst_0
    //   81: aload_2
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: aload_0
    //   86: aastore
    //   87: invokestatic 253	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   90: aload_3
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramInputStream	InputStream
    //   19	10	1	i	int
    //   7	75	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   13	14	3	arrayOfByte	byte[]
    //   35	1	3	localException	Exception
    //   74	17	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	35	java/lang/Exception
    //   25	32	35	java/lang/Exception
    //   14	20	74	finally
    //   25	32	74	finally
  }
  
  private static boolean b(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Encoding");
    return (!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("zip"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */