package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.geolocate.ILocationChangeListener;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGJamReportModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.NaviStatItem;

class BNavigator$11 extends ILocationChangeListener {
    final /* synthetic */ BNavigator this$0;

    BNavigator$11(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onLocationChange(LocData locData) {
    }

    public void onGpsStatusChange(boolean enabled, boolean available) {
        LogUtil.m15791e("sunhao", "onGpsStatusChange() enabled=" + enabled + ", available=" + available);
        if (BNSettingManager.isShowJavaLog()) {
            TipTool.onCreateToastDialog(BNavigator.access$1100(this.this$0), "来自应用: onGpsStatusChange enabled=" + enabled + ", available=" + available);
            SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From app: onGpsStatusChange enabled=" + enabled + ", available=" + available);
        }
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_GPS, "From app: onGpsStatusChange enabled=" + enabled + ", available=" + available);
        if (BNavigator.access$1000(this.this$0) != null) {
            BNavigator.access$1000(this.this$0).notifyGPSStatusData(enabled ? 4 : 5);
        }
        if (enabled) {
            RGAssistGuideModel.getInstance().mIsGPSEnable = true;
        } else {
            RGAssistGuideModel.getInstance().mIsGPSEnable = false;
        }
        RGViewController.getInstance().updateCurCarSpeed();
    }

    public void onWGS84LocationChange(LocData locData, LocData gcj02LocData) {
        NaviStatItem.getInstance().onGpsLocated();
        NaviIPOStatItem.getInstance().onGpsLocated();
        BNavigator.access$1202(this.this$0, locData);
        if (BNavigator.access$1000(this.this$0) != null) {
            BNavigator.access$1000(this.this$0).notifyLoacteData(locData.clone());
        }
        if (SDKDebugFileUtil.getInstance().isShowCoreLog(2, 0, locData.satellitesNum, null, null)) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_GPS, "sysloc=long:" + (locData.longitude * 100000.0d) + ", lati:" + (locData.latitude * 100000.0d) + ", speed:" + locData.speed + ", direction:" + locData.direction + ", accuracy:" + locData.accuracy + ", locType:" + locData.locType + ", satellitesNum:" + locData.satellitesNum);
        }
        if (locData.locType == 0) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onLocationChange TYPE_LOC_GPS  longitude:" + locData.longitude + ", latitude:" + locData.latitude);
            BNRouteGuider.getInstance().triggerGPSDataChange((int) (locData.longitude * 100000.0d), (int) (locData.latitude * 100000.0d), locData.speed, locData.direction, locData.accuracy, (float) locData.altitude, locData.satellitesNum, locData.locType);
            if (BNSettingManager.isShowJavaLog()) {
                SDKDebugFileUtil.get(SDKDebugFileUtil.NAVING_SYSLOC_FILENAME).add("sysloc=long:" + (locData.longitude * 100000.0d) + ", lati:" + (locData.latitude * 100000.0d) + ", speed:" + locData.speed + ", direction:" + locData.direction + ", accuracy:" + locData.accuracy + ", locType:" + locData.locType + ", satellitesNum:" + locData.satellitesNum);
            }
            BusinessActivityManager.getInstance().updateGPSSpeed((double) locData.speed);
        }
        if (locData.locType == 1 && BNavigator.access$1300(this.this$0)) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onLocationChange TYPE_LOC_WIFI  longitude:" + locData.longitude + ", latitude:" + locData.latitude);
            BNRouteGuider.getInstance().triggerGPSDataChange((int) (locData.longitude * 100000.0d), (int) (locData.latitude * 100000.0d), locData.speed, locData.direction, locData.accuracy, (float) locData.altitude, locData.satellitesNum, locData.locType);
            if (BNSettingManager.isShowJavaLog()) {
                SDKDebugFileUtil.get(SDKDebugFileUtil.NAVING_SYSLOC_FILENAME).add("sysloc=long:" + (locData.longitude * 100000.0d) + ", lati:" + (locData.latitude * 100000.0d) + ", speed:" + locData.speed + ", direction:" + locData.direction + ", accuracy:" + locData.accuracy + ", locType:" + locData.locType + ", satellitesNum:" + locData.satellitesNum);
            }
        }
        if (locData.locType == 0) {
            BNRouteGuider.getInstance().triggerStartLocationData((int) (locData.longitude * 100000.0d), (int) (locData.latitude * 100000.0d), (float) locData.altitude, locData.speed, locData.direction, locData.accuracy, 1, 0);
        } else {
            BNRouteGuider.getInstance().triggerStartLocationData((int) (locData.longitude * 100000.0d), (int) (locData.latitude * 100000.0d), (float) locData.altitude, locData.speed, locData.direction, locData.accuracy, 2, 0);
        }
        RGAssistGuideModel.getInstance().updateCurCarSpeed((double) locData.speed);
        RGViewController.getInstance().updateCurCarSpeed();
        RGViewController.getInstance().updateHudAssistInfo();
        RGViewController.getInstance().showRGSimpleGuideSuitableView();
        BusinessActivityManager.getInstance().updateGPSSpeed((double) locData.speed);
        if (RGJamReportModel.getInstance().isJamming() && !RGJamReportModel.getInstance().isHasJamReportShown() && RGJamReportModel.getInstance().speedCheck(locData.speed)) {
            BNavigator.access$1400(this.this$0);
        }
    }
}
