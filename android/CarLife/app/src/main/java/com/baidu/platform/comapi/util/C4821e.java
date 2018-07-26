package com.baidu.platform.comapi.util;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: EglConfigUtils */
/* renamed from: com.baidu.platform.comapi.util.e */
public class C4821e {
    /* renamed from: a */
    static final int f19964a = 100;

    /* renamed from: b */
    private static String m16004b() {
        StringBuilder sb = new StringBuilder();
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay dpy = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl.eglInitialize(dpy, new int[2]);
        EGLConfig[] conf = new EGLConfig[100];
        egl.eglGetConfigs(dpy, conf, 100, new int[100]);
        for (int i = 0; i < 100; i++) {
            int[] value = new int[1];
            if (conf[i] == null) {
                break;
            }
            sb.append(String.format("conf[%d] = %s\n", new Object[]{Integer.valueOf(i), conf[i].toString()}));
            egl.eglGetConfigAttrib(dpy, conf[i], 12324, value);
            sb.append(String.format("EGL_RED_SIZE  = %d\n", new Object[]{Integer.valueOf(value[0])}));
            egl.eglGetConfigAttrib(dpy, conf[i], 12322, value);
            sb.append(String.format("EGL_BLUE_SIZE  = %d\n", new Object[]{Integer.valueOf(value[0])}));
            egl.eglGetConfigAttrib(dpy, conf[i], 12323, value);
            sb.append(String.format("EGL_GREEN_SIZE  = %d\n", new Object[]{Integer.valueOf(value[0])}));
            egl.eglGetConfigAttrib(dpy, conf[i], 12321, value);
            sb.append(String.format("EGL_ALPHA_SIZE  = %d\n", new Object[]{Integer.valueOf(value[0])}));
            egl.eglGetConfigAttrib(dpy, conf[i], 12325, value);
            sb.append(String.format("EGL_DEPTH_SIZE  = %d\n", new Object[]{Integer.valueOf(value[0])}));
            egl.eglGetConfigAttrib(dpy, conf[i], 12424, value);
            sb.append(String.format("EGL_ALPHA_FORMAT  = %d\n", new Object[]{Integer.valueOf(value[0])}));
            egl.eglGetConfigAttrib(dpy, conf[i], 12350, value);
            sb.append(String.format("EGL_ALPHA_MASK_SIZE  = %d\n", new Object[]{Integer.valueOf(value[0])}));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m16002a() {
        try {
            EGL10 egl = (EGL10) EGLContext.getEGL();
            EGLDisplay dpy = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl.eglInitialize(dpy, new int[2]);
            EGLConfig[] conf = new EGLConfig[100];
            egl.eglGetConfigs(dpy, conf, 100, new int[100]);
            int[] rgbdValue = new int[4];
            for (int i = 0; i < 100; i++) {
                int[] value = new int[1];
                if (conf[i] == null) {
                    break;
                }
                egl.eglGetConfigAttrib(dpy, conf[i], 12324, value);
                rgbdValue[0] = value[0];
                egl.eglGetConfigAttrib(dpy, conf[i], 12323, value);
                rgbdValue[1] = value[0];
                egl.eglGetConfigAttrib(dpy, conf[i], 12322, value);
                rgbdValue[2] = value[0];
                egl.eglGetConfigAttrib(dpy, conf[i], 12325, value);
                rgbdValue[3] = value[0];
                if (rgbdValue[0] == 5 && rgbdValue[1] == 6 && rgbdValue[2] == 5 && rgbdValue[3] == 24) {
                    return true;
                }
                if (rgbdValue[0] == 8 && rgbdValue[1] == 8 && rgbdValue[2] == 8 && rgbdValue[3] == 24) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m16003a(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay dpy = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl.eglInitialize(dpy, new int[2]);
        int[] num_conf = new int[1];
        if (!egl.eglChooseConfig(dpy, new int[]{12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344}, new EGLConfig[100], 100, num_conf) || num_conf[0] <= 0) {
            return false;
        }
        return true;
    }
}
