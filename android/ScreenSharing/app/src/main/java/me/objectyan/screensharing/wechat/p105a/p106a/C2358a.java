package com.baidu.carlife.wechat.p105a.p106a;

import java.util.Map;

/* compiled from: HttpResult */
/* renamed from: com.baidu.carlife.wechat.a.a.a */
public class C2358a {
    /* renamed from: a */
    private int f7805a;
    /* renamed from: b */
    private String f7806b;
    /* renamed from: c */
    private Map<String, String> f7807c;
    /* renamed from: d */
    private String f7808d;

    /* renamed from: a */
    public void m8962a(int statusCode) {
        this.f7805a = statusCode;
    }

    /* renamed from: a */
    public void m8963a(String response) {
        this.f7806b = response;
    }

    /* renamed from: b */
    public void m8966b(String filePath) {
        this.f7808d = filePath;
    }

    /* renamed from: a */
    public void m8964a(Map<String, String> cookies) {
        this.f7807c = cookies;
    }

    /* renamed from: a */
    public Integer m8961a() {
        return Integer.valueOf(this.f7805a);
    }

    /* renamed from: b */
    public String m8965b() {
        return this.f7806b;
    }

    /* renamed from: c */
    public Map<String, String> m8967c() {
        return this.f7807c;
    }

    /* renamed from: d */
    public String m8968d() {
        return this.f7808d;
    }
}
