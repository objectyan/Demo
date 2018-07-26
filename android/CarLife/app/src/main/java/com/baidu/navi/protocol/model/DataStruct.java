package com.baidu.navi.protocol.model;

import android.os.Bundle;
import java.util.Map;

public class DataStruct {
    public static String KEY_ERROR_CODE = ResultDataStruct.KEY_ERROR_CODE;
    public static String KEY_ERROR_STRING = ResultDataStruct.KEY_ERROR_STRING;
    public static String KEY_METHOD_NAME = "methodName";
    public CommandResult commandResult = new CommandResult();
    public String mCmd;
    public Map<String, Object> mParams;

    public class CommandResult {
        public int errCode;
        public String errString = "";
        public Bundle params;
    }
}
