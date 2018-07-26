package com.baidu.navisdk.lightnavi.controller;

import android.os.Message;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;

public class BNLightNaviSwitchManager {
    private static volatile BNLightNaviSwitchManager mInstance;
    private int handlerID;
    private volatile boolean mHaveSwitched = false;
    private volatile boolean mIsRefreashRoute = false;
    private volatile boolean mIsSwitching = false;
    private NormalNaviSwitchSlightListener mNormalNaviSwitchSlightListener = null;

    public interface NormalNaviSwitchSlightListener {
        void onSwitchNormalNaviToSLight(Message message);
    }

    private BNLightNaviSwitchManager() {
    }

    public static BNLightNaviSwitchManager getInstance() {
        if (mInstance == null) {
            synchronized (BNLightNaviSwitchManager.class) {
                if (mInstance == null) {
                    mInstance = new BNLightNaviSwitchManager();
                }
            }
        }
        return mInstance;
    }

    public boolean getHaveSwitched() {
        return this.mHaveSwitched;
    }

    public void setHaveSwitched(boolean haveSwitched) {
        this.mHaveSwitched = haveSwitched;
    }

    public boolean isSwitching() {
        return this.mIsSwitching;
    }

    public void setIsSwitching(boolean isSwitching) {
        this.mIsSwitching = isSwitching;
    }

    public boolean isRefreashRoute() {
        return this.mIsRefreashRoute;
    }

    public void setIsRefreashRoute(boolean isRefreashRoute) {
        this.mIsRefreashRoute = isRefreashRoute;
    }

    public void setNormalNaviSwitchSlightListener(NormalNaviSwitchSlightListener lis) {
        this.mNormalNaviSwitchSlightListener = lis;
    }

    public void onSwitchNormalNaviToSLight(Message msg) {
        if (this.mNormalNaviSwitchSlightListener != null) {
            this.mNormalNaviSwitchSlightListener.onSwitchNormalNaviToSLight(msg);
        }
    }

    public void naviSwitchingCalcRoute(int type) {
        this.handlerID = BNRouteGuider.getInstance().naviSwitchingCalcRoute(type);
        setIsSwitching(true);
    }

    public void cancleRoutePlan() {
        if (this.handlerID > 0) {
            BNRouteGuider.getInstance().cancelCalcRoute(this.handlerID);
        }
    }

    public boolean isCurDriveRouteOnline() {
        return BNRouteGuider.getInstance().isCurDriveRouteOnline();
    }

    public boolean switch2AlternativeRoute(int type) {
        if (!BNRouteGuider.getInstance().switch2AlternativeRoute(type)) {
            return false;
        }
        setIsRefreashRoute(true);
        return true;
    }

    public void unInit() {
        this.mHaveSwitched = false;
        mInstance = null;
    }
}
