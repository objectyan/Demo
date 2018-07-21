package com.indooratlas.android.sdk._internal;

public final class es
{
  static final class a
  {
    final int a;
    final int b;
    final int c;
    final int d;
    final int e;
    public final int f;
    
    a(er paramer, int paramInt)
    {
      this.e = paramInt;
      et localet = et.a(paramer.b, paramer.a, paramInt);
      paramer = et.a(paramer.d, paramer.c, paramInt);
      this.f = (1 << paramInt);
      int j = localet.a;
      paramInt = paramer.a;
      int k = localet.a;
      int m = this.f;
      int i = paramInt - k;
      paramInt = i;
      if (i < -m / 2) {
        paramInt = (int)(i + Math.round(-i / m) * m);
      }
      i = paramInt;
      if (paramInt > m / 2) {
        i = (int)(paramInt - Math.round(paramInt / m) * m);
      }
      paramInt = i + k;
      this.a = Math.min(j, paramInt);
      this.b = Math.max(j, paramInt);
      this.c = Math.min(localet.b, paramer.b);
      this.d = Math.max(localet.b, paramer.b);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */