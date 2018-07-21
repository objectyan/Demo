package com.baidu.carlife.core;

import android.os.Handler;
import android.os.Looper;

public class l
  extends Handler
  implements h
{
  private static l a = new l();
  
  private l()
  {
    super(Looper.getMainLooper());
  }
  
  public static l a()
  {
    return a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */