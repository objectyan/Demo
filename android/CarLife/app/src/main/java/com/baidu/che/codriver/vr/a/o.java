package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.sdk.a.h.b;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.c;
import com.baidu.che.codriver.vr.p;

public class o
  extends a
{
  private static final String f = "OperatorCommand";
  boolean e = false;
  private String g;
  private String h;
  private String i;
  private String j;
  private NLPResponseData k = null;
  private h.b l = com.baidu.che.codriver.sdk.a.h.a().b();
  
  public o(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  public void a(a parama)
  {
    com.baidu.che.codriver.util.h.b("OperatorCommand", "NaviGationCommand ------merge()------------");
  }
  
  public void h()
  {
    if (this.l == null) {
      return;
    }
    b localb = new b();
    if (this.l.a())
    {
      localb.f = b.a.c;
      localb.j = 1;
      localb.k = true;
      localb.g = this.d.getString(2131297737);
      this.c.a(m.c.e);
      this.c.a(localb);
      return;
    }
    localb.f = b.a.c;
    localb.j = 2;
    localb.g = this.d.getString(2131296727);
    this.c.a(m.c.e);
    this.c.a(localb);
  }
  
  protected void j() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */