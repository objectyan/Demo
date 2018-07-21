package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import java.util.Timer;

class bz
  implements Runnable
{
  bz(by paramby, Context paramContext) {}
  
  public void run()
  {
    if (by.a(this.b) != null)
    {
      by.a(this.b).cancel();
      by.a(this.b, null);
    }
    by.a(this.b, SendStrategyEnum.values()[bj.a().b(this.a)]);
    by.a(this.b, bj.a().c(this.a));
    by.a(this.b, bj.a().d(this.a));
    if (by.b(this.b).equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
      this.b.b(this.a);
    }
    for (;;)
    {
      by.d(this.b).postDelayed(new ca(this), by.c(this.b) * 1000);
      return;
      if (by.b(this.b).equals(SendStrategyEnum.ONCE_A_DAY)) {
        this.b.b(this.a);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */