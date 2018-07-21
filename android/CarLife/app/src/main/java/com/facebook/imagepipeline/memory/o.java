package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class o
  implements z
{
  private final ac a;
  private final m b;
  
  public o(m paramm, ac paramac)
  {
    this.b = paramm;
    this.a = paramac;
  }
  
  /* Error */
  public n a(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifle +43 -> 44
    //   4: iconst_1
    //   5: istore_2
    //   6: iload_2
    //   7: invokestatic 27	com/facebook/common/internal/k:a	(Z)V
    //   10: aload_0
    //   11: getfield 18	com/facebook/imagepipeline/memory/o:b	Lcom/facebook/imagepipeline/memory/m;
    //   14: iload_1
    //   15: invokevirtual 32	com/facebook/imagepipeline/memory/m:a	(I)Ljava/lang/Object;
    //   18: aload_0
    //   19: getfield 18	com/facebook/imagepipeline/memory/o:b	Lcom/facebook/imagepipeline/memory/m;
    //   22: invokestatic 37	com/facebook/common/h/a:a	(Ljava/lang/Object;Lcom/facebook/common/h/c;)Lcom/facebook/common/h/a;
    //   25: astore_3
    //   26: new 39	com/facebook/imagepipeline/memory/n
    //   29: dup
    //   30: aload_3
    //   31: iload_1
    //   32: invokespecial 42	com/facebook/imagepipeline/memory/n:<init>	(Lcom/facebook/common/h/a;I)V
    //   35: astore 4
    //   37: aload_3
    //   38: invokevirtual 45	com/facebook/common/h/a:close	()V
    //   41: aload 4
    //   43: areturn
    //   44: iconst_0
    //   45: istore_2
    //   46: goto -40 -> 6
    //   49: astore 4
    //   51: aload_3
    //   52: invokevirtual 45	com/facebook/common/h/a:close	()V
    //   55: aload 4
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	o
    //   0	58	1	paramInt	int
    //   5	41	2	bool	boolean
    //   25	27	3	locala	com.facebook.common.h.a
    //   35	7	4	localn	n
    //   49	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	37	49	finally
  }
  
  public n a(InputStream paramInputStream)
    throws IOException
  {
    p localp = new p(this.b);
    try
    {
      paramInputStream = a(paramInputStream, localp);
      return paramInputStream;
    }
    finally
    {
      localp.close();
    }
  }
  
  public n a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    p localp = new p(this.b, paramInt);
    try
    {
      paramInputStream = a(paramInputStream, localp);
      return paramInputStream;
    }
    finally
    {
      localp.close();
    }
  }
  
  @VisibleForTesting
  n a(InputStream paramInputStream, p paramp)
    throws IOException
  {
    this.a.a(paramInputStream, paramp);
    return paramp.a();
  }
  
  public n a(byte[] paramArrayOfByte)
  {
    p localp = new p(this.b, paramArrayOfByte.length);
    try
    {
      localp.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localp.a();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw com.facebook.common.internal.o.b(paramArrayOfByte);
    }
    finally
    {
      localp.close();
    }
  }
  
  public p a()
  {
    return new p(this.b);
  }
  
  public p b(int paramInt)
  {
    return new p(this.b, paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */