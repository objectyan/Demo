package com.indooratlas.android.sdk._internal;

public final class er
{
  public final double a;
  public final double b;
  public final double c;
  public final double d;
  
  public er(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if ((paramDouble3 < paramDouble1) || (paramDouble4 < paramDouble2)) {
      throw new IllegalArgumentException(String.format("Invalid values for a rectangle: %f, %f, %f, %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Double.valueOf(paramDouble3), Double.valueOf(paramDouble4) }));
    }
    this.a = paramDouble1;
    this.c = paramDouble3;
    this.b = paramDouble2;
    this.d = paramDouble4;
  }
  
  public final String toString()
  {
    return "Rectangle{(" + this.a + ", " + this.b + "), (" + this.c + ", " + this.d + ")}";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */