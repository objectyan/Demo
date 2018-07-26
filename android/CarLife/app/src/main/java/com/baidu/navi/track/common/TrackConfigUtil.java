package com.baidu.navi.track.common;

public class TrackConfigUtil {
    private static TrackConfigUtil sInstance = new TrackConfigUtil();

    private TrackConfigUtil() {
    }

    public static TrackConfigUtil getInstance() {
        return sInstance;
    }

    public boolean getRouteRecordFlag() {
        return TrackConfig.getInstance().isOpenNavigateRecord();
    }

    public void setRouteRecordFlag(boolean flag) {
        TrackConfig.getInstance().setOpenNavigateRecord(flag);
    }
}
