package com.baidu.mobstat;

import java.util.HashMap;

class bp
  implements Runnable
{
  bp(bm parambm, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    bv.a().d();
    bs localbs = new bs();
    localbs.c = this.a;
    localbs.a = this.b;
    localbs.b = this.c;
    String str = this.d.a(this.b, this.c);
    if (this.d.a.get(str) != null) {
      db.b("EventStat: event_id[" + this.b + "] with label[" + this.c + "] is duplicated, older is removed");
    }
    this.d.a.put(str, localbs);
    db.a("put a keyword[" + str + "] into durationlist");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */