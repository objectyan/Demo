package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;

public class o
  extends c
{
  protected String d;
  
  public o(l paraml, Context paramContext, String paramString)
  {
    super(paraml, paramContext);
    this.d = paramString;
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "gbind");
    paramHashMap.put("gid", this.d);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */