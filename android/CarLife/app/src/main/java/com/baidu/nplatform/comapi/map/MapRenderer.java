package com.baidu.nplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MapRenderer implements Renderer {
    public static int h_old;
    public static int resize_tries = 0;
    public static int w_old;
    private int drawCount = 0;
    private final WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
    private OnDrawFrameCallback onDrawFrameCallback = null;
    private int surfaceHeight;
    private int surfaceWidth;

    public interface OnDrawFrameCallback {
        void onFirstFrameDrawed();
    }

    public MapRenderer(WeakReference<GLSurfaceView> glViewRef) {
        this.mGLSurfaceViewWeakRef = glViewRef;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        BNMapController.getInstance().ResetImageRes();
        JNIBaseMap.GLInit();
        String strVer = gl.glGetString(7938);
        String strRender = gl.glGetString(7937);
        if (SysOSAPI.getInstance().getGLVersion() == null || !SysOSAPI.getInstance().getGLVersion().equals(strVer) || SysOSAPI.getInstance().getGLRenderer() == null || !SysOSAPI.getInstance().getGLRenderer().equals(strRender)) {
            SysOSAPI.getInstance().updateGLinfo(strVer, strRender);
        }
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        JNIBaseMap.GLResize(width, height, 0, 0, 0);
        BNMapController mapController = BNMapController.getInstance();
        if (!(RouteGuideParams.getRouteGuideMode() == 2 || BNNaviResultController.getInstance().isNaviResultShowing())) {
            MapStatus st = mapController.getMapStatus(false);
            if (st != null) {
                st._WinRound.left = 0;
                st._WinRound.top = 0;
                st._WinRound.bottom = height;
                st._WinRound.right = width;
                st._Level = -1.0f;
                mapController.setMapStatus(st, AnimationType.eAnimationNone);
            }
        }
        if (BNDrivingToolUtils.sCanShow) {
            GLES20.glViewport(0, 0, width, height);
            this.surfaceWidth = width;
            this.surfaceHeight = height;
        }
    }

    public void setOnDrawFrameCallback(OnDrawFrameCallback callback) {
        this.onDrawFrameCallback = callback;
    }

    public void resetFirstFrameDrawed() {
        this.drawCount = 0;
    }

    public void onDrawFrame(GL10 gl) {
        this.drawCount++;
        if (resize_tries <= 1) {
            JNIBaseMap.GLResize(w_old, h_old, 0, 0, 0);
            resize_tries++;
        }
        JNIBaseMap.UpdateNeedRender(true);
        int ret = JNIBaseMap.GLDraw();
        GLSurfaceView view = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
        if (view != null) {
            if (ret == 1) {
                view.requestRender();
            } else if (view.getRenderMode() != 0) {
                view.setRenderMode(0);
            }
        }
        try {
            if (BNDrivingToolUtils.sCanShow && BNDrivingToolUtils.sMapRenderShow) {
                BNScreentShotManager.getInstance().captureSurfaceView(this.surfaceWidth, this.surfaceHeight, 1);
            }
        } catch (Exception e) {
            BNDrivingToolUtils.setSurfaceViewState(false);
            e.printStackTrace();
        }
        if (this.onDrawFrameCallback != null && this.drawCount == 1) {
            this.onDrawFrameCallback.onFirstFrameDrawed();
        }
    }
}
