package com.baidu.navisdk.lightnavi.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.navisdk.lightnavi.LightNaviParams;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.List;

public class LightNaviLockScreenReceiver extends BroadcastReceiver {
    private static final String TAG = "LightNaviLockScreenReceiver";
    private static Activity mActivity;
    private static Context mContext;
    public static boolean mIsLock = false;
    private static LightNaviLockScreenReceiver sInstance = new LightNaviLockScreenReceiver();
    private static boolean sLockScreenReceiverRegisted = false;

    private LightNaviLockScreenReceiver() {
    }

    public static void initLockScreenReceiver(Context context, Activity activity) {
        if (context != null) {
            mContext = context;
            mActivity = activity;
            IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_ON");
            filter.addAction("android.intent.action.SCREEN_OFF");
            filter.addAction("android.intent.action.SCREEN_ON");
            filter.setPriority(Integer.MAX_VALUE);
            try {
                mContext.registerReceiver(sInstance, filter);
                sLockScreenReceiverRegisted = true;
            } catch (Exception e) {
                LogUtil.m15791e("wy", "[LightNaviLockScreenReceiver]initLockScreenReceiver->" + e.toString());
            }
        }
    }

    public static void uninitLockScreenReceiver() {
        try {
            if (mContext != null && sLockScreenReceiverRegisted) {
                sLockScreenReceiverRegisted = false;
                mContext.unregisterReceiver(sInstance);
            }
            mActivity = null;
            mContext = null;
        } catch (Exception e) {
            LogUtil.m15791e("wy", "[LightNaviLockScreenReceiver]uninitLockScreenReceiver->" + e.toString());
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_6, "", null, null);
            String mPackageName = getCurrentPackagename(context);
            BNLightNaviManager.getInstance().setPackageName(mPackageName);
            LogUtil.m15791e("wangyang", "LightNaviLockScreenReceiver " + mPackageName);
            BNLightNaviManager.getInstance().setType(1);
            Intent intentLock = new Intent(LightNaviParams.DEFAULT_SLIGHT_ACTION);
            intentLock.addFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
            try {
                context.startActivity(intentLock);
            } catch (Exception e) {
            }
        }
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_e);
            BNLightNaviManager.getInstance().setType(1);
        }
        if (!mIsLock) {
            try {
                if (mActivity != null) {
                    mActivity.getWindow().addFlags(525312);
                }
            } catch (Exception e2) {
            }
            mIsLock = true;
        }
    }

    private String getCurrentPackagename(Context context) {
        List<RunningAppProcessInfo> taskInfo = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
        if (taskInfo != null) {
            for (RunningAppProcessInfo runinfo : taskInfo) {
                if (runinfo.importance == 100) {
                    return runinfo.processName;
                }
            }
        }
        return LightNaviParams.DEFAULT_PACKAGE_NAME;
    }
}
