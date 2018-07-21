package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.k;
import org.json.JSONObject;

public class l
  extends e
{
  private d a;
  private JSONObject m = null;
  
  public l(Context paramContext, int paramInt, JSONObject paramJSONObject, k paramk)
  {
    super(paramContext, paramInt, paramk);
    this.a = new d(paramContext);
    this.m = paramJSONObject;
  }
  
  public f a()
  {
    return f.b;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (this.e != null) {
      paramJSONObject.put("ut", this.e.d());
    }
    if (this.m != null) {
      paramJSONObject.put("cfg", this.m);
    }
    if (m.y(this.l)) {
      paramJSONObject.put("ncts", 1);
    }
    this.a.a(paramJSONObject, null);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */