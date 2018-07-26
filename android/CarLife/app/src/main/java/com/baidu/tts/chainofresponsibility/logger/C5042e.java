package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PrintLogger */
/* renamed from: com.baidu.tts.chainofresponsibility.logger.e */
public class C5042e {
    /* renamed from: a */
    private List<String> f20832a = new ArrayList();
    /* renamed from: b */
    private List<String> f20833b = new ArrayList();

    /* renamed from: a */
    public void m17029a() {
        if (this.f20832a != null) {
            this.f20832a.clear();
        }
        if (this.f20833b != null) {
            this.f20833b.clear();
        }
    }

    /* renamed from: a */
    public void m17031a(String str) {
        if (this.f20832a != null && !this.f20832a.contains(str)) {
            this.f20832a.add(str);
        }
    }

    /* renamed from: a */
    public void m17032a(List<String> list) {
        if (this.f20832a != null) {
            this.f20832a.addAll(list);
        }
    }

    /* renamed from: b */
    public void m17033b(String str) {
        if (this.f20833b != null && !this.f20833b.contains(str)) {
            this.f20833b.add(str);
        }
    }

    /* renamed from: a */
    public void m17030a(C5037c c5037c, Void voidR, C5041d c5041d) {
        Object obj;
        String b = c5037c.m17009b();
        String c = c5037c.m17011c();
        String d = c5037c.m17012d();
        if (d != null) {
            d = "(" + d + ")" + c;
        } else {
            d = c;
        }
        if (this.f20833b == null || this.f20833b.isEmpty()) {
            int i = 1;
        } else if (this.f20833b.contains(b)) {
            obj = null;
        } else {
            obj = 1;
            for (String c2 : this.f20833b) {
                Object obj2;
                if (c2 == null || d == null || !d.contains(c2)) {
                    obj2 = obj;
                } else {
                    obj2 = null;
                }
                obj = obj2;
            }
        }
        if (!(this.f20832a == null || this.f20832a.isEmpty())) {
            if (this.f20832a.contains(b)) {
                obj = 1;
            } else {
                for (String c22 : this.f20832a) {
                    if (!(c22 == null || d == null)) {
                        if (d.contains(c22)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                }
            }
        }
        if (obj != null) {
            Log.println(c5037c.m17006a(), "bdtts-" + b, d);
        }
    }
}
