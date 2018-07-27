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
    private static final String Tag = "CarlifeActivity#MaskView";
    /* renamed from: f */
    private static DisplaySpec sDisplaySpec;
    /* renamed from: g */
    private static Surface sSurface;
    /* renamed from: a */
    SurfaceTextureListener mMaskViewSurfaceTextureListener = new MaskViewSurfaceTextureListener(this);
    /* renamed from: c */
    private FrameLayout mView;
    /* renamed from: d */
    private TextureView mTextureView;
    /* renamed from: e */
    private OnSurfaceListener mOnSurfaceListener;

    /* compiled from: CarlifeMaskView */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.j$1 */
    class MaskViewSurfaceTextureListener implements SurfaceTextureListener {
        /* renamed from: a */
        final /* synthetic */ CarlifeMaskView mCarlifeMaskView;

        MaskViewSurfaceTextureListener(CarlifeMaskView this$0) {
            this.mCarlifeMaskView = this$0;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (CommonParams.jp <= 3) {
                LogUtil.d(CarlifeMaskView.Tag, "onSurfaceTextureUpdated , 外层");
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            LogUtil.d(CarlifeMaskView.Tag, "onSurfaceTextureSizeChanged surface=" + surface + ", width=" + width + ", height=" + height);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            LogUtil.d(CarlifeMaskView.Tag, "onSurfaceTextureDestroyed surface=" + surface);
            return false;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            LogUtil.d(CarlifeMaskView.Tag, "onSurfaceTextureAvailable surface=" + surface + ", width=" + width + ", height=" + height);
            Surface mSurface = new Surface(surface);
            CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.m4331a();
            CarlifeMaskView.sDisplaySpec = new DisplaySpec(carlifeScreenUtil.m4351h(), carlifeScreenUtil.m4352i(), carlifeScreenUtil.m4350g(), mSurface, 2);
            if (!CarLifeSettings.m4069a().m4094l()) {
                this.mCarlifeMaskView.bindServiceForDisplaySpec();
                CarLifeSettings.m4069a().m4089i(true);
            }
        }
    }

    public CarlifeMaskView(OnSurfaceListener listener) {
        this.mOnSurfaceListener = listener;
        FrameLayout frameLayout = new FrameLayout(AppContext.getAppContext());
        this.mTextureView = new TextureView(AppContext.getAppContext());
        ImageView imageView = new ImageView(AppContext.getAppContext());
        imageView.setImageDrawable(CarLifePresentationController.newInstance().getMaskDrawable());
        LinearLayout linearLayout = new LinearLayout(AppContext.getAppContext());
        linearLayout.setBackgroundColor(-16777216);
        imageView.setScaleType(ScaleType.CENTER);
        linearLayout.addView(imageView, new LayoutParams(-1, -1));
        frameLayout.addView(this.mTextureView, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        this.mView = frameLayout;
        if (Recorder.newInstance().m4879j()) {
            this.mTextureView.setSurfaceTextureListener(this.mMaskViewSurfaceTextureListener);
            return;
        }
        this.mView.removeView(this.mTextureView);
        sSurface = Recorder.newInstance().m4854a();
        sDisplaySpec = new DisplaySpec(Recorder.m4828c(), Recorder.m4830d(), CarlifeScreenUtil.m4331a().m4350g(), sSurface, 2);
        if (!CarLifeSettings.m4069a().m4094l()) {
            bindServiceForDisplaySpec();
            CarLifeSettings.m4069a().m4089i(true);
        }
    }

    /* renamed from: a */
    public static void setDisplaySpec(Surface encoderSurface) {
        sSurface = encoderSurface;
        sDisplaySpec = new DisplaySpec(Recorder.m4828c(), Recorder.m4830d(), CarlifeScreenUtil.m4331a().m4350g(), sSurface, 2);
    }

    /* renamed from: a */
    public void bindServiceForDisplaySpec() {
        if (sDisplaySpec != null) {
            this.mOnSurfaceListener.bindServiceForDisplaySpec(sDisplaySpec);
        }
    }

    /* renamed from: b */
    public View getFrameLayout() {
        return this.mView;
    }
}
