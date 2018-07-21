package com.tencent.wxop.stat;

public class e
  implements Cloneable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private String d = null;
  private long e = 0L;
  private long f = 0L;
  private int g = 0;
  private long h = 0L;
  private int i = 0;
  private int j = 1;
  
  public e(String paramString)
  {
    this.d = paramString;
  }
  
  public e(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, int paramInt3)
  {
    this.d = paramString;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramInt1;
    this.h = paramLong3;
    this.i = paramInt2;
    this.j = paramInt3;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public long b()
  {
    return this.e;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  public long c()
  {
    return this.f;
  }
  
  public void c(int paramInt)
  {
    int k = paramInt;
    if (paramInt <= 0) {
      k = 1;
    }
    this.j = k;
  }
  
  public void c(long paramLong)
  {
    this.h = paramLong;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public long e()
  {
    return this.h;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public int g()
  {
    return this.j;
  }
  
  public e h()
  {
    try
    {
      e locale = (e)super.clone();
      return locale;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */