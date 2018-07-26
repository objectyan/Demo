package com.baidu.location;

public abstract class BDAbstractLocationListener {
    public void onConnectHotSpotMessage(String str, int i) {
    }

    public void onLocDiagnosticMessage(int i, int i2, String str) {
    }

    public abstract void onReceiveLocation(BDLocation bDLocation);
}
