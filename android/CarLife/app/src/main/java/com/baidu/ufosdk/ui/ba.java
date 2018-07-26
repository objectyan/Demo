package com.baidu.ufosdk.ui;

import android.content.SharedPreferences.Editor;
import com.baidu.ufosdk.util.C5220m;

/* compiled from: FeedbackInputActivity */
final class ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ az f21566a;
    /* renamed from: b */
    private final /* synthetic */ String f21567b;

    ba(az azVar, String str) {
        this.f21566a = azVar;
        this.f21567b = str;
    }

    public final void run() {
        Editor edit = this.f21566a.f21563a.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("contact", C5220m.m17770a(this.f21567b));
        edit.commit();
        this.f21566a.f21563a.aw = this.f21567b;
        FeedbackInputActivity.m17636P(this.f21566a.f21563a);
    }
}
