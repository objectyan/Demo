package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.platform.comapi.C2907c;

/* compiled from: DpiInfo */
/* renamed from: com.baidu.platform.comapi.util.c.e */
public class C4807e implements C4800g {
    /* renamed from: a */
    public static final int f19920a = 160;
    /* renamed from: b */
    private int f19921b = -1;
    /* renamed from: c */
    private int f19922c = -1;
    /* renamed from: d */
    private float f19923d = -1.0f;
    /* renamed from: e */
    private int f19924e = -1;
    /* renamed from: f */
    private int f19925f = -1;
    /* renamed from: g */
    private int f19926g = -1;
    /* renamed from: h */
    private double f19927h = -1.0d;

    /* renamed from: a */
    public void mo3723a(Context context) {
        DisplayMetrics outMetrics = context.getResources().getDisplayMetrics();
        this.f19921b = outMetrics.widthPixels;
        this.f19922c = outMetrics.heightPixels;
        this.f19923d = outMetrics.density;
        this.f19924e = (int) outMetrics.xdpi;
        this.f19925f = (int) outMetrics.ydpi;
        if (VERSION.SDK_INT > 3) {
            double width = (double) (((float) outMetrics.widthPixels) / outMetrics.xdpi);
            double height = (double) (((float) outMetrics.heightPixels) / outMetrics.ydpi);
            this.f19926g = (int) Math.ceil(Math.sqrt((double) ((outMetrics.heightPixels * outMetrics.heightPixels) + (outMetrics.widthPixels * outMetrics.widthPixels))) / Math.sqrt((width * width) + (height * height)));
            if (this.f19926g < RGHUDDataModel.MAX_CAR_SPEED) {
                this.f19926g = outMetrics.densityDpi;
            }
        } else {
            this.f19926g = 160;
        }
        if (this.f19926g == 0) {
            this.f19926g = 160;
        }
        this.f19927h = ((double) this.f19926g) / 240.0d;
    }

    /* renamed from: a */
    public int m15962a() {
        if (this.f19921b == -1) {
            mo3723a(C2907c.f());
        }
        return this.f19921b;
    }

    /* renamed from: b */
    public int m15964b() {
        if (this.f19922c == -1) {
            mo3723a(C2907c.f());
        }
        return this.f19922c;
    }

    /* renamed from: c */
    public float m15965c() {
        if (this.f19923d == -1.0f) {
            mo3723a(C2907c.f());
        }
        return this.f19923d;
    }

    /* renamed from: d */
    public int m15966d() {
        if (this.f19924e == -1) {
            mo3723a(C2907c.f());
        }
        return this.f19924e;
    }

    /* renamed from: e */
    public int m15967e() {
        if (this.f19925f == -1) {
            mo3723a(C2907c.f());
        }
        return this.f19925f;
    }

    /* renamed from: f */
    public int m15968f() {
        if (this.f19926g == -1) {
            mo3723a(C2907c.f());
        }
        return this.f19926g;
    }

    /* renamed from: g */
    public double m15969g() {
        if (this.f19927h == -1.0d) {
            mo3723a(C2907c.f());
        }
        return this.f19927h;
    }
}
