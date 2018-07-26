package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends Geometry {
    private List<GeoPoint> mPoints;

    public Polygon(Style style) {
        super(style);
        this.dataType = 1;
        this.styleType = 3;
    }

    public void setStyleType(int type) {
        this.styleType = type;
    }

    public void setPoints(List<GeoPoint> points) {
        if (points == null) {
            throw new IllegalArgumentException("points list can not be null!");
        } else if (points.size() >= 3 || this.styleType != 3) {
            if (this.mPoints == null) {
                this.mPoints = new ArrayList();
                this.mPoints.addAll(points);
            } else {
                this.mPoints.clear();
                this.mPoints.addAll(points);
            }
            this.isNeedRefresh = true;
        } else {
            throw new IllegalArgumentException("points count can not be less than three!");
        }
    }

    public String getData() {
        if (this.isNeedRefresh) {
            genGeoBound();
            this.isNeedRefresh = !genDifferPoints();
        }
        return getData(this.dataType);
    }

    private boolean genDifferPoints() {
        if (this.mPoints == null && this.mPoints.size() < 3) {
            return false;
        }
        int ptSize = this.mPoints.size();
        this.mDifferArray = new double[(this.mPoints.size() * 2)];
        genGeoBound();
        this.mDifferArray[0] = ((GeoPoint) this.mPoints.get(0)).getLongitude();
        this.mDifferArray[1] = ((GeoPoint) this.mPoints.get(0)).getLatitude();
        for (int i = 1; i < ptSize; i++) {
            this.mDifferArray[i * 2] = ((GeoPoint) this.mPoints.get(i)).getLongitude() - ((GeoPoint) this.mPoints.get(i - 1)).getLongitude();
            this.mDifferArray[(i * 2) + 1] = ((GeoPoint) this.mPoints.get(i)).getLatitude() - ((GeoPoint) this.mPoints.get(i - 1)).getLatitude();
        }
        return true;
    }

    private boolean genGeoBound() {
        if (this.mPoints == null && this.mPoints.size() < 3) {
            return false;
        }
        this.mLL.setLatitude(((GeoPoint) this.mPoints.get(0)).getLatitude());
        this.mLL.setLongitude(((GeoPoint) this.mPoints.get(0)).getLongitude());
        this.mRU.setLatitude(((GeoPoint) this.mPoints.get(0)).getLatitude());
        this.mRU.setLongitude(((GeoPoint) this.mPoints.get(0)).getLongitude());
        for (GeoPoint p : this.mPoints) {
            if (this.mLL.getLatitude() >= p.getLatitude()) {
                this.mLL.setLatitude(p.getLatitude());
            }
            if (this.mLL.getLongitude() >= p.getLongitude()) {
                this.mLL.setLongitude(p.getLongitude());
            }
            if (this.mRU.getLatitude() <= p.getLatitude()) {
                this.mRU.setLatitude(p.getLatitude());
            }
            if (this.mRU.getLongitude() <= p.getLongitude()) {
                this.mRU.setLongitude(p.getLongitude());
            }
        }
        return true;
    }
}
