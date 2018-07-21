package com.indooratlas.android.sdk._internal;

import android.os.SystemClock;

public abstract interface cr
{
  public abstract long a();
  
  public abstract long b();
  
  public abstract void c();
  
  public static final class a
    implements cr
  {
    private volatile long a = SystemClock.elapsedRealtime();
    
    public final long a()
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = this.a;
        return l1 - l2;
      }
      finally {}
    }
    
    public final long b()
    {
      return System.currentTimeMillis();
    }
    
    public final void c()
    {
      try
      {
        this.a = SystemClock.elapsedRealtime();
        return;
      }
      finally {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */