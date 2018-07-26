package com.baidu.mapframework.location;

public class MyLocationEvent {
    private String myLocation;

    public MyLocationEvent(String string) {
        this.myLocation = string;
    }

    public String getMyLocation() {
        return this.myLocation;
    }
}
