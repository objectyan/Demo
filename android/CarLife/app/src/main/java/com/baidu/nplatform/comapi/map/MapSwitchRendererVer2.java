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

public class MapSwitchRendererVer2
  implements GLSurfaceView.Renderer
{
  private static final String TAG = MapSwitchRendererVer2.class.getSimpleName();
  public int h_old;
  private final WeakReference<BaiduGLSurfaceView> mGLSurfaceViewWeakRef;
  public int resize_tries = 0;
  private int surfaceHeight;
  private int surfaceWidth;
  public int w_old;
  
  public MapSwitchRendererVer2(WeakReference<BaiduGLSurfaceView> paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    JNIBaseMap.UpdateNeedRender(true);
    JNIBaseMap.GLDrawMinimap();
    try
    {
      if ((BNDrivingToolUtils.sSwitchRenderShow) && (BNDrivingToolUtils.sCanShow)) {
        BNScreentShotManager.getInstance().captureSurfaceView(this.surfaceWidth, this.surfaceHeight, 3);
      }
      return;
    }
    catch (Exception paramGL10)
    {
      BNDrivingToolUtils.setSurfaceViewState(false);
      paramGL10.printStackTrace();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    LogUtil.e(TAG, "MapSwitchGLSurfaceView MapSwitchRenderer --> onSurfaceChanged width = " + paramInt1 + ", height = " + paramInt2);
    JNIBaseMap.MinimapGLResize(paramInt1, paramInt2, 0, 0, 0);
    BNMapController.getInstance().SetMinimapWinSize(paramInt1, paramInt2);
    if (BNDrivingToolUtils.sCanShow)
    {
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    LogUtil.e(TAG, "MapSwitchRenderer --> onSurfaceCreated");
    if (!BNavigator.getInstance().isMapSwitchInited())
    {
      BNavigator.getInstance().setIsMapSwitchInited(true);
      BNMapController.getInstance().createMiniMapControl();
    }
    BNMapController.getInstance().ResetGLHandleWhenCreateOrDestroyContext(true);
  }
  
  public void setGLResizeParams(int paramInt1, int paramInt2, int paramInt3)
  {
    this.w_old = paramInt1;
    this.h_old = paramInt2;
    this.resize_tries = paramInt3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/MapSwitchRendererVer2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */