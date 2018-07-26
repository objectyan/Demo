package com.baidu.navisdk.module.ugc.data.datastatus;

import java.util.ArrayList;

public class InNaviRouteProStatus {
    private ArrayList<RouteProInfo> routeProInfoList = new ArrayList();

    public class RouteProInfo {
        private int type = -1;

        RouteProInfo(int type) {
        }
    }

    private void addNewRoutePro(RouteProInfo mRouteProInfo) {
        if (this.routeProInfoList != null) {
            this.routeProInfoList.add(mRouteProInfo);
        }
    }

    private void clear() {
        if (this.routeProInfoList != null) {
            this.routeProInfoList.clear();
        }
    }
}
