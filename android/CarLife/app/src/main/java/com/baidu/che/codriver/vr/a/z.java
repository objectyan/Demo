package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.sdk.a.k;
import com.baidu.che.codriver.sdk.a.k.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.p;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import org.json.JSONException;
import org.json.JSONObject;

public class z
  extends a
{
  private static final String e = "__";
  private String f;
  private k.b g;
  
  public z(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
    c.a(this.d, "10011");
    this.g = k.a().b();
  }
  
  public void a(a parama) {}
  
  public void h()
  {
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    if (("app".equals(d())) && (("导航".equals(this.f)) || ("地图".equals(this.f))))
    {
      if ("open".equals(e()))
      {
        localb.j = 2;
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            PlatformManager.getInstance().sendNaviCommand("key_navi_start_app", Boolean.valueOf(true));
          }
        }, null);
        return;
      }
      if ("close".equals(e()))
      {
        localb.j = 1;
        if (BNavigator.getInstance().isNaviBegin()) {}
        for (String str = this.d.getString(2131297729);; str = this.d.getString(2131297740))
        {
          localb.g = str;
          this.c.a(localb, new m.a()
          {
            public void a()
            {
              PlatformManager.getInstance().sendNaviCommand("key_navi_exit_app", Boolean.valueOf(false));
            }
          }, null);
          return;
        }
      }
    }
    final boolean bool = com.baidu.che.codriver.ui.b.b.b().q();
    if (this.g != null)
    {
      localb.j = 2;
      this.c.a(localb, new m.a()
      {
        public void a()
        {
          boolean bool2 = true;
          boolean bool3 = true;
          boolean bool1 = true;
          Object localObject = z.this.e();
          int i = -1;
          switch (((String)localObject).hashCode())
          {
          default: 
            switch (i)
            {
            }
            break;
          }
          do
          {
            return;
            if (!((String)localObject).equals("view")) {
              break;
            }
            i = 0;
            break;
            if (!((String)localObject).equals("operate")) {
              break;
            }
            i = 1;
            break;
            if (!((String)localObject).equals("back_home")) {
              break;
            }
            i = 2;
            break;
            if (!((String)localObject).equals("open")) {
              break;
            }
            i = 3;
            break;
            if (!((String)localObject).equals("close")) {
              break;
            }
            i = 4;
            break;
            if (!((String)localObject).equals("set_ac")) {
              break;
            }
            i = 5;
            break;
            if (!((String)localObject).equals("heat")) {
              break;
            }
            i = 6;
            break;
            if (!((String)localObject).equals("light_down_min")) {
              break;
            }
            i = 7;
            break;
            if (!((String)localObject).equals("light_up_max")) {
              break;
            }
            i = 8;
            break;
            if (!((String)localObject).equals("light_down")) {
              break;
            }
            i = 9;
            break;
            if (!((String)localObject).equals("light_up")) {
              break;
            }
            i = 10;
            break;
            if (!((String)localObject).equals("volume_up_max")) {
              break;
            }
            i = 11;
            break;
            if (!((String)localObject).equals("volume_down_min")) {
              break;
            }
            i = 12;
            break;
            if (!((String)localObject).equals("volume_down")) {
              break;
            }
            i = 13;
            break;
            if (!((String)localObject).equals("volume_up")) {
              break;
            }
            i = 14;
            break;
            localObject = z.a(z.this);
            if (!bool) {}
            for (;;)
            {
              ((k.b)localObject).a("telephone", bool1);
              return;
              bool1 = false;
            }
            z.a(z.this).f(z.b(z.this));
            return;
            localObject = z.a(z.this);
            if (!bool) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((k.b)localObject).a("home", bool1);
              return;
            }
            localObject = z.a(z.this);
            String str = z.b(z.this);
            if (!bool) {}
            for (bool1 = bool3;; bool1 = false)
            {
              ((k.b)localObject).a(str, bool1);
              return;
            }
            z.a(z.this).a(z.b(z.this));
            return;
            try
            {
              localObject = new JSONObject(z.this.g());
              if (((JSONObject)localObject).has("wind_flow"))
              {
                z.a(z.this).f("wind_flow__" + z.b(z.this));
                return;
              }
            }
            catch (Exception localException)
            {
              h.e("CoDriverVoice", "parse system command params error");
              return;
            }
            if (localException.has("wind_direction"))
            {
              z.a(z.this).f("wind_direction__" + z.b(z.this));
              return;
            }
          } while (!localException.has("temp"));
          z.a(z.this).f("temp__" + z.b(z.this));
          return;
          z.a(z.this).f("heat_temp__" + z.b(z.this));
          return;
          z.a(z.this).e("light");
          return;
          z.a(z.this).d("light");
          return;
          z.a(z.this).c("light");
          return;
          z.a(z.this).b("light");
          return;
          z.a(z.this).d("volume");
          return;
          z.a(z.this).e("volume");
          return;
          z.a(z.this).c("volume");
          return;
          z.a(z.this).b("volume");
        }
      }, null);
      return;
    }
    localb.f = b.a.c;
    localb.g = this.d.getString(2131296727);
    localb.j = 1;
    this.c.a(localb);
  }
  
  protected void i() {}
  
  protected void j()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(g());
      this.f = localJSONObject.optString("function", "");
      this.f += localJSONObject.optString("appname", "");
      this.f += localJSONObject.optString("item", "");
      this.f += localJSONObject.optString("wind_flow", "");
      this.f += localJSONObject.optString("wind_direction", "");
      this.f += localJSONObject.optString("temp", "");
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */