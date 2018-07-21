package com.baidu.che.codriver.sdk.a;

import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.util.h;
import com.baidu.navi.util.StatisticManager;

public class c
{
  private static final String a = c.class.getSimpleName();
  private p b;
  private n c;
  private m d = null;
  
  public static c a()
  {
    return a.a();
  }
  
  public void a(m paramm)
  {
    this.d = paramm;
    LocationUtil.getInstance().setNaviTool(paramm);
  }
  
  public void a(n paramn)
  {
    this.c = paramn;
  }
  
  public void a(p paramp)
  {
    this.b = paramp;
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.b(a, "-onReceiveNaviCmd---func:" + paramString1 + "--params:" + paramString2);
    if (this.d != null)
    {
      this.d.onNaviCommand(paramString1, paramString2);
      StatisticManager.onEvent("VOICE_0005");
    }
  }
  
  public p b()
  {
    return this.b;
  }
  
  public n c()
  {
    return this.c;
  }
  
  public m d()
  {
    return this.d;
  }
  
  private static class a
  {
    private static c a = new c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */