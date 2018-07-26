package com.baidu.baidunavis.model;

public class NavSearchCircle {
    public NavGeoPoint mCenter;
    public int mRadius;

    public NavSearchCircle(NavGeoPoint center, int radius) {
        this.mCenter = center;
        this.mRadius = radius;
    }

    public NavSearchCircle(int longitude, int latitude, int radius) {
        this.mCenter = new NavGeoPoint(longitude, latitude);
        this.mRadius = radius;
    }
}
