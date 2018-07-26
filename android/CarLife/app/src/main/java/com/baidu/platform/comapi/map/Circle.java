package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.C4820d;

public class Circle extends Geometry {
    private static final double DELT = 0.06981317007777778d;
    private static final int DISC_PTS_SIZE = 90;
    private static final double PI = 3.1415926535d;
    private GeoPoint center;
    private float radius;

    public Circle(Style style) {
        super(style);
        this.dataType = 1;
        this.styleType = 3;
    }

    public String getData() {
        if (this.isNeedRefresh) {
            genGeoBound();
            this.isNeedRefresh = !genDifferPoints();
        }
        return getData(this.dataType);
    }

    public Circle setCenter(GeoPoint center) {
        this.center = center;
        this.isNeedRefresh = true;
        return this;
    }

    public Circle setRadius(float radius) {
        this.radius = radius;
        this.isNeedRefresh = true;
        return this;
    }

    private boolean genGeoBound() {
        if (this.center == null || this.radius <= 0.0f) {
            return false;
        }
        this.mLL.setLatitude(this.center.getLatitude() - ((double) this.radius));
        this.mLL.setLongitude(this.center.getLongitude() - ((double) this.radius));
        this.mRU.setLatitude(this.center.getLatitude() + ((double) this.radius));
        this.mRU.setLongitude(this.center.getLongitude() + ((double) this.radius));
        return true;
    }

    private boolean genDifferPoints() {
        this.mDifferArray = new double[C4820d.f19955a];
        this.mDifferArray[0] = this.center.getLongitude() + ((double) this.radius);
        this.mDifferArray[1] = this.center.getLatitude();
        for (int i = 1; i < 90; i++) {
            this.mDifferArray[i * 2] = ((double) this.radius) * (Math.cos(((double) i) * DELT) - Math.cos(((double) (i - 1)) * DELT));
            this.mDifferArray[(i * 2) + 1] = ((double) this.radius) * (Math.sin(((double) i) * DELT) - Math.sin(((double) (i - 1)) * DELT));
        }
        return true;
    }
}
