package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RGFSMTable
{
  public static HashMap<String, HashMap<String, String>> dictFSM;
  public static HashMap<String, String> dictStateAR;
  public static HashMap<String, String> dictStateBrowseMap;
  public static HashMap<String, String> dictStateCar3D;
  public static HashMap<String, String> dictStateColladamap;
  public static HashMap<String, String> dictStateEnlargeRoadmap;
  public static HashMap<String, String> dictStateFullview;
  public static HashMap<String, String> dictStateHUD;
  public static HashMap<String, String> dictStateHUDMirror;
  public static HashMap<String, String> dictStateHighway;
  public static HashMap<String, String> dictStateNorth2D;
  public static HashMap<String, String> dictStatePark;
  public static HashMap<String, String> dictStatePickPoint;
  public static HashMap<String, String> dictStateRouteItem;
  public static HashMap<String, String> dictStateRoutePlan;
  public static HashMap<String, String> dictStateSimpleGuide;
  private static List<String> glassStates;
  private static final byte[] lock = new byte[0];
  
  public static void destory()
  {
    if (dictFSM != null) {
      dictFSM.clear();
    }
    if (dictStateNorth2D != null) {
      dictStateNorth2D.clear();
    }
    if (dictStateCar3D != null) {
      dictStateCar3D.clear();
    }
    if (dictStateFullview != null) {
      dictStateFullview.clear();
    }
    if (dictStateEnlargeRoadmap != null) {
      dictStateEnlargeRoadmap.clear();
    }
    if (dictStateColladamap != null) {
      dictStateColladamap.clear();
    }
    if (dictStateBrowseMap != null) {
      dictStateBrowseMap.clear();
    }
    if (dictStateHUD != null) {
      dictStateHUD.clear();
    }
    if (dictStateHUDMirror != null) {
      dictStateHUDMirror.clear();
    }
    if (dictStateAR != null) {
      dictStateAR.clear();
    }
    if (dictStateAR != null) {
      dictStateAR.clear();
    }
    if (dictStateRoutePlan != null) {
      dictStateRoutePlan.clear();
    }
    if (dictStatePickPoint != null) {
      dictStatePickPoint.clear();
    }
    if (dictStateHighway != null) {
      dictStateHighway.clear();
    }
  }
  
  private static void initDictFSM()
  {
    dictFSM = new HashMap();
    dictFSM.clear();
    dictFSM.put("SimpleGuide", dictStateSimpleGuide);
    dictFSM.put("North2D", dictStateNorth2D);
    dictFSM.put("Car3D", dictStateCar3D);
    dictFSM.put("Fullview", dictStateFullview);
    dictFSM.put("EnlargeRoadmap", dictStateEnlargeRoadmap);
    dictFSM.put("Colladamap", dictStateColladamap);
    dictFSM.put("BrowseMap", dictStateBrowseMap);
    dictFSM.put("HUD", dictStateHUD);
    dictFSM.put("HUDMirror", dictStateHUDMirror);
    dictFSM.put("AR", dictStateAR);
    dictFSM.put("RoutePlan", dictStateRoutePlan);
    dictFSM.put("PickPoint", dictStatePickPoint);
    dictFSM.put("Highway", dictStateHighway);
    dictFSM.put("RouteItem", dictStateRouteItem);
    dictFSM.put("Park", dictStatePark);
  }
  
  private static void initGlassStates()
  {
    glassStates = new ArrayList();
    glassStates.add("North2D");
    glassStates.add("Car3D");
    glassStates.add("Fullview");
    glassStates.add("BrowseMap");
  }
  
  private static void initTransAR()
  {
    dictStateAR = new HashMap();
    dictStateAR.clear();
    dictStateAR.put("[返回]按钮点击", "BACK");
    dictStateAR.put("[HUD]按钮点击", "HUD");
    dictStateAR.put("从HUD去HUD镜像页", "HUDMirror");
    dictStateAR.put("从HUD镜像页回到HUD", "HUD");
    dictStateAR.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateAR.put("更多菜单[分段浏览]点击", "RouteItem");
    dictStateAR.put("收到偏航开始的消息", "SimpleGuide");
    dictStateAR.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateAR.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransBrowseMap()
  {
    dictStateBrowseMap = new HashMap();
    dictStateBrowseMap.clear();
    dictStateBrowseMap.put("[回车位]按钮点击", "BACK");
    dictStateBrowseMap.put("[一键全览]按钮点击", "Fullview");
    dictStateBrowseMap.put("[放大缩小]按钮点击", "BrowseMap");
    dictStateBrowseMap.put("[HUD]按钮点击", "HUD");
    dictStateBrowseMap.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateBrowseMap.put("指南针点击", "BACK");
    dictStateBrowseMap.put("拖动地图", "BrowseMap");
    dictStateBrowseMap.put("触碰地图", "BrowseMap");
    dictStateBrowseMap.put("收到放大图显示消息", "EnlargeRoadmap");
    dictStateBrowseMap.put("收到collada显示消息", "Colladamap");
    dictStateBrowseMap.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateBrowseMap.put("收到自动回车位消息", "BACK");
    dictStateBrowseMap.put("收到横竖屏变化消息", "BACK");
    dictStateBrowseMap.put("[Highway]进入", "Highway");
    dictStateBrowseMap.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransCar3D()
  {
    dictStateCar3D = new HashMap();
    dictStateCar3D.clear();
    dictStateCar3D.put("[3D车头向上]按钮点击", "North2D");
    dictStateCar3D.put("[一键全览]按钮点击", "Fullview");
    dictStateCar3D.put("[HUD]按钮点击", "HUD");
    dictStateCar3D.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateCar3D.put("指南针点击", "North2D");
    dictStateCar3D.put("拖动地图", "BrowseMap");
    dictStateCar3D.put("触碰地图", "Car3D");
    dictStateCar3D.put("收到放大图显示消息", "EnlargeRoadmap");
    dictStateCar3D.put("收到collada显示消息", "Colladamap");
    dictStateCar3D.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateCar3D.put("收到横竖屏变化消息", "Car3D");
    dictStateCar3D.put("[Highway]进入", "Highway");
    dictStateCar3D.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransColladamap()
  {
    dictStateColladamap = new HashMap();
    dictStateColladamap.clear();
    dictStateColladamap.put("[回车位]按钮点击", "Car3D");
    dictStateColladamap.put("[3D车头向上]按钮点击", "North2D");
    dictStateColladamap.put("[2D正北]按钮点击", "Car3D");
    dictStateColladamap.put("[一键全览]按钮点击", "Fullview");
    dictStateColladamap.put("[返回]按钮点击", "BACK");
    dictStateColladamap.put("拖动地图", "BrowseMap");
    dictStateColladamap.put("触碰地图", "BrowseMap");
    dictStateColladamap.put("收到偏航开始的消息", "SimpleGuide");
    dictStateColladamap.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateColladamap.put("[HUD]按钮点击", "HUD");
    dictStateColladamap.put("收到横竖屏变化消息", "Colladamap");
    dictStateColladamap.put("继续导航", "SimpleGuide");
    dictStateColladamap.put("收到collada隐藏消息", "BACK");
  }
  
  private static void initTransEnlargeRoadmap()
  {
    dictStateEnlargeRoadmap = new HashMap();
    dictStateEnlargeRoadmap.clear();
    dictStateEnlargeRoadmap.put("[回车位]按钮点击", "Car3D");
    dictStateEnlargeRoadmap.put("[3D车头向上]按钮点击", "North2D");
    dictStateEnlargeRoadmap.put("[2D正北]按钮点击", "Car3D");
    dictStateEnlargeRoadmap.put("[一键全览]按钮点击", "Fullview");
    dictStateEnlargeRoadmap.put("[返回]按钮点击", "BACK");
    dictStateEnlargeRoadmap.put("拖动地图", "BrowseMap");
    dictStateEnlargeRoadmap.put("触碰地图", "BrowseMap");
    dictStateEnlargeRoadmap.put("[HUD]按钮点击", "HUD");
    dictStateEnlargeRoadmap.put("收到放大图隐藏消息", "BACK");
    dictStateEnlargeRoadmap.put("收到偏航开始的消息", "SimpleGuide");
    dictStateEnlargeRoadmap.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateEnlargeRoadmap.put("收到横竖屏变化消息", "EnlargeRoadmap");
    dictStateEnlargeRoadmap.put("继续导航", "SimpleGuide");
    dictStateEnlargeRoadmap.put("收到collada显示消息", "Colladamap");
  }
  
  private static void initTransFullview()
  {
    dictStateFullview = new HashMap();
    dictStateFullview.clear();
    dictStateFullview.put("[一键全览]按钮点击", "BACK");
    dictStateFullview.put("[HUD]按钮点击", "HUD");
    dictStateFullview.put("[放大缩小]按钮点击", "BrowseMap");
    dictStateFullview.put("[返回]按钮点击", "BACK");
    dictStateFullview.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateFullview.put("指南针点击", "BACK");
    dictStateFullview.put("拖动地图", "BrowseMap");
    dictStateFullview.put("触碰地图", "Fullview");
    dictStateFullview.put("收到放大图显示消息", "EnlargeRoadmap");
    dictStateFullview.put("收到collada显示消息", "Colladamap");
    dictStateFullview.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateFullview.put("收到自动回车位消息", "Fullview");
    dictStateFullview.put("收到横竖屏变化消息", "Fullview");
    dictStateFullview.put("[Highway]进入", "Highway");
    dictStateFullview.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransHUD()
  {
    dictStateHUD = new HashMap();
    dictStateHUD.clear();
    dictStateHUD.put("[AR]按钮点击", "AR");
    dictStateHUD.put("从HUD去HUD镜像页", "HUDMirror");
    dictStateHUD.put("[返回]按钮点击", "BACK");
    dictStateHUD.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateHUD.put("更多菜单[分段浏览]点击", "RouteItem");
    dictStateHUD.put("收到偏航开始的消息", "SimpleGuide");
    dictStateHUD.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateHUD.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransHUDMirror()
  {
    dictStateHUDMirror = new HashMap();
    dictStateHUDMirror.clear();
    dictStateHUDMirror.put("[返回]按钮点击", "BACK");
    dictStateHUDMirror.put("从HUD镜像页回到HUD", "HUD");
    dictStateHUDMirror.put("[HUD]按钮点击", "HUD");
    dictStateHUDMirror.put("[AR]按钮点击", "AR");
    dictStateHUDMirror.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateHUDMirror.put("更多菜单[分段浏览]点击", "RouteItem");
    dictStateHUDMirror.put("收到偏航开始的消息", "SimpleGuide");
    dictStateHUDMirror.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateHUDMirror.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransHighway()
  {
    dictStateHighway = new HashMap();
    dictStateHighway.clear();
    dictStateHighway.put("[回车位]按钮点击", "Car3D");
    dictStateHighway.put("[3D车头向上]按钮点击", "North2D");
    dictStateHighway.put("[2D正北]按钮点击", "Car3D");
    dictStateHighway.put("[一键全览]按钮点击", "Fullview");
    dictStateHighway.put("拖动地图", "BrowseMap");
    dictStateHighway.put("触碰地图", "BrowseMap");
    dictStateHighway.put("[HUD]按钮点击", "HUD");
    dictStateHighway.put("[AR]按钮点击", "AR");
    dictStateHighway.put("从HUD去HUD镜像页", "HUDMirror");
    dictStateHighway.put("从HUD镜像页回到HUD", "HUD");
    dictStateHighway.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateHighway.put("更多菜单[分段浏览]点击", "RouteItem");
    dictStateHighway.put("收到偏航开始的消息", "SimpleGuide");
    dictStateHighway.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateHighway.put("收到横竖屏变化消息", "Highway");
    dictStateHighway.put("收到放大图显示消息", "EnlargeRoadmap");
    dictStateHighway.put("收到collada显示消息", "Colladamap");
    dictStateHighway.put("指南针点击", "PickPoint");
    dictStateHighway.put("[Highway]退出", "SimpleGuide");
    dictStateHighway.put("继续导航", "Highway");
    dictStateSimpleGuide.put("展示目的地停车场", "Park");
  }
  
  private static void initTransNorth2D()
  {
    dictStateNorth2D = new HashMap();
    dictStateNorth2D.clear();
    dictStateNorth2D.put("[2D正北]按钮点击", "Car3D");
    dictStateNorth2D.put("[一键全览]按钮点击", "Fullview");
    dictStateNorth2D.put("[HUD]按钮点击", "HUD");
    dictStateNorth2D.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateNorth2D.put("指南针点击", "Car3D");
    dictStateNorth2D.put("拖动地图", "BrowseMap");
    dictStateNorth2D.put("触碰地图", "North2D");
    dictStateNorth2D.put("收到放大图显示消息", "EnlargeRoadmap");
    dictStateNorth2D.put("收到collada显示消息", "Colladamap");
    dictStateNorth2D.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateNorth2D.put("收到横竖屏变化消息", "North2D");
    dictStateNorth2D.put("[Highway]进入", "Highway");
    dictStateNorth2D.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransPark()
  {
    dictStatePark = new HashMap();
    dictStatePark.put("[返回]按钮点击", "BACK");
    dictStatePark.put("[回车位]按钮点击", "Car3D");
    dictStatePark.put("[3D车头向上]按钮点击", "North2D");
    dictStatePark.put("[2D正北]按钮点击", "Car3D");
    dictStatePark.put("拖动地图", "BrowseMap");
    dictStatePark.put("触碰地图", "BrowseMap");
    dictStatePark.put("[HUD]按钮点击", "HUD");
    dictStatePark.put("从HUD去HUD镜像页", "HUDMirror");
    dictStatePark.put("从HUD镜像页回到HUD", "HUD");
    dictStatePark.put("[AR]按钮点击", "AR");
    dictStatePark.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStatePark.put("更多菜单[分段浏览]点击", "RouteItem");
    dictStatePark.put("收到偏航开始的消息", "SimpleGuide");
    dictStatePark.put("收到偏航算路成功消息", "SimpleGuide");
    dictStatePark.put("收到横竖屏变化消息", "Park");
    dictStatePark.put("继续导航", "SimpleGuide");
    dictStatePark.put("指南针点击", "PickPoint");
    dictStatePark.put("收到collada显示消息", "Colladamap");
  }
  
  private static void initTransPickPoint()
  {
    dictStatePickPoint = new HashMap();
    dictStatePickPoint.clear();
    dictStatePickPoint.put("[返回]按钮点击", "BACK");
    dictStatePickPoint.put("[回车位]按钮点击", "Car3D");
    dictStatePickPoint.put("[3D车头向上]按钮点击", "North2D");
    dictStatePickPoint.put("[2D正北]按钮点击", "Car3D");
    dictStatePickPoint.put("[一键全览]按钮点击", "Fullview");
    dictStatePickPoint.put("拖动地图", "BrowseMap");
    dictStatePickPoint.put("触碰地图", "BrowseMap");
    dictStatePickPoint.put("[HUD]按钮点击", "HUD");
    dictStatePickPoint.put("从HUD去HUD镜像页", "HUDMirror");
    dictStateHUDMirror.put("从HUD镜像页回到HUD", "HUD");
    dictStatePickPoint.put("[AR]按钮点击", "AR");
    dictStatePickPoint.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStatePickPoint.put("更多菜单[分段浏览]点击", "RouteItem");
    dictStatePickPoint.put("收到collada显示消息", "Colladamap");
    dictStatePickPoint.put("收到偏航开始的消息", "SimpleGuide");
    dictStatePickPoint.put("收到偏航算路成功消息", "SimpleGuide");
    dictStatePickPoint.put("收到横竖屏变化消息", "PickPoint");
    dictStatePickPoint.put("继续导航", "SimpleGuide");
    dictStatePickPoint.put("展示目的地停车场", "Park");
  }
  
  private static void initTransRouteItem()
  {
    dictStateRouteItem = new HashMap();
    dictStateRouteItem.clear();
    dictStateRouteItem.put("[返回]按钮点击", "BACK");
    dictStateRouteItem.put("[回车位]按钮点击", "Car3D");
    dictStateRouteItem.put("[3D车头向上]按钮点击", "North2D");
    dictStateRouteItem.put("[2D正北]按钮点击", "Car3D");
    dictStateRouteItem.put("[一键全览]按钮点击", "Fullview");
    dictStateRouteItem.put("拖动地图", "BrowseMap");
    dictStateRouteItem.put("触碰地图", "BrowseMap");
    dictStateRouteItem.put("[HUD]按钮点击", "HUD");
    dictStateRouteItem.put("从HUD去HUD镜像页", "HUDMirror");
    dictStateRouteItem.put("从HUD镜像页回到HUD", "HUD");
    dictStateRouteItem.put("[AR]按钮点击", "AR");
    dictStateRouteItem.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateRouteItem.put("收到偏航开始的消息", "SimpleGuide");
    dictStateRouteItem.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateRouteItem.put("收到横竖屏变化消息", "RouteItem");
    dictStateRouteItem.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransRoutePlan()
  {
    dictStateRoutePlan = new HashMap();
    dictStateRoutePlan.clear();
    dictStateRoutePlan.put("[返回]按钮点击", "BACK");
    dictStateRoutePlan.put("收到偏航开始的消息", "SimpleGuide");
    dictStateRoutePlan.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateRoutePlan.put("继续导航", "SimpleGuide");
  }
  
  private static void initTransSimpleGuide()
  {
    dictStateSimpleGuide = new HashMap();
    dictStateSimpleGuide.put("[回车位]按钮点击", "Car3D");
    dictStateSimpleGuide.put("[3D车头向上]按钮点击", "North2D");
    dictStateSimpleGuide.put("[2D正北]按钮点击", "Car3D");
    dictStateSimpleGuide.put("[一键全览]按钮点击", "Fullview");
    dictStateSimpleGuide.put("指南针点击", "Car3D");
    dictStateSimpleGuide.put("拖动地图", "BrowseMap");
    dictStateSimpleGuide.put("触碰地图", "BrowseMap");
    dictStateSimpleGuide.put("[HUD]按钮点击", "HUD");
    dictStateSimpleGuide.put("从HUD去HUD镜像页", "HUDMirror");
    dictStateSimpleGuide.put("从HUD镜像页回到HUD", "HUD");
    dictStateSimpleGuide.put("[AR]按钮点击", "AR");
    dictStateSimpleGuide.put("更多菜单[路线规划]点击", "RoutePlan");
    dictStateSimpleGuide.put("更多菜单[分段浏览]点击", "RouteItem");
    dictStateSimpleGuide.put("收到放大图显示消息", "EnlargeRoadmap");
    dictStateSimpleGuide.put("收到collada显示消息", "Colladamap");
    dictStateSimpleGuide.put("收到偏航算路成功消息", "SimpleGuide");
    dictStateSimpleGuide.put("收到横竖屏变化消息", "SimpleGuide");
    dictStateSimpleGuide.put("[Highway]进入", "Highway");
    dictStateSimpleGuide.put("指南针点击", "PickPoint");
    dictStateSimpleGuide.put("继续导航", "SimpleGuide");
    dictStateSimpleGuide.put("展示目的地停车场", "Park");
  }
  
  public static void initTransition()
  {
    initTransSimpleGuide();
    initTransNorth2D();
    initTransCar3D();
    initTransFullview();
    initTransEnlargeRoadmap();
    initTransColladamap();
    initTransBrowseMap();
    initTransHUD();
    initTransHUDMirror();
    initTransAR();
    initTransRoutePlan();
    initTransPickPoint();
    initTransHighway();
    initTransRouteItem();
    initTransPark();
    initDictFSM();
    initGlassStates();
  }
  
  public static boolean isGlassState(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return glassStates.contains(paramString);
  }
  
  public static boolean isNeedRefreshMapState(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!"SimpleGuide".equals(paramString)) && (!"Highway".equals(paramString))) {
      return false;
    }
    return true;
  }
  
  public static String queryDestState(String paramString1, String paramString2)
  {
    synchronized (lock)
    {
      new HashMap();
      Object localObject = (HashMap)dictFSM.get(paramString1);
      if (localObject == null)
      {
        LogUtil.e("RouteGuide", "不存在该状态对应的状态机，请完善逻辑!");
        return null;
      }
      localObject = (String)((HashMap)localObject).get(paramString2);
      if (localObject == null)
      {
        LogUtil.e("RouteGuide", "处于状态 (" + paramString1 + ")时， 不存在执行event = " + paramString2 + " 的跳转，请考虑是否完善逻辑!");
        return null;
      }
      return (String)localObject;
    }
  }
  
  public static class FsmEvent
  {
    public static final String ANTI_GEO_PICK_POINT = "指南针点击";
    public static final String BTN_CLICK_AR = "[AR]按钮点击";
    public static final String BTN_CLICK_BACK = "[返回]按钮点击";
    public static final String BTN_CLICK_CAR_3D = "[3D车头向上]按钮点击";
    public static final String BTN_CLICK_FULL_VIEW = "[一键全览]按钮点击";
    public static final String BTN_CLICK_HUD_ENTER = "[HUD]按钮点击";
    public static final String BTN_CLICK_LOC_CAR = "[回车位]按钮点击";
    public static final String BTN_CLICK_NORTH_2D = "[2D正北]按钮点击";
    public static final String BTN_CLICK_ZOOM = "[放大缩小]按钮点击";
    public static final String CONTINUE_NAVI = "继续导航";
    public static final String DEST_PARK_SHOW = "展示目的地停车场";
    public static final String MAP_COMPASS_CLICK = "指南针点击";
    public static final String MAP_MOVE = "拖动地图";
    public static final String MENU_CLICK_PICK_POINT = "更多菜单[设置终点/设中转点]点击";
    public static final String MENU_CLICK_ROUTE_DETAIL = "更多菜单[查看路线]点击";
    public static final String MENU_CLICK_ROUTE_ITEM = "更多菜单[分段浏览]点击";
    public static final String MENU_CLICK_ROUTE_PLAN = "更多菜单[路线规划]点击";
    public static final String MENU_CLICK_SPACE_SEARCH = "更多菜单[搜周边]点击";
    public static final String MSG_AUTO_LOC_CAR_WHEN_TIMEOUT = "收到自动回车位消息";
    public static final String MSG_COLLADA_HIDE = "收到collada隐藏消息";
    public static final String MSG_COLLADA_SHOW = "收到collada显示消息";
    public static final String MSG_ENLARGE_ROADMAP_HIDE = "收到放大图隐藏消息";
    public static final String MSG_ENLARGE_ROADMAP_SHOW = "收到放大图显示消息";
    public static final String MSG_HUD_GOTO_MIRROR = "从HUD去HUD镜像页";
    public static final String MSG_MIRROR_GOTO_HUD = "从HUD镜像页回到HUD";
    public static final String MSG_PORT_LAND_SCREEN_CHANGED = "收到横竖屏变化消息";
    public static final String MSG_YAWING_REROUTED = "收到偏航算路成功消息";
    public static final String MSG_YAWING_START = "收到偏航开始的消息";
    public static final String TOUCH_ENLARGE_ROAD_MAP = "触碰放大图";
    public static final String TOUCH_MAP = "触碰地图";
    public static final String VIEW_CLICK_HIGHWAY_ENTER = "[Highway]进入";
    public static final String VIEW_CLICK_HIGHWAY_EXIT = "[Highway]退出";
  }
  
  public static class FsmParamsKey
  {
    public static final String ORIENTATION_CHANGE = "orientation_change";
  }
  
  public static class FsmState
  {
    public static final String AR = "AR";
    public static final String BACK = "BACK";
    public static final String BrowseMap = "BrowseMap";
    public static final String Car3D = "Car3D";
    public static final String Colladamap = "Colladamap";
    public static final String EnlargeRoadmap = "EnlargeRoadmap";
    public static final String Fullview = "Fullview";
    public static final String HUD = "HUD";
    public static final String HUDMirror = "HUDMirror";
    public static final String Highway = "Highway";
    public static final String North2D = "North2D";
    public static final String Park = "Park";
    public static final String PickPoint = "PickPoint";
    public static final String RouteItem = "RouteItem";
    public static final String RoutePlan = "RoutePlan";
    public static final String SimpleGuide = "SimpleGuide";
    public static final String StartNavAnimation = "StartNavAnimation";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGFSMTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */