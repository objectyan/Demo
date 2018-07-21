package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.che.codriver.protocol.d;
import com.baidu.che.codriver.protocol.d.a;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.protocol.data.Place.Location;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.c;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  extends a
  implements d<Place>
{
  public static final String e = "NearbyCommand";
  private static int n;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private Context l;
  private List<Place.Result> m;
  private Handler o = new Handler(Looper.getMainLooper());
  
  public p(com.baidu.che.codriver.vr.p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
    this.l = paramContext;
  }
  
  private void a()
  {
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---结果为空或者无法解析---");
    b localb = new b();
    if (n == 0)
    {
      localb.j = 1;
      localb.g = this.l.getResources().getString(2131297756);
    }
    for (localb.h = "nearby_command_no_poi_once";; localb.h = "nearby_command_no_poi_more")
    {
      localb.f = b.a.c;
      this.c.a(localb);
      n = 1;
      return;
      localb.g = this.l.getResources().getString(2131297755);
    }
  }
  
  private void a(Place.Result paramResult)
  {
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---sendCommand---" + paramResult.toString());
    this.h = new BigDecimal(paramResult.location.lat * 100000.0D).toString();
    this.i = new BigDecimal(paramResult.location.lng * 100000.0D).toString();
    this.j = paramResult.name;
    this.k = paramResult.address;
    b localb = new b();
    localb.j = 2;
    this.c.a(localb);
    boolean bool = c.a().a("map", "route", new Pair[] { new Pair("lat", this.h), new Pair("lng", this.i), new Pair("poiName", paramResult.name), new Pair("poiRegion", paramResult.address) });
    com.baidu.che.codriver.util.h.b("NearbyCommand", "handle: " + bool);
    c.a().d();
    n = 0;
  }
  
  private void a(List<Place.Result> paramList)
  {
    if (paramList.size() == 1)
    {
      a((Place.Result)paramList.get(0));
      return;
    }
    String str = this.l.getResources().getString(2131297757, new Object[] { Integer.valueOf(Math.min(paramList.size(), 10)) });
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---存在多个相关地点，再次发起语音识别------");
    c.a().b(this);
    paramList = new com.baidu.che.codriver.ui.d.h(paramList);
    paramList.g = str;
    paramList.j = 1;
    this.c.a(paramList);
    n = 0;
  }
  
  public void a(d.a parama)
  {
    a();
  }
  
  public void a(Place paramPlace)
  {
    com.baidu.che.codriver.util.h.b("NearbyCommand", "--------请求成功-------" + paramPlace.toString());
    if ((paramPlace == null) || (paramPlace.results == null) || (paramPlace.results.size() == 0))
    {
      a();
      return;
    }
    Iterator localIterator = paramPlace.results.iterator();
    while (localIterator.hasNext()) {
      if (((Place.Result)localIterator.next()).location == null)
      {
        a();
        return;
      }
    }
    this.m = paramPlace.results;
    a(this.m);
  }
  
  public void a(a parama)
  {
    com.baidu.che.codriver.util.c.a(this.l, "10008", "进入多轮");
    if ((parama == null) || (!b(parama)))
    {
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---不是导航多轮命令，提示用户选择------");
      this.c.a(null);
      return;
    }
    int i1;
    try
    {
      parama = new JSONObject(parama.g());
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---多轮命令---" + parama.toString());
      i1 = a(parama.optString("option"), this.m.size());
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---多轮命令---selectIndex:" + i1);
      if ((this.m == null) || (i1 >= this.m.size()) || (i1 < 0))
      {
        parama = new b();
        parama.f = b.a.c;
        parama.j = 1;
        parama.g = this.l.getString(2131298396);
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
    a((Place.Result)this.m.get(i1));
    com.baidu.che.codriver.util.c.a(this.l, "10008", "澄清成功");
  }
  
  public void h()
  {
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---excute：-----1");
    if (this.c.s() == m.c.e)
    {
      com.baidu.che.codriver.util.h.b("NearbyCommand", "UICallBack.State.STATE_WHERE_GOING");
      com.baidu.che.codriver.util.c.a(this.l, "NAVI_0032", "NAVI_0032");
    }
    b localb;
    if ((!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.i)))
    {
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---excute：-----2");
      localb = new b();
      localb.g = this.l.getString(2131297358);
      localb.j = 2;
      this.c.a(localb);
      c.a().a("map", "route", new Pair[] { new Pair("lat", this.h), new Pair("lng", this.i), new Pair("poiName", this.j), new Pair("poiRegion", this.k) });
    }
    for (;;)
    {
      com.baidu.che.codriver.util.c.a(this.l, "10006");
      return;
      if ((this.m != null) && (this.m.size() > 0))
      {
        a(this.m);
      }
      else
      {
        com.baidu.che.codriver.util.h.b("NearbyCommand", "---excute：-----3");
        if (LocationUtil.getInstance().isReady())
        {
          new com.baidu.che.codriver.protocol.a.c(this, Place.class, this.f, this.g).d();
        }
        else
        {
          localb = new b();
          localb.i = 21;
          localb.f = b.a.c;
          this.c.a(localb);
        }
      }
    }
  }
  
  protected void i() {}
  
  protected void j()
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(this.b.d());
        this.f = ((JSONObject)localObject).optString("keywords");
        this.g = ((JSONObject)localObject).optString("centre");
        com.baidu.che.codriver.util.h.b("NearbyCommand", "---语音指令：-----" + ((JSONObject)localObject).toString());
        localObject = ((JSONObject)localObject).optString("poi");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.m = Arrays.asList((Place.Result[])new Gson().fromJson((String)localObject, Place.Result[].class));
        }
        if (!TextUtils.isEmpty(this.f)) {
          continue;
        }
        this.f = "餐馆";
        return;
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
  
  protected JSONObject k()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */