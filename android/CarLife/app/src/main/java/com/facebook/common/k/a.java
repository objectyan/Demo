package com.facebook.common.k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class a
  extends FilterInputStream
{
  private int a;
  private int b;
  
  public a(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("limit must be >= 0");
    }
    this.a = paramInt;
    this.b = -1;
  }
  
  public int available()
    throws IOException
  {
    return Math.min(this.in.available(), this.a);
  }
  
  public void mark(int paramInt)
  {
    if (this.in.markSupported())
    {
      this.in.mark(paramInt);
      this.b = this.a;
    }
  }
  
  public int read()
    throws IOException
  {
    int i;
    if (this.a == 0) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = this.in.read();
      i = j;
    } while (j == -1);
    this.a -= 1;
    return j;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.a == 0) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, this.a);
      paramInt2 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    this.a -= paramInt2;
    return paramInt2;
  }
  
  public void reset()
    throws IOException
  {
    if (!this.in.markSupported()) {
      throw new IOException("mark is not supported");
    }
    if (this.b == -1) {
      throw new IOException("mark not set");
    }
    this.in.reset();
    this.a = this.b;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = Math.min(paramLong, this.a);
    paramLong = this.in.skip(paramLong);
    this.a = ((int)(this.a - paramLong));
    return paramLong;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */