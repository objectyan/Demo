package com.baidu.platform.comapi.map;

public class BMBarHiddeEvent {
    public byte[] data;
    public String uid;

    public BMBarHiddeEvent(String uid, byte[] data) {
        this.uid = uid;
        this.data = data;
    }
}
