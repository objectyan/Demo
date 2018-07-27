package com.baidu.carlife.p059c.p064d;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;

/* compiled from: AndroidViewModel */
/* renamed from: com.baidu.carlife.c.d.a */
public class C1109a extends C1108f {
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: a */
    private Application f2883a;

    public C1109a(@NonNull Application application) {
        this.f2883a = application;
    }

    @NonNull
    /* renamed from: a */
    public <T extends Application> T m3739a() {
        return this.f2883a;
    }
}
