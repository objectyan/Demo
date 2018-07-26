package com.baidu.platform.comapi.map;

public class BMBarShowEvent {
    public String curfloor;
    public byte[] data;
    public String searchbound;
    public String uid;

    public BMBarShowEvent(String uid, String curfloor, byte[] data) {
        this.uid = uid;
        this.data = data;
        this.curfloor = curfloor;
    }

    public BMBarShowEvent(String uid, String searchbound, String curfloor, byte[] data) {
        this.uid = uid;
        this.searchbound = searchbound;
        this.data = data;
        this.curfloor = curfloor;
    }
}
