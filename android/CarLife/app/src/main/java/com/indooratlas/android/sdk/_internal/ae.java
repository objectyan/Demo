package com.indooratlas.android.sdk._internal;

public final class ae<R>
{
  public final boolean a;
  public final R b;
  public x c;
  public final ad d;
  
  private ae(boolean paramBoolean, x paramx, R paramR, ad paramad)
  {
    this.a = paramBoolean;
    this.b = paramR;
    this.d = paramad;
    this.c = paramx;
  }
  
  public static <R> ae<R> a(ad paramad, R paramR)
  {
    return new ae(false, null, paramR, paramad);
  }
  
  public static <R> ae<R> a(x paramx, R paramR)
  {
    return new ae(true, paramx, paramR, null);
  }
  
  public final String toString()
  {
    return "RestResponse{success=" + this.a + ", result=" + this.b + ", response=" + this.c + ", error=" + this.d + '}';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */