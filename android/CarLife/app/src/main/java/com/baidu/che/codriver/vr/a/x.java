package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.logic.a.j;
import com.baidu.che.codriver.sdk.a.c;
import com.baidu.che.codriver.sdk.a.n;
import com.baidu.che.codriver.sdk.a.n.a;
import com.baidu.che.codriver.sdk.a.n.b;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class x
  extends a
  implements n.a
{
  private String e;
  private String f;
  private String g;
  private List<String> h;
  private n i = c.a().c();
  
  public x(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  public void a()
  {
    b localb = new b();
    if (TextUtils.isEmpty(this.g)) {}
    for (localb.g = this.d.getString(2131297358);; localb.g = (this.d.getString(2131297663) + "《" + this.g + "》"))
    {
      localb.j = 2;
      this.c.a(localb, new m.a()
      {
        public void a()
        {
          if (x.a(x.this) != null) {
            x.a(x.this).a();
          }
        }
      }, null);
      return;
    }
  }
  
  public void b()
  {
    b localb = new b();
    localb.g = this.d.getString(2131297357);
    localb.j = 1;
    this.c.a(localb, new m.a()
    {
      public void a() {}
    }, null);
  }
  
  public void h()
  {
    if (this.i != null)
    {
      n.b localb = new n.b(this.e, this.f, this.g, this.h, this.b.h());
      j.a().a(this.b.b());
      this.i.a(localb, this);
    }
  }
  
  protected void j()
  {
    try
    {
      Object localObject = new JSONObject(g());
      this.e = ((JSONObject)localObject).optString("type");
      this.f = ((JSONObject)localObject).optString("person");
      this.g = ((JSONObject)localObject).optString("program_name");
      if (((JSONObject)localObject).has("keywords"))
      {
        localObject = ((JSONObject)localObject).optJSONArray("keywords");
        this.h = new ArrayList();
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          this.h.add(((JSONArray)localObject).getString(j));
          j += 1;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */