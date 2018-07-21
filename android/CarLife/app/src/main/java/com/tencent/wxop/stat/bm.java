package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.c;
import com.tencent.wxop.stat.b.b;
import java.util.Map;

final class bm
  implements Runnable
{
  bm(String paramString, c paramc, Context paramContext) {}
  
  public final void run()
  {
    try
    {
      if (j.a(this.a))
      {
        j.g().g("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
        return;
      }
      if (f.b()) {
        j.g().b("add begin key:" + this.b);
      }
      if (j.l().containsKey(this.b))
      {
        j.g().e("Duplicate CustomEvent key: " + this.b.toString() + ", trackCustomBeginKVEvent() repeated?");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.c, localThrowable);
      return;
    }
    if (j.l().size() <= f.n())
    {
      j.l().put(this.b, Long.valueOf(System.currentTimeMillis()));
      return;
    }
    j.g().g("The number of timedEvent exceeds the maximum value " + Integer.toString(f.n()));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */