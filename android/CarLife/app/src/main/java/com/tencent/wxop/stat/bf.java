package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;

final class bf
  implements Runnable
{
  bf(Throwable paramThrowable, Context paramContext, k paramk) {}
  
  public final void run()
  {
    if (this.a == null)
    {
      j.g().g("The Throwable error message of StatService.reportException() can not be null!");
      return;
    }
    new ac(new d(this.b, j.a(this.b, false, this.c), 1, this.a, this.c)).a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */