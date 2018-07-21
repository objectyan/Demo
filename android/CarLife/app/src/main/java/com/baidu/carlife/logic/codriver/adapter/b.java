package com.baidu.carlife.logic.codriver.adapter;

import android.content.Context;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.v;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.sdk.a.a.b;
import com.baidu.che.codriver.sdk.a.b.a;
import com.baidu.che.codriver.sdk.a.f;
import com.baidu.che.codriver.sdk.a.f.a;
import com.baidu.che.codriver.sdk.a.g;
import com.baidu.che.codriver.sdk.a.g.a;
import com.baidu.che.codriver.sdk.a.h.b;
import com.baidu.che.codriver.sdk.a.i;
import com.baidu.che.codriver.sdk.a.i.b;
import com.baidu.che.codriver.sdk.a.j;
import com.baidu.che.codriver.sdk.a.j.a;
import com.baidu.che.codriver.sdk.a.k.b;
import com.baidu.che.codriver.sdk.a.m;
import com.baidu.che.codriver.sdk.a.n;
import com.baidu.che.codriver.sdk.a.p;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.m.c;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.NaviToolImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static b a;
  private static final String c = b.class.getSimpleName();
  private Context b;
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext;
    LocationUtil.getInstance().setCoordinateSystem("bd09ll");
    PlatformManager.getInstance().init(this.b);
    com.baidu.che.codriver.e.b.a().a(this.b);
    com.baidu.carlife.o.b.a().a(this.b);
    com.baidu.che.codriver.sdk.a.b.a().a(b.a.a);
    a(new i.b()
    {
      public void a(String paramAnonymousString)
      {
        com.baidu.che.codriver.util.h.b(b.d(), "-----dialNum-num:" + paramAnonymousString);
        q.f().a(b.a(b.this), paramAnonymousString);
        StatisticManager.onEvent("VOICE_0007");
      }
    });
    paramContext = new com.baidu.carlife.logic.music.k();
    a(new NaviToolImpl());
    a(new com.baidu.carlife.wechat.f.c());
    a(paramContext);
    a(new com.baidu.carlife.logic.a.h());
    a(paramContext);
    a(new v());
  }
  
  public void a(a.b paramb)
  {
    com.baidu.che.codriver.sdk.a.a.a().a(paramb);
  }
  
  public void a(f.a parama)
  {
    f.a().b(parama);
  }
  
  public void a(h.b paramb)
  {
    com.baidu.che.codriver.sdk.a.h.a().a(paramb);
  }
  
  public void a(i.b paramb)
  {
    i.b().a(paramb);
  }
  
  public void a(j.a parama)
  {
    j.a().a(parama);
  }
  
  public void a(k.b paramb)
  {
    com.baidu.che.codriver.sdk.a.k.a().a(paramb);
  }
  
  public void a(m paramm)
  {
    com.baidu.che.codriver.sdk.a.c.a().a(paramm);
  }
  
  public void a(n paramn)
  {
    com.baidu.che.codriver.sdk.a.c.a().a(paramn);
  }
  
  public void a(p paramp)
  {
    com.baidu.che.codriver.sdk.a.c.a().a(paramp);
  }
  
  public void a(com.baidu.che.codriver.sdk.b.a parama)
  {
    com.baidu.che.codriver.ui.b.b.b().a(parama);
  }
  
  public void a(m.c paramc)
  {
    com.baidu.che.codriver.ui.b.b.b().b(paramc);
  }
  
  public void a(String paramString)
  {
    NaviCmdController.getInstance().handleNaviAppAddress(paramString);
  }
  
  public void a(String paramString, g.a parama)
  {
    g.a().a(paramString, parama);
  }
  
  public void b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("domain", "navigate_instruction");
      localJSONObject1.put("intent", "set_work");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("name", "");
      localJSONObject2.put("address", "");
      localJSONObject2.put("type", "office");
      localJSONObject1.put("data", localJSONObject2);
      a(localJSONObject1.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void b(a.b paramb)
  {
    com.baidu.che.codriver.sdk.a.a.a().b(paramb);
  }
  
  public void c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("domain", "navigate_instruction");
      localJSONObject1.put("intent", "set_home");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("name", "");
      localJSONObject2.put("address", "");
      localJSONObject2.put("type", "home");
      localJSONObject1.put("data", localJSONObject2);
      a(localJSONObject1.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/codriver/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */