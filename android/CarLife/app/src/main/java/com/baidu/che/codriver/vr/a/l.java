package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.f.a.a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.g;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.p;
import com.google.gson.Gson;

public class l
  extends a
{
  public static final String e = "NLPCommand";
  private NLPResponseData f;
  
  public l(NLPResponseData paramNLPResponseData, m paramm, Context paramContext)
  {
    super(null, paramm, paramContext);
    this.f = paramNLPResponseData;
  }
  
  public l(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  private void a(NLPResponseData paramNLPResponseData)
  {
    paramNLPResponseData = g.b(paramNLPResponseData);
    if ((paramNLPResponseData.f == b.a.g) || (paramNLPResponseData.f == b.a.a)) {
      c.a().b(this);
    }
    this.c.a(paramNLPResponseData);
  }
  
  public void a(a parama)
  {
    if (b(parama))
    {
      parama = new b();
      parama.j = 1;
      parama.g = this.d.getString(2131298392);
      this.c.a(parama);
    }
  }
  
  public void h()
  {
    if (this.f != null)
    {
      a(this.f);
      return;
    }
    h.b("NLPCommand", "NlpCommand excute mNlpResponseData is null");
    new com.baidu.che.codriver.f.a(new a.a()
    {
      public void a(String paramAnonymousString)
      {
        paramAnonymousString = new b();
        paramAnonymousString.i = 5;
        l.this.c.a(paramAnonymousString);
      }
      
      public void b(String paramAnonymousString)
      {
        paramAnonymousString = (NLPResponseData)new Gson().fromJson(paramAnonymousString, NLPResponseData.class);
        l.a(l.this, paramAnonymousString);
      }
    }).a(this.b.e());
  }
  
  protected void j() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */