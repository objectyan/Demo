package com.baidu.baidunavis.model;

public class NavGeoPoint {
    public static final int INVALID_VALUE = Integer.MIN_VALUE;
    private int mLatitudeE6;
    private int mLongitudeE6;

    public NavGeoPoint() {
        this.mLongitudeE6 = Integer.MIN_VALUE;
        this.mLatitudeE6 = Integer.MIN_VALUE;
    }

    public NavGeoPoint(NavGeoPoint geoPoint) {
        this.mLongitudeE6 = geoPoint.mLongitudeE6;
        this.mLatitudeE6 = geoPoint.mLatitudeE6;
    }

    public NavGeoPoint(int longitudeE6, int latitudeE6) {
        this.mLongitudeE6 = longitudeE6;
        this.mLatitudeE6 = latitudeE6;
    }

    public int getLatitudeE6() {
        return this.mLatitudeE6;
    }

    public int getLongitudeE6() {
        return this.mLongitudeE6;
    }

    public void setLatitudeE6(int latitudeE6) {
        this.mLatitudeE6 = latitudeE6;
    }

    public void setLongitudeE6(int longitudeE6) {
        this.mLongitudeE6 = longitudeE6;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return "GeoPoint(" + this.mLongitudeE6 + "," + this.mLatitudeE6 + ") ";
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        boolean z = this.mLatitudeE6 == ((NavGeoPoint) obj).mLatitudeE6 && this.mLongitudeE6 == ((NavGeoPoint) obj).mLongitudeE6;
        return z;
    }

    public boolean isValid() {
        return (this.mLongitudeE6 == Integer.MIN_VALUE || this.mLatitudeE6 == Integer.MIN_VALUE) ? false : true;
    }
}
