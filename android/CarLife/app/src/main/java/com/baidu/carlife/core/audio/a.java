package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.e;

public class a
{
  public static final int a = 120;
  public static final int b = 10240;
  public static final int c = 120;
  public static final int d = 10240;
  public static final int e = 2;
  public static final int f = 102400;
  public static final int g = 12;
  public static final int h = 12;
  public static final int i = 20480;
  public static final int j = 2;
  public static final int k = 2;
  public static final float l = 0.001F;
  public static final int m = 100;
  public static final String n = "Audio-";
  private static a o;
  private static final int p = 0;
  private static final int q = 0;
  private static final int r = 1;
  private int s = 0;
  private int t = 0;
  
  public static a a()
  {
    if (o == null) {
      o = new a();
    }
    return o;
  }
  
  public static boolean h()
  {
    e.a();
    return e.y();
  }
  
  public void a(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    int i1 = 0;
    while (i1 < paramInt1 / 2)
    {
      int i2 = (short)(paramArrayOfByte[(i1 * 2 + paramInt2)] & 0xFF);
      paramArrayOfShort[i1] = ((short)((short)(paramArrayOfByte[(i1 * 2 + paramInt2 + 1)] & 0xFF) << 8 | i2));
      i1 += 1;
    }
  }
  
  public void a(short[] paramArrayOfShort, int paramInt, byte[] paramArrayOfByte)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      int i2 = (short)(paramArrayOfShort[i1] & 0xFF00);
      paramArrayOfByte[(i1 * 2)] = ((byte)((short)(paramArrayOfShort[i1] & 0xFF) & 0xFF));
      paramArrayOfByte[(i1 * 2 + 1)] = ((byte)(i2 >> 8 & 0xFF));
      i1 += 1;
    }
  }
  
  public void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      int i2 = (short)(paramArrayOfShort[i1] & 0xFF00);
      int i3 = (short)(paramArrayOfShort[i1] & 0xFF);
      paramArrayOfByte[(i1 * 2)] = ((byte)(i2 >> 8 & 0xFF));
      paramArrayOfByte[(i1 * 2 + 1)] = ((byte)(i3 & 0xFF));
      i1 += 1;
    }
  }
  
  public void a(short[] paramArrayOfShort, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    while (i1 < paramInt / 2)
    {
      paramArrayOfShort[i1] = ((short)((short)(paramArrayOfByte[(i1 * 2)] & 0xFF) << 8 | (short)(paramArrayOfByte[(i1 * 2 + 1)] & 0xFF)));
      i1 += 1;
    }
  }
  
  public void b()
  {
    this.t = 0;
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public int c()
  {
    return this.t;
  }
  
  public boolean d()
  {
    return c() == 1;
  }
  
  public void e()
  {
    this.s = 0;
  }
  
  public int f()
  {
    return this.s;
  }
  
  public boolean g()
  {
    return f() == a.b.a();
  }
  
  private static enum a
  {
    private int c;
    
    private a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public int a()
    {
      return this.c;
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
  
  public static enum d
  {
    private d() {}
  }
  
  public static enum e
  {
    private e() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */