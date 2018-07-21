package com.facebook.common.c;

import android.os.Handler;
import android.os.Looper;

public class i
  extends e
{
  private static i a = null;
  
  private i()
  {
    super(new Handler(Looper.getMainLooper()));
  }
  
  public static i c()
  {
    if (a == null) {
      a = new i();
    }
    return a;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (b())
    {
      paramRunnable.run();
      return;
    }
    super.execute(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */