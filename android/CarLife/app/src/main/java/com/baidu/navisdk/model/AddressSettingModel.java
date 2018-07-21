package com.baidu.navisdk.model;

import android.content.Context;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class AddressSettingModel
{
  private static final String DEFAULT_NAME = "地图上的点";
  
  public static RoutePlanNode getCompAddrNode(Context paramContext)
  {
    if (!hasSetCompAddr(paramContext))
    {
      paramContext = new RoutePlanNode();
      paramContext.setFrom(5);
      return paramContext;
    }
    return new RoutePlanNode(new GeoPoint(getCompLon(paramContext), getCompLat(paramContext)), 5, getCompName(paramContext), getCompAddress(paramContext), getCompPoiOriginUID(paramContext));
  }
  
  public static String getCompAddress(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getString("SET_COMP_ADDR_ADDRESS", "地图上的点");
  }
  
  public static int getCompCityId(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getInt("COMP_CITY_ID", -1);
  }
  
  public static int getCompLat(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getInt("SET_COMP_ADDR_LATITUDE", 0);
  }
  
  public static int getCompLon(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getInt("SET_COMP_ADDR_LONGITUDE", 0);
  }
  
  public static String getCompName(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getString("SET_COMP_ADDR_NAME", "地图上的点");
  }
  
  public static String getCompPoiOriginUID(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getString("SET_COMP_ADDR_POI_ORIGIN_UID", null);
  }
  
  public static RoutePlanNode getHomeAddrNode(Context paramContext)
  {
    if (!hasSetHomeAddr(paramContext))
    {
      paramContext = new RoutePlanNode();
      paramContext.setFrom(4);
      return paramContext;
    }
    return new RoutePlanNode(new GeoPoint(getHomeLon(paramContext), getHomeLat(paramContext)), 4, getHomeName(paramContext), getHomeAddress(paramContext), getHomePoiOriginUID(paramContext));
  }
  
  public static String getHomeAddress(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getString("SET_HOME_ADDR_ADDRESS", "");
  }
  
  public static int getHomeCityId(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getInt("HOME_CITY_ID", -1);
  }
  
  public static int getHomeLat(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getInt("SET_HOME_ADDR_LATITUDE", 0);
  }
  
  public static int getHomeLon(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getInt("SET_HOME_ADDR_LONGITUDE", 0);
  }
  
  public static String getHomeName(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getString("SET_HOME_ADDR_NAME", "地图上的点");
  }
  
  public static String getHomePoiOriginUID(Context paramContext)
  {
    return PreferenceHelper.getInstance(paramContext).getString("SET_HOME_ADDR_POI_ORIGIN_UID", null);
  }
  
  public static boolean hasSetCompAddr(Context paramContext)
  {
    return (getCompLat(paramContext) > 0) && (getCompLon(paramContext) > 0);
  }
  
  public static boolean hasSetHomeAddr(Context paramContext)
  {
    return (getHomeLat(paramContext) > 0) && (getHomeLon(paramContext) > 0);
  }
  
  public static boolean removeCompAddress(Context paramContext)
  {
    PreferenceHelper.getInstance(paramContext).remove("SET_COMP_ADDR_LONGITUDE");
    PreferenceHelper.getInstance(paramContext).remove("SET_COMP_ADDR_LATITUDE");
    PreferenceHelper.getInstance(paramContext).remove("SET_COMP_ADDR_ADDRESS");
    PreferenceHelper.getInstance(paramContext).remove("SET_COMP_ADDR_NAME");
    PreferenceHelper.getInstance(paramContext).remove("SET_COMP_ADDR_POI_ORIGIN_UID");
    PreferenceHelper.getInstance(paramContext).remove("COMP_CITY_ID");
    PreferenceHelper.getInstance(paramContext).putBoolean("company_has_synced", true);
    return true;
  }
  
  public static boolean removeHomeAddress(Context paramContext)
  {
    PreferenceHelper.getInstance(paramContext).remove("SET_HOME_ADDR_LONGITUDE");
    PreferenceHelper.getInstance(paramContext).remove("SET_HOME_ADDR_LATITUDE");
    PreferenceHelper.getInstance(paramContext).remove("SET_HOME_ADDR_ADDRESS");
    PreferenceHelper.getInstance(paramContext).remove("SET_HOME_ADDR_NAME");
    PreferenceHelper.getInstance(paramContext).remove("SET_HOME_ADDR_POI_ORIGIN_UID");
    PreferenceHelper.getInstance(paramContext).remove("HOME_CITY_ID");
    PreferenceHelper.getInstance(paramContext).remove("family_has_synced");
    PreferenceHelper.getInstance(paramContext).putBoolean("family_has_synced", true);
    return true;
  }
  
  public static boolean setCompAddress(Context paramContext, RoutePlanNode paramRoutePlanNode)
  {
    setCompCityId(paramContext, -1);
    return setCompAddress(paramContext, paramRoutePlanNode.mDescription, paramRoutePlanNode.mName, paramRoutePlanNode.getLongitudeE6(), paramRoutePlanNode.getLatitudeE6(), paramRoutePlanNode.mUID);
  }
  
  public static boolean setCompAddress(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    PreferenceHelper.getInstance(paramContext).putString("SET_COMP_ADDR_ADDRESS", paramString1);
    PreferenceHelper.getInstance(paramContext).putString("SET_COMP_ADDR_NAME", paramString2);
    PreferenceHelper.getInstance(paramContext).putInt("SET_COMP_ADDR_LONGITUDE", paramInt1);
    PreferenceHelper.getInstance(paramContext).putInt("SET_COMP_ADDR_LATITUDE", paramInt2);
    if ((paramString3 == null) || (paramString3.trim().length() == 0)) {
      PreferenceHelper.getInstance(paramContext).putString("SET_COMP_ADDR_POI_ORIGIN_UID", "");
    }
    for (;;)
    {
      PreferenceHelper.getInstance(paramContext).putBoolean("company_has_synced", true);
      return true;
      PreferenceHelper.getInstance(paramContext).putString("SET_COMP_ADDR_POI_ORIGIN_UID", paramString3);
    }
  }
  
  public static void setCompCityId(Context paramContext, int paramInt)
  {
    PreferenceHelper.getInstance(paramContext).putInt("COMP_CITY_ID", paramInt);
  }
  
  public static boolean setHomeAddress(Context paramContext, RoutePlanNode paramRoutePlanNode)
  {
    setHomeCityId(paramContext, -1);
    return setHomeAddress(paramContext, paramRoutePlanNode.mDescription, paramRoutePlanNode.mName, paramRoutePlanNode.getLongitudeE6(), paramRoutePlanNode.getLatitudeE6(), paramRoutePlanNode.mUID);
  }
  
  public static boolean setHomeAddress(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    PreferenceHelper.getInstance(paramContext).putString("SET_HOME_ADDR_ADDRESS", paramString1);
    PreferenceHelper.getInstance(paramContext).putString("SET_HOME_ADDR_NAME", paramString2);
    PreferenceHelper.getInstance(paramContext).putInt("SET_HOME_ADDR_LONGITUDE", paramInt1);
    PreferenceHelper.getInstance(paramContext).putInt("SET_HOME_ADDR_LATITUDE", paramInt2);
    if ((paramString3 == null) || (paramString3.trim().length() == 0)) {
      PreferenceHelper.getInstance(paramContext).putString("SET_HOME_ADDR_POI_ORIGIN_UID", "");
    }
    for (;;)
    {
      PreferenceHelper.getInstance(paramContext).putBoolean("family_has_synced", true);
      return true;
      PreferenceHelper.getInstance(paramContext).putString("SET_HOME_ADDR_POI_ORIGIN_UID", paramString3);
    }
  }
  
  public static void setHomeCityId(Context paramContext, int paramInt)
  {
    PreferenceHelper.getInstance(paramContext).putInt("HOME_CITY_ID", paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/AddressSettingModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */