package com.tencent.p280a.p281a.p282a.p283a;

import android.content.Context;

/* renamed from: com.tencent.a.a.a.a.f */
public abstract class C6079f {
    /* renamed from: a */
    protected Context f24736a = null;

    protected C6079f(Context context) {
        this.f24736a = context;
    }

    /* renamed from: a */
    public final void m21641a(C6081c c6081c) {
        if (c6081c != null) {
            String c6081c2 = c6081c.toString();
            if (mo4974a()) {
                mo4973a(C6085h.m21670d(c6081c2));
            }
        }
    }

    /* renamed from: a */
    protected abstract void mo4973a(String str);

    /* renamed from: a */
    protected abstract boolean mo4974a();

    /* renamed from: b */
    protected abstract String mo4975b();

    /* renamed from: c */
    public final C6081c m21645c() {
        String c = mo4974a() ? C6085h.m21669c(mo4975b()) : null;
        return c != null ? C6081c.m21649a(c) : null;
    }
}
