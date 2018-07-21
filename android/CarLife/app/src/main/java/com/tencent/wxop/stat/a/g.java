package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.s;
import com.tencent.wxop.stat.k;
import org.json.JSONObject;

public class g
  extends e
{
  private com.tencent.wxop.stat.g a = null;
  
  public g(Context paramContext, int paramInt, com.tencent.wxop.stat.g paramg, k paramk)
  {
    super(paramContext, paramInt, paramk);
    this.a = paramg.d();
  }
  
  public f a()
  {
    return f.g;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (this.a == null) {
      return false;
    }
    s.a(paramJSONObject, "wod", this.a.a());
    s.a(paramJSONObject, "gid", this.a.b());
    s.a(paramJSONObject, "lev", this.a.c());
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */