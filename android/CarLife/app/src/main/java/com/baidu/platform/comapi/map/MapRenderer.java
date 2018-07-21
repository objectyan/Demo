package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLException;
import android.opengl.GLSurfaceView.Renderer;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comapi.util.n;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MapRenderer
  implements GLSurfaceView.Renderer
{
  private static final boolean DEBUG = false;
  private static final float DEFBG_A = 1.0F;
  private static final float DEFBG_B = 0.94F;
  private static final float DEFBG_G = 0.95F;
  private static final float DEFBG_R = 0.96F;
  private static final String TAG = "MapView GL Renderer";
  public static boolean isReinit = false;
  public int h_old;
  private int mBaseMapPtr = 0;
  private int mCaptureHeight;
  private CaptureMapViewListener mCaptureMapViewListener;
  private int mCaptureWidth;
  private WeakReference<BaiduGLSurfaceView> mGLSurfaceViewWeakRef;
  private volatile boolean mIsCatureMap = false;
  private boolean mIsMapResOk = false;
  private ResourceRecycler mResourceRecycler;
  private WeakReference<GLTextureView> mTextureViewWeakRef;
  public int resize_tries = 0;
  public int w_old;
  
  public MapRenderer(GLTextureView paramGLTextureView, ResourceRecycler paramResourceRecycler)
  {
    this.mTextureViewWeakRef = new WeakReference(paramGLTextureView);
    this.mResourceRecycler = paramResourceRecycler;
  }
  
  public MapRenderer(WeakReference<BaiduGLSurfaceView> paramWeakReference, ResourceRecycler paramResourceRecycler)
  {
    this.mResourceRecycler = paramResourceRecycler;
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  private boolean checkBaseMap()
  {
    return (this.mBaseMapPtr != 0) && (this.mIsMapResOk);
  }
  
  private Bitmap createBitmapFromGLSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, GL10 paramGL10)
  {
    int[] arrayOfInt1 = new int[paramInt3 * paramInt4];
    int[] arrayOfInt2 = new int[paramInt3 * paramInt4];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    for (;;)
    {
      try
      {
        paramGL10.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
        paramInt1 = 0;
      }
      catch (GLException paramGL10)
      {
        int i;
        return null;
      }
      if (paramInt2 < paramInt3)
      {
        i = arrayOfInt1[(paramInt1 * paramInt3 + paramInt2)];
        arrayOfInt2[((paramInt4 - paramInt1 - 1) * paramInt3 + paramInt2)] = (0xFF00FF00 & i | i << 16 & 0xFF0000 | i >> 16 & 0xFF);
        paramInt2 += 1;
      }
      else
      {
        paramInt1 += 1;
        while (paramInt1 >= paramInt4) {
          return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
        }
        paramInt2 = 0;
      }
    }
  }
  
  private void drawEmptyBackground(GL10 paramGL10)
  {
    paramGL10.glClear(16640);
    paramGL10.glClearColor(0.96F, 0.95F, 0.94F, 1.0F);
  }
  
  private static native void nativeDone(long paramLong);
  
  private static native void nativeInit(long paramLong);
  
  private static native int nativeRender(long paramLong);
  
  private static native void nativeResize(long paramLong, int paramInt1, int paramInt2);
  
  public void doCaptureMapView(CaptureMapViewListener paramCaptureMapViewListener, int paramInt1, int paramInt2)
  {
    this.mIsCatureMap = true;
    this.mCaptureMapViewListener = paramCaptureMapViewListener;
    this.mCaptureWidth = paramInt1;
    this.mCaptureHeight = paramInt2;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (!checkBaseMap()) {
      drawEmptyBackground(paramGL10);
    }
    label73:
    label150:
    label165:
    label178:
    for (;;)
    {
      return;
      if (isReinit)
      {
        nativeRender(this.mBaseMapPtr);
        isReinit = false;
        return;
      }
      int i = nativeRender(this.mBaseMapPtr);
      Object localObject;
      if (this.mGLSurfaceViewWeakRef != null)
      {
        localObject = (BaiduGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
        if (localObject != null)
        {
          if (i != 1) {
            break label150;
          }
          ((BaiduGLSurfaceView)localObject).requestRender();
        }
      }
      if (this.mTextureViewWeakRef != null)
      {
        localObject = (GLTextureView)this.mTextureViewWeakRef.get();
        if (localObject != null)
        {
          if (i != 1) {
            break label165;
          }
          ((GLTextureView)localObject).requestRender();
        }
      }
      for (;;)
      {
        if (!this.mIsCatureMap) {
          break label178;
        }
        this.mIsCatureMap = false;
        if (this.mCaptureMapViewListener == null) {
          break;
        }
        n.a(new Runnable()
        {
          public void run()
          {
            MapRenderer.this.mCaptureMapViewListener.onCompleted(this.val$bmp);
          }
        });
        return;
        if (((BaiduGLSurfaceView)localObject).getRenderMode() == 0) {
          break label73;
        }
        ((BaiduGLSurfaceView)localObject).setRenderMode(0);
        break label73;
        if (((GLTextureView)localObject).getRenderMode() != 0) {
          ((GLTextureView)localObject).setRenderMode(0);
        }
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.mBaseMapPtr != 0) {
      nativeResize(this.mBaseMapPtr, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (!checkBaseMap()) {
      return;
    }
    nativeInit(this.mBaseMapPtr);
    this.mResourceRecycler.onRecycle();
    paramEGLConfig = paramGL10.glGetString(7938);
    paramGL10 = paramGL10.glGetString(7937);
    SysOSAPIv2.getInstance().setGLInfo(paramGL10, paramEGLConfig);
  }
  
  public void setBaseMapId(int paramInt)
  {
    this.mBaseMapPtr = paramInt;
  }
  
  public void setMapResInitOk(boolean paramBoolean)
  {
    this.mIsMapResOk = paramBoolean;
  }
  
  public static abstract interface CaptureMapViewListener
  {
    public abstract void onCompleted(Bitmap paramBitmap);
  }
  
  public static abstract interface ResourceRecycler
  {
    public abstract void onRecycle();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/MapRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */