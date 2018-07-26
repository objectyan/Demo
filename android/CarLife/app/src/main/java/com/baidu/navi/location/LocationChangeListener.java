package com.baidu.navi.location;

import com.baidu.navi.location.LocationManager.LocData;

public interface LocationChangeListener {

    public enum CoordType {
        CoordType_BD09LL,
        CoordType_BD09,
        CoordType_GCJ02
    }

    CoordType onGetCoordType();

    void onLocationChange(LocData locData);
}
