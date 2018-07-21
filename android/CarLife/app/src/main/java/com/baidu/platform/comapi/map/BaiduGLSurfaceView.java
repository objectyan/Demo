package com.baidu.platform.comapi.map;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.opengl.GLSurfaceView.GLWrapper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.baidu.platform.comapi.util.f;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class BaiduGLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  private static final boolean LOG_ATTACH_DETACH = false;
  private static final boolean LOG_EGL = false;
  private static final boolean LOG_PAUSE_RESUME = false;
  private static final boolean LOG_RENDERER = false;
  private static final boolean LOG_RENDERER_DRAW_FRAME = false;
  private static final boolean LOG_SURFACE = false;
  private static final boolean LOG_THREADS = false;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "GLSurfaceView";
  private static final GLThreadManager sGLThreadManager = new GLThreadManager(null);
  private EGLSwapListener eglSwapListener;
  private int mDebugFlags;
  private boolean mDetached;
  private GLSurfaceView.EGLConfigChooser mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private GLSurfaceView.EGLContextFactory mEGLContextFactory;
  private GLSurfaceView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  private GLThread mGLThread;
  private GLSurfaceView.GLWrapper mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private GLSurfaceView.Renderer mRenderer;
  private final WeakReference<BaiduGLSurfaceView> mThisWeakRef = new WeakReference(this);
  
  public BaiduGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BaiduGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void checkRenderThreadState()
  {
    if (this.mGLThread != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  private void init()
  {
    getHolder().addCallback(this);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mGLThread != null) {
        this.mGLThread.requestExitAndWait();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.mDebugFlags;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    return this.mGLThread.getRenderMode();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mDetached) && (this.mRenderer != null))
    {
      int i = 1;
      if (this.mGLThread != null) {
        i = this.mGLThread.getRenderMode();
      }
      this.mGLThread = new GLThread(this.mThisWeakRef);
      if (i != 1) {
        this.mGLThread.setRenderMode(i);
      }
      this.mGLThread.start();
    }
    this.mDetached = false;
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mGLThread != null) {
      this.mGLThread.requestExitAndWait();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    this.mGLThread.onPause();
  }
  
  public void onResume()
  {
    this.mGLThread.onResume();
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.mGLThread.queueEvent(paramRunnable);
  }
  
  public void requestRender()
  {
    this.mGLThread.requestRender();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new ComponentSizeChooser(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new SimpleEGLConfigChooser(paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }
  
  public void setEGLContextFactory(GLSurfaceView.EGLContextFactory paramEGLContextFactory)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }
  
  public void setEglSwapListener(EGLSwapListener paramEGLSwapListener)
  {
    this.eglSwapListener = paramEGLSwapListener;
  }
  
  public void setGLWrapper(GLSurfaceView.GLWrapper paramGLWrapper)
  {
    this.mGLWrapper = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mGLThread.setRenderMode(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new DefaultContextFactory(null);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory(null);
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new GLThread(this.mThisWeakRef);
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGLThread.onWindowResize(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mGLThread != null) {
      this.mGLThread.surfaceCreated();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.surfaceDestroyed();
  }
  
  private abstract class BaseConfigChooser
    implements GLSurfaceView.EGLConfigChooser
  {
    protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
    
    public BaseConfigChooser(int[] paramArrayOfInt) {}
    
    private int[] filterConfigSpec(int[] paramArrayOfInt)
    {
      if ((BaiduGLSurfaceView.this.mEGLContextClientVersion != 2) && (BaiduGLSurfaceView.this.mEGLContextClientVersion != 3)) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      if (BaiduGLSurfaceView.this.mEGLContextClientVersion == 2) {
        arrayOfInt[i] = 4;
      }
      for (;;)
      {
        arrayOfInt[(i + 1)] = 12344;
        return arrayOfInt;
        arrayOfInt[i] = 64;
      }
    }
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
    
    abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  }
  
  private class ComponentSizeChooser
    extends BaiduGLSurfaceView.BaseConfigChooser
  {
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mRedSize;
    protected int mStencilSize;
    private int[] mValue = new int[1];
    
    public ComponentSizeChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
      this.mRedSize = paramInt1;
      this.mGreenSize = paramInt2;
      this.mBlueSize = paramInt3;
      this.mAlphaSize = paramInt4;
      this.mDepthSize = paramInt5;
      this.mStencilSize = paramInt6;
    }
    
    private int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.mValue)) {
        paramInt2 = this.mValue[0];
      }
      return paramInt2;
    }
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((k >= this.mDepthSize) && (m >= this.mStencilSize))
        {
          k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int n = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((k == this.mRedSize) && (m == this.mGreenSize) && (n == this.mBlueSize) && (i1 == this.mAlphaSize)) {
            return localEGLConfig;
          }
        }
        i += 1;
      }
      return null;
    }
  }
  
  private class DefaultContextFactory
    implements GLSurfaceView.EGLContextFactory
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    private DefaultContextFactory() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
      arrayOfInt[1] = BaiduGLSurfaceView.this.mEGLContextClientVersion;
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (BaiduGLSurfaceView.this.mEGLContextClientVersion != 0) {}
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        arrayOfInt = null;
      }
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
        BaiduGLSurfaceView.EglHelper.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
      }
    }
  }
  
  private static class DefaultWindowSurfaceFactory
    implements GLSurfaceView.EGLWindowSurfaceFactory
  {
    public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        f.c("GLSurfaceView", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  public static abstract interface EGLSwapListener
  {
    public abstract void onEGLSwap(BaiduGLSurfaceView paramBaiduGLSurfaceView);
  }
  
  private static class EglHelper
  {
    EGL10 mEgl;
    EGLConfig mEglConfig;
    EGLContext mEglContext;
    EGLDisplay mEglDisplay;
    EGLSurface mEglSurface;
    private WeakReference<BaiduGLSurfaceView> mGLSurfaceViewWeakRef;
    
    public EglHelper(WeakReference<BaiduGLSurfaceView> paramWeakReference)
    {
      this.mGLSurfaceViewWeakRef = paramWeakReference;
    }
    
    private void destroySurfaceImp()
    {
      if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
      {
        this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        BaiduGLSurfaceView localBaiduGLSurfaceView = (BaiduGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
        if (localBaiduGLSurfaceView != null) {
          localBaiduGLSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
        }
        this.mEglSurface = null;
      }
    }
    
    public static String formatEglError(String paramString, int paramInt)
    {
      return paramString + " failed: " + getErrorString(paramInt);
    }
    
    private static String getErrorString(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return getHex(paramInt);
      case 12288: 
        return "EGL_SUCCESS";
      case 12289: 
        return "EGL_NOT_INITIALIZED";
      case 12290: 
        return "EGL_BAD_ACCESS";
      case 12291: 
        return "EGL_BAD_ALLOC";
      case 12292: 
        return "EGL_BAD_ATTRIBUTE";
      case 12293: 
        return "EGL_BAD_CONFIG";
      case 12294: 
        return "EGL_BAD_CONTEXT";
      case 12295: 
        return "EGL_BAD_CURRENT_SURFACE";
      case 12296: 
        return "EGL_BAD_DISPLAY";
      case 12297: 
        return "EGL_BAD_MATCH";
      case 12298: 
        return "EGL_BAD_NATIVE_PIXMAP";
      case 12299: 
        return "EGL_BAD_NATIVE_WINDOW";
      case 12300: 
        return "EGL_BAD_PARAMETER";
      case 12301: 
        return "EGL_BAD_SURFACE";
      }
      return "EGL_CONTEXT_LOST";
    }
    
    private static String getHex(int paramInt)
    {
      return "0x" + Integer.toHexString(paramInt);
    }
    
    public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
    {
      f.d(paramString1, formatEglError(paramString2, paramInt));
    }
    
    private void throwEglException(String paramString)
    {
      throwEglException(paramString, this.mEgl.eglGetError());
    }
    
    public static void throwEglException(String paramString, int paramInt)
    {
      throw new RuntimeException(formatEglError(paramString, paramInt));
    }
    
    GL createGL()
    {
      GL localGL2 = this.mEglContext.getGL();
      BaiduGLSurfaceView localBaiduGLSurfaceView = (BaiduGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      Object localObject = localGL2;
      if (localBaiduGLSurfaceView != null)
      {
        GL localGL1 = localGL2;
        if (localBaiduGLSurfaceView.mGLWrapper != null) {
          localGL1 = localBaiduGLSurfaceView.mGLWrapper.wrap(localGL2);
        }
        localObject = localGL1;
        if ((localBaiduGLSurfaceView.mDebugFlags & 0x3) != 0)
        {
          int i = 0;
          localObject = null;
          if ((localBaiduGLSurfaceView.mDebugFlags & 0x1) != 0) {
            i = 0x0 | 0x1;
          }
          if ((localBaiduGLSurfaceView.mDebugFlags & 0x2) != 0) {
            localObject = new BaiduGLSurfaceView.LogWriter();
          }
          localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        }
      }
      return (GL)localObject;
    }
    
    public boolean createSurface()
    {
      if (this.mEgl == null) {
        throw new RuntimeException("egl not initialized");
      }
      if (this.mEglDisplay == null) {
        throw new RuntimeException("eglDisplay not initialized");
      }
      if (this.mEglConfig == null) {
        throw new RuntimeException("mEglConfig not initialized");
      }
      destroySurfaceImp();
      BaiduGLSurfaceView localBaiduGLSurfaceView = (BaiduGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (localBaiduGLSurfaceView != null) {}
      for (this.mEglSurface = localBaiduGLSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localBaiduGLSurfaceView.getHolder()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
      {
        if (this.mEgl.eglGetError() == 12299) {
          f.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        }
        return false;
      }
      if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
      {
        logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
        return false;
      }
      return true;
    }
    
    public void destroySurface()
    {
      destroySurfaceImp();
    }
    
    public void finish()
    {
      if (this.mEglContext != null)
      {
        BaiduGLSurfaceView localBaiduGLSurfaceView = (BaiduGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
        if (localBaiduGLSurfaceView != null) {
          localBaiduGLSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
        }
        this.mEglContext = null;
      }
      if (this.mEglDisplay != null)
      {
        this.mEgl.eglTerminate(this.mEglDisplay);
        this.mEglDisplay = null;
      }
    }
    
    public void start()
    {
      this.mEgl = ((EGL10)EGLContext.getEGL());
      this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
        throw new RuntimeException("eglGetDisplay failed");
      }
      Object localObject = new int[2];
      if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject)) {
        throw new RuntimeException("eglInitialize failed");
      }
      localObject = (BaiduGLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (localObject == null) {
        this.mEglConfig = null;
      }
      for (this.mEglContext = null;; this.mEglContext = ((BaiduGLSurfaceView)localObject).mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
      {
        if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
        {
          this.mEglContext = null;
          throwEglException("createContext");
        }
        this.mEglSurface = null;
        return;
        this.mEglConfig = ((BaiduGLSurfaceView)localObject).mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
      }
    }
    
    public int swap()
    {
      if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
        return this.mEgl.eglGetError();
      }
      return 12288;
    }
  }
  
  static class GLThread
    extends Thread
  {
    private BaiduGLSurfaceView.EglHelper mEglHelper;
    private ArrayList<Runnable> mEventQueue = new ArrayList();
    private boolean mExited;
    private boolean mFinishedCreatingEglSurface;
    private WeakReference<BaiduGLSurfaceView> mGLSurfaceViewWeakRef;
    private boolean mHasSurface;
    private boolean mHaveEglContext;
    private boolean mHaveEglSurface;
    private int mHeight = 0;
    private boolean mPaused;
    private boolean mRenderComplete;
    private int mRenderMode = 1;
    private boolean mRequestPaused;
    private boolean mRequestRender = true;
    private boolean mShouldExit;
    private boolean mShouldReleaseEglContext;
    private boolean mSizeChanged = true;
    private boolean mSurfaceIsBad;
    private boolean mWaitingForSurface;
    private int mWidth = 0;
    
    GLThread(WeakReference<BaiduGLSurfaceView> paramWeakReference)
    {
      this.mGLSurfaceViewWeakRef = paramWeakReference;
    }
    
    /* Error */
    private void guardedRun()
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: new 70	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper
      //   4: dup
      //   5: aload_0
      //   6: getfield 56	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 72	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 74	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 76	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglContext	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 78	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglSurface	Z
      //   25: aconst_null
      //   26: astore 24
      //   28: iconst_0
      //   29: istore 4
      //   31: iconst_0
      //   32: istore_1
      //   33: iconst_0
      //   34: istore_2
      //   35: iconst_0
      //   36: istore 7
      //   38: iconst_0
      //   39: istore_3
      //   40: iconst_0
      //   41: istore 5
      //   43: iconst_0
      //   44: istore 6
      //   46: iconst_0
      //   47: istore 13
      //   49: iconst_0
      //   50: istore 9
      //   52: iconst_0
      //   53: istore 10
      //   55: aconst_null
      //   56: astore 22
      //   58: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   61: astore 25
      //   63: aload 25
      //   65: monitorenter
      //   66: iload 7
      //   68: istore 8
      //   70: iload 13
      //   72: istore 7
      //   74: aload_0
      //   75: getfield 84	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mShouldExit	Z
      //   78: ifeq +34 -> 112
      //   81: aload 25
      //   83: monitorexit
      //   84: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   87: astore 22
      //   89: aload 22
      //   91: monitorenter
      //   92: aload_0
      //   93: invokespecial 87	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglSurfaceLocked	()V
      //   96: aload_0
      //   97: invokespecial 90	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglContextLocked	()V
      //   100: aload 22
      //   102: monitorexit
      //   103: return
      //   104: astore 23
      //   106: aload 22
      //   108: monitorexit
      //   109: aload 23
      //   111: athrow
      //   112: aload_0
      //   113: getfield 44	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   116: invokevirtual 94	java/util/ArrayList:isEmpty	()Z
      //   119: ifne +101 -> 220
      //   122: aload_0
      //   123: getfield 44	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   126: iconst_0
      //   127: invokevirtual 98	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   130: checkcast 100	java/lang/Runnable
      //   133: astore 23
      //   135: iload 5
      //   137: istore 11
      //   139: iload 9
      //   141: istore 20
      //   143: iload_3
      //   144: istore 5
      //   146: iload 8
      //   148: istore_3
      //   149: iload 10
      //   151: istore 19
      //   153: iload 6
      //   155: istore 12
      //   157: iload_1
      //   158: istore 6
      //   160: iload 4
      //   162: istore_1
      //   163: iload 7
      //   165: istore 8
      //   167: aload 25
      //   169: monitorexit
      //   170: aload 23
      //   172: ifnull +663 -> 835
      //   175: aload 23
      //   177: invokeinterface 103 1 0
      //   182: aconst_null
      //   183: astore 22
      //   185: iload 8
      //   187: istore 13
      //   189: iload_1
      //   190: istore 4
      //   192: iload 6
      //   194: istore_1
      //   195: iload 12
      //   197: istore 6
      //   199: iload 19
      //   201: istore 10
      //   203: iload_3
      //   204: istore 7
      //   206: iload 5
      //   208: istore_3
      //   209: iload 20
      //   211: istore 9
      //   213: iload 11
      //   215: istore 5
      //   217: goto -159 -> 58
      //   220: iconst_0
      //   221: istore 21
      //   223: aload_0
      //   224: getfield 105	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mPaused	Z
      //   227: aload_0
      //   228: getfield 107	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mRequestPaused	Z
      //   231: if_icmpeq +23 -> 254
      //   234: aload_0
      //   235: getfield 107	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mRequestPaused	Z
      //   238: istore 21
      //   240: aload_0
      //   241: aload_0
      //   242: getfield 107	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mRequestPaused	Z
      //   245: putfield 105	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mPaused	Z
      //   248: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   251: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   254: aload_0
      //   255: getfield 114	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mShouldReleaseEglContext	Z
      //   258: ifeq +19 -> 277
      //   261: aload_0
      //   262: invokespecial 87	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglSurfaceLocked	()V
      //   265: aload_0
      //   266: invokespecial 90	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglContextLocked	()V
      //   269: aload_0
      //   270: iconst_0
      //   271: putfield 114	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mShouldReleaseEglContext	Z
      //   274: iconst_1
      //   275: istore 7
      //   277: iload 8
      //   279: istore 11
      //   281: iload 8
      //   283: ifeq +14 -> 297
      //   286: aload_0
      //   287: invokespecial 87	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglSurfaceLocked	()V
      //   290: aload_0
      //   291: invokespecial 90	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglContextLocked	()V
      //   294: iconst_0
      //   295: istore 11
      //   297: iload 21
      //   299: ifeq +14 -> 313
      //   302: aload_0
      //   303: getfield 78	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglSurface	Z
      //   306: ifeq +7 -> 313
      //   309: aload_0
      //   310: invokespecial 87	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglSurfaceLocked	()V
      //   313: iload 21
      //   315: ifeq +56 -> 371
      //   318: aload_0
      //   319: getfield 76	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglContext	Z
      //   322: ifeq +49 -> 371
      //   325: aload_0
      //   326: getfield 56	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   329: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   332: checkcast 6	com/baidu/platform/comapi/map/BaiduGLSurfaceView
      //   335: astore 23
      //   337: aload 23
      //   339: ifnull +390 -> 729
      //   342: aload 23
      //   344: invokestatic 124	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$900	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView;)Z
      //   347: ifeq +382 -> 729
      //   350: iconst_1
      //   351: istore 8
      //   353: iload 8
      //   355: ifeq +12 -> 367
      //   358: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   361: invokevirtual 129	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:shouldReleaseEGLContextWhenPausing	()Z
      //   364: ifeq +7 -> 371
      //   367: aload_0
      //   368: invokespecial 90	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglContextLocked	()V
      //   371: iload 21
      //   373: ifeq +19 -> 392
      //   376: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   379: invokevirtual 132	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:shouldTerminateEGLWhenPausing	()Z
      //   382: ifeq +10 -> 392
      //   385: aload_0
      //   386: getfield 74	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper;
      //   389: invokevirtual 135	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:finish	()V
      //   392: aload_0
      //   393: getfield 137	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHasSurface	Z
      //   396: ifne +37 -> 433
      //   399: aload_0
      //   400: getfield 139	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mWaitingForSurface	Z
      //   403: ifne +30 -> 433
      //   406: aload_0
      //   407: getfield 78	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglSurface	Z
      //   410: ifeq +7 -> 417
      //   413: aload_0
      //   414: invokespecial 87	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglSurfaceLocked	()V
      //   417: aload_0
      //   418: iconst_1
      //   419: putfield 139	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mWaitingForSurface	Z
      //   422: aload_0
      //   423: iconst_0
      //   424: putfield 141	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mSurfaceIsBad	Z
      //   427: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   430: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   433: aload_0
      //   434: getfield 137	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHasSurface	Z
      //   437: ifeq +21 -> 458
      //   440: aload_0
      //   441: getfield 139	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mWaitingForSurface	Z
      //   444: ifeq +14 -> 458
      //   447: aload_0
      //   448: iconst_0
      //   449: putfield 139	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mWaitingForSurface	Z
      //   452: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   455: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   458: iload 6
      //   460: istore 12
      //   462: iload 5
      //   464: istore 13
      //   466: iload 6
      //   468: ifeq +20 -> 488
      //   471: iconst_0
      //   472: istore 13
      //   474: iconst_0
      //   475: istore 12
      //   477: aload_0
      //   478: iconst_1
      //   479: putfield 143	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mRenderComplete	Z
      //   482: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   485: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   488: iload 7
      //   490: istore 14
      //   492: iload 4
      //   494: istore 16
      //   496: iload_1
      //   497: istore 17
      //   499: iload_2
      //   500: istore 18
      //   502: iload_3
      //   503: istore 15
      //   505: aload_0
      //   506: invokespecial 146	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:readyToDraw	()Z
      //   509: ifeq +288 -> 797
      //   512: iload 7
      //   514: istore 6
      //   516: iload 4
      //   518: istore 5
      //   520: aload_0
      //   521: getfield 76	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglContext	Z
      //   524: ifne +15 -> 539
      //   527: iload 7
      //   529: ifeq +206 -> 735
      //   532: iconst_0
      //   533: istore 6
      //   535: iload 4
      //   537: istore 5
      //   539: iload_1
      //   540: istore 8
      //   542: iload_2
      //   543: istore 4
      //   545: iload_3
      //   546: istore 7
      //   548: aload_0
      //   549: getfield 76	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglContext	Z
      //   552: ifeq +33 -> 585
      //   555: iload_1
      //   556: istore 8
      //   558: iload_2
      //   559: istore 4
      //   561: iload_3
      //   562: istore 7
      //   564: aload_0
      //   565: getfield 78	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglSurface	Z
      //   568: ifne +17 -> 585
      //   571: aload_0
      //   572: iconst_1
      //   573: putfield 78	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglSurface	Z
      //   576: iconst_1
      //   577: istore 8
      //   579: iconst_1
      //   580: istore 4
      //   582: iconst_1
      //   583: istore 7
      //   585: iload 6
      //   587: istore 14
      //   589: iload 5
      //   591: istore 16
      //   593: iload 8
      //   595: istore 17
      //   597: iload 4
      //   599: istore 18
      //   601: iload 7
      //   603: istore 15
      //   605: aload_0
      //   606: getfield 78	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglSurface	Z
      //   609: ifeq +188 -> 797
      //   612: iload 8
      //   614: istore_2
      //   615: aload_0
      //   616: getfield 46	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mSizeChanged	Z
      //   619: ifeq +28 -> 647
      //   622: iconst_1
      //   623: istore 7
      //   625: aload_0
      //   626: getfield 48	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mWidth	I
      //   629: istore 9
      //   631: aload_0
      //   632: getfield 50	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHeight	I
      //   635: istore 10
      //   637: iconst_1
      //   638: istore 13
      //   640: iconst_1
      //   641: istore_2
      //   642: aload_0
      //   643: iconst_0
      //   644: putfield 46	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mSizeChanged	Z
      //   647: aload_0
      //   648: iconst_0
      //   649: putfield 52	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mRequestRender	Z
      //   652: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   655: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   658: iload 6
      //   660: istore 8
      //   662: iload 5
      //   664: istore_1
      //   665: iload_2
      //   666: istore 6
      //   668: iload 4
      //   670: istore_2
      //   671: aload 22
      //   673: astore 23
      //   675: iload 10
      //   677: istore 19
      //   679: iload 11
      //   681: istore_3
      //   682: iload 7
      //   684: istore 5
      //   686: iload 9
      //   688: istore 20
      //   690: iload 13
      //   692: istore 11
      //   694: goto -527 -> 167
      //   697: astore 22
      //   699: aload 25
      //   701: monitorexit
      //   702: aload 22
      //   704: athrow
      //   705: astore 23
      //   707: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   710: astore 22
      //   712: aload 22
      //   714: monitorenter
      //   715: aload_0
      //   716: invokespecial 87	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglSurfaceLocked	()V
      //   719: aload_0
      //   720: invokespecial 90	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:stopEglContextLocked	()V
      //   723: aload 22
      //   725: monitorexit
      //   726: aload 23
      //   728: athrow
      //   729: iconst_0
      //   730: istore 8
      //   732: goto -379 -> 353
      //   735: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   738: aload_0
      //   739: invokevirtual 150	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:tryAcquireEglContextLocked	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread;)Z
      //   742: istore 21
      //   744: iload 7
      //   746: istore 6
      //   748: iload 4
      //   750: istore 5
      //   752: iload 21
      //   754: ifeq -215 -> 539
      //   757: aload_0
      //   758: getfield 74	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper;
      //   761: invokevirtual 153	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:start	()V
      //   764: aload_0
      //   765: iconst_1
      //   766: putfield 76	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mHaveEglContext	Z
      //   769: iconst_1
      //   770: istore 5
      //   772: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   775: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   778: iload 7
      //   780: istore 6
      //   782: goto -243 -> 539
      //   785: astore 22
      //   787: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   790: aload_0
      //   791: invokevirtual 157	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:releaseEglContextLocked	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread;)V
      //   794: aload 22
      //   796: athrow
      //   797: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   800: invokevirtual 160	java/lang/Object:wait	()V
      //   803: iload 14
      //   805: istore 7
      //   807: iload 16
      //   809: istore 4
      //   811: iload 17
      //   813: istore_1
      //   814: iload 18
      //   816: istore_2
      //   817: iload 12
      //   819: istore 6
      //   821: iload 11
      //   823: istore 8
      //   825: iload 15
      //   827: istore_3
      //   828: iload 13
      //   830: istore 5
      //   832: goto -758 -> 74
      //   835: iload 6
      //   837: istore 14
      //   839: iload 6
      //   841: ifeq +38 -> 879
      //   844: aload_0
      //   845: getfield 74	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper;
      //   848: invokevirtual 163	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:createSurface	()Z
      //   851: ifeq +355 -> 1206
      //   854: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   857: astore 22
      //   859: aload 22
      //   861: monitorenter
      //   862: aload_0
      //   863: iconst_1
      //   864: putfield 165	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mFinishedCreatingEglSurface	Z
      //   867: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   870: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   873: aload 22
      //   875: monitorexit
      //   876: iconst_0
      //   877: istore 14
      //   879: iload_2
      //   880: istore 15
      //   882: aload 24
      //   884: astore 25
      //   886: iload_2
      //   887: ifeq +26 -> 913
      //   890: aload_0
      //   891: getfield 74	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper;
      //   894: invokevirtual 169	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:createGL	()Ljavax/microedition/khronos/opengles/GL;
      //   897: checkcast 171	javax/microedition/khronos/opengles/GL10
      //   900: astore 25
      //   902: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   905: aload 25
      //   907: invokevirtual 175	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:checkGLDriver	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   910: iconst_0
      //   911: istore 15
      //   913: iload_1
      //   914: istore 16
      //   916: iload_1
      //   917: ifeq +42 -> 959
      //   920: aload_0
      //   921: getfield 56	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   924: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   927: checkcast 6	com/baidu/platform/comapi/map/BaiduGLSurfaceView
      //   930: astore 22
      //   932: aload 22
      //   934: ifnull +417 -> 1351
      //   937: aload 22
      //   939: invokestatic 179	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$1000	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   942: aload 25
      //   944: aload_0
      //   945: getfield 74	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper;
      //   948: getfield 183	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   951: invokeinterface 189 3 0
      //   956: goto +395 -> 1351
      //   959: iload 5
      //   961: istore 17
      //   963: iload 5
      //   965: ifeq +39 -> 1004
      //   968: aload_0
      //   969: getfield 56	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   972: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   975: checkcast 6	com/baidu/platform/comapi/map/BaiduGLSurfaceView
      //   978: astore 22
      //   980: aload 22
      //   982: ifnull +375 -> 1357
      //   985: aload 22
      //   987: invokestatic 179	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$1000	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   990: aload 25
      //   992: iload 20
      //   994: iload 19
      //   996: invokeinterface 193 4 0
      //   1001: goto +356 -> 1357
      //   1004: aload_0
      //   1005: getfield 56	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1008: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1011: checkcast 6	com/baidu/platform/comapi/map/BaiduGLSurfaceView
      //   1014: astore 22
      //   1016: aload 22
      //   1018: ifnull +15 -> 1033
      //   1021: aload 22
      //   1023: invokestatic 179	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$1000	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1026: aload 25
      //   1028: invokeinterface 196 2 0
      //   1033: aload_0
      //   1034: getfield 74	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper;
      //   1037: invokevirtual 200	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:swap	()I
      //   1040: istore_1
      //   1041: iload_1
      //   1042: lookupswitch	default:+321->1363, 12288:+238->1280, 12302:+287->1329
      //   1068: ldc -55
      //   1070: ldc -53
      //   1072: iload_1
      //   1073: invokestatic 207	com/baidu/platform/comapi/map/BaiduGLSurfaceView$EglHelper:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1076: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   1079: astore 22
      //   1081: aload 22
      //   1083: monitorenter
      //   1084: aload_0
      //   1085: iconst_1
      //   1086: putfield 141	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mSurfaceIsBad	Z
      //   1089: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   1092: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   1095: aload 22
      //   1097: monitorexit
      //   1098: iload_3
      //   1099: istore 18
      //   1101: iload 8
      //   1103: istore 13
      //   1105: iload 16
      //   1107: istore 4
      //   1109: iload 14
      //   1111: istore_1
      //   1112: iload 15
      //   1114: istore_2
      //   1115: iload 12
      //   1117: istore 6
      //   1119: aload 23
      //   1121: astore 22
      //   1123: aload 25
      //   1125: astore 24
      //   1127: iload 19
      //   1129: istore 10
      //   1131: iload 18
      //   1133: istore 7
      //   1135: iload 17
      //   1137: istore_3
      //   1138: iload 20
      //   1140: istore 9
      //   1142: iload 11
      //   1144: istore 5
      //   1146: iload 11
      //   1148: ifeq -1090 -> 58
      //   1151: iconst_1
      //   1152: istore 6
      //   1154: iload 8
      //   1156: istore 13
      //   1158: iload 16
      //   1160: istore 4
      //   1162: iload 14
      //   1164: istore_1
      //   1165: iload 15
      //   1167: istore_2
      //   1168: aload 23
      //   1170: astore 22
      //   1172: aload 25
      //   1174: astore 24
      //   1176: iload 19
      //   1178: istore 10
      //   1180: iload 18
      //   1182: istore 7
      //   1184: iload 17
      //   1186: istore_3
      //   1187: iload 20
      //   1189: istore 9
      //   1191: iload 11
      //   1193: istore 5
      //   1195: goto -1137 -> 58
      //   1198: astore 23
      //   1200: aload 22
      //   1202: monitorexit
      //   1203: aload 23
      //   1205: athrow
      //   1206: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   1209: astore 22
      //   1211: aload 22
      //   1213: monitorenter
      //   1214: aload_0
      //   1215: iconst_1
      //   1216: putfield 165	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mFinishedCreatingEglSurface	Z
      //   1219: aload_0
      //   1220: iconst_1
      //   1221: putfield 141	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mSurfaceIsBad	Z
      //   1224: invokestatic 82	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$800	()Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager;
      //   1227: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   1230: aload 22
      //   1232: monitorexit
      //   1233: iload 8
      //   1235: istore 13
      //   1237: iload_1
      //   1238: istore 4
      //   1240: iload 6
      //   1242: istore_1
      //   1243: iload 12
      //   1245: istore 6
      //   1247: aload 23
      //   1249: astore 22
      //   1251: iload 19
      //   1253: istore 10
      //   1255: iload_3
      //   1256: istore 7
      //   1258: iload 5
      //   1260: istore_3
      //   1261: iload 20
      //   1263: istore 9
      //   1265: iload 11
      //   1267: istore 5
      //   1269: goto -1211 -> 58
      //   1272: astore 23
      //   1274: aload 22
      //   1276: monitorexit
      //   1277: aload 23
      //   1279: athrow
      //   1280: aload_0
      //   1281: getfield 56	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1284: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1287: checkcast 6	com/baidu/platform/comapi/map/BaiduGLSurfaceView
      //   1290: astore 22
      //   1292: iload_3
      //   1293: istore 18
      //   1295: aload 22
      //   1297: ifnull -196 -> 1101
      //   1300: iload_3
      //   1301: istore 18
      //   1303: aload 22
      //   1305: invokestatic 211	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$1100	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView;)Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EGLSwapListener;
      //   1308: ifnull -207 -> 1101
      //   1311: aload 22
      //   1313: invokestatic 211	com/baidu/platform/comapi/map/BaiduGLSurfaceView:access$1100	(Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView;)Lcom/baidu/platform/comapi/map/BaiduGLSurfaceView$EGLSwapListener;
      //   1316: aload 22
      //   1318: invokeinterface 217 2 0
      //   1323: iload_3
      //   1324: istore 18
      //   1326: goto -225 -> 1101
      //   1329: iconst_1
      //   1330: istore 18
      //   1332: goto -231 -> 1101
      //   1335: astore 23
      //   1337: aload 22
      //   1339: monitorexit
      //   1340: aload 23
      //   1342: athrow
      //   1343: astore 23
      //   1345: aload 22
      //   1347: monitorexit
      //   1348: aload 23
      //   1350: athrow
      //   1351: iconst_0
      //   1352: istore 16
      //   1354: goto -395 -> 959
      //   1357: iconst_0
      //   1358: istore 17
      //   1360: goto -356 -> 1004
      //   1363: goto -295 -> 1068
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1366	0	this	GLThread
      //   32	1211	1	i	int
      //   34	1134	2	j	int
      //   39	1285	3	k	int
      //   29	1210	4	m	int
      //   41	1227	5	n	int
      //   44	1202	6	i1	int
      //   36	1221	7	i2	int
      //   68	1166	8	i3	int
      //   50	1214	9	i4	int
      //   53	1201	10	i5	int
      //   137	1129	11	i6	int
      //   155	1089	12	i7	int
      //   47	1189	13	i8	int
      //   490	673	14	i9	int
      //   503	663	15	i10	int
      //   494	859	16	i11	int
      //   497	862	17	i12	int
      //   500	831	18	i13	int
      //   151	1101	19	i14	int
      //   141	1121	20	i15	int
      //   221	532	21	bool	boolean
      //   697	6	22	localObject1	Object
      //   785	10	22	localRuntimeException	RuntimeException
      //   104	6	23	localObject3	Object
      //   133	541	23	localObject4	Object
      //   705	464	23	localObject5	Object
      //   1198	50	23	localObject6	Object
      //   1272	6	23	localObject7	Object
      //   1335	6	23	localObject8	Object
      //   1343	6	23	localObject9	Object
      //   26	1149	24	localObject10	Object
      //   61	1112	25	localObject11	Object
      // Exception table:
      //   from	to	target	type
      //   92	103	104	finally
      //   106	109	104	finally
      //   74	84	697	finally
      //   112	135	697	finally
      //   167	170	697	finally
      //   223	254	697	finally
      //   254	274	697	finally
      //   286	294	697	finally
      //   302	313	697	finally
      //   318	337	697	finally
      //   342	350	697	finally
      //   358	367	697	finally
      //   367	371	697	finally
      //   376	392	697	finally
      //   392	417	697	finally
      //   417	433	697	finally
      //   433	458	697	finally
      //   477	488	697	finally
      //   505	512	697	finally
      //   520	527	697	finally
      //   548	555	697	finally
      //   564	576	697	finally
      //   605	612	697	finally
      //   615	622	697	finally
      //   625	637	697	finally
      //   642	647	697	finally
      //   647	658	697	finally
      //   699	702	697	finally
      //   735	744	697	finally
      //   757	764	697	finally
      //   764	769	697	finally
      //   772	778	697	finally
      //   787	797	697	finally
      //   797	803	697	finally
      //   58	66	705	finally
      //   175	182	705	finally
      //   702	705	705	finally
      //   844	862	705	finally
      //   890	910	705	finally
      //   920	932	705	finally
      //   937	956	705	finally
      //   968	980	705	finally
      //   985	1001	705	finally
      //   1004	1016	705	finally
      //   1021	1033	705	finally
      //   1033	1041	705	finally
      //   1068	1084	705	finally
      //   1203	1206	705	finally
      //   1206	1214	705	finally
      //   1277	1280	705	finally
      //   1280	1292	705	finally
      //   1303	1323	705	finally
      //   1340	1343	705	finally
      //   757	764	785	java/lang/RuntimeException
      //   862	876	1198	finally
      //   1200	1203	1198	finally
      //   1214	1233	1272	finally
      //   1274	1277	1272	finally
      //   1084	1098	1335	finally
      //   1337	1340	1335	finally
      //   715	726	1343	finally
      //   1345	1348	1343	finally
    }
    
    private boolean readyToDraw()
    {
      return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
    }
    
    private void stopEglContextLocked()
    {
      if (this.mHaveEglContext)
      {
        this.mEglHelper.finish();
        this.mHaveEglContext = false;
        BaiduGLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
      }
    }
    
    private void stopEglSurfaceLocked()
    {
      if (this.mHaveEglSurface)
      {
        this.mHaveEglSurface = false;
        this.mEglHelper.destroySurface();
      }
    }
    
    public boolean ableToDraw()
    {
      return (this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw());
    }
    
    public int getRenderMode()
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        int i = this.mRenderMode;
        return i;
      }
    }
    
    public void onPause()
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mRequestPaused = true;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if (!this.mExited)
          {
            boolean bool = this.mPaused;
            if (!bool) {
              try
              {
                BaiduGLSurfaceView.sGLThreadManager.wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void onResume()
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mRequestPaused = false;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (this.mPaused))
          {
            boolean bool = this.mRenderComplete;
            if (!bool) {
              try
              {
                BaiduGLSurfaceView.sGLThreadManager.wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void onWindowResize(int paramInt1, int paramInt2)
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        this.mSizeChanged = true;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
          {
            boolean bool = ableToDraw();
            if (bool) {
              try
              {
                BaiduGLSurfaceView.sGLThreadManager.wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void queueEvent(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        throw new IllegalArgumentException("r must not be null");
      }
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mEventQueue.add(paramRunnable);
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void requestExitAndWait()
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mShouldExit = true;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        for (;;)
        {
          boolean bool = this.mExited;
          if (!bool) {
            try
            {
              BaiduGLSurfaceView.sGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    
    public void requestReleaseEglContextLocked()
    {
      this.mShouldReleaseEglContext = true;
      BaiduGLSurfaceView.sGLThreadManager.notifyAll();
    }
    
    public void requestRender()
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mRequestRender = true;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void run()
    {
      setName("GLThread " + getId());
      try
      {
        guardedRun();
        BaiduGLSurfaceView.sGLThreadManager.threadExiting(this);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException = localInterruptedException;
        BaiduGLSurfaceView.sGLThreadManager.threadExiting(this);
        return;
      }
      finally
      {
        localObject = finally;
        BaiduGLSurfaceView.sGLThreadManager.threadExiting(this);
        throw ((Throwable)localObject);
      }
    }
    
    public void setRenderMode(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mRenderMode = paramInt;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void surfaceCreated()
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mHasSurface = true;
        this.mFinishedCreatingEglSurface = false;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
          {
            boolean bool = this.mExited;
            if (!bool) {
              try
              {
                BaiduGLSurfaceView.sGLThreadManager.wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
    
    public void surfaceDestroyed()
    {
      synchronized (BaiduGLSurfaceView.sGLThreadManager)
      {
        this.mHasSurface = false;
        BaiduGLSurfaceView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if (!this.mWaitingForSurface)
          {
            boolean bool = this.mExited;
            if (!bool) {
              try
              {
                BaiduGLSurfaceView.sGLThreadManager.wait();
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    }
  }
  
  private static class GLThreadManager
  {
    private static final Method GET_INT_METHOD;
    private static final Class SYSTEM_PROPERTIES_CLASS;
    private static String TAG = "GLThreadManager";
    private static final int kGLES_20 = 131072;
    private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
    private BaiduGLSurfaceView.GLThread mEglOwner;
    private boolean mGLESDriverCheckComplete;
    private int mGLESVersion;
    private boolean mGLESVersionCheckComplete;
    private boolean mLimitedGLESContexts;
    private boolean mMultipleGLESContextsAllowed;
    
    static
    {
      try
      {
        SYSTEM_PROPERTIES_CLASS = Class.forName("android.os.SystemProperties");
        GET_INT_METHOD = SYSTEM_PROPERTIES_CLASS.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
        GET_INT_METHOD.setAccessible(true);
        return;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    
    private void checkGLESVersion()
    {
      if (!this.mGLESVersionCheckComplete) {}
      try
      {
        this.mGLESVersion = ((Integer)GET_INT_METHOD.invoke(null, new Object[] { "ro.opengles.version", Integer.valueOf(0) })).intValue();
        if (this.mGLESVersion >= 131072) {
          this.mMultipleGLESContextsAllowed = true;
        }
        this.mGLESVersionCheckComplete = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.mGLESVersion = 65536;
        }
      }
    }
    
    /* Error */
    public void checkGLDriver(javax.microedition.khronos.opengles.GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 102	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:mGLESDriverCheckComplete	Z
      //   8: ifne +65 -> 73
      //   11: aload_0
      //   12: invokespecial 104	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:checkGLESVersion	()V
      //   15: aload_1
      //   16: sipush 7937
      //   19: invokeinterface 110 2 0
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 95	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:mGLESVersion	I
      //   29: ldc 16
      //   31: if_icmpge +23 -> 54
      //   34: aload_1
      //   35: ldc 19
      //   37: invokevirtual 114	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   40: ifne +36 -> 76
      //   43: iconst_1
      //   44: istore_2
      //   45: aload_0
      //   46: iload_2
      //   47: putfield 97	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:mMultipleGLESContextsAllowed	Z
      //   50: aload_0
      //   51: invokevirtual 117	java/lang/Object:notifyAll	()V
      //   54: aload_0
      //   55: getfield 97	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:mMultipleGLESContextsAllowed	Z
      //   58: ifne +23 -> 81
      //   61: iload_3
      //   62: istore_2
      //   63: aload_0
      //   64: iload_2
      //   65: putfield 119	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:mLimitedGLESContexts	Z
      //   68: aload_0
      //   69: iconst_1
      //   70: putfield 102	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:mGLESDriverCheckComplete	Z
      //   73: aload_0
      //   74: monitorexit
      //   75: return
      //   76: iconst_0
      //   77: istore_2
      //   78: goto -33 -> 45
      //   81: iconst_0
      //   82: istore_2
      //   83: goto -20 -> 63
      //   86: astore_1
      //   87: aload_0
      //   88: monitorexit
      //   89: aload_1
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	GLThreadManager
      //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
      //   44	39	2	bool1	boolean
      //   1	61	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	43	86	finally
      //   45	54	86	finally
      //   54	61	86	finally
      //   63	73	86	finally
    }
    
    public void releaseEglContextLocked(BaiduGLSurfaceView.GLThread paramGLThread)
    {
      if (this.mEglOwner == paramGLThread) {
        this.mEglOwner = null;
      }
      notifyAll();
    }
    
    public boolean shouldReleaseEGLContextWhenPausing()
    {
      try
      {
        boolean bool = this.mLimitedGLESContexts;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public boolean shouldTerminateEGLWhenPausing()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 104	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:checkGLESVersion	()V
      //   6: aload_0
      //   7: getfield 97	com/baidu/platform/comapi/map/BaiduGLSurfaceView$GLThreadManager:mMultipleGLESContextsAllowed	Z
      //   10: istore_1
      //   11: iload_1
      //   12: ifne +9 -> 21
      //   15: iconst_1
      //   16: istore_1
      //   17: aload_0
      //   18: monitorexit
      //   19: iload_1
      //   20: ireturn
      //   21: iconst_0
      //   22: istore_1
      //   23: goto -6 -> 17
      //   26: astore_2
      //   27: aload_0
      //   28: monitorexit
      //   29: aload_2
      //   30: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	GLThreadManager
      //   10	13	1	bool	boolean
      //   26	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	11	26	finally
    }
    
    public void threadExiting(BaiduGLSurfaceView.GLThread paramGLThread)
    {
      try
      {
        BaiduGLSurfaceView.GLThread.access$1202(paramGLThread, true);
        if (this.mEglOwner == paramGLThread) {
          this.mEglOwner = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    public boolean tryAcquireEglContextLocked(BaiduGLSurfaceView.GLThread paramGLThread)
    {
      if ((this.mEglOwner == paramGLThread) || (this.mEglOwner == null))
      {
        this.mEglOwner = paramGLThread;
        notifyAll();
      }
      do
      {
        return true;
        checkGLESVersion();
      } while (this.mMultipleGLESContextsAllowed);
      if (this.mEglOwner != null) {
        this.mEglOwner.requestReleaseEglContextLocked();
      }
      return false;
    }
  }
  
  static class LogWriter
    extends Writer
  {
    private StringBuilder mBuilder = new StringBuilder();
    
    private void flushBuilder()
    {
      if (this.mBuilder.length() > 0) {
        this.mBuilder.delete(0, this.mBuilder.length());
      }
    }
    
    public void close()
    {
      flushBuilder();
    }
    
    public void flush()
    {
      flushBuilder();
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          flushBuilder();
        }
        for (;;)
        {
          i += 1;
          break;
          this.mBuilder.append(c);
        }
      }
    }
  }
  
  private class SimpleEGLConfigChooser
    extends BaiduGLSurfaceView.ComponentSizeChooser
  {
    public SimpleEGLConfigChooser(boolean paramBoolean) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/BaiduGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */