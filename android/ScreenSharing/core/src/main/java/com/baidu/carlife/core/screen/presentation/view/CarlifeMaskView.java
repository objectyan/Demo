package com.baidu.carlife.core.screen.presentation.view;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnSurfaceListener;
import com.baidu.carlife.core.screen.presentation.DisplaySpec;
import com.baidu.carlife.core.screen.video.Recorder;

/* compiled from: CarlifeMaskView */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.j */
public class CarlifeMaskView {
    /* renamed from: b */
    private static final String f3801b = "CarlifeActivity#MaskView";
    /* renamed from: f */
    private static DisplaySpec f3802f;
    /* renamed from: g */
    private static Surface f3803g;
    /* renamed from: a */
    SurfaceTextureListener f3804a = new C13201(this);
    /* renamed from: c */
    private View f3805c;
    /* renamed from: d */
    private TextureView f3806d;
    /* renamed from: e */
    private OnSurfaceListener f3807e;

    /* compiled from: CarlifeMaskView */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.j$1 */
    class C13201 implements SurfaceTextureListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeMaskView f3800a;

        C13201(CarlifeMaskView this$0) {
            this.f3800a = this$0;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (CommonParams.jp <= 3) {
                LogUtil.d(CarlifeMaskView.f3801b, "onSurfaceTextureUpdated , 外层");
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            LogUtil.d(CarlifeMaskView.f3801b, "onSurfaceTextureSizeChanged surface=" + surface + ", width=" + width + ", height=" + height);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            LogUtil.d(CarlifeMaskView.f3801b, "onSurfaceTextureDestroyed surface=" + surface);
            return false;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            LogUtil.d(CarlifeMaskView.f3801b, "onSurfaceTextureAvailable surface=" + surface + ", width=" + width + ", height=" + height);
            Surface mSurface = new Surface(surface);
            CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.m4331a();
            CarlifeMaskView.f3802f = new DisplaySpec(carlifeScreenUtil.m4351h(), carlifeScreenUtil.m4352i(), carlifeScreenUtil.m4350g(), mSurface, 2);
            if (!CarLifeSettings.m4069a().m4094l()) {
                this.f3800a.m4742a();
                CarLifeSettings.m4069a().m4089i(true);
            }
        }
    }

    public CarlifeMaskView(OnSurfaceListener listener) {
        this.f3807e = listener;
        FrameLayout frameLayout = new FrameLayout(AppContext.getAppContext());
        this.f3806d = new TextureView(AppContext.getAppContext());
        ImageView imageView = new ImageView(AppContext.getAppContext());
        imageView.setImageDrawable(CarLifePresentationController.m4626b().m4638f());
        LinearLayout linearLayout = new LinearLayout(AppContext.getAppContext());
        linearLayout.setBackgroundColor(-16777216);
        imageView.setScaleType(ScaleType.CENTER);
        linearLayout.addView(imageView, new LayoutParams(-1, -1));
        frameLayout.addView(this.f3806d, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        this.f3805c = frameLayout;
        if (Recorder.m4826b().m4879j()) {
            this.f3806d.setSurfaceTextureListener(this.f3804a);
            return;
        }
        this.f3805c.removeView(this.f3806d);
        f3803g = Recorder.m4826b().m4854a();
        f3802f = new DisplaySpec(Recorder.m4828c(), Recorder.m4830d(), CarlifeScreenUtil.m4331a().m4350g(), f3803g, 2);
        if (!CarLifeSettings.m4069a().m4094l()) {
            m4742a();
            CarLifeSettings.m4069a().m4089i(true);
        }
    }

    /* renamed from: a */
    public static void m4741a(Surface encoderSurface) {
        f3803g = encoderSurface;
        f3802f = new DisplaySpec(Recorder.m4828c(), Recorder.m4830d(), CarlifeScreenUtil.m4331a().m4350g(), f3803g, 2);
    }

    /* renamed from: a */
    public void m4742a() {
        if (f3802f != null) {
            this.f3807e.mo1453a(f3802f);
        }
    }

    /* renamed from: b */
    public View m4743b() {
        return this.f3805c;
    }
}
