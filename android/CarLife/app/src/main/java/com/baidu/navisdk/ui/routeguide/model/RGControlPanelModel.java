package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.NaviStatItem;

public class RGControlPanelModel {
    public static final int ADJUST_LEVEL = 0;
    public static final int Control_Manual_Panel_Auto_Hide_Timeout = 10000;
    public static final int INVALID = -1;
    public static final int LOCATE_STATUS_CAR_3D = 1;
    public static final int LOCATE_STATUS_LOC_CAR = 3;
    public static final int LOCATE_STATUS_NORTH_2D = 2;
    public static final int LOCATE_STATUS_QUIT_NAV = 4;
    public static final long LocView_Auto_Hide_Timeout = 5500;
    public static final int NOT_ADJUST_LEVEL = 1;
    private static final String TAG = "RGControlPanelModel";
    private static RGControlPanelModel mInstance = null;
    public static boolean mIsMenuMoreVisible = false;
    public static boolean mIsMenuVisible = false;
    public static boolean mIsRouteSearchVisible = false;
    public static boolean sIsBlueToothUSBGuideVisible = false;
    public static boolean sIsRouteSortViewVisible = false;
    private int mCurLocateStatus;
    private boolean mHasChangeLevel = false;
    private boolean mIsAnologPlaying = true;
    private boolean mIsConfigChange = false;
    private boolean mIsFullviewBeforeEnlargeMap = false;
    private boolean mIsFullviewState = false;
    private boolean mIsParkSearching = false;
    private int mLevelBeforeParkSerach = 18;
    public boolean mNeedAnimForFullview = true;
    private String navState = NavState.NAV_STATE_NAVING;
    public int sAdjustLevel = -1;

    public static RGControlPanelModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGControlPanelModel();
        }
        return mInstance;
    }

    public void updateLocateStatus(int locateStatus) {
        this.mCurLocateStatus = locateStatus;
    }

    public int getLocateStatus() {
        return this.mCurLocateStatus;
    }

    public void updateFullviewState(boolean isFullview) {
        if (isFullview) {
            NaviStatItem.getInstance().setStartFullViewTime();
        } else {
            NaviStatItem.getInstance().setFullViewRealTime();
        }
        this.mIsFullviewState = isFullview;
    }

    public boolean getFullviewState() {
        return this.mIsFullviewState;
    }

    public void updateAnologPlaying(boolean isPlaying) {
        this.mIsAnologPlaying = isPlaying;
    }

    public boolean isAnologPlaying() {
        return this.mIsAnologPlaying;
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset");
        this.mIsAnologPlaying = true;
        resetAdjustLevel();
    }

    public String getNavState() {
        return this.navState;
    }

    public void setNavState(String navState) {
        this.navState = navState;
    }

    public boolean ismIsParkSearching() {
        return this.mIsParkSearching;
    }

    public void setmIsParkSearching(boolean mIsParkSearching) {
        this.mIsParkSearching = mIsParkSearching;
    }

    public boolean ismIsConfigChange() {
        return this.mIsConfigChange;
    }

    public void setmIsConfigChange(boolean mIsConfigChange) {
        this.mIsConfigChange = mIsConfigChange;
    }

    public int getmLevelBeforeParkSerach() {
        return this.mLevelBeforeParkSerach;
    }

    public void setmLevelBeforeParkSerach(int mLevelBeforeParkSerach) {
        this.mLevelBeforeParkSerach = mLevelBeforeParkSerach;
    }

    public boolean ismHasChangeLevel() {
        return this.mHasChangeLevel;
    }

    public void setmHasChangeLevel(boolean mHasChangeLevel) {
        this.mHasChangeLevel = mHasChangeLevel;
    }

    public boolean ismIsFullviewBeforeEnlargeMap() {
        return this.mIsFullviewBeforeEnlargeMap;
    }

    public void setmIsFullviewBeforeEnlargeMap(boolean mIsFullviewBeforeEnlargeMap) {
        this.mIsFullviewBeforeEnlargeMap = mIsFullviewBeforeEnlargeMap;
    }

    public void resetAdjustLevel() {
        this.sAdjustLevel = -1;
    }

    public boolean isNeedAdjustLevel() {
        return this.sAdjustLevel == 0;
    }
}
