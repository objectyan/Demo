package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.s;
import org.json.JSONObject;

public class k
  extends e
{
  Long a = null;
  String m;
  String n;
  
  public k(Context paramContext, String paramString1, String paramString2, int paramInt, Long paramLong, com.tencent.wxop.stat.k paramk)
  {
    super(paramContext, paramInt, paramk);
    this.n = paramString1;
    this.m = paramString2;
    this.a = paramLong;
  }
  
  public f a()
  {
    return f.a;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    s.a(paramJSONObject, "pi", this.m);
    s.a(paramJSONObject, "rf", this.n);
    if (this.a != null) {
      paramJSONObject.put("du", this.a);
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */