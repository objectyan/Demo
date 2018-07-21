package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class je
{
  public static final je b = new je()
  {
    public final je a(long paramAnonymousLong)
    {
      return this;
    }
    
    public final je a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      return this;
    }
    
    public final void f()
      throws IOException
    {}
  };
  private boolean a;
  private long c;
  private long d;
  
  public je a(long paramLong)
  {
    this.a = true;
    this.c = paramLong;
    return this;
  }
  
  public je a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    this.d = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public long c()
  {
    if (!this.a) {
      throw new IllegalStateException("No deadline");
    }
    return this.c;
  }
  
  public long c_()
  {
    return this.d;
  }
  
  public je d()
  {
    this.d = 0L;
    return this;
  }
  
  public boolean d_()
  {
    return this.a;
  }
  
  public je e_()
  {
    this.a = false;
    return this;
  }
  
  public void f()
    throws IOException
  {
    if (Thread.interrupted()) {
      throw new InterruptedIOException("thread interrupted");
    }
    if ((this.a) && (this.c - System.nanoTime() <= 0L)) {
      throw new InterruptedIOException("deadline reached");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/je.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */