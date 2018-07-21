package com.indooratlas.android.sdk._internal;

final class ja
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  ja f;
  ja g;
  
  ja()
  {
    this.a = new byte['ࠀ'];
    this.e = true;
    this.d = false;
  }
  
  ja(ja paramja)
  {
    this(paramja.a, paramja.b, paramja.c);
    paramja.d = true;
  }
  
  private ja(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = false;
    this.d = true;
  }
  
  public final ja a()
  {
    if (this.f != this) {}
    for (ja localja = this.f;; localja = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localja;
    }
  }
  
  public final ja a(ja paramja)
  {
    paramja.g = this;
    paramja.f = this.f;
    this.f.g = paramja;
    this.f = paramja;
    return paramja;
  }
  
  public final void a(ja paramja, int paramInt)
  {
    if (!paramja.e) {
      throw new IllegalArgumentException();
    }
    if (paramja.c + paramInt > 2048)
    {
      if (paramja.d) {
        throw new IllegalArgumentException();
      }
      if (paramja.c + paramInt - paramja.b > 2048) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramja.a, paramja.b, paramja.a, 0, paramja.c - paramja.b);
      paramja.c -= paramja.b;
      paramja.b = 0;
    }
    System.arraycopy(this.a, this.b, paramja.a, paramja.c, paramInt);
    paramja.c += paramInt;
    this.b += paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */