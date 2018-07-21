package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract class is
  implements jd
{
  private final jd a;
  
  public is(jd paramjd)
  {
    if (paramjd == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramjd;
  }
  
  public long a(in paramin, long paramLong)
    throws IOException
  {
    return this.a.a(paramin, paramLong);
  }
  
  public final je a()
  {
    return this.a.a();
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */