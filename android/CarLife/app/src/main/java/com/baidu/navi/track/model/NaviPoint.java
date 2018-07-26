package com.baidu.navi.track.model;

public class NaviPoint {
    private String addr = "";
    private boolean hasAddr;
    private boolean hasLat;
    private boolean hasLng;
    private double lat = 0.0d;
    private double lng = 0.0d;

    public double getLng() {
        return this.lng;
    }

    public boolean hasLng() {
        return this.hasLng;
    }

    public NaviPoint setLng(double value) {
        this.hasLng = true;
        this.lng = value;
        return this;
    }

    public NaviPoint clearLng() {
        this.hasLng = false;
        this.lng = 0.0d;
        return this;
    }

    public double getLat() {
        return this.lat;
    }

    public boolean hasLat() {
        return this.hasLat;
    }

    public NaviPoint setLat(double value) {
        this.hasLat = true;
        this.lat = value;
        return this;
    }

    public NaviPoint clearLat() {
        this.hasLat = false;
        this.lat = 0.0d;
        return this;
    }

    public String getAddr() {
        return this.addr;
    }

    public boolean hadAddr() {
        return this.hasAddr;
    }

    public NaviPoint setAddr(String value) {
        this.hasAddr = true;
        this.addr = value;
        return this;
    }

    public NaviPoint clearAddr() {
        this.hasAddr = false;
        this.addr = "";
        return this;
    }

    public NaviPoint clear() {
        clearLng();
        clearLat();
        clearAddr();
        return this;
    }

    public String toString() {
        return "NaviPoint [addr=" + this.addr + ", lng=" + this.lng + ", lat=" + this.lat + "]";
    }
}
