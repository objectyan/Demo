package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.m.c;
import com.baidu.che.codriver.vr.p;

public class m
  extends a
{
  public m(p paramp, com.baidu.che.codriver.vr.m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  public void a(a parama)
  {
    super.a(parama);
  }
  
  public void h()
  {
    b localb = new b();
    if (("set_home".equals(e())) || ("set_work".equals(e())))
    {
      localb.f = b.a.c;
      localb.j = 1;
      localb.k = true;
      if ("set_home".equals(e()))
      {
        localb.g = this.d.getString(2131297736);
        this.c.a(m.c.c);
        break label96;
        label86:
        this.c.a(localb);
      }
    }
    for (;;)
    {
      label96:
      return;
      if (!"set_work".equals(e())) {
        break label86;
      }
      localb.g = this.d.getString(2131297735);
      this.c.a(m.c.d);
      break label86;
      if ((!"route_home".equals(e())) && (!"route_work".equals(e()))) {
        break;
      }
      localb.f = b.a.c;
      localb.j = 2;
      if ("route_home".equals(e()))
      {
        if (!NaviCmdController.getInstance().isSetHomeAddress()) {
          break label280;
        }
        localb.g = this.d.getString(2131297733);
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            c.a().a(m.this);
          }
        }, null);
      }
      while ("route_work".equals(e()))
      {
        if (!NaviCmdController.getInstance().isSetCompanyAddress()) {
          break label296;
        }
        localb.g = this.d.getString(2131297732);
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            c.a().a(m.this);
          }
        }, null);
        return;
        label280:
        this.b.b("set_home");
        h();
      }
    }
    label296:
    this.b.b("set_work");
    h();
  }
  
  protected void j() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */