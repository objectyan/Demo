package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.c;

final class bg
  implements Runnable
{
  bg(Context paramContext, k paramk, c paramc) {}
  
  public final void run()
  {
    try
    {
      com.tencent.wxop.stat.a.b localb = new com.tencent.wxop.stat.a.b(this.a, j.a(this.a, false, this.b), this.c.a, this.b);
      localb.b().b = this.c.b;
      new ac(localb).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.a, localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */