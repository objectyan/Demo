package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.sdk.a.h.b;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.c;
import com.baidu.che.codriver.vr.p;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends a
{
  private static final String f = "InstructionCommand";
  public NLPResponseData e;
  private h.b g;
  
  public h(NLPResponseData paramNLPResponseData, m paramm, Context paramContext)
  {
    super(null, paramm, paramContext);
    this.e = paramNLPResponseData;
  }
  
  public h(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
    this.g = com.baidu.che.codriver.sdk.a.h.a().b();
  }
  
  public void a(a parama) {}
  
  public boolean a()
  {
    try
    {
      int i = a(new JSONObject(g()).optString("option"), 0);
      com.baidu.che.codriver.util.h.b("InstructionCommand", "voice selectIndex:" + i);
      if (this.g == null)
      {
        com.baidu.che.codriver.util.h.b("InstructionCommand", "voice selectIndex operate error ");
        return false;
      }
      c.a().d();
      b localb = new b();
      localb.j = 2;
      localb.g = "";
      if ((i != -1) && (this.g.a(i)))
      {
        this.c.a(localb, null, null);
        return true;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public void h()
  {
    b localb = new b();
    if (this.c.s() == m.c.b) {
      c.a().c(this);
    }
    do
    {
      return;
      if (p())
      {
        if ("no".equals(e()))
        {
          c.a().c(this);
          return;
        }
        if ("yes".equals(e()))
        {
          c.a().c(this);
          return;
        }
        localb.g = this.d.getString(2131296382);
        localb.j = 1;
        this.c.a(localb);
        return;
      }
      if (!"select".equals(e())) {
        break;
      }
      if (c.a().e())
      {
        c.a().c(this);
        return;
      }
    } while (a());
    localb.g = this.d.getString(2131298392);
    this.c.a(localb);
    return;
    if ("no".equals(e()))
    {
      i();
      return;
    }
    if ("quit".equals(e()))
    {
      localb.g = this.d.getString(2131298630);
      localb.j = 2;
      this.c.a(localb);
      return;
    }
    if ("yes".equals(e()))
    {
      if (c.a().e())
      {
        c.a().c(this);
        return;
      }
      i();
      return;
    }
    if ("back".equals(e()))
    {
      this.c.e();
      return;
    }
    if ("next".equals(e()))
    {
      this.c.f();
      return;
    }
    i();
  }
  
  protected void j() {}
  
  protected JSONObject k()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */