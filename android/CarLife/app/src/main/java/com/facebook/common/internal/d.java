package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class d
  extends FilterOutputStream
{
  private long a = 0L;
  
  public d(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
    this.a += 1L;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.a += paramInt2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */