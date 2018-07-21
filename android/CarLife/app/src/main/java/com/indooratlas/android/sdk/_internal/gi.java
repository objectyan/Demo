package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public enum gi
{
  private final String e;
  
  private gi(String paramString)
  {
    this.e = paramString;
  }
  
  public static gi a(String paramString)
    throws IOException
  {
    if (paramString.equals(a.e)) {
      return a;
    }
    if (paramString.equals(b.e)) {
      return b;
    }
    if (paramString.equals(d.e)) {
      return d;
    }
    if (paramString.equals(c.e)) {
      return c;
    }
    throw new IOException("Unexpected protocol: " + paramString);
  }
  
  public final String toString()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */