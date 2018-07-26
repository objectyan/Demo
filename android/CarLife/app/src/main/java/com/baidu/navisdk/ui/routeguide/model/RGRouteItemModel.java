package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.ui.routeguide.subview.BNavR;
import java.util.ArrayList;
import java.util.List;

public class RGRouteItemModel {
    private static RGRouteItemModel sInstance = null;
    private int mFocusRouteItemIndex = 0;
    private List<RouteItem> mRouteItems = new ArrayList();

    public static class RouteItem {
        public static final int Type_End = 3;
        public static final int Type_Normal = 0;
        public static final int Type_Start = 1;
        public static final int Type_Via = 2;
        public int curRoadDist = -1;
        public int latitude = 0;
        public int longitude = 0;
        public String nextRoadName = null;
        public int originTurnType = -1;
        public int turnIconResId = -1;
        public int type = 0;

        public RouteItem(int turnType, int pCurRoadDist, String pNextRoadName, int longi, int lati) {
            this.originTurnType = turnType;
            this.curRoadDist = pCurRoadDist;
            this.nextRoadName = pNextRoadName;
            this.longitude = longi;
            this.latitude = lati;
            if (this.originTurnType >= 0 && this.originTurnType < BNavR.gTurnIconID.length) {
                this.turnIconResId = BNavR.gTurnIconID[this.originTurnType];
            }
        }

        public boolean isValid() {
            if (this.turnIconResId == -1 || this.curRoadDist == -1 || this.nextRoadName == null) {
                return false;
            }
            return true;
        }
    }

    public static RGRouteItemModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGRouteItemModel();
        }
        return sInstance;
    }

    private RGRouteItemModel() {
    }

    public void updateRouteItems(List<RouteItem> list) {
        if (list != null && list.size() != 0 && this.mRouteItems != null) {
            this.mRouteItems.clear();
            this.mRouteItems.addAll(list);
        }
    }

    public List<RouteItem> getRouteItems() {
        return this.mRouteItems;
    }

    public void updateFocusItemIndex(int index) {
        this.mFocusRouteItemIndex = index;
    }

    public int getFocusItemIndex() {
        return this.mFocusRouteItemIndex;
    }

    public void reset() {
        if (this.mRouteItems != null) {
            this.mRouteItems.clear();
        }
    }
}
