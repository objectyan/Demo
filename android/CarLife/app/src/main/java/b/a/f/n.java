package b.a.f;

import java.util.Arrays;

public final class n
{
  static final int a = 65535;
  static final int b = 1;
  static final int c = 2;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 10;
  private int i;
  private final int[] j = new int[10];
  
  n a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.j.length) {
      return this;
    }
    this.i |= 1 << paramInt1;
    this.j[paramInt1] = paramInt2;
    return this;
  }
  
  void a()
  {
    this.i = 0;
    Arrays.fill(this.j, 0);
  }
  
  void a(n paramn)
  {
    int k = 0;
    if (k < 10)
    {
      if (!paramn.a(k)) {}
      for (;;)
      {
        k += 1;
        break;
        a(k, paramn.b(k));
      }
    }
  }
  
  boolean a(int paramInt)
  {
    return (this.i & 1 << paramInt) != 0;
  }
  
  boolean a(boolean paramBoolean)
  {
    int k;
    if ((this.i & 0x4) != 0) {
      k = this.j[2];
    }
    while (k == 1)
    {
      return true;
      if (paramBoolean) {
        k = 1;
      } else {
        k = 0;
      }
    }
    return false;
  }
  
  int b()
  {
    return Integer.bitCount(this.i);
  }
  
  int b(int paramInt)
  {
    return this.j[paramInt];
  }
  
  int c()
  {
    if ((this.i & 0x2) != 0) {
      return this.j[1];
    }
    return -1;
  }
  
  int c(int paramInt)
  {
    if ((this.i & 0x10) != 0) {
      paramInt = this.j[4];
    }
    return paramInt;
  }
  
  int d()
  {
    if ((this.i & 0x80) != 0) {
      return this.j[7];
    }
    return 65535;
  }
  
  int d(int paramInt)
  {
    if ((this.i & 0x20) != 0) {
      paramInt = this.j[5];
    }
    return paramInt;
  }
  
  int e(int paramInt)
  {
    if ((this.i & 0x40) != 0) {
      paramInt = this.j[6];
    }
    return paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/f/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */