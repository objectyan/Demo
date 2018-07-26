package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.platform.comapi.C2907c;

/* compiled from: PathInfo */
/* renamed from: com.baidu.platform.comapi.util.c.l */
public class C4818l implements C4800g {
    /* renamed from: a */
    private String f19949a;
    /* renamed from: b */
    private String f19950b;
    /* renamed from: c */
    private String f19951c;
    /* renamed from: d */
    private String f19952d;
    /* renamed from: e */
    private String f19953e;

    /* renamed from: a */
    public void mo3723a(Context context) {
        this.f19949a = context.getFilesDir().getAbsolutePath();
        this.f19952d = context.getCacheDir().getAbsolutePath();
        this.f19953e = this.f19952d;
        this.f19950b = Environment.getExternalStorageDirectory().getPath();
    }

    /* renamed from: a */
    public String m15990a() {
        if (TextUtils.isEmpty(this.f19949a)) {
            mo3723a(C2907c.f());
        }
        return this.f19949a;
    }

    /* renamed from: b */
    public String m15993b() {
        return this.f19950b;
    }

    /* renamed from: a */
    public void m15992a(String sdcardPath) {
        this.f19950b = sdcardPath;
    }

    /* renamed from: b */
    public void m15994b(String sdcardDataPath) {
        this.f19951c = sdcardDataPath;
    }

    /* renamed from: c */
    public String m15995c() {
        return this.f19951c;
    }

    /* renamed from: d */
    public String m15997d() {
        return this.f19952d;
    }

    /* renamed from: c */
    public void m15996c(String outputCache) {
        this.f19952d = outputCache;
    }

    /* renamed from: e */
    public String m15999e() {
        return this.f19953e;
    }

    /* renamed from: d */
    public void m15998d(String outputSecondCache) {
        this.f19953e = outputSecondCache;
    }
}
