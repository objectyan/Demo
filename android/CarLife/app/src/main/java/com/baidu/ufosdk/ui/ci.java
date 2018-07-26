package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackListActivity */
final class ci implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ch f21619a;
    /* renamed from: b */
    private final /* synthetic */ Context f21620b;
    /* renamed from: c */
    private final /* synthetic */ String f21621c;

    ci(ch chVar, Context context, String str) {
        this.f21619a = chVar;
        this.f21620b = context;
        this.f21621c = str;
    }

    public final void run() {
        C5180a.m17570a(this.f21620b, this.f21621c);
    }
}
