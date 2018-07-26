package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RGFSMTable {
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

    public static class FsmEvent {
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

    public static class FsmParamsKey {
        public static final String ORIENTATION_CHANGE = "orientation_change";
    }

    public static class FsmState {
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

    public static void initTransition() {
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

    private static void initTransSimpleGuide() {
        dictStateSimpleGuide = new HashMap();
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateSimpleGuide.put("指南针点击", FsmState.Car3D);
        dictStateSimpleGuide.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateSimpleGuide.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateSimpleGuide.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateSimpleGuide.put(FsmEvent.MSG_MIRROR_GOTO_HUD, "HUD");
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_AR, "AR");
        dictStateSimpleGuide.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateSimpleGuide.put(FsmEvent.MENU_CLICK_ROUTE_ITEM, FsmState.RouteItem);
        dictStateSimpleGuide.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateSimpleGuide.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateSimpleGuide.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateSimpleGuide.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.SimpleGuide);
        dictStateSimpleGuide.put(FsmEvent.VIEW_CLICK_HIGHWAY_ENTER, "Highway");
        dictStateSimpleGuide.put("指南针点击", FsmState.PickPoint);
        dictStateSimpleGuide.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateSimpleGuide.put(FsmEvent.DEST_PARK_SHOW, FsmState.Park);
    }

    private static void initTransNorth2D() {
        dictStateNorth2D = new HashMap();
        dictStateNorth2D.clear();
        dictStateNorth2D.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateNorth2D.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateNorth2D.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateNorth2D.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateNorth2D.put("指南针点击", FsmState.Car3D);
        dictStateNorth2D.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateNorth2D.put(FsmEvent.TOUCH_MAP, FsmState.North2D);
        dictStateNorth2D.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateNorth2D.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateNorth2D.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateNorth2D.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.North2D);
        dictStateNorth2D.put(FsmEvent.VIEW_CLICK_HIGHWAY_ENTER, "Highway");
        dictStateNorth2D.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransCar3D() {
        dictStateCar3D = new HashMap();
        dictStateCar3D.clear();
        dictStateCar3D.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateCar3D.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateCar3D.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateCar3D.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateCar3D.put("指南针点击", FsmState.North2D);
        dictStateCar3D.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateCar3D.put(FsmEvent.TOUCH_MAP, FsmState.Car3D);
        dictStateCar3D.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateCar3D.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateCar3D.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateCar3D.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Car3D);
        dictStateCar3D.put(FsmEvent.VIEW_CLICK_HIGHWAY_ENTER, "Highway");
        dictStateCar3D.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransFullview() {
        dictStateFullview = new HashMap();
        dictStateFullview.clear();
        dictStateFullview.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.BACK);
        dictStateFullview.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateFullview.put(FsmEvent.BTN_CLICK_ZOOM, FsmState.BrowseMap);
        dictStateFullview.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateFullview.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateFullview.put("指南针点击", FsmState.BACK);
        dictStateFullview.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateFullview.put(FsmEvent.TOUCH_MAP, FsmState.Fullview);
        dictStateFullview.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateFullview.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateFullview.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateFullview.put(FsmEvent.MSG_AUTO_LOC_CAR_WHEN_TIMEOUT, FsmState.Fullview);
        dictStateFullview.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Fullview);
        dictStateFullview.put(FsmEvent.VIEW_CLICK_HIGHWAY_ENTER, "Highway");
        dictStateFullview.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransEnlargeRoadmap() {
        dictStateEnlargeRoadmap = new HashMap();
        dictStateEnlargeRoadmap.clear();
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateEnlargeRoadmap.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateEnlargeRoadmap.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE, FsmState.BACK);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.EnlargeRoadmap);
        dictStateEnlargeRoadmap.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
    }

    private static void initTransColladamap() {
        dictStateColladamap = new HashMap();
        dictStateColladamap.clear();
        dictStateColladamap.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateColladamap.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateColladamap.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateColladamap.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateColladamap.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateColladamap.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Colladamap);
        dictStateColladamap.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateColladamap.put(FsmEvent.MSG_COLLADA_HIDE, FsmState.BACK);
    }

    private static void initTransBrowseMap() {
        dictStateBrowseMap = new HashMap();
        dictStateBrowseMap.clear();
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_ZOOM, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateBrowseMap.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateBrowseMap.put("指南针点击", FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateBrowseMap.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateBrowseMap.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateBrowseMap.put(FsmEvent.MSG_AUTO_LOC_CAR_WHEN_TIMEOUT, FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.VIEW_CLICK_HIGHWAY_ENTER, "Highway");
        dictStateBrowseMap.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransHUD() {
        dictStateHUD = new HashMap();
        dictStateHUD.clear();
        dictStateHUD.put(FsmEvent.BTN_CLICK_AR, "AR");
        dictStateHUD.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateHUD.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateHUD.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateHUD.put(FsmEvent.MENU_CLICK_ROUTE_ITEM, FsmState.RouteItem);
        dictStateHUD.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateHUD.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateHUD.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransHUDMirror() {
        dictStateHUDMirror = new HashMap();
        dictStateHUDMirror.clear();
        dictStateHUDMirror.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateHUDMirror.put(FsmEvent.MSG_MIRROR_GOTO_HUD, "HUD");
        dictStateHUDMirror.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateHUDMirror.put(FsmEvent.BTN_CLICK_AR, "AR");
        dictStateHUDMirror.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateHUDMirror.put(FsmEvent.MENU_CLICK_ROUTE_ITEM, FsmState.RouteItem);
        dictStateHUDMirror.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateHUDMirror.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateHUDMirror.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransAR() {
        dictStateAR = new HashMap();
        dictStateAR.clear();
        dictStateAR.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateAR.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateAR.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateAR.put(FsmEvent.MSG_MIRROR_GOTO_HUD, "HUD");
        dictStateAR.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateAR.put(FsmEvent.MENU_CLICK_ROUTE_ITEM, FsmState.RouteItem);
        dictStateAR.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateAR.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateAR.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransRoutePlan() {
        dictStateRoutePlan = new HashMap();
        dictStateRoutePlan.clear();
        dictStateRoutePlan.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateRoutePlan.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateRoutePlan.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateRoutePlan.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransPickPoint() {
        dictStatePickPoint = new HashMap();
        dictStatePickPoint.clear();
        dictStatePickPoint.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStatePickPoint.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStatePickPoint.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStatePickPoint.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStatePickPoint.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStatePickPoint.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStatePickPoint.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStatePickPoint.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStatePickPoint.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateHUDMirror.put(FsmEvent.MSG_MIRROR_GOTO_HUD, "HUD");
        dictStatePickPoint.put(FsmEvent.BTN_CLICK_AR, "AR");
        dictStatePickPoint.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStatePickPoint.put(FsmEvent.MENU_CLICK_ROUTE_ITEM, FsmState.RouteItem);
        dictStatePickPoint.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStatePickPoint.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStatePickPoint.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStatePickPoint.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.PickPoint);
        dictStatePickPoint.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStatePickPoint.put(FsmEvent.DEST_PARK_SHOW, FsmState.Park);
    }

    private static void initTransHighway() {
        dictStateHighway = new HashMap();
        dictStateHighway.clear();
        dictStateHighway.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateHighway.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateHighway.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateHighway.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateHighway.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateHighway.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateHighway.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateHighway.put(FsmEvent.BTN_CLICK_AR, "AR");
        dictStateHighway.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateHighway.put(FsmEvent.MSG_MIRROR_GOTO_HUD, "HUD");
        dictStateHighway.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateHighway.put(FsmEvent.MENU_CLICK_ROUTE_ITEM, FsmState.RouteItem);
        dictStateHighway.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateHighway.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateHighway.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, "Highway");
        dictStateHighway.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateHighway.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateHighway.put("指南针点击", FsmState.PickPoint);
        dictStateHighway.put(FsmEvent.VIEW_CLICK_HIGHWAY_EXIT, FsmState.SimpleGuide);
        dictStateHighway.put(FsmEvent.CONTINUE_NAVI, "Highway");
        dictStateSimpleGuide.put(FsmEvent.DEST_PARK_SHOW, FsmState.Park);
    }

    private static void initTransRouteItem() {
        dictStateRouteItem = new HashMap();
        dictStateRouteItem.clear();
        dictStateRouteItem.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateRouteItem.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateRouteItem.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateRouteItem.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateRouteItem.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateRouteItem.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateRouteItem.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateRouteItem.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStateRouteItem.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateRouteItem.put(FsmEvent.MSG_MIRROR_GOTO_HUD, "HUD");
        dictStateRouteItem.put(FsmEvent.BTN_CLICK_AR, "AR");
        dictStateRouteItem.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStateRouteItem.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateRouteItem.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateRouteItem.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.RouteItem);
        dictStateRouteItem.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
    }

    private static void initTransPark() {
        dictStatePark = new HashMap();
        dictStatePark.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStatePark.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStatePark.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStatePark.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStatePark.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStatePark.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStatePark.put(FsmEvent.BTN_CLICK_HUD_ENTER, "HUD");
        dictStatePark.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStatePark.put(FsmEvent.MSG_MIRROR_GOTO_HUD, "HUD");
        dictStatePark.put(FsmEvent.BTN_CLICK_AR, "AR");
        dictStatePark.put(FsmEvent.MENU_CLICK_ROUTE_PLAN, "RoutePlan");
        dictStatePark.put(FsmEvent.MENU_CLICK_ROUTE_ITEM, FsmState.RouteItem);
        dictStatePark.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStatePark.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStatePark.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Park);
        dictStatePark.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStatePark.put("指南针点击", FsmState.PickPoint);
        dictStatePark.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
    }

    private static void initDictFSM() {
        dictFSM = new HashMap();
        dictFSM.clear();
        dictFSM.put(FsmState.SimpleGuide, dictStateSimpleGuide);
        dictFSM.put(FsmState.North2D, dictStateNorth2D);
        dictFSM.put(FsmState.Car3D, dictStateCar3D);
        dictFSM.put(FsmState.Fullview, dictStateFullview);
        dictFSM.put(FsmState.EnlargeRoadmap, dictStateEnlargeRoadmap);
        dictFSM.put(FsmState.Colladamap, dictStateColladamap);
        dictFSM.put(FsmState.BrowseMap, dictStateBrowseMap);
        dictFSM.put("HUD", dictStateHUD);
        dictFSM.put(FsmState.HUDMirror, dictStateHUDMirror);
        dictFSM.put("AR", dictStateAR);
        dictFSM.put("RoutePlan", dictStateRoutePlan);
        dictFSM.put(FsmState.PickPoint, dictStatePickPoint);
        dictFSM.put("Highway", dictStateHighway);
        dictFSM.put(FsmState.RouteItem, dictStateRouteItem);
        dictFSM.put(FsmState.Park, dictStatePark);
    }

    private static void initGlassStates() {
        glassStates = new ArrayList();
        glassStates.add(FsmState.North2D);
        glassStates.add(FsmState.Car3D);
        glassStates.add(FsmState.Fullview);
        glassStates.add(FsmState.BrowseMap);
    }

    public static boolean isGlassState(String state) {
        if (state == null || state.length() == 0) {
            return false;
        }
        return glassStates.contains(state);
    }

    public static String queryDestState(String sourceState, String event) {
        synchronized (lock) {
            HashMap<String, String> dictEventState = new HashMap();
            dictEventState = (HashMap) dictFSM.get(sourceState);
            if (dictEventState == null) {
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "不存在该状态对应的状态机，请完善逻辑!");
                return null;
            }
            String destState = (String) dictEventState.get(event);
            if (destState == null) {
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "处于状态 (" + sourceState + ")时， 不存在执行event = " + event + " 的跳转，请考虑是否完善逻辑!");
                return null;
            }
            return destState;
        }
    }

    public static boolean isNeedRefreshMapState(String state) {
        if (state == null || state.length() == 0) {
            return false;
        }
        if (FsmState.SimpleGuide.equals(state) || "Highway".equals(state)) {
            return true;
        }
        return false;
    }

    public static void destory() {
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
}
