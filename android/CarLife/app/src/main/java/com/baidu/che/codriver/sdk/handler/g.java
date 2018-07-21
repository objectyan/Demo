package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.sdk.a.j;
import com.baidu.che.codriver.sdk.a.j.a;
import com.baidu.che.codriver.sdk.a.l;
import com.baidu.che.codriver.sdk.a.l.a;

public class g
  implements l.a
{
  public String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("set".equals(paramString3))
    {
      j.a().a(new a(null));
      l.a().a(paramString1, paramString2);
    }
    while (!"reset".equals(paramString3)) {
      return null;
    }
    j.a().a(null);
    return null;
  }
  
  private class a
    implements j.a
  {
    private a() {}
    
    public void a(int paramInt)
    {
      l.a().a("player.tool", "switch.mode", String.valueOf(paramInt));
    }
    
    public boolean a()
    {
      return true;
    }
    
    public void b()
    {
      l.a().a("player.tool", "play", null);
    }
    
    public void c()
    {
      l.a().a("player.tool", "pause", null);
    }
    
    public void d()
    {
      l.a().a("player.tool", "exit", null);
    }
    
    public void e()
    {
      l.a().a("player.tool", "prev", null);
    }
    
    public void f()
    {
      l.a().a("player.tool", "next", null);
    }
    
    public void g()
    {
      l.a().a("player.tool", "change", null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/handler/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */