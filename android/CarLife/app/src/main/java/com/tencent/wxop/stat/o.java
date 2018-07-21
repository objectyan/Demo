package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.c;

final class o
  implements Runnable
{
  o(Context paramContext, k paramk, c paramc, int paramInt) {}
  
  public final void run()
  {
    try
    {
      com.tencent.wxop.stat.a.b localb = new com.tencent.wxop.stat.a.b(this.a, j.a(this.a, false, this.b), this.c.a, this.b);
      localb.b().c = this.c.c;
      Long localLong = Long.valueOf(this.d);
      if (localLong.longValue() <= 0L) {}
      for (long l = 1L;; l = localLong.longValue())
      {
        localb.a(Long.valueOf(l).longValue());
        new ac(localb).a();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.a, localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */