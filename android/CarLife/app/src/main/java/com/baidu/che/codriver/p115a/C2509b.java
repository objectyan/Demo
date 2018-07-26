package com.baidu.che.codriver.p115a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScreenAdapter */
/* renamed from: com.baidu.che.codriver.a.b */
public class C2509b {
    /* renamed from: a */
    private static final float f8172a = 160.0f;
    /* renamed from: b */
    private List<C2508b> f8173b;

    /* compiled from: ScreenAdapter */
    /* renamed from: com.baidu.che.codriver.a.b$a */
    private static final class C2507a {
        /* renamed from: a */
        private static final C2509b f8161a = new C2509b();

        private C2507a() {
        }
    }

    /* compiled from: ScreenAdapter */
    /* renamed from: com.baidu.che.codriver.a.b$b */
    enum C2508b {
        W_854_H_480(854, BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT, RGHUDDataModel.MAX_CAR_SPEED, 1.0f),
        W_1280_H_720(1280, C1253f.eK, NaviFragmentManager.TYPE_VOICE_MAIN, 1.0f),
        W_1280_H_480(1280, BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT, RGHUDDataModel.MAX_CAR_SPEED, 1.0f),
        W_1198_H_480(1198, BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT, RGHUDDataModel.MAX_CAR_SPEED, 1.0f),
        W_1024_H_600(1024, 600, RGHUDDataModel.MAX_CAR_SPEED, 1.0f);
        
        /* renamed from: f */
        int f8168f;
        /* renamed from: g */
        int f8169g;
        /* renamed from: h */
        int f8170h;
        /* renamed from: i */
        float f8171i;

        /* renamed from: a */
        boolean m9520a(int width, int height) {
            return this.f8168f == width && this.f8169g == height;
        }

        private C2508b(int width, int height, int density, float fontScale) {
            this.f8168f = width;
            this.f8169g = height;
            this.f8170h = density;
            this.f8171i = fontScale;
        }
    }

    private C2509b() {
        this.f8173b = new ArrayList();
        this.f8173b.add(C2508b.W_854_H_480);
        this.f8173b.add(C2508b.W_1280_H_720);
        this.f8173b.add(C2508b.W_1280_H_480);
        this.f8173b.add(C2508b.W_1198_H_480);
        this.f8173b.add(C2508b.W_1024_H_600);
    }

    /* renamed from: a */
    public static C2509b m9521a() {
        return C2507a.f8161a;
    }

    /* renamed from: a */
    public boolean m9524a(Context context) {
        return (((float) context.getResources().getDisplayMetrics().widthPixels) * 1.0f) / ((float) context.getResources().getDisplayMetrics().heightPixels) > 1.7777778f;
    }

    /* renamed from: a */
    public void m9523a(final Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(3842);
        decorView.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(this) {
            /* renamed from: b */
            final /* synthetic */ C2509b f8160b;

            public void onSystemUiVisibilityChange(int arg0) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3842);
            }
        });
    }

    /* renamed from: b */
    public void m9525b(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        int densityDpi = displayMetrics.densityDpi;
        float density = displayMetrics.density;
        float scaledDensity = displayMetrics.scaledDensity;
        C2725h.m10210c("ScreenAdapter", "resolution=" + screenWidth + "*" + screenHeight + ",densityDpi=" + densityDpi + ",density=" + density + ",scaledDensity=" + scaledDensity + ",fontScale=" + configuration.fontScale);
        for (C2508b screen : this.f8173b) {
            if (screen.m9520a(screenWidth, screenHeight)) {
                if (densityDpi != screen.f8170h) {
                    m9522a(resources, screen.f8170h, screen.f8171i);
                    return;
                } else {
                    C2725h.m10210c("ScreenAdapter", "the screen params is standard");
                    return;
                }
            }
        }
        C2725h.m10214e("ScreenAdapter", "screen adapt failed, resolution=" + screenWidth + "*" + screenHeight);
    }

    /* renamed from: a */
    private void m9522a(Resources resources, int densityDpi, float fontScale) {
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float density = ((float) densityDpi) / f8172a;
        configuration.densityDpi = densityDpi;
        configuration.fontScale = fontScale;
        displayMetrics.densityDpi = densityDpi;
        displayMetrics.density = density;
        displayMetrics.scaledDensity = density;
        resources.updateConfiguration(configuration, displayMetrics);
        C2725h.m10210c("ScreenAdapter", "[new] densityDpi=" + densityDpi + ",density=scaledDensity=" + density + ",fontScale=" + fontScale);
    }
}
