package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ac
{
  private static final int a = 16384;
  private final int b;
  private final f c;
  
  public ac(f paramf)
  {
    this(paramf, 16384);
  }
  
  @VisibleForTesting
  ac(f paramf, int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      this.b = paramInt;
      this.c = paramf;
      return;
    }
  }
  
  /* Error */
  public long a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_0
    //   4: getfield 29	com/facebook/imagepipeline/memory/ac:c	Lcom/facebook/imagepipeline/memory/f;
    //   7: aload_0
    //   8: getfield 27	com/facebook/imagepipeline/memory/ac:b	I
    //   11: invokeinterface 38 2 0
    //   16: checkcast 40	[B
    //   19: astore 6
    //   21: aload_1
    //   22: aload 6
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 27	com/facebook/imagepipeline/memory/ac:b	I
    //   29: invokevirtual 46	java/io/InputStream:read	([BII)I
    //   32: istore_3
    //   33: iload_3
    //   34: iconst_m1
    //   35: if_icmpne +17 -> 52
    //   38: aload_0
    //   39: getfield 29	com/facebook/imagepipeline/memory/ac:c	Lcom/facebook/imagepipeline/memory/f;
    //   42: aload 6
    //   44: invokeinterface 49 2 0
    //   49: lload 4
    //   51: lreturn
    //   52: aload_2
    //   53: aload 6
    //   55: iconst_0
    //   56: iload_3
    //   57: invokevirtual 55	java/io/OutputStream:write	([BII)V
    //   60: lload 4
    //   62: iload_3
    //   63: i2l
    //   64: ladd
    //   65: lstore 4
    //   67: goto -46 -> 21
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 29	com/facebook/imagepipeline/memory/ac:c	Lcom/facebook/imagepipeline/memory/f;
    //   75: aload 6
    //   77: invokeinterface 49 2 0
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ac
    //   0	84	1	paramInputStream	InputStream
    //   0	84	2	paramOutputStream	OutputStream
    //   32	31	3	i	int
    //   1	65	4	l	long
    //   19	57	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	33	70	finally
    //   52	60	70	finally
  }
  
  public long a(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    boolean bool = false;
    if (paramLong > 0L) {
      bool = true;
    }
    k.b(bool);
    long l = 0L;
    arrayOfByte = (byte[])this.c.a(this.b);
    for (;;)
    {
      if (l < paramLong) {}
      try
      {
        int i = paramInputStream.read(arrayOfByte, 0, (int)Math.min(this.b, paramLong - l));
        if (i == -1) {
          return l;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        l += i;
      }
      finally
      {
        this.c.a(arrayOfByte);
      }
    }
    this.c.a(arrayOfByte);
    return l;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */