package com.baidu.navisdk.lightnavi.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class BNCommonAddressItem {
    public static final int ADDR_TYPE_COMPANY = 2;
    public static final int ADDR_TYPE_CUR_LOCATION = 5;
    public static final int ADDR_TYPE_FAV = 3;
    public static final int ADDR_TYPE_HOME = 1;
    private String addressDesc;
    private int cityId = -1;
    private GeoPoint guideGeoPoint;
    private String name;
    private String poiOriginUID;
    private RoutePlanNode routePlanNodeGCJ = null;
    private int type;
    private GeoPoint viewGeoPoint;

    public static class LightNaviRoutePlanModel {
        private int currentETASecs;
        private int currentPlanedDistance;
        private int maxETA;

        private static class LazyLoader {
            private static LightNaviRoutePlanModel instance = new LightNaviRoutePlanModel();

            private LazyLoader() {
            }
        }

        private LightNaviRoutePlanModel() {
            this.currentETASecs = 0;
            this.currentPlanedDistance = 0;
            this.maxETA = 0;
        }

        public static LightNaviRoutePlanModel getInstance() {
            return LazyLoader.instance;
        }

        public void parseRouteResultOutlineLightNavi() {
            this.currentETASecs = 0;
            this.currentPlanedDistance = 0;
            this.maxETA = 0;
            Bundle remainBundle = new Bundle();
            BNLightNaviManager.getInstance().getRemianDisAndTime(remainBundle);
            this.currentPlanedDistance = remainBundle.getInt("remainDis");
            this.currentETASecs = remainBundle.getInt("remainTime");
            int routeCnt = BNRoutePlaner.getInstance().getRouteCnt();
            for (int index = 0; index < routeCnt; index++) {
                Bundle outlineBundle = new Bundle();
                BNRoutePlaner.getInstance().getRouteInfo(index, outlineBundle);
                int tmp = outlineBundle.getInt(SimpleGuideInfo.TotalTime);
                if (this.maxETA < tmp) {
                    this.maxETA = tmp;
                }
            }
        }

        public int getCurrentETASecs() {
            return this.currentETASecs;
        }

        public void setCurrentETASecs(int currentETASecs) {
            this.currentETASecs = currentETASecs;
        }

        public int getCurrentPlanedDistance() {
            return this.currentPlanedDistance;
        }

        public void setCurrentPlanedDistance(int currentPlanedDistance) {
            this.currentPlanedDistance = currentPlanedDistance;
        }

        public int getMaxETA() {
            return this.maxETA;
        }

        public void setMaxETA(int maxETA) {
            this.maxETA = maxETA;
        }
    }

    public BNCommonAddressItem(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddressDesc() {
        return this.addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public GeoPoint getGuideGeoPoint() {
        return this.guideGeoPoint;
    }

    public void setGuideGeoPoint(GeoPoint guideGeoPoint) {
        this.guideGeoPoint = guideGeoPoint;
    }

    public GeoPoint getViewGeoPoint() {
        return this.viewGeoPoint;
    }

    public void setViewGeoPoint(GeoPoint viewGeoPoint) {
        this.viewGeoPoint = viewGeoPoint;
    }

    public String getPoiOriginUID() {
        return this.poiOriginUID;
    }

    public void setPoiOriginUID(String poiOriginUID) {
        this.poiOriginUID = poiOriginUID;
    }

    public RoutePlanNode getRoutePlanNode() {
        if (this.routePlanNodeGCJ != null) {
            return this.routePlanNodeGCJ;
        }
        switch (this.type) {
            case 1:
                this.routePlanNodeGCJ = new RoutePlanNode(this.guideGeoPoint, this.viewGeoPoint, 4, this.name, this.addressDesc);
                break;
            case 2:
                this.routePlanNodeGCJ = new RoutePlanNode(this.guideGeoPoint, this.viewGeoPoint, 5, this.name, this.addressDesc);
                break;
            default:
                this.routePlanNodeGCJ = new RoutePlanNode(this.guideGeoPoint, this.viewGeoPoint, 0, this.name, this.addressDesc);
                break;
        }
        return this.routePlanNodeGCJ;
    }

    public boolean isValid() {
        return (this.name == null || this.guideGeoPoint == null || !this.guideGeoPoint.isValid()) ? false : true;
    }

    public String toString() {
        return "type = " + this.type + ", name = " + this.name + ", cityId = " + this.cityId + ", guideGeoPoint = " + this.guideGeoPoint;
    }
}
