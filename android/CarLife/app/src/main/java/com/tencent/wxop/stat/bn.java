package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.c;
import java.util.Map;

final class bn
  implements Runnable
{
  bn(String paramString, c paramc, Context paramContext, k paramk) {}
  
  public final void run()
  {
    for (;;)
    {
      Long localLong;
      try
      {
        if (j.a(this.a))
        {
          j.g().g("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
          return;
        }
        localLong = (Long)j.l().remove(this.b);
        if (localLong == null) {
          break;
        }
        com.tencent.wxop.stat.a.b localb = new com.tencent.wxop.stat.a.b(this.c, j.a(this.c, false, this.d), this.b.a, this.d);
        localb.b().c = this.b.c;
        localLong = Long.valueOf((System.currentTimeMillis() - localLong.longValue()) / 1000L);
        if (localLong.longValue() <= 0L)
        {
          l = 1L;
          localb.a(Long.valueOf(l).longValue());
          new ac(localb).a();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        j.g().b(localThrowable);
        j.a(this.c, localThrowable);
        return;
      }
      long l = localLong.longValue();
    }
    j.g().e("No start time found for custom event: " + this.b.toString() + ", lost trackCustomBeginKVEvent()?");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */