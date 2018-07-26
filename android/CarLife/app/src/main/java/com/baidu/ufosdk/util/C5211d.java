package com.baidu.ufosdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: BehaviorStatistics */
/* renamed from: com.baidu.ufosdk.util.d */
public final class C5211d {
    /* renamed from: a */
    Context f21695a;
    /* renamed from: b */
    SharedPreferences f21696b;
    /* renamed from: c */
    Editor f21697c = this.f21696b.edit();

    public C5211d(Context context) {
        this.f21695a = context;
        this.f21696b = context.getSharedPreferences("UfoSharePreference", 0);
    }

    /* renamed from: a */
    private void m17738a(String str, int i) {
        this.f21697c.putInt(str, i);
        this.f21697c.commit();
    }

    /* renamed from: a */
    private int m17737a(String str) {
        return this.f21696b.getInt(str, 0);
    }

    /* renamed from: a */
    public final void m17740a(int i) {
        m17738a("editFeedbackView", i);
    }

    /* renamed from: b */
    public final void m17742b(int i) {
        m17738a("editFeedbackWord", i);
    }

    /* renamed from: c */
    public final void m17744c(int i) {
        m17738a("editFeedbackPicture", i);
    }

    /* renamed from: d */
    public final void m17746d(int i) {
        m17738a("myFeedback", i);
    }

    /* renamed from: a */
    public final int m17739a() {
        return m17737a("editFeedbackView");
    }

    /* renamed from: b */
    public final int m17741b() {
        return m17737a("editFeedbackWord");
    }

    /* renamed from: c */
    public final int m17743c() {
        return m17737a("editFeedbackPicture");
    }

    /* renamed from: d */
    public final int m17745d() {
        return m17737a("myFeedback");
    }

    /* renamed from: e */
    public final boolean m17747e() {
        if (m17737a("editFeedbackPicture") == 0 && m17737a("editFeedbackView") == 0 && m17737a("editFeedbackWord") == 0 && m17737a("myFeedback") == 0) {
            return false;
        }
        return true;
    }
}
