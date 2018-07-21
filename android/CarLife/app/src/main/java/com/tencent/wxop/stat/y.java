package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class y
  implements Runnable
{
  y(g paramg, Context paramContext, k paramk) {}
  
  public final void run()
  {
    if (this.a == null)
    {
      j.g().g("The gameUser of StatService.reportGameUser() can not be null!");
      return;
    }
    if ((this.a.b() == null) || (this.a.b().length() == 0))
    {
      j.g().g("The account of gameUser on StatService.reportGameUser() can not be null or empty!");
      return;
    }
    try
    {
      new ac(new com.tencent.wxop.stat.a.g(this.b, j.a(this.b, false, this.c), this.a, this.c)).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.b, localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */