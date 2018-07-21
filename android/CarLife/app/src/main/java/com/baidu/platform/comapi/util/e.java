package com.baidu.platform.comapi.util;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class e
{
  static final int a = 100;
  
  public static boolean a()
  {
    try
    {
      EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
      EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      localEGL10.eglInitialize(localEGLDisplay, new int[2]);
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[100];
      localEGL10.eglGetConfigs(localEGLDisplay, arrayOfEGLConfig, 100, new int[100]);
      int[] arrayOfInt1 = new int[4];
      int i = 0;
      while (i < 100)
      {
        int[] arrayOfInt2 = new int[1];
        if (arrayOfEGLConfig[i] == null) {
          break;
        }
        localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12324, arrayOfInt2);
        arrayOfInt1[0] = arrayOfInt2[0];
        localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12323, arrayOfInt2);
        arrayOfInt1[1] = arrayOfInt2[0];
        localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12322, arrayOfInt2);
        arrayOfInt1[2] = arrayOfInt2[0];
        localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12325, arrayOfInt2);
        arrayOfInt1[3] = arrayOfInt2[0];
        if ((arrayOfInt1[0] != 5) || (arrayOfInt1[1] != 6) || (arrayOfInt1[2] != 5) || (arrayOfInt1[3] != 24))
        {
          if ((arrayOfInt1[0] == 8) && (arrayOfInt1[1] == 8) && (arrayOfInt1[2] == 8))
          {
            int j = arrayOfInt1[3];
            if (j != 24) {}
          }
        }
        else {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[100];
    int[] arrayOfInt = new int[1];
    return (localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 }, arrayOfEGLConfig, 100, arrayOfInt)) && (arrayOfInt[0] > 0);
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[100];
    localEGL10.eglGetConfigs(localEGLDisplay, arrayOfEGLConfig, 100, new int[100]);
    int i = 0;
    while (i < 100)
    {
      int[] arrayOfInt = new int[1];
      if (arrayOfEGLConfig[i] == null) {
        break;
      }
      localStringBuilder.append(String.format("conf[%d] = %s\n", new Object[] { Integer.valueOf(i), arrayOfEGLConfig[i].toString() }));
      localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12324, arrayOfInt);
      localStringBuilder.append(String.format("EGL_RED_SIZE  = %d\n", new Object[] { Integer.valueOf(arrayOfInt[0]) }));
      localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12322, arrayOfInt);
      localStringBuilder.append(String.format("EGL_BLUE_SIZE  = %d\n", new Object[] { Integer.valueOf(arrayOfInt[0]) }));
      localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12323, arrayOfInt);
      localStringBuilder.append(String.format("EGL_GREEN_SIZE  = %d\n", new Object[] { Integer.valueOf(arrayOfInt[0]) }));
      localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12321, arrayOfInt);
      localStringBuilder.append(String.format("EGL_ALPHA_SIZE  = %d\n", new Object[] { Integer.valueOf(arrayOfInt[0]) }));
      localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12325, arrayOfInt);
      localStringBuilder.append(String.format("EGL_DEPTH_SIZE  = %d\n", new Object[] { Integer.valueOf(arrayOfInt[0]) }));
      localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12424, arrayOfInt);
      localStringBuilder.append(String.format("EGL_ALPHA_FORMAT  = %d\n", new Object[] { Integer.valueOf(arrayOfInt[0]) }));
      localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12350, arrayOfInt);
      localStringBuilder.append(String.format("EGL_ALPHA_MASK_SIZE  = %d\n", new Object[] { Integer.valueOf(arrayOfInt[0]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */