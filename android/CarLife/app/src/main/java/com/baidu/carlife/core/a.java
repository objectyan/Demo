package com.baidu.carlife.core;

import android.content.Context;
import android.content.ContextWrapper;

public class a
  extends ContextWrapper
  implements h
{
  private static a a;
  
  private a(Context paramContext)
  {
    super(paramContext);
  }
  
  public static a a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */