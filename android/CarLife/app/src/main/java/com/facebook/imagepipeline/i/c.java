package com.facebook.imagepipeline.i;

import android.graphics.Bitmap;
import com.facebook.common.internal.k;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class c
  extends a
{
  @GuardedBy("this")
  private com.facebook.common.h.a<Bitmap> a;
  private volatile Bitmap b;
  private final g c;
  private final int d;
  
  public c(Bitmap paramBitmap, com.facebook.common.h.c<Bitmap> paramc, g paramg, int paramInt)
  {
    this.b = ((Bitmap)k.a(paramBitmap));
    this.a = com.facebook.common.h.a.a(this.b, (com.facebook.common.h.c)k.a(paramc));
    this.c = paramg;
    this.d = paramInt;
  }
  
  public c(com.facebook.common.h.a<Bitmap> parama, g paramg, int paramInt)
  {
    this.a = ((com.facebook.common.h.a)k.a(parama.c()));
    this.b = ((Bitmap)this.a.a());
    this.c = paramg;
    this.d = paramInt;
  }
  
  private com.facebook.common.h.a<Bitmap> j()
  {
    try
    {
      com.facebook.common.h.a locala = this.a;
      this.a = null;
      this.b = null;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Bitmap a()
  {
    return this.b;
  }
  
  public int b()
  {
    return com.facebook.h.a.a(this.b);
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/facebook/imagepipeline/i/c:a	Lcom/facebook/common/h/a;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	c
    //   12	7	1	bool	boolean
    //   6	2	2	locala	com.facebook.common.h.a
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void close()
  {
    com.facebook.common.h.a locala = j();
    if (locala != null) {
      locala.close();
    }
  }
  
  public g d()
  {
    return this.c;
  }
  
  public com.facebook.common.h.a<Bitmap> f()
  {
    try
    {
      k.a(this.a, "Cannot convert a closed static bitmap");
      com.facebook.common.h.a locala = j();
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int g()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap == null) {
      return 0;
    }
    return localBitmap.getWidth();
  }
  
  public int h()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap == null) {
      return 0;
    }
    return localBitmap.getHeight();
  }
  
  public int i()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */