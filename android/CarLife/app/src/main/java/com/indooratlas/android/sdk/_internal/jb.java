package com.indooratlas.android.sdk._internal;

final class jb
{
  static ja a;
  static long b;
  
  static ja a()
  {
    try
    {
      if (a != null)
      {
        ja localja = a;
        a = localja.f;
        localja.f = null;
        b -= 2048L;
        return localja;
      }
      return new ja();
    }
    finally {}
  }
  
  static void a(ja paramja)
  {
    if ((paramja.f != null) || (paramja.g != null)) {
      throw new IllegalArgumentException();
    }
    if (paramja.d) {
      return;
    }
    try
    {
      if (b + 2048L > 65536L) {
        return;
      }
    }
    finally {}
    b += 2048L;
    paramja.f = a;
    paramja.c = 0;
    paramja.b = 0;
    a = paramja;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */