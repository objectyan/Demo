package com.baidu.navi.controller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class BGPSAlarmController {
    public static final int ALARM_TIME = 10800000;
    public static final String GPS_HOT_START_ALARM_BROADCAST = "com.baidu.navi.GPSHostStart.alarm";
    public static final String INTERVAL_TIME = "interval_time";
    private static final String TAG = "BGPSAlarmController";
    public static final int mPendIntentId = 28888;

    private static class LazyHolder {
        private static final BGPSAlarmController sInstance = new BGPSAlarmController();

        private LazyHolder() {
        }
    }

    public static BGPSAlarmController getInstance() {
        return LazyHolder.sInstance;
    }

    public void addGPSAlarmNotify(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).set(1, System.currentTimeMillis() + 10800000, PendingIntent.getBroadcast(context, mPendIntentId, new Intent(GPS_HOT_START_ALARM_BROADCAST), 0));
    }

    public void deleteGPSAlarmNotify(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, mPendIntentId, new Intent(GPS_HOT_START_ALARM_BROADCAST), 0));
    }

    public void restartGPSAlarm(Context context) {
        deleteGPSAlarmNotify(context);
        addGPSAlarmNotify(context);
    }
}
