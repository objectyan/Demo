package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.jni.nativeif.JNIUgcRoadControl;
import com.baidu.navisdk.model.datastruct.UgcPointInfo;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RGUgcRoadModel {
    private static final String BUNDLE_UGCINFO_DISTRICT = "BUNDLE_UGCINFO_DISTRICT";
    private static final String BUNDLE_UGCINFO_GEOPOINT = "BUNDLE_UGCINFO_GEOPOINT";
    private static final String BUNDLE_UGCINFO_ID = "BUNDLE_UGCINFO_ID";
    private static final String BUNDLE_UGCINFO_POINT_X = "BUNDLE_UGCINFO_POINT_X";
    private static final String BUNDLE_UGCINFO_POINT_Y = "BUNDLE_UGCINFO_POINT_Y";
    private static final String BUNDLE_UGCINFO_ROAD_NAME = "BUNDLE_UGCINFO_ROAD_NAME";
    private static final String BUNDLE_UGCINFO_SYNC_STATUS = "BUNDLE_UGCINFO_SYNC_STATUS";
    private static final String BUNDLE_UGCINFO_TIME = "BUNDLE_UGCINFO_TIME";
    private static final String BUNDLE_UGCINFO_TYPE = "BUNDLE_UGCINFO_TYPE";
    private static RGUgcRoadModel sInstance = null;
    private List<UgcPointInfo> mUgcYawItems = new ArrayList();
    private int ugcItemType = -1;

    public static RGUgcRoadModel getInstance() {
        if (sInstance == null) {
            sInstance = new RGUgcRoadModel();
        }
        return sInstance;
    }

    private RGUgcRoadModel() {
    }

    public int getUgcItemType() {
        return this.ugcItemType;
    }

    public void setUgcItemType(int ugcItemType) {
        this.ugcItemType = ugcItemType;
    }

    public void updateUgcYawItems(List<UgcPointInfo> list) {
        reset();
        if (list != null && list.size() != 0 && this.mUgcYawItems != null) {
            this.mUgcYawItems.clear();
            this.mUgcYawItems.addAll(list);
        }
    }

    public int getUgcYawItemsNum() {
        if (this.mUgcYawItems != null) {
            return this.mUgcYawItems.size();
        }
        return 0;
    }

    public List<UgcPointInfo> getUgcYawItems() {
        return this.mUgcYawItems;
    }

    public void reset() {
        if (this.mUgcYawItems != null) {
            this.mUgcYawItems.clear();
        }
    }

    public ArrayList<UgcPointInfo> getUgcYawPointList() {
        ArrayList<Bundle> bundleList = new ArrayList();
        JNIUgcRoadControl.sInstance.getCurYawPoint(bundleList, 10);
        LogUtil.m15791e("RGUgcRoadModel", "getUgcYawPointList unYawPointCnt = " + 10);
        ArrayList<UgcPointInfo> ugcPointInfoList = new ArrayList();
        if (!(bundleList == null || bundleList.isEmpty())) {
            Iterator it = bundleList.iterator();
            while (it.hasNext()) {
                Bundle bundle = (Bundle) it.next();
                UgcPointInfo ugcPointInfo = new UgcPointInfo();
                ugcPointInfo.mUgcPointRoadName = bundle.getString(BUNDLE_UGCINFO_ROAD_NAME);
                ugcPointInfo.mUgPermitType = bundle.getInt(BUNDLE_UGCINFO_TYPE);
                Bundle viewPointBundle = bundle.getBundle(BUNDLE_UGCINFO_GEOPOINT);
                if (viewPointBundle != null) {
                    LogUtil.m15791e("RGUgcRoadModel", "getUgcYawPointList  viewPointBundle!=null:");
                    ugcPointInfo.longitude = viewPointBundle.getInt("lon");
                    ugcPointInfo.latitude = viewPointBundle.getInt("lat");
                    ugcPointInfo.setUgcViewPoint(viewPointBundle.getInt("lon"), viewPointBundle.getInt("lat"));
                }
                LogUtil.m15791e("RGUgcRoadModel", "getUgcYawPointList  ugcPointInfo.mUgPermitType:" + ugcPointInfo.mUgPermitType + "  ugcPointInfo.mUgcPointRoadName:" + ugcPointInfo.mUgcPointRoadName + "  ugcPointInfo.lon:" + ugcPointInfo.longitude + "  ugcPointInfo.lat:" + ugcPointInfo.latitude);
                ugcPointInfoList.add(ugcPointInfo);
            }
        }
        return ugcPointInfoList;
    }

    public ArrayList<UgcPointInfo> getUgcManagerInfoList() {
        ArrayList<Bundle> bundleList = new ArrayList();
        JNIUgcRoadControl.sInstance.getAllItems(bundleList, 0);
        LogUtil.m15791e("RGUgcRoadModel", "getUgcManagerInfoList unYawPointCnt = " + 0);
        ArrayList<UgcPointInfo> ugcPointInfoList = new ArrayList();
        if (!(bundleList == null || bundleList.isEmpty())) {
            Iterator it = bundleList.iterator();
            while (it.hasNext()) {
                Bundle bundle = (Bundle) it.next();
                UgcPointInfo ugcPointInfo = new UgcPointInfo();
                ugcPointInfo.mUgcId = bundle.getString(BUNDLE_UGCINFO_ID);
                ugcPointInfo.mUgcSyncStatus = bundle.getInt(BUNDLE_UGCINFO_SYNC_STATUS);
                ugcPointInfo.mUgcType = bundle.getInt(BUNDLE_UGCINFO_TYPE);
                ugcPointInfo.mUgcPointRoadName = bundle.getString(BUNDLE_UGCINFO_ROAD_NAME);
                ugcPointInfo.mUgcTime = bundle.getString(BUNDLE_UGCINFO_TIME);
                ugcPointInfo.mUgcDistrictName = bundle.getString(BUNDLE_UGCINFO_DISTRICT);
                Bundle viewPointBundle = bundle.getBundle(BUNDLE_UGCINFO_GEOPOINT);
                if (viewPointBundle != null) {
                    LogUtil.m15791e("RGUgcRoadModel", "getUgcManagerInfoList  viewPointBundle!=null:");
                    ugcPointInfo.longitude = viewPointBundle.getInt("lon");
                    ugcPointInfo.latitude = viewPointBundle.getInt("lat");
                    ugcPointInfo.setUgcViewPoint(viewPointBundle.getInt("lon"), viewPointBundle.getInt("lat"));
                }
                LogUtil.m15791e("RGUgcRoadModel", "getUgcManagerInfoList  ugcPointInfo.mUgcId:" + ugcPointInfo.mUgcId + "  ugcPointInfo.mUgcSyncStatus:" + ugcPointInfo.mUgcSyncStatus + "  ugcPointInfo.mUgcType:" + ugcPointInfo.mUgcType + "  ugcPointInfo.mUgcPointRoadName:" + ugcPointInfo.mUgcPointRoadName + "  ugcPointInfo.mUgcTime:" + ugcPointInfo.mUgcTime + "  ugcPointInfo.lon:" + ugcPointInfo.longitude + "  ugcPointInfo.lat:" + ugcPointInfo.latitude);
                ugcPointInfoList.add(ugcPointInfo);
            }
        }
        return ugcPointInfoList;
    }
}
