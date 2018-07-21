package com.baidu.mobstat;

import android.content.Context;
import java.util.Map;

class br
  implements Runnable
{
  br(bm parambm, long paramLong, Context paramContext, String paramString1, String paramString2, ExtraInfo paramExtraInfo, Map paramMap) {}
  
  public void run()
  {
    bv.a().d();
    if (this.a <= 0L)
    {
      db.a("EventStat: Wrong Case, Duration must be positive");
      return;
    }
    this.g.a(this.b, this.c, this.d, 1, System.currentTimeMillis(), this.a, this.e, this.f);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */