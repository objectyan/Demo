package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class RGPickPointModel {
    private static final String TAG = "RGPickPointModel";
    private static RGPickPointModel sInstance = null;
    private boolean isPickPointShow = false;
    private SearchPoi mAntiSearchPoi = null;
    private GeoPoint mPickPointGeo = null;

    public boolean isPickPointShow() {
        return this.isPickPointShow;
    }

    public void setPickPointShow(boolean isPickPointShow) {
        this.isPickPointShow = isPickPointShow;
    }

    public static RGPickPointModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGPickPointModel();
        }
        return sInstance;
    }

    private RGPickPointModel() {
    }

    public void updatePickPoint(GeoPoint gp) {
        this.mPickPointGeo = gp;
    }

    public GeoPoint getPickPoint() {
        return this.mPickPointGeo;
    }

    public void updateAntiSearchPoi(SearchPoi sp) {
        this.mAntiSearchPoi = sp;
    }

    public SearchPoi getAntiSearchPoi() {
        return this.mAntiSearchPoi;
    }

    public void reset() {
        LogUtil.m15791e(TAG, "reset");
        this.mAntiSearchPoi = null;
        this.mPickPointGeo = null;
        this.isPickPointShow = false;
    }
}
