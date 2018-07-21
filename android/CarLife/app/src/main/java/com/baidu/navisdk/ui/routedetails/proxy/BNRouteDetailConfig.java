package com.baidu.navisdk.ui.routedetails.proxy;

public class BNRouteDetailConfig
{
  public static final int CONFIG_VIEW_MODE_INFLATE_MAP = 0;
  public static final int CONFIG_VIEW_MODE_NOT_INFLATE_MAP = 1;
  public static final int INVALID_INT_VALUE = -1;
  public static final String KEY_ROUTE_DETAIL_VIEW_MODE = "route_detail_view_mode";
  public static int pRGViewMode = 1;
  
  public static void clear()
  {
    pRGViewMode = -1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routedetails/proxy/BNRouteDetailConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */