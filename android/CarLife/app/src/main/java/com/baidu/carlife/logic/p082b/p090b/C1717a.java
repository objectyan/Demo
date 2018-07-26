package com.baidu.carlife.logic.p082b.p090b;

import com.baidu.carlife.p059c.p063c.C1103a;
import com.baidu.carlife.p059c.p064d.C1115c;

/* compiled from: SettingItem */
/* renamed from: com.baidu.carlife.logic.b.b.a */
public class C1717a implements C1103a {
    /* renamed from: a */
    private C1115c<Integer> f5238a;
    /* renamed from: b */
    private C1115c<String> f5239b;
    /* renamed from: c */
    private C1115c<String> f5240c;
    /* renamed from: d */
    private C1115c<Boolean> f5241d;
    /* renamed from: e */
    private C1115c<Boolean> f5242e;

    /* compiled from: SettingItem */
    /* renamed from: com.baidu.carlife.logic.b.b.a$a */
    public static final class C1716a {
        /* renamed from: a */
        private C1115c<Integer> f5233a;
        /* renamed from: b */
        private C1115c<String> f5234b;
        /* renamed from: c */
        private C1115c<String> f5235c;
        /* renamed from: d */
        private C1115c<Boolean> f5236d;
        /* renamed from: e */
        private C1115c<Boolean> f5237e;

        private C1716a() {
        }

        /* renamed from: a */
        public static C1716a m6266a() {
            return new C1716a();
        }

        /* renamed from: a */
        public C1716a m6267a(C1115c<Integer> layoutId) {
            this.f5233a = layoutId;
            return this;
        }

        /* renamed from: b */
        public C1716a m6269b(C1115c<String> description) {
            this.f5234b = description;
            return this;
        }

        /* renamed from: c */
        public C1716a m6270c(C1115c<String> itemName) {
            this.f5235c = itemName;
            return this;
        }

        /* renamed from: d */
        public C1716a m6272d(C1115c<Boolean> checked) {
            this.f5236d = checked;
            return this;
        }

        /* renamed from: e */
        public C1716a m6273e(C1115c<Boolean> showRedPoint) {
            this.f5237e = showRedPoint;
            return this;
        }

        /* renamed from: b */
        public C1716a m6268b() {
            return C1716a.m6266a().m6267a(this.f5233a).m6269b(this.f5234b).m6270c(this.f5235c).m6272d(this.f5236d).m6273e(this.f5237e);
        }

        /* renamed from: c */
        public C1717a m6271c() {
            C1717a settingItem = new C1717a();
            settingItem.mo1622a(this.f5233a);
            settingItem.m6281d(this.f5234b);
            settingItem.m6283e(this.f5235c);
            settingItem.m6277b(this.f5236d);
            settingItem.m6279c(this.f5237e);
            return settingItem;
        }
    }

    /* renamed from: b */
    public C1115c<Boolean> m6276b() {
        return this.f5241d;
    }

    /* renamed from: b */
    public void m6277b(C1115c<Boolean> checked) {
        this.f5241d = checked;
    }

    /* renamed from: c */
    public C1115c<Boolean> m6278c() {
        return this.f5242e;
    }

    /* renamed from: c */
    public void m6279c(C1115c<Boolean> showRedPoint) {
        this.f5242e = showRedPoint;
    }

    /* renamed from: a */
    public C1115c<Integer> mo1621a() {
        return this.f5238a;
    }

    /* renamed from: a */
    public void mo1622a(C1115c<Integer> layoutId) {
        this.f5238a = layoutId;
    }

    /* renamed from: d */
    public C1115c<String> m6280d() {
        return this.f5239b;
    }

    /* renamed from: d */
    public void m6281d(C1115c<String> description) {
        this.f5239b = description;
    }

    /* renamed from: e */
    public C1115c<String> m6282e() {
        return this.f5240c;
    }

    /* renamed from: e */
    public void m6283e(C1115c<String> itemName) {
        this.f5240c = itemName;
    }
}
