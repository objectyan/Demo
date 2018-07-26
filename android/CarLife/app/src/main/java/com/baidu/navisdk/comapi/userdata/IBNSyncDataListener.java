package com.baidu.navisdk.comapi.userdata;

public interface IBNSyncDataListener {
    public static final int FAV_POI_SYNC_RESULT_BDUSS = 1;
    public static final int FAV_POI_SYNC_RESULT_FAILED = 5;
    public static final int FAV_POI_SYNC_RESULT_FULL = 3;
    public static final int FAV_POI_SYNC_RESULT_RELOGIN = 4;
    public static final int FAV_POI_SYNC_RESULT_SUCCESS = 2;

    void onSyncFavPoiResult(int i);
}
