package com.indooratlas.android.sdk._internal;

import java.lang.reflect.Field;

public final class bd
{
  public static final String a;
  
  static
  {
    Object localObject = null;
    int i = 0;
    for (;;)
    {
      if (i > 0) {
        break label50;
      }
      String str = new String[] { "com.indooratlas.android.Config" }[i];
      try
      {
        str = (String)Class.forName(str).getDeclaredField("AUTHORITY").get(null);
        localObject = str;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
      i += 1;
    }
    label50:
    if (localObject != null) {}
    for (;;)
    {
      a = (String)localObject;
      return;
      localObject = "com.indooratlas.sdk";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */