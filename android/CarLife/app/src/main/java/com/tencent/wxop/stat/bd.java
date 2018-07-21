package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;

final class bd
  implements Runnable
{
  bd(String paramString, Context paramContext, k paramk) {}
  
  public final void run()
  {
    try
    {
      if (j.a(this.a))
      {
        j.g().g("Error message in StatService.reportError() is empty.");
        return;
      }
      new ac(new d(this.b, j.a(this.b, false, this.c), this.a, 0, f.x(), null, this.c)).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.b, localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */