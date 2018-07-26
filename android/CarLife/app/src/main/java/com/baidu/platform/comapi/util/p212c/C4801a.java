package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.baidu.platform.comapi.C2907c;

/* compiled from: AppInfo */
/* renamed from: com.baidu.platform.comapi.util.c.a */
public class C4801a implements C4800g {
    /* renamed from: a */
    private String f19908a;
    /* renamed from: b */
    private int f19909b;
    /* renamed from: c */
    private byte[] f19910c;

    /* renamed from: a */
    public void mo3723a(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            this.f19908a = info.versionName;
            this.f19909b = info.versionCode;
        } catch (NameNotFoundException e) {
            this.f19908a = "1.0.0";
            this.f19909b = 1;
        }
        try {
            this.f19910c = manager.getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
        } catch (NameNotFoundException e2) {
            this.f19910c = new byte[0];
        }
    }

    /* renamed from: a */
    public String m15944a() {
        if (TextUtils.isEmpty(this.f19908a)) {
            mo3723a(C2907c.f());
        }
        return this.f19908a;
    }

    /* renamed from: b */
    public int m15946b() {
        if (this.f19909b == 0) {
            mo3723a(C2907c.f());
        }
        return this.f19909b;
    }

    /* renamed from: c */
    public byte[] m15947c() {
        if (this.f19910c == null) {
            mo3723a(C2907c.f());
        }
        return this.f19910c;
    }
}
