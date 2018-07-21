package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.h;
import com.tencent.wxop.stat.b.b;

final class m
  implements Runnable
{
  m(Context paramContext, k paramk, e parame) {}
  
  public final void run()
  {
    try
    {
      new ac(new h(this.a, j.a(this.a, false, this.b), this.c, this.b)).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.a, localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */