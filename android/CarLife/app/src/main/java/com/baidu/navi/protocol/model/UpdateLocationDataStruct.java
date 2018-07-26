package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class UpdateLocationDataStruct extends DataStruct {
    public static final String KEY_ACCURACY = "accuracy";
    public static final String KEY_ALTITUDE = "altitude";
    public static final String KEY_BEARING = "bearing";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_SATELLITES = "satellites";
    public static final String KEY_SPEED = "speed";
    public float accuracy;
    public double altitude;
    public float bearing;
    public double latitude;
    public double longitude;
    public int satellites;
    public float speed;

    public UpdateLocationDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_UPDATE_LOCATION;
    }
}
