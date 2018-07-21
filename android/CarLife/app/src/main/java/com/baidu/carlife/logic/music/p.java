package com.baidu.carlife.logic.music;

import java.util.Random;

public class p
{
  private long a = System.currentTimeMillis();
  private b b = b.a;
  private long c = 0L;
  
  private long a(int paramInt1, int paramInt2)
  {
    return new Random().nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
  }
  
  private long a(long paramLong)
  {
    long l;
    if (paramLong <= 0L) {
      l = a(0, 100);
    }
    do
    {
      return l;
      l = paramLong;
    } while (paramLong < 7200000L);
    return a(0, 1000) + 7200000L;
  }
  
  public static p a()
  {
    return a.a();
  }
  
  public void b()
  {
    if (this.b == b.a)
    {
      this.c = 0L;
      this.a = System.currentTimeMillis();
      this.b = b.d;
    }
  }
  
  public void c()
  {
    if (this.b == b.d)
    {
      this.c += System.currentTimeMillis() - this.a;
      this.b = b.c;
    }
  }
  
  public void d()
  {
    if (this.b == b.c)
    {
      this.a = System.currentTimeMillis();
      this.b = b.d;
    }
  }
  
  public long e()
  {
    long l = f();
    this.b = b.a;
    this.c = 0L;
    this.a = System.currentTimeMillis();
    return l;
  }
  
  public long f()
  {
    if (this.b == b.c) {
      return a(this.c);
    }
    if (this.b == b.d) {
      return a(System.currentTimeMillis() - this.a + this.c);
    }
    return 0L;
  }
  
  private static class a
  {
    private static final p a = new p(null);
  }
  
  private static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */