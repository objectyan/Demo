package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.view.SurfaceHolder;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.EglConfigUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.ref.WeakReference;

public class MapSwitchGLSurfaceView
  extends BaiduGLSurfaceView
{
  private static final String TAG = "MapSwitchGLSurfaceView";
  public MapSwitchRendererVer2 mRenderer;
  
  public MapSwitchGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    setRestartGLThreadOnAttach(false);
    LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView: --> create instance");
    setEGLContextClientVersion(2);
    getHolder().setFormat(-2);
    setZOrderMediaOverlay(true);
    try
    {
      if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 0)) {
        setEGLConfigChooser(8, 8, 8, 8, 24, 0);
      }
      for (;;)
      {
        Init();
        return;
        setEGLConfigChooser(true);
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        setEGLConfigChooser(true);
      }
    }
  }
  
  public void Init()
  {
    this.mRenderer = new MapSwitchRendererVer2(new WeakReference(this));
    setRenderer(this.mRenderer);
    setRenderMode(0);
  }
  
  public void onPause()
  {
    LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView --> onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView --> onResume");
    try
    {
      super.onResume();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView --> surfaceChanged");
    if (this.mRenderer != null) {
      this.mRenderer.setGLResizeParams(paramInt2, paramInt3, 0);
    }
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceCreated(paramSurfaceHolder);
    LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView: --> surfaceCreated");
    BNMapController.getInstance().updateLayer(9);
    BNMapController.getInstance().updateLayer(10);
    BNMapController.getInstance().updateLayer(0);
    BNMapController.getInstance().updateLayer(8);
  }
  
  public void unInit()
  {
    releaseGLThread();
    this.mRenderer = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/MapSwitchGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */