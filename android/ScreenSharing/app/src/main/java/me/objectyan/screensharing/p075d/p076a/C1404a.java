package com.baidu.carlife.p075d.p076a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import p003b.C0329m;
import p003b.C0329m.C0328a;
import p003b.C0330n;
import p003b.C0344u;

/* compiled from: CookieJarImpl */
/* renamed from: com.baidu.carlife.d.a.a */
final class C1404a implements C0330n {
    /* renamed from: a */
    List<C0329m> f4123a = new ArrayList();

    C1404a() {
    }

    /* renamed from: a */
    public void mo1138a(C0344u url, List<C0329m> list) {
    }

    /* renamed from: a */
    public List<C0329m> mo1137a(C0344u url) {
        return this.f4123a;
    }

    /* renamed from: a */
    public void m5187a(String name, String value, String domain) {
        m5183a(new C0328a().m1038a(name).m1040b(value).m1041c(domain).m1042c());
    }

    /* renamed from: a */
    public void m5185a() {
        this.f4123a.clear();
    }

    /* renamed from: a */
    private void m5183a(C0329m cookie) {
        for (C0329m c : this.f4123a) {
            if (TextUtils.equals(c.m1054a(), cookie.m1054a())) {
                this.f4123a.remove(c);
                this.f4123a.add(cookie);
                return;
            }
        }
        this.f4123a.add(cookie);
    }
}
