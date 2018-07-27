package me.objectyan.screensharing.core.screen.presentation.view;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import me.objectyan.screensharing.core.AppContext;
import me.objectyan.screensharing.core.CarLifeSettings;
import me.objectyan.screensharing.core.CarlifeScreenUtil;
import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.screen.OnSurfaceListener;
import me.objectyan.screensharing.core.screen.presentation.DisplaySpec;
import me.objectyan.screensharing.core.screen.video.Recorder;


public class CarlifeMaskView {

    private static final String Tag = "CarlifeActivity#MaskView";

    private static DisplaySpec sDisplaySpec;

    private static Surface sSurface;

    SurfaceTextureListener mMaskViewSurfaceTextureListener = new MaskViewSurfaceTextureListener(this);

    private FrameLayout mView;

    private TextureView mTextureView;

    private OnSurfaceListener mOnSurfaceListener;


    class MaskViewSurfaceTextureListener implements SurfaceTextureListener {

        final  CarlifeMaskView mCarlifeMaskView;

        MaskViewSurfaceTextureListener(CarlifeMaskView this$0) {
            this.mCarlifeMaskView = this$0;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (CommonParams.jp <= 3) {
                Log.d(CarlifeMaskView.Tag, "onSurfaceTextureUpdated , 外层");
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            Log.d(CarlifeMaskView.Tag, "onSurfaceTextureSizeChanged surface=" + surface + ", width=" + width + ", height=" + height);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            Log.d(CarlifeMaskView.Tag, "onSurfaceTextureDestroyed surface=" + surface);
            return false;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            Log.d(CarlifeMaskView.Tag, "onSurfaceTextureAvailable surface=" + surface + ", width=" + width + ", height=" + height);
            Surface mSurface = new Surface(surface);
            CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.newInstance();
            CarlifeMaskView.sDisplaySpec = new DisplaySpec(carlifeScreenUtil.getWidthPixels(), carlifeScreenUtil.getHeightPixels(), carlifeScreenUtil.getDensityDpi(), mSurface, 2);
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
        if (Recorder.newInstance().getIsJPEGMode()) {
            this.mTextureView.setSurfaceTextureListener(this.mMaskViewSurfaceTextureListener);
            return;
        }
        this.mView.removeView(this.mTextureView);
        sSurface = Recorder.newInstance().getInputSurface();
        sDisplaySpec = new DisplaySpec(Recorder.getContainerWidth(), Recorder.getContainerHeight(), CarlifeScreenUtil.newInstance().getDensityDpi(), sSurface, 2);
        if (!CarLifeSettings.m4069a().m4094l()) {
            bindServiceForDisplaySpec();
            CarLifeSettings.m4069a().m4089i(true);
        }
    }


    public static void setDisplaySpec(Surface encoderSurface) {
        sSurface = encoderSurface;
        sDisplaySpec = new DisplaySpec(Recorder.getContainerWidth(), Recorder.getContainerHeight(), CarlifeScreenUtil.newInstance().getDensityDpi(), sSurface, 2);
    }


    public void bindServiceForDisplaySpec() {
        if (sDisplaySpec != null) {
            this.mOnSurfaceListener.bindServiceForDisplaySpec(sDisplaySpec);
        }
    }


    public View getFrameLayout() {
        return this.mView;
    }
}
