package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;

public class n
  extends c
{
  int d = 1;
  int e = 1;
  String f;
  
  public n(l paraml, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    super(paraml, paramContext);
    this.f = paramString;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "fetchgmsg");
    paramHashMap.put("gid", this.f);
    paramHashMap.put("fetch_type", this.d + "");
    paramHashMap.put("fetch_num", this.e + "");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */