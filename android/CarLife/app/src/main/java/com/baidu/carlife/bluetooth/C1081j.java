package com.baidu.carlife.bluetooth;

import android.content.Intent;
import android.content.res.Configuration;
import com.baidu.carlife.C1080c;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.p069b.C1190a;

/* compiled from: DefaultLifeCycleListener */
/* renamed from: com.baidu.carlife.bluetooth.j */
public class C1081j implements C1080c {
    /* renamed from: a */
    private static final String f2837a = "CarlifeActivity#CycleListener";

    /* renamed from: a */
    public void mo1400a() {
    }

    /* renamed from: b */
    public void mo1402b() {
        if (C1190a.m4065a()) {
            C1260i.m4435b(f2837a, "onStop: Internal screen capture not send background msg. ");
            return;
        }
        C1260i.m4435b(f2837a, "onStop: full screen capture send background msg.");
        C1048c.m3442a(false, false);
    }

    /* renamed from: c */
    public void mo1403c() {
    }

    /* renamed from: d */
    public void mo1404d() {
        if (C1190a.m4065a()) {
            C1260i.m4435b(f2837a, "onResume: Internal screen capture not send forground msg.");
            return;
        }
        C1260i.m4435b(f2837a, "onResume: full screen capture send forground msg.");
        C1048c.m3442a(false, true);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        C1260i.m4435b(f2837a, "onConfigurationChanged: newConfig=" + newConfig);
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
