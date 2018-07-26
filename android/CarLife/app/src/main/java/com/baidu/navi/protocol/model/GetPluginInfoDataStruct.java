package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class GetPluginInfoDataStruct extends DataStruct {
    public static final String KEY_DETAIL = "detail";
    public static final String KEY_IS_RUNNING = "isRunning";
    public static final String KEY_NAME = "name";
    public static final String KEY_PLUGIN_ID = "pluginId";
    public static final String KEY_SUMMARY = "summary";
    public static final String KEY_VERSION = "version";
    public int pluginId;

    public GetPluginInfoDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_GET_PLUGIN_INFO;
    }
}
