package com.baidu.platform.comapi.basestruct;

public class GeoPoint {
    private double mLatitude;
    private double mLongitude;

    public GeoPoint(int latitude, int longitude) {
        this.mLatitude = (double) latitude;
        this.mLongitude = (double) longitude;
    }

    public GeoPoint(double latitude, double longitude) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLatitude(int latitude) {
        this.mLatitude = (double) latitude;
    }

    public void setLongitude(int longitude) {
        this.mLongitude = (double) longitude;
    }

    public void setLatitude(double latitude) {
        this.mLatitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.mLongitude = longitude;
    }

    public int getLatitudeE6() {
        return (int) this.mLatitude;
    }

    public int getLongitudeE6() {
        return (int) this.mLongitude;
    }

    public void setLatitudeE6(int lat) {
        this.mLatitude = (double) lat;
    }

    public void setLongitudeE6(int longitude) {
        this.mLongitude = (double) longitude;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.mLatitude + ", Longitude: " + this.mLongitude;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        boolean z;
        if (obj.getClass() != getClass() || Math.abs(this.mLatitude - ((GeoPoint) obj).mLatitude) > 1.0E-6d || Math.abs(this.mLongitude - ((GeoPoint) obj).mLongitude) > 1.0E-6d) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }
}
