package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.e;
import com.tencent.wxop.stat.b.b;
import java.util.Map;

final class t
  implements Runnable
{
  t(Context paramContext, String paramString, k paramk) {}
  
  public final void run()
  {
    try
    {
      j.i(this.a);
      synchronized (j.i())
      {
        Object localObject2 = (Long)j.i().remove(this.b);
        if (localObject2 != null)
        {
          localObject2 = Long.valueOf((System.currentTimeMillis() - ((Long)localObject2).longValue()) / 1000L);
          ??? = localObject2;
          if (((Long)localObject2).longValue() <= 0L) {
            ??? = Long.valueOf(1L);
          }
          String str = j.k();
          localObject2 = str;
          if (str != null)
          {
            localObject2 = str;
            if (str.equals(this.b) == true) {
              localObject2 = "-";
            }
          }
          ??? = new com.tencent.wxop.stat.a.k(this.a, (String)localObject2, this.b, j.a(this.a, false, this.c), (Long)???, this.c);
          if (!this.b.equals(j.j())) {
            j.g().e("Invalid invocation since previous onResume on diff page.");
          }
          new ac((e)???).a();
          j.d(this.b);
          return;
        }
      }
      j.g().h("Starttime for PageID:" + this.b + " not found, lost onResume()?");
    }
    catch (Throwable localThrowable)
    {
      j.g().b(localThrowable);
      j.a(this.a, localThrowable);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */