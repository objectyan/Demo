package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.protocol.data.Place.Location;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.g;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.c;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ac
  extends a
{
  public static final String e = "NearbyCommand";
  private static int m;
  private String f;
  private String g;
  private String h;
  private String i;
  private Context j;
  private List<Place.Result> k;
  private NLPResponseData l;
  
  public ac(NLPResponseData paramNLPResponseData, m paramm, Context paramContext)
  {
    super(null, paramm, paramContext);
    this.l = paramNLPResponseData;
    this.j = paramContext;
    j();
  }
  
  private void a()
  {
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---结果为空或者无法解析---");
    b localb = new b();
    if (m == 0)
    {
      localb.g = this.j.getResources().getString(2131298446);
      localb.j = 1;
      this.c.a(localb);
    }
    for (;;)
    {
      m = 1;
      return;
      localb.g = this.j.getResources().getString(2131298445);
      this.c.a(localb);
      this.c.a(m.c.a);
    }
  }
  
  private void a(Place.Result paramResult)
  {
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---sendCommand---" + paramResult.toString());
    this.f = new BigDecimal(paramResult.location.lat * 100000.0D).toString();
    this.g = new BigDecimal(paramResult.location.lng * 100000.0D).toString();
    this.h = paramResult.name;
    this.i = paramResult.address;
    b localb = new b();
    localb.j = 2;
    this.c.a(localb);
    boolean bool = c.a().a("map", "route", new Pair[] { new Pair("lat", this.f), new Pair("lng", this.g), new Pair("poiName", paramResult.name), new Pair("poiRegion", paramResult.address) });
    com.baidu.che.codriver.util.h.b("NearbyCommand", "handle: " + bool);
    c.a().d();
    m = 0;
  }
  
  private void a(List<Place.Result> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((Place.Result)((Iterator)localObject).next()).location == null)
      {
        a();
        return;
      }
    }
    if (paramList.size() > 3) {}
    for (localObject = this.j.getResources().getString(2131298624, new Object[] { Integer.valueOf(paramList.size()) });; localObject = this.j.getResources().getString(2131298625))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Place.Result localResult = (Place.Result)localIterator.next();
        localResult.distance = (Math.round(LocationUtil.getInstance().calculateDistance(localResult.location.lat, localResult.location.lng) / 100.0D) / 10.0D);
      }
    }
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---存在多个相关地点，再次发起语音识别------");
    c.a().b(this);
    paramList = new com.baidu.che.codriver.ui.d.h(paramList);
    paramList.g = ((String)localObject);
    paramList.j = 1;
    this.c.a(paramList);
    m = 0;
  }
  
  public void a(a parama)
  {
    if ((parama == null) || (!b(parama)))
    {
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---不是导航多轮命令，提示用户选择------");
      this.c.a(new b());
      return;
    }
    int n;
    try
    {
      parama = new JSONObject(parama.g());
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---多轮命令---" + parama.toString());
      n = a(parama.optString("option"), this.k.size());
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---多轮命令---selectIndex:" + n);
      if ((n >= this.k.size()) || (n < 0))
      {
        parama = new b();
        parama.f = b.a.c;
        parama.j = 1;
        parama.g = this.j.getString(2131298396);
        this.c.a(parama);
        return;
      }
    }
    catch (JSONException parama)
    {
      parama = new b();
      parama.j = 2;
      parama.g = this.j.getString(2131297239);
      this.c.a(parama);
      return;
    }
    a((Place.Result)this.k.get(n));
  }
  
  public void h()
  {
    com.baidu.che.codriver.util.h.b("NearbyCommand", "---excute：-----1");
    b localb;
    if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)))
    {
      com.baidu.che.codriver.util.h.b("NearbyCommand", "---excute：-----2");
      localb = new b();
      localb.g = this.j.getString(2131297358);
      localb.j = 2;
      this.c.a(localb);
      c.a().a("map", "route", new Pair[] { new Pair("lat", this.f), new Pair("lng", this.g), new Pair("poiName", this.h), new Pair("poiRegion", this.i) });
      return;
    }
    if ((this.k != null) && (this.k.size() > 0))
    {
      a(this.k);
      return;
    }
    if (!LocationUtil.getInstance().isReady())
    {
      localb = new b();
      localb.g = this.j.getString(2131298626);
      this.c.a(localb);
      return;
    }
    a();
  }
  
  protected void i() {}
  
  protected void j()
  {
    if (this.l == null) {
      return;
    }
    NLPResponseData.Result localResult = g.a(this.l);
    try
    {
      Type localType = new TypeToken() {}.getType();
      this.k = ((Place)new Gson().fromJson(localResult.data, localType)).list;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected JSONObject k()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */