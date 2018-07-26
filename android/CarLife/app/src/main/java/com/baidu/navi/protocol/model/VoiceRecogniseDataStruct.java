package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class VoiceRecogniseDataStruct extends DataStruct {
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_LIST = "list";
    public static final String KEY_TYPE = "type";
    public static final int TYPE_COMPANY = 2;
    public static final int TYPE_HOME = 1;
    public static final int TYPE_OTHERS = 3;
    public String filePath;

    public VoiceRecogniseDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_VOICE_RECOGNISE;
    }
}
