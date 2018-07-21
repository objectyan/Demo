package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.d.c;
import com.baidu.location.d.j;
import com.baidu.location.d.j.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static a d = null;
  public boolean a = false;
  boolean b = false;
  int c = 0;
  private ArrayList<a> e = null;
  private boolean f = false;
  private BDLocation g = null;
  private BDLocation h = null;
  private BDLocation i = null;
  private BDLocation j = null;
  private boolean k = false;
  private boolean l = false;
  private b m = null;
  
  private a a(Messenger paramMessenger)
  {
    if (this.e == null) {
      return null;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b.equals(paramMessenger)) {
        return locala;
      }
    }
    return null;
  }
  
  public static a a()
  {
    if (d == null) {
      d = new a();
    }
    return d;
  }
  
  private void a(a parama)
  {
    if (parama == null) {
      return;
    }
    if (a(parama.b) != null)
    {
      a.a(parama, 14);
      return;
    }
    this.e.add(parama);
    a.a(parama, 13);
  }
  
  private void h()
  {
    i();
    g();
  }
  
  private void i()
  {
    boolean bool3 = true;
    Object localObject = this.e.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    if (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.c.openGps) {
        bool2 = true;
      }
      if (!locala.c.location_change_notify) {
        break label159;
      }
      bool1 = true;
    }
    label136:
    label141:
    label159:
    for (;;)
    {
      break;
      com.baidu.location.h.g.a = bool1;
      if (this.f != bool2)
      {
        this.f = bool2;
        if ((!com.baidu.location.d.d.f.equals("1")) || (this.a) || (this.f)) {
          break label141;
        }
        localObject = com.baidu.location.f.d.a();
        if (this.f) {
          break label136;
        }
      }
      for (bool1 = bool3;; bool1 = false)
      {
        ((com.baidu.location.f.d)localObject).a(bool1);
        c.a().a(false);
        return;
      }
      com.baidu.location.f.d.a().a(this.f);
      c.a().a(true);
      return;
    }
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    try
    {
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        a.a(locala, paramInt, paramBundle);
        if (locala.d > 4) {
          localIterator.remove();
        }
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  public void a(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null)) {
      return;
    }
    this.a = true;
    com.baidu.location.f.f.a().b();
    com.baidu.location.d.d.a().b();
    a(new a(paramMessage));
    h();
  }
  
  public void a(BDLocation paramBDLocation)
  {
    b(paramBDLocation);
  }
  
  public void a(String paramString)
  {
    c(new BDLocation(paramString));
  }
  
  public void b()
  {
    this.e.clear();
    this.g = null;
    h();
  }
  
  public void b(Message paramMessage)
  {
    paramMessage = a(paramMessage.replyTo);
    if (paramMessage != null) {
      this.e.remove(paramMessage);
    }
    com.baidu.location.b.g.a().c();
    i.a().c();
    h();
  }
  
  public void b(BDLocation paramBDLocation)
  {
    if ((paramBDLocation != null) && ((paramBDLocation.getLocType() == 61) || (paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66)))
    {
      j.b().a(paramBDLocation.getLatitude(), paramBDLocation.getLongitude());
      com.baidu.location.c.b.a().a(paramBDLocation);
    }
    if ((com.baidu.location.indoor.d.a().g()) && (paramBDLocation.getFloor() != null))
    {
      this.i = null;
      this.i = new BDLocation(paramBDLocation);
    }
    boolean bool = h.h;
    if (bool) {
      h.h = false;
    }
    Object localObject;
    if ((com.baidu.location.h.g.V >= 10000) && ((paramBDLocation.getLocType() == 61) || (paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66)))
    {
      if (this.g == null) {
        break label446;
      }
      localObject = new float[1];
      Location.distanceBetween(this.g.getLatitude(), this.g.getLongitude(), paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject);
      if ((localObject[0] > com.baidu.location.h.g.X) || (bool)) {}
    }
    for (;;)
    {
      return;
      this.g = null;
      this.g = new BDLocation(paramBDLocation);
      label446:
      for (;;)
      {
        if (paramBDLocation != null)
        {
          com.baidu.location.d.f.a().b("" + paramBDLocation.getLocType());
          com.baidu.location.d.f.a().a("send location = " + paramBDLocation.getLocType() + " ; " + paramBDLocation.getLatitude() + " ; " + paramBDLocation.getLongitude() + " ; " + paramBDLocation.getRadius() + " ; " + paramBDLocation.getSpeed() + " ; " + paramBDLocation.getDirection());
        }
        if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || (g.a().b())) {
          break label461;
        }
        if (this.h == null)
        {
          this.h = new BDLocation();
          this.h.setLocType(505);
        }
        paramBDLocation = this.e.iterator();
        try
        {
          while (paramBDLocation.hasNext())
          {
            localObject = (a)paramBDLocation.next();
            ((a)localObject).a(this.h);
            if (((a)localObject).d > 4) {
              paramBDLocation.remove();
            }
          }
          this.g = new BDLocation(paramBDLocation);
        }
        catch (Exception paramBDLocation)
        {
          return;
        }
      }
      label461:
      if ((!paramBDLocation.hasAltitude()) && (this.b) && ((paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66)))
      {
        double d1 = com.baidu.location.b.a.a().b(paramBDLocation.getLongitude(), paramBDLocation.getLatitude());
        if (d1 != Double.MAX_VALUE) {
          paramBDLocation.setAltitude(d1);
        }
      }
      if (paramBDLocation.getLocType() == 61) {
        paramBDLocation.setGpsAccuracyStatus(com.baidu.location.b.a.a().a(paramBDLocation));
      }
      localObject = this.e.iterator();
      try
      {
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          locala.a(paramBDLocation);
          if (locala.d > 4) {
            ((Iterator)localObject).remove();
          }
        }
        return;
      }
      catch (Exception paramBDLocation) {}
    }
  }
  
  public void c(BDLocation paramBDLocation)
  {
    Address localAddress = h.c().a(paramBDLocation);
    String str = h.c().f();
    List localList = h.c().g();
    if (localAddress != null) {
      paramBDLocation.setAddr(localAddress);
    }
    if (str != null) {
      paramBDLocation.setLocationDescribe(str);
    }
    if (localList != null) {
      paramBDLocation.setPoiList(localList);
    }
    if ((com.baidu.location.indoor.d.a().g()) && (com.baidu.location.indoor.d.a().h() != null))
    {
      paramBDLocation.setFloor(com.baidu.location.indoor.d.a().h());
      paramBDLocation.setIndoorLocMode(true);
      if (com.baidu.location.indoor.d.a().i() != null) {
        paramBDLocation.setBuildingID(com.baidu.location.indoor.d.a().i());
      }
    }
    com.baidu.location.d.h.a().b();
    com.baidu.location.d.f.a().a("gps notify!");
    h.c().d(paramBDLocation);
    a(paramBDLocation);
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public boolean c(Message paramMessage)
  {
    boolean bool = true;
    a locala = a(paramMessage.replyTo);
    if (locala == null) {
      return false;
    }
    int n = locala.c.scanSpan;
    locala.c.scanSpan = paramMessage.getData().getInt("scanSpan", locala.c.scanSpan);
    com.baidu.location.d.f.a().a("change option = " + locala.c.scanSpan);
    if (locala.c.scanSpan < 1000)
    {
      com.baidu.location.b.g.a().e();
      i.a().c();
      this.a = false;
      j.b().a(j.b.b);
      com.baidu.location.d.h.a().c();
      com.baidu.location.d.f.a().a("scanspan < 1000");
      com.baidu.location.d.f.a().d();
      com.baidu.location.d.d.a().c();
      com.baidu.location.f.f.a().b();
      if ((locala.c.scanSpan <= 999) || (n >= 1000)) {
        break label577;
      }
      if ((locala.c.mIsNeedDeviceDirect) || (locala.c.isNeedAltitude))
      {
        i.a().a(locala.c.mIsNeedDeviceDirect);
        i.a().b(locala.c.isNeedAltitude);
        i.a().b();
      }
      this.b |= locala.c.isNeedAltitude;
    }
    for (;;)
    {
      locala.c.openGps = paramMessage.getData().getBoolean("openGPS", locala.c.openGps);
      String str = paramMessage.getData().getString("coorType");
      LocationClientOption localLocationClientOption = locala.c;
      if ((str != null) && (!str.equals("")))
      {
        label315:
        localLocationClientOption.coorType = str;
        str = paramMessage.getData().getString("addrType");
        localLocationClientOption = locala.c;
        if ((str == null) || (str.equals(""))) {
          break label564;
        }
      }
      for (;;)
      {
        localLocationClientOption.addrType = str;
        if (!com.baidu.location.h.g.g.equals(locala.c.addrType)) {
          h.c().k();
        }
        locala.c.timeOut = paramMessage.getData().getInt("timeOut", locala.c.timeOut);
        locala.c.location_change_notify = paramMessage.getData().getBoolean("location_change_notify", locala.c.location_change_notify);
        locala.c.priority = paramMessage.getData().getInt("priority", locala.c.priority);
        n = paramMessage.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (n < com.baidu.location.h.g.ae) {
          com.baidu.location.h.g.ae = n;
        }
        h();
        return bool;
        com.baidu.location.b.g.a().d();
        j.b().a(j.b.a);
        h.c().a(false, false);
        com.baidu.location.d.f.a().a("request offline location!");
        com.baidu.location.d.f.a().a("scanspan >= 1000");
        com.baidu.location.d.d.a().b();
        this.a = true;
        break;
        str = locala.c.coorType;
        break label315;
        label564:
        str = locala.c.addrType;
      }
      label577:
      bool = false;
    }
  }
  
  public int d(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null)) {}
    do
    {
      return 1;
      paramMessage = a(paramMessage.replyTo);
    } while ((paramMessage == null) || (paramMessage.c == null));
    return paramMessage.c.priority;
  }
  
  public void d()
  {
    if (this.i != null) {
      a(this.i);
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
  }
  
  public String f()
  {
    Object localObject = new StringBuffer(256);
    if (this.e.isEmpty()) {
      return "&prod=" + com.baidu.location.h.b.e + ":" + com.baidu.location.h.b.d;
    }
    a locala = (a)this.e.get(0);
    if (locala.c.prodName != null) {
      ((StringBuffer)localObject).append(locala.c.prodName);
    }
    if (locala.a != null)
    {
      ((StringBuffer)localObject).append(":");
      ((StringBuffer)localObject).append(locala.a);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      return "&prod=" + (String)localObject;
    }
    return null;
  }
  
  public void g()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b();
    }
  }
  
  private class a
  {
    public String a = null;
    public Messenger b = null;
    public LocationClientOption c = new LocationClientOption();
    public int d = 0;
    
    public a(Message paramMessage)
    {
      this.b = paramMessage.replyTo;
      this.a = paramMessage.getData().getString("packName");
      this.c.prodName = paramMessage.getData().getString("prodName");
      com.baidu.location.h.b.a().a(this.c.prodName, this.a);
      this.c.coorType = paramMessage.getData().getString("coorType");
      this.c.addrType = paramMessage.getData().getString("addrType");
      this.c.enableSimulateGps = paramMessage.getData().getBoolean("enableSimulateGps", false);
      if ((com.baidu.location.h.g.l) || (this.c.enableSimulateGps))
      {
        bool1 = true;
        com.baidu.location.h.g.l = bool1;
        if (!com.baidu.location.h.g.g.equals("all")) {
          com.baidu.location.h.g.g = this.c.addrType;
        }
        this.c.openGps = paramMessage.getData().getBoolean("openGPS");
        this.c.scanSpan = paramMessage.getData().getInt("scanSpan");
        this.c.timeOut = paramMessage.getData().getInt("timeOut");
        this.c.priority = paramMessage.getData().getInt("priority");
        this.c.location_change_notify = paramMessage.getData().getBoolean("location_change_notify");
        this.c.mIsNeedDeviceDirect = paramMessage.getData().getBoolean("needDirect", false);
        this.c.isNeedAltitude = paramMessage.getData().getBoolean("isneedaltitude", false);
        if ((!com.baidu.location.h.g.h) && (!paramMessage.getData().getBoolean("isneedaptag", false))) {
          break label556;
        }
        bool1 = true;
        label322:
        com.baidu.location.h.g.h = bool1;
        bool1 = bool2;
        if (!com.baidu.location.h.g.i) {
          if (!paramMessage.getData().getBoolean("isneedaptagd", false)) {
            break label562;
          }
        }
      }
      label556:
      label562:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.baidu.location.h.g.i = bool1;
        com.baidu.location.h.g.Q = paramMessage.getData().getFloat("autoNotifyLocSensitivity", 0.5F);
        int i = paramMessage.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i < com.baidu.location.h.g.ae) {
          com.baidu.location.h.g.ae = i;
        }
        i = paramMessage.getData().getInt("autoNotifyMaxInterval", 0);
        if (i >= com.baidu.location.h.g.V) {
          com.baidu.location.h.g.V = i;
        }
        i = paramMessage.getData().getInt("autoNotifyMinDistance", 0);
        if (i >= com.baidu.location.h.g.X) {
          com.baidu.location.h.g.X = i;
        }
        i = paramMessage.getData().getInt("autoNotifyMinTimeInterval", 0);
        if (i >= com.baidu.location.h.g.W) {
          com.baidu.location.h.g.W = i;
        }
        if (this.c.scanSpan >= 1000) {
          com.baidu.location.b.g.a().b();
        }
        if ((this.c.mIsNeedDeviceDirect) || (this.c.isNeedAltitude))
        {
          i.a().a(this.c.mIsNeedDeviceDirect);
          i.a().b(this.c.isNeedAltitude);
          i.a().b();
        }
        a.this.b |= this.c.isNeedAltitude;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label322;
      }
    }
    
    private void a(int paramInt)
    {
      Message localMessage = Message.obtain(null, paramInt);
      try
      {
        if (this.b != null) {
          this.b.send(localMessage);
        }
        this.d = 0;
        return;
      }
      catch (Exception localException)
      {
        while (!(localException instanceof DeadObjectException)) {}
        this.d += 1;
      }
    }
    
    private void a(int paramInt, Bundle paramBundle)
    {
      Message localMessage = Message.obtain(null, paramInt);
      localMessage.setData(paramBundle);
      try
      {
        if (this.b != null) {
          this.b.send(localMessage);
        }
        this.d = 0;
        return;
      }
      catch (Exception paramBundle)
      {
        if ((paramBundle instanceof DeadObjectException)) {
          this.d += 1;
        }
        paramBundle.printStackTrace();
      }
    }
    
    private void a(int paramInt, String paramString, BDLocation paramBDLocation)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(paramString, paramBDLocation);
      localBundle.setClassLoader(BDLocation.class.getClassLoader());
      paramString = Message.obtain(null, paramInt);
      paramString.setData(localBundle);
      try
      {
        if (this.b != null) {
          this.b.send(paramString);
        }
        this.d = 0;
        return;
      }
      catch (Exception paramString)
      {
        while (!(paramString instanceof DeadObjectException)) {}
        this.d += 1;
      }
    }
    
    public void a()
    {
      a(111);
    }
    
    public void a(BDLocation paramBDLocation)
    {
      a(paramBDLocation, 21);
    }
    
    public void a(BDLocation paramBDLocation, int paramInt)
    {
      paramBDLocation = new BDLocation(paramBDLocation);
      if (com.baidu.location.indoor.d.a().f()) {
        paramBDLocation.setIndoorLocMode(true);
      }
      if ((i.a().h()) && ((paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66))) {
        paramBDLocation.setAltitude(i.a().j());
      }
      double d1;
      double d2;
      double[] arrayOfDouble;
      if ((this.c.coorType != null) && (!this.c.coorType.equals("gcj02")))
      {
        d1 = paramBDLocation.getLongitude();
        d2 = paramBDLocation.getLatitude();
        if ((d1 != Double.MIN_VALUE) && (d2 != Double.MIN_VALUE))
        {
          if (((paramBDLocation.getCoorType() == null) || (!paramBDLocation.getCoorType().equals("gcj02"))) && (paramBDLocation.getCoorType() != null)) {
            break label194;
          }
          arrayOfDouble = Jni.coorEncrypt(d1, d2, this.c.coorType);
          paramBDLocation.setLongitude(arrayOfDouble[0]);
          paramBDLocation.setLatitude(arrayOfDouble[1]);
          paramBDLocation.setCoorType(this.c.coorType);
        }
      }
      for (;;)
      {
        a(paramInt, "locStr", paramBDLocation);
        return;
        label194:
        if ((paramBDLocation.getCoorType() != null) && (paramBDLocation.getCoorType().equals("wgs84")) && (!this.c.coorType.equals("bd09ll")))
        {
          arrayOfDouble = Jni.coorEncrypt(d1, d2, "wgs842mc");
          paramBDLocation.setLongitude(arrayOfDouble[0]);
          paramBDLocation.setLatitude(arrayOfDouble[1]);
          paramBDLocation.setCoorType("wgs84mc");
        }
      }
    }
    
    public void b()
    {
      if (this.c.location_change_notify == true)
      {
        if (com.baidu.location.h.g.b) {
          a(54);
        }
      }
      else {
        return;
      }
      a(55);
    }
  }
  
  private class b
    implements Runnable
  {
    private int b;
    private boolean c;
    
    public void run()
    {
      if (this.c) {
        return;
      }
      this.b += 1;
      a.a(this.a, false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */