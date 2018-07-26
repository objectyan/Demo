package com.baidu.tts.p225m;

import android.text.TextUtils;
import com.baidu.tts.p224n.C5004a;
import com.baidu.tts.p233f.C5091i;
import java.io.UnsupportedEncodingException;

/* compiled from: TextParams */
/* renamed from: com.baidu.tts.m.i */
public class C5146i extends C5004a<C5146i> {
    /* renamed from: a */
    private String f21267a;
    /* renamed from: b */
    private String f21268b;
    /* renamed from: c */
    private String f21269c = "0";
    /* renamed from: d */
    private C5091i f21270d;
    /* renamed from: e */
    private String f21271e;

    public C5146i(String str, String str2) {
        m17439b(str);
        m17443d(str2);
    }

    /* renamed from: a */
    public void m17435a() {
        if (!TextUtils.isEmpty(this.f21271e)) {
            this.f21267a = this.f21271e + this.f21267a;
        }
    }

    /* renamed from: b */
    public String m17438b() {
        return this.f21271e;
    }

    /* renamed from: a */
    public void m17437a(String str) {
        this.f21271e = str;
    }

    /* renamed from: c */
    public String m17440c() {
        return this.f21267a;
    }

    /* renamed from: b */
    public void m17439b(String str) {
        this.f21267a = str;
    }

    /* renamed from: d */
    public String m17442d() {
        return this.f21268b;
    }

    /* renamed from: c */
    public void m17441c(String str) {
        this.f21268b = str;
    }

    /* renamed from: e */
    public byte[] m17444e() {
        byte[] bArr = null;
        try {
            bArr = this.f21267a.getBytes(this.f21268b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    /* renamed from: f */
    public String m17445f() {
        return this.f21269c;
    }

    /* renamed from: d */
    public void m17443d(String str) {
        if (str == null) {
            str = "0";
        }
        this.f21269c = str;
    }

    /* renamed from: g */
    public C5091i m17446g() {
        return this.f21270d;
    }

    /* renamed from: a */
    public void m17436a(C5091i c5091i) {
        this.f21270d = c5091i;
    }
}
