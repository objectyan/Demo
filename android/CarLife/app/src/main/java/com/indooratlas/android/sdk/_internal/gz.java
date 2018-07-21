package com.indooratlas.android.sdk._internal;

public enum gz
{
  public final int s;
  public final int t;
  public final int u;
  
  private gz(int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = paramInt1;
    this.t = paramInt2;
    this.u = paramInt3;
  }
  
  public static gz a(int paramInt)
  {
    gz[] arrayOfgz = values();
    int i2 = arrayOfgz.length;
    int i1 = 0;
    while (i1 < i2)
    {
      gz localgz = arrayOfgz[i1];
      if (localgz.t == paramInt) {
        return localgz;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static gz b(int paramInt)
  {
    gz[] arrayOfgz = values();
    int i2 = arrayOfgz.length;
    int i1 = 0;
    while (i1 < i2)
    {
      gz localgz = arrayOfgz[i1];
      if (localgz.s == paramInt) {
        return localgz;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static gz c(int paramInt)
  {
    gz[] arrayOfgz = values();
    int i2 = arrayOfgz.length;
    int i1 = 0;
    while (i1 < i2)
    {
      gz localgz = arrayOfgz[i1];
      if (localgz.u == paramInt) {
        return localgz;
      }
      i1 += 1;
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */