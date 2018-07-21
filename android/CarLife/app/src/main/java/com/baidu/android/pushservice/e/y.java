package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;

public class y
  extends d
{
  public y(l paraml, Context paramContext)
  {
    super(paraml, paramContext);
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "unbind");
    int i = a.a(a.a);
    int j = com.baidu.android.pushservice.c.d.a(this.a).b();
    if (com.baidu.android.pushservice.c.d.d(this.a)) {
      i = a.a(a.c);
    }
    for (;;)
    {
      paramHashMap.put("model", i + "");
      return;
      if (com.baidu.android.pushservice.c.d.c(this.a)) {
        i = a.a(a.d);
      } else if (com.baidu.android.pushservice.c.d.b(this.a)) {
        i = a.a(a.e);
      } else if (com.baidu.android.pushservice.c.d.e(this.a)) {
        i = a.a(a.f);
      } else if ((j == 2) || (j == 4) || (j == 3)) {
        i = a.a(a.b);
      }
    }
  }
  
  private static enum a
  {
    private int g;
    
    private a(int paramInt)
    {
      this.g = paramInt;
    }
    
    private int a()
    {
      return this.g;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */