package com.baidu.navisdk.ui.widget;

public class RouteDetailDataModel {
    public RouteDirect routeDirect;
    public String routeDistance;
    public String routeName;
    public RouteStatus routeStatus;

    public enum RouteDirect {
        STRAIGHT,
        LEFT,
        RIGHT
    }

    public enum RouteStatus {
        NONE,
        CLEAR,
        NORMAL,
        CROWED,
        SNAIL
    }

    public RouteDetailDataModel(RouteStatus routeStatus, RouteDirect routeDirect, String routeName, String routeDistance) {
        this.routeStatus = routeStatus;
        this.routeDirect = routeDirect;
        this.routeName = routeName;
        this.routeDistance = routeDistance;
    }
}
