package com.baidu.mobstat;

import android.content.Context;

public class GetReverse
{
  private static ICooperService a;
  
  public static ICooperService getCooperService(Context paramContext)
  {
    if (a == null) {
      a = CooperService.a();
    }
    return a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/GetReverse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */