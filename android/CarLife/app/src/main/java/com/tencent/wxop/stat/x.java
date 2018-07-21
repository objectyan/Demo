package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class x
  implements Runnable
{
  x(d paramd, Context paramContext, k paramk) {}
  
  public final void run()
  {
    if ((this.a == null) || (this.a.b().trim().length() == 0))
    {
      j.g().f("account is null or empty.");
      return;
    }
    f.d(this.b, this.a.b());
    j.b(this.b, this.a, this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */