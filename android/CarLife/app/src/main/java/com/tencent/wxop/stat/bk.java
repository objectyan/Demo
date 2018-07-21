package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import java.util.Map;

final class bk
  implements Runnable
{
  bk(String paramString, Context paramContext, k paramk) {}
  
  public final void run()
  {
    try
    {
      synchronized ()
      {
        if (j.i().size() >= f.n())
        {
          j.g().g("The number of page events exceeds the maximum value " + Integer.toString(f.n()));
          return;
        }
        j.c(this.a);
        if (j.i().containsKey(j.j()))
        {
          j.g().h("Duplicate PageID : " + j.j() + ", onResume() repeated?");
          return;
        }
      }
      j.i().put(j.j(), Long.valueOf(System.currentTimeMillis()));
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.b, localThrowable);
      return;
    }
    j.a(this.b, true, this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */