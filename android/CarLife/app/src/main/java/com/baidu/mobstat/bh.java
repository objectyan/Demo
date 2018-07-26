package com.baidu.mobstat;

import android.app.Activity;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class bh extends AccessibilityDelegate {
    /* renamed from: a */
    final /* synthetic */ bf f19447a;
    /* renamed from: b */
    private AccessibilityDelegate f19448b;
    /* renamed from: c */
    private Activity f19449c;
    /* renamed from: d */
    private View f19450d;
    /* renamed from: e */
    private String f19451e;

    public bh(bf bfVar, Activity activity, View view, String str, AccessibilityDelegate accessibilityDelegate) {
        this.f19447a = bfVar;
        this.f19448b = accessibilityDelegate;
        this.f19449c = activity;
        this.f19450d = view;
        this.f19451e = str;
    }

    public void sendAccessibilityEvent(View view, int i) {
        if (view == this.f19450d && i == 1) {
            this.f19447a.m15451b(this.f19449c, this.f19450d, this.f19451e);
        }
        if (this.f19448b != null) {
            this.f19448b.sendAccessibilityEvent(view, i);
        }
    }
}
