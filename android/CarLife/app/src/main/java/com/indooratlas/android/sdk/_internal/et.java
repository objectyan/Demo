package com.indooratlas.android.sdk._internal;

public final class et
{
  private static final double d = Math.atan(Math.sinh(3.141592653589793D)) / 3.141592653589793D * 180.0D;
  public final int a;
  public final int b;
  final int c;
  
  public et(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public static et a(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (Math.abs(paramDouble1) > d) {
      throw new IllegalArgumentException("Latitude is outside the valid range");
    }
    int m = 1 << paramInt;
    paramDouble1 = 3.141592653589793D * paramDouble1 / 180.0D;
    int i = (int)Math.floor(m * ((180.0D + paramDouble2) / 360.0D));
    paramDouble2 = m;
    double d1 = Math.tan(paramDouble1);
    int k = (int)Math.floor((1.0D - Math.log(1.0D / Math.cos(paramDouble1) + d1) / 3.141592653589793D) * paramDouble2 / 2.0D);
    int j = i % m;
    i = j;
    if (j < 0) {
      i = j + m;
    }
    return new et(i, k, paramInt);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof et))) {}
    do
    {
      return false;
      paramObject = (et)paramObject;
    } while ((this.c != ((et)paramObject).c) || (this.a != ((et)paramObject).a) || (this.b != ((et)paramObject).b));
    return true;
  }
  
  public final int hashCode()
  {
    return (((int)(this.c ^ this.c >>> 32) + 37) * 37 + (int)(this.a ^ this.a >>> 32)) * 37 + (int)(this.b ^ this.b >>> 32);
  }
  
  public final String toString()
  {
    int i = this.a;
    int j = this.b;
    int k = this.c;
    return "TileLocation(x=" + i + ", y=" + j + ", zoomLevel=" + k + ")";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */