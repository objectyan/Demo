package com.baidu.android.pushservice.j;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class h
{
  byte[] a;
  private DataInputStream b;
  
  public h(InputStream paramInputStream)
  {
    this.b = new DataInputStream(paramInputStream);
    this.a = new byte[8];
  }
  
  private int a(int paramInt)
    throws IOException
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = this.b.read(this.a, i, paramInt - i);
      if (j == -1) {
        return j;
      }
      i += j;
    }
    return i;
  }
  
  public void a()
    throws IOException
  {
    this.b.close();
  }
  
  public final void a(byte[] paramArrayOfByte)
    throws IOException
  {
    this.b.readFully(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int b()
    throws IOException
  {
    if (a(4) < 0) {
      throw new EOFException();
    }
    return (this.a[3] & 0xFF) << 24 | (this.a[2] & 0xFF) << 16 | (this.a[1] & 0xFF) << 8 | this.a[0] & 0xFF;
  }
  
  public final short c()
    throws IOException
  {
    if (a(2) < 0) {
      throw new EOFException();
    }
    return (short)((this.a[1] & 0xFF) << 8 | this.a[0] & 0xFF);
  }
  
  public final long d()
    throws IOException
  {
    if (a(8) < 0) {
      throw new EOFException();
    }
    int i = this.a[7];
    int j = this.a[6];
    int k = this.a[5];
    int m = this.a[4];
    int n = this.a[3];
    int i1 = this.a[2];
    int i2 = this.a[1];
    int i3 = this.a[0];
    long l = (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF;
    return ((n & 0xFF) << 24 | (i1 & 0xFF) << 16 | (i2 & 0xFF) << 8 | i3 & 0xFF) & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 32;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */