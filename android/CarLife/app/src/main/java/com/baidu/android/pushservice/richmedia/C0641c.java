package com.baidu.android.pushservice.richmedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.android.pushservice.richmedia.c */
public class C0641c {
    /* renamed from: a */
    public String f2032a;
    /* renamed from: b */
    public String f2033b;
    /* renamed from: c */
    public String f2034c;
    /* renamed from: d */
    public String f2035d;
    /* renamed from: e */
    protected C0640a f2036e;
    /* renamed from: f */
    public HashMap<String, String> f2037f = new HashMap();
    /* renamed from: g */
    public boolean f2038g = true;
    /* renamed from: h */
    public boolean f2039h = false;
    /* renamed from: i */
    private String f2040i;
    /* renamed from: j */
    private Map<String, String> f2041j = new HashMap();
    /* renamed from: k */
    private String f2042k;
    /* renamed from: l */
    private String f2043l;
    /* renamed from: m */
    private String f2044m;

    /* renamed from: com.baidu.android.pushservice.richmedia.c$a */
    public enum C0640a {
        REQ_TYPE_GET_ZIP
    }

    /* renamed from: a */
    public C0640a m2803a() {
        return this.f2036e;
    }

    /* renamed from: a */
    public void m2804a(C0640a c0640a) {
        this.f2036e = c0640a;
    }

    /* renamed from: a */
    public void m2805a(String str) {
        this.f2042k = str;
    }

    /* renamed from: b */
    public String m2806b() {
        return this.f2042k == null ? "GET" : this.f2042k;
    }

    /* renamed from: b */
    public void m2807b(String str) {
        this.f2043l = str;
    }

    /* renamed from: c */
    public String m2808c() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f2043l != null) {
            stringBuffer.append(this.f2043l);
        }
        this.f2043l = stringBuffer.toString();
        return this.f2043l.endsWith("&") ? this.f2043l.substring(0, this.f2043l.length() - 1) : this.f2043l;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r4 != r5) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof com.baidu.android.pushservice.richmedia.C0641c;
        if (r2 == 0) goto L_0x0098;
    L_0x0009:
        r5 = (com.baidu.android.pushservice.richmedia.C0641c) r5;
        r2 = r4.f2040i;
        if (r2 != 0) goto L_0x004b;
    L_0x000f:
        r2 = r5.f2040i;
        if (r2 != 0) goto L_0x0049;
    L_0x0013:
        r2 = r4.f2036e;
        if (r2 != 0) goto L_0x0056;
    L_0x0017:
        r2 = r5.f2036e;
        if (r2 != 0) goto L_0x0049;
    L_0x001b:
        r2 = r4.f2041j;
        if (r2 != 0) goto L_0x0061;
    L_0x001f:
        r2 = r5.f2041j;
        if (r2 != 0) goto L_0x0049;
    L_0x0023:
        r2 = r4.f2042k;
        if (r2 != 0) goto L_0x006c;
    L_0x0027:
        r2 = r5.f2042k;
        if (r2 != 0) goto L_0x0049;
    L_0x002b:
        r2 = r4.f2043l;
        if (r2 != 0) goto L_0x0077;
    L_0x002f:
        r2 = r5.f2043l;
        if (r2 != 0) goto L_0x0049;
    L_0x0033:
        r2 = r4.f2044m;
        if (r2 != 0) goto L_0x0082;
    L_0x0037:
        r2 = r5.f2044m;
        if (r2 != 0) goto L_0x0049;
    L_0x003b:
        r2 = r4.f2037f;
        if (r2 != 0) goto L_0x008d;
    L_0x003f:
        r2 = r5.f2037f;
        if (r2 != 0) goto L_0x0049;
    L_0x0043:
        r2 = r4.f2039h;
        r3 = r5.f2039h;
        if (r2 == r3) goto L_0x0004;
    L_0x0049:
        r0 = r1;
        goto L_0x0004;
    L_0x004b:
        r2 = r4.f2040i;
        r3 = r5.f2040i;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0049;
    L_0x0055:
        goto L_0x0013;
    L_0x0056:
        r2 = r4.f2036e;
        r3 = r5.f2036e;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0049;
    L_0x0060:
        goto L_0x001b;
    L_0x0061:
        r2 = r4.f2041j;
        r3 = r5.f2041j;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0049;
    L_0x006b:
        goto L_0x0023;
    L_0x006c:
        r2 = r4.f2042k;
        r3 = r5.f2042k;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0049;
    L_0x0076:
        goto L_0x002b;
    L_0x0077:
        r2 = r4.f2043l;
        r3 = r5.f2043l;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0049;
    L_0x0081:
        goto L_0x0033;
    L_0x0082:
        r2 = r4.f2044m;
        r3 = r5.f2044m;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0049;
    L_0x008c:
        goto L_0x003b;
    L_0x008d:
        r2 = r4.f2037f;
        r3 = r5.f2037f;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0049;
    L_0x0097:
        goto L_0x0043;
    L_0x0098:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.richmedia.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2040i);
        arrayList.add(this.f2036e);
        arrayList.add(this.f2041j);
        arrayList.add(this.f2042k);
        arrayList.add(this.f2043l);
        arrayList.add(this.f2044m);
        arrayList.add(this.f2037f);
        arrayList.add(Boolean.valueOf(this.f2039h));
        return arrayList.hashCode();
    }
}
