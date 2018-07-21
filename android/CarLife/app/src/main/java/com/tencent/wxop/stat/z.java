package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class z
  implements Runnable
{
  z(Context paramContext, k paramk) {}
  
  public final void run()
  {
    try
    {
      j.a(this.a, false, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */