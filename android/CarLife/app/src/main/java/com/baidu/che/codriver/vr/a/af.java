package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.view.View;
import com.baidu.che.codriver.ui.a.f.a;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.i;
import com.baidu.che.codriver.ui.d.i.a;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.m.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class af
  extends a
{
  private static int f = 0;
  private List<com.baidu.che.codriver.e.a> e;
  private com.baidu.che.codriver.sdk.a.p g = com.baidu.che.codriver.sdk.a.c.a().b();
  private String h;
  private com.baidu.che.codriver.sdk.b.a i;
  private a j = a.a;
  private f.a k = new f.a()
  {
    public void a(int paramAnonymousInt, com.baidu.che.codriver.e.a paramAnonymousa, i.a paramAnonymousa1)
    {
      af.this.c.d();
      af.a(af.this, (com.baidu.che.codriver.sdk.b.a)paramAnonymousa);
    }
  };
  
  public af(com.baidu.che.codriver.vr.p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
    if ((this.g == null) || (!this.g.b()))
    {
      this.j = a.a;
      return;
    }
    if (!this.g.a())
    {
      this.j = a.b;
      return;
    }
    if (this.i == null)
    {
      this.j = a.d;
      return;
    }
    if ("listen".equals(e()))
    {
      this.j = a.e;
      return;
    }
    this.j = a.c;
  }
  
  private void a()
  {
    com.baidu.che.codriver.vr.p localp = this.b;
    localp.a("other");
    c.a().a(localp, this.c, this.d).h();
  }
  
  private void a(com.baidu.che.codriver.sdk.b.a parama)
  {
    this.j = a.e;
    this.c.a(m.c.b);
    this.b.b("listen");
    this.i = parama;
    c.a().b(this);
    parama = new b();
    parama.g = this.d.getString(2131298673);
    parama.j = 1;
    this.c.a(parama);
  }
  
  private void a(String paramString)
  {
    paramString = this.g.a(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      int m = f + 1;
      f = m;
      if (m >= 2)
      {
        f = 0;
        this.c.a(new i(this.d.getString(2131298394), 2));
        return;
      }
      this.c.a(new i(this.d.getString(2131298395), 1));
      return;
    }
    f = 0;
    this.e = paramString;
    if (paramString.size() == 1)
    {
      a((com.baidu.che.codriver.sdk.b.a)this.e.get(0));
      return;
    }
    c.a().b(this);
    paramString = new i(this.d.getString(2131298390), this.e, i.a.a, 1);
    paramString.a(this.k);
    this.c.a(paramString);
  }
  
  private void b()
  {
    b localb = new b();
    localb.g = this.d.getString(2131298670);
    localb.j = 2;
    this.c.a(localb, new m.a()
    {
      public void a()
      {
        af.a(af.this).c();
      }
    }, null);
  }
  
  private void r()
  {
    b localb = new b();
    localb.g = this.d.getString(2131298672);
    localb.j = 1;
    this.c.a(localb);
  }
  
  private void s()
  {
    b localb = new b();
    localb.g = this.d.getString(2131297358);
    localb.j = 2;
    this.c.a(localb, new m.a()
    {
      public void a()
      {
        af.this.q();
        af.a(af.this).a(af.b(af.this), af.c(af.this));
      }
    }, null);
    this.c.a(m.c.a);
  }
  
  public void a(View paramView)
  {
    this.j = a.f;
    super.a(paramView);
  }
  
  public void a(a parama)
  {
    if (this.j == a.e)
    {
      this.h = parama.f();
      a(null);
      parama = new b();
      parama.g = this.d.getString(2131298674, new Object[] { this.i.a() });
      parama.j = 1;
      this.c.a(parama);
    }
    do
    {
      do
      {
        return;
        if (this.j != a.f) {
          break;
        }
        if ("yes".equals(parama.e()))
        {
          s();
          return;
        }
      } while (!"no".equals(parama.e()));
      i();
      return;
    } while (!"select".equals(parama.e()));
    try
    {
      parama = new JSONObject(parama.g());
      a((com.baidu.che.codriver.sdk.b.a)this.e.get(a(parama.optString("option"), this.e.size())));
      return;
    }
    catch (JSONException parama)
    {
      parama = parama;
      parama = new b();
      parama.f = b.a.c;
      parama.i = 5;
      this.c.a(parama);
      return;
    }
    catch (IndexOutOfBoundsException parama)
    {
      parama = parama;
      this.c.a(new i(this.d.getString(2131298396), 1));
      return;
    }
    finally {}
  }
  
  public void h()
  {
    switch (4.a[this.j.ordinal()])
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      b();
      return;
    case 3: 
      a(this.i.a());
      return;
    }
    r();
  }
  
  protected void i()
  {
    this.c.p();
    a(this.i);
  }
  
  protected void j()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(g());
      if (!localJSONObject.isNull("wechat_name"))
      {
        this.i = new com.baidu.che.codriver.sdk.b.a(localJSONObject.optString("wechat_id", ""), localJSONObject.optString("wechat_name", ""));
        return;
      }
      this.i = null;
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */