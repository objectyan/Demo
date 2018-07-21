package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class q
  implements Runnable
{
  q(Context paramContext) {}
  
  public final void run()
  {
    try
    {
      new Thread(new ab(this.a, null, null), "NetworkMonitorTask").start();
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.a, localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */