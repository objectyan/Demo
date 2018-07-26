package com.baidu.navi;

import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;

public class BaiduNaviSDKManager {
    public static final String TAG = BaiduNaviSDKManager.class.getSimpleName();
    private static volatile BaiduNaviSDKManager mInstance = null;

    public static BaiduNaviSDKManager getInstance() {
        if (mInstance == null) {
            synchronized (BaiduNaviSDKManager.class) {
                if (mInstance == null) {
                    mInstance = new BaiduNaviSDKManager();
                }
            }
        }
        return mInstance;
    }

    public boolean isNaviBegin() {
        return BNavigator.getInstance().isNaviBegin();
    }

    public void quitNavi() {
        BNavigator.getInstance().quitNavi();
    }

    public boolean isCruiseBegin() {
        return BCruiser.getInstance().isCruiseBegin();
    }

    public void quitCruise() {
        BCruiser.getInstance().notifyCruiseFragmentQuitCruise();
    }

    public void reInitNaviLocationService(int pRGLocateMode) {
        BNavigator.getInstance().reInitLocationService(pRGLocateMode);
    }

    public void reInitCruiseLocationService() {
        BCruiser.getInstance().reInitLocationService();
    }

    public void reInitTrackLocationService() {
        NavTrajectoryController.getInstance().reInitLocationService();
    }

    public void updateWGS84Location(LocData wgsLocData, LocData gcjLocData) {
        BNExtGPSLocationManager.getInstance().updateWGS84Location(wgsLocData, gcjLocData);
    }

    public void updateRGEngineSpeekStatus() {
        BNavigator.getInstance().updateRGEngineSpeekStatus();
    }

    public boolean isNaviMuteState() {
        return TTSPlayerControl.isNaviMuteState();
    }

    public void setNaviMuteState(boolean isMute) {
        TTSPlayerControl.setNaviMuteState(isMute);
    }

    public void closeNaviInstant() {
        JNIGuidanceControl.getInstance().setFuncConfigParams(true, RGMultiRouteModel.DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS, 1);
    }

    public void updateNaviInstant() {
        BNRoutePlaner.getInstance().updateFuncConfigParams();
    }

    public void enterNavState() {
        BNavigator.getInstance().enterNavState();
    }
}
