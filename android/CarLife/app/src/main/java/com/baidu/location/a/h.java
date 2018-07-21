package com.baidu.location.a;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.d.j;
import com.baidu.location.d.j.b;
import com.baidu.location.d.k;
import com.baidu.location.e.d.a;
import com.baidu.location.e.d.b;
import com.baidu.location.f.c;
import java.util.List;
import java.util.Locale;

public class h
  extends f
{
  public static boolean h = false;
  private static h i = null;
  private double A;
  private boolean B = false;
  private long C = 0L;
  private long D = 0L;
  private a E = null;
  private boolean F = false;
  private boolean G = false;
  private boolean H = true;
  private boolean I = false;
  private boolean J = false;
  private b K = null;
  private boolean L = false;
  private int M = 0;
  private long N = 0L;
  private boolean O = true;
  final int e = 1000;
  public f.b f = null;
  public final Handler g = new f.a(this);
  private boolean j = true;
  private String k = null;
  private BDLocation l = null;
  private BDLocation m = null;
  private com.baidu.location.f.e n = null;
  private com.baidu.location.f.a o = null;
  private com.baidu.location.f.e p = null;
  private com.baidu.location.f.a q = null;
  private boolean r = true;
  private volatile boolean s = false;
  private boolean t = false;
  private long u = 0L;
  private long v = 0L;
  private Address w = null;
  private String x = null;
  private List<Poi> y = null;
  private double z;
  
  private boolean a(com.baidu.location.f.a parama)
  {
    boolean bool2 = true;
    this.b = com.baidu.location.f.b.a().f();
    boolean bool1;
    if (this.b == parama) {
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
        } while (this.b == null);
        bool1 = bool2;
      } while (parama == null);
      bool1 = bool2;
    } while (!parama.a(this.b));
    return false;
  }
  
  private boolean a(com.baidu.location.f.e parame)
  {
    boolean bool2 = true;
    this.a = com.baidu.location.f.f.a().q();
    boolean bool1;
    if (parame == this.a) {
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
        } while (this.a == null);
        bool1 = bool2;
      } while (parame == null);
      bool1 = bool2;
    } while (!parame.c(this.a));
    return false;
  }
  
  private boolean b(com.baidu.location.f.a parama)
  {
    boolean bool2 = true;
    boolean bool1;
    if (parama == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.q == null);
      bool1 = bool2;
    } while (!parama.a(this.q));
    return false;
  }
  
  public static h c()
  {
    try
    {
      if (i == null) {
        i = new h();
      }
      h localh = i;
      return localh;
    }
    finally {}
  }
  
  private void c(Message paramMessage)
  {
    com.baidu.location.d.f.a().a("request location!");
    if (paramMessage.getData().getBoolean("isWaitingLocTag", false)) {
      k.a().b();
    }
    if (com.baidu.location.indoor.d.a().g()) {}
    do
    {
      return;
      int i1 = a.a().d(paramMessage);
      i.a().d();
      switch (i1)
      {
      default: 
        throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[] { Integer.valueOf(i1) }));
      }
    } while (!com.baidu.location.f.d.a().m());
    e(paramMessage);
    return;
    d(paramMessage);
    return;
    g(paramMessage);
  }
  
  private void d(Message paramMessage)
  {
    if (com.baidu.location.f.d.a().m())
    {
      com.baidu.location.d.f.a().a("gps is valid");
      g(paramMessage);
      i.a().b();
      j.b().a(j.b.c);
      return;
    }
    g(paramMessage);
    i.a().b();
  }
  
  private void e(Message paramMessage)
  {
    paramMessage = new BDLocation(com.baidu.location.f.d.a().j());
    if ((com.baidu.location.h.g.g.equals("all")) || (com.baidu.location.h.g.h) || (com.baidu.location.h.g.i))
    {
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.A, this.z, paramMessage.getLatitude(), paramMessage.getLongitude(), arrayOfFloat);
      if (arrayOfFloat[0] >= 100.0F) {
        break label135;
      }
      if (this.w != null) {
        paramMessage.setAddr(this.w);
      }
      if (this.x != null) {
        paramMessage.setLocationDescribe(this.x);
      }
      if (this.y != null) {
        paramMessage.setPoiList(this.y);
      }
    }
    for (;;)
    {
      this.l = paramMessage;
      this.m = null;
      a.a().a(paramMessage);
      return;
      label135:
      this.B = true;
      g(null);
    }
  }
  
  private void f(Message paramMessage)
  {
    if (com.baidu.location.f.f.a().g())
    {
      this.t = true;
      if (this.K == null) {
        this.K = new b(null);
      }
      if ((this.L) && (this.K != null)) {
        this.g.removeCallbacks(this.K);
      }
      this.g.postDelayed(this.K, 3500L);
      this.L = true;
      return;
    }
    h(paramMessage);
  }
  
  private void g(Message paramMessage)
  {
    this.M = 0;
    if (this.r)
    {
      this.M = 1;
      this.D = SystemClock.uptimeMillis();
      if (com.baidu.location.f.f.a().k())
      {
        f(paramMessage);
        return;
      }
      h(paramMessage);
      return;
    }
    if (com.baidu.location.f.d.a().d()) {
      this.M = 2;
    }
    if (this.M == 2) {
      if (com.baidu.location.f.f.a().a(60000L)) {
        f(paramMessage);
      }
    }
    for (;;)
    {
      this.D = SystemClock.uptimeMillis();
      return;
      h(paramMessage);
      continue;
      f(paramMessage);
    }
  }
  
  private void h(Message paramMessage)
  {
    long l2 = 0L;
    long l1 = System.currentTimeMillis();
    long l3 = this.u;
    if ((this.s) && (l1 - l3 <= 12000L)) {
      return;
    }
    if ((System.currentTimeMillis() - this.u > 0L) && (System.currentTimeMillis() - this.u < 1000L))
    {
      if (this.l != null) {
        a.a().a(this.l);
      }
      o();
      return;
    }
    if (this.D > 0L)
    {
      com.baidu.location.d.g.a().b().a(this.D);
      label104:
      this.s = true;
      this.j = a(this.o);
      boolean bool = a(this.n);
      if (!this.r)
      {
        int i1 = j.b().g();
        if ((j.b().d()) && (System.currentTimeMillis() - this.u >= i1 * 1000))
        {
          if (!j.b().a(com.baidu.location.f.f.a().p().a)) {
            break label386;
          }
          this.B = true;
        }
      }
      label195:
      if ((bool) || (this.j) || (this.l == null) || (this.B)) {
        break label396;
      }
      if ((this.m != null) && (System.currentTimeMillis() - this.v > 30000L))
      {
        this.l = this.m;
        this.m = null;
      }
      if (i.a().g()) {
        this.l.setDirection(i.a().i());
      }
      l1 = l2;
      if (this.l.getLocType() == 62)
      {
        l1 = System.currentTimeMillis() - this.N;
        if (l1 > 0L) {
          break label925;
        }
        l1 = l2;
      }
    }
    label386:
    label396:
    label532:
    label875:
    label925:
    for (;;)
    {
      if ((this.l.getLocType() == 61) || (this.l.getLocType() == 161) || ((this.l.getLocType() == 62) && (l1 < 15000L)))
      {
        a.a().a(this.l);
        o();
        return;
        com.baidu.location.d.g.a().b().a(SystemClock.uptimeMillis());
        break label104;
        this.u = System.currentTimeMillis();
        break label195;
      }
      this.u = System.currentTimeMillis();
      Object localObject = a(null);
      this.J = false;
      paramMessage = (Message)localObject;
      if (localObject == null)
      {
        this.J = true;
        this.N = System.currentTimeMillis();
        paramMessage = n();
        l1 = System.currentTimeMillis();
        if (l1 - this.C > 60000L)
        {
          this.C = l1;
          com.baidu.location.d.g.a().a("Criteria" + paramMessage[0]);
        }
        localObject = com.baidu.location.f.f.a().m();
        if (localObject == null) {
          break label875;
        }
        paramMessage = (String)localObject + b() + paramMessage[0];
        localObject = paramMessage;
        if (this.b != null)
        {
          localObject = paramMessage;
          if (this.b.i() != null) {
            localObject = this.b.i() + paramMessage;
          }
        }
        String str = com.baidu.location.h.b.a().a(true);
        paramMessage = (Message)localObject;
        if (str != null) {
          paramMessage = (String)localObject + str;
        }
      }
      localObject = paramMessage;
      if (this.M > 0) {
        localObject = paramMessage + "&mft=" + this.M;
      }
      paramMessage = (Message)localObject;
      if (this.k != null)
      {
        paramMessage = (String)localObject + this.k;
        this.k = null;
      }
      com.baidu.location.d.g.a().b().b(SystemClock.uptimeMillis());
      com.baidu.location.d.f.a().a("netreqstr = " + paramMessage);
      this.f.a(paramMessage);
      this.o = this.b;
      this.n = this.a;
      if (this.r) {}
      for (;;)
      {
        if (com.baidu.location.e.d.a().i())
        {
          if (this.E == null) {
            this.E = new a(null);
          }
          l1 = com.baidu.location.e.d.a().a(c.a(com.baidu.location.f.b.a().e()));
          this.g.postDelayed(this.E, l1);
          this.F = true;
        }
        if (this.r == true)
        {
          this.r = false;
          com.baidu.location.b.b.a().b();
        }
        if (this.M <= 0) {
          break;
        }
        if (this.M == 2) {
          com.baidu.location.f.f.a().g();
        }
        this.M = 0;
        return;
        paramMessage = "" + b() + paramMessage[0];
        break label532;
        if (!com.baidu.location.f.d.a().m()) {
          m();
        }
      }
    }
  }
  
  private boolean m()
  {
    com.baidu.location.d.m localm = null;
    boolean bool2 = false;
    double d = Math.random();
    long l2 = SystemClock.uptimeMillis();
    Object localObject = com.baidu.location.f.b.a().f();
    com.baidu.location.f.e locale = com.baidu.location.f.f.a().p();
    if ((locale != null) && (locale.a() > 0)) {}
    for (long l1 = locale.f();; l1 = 0L)
    {
      int i1;
      if ((localObject != null) && (((com.baidu.location.f.a)localObject).e()) && ((locale == null) || (locale.a() == 0)))
      {
        i1 = 1;
        localObject = localm;
        if (com.baidu.location.e.d.a().d())
        {
          localObject = localm;
          if (com.baidu.location.e.d.a().g())
          {
            localObject = localm;
            if (l1 < 60L) {
              if (i1 == 0)
              {
                localObject = localm;
                if (0.0D < d)
                {
                  localObject = localm;
                  if (d >= com.baidu.location.e.d.a().p()) {}
                }
              }
              else
              {
                localObject = com.baidu.location.e.d.a().a(com.baidu.location.f.b.a().f(), com.baidu.location.f.f.a().p(), null, d.b.a, d.a.a);
                if ((!com.baidu.location.h.g.g.equals("all")) || (((BDLocation)localObject).getAddrStr() != null)) {
                  break label431;
                }
              }
            }
          }
        }
      }
      label431:
      for (int i2 = 0;; i2 = 1)
      {
        i1 = i2;
        if (com.baidu.location.h.g.h)
        {
          i1 = i2;
          if (((BDLocation)localObject).getLocationDescribe() == null) {
            i1 = 0;
          }
        }
        i2 = i1;
        if (com.baidu.location.h.g.i)
        {
          i2 = i1;
          if (((BDLocation)localObject).getPoiList() == null) {
            i2 = 0;
          }
        }
        if (i2 == 0) {
          localObject = localm;
        }
        for (;;)
        {
          boolean bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((BDLocation)localObject).getLocType() == 66)
            {
              bool1 = bool2;
              if (this.s)
              {
                localObject = new BDLocation((BDLocation)localObject);
                ((BDLocation)localObject).setLocType(161);
                bool1 = bool2;
                if (this.s)
                {
                  localm = new com.baidu.location.d.m();
                  localm.a(this.D);
                  localm.b(l2);
                  localm.c(l2);
                  localm.d(SystemClock.uptimeMillis());
                  localm.a("ofs");
                  if (this.o != null)
                  {
                    localm.b(this.o.i());
                    localm.b("&offtag=1");
                  }
                  com.baidu.location.d.g.a().a(localm);
                  this.G = true;
                  a.a().a((BDLocation)localObject);
                  this.l = ((BDLocation)localObject);
                  bool1 = true;
                }
              }
            }
          }
          return bool1;
          i1 = 0;
          break;
        }
      }
    }
  }
  
  private String[] n()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "Location failed beacuse we can not get any loc information!";
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("&apl=");
    int i2 = com.baidu.location.h.g.b(com.baidu.location.f.getServiceContext());
    if (i2 == 1) {
      arrayOfString[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
    }
    localStringBuffer.append(i2);
    String str1 = com.baidu.location.h.g.d(com.baidu.location.f.getServiceContext());
    if (str1.contains("0|0|")) {
      arrayOfString[1] = "Location failed beacuse we can not get any loc information without any location permission!";
    }
    localStringBuffer.append(str1);
    int i3;
    int i1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localStringBuffer.append("&loc=");
      i3 = com.baidu.location.h.g.c(com.baidu.location.f.getServiceContext());
      if (i3 == 0)
      {
        arrayOfString[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
        i1 = 1;
        localStringBuffer.append(i3);
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        localStringBuffer.append("&lmd=");
        i3 = com.baidu.location.h.g.c(com.baidu.location.f.getServiceContext());
        if (i3 >= 0) {
          localStringBuffer.append(i3);
        }
      }
      String str2 = com.baidu.location.f.b.a().g();
      String str3 = com.baidu.location.f.f.a().h();
      localStringBuffer.append(str3);
      localStringBuffer.append(str2);
      localStringBuffer.append(com.baidu.location.h.g.e(com.baidu.location.f.getServiceContext()));
      if (i2 == 1) {
        b.a().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
      }
      for (;;)
      {
        arrayOfString[0] = localStringBuffer.toString();
        return arrayOfString;
        if (str1.contains("0|0|")) {
          b.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (i1 != 0) {
          b.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if ((str2 != null) && (str3 != null) && (str2.equals("&sim=1")) && (!str3.equals("&wifio=1"))) {
          b.a().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        } else {
          b.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
        }
      }
      i1 = 0;
      break;
      i1 = 0;
    }
  }
  
  private void o()
  {
    this.s = false;
    this.G = false;
    this.H = false;
    this.B = false;
    p();
    if (this.O)
    {
      this.O = false;
      if ((!com.baidu.location.f.d.a().m()) && (com.baidu.location.f.f.a().m() == null)) {
        com.baidu.location.f.f.a().g();
      }
    }
  }
  
  private void p()
  {
    if (this.l != null)
    {
      m.a().e();
      com.baidu.location.c.a.b().b(false);
    }
  }
  
  public Address a(BDLocation paramBDLocation)
  {
    if ((com.baidu.location.h.g.g.equals("all")) || (com.baidu.location.h.g.h) || (com.baidu.location.h.g.i))
    {
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.A, this.z, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), arrayOfFloat);
      if (arrayOfFloat[0] < 100.0F)
      {
        if (this.w != null) {
          return this.w;
        }
      }
      else
      {
        this.x = null;
        this.y = null;
        this.B = true;
        g(null);
      }
    }
    return null;
  }
  
  public void a()
  {
    int i3 = 1;
    if ((this.E != null) && (this.F))
    {
      this.F = false;
      this.g.removeCallbacks(this.E);
    }
    Object localObject2;
    if (com.baidu.location.f.d.a().m())
    {
      localObject1 = new BDLocation(com.baidu.location.f.d.a().j());
      if ((com.baidu.location.h.g.g.equals("all")) || (com.baidu.location.h.g.h) || (com.baidu.location.h.g.i))
      {
        localObject2 = new float[2];
        Location.distanceBetween(this.A, this.z, ((BDLocation)localObject1).getLatitude(), ((BDLocation)localObject1).getLongitude(), (float[])localObject2);
        if (localObject2[0] < 100.0F)
        {
          if (this.w != null) {
            ((BDLocation)localObject1).setAddr(this.w);
          }
          if (this.x != null) {
            ((BDLocation)localObject1).setLocationDescribe(this.x);
          }
          if (this.y != null) {
            ((BDLocation)localObject1).setPoiList(this.y);
          }
        }
      }
      a.a().a((BDLocation)localObject1);
      o();
      return;
    }
    if (this.G)
    {
      o();
      return;
    }
    com.baidu.location.d.g.a().b().c(SystemClock.uptimeMillis());
    if ((com.baidu.location.e.d.a().d()) && (com.baidu.location.e.d.a().f()))
    {
      localObject2 = com.baidu.location.e.d.a().a(com.baidu.location.f.b.a().f(), com.baidu.location.f.f.a().p(), null, d.b.b, d.a.a);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((BDLocation)localObject2).getLocType() == 66) {
          a.a().a((BDLocation)localObject2);
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((BDLocation)localObject1).getLocType() != 67) {}
      }
      else
      {
        if ((!this.j) && (this.l != null)) {
          break label675;
        }
        if (!com.baidu.location.e.a.a().a) {
          break label651;
        }
        localObject1 = com.baidu.location.e.a.a().a(false);
      }
      label467:
      label518:
      label651:
      label675:
      label749:
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((BDLocation)localObject1).getLocType() != 67) {}
        }
        else
        {
          BDLocation localBDLocation = com.baidu.location.c.b.a().a(com.baidu.location.f.b.a().f(), com.baidu.location.f.f.a().p(), true, null);
          localObject2 = localObject1;
          if (localBDLocation != null)
          {
            localObject2 = localObject1;
            if (localBDLocation.getLocType() == 66) {
              localObject2 = localBDLocation;
            }
          }
        }
        int i2;
        int i1;
        if (localObject2 != null)
        {
          a.a().a((BDLocation)localObject2);
          if ((((BDLocation)localObject2).getLocType() == 67) && (!this.J)) {
            b.a().a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
          }
          if ((com.baidu.location.h.g.g.equals("all")) && (((BDLocation)localObject2).getAddrStr() == null))
          {
            i2 = 0;
            i1 = i2;
            if (com.baidu.location.h.g.h)
            {
              i1 = i2;
              if (((BDLocation)localObject2).getLocationDescribe() == null) {
                i1 = 0;
              }
            }
            i2 = i1;
            if (com.baidu.location.h.g.i)
            {
              i2 = i1;
              if (((BDLocation)localObject2).getPoiList() == null) {
                i2 = 0;
              }
            }
            if (i2 == 0) {
              ((BDLocation)localObject2).setLocType(67);
            }
          }
        }
        for (;;)
        {
          com.baidu.location.d.g.a().b().d(SystemClock.uptimeMillis());
          i1 = i3;
          if (com.baidu.location.h.g.g.equals("all"))
          {
            i1 = i3;
            if (localObject2 != null)
            {
              i1 = i3;
              if (((BDLocation)localObject2).getAddrStr() == null) {
                i1 = 0;
              }
            }
          }
          if ((localObject2 != null) && (i1 == 0)) {
            ((BDLocation)localObject2).setLocType(67);
          }
          if ((localObject2 != null) && (((BDLocation)localObject2).getLocType() == 66))
          {
            this.l = ((BDLocation)localObject2);
            com.baidu.location.d.g.a().b().a("ofs");
            if (this.o != null) {
              com.baidu.location.d.g.a().b().b(this.o.i());
            }
            com.baidu.location.d.g.a().d();
          }
          for (;;)
          {
            this.m = null;
            o();
            return;
            if (localObject1 != null) {
              break label749;
            }
            localObject1 = new BDLocation();
            ((BDLocation)localObject1).setLocType(67);
            break;
            a.a().a(this.l);
            localObject2 = localObject1;
            break label518;
            this.l = null;
            com.baidu.location.d.g.a().b().a("off");
            if (this.o != null) {
              com.baidu.location.d.g.a().b().b(this.o.i());
            }
            com.baidu.location.d.g.a().d();
          }
          i2 = 1;
          break label467;
        }
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.E != null) && (this.F))
    {
      this.F = false;
      this.g.removeCallbacks(this.E);
    }
    paramMessage = (BDLocation)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.getLocType() == 167) && (this.J)) {
      paramMessage.setLocType(62);
    }
    b(paramMessage);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    BDLocation localBDLocation2;
    BDLocation localBDLocation1;
    if ((com.baidu.location.e.d.a().d()) && (com.baidu.location.e.d.a().h()))
    {
      localBDLocation2 = com.baidu.location.e.d.a().a(com.baidu.location.f.b.a().f(), com.baidu.location.f.f.a().p(), null, d.b.b, d.a.a);
      if (localBDLocation2 != null)
      {
        localBDLocation1 = localBDLocation2;
        if (localBDLocation2.getLocType() != 67) {}
      }
      else
      {
        localBDLocation1 = localBDLocation2;
        if (paramBoolean1)
        {
          localBDLocation1 = localBDLocation2;
          if (com.baidu.location.e.a.a().a) {
            localBDLocation1 = com.baidu.location.e.a.a().a(false);
          }
        }
      }
    }
    for (;;)
    {
      if ((paramBoolean2) && ((localBDLocation1 == null) || (localBDLocation1.getLocType() != 66)))
      {
        localBDLocation2 = com.baidu.location.c.b.a().a(com.baidu.location.f.b.a().f(), com.baidu.location.f.f.a().p(), true, null);
        if ((localBDLocation2 != null) && (localBDLocation2.getLocType() == 66)) {
          localBDLocation1 = localBDLocation2;
        }
      }
      for (;;)
      {
        if ((localBDLocation1 != null) && (localBDLocation1.getLocType() == 66)) {
          if ((!com.baidu.location.h.g.g.equals("all")) || (localBDLocation1.getAddrStr() != null)) {
            break label280;
          }
        }
        label280:
        for (int i2 = 0;; i2 = 1)
        {
          int i1 = i2;
          if (com.baidu.location.h.g.h)
          {
            i1 = i2;
            if (localBDLocation1.getLocationDescribe() == null) {
              i1 = 0;
            }
          }
          i2 = i1;
          if (com.baidu.location.h.g.i)
          {
            i2 = i1;
            if (localBDLocation1.getPoiList() == null) {
              i2 = 0;
            }
          }
          if ((i2 != 0) || (paramBoolean2)) {
            a.a().a(localBDLocation1);
          }
          return;
          if ((!paramBoolean1) || (!com.baidu.location.e.a.a().a)) {
            break label289;
          }
          localBDLocation1 = com.baidu.location.e.a.a().a(false);
          break;
        }
      }
      label289:
      localBDLocation1 = null;
    }
  }
  
  public void b(Message paramMessage)
  {
    if (!this.I) {
      return;
    }
    c(paramMessage);
  }
  
  public void b(BDLocation paramBDLocation)
  {
    Object localObject2 = null;
    Object localObject1 = new BDLocation(paramBDLocation);
    if ((paramBDLocation != null) && (paramBDLocation.getLocType() == 161)) {
      com.baidu.location.d.d.a().a(paramBDLocation);
    }
    if (paramBDLocation.hasAddr())
    {
      this.w = paramBDLocation.getAddress();
      this.z = paramBDLocation.getLongitude();
      this.A = paramBDLocation.getLatitude();
    }
    if (paramBDLocation.getLocationDescribe() != null)
    {
      this.x = paramBDLocation.getLocationDescribe();
      this.z = paramBDLocation.getLongitude();
      this.A = paramBDLocation.getLatitude();
    }
    if (paramBDLocation.getPoiList() != null)
    {
      this.y = paramBDLocation.getPoiList();
      this.z = paramBDLocation.getLongitude();
      this.A = paramBDLocation.getLatitude();
    }
    if (com.baidu.location.f.d.a().m()) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        paramBDLocation = new BDLocation(com.baidu.location.f.d.a().j());
        if ((com.baidu.location.h.g.g.equals("all")) || (com.baidu.location.h.g.h) || (com.baidu.location.h.g.i))
        {
          localObject1 = new float[2];
          Location.distanceBetween(this.A, this.z, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject1);
          if (localObject1[0] < 100.0F)
          {
            if (this.w != null) {
              paramBDLocation.setAddr(this.w);
            }
            if (this.x != null) {
              paramBDLocation.setLocationDescribe(this.x);
            }
            if (this.y != null) {
              paramBDLocation.setPoiList(this.y);
            }
          }
        }
        a.a().a(paramBDLocation);
        o();
        return;
      }
      if (this.G)
      {
        localObject1 = new float[2];
        if (this.l != null) {
          Location.distanceBetween(this.l.getLatitude(), this.l.getLongitude(), paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject1);
        }
        if (localObject1[0] > 10.0F)
        {
          this.l = paramBDLocation;
          if (!this.H)
          {
            this.H = false;
            a.a().a(paramBDLocation);
          }
        }
        for (;;)
        {
          o();
          return;
          if (paramBDLocation.getUserIndoorState() > -1)
          {
            this.l = paramBDLocation;
            a.a().a(paramBDLocation);
          }
        }
      }
      com.baidu.location.d.g.a().b().c(SystemClock.uptimeMillis());
      if (paramBDLocation.getLocType() == 167) {
        b.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
      }
      label498:
      label512:
      label528:
      Object localObject3;
      label629:
      while (paramBDLocation.getLocType() != 161)
      {
        this.m = null;
        if ((paramBDLocation.getLocType() != 161) || (!"cl".equals(paramBDLocation.getNetworkLocationType())) || (this.l == null) || (this.l.getLocType() != 161) || (!"wf".equals(this.l.getNetworkLocationType())) || (System.currentTimeMillis() - this.v >= 30000L)) {
          break label1176;
        }
        this.m = paramBDLocation;
        i1 = 1;
        if (i1 == 0) {
          break;
        }
        a.a().a(this.l);
        if (!com.baidu.location.h.g.a(paramBDLocation)) {
          break label1160;
        }
        if (i1 == 0) {
          this.l = paramBDLocation;
        }
        i1 = com.baidu.location.h.g.a(c, "ssid\":\"", "\"");
        if ((i1 == Integer.MIN_VALUE) || (this.n == null)) {
          break label1168;
        }
        this.k = this.n.e(i1);
        if (!TextUtils.isEmpty(this.k))
        {
          localObject3 = com.baidu.location.h.b.a().d();
          com.baidu.location.d.g.b(Jni.encode(String.format(Locale.CHINA, "&uptype=ssid%s%s&time=%d", new Object[] { localObject3, this.k, Long.valueOf(System.currentTimeMillis() / 1000L) })));
        }
        if ((com.baidu.location.e.d.a().d()) && (paramBDLocation.getLocType() == 161) && ("cl".equals(paramBDLocation.getNetworkLocationType())) && (b(this.o)))
        {
          com.baidu.location.e.d.a().a(this.o, null, (BDLocation)localObject1, d.b.b, d.a.b);
          this.q = this.o;
        }
        if ((com.baidu.location.e.d.a().d()) && (paramBDLocation.getLocType() == 161) && ("wf".equals(paramBDLocation.getNetworkLocationType())))
        {
          com.baidu.location.e.d.a().a(null, this.n, (BDLocation)localObject1, d.b.b, d.a.b);
          this.p = this.n;
        }
        if (this.o != null) {
          com.baidu.location.e.a.a().a(c, this.o, this.n, (BDLocation)localObject1);
        }
        if (com.baidu.location.f.f.j())
        {
          com.baidu.location.e.d.a().j();
          com.baidu.location.e.d.a().n();
          localObject3 = com.baidu.location.f.f.a().l();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((WifiInfo)localObject3).getBSSID() != null) {
              localObject1 = ((WifiInfo)localObject3).getBSSID().replace(":", "");
            }
          }
          if (localObject1 != null) {
            com.baidu.location.d.e.a().a((String)localObject1);
          }
          if (!TextUtils.isEmpty(paramBDLocation.getCityCode()))
          {
            com.baidu.location.d.a.f.a().c(paramBDLocation.getCityCode());
            com.baidu.location.indoor.a.a.b().a(paramBDLocation.getCityCode());
            com.baidu.location.c.b.a().a(paramBDLocation.getCityCode());
          }
        }
        o();
        return;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        i1 = com.baidu.location.h.g.c(com.baidu.location.f.getServiceContext());
        if ((i1 != 0) && (i1 != 2)) {}
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          b.a().a(161, 1, "NetWork location successful, open gps will be better!");
          break;
        }
        if ((paramBDLocation.getRadius() < 100.0F) || (paramBDLocation.getNetworkLocationType() == null) || (!paramBDLocation.getNetworkLocationType().equals("cl"))) {
          break;
        }
        localObject3 = com.baidu.location.f.f.a().h();
        if ((localObject3 == null) || (((String)localObject3).equals("&wifio=1"))) {
          break;
        }
        b.a().a(161, 2, "NetWork location successful, open wifi will be better!");
        break;
        a.a().a(paramBDLocation);
        this.v = System.currentTimeMillis();
        com.baidu.location.d.g.a().b().d(SystemClock.uptimeMillis());
        if (paramBDLocation.getLocType() == 161)
        {
          com.baidu.location.d.g.a().b().a("ons");
          if (this.o != null) {
            com.baidu.location.d.g.a().b().b(this.o.i());
          }
          if (Math.random() <= 0.5D) {
            break label512;
          }
          com.baidu.location.d.g.a().d();
          break label512;
        }
        com.baidu.location.d.g.a().b().a("onf");
        if (this.o != null) {
          com.baidu.location.d.g.a().b().b(this.o.i());
        }
        com.baidu.location.d.g.a().d();
        break label512;
        label1160:
        this.l = null;
        break label528;
        label1168:
        this.k = null;
        break label629;
        label1176:
        i1 = 0;
        break label498;
      }
    }
  }
  
  public void c(BDLocation paramBDLocation)
  {
    k();
    this.l = paramBDLocation;
    this.l.setIndoorLocMode(false);
  }
  
  public void d()
  {
    this.r = true;
    this.s = false;
    this.I = true;
  }
  
  public void d(BDLocation paramBDLocation)
  {
    this.l = new BDLocation(paramBDLocation);
  }
  
  public void e()
  {
    this.s = false;
    this.t = false;
    this.G = false;
    this.H = true;
    k();
    this.I = false;
  }
  
  public String f()
  {
    return this.x;
  }
  
  public List<Poi> g()
  {
    return this.y;
  }
  
  public void h()
  {
    this.B = true;
    g(null);
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public void j()
  {
    if (this.t)
    {
      if (a(this.n)) {
        com.baidu.location.f.f.a().b();
      }
      for (;;)
      {
        h(null);
        this.t = false;
        return;
        com.baidu.location.f.f.a().a(1000);
      }
    }
    com.baidu.location.b.b.a().d();
  }
  
  public void k()
  {
    this.l = null;
  }
  
  public BDLocation l()
  {
    return this.l;
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      if (h.d(h.this) == true)
      {
        h.c(h.this, false);
        if ((!h.e(h.this)) && (!com.baidu.location.f.d.a().m())) {
          h.this.a(false, false);
        }
      }
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      if (h.a(h.this)) {
        h.a(h.this, false);
      }
      if (h.b(h.this) == true)
      {
        h.b(h.this, false);
        if (!h.a(h.this, h.c(h.this))) {
          break label71;
        }
        com.baidu.location.f.f.a().b();
      }
      for (;;)
      {
        h.a(h.this, null);
        return;
        label71:
        com.baidu.location.f.f.a().a(1000);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */