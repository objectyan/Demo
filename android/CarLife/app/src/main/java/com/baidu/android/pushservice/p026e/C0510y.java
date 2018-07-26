package com.baidu.android.pushservice.p026e;

import android.content.Context;
import com.baidu.android.pushservice.p024c.C0448d;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.y */
public class C0510y extends C0488d {

    /* renamed from: com.baidu.android.pushservice.e.y$a */
    private enum C0509a {
        MODEL_O(1),
        MODEL_C(2),
        MODEL_HW(3),
        MODEL_XM(4),
        MODEL_MZ(5),
        MODEL_OP(6);
        
        /* renamed from: g */
        private int f1644g;

        private C0509a(int i) {
            this.f1644g = i;
        }

        /* renamed from: a */
        private int m2111a() {
            return this.f1644g;
        }
    }

    public C0510y(C0496l c0496l, Context context) {
        super(c0496l, context);
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "unbind");
        int a = C0509a.MODEL_O.m2111a();
        int b = C0448d.m1932a(this.a).m1952b();
        if (C0448d.m1941d(this.a)) {
            a = C0509a.MODEL_HW.m2111a();
        } else if (C0448d.m1940c(this.a)) {
            a = C0509a.MODEL_XM.m2111a();
        } else if (C0448d.m1939b(this.a)) {
            a = C0509a.MODEL_MZ.m2111a();
        } else if (C0448d.m1942e(this.a)) {
            a = C0509a.MODEL_OP.m2111a();
        } else if (b == 2 || b == 4 || b == 3) {
            a = C0509a.MODEL_C.m2111a();
        }
        hashMap.put("model", a + "");
    }
}
