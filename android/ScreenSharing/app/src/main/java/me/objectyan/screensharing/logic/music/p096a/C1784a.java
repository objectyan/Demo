package com.baidu.carlife.logic.music.p096a;

import com.baidu.carlife.p059c.p063c.C1103a;
import com.baidu.carlife.p059c.p064d.C1115c;

/* compiled from: DiscoverCardModel */
/* renamed from: com.baidu.carlife.logic.music.a.a */
public class C1784a implements C1103a {
    /* renamed from: a */
    private C1115c<Integer> f5424a;
    /* renamed from: b */
    private C1115c<String> f5425b;
    /* renamed from: c */
    private C1115c<String> f5426c;
    /* renamed from: d */
    private C1115c<Integer> f5427d;
    /* renamed from: e */
    private C1115c<Integer> f5428e;

    /* compiled from: DiscoverCardModel */
    /* renamed from: com.baidu.carlife.logic.music.a.a$a */
    public static final class C1783a {
        /* renamed from: a */
        private C1115c<Integer> f5419a;
        /* renamed from: b */
        private C1115c<String> f5420b;
        /* renamed from: c */
        private C1115c<String> f5421c;
        /* renamed from: d */
        private C1115c<Integer> f5422d;
        /* renamed from: e */
        private C1115c<Integer> f5423e;

        private C1783a() {
        }

        /* renamed from: a */
        public static C1783a m6530a() {
            return new C1783a();
        }

        /* renamed from: a */
        public C1783a m6531a(C1115c<Integer> layoutId) {
            this.f5419a = layoutId;
            return this;
        }

        /* renamed from: b */
        public C1783a m6533b(C1115c<String> title) {
            this.f5420b = title;
            return this;
        }

        /* renamed from: c */
        public C1783a m6534c(C1115c<String> description) {
            this.f5421c = description;
            return this;
        }

        /* renamed from: d */
        public C1783a m6536d(C1115c<Integer> iconResource) {
            this.f5422d = iconResource;
            return this;
        }

        /* renamed from: e */
        public C1783a m6537e(C1115c<Integer> position) {
            this.f5423e = position;
            return this;
        }

        /* renamed from: b */
        public C1783a m6532b() {
            return C1783a.m6530a().m6531a(this.f5419a).m6533b(this.f5420b).m6534c(this.f5421c).m6536d(this.f5422d).m6537e(this.f5423e);
        }

        /* renamed from: c */
        public C1784a m6535c() {
            C1784a discoverCardModel = new C1784a();
            discoverCardModel.mo1622a(this.f5419a);
            discoverCardModel.m6541b(this.f5420b);
            discoverCardModel.m6543c(this.f5421c);
            discoverCardModel.m6545d(this.f5422d);
            discoverCardModel.m6547e(this.f5423e);
            return discoverCardModel;
        }
    }

    /* renamed from: a */
    public C1115c<Integer> mo1621a() {
        return this.f5424a;
    }

    /* renamed from: a */
    public void mo1622a(C1115c<Integer> layoutId) {
        this.f5424a = layoutId;
    }

    /* renamed from: b */
    public C1115c<String> m6540b() {
        return this.f5425b;
    }

    /* renamed from: b */
    public void m6541b(C1115c<String> title) {
        this.f5425b = title;
    }

    /* renamed from: c */
    public C1115c<String> m6542c() {
        return this.f5426c;
    }

    /* renamed from: c */
    public void m6543c(C1115c<String> description) {
        this.f5426c = description;
    }

    /* renamed from: d */
    public C1115c<Integer> m6544d() {
        return this.f5427d;
    }

    /* renamed from: d */
    public void m6545d(C1115c<Integer> iconResource) {
        this.f5427d = iconResource;
    }

    /* renamed from: e */
    public C1115c<Integer> m6546e() {
        return this.f5428e;
    }

    /* renamed from: e */
    public void m6547e(C1115c<Integer> position) {
        this.f5428e = position;
    }
}
