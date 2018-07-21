package com.indooratlas.android.sdk._internal;

public enum gp
{
  final String e;
  
  private gp(String paramString)
  {
    this.e = paramString;
  }
  
  public static gp a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Unexpected TLS version: " + paramString);
        if (paramString.equals("TLSv1.2"))
        {
          i = 0;
          continue;
          if (paramString.equals("TLSv1.1"))
          {
            i = 1;
            continue;
            if (paramString.equals("TLSv1"))
            {
              i = 2;
              continue;
              if (paramString.equals("SSLv3")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return a;
    return b;
    return c;
    return d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */