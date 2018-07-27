package me.objectyan.screensharing.core.screen.presentation;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import me.objectyan.screensharing.core.CarlifeScreenUtil;
import me.objectyan.screensharing.core.CommonParams;

import me.objectyan.screensharing.core.screen.OnSurfaceListener;
import me.objectyan.screensharing.core.screen.video.Recorder;

@TargetApi(17)

public class AbsCarlifeFakePresentation extends Presentation  {

    public static String Tag = "CarlifeFakePresentation";

    protected OnSurfaceListener mOnSurfaceListener;

    protected TextureView mTextureView;

    SurfaceTextureListener mSurfaceTextureListener = new C12941(this);

    private long f3812e = 0;

    private Recorder mRecorder;


    class C12941 implements SurfaceTextureListener {

        final  AbsCarlifeFakePresentation f3728a;

        C12941(AbsCarlifeFakePresentation this$0) {
            this.f3728a = this$0;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (CommonParams.jp <= 3) {
            }
            if (this.f3728a.mRecorder.getIsJPEGMode()) {
                synchronized (this.f3728a.mRecorder.mBitmap) {
                    this.f3728a.mTextureView.getBitmap(this.f3728a.mRecorder.mBitmap);
                }
            }
            long sleepTime = ((long) Recorder.sChangeFrameRate) - (System.currentTimeMillis() - this.f3728a.f3812e);
            this.f3728a.f3812e = System.currentTimeMillis();
            if (sleepTime > 0 && sleepTime < 500) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            Log.d(AbsCarlifeFakePresentation.Tag, "onSurfaceTextureSizeChanged, SurfaceTexture = " + surface.toString());
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            Log.d(AbsCarlifeFakePresentation.Tag, "onSurfaceTextureDestroyed, SurfaceTexture = " + surface.toString());
            return true;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            Log.d(AbsCarlifeFakePresentation.Tag, "onSurfaceTextureAvailable, SurfaceTexture = " + surface.toString());
            Log.d(AbsCarlifeFakePresentation.Tag, "width = " + width + ", height = " + height);
            Surface mSurface = new Surface(surface);
            CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.newInstance();
            this.f3728a.m4748a(new DisplaySpec(carlifeScreenUtil.getWidthPixels(), carlifeScreenUtil.getHeightPixels(), carlifeScreenUtil.getDensityDpi(), mSurface, 2));
        }
    }

    public AbsCarlifeFakePresentation(Context outerContext, Display display, OnSurfaceListener listener) {
        super(outerContext, display);
        this.mOnSurfaceListener = listener;
        m4746a();
        this.mRecorder = Recorder.newInstance();
    }


    private void m4746a() {
        Window window = getWindow();
        window.setType(CommonParams.fW);
        window.addFlags(268435456);
        window.addFlags(16777216);
        window.addFlags(1024);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mTextureView = new TextureView(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mTextureView, new LayoutParams(-1, -1));
        LayoutParams flp = new LayoutParams(-1, -1);
        flp.gravity = 17;
        setContentView(frameLayout, flp);
        if (this.mRecorder.getIsJPEGMode()) {
            this.mTextureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
            return;
        }
        CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.newInstance();
        float scaleX = 0.0f;
        float scaleY = 0.0f;
        if (carlifeScreenUtil.getWidthPixels() != 0) {
            scaleX = (((float) Recorder.getContainerWidth()) * 1.0f) / ((float) carlifeScreenUtil.getWidthPixels());
        }
        if (carlifeScreenUtil.getHeightPixels() != 0) {
            scaleY = (((float) Recorder.getContainerHeight()) * 1.0f) / ((float) carlifeScreenUtil.getHeightPixels());
        }
        this.mTextureView.setScaleX(scaleX);
        this.mTextureView.setScaleY(scaleY);
        ViewGroup parentView = (ViewGroup) this.mTextureView.getParent();
        ViewGroup.LayoutParams lp = parentView.getLayoutParams();
        lp.width = carlifeScreenUtil.getWidthPixels();
        lp.height = carlifeScreenUtil.getHeightPixels();
        parentView.setLayoutParams(lp);
        parentView.invalidate();
        this.mTextureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
    }


    protected void m4748a(DisplaySpec spec) {
        if (this.mOnSurfaceListener != null) {
            this.mOnSurfaceListener.bindServiceForDisplaySpec(spec);
        }
    }
}
