package com.baidu.baidunavis.navirecover;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.platform.comapi.map.config.Preferences;

public class NaviRecoveryModel {
    private static final String NAVI_CRASH_TIME = "navi_crash_time";
    private static final String NAVI_NA_CRASH_TIME = "navi_na_crash_time";
    private static final String NAVI_RECOVER = "naviRecover";
    private static final String NAVI_RECOVER_TIME = "navi_recover_time";
    private static NaviRecoveryModel instance;
    private boolean mHasCalcRoute = false;
    private Preferences preferences = Preferences.build(NavMapAdapter.getInstance().getBaiduMapApplicationInstance(), NAVI_RECOVER);

    private NaviRecoveryModel() {
    }

    public static synchronized NaviRecoveryModel getInstance() {
        NaviRecoveryModel naviRecoveryModel;
        synchronized (NaviRecoveryModel.class) {
            if (instance == null) {
                synchronized (NaviRecoveryModel.class) {
                    if (instance == null) {
                        instance = new NaviRecoveryModel();
                    }
                }
            }
            naviRecoveryModel = instance;
        }
        return naviRecoveryModel;
    }

    public boolean markCrashTime(long time) {
        return this.preferences.putLong(NAVI_CRASH_TIME, time);
    }

    public boolean markNaCrashTime(long time) {
        return this.preferences.putLong(NAVI_NA_CRASH_TIME, time);
    }

    public long getNaCrashTime() {
        return this.preferences.getLong(NAVI_NA_CRASH_TIME, 0).longValue();
    }

    public long getCrashTime() {
        return this.preferences.getLong(NAVI_CRASH_TIME, 0).longValue();
    }

    public boolean markRecoverTime(long time) {
        return this.preferences.putLong(NAVI_RECOVER_TIME, time);
    }

    public long getRecoverTime() {
        return this.preferences.getLong(NAVI_RECOVER_TIME, 0).longValue();
    }

    public void setHasCalcRoute(boolean hasCalcRoute) {
        this.mHasCalcRoute = hasCalcRoute;
    }

    public boolean hasCalcRoute() {
        return this.mHasCalcRoute;
    }
}
