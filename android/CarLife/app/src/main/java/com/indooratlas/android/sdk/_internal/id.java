package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.reflect.Method;

public final class id
  extends Exception
{
  public static final Method a;
  public IOException b;
  
  static
  {
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      a = localMethod;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public id(IOException paramIOException)
  {
    super(paramIOException);
    this.b = paramIOException;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */