package com.baidu.mobstat;

import android.content.Context;
import android.content.Intent;
import com.baidu.bottom.service.BottomReceiver;

public class at
  extends Thread
{
  public at(BottomReceiver paramBottomReceiver, Context paramContext, Intent paramIntent, dd paramdd) {}
  
  public void run()
  {
    try
    {
      BottomReceiver.a(this.d, this.a, this.b);
      BottomReceiver.b(this.d, this.a, this.b);
      long l = System.currentTimeMillis();
      if (l - BottomReceiver.a() < 30000L)
      {
        bd.a("No need to handle receiver due to time strategy");
        return;
      }
      BottomReceiver.a(l);
      ao.c.a(this.a);
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      this.c.b();
      BottomReceiver.a(null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */