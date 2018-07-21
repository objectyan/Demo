package com.baidu.che.codriver.util;

import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;

public class b
{
  private static b a;
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      a = new b();
      return a;
    }
    finally {}
  }
  
  public boolean b()
  {
    return NaviAccountUtils.getInstance().isLogin();
  }
  
  public SapiAccount c()
  {
    return SapiAccountManager.getInstance().getSession();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */