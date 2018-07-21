package com.baidu.location.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.wifi.ScanResult;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.h.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class c
{
  private static c a = null;
  private static Object b = new Object();
  private a A = null;
  private b B = null;
  private BDLocation C = null;
  private BDLocation D = null;
  private com.baidu.location.f.a E = null;
  private com.baidu.location.f.e F = null;
  private int G = 0;
  private int H = 0;
  private SharedPreferences c = null;
  private int d = 1;
  private int e = 50;
  private float f = 0.5F;
  private long g = 0L;
  private long h = 0L;
  private int i = 0;
  private long j = 0L;
  private boolean k = false;
  private int l = 0;
  private float m = -0.18181887F;
  private float n = -0.90904963F;
  private float o = -0.55321634F;
  private float p = -0.05259979F;
  private float q = 24.0F;
  private float r = 8.61F;
  private float s = 4.25F;
  private float t = 60.39F;
  private float u = 15.6F;
  private float v = 68.07F;
  private float w = 11.61F;
  private double x = -1.0D;
  private boolean y = false;
  private boolean z = false;
  
  public c()
  {
    if (this.c == null) {
      this.c = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePregck", 0);
    }
    if (this.c != null) {}
    try
    {
      this.d = this.c.getInt("enable", 1);
      this.e = this.c.getInt("radius", 50);
      this.f = this.c.getFloat("speed", 0.5F);
      this.l = this.c.getInt("gcs", 0);
      this.m = this.c.getFloat("imc_intercept", this.m);
      this.n = this.c.getFloat("imc_lln", this.n);
      this.o = this.c.getFloat("imc_wftop", this.o);
      this.p = this.c.getFloat("imc_wfave", this.p);
      this.q = this.c.getFloat("omc_snr", this.q);
      this.r = this.c.getFloat("inc_lln_mean", this.r);
      this.s = this.c.getFloat("inc_lln_sigma", this.s);
      this.t = this.c.getFloat("inc_wftop_mean", this.t);
      this.u = this.c.getFloat("inc_wftop_sigma", this.u);
      this.v = this.c.getFloat("inc_wfave_mean", this.v);
      this.w = this.c.getFloat("inc_wfave_sigma", this.w);
      this.g = this.c.getLong("tt", 0L);
      this.h = this.c.getLong("temp_tt", 0L);
      this.i = this.c.getInt("coef_req_time", 0);
      return;
    }
    catch (Exception localException)
    {
      this.d = 1;
      this.e = 50;
      this.f = 0.5F;
      this.l = 0;
      this.m = -0.18181887F;
      this.n = -0.90904963F;
      this.o = -0.55321634F;
      this.p = -0.05259979F;
      this.q = 24.0F;
      this.r = 8.61F;
      this.s = 4.25F;
      this.t = 60.39F;
      this.u = 15.6F;
      this.v = 68.07F;
      this.w = 11.61F;
      this.g = System.currentTimeMillis();
      this.h = System.currentTimeMillis();
      this.i = 0;
    }
  }
  
  public static c a()
  {
    synchronized (b)
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
  }
  
  private String a(Location paramLocation, int paramInt)
  {
    Object localObject1 = null;
    String str;
    float f1;
    int i3;
    Object localObject2;
    int i1;
    if (paramLocation != null)
    {
      str = "{\"result\":{\"time\":\"" + g.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"";
      if (!paramLocation.hasAccuracy()) {
        break label334;
      }
      f1 = paramLocation.getAccuracy();
      i3 = (int)f1;
      f1 = (float)(paramLocation.getSpeed() * 3.6D);
      if (!paramLocation.hasSpeed()) {
        f1 = -1.0F;
      }
      localObject1 = new double[2];
      int i2 = 1;
      if (!com.baidu.location.h.d.a().a(paramLocation.getLongitude(), paramLocation.getLatitude())) {
        break label341;
      }
      localObject2 = Jni.coorEncrypt(paramLocation.getLongitude(), paramLocation.getLatitude(), "gps2gcj");
      i1 = i2;
      localObject1 = localObject2;
      if (localObject2[0] <= 0.0D)
      {
        i1 = i2;
        localObject1 = localObject2;
        if (localObject2[1] <= 0.0D)
        {
          localObject2[0] = paramLocation.getLongitude();
          localObject2[1] = paramLocation.getLatitude();
          localObject1 = localObject2;
          i1 = i2;
        }
      }
    }
    for (;;)
    {
      localObject2 = String.format(Locale.CHINA, str, new Object[] { Double.valueOf(localObject1[0]), Double.valueOf(localObject1[1]), Integer.valueOf(i3), Float.valueOf(paramLocation.getBearing()), Float.valueOf(f1), Integer.valueOf(paramInt) });
      localObject1 = localObject2;
      if (i1 == 0) {
        localObject1 = (String)localObject2 + ",\"in_cn\":\"0\"";
      }
      if (!paramLocation.hasAltitude()) {
        break label363;
      }
      localObject1 = (String)localObject1 + String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[] { Double.valueOf(paramLocation.getAltitude()) });
      return (String)localObject1;
      label334:
      f1 = 10.0F;
      break;
      label341:
      i1 = 0;
      localObject1[0] = paramLocation.getLongitude();
      localObject1[1] = paramLocation.getLatitude();
    }
    label363:
    return (String)localObject1 + "}}";
  }
  
  private ArrayList<Double> a(ArrayList<Double> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Double.valueOf((((Double)paramArrayList.get(0)).doubleValue() - this.r) / this.s));
    localArrayList.add(Double.valueOf((((Double)paramArrayList.get(1)).doubleValue() - this.t) / this.u));
    localArrayList.add(Double.valueOf((((Double)paramArrayList.get(2)).doubleValue() - this.v) / this.w));
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2, double paramDouble)
  {
    boolean bool1 = a(this.F);
    boolean bool2 = a(this.E);
    if ((!bool1) && (!bool2) && (paramInt1 == this.H) && (System.currentTimeMillis() - this.j < 15000L)) {}
    while (System.currentTimeMillis() - this.j < 3000L) {
      return;
    }
    this.H = paramInt1;
    this.j = System.currentTimeMillis();
    this.E = com.baidu.location.f.b.a().f();
    this.F = com.baidu.location.f.f.a().q();
    StringBuffer localStringBuffer = new StringBuffer(1024);
    if ((this.E != null) && (this.E.b())) {
      localStringBuffer.append(this.E.i());
    }
    if ((this.F != null) && (this.F.a() > 1)) {
      localStringBuffer.append(this.F.a(15));
    }
    for (;;)
    {
      Object localObject = com.baidu.location.f.d.a().h();
      if (localObject != null) {
        localStringBuffer.append((String)localObject);
      }
      localStringBuffer.append(com.baidu.location.h.b.a().a(false));
      localStringBuffer.append(com.baidu.location.a.a.a().f());
      localStringBuffer.append("&gad=" + paramInt2);
      localObject = com.baidu.location.b.a.a().a(this.C.getLongitude(), this.C.getLatitude());
      localStringBuffer.append("&gchm=" + String.format("%.2f", new Object[] { Double.valueOf(localObject[0]) }));
      localStringBuffer.append("&gchs=" + localObject[1]);
      localStringBuffer.append("&gsnr=" + String.format("%.2f", new Object[] { Double.valueOf(paramDouble) }));
      localStringBuffer.append("&coor=gcj02");
      this.B.a(localStringBuffer.toString());
      return;
      localObject = com.baidu.location.f.f.a().m();
      if (localObject != null) {
        localStringBuffer.append((String)localObject);
      }
    }
  }
  
  private void a(BDLocation paramBDLocation)
  {
    if (paramBDLocation != null) {
      com.baidu.location.a.a.a().c(paramBDLocation);
    }
  }
  
  private boolean a(double paramDouble, ArrayList<Double> paramArrayList)
  {
    int i1 = 0;
    paramArrayList.add(Double.valueOf(paramDouble));
    if ((this.F.a == null) || (this.F.a.size() < 3)) {
      return false;
    }
    paramArrayList.add(Double.valueOf(-((ScanResult)this.F.a.get(0)).level));
    paramDouble = 0.0D;
    while (i1 < 3)
    {
      paramDouble += -((ScanResult)this.F.a.get(i1)).level;
      i1 += 1;
    }
    paramArrayList.add(Double.valueOf(paramDouble / 3.0D));
    return true;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt != this.G) {
      return true;
    }
    com.baidu.location.f.e locale = com.baidu.location.f.f.a().q();
    boolean bool1 = bool2;
    if (locale.a.size() >= 3)
    {
      bool1 = bool2;
      if (this.F.a.size() >= 3) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      if ((paramInt >= 3) || (((ScanResult)locale.a.get(paramInt)).level != ((ScanResult)this.F.a.get(paramInt)).level))
      {
        bool1 = true;
        return bool1;
      }
      paramInt += 1;
    }
  }
  
  private boolean a(Location paramLocation, double paramDouble, ArrayList<Double> paramArrayList)
  {
    if (paramLocation == null) {}
    double[] arrayOfDouble;
    double d1;
    do
    {
      do
      {
        return false;
        arrayOfDouble = com.baidu.location.b.a.a().a(paramLocation.getLongitude(), paramLocation.getLatitude());
        d1 = arrayOfDouble[0];
        com.baidu.location.b.a.a();
      } while (d1 == 10000.0D);
      d1 = arrayOfDouble[1];
      com.baidu.location.b.a.a();
    } while (d1 == 10000.0D);
    paramArrayList.add(Double.valueOf(arrayOfDouble[0]));
    paramArrayList.add(Double.valueOf(arrayOfDouble[1]));
    paramArrayList.add(Double.valueOf(paramLocation.getAltitude()));
    paramArrayList.add(Double.valueOf(paramDouble));
    return true;
  }
  
  private boolean a(com.baidu.location.f.a parama)
  {
    boolean bool2 = true;
    com.baidu.location.f.a locala = com.baidu.location.f.b.a().f();
    boolean bool1;
    if (locala == parama) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (locala == null);
        bool1 = bool2;
      } while (parama == null);
      bool1 = bool2;
    } while (!parama.a(locala));
    return false;
  }
  
  private boolean a(com.baidu.location.f.e parame)
  {
    boolean bool2 = true;
    com.baidu.location.f.e locale = com.baidu.location.f.f.a().q();
    boolean bool1;
    if (parame == locale) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (locale == null);
        bool1 = bool2;
      } while (parame == null);
      bool1 = bool2;
    } while (!parame.c(locale));
    return false;
  }
  
  private double b(ArrayList<Double> paramArrayList)
  {
    double d1 = this.m;
    double d2 = this.n;
    double d3 = ((Double)paramArrayList.get(0)).doubleValue();
    double d4 = this.o;
    double d5 = ((Double)paramArrayList.get(1)).doubleValue();
    double d6 = this.p;
    return 1.0D / (Math.pow(2.718281828459045D, -(((Double)paramArrayList.get(2)).doubleValue() * d6 + (d1 + d3 * d2 + d5 * d4))) + 1.0D);
  }
  
  private boolean c(ArrayList<Double> paramArrayList)
  {
    double d1 = ((Double)paramArrayList.get(0)).doubleValue();
    double d2 = ((Double)paramArrayList.get(1)).doubleValue();
    double d3 = ((Double)paramArrayList.get(0)).doubleValue();
    double d4 = ((Double)paramArrayList.get(1)).doubleValue();
    return ((((Double)paramArrayList.get(2)).doubleValue() >= d3 - d4 * 2.0D) && (((Double)paramArrayList.get(2)).doubleValue() <= d1 + d2 * 2.0D)) || (((Double)paramArrayList.get(3)).doubleValue() >= this.q);
  }
  
  private boolean d(ArrayList<Long> paramArrayList)
  {
    boolean bool2 = false;
    if (paramArrayList.size() < 3) {
      return false;
    }
    int i1 = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i1 < 3)
      {
        if (((Long)paramArrayList.get(i1)).longValue() > 15L) {
          bool1 = true;
        }
      }
      else
      {
        if (bool1) {
          break;
        }
        Collections.sort(paramArrayList);
        if (((Long)paramArrayList.get(paramArrayList.size() / 2)).longValue() <= 15L) {
          break;
        }
        return true;
      }
      i1 += 1;
    }
    return bool1;
  }
  
  private boolean e(ArrayList<Long> paramArrayList)
  {
    if (paramArrayList.size() < 3) {
      return false;
    }
    Long localLong = Long.valueOf(Long.MIN_VALUE);
    int i1 = 0;
    if (i1 < 3)
    {
      if (localLong.longValue() >= ((Long)paramArrayList.get(i1)).longValue()) {
        break label83;
      }
      localLong = (Long)paramArrayList.get(i1);
    }
    label83:
    for (;;)
    {
      i1 += 1;
      break;
      if (localLong.longValue() > 20L) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void a(Location paramLocation, int paramInt, double paramDouble)
  {
    if ((paramLocation == null) || (paramInt < 3))
    {
      if (g.l) {
        a(new BDLocation(a(paramLocation, paramInt)));
      }
      return;
    }
    this.C = new BDLocation(a(paramLocation, paramInt));
    long l1 = System.currentTimeMillis() - this.g;
    long l2 = System.currentTimeMillis();
    long l3 = this.h;
    if ((l1 > 86400000L) || (l1 < 0L))
    {
      if (this.i >= 10) {
        break label262;
      }
      if ((this.z) || (l2 - l3 < 600000L))
      {
        a(this.C);
        return;
      }
      this.i += 1;
      this.h = System.currentTimeMillis();
    }
    try
    {
      SharedPreferences.Editor localEditor = this.c.edit();
      localEditor.putInt("coef_req_time", this.i);
      localEditor.putLong("temp_tt", this.h);
      localEditor.commit();
      this.A.b();
      for (;;)
      {
        this.E = com.baidu.location.f.b.a().f();
        this.F = com.baidu.location.f.f.a().q();
        try
        {
          this.x = this.C.getSpeed();
          if (this.x <= 10.0D) {
            break;
          }
          this.y = false;
          a(this.C);
          return;
        }
        catch (Exception paramLocation)
        {
          a(this.C);
          return;
        }
        label262:
        this.g = System.currentTimeMillis();
        this.h = System.currentTimeMillis();
        try
        {
          localEditor = this.c.edit();
          localEditor.putLong("tt", this.g);
          localEditor.putLong("temp_tt", this.h);
          localEditor.putInt("coef_req_time", 0);
          localEditor.commit();
        }
        catch (Exception localException1) {}
      }
      if ((this.l == 0) || (!this.k))
      {
        a(this.C);
        return;
      }
      if (!a(paramInt))
      {
        if (this.y)
        {
          a(this.D);
          return;
        }
        a(this.C);
        return;
      }
      if (d(this.F.g()))
      {
        com.baidu.location.f.f.a().f();
        if ((this.y) && (!e(this.F.g())))
        {
          a(this.D);
          return;
        }
        this.y = false;
        a(this.C);
        return;
      }
      if (!com.baidu.location.f.d.a().m())
      {
        a(this.C);
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if (!a(paramInt, localArrayList1))
      {
        this.y = false;
        a(this.C);
        return;
      }
      if (b(a(localArrayList1)) >= 0.5D)
      {
        if ((this.l == 3) || (this.l == 1))
        {
          a(1, 2, paramDouble);
          if (!this.y)
          {
            a(this.C);
            return;
          }
          a(this.D);
          return;
        }
        a(this.C);
        return;
      }
      if ((!a(paramLocation, paramDouble, localArrayList2)) || ((this.l != 3) && (this.l != 2)))
      {
        this.y = false;
        a(this.C);
        return;
      }
      if (c(localArrayList2))
      {
        this.y = false;
        a(this.C);
        return;
      }
      a(2, 3, paramDouble);
      if (!this.y)
      {
        a(this.C);
        return;
      }
      a(this.D);
      return;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  class a
    extends com.baidu.location.h.e
  {
    a() {}
    
    public void a()
    {
      if (this.k == null) {
        this.k = new HashMap();
      }
      if (this.k != null) {
        this.k.clear();
      }
      this.k.put("qt", "gps_vd");
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null))
      {
        c.a(c.this, System.currentTimeMillis());
        c.b(c.this, System.currentTimeMillis());
      }
      try
      {
        Object localObject1 = c.b(c.this).edit();
        ((SharedPreferences.Editor)localObject1).putLong("tt", c.c(c.this));
        ((SharedPreferences.Editor)localObject1).putLong("temp_tt", c.d(c.this));
        ((SharedPreferences.Editor)localObject1).putInt("coef_req_time", 0);
        ((SharedPreferences.Editor)localObject1).commit();
        try
        {
          localObject1 = new JSONObject(this.j);
          if (((JSONObject)localObject1).has("gps_vd"))
          {
            localObject1 = ((JSONObject)localObject1).getJSONObject("gps_vd");
            c.a(c.this, ((JSONObject)localObject1).getInt("enable"));
            if (c.e(c.this) != 0)
            {
              c.b(c.this, ((JSONObject)localObject1).getInt("radius"));
              c.a(c.this, (float)((JSONObject)localObject1).getDouble("speed"));
            }
            if (((JSONObject)localObject1).has("gps_rec"))
            {
              localObject2 = ((JSONObject)localObject1).getJSONObject("gps_rec");
              c.c(c.this, ((JSONObject)localObject2).getInt("gcs"));
              JSONObject localJSONObject1;
              if (((JSONObject)localObject2).has("imc"))
              {
                localJSONObject1 = ((JSONObject)localObject2).getJSONObject("imc");
                c.b(c.this, (float)localJSONObject1.getDouble("intercept"));
                c.c(c.this, (float)localJSONObject1.getDouble("lln"));
                c.d(c.this, (float)localJSONObject1.getDouble("wftop"));
                c.e(c.this, (float)localJSONObject1.getDouble("wfave"));
              }
              if (((JSONObject)localObject2).has("omc"))
              {
                localJSONObject1 = ((JSONObject)localObject2).getJSONObject("omc");
                c.f(c.this, (float)localJSONObject1.getDouble("snr"));
              }
              if (((JSONObject)localObject2).has("inc"))
              {
                JSONObject localJSONObject2 = ((JSONObject)localObject2).getJSONObject("inc");
                localObject2 = localJSONObject2.getJSONObject("lln");
                localJSONObject1 = localJSONObject2.getJSONObject("wftop");
                localJSONObject2 = localJSONObject2.getJSONObject("wfave");
                c.g(c.this, (float)((JSONObject)localObject2).getDouble("mean"));
                c.h(c.this, (float)((JSONObject)localObject2).getDouble("sigma"));
                c.i(c.this, (float)localJSONObject1.getDouble("mean"));
                c.j(c.this, (float)localJSONObject1.getDouble("sigma"));
                c.k(c.this, (float)localJSONObject2.getDouble("mean"));
                c.l(c.this, (float)localJSONObject2.getDouble("sigma"));
              }
            }
          }
        }
        catch (Exception localException1)
        {
          Object localObject2;
          label726:
          for (;;) {}
        }
        try
        {
          localObject2 = c.b(c.this).edit();
          ((SharedPreferences.Editor)localObject2).putInt("enable", c.e(c.this));
          ((SharedPreferences.Editor)localObject2).putInt("radius", c.f(c.this));
          ((SharedPreferences.Editor)localObject2).putFloat("speed", c.g(c.this));
          if (((JSONObject)localObject1).has("gps_rec"))
          {
            ((SharedPreferences.Editor)localObject2).putInt("gcs", c.h(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("imc_intercept", c.i(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("imc_lln", c.j(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("imc_wftop", c.k(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("imc_wfave", c.l(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("omc_snr", c.m(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("inc_lln_mean", c.n(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("inc_lln_sigma", c.o(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("inc_wftop_mean", c.p(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("inc_wftop_sigma", c.q(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("inc_wfave_mean", c.r(c.this));
            ((SharedPreferences.Editor)localObject2).putFloat("inc_wfave_sigma", c.s(c.this));
          }
          ((SharedPreferences.Editor)localObject2).commit();
        }
        catch (Exception localException2)
        {
          break label726;
        }
        c.b(c.this, false);
        return;
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
    
    public void b()
    {
      c.b(c.this, true);
      c("https://loc.map.baidu.com/cfgs/loc/gps");
    }
  }
  
  class b
    extends com.baidu.location.h.e
  {
    private String b = null;
    
    b()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      String str = Jni.encodeTp4(this.b);
      this.b = null;
      this.k.put("bloc", str);
    }
    
    public void a(String paramString)
    {
      this.b = paramString;
      c(g.f);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      for (;;)
      {
        try
        {
          BDLocation localBDLocation = new BDLocation(this.j);
          if (localBDLocation.getGpsCheckStatus() == 0)
          {
            c.a(c.this, false);
            if (this.k != null) {
              this.k.clear();
            }
            return;
          }
          c.a(c.this, true);
          c.a(c.this, localBDLocation);
          c.b(c.this, localBDLocation);
          continue;
        }
        catch (Exception localException)
        {
          c.a(c.this, false);
          c.b(c.this, c.a(c.this));
          continue;
        }
        c.b(c.this, c.a(c.this));
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */