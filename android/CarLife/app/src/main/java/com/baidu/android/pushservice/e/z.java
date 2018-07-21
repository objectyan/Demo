package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;

public class z
  extends d
{
  public z(l paraml, Context paramContext)
  {
    super(paraml, paramContext);
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    b.a(paramHashMap);
    paramHashMap.put("method", "unbindapp");
    paramHashMap.put("appid", this.b.f);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */