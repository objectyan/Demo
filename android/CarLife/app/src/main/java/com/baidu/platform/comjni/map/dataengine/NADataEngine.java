package com.baidu.platform.comjni.map.dataengine;

import android.os.Bundle;
import com.baidu.platform.comjni.C2912a;

public class NADataEngine extends C2912a {
    /* renamed from: a */
    private int f20003a = 0;

    private native void nativeCancelThumbImageRequest(int i);

    private native int nativeCreate();

    private native String nativeGetCurrentStreetId(int i);

    private native String nativeGetCurrentStreetInfo(int i, Bundle bundle);

    private native boolean nativeGetHotMapCityInfo(int i, Bundle bundle);

    private native boolean nativeGetStreetCityInfo(int i, Bundle bundle);

    private native boolean nativeQueryThumbImage(int i, String str);

    private native int nativeRelease(int i);

    private native void nativeSetStreetPOIUID(int i, String str);

    private native boolean nativeStreetSwitchByUID(int i, String str, String str2);

    private native boolean nativeStreetSwitchToID(int i, String str, int i2);

    private native boolean nativeStreetSwitchToIDFromReGeo(int i, String str, String str2, long j, long j2);

    private native boolean nativeStreetSwitchToIID(int i, String str, String str2, boolean z);

    public int create() {
        this.f20003a = nativeCreate();
        return this.f20003a;
    }

    public int release() {
        return nativeRelease(this.f20003a);
    }

    public boolean getHotMapCityInfo(Bundle b) {
        return nativeGetHotMapCityInfo(this.f20003a, b);
    }

    public boolean getStreetCityInfo(Bundle b) {
        return nativeGetStreetCityInfo(this.f20003a, b);
    }

    public String getCurrentStreetInfo(Bundle b) {
        return nativeGetCurrentStreetInfo(this.f20003a, b);
    }

    public boolean streetSwitchToId(String id, int type) {
        return nativeStreetSwitchToID(this.f20003a, id, type);
    }

    public boolean streetSwitchToId(String id, String name, long geoX, long geoY) {
        return nativeStreetSwitchToIDFromReGeo(this.f20003a, id, name, geoX, geoY);
    }

    public boolean streetSwitchByUID(String uid, String type) {
        return nativeStreetSwitchByUID(this.f20003a, uid, type);
    }

    public boolean streetSwitchToIID(String iid, String pid, boolean refreshMap) {
        return nativeStreetSwitchToIID(this.f20003a, iid, pid, refreshMap);
    }

    public String getCurrentStreetId() {
        return nativeGetCurrentStreetId(this.f20003a);
    }

    public boolean queryThumbImage(String panoId) {
        return nativeQueryThumbImage(this.f20003a, panoId);
    }

    public void cancelThumbImageRequest() {
        nativeCancelThumbImageRequest(this.f20003a);
    }

    public void setStreetPOIUID(String strPoiUid) {
        nativeSetStreetPOIUID(this.f20003a, strPoiUid);
    }
}
