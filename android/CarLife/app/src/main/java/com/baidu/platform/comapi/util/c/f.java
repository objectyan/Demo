package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class f
  implements g
{
  private static int c = 0;
  private String a;
  private String b;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    paramContext = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = paramContext.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (!paramContext.eglInitialize(localEGLDisplay, new int[2])) {
      throw new RuntimeException("eglInitialize failed");
    }
    Object localObject = new d(true);
    c localc = new c(null);
    localObject = localc.createContext(paramContext, localEGLDisplay, ((GLSurfaceView.EGLConfigChooser)localObject).chooseConfig(paramContext, localEGLDisplay));
    GL10 localGL10 = (GL10)((EGLContext)localObject).getGL();
    this.b = localGL10.glGetString(7938);
    this.a = localGL10.glGetString(7937);
    localc.destroyContext(paramContext, localEGLDisplay, (EGLContext)localObject);
    if (this.b == null) {
      this.b = "";
    }
    if (this.a == null) {
      this.a = "";
    }
  }
  
  public String b()
  {
    return this.b;
  }
  
  private static abstract class a
    implements GLSurfaceView.EGLConfigChooser
  {
    protected int[] a = a(paramArrayOfInt);
    
    public a(int[] paramArrayOfInt) {}
    
    private int[] a(int[] paramArrayOfInt)
    {
      if (f.c() != 2) {
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
    
    abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
  }
  
  private static class b
    extends f.a
  {
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    private int[] h = new int[1];
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super();
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
      this.g = paramInt6;
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.h)) {
        paramInt2 = this.h[0];
      }
      return paramInt2;
    }
    
    public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((k >= this.f) && (m >= this.g))
        {
          k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((k == this.b) && (m == this.c) && (n == this.d) && (i1 == this.e)) {
            return localEGLConfig;
          }
        }
        i += 1;
      }
      return null;
    }
  }
  
  private class c
    implements GLSurfaceView.EGLContextFactory
  {
    private int b = 12440;
    
    private c() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.b;
      arrayOfInt[1] = f.c();
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (f.c() != 0) {}
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        arrayOfInt = null;
      }
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {}
    }
  }
  
  private static class d
    extends f.b
  {
    public d(boolean paramBoolean) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */