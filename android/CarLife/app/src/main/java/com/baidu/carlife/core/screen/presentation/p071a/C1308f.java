package com.baidu.carlife.core.screen.presentation.p071a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.C1279g;
import com.baidu.carlife.core.screen.C1280h;
import com.baidu.carlife.core.screen.C1281i;
import com.baidu.carlife.core.screen.C1283l;
import com.baidu.carlife.core.screen.C1284m;

/* compiled from: CarlifeView */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.f */
public abstract class C1308f implements C1277e, C1279g, C1280h, C1281i, C1283l, C1284m {
    /* renamed from: a */
    protected View f3767a;
    /* renamed from: b */
    protected Context f3768b;

    /* renamed from: e */
    public abstract Context mo1482e();

    /* renamed from: f */
    public abstract void mo1483f();

    public C1308f(Context context, int rId) {
        this.f3768b = context;
        this.f3767a = LayoutInflater.from(context).inflate(rId, null);
    }

    /* renamed from: g */
    public View m4695g() {
        return this.f3767a;
    }

    /* renamed from: h */
    public void mo1484h() {
    }

    /* renamed from: i */
    public boolean m4697i() {
        return true;
    }

    /* renamed from: j */
    public boolean mo1489j() {
        return true;
    }
}
