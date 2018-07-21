package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.m;

final class az
  implements Runnable
{
  az(Context paramContext) {}
  
  public final void run()
  {
    l.a(j.f()).h();
    m.a(this.a, true);
    ag.a(this.a);
    aw.b(this.a);
    j.a(Thread.getDefaultUncaughtExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new aa());
    if (f.a() == h.d) {
      j.a(this.a, -1);
    }
    if (f.b()) {
      j.g().j("Init MTA StatService success.");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */