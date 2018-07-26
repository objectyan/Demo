package com.baidu.navisdk.util.common;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class EglConfigUtils {
    static final int CONFIG_SIZE = 100;

    private static String getEglConfigOnDevice() {
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

    public static boolean isSupport24DepthSize() {
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

    public static boolean isSupportConfig(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay dpy = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl.eglInitialize(dpy, new int[2]);
        int[] configs = new int[1];
        egl.eglGetConfigs(dpy, null, 0, configs);
        int num_conf = configs[0];
        if (num_conf <= 0) {
            return false;
        }
        EGLConfig[] conf = new EGLConfig[num_conf];
        int[] value = new int[1];
        egl.eglGetConfigs(dpy, conf, num_conf, configs);
        int i = 0;
        while (i < num_conf) {
            if (conf[i] != null) {
                egl.eglGetConfigAttrib(dpy, conf[i], 12324, value);
                if (value[0] == redSize) {
                    egl.eglGetConfigAttrib(dpy, conf[i], 12323, value);
                    if (value[0] == greenSize) {
                        egl.eglGetConfigAttrib(dpy, conf[i], 12322, value);
                        if (value[0] == blueSize) {
                            if (alphaSize > 0) {
                                egl.eglGetConfigAttrib(dpy, conf[i], 12321, value);
                                if (value[0] != alphaSize) {
                                    continue;
                                }
                            }
                            if (depthSize > 0) {
                                egl.eglGetConfigAttrib(dpy, conf[i], 12325, value);
                                if (value[0] != depthSize) {
                                    continue;
                                }
                            }
                            if (stencilSize <= 0) {
                                break;
                            }
                            egl.eglGetConfigAttrib(dpy, conf[i], 12326, value);
                            if (value[0] == stencilSize) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        if (i == num_conf) {
            return false;
        }
        if (!egl.eglChooseConfig(dpy, new int[]{12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344}, null, 0, configs) || configs[0] <= 0) {
            return false;
        }
        return true;
    }
}
