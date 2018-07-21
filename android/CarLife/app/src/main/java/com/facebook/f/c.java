package com.facebook.f;

import com.facebook.common.internal.i;
import com.facebook.common.internal.k;
import com.facebook.common.internal.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class c
{
  private static final int a = 20;
  private static final int b = 21;
  private static final byte[] c = { -1, -40, -1 };
  private static final byte[] d = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private static final byte[] e = b("GIF87a");
  private static final byte[] f = b("GIF89a");
  private static final int g = 6;
  private static final byte[] h = b("BM");
  private static final int i = i.a(new int[] { 21, 20, c.length, d.length, 6, h.length });
  
  private static int a(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    k.a(paramInputStream);
    k.a(paramArrayOfByte);
    if (paramArrayOfByte.length >= i) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      if (!paramInputStream.markSupported()) {
        break;
      }
      try
      {
        paramInputStream.mark(i);
        int j = com.facebook.common.internal.b.a(paramInputStream, paramArrayOfByte, 0, i);
        return j;
      }
      finally
      {
        paramInputStream.reset();
      }
    }
    return com.facebook.common.internal.b.a(paramInputStream, paramArrayOfByte, 0, i);
  }
  
  public static b a(InputStream paramInputStream)
    throws IOException
  {
    k.a(paramInputStream);
    byte[] arrayOfByte = new byte[i];
    return a(arrayOfByte, a(paramInputStream, arrayOfByte));
  }
  
  /* Error */
  public static b a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 98	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic 103	com/facebook/f/c:a	(Ljava/io/InputStream;)Lcom/facebook/f/b;
    //   17: astore_1
    //   18: aload_0
    //   19: invokestatic 108	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
    //   22: aload_1
    //   23: areturn
    //   24: astore_0
    //   25: aload_2
    //   26: astore_0
    //   27: aload_0
    //   28: astore_1
    //   29: getstatic 114	com/facebook/f/b:j	Lcom/facebook/f/b;
    //   32: astore_2
    //   33: aload_0
    //   34: invokestatic 108	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_1
    //   41: invokestatic 108	com/facebook/common/internal/c:a	(Ljava/io/InputStream;)V
    //   44: aload_0
    //   45: athrow
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: goto -11 -> 40
    //   54: astore_1
    //   55: goto -28 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramString	String
    //   1	48	1	localObject1	Object
    //   54	1	1	localIOException	IOException
    //   3	35	2	localb	b
    //   46	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	24	java/io/IOException
    //   4	13	39	finally
    //   29	33	39	finally
    //   13	18	46	finally
    //   13	18	54	java/io/IOException
  }
  
  private static b a(byte[] paramArrayOfByte, int paramInt)
  {
    k.a(paramArrayOfByte);
    if (com.facebook.common.n.b.c(paramArrayOfByte, 0, paramInt)) {
      return b(paramArrayOfByte, paramInt);
    }
    if (c(paramArrayOfByte, paramInt)) {
      return b.f;
    }
    if (d(paramArrayOfByte, paramInt)) {
      return b.g;
    }
    if (e(paramArrayOfByte, paramInt)) {
      return b.h;
    }
    if (f(paramArrayOfByte, paramInt)) {
      return b.i;
    }
    return b.j;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    k.a(paramArrayOfByte1);
    k.a(paramArrayOfByte2);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      if (paramArrayOfByte2.length + paramInt <= paramArrayOfByte1.length) {
        break;
      }
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= paramArrayOfByte2.length) {
        break label65;
      }
      if (paramArrayOfByte1[(j + paramInt)] != paramArrayOfByte2[j]) {
        break;
      }
      j += 1;
    }
    label65:
    return true;
  }
  
  public static b b(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = a(paramInputStream);
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw o.b(paramInputStream);
    }
  }
  
  private static b b(byte[] paramArrayOfByte, int paramInt)
  {
    k.a(com.facebook.common.n.b.c(paramArrayOfByte, 0, paramInt));
    if (com.facebook.common.n.b.b(paramArrayOfByte, 0)) {
      return b.a;
    }
    if (com.facebook.common.n.b.c(paramArrayOfByte, 0)) {
      return b.b;
    }
    if (com.facebook.common.n.b.b(paramArrayOfByte, 0, paramInt))
    {
      if (com.facebook.common.n.b.a(paramArrayOfByte, 0)) {
        return b.e;
      }
      if (com.facebook.common.n.b.d(paramArrayOfByte, 0)) {
        return b.d;
      }
      return b.c;
    }
    return b.j;
  }
  
  private static byte[] b(String paramString)
  {
    k.a(paramString);
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII not found!", paramString);
    }
  }
  
  private static boolean c(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= c.length)
    {
      bool1 = bool2;
      if (a(paramArrayOfByte, 0, c)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean d(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= d.length)
    {
      bool1 = bool2;
      if (a(paramArrayOfByte, 0, d)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean e(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt < 6) {}
    while ((!a(paramArrayOfByte, 0, e)) && (!a(paramArrayOfByte, 0, f))) {
      return false;
    }
    return true;
  }
  
  private static boolean f(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt < h.length) {
      return false;
    }
    return a(paramArrayOfByte, 0, h);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */