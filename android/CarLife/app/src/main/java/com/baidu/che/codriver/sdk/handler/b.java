package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;
import com.baidu.che.codriver.util.h;

public class b
  implements l.a
{
  public static final String a = "BuleToothHandler";
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    h.e("BuleToothHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3 + paramString4);
    if ("set".equals(paramString3)) {
      l.a().a(paramString1, paramString2);
    }
    for (;;)
    {
      return null;
      if ("bt_phone_notify".equals(paramString3))
      {
        if ("0".equals(paramString4)) {
          com.baidu.che.codriver.e.b.a().a(com.baidu.che.codriver.e.b.a.b);
        } else if ("2".equals(paramString4)) {
          com.baidu.che.codriver.e.b.a().a(com.baidu.che.codriver.e.b.a.a);
        } else if ("3".equals(paramString4)) {
          com.baidu.che.codriver.e.b.a().a(com.baidu.che.codriver.e.b.a.e);
        } else if ("1".equals(paramString4)) {
          com.baidu.che.codriver.e.b.a().a(com.baidu.che.codriver.e.b.a.d);
        }
      }
      else if ("bt_media_notify".equals(paramString3)) {
        h.e("BuleToothHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3 + paramString4);
      } else if ("bt_status_notify".equals(paramString3))
      {
        if ("0".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.b);
        } else if ("1".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.d);
        } else if ("2".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.a);
        } else if ("3".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.e);
        } else if ("4".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.f);
        } else if ("5".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.g);
        } else if ("6".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.h);
        } else if ("7".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(com.baidu.che.codriver.sdk.a.b.a.i);
        }
      }
      else if ("bt_service_notify".equals(paramString3)) {
        h.e("BuleToothHandler", "onReceiveCommand-cmdType:" + paramString2 + ";param:" + paramString3 + paramString4);
      } else if ("bt_driver".equals(paramString3)) {
        if ("1".equals(paramString4)) {
          com.baidu.che.codriver.sdk.a.b.a().a(1);
        } else {
          com.baidu.che.codriver.sdk.a.b.a().a(0);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */