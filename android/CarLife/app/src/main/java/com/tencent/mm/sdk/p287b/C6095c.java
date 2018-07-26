package com.tencent.mm.sdk.p287b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.p287b.C6094b.C6093a;

/* renamed from: com.tencent.mm.sdk.b.c */
final class C6095c implements C6093a {
    private Handler handler = new Handler(Looper.getMainLooper());

    C6095c() {
    }

    /* renamed from: f */
    public final void mo4976f(String str, String str2) {
        if (C6094b.level <= 2) {
            Log.i(str, str2);
        }
    }

    /* renamed from: g */
    public final void mo4977g(String str, String str2) {
        if (C6094b.level <= 1) {
            Log.d(str, str2);
        }
    }

    public final int getLogLevel() {
        return C6094b.level;
    }

    /* renamed from: h */
    public final void mo4979h(String str, String str2) {
        if (C6094b.level <= 3) {
            Log.w(str, str2);
        }
    }

    /* renamed from: i */
    public final void mo4980i(String str, String str2) {
        if (C6094b.level <= 4) {
            Log.e(str, str2);
        }
    }
}
