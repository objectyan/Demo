package com.baidu.android.pushservice.message;

import java.io.Serializable;

public class k
  implements Serializable
{
  private String a;
  private String b;
  private long c;
  private int d;
  private byte[] e;
  private long f;
  private long g;
  private long h;
  private boolean i = false;
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public long b()
  {
    return this.f;
  }
  
  public void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public long c()
  {
    return this.g;
  }
  
  public void c(long paramLong)
  {
    this.h = paramLong;
  }
  
  public long d()
  {
    return this.h;
  }
  
  public void d(long paramLong)
  {
    this.c = paramLong;
  }
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public long g()
  {
    return this.c;
  }
  
  public String h()
  {
    return String.valueOf(this.c);
  }
  
  public int i()
  {
    return this.d;
  }
  
  public byte[] j()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "type:" + this.d + " appid:" + this.a + " msgId:" + this.c + " isAlarm:  " + this.i + " pkgName:  " + this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */