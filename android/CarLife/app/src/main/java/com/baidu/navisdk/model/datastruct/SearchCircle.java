package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class SearchCircle {
    public GeoPoint mCenter;
    public int mRadius;

    public SearchCircle(GeoPoint center, int radius) {
        this.mCenter = center;
        this.mRadius = radius;
    }

    public SearchCircle(int longitude, int latitude, int radius) {
        this.mCenter = new GeoPoint(longitude, latitude);
        this.mRadius = radius;
    }
}
