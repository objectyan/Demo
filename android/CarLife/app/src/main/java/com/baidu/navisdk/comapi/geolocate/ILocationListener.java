package com.baidu.navisdk.comapi.geolocate;

import com.baidu.navisdk.model.datastruct.LocData;

public interface ILocationListener {
    void onGpsStatusChange(boolean z, boolean z2);

    void onLocationChange(LocData locData);

    void onWGS84LocationChange(LocData locData, LocData locData2);
}
