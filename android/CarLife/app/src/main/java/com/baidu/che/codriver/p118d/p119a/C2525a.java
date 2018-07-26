package com.baidu.che.codriver.p118d.p119a;

import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p075d.p076a.C1408c;
import com.baidu.carlife.p075d.p076a.C1416e;
import java.util.Map;

/* compiled from: AbsHttpPostRequest */
/* renamed from: com.baidu.che.codriver.d.a.a */
public abstract class C2525a implements C1408c, C2524b {
    /* renamed from: a */
    protected static final String f8264a = "network";
    /* renamed from: b */
    private String f8265b;

    /* renamed from: a */
    public abstract void mo1878a(String str, int i, String str2);

    /* renamed from: a */
    public void mo1876a() {
        this.f8265b = mo1879c();
        C1416e.m5213c(this.f8265b, mo1880d(), this);
    }

    /* renamed from: b */
    public void mo1877b() {
        C1416e.m5205a(this.f8265b);
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        C1260i.m4435b("network", "onSuccess statusCode = " + statusCode + ";response = " + response);
        mo1878a(this.f8265b, statusCode, response);
    }
}
