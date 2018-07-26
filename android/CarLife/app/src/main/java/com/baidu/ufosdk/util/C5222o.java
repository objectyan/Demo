package com.baidu.ufosdk.util;

import android.app.Activity;
import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackInputActivity;

/* compiled from: GlobalScreenShot */
/* renamed from: com.baidu.ufosdk.util.o */
final class C5222o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C5221n f21715a;
    /* renamed from: b */
    private final /* synthetic */ Activity f21716b;
    /* renamed from: c */
    private final /* synthetic */ int f21717c;

    C5222o(C5221n c5221n, Activity activity, int i) {
        this.f21715a = c5221n;
        this.f21716b = activity;
        this.f21717c = i;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setClass(this.f21716b, FeedbackInputActivity.class);
        intent.putExtra("shot", this.f21715a.f21714d.toByteArray());
        intent.putExtra("currentview", 1);
        intent.putExtra("feedback_channel", this.f21717c);
        this.f21716b.startActivity(intent);
    }
}
