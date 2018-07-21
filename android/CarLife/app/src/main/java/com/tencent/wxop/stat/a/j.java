package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.b.s;
import com.tencent.wxop.stat.k;
import com.tencent.wxop.stat.l;
import org.json.JSONObject;

public class j
  extends e
{
  private static String a = null;
  private String m = null;
  private String n = null;
  
  public j(Context paramContext, int paramInt, k paramk)
  {
    super(paramContext, paramInt, paramk);
    this.m = l.a(paramContext).b();
    if (a == null) {
      a = m.i(paramContext);
    }
  }
  
  public f a()
  {
    return f.h;
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    s.a(paramJSONObject, "op", a);
    s.a(paramJSONObject, "cn", this.m);
    paramJSONObject.put("sp", this.n);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */