package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLInfo */
/* renamed from: com.baidu.platform.comapi.util.c.f */
public class C4813f implements C4800g {
    /* renamed from: c */
    private static int f19938c = 0;
    /* renamed from: a */
    private String f19939a;
    /* renamed from: b */
    private String f19940b;

    /* compiled from: GLInfo */
    /* renamed from: com.baidu.platform.comapi.util.c.f$a */
    private static abstract class C4809a implements EGLConfigChooser {
        /* renamed from: a */
        protected int[] f19928a;

        /* renamed from: a */
        abstract EGLConfig mo3724a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public C4809a(int[] configSpec) {
            this.f19928a = m15970a(configSpec);
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            int[] num_config = new int[1];
            if (egl.eglChooseConfig(display, this.f19928a, null, 0, num_config)) {
                int numConfigs = num_config[0];
                if (numConfigs <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] configs = new EGLConfig[numConfigs];
                if (egl.eglChooseConfig(display, this.f19928a, configs, numConfigs, num_config)) {
                    EGLConfig config = mo3724a(egl, display, configs);
                    if (config != null) {
                        return config;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        /* renamed from: a */
        private int[] m15970a(int[] configSpec) {
            if (C4813f.f19938c != 2) {
                return configSpec;
            }
            int len = configSpec.length;
            int[] newConfigSpec = new int[(len + 2)];
            System.arraycopy(configSpec, 0, newConfigSpec, 0, len - 1);
            newConfigSpec[len - 1] = 12352;
            newConfigSpec[len] = 4;
            newConfigSpec[len + 1] = 12344;
            return newConfigSpec;
        }
    }

    /* compiled from: GLInfo */
    /* renamed from: com.baidu.platform.comapi.util.c.f$b */
    private static class C4810b extends C4809a {
        /* renamed from: b */
        protected int f19929b;
        /* renamed from: c */
        protected int f19930c;
        /* renamed from: d */
        protected int f19931d;
        /* renamed from: e */
        protected int f19932e;
        /* renamed from: f */
        protected int f19933f;
        /* renamed from: g */
        protected int f19934g;
        /* renamed from: h */
        private int[] f19935h = new int[1];

        public C4810b(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
            super(new int[]{12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344});
            this.f19929b = redSize;
            this.f19930c = greenSize;
            this.f19931d = blueSize;
            this.f19932e = alphaSize;
            this.f19933f = depthSize;
            this.f19934g = stencilSize;
        }

        /* renamed from: a */
        public EGLConfig mo3724a(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            for (EGLConfig config : configs) {
                int d = m15972a(egl, display, config, 12325, 0);
                int s = m15972a(egl, display, config, 12326, 0);
                if (d >= this.f19933f && s >= this.f19934g) {
                    int r = m15972a(egl, display, config, 12324, 0);
                    int g = m15972a(egl, display, config, 12323, 0);
                    int b = m15972a(egl, display, config, 12322, 0);
                    int a = m15972a(egl, display, config, 12321, 0);
                    if (r == this.f19929b && g == this.f19930c && b == this.f19931d && a == this.f19932e) {
                        return config;
                    }
                }
            }
            return null;
        }

        /* renamed from: a */
        private int m15972a(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
            if (egl.eglGetConfigAttrib(display, config, attribute, this.f19935h)) {
                return this.f19935h[0];
            }
            return defaultValue;
        }
    }

    /* compiled from: GLInfo */
    /* renamed from: com.baidu.platform.comapi.util.c.f$c */
    private class C4811c implements EGLContextFactory {
        /* renamed from: a */
        final /* synthetic */ C4813f f19936a;
        /* renamed from: b */
        private int f19937b;

        private C4811c(C4813f c4813f) {
            this.f19936a = c4813f;
            this.f19937b = 12440;
        }

        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig config) {
            int[] attrib_list = new int[]{this.f19937b, C4813f.f19938c, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (C4813f.f19938c == 0) {
                attrib_list = null;
            }
            return egl.eglCreateContext(display, config, eGLContext, attrib_list);
        }

        public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
            if (!egl.eglDestroyContext(display, context)) {
            }
        }
    }

    /* compiled from: GLInfo */
    /* renamed from: com.baidu.platform.comapi.util.c.f$d */
    private static class C4812d extends C4810b {
        public C4812d(boolean withDepthBuffer) {
            int i;
            if (withDepthBuffer) {
                i = 16;
            } else {
                i = 0;
            }
            super(8, 8, 8, 0, i, 0);
        }
    }

    /* renamed from: a */
    public String m15975a() {
        return this.f19939a;
    }

    /* renamed from: b */
    public String m15977b() {
        return this.f19940b;
    }

    /* renamed from: a */
    public void mo3723a(Context context) {
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay display = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (egl.eglInitialize(display, new int[2])) {
            EGLConfigChooser chooser = new C4812d(true);
            EGLContextFactory contextFactory = new C4811c();
            EGLContext eglContext = contextFactory.createContext(egl, display, chooser.chooseConfig(egl, display));
            GL10 gl = (GL10) eglContext.getGL();
            this.f19940b = gl.glGetString(7938);
            this.f19939a = gl.glGetString(7937);
            contextFactory.destroyContext(egl, display, eglContext);
            if (this.f19940b == null) {
                this.f19940b = "";
            }
            if (this.f19939a == null) {
                this.f19939a = "";
                return;
            }
            return;
        }
        throw new RuntimeException("eglInitialize failed");
    }
}
