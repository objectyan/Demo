package com.facebook.imagepipeline.memory;

import com.facebook.common.h.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class p
  extends ab
{
  private final m a;
  private a<NativeMemoryChunk> b;
  private int c;
  
  public p(m paramm)
  {
    this(paramm, paramm.g());
  }
  
  public p(m paramm, int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      this.a = ((m)k.a(paramm));
      this.c = 0;
      this.b = a.a(this.a.a(paramInt), this.a);
      return;
    }
  }
  
  private void d()
  {
    if (!a.a(this.b)) {
      throw new a();
    }
  }
  
  public n a()
  {
    d();
    return new n(this.b, this.c);
  }
  
  @VisibleForTesting
  void a(int paramInt)
  {
    d();
    if (paramInt <= ((NativeMemoryChunk)this.b.a()).b()) {
      return;
    }
    NativeMemoryChunk localNativeMemoryChunk = (NativeMemoryChunk)this.a.a(paramInt);
    ((NativeMemoryChunk)this.b.a()).a(0, localNativeMemoryChunk, 0, this.c);
    this.b.close();
    this.b = a.a(localNativeMemoryChunk, this.a);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void close()
  {
    a.c(this.b);
    this.b = null;
    this.c = -1;
    super.close();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    write(new byte[] { (byte)paramInt });
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new ArrayIndexOutOfBoundsException("length=" + paramArrayOfByte.length + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    d();
    a(this.c + paramInt2);
    ((NativeMemoryChunk)this.b.a()).a(this.c, paramArrayOfByte, paramInt1, paramInt2);
    this.c += paramInt2;
  }
  
  public static class a
    extends RuntimeException
  {
    public a()
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */