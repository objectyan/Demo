package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.location.LocationManager;
import com.baidu.platform.comapi.c;

public class i
  implements g
{
  private int a = -1;
  private int b = -1;
  
  public int a()
  {
    if (this.a == -1) {
      a(c.f());
    }
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    int j = 1;
    try
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      if (paramContext.isProviderEnabled("gps"))
      {
        i = 1;
        this.a = i;
        if (!paramContext.isProviderEnabled("network")) {
          break label50;
        }
      }
      label50:
      for (int i = j;; i = 0)
      {
        this.b = i;
        return;
        i = 0;
        break;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public int b()
  {
    if (this.b == -1) {
      a(c.f());
    }
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */