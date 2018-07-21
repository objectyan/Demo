package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.a.e;
import com.baidu.che.codriver.sdk.a.e.a;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;

public class d
  implements l.a
{
  public static final String a = "MediaCommandHandler";
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.e("MediaCommandHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3);
    if ("set".equals(paramString3))
    {
      e.a().a(new e.a()
      {
        public void a()
        {
          e.a().a("radio", null);
        }
        
        public void a(String paramAnonymousString)
        {
          e.a().a("fm", paramAnonymousString);
        }
        
        public void b()
        {
          e.a().a("radio", "close");
        }
        
        public void b(String paramAnonymousString)
        {
          e.a().a("am", paramAnonymousString);
        }
        
        public void c()
        {
          e.a().a("fm", null);
        }
        
        public void d()
        {
          e.a().a("am", null);
        }
        
        public void e()
        {
          e.a().a("usb", null);
        }
        
        public void f()
        {
          e.a().a("cd", null);
        }
        
        public void g()
        {
          e.a().a("aux", null);
        }
        
        public void h()
        {
          e.a().a("ipod", null);
        }
        
        public void i()
        {
          e.a().a("bt", null);
        }
        
        public void j()
        {
          e.a().a("mymusic", null);
        }
      });
      l.a().a(paramString1, paramString2);
    }
    while (!"reset".equals(paramString3)) {
      return null;
    }
    e.a().a(null);
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */