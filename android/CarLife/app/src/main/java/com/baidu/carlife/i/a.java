package com.baidu.carlife.i;

import android.os.Bundle;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;

public class a
{
  public static int a = 1;
  private static a b = null;
  private boolean c = false;
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  public static GeoPoint a(double paramDouble1, double paramDouble2)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    Bundle localBundle = JNITools.GCJ2WGS(paramDouble1, paramDouble2);
    if (localBundle == null) {
      return localGeoPoint;
    }
    int i = (int)(localBundle.getDouble("LLx") * 100000.0D);
    localGeoPoint.setLatitudeE6((int)(localBundle.getDouble("LLy") * 100000.0D));
    localGeoPoint.setLongitudeE6(i);
    return localGeoPoint;
  }
  
  public static void a(a parama)
  {
    if (a == 2)
    {
      b(parama);
      return;
    }
    c(parama);
  }
  
  public static void a(LocationManager.LocData paramLocData)
  {
    LocationManager.getInstance().notifiyLocation(paramLocData);
  }
  
  public static void a(LocData paramLocData1, LocData paramLocData2)
  {
    BaiduNaviSDKManager.getInstance().updateWGS84Location(paramLocData1, paramLocData2);
  }
  
  private static void b(a parama)
  {
    Object localObject2;
    try
    {
      localObject2 = a(parama.b / 1000000.0D, parama.a / 1000000.0D);
      if (!((GeoPoint)localObject2).isValid()) {
        return;
      }
    }
    catch (Exception parama)
    {
      return;
    }
    Object localObject1;
    if ((BaiduNaviSDKManager.getInstance().isCruiseBegin()) || (BaiduNaviSDKManager.getInstance().isNaviBegin()) || (BCruiser.getInstance().isCruiseBegin()))
    {
      localObject1 = new LocData();
      ((LocData)localObject1).locType = 0;
      ((LocData)localObject1).latitude = (((GeoPoint)localObject2).getLatitudeE6() / 100000.0D);
      ((LocData)localObject1).longitude = (((GeoPoint)localObject2).getLongitudeE6() / 100000.0D);
      ((LocData)localObject1).speed = (parama.c / 100.0F);
      ((LocData)localObject1).accuracy = Math.min(2000.0F, parama.h);
      ((LocData)localObject1).direction = (parama.d / 10.0F);
      if (parama.f == 0)
      {
        ((LocData)localObject1).satellitesNum = 5;
        ((LocData)localObject1).altitude = (parama.e / 10.0F);
        ((LocData)localObject1).time = parama.g;
        localObject2 = ((LocData)localObject1).clone();
        ((LocData)localObject2).latitude = (parama.a / 1000000.0D);
        ((LocData)localObject2).longitude = (parama.b / 1000000.0D);
        a((LocData)localObject1, (LocData)localObject2);
      }
    }
    else
    {
      localObject1 = new LocationManager.LocData();
      ((LocationManager.LocData)localObject1).type = 61;
      ((LocationManager.LocData)localObject1).latitude = (parama.a / 1000000.0D);
      ((LocationManager.LocData)localObject1).longitude = (parama.b / 1000000.0D);
      ((LocationManager.LocData)localObject1).speed = (parama.c / 100.0F);
      ((LocationManager.LocData)localObject1).accuracy = Math.min(2000.0F, parama.h);
      ((LocationManager.LocData)localObject1).direction = (parama.d / 10.0F);
      if (parama.f != 0) {
        break label322;
      }
    }
    label322:
    for (((LocationManager.LocData)localObject1).satellitesNum = 5;; ((LocationManager.LocData)localObject1).satellitesNum = parama.f)
    {
      ((LocationManager.LocData)localObject1).altitude = (parama.e / 10.0F);
      a((LocationManager.LocData)localObject1);
      return;
      ((LocData)localObject1).satellitesNum = parama.f;
      break;
    }
  }
  
  private static void c(a parama)
  {
    GeoPoint localGeoPoint;
    try
    {
      localGeoPoint = CoordinateTransformUtil.transferWGS84ToGCJ02(parama.b / 1000000.0D, parama.a / 1000000.0D);
      if (!localGeoPoint.isValid()) {
        return;
      }
    }
    catch (Exception parama)
    {
      return;
    }
    Object localObject;
    if ((BaiduNaviSDKManager.getInstance().isCruiseBegin()) || (BaiduNaviSDKManager.getInstance().isNaviBegin()) || (BCruiser.getInstance().isCruiseBegin()))
    {
      localObject = new LocData();
      ((LocData)localObject).locType = 0;
      ((LocData)localObject).latitude = (localGeoPoint.getLatitudeE6() / 100000.0D);
      ((LocData)localObject).longitude = (localGeoPoint.getLongitudeE6() / 100000.0D);
      ((LocData)localObject).speed = (parama.c / 100.0F);
      ((LocData)localObject).accuracy = Math.min(2000.0F, parama.h);
      ((LocData)localObject).direction = (parama.d / 10.0F);
      if (parama.f == 0)
      {
        ((LocData)localObject).satellitesNum = 5;
        ((LocData)localObject).altitude = (parama.e / 10.0F);
        ((LocData)localObject).time = parama.g;
        LocData localLocData = ((LocData)localObject).clone();
        localLocData.latitude = (parama.a / 1000000.0D);
        localLocData.longitude = (parama.b / 1000000.0D);
        a(localLocData, (LocData)localObject);
      }
    }
    else
    {
      localObject = new LocationManager.LocData();
      ((LocationManager.LocData)localObject).type = 61;
      ((LocationManager.LocData)localObject).latitude = (localGeoPoint.getLatitudeE6() / 100000.0D);
      ((LocationManager.LocData)localObject).longitude = (localGeoPoint.getLongitudeE6() / 100000.0D);
      ((LocationManager.LocData)localObject).speed = (parama.c / 100.0F);
      ((LocationManager.LocData)localObject).accuracy = Math.min(2000.0F, parama.h);
      ((LocationManager.LocData)localObject).direction = (parama.d / 10.0F);
      if (parama.f != 0) {
        break label322;
      }
    }
    label322:
    for (((LocationManager.LocData)localObject).satellitesNum = 5;; ((LocationManager.LocData)localObject).satellitesNum = parama.f)
    {
      ((LocationManager.LocData)localObject).altitude = (parama.e / 10.0F);
      a((LocationManager.LocData)localObject);
      return;
      ((LocData)localObject).satellitesNum = parama.f;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    BNExtGPSLocationManager.getInstance().updateGpsStatus(paramBoolean);
  }
  
  public boolean b()
  {
    return (this.c) && (com.baidu.carlife.l.a.a().N());
  }
  
  public boolean c()
  {
    return BNExtGPSLocationManager.getInstance().isGpsEnabled();
  }
  
  public boolean d()
  {
    return BNExtGPSLocationManager.getInstance().isGpsAvailable();
  }
  
  public static class a
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public float h;
    
    public String toString()
    {
      return super.toString() + "---latitudeE6 = " + this.a + ",longitudeE6 = " + this.b + ",speedE2 = " + this.c + ",accuracy = " + this.h + ",directionE1 = " + this.d + ",altitudeE1 = " + this.e;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */