package com.baidu.carlife.logic.p088a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AntiShakeOnClickListener */
/* renamed from: com.baidu.carlife.logic.a.a */
public abstract class C1681a implements OnClickListener {
    /* renamed from: a */
    private long f5176a = 0;
    /* renamed from: b */
    private long f5177b = 500;

    /* renamed from: a */
    protected abstract void mo1784a(View view);

    /* renamed from: a */
    public void m6134a(long timeInterval) {
        this.f5177b = timeInterval;
    }

    public void onClick(View v) {
        if (!m6133b()) {
            this.f5176a = System.currentTimeMillis();
            mo1784a(v);
        }
    }

    /* renamed from: b */
    private boolean m6133b() {
        return System.currentTimeMillis() - this.f5176a < this.f5177b || m6136a();
    }

    /* renamed from: a */
    protected boolean m6136a() {
        return false;
    }
}
