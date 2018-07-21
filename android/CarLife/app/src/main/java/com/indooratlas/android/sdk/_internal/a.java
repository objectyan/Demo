package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class a
{
  final byte[] a;
  int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = Integer.MAX_VALUE;
  private int h;
  private int i = 64;
  private int j = 67108864;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = (paramInt + 0);
    this.e = 0;
  }
  
  private byte[] f(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw j.b();
    }
    if (this.e + paramInt > this.g)
    {
      g(this.g - this.e);
      throw j.a();
    }
    if (paramInt <= this.c - this.e)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.a, this.e, arrayOfByte, 0, paramInt);
      this.e += paramInt;
      return arrayOfByte;
    }
    throw j.a();
  }
  
  private void g(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw j.b();
    }
    if (this.e + paramInt > this.g)
    {
      g(this.g - this.e);
      throw j.a();
    }
    if (paramInt <= this.c - this.e)
    {
      this.e += paramInt;
      return;
    }
    throw j.a();
  }
  
  private void m()
  {
    this.c += this.d;
    int k = this.c;
    if (k > this.g)
    {
      this.d = (k - this.g);
      this.c -= this.d;
      return;
    }
    this.d = 0;
  }
  
  private byte n()
    throws IOException
  {
    if (this.e == this.c) {
      throw j.a();
    }
    byte[] arrayOfByte = this.a;
    int k = this.e;
    this.e = (k + 1);
    return arrayOfByte[k];
  }
  
  public final int a()
    throws IOException
  {
    if (this.e == this.c) {}
    for (int k = 1; k != 0; k = 0)
    {
      this.f = 0;
      return 0;
    }
    this.f = f();
    if (this.f == 0) {
      throw j.d();
    }
    return this.f;
  }
  
  public final void a(int paramInt)
    throws j
  {
    if (this.f != paramInt) {
      throw j.e();
    }
  }
  
  public final void a(m paramm)
    throws IOException
  {
    int k = f();
    if (this.h >= this.i) {
      throw j.g();
    }
    k = c(k);
    this.h += 1;
    paramm.a(this);
    a(0);
    this.h -= 1;
    d(k);
  }
  
  public final boolean b()
    throws IOException
  {
    return f() != 0;
  }
  
  public final boolean b(int paramInt)
    throws IOException
  {
    switch (s.a(paramInt))
    {
    default: 
      throw j.f();
    case 0: 
      f();
      return true;
    case 1: 
      i();
      return true;
    case 2: 
      g(f());
      return true;
    case 3: 
      int k;
      do
      {
        k = a();
      } while ((k != 0) && (b(k)));
      a(s.a(s.b(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    h();
    return true;
  }
  
  public final int c(int paramInt)
    throws j
  {
    if (paramInt < 0) {
      throw j.b();
    }
    paramInt = this.e + paramInt;
    int k = this.g;
    if (paramInt > k) {
      throw j.a();
    }
    this.g = paramInt;
    m();
    return k;
  }
  
  public final String c()
    throws IOException
  {
    int k = f();
    if ((k <= this.c - this.e) && (k > 0))
    {
      String str = new String(this.a, this.e, k, i.a);
      this.e = (k + this.e);
      return str;
    }
    return new String(f(k), i.a);
  }
  
  public final void d(int paramInt)
  {
    this.g = paramInt;
    m();
  }
  
  public final byte[] d()
    throws IOException
  {
    int k = f();
    if ((k <= this.c - this.e) && (k > 0))
    {
      byte[] arrayOfByte = new byte[k];
      System.arraycopy(this.a, this.e, arrayOfByte, 0, k);
      this.e = (k + this.e);
      return arrayOfByte;
    }
    if (k == 0) {
      return s.h;
    }
    return f(k);
  }
  
  public final int e()
    throws IOException
  {
    int k = f();
    return -(k & 0x1) ^ k >>> 1;
  }
  
  public final void e(int paramInt)
  {
    if (paramInt > this.e - this.b) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.e - this.b));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.e = (this.b + paramInt);
  }
  
  public final int f()
    throws IOException
  {
    int k = n();
    if (k >= 0) {}
    int n;
    do
    {
      return k;
      k &= 0x7F;
      m = n();
      if (m >= 0) {
        return k | m << 7;
      }
      k |= (m & 0x7F) << 7;
      m = n();
      if (m >= 0) {
        return k | m << 14;
      }
      k |= (m & 0x7F) << 14;
      n = n();
      if (n >= 0) {
        return k | n << 21;
      }
      m = n();
      n = k | (n & 0x7F) << 21 | m << 28;
      k = n;
    } while (m >= 0);
    int m = 0;
    for (;;)
    {
      if (m >= 5) {
        break label133;
      }
      k = n;
      if (n() >= 0) {
        break;
      }
      m += 1;
    }
    label133:
    throw j.c();
  }
  
  public final long g()
    throws IOException
  {
    int k = 0;
    long l = 0L;
    while (k < 64)
    {
      int m = n();
      l |= (m & 0x7F) << k;
      if ((m & 0x80) == 0) {
        return l;
      }
      k += 7;
    }
    throw j.c();
  }
  
  public final int h()
    throws IOException
  {
    return n() & 0xFF | (n() & 0xFF) << 8 | (n() & 0xFF) << 16 | (n() & 0xFF) << 24;
  }
  
  public final long i()
    throws IOException
  {
    int k = n();
    int m = n();
    int n = n();
    int i1 = n();
    int i2 = n();
    int i3 = n();
    int i4 = n();
    int i5 = n();
    long l = k;
    return (m & 0xFF) << 8 | l & 0xFF | (n & 0xFF) << 16 | (i1 & 0xFF) << 24 | (i2 & 0xFF) << 32 | (i3 & 0xFF) << 40 | (i4 & 0xFF) << 48 | (i5 & 0xFF) << 56;
  }
  
  public final int j()
  {
    if (this.g == Integer.MAX_VALUE) {
      return -1;
    }
    int k = this.e;
    return this.g - k;
  }
  
  public final int k()
  {
    return this.e - this.b;
  }
  
  final Object l()
    throws IOException
  {
    return c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */