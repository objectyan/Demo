package com.baidu.nplatform.comapi.basestruct;

public class GeoPoint {
    public static final int INVALID_VALUE = Integer.MIN_VALUE;
    private int mLatitudeE6;
    private int mLongitudeE6;

    public GeoPoint() {
        this.mLongitudeE6 = Integer.MIN_VALUE;
        this.mLatitudeE6 = Integer.MIN_VALUE;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this.mLongitudeE6 = geoPoint.mLongitudeE6;
        this.mLatitudeE6 = geoPoint.mLatitudeE6;
    }

    public GeoPoint(int longitudeE6, int latitudeE6) {
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
        boolean z = this.mLatitudeE6 == ((GeoPoint) obj).mLatitudeE6 && this.mLongitudeE6 == ((GeoPoint) obj).mLongitudeE6;
        return z;
    }

    public boolean isValid() {
        return (this.mLongitudeE6 == Integer.MIN_VALUE || this.mLatitudeE6 == Integer.MIN_VALUE) ? false : true;
    }
}
