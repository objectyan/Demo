package com.baidu.carlife.core.screen.presentation.p071a;

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
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C1282k;
import com.baidu.carlife.core.screen.presentation.C1329i;
import com.baidu.carlife.core.screen.video.C1338e;

/* compiled from: CarlifeMaskView */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.j */
public class C1321j {
    /* renamed from: b */
    private static final String f3801b = "CarlifeActivity#MaskView";
    /* renamed from: f */
    private static C1329i f3802f;
    /* renamed from: g */
    private static Surface f3803g;
    /* renamed from: a */
    SurfaceTextureListener f3804a = new C13201(this);
    /* renamed from: c */
    private View f3805c;
    /* renamed from: d */
    private TextureView f3806d;
    /* renamed from: e */
    private C1282k f3807e;

    /* compiled from: CarlifeMaskView */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.j$1 */
    class C13201 implements SurfaceTextureListener {
        /* renamed from: a */
        final /* synthetic */ C1321j f3800a;

        C13201(C1321j this$0) {
            this.f3800a = this$0;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (C1253f.jp <= 3) {
                C1260i.m4435b(C1321j.f3801b, "onSurfaceTextureUpdated , 外层");
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            C1260i.m4435b(C1321j.f3801b, "onSurfaceTextureSizeChanged surface=" + surface + ", width=" + width + ", height=" + height);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            C1260i.m4435b(C1321j.f3801b, "onSurfaceTextureDestroyed surface=" + surface);
            return false;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            C1260i.m4435b(C1321j.f3801b, "onSurfaceTextureAvailable surface=" + surface + ", width=" + width + ", height=" + height);
            Surface mSurface = new Surface(surface);
            C1249d carlifeScreenUtil = C1249d.m4331a();
            C1321j.f3802f = new C1329i(carlifeScreenUtil.m4351h(), carlifeScreenUtil.m4352i(), carlifeScreenUtil.m4350g(), mSurface, 2);
            if (!C1192c.m4069a().m4094l()) {
                this.f3800a.m4742a();
                C1192c.m4069a().m4089i(true);
            }
        }
    }

    public C1321j(C1282k listener) {
        this.f3807e = listener;
        FrameLayout frameLayout = new FrameLayout(C1157a.m3876a());
        this.f3806d = new TextureView(C1157a.m3876a());
        ImageView imageView = new ImageView(C1157a.m3876a());
        imageView.setImageDrawable(C1299b.m4626b().m4638f());
        LinearLayout linearLayout = new LinearLayout(C1157a.m3876a());
        linearLayout.setBackgroundColor(-16777216);
        imageView.setScaleType(ScaleType.CENTER);
        linearLayout.addView(imageView, new LayoutParams(-1, -1));
        frameLayout.addView(this.f3806d, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        this.f3805c = frameLayout;
        if (C1338e.m4826b().m4879j()) {
            this.f3806d.setSurfaceTextureListener(this.f3804a);
            return;
        }
        this.f3805c.removeView(this.f3806d);
        f3803g = C1338e.m4826b().m4854a();
        f3802f = new C1329i(C1338e.m4828c(), C1338e.m4830d(), C1249d.m4331a().m4350g(), f3803g, 2);
        if (!C1192c.m4069a().m4094l()) {
            m4742a();
            C1192c.m4069a().m4089i(true);
        }
    }

    /* renamed from: a */
    public static void m4741a(Surface encoderSurface) {
        f3803g = encoderSurface;
        f3802f = new C1329i(C1338e.m4828c(), C1338e.m4830d(), C1249d.m4331a().m4350g(), f3803g, 2);
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
