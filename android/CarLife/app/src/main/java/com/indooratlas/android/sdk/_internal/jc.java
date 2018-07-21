package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract interface jc
  extends Closeable, Flushable
{
  public abstract je a();
  
  public abstract void a_(in paramin, long paramLong)
    throws IOException;
  
  public abstract void close()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */