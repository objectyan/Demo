package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class p
  implements Runnable
{
  p(Context paramContext, int paramInt) {}
  
  public final void run()
  {
    try
    {
      j.i(this.a);
      ag.a(this.a).a(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.a, localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */