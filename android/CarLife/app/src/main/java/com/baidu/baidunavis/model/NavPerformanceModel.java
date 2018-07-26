package com.baidu.baidunavis.model;

import android.os.SystemClock;
import android.util.Log;

public class NavPerformanceModel {
    private static boolean OPEN = false;
    private static String TAG = "Navi_Performance";
    private static NavPerformanceModel sInstance = null;
    private long mSearchByCircleForMapPoiResultPBStartTime = -1;
    private long mSearchByNameForMapPoiResultPBStartTime = -1;

    private NavPerformanceModel() {
    }

    public static NavPerformanceModel getInstance() {
        if (sInstance == null) {
            sInstance = new NavPerformanceModel();
        }
        return sInstance;
    }

    public void startSearchByNameForMapPoiResultPB() {
        this.mSearchByNameForMapPoiResultPBStartTime = SystemClock.elapsedRealtime();
        log("oneSearch() startTime=" + this.mSearchByNameForMapPoiResultPBStartTime);
    }

    public void endSearchByNameForMapPoiResultPB() {
        long tmpEndTime = SystemClock.elapsedRealtime();
        log("oneSearch() totalTime=" + (tmpEndTime - this.mSearchByNameForMapPoiResultPBStartTime) + "ms, endTime=" + tmpEndTime);
    }

    public void startSearchByCircleForMapPoiResultPB() {
        this.mSearchByCircleForMapPoiResultPBStartTime = SystemClock.elapsedRealtime();
        log("spaceSearch() startTime=" + this.mSearchByCircleForMapPoiResultPBStartTime);
    }

    public void endSearchByCircleForMapPoiResultPB() {
        long tmpEndTime = SystemClock.elapsedRealtime();
        log("spaceSearch() totalTime=" + (tmpEndTime - this.mSearchByCircleForMapPoiResultPBStartTime) + "ms, endTime=" + tmpEndTime);
    }

    private void log(String info) {
        if (OPEN) {
            Log.e(TAG, info);
        }
    }
}
