package com.baidu.carlife.model;

import android.text.TextUtils;

/* compiled from: ThirdPartyAppModel */
/* renamed from: com.baidu.carlife.model.o */
public class C1930o {
    /* renamed from: f */
    public static final int f6057f = 0;
    /* renamed from: g */
    public int f6058g;
    /* renamed from: h */
    public String f6059h;
    /* renamed from: i */
    public String f6060i;
    /* renamed from: j */
    public String f6061j;
    /* renamed from: k */
    public String f6062k;
    /* renamed from: l */
    public String f6063l;
    /* renamed from: m */
    public String f6064m;
    /* renamed from: n */
    public String f6065n;

    /* renamed from: a */
    public String m7398a() {
        if (TextUtils.isEmpty(this.f6065n)) {
            return null;
        }
        return "com.baidu.carlife.platform." + this.f6065n;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof C1930o) {
            C1930o model = (C1930o) o;
            if (!TextUtils.isEmpty(this.f6064m) && this.f6064m.equals(model.f6064m)) {
                return true;
            }
        }
        return false;
    }
}
