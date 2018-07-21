package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
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

public class ColladaGLSurfaceView
  extends GLSurfaceView
{
  private static String TAG = "ColladaGLSurfaceView";
  public Renderer mRenderer;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public ColladaGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public ColladaGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void initView()
  {
    setZOrderOnTop(true);
    try
    {
      if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 24, 0)) {
        setEGLConfigChooser(5, 6, 5, 0, 24, 0);
      }
      for (;;)
      {
        this.mRenderer = new Renderer(new WeakReference(this));
        setRenderer(this.mRenderer);
        setRenderMode(1);
        return;
        if (!EglConfigUtils.isSupportConfig(5, 6, 5, 0, 16, 0)) {
          break;
        }
        setEGLConfigChooser(5, 6, 5, 0, 16, 0);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        LogUtil.e("ColladaGLSurfaceView", "no such eglconfigure");
        continue;
        if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 8, 0)) {
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
      }
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e(TAG, " surfaceChanged===");
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    LogUtil.e(TAG, " surfaceCreated===");
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    LogUtil.e(TAG, " surfaceDestroyed===");
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  private class Renderer
    implements GLSurfaceView.Renderer
  {
    private final WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
    private boolean mInit = false;
    
    public Renderer()
    {
      WeakReference localWeakReference;
      this.mGLSurfaceViewWeakRef = localWeakReference;
    }
    
    public void onDrawFrame(GL10 paramGL10)
    {
      LogUtil.e(ColladaGLSurfaceView.TAG, "onDrawFrame  Renderer");
      JNIBaseMap.ColladaDraw();
      try
      {
        if ((BNDrivingToolUtils.sColladaRenderShow) && (BNDrivingToolUtils.sCanShow)) {
          BNScreentShotManager.getInstance().captureSurfaceView(ColladaGLSurfaceView.this.surfaceWidth, ColladaGLSurfaceView.this.surfaceHeight, 2);
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
      LogUtil.e(ColladaGLSurfaceView.TAG, "surfaceChanged Renderer width: " + paramInt1 + "  height: " + paramInt2);
      if (this.mInit)
      {
        this.mInit = false;
        JNIBaseMap.ColladaInit(0, 0, paramInt1, paramInt2);
      }
      for (;;)
      {
        if (BNDrivingToolUtils.sCanShow)
        {
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          ColladaGLSurfaceView.access$102(ColladaGLSurfaceView.this, paramInt1);
          ColladaGLSurfaceView.access$202(ColladaGLSurfaceView.this, paramInt2);
        }
        return;
        JNIBaseMap.ColladaResize(paramInt1, paramInt2);
      }
    }
    
    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      LogUtil.e(ColladaGLSurfaceView.TAG, "surfaceCreated  Renderer");
      this.mInit = true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/ColladaGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */