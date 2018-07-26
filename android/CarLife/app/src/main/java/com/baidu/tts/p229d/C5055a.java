package com.baidu.tts.p229d;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CheckResult */
/* renamed from: com.baidu.tts.d.a */
public class C5055a {
    /* renamed from: a */
    private boolean f20909a = false;
    /* renamed from: b */
    private Map<String, Integer> f20910b = new HashMap();

    /* renamed from: a */
    public boolean m17099a() {
        return this.f20909a;
    }

    /* renamed from: a */
    public void m17098a(boolean z) {
        this.f20909a = z;
    }

    /* renamed from: a */
    public void m17097a(String str, int i) {
        this.f20910b.put(str, Integer.valueOf(i));
    }

    /* renamed from: b */
    public boolean m17100b() {
        for (Integer intValue : this.f20910b.values()) {
            if (intValue.intValue() != 7) {
                return false;
            }
        }
        return true;
    }
}
