package com.baidu.tts.p225m;

import com.baidu.tts.p224n.C5004a;
import com.baidu.tts.p233f.C5086d;
import com.baidu.tts.p233f.C5090h;

/* compiled from: BaseSynthesizerParams */
/* renamed from: com.baidu.tts.m.d */
public class C5005d<T> extends C5004a<T> {
    /* renamed from: a */
    private String f20724a = "5";
    /* renamed from: b */
    private String f20725b = "5";
    /* renamed from: c */
    private String f20726c = "5";
    /* renamed from: d */
    private C5090h f20727d = C5090h.ZH;
    /* renamed from: e */
    private C5086d f20728e = C5086d.UTF8;
    /* renamed from: f */
    private String f20729f = "0";

    /* renamed from: q */
    public String m16778q() {
        return this.f20728e.m17269a();
    }

    /* renamed from: r */
    public String m16779r() {
        return this.f20728e.m17270b();
    }

    /* renamed from: a */
    public void m16772a(C5086d c5086d) {
        this.f20728e = c5086d;
    }

    /* renamed from: s */
    public String m16780s() {
        return this.f20727d.m17276a();
    }

    /* renamed from: i */
    public void m16773i(String str) {
        this.f20727d = C5090h.m17275a(str);
    }

    /* renamed from: j */
    public void m16774j(String str) {
        this.f20729f = str;
    }

    /* renamed from: t */
    public String m16781t() {
        return this.f20729f;
    }

    /* renamed from: u */
    public long m16782u() {
        long j = 0;
        try {
            j = Long.parseLong(this.f20729f);
        } catch (Exception e) {
        }
        return j;
    }

    /* renamed from: v */
    public String m16783v() {
        return this.f20724a;
    }

    /* renamed from: k */
    public void m16775k(String str) {
        this.f20724a = str;
    }

    /* renamed from: w */
    public String m16784w() {
        return this.f20725b;
    }

    /* renamed from: l */
    public void m16776l(String str) {
        this.f20725b = str;
    }

    /* renamed from: x */
    public String m16785x() {
        return this.f20726c;
    }

    /* renamed from: m */
    public void m16777m(String str) {
        this.f20726c = str;
    }

    /* renamed from: y */
    public long m16786y() {
        return Long.parseLong(this.f20726c);
    }

    /* renamed from: z */
    public long m16787z() {
        return Long.parseLong(this.f20724a);
    }

    /* renamed from: A */
    public long m16771A() {
        return Long.parseLong(this.f20725b);
    }
}
