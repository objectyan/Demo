package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.util.common.EglConfigUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ColladaGLSurfaceView extends GLSurfaceView {
    private static String TAG = "ColladaGLSurfaceView";
    public Renderer mRenderer;
    private int surfaceHeight;
    private int surfaceWidth;

    private class Renderer implements android.opengl.GLSurfaceView.Renderer {
        private final WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean mInit = false;

        public Renderer(WeakReference<GLSurfaceView> glViewRef) {
            this.mGLSurfaceViewWeakRef = glViewRef;
        }

        public void onDrawFrame(GL10 gl) {
            LogUtil.m15791e(ColladaGLSurfaceView.TAG, "onDrawFrame  Renderer");
            JNIBaseMap.ColladaDraw();
            try {
                if (BNDrivingToolUtils.sColladaRenderShow && BNDrivingToolUtils.sCanShow) {
                    BNScreentShotManager.getInstance().captureSurfaceView(ColladaGLSurfaceView.this.surfaceWidth, ColladaGLSurfaceView.this.surfaceHeight, 2);
                }
            } catch (Exception e) {
                BNDrivingToolUtils.setSurfaceViewState(false);
                e.printStackTrace();
            }
        }

        public void onSurfaceChanged(GL10 gl, int width, int height) {
            LogUtil.m15791e(ColladaGLSurfaceView.TAG, "surfaceChanged Renderer width: " + width + "  height: " + height);
            if (this.mInit) {
                this.mInit = false;
                JNIBaseMap.ColladaInit(0, 0, width, height);
            } else {
                JNIBaseMap.ColladaResize(width, height);
            }
            if (BNDrivingToolUtils.sCanShow) {
                GLES20.glViewport(0, 0, width, height);
                ColladaGLSurfaceView.this.surfaceWidth = width;
                ColladaGLSurfaceView.this.surfaceHeight = height;
            }
        }

        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            LogUtil.m15791e(ColladaGLSurfaceView.TAG, "surfaceCreated  Renderer");
            this.mInit = true;
        }
    }

    public ColladaGLSurfaceView(Context context) {
        super(context);
        initView();
    }

    public ColladaGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setZOrderOnTop(true);
        try {
            if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 24, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 24, 0);
            } else if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 16, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 16, 0);
            } else if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 8, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 8, 0);
            } else if (EglConfigUtils.isSupportConfig(8, 8, 8, 0, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 0, 24, 0);
            } else if (EglConfigUtils.isSupportConfig(8, 8, 8, 0, 16, 0)) {
                setEGLConfigChooser(8, 8, 8, 0, 16, 0);
            } else if (EglConfigUtils.isSupportConfig(8, 8, 8, 0, 8, 0)) {
                setEGLConfigChooser(8, 8, 8, 0, 8, 0);
            } else if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 0, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 0, 0);
            } else {
                setEGLConfigChooser(8, 8, 8, 0, 0, 0);
            }
        } catch (IllegalArgumentException e) {
            LogUtil.m15791e("ColladaGLSurfaceView", "no such eglconfigure");
        }
        this.mRenderer = new Renderer(new WeakReference(this));
        setRenderer(this.mRenderer);
        setRenderMode(1);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        LogUtil.m15791e(TAG, " surfaceCreated===");
        super.surfaceCreated(holder);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        LogUtil.m15791e(TAG, " surfaceChanged===");
        super.surfaceChanged(holder, format, w, h);
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        LogUtil.m15791e(TAG, " surfaceDestroyed===");
        super.surfaceDestroyed(holder);
    }
}
