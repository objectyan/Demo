package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.b.s;
import com.tencent.wxop.stat.k;
import com.tencent.wxop.stat.l;
import org.json.JSONObject;

public class h
  extends e
{
  private static String m = null;
  private static String n = null;
  private com.tencent.wxop.stat.e a = null;
  
  public h(Context paramContext, int paramInt, com.tencent.wxop.stat.e parame, k paramk)
  {
    super(paramContext, paramInt, paramk);
    this.a = parame.h();
  }
  
  public f a()
  {
    return f.f;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (this.a == null) {
      return false;
    }
    paramJSONObject.put("na", this.a.a());
    paramJSONObject.put("rq", this.a.b());
    paramJSONObject.put("rp", this.a.c());
    paramJSONObject.put("rt", this.a.d());
    paramJSONObject.put("tm", this.a.e());
    paramJSONObject.put("rc", this.a.f());
    paramJSONObject.put("sp", this.a.g());
    if (n == null) {
      n = m.n(this.l);
    }
    s.a(paramJSONObject, "av", n);
    if (m == null) {
      m = m.i(this.l);
    }
    s.a(paramJSONObject, "op", m);
    paramJSONObject.put("cn", l.a(this.l).b());
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */