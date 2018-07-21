package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.a.k;
import com.baidu.che.codriver.sdk.a.k.b;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;

public class i
  implements l.a
{
  public static final String a = "SystemCommandHandler";
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.b("SystemCommandHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3);
    if ("set".equals(paramString3))
    {
      k.a().a(new k.b()
      {
        public void a(String paramAnonymousString)
        {
          k.a().a("close", paramAnonymousString);
        }
        
        public void a(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          k.a().a("open", paramAnonymousString);
        }
        
        public void b(String paramAnonymousString)
        {
          k.a().a("up", paramAnonymousString);
        }
        
        public void c(String paramAnonymousString)
        {
          k.a().a("down", paramAnonymousString);
        }
        
        public void d(String paramAnonymousString)
        {
          k.a().a("max", paramAnonymousString);
        }
        
        public void e(String paramAnonymousString)
        {
          k.a().a("min", paramAnonymousString);
        }
        
        public void f(String paramAnonymousString)
        {
          k.a().a("operate", paramAnonymousString);
        }
      });
      l.a().a(paramString1, paramString2);
    }
    while (!"reset".equals(paramString3)) {
      return null;
    }
    k.a().a(null);
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */