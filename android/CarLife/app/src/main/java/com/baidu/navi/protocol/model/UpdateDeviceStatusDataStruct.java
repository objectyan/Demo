package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class UpdateDeviceStatusDataStruct extends DataStruct {
    public static final String DEVICE_GPS = "GPS";
    public static final String KEY_DEVICE = "device";
    public static final String KEY_ENABLED = "enabled";
    public String device;
    public boolean enabled;

    public UpdateDeviceStatusDataStruct() {
        this.enabled = false;
        this.mCmd = BNaviProtocolDef.COMMAND_UPDATE_DEVICE_STATUS;
    }
}
