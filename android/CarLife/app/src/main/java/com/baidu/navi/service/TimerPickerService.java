package com.baidu.navi.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.navi.NaviOfflineActivityStarter;
import com.baidu.navi.controller.BGPSAlarmController;
import com.baidu.navi.controller.RouteCustomController;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.model.RouteCustomModel;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import java.util.Date;

public class TimerPickerService extends Service {
    private static final int MAX_WAIT_TIME = 600000;
    private static final String NAVI_PACK_NAME = "com.baidu.carlife";
    private ILocationListener mGPSLocationListener = new C39602();
    private Handler mHander = new Handler();
    private int mServiceCount = 0;
    private Runnable mTimeEndThread = new C39591();

    /* renamed from: com.baidu.navi.service.TimerPickerService$1 */
    class C39591 implements Runnable {
        C39591() {
        }

        public void run() {
            TimerPickerService.this.stopService();
        }
    }

    /* renamed from: com.baidu.navi.service.TimerPickerService$2 */
    class C39602 implements ILocationListener {
        C39602() {
        }

        public void onLocationChange(LocData locData) {
            if (locData != null) {
                TimerPickerService.this.mHander.removeCallbacks(TimerPickerService.this.mTimeEndThread);
                TimerPickerService.this.stopService();
            }
        }

        public void onGpsStatusChange(boolean enabled, boolean available) {
            if (enabled && available) {
                TimerPickerService.this.mHander.removeCallbacks(TimerPickerService.this.mTimeEndThread);
                TimerPickerService.this.stopService();
            }
        }

        public void onWGS84LocationChange(LocData arg0, LocData arg1) {
        }
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
        this.mHander.removeCallbacks(this.mTimeEndThread);
        BNSysLocationManager.getInstance().removeLocationListener(this.mGPSLocationListener);
        if (!isNaviAppStart()) {
            BNSysLocationManager.getInstance().unInit();
        }
    }

    public void onStart(Intent intent, int startId) {
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            this.mServiceCount++;
            DBManager.init(this);
            String action = intent.getStringExtra(VoiceKey.ACTION);
            if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
                BGPSAlarmController.getInstance().restartGPSAlarm(this);
                RouteCustomController.getInstance().calcPushTimeAndAddAlarmByRCList(this);
                if (!isNaviAppStart()) {
                    DBManager.destroy();
                }
                stopService();
            } else if (RouteCustomController.ALARM_BROADCAST.equals(action)) {
                int id = intent.getIntExtra("id", -1);
                if (id != -1) {
                    sendNotify(this, id);
                }
                if (!isNaviAppStart()) {
                    DBManager.destroy();
                }
                stopService();
            } else if ("com.baidu.navi.service.GPSAlarmService".equals(action)) {
                BGPSAlarmController.getInstance().restartGPSAlarm(this);
                doGPSHotStart();
            }
        }
        return 2;
    }

    public void sendNotify(Context context, int dbId) {
        RouteCustomDBObject obj = RouteCustomModel.getInstance().getRouteCustomInfoById(dbId);
        if (obj != null) {
            if (obj.getIsRepeat() == 0) {
                obj.setOpen(0);
                RouteCustomModel.getInstance().updateRouteCustomInfo(obj);
            } else {
                long time = RouteCustomController.getInstance().getNextPushTimeMillsByRCId(dbId);
                RouteCustomController.getInstance().deleteAlarmNotify(context, dbId);
                if (time != -1) {
                    RouteCustomController.getInstance().addAlarmNotify(context, time, dbId);
                }
            }
        }
        String notifyContent = "查看" + RouteCustomController.getInstance().getRCShowNameByDBId(dbId) + "的路程时间";
        NotificationManager nm = (NotificationManager) context.getSystemService("notification");
        Notification notification = new Notification();
        notification.icon = C0965R.drawable.ic_launcher;
        notification.tickerText = notifyContent;
        notification.defaults = 3;
        notification.flags |= 16;
        DBManager.init(context);
        Intent intent = new Intent(PlatformConstants.BAIDU_NAVI_START_ACTIVITY_ACTION);
        intent.setClass(context, NaviOfflineActivityStarter.class);
        intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        intent.setData(Uri.parse("bdnavi://customroute?"));
        intent.putExtra("dbId", dbId);
        notification.setLatestEventInfo(context, "小度提醒您现在该出发啦", notifyContent, PendingIntent.getActivity(context, dbId, intent, 0));
        nm.notify(dbId, notification);
    }

    private boolean isNaviAppStart() {
        for (RunningTaskInfo runTaskInfo : ((ActivityManager) getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningTasks(200)) {
            if ("com.baidu.carlife".equalsIgnoreCase(runTaskInfo.topActivity.getPackageName()) && "com.baidu.carlife".equalsIgnoreCase(runTaskInfo.baseActivity.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    private void doGPSHotStart() {
        int mCurHour = new Date(System.currentTimeMillis()).getHours();
        if (6 > mCurHour || mCurHour > 22) {
            stopService();
        } else if (!BNSysLocationManager.getInstance().isGpsEnabled() || isNaviAppStart()) {
            stopService();
        } else {
            BNSysLocationManager.getInstance().init(this);
            BNSysLocationManager.getInstance().addLocationListener(this.mGPSLocationListener);
            this.mHander.postDelayed(this.mTimeEndThread, 600000);
        }
    }

    private void stopService() {
        this.mServiceCount--;
        if (this.mServiceCount <= 0) {
            stopSelf();
        }
    }
}
