package com.baidu.carlife.core.screen.presentation.p071a;

import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C0690d;
import com.baidu.carlife.core.screen.C1281i;

/* compiled from: CarlifeProgressDialogContainer */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.e */
public class C1307e implements C1281i {
    /* renamed from: b */
    private static C1307e f3765b = new C1307e();
    /* renamed from: a */
    private C1281i f3766a = null;

    /* renamed from: a */
    public static C1307e m4686a() {
        return f3765b;
    }

    private C1307e() {
    }

    /* renamed from: a */
    public void m4687a(C1281i listener) {
        this.f3766a = listener;
    }

    /* renamed from: c */
    public void mo1468c() {
        this.f3766a.mo1468c();
    }

    /* renamed from: b */
    public void mo1467b(String msg) {
        this.f3766a.mo1467b(msg);
    }

    /* renamed from: a */
    public void mo1465a(String msg, C0672b cancelListener) {
        this.f3766a.mo1465a(msg, cancelListener);
    }

    /* renamed from: a */
    public void mo1466a(String msg, C0672b cancelListener, C0690d listener) {
        this.f3766a.mo1466a(msg, cancelListener, listener);
    }

    /* renamed from: d */
    public boolean mo1469d() {
        return this.f3766a.mo1469d();
    }
}
