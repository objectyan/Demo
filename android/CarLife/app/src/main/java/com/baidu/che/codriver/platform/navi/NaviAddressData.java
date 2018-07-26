package com.baidu.che.codriver.platform.navi;

import com.baidu.che.codriver.util.INoProguard;

public class NaviAddressData implements INoProguard {
    private String address;
    private String lat;
    private String lng;
    private String name;
    private String type;

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setType(String type) {
        this.type = type;
    }
}
