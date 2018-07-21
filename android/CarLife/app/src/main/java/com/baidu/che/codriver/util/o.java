package com.baidu.che.codriver.util;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class o
{
  private static RequestQueue a;
  
  public static RequestQueue a()
  {
    if (a == null) {
      a(c.a());
    }
    return a;
  }
  
  private static void a(Context paramContext)
  {
    if (a != null) {
      a.stop();
    }
    a = Volley.newRequestQueue(paramContext);
  }
  
  public static void a(Request paramRequest)
  {
    if (a != null)
    {
      a.add(paramRequest);
      return;
    }
    a(c.a());
    a.add(paramRequest);
  }
  
  public static void b()
  {
    if (a != null) {
      a.stop();
    }
    a = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */