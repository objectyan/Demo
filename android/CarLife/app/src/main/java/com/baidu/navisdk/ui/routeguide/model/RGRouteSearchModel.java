package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.util.common.LogUtil;

public class RGRouteSearchModel {
    public static final int Control_Route_Search_Auto_Exit_Timeout = 60000;
    private static final String TAG = "RGRouteSearchModel";
    private static RGRouteSearchModel mInstance = null;
    public boolean isSearching = false;
    private int mLastBkgItemId = -1;
    private String mLastKey = "";
    private boolean mRouteSearchMode = false;
    public SearchPoiPager mSearchPoiPager;

    public static RGRouteSearchModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGRouteSearchModel();
        }
        return mInstance;
    }

    public void setRouteSearchMode(boolean mode) {
        this.mRouteSearchMode = mode;
    }

    public boolean isRouteSearchMode() {
        return this.mRouteSearchMode;
    }

    public void setLastBkgItemId(int id) {
        this.mLastBkgItemId = id;
    }

    public int getLastBkgItemId() {
        return this.mLastBkgItemId;
    }

    public void resetLastBkgItemId() {
        this.mLastBkgItemId = -1;
    }

    public String getmLastKey() {
        return this.mLastKey;
    }

    public void setmLastKey(String mLastKey) {
        this.mLastKey = mLastKey;
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset");
        this.mRouteSearchMode = false;
        this.isSearching = false;
        this.mLastBkgItemId = -1;
        this.mLastKey = "";
    }
}
