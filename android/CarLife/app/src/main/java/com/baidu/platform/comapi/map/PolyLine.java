package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class PolyLine extends Geometry {
    public static final int TYPE = 2;
    private List<GeoPoint> mPoints;

    public PolyLine(Style style) {
        super(style);
        this.mPoints = new ArrayList();
        this.dataType = 0;
        this.styleType = 2;
    }

    public void setPoints(List<GeoPoint> points) {
        if (points == null) {
            throw new IllegalArgumentException("points list can not be null!");
        } else if (points.size() < 2) {
            throw new IllegalArgumentException("points count can not be less than two!");
        } else {
            synchronized (this.mPoints) {
                this.mPoints.clear();
                this.mPoints.addAll(points);
                this.isNeedRefresh = true;
            }
        }
    }

    public void removeAllPoints() {
        synchronized (this.mPoints) {
            this.mPoints.clear();
        }
    }

    public void addPoint(GeoPoint point) {
        if (point == null) {
            throw new IllegalArgumentException("point can not be null!");
        }
        synchronized (this.mPoints) {
            this.mPoints.add(point);
            this.isNeedRefresh = true;
        }
    }

    public String getData() {
        String data;
        synchronized (this.mPoints) {
            if (this.isNeedRefresh) {
                this.isNeedRefresh = !genDifferPoints();
            }
            data = getData(this.dataType);
        }
        return data;
    }

    private boolean genDifferPoints() {
        synchronized (this.mPoints) {
            if (this.mPoints.size() < 2) {
                return false;
            }
            int ptSize = this.mPoints.size();
            this.mDifferArray = new double[((this.mPoints.size() * 2) + 5)];
            if (genGeoBound()) {
                this.mDifferArray[0] = this.mLL.getLongitude();
                this.mDifferArray[1] = this.mLL.getLatitude();
                this.mDifferArray[2] = this.mRU.getLongitude();
                this.mDifferArray[3] = this.mRU.getLatitude();
            }
            this.mDifferArray[4] = 2.0d;
            this.mDifferArray[5] = ((GeoPoint) this.mPoints.get(0)).getLongitude();
            this.mDifferArray[6] = ((GeoPoint) this.mPoints.get(0)).getLatitude();
            for (int i = 1; i < ptSize; i++) {
                this.mDifferArray[(i * 2) + 5] = ((GeoPoint) this.mPoints.get(i)).getLongitude() - ((GeoPoint) this.mPoints.get(i - 1)).getLongitude();
                this.mDifferArray[((i * 2) + 5) + 1] = ((GeoPoint) this.mPoints.get(i)).getLatitude() - ((GeoPoint) this.mPoints.get(i - 1)).getLatitude();
            }
            return true;
        }
    }

    private boolean genGeoBound() {
        boolean z = false;
        synchronized (this.mPoints) {
            if (this.mPoints.size() < 2) {
            } else {
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
                z = true;
            }
        }
        return z;
    }
}
