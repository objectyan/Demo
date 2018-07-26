package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;

public class RingModeStatusReceiver extends BroadcastReceiver {
    private static final String TAG = "RingModeStatusReceiver";
    private static boolean hasRegistered = false;
    private static ContentObserver mMuteChangeObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
        public boolean deliverSelfNotifications() {
            LogUtil.m15791e(RingModeStatusReceiver.TAG, "deliverSelfNotifications");
            return super.deliverSelfNotifications();
        }

        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            LogUtil.m15791e(RingModeStatusReceiver.TAG, "onChange selfChange:" + selfChange);
        }

        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            LogUtil.m15791e(RingModeStatusReceiver.TAG, "onChange selfChange:" + selfChange + ", Uri:" + uri.toString());
            if (AudioUtils.getCurrentVolume(BNaviModuleManager.getContext()) > 0) {
                RGViewController.getInstance().updateLowVolumeView(false);
            } else {
                RGViewController.getInstance().updateLowVolumeView(true);
            }
        }
    };
    private static RingModeStatusReceiver sInstance = new RingModeStatusReceiver();

    private RingModeStatusReceiver() {
    }

    public static void initRingModeStatusReceiver(Context context) {
        LogUtil.m15791e(TAG, "initRingModeStatusReceiver");
        if (context != null && !hasRegistered) {
            IntentFilter filter = new IntentFilter("android.media.RINGER_MODE_CHANGED");
            filter.setPriority(Integer.MAX_VALUE);
            try {
                context.registerReceiver(sInstance, filter);
                hasRegistered = true;
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "initRingModeStatusReceiver cause :" + e.getCause());
                LogUtil.m15791e(TAG, "initRingModeStatusReceiver crash :" + e.getMessage());
            }
            if (PackageUtil.isSmartisanPhone()) {
                context.getContentResolver().registerContentObserver(System.getUriFor("volume_panel_mute_enable"), true, mMuteChangeObserver);
            }
        }
    }

    public static void uninitRingModeStatusReceiver(Context context) {
        LogUtil.m15791e(TAG, "uninitRingModeStatusReceiver");
        if (context != null && hasRegistered) {
            hasRegistered = false;
            try {
                context.unregisterReceiver(sInstance);
            } catch (Exception e) {
                LogUtil.m15791e(TAG, "uninitRingModeStatusReceiver crash :" + e.getMessage());
            }
            if (PackageUtil.isSmartisanPhone()) {
                context.getContentResolver().unregisterContentObserver(mMuteChangeObserver);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtil.m15791e(TAG, "action:" + action);
        if (!"android.media.RINGER_MODE_CHANGED".equals(action)) {
            return;
        }
        if (AudioUtils.getCurrentVolume(context) > 0) {
            RGViewController.getInstance().updateLowVolumeView(false);
        } else {
            RGViewController.getInstance().updateLowVolumeView(true);
        }
    }
}
