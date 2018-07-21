package com.facebook.imagepipeline.memory;

import com.facebook.common.e.a;
import com.facebook.common.h.c;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class x
  extends InputStream
{
  private static final String a = "PooledByteInputStream";
  private final InputStream b;
  private final byte[] c;
  private final c<byte[]> d;
  private int e;
  private int f;
  private boolean g;
  
  public x(InputStream paramInputStream, byte[] paramArrayOfByte, c<byte[]> paramc)
  {
    this.b = ((InputStream)k.a(paramInputStream));
    this.c = ((byte[])k.a(paramArrayOfByte));
    this.d = ((c)k.a(paramc));
    this.e = 0;
    this.f = 0;
    this.g = false;
  }
  
  private boolean a()
    throws IOException
  {
    if (this.f < this.e) {
      return true;
    }
    int i = this.b.read(this.c);
    if (i <= 0) {
      return false;
    }
    this.e = i;
    this.f = 0;
    return true;
  }
  
  private void b()
    throws IOException
  {
    if (this.g) {
      throw new IOException("stream already closed");
    }
  }
  
  public int available()
    throws IOException
  {
    if (this.f <= this.e) {}
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      b();
      return this.e - this.f + this.b.available();
    }
  }
  
  public void close()
    throws IOException
  {
    if (!this.g)
    {
      this.g = true;
      this.d.a(this.c);
      super.close();
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    if (!this.g)
    {
      a.e("PooledByteInputStream", "Finalized without closing");
      close();
    }
    super.finalize();
  }
  
  public int read()
    throws IOException
  {
    if (this.f <= this.e) {}
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      b();
      if (a()) {
        break;
      }
      return -1;
    }
    byte[] arrayOfByte = this.c;
    int i = this.f;
    this.f = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.f <= this.e) {}
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      b();
      if (a()) {
        break;
      }
      return -1;
    }
    paramInt2 = Math.min(this.e - this.f, paramInt2);
    System.arraycopy(this.c, this.f, paramArrayOfByte, paramInt1, paramInt2);
    this.f += paramInt2;
    return paramInt2;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (this.f <= this.e) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      b();
      i = this.e - this.f;
      if (i < paramLong) {
        break;
      }
      this.f = ((int)(this.f + paramLong));
      return paramLong;
    }
    this.f = this.e;
    return i + this.b.skip(paramLong - i);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */