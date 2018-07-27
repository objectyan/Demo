package com.baidu.carlife.p087l;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.screen.OnStatusChangeListener;
import com.baidu.carlife.core.screen.presentation.CarlifeServiceConnection;
import com.baidu.carlife.core.screen.presentation.view.CarLifePresentationController;
import com.baidu.carlife.core.screen.video.Recorder;

/* compiled from: CarlifeCoreVideo */
/* renamed from: com.baidu.carlife.l.d */
public class CarlifeCoreVideo {
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
    private static com.baidu.carlife.p087l.CarlifeCoreVideo f5154g;
    /* renamed from: f */
    private Recorder f5155f;

    private CarlifeCoreVideo() {
        this.f5155f = null;
        this.f5155f = Recorder.newInstance();
    }

    /* renamed from: a */
    public static com.baidu.carlife.p087l.CarlifeCoreVideo m6102a() {
        if (f5154g == null) {
            f5154g = new com.baidu.carlife.p087l.CarlifeCoreVideo();
        }
        return f5154g;
    }

    /* renamed from: b */
    public int m6106b() {
        Recorder recorder = this.f5155f;
        return Recorder.m4828c();
    }

    /* renamed from: c */
    public int m6108c() {
        Recorder recorder = this.f5155f;
        return Recorder.m4830d();
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
        CarLifePresentationController.newInstance().clearAll();
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
    public CarlifeServiceConnection m6121n() {
        return CarLifePresentationController.newInstance().getServiceConn();
    }

    /* renamed from: a */
    public void m6104a(Activity activity, Class CarlifeActivityServiceClass, OnStatusChangeListener listener, Drawable maskDrawable, int launchIconId) {
        CarLifePresentationController.newInstance().m4630a(activity, CarlifeActivityServiceClass, listener);
        CarLifePresentationController.newInstance().setMaskDrawable(maskDrawable);
        CarLifePresentationController.newInstance().setLaunchIconId(launchIconId);
        CarlifeScreenUtil.m4331a().m4337a(activity);
    }
}
