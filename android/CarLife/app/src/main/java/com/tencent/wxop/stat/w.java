package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class w
  implements Runnable
{
  w(String paramString, Context paramContext, k paramk) {}
  
  public final void run()
  {
    if ((this.a == null) || (this.a.trim().length() == 0))
    {
      j.g().f("qq num is null or empty.");
      return;
    }
    f.f = this.a;
    j.b(this.b, new d(this.a), this.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */