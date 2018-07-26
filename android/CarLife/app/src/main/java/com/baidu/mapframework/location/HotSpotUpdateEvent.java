package com.baidu.mapframework.location;

public class HotSpotUpdateEvent {
    public String connectWifiMac = null;
    public int hotSpotState = -1;

    public HotSpotUpdateEvent(String connectWifiMac, int hotSpotState) {
        this.connectWifiMac = connectWifiMac;
        this.hotSpotState = hotSpotState;
    }
}
