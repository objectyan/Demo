package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.e.b;
import com.baidu.che.codriver.sdk.a.i;
import com.baidu.che.codriver.sdk.a.i.b;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;

public class f
  implements l.a
{
  public static final String a = "PhoneCommandHandler";
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.e("PhoneCommandHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3 + "data:" + paramString4);
    if ("set".equals(paramString3))
    {
      i.b().a(new a(null));
      l.a().a(paramString1, paramString2);
    }
    do
    {
      return null;
      if ("notify_phone_status".equals(paramString3))
      {
        i.b().a(paramString4);
        return null;
      }
      if (("phone_book_data".equals(paramString3)) && (paramString4 != null))
      {
        b.a().c(paramString4);
        return null;
      }
    } while (!"reset".equals(paramString3));
    i.b().a(null);
    return null;
  }
  
  private class a
    implements i.b
  {
    private a() {}
    
    public void a(String paramString)
    {
      i.b().a("call", paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */