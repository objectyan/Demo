package com.baidu.navisdk.lightnavi.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;

public class LightNaviRoutePlanModel {
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
