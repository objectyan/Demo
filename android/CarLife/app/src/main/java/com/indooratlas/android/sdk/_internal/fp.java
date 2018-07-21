package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public final class fp
  implements Closeable, Flushable
{
  final gt a;
  private final gr b;
  
  public final void close()
    throws IOException
  {
    this.b.close();
  }
  
  public final void flush()
    throws IOException
  {
    this.b.flush();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */