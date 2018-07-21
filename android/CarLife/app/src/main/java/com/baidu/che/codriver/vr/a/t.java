package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.sdk.a.h.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.p;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends a
{
  private static final String e = "OperatorCommand";
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private NLPResponseData k = null;
  private h.b l;
  
  public t(NLPResponseData paramNLPResponseData, m paramm, Context paramContext)
  {
    super(null, paramm, paramContext);
    this.k = paramNLPResponseData;
    this.l = com.baidu.che.codriver.sdk.a.h.a().b();
  }
  
  public t(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
    this.l = com.baidu.che.codriver.sdk.a.h.a().b();
  }
  
  private void a(String paramString)
  {
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    localb.j = 1;
    localb.g = paramString;
    localb.f = b.a.c;
    this.c.a(localb);
  }
  
  public void a(a parama)
  {
    com.baidu.che.codriver.util.h.b("OperatorCommand", "OperatorCommand ------merge()------------");
  }
  
  public void h()
  {
    com.baidu.che.codriver.util.h.b("OperatorCommand", "OperatorCommand ------excute()------------");
    if (this.l == null)
    {
      a(this.d.getString(2131297207));
      return;
    }
    c.a().d();
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    localb.j = 2;
    localb.g = "";
    String str;
    if (this.k != null) {
      str = this.k.rawText;
    }
    while (com.baidu.che.codriver.ui.b.b.b().q())
    {
      a(this.d.getString(2131297207));
      return;
      if (this.b != null) {
        str = this.b.e();
      } else {
        str = null;
      }
    }
    if (("download".equals(e())) || ("sync".equals(e())) || ("login".equals(e())))
    {
      if (this.l.a(str, e()))
      {
        this.c.a(localb, null, null);
        return;
      }
      a(this.d.getString(2131297207));
      return;
    }
    if (this.l.a(str, this.j))
    {
      this.c.a(localb, new m.a()
      {
        public void a() {}
      }, null);
      return;
    }
    a(this.d.getString(2131297207));
  }
  
  protected void i() {}
  
  protected void j()
  {
    try
    {
      this.j = new JSONObject(g()).optString("item");
      com.baidu.che.codriver.util.h.b("CoDriverVoice", "Goto Cmd Item: " + this.j);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  protected JSONObject k()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */