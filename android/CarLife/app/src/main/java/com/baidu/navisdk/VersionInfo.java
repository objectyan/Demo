package com.baidu.navisdk;

public class VersionInfo {
    private static final String APIVERSION = "5.4";
    private static final String DATAVERSION = "5.3.0";
    private static final String sVersionDesc = "百度导航Android SDK正式版V4.7";

    public static String getApiVersion() {
        return APIVERSION;
    }

    public static String getVersionDesc() {
        return sVersionDesc;
    }

    public static String getDataVersion() {
        return DATAVERSION;
    }
}
