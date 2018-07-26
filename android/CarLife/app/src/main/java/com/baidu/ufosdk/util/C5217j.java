package com.baidu.ufosdk.util;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

/* compiled from: CommonUtil */
/* renamed from: com.baidu.ufosdk.util.j */
final class C5217j implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Activity f21706a;
    /* renamed from: b */
    private final /* synthetic */ String f21707b;
    /* renamed from: c */
    private final /* synthetic */ long f21708c;

    C5217j(Activity activity, String str, long j) {
        this.f21706a = activity;
        this.f21707b = str;
        this.f21708c = j;
    }

    public final void run() {
        Toast makeText = Toast.makeText(this.f21706a, this.f21707b, 1);
        makeText.show();
        new Handler().postDelayed(new C5218k(this, makeText), this.f21708c);
    }
}
