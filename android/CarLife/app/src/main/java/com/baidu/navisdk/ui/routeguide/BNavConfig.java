package com.baidu.navisdk.ui.routeguide;

public class BNavConfig
{
  public static final int INVALID_INT_VALUE = -1;
  public static final String INVALID_STRING_VALUE = "none";
  public static final String KEY_ROUTEGUIDE_CALCROUTE_DONE = "calroute_done";
  public static final String KEY_ROUTEGUIDE_CAR_RESULT_HAS_SHOW_ANIM = "car_result_has_show_anim";
  public static final String KEY_ROUTEGUIDE_END_NAME = "end_name";
  public static final String KEY_ROUTEGUIDE_END_UGCRESULTPAGE = "navi.end.ugcpage";
  public static final String KEY_ROUTEGUIDE_END_X = "end_x";
  public static final String KEY_ROUTEGUIDE_END_Y = "end_y";
  public static final String KEY_ROUTEGUIDE_IPO_SWITCH = "is_ipo_switch";
  public static final String KEY_ROUTEGUIDE_LOCATE_MODE = "locate_mode";
  public static final String KEY_ROUTEGUIDE_MENU_TYPE = "menu_type";
  public static final String KEY_ROUTEGUIDE_NET_FRESH_ENABLE = "net_refresh";
  public static final String KEY_ROUTEGUIDE_ROAD_CONDITION_ENABLE = "road_condition";
  public static final String KEY_ROUTEGUIDE_SELECTED_ROUTE_MRSL = "selected_route_mrsl";
  public static final String KEY_ROUTEGUIDE_SHOW_FULLVIEW = "show_fullview";
  public static final String KEY_ROUTEGUIDE_START_NAME = "start_name";
  public static final String KEY_ROUTEGUIDE_START_X = "start_x";
  public static final String KEY_ROUTEGUIDE_START_Y = "start_y";
  public static final String KEY_ROUTEGUIDE_VIEW_MODE = "routeguide_view_mode";
  public static final String KEY_ROUTEGUIDE_WALKNAVI = "walknavi";
  public static final String KEY_ROUTEGUIDE_WANDA = "is_wanda";
  public static int pRGCalcDone;
  public static String pRGEndName;
  public static int pRGEndX;
  public static int pRGEndY;
  public static int pRGLocateMode;
  public static int pRGMenuType;
  public static String pRGMrsl = null;
  public static boolean pRGNetRefreshEnable;
  public static boolean pRGRoadConditionEnable;
  public static boolean pRGShowFullview;
  public static String pRGStartName;
  public static int pRGStartX;
  public static int pRGStartY;
  public static int pRGViewMode = -1;
  
  static
  {
    pRGCalcDone = -1;
    pRGStartX = -1;
    pRGStartY = -1;
    pRGEndX = -1;
    pRGEndY = -1;
    pRGStartName = "none";
    pRGEndName = "none";
    pRGLocateMode = 0;
    pRGMenuType = 1;
    pRGNetRefreshEnable = false;
    pRGRoadConditionEnable = false;
    pRGShowFullview = true;
  }
  
  public static void clear()
  {
    pRGViewMode = -1;
    pRGCalcDone = -1;
    pRGStartX = -1;
    pRGStartY = -1;
    pRGEndX = -1;
    pRGEndY = -1;
    pRGStartName = "none";
    pRGEndName = "none";
    pRGLocateMode = 0;
    pRGShowFullview = true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/BNavConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */