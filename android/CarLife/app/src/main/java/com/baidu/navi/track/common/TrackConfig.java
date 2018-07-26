package com.baidu.navi.track.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.carlife.core.C1157a;

public class TrackConfig {
    private static final String MAX_TIME = "max_time";
    private static final String TOTAL_DISTANSE = "total_distanse";
    private static final String TRACK_AUTO_NAVIGATE_COLLECT = "track_auto_navigate_collect";
    private static final String TRACK_AUTO_SYNC = "track_auto_sync";
    private static final String TRACK_CONFIG = "track_pref";
    private static final String TRACK_LAST_SYNC_TIME = "track_last_sync_time";
    private static final String WEEK_DISTANSE = "week_distanse";
    private static final String WEEK_END_TIME = "week_end_time";
    private SharedPreferences mPreferences;

    private static class Holder {
        static final TrackConfig GLOBAL_CONFIG = new TrackConfig();

        private Holder() {
        }
    }

    public int getTotalDistanse() {
        return this.mPreferences.getInt(TOTAL_DISTANSE, 0);
    }

    public int getWeekDistanse() {
        return this.mPreferences.getInt(WEEK_DISTANSE, 0);
    }

    public int getMaxTime() {
        return this.mPreferences.getInt(MAX_TIME, 0);
    }

    public int getWeekEndTime() {
        return this.mPreferences.getInt(WEEK_END_TIME, 0);
    }

    public void setTotalDistanse(int distanse) {
        Editor editor = this.mPreferences.edit();
        editor.putInt(TOTAL_DISTANSE, distanse);
        editor.commit();
    }

    public void setWeekDistanse(int distanse) {
        Editor editor = this.mPreferences.edit();
        editor.putInt(WEEK_DISTANSE, distanse);
        editor.commit();
    }

    public void setMaxTime(int time) {
        Editor editor = this.mPreferences.edit();
        editor.putInt(MAX_TIME, time);
        editor.commit();
    }

    public void setWeekEndTime(int time) {
        Editor editor = this.mPreferences.edit();
        editor.putInt(WEEK_END_TIME, time);
        editor.commit();
    }

    public boolean isOpenNavigateRecord() {
        return this.mPreferences.getBoolean(TRACK_AUTO_NAVIGATE_COLLECT, true);
    }

    public void setOpenNavigateRecord(boolean record) {
        Editor editor = this.mPreferences.edit();
        editor.putBoolean(TRACK_AUTO_NAVIGATE_COLLECT, record);
        editor.commit();
    }

    public boolean isOpenAutoSync() {
        return this.mPreferences.getBoolean(TRACK_AUTO_SYNC, false);
    }

    public void setOpenAutoSync(boolean autoSync) {
        Editor editor = this.mPreferences.edit();
        editor.putBoolean(TRACK_AUTO_SYNC, autoSync);
        editor.commit();
    }

    public long getLastSyncTime() {
        return this.mPreferences.getLong(TRACK_LAST_SYNC_TIME, 0);
    }

    public void setLastSyncTime(long time) {
        Editor editor = this.mPreferences.edit();
        editor.putLong(TRACK_LAST_SYNC_TIME, time);
        editor.commit();
    }

    public static TrackConfig getInstance() {
        return Holder.GLOBAL_CONFIG;
    }

    private TrackConfig() {
        this.mPreferences = C1157a.a().getSharedPreferences(TRACK_CONFIG, 0);
    }
}
