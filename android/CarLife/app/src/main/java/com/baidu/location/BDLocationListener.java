package com.baidu.location;

public abstract class BDLocationListener {
    public void onConnectHotSpotMessage(String str, int i) {
    }

    public void onGPSLongLinkPushData(byte[] bArr, int i) {
    }

    public void onLocDiagnosticMessage(int i, int i2, String str) {
    }

    public abstract void onReceiveLocation(BDLocation bDLocation);

    public void onReceiveLocationTag(String str) {
    }

    public void onReceiveNaviModeWifiLocation(BDLocation bDLocation) {
    }
}
