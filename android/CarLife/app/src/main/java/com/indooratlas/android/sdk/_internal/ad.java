package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class ad
  extends RuntimeException
{
  public a a;
  public x b;
  private String c;
  
  private ad(a parama, String paramString, Throwable paramThrowable, x paramx)
  {
    super(paramThrowable);
    this.c = paramString;
    this.a = parama;
    this.b = paramx;
  }
  
  public static ad a(String paramString, x paramx)
  {
    return new ad(a.b, paramString, null, paramx);
  }
  
  public static ad a(String paramString, x paramx, Throwable paramThrowable)
  {
    return new ad(a.a, paramString, paramThrowable, paramx);
  }
  
  public static ad a(String paramString, IOException paramIOException)
  {
    return new ad(a.c, paramString, paramIOException, null);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RestError{mKind=").append(this.a).append(", mUrl='").append(this.c).append('\'').append(", mHttpResponse=").append(this.b);
    if (getCause() != null) {
      localStringBuilder.append(", cause=").append(getCause());
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */