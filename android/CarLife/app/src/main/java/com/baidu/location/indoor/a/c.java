package com.baidu.location.indoor.a;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.f;
import com.baidu.location.h.e;
import com.indooratlas.android.sdk.IAExtraInfo;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IARegion;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private final b a;
  private final b b = new b(this, f.getServiceContext().getMainLooper());
  private String c;
  private String d = null;
  private String e;
  private IALocationManager f;
  private boolean g = true;
  private Boolean h = null;
  private boolean i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private HashMap<String, String> o;
  private HashMap<String, String> p;
  private HashMap<String, String> q;
  private final d r;
  private final a s;
  private final Queue<BDLocation> t;
  private final Queue<BDLocation> u;
  
  c(b paramb)
  {
    this.a = paramb;
    this.c = null;
    this.e = null;
    this.i = false;
    this.j = new String();
    this.k = new String();
    this.l = new String();
    this.m = new String();
    this.o = new HashMap();
    this.p = new HashMap();
    this.q = new HashMap();
    this.r = new d(this);
    this.s = new a();
    paramb = new Comparator()
    {
      public int a(BDLocation paramAnonymousBDLocation1, BDLocation paramAnonymousBDLocation2)
      {
        return paramAnonymousBDLocation2.getTime().compareTo(paramAnonymousBDLocation1.getTime());
      }
    };
    this.t = new PriorityQueue(5, paramb);
    this.u = new PriorityQueue(5, paramb);
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d2 = Math.toRadians(paramDouble1);
    Math.toRadians(paramDouble2);
    double d1 = Math.toRadians(paramDouble3);
    Math.toRadians(paramDouble4);
    paramDouble2 = Math.toRadians(paramDouble4 - paramDouble2);
    paramDouble3 = Math.toRadians(paramDouble3 - paramDouble1);
    paramDouble1 = Math.sin(paramDouble3 / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    paramDouble4 = Math.cos(d2);
    d1 = Math.cos(d1);
    d2 = Math.sin(paramDouble2 / 2.0D);
    paramDouble1 = Math.sin(paramDouble2 / 2.0D) * (paramDouble4 * d1 * d2) + paramDouble3 * paramDouble1;
    return Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)) * 2.0D * 6378137.0D;
  }
  
  private void h()
  {
    int i2 = 1;
    if (this.h == null)
    {
      this.s.a(this.c);
      i1 = i2;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        this.a.a((BDLocation)this.t.peek());
        return;
        i1 = i2;
        if (this.h.booleanValue()) {
          if (this.i)
          {
            i1 = i2;
            if (this.u.isEmpty()) {
              continue;
            }
            BDLocation localBDLocation1 = (BDLocation)this.t.peek();
            BDLocation localBDLocation2 = (BDLocation)this.u.peek();
            Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            try
            {
              Date localDate = ((SimpleDateFormat)localObject).parse(localBDLocation1.getTime());
              localObject = ((SimpleDateFormat)localObject).parse(localBDLocation2.getTime());
              l1 = localDate.getTime();
              long l2 = ((Date)localObject).getTime();
              l1 -= l2;
            }
            catch (ParseException localParseException)
            {
              for (;;)
              {
                long l1 = 5000L;
              }
            }
            if ((l1 >= 5000L) || (a(localBDLocation1.getLatitude(), localBDLocation1.getLongitude(), localBDLocation2.getLatitude(), localBDLocation2.getLongitude()) >= 35.0D)) {
              break label270;
            }
          }
        }
      }
    }
    label270:
    for (int i1 = 0;; i1 = 1)
    {
      break;
      i1 = i2;
      if (!this.q.containsKey(this.e)) {
        break;
      }
      i1 = i2;
      if (!this.g) {
        break;
      }
      i();
      i1 = i2;
      break;
      this.a.a((BDLocation)this.u.peek());
      return;
    }
  }
  
  private void i()
  {
    this.n = ((String)this.q.get(this.e));
    if (this.p.containsKey(this.e))
    {
      this.m = ((String)this.p.get(this.e));
      if (!this.o.containsKey(this.e)) {
        break label201;
      }
    }
    for (this.l = ((String)this.o.get(this.e));; this.l = new String())
    {
      try
      {
        Object localObject;
        if (this.f == null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("com.indooratlas.android.sdk.intent.extras.apiKey", this.j);
          ((Bundle)localObject).putString("com.indooratlas.android.sdk.intent.extras.apiSecret", this.k);
          this.f = IALocationManager.create(f.getServiceContext(), (Bundle)localObject);
        }
        if (this.f != null)
        {
          this.f.requestLocationUpdates(IALocationRequest.create(), this.r);
          localObject = IALocation.from(IARegion.venue(this.l));
          this.f.setLocation((IALocation)localObject);
          this.f.registerRegionListener(this.r);
          this.i = true;
        }
        return;
      }
      catch (Exception localException)
      {
        label201:
        this.i = false;
      }
      this.m = new String();
      break;
    }
  }
  
  void a()
  {
    this.g = false;
    e();
  }
  
  void a(BDLocation paramBDLocation)
  {
    if (paramBDLocation == null) {
      return;
    }
    if ((this.f != null) && (this.f.getExtraInfo() != null)) {
      String str = this.f.getExtraInfo().traceId;
    }
    this.u.add(paramBDLocation);
    h();
  }
  
  public BDLocation b()
  {
    return (BDLocation)this.u.peek();
  }
  
  void b(BDLocation paramBDLocation)
  {
    if (paramBDLocation == null) {
      return;
    }
    this.t.add(paramBDLocation);
    if ((this.c == null) || ((paramBDLocation.getBuildingID() != null) && (!this.c.equals(paramBDLocation.getBuildingID()))))
    {
      this.c = paramBDLocation.getBuildingID();
      this.d = paramBDLocation.getBuildingName();
      this.e = null;
      if (this.i) {
        e();
      }
      this.h = null;
    }
    if ((this.e == null) || ((paramBDLocation.getFloor() != null) && (!this.e.equals(paramBDLocation.getFloor())))) {
      this.e = paramBDLocation.getFloor();
    }
    h();
  }
  
  void c()
  {
    if ((!this.i) && (this.h != null) && (this.h.booleanValue()) && (this.e != null) && (this.q.containsKey(this.e)) && (this.g)) {
      i();
    }
  }
  
  void d()
  {
    if ((this.f != null) && (this.i))
    {
      this.u.clear();
      this.f.removeLocationUpdates(this.r);
      this.f.unregisterRegionListener(this.r);
      this.f.destroy();
      this.f = null;
      this.i = false;
      this.h = null;
    }
  }
  
  void e()
  {
    try
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      this.b.sendMessage(localMessage);
      return;
    }
    catch (Exception localException) {}
  }
  
  String f()
  {
    return this.c;
  }
  
  String g()
  {
    return this.e;
  }
  
  private class a
    extends e
  {
    private final String b = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
    private boolean c = false;
    
    a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
      this.k.clear();
      this.k.put("bid", c.a(c.this));
      if (!TextUtils.isEmpty(c.b(c.this))) {
        this.k.put("bldg", c.b(c.this));
      }
      this.k.put("mb", Build.MODEL);
      this.k.put("msdk", "3.0");
      this.k.put("cuid", com.baidu.location.h.b.a().b);
    }
    
    protected void a(String paramString)
    {
      if (!this.c)
      {
        this.c = true;
        i();
      }
    }
    
    public void a(boolean paramBoolean)
    {
      c.a(c.this, Boolean.valueOf(false));
      if ((paramBoolean) && (this.j != null)) {}
      for (;;)
      {
        try
        {
          localObject = new JSONObject(new String(Base64.decode(this.j.toString().getBytes())));
          c.a(c.this, ((JSONObject)localObject).getString("apikey"));
          c.b(c.this, ((JSONObject)localObject).getString("secretkey"));
          c.c(c.this).clear();
          c.d(c.this).clear();
          c.e(c.this).clear();
          localObject = ((JSONObject)localObject).getJSONArray("buildinginfo");
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            c.e(c.this).put(localJSONObject.getString("findex"), localJSONObject.getString("fplanid"));
            if (localJSONObject.has("floorid")) {
              c.d(c.this).put(localJSONObject.getString("findex"), localJSONObject.getString("floorid"));
            }
            if (!localJSONObject.has("venueid")) {
              break label291;
            }
            c.c(c.this).put(localJSONObject.getString("findex"), localJSONObject.getString("venueid"));
            break label291;
          }
          c.a(c.this, Boolean.valueOf(true));
          i = 1;
        }
        catch (Exception localException)
        {
          Object localObject;
          i = 0;
          continue;
        }
        this.c = false;
        if (i != 0)
        {
          localObject = new Message();
          ((Message)localObject).what = 1;
          c.f(c.this).sendMessage((Message)localObject);
        }
        return;
        int i = 0;
        continue;
        label291:
        i += 1;
      }
    }
  }
  
  private static class b
    extends Handler
  {
    private WeakReference<c> a;
    
    b(c paramc, Looper paramLooper)
    {
      super();
      this.a = new WeakReference(paramc);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        paramMessage = (c)this.a.get();
        if (paramMessage != null) {
          paramMessage.c();
        }
      }
      do
      {
        do
        {
          return;
        } while (paramMessage.what != 2);
        paramMessage = (c)this.a.get();
      } while (paramMessage == null);
      paramMessage.d();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */