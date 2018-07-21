package com.baidu.baidumaps.e;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.platform.comapi.util.SysOSAPIv2;

public class a
{
  public static final int a = 0;
  public static final String b = " baidumap_ANDR";
  
  public static int a()
  {
    if (LocationManager.getInstance().isLocationValid()) {
      return (int)LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09).longitude;
    }
    return 0;
  }
  
  public static int b()
  {
    if (LocationManager.getInstance().isLocationValid()) {
      return (int)LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09).latitude;
    }
    return 0;
  }
  
  public static int c()
  {
    int j = NavMapAdapter.getInstance().getCurrentLocalCityId();
    int i = j;
    if (j == 1) {
      i = 0;
    }
    return i;
  }
  
  public static String d()
  {
    return SysOSAPIv2.getInstance().getOSVersion();
  }
  
  public static String e()
  {
    return SysOSAPIv2.getInstance().getPhoneType();
  }
  
  public static String f()
  {
    return SysOSAPIv2.getInstance().getOSVersion();
  }
  
  public static String g()
  {
    return SysOSAPIv2.getInstance().getVersionName();
  }
  
  public static String h()
  {
    return String.valueOf(SysOSAPIv2.getInstance().getXDpi());
  }
  
  public static String i()
  {
    return String.valueOf(SysOSAPIv2.getInstance().getYDpi());
  }
  
  public static String j()
  {
    return SysOSAPIv2.getInstance().getNetType();
  }
  
  public static String k()
  {
    return " baidumap_ANDR";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */