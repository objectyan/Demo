package com.indooratlas.android.sdk._internal;

import java.util.Date;

public abstract class v
{
  private static v a = new a();
  
  public static v d()
  {
    return a;
  }
  
  public abstract long a();
  
  public abstract Date b();
  
  public abstract long c();
  
  public static final class a
    extends v
  {
    public final long a()
    {
      return System.nanoTime() / 1000000L;
    }
    
    public final Date b()
    {
      return new Date();
    }
    
    public final long c()
    {
      return System.currentTimeMillis();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */