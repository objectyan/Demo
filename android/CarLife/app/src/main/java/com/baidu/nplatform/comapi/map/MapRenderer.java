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
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MapRenderer
  implements GLSurfaceView.Renderer
{
  public static int h_old;
  public static int resize_tries = 0;
  public static int w_old;
  private int drawCount = 0;
  private final WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
  private OnDrawFrameCallback onDrawFrameCallback = null;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public MapRenderer(WeakReference<GLSurfaceView> paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    this.drawCount += 1;
    if (resize_tries <= 1)
    {
      JNIBaseMap.GLResize(w_old, h_old, 0, 0, 0);
      resize_tries += 1;
    }
    JNIBaseMap.UpdateNeedRender(true);
    int i = JNIBaseMap.GLDraw();
    paramGL10 = (GLSurfaceView)this.mGLSurfaceViewWeakRef.get();
    if (paramGL10 != null)
    {
      if (i != 1) {
        break label121;
      }
      paramGL10.requestRender();
    }
    try
    {
      for (;;)
      {
        if ((BNDrivingToolUtils.sCanShow) && (BNDrivingToolUtils.sMapRenderShow)) {
          BNScreentShotManager.getInstance().captureSurfaceView(this.surfaceWidth, this.surfaceHeight, 1);
        }
        if ((this.onDrawFrameCallback != null) && (this.drawCount == 1)) {
          this.onDrawFrameCallback.onFirstFrameDrawed();
        }
        return;
        label121:
        if (paramGL10.getRenderMode() != 0) {
          paramGL10.setRenderMode(0);
        }
      }
    }
    catch (Exception paramGL10)
    {
      for (;;)
      {
        BNDrivingToolUtils.setSurfaceViewState(false);
        paramGL10.printStackTrace();
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    JNIBaseMap.GLResize(paramInt1, paramInt2, 0, 0, 0);
    paramGL10 = BNMapController.getInstance();
    if ((RouteGuideParams.getRouteGuideMode() != 2) && (!BNNaviResultController.getInstance().isNaviResultShowing()))
    {
      MapStatus localMapStatus = paramGL10.getMapStatus(false);
      if (localMapStatus != null)
      {
        localMapStatus._WinRound.left = 0;
        localMapStatus._WinRound.top = 0;
        localMapStatus._WinRound.bottom = paramInt2;
        localMapStatus._WinRound.right = paramInt1;
        localMapStatus._Level = -1.0F;
        paramGL10.setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
      }
    }
    if (BNDrivingToolUtils.sCanShow)
    {
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    BNMapController.getInstance().ResetImageRes();
    JNIBaseMap.GLInit();
    paramEGLConfig = paramGL10.glGetString(7938);
    paramGL10 = paramGL10.glGetString(7937);
    if ((SysOSAPI.getInstance().getGLVersion() != null) && (SysOSAPI.getInstance().getGLVersion().equals(paramEGLConfig)) && (SysOSAPI.getInstance().getGLRenderer() != null) && (SysOSAPI.getInstance().getGLRenderer().equals(paramGL10))) {
      return;
    }
    SysOSAPI.getInstance().updateGLinfo(paramEGLConfig, paramGL10);
  }
  
  public void resetFirstFrameDrawed()
  {
    this.drawCount = 0;
  }
  
  public void setOnDrawFrameCallback(OnDrawFrameCallback paramOnDrawFrameCallback)
  {
    this.onDrawFrameCallback = paramOnDrawFrameCallback;
  }
  
  public static abstract interface OnDrawFrameCallback
  {
    public abstract void onFirstFrameDrawed();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/MapRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */