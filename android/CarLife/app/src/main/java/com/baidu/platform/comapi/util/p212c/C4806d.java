package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.carlife.core.C1253f;
import com.baidu.platform.comapi.C2907c;

/* compiled from: DeviceIdInfo */
/* renamed from: com.baidu.platform.comapi.util.c.d */
public class C4806d implements C4800g {
    /* renamed from: a */
    private String f19915a;
    /* renamed from: b */
    private String f19916b;
    /* renamed from: c */
    private String f19917c;
    /* renamed from: d */
    private String f19918d;
    /* renamed from: e */
    private String f19919e;

    /* renamed from: a */
    public void mo3723a(Context context) {
        this.f19916b = Build.MODEL;
        this.f19917c = C1253f.jb + VERSION.SDK_INT;
        this.f19918d = Build.BRAND != null ? Build.BRAND : "";
        String vmVersion = System.getProperty("java.vm.version");
        if (vmVersion == null || !vmVersion.startsWith("2")) {
            this.f19919e = "0";
        } else {
            this.f19919e = "1";
        }
    }

    /* renamed from: a */
    public String m15956a() {
        if (this.f19918d == null) {
            mo3723a(C2907c.f());
        }
        return this.f19918d;
    }

    /* renamed from: b */
    public String m15958b() {
        if (TextUtils.isEmpty(this.f19916b)) {
            mo3723a(C2907c.f());
        }
        return this.f19916b;
    }

    /* renamed from: c */
    public String m15959c() {
        if (TextUtils.isEmpty(this.f19917c)) {
            mo3723a(C2907c.f());
        }
        return this.f19917c;
    }

    /* renamed from: d */
    public String m15960d() {
        if (TextUtils.isEmpty(this.f19915a)) {
            this.f19915a = DeviceId.getDeviceID(C2907c.f());
            mo3723a(C2907c.f());
        }
        return this.f19915a;
    }

    /* renamed from: e */
    public String m15961e() {
        if (TextUtils.isEmpty(this.f19919e)) {
            mo3723a(C2907c.f());
        }
        return this.f19919e;
    }
}
