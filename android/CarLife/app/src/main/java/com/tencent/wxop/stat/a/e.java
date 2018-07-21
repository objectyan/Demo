package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.ag;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.b.s;
import com.tencent.wxop.stat.k;
import org.json.JSONObject;

public abstract class e
{
  protected static String j = null;
  private k a = null;
  protected String b = null;
  protected long c;
  protected int d;
  protected c e = null;
  protected int f;
  protected String g = null;
  protected String h = null;
  protected String i = null;
  protected boolean k = false;
  protected Context l;
  
  e(Context paramContext, int paramInt, k paramk)
  {
    this.l = paramContext;
    this.c = (System.currentTimeMillis() / 1000L);
    this.d = paramInt;
    this.h = com.tencent.wxop.stat.f.c(paramContext);
    this.i = m.j(paramContext);
    this.b = com.tencent.wxop.stat.f.b(paramContext);
    if (paramk != null)
    {
      this.a = paramk;
      if (m.c(paramk.c())) {
        this.b = paramk.c();
      }
      if (m.c(paramk.d())) {
        this.h = paramk.d();
      }
      if (m.c(paramk.b())) {
        this.i = paramk.b();
      }
      this.k = paramk.e();
    }
    this.g = com.tencent.wxop.stat.f.e(paramContext);
    this.e = ag.a(paramContext).b(paramContext);
    if (a() != f.i) {}
    for (this.f = m.s(paramContext).intValue();; this.f = (-f.i.a()))
    {
      if (!h.b(j))
      {
        paramContext = com.tencent.wxop.stat.f.g(paramContext);
        j = paramContext;
        if (!m.c(paramContext)) {
          j = "0";
        }
      }
      return;
    }
  }
  
  public abstract f a();
  
  public abstract boolean a(JSONObject paramJSONObject);
  
  public boolean b(JSONObject paramJSONObject)
  {
    try
    {
      s.a(paramJSONObject, "ky", this.b);
      paramJSONObject.put("et", a().a());
      if (this.e != null)
      {
        paramJSONObject.put("ui", this.e.b());
        s.a(paramJSONObject, "mc", this.e.c());
        int m = this.e.d();
        paramJSONObject.put("ut", m);
        if ((m == 0) && (m.w(this.l) == 1)) {
          paramJSONObject.put("ia", 1);
        }
      }
      s.a(paramJSONObject, "cui", this.g);
      if (a() != f.b)
      {
        s.a(paramJSONObject, "av", this.i);
        s.a(paramJSONObject, "ch", this.h);
      }
      if (this.k) {
        paramJSONObject.put("impt", 1);
      }
      s.a(paramJSONObject, "mid", j);
      paramJSONObject.put("idx", this.f);
      paramJSONObject.put("si", this.d);
      paramJSONObject.put("ts", this.c);
      paramJSONObject.put("dts", m.a(this.l, false));
      boolean bool = a(paramJSONObject);
      return bool;
    }
    catch (Throwable paramJSONObject) {}
    return false;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public k d()
  {
    return this.a;
  }
  
  public Context e()
  {
    return this.l;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public String g()
  {
    try
    {
      Object localObject = new JSONObject();
      b((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */