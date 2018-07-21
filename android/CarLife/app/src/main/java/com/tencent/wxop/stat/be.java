package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.i;
import com.tencent.wxop.stat.b.b;

final class be
  implements Runnable
{
  be(Context paramContext, Throwable paramThrowable) {}
  
  public final void run()
  {
    try
    {
      if (!f.c()) {
        return;
      }
      new ac(new d(this.a, j.a(this.a, false, null), 99, this.b, i.a)).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().h("reportSdkSelfException error: " + localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */