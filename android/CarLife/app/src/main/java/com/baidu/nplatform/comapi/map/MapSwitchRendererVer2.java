package com.baidu.nplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MapSwitchRendererVer2 implements Renderer {
    private static final String TAG = MapSwitchRendererVer2.class.getSimpleName();
    public int h_old;
    private final WeakReference<BaiduGLSurfaceView> mGLSurfaceViewWeakRef;
    public int resize_tries = 0;
    private int surfaceHeight;
    private int surfaceWidth;
    public int w_old;

    public MapSwitchRendererVer2(WeakReference<BaiduGLSurfaceView> glViewRef) {
        this.mGLSurfaceViewWeakRef = glViewRef;
    }

    public void setGLResizeParams(int wOld, int hOld, int resizeTries) {
        this.w_old = wOld;
        this.h_old = hOld;
        this.resize_tries = resizeTries;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        LogUtil.m15791e(TAG, "MapSwitchRenderer --> onSurfaceCreated");
        if (!BNavigator.getInstance().isMapSwitchInited()) {
            BNavigator.getInstance().setIsMapSwitchInited(true);
            BNMapController.getInstance().createMiniMapControl();
        }
        BNMapController.getInstance().ResetGLHandleWhenCreateOrDestroyContext(true);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        LogUtil.m15791e(TAG, "MapSwitchGLSurfaceView MapSwitchRenderer --> onSurfaceChanged width = " + width + ", height = " + height);
        JNIBaseMap.MinimapGLResize(width, height, 0, 0, 0);
        BNMapController.getInstance().SetMinimapWinSize(width, height);
        if (BNDrivingToolUtils.sCanShow) {
            GLES20.glViewport(0, 0, width, height);
            this.surfaceWidth = width;
            this.surfaceHeight = height;
        }
    }

    public void onDrawFrame(GL10 gl) {
        JNIBaseMap.UpdateNeedRender(true);
        int ret = JNIBaseMap.GLDrawMinimap();
        try {
            if (BNDrivingToolUtils.sSwitchRenderShow && BNDrivingToolUtils.sCanShow) {
                BNScreentShotManager.getInstance().captureSurfaceView(this.surfaceWidth, this.surfaceHeight, 3);
            }
        } catch (Exception e) {
            BNDrivingToolUtils.setSurfaceViewState(false);
            e.printStackTrace();
        }
    }
}
