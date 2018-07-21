package com.indooratlas.android.sdk._internal;

public final class di
{
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public double f;
  
  public di(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    this.a = paramString;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramDouble;
  }
  
  public final String toString()
  {
    return "uuid: " + this.a + " major: " + this.c + " minor: " + this.b + " rssi: " + this.d + " calibratedTxPowerLevel: " + this.e + " accuracy: " + this.f;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */