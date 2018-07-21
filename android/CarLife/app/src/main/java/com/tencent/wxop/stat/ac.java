package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.e;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.b.r;
import java.util.Map;

class ac
{
  private static volatile long f = 0L;
  private e a;
  private h b = null;
  private boolean c = false;
  private Context d = null;
  private long e = System.currentTimeMillis();
  
  public ac(e parame)
  {
    this.a = parame;
    this.b = f.a();
    this.c = parame.f();
    this.d = parame.e();
  }
  
  private void a(av paramav)
  {
    aw.b(j.f()).a(this.a, paramav);
  }
  
  private void b()
  {
    if ((this.a.d() != null) && (this.a.d().a())) {
      this.b = h.a;
    }
    if ((f.j) && (l.a(j.f()).e())) {
      this.b = h.a;
    }
    if (f.b()) {
      j.g().b("strategy=" + this.b.name());
    }
    switch (s.a[this.b.ordinal()])
    {
    default: 
      j.g().g("Invalid stat strategy:" + f.a());
    }
    do
    {
      do
      {
        return;
        c();
        return;
        ag.a(this.d).a(this.a, null, this.c, false);
        if (f.b()) {
          j.g().b("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + j.c + ",difftime=" + (j.c - this.e));
        }
        if (j.c == 0L)
        {
          j.c = r.a(this.d, "last_period_ts", 0L);
          if (this.e > j.c) {
            j.j(this.d);
          }
          long l = this.e + f.m() * 60 * 1000;
          if (j.c > l) {
            j.c = l;
          }
          ar.a(this.d).a();
        }
        if (f.b()) {
          j.g().b("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + j.c + ",difftime=" + (j.c - this.e));
        }
      } while (this.e <= j.c);
      j.j(this.d);
      return;
      ag.a(this.d).a(this.a, null, this.c, false);
      return;
      ag.a(this.d).a(this.a, new ad(this), this.c, true);
      return;
      if (l.a(j.f()).c() == 1)
      {
        c();
        return;
      }
      ag.a(this.d).a(this.a, null, this.c, false);
      return;
    } while (!m.e(this.d));
    a(new ae(this));
  }
  
  private void c()
  {
    if ((ag.b().a > 0) && (f.m))
    {
      ag.b().a(this.a, null, this.c, true);
      ag.b().a(-1);
      return;
    }
    a(new af(this));
  }
  
  private boolean d()
  {
    if (f.h > 0)
    {
      if (this.e > j.m())
      {
        j.n().clear();
        j.a(this.e + f.i);
        if (f.b()) {
          j.g().b("clear methodsCalledLimitMap, nextLimitCallClearTime=" + j.m());
        }
      }
      Integer localInteger1 = Integer.valueOf(this.a.a().a());
      Integer localInteger2 = (Integer)j.n().get(localInteger1);
      if (localInteger2 != null)
      {
        j.n().put(localInteger1, Integer.valueOf(localInteger2.intValue() + 1));
        if (localInteger2.intValue() > f.h)
        {
          if (f.b()) {
            j.g().h("event " + this.a.g() + " was discard, cause of called limit, current:" + localInteger2 + ", limit:" + f.h + ", period:" + f.i + " ms");
          }
          return true;
        }
      }
      else
      {
        j.n().put(localInteger1, Integer.valueOf(1));
      }
    }
    return false;
  }
  
  public void a()
  {
    if (d()) {}
    do
    {
      return;
      if ((f.n > 0) && (this.e >= f))
      {
        j.i(this.d);
        f = this.e + f.o;
        if (f.b()) {
          j.g().b("nextFlushTime=" + f);
        }
      }
      if (!l.a(this.d).f()) {
        break;
      }
      if (f.b()) {
        j.g().b("sendFailedCount=" + j.a);
      }
      if (!j.a())
      {
        b();
        return;
      }
      ag.a(this.d).a(this.a, null, this.c, false);
    } while (this.e - j.b <= 1800000L);
    j.g(this.d);
    return;
    ag.a(this.d).a(this.a, null, this.c, false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */