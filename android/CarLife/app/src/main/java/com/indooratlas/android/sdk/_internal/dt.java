package com.indooratlas.android.sdk._internal;

public abstract class dt
{
  protected String a = "SensorTimestampFix";
  
  public abstract long a(int paramInt, long paramLong);
  
  public static final class a
    extends dt
  {
    private dt.b b;
    
    public a()
    {
      this(new dt.b());
    }
    
    private a(dt.b paramb)
    {
      this.b = paramb;
    }
    
    public final long a(int paramInt, long paramLong)
    {
      return System.nanoTime();
    }
  }
  
  static final class b {}
  
  public static final class c
    extends dt
  {
    dt.b b = new dt.b();
    private int c;
    private int d;
    private long e;
    private long f;
    private long g;
    
    public c(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      this.f = paramLong2;
      this.e = paramLong1;
    }
    
    public final long a(int paramInt, long paramLong)
    {
      if (paramInt == this.c)
      {
        this.e = paramLong;
        this.f = System.nanoTime();
      }
      while ((paramInt != this.d) || (this.f == 0L)) {
        return paramLong;
      }
      paramLong = System.nanoTime();
      paramLong = this.e + (paramLong - this.f);
      if (paramLong < this.g)
      {
        paramLong = this.g;
        paramLong = this.e;
        paramLong = this.f;
        paramLong = this.g;
      }
      for (;;)
      {
        return paramLong;
        this.g = paramLong;
      }
    }
    
    public final String toString()
    {
      return "{mBaseSensorType: " + this.c + ", mAdjustSensorType: " + this.d + ", mLastBaseSensorSystemTime: " + this.e + "}";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */