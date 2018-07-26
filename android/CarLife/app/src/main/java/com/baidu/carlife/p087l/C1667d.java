package com.baidu.carlife.p087l;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.screen.C0940j;
import com.baidu.carlife.core.screen.presentation.C1326f;
import com.baidu.carlife.core.screen.presentation.p071a.C1299b;
import com.baidu.carlife.core.screen.video.C1338e;

/* compiled from: CarlifeCoreVideo */
/* renamed from: com.baidu.carlife.l.d */
public class C1667d {
    /* renamed from: a */
    public static final int f5149a = 1;
    /* renamed from: b */
    public static final int f5150b = 2;
    /* renamed from: c */
    public static final int f5151c = 3;
    /* renamed from: d */
    public static final int f5152d = 4353;
    /* renamed from: e */
    private static final String f5153e = "CarlifeCoreVideo";
    /* renamed from: g */
    private static C1667d f5154g;
    /* renamed from: f */
    private C1338e f5155f;

    private C1667d() {
        this.f5155f = null;
        this.f5155f = C1338e.m4826b();
    }

    /* renamed from: a */
    public static C1667d m6102a() {
        if (f5154g == null) {
            f5154g = new C1667d();
        }
        return f5154g;
    }

    /* renamed from: b */
    public int m6106b() {
        C1338e c1338e = this.f5155f;
        return C1338e.m4828c();
    }

    /* renamed from: c */
    public int m6108c() {
        C1338e c1338e = this.f5155f;
        return C1338e.m4830d();
    }

    /* renamed from: d */
    public Bitmap m6110d() {
        return this.f5155f.f3905f;
    }

    /* renamed from: e */
    public boolean m6112e() {
        return this.f5155f.m4870e();
    }

    /* renamed from: a */
    public void m6105a(boolean needCheckIDRCnt) {
        this.f5155f.m4859a(needCheckIDRCnt);
    }

    /* renamed from: f */
    public void m6113f() {
        this.f5155f.m4875h();
    }

    /* renamed from: g */
    public void m6114g() {
        this.f5155f.m4877i();
    }

    /* renamed from: h */
    public boolean m6115h() {
        return this.f5155f.m4879j();
    }

    /* renamed from: b */
    public void m6107b(boolean isJPEGMode) {
        this.f5155f.m4864b(isJPEGMode);
    }

    /* renamed from: c */
    public void m6109c(boolean isStart) {
        this.f5155f.m4866c(isStart);
    }

    /* renamed from: i */
    public boolean m6116i() {
        return this.f5155f.m4880k();
    }

    /* renamed from: j */
    public boolean m6117j() {
        return this.f5155f.m4881l();
    }

    /* renamed from: d */
    public void m6111d(boolean isNeedChangeColor) {
        this.f5155f.m4868d(isNeedChangeColor);
    }

    /* renamed from: k */
    public void m6118k() {
        this.f5155f.m4882m();
    }

    /* renamed from: l */
    public void m6119l() {
        this.f5155f.m4885p();
        C1299b.m4626b().m4635c();
    }

    /* renamed from: a */
    public void m6103a(int requestCode, int resultCode, Intent data) {
        this.f5155f.m4856a(requestCode, resultCode, data);
    }

    /* renamed from: m */
    public boolean m6120m() {
        return this.f5155f.m4883n();
    }

    /* renamed from: n */
    public C1326f m6121n() {
        return C1299b.m4626b().m4640h();
    }

    /* renamed from: a */
    public void m6104a(Activity activity, Class CarlifeActivityServiceClass, C0940j listener, Drawable maskDrawable, int launchIconId) {
        C1299b.m4626b().m4630a(activity, CarlifeActivityServiceClass, listener);
        C1299b.m4626b().m4633a(maskDrawable);
        C1299b.m4626b().m4628a(launchIconId);
        C1249d.m4331a().m4337a(activity);
    }
}
