package com.baidu.navisdk.comapi.poisearch;

public class PoiSearchParams
{
  public static final int BKG_TYPE_NUM = 4;
  public static final int DEFAULT_SPACE_SEARCH_RADIUS = 5000;
  public static final int MAX_OFFLINE_SEARCH_COUNT = 100;
  public static final int MAX_ONLINE_ROUTE_SEARCH_COUNT = 30;
  public static final int MAX_ONLINE_SEARCH_COUNT = 20;
  public static final int MAX_SUB_POI_TYPE_NUM = 32;
  public static final int SUB_POI_TYPE_NUM = 8;
  public static final int SUG_PREFIX_MAX_LENGTH = 40;
  
  public class BkgType
  {
    public static final int TYPE_BANK = 7;
    public static final int TYPE_GAS_STATION = 0;
    public static final int TYPE_HOTEL = 5;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_PARKING = 2;
    public static final int TYPE_RESTAURANT = 6;
    public static final int TYPE_SERVICE = 3;
    public static final int TYPE_SPOTS = 4;
    public static final int TYPE_TOILET = 1;
    
    public BkgType() {}
  }
  
  public class SubPoiType
  {
    public static final int TYPE_DOOR = 1;
    public static final int TYPE_IN = 4;
    public static final int TYPE_IN_OUT = 16;
    public static final int TYPE_OUT = 8;
    public static final int TYPE_PARK = 2;
    
    public SubPoiType() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/poisearch/PoiSearchParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */