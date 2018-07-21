package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.a.c;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.sdk.a.n;
import com.baidu.che.codriver.sdk.a.n.a;
import com.baidu.che.codriver.sdk.a.n.b;
import com.google.gson.Gson;

public class h
  implements l.a
{
  private static final String a = h.class.getSimpleName();
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.baidu.che.codriver.util.h.e(a, "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3);
    if ("set".equals(paramString3))
    {
      c.a().a(new n()
      {
        public void a() {}
        
        public void a(n.b paramAnonymousb, n.a paramAnonymousa)
        {
          l.a().a("private_radio.tool", "open", new Gson().toJson(paramAnonymousb));
        }
      });
      l.a().a(paramString1, paramString2);
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */