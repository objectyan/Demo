package cz.msebera.android.httpclient.o;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class g
{
  public static String a(n paramn, String paramString)
    throws IOException, ai
  {
    if (paramString != null) {}
    for (paramString = Charset.forName(paramString);; paramString = null) {
      return a(paramn, paramString);
    }
  }
  
  /* Error */
  public static String a(n paramn, Charset paramCharset)
    throws IOException, ai
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: ldc 29
    //   6: invokestatic 34	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_0
    //   11: invokeinterface 40 1 0
    //   16: astore 8
    //   18: aload 8
    //   20: ifnonnull +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: invokeinterface 44 1 0
    //   31: ldc2_w 45
    //   34: lcmp
    //   35: ifgt +6 -> 41
    //   38: iconst_1
    //   39: istore 4
    //   41: iload 4
    //   43: ldc 48
    //   45: invokestatic 51	cz/msebera/android/httpclient/o/a:a	(ZLjava/lang/String;)V
    //   48: aload_0
    //   49: invokeinterface 44 1 0
    //   54: lstore 5
    //   56: lload 5
    //   58: l2i
    //   59: istore_3
    //   60: iload_3
    //   61: istore_2
    //   62: iload_3
    //   63: ifge +7 -> 70
    //   66: sipush 4096
    //   69: istore_2
    //   70: aconst_null
    //   71: astore 7
    //   73: aload_0
    //   74: invokestatic 56	cz/msebera/android/httpclient/g/g:a	(Lcz/msebera/android/httpclient/n;)Lcz/msebera/android/httpclient/g/g;
    //   77: astore 9
    //   79: aload 7
    //   81: astore_0
    //   82: aload 9
    //   84: ifnull +9 -> 93
    //   87: aload 9
    //   89: invokevirtual 60	cz/msebera/android/httpclient/g/g:b	()Ljava/nio/charset/Charset;
    //   92: astore_0
    //   93: aload_0
    //   94: astore 7
    //   96: aload_0
    //   97: ifnonnull +6 -> 103
    //   100: aload_1
    //   101: astore 7
    //   103: aload 7
    //   105: astore_0
    //   106: aload 7
    //   108: ifnonnull +7 -> 115
    //   111: getstatic 66	cz/msebera/android/httpclient/n/f:t	Ljava/nio/charset/Charset;
    //   114: astore_0
    //   115: new 68	java/io/InputStreamReader
    //   118: dup
    //   119: aload 8
    //   121: aload_0
    //   122: invokespecial 71	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   125: astore_0
    //   126: new 73	cz/msebera/android/httpclient/o/d
    //   129: dup
    //   130: iload_2
    //   131: invokespecial 76	cz/msebera/android/httpclient/o/d:<init>	(I)V
    //   134: astore_1
    //   135: sipush 1024
    //   138: newarray <illegal type>
    //   140: astore 7
    //   142: aload_0
    //   143: aload 7
    //   145: invokevirtual 82	java/io/Reader:read	([C)I
    //   148: istore_2
    //   149: iload_2
    //   150: iconst_m1
    //   151: if_icmpeq +35 -> 186
    //   154: aload_1
    //   155: aload 7
    //   157: iconst_0
    //   158: iload_2
    //   159: invokevirtual 85	cz/msebera/android/httpclient/o/d:a	([CII)V
    //   162: goto -20 -> 142
    //   165: astore_0
    //   166: aload 8
    //   168: invokevirtual 90	java/io/InputStream:close	()V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: new 92	java/io/UnsupportedEncodingException
    //   177: dup
    //   178: aload_0
    //   179: invokevirtual 96	java/nio/charset/UnsupportedCharsetException:getMessage	()Ljava/lang/String;
    //   182: invokespecial 99	java/io/UnsupportedEncodingException:<init>	(Ljava/lang/String;)V
    //   185: athrow
    //   186: aload_1
    //   187: invokevirtual 102	cz/msebera/android/httpclient/o/d:toString	()Ljava/lang/String;
    //   190: astore_0
    //   191: aload 8
    //   193: invokevirtual 90	java/io/InputStream:close	()V
    //   196: aload_0
    //   197: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramn	n
    //   0	198	1	paramCharset	Charset
    //   61	98	2	i	int
    //   59	4	3	j	int
    //   1	41	4	bool	boolean
    //   54	3	5	l	long
    //   71	85	7	localObject	Object
    //   16	176	8	localInputStream	InputStream
    //   77	11	9	localg	cz.msebera.android.httpclient.g.g
    // Exception table:
    //   from	to	target	type
    //   25	38	165	finally
    //   41	56	165	finally
    //   73	79	165	finally
    //   87	93	165	finally
    //   111	115	165	finally
    //   115	142	165	finally
    //   142	149	165	finally
    //   154	162	165	finally
    //   174	186	165	finally
    //   186	191	165	finally
    //   73	79	173	java/nio/charset/UnsupportedCharsetException
    //   87	93	173	java/nio/charset/UnsupportedCharsetException
  }
  
  public static void a(n paramn)
  {
    try
    {
      b(paramn);
      return;
    }
    catch (IOException paramn) {}
  }
  
  public static void a(x paramx, n paramn)
    throws IOException
  {
    a.a(paramx, "Response");
    b(paramx.b());
    paramx.a(paramn);
  }
  
  public static void b(n paramn)
    throws IOException
  {
    if (paramn == null) {}
    do
    {
      do
      {
        return;
      } while (!paramn.isStreaming());
      paramn = paramn.getContent();
    } while (paramn == null);
    paramn.close();
  }
  
  public static byte[] c(n paramn)
    throws IOException
  {
    boolean bool = false;
    a.a(paramn, "Entity");
    InputStream localInputStream = paramn.getContent();
    if (localInputStream == null) {
      return null;
    }
    try
    {
      if (paramn.getContentLength() <= 2147483647L) {
        bool = true;
      }
      a.a(bool, "HTTP entity too large to be buffered in memory");
      int j = (int)paramn.getContentLength();
      int i = j;
      if (j < 0) {
        i = 4096;
      }
      paramn = new c(i);
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramn.a(arrayOfByte, 0, i);
      }
      paramn = paramn.b();
    }
    finally
    {
      localInputStream.close();
    }
    localInputStream.close();
    return paramn;
  }
  
  @Deprecated
  public static String d(n paramn)
    throws ai
  {
    a.a(paramn, "Entity");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramn.getContentType() != null)
    {
      paramn = paramn.getContentType().e();
      localObject1 = localObject2;
      if (paramn.length > 0)
      {
        paramn = paramn[0].a("charset");
        localObject1 = localObject2;
        if (paramn != null) {
          localObject1 = paramn.b();
        }
      }
    }
    return (String)localObject1;
  }
  
  @Deprecated
  public static String e(n paramn)
    throws ai
  {
    a.a(paramn, "Entity");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramn.getContentType() != null)
    {
      paramn = paramn.getContentType().e();
      localObject1 = localObject2;
      if (paramn.length > 0) {
        localObject1 = paramn[0].a();
      }
    }
    return (String)localObject1;
  }
  
  public static String f(n paramn)
    throws IOException, ai
  {
    return a(paramn, (Charset)null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/o/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */