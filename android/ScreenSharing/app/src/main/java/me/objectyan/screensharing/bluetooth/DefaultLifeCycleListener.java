package com.baidu.carlife.bluetooth;

import android.content.Intent;
import android.content.res.Configuration;
import com.baidu.carlife.LifeCycleListener;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.config.CarlifeConfig;

/* compiled from: DefaultLifeCycleListener */
/* renamed from: com.baidu.carlife.bluetooth.j */
public class DefaultLifeCycleListener implements LifeCycleListener {
    /* renamed from: a */
    private static final String f2837a = "CarlifeActivity#CycleListener";

    /* renamed from: a */
    public void mo1400a() {
    }

    /* renamed from: b */
    public void mo1402b() {
        if (CarlifeConfig.m4065a()) {
            LogUtil.d(f2837a, "onStop: Internal screen capture not send background msg. ");
            return;
        }
        LogUtil.d(f2837a, "onStop: full screen capture send background msg.");
        BtHfpProtocolHelper.m3442a(false, false);
    }

    /* renamed from: c */
    public void mo1403c() {
    }

    /* renamed from: d */
    public void mo1404d() {
        if (CarlifeConfig.m4065a()) {
            LogUtil.d(f2837a, "onResume: Internal screen capture not send forground msg.");
            return;
        }
        LogUtil.d(f2837a, "onResume: full screen capture send forground msg.");
        BtHfpProtocolHelper.m3442a(false, true);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        LogUtil.d(f2837a, "onConfigurationChanged: newConfig=" + newConfig);
    }

    /* renamed from: a */
    public void mo1401a(Intent intent) {
    }

    /* renamed from: e */
    public void mo1405e() {
    }

    /* renamed from: f */
    public void mo1406f() {
    }
}
