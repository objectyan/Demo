package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.e;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.p;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
  implements e
{
  public static final String a = "CoDriverVoice";
  protected p b = null;
  protected m c;
  protected Context d;
  
  public a(p paramp, m paramm, Context paramContext)
  {
    this.b = paramp;
    this.c = paramm;
    this.d = paramContext;
    j();
  }
  
  protected static int a(String paramString, int paramInt)
  {
    int i = -1;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return i;
      try
      {
        int j = Integer.parseInt(paramString);
        if (j > 0) {
          return j - 1;
        }
        i = j;
        if (j != 0) {
          return j + paramInt;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return -1;
  }
  
  public static boolean b(a parama)
  {
    return (parama != null) && ("codriver".equals(parama.d())) && ("select".equals(parama.e()));
  }
  
  public void a(View paramView)
  {
    this.c.a(paramView);
    c.a().d(this);
  }
  
  public void a(a parama) {}
  
  public String c()
  {
    if (this.b != null) {
      return this.b.g();
    }
    return null;
  }
  
  public String d()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.b();
  }
  
  public String e()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.c();
  }
  
  public String f()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.e();
  }
  
  public String g()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.d();
  }
  
  public abstract void h();
  
  protected void i()
  {
    b localb = new b();
    localb.g = this.d.getString(2131297356);
    this.c.a(localb);
    q();
  }
  
  protected abstract void j();
  
  protected JSONObject k()
  {
    return null;
  }
  
  protected void l()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("domain", d());
      localJSONObject1.put("intent", e());
      JSONObject localJSONObject2 = k();
      localJSONObject1.putOpt("object", localJSONObject2);
      if (localJSONObject2 != null) {
        this.b.c(localJSONObject2.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.e("CoDriverVoice", "---createJsonResult--ERROR---");
        localJSONException.printStackTrace();
      }
    }
    this.b.e(localJSONObject1.toString());
    h.b("CoDriverVoice", "------updateJsonResult:" + localJSONObject1.toString());
  }
  
  public String m()
  {
    if (this.b != null) {
      return this.b.h();
    }
    return null;
  }
  
  public boolean n()
  {
    return ("codriver".equals(d())) && ("back".equals(e()));
  }
  
  public boolean o()
  {
    return ("codriver".equals(d())) && ("next".equals(e()));
  }
  
  public boolean p()
  {
    return c.a().f();
  }
  
  public void q()
  {
    this.c.p();
    c.a().g();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */