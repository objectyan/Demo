package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.opengl.GLSurfaceView.GLWrapper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
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

public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  private static final boolean LOG_ATTACH_DETACH = true;
  private static final boolean LOG_EGL = true;
  private static final boolean LOG_PAUSE_RESUME = true;
  private static final boolean LOG_RENDERER = true;
  private static final boolean LOG_RENDERER_DRAW_FRAME = false;
  private static final boolean LOG_SURFACE = true;
  private static final boolean LOG_THREADS = true;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "GLTextureView";
  private static final GLThreadManager sGLThreadManager = new GLThreadManager(null);
  private final View.OnLayoutChangeListener layoutChangeListener = new View.OnLayoutChangeListener()
  {
    public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
    {
      GLTextureView.this.onSurfaceTextureSizeChanged(GLTextureView.this.getSurfaceTexture(), paramAnonymousInt3 - paramAnonymousInt1, paramAnonymousInt4 - paramAnonymousInt2);
    }
  };
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
  private final WeakReference<GLTextureView> mThisWeakRef = new WeakReference(this);
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(this.layoutChangeListener);
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
    Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.mDetached);
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
    Log.d("GLTextureView", "onDetachedFromWindow");
    if (this.mGLThread != null) {
      this.mGLThread.requestExitAndWait();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    if (this.mGLThread != null) {
      this.mGLThread.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mGLThread != null) {
      this.mGLThread.onResume();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    surfaceCreated(paramSurfaceTexture);
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    surfaceDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void queueEvent(Runnable paramRunnable)
  {
    if (this.mGLThread != null) {
      this.mGLThread.queueEvent(paramRunnable);
    }
  }
  
  public void requestRender()
  {
    if (this.mGLThread != null) {
      this.mGLThread.requestRender();
    }
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
  
  public void surfaceChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mGLThread != null) {
      this.mGLThread.onWindowResize(paramInt2, paramInt3);
    }
  }
  
  public void surfaceCreated(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mGLThread != null) {
      this.mGLThread.surfaceCreated();
    }
  }
  
  public void surfaceDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mGLThread != null) {
      this.mGLThread.surfaceDestroyed();
    }
  }
  
  private abstract class BaseConfigChooser
    implements GLSurfaceView.EGLConfigChooser
  {
    protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
    
    public BaseConfigChooser(int[] paramArrayOfInt) {}
    
    private int[] filterConfigSpec(int[] paramArrayOfInt)
    {
      if (GLTextureView.this.mEGLContextClientVersion != 2) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      arrayOfInt[i] = 4;
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
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
    extends GLTextureView.BaseConfigChooser
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
      arrayOfInt[1] = GLTextureView.this.mEGLContextClientVersion;
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (GLTextureView.this.mEGLContextClientVersion != 0) {}
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        arrayOfInt = null;
      }
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
        GLTextureView.EglHelper.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
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
        Log.e("GLTextureView", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  private static class EglHelper
  {
    EGL10 mEgl;
    EGLConfig mEglConfig;
    EGLContext mEglContext;
    EGLDisplay mEglDisplay;
    EGLSurface mEglSurface;
    private WeakReference<GLTextureView> mGLTextureViewWeakRef;
    
    public EglHelper(WeakReference<GLTextureView> paramWeakReference)
    {
      this.mGLTextureViewWeakRef = paramWeakReference;
    }
    
    private void destroySurfaceImp()
    {
      if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
      {
        this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
        if (localGLTextureView != null) {
          localGLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
        }
        this.mEglSurface = null;
      }
    }
    
    public static String formatEglError(String paramString, int paramInt)
    {
      return paramString + " EGL failed code: " + paramInt;
    }
    
    public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt) {}
    
    private void throwEglException(String paramString)
    {
      throwEglException(paramString, this.mEgl.eglGetError());
    }
    
    public static void throwEglException(String paramString, int paramInt)
    {
      paramString = formatEglError(paramString, paramInt);
      Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString);
      throw new RuntimeException(paramString);
    }
    
    GL createGL()
    {
      GL localGL2 = this.mEglContext.getGL();
      GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
      Object localObject = localGL2;
      if (localGLTextureView != null)
      {
        GL localGL1 = localGL2;
        if (localGLTextureView.mGLWrapper != null) {
          localGL1 = localGLTextureView.mGLWrapper.wrap(localGL2);
        }
        localObject = localGL1;
        if ((localGLTextureView.mDebugFlags & 0x3) != 0)
        {
          int i = 0;
          localObject = null;
          if ((localGLTextureView.mDebugFlags & 0x1) != 0) {
            i = 0x0 | 0x1;
          }
          if ((localGLTextureView.mDebugFlags & 0x2) != 0) {
            localObject = new GLTextureView.LogWriter();
          }
          localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        }
      }
      return (GL)localObject;
    }
    
    public boolean createSurface()
    {
      Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
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
      GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if (localGLTextureView != null) {}
      for (this.mEglSurface = localGLTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localGLTextureView.getSurfaceTexture()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
      {
        if (this.mEgl.eglGetError() == 12299) {
          Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
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
      Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
      destroySurfaceImp();
    }
    
    public void finish()
    {
      Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
      if (this.mEglContext != null)
      {
        GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
        if (localGLTextureView != null) {
          localGLTextureView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
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
      Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
      this.mEgl = ((EGL10)EGLContext.getEGL());
      this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
        throw new RuntimeException("eglGetDisplay failed");
      }
      Object localObject = new int[2];
      if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject)) {
        throw new RuntimeException("eglInitialize failed");
      }
      localObject = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if (localObject == null) {
        this.mEglConfig = null;
      }
      for (this.mEglContext = null;; this.mEglContext = ((GLTextureView)localObject).mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
      {
        if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
        {
          this.mEglContext = null;
          throwEglException("createContext");
        }
        Log.w("EglHelper", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId());
        this.mEglSurface = null;
        return;
        this.mEglConfig = ((GLTextureView)localObject).mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
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
    private GLTextureView.EglHelper mEglHelper;
    private ArrayList<Runnable> mEventQueue = new ArrayList();
    private boolean mExited;
    private WeakReference<GLTextureView> mGLTextureViewWeakRef;
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
    
    GLThread(WeakReference<GLTextureView> paramWeakReference)
    {
      this.mGLTextureViewWeakRef = paramWeakReference;
    }
    
    /* Error */
    private void guardedRun()
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: new 69	com/baidu/platform/comapi/map/GLTextureView$EglHelper
      //   4: dup
      //   5: aload_0
      //   6: getfield 55	com/baidu/platform/comapi/map/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 71	com/baidu/platform/comapi/map/GLTextureView$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 73	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/GLTextureView$EglHelper;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 75	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglContext	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 77	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglSurface	Z
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
      //   58: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   61: astore 25
      //   63: aload 25
      //   65: monitorenter
      //   66: iload 7
      //   68: istore 8
      //   70: iload 13
      //   72: istore 7
      //   74: aload_0
      //   75: getfield 83	com/baidu/platform/comapi/map/GLTextureView$GLThread:mShouldExit	Z
      //   78: ifeq +34 -> 112
      //   81: aload 25
      //   83: monitorexit
      //   84: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   87: astore 22
      //   89: aload 22
      //   91: monitorenter
      //   92: aload_0
      //   93: invokespecial 86	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   96: aload_0
      //   97: invokespecial 89	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglContextLocked	()V
      //   100: aload 22
      //   102: monitorexit
      //   103: return
      //   104: astore 23
      //   106: aload 22
      //   108: monitorexit
      //   109: aload 23
      //   111: athrow
      //   112: aload_0
      //   113: getfield 43	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   116: invokevirtual 93	java/util/ArrayList:isEmpty	()Z
      //   119: ifne +101 -> 220
      //   122: aload_0
      //   123: getfield 43	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   126: iconst_0
      //   127: invokevirtual 97	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   130: checkcast 99	java/lang/Runnable
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
      //   172: ifnull +1075 -> 1247
      //   175: aload 23
      //   177: invokeinterface 102 1 0
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
      //   224: getfield 104	com/baidu/platform/comapi/map/GLTextureView$GLThread:mPaused	Z
      //   227: aload_0
      //   228: getfield 106	com/baidu/platform/comapi/map/GLTextureView$GLThread:mRequestPaused	Z
      //   231: if_icmpeq +63 -> 294
      //   234: aload_0
      //   235: getfield 106	com/baidu/platform/comapi/map/GLTextureView$GLThread:mRequestPaused	Z
      //   238: istore 21
      //   240: aload_0
      //   241: aload_0
      //   242: getfield 106	com/baidu/platform/comapi/map/GLTextureView$GLThread:mRequestPaused	Z
      //   245: putfield 104	com/baidu/platform/comapi/map/GLTextureView$GLThread:mPaused	Z
      //   248: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   251: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   254: ldc 112
      //   256: new 114	java/lang/StringBuilder
      //   259: dup
      //   260: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   263: ldc 117
      //   265: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: aload_0
      //   269: getfield 104	com/baidu/platform/comapi/map/GLTextureView$GLThread:mPaused	Z
      //   272: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   275: ldc 126
      //   277: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   280: aload_0
      //   281: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   284: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   287: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   290: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   293: pop
      //   294: aload_0
      //   295: getfield 145	com/baidu/platform/comapi/map/GLTextureView$GLThread:mShouldReleaseEglContext	Z
      //   298: ifeq +47 -> 345
      //   301: ldc 112
      //   303: new 114	java/lang/StringBuilder
      //   306: dup
      //   307: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   310: ldc -109
      //   312: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: aload_0
      //   316: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   319: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   322: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   325: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   328: pop
      //   329: aload_0
      //   330: invokespecial 86	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   333: aload_0
      //   334: invokespecial 89	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglContextLocked	()V
      //   337: aload_0
      //   338: iconst_0
      //   339: putfield 145	com/baidu/platform/comapi/map/GLTextureView$GLThread:mShouldReleaseEglContext	Z
      //   342: iconst_1
      //   343: istore 7
      //   345: iload 8
      //   347: istore 11
      //   349: iload 8
      //   351: ifeq +14 -> 365
      //   354: aload_0
      //   355: invokespecial 86	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   358: aload_0
      //   359: invokespecial 89	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglContextLocked	()V
      //   362: iconst_0
      //   363: istore 11
      //   365: iload 21
      //   367: ifeq +42 -> 409
      //   370: aload_0
      //   371: getfield 77	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglSurface	Z
      //   374: ifeq +35 -> 409
      //   377: ldc 112
      //   379: new 114	java/lang/StringBuilder
      //   382: dup
      //   383: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   386: ldc -107
      //   388: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   391: aload_0
      //   392: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   395: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   398: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   401: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   404: pop
      //   405: aload_0
      //   406: invokespecial 86	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   409: iload 21
      //   411: ifeq +84 -> 495
      //   414: aload_0
      //   415: getfield 75	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglContext	Z
      //   418: ifeq +77 -> 495
      //   421: aload_0
      //   422: getfield 55	com/baidu/platform/comapi/map/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   425: invokevirtual 155	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   428: checkcast 6	com/baidu/platform/comapi/map/GLTextureView
      //   431: astore 23
      //   433: aload 23
      //   435: ifnull +558 -> 993
      //   438: aload 23
      //   440: invokestatic 159	com/baidu/platform/comapi/map/GLTextureView:access$900	(Lcom/baidu/platform/comapi/map/GLTextureView;)Z
      //   443: ifeq +550 -> 993
      //   446: iconst_1
      //   447: istore 8
      //   449: iload 8
      //   451: ifeq +12 -> 463
      //   454: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   457: invokevirtual 164	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:shouldReleaseEGLContextWhenPausing	()Z
      //   460: ifeq +35 -> 495
      //   463: aload_0
      //   464: invokespecial 89	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglContextLocked	()V
      //   467: ldc 112
      //   469: new 114	java/lang/StringBuilder
      //   472: dup
      //   473: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   476: ldc -90
      //   478: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   481: aload_0
      //   482: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   485: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   488: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   491: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   494: pop
      //   495: iload 21
      //   497: ifeq +47 -> 544
      //   500: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   503: invokevirtual 169	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:shouldTerminateEGLWhenPausing	()Z
      //   506: ifeq +38 -> 544
      //   509: aload_0
      //   510: getfield 73	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/GLTextureView$EglHelper;
      //   513: invokevirtual 172	com/baidu/platform/comapi/map/GLTextureView$EglHelper:finish	()V
      //   516: ldc 112
      //   518: new 114	java/lang/StringBuilder
      //   521: dup
      //   522: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   525: ldc -82
      //   527: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   530: aload_0
      //   531: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   534: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   537: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   540: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   543: pop
      //   544: aload_0
      //   545: getfield 176	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHasSurface	Z
      //   548: ifne +65 -> 613
      //   551: aload_0
      //   552: getfield 178	com/baidu/platform/comapi/map/GLTextureView$GLThread:mWaitingForSurface	Z
      //   555: ifne +58 -> 613
      //   558: ldc 112
      //   560: new 114	java/lang/StringBuilder
      //   563: dup
      //   564: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   567: ldc -76
      //   569: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   572: aload_0
      //   573: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   576: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   579: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   582: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   585: pop
      //   586: aload_0
      //   587: getfield 77	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglSurface	Z
      //   590: ifeq +7 -> 597
      //   593: aload_0
      //   594: invokespecial 86	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   597: aload_0
      //   598: iconst_1
      //   599: putfield 178	com/baidu/platform/comapi/map/GLTextureView$GLThread:mWaitingForSurface	Z
      //   602: aload_0
      //   603: iconst_0
      //   604: putfield 182	com/baidu/platform/comapi/map/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   607: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   610: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   613: aload_0
      //   614: getfield 176	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHasSurface	Z
      //   617: ifeq +49 -> 666
      //   620: aload_0
      //   621: getfield 178	com/baidu/platform/comapi/map/GLTextureView$GLThread:mWaitingForSurface	Z
      //   624: ifeq +42 -> 666
      //   627: ldc 112
      //   629: new 114	java/lang/StringBuilder
      //   632: dup
      //   633: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   636: ldc -72
      //   638: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   641: aload_0
      //   642: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   645: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   648: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   651: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   654: pop
      //   655: aload_0
      //   656: iconst_0
      //   657: putfield 178	com/baidu/platform/comapi/map/GLTextureView$GLThread:mWaitingForSurface	Z
      //   660: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   663: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   666: iload 6
      //   668: istore 12
      //   670: iload 5
      //   672: istore 13
      //   674: iload 6
      //   676: ifeq +48 -> 724
      //   679: ldc 112
      //   681: new 114	java/lang/StringBuilder
      //   684: dup
      //   685: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   688: ldc -70
      //   690: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   693: aload_0
      //   694: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   697: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   700: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   703: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   706: pop
      //   707: iconst_0
      //   708: istore 13
      //   710: iconst_0
      //   711: istore 12
      //   713: aload_0
      //   714: iconst_1
      //   715: putfield 188	com/baidu/platform/comapi/map/GLTextureView$GLThread:mRenderComplete	Z
      //   718: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   721: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   724: iload 7
      //   726: istore 14
      //   728: iload 4
      //   730: istore 16
      //   732: iload_1
      //   733: istore 17
      //   735: iload_2
      //   736: istore 18
      //   738: iload_3
      //   739: istore 15
      //   741: aload_0
      //   742: invokespecial 191	com/baidu/platform/comapi/map/GLTextureView$GLThread:readyToDraw	()Z
      //   745: ifeq +316 -> 1061
      //   748: iload 7
      //   750: istore 6
      //   752: iload 4
      //   754: istore 5
      //   756: aload_0
      //   757: getfield 75	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglContext	Z
      //   760: ifne +15 -> 775
      //   763: iload 7
      //   765: ifeq +234 -> 999
      //   768: iconst_0
      //   769: istore 6
      //   771: iload 4
      //   773: istore 5
      //   775: iload_1
      //   776: istore 8
      //   778: iload_2
      //   779: istore 4
      //   781: iload_3
      //   782: istore 7
      //   784: aload_0
      //   785: getfield 75	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglContext	Z
      //   788: ifeq +33 -> 821
      //   791: iload_1
      //   792: istore 8
      //   794: iload_2
      //   795: istore 4
      //   797: iload_3
      //   798: istore 7
      //   800: aload_0
      //   801: getfield 77	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglSurface	Z
      //   804: ifne +17 -> 821
      //   807: aload_0
      //   808: iconst_1
      //   809: putfield 77	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglSurface	Z
      //   812: iconst_1
      //   813: istore 8
      //   815: iconst_1
      //   816: istore 4
      //   818: iconst_1
      //   819: istore 7
      //   821: iload 6
      //   823: istore 14
      //   825: iload 5
      //   827: istore 16
      //   829: iload 8
      //   831: istore 17
      //   833: iload 4
      //   835: istore 18
      //   837: iload 7
      //   839: istore 15
      //   841: aload_0
      //   842: getfield 77	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglSurface	Z
      //   845: ifeq +216 -> 1061
      //   848: iload 8
      //   850: istore_2
      //   851: aload_0
      //   852: getfield 45	com/baidu/platform/comapi/map/GLTextureView$GLThread:mSizeChanged	Z
      //   855: ifeq +56 -> 911
      //   858: iconst_1
      //   859: istore 7
      //   861: aload_0
      //   862: getfield 47	com/baidu/platform/comapi/map/GLTextureView$GLThread:mWidth	I
      //   865: istore 9
      //   867: aload_0
      //   868: getfield 49	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHeight	I
      //   871: istore 10
      //   873: iconst_1
      //   874: istore 13
      //   876: ldc 112
      //   878: new 114	java/lang/StringBuilder
      //   881: dup
      //   882: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   885: ldc -63
      //   887: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   890: aload_0
      //   891: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   894: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   897: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   900: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   903: pop
      //   904: iconst_1
      //   905: istore_2
      //   906: aload_0
      //   907: iconst_0
      //   908: putfield 45	com/baidu/platform/comapi/map/GLTextureView$GLThread:mSizeChanged	Z
      //   911: aload_0
      //   912: iconst_0
      //   913: putfield 51	com/baidu/platform/comapi/map/GLTextureView$GLThread:mRequestRender	Z
      //   916: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   919: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   922: iload 6
      //   924: istore 8
      //   926: iload 5
      //   928: istore_1
      //   929: iload_2
      //   930: istore 6
      //   932: iload 4
      //   934: istore_2
      //   935: aload 22
      //   937: astore 23
      //   939: iload 10
      //   941: istore 19
      //   943: iload 11
      //   945: istore_3
      //   946: iload 7
      //   948: istore 5
      //   950: iload 9
      //   952: istore 20
      //   954: iload 13
      //   956: istore 11
      //   958: goto -791 -> 167
      //   961: astore 22
      //   963: aload 25
      //   965: monitorexit
      //   966: aload 22
      //   968: athrow
      //   969: astore 23
      //   971: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   974: astore 22
      //   976: aload 22
      //   978: monitorenter
      //   979: aload_0
      //   980: invokespecial 86	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   983: aload_0
      //   984: invokespecial 89	com/baidu/platform/comapi/map/GLTextureView$GLThread:stopEglContextLocked	()V
      //   987: aload 22
      //   989: monitorexit
      //   990: aload 23
      //   992: athrow
      //   993: iconst_0
      //   994: istore 8
      //   996: goto -547 -> 449
      //   999: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1002: aload_0
      //   1003: invokevirtual 197	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:tryAcquireEglContextLocked	(Lcom/baidu/platform/comapi/map/GLTextureView$GLThread;)Z
      //   1006: istore 21
      //   1008: iload 7
      //   1010: istore 6
      //   1012: iload 4
      //   1014: istore 5
      //   1016: iload 21
      //   1018: ifeq -243 -> 775
      //   1021: aload_0
      //   1022: getfield 73	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/GLTextureView$EglHelper;
      //   1025: invokevirtual 200	com/baidu/platform/comapi/map/GLTextureView$EglHelper:start	()V
      //   1028: aload_0
      //   1029: iconst_1
      //   1030: putfield 75	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglContext	Z
      //   1033: iconst_1
      //   1034: istore 5
      //   1036: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1039: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   1042: iload 7
      //   1044: istore 6
      //   1046: goto -271 -> 775
      //   1049: astore 22
      //   1051: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1054: aload_0
      //   1055: invokevirtual 204	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:releaseEglContextLocked	(Lcom/baidu/platform/comapi/map/GLTextureView$GLThread;)V
      //   1058: aload 22
      //   1060: athrow
      //   1061: ldc 112
      //   1063: new 114	java/lang/StringBuilder
      //   1066: dup
      //   1067: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   1070: ldc -50
      //   1072: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1075: aload_0
      //   1076: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   1079: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1082: ldc -48
      //   1084: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1087: aload_0
      //   1088: getfield 75	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglContext	Z
      //   1091: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1094: ldc -46
      //   1096: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1099: aload_0
      //   1100: getfield 77	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHaveEglSurface	Z
      //   1103: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1106: ldc -44
      //   1108: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1111: aload_0
      //   1112: getfield 104	com/baidu/platform/comapi/map/GLTextureView$GLThread:mPaused	Z
      //   1115: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1118: ldc -42
      //   1120: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1123: aload_0
      //   1124: getfield 176	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHasSurface	Z
      //   1127: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1130: ldc -40
      //   1132: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1135: aload_0
      //   1136: getfield 182	com/baidu/platform/comapi/map/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   1139: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1142: ldc -38
      //   1144: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1147: aload_0
      //   1148: getfield 178	com/baidu/platform/comapi/map/GLTextureView$GLThread:mWaitingForSurface	Z
      //   1151: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1154: ldc -36
      //   1156: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1159: aload_0
      //   1160: getfield 47	com/baidu/platform/comapi/map/GLTextureView$GLThread:mWidth	I
      //   1163: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1166: ldc -31
      //   1168: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1171: aload_0
      //   1172: getfield 49	com/baidu/platform/comapi/map/GLTextureView$GLThread:mHeight	I
      //   1175: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1178: ldc -29
      //   1180: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1183: aload_0
      //   1184: getfield 51	com/baidu/platform/comapi/map/GLTextureView$GLThread:mRequestRender	Z
      //   1187: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1190: ldc -27
      //   1192: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1195: aload_0
      //   1196: getfield 53	com/baidu/platform/comapi/map/GLTextureView$GLThread:mRenderMode	I
      //   1199: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1202: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1205: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   1208: pop
      //   1209: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1212: invokevirtual 232	java/lang/Object:wait	()V
      //   1215: iload 14
      //   1217: istore 7
      //   1219: iload 16
      //   1221: istore 4
      //   1223: iload 17
      //   1225: istore_1
      //   1226: iload 18
      //   1228: istore_2
      //   1229: iload 12
      //   1231: istore 6
      //   1233: iload 11
      //   1235: istore 8
      //   1237: iload 15
      //   1239: istore_3
      //   1240: iload 13
      //   1242: istore 5
      //   1244: goto -1170 -> 74
      //   1247: iload 6
      //   1249: istore 14
      //   1251: iload 6
      //   1253: ifeq +90 -> 1343
      //   1256: ldc 112
      //   1258: ldc -22
      //   1260: invokestatic 237	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   1263: pop
      //   1264: aload_0
      //   1265: getfield 73	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/GLTextureView$EglHelper;
      //   1268: invokevirtual 240	com/baidu/platform/comapi/map/GLTextureView$EglHelper:createSurface	()Z
      //   1271: ifne +499 -> 1770
      //   1274: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1277: astore 22
      //   1279: aload 22
      //   1281: monitorenter
      //   1282: aload_0
      //   1283: iconst_1
      //   1284: putfield 182	com/baidu/platform/comapi/map/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   1287: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1290: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   1293: aload 22
      //   1295: monitorexit
      //   1296: iload 8
      //   1298: istore 13
      //   1300: iload_1
      //   1301: istore 4
      //   1303: iload 6
      //   1305: istore_1
      //   1306: iload 12
      //   1308: istore 6
      //   1310: aload 23
      //   1312: astore 22
      //   1314: iload 19
      //   1316: istore 10
      //   1318: iload_3
      //   1319: istore 7
      //   1321: iload 5
      //   1323: istore_3
      //   1324: iload 20
      //   1326: istore 9
      //   1328: iload 11
      //   1330: istore 5
      //   1332: goto -1274 -> 58
      //   1335: astore 23
      //   1337: aload 22
      //   1339: monitorexit
      //   1340: aload 23
      //   1342: athrow
      //   1343: iload_2
      //   1344: istore 15
      //   1346: aload 24
      //   1348: astore 25
      //   1350: iload_2
      //   1351: ifeq +26 -> 1377
      //   1354: aload_0
      //   1355: getfield 73	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/GLTextureView$EglHelper;
      //   1358: invokevirtual 244	com/baidu/platform/comapi/map/GLTextureView$EglHelper:createGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1361: checkcast 246	javax/microedition/khronos/opengles/GL10
      //   1364: astore 25
      //   1366: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1369: aload 25
      //   1371: invokevirtual 250	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:checkGLDriver	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   1374: iconst_0
      //   1375: istore 15
      //   1377: iload_1
      //   1378: istore 16
      //   1380: iload_1
      //   1381: ifeq +50 -> 1431
      //   1384: ldc 112
      //   1386: ldc -4
      //   1388: invokestatic 237	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   1391: pop
      //   1392: aload_0
      //   1393: getfield 55	com/baidu/platform/comapi/map/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1396: invokevirtual 155	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1399: checkcast 6	com/baidu/platform/comapi/map/GLTextureView
      //   1402: astore 22
      //   1404: aload 22
      //   1406: ifnull +370 -> 1776
      //   1409: aload 22
      //   1411: invokestatic 256	com/baidu/platform/comapi/map/GLTextureView:access$1000	(Lcom/baidu/platform/comapi/map/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1414: aload 25
      //   1416: aload_0
      //   1417: getfield 73	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/GLTextureView$EglHelper;
      //   1420: getfield 260	com/baidu/platform/comapi/map/GLTextureView$EglHelper:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1423: invokeinterface 265 3 0
      //   1428: goto +348 -> 1776
      //   1431: iload 5
      //   1433: istore 17
      //   1435: iload 5
      //   1437: ifeq +83 -> 1520
      //   1440: ldc 112
      //   1442: new 114	java/lang/StringBuilder
      //   1445: dup
      //   1446: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   1449: ldc_w 267
      //   1452: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1455: iload 20
      //   1457: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1460: ldc_w 269
      //   1463: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1466: iload 19
      //   1468: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1471: ldc_w 271
      //   1474: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1477: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1480: invokestatic 237	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   1483: pop
      //   1484: aload_0
      //   1485: getfield 55	com/baidu/platform/comapi/map/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1488: invokevirtual 155	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1491: checkcast 6	com/baidu/platform/comapi/map/GLTextureView
      //   1494: astore 22
      //   1496: aload 22
      //   1498: ifnull +284 -> 1782
      //   1501: aload 22
      //   1503: invokestatic 256	com/baidu/platform/comapi/map/GLTextureView:access$1000	(Lcom/baidu/platform/comapi/map/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1506: aload 25
      //   1508: iload 20
      //   1510: iload 19
      //   1512: invokeinterface 275 4 0
      //   1517: goto +265 -> 1782
      //   1520: aload_0
      //   1521: getfield 55	com/baidu/platform/comapi/map/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1524: invokevirtual 155	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1527: checkcast 6	com/baidu/platform/comapi/map/GLTextureView
      //   1530: astore 22
      //   1532: aload 22
      //   1534: ifnull +15 -> 1549
      //   1537: aload 22
      //   1539: invokestatic 256	com/baidu/platform/comapi/map/GLTextureView:access$1000	(Lcom/baidu/platform/comapi/map/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1542: aload 25
      //   1544: invokeinterface 278 2 0
      //   1549: aload_0
      //   1550: getfield 73	com/baidu/platform/comapi/map/GLTextureView$GLThread:mEglHelper	Lcom/baidu/platform/comapi/map/GLTextureView$EglHelper;
      //   1553: invokevirtual 282	com/baidu/platform/comapi/map/GLTextureView$EglHelper:swap	()I
      //   1556: istore_1
      //   1557: iload_3
      //   1558: istore 18
      //   1560: iload_1
      //   1561: lookupswitch	default:+227->1788, 12288:+61->1622, 12302:+158->1719
      //   1588: ldc 112
      //   1590: ldc_w 284
      //   1593: iload_1
      //   1594: invokestatic 288	com/baidu/platform/comapi/map/GLTextureView$EglHelper:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1597: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1600: astore 22
      //   1602: aload 22
      //   1604: monitorenter
      //   1605: aload_0
      //   1606: iconst_1
      //   1607: putfield 182	com/baidu/platform/comapi/map/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   1610: invokestatic 81	com/baidu/platform/comapi/map/GLTextureView:access$800	()Lcom/baidu/platform/comapi/map/GLTextureView$GLThreadManager;
      //   1613: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   1616: aload 22
      //   1618: monitorexit
      //   1619: iload_3
      //   1620: istore 18
      //   1622: iload 8
      //   1624: istore 13
      //   1626: iload 16
      //   1628: istore 4
      //   1630: iload 14
      //   1632: istore_1
      //   1633: iload 15
      //   1635: istore_2
      //   1636: iload 12
      //   1638: istore 6
      //   1640: aload 23
      //   1642: astore 22
      //   1644: aload 25
      //   1646: astore 24
      //   1648: iload 19
      //   1650: istore 10
      //   1652: iload 18
      //   1654: istore 7
      //   1656: iload 17
      //   1658: istore_3
      //   1659: iload 20
      //   1661: istore 9
      //   1663: iload 11
      //   1665: istore 5
      //   1667: iload 11
      //   1669: ifeq -1611 -> 58
      //   1672: iconst_1
      //   1673: istore 6
      //   1675: iload 8
      //   1677: istore 13
      //   1679: iload 16
      //   1681: istore 4
      //   1683: iload 14
      //   1685: istore_1
      //   1686: iload 15
      //   1688: istore_2
      //   1689: aload 23
      //   1691: astore 22
      //   1693: aload 25
      //   1695: astore 24
      //   1697: iload 19
      //   1699: istore 10
      //   1701: iload 18
      //   1703: istore 7
      //   1705: iload 17
      //   1707: istore_3
      //   1708: iload 20
      //   1710: istore 9
      //   1712: iload 11
      //   1714: istore 5
      //   1716: goto -1658 -> 58
      //   1719: ldc 112
      //   1721: new 114	java/lang/StringBuilder
      //   1724: dup
      //   1725: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   1728: ldc_w 290
      //   1731: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1734: aload_0
      //   1735: invokevirtual 130	com/baidu/platform/comapi/map/GLTextureView$GLThread:getId	()J
      //   1738: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1741: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1744: invokestatic 143	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
      //   1747: pop
      //   1748: iconst_1
      //   1749: istore 18
      //   1751: goto -129 -> 1622
      //   1754: astore 23
      //   1756: aload 22
      //   1758: monitorexit
      //   1759: aload 23
      //   1761: athrow
      //   1762: astore 23
      //   1764: aload 22
      //   1766: monitorexit
      //   1767: aload 23
      //   1769: athrow
      //   1770: iconst_0
      //   1771: istore 14
      //   1773: goto -430 -> 1343
      //   1776: iconst_0
      //   1777: istore 16
      //   1779: goto -348 -> 1431
      //   1782: iconst_0
      //   1783: istore 17
      //   1785: goto -265 -> 1520
      //   1788: goto -200 -> 1588
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1791	0	this	GLThread
      //   32	1654	1	i	int
      //   34	1655	2	j	int
      //   39	1669	3	k	int
      //   29	1653	4	m	int
      //   41	1674	5	n	int
      //   44	1630	6	i1	int
      //   36	1668	7	i2	int
      //   68	1608	8	i3	int
      //   50	1661	9	i4	int
      //   53	1647	10	i5	int
      //   137	1576	11	i6	int
      //   155	1482	12	i7	int
      //   47	1631	13	i8	int
      //   726	1046	14	i9	int
      //   739	948	15	i10	int
      //   730	1048	16	i11	int
      //   733	1051	17	i12	int
      //   736	1014	18	i13	int
      //   151	1547	19	i14	int
      //   141	1568	20	i15	int
      //   221	796	21	bool	boolean
      //   961	6	22	localObject1	Object
      //   1049	10	22	localRuntimeException	RuntimeException
      //   104	6	23	localObject3	Object
      //   133	805	23	localObject4	Object
      //   969	342	23	localObject5	Object
      //   1335	355	23	localObject6	Object
      //   1754	6	23	localObject7	Object
      //   1762	6	23	localObject8	Object
      //   26	1670	24	localObject9	Object
      //   61	1633	25	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   92	103	104	finally
      //   106	109	104	finally
      //   74	84	961	finally
      //   112	135	961	finally
      //   167	170	961	finally
      //   223	294	961	finally
      //   294	342	961	finally
      //   354	362	961	finally
      //   370	409	961	finally
      //   414	433	961	finally
      //   438	446	961	finally
      //   454	463	961	finally
      //   463	495	961	finally
      //   500	544	961	finally
      //   544	597	961	finally
      //   597	613	961	finally
      //   613	666	961	finally
      //   679	707	961	finally
      //   713	724	961	finally
      //   741	748	961	finally
      //   756	763	961	finally
      //   784	791	961	finally
      //   800	812	961	finally
      //   841	848	961	finally
      //   851	858	961	finally
      //   861	873	961	finally
      //   876	904	961	finally
      //   906	911	961	finally
      //   911	922	961	finally
      //   963	966	961	finally
      //   999	1008	961	finally
      //   1021	1028	961	finally
      //   1028	1033	961	finally
      //   1036	1042	961	finally
      //   1051	1061	961	finally
      //   1061	1215	961	finally
      //   58	66	969	finally
      //   175	182	969	finally
      //   966	969	969	finally
      //   1256	1282	969	finally
      //   1340	1343	969	finally
      //   1354	1374	969	finally
      //   1384	1404	969	finally
      //   1409	1428	969	finally
      //   1440	1496	969	finally
      //   1501	1517	969	finally
      //   1520	1532	969	finally
      //   1537	1549	969	finally
      //   1549	1557	969	finally
      //   1588	1605	969	finally
      //   1719	1748	969	finally
      //   1759	1762	969	finally
      //   1021	1028	1049	java/lang/RuntimeException
      //   1282	1296	1335	finally
      //   1337	1340	1335	finally
      //   1605	1619	1754	finally
      //   1756	1759	1754	finally
      //   979	990	1762	finally
      //   1764	1767	1762	finally
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
        GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
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
      synchronized (GLTextureView.sGLThreadManager)
      {
        int i = this.mRenderMode;
        return i;
      }
    }
    
    public void onPause()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        Log.i("GLThread", "onPause tid=" + getId());
        this.mRequestPaused = true;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (!this.mPaused))
          {
            Log.i("Main thread", "onPause waiting for mPaused.");
            try
            {
              GLTextureView.sGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    
    public void onResume()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        Log.i("GLThread", "onResume tid=" + getId());
        this.mRequestPaused = false;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (this.mPaused) && (!this.mRenderComplete))
          {
            Log.i("Main thread", "onResume waiting for !mPaused.");
            try
            {
              GLTextureView.sGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    
    public void onWindowResize(int paramInt1, int paramInt2)
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        this.mSizeChanged = true;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete) && (ableToDraw()))
          {
            Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
            try
            {
              GLTextureView.sGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
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
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mEventQueue.add(paramRunnable);
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void requestExitAndWait()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mShouldExit = true;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          boolean bool = this.mExited;
          if (!bool) {
            try
            {
              GLTextureView.sGLThreadManager.wait();
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
      GLTextureView.sGLThreadManager.notifyAll();
    }
    
    public void requestRender()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mRequestRender = true;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void run()
    {
      setName("GLThread " + getId());
      Log.i("GLThread", "starting tid=" + getId());
      try
      {
        guardedRun();
        GLTextureView.sGLThreadManager.threadExiting(this);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException = localInterruptedException;
        GLTextureView.sGLThreadManager.threadExiting(this);
        return;
      }
      finally
      {
        localObject = finally;
        GLTextureView.sGLThreadManager.threadExiting(this);
        throw ((Throwable)localObject);
      }
    }
    
    public void setRenderMode(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mRenderMode = paramInt;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void surfaceCreated()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        Log.i("GLThread", "surfaceCreated tid=" + getId());
        this.mHasSurface = true;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if (this.mWaitingForSurface)
          {
            boolean bool = this.mExited;
            if (!bool) {
              try
              {
                GLTextureView.sGLThreadManager.wait();
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
      synchronized (GLTextureView.sGLThreadManager)
      {
        Log.i("GLThread", "surfaceDestroyed tid=" + getId());
        this.mHasSurface = false;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if (!this.mWaitingForSurface)
          {
            boolean bool = this.mExited;
            if (!bool) {
              try
              {
                GLTextureView.sGLThreadManager.wait();
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
    private GLTextureView.GLThread mEglOwner;
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
        Log.w(TAG, "checkGLESVersion mGLESVersion = " + this.mGLESVersion + " mMultipleGLESContextsAllowed = " + this.mMultipleGLESContextsAllowed);
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
      //   5: getfield 129	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mGLESDriverCheckComplete	Z
      //   8: ifne +115 -> 123
      //   11: aload_0
      //   12: invokespecial 131	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:checkGLESVersion	()V
      //   15: aload_1
      //   16: sipush 7937
      //   19: invokeinterface 137 2 0
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 95	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mGLESVersion	I
      //   29: ldc 16
      //   31: if_icmpge +23 -> 54
      //   34: aload_1
      //   35: ldc 19
      //   37: invokevirtual 141	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   40: ifne +86 -> 126
      //   43: iconst_1
      //   44: istore_2
      //   45: aload_0
      //   46: iload_2
      //   47: putfield 97	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mMultipleGLESContextsAllowed	Z
      //   50: aload_0
      //   51: invokevirtual 144	java/lang/Object:notifyAll	()V
      //   54: aload_0
      //   55: getfield 97	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mMultipleGLESContextsAllowed	Z
      //   58: ifne +73 -> 131
      //   61: iload_3
      //   62: istore_2
      //   63: aload_0
      //   64: iload_2
      //   65: putfield 146	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mLimitedGLESContexts	Z
      //   68: getstatic 34	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:TAG	Ljava/lang/String;
      //   71: new 99	java/lang/StringBuilder
      //   74: dup
      //   75: invokespecial 100	java/lang/StringBuilder:<init>	()V
      //   78: ldc -108
      //   80: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: aload_1
      //   84: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: ldc -106
      //   89: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: aload_0
      //   93: getfield 97	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mMultipleGLESContextsAllowed	Z
      //   96: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   99: ldc -104
      //   101: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: aload_0
      //   105: getfield 146	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mLimitedGLESContexts	Z
      //   108: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   111: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   114: invokestatic 124	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   117: pop
      //   118: aload_0
      //   119: iconst_1
      //   120: putfield 129	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mGLESDriverCheckComplete	Z
      //   123: aload_0
      //   124: monitorexit
      //   125: return
      //   126: iconst_0
      //   127: istore_2
      //   128: goto -83 -> 45
      //   131: iconst_0
      //   132: istore_2
      //   133: goto -70 -> 63
      //   136: astore_1
      //   137: aload_0
      //   138: monitorexit
      //   139: aload_1
      //   140: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	141	0	this	GLThreadManager
      //   0	141	1	paramGL10	javax.microedition.khronos.opengles.GL10
      //   44	89	2	bool1	boolean
      //   1	61	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	43	136	finally
      //   45	54	136	finally
      //   54	61	136	finally
      //   63	123	136	finally
    }
    
    public void releaseEglContextLocked(GLTextureView.GLThread paramGLThread)
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
      //   3: invokespecial 131	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:checkGLESVersion	()V
      //   6: aload_0
      //   7: getfield 97	com/baidu/platform/comapi/map/GLTextureView$GLThreadManager:mMultipleGLESContextsAllowed	Z
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
    
    public void threadExiting(GLTextureView.GLThread paramGLThread)
    {
      try
      {
        Log.i("GLThread", "exiting tid=" + paramGLThread.getId());
        GLTextureView.GLThread.access$1102(paramGLThread, true);
        if (this.mEglOwner == paramGLThread) {
          this.mEglOwner = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    public boolean tryAcquireEglContextLocked(GLTextureView.GLThread paramGLThread)
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
    extends GLTextureView.ComponentSizeChooser
  {
    public SimpleEGLConfigChooser(boolean paramBoolean) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/GLTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */