package com.baidu.navi.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.navi.controller.BGPSAlarmController;
import com.baidu.navi.controller.RouteCustomController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;

public class TimerPickerBroadReceive extends BroadcastReceiver {
    public void onReceive(Context context, Intent arg1) {
        String action = arg1.getAction();
        Intent serviceIntent;
        if (RouteCustomController.ALARM_BROADCAST.equals(action)) {
            int dbId = arg1.getIntExtra("id", -1);
            serviceIntent = new Intent(context, TimerPickerService.class);
            serviceIntent.putExtra(VoiceKey.ACTION, action);
            serviceIntent.putExtra("id", dbId);
            context.startService(serviceIntent);
        } else if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            serviceIntent = new Intent(context, TimerPickerService.class);
            serviceIntent.putExtra(VoiceKey.ACTION, action);
            context.startService(serviceIntent);
        } else if (BGPSAlarmController.GPS_HOT_START_ALARM_BROADCAST.equals(action) && BNSettingManager.getGPSHotStart()) {
            serviceIntent = new Intent(context, TimerPickerService.class);
            serviceIntent.putExtra(VoiceKey.ACTION, "com.baidu.navi.service.GPSAlarmService");
            context.startService(serviceIntent);
        }
    }
}
