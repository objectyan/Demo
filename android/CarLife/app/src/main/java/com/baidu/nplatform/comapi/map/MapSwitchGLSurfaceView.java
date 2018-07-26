package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.view.SurfaceHolder;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.EglConfigUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.ref.WeakReference;

public class MapSwitchGLSurfaceView extends BaiduGLSurfaceView {
    private static final String TAG = "MapSwitchGLSurfaceView";
    public MapSwitchRendererVer2 mRenderer;

    public MapSwitchGLSurfaceView(Context context) {
        super(context);
        setRestartGLThreadOnAttach(false);
        LogUtil.m15791e(TAG, "MapSwitchGLSurfaceView: --> create instance");
        setEGLContextClientVersion(2);
        getHolder().setFormat(-2);
        setZOrderMediaOverlay(true);
        try {
            if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException e) {
            setEGLConfigChooser(true);
        }
        Init();
    }

    public void Init() {
        this.mRenderer = new MapSwitchRendererVer2(new WeakReference(this));
        setRenderer(this.mRenderer);
        setRenderMode(0);
    }

    public void unInit() {
        releaseGLThread();
        this.mRenderer = null;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        super.surfaceCreated(holder);
        LogUtil.m15791e(TAG, "MapSwitchGLSurfaceView: --> surfaceCreated");
        BNMapController.getInstance().updateLayer(9);
        BNMapController.getInstance().updateLayer(10);
        BNMapController.getInstance().updateLayer(0);
        BNMapController.getInstance().updateLayer(8);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        LogUtil.m15791e(TAG, "MapSwitchGLSurfaceView --> surfaceChanged");
        if (this.mRenderer != null) {
            this.mRenderer.setGLResizeParams(w, h, 0);
        }
        super.surfaceChanged(holder, format, w, h);
    }

    public void onResume() {
        LogUtil.m15791e(TAG, "MapSwitchGLSurfaceView --> onResume");
        try {
            super.onResume();
        } catch (Exception e) {
        }
    }

    public void onPause() {
        LogUtil.m15791e(TAG, "MapSwitchGLSurfaceView --> onPause");
        super.onPause();
    }
}
