package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.p;
import org.json.JSONObject;

public class n
  extends a
{
  public n(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  public void a(a parama) {}
  
  public void h()
  {
    b localb = new b();
    com.baidu.che.codriver.util.c.a(this.d, "10007");
    if (("navigate".equals(e())) || ("start_navigate".equals(e())))
    {
      localb.j = 2;
      localb.g = this.d.getString(2131297739);
      this.c.a(localb, new m.a()
      {
        public void a()
        {
          PlatformManager.getInstance().sendNaviCommand("key_navi_start_task", Boolean.valueOf(false));
        }
      }, null);
      return;
    }
    if ("quit".equals(e()))
    {
      localb.j = 1;
      localb.g = this.d.getString(2131297729);
      this.c.a(localb, new m.a()
      {
        public void a()
        {
          PlatformManager.getInstance().sendNaviCommand("key_navi_exit_app", Boolean.valueOf(false));
        }
      }, null);
      return;
    }
    c.a().a(this);
    localb.j = 2;
    this.c.a(localb);
  }
  
  protected void i() {}
  
  protected void j() {}
  
  protected JSONObject k()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */