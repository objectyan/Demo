package com.facebook.common.k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
  extends FilterInputStream
{
  private final byte[] a;
  private int b;
  private int c;
  
  public b(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    super(paramInputStream);
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    this.a = paramArrayOfByte;
  }
  
  private int a()
  {
    if (this.b >= this.a.length) {
      return -1;
    }
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public void mark(int paramInt)
  {
    if (this.in.markSupported())
    {
      super.mark(paramInt);
      this.c = this.b;
    }
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1) {
      return i;
    }
    return a();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1) {
      return i;
    }
    if (paramInt2 == 0) {
      return 0;
    }
    i = 0;
    int j;
    if (i < paramInt2)
    {
      j = a();
      if (j != -1) {}
    }
    else
    {
      if (i <= 0) {
        break label74;
      }
    }
    for (;;)
    {
      return i;
      paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
      i += 1;
      break;
      label74:
      i = -1;
    }
  }
  
  public void reset()
    throws IOException
  {
    if (this.in.markSupported())
    {
      this.in.reset();
      this.b = this.c;
      return;
    }
    throw new IOException("mark is not supported");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/k/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */