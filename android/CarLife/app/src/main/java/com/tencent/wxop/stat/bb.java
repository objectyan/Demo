package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.m;

final class bb
  implements Runnable
{
  bb(Context paramContext) {}
  
  public final void run()
  {
    if (this.a == null) {
      j.g().g("The Context of StatService.onStop() can not be null!");
    }
    for (;;)
    {
      return;
      j.i(this.a);
      if (j.a()) {
        continue;
      }
      try
      {
        Thread.sleep(100L);
        if (!m.B(this.a)) {
          continue;
        }
        if (f.b()) {
          j.g().b("onStop isBackgroundRunning flushDataToDB");
        }
        j.a(this.a, -1);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */