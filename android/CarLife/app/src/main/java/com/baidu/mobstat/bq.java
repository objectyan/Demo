package com.baidu.mobstat;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

class bq
  implements Runnable
{
  bq(bm parambm, String paramString1, String paramString2, long paramLong, Context paramContext, ExtraInfo paramExtraInfo, Map paramMap) {}
  
  public void run()
  {
    bv.a().d();
    String str = this.g.a(this.a, this.b);
    bs localbs = (bs)this.g.a.get(str);
    if (localbs == null)
    {
      db.b("EventStat: event_id[" + this.a + "] with label[" + this.b + "] is not started or alread done.");
      return;
    }
    if ((!this.a.equals(localbs.a)) || (!this.b.equals(localbs.b)))
    {
      db.a("EventStat: Wrong Case, eventId/label pair not match");
      return;
    }
    this.g.a.remove(str);
    long l = this.c - localbs.c;
    if (l <= 0L)
    {
      db.a("EventStat: Wrong Case, Duration must be positive");
      return;
    }
    this.g.a(this.d, this.a, this.b, 1, localbs.c, l, this.e, this.f);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */