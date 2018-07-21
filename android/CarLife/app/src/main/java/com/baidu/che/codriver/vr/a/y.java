package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.protocol.d;
import com.baidu.che.codriver.protocol.d.a;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.protocol.data.Place.Location;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.j;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.m.c;
import com.baidu.che.codriver.vr.p;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class y
  extends a
  implements d<Place>, s
{
  public static final String e = "RouteCommand";
  private static int j;
  private Place.Result f;
  private List<Place.Result> g;
  private String h;
  private Context i;
  private Handler k = new Handler(Looper.getMainLooper());
  
  public y(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
    this.i = paramContext;
  }
  
  private void a(List<Place.Result> paramList)
  {
    int m = 10;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((Place.Result)((Iterator)localObject).next()).location == null)
      {
        b();
        return;
      }
    }
    if ((paramList.size() > 0) && (paramList.size() == 1))
    {
      h.b("RouteCommand", "only on result: " + ((Place.Result)paramList.get(0)).toString());
      if ((this.c.s() == m.c.c) || (this.c.s() == m.c.d))
      {
        b((Place.Result)paramList.get(0));
        return;
      }
      c((Place.Result)paramList.get(0));
      return;
    }
    localObject = this.i.getResources();
    Iterator localIterator;
    if (paramList.size() > 10)
    {
      localObject = ((Resources)localObject).getString(2131298444, new Object[] { Integer.valueOf(m) });
      localIterator = paramList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label286;
      }
      Place.Result localResult = (Place.Result)localIterator.next();
      if (localResult.location == null)
      {
        b();
        return;
        m = paramList.size();
        break;
      }
      localResult.distance = (Math.round(LocationUtil.getInstance().calculateDistance(localResult.location.lat, localResult.location.lng) / 100.0D) / 10.0D);
    }
    label286:
    j = 0;
    c.a().b(this);
    h.b("RouteCommand", "more than one result");
    paramList = new j(paramList, this);
    paramList.g = ((String)localObject);
    paramList.j = 1;
    this.c.a(paramList);
  }
  
  private void b()
  {
    h.b("RouteCommand", "---定位结果为空---" + j);
    b localb = new b();
    if (j == 0)
    {
      localb.j = 1;
      localb.g = this.i.getResources().getString(2131298446);
    }
    for (localb.h = "nearby_command_no_poi_once";; localb.h = "nearby_command_no_poi_more")
    {
      localb.f = b.a.c;
      this.c.a(localb);
      j = 1;
      return;
      localb.g = this.i.getResources().getString(2131298445);
    }
  }
  
  private void b(Place.Result paramResult)
  {
    if ((paramResult != null) && (paramResult.location != null)) {
      this.f = paramResult;
    }
    this.k.postDelayed(new Runnable()
    {
      public void run()
      {
        y.a(y.this);
        NaviCmdController.getInstance().handleNaviAppAddress(y.this.b.g());
        c.a().a(8, y.this.c(), Boolean.valueOf(false));
        y.this.l();
        c.a().a(y.this);
        c.a().d();
        y.this.c.a(m.c.a);
        y.a(0);
        b localb = new b();
        localb.f = b.a.c;
        localb.j = 2;
        localb.g = y.b(y.this).getString(2131297734);
        y.this.c.a(localb);
      }
    }, 1000L);
  }
  
  private void c(Place.Result paramResult)
  {
    if ((paramResult != null) && (paramResult.location != null)) {
      this.f = paramResult;
    }
    this.k.postDelayed(new Runnable()
    {
      public void run()
      {
        y.this.l();
        c.a().d();
        y.a(0);
        b localb = new b();
        localb.j = 2;
        y.this.c.a(localb, new m.a()
        {
          public void a()
          {
            c.a().a(y.this);
          }
        }, null);
      }
    }, 1000L);
  }
  
  private void r()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("domain", "navigate_instruction");
        if (this.c.s() != m.c.d) {
          continue;
        }
        localJSONObject.put("intent", "set_work");
        localJSONObject.putOpt("data", a());
      }
      catch (JSONException localJSONException)
      {
        h.e("RouteCommand", "updateJsonResultForSetAddress error");
        localJSONException.printStackTrace();
        continue;
      }
      this.b.e(localJSONObject.toString());
      h.b("RouteCommand", "updateJsonResultForSetAddress result = " + localJSONObject.toString());
      return;
      if (this.c.s() == m.c.c) {
        localJSONObject.put("intent", "set_home");
      }
    }
  }
  
  protected JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("name", this.f.name);
      localJSONObject.putOpt("address", this.f.address);
      localJSONObject.putOpt("lat", new BigDecimal(this.f.location.lat * 100000.0D).toString());
      localJSONObject.putOpt("lng", new BigDecimal(this.f.location.lng * 100000.0D).toString());
      if (this.c.s() == m.c.d) {
        localJSONObject.putOpt("type", "office");
      }
      for (;;)
      {
        h.b("RouteCommand", "createParamJsonForSetAddress result = " + localJSONObject.toString());
        return localJSONObject;
        if (this.c.s() == m.c.c) {
          localJSONObject.putOpt("type", "home");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(d.a parama)
  {
    b();
  }
  
  public void a(Place.Result paramResult)
  {
    if ((this.c.s() == m.c.c) || (this.c.s() == m.c.d)) {
      b(paramResult);
    }
    for (;;)
    {
      this.c.d();
      h.b("RouteCommand", "onItemClick");
      return;
      c(paramResult);
    }
  }
  
  public void a(Place paramPlace)
  {
    if ((paramPlace == null) || (paramPlace.results == null) || (paramPlace.results.size() == 0))
    {
      b();
      return;
    }
    this.g = paramPlace.results;
    a(this.g);
  }
  
  public void a(a parama)
  {
    com.baidu.che.codriver.util.c.a(this.i, "10021", "进入多轮");
    if ((parama == null) || (!"codriver".equals(parama.d())) || (!"select".equals(parama.e())))
    {
      h.b("RouteCommand", "merge error");
      this.c.a(null);
      return;
    }
    int m;
    try
    {
      m = a(new JSONObject(parama.g()).optString("option"), this.g.size());
      h.b("RouteCommand", "selectIndex:" + m);
      if ((this.g == null) || (m >= this.g.size()) || (m < 0))
      {
        parama = new b();
        parama.f = b.a.c;
        parama.j = 1;
        parama.g = this.i.getString(2131298396);
        parama.h = "tts_record_say_right_index";
        this.c.a(parama);
        return;
      }
    }
    catch (JSONException parama)
    {
      parama = new b();
      parama.f = b.a.c;
      parama.i = 5;
      this.c.a(parama);
      return;
    }
    com.baidu.che.codriver.util.c.a(this.i, "10021", "澄清成功");
    if ((this.c.s() == m.c.c) || (this.c.s() == m.c.d))
    {
      b((Place.Result)this.g.get(m));
      return;
    }
    c((Place.Result)this.g.get(m));
  }
  
  public void h()
  {
    h.b("RouteCommand", "---excute：-----00");
    com.baidu.che.codriver.util.c.a(this.i, "10005");
    if (this.f != null)
    {
      h.b("RouteCommand", "---excute：-----01");
      localb = new b();
      localb.g = this.i.getString(2131297358);
      localb.j = 2;
      this.c.a(localb);
      return;
    }
    if ((this.g != null) && (this.g.size() > 0))
    {
      a(this.g);
      return;
    }
    h.b("RouteCommand", "---excute：-----02");
    if (LocationUtil.getInstance().isReady())
    {
      new com.baidu.che.codriver.protocol.a.c(this, Place.class, this.h, true).d();
      return;
    }
    b localb = new b();
    localb.i = 21;
    localb.f = b.a.c;
    this.c.a(localb);
  }
  
  protected void i() {}
  
  protected void j()
  {
    if (this.b == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(g());
        h.b("RouteCommand", localJSONObject.toString());
        if ("poi".equals(e()))
        {
          this.h = localJSONObject.optString("centre", f());
          String str = localJSONObject.optString("poi");
          if (!TextUtils.isEmpty(str)) {
            this.g = Arrays.asList((Place.Result[])new Gson().fromJson(str, Place.Result[].class));
          }
          h.b("RouteCommand", "parseParam: " + localJSONObject.toString());
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      if ("route".equals(e())) {
        this.h = localJSONException.optString("arrival");
      }
    }
  }
  
  protected JSONObject k()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("lat", new BigDecimal(this.f.location.lat * 100000.0D).toString());
      localJSONObject.putOpt("lng", new BigDecimal(this.f.location.lng * 100000.0D).toString());
      localJSONObject.putOpt("poiName", this.f.name);
      localJSONObject.putOpt("poiRegion", this.f.address);
      h.b("RouteCommand", "createParamJson result = " + localJSONObject.toString());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */