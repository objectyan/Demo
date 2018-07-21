package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.a.g;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;

public class e
  implements l.a
{
  public static final String a = "NLPHandler";
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.e("NLPHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3);
    if ("set".equals(paramString3)) {
      l.a().a(paramString1, paramString2);
    }
    for (;;)
    {
      return null;
      if ("nlp".equals(paramString3)) {
        g.a().a(paramString4);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */