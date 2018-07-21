package com.baidu.che.codriver.sdk.handler;

import android.view.KeyEvent;
import com.baidu.che.codriver.sdk.a.d;
import com.baidu.che.codriver.sdk.a.d.a;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;

public class c
  implements l.a
{
  public static final String a = "HardKeyCommandHandler";
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.e("HardKeyCommandHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3);
    if ("set".equals(paramString3))
    {
      d.a().a(new d.a()
      {
        public void a(int paramAnonymousInt)
        {
          d.a().a("click", String.valueOf(paramAnonymousInt));
        }
        
        public void a(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          d.a().a("down", String.valueOf(paramAnonymousInt));
        }
        
        public void b(int paramAnonymousInt)
        {
          d.a().a("long_click", String.valueOf(paramAnonymousInt));
        }
        
        public void b(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          d.a().a("up", String.valueOf(paramAnonymousInt));
        }
      });
      l.a().a(paramString1, paramString2);
    }
    while (!"reset".equals(paramString3)) {
      return null;
    }
    d.a().a(null);
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */