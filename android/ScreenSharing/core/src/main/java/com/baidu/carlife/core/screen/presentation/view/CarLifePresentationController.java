package com.baidu.carlife.core.screen.presentation.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnStatusChangeListener;
import com.baidu.carlife.core.screen.OnSurfaceListener;
import com.baidu.carlife.core.screen.OnServiceDiedListener;
import com.baidu.carlife.core.screen.operation.CarlifeTouchManager;
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService;
import com.baidu.carlife.core.screen.presentation.CarlifeServiceConnection;
import com.baidu.carlife.core.screen.presentation.DisplaySpec;
import com.baidu.carlife.core.screen.video.Recorder;

/* compiled from: CarLifePresentationController */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.b */
public class CarLifePresentationController implements OnStatusChangeListener, OnSurfaceListener, OnServiceDiedListener {
    /* renamed from: a */
    public static final String f3737a = CarLifePresentationController.class.getSimpleName();
    /* renamed from: b */
    private static CarLifePresentationController f3738b;
    /* renamed from: c */
    private CarlifeMaskView f3739c;
    /* renamed from: d */
    private View f3740d;
    /* renamed from: e */
    private Drawable f3741e;
    /* renamed from: f */
    private int f3742f;
    /* renamed from: g */
    private Activity f3743g;
    /* renamed from: h */
    private CarlifeServiceConnection f3744h;
    /* renamed from: i */
    private Class f3745i = AbsCarlifeActivityService.class;
    /* renamed from: j */
    private OnStatusChangeListener f3746j;

    private CarLifePresentationController() {
    }

    /* renamed from: b */
    public static CarLifePresentationController m4626b() {
        if (f3738b == null) {
            f3738b = new CarLifePresentationController();
        }
        return f3738b;
    }

    /* renamed from: a */
    public void m4630a(Activity activity, Class serviceClass, OnStatusChangeListener listener) {
        this.f3743g = activity;
        this.f3746j = listener;
        if (serviceClass != null) {
            this.f3745i = serviceClass;
        } else {
            this.f3745i = AbsCarlifeActivityService.class;
        }
        Recorder.m4826b().m4857a((OnStatusChangeListener) this);
    }

    /* renamed from: c */
    public void m4635c() {
        this.f3739c = null;
        this.f3740d = null;
        this.f3743g = null;
        this.f3744h = null;
        this.f3746j = null;
        this.f3741e = null;
    }

    /* renamed from: d */
    public CarlifeMaskView m4636d() {
        return this.f3739c;
    }

    /* renamed from: e */
    public View m4637e() {
        return this.f3740d;
    }

    /* renamed from: f */
    public Drawable m4638f() {
        return this.f3741e;
    }

    /* renamed from: a */
    public void m4633a(Drawable maskDrawable) {
        this.f3741e = maskDrawable;
    }

    /* renamed from: a */
    public void m4628a(int launchIconId) {
        this.f3742f = launchIconId;
    }

    /* renamed from: g */
    public int m4639g() {
        return this.f3742f;
    }

    /* renamed from: h */
    public CarlifeServiceConnection m4640h() {
        return this.f3744h;
    }

    /* renamed from: a */
    public void m4631a(Activity activity, boolean isConnect) {
        LogUtil.d(f3737a, "switchCarLifeViewAndMaskView isConnect=" + isConnect);
        if (activity != null) {
            if (!isConnect && this.f3740d != null) {
                if (this.f3740d.getParent() != null) {
                    ((ViewGroup) this.f3740d.getParent()).removeView(this.f3740d);
                    ((ViewGroup) activity.getWindow().getDecorView()).removeAllViews();
                }
                ((ViewGroup) activity.getWindow().getDecorView()).addView(this.f3740d);
                if (this.f3739c != null && this.f3739c.m4743b() != null && this.f3739c.m4743b().getParent() != null) {
                    ((ViewGroup) this.f3739c.m4743b().getParent()).removeView(this.f3739c.m4743b());
                }
            } else if (isConnect) {
                this.f3740d = ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0);
                if (this.f3740d == null) {
                    LogUtil.m4445e(f3737a, "getDecorView.getChildAt(0) is null");
                    return;
                }
                if (this.f3739c == null) {
                    this.f3739c = new CarlifeMaskView(this);
                } else {
                    this.f3739c.m4742a();
                }
                ViewParent parent = this.f3740d.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.f3740d);
                    ((ViewGroup) parent).removeAllViews();
                    ((ViewGroup) parent).invalidate();
                }
                ViewParent maskViewParent = this.f3739c.m4743b().getParent();
                if (maskViewParent != null && (maskViewParent instanceof ViewGroup)) {
                    ((ViewGroup) maskViewParent).removeView(this.f3739c.m4743b());
                }
                FrameLayout frameLayout = new FrameLayout(activity);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                frameLayout.addView(this.f3740d, layoutParams);
                frameLayout.addView(this.f3739c.m4743b(), layoutParams);
                ((ViewGroup) parent).addView(frameLayout);
                ((ViewGroup) parent).invalidate();
                frameLayout.invalidate();
            }
        }
    }

    /* renamed from: a */
    private void m4625a(Context activityContext, DisplaySpec spec) {
        Intent intent = new Intent(activityContext, this.f3745i);
        activityContext.startService(intent);
        this.f3744h = new CarlifeServiceConnection(this.f3743g, this, spec, this.f3745i);
        activityContext.bindService(intent, this.f3744h, 64);
    }

    /* renamed from: a */
    public void mo1453a(DisplaySpec spec) {
        if (this.f3743g != null) {
            m4625a(this.f3743g, spec);
        }
    }

    /* renamed from: o */
    public void mo1348o() {
        LogUtil.d(f3737a, "onVehicleConnected");
        m4631a(this.f3743g, true);
        if (this.f3746j != null) {
            this.f3746j.mo1348o();
        }
    }

    /* renamed from: p */
    public void mo1355p() {
        LogUtil.d(f3737a, "onVehicleDisconnect");
        if (this.f3744h != null) {
            this.f3744h.m4755b();
            this.f3744h.m4754a();
        }
        m4631a(this.f3743g, false);
        if (this.f3746j != null) {
            this.f3746j.mo1355p();
        }
    }

    /* renamed from: a */
    public void mo1347a(Intent intent, int requestCode) {
        if (this.f3746j != null) {
            this.f3746j.mo1347a(intent, requestCode);
        } else if (this.f3743g != null) {
            this.f3743g.startActivityForResult(intent, requestCode);
        }
    }

    /* renamed from: q */
    public boolean mo1356q() {
        if (this.f3746j != null) {
            return this.f3746j.mo1356q();
        }
        return false;
    }

    /* renamed from: a */
    public void mo1346a(int width, int height) {
        CarlifeTouchManager.m4515a().m4534a(width);
        CarlifeTouchManager.m4515a().m4542b(height);
        if (this.f3746j != null) {
            this.f3746j.mo1346a(width, height);
        }
    }

    /* renamed from: a */
    public void mo1463a() {
        if (this.f3739c != null) {
            this.f3739c.m4742a();
        }
    }
}
