package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.s;
import com.tencent.wxop.stat.d;
import com.tencent.wxop.stat.k;
import org.json.JSONObject;

public class a
  extends e
{
  private d a = null;
  
  public a(Context paramContext, int paramInt, d paramd, k paramk)
  {
    super(paramContext, paramInt, paramk);
    this.a = paramd;
  }
  
  public f a()
  {
    return f.e;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    s.a(paramJSONObject, "qq", this.a.b());
    paramJSONObject.put("acc", this.a.a());
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */