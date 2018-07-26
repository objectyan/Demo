package com.baidu.che.codriver.util;

import com.baidu.che.codriver.sdk.p081a.C2607m;

public class LocationUtil implements INoProguard {
    public static final String COORDINATE_SYSTEM_BD09 = "bd09ll";
    public static final String COORDINATE_SYSTEM_GCJ02 = "gcj02ll";
    private static LocationUtil mInstance;
    private String mCoordinateSystem = COORDINATE_SYSTEM_GCJ02;
    private C2607m mNaviTool;

    private LocationUtil() {
    }

    public static LocationUtil getInstance() {
        if (mInstance == null) {
            synchronized (LocationUtil.class) {
                if (mInstance == null) {
                    mInstance = new LocationUtil();
                    LocationUtil locationUtil = mInstance;
                    return locationUtil;
                }
            }
        }
        return mInstance;
    }

    public String getCoordinateSysmem() {
        return this.mCoordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.mCoordinateSystem = coordinateSystem;
    }

    public void setNaviTool(C2607m tool) {
        this.mNaviTool = tool;
    }

    public boolean isReady() {
        return this.mNaviTool == null ? false : this.mNaviTool.isLocationReady();
    }

    public String getCity() {
        return this.mNaviTool == null ? "" : this.mNaviTool.getCity();
    }

    public double getLatitude() {
        return this.mNaviTool == null ? 39.912733d : this.mNaviTool.getLatitude();
    }

    public double getLongitude() {
        return this.mNaviTool == null ? 116.403963d : this.mNaviTool.getLongitude();
    }

    public double calculateDistance(double lat, double lng) {
        return this.mNaviTool == null ? -1.0d : this.mNaviTool.calculateDistance(lat, lng);
    }

    public double getLatitudeBd09ll() {
        return this.mNaviTool == null ? 39.912733d : this.mNaviTool.getLatitudeBd09ll();
    }

    public double getLongitudeBd09ll() {
        return this.mNaviTool == null ? 116.403963d : this.mNaviTool.getLongitudeBd09ll();
    }

    public double getLatitudeBd09mc() {
        return this.mNaviTool == null ? 4443113.458d : this.mNaviTool.getLatitudeBd09mc();
    }

    public double getLongitudeBd09mc() {
        return this.mNaviTool == null ? 1.2474104174E7d : this.mNaviTool.getLongitudeBd09mc();
    }
}
