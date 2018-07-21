package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Jni;
import com.baidu.location.indoor.mapversion.b.a.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class d
{
  private static d j;
  private f A = null;
  private String B = null;
  private String C = null;
  private String D = null;
  private int E = 0;
  private boolean F = true;
  private int G = 7;
  private b<String> H = null;
  private int I = 20;
  private b<String> J = null;
  private double K = 0.0D;
  private double L = 0.0D;
  private double M = 0.4D;
  private double N = 0.0D;
  private boolean O = false;
  private boolean P = true;
  private List<g> Q = Collections.synchronizedList(new ArrayList());
  private int R = -1;
  private int S = 0;
  private int T = 0;
  private a U;
  private String V = null;
  private c W = null;
  private i X;
  private i.a Y;
  private boolean Z = false;
  boolean a = false;
  private int aa = 2;
  private BDLocation ab = null;
  private boolean ac = false;
  private boolean ad = false;
  private boolean ae = false;
  private List<Float> af = Collections.synchronizedList(new ArrayList());
  boolean b = false;
  public e c = null;
  public SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private final int e = 32;
  private boolean f = false;
  private BDLocationListener g = new BDLocationListener()
  {
    public void onReceiveLocation(BDLocation paramAnonymousBDLocation)
    {
      if ((paramAnonymousBDLocation != null) && (d.a(d.this) != null))
      {
        if ((paramAnonymousBDLocation.getAddrStr() == null) && (d.a(d.this).getAddrStr() != null))
        {
          paramAnonymousBDLocation.setAddr(d.a(d.this).getAddress());
          paramAnonymousBDLocation.setAddrStr(d.a(d.this).getAddrStr());
        }
        if ((paramAnonymousBDLocation.getPoiList() == null) && (d.a(d.this).getPoiList() != null)) {
          paramAnonymousBDLocation.setPoiList(d.a(d.this).getPoiList());
        }
        if ((paramAnonymousBDLocation.getLocationDescribe() == null) && (d.a(d.this).getLocationDescribe() != null)) {
          paramAnonymousBDLocation.setLocationDescribe(d.a(d.this).getLocationDescribe());
        }
      }
      if (d.b(d.this).c() == 1)
      {
        if ((paramAnonymousBDLocation == null) || (com.baidu.location.f.d.a().m())) {
          break label220;
        }
        paramAnonymousBDLocation.setUserIndoorState(1);
        paramAnonymousBDLocation.setIndoorNetworkState(d.c(d.this));
        com.baidu.location.a.a.a().a(paramAnonymousBDLocation);
      }
      for (;;)
      {
        if ((paramAnonymousBDLocation != null) && (paramAnonymousBDLocation.getNetworkLocationType().equals("ml")))
        {
          Message localMessage = d.this.c.obtainMessage(801);
          localMessage.obj = paramAnonymousBDLocation;
          localMessage.sendToTarget();
        }
        return;
        label220:
        if ((paramAnonymousBDLocation != null) && (com.baidu.location.f.d.a().m()) && (d.d(d.this)))
        {
          paramAnonymousBDLocation.setUserIndoorState(1);
          paramAnonymousBDLocation.setIndoorNetworkState(d.c(d.this));
          com.baidu.location.a.a.a().a(paramAnonymousBDLocation);
        }
      }
    }
  };
  private BDLocationListener h;
  private int i = 5;
  private long k = 3000L;
  private volatile boolean l = true;
  private h m = null;
  private f n = null;
  private h o = null;
  private long p = 0L;
  private boolean q = false;
  private boolean r = false;
  private long s = 0L;
  private int t = 0;
  private int u = 0;
  private h.a v;
  private int w = 0;
  private int x = 0;
  private String y = null;
  private String z = null;
  
  private d()
  {
    try
    {
      com.baidu.location.indoor.mapversion.b.a.a(com.baidu.location.f.getServiceContext());
      this.X = new i();
      this.X.a(800L);
      this.Y = new i.a()
      {
        public void a(BDLocation paramAnonymousBDLocation)
        {
          d.a(d.this, paramAnonymousBDLocation, 29);
        }
      };
      this.v = new h.a()
      {
        public void a(double paramAnonymousDouble1, double paramAnonymousDouble2)
        {
          for (;;)
          {
            Object localObject;
            double d1;
            double d2;
            try
            {
              d.this.a = true;
              d.this.b = true;
              d.a(d.this, 0.4D);
              if ((d.e(d.this) > 0.1D) || (d.f(d.this) > 0.1D))
              {
                int j = 0;
                localBDLocation2 = null;
                localObject = localBDLocation2;
                i = j;
                if (d.g(d.this))
                {
                  localObject = localBDLocation2;
                  i = j;
                  if (d.h(d.this))
                  {
                    localObject = com.baidu.location.indoor.mapversion.a.a.a(d.i(d.this), paramAnonymousDouble1, paramAnonymousDouble2);
                    if (localObject == null) {
                      continue;
                    }
                    i = 1;
                    break label796;
                  }
                }
                if ((d.g(d.this)) && (d.h(d.this)) && (i != 0)) {
                  break label793;
                }
                localObject = d.a(d.this, d.f(d.this), d.e(d.this), paramAnonymousDouble1, paramAnonymousDouble2);
                d.j(d.this).add(Float.valueOf((float)paramAnonymousDouble2));
                d.b(d.this, paramAnonymousDouble2);
              }
            }
            finally {}
            try
            {
              d1 = d.f(d.this);
              d2 = d.e(d.this);
              if (d.a(d.this) != null)
              {
                d1 = d.a(d.this).getLatitude();
                d2 = d.a(d.this).getLongitude();
              }
              if ((localObject[0] >= 1.0D) && (localObject[1] >= 1.0D))
              {
                d1 = g.a(localObject[0], localObject[1], d1, d2);
                if (d1 <= 10000.0D) {
                  continue;
                }
              }
            }
            catch (Exception localException)
            {
              continue;
            }
            return;
            int i = 0;
            break label796;
            BDLocation localBDLocation2 = new BDLocation();
            localBDLocation2.setLocType(161);
            localBDLocation2.setLatitude(localObject[0]);
            localBDLocation2.setLongitude(localObject[1]);
            localBDLocation2.setRadius(15.0F);
            localBDLocation2.setDirection((float)paramAnonymousDouble2);
            Date localDate = new Date();
            localBDLocation2.setTime(d.this.d.format(localDate));
            d.c(d.this, localObject[0]);
            d.d(d.this, localObject[1]);
            if (d.i(d.this) != null) {
              localBDLocation2.setFloor(d.i(d.this));
            }
            if (d.k(d.this) != null) {
              localBDLocation2.setBuildingID(d.k(d.this));
            }
            if (d.l(d.this) != null) {
              localBDLocation2.setBuildingName(d.l(d.this));
            }
            localBDLocation2.setParkAvailable(d.m(d.this));
            if (d.n(d.this) != null)
            {
              localBDLocation2.setNetworkLocationType(d.n(d.this));
              if (d.o(d.this))
              {
                localBDLocation2.setIndoorLocMode(true);
                d.p(d.this);
                if (d.q(d.this).size() > 50) {
                  d.q(d.this).clear();
                }
                d.q(d.this).add(new d.g(d.this, d.b(d.this).d(), paramAnonymousDouble1, paramAnonymousDouble2));
                if ((d.r(d.this) >= 60) || (d.b(d.this).d() % 3 != 0)) {
                  continue;
                }
                localBDLocation2.setNetworkLocationType("dr");
                d.a(d.this, localBDLocation2, 21);
                localObject = new BDLocation(localBDLocation2);
                if (!com.baidu.location.indoor.b.b.a().a((BDLocation)localObject)) {
                  break label692;
                }
                d.a(d.this, (BDLocation)localObject, 21);
              }
            }
            else
            {
              localBDLocation2.setNetworkLocationType("wf");
              continue;
            }
            continue;
            label692:
            if (0 != 0) {
              localBDLocation1.setNetworkLocationType(null);
            }
            for (;;)
            {
              if ((d.s(d.this) != null) && (d.s(d.this).c()))
              {
                if (d.t(d.this) > 2L)
                {
                  d.s(d.this).a(localBDLocation1);
                  break;
                  localBDLocation1.setNetworkLocationType("dr2");
                  continue;
                }
                d.a(d.this, localBDLocation1, 29);
                break;
              }
            }
            d.a(d.this, localBDLocation1, 21);
            continue;
            label793:
            continue;
            label796:
            if (localBDLocation1 == null) {}
          }
        }
      };
      this.m = new h(com.baidu.location.f.getServiceContext(), this.v);
      this.o = new h();
      this.H = new b(this.G);
      this.J = new b(this.I);
      this.U = new a(com.baidu.location.f.getServiceContext());
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static d a()
  {
    try
    {
      if (j == null) {
        j = new d();
      }
      d locald = j;
      return locald;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    if (this.Q.size() == 0) {
      return "&dr=0:0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&dr=");
    ((g)this.Q.get(0)).d = 1;
    localStringBuilder.append(((g)this.Q.get(0)).toString());
    int i2 = ((g)this.Q.get(0)).a;
    int i1 = 1;
    while ((i1 < this.Q.size()) && (i1 <= paramInt))
    {
      ((g)this.Q.get(i1)).d = (((g)this.Q.get(i1)).a - i2);
      localStringBuilder.append(";");
      localStringBuilder.append(((g)this.Q.get(i1)).toString());
      i2 = ((g)this.Q.get(i1)).a;
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private String a(com.baidu.location.f.e parame)
  {
    int i2 = parame.a();
    if (i2 <= 32) {
      return parame.a(32) + "&aprk=0";
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    Object localObject;
    if (i1 < i2)
    {
      localObject = ((ScanResult)parame.a.get(i1)).BSSID.replaceAll(":", "").toLowerCase();
      if ((this.U != null) && (this.U.b((String)localObject))) {
        localArrayList1.add(parame.a.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localArrayList2.add(parame.a.get(i1));
      }
    }
    if (localArrayList1.size() > 0) {}
    for (String str = "&aprk=3";; str = "")
    {
      localObject = str;
      if (str.equals("")) {
        if (!this.U.b()) {
          break label237;
        }
      }
      label237:
      for (localObject = "&aprk=2";; localObject = "&aprk=1")
      {
        localArrayList1.addAll(localArrayList2);
        parame.a = localArrayList1;
        parame = parame.a(32);
        return parame + (String)localObject;
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    if (!this.q) {
      return;
    }
    paramMessage = (BDLocation)paramMessage.obj;
    Object localObject;
    if (paramMessage.getLocType() == 161)
    {
      o();
      if ((paramMessage.getIndoorSurpportPolygon() != null) && (paramMessage.getIndoorLocationSurpportBuidlingID() != null) && ((this.A == null) || (!this.A.a().equals(paramMessage.getBuildingID()))))
      {
        localObject = paramMessage.getIndoorSurpportPolygon().split("\\|");
        Location[] arrayOfLocation = new Location[localObject.length];
        int i1 = 0;
        while (i1 < localObject.length)
        {
          String[] arrayOfString = localObject[i1].split(",");
          Location localLocation = new Location("gps");
          localLocation.setLatitude(Double.valueOf(arrayOfString[1]).doubleValue());
          localLocation.setLongitude(Double.valueOf(arrayOfString[0]).doubleValue());
          arrayOfLocation[i1] = localLocation;
          i1 += 1;
        }
        this.A = new f(paramMessage.getIndoorLocationSurpportBuidlingID(), arrayOfLocation);
      }
      this.t = 0;
      if (paramMessage.getBuildingID() == null)
      {
        this.r = false;
        this.u += 1;
        if (this.u > 3) {
          d();
        }
        label226:
        if ((paramMessage.getNetworkLocationType() != null) && (!paramMessage.getNetworkLocationType().equals("ble"))) {
          com.baidu.location.a.h.c().c(paramMessage);
        }
        label253:
        if (this.r)
        {
          if (paramMessage.getTime() == null)
          {
            localObject = new Date();
            paramMessage.setTime(this.d.format((Date)localObject));
          }
          a(paramMessage, 21);
          if (paramMessage.getNetworkLocationType().equals("wf"))
          {
            localObject = new b(paramMessage.getLongitude(), paramMessage.getLatitude(), System.currentTimeMillis(), this.m.d(), this.af, paramMessage.getRetFields("gradient"), paramMessage.getRetFields("mean_error"), paramMessage.getRetFields("confidence"));
            this.af.clear();
            if (!((b)localObject).e.isEmpty())
            {
              if (h.a(this.o).a((b)localObject)) {
                h.b(this.o).b((b)localObject);
              }
              this.o.a = h.b(this.o).b();
              h.a(this.o).b((b)localObject);
            }
            paramMessage.setDirection((float)this.N);
          }
          paramMessage = new BDLocation(paramMessage);
          if (!com.baidu.location.indoor.b.b.a().a(paramMessage)) {
            break label942;
          }
          a(paramMessage, 21);
        }
      }
    }
    for (;;)
    {
      this.o.c();
      return;
      this.w = 0;
      this.u = 0;
      this.r = true;
      paramMessage.setIndoorLocMode(true);
      if ((this.K < 0.1D) || (this.L < 0.1D))
      {
        this.L = paramMessage.getLatitude();
        this.K = paramMessage.getLongitude();
      }
      if (this.y == null) {
        this.y = paramMessage.getFloor();
      }
      a(paramMessage.getBuildingName(), paramMessage.getFloor());
      this.z = paramMessage.getBuildingID();
      this.B = paramMessage.getBuildingName();
      this.D = paramMessage.getNetworkLocationType();
      if ((this.D.equals("ble")) && (this.P == true))
      {
        this.L = paramMessage.getLatitude();
        this.K = paramMessage.getLongitude();
        this.P = false;
      }
      this.E = paramMessage.isParkAvailable();
      if (!paramMessage.getFloor().equals(n())) {
        break;
      }
      boolean bool2 = paramMessage.getFloor().equalsIgnoreCase(this.y);
      if ((!bool2) && (this.ad))
      {
        com.baidu.location.indoor.mapversion.a.a.b();
        this.ae = com.baidu.location.indoor.mapversion.a.a.a(paramMessage.getFloor());
      }
      this.y = paramMessage.getFloor();
      if (!bool2) {
        k();
      }
      int i2 = 0;
      if (this.ad)
      {
        boolean bool1 = com.baidu.location.indoor.mapversion.a.a.a(paramMessage);
        i2 = bool1;
        if (!bool1) {}
      }
      if (((!this.ad) || (i2 == 0)) && (!this.O) && (bool2))
      {
        double d1 = this.K;
        double d2 = 1000000L;
        double d3 = this.M;
        double d4 = this.M;
        double d5 = paramMessage.getLongitude();
        double d6 = 1000000L;
        paramMessage.setLatitude((this.L * 1000000L * this.M + (1.0D - this.M) * (paramMessage.getLatitude() * 1000000L)) / 1000000L);
        paramMessage.setLongitude((d1 * d2 * d3 + (1.0D - d4) * (d5 * d6)) / 1000000L);
      }
      this.L = paramMessage.getLatitude();
      this.K = paramMessage.getLongitude();
      break label226;
      if (paramMessage.getLocType() == 63)
      {
        this.t += 1;
        this.r = false;
        this.Z = true;
        if (this.t <= 10) {
          break;
        }
        d();
        break label253;
      }
      this.t = 0;
      this.r = false;
      break label253;
      label942:
      localObject = paramMessage.getNetworkLocationType();
      paramMessage.setNetworkLocationType((String)localObject + "2");
      if ((this.X != null) && (this.X.c()))
      {
        if (this.T > 2L) {
          this.X.a(paramMessage);
        } else {
          a(paramMessage, 29);
        }
      }
      else {
        a(paramMessage, 21);
      }
    }
  }
  
  private void a(BDLocation paramBDLocation)
  {
    e.a().a(paramBDLocation, this.C);
  }
  
  private void a(BDLocation paramBDLocation, int paramInt)
  {
    if (this.ab != null)
    {
      if ((paramBDLocation.getAddrStr() == null) && (this.ab.getAddrStr() != null))
      {
        paramBDLocation.setAddr(this.ab.getAddress());
        paramBDLocation.setAddrStr(this.ab.getAddrStr());
      }
      if ((paramBDLocation.getPoiList() == null) && (this.ab.getPoiList() != null)) {
        paramBDLocation.setPoiList(this.ab.getPoiList());
      }
      if ((paramBDLocation.getLocationDescribe() == null) && (this.ab.getLocationDescribe() != null)) {
        paramBDLocation.setLocationDescribe(this.ab.getLocationDescribe());
      }
    }
    if ((this.f) && (this.h != null))
    {
      paramBDLocation.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
      if (paramBDLocation.getNetworkLocationType().contains("2"))
      {
        localObject = paramBDLocation.getNetworkLocationType();
        paramBDLocation.setNetworkLocationType(((String)localObject).substring(0, ((String)localObject).length() - 1));
        this.h.onReceiveLocation(paramBDLocation);
      }
    }
    while ((com.baidu.location.f.d.a().m()) || ((this.X != null) && (this.X.c()) && (paramInt != 29)))
    {
      return;
      paramBDLocation = new BDLocation(paramBDLocation);
      Object localObject = this.c.obtainMessage(801);
      ((Message)localObject).obj = paramBDLocation;
      ((Message)localObject).sendToTarget();
      return;
    }
    paramBDLocation.setIndoorNetworkState(this.aa);
    paramBDLocation.setUserIndoorState(1);
    com.baidu.location.a.a.a().a(paramBDLocation);
  }
  
  private void a(final String paramString1, final String paramString2)
  {
    if ((this.B != null) && (this.B.equals(paramString1)) && (this.ad)) {
      return;
    }
    com.baidu.location.indoor.mapversion.b.a locala = com.baidu.location.indoor.mapversion.b.a.a();
    locala.a("gcj02");
    locala.a(paramString1, new a.c()
    {
      public void a(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        d.a(d.this, paramAnonymousBoolean);
        if (paramAnonymousBoolean) {
          d.b(d.this, com.baidu.location.indoor.mapversion.a.a.a(paramString2));
        }
      }
    });
  }
  
  private double[] a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    double d1 = Math.toRadians(paramDouble4);
    paramDouble4 = Math.asin(Math.sin(paramDouble1) * Math.cos(paramDouble3 / 6378137.0D) + Math.cos(paramDouble1) * Math.sin(paramDouble3 / 6378137.0D) * Math.cos(d1));
    paramDouble1 = Math.atan2(Math.sin(d1) * Math.sin(paramDouble3 / 6378137.0D) * Math.cos(paramDouble1), Math.cos(paramDouble3 / 6378137.0D) - Math.sin(paramDouble1) * Math.sin(paramDouble4));
    return new double[] { Math.toDegrees(paramDouble4), Math.toDegrees(paramDouble1 + paramDouble2) };
  }
  
  private void b(Message paramMessage)
  {
    paramMessage = (BDLocation)paramMessage.obj;
    if ((this.K < 0.1D) || (this.L < 0.1D))
    {
      this.L = paramMessage.getLatitude();
      this.K = paramMessage.getLongitude();
    }
    this.H.add(paramMessage.getFloor());
    this.y = n();
    paramMessage.setFloor(this.y);
    double d1 = this.K;
    double d2 = 1000000L;
    double d3 = this.M;
    double d4 = this.M;
    double d5 = paramMessage.getLongitude();
    double d6 = 1000000L;
    paramMessage.setLatitude((this.L * 1000000L * this.M + (1.0D - this.M) * (paramMessage.getLatitude() * 1000000L)) / 1000000L);
    paramMessage.setLongitude((d1 * d2 * d3 + (1.0D - d4) * (d5 * d6)) / 1000000L);
    Date localDate = new Date();
    paramMessage.setTime(this.d.format(localDate));
    this.L = paramMessage.getLatitude();
    this.K = paramMessage.getLongitude();
    a(paramMessage, 21);
  }
  
  private boolean j()
  {
    SensorManager localSensorManager = (SensorManager)com.baidu.location.f.getServiceContext().getSystemService("sensor");
    if ((localSensorManager.getDefaultSensor(4) != null) && (localSensorManager.getDefaultSensor(1) != null) && (localSensorManager.getDefaultSensor(2) != null)) {
      try
      {
        getClass().getClassLoader().loadClass("com.indooratlas.android.sdk.IALocationManager");
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return false;
      }
    }
    return false;
  }
  
  private void k()
  {
    this.X.b();
    this.T = 0;
    h.a(this.o).g();
    h.b(this.o).g();
    this.o.a = 0.0F;
    h.c(this.o).clear();
    this.af.clear();
    this.Q.clear();
  }
  
  private void l()
  {
    this.H.clear();
    this.J.clear();
    this.s = 0L;
    this.t = 0;
    this.E = 0;
    this.x = 0;
    this.y = null;
    this.Z = false;
    this.z = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.F = true;
    this.M = 0.4D;
    this.K = 0.0D;
    this.L = 0.0D;
    this.w = 0;
    this.u = 0;
    this.O = false;
    this.S = 0;
    if (this.ad)
    {
      com.baidu.location.indoor.mapversion.a.a.b();
      com.baidu.location.indoor.mapversion.b.a.a().b();
    }
    this.ae = false;
    this.ad = false;
    com.baidu.location.a.i.a().c(false);
    if (this.W != null) {
      this.W.b();
    }
  }
  
  private void m()
  {
    if (this.q)
    {
      this.l = true;
      this.o.b();
      this.p = System.currentTimeMillis();
    }
  }
  
  private String n()
  {
    HashMap localHashMap = new HashMap();
    int i3 = this.H.size();
    Object localObject2 = null;
    int i2 = -1;
    int i1 = 0;
    String str = "";
    if (i1 < i3)
    {
      try
      {
        localObject3 = (String)this.H.get(i1);
        str = str + (String)localObject3 + "|";
        if (localHashMap.containsKey(localObject3)) {
          localHashMap.put(localObject3, Integer.valueOf(((Integer)localHashMap.get(localObject3)).intValue() + 1));
        } else {
          localHashMap.put(localObject3, Integer.valueOf(1));
        }
      }
      catch (Exception localException)
      {
        localObject2 = this.y;
      }
      label145:
      return (String)localObject2;
    }
    Object localObject3 = localHashMap.keySet().iterator();
    Object localObject1 = localObject2;
    i1 = i2;
    label474:
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (String)((Iterator)localObject3).next();
        if (((Integer)localHashMap.get(localObject2)).intValue() > i1)
        {
          i1 = ((Integer)localHashMap.get(localObject2)).intValue();
          localObject1 = localObject2;
          break label474;
        }
      }
      else
      {
        if ((i3 == this.G) && (!this.y.equals(localObject1)))
        {
          if ((((String)this.H.get(i3 - 3)).equals(localObject1)) && (((String)this.H.get(i3 - 2)).equals(localObject1)))
          {
            localObject2 = localObject1;
            if (((String)this.H.get(i3 - 1)).equals(localObject1)) {
              break label145;
            }
          }
          return this.y;
        }
        if (localObject1 == null) {
          return this.y;
        }
        localObject2 = localObject1;
        if (i3 < 3) {
          break label145;
        }
        localObject2 = localObject1;
        if (i3 > this.G) {
          break label145;
        }
        localObject2 = localObject1;
        if (!((String)this.H.get(i3 - 3)).equals(this.H.get(i3 - 1))) {
          break label145;
        }
        localObject2 = localObject1;
        if (!((String)this.H.get(i3 - 2)).equals(this.H.get(i3 - 1))) {
          break label145;
        }
        localObject2 = localObject1;
        if (((String)this.H.get(i3 - 1)).equals(localObject1)) {
          break label145;
        }
        localObject1 = (String)this.H.get(i3 - 1);
        return (String)localObject1;
      }
      break label474;
      i1 += 1;
      break;
    }
  }
  
  private void o()
  {
    int i1 = this.R;
    while ((i1 >= 0) && (this.Q.size() > 0))
    {
      this.Q.remove(0);
      i1 -= 1;
    }
    this.R = -1;
  }
  
  public boolean a(Location paramLocation)
  {
    if ((paramLocation != null) && (this.A != null) && (this.A.a(paramLocation.getLatitude(), paramLocation.getLongitude()))) {}
    for (this.ac = true;; this.ac = false) {
      return this.ac;
    }
  }
  
  public void b()
  {
    try
    {
      if (this.q) {
        this.H.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 140	com/baidu/location/indoor/d:q	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   18: putfield 144	com/baidu/location/indoor/d:s	J
    //   21: aload_0
    //   22: getfield 132	com/baidu/location/indoor/d:m	Lcom/baidu/location/indoor/h;
    //   25: invokevirtual 866	com/baidu/location/indoor/h:a	()V
    //   28: aload_0
    //   29: new 29	com/baidu/location/indoor/d$f
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 867	com/baidu/location/indoor/d$f:<init>	(Lcom/baidu/location/indoor/d;)V
    //   37: putfield 134	com/baidu/location/indoor/d:n	Lcom/baidu/location/indoor/d$f;
    //   40: aload_0
    //   41: getfield 134	com/baidu/location/indoor/d:n	Lcom/baidu/location/indoor/d$f;
    //   44: invokevirtual 870	com/baidu/location/indoor/d$f:start	()V
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 142	com/baidu/location/indoor/d:r	Z
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 140	com/baidu/location/indoor/d:q	Z
    //   57: aload_0
    //   58: invokespecial 872	com/baidu/location/indoor/d:j	()Z
    //   61: ifeq +31 -> 92
    //   64: invokestatic 877	com/baidu/location/indoor/a/a:b	()Lcom/baidu/location/indoor/a/a;
    //   67: invokevirtual 878	com/baidu/location/indoor/a/a:c	()Z
    //   70: ifeq +22 -> 92
    //   73: aload_0
    //   74: iconst_1
    //   75: putfield 236	com/baidu/location/indoor/d:f	Z
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 241	com/baidu/location/indoor/d:g	Lcom/baidu/location/BDLocationListener;
    //   83: invokestatic 883	com/baidu/location/indoor/a/b:a	(Lcom/baidu/location/BDLocationListener;)Lcom/baidu/location/indoor/a/b;
    //   86: invokevirtual 886	com/baidu/location/indoor/a/b:b	()Lcom/baidu/location/BDLocationListener;
    //   89: putfield 638	com/baidu/location/indoor/d:h	Lcom/baidu/location/BDLocationListener;
    //   92: aload_0
    //   93: getfield 258	com/baidu/location/indoor/d:X	Lcom/baidu/location/indoor/i;
    //   96: aload_0
    //   97: getfield 266	com/baidu/location/indoor/d:Y	Lcom/baidu/location/indoor/i$a;
    //   100: invokevirtual 889	com/baidu/location/indoor/i:a	(Lcom/baidu/location/indoor/i$a;)V
    //   103: aload_0
    //   104: invokestatic 248	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   107: invokestatic 892	com/baidu/location/indoor/c:a	(Landroid/content/Context;)Lcom/baidu/location/indoor/c;
    //   110: putfield 211	com/baidu/location/indoor/d:W	Lcom/baidu/location/indoor/c;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 205	com/baidu/location/indoor/d:S	I
    //   118: invokestatic 798	com/baidu/location/a/i:a	()Lcom/baidu/location/a/i;
    //   121: iconst_1
    //   122: invokevirtual 800	com/baidu/location/a/i:c	(Z)V
    //   125: invokestatic 798	com/baidu/location/a/i:a	()Lcom/baidu/location/a/i;
    //   128: invokevirtual 893	com/baidu/location/a/i:d	()V
    //   131: goto -120 -> 11
    //   134: astore_2
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	d
    //   6	2	1	bool	boolean
    //   134	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	134	finally
    //   14	92	134	finally
    //   92	131	134	finally
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 140	com/baidu/location/indoor/d:q	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 132	com/baidu/location/indoor/d:m	Lcom/baidu/location/indoor/h;
    //   18: invokevirtual 894	com/baidu/location/indoor/h:b	()V
    //   21: aload_0
    //   22: getfield 258	com/baidu/location/indoor/d:X	Lcom/baidu/location/indoor/i;
    //   25: ifnull +20 -> 45
    //   28: aload_0
    //   29: getfield 258	com/baidu/location/indoor/d:X	Lcom/baidu/location/indoor/i;
    //   32: invokevirtual 596	com/baidu/location/indoor/i:c	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_0
    //   39: getfield 258	com/baidu/location/indoor/d:X	Lcom/baidu/location/indoor/i;
    //   42: invokevirtual 895	com/baidu/location/indoor/i:a	()V
    //   45: aload_0
    //   46: getfield 287	com/baidu/location/indoor/d:U	Lcom/baidu/location/indoor/a;
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: getfield 287	com/baidu/location/indoor/d:U	Lcom/baidu/location/indoor/a;
    //   56: invokevirtual 896	com/baidu/location/indoor/a:c	()V
    //   59: aload_0
    //   60: getfield 236	com/baidu/location/indoor/d:f	Z
    //   63: ifeq +23 -> 86
    //   66: aload_0
    //   67: getfield 241	com/baidu/location/indoor/d:g	Lcom/baidu/location/BDLocationListener;
    //   70: invokestatic 883	com/baidu/location/indoor/a/b:a	(Lcom/baidu/location/BDLocationListener;)Lcom/baidu/location/indoor/a/b;
    //   73: ifnull +13 -> 86
    //   76: aload_0
    //   77: getfield 241	com/baidu/location/indoor/d:g	Lcom/baidu/location/BDLocationListener;
    //   80: invokestatic 883	com/baidu/location/indoor/a/b:a	(Lcom/baidu/location/BDLocationListener;)Lcom/baidu/location/indoor/a/b;
    //   83: invokevirtual 897	com/baidu/location/indoor/a/b:d	()V
    //   86: aload_0
    //   87: getfield 134	com/baidu/location/indoor/d:n	Lcom/baidu/location/indoor/d$f;
    //   90: ifnull +24 -> 114
    //   93: aload_0
    //   94: getfield 134	com/baidu/location/indoor/d:n	Lcom/baidu/location/indoor/d$f;
    //   97: iconst_0
    //   98: invokestatic 900	com/baidu/location/indoor/d$f:a	(Lcom/baidu/location/indoor/d$f;Z)Z
    //   101: pop
    //   102: aload_0
    //   103: getfield 134	com/baidu/location/indoor/d:n	Lcom/baidu/location/indoor/d$f;
    //   106: invokevirtual 903	com/baidu/location/indoor/d$f:interrupt	()V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 134	com/baidu/location/indoor/d:n	Lcom/baidu/location/indoor/d$f;
    //   114: aload_0
    //   115: invokespecial 905	com/baidu/location/indoor/d:l	()V
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 142	com/baidu/location/indoor/d:r	Z
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 140	com/baidu/location/indoor/d:q	Z
    //   128: invokestatic 690	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
    //   131: invokevirtual 907	com/baidu/location/a/a:e	()V
    //   134: invokestatic 605	com/baidu/location/indoor/e:a	()Lcom/baidu/location/indoor/e;
    //   137: invokevirtual 908	com/baidu/location/indoor/e:b	()V
    //   140: goto -129 -> 11
    //   143: astore_2
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	d
    //   6	2	1	bool	boolean
    //   143	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	143	finally
    //   14	45	143	finally
    //   45	59	143	finally
    //   59	86	143	finally
    //   86	114	143	finally
    //   114	140	143	finally
  }
  
  public void e()
  {
    try
    {
      if ((this.f) && (com.baidu.location.indoor.a.b.a(this.g) != null)) {
        com.baidu.location.indoor.a.b.a(this.g).c();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean f()
  {
    return this.q;
  }
  
  public boolean g()
  {
    return (this.q) && (this.r);
  }
  
  public String h()
  {
    return this.y;
  }
  
  public String i()
  {
    return this.z;
  }
  
  class a
  {
    private HashMap<String, Integer> b = new HashMap();
    private double c = 0.0D;
    
    public a(com.baidu.location.f.e parame)
    {
      if (parame.a != null)
      {
        this$1 = parame.a.iterator();
        while (d.this.hasNext())
        {
          parame = (ScanResult)d.this.next();
          int i = Math.abs(parame.level);
          this.b.put(parame.BSSID, Integer.valueOf(i));
          double d = this.c;
          this.c = ((100 - i) * (100 - i) + d);
        }
        this.c = Math.sqrt(this.c + 1.0D);
      }
    }
    
    double a(a parama)
    {
      Iterator localIterator = this.b.keySet().iterator();
      double d = 0.0D;
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        int i = ((Integer)this.b.get(localObject)).intValue();
        localObject = (Integer)parama.a().get(localObject);
        if (localObject != null) {
          d = (100 - ((Integer)localObject).intValue()) * (100 - i) + d;
        }
      }
      return d / (this.c * parama.b());
    }
    
    public HashMap<String, Integer> a()
    {
      return this.b;
    }
    
    public double b()
    {
      return this.c;
    }
  }
  
  class b
  {
    double a;
    double b;
    long c;
    int d;
    List<Float> e;
    boolean f;
    String g;
    String h;
    String i;
    boolean j = false;
    
    public b(double paramDouble, long paramLong, int paramInt, List<Float> paramList, String paramString1, String paramString2, String paramString3)
    {
      this.a = ???;
      this.b = ???;
      this.c = ???;
      this.d = paramList;
      this.f = false;
      this.e = new ArrayList(paramString1);
      this.g = paramString2;
      this.h = paramString3;
      String str1;
      this.i = str1;
    }
    
    public double a()
    {
      return this.a;
    }
    
    public int a(b paramb)
    {
      return Math.abs(this.d - paramb.c());
    }
    
    public void a(double paramDouble)
    {
      this.a = paramDouble;
    }
    
    public void a(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public double b()
    {
      return this.b;
    }
    
    public float b(b paramb)
    {
      float[] arrayOfFloat = new float[1];
      Location.distanceBetween(this.b, this.a, paramb.b, paramb.a, arrayOfFloat);
      return arrayOfFloat[0];
    }
    
    public void b(double paramDouble)
    {
      this.b = paramDouble;
    }
    
    public int c()
    {
      return this.d;
    }
    
    public boolean c(b paramb)
    {
      int m = a(paramb);
      if (m == 0) {}
      while (b(paramb) / m > 1.0D + 0.5D * Math.pow(1.2D, 1 - m)) {
        return false;
      }
      return true;
    }
    
    public boolean d()
    {
      return this.f;
    }
    
    public Double e()
    {
      if (this.g == null) {
        return null;
      }
      return Double.valueOf(Double.parseDouble(this.g));
    }
    
    public Double f()
    {
      if (this.h == null) {
        return null;
      }
      return Double.valueOf(Double.parseDouble(this.h));
    }
    
    public Double g()
    {
      if (this.i == null) {
        return null;
      }
      return Double.valueOf(Double.parseDouble(this.i));
    }
  }
  
  class c
  {
    private d.b[] b;
    private int c;
    private int d;
    
    public c()
    {
      this(5);
    }
    
    public c(int paramInt)
    {
      this.b = new d.b[paramInt + 1];
      this.c = 0;
      this.d = 0;
    }
    
    public d.b a()
    {
      return this.b[((this.d - 1 + this.b.length) % this.b.length)];
    }
    
    public d.b a(int paramInt)
    {
      return this.b[((this.d - 1 - paramInt + this.b.length) % this.b.length)];
    }
    
    public void a(d.b paramb)
    {
      if (this.c != this.d)
      {
        d.b localb = a();
        if (localb.c() == paramb.c())
        {
          localb.a((localb.a() + paramb.a()) / 2.0D);
          localb.b((localb.b() + paramb.b()) / 2.0D);
          return;
        }
      }
      if (b()) {
        d();
      }
      b(paramb);
    }
    
    public boolean b()
    {
      return (this.d + 1) % this.b.length == this.c;
    }
    
    public boolean b(d.b paramb)
    {
      if (b()) {
        return false;
      }
      this.b[this.d] = paramb;
      this.d = ((this.d + 1) % this.b.length);
      return true;
    }
    
    public boolean c()
    {
      return this.d == this.c;
    }
    
    public boolean c(d.b paramb)
    {
      boolean bool2 = false;
      boolean bool1;
      if ((d.g(d.this)) && (d.h(d.this))) {
        bool1 = true;
      }
      do
      {
        return bool1;
        if (c()) {
          return true;
        }
        if (paramb.c(a())) {
          return true;
        }
        bool1 = bool2;
      } while (a().d());
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= e()) {
          break;
        }
        d.b localb = a(i);
        if ((localb.d()) && (localb.c(paramb))) {
          return true;
        }
        i += 1;
      }
    }
    
    public boolean d()
    {
      if (this.c == this.d) {
        return false;
      }
      this.c = ((this.c + 1) % this.b.length);
      return true;
    }
    
    public int e()
    {
      return (this.d - this.c + this.b.length) % this.b.length;
    }
    
    public String toString()
    {
      int j = 0;
      String str = "";
      int i = 0;
      d.b localb;
      while (i < e())
      {
        localb = this.b[((this.c + i) % this.b.length)];
        str = str + localb.a + ",";
        i += 1;
      }
      str = str + "  ";
      i = 0;
      while (i < e())
      {
        localb = this.b[((this.c + i) % this.b.length)];
        str = str + localb.b + ",";
        i += 1;
      }
      str = str + "  ";
      i = j;
      while (i < e())
      {
        localb = this.b[((this.c + i) % this.b.length)];
        str = str + localb.d + ",";
        i += 1;
      }
      return str + "  ";
    }
  }
  
  class d
  {
    private d.b[] b;
    private int c;
    private int d;
    
    public d()
    {
      this(5);
    }
    
    public d(int paramInt)
    {
      this.b = new d.b[paramInt + 1];
      this.c = 0;
      this.d = 0;
    }
    
    public d.b a()
    {
      return this.b[((this.d - 1 + this.b.length) % this.b.length)];
    }
    
    public boolean a(d.b paramb)
    {
      if ((paramb.g() == null) || (paramb.f() == null)) {}
      double d1;
      double d3;
      double d2;
      do
      {
        do
        {
          return false;
          d1 = paramb.g().doubleValue();
        } while ((paramb.f().doubleValue() > 1.0D) && (d1 > 8.0D));
        if (d()) {
          return true;
        }
        d.b localb = a();
        d3 = localb.e().doubleValue();
        double d4 = paramb.e().doubleValue();
        d1 = g.a(localb.e);
        d2 = g.a(paramb.e);
        d3 = g.a(d3, d4);
        d1 = g.b(d1, d2);
        d2 = Math.abs(Math.abs(d3) - Math.abs(d1));
        if (Math.abs(d1) > 15.0D)
        {
          d.h.b(d.O(d.this)).g();
          return false;
        }
      } while ((Math.abs(d3) > Math.abs(d1) * 2.0D) || (d2 > 20.0D));
      return true;
    }
    
    public float b()
    {
      if (f() < 4) {
        return 0.0F;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 2;
      if (i <= f())
      {
        d.b localb1 = this.b[((this.d - i + 1 + this.b.length) % this.b.length)];
        d.b localb2 = this.b[((this.d - i + this.b.length) % this.b.length)];
        double d2 = g.b(localb2.b, localb2.a, localb1.b, localb1.a);
        double d1 = 90.0D - Math.toDegrees(Math.atan(localb1.e().doubleValue()));
        if (Math.abs(g.b(d1, d2)) < Math.abs(g.b(d1 + 180.0D, d2))) {}
        for (;;)
        {
          localArrayList.add(Float.valueOf((float)g.b(g.a(localb1.e), d1)));
          i += 1;
          break;
          d1 += 180.0D;
        }
      }
      return (float)g.a(localArrayList);
    }
    
    public boolean b(d.b paramb)
    {
      if (c()) {
        e();
      }
      return c(paramb);
    }
    
    public boolean c()
    {
      return (this.d + 1) % this.b.length == this.c;
    }
    
    public boolean c(d.b paramb)
    {
      if (c()) {
        return false;
      }
      this.b[this.d] = paramb;
      this.d = ((this.d + 1) % this.b.length);
      return true;
    }
    
    public boolean d()
    {
      return this.d == this.c;
    }
    
    public boolean e()
    {
      if (this.c == this.d) {
        return false;
      }
      this.c = ((this.c + 1) % this.b.length);
      return true;
    }
    
    public int f()
    {
      return (this.d - this.c + this.b.length) % this.b.length;
    }
    
    public void g()
    {
      this.d = 0;
      this.c = 0;
    }
    
    public String toString()
    {
      int j = 0;
      String str = "";
      int i = 0;
      d.b localb;
      while (i < f())
      {
        localb = this.b[((this.c + i) % this.b.length)];
        str = str + localb.a + ",";
        i += 1;
      }
      str = str + "  ";
      i = 0;
      while (i < f())
      {
        localb = this.b[((this.c + i) % this.b.length)];
        str = str + localb.b + ",";
        i += 1;
      }
      str = str + "  ";
      i = j;
      while (i < f())
      {
        localb = this.b[((this.c + i) % this.b.length)];
        str = str + localb.d + ",";
        i += 1;
      }
      return str + "  ";
    }
  }
  
  public class e
    extends Handler
  {
    public e() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (!com.baidu.location.f.isServing) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        super.dispatchMessage(paramMessage);
        return;
      case 41: 
        d.u(d.this);
        return;
      case 21: 
        d.a(d.this, paramMessage);
        return;
      case 801: 
        paramMessage = (BDLocation)paramMessage.obj;
        d.a(d.this, paramMessage);
        return;
      }
      d.b(d.this, paramMessage);
    }
  }
  
  class f
    extends Thread
  {
    private volatile boolean b = true;
    private long c = 0L;
    
    f() {}
    
    public void run()
    {
      if (this.b)
      {
        if (((!d.v(d.this)) || (System.currentTimeMillis() - this.c <= d.w(d.this))) && (((System.currentTimeMillis() - this.c <= 10000L) || (d.b(d.this).c() != 1)) && (System.currentTimeMillis() - this.c <= 17500L))) {
          break label184;
        }
        com.baidu.location.f.f.a().i();
        d.b(d.this).e();
        this.c = System.currentTimeMillis();
        d.c(d.this, false);
      }
      for (;;)
      {
        if (System.currentTimeMillis() - d.x(d.this) > 22000L) {
          d.this.c.sendEmptyMessage(41);
        }
        if (System.currentTimeMillis() - d.y(d.this) > 60000L) {
          d.a().d();
        }
        try
        {
          Thread.sleep(2000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          this.b = false;
        }
        return;
        label184:
        if (d.b(d.this).c() != 1) {
          com.baidu.location.a.a.a().d();
        }
      }
    }
  }
  
  private class g
  {
    public int a;
    public double b;
    public double c;
    public int d = 1;
    
    public g(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.a = paramInt;
      this.b = paramDouble1;
      this.c = paramDouble2;
    }
    
    public String toString()
    {
      return String.format("%d:%.2f", new Object[] { Integer.valueOf(this.d), Double.valueOf(this.c) });
    }
  }
  
  class h
    extends com.baidu.location.h.e
  {
    public float a = 0.0F;
    private boolean c = false;
    private boolean d = false;
    private String e = null;
    private String f = null;
    private List<Float> p = new ArrayList();
    private d.a q = null;
    private d.c r = null;
    private d.d s = null;
    private d.d t = null;
    private int u = -1;
    private long v = 0L;
    private long w = 0L;
    
    public h()
    {
      this.k = new HashMap();
    }
    
    private boolean a(com.baidu.location.f.e parame, double paramDouble)
    {
      parame = new d.a(d.this, parame);
      if ((this.q != null) && (parame.a(this.q) > paramDouble)) {
        return false;
      }
      this.q = parame;
      return true;
    }
    
    public void a()
    {
      this.h = com.baidu.location.h.g.e();
      if ((d.k(d.this) == null) || (d.z(d.this) == null) || (!d.k(d.this).equals(d.z(d.this).a()))) {
        this.e = ("&nd_idf=1&indoor_polygon=1" + this.e);
      }
      this.i = 1;
      String str = Jni.encodeTp4(this.e);
      this.e = null;
      this.k.put("bloc", str);
      this.v = System.currentTimeMillis();
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      for (;;)
      {
        try
        {
          localObject1 = this.j;
          if (!d.A(d.this))
          {
            this.c = false;
            return;
          }
          localObject1 = new BDLocation((String)localObject1);
          if ((localObject1 != null) && (((BDLocation)localObject1).getLocType() == 161) && (((BDLocation)localObject1).getBuildingID() != null)) {
            d.b(d.this, new BDLocation((BDLocation)localObject1));
          }
          d.d(d.this, false);
          localObject2 = ((BDLocation)localObject1).getIndoorLocationSurpportBuidlingName();
          if (localObject2 == null) {
            continue;
          }
          if (!d.B(d.this).a((String)localObject2)) {
            d.B(d.this).a((String)localObject2, null);
          }
          if (d.C(d.this) != null) {
            d.C(d.this).a(new c.a()
            {
              public void a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
              {
                if (paramAnonymousBoolean) {
                  d.a(d.this, "&ibuuid=" + paramAnonymousString1 + "&ibname=" + paramAnonymousString2 + "&ibfls=" + paramAnonymousString3);
                }
              }
            });
          }
          com.baidu.location.a.i.a().c(true);
          com.baidu.location.a.i.a().d();
          if (d.b(d.this).d() == -1) {
            d.this.b = false;
          }
          if (((BDLocation)localObject1).getBuildingName() != null) {
            d.b(d.this, ((BDLocation)localObject1).getBuildingName());
          }
          if (((BDLocation)localObject1).getFloor() != null)
          {
            d.a(d.this, System.currentTimeMillis());
            this.w = System.currentTimeMillis();
            i = (int)(this.w - this.v);
            if (i <= 10000) {
              continue;
            }
            d.a(d.this, 0);
            if (!((BDLocation)localObject1).getFloor().contains("-a")) {
              continue;
            }
            d.e(d.this, true);
            ((BDLocation)localObject1).setFloor(localObject1.getFloor().split("-")[0]);
            d.D(d.this).add(((BDLocation)localObject1).getFloor());
          }
          if ((!d.this.a) || (!d.this.b)) {
            continue;
          }
          localObject2 = new d.b(d.this, ((BDLocation)localObject1).getLongitude(), ((BDLocation)localObject1).getLatitude(), System.currentTimeMillis(), d.b(d.this).d(), this.p, ((BDLocation)localObject1).getRetFields("gradient"), ((BDLocation)localObject1).getRetFields("mean_error"), ((BDLocation)localObject1).getRetFields("confidence"));
          if (!this.r.c((d.b)localObject2)) {
            continue;
          }
          ((d.b)localObject2).a(true);
          Message localMessage = d.this.c.obtainMessage(21);
          localMessage.obj = localObject1;
          localMessage.sendToTarget();
          if (((BDLocation)localObject1).getFloor() != null) {
            this.r.a((d.b)localObject2);
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          int i;
          continue;
        }
        if (this.k != null) {
          this.k.clear();
        }
        this.c = false;
        return;
        Log.w(com.baidu.location.h.a.a, "inbldg is null");
        continue;
        if (i < 3000)
        {
          d.a(d.this, 2);
        }
        else
        {
          d.a(d.this, 1);
          continue;
          d.e(d.this, false);
          continue;
          d.E(d.this);
          continue;
          localObject2 = d.this.c.obtainMessage(21);
          ((Message)localObject2).obj = localObject1;
          ((Message)localObject2).sendToTarget();
          continue;
          d.F(d.this);
          d.a(d.this, 0);
          d.d(d.this, true);
          this.c = false;
          if (d.G(d.this) <= 40) {
            continue;
          }
          d.this.d();
        }
      }
    }
    
    public void b()
    {
      if (this.c) {
        this.d = true;
      }
      label605:
      for (;;)
      {
        return;
        StringBuffer localStringBuffer = new StringBuffer(1024);
        String str1 = com.baidu.location.f.b.a().f().i();
        String str2 = com.baidu.location.f.d.a().i();
        d.a(d.this, 0.5D);
        com.baidu.location.f.e locale = com.baidu.location.f.f.a().r();
        Object localObject = d.a(d.this, locale);
        if (localObject == null) {
          localObject = locale.a(32);
        }
        for (;;)
        {
          if ((localObject == null) || (((String)localObject).length() < 10) || ((this.f != null) && (this.f.equals(localObject)))) {
            break label605;
          }
          this.f = ((String)localObject);
          int j = d.b(d.this).d();
          if ((this.u < 0) || (j - this.u > d.H(d.this))) {}
          for (int i = 1;; i = 0)
          {
            if ((d.this.a) && (d.this.b)) {
              if ((d.o(d.this)) && (!a(locale, 0.8D)) && (i == 0)) {
                break;
              }
            }
            while ((!d.this.a) || (!d.o(d.this)) || (a(locale, 0.7D)) || (i != 0))
            {
              this.u = j;
              this.c = true;
              localStringBuffer.append(str1);
              if (str2 != null) {
                localStringBuffer.append(str2);
              }
              localStringBuffer.append("&coor=gcj02");
              localStringBuffer.append("&lt=1");
              localStringBuffer.append((String)localObject);
              if ((d.I(d.this)) && (com.baidu.location.indoor.a.b.a(d.J(d.this)) != null))
              {
                localObject = com.baidu.location.indoor.a.b.a(d.J(d.this)).a();
                if (localObject != null)
                {
                  localStringBuffer.append(String.format("&mag_x=%.6f", new Object[] { Double.valueOf(((BDLocation)localObject).getLongitude()) }));
                  localStringBuffer.append(String.format("&mag_y=%.6f", new Object[] { Double.valueOf(((BDLocation)localObject).getLatitude()) }));
                  localStringBuffer.append(String.format("&mag_r=%.1f", new Object[] { Float.valueOf(((BDLocation)localObject).getRadius()) }));
                  localStringBuffer.append("&mag_t=" + ((BDLocation)localObject).getTime());
                }
              }
              i = d.q(d.this).size();
              localStringBuffer.append(d.b(d.this, i));
              d.c(d.this, i);
              d.K(d.this);
              localStringBuffer.append("&drsi=" + d.L(d.this));
              localStringBuffer.append("&idpfv=1");
              d.M(d.this);
              if (d.N(d.this) != null)
              {
                localStringBuffer.append(d.N(d.this));
                d.a(d.this, null);
              }
              localStringBuffer.append(com.baidu.location.h.b.a().a(true));
              this.e = localStringBuffer.toString();
              c(com.baidu.location.h.g.f);
              return;
            }
            return;
          }
        }
      }
    }
    
    /* Error */
    public void c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 43	com/baidu/location/indoor/d$h:c	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 45	com/baidu/location/indoor/d$h:d	Z
      //   18: ifeq -7 -> 11
      //   21: aload_0
      //   22: iconst_0
      //   23: putfield 45	com/baidu/location/indoor/d$h:d	Z
      //   26: aload_0
      //   27: invokevirtual 507	com/baidu/location/indoor/d$h:b	()V
      //   30: goto -19 -> 11
      //   33: astore_2
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_2
      //   37: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	38	0	this	h
      //   6	2	1	bool	boolean
      //   33	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	33	finally
      //   14	30	33	finally
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */