package com.baidu.location.f;

import java.util.Locale;

public class a
{
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public int e = Integer.MAX_VALUE;
  public int f = Integer.MAX_VALUE;
  public long g = 0L;
  public int h = -1;
  public char i = '0';
  public String j = null;
  private boolean k = false;
  
  public a()
  {
    this.g = System.currentTimeMillis();
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, char paramChar)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.h = paramInt5;
    this.i = paramChar;
    this.g = System.currentTimeMillis();
  }
  
  public a(a parama)
  {
    this(parama.a, parama.b, parama.c, parama.d, parama.h, parama.i);
    this.g = parama.g;
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    return (l - this.g > 0L) && (l - this.g < 3000L);
  }
  
  public boolean a(a parama)
  {
    return (this.a == parama.a) && (this.b == parama.b) && (this.d == parama.d) && (this.c == parama.c);
  }
  
  public boolean b()
  {
    return (this.a > -1) && (this.b > 0);
  }
  
  public boolean c()
  {
    return (this.a == -1) && (this.b == -1) && (this.d == -1) && (this.c == -1);
  }
  
  public boolean d()
  {
    return (this.a > -1) && (this.b > -1) && (this.d == -1) && (this.c == -1);
  }
  
  public boolean e()
  {
    return (this.a > -1) && (this.b > -1) && (this.d > -1) && (this.c > -1);
  }
  
  public void f()
  {
    this.k = true;
  }
  
  public String g()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append(this.b + 23);
    localStringBuffer.append("H");
    localStringBuffer.append(this.a + 45);
    localStringBuffer.append("K");
    localStringBuffer.append(this.d + 54);
    localStringBuffer.append("Q");
    localStringBuffer.append(this.c + 203);
    return localStringBuffer.toString();
  }
  
  public String h()
  {
    return String.format(Locale.CHINA, "%d|%d|%d|%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
  
  public String i()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.h) }));
    if (this.k) {
      localStringBuffer.append("&newcl=1");
    }
    return localStringBuffer.toString();
  }
  
  public String j()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw2=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.h) }));
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */