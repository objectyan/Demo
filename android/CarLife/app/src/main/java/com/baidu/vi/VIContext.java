package com.baidu.vi;

import android.content.Context;

public class VIContext
{
  static Context a;
  
  public static Context getContext()
  {
    return a;
  }
  
  public static void init(Context paramContext)
  {
    a = paramContext;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/vi/VIContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */