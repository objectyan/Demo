package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.LogUtil;

public class GuideStatItem {
    private static final String TAG = GuideStatItem.class.getName();
    private static GuideStatItem instance = null;
    private long mBaseTime = 0;
    private Bundle mDataBundle = null;
    private StringBuffer mGuideSer = new StringBuffer();

    public interface GuideStatContants {
        public static final String HIGH_WAY_REMAIN_DIST_SERIALNUM = "3.4";
        public static final String RASTER_EXPAND_MAP_SERIALNUM = "3.3";
    }

    private interface StatResultKey {
        public static final String ALL_STATICS_KEY = "all_statics";
        public static final String PART_STATICS_KEY = "part_statics";
    }

    private GuideStatItem() {
        init();
    }

    public static GuideStatItem getInstance() {
        if (instance == null) {
            instance = new GuideStatItem();
        }
        return instance;
    }

    public String getGuideStatString() {
        if (this.mGuideSer == null || this.mGuideSer.length() <= 0 || this.mDataBundle == null || !this.mDataBundle.containsKey(StatResultKey.PART_STATICS_KEY)) {
            return null;
        }
        LogUtil.m15791e(TAG, "getGuideStatString() PART_STATICS_KEY:" + this.mDataBundle.getString(StatResultKey.PART_STATICS_KEY));
        LogUtil.m15791e(TAG, "getGuideStatString() ALL_STATICS_KEY:" + this.mDataBundle.getString(StatResultKey.ALL_STATICS_KEY));
        return this.mDataBundle.getString(StatResultKey.ALL_STATICS_KEY);
    }

    public void end() {
        if (this.mGuideSer != null && this.mGuideSer.length() > 0) {
            this.mDataBundle = new Bundle();
            LogUtil.m15791e(TAG, "end():" + this.mGuideSer.toString());
            JNIStatisticsControl.sInstance.getStatisticsResult(this.mGuideSer.toString(), this.mDataBundle);
            this.mBaseTime = 0;
        }
    }

    public void add(String serialNum, String param) {
        long timeValue;
        if (this.mBaseTime <= 0) {
            this.mBaseTime = SystemClock.elapsedRealtime();
            timeValue = 0;
        } else {
            timeValue = ((SystemClock.elapsedRealtime() - this.mBaseTime) / 1000) + 1;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(serialNum);
        sb.append("-");
        sb.append(String.valueOf(timeValue));
        if (param != null) {
            sb.append("-");
            sb.append(param);
        }
        if (this.mGuideSer.length() >= 1) {
            this.mGuideSer.append(Config.TRACE_TODAY_VISIT_SPLIT);
        }
        this.mGuideSer.append(sb.toString());
        LogUtil.m15791e(TAG, "add:" + sb.toString());
    }

    private void init() {
        this.mBaseTime = 0;
        this.mDataBundle = null;
    }

    public void initMBaseTime() {
        if (this.mBaseTime <= 0) {
            this.mBaseTime = SystemClock.elapsedRealtime();
        }
    }
}
