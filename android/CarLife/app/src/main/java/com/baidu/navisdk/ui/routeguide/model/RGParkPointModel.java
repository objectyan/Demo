package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class RGParkPointModel {
    private static RGParkPointModel sInstance = null;
    private boolean mCanShow = true;
    private boolean mDoneWithParkSearch = false;
    private boolean mIsParkPointShow = false;
    private SearchParkPoi mNeareastSearchParkPoi = null;
    private int mParkPointIndex = -1;
    private GeoPoint mPickPointGeo = null;
    private SearchParkPoi mSearchParkPoi = null;

    public static RGParkPointModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGParkPointModel();
        }
        return sInstance;
    }

    private RGParkPointModel() {
    }

    public void updateParkPoint(GeoPoint gp) {
        this.mPickPointGeo = gp;
    }

    public GeoPoint getParkPoint() {
        return this.mPickPointGeo;
    }

    public void updateParkPoi(SearchParkPoi sp) {
        this.mSearchParkPoi = sp;
    }

    public SearchParkPoi getParkPoi() {
        return this.mSearchParkPoi;
    }

    public void updateNeareastParkPoi(SearchParkPoi sp) {
        this.mNeareastSearchParkPoi = sp;
    }

    public SearchParkPoi getNeareastParkPoi() {
        return this.mNeareastSearchParkPoi;
    }

    public void reset() {
        this.mSearchParkPoi = null;
        this.mNeareastSearchParkPoi = null;
        this.mPickPointGeo = null;
        this.mParkPointIndex = -1;
        this.mIsParkPointShow = false;
    }

    public void updateParkPoiIndex(int index) {
        this.mParkPointIndex = index;
    }

    public int getParkPoiIndex() {
        return this.mParkPointIndex;
    }

    public void setCanParkPoiShow(boolean canShow) {
        this.mCanShow = canShow;
    }

    public boolean getCanParkPoiShow() {
        return this.mCanShow;
    }

    public void setDoneWithParkSearch(boolean done) {
        this.mDoneWithParkSearch = done;
    }

    public boolean getDoneWithParkSearch() {
        return this.mDoneWithParkSearch;
    }

    public boolean ismIsParkPointShow() {
        return this.mIsParkPointShow;
    }

    public void setmIsParkPointShow(boolean mIsParkPointShow) {
        this.mIsParkPointShow = mIsParkPointShow;
    }
}
