package com.baidu.android.pushservice.j;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class i
{
  byte[] a;
  private DataOutputStream b;
  
  public i(OutputStream paramOutputStream)
  {
    this.b = new DataOutputStream(paramOutputStream);
    this.a = new byte[8];
  }
  
  public void a()
    throws IOException
  {
    this.b.close();
  }
  
  public final void a(int paramInt)
    throws Exception
  {
    this.a[1] = ((byte)(paramInt >> 8));
    this.a[0] = ((byte)paramInt);
    this.b.write(this.a, 0, 2);
  }
  
  public final void a(long paramLong)
    throws Exception
  {
    this.a[7] = ((byte)(int)(paramLong >> 56));
    this.a[6] = ((byte)(int)(paramLong >> 48));
    this.a[5] = ((byte)(int)(paramLong >> 40));
    this.a[4] = ((byte)(int)(paramLong >> 32));
    this.a[3] = ((byte)(int)(paramLong >> 24));
    this.a[2] = ((byte)(int)(paramLong >> 16));
    this.a[1] = ((byte)(int)(paramLong >> 8));
    this.a[0] = ((byte)(int)paramLong);
    this.b.write(this.a, 0, 8);
  }
  
  public void a(byte[] paramArrayOfByte)
    throws Exception
  {
    this.b.write(paramArrayOfByte);
  }
  
  public final void b(int paramInt)
    throws Exception
  {
    this.a[3] = ((byte)(paramInt >> 24));
    this.a[2] = ((byte)(paramInt >> 16));
    this.a[1] = ((byte)(paramInt >> 8));
    this.a[0] = ((byte)paramInt);
    this.b.write(this.a, 0, 4);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */