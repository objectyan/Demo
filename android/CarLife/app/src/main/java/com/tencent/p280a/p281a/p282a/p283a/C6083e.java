package com.tencent.p280a.p281a.p282a.p283a;

import android.content.Context;
import android.provider.Settings.System;
import android.util.Log;

/* renamed from: com.tencent.a.a.a.a.e */
public final class C6083e extends C6079f {
    public C6083e(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected final void mo4973a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            System.putString(this.a.getContentResolver(), C6085h.m21669c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    /* renamed from: a */
    protected final boolean mo4974a() {
        return C6085h.m21665a(this.a, "android.permission.WRITE_SETTINGS");
    }

    /* renamed from: b */
    protected final String mo4975b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            string = System.getString(this.a.getContentResolver(), C6085h.m21669c("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }
}
