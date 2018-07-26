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
import javax.microedition.khronos.opengles.GL10;

public class GLTextureView extends TextureView implements SurfaceTextureListener {
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
    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private final OnLayoutChangeListener layoutChangeListener = new C47781();
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private Renderer mRenderer;
    private final WeakReference<GLTextureView> mThisWeakRef = new WeakReference(this);

    /* renamed from: com.baidu.platform.comapi.map.GLTextureView$1 */
    class C47781 implements OnLayoutChangeListener {
        C47781() {
        }

        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            GLTextureView.this.onSurfaceTextureSizeChanged(GLTextureView.this.getSurfaceTexture(), right - left, bottom - top);
        }
    }

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] configSpec) {
            this.mConfigSpec = filterConfigSpec(configSpec);
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            int[] num_config = new int[1];
            if (egl.eglChooseConfig(display, this.mConfigSpec, null, 0, num_config)) {
                int numConfigs = num_config[0];
                if (numConfigs <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] configs = new EGLConfig[numConfigs];
                if (egl.eglChooseConfig(display, this.mConfigSpec, configs, numConfigs, num_config)) {
                    EGLConfig config = chooseConfig(egl, display, configs);
                    if (config != null) {
                        return config;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] filterConfigSpec(int[] configSpec) {
            if (GLTextureView.this.mEGLContextClientVersion != 2) {
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

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
            super(new int[]{12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344});
            this.mRedSize = redSize;
            this.mGreenSize = greenSize;
            this.mBlueSize = blueSize;
            this.mAlphaSize = alphaSize;
            this.mDepthSize = depthSize;
            this.mStencilSize = stencilSize;
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            for (EGLConfig config : configs) {
                int d = findConfigAttrib(egl, display, config, 12325, 0);
                int s = findConfigAttrib(egl, display, config, 12326, 0);
                if (d >= this.mDepthSize && s >= this.mStencilSize) {
                    int r = findConfigAttrib(egl, display, config, 12324, 0);
                    int g = findConfigAttrib(egl, display, config, 12323, 0);
                    int b = findConfigAttrib(egl, display, config, 12322, 0);
                    int a = findConfigAttrib(egl, display, config, 12321, 0);
                    if (r == this.mRedSize && g == this.mGreenSize && b == this.mBlueSize && a == this.mAlphaSize) {
                        return config;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
            if (egl.eglGetConfigAttrib(display, config, attribute, this.mValue)) {
                return this.mValue[0];
            }
            return defaultValue;
        }
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig config) {
            int[] attrib_list = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.mEGLContextClientVersion == 0) {
                attrib_list = null;
            }
            return egl.eglCreateContext(display, config, eGLContext, attrib_list);
        }

        public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
            if (!egl.eglDestroyContext(display, context)) {
                Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
                EglHelper.throwEglException("eglDestroyContex", egl.eglGetError());
            }
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display, EGLConfig config, Object nativeWindow) {
            EGLSurface result = null;
            try {
                result = egl.eglCreateWindowSurface(display, config, nativeWindow, null);
            } catch (IllegalArgumentException e) {
                Log.e(GLTextureView.TAG, "eglCreateWindowSurface", e);
            }
            return result;
        }

        public void destroySurface(EGL10 egl, EGLDisplay display, EGLSurface surface) {
            egl.eglDestroySurface(display, surface);
        }
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLTextureView> mGLTextureViewWeakRef;

        public EglHelper(WeakReference<GLTextureView> glSurfaceViewWeakRef) {
            this.mGLTextureViewWeakRef = glSurfaceViewWeakRef;
        }

        public void start() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                GLTextureView view = (GLTextureView) this.mGLTextureViewWeakRef.get();
                if (view == null) {
                    this.mEglConfig = null;
                    this.mEglContext = null;
                } else {
                    this.mEglConfig = view.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                    this.mEglContext = view.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                }
                if (this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                    this.mEglContext = null;
                    throwEglException("createContext");
                }
                Log.w("EglHelper", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId());
                this.mEglSurface = null;
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }

        public boolean createSurface() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                destroySurfaceImp();
                GLTextureView view = (GLTextureView) this.mGLTextureViewWeakRef.get();
                if (view != null) {
                    this.mEglSurface = view.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, view.getSurfaceTexture());
                } else {
                    this.mEglSurface = null;
                }
                if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() != 12299) {
                        return false;
                    }
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                    return true;
                } else {
                    logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                    return false;
                }
            }
        }

        GL createGL() {
            GL gl = this.mEglContext.getGL();
            GLTextureView view = (GLTextureView) this.mGLTextureViewWeakRef.get();
            if (view == null) {
                return gl;
            }
            if (view.mGLWrapper != null) {
                gl = view.mGLWrapper.wrap(gl);
            }
            if ((view.mDebugFlags & 3) == 0) {
                return gl;
            }
            int configFlags = 0;
            Writer log = null;
            if ((view.mDebugFlags & 1) != 0) {
                configFlags = 0 | 1;
            }
            if ((view.mDebugFlags & 2) != 0) {
                log = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, configFlags, log);
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return 12288;
            }
            return this.mEgl.eglGetError();
        }

        public void destroySurface() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            if (this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView view = (GLTextureView) this.mGLTextureViewWeakRef.get();
                if (view != null) {
                    view.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public void finish() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.mEglContext != null) {
                GLTextureView view = (GLTextureView) this.mGLTextureViewWeakRef.get();
                if (view != null) {
                    view.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            if (this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String function) {
            throwEglException(function, this.mEgl.eglGetError());
        }

        public static void throwEglException(String function, int error) {
            String message = formatEglError(function, error);
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + message);
            throw new RuntimeException(message);
        }

        public static void logEglErrorAsWarning(String tag, String function, int error) {
        }

        public static String formatEglError(String function, int error) {
            return function + " EGL failed code: " + error;
        }
    }

    static class GLThread extends Thread {
        private EglHelper mEglHelper;
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

        GLThread(WeakReference<GLTextureView> glTextureViewWeakRef) {
            this.mGLTextureViewWeakRef = glTextureViewWeakRef;
        }

        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            try {
                guardedRun();
            } catch (InterruptedException e) {
            } finally {
                GLTextureView.sGLThreadManager.threadExiting(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
            r26 = this;
            r21 = new com.baidu.platform.comapi.map.GLTextureView$EglHelper;
            r0 = r26;
            r0 = r0.mGLTextureViewWeakRef;
            r22 = r0;
            r21.<init>(r22);
            r0 = r21;
            r1 = r26;
            r1.mEglHelper = r0;
            r21 = 0;
            r0 = r21;
            r1 = r26;
            r1.mHaveEglContext = r0;
            r21 = 0;
            r0 = r21;
            r1 = r26;
            r1.mHaveEglSurface = r0;
            r10 = 0;
            r5 = 0;
            r6 = 0;
            r7 = 0;
            r12 = 0;
            r15 = 0;
            r20 = 0;
            r8 = 0;
            r4 = 0;
            r19 = 0;
            r11 = 0;
            r9 = 0;
        L_0x002f:
            r22 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031e }
            monitor-enter(r22);	 Catch:{ all -> 0x031e }
        L_0x0034:
            r0 = r26;
            r0 = r0.mShouldExit;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x004d;
        L_0x003c:
            monitor-exit(r22);	 Catch:{ all -> 0x031b }
            r22 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;
            monitor-enter(r22);
            r26.stopEglSurfaceLocked();	 Catch:{ all -> 0x004a }
            r26.stopEglContextLocked();	 Catch:{ all -> 0x004a }
            monitor-exit(r22);	 Catch:{ all -> 0x004a }
            return;
        L_0x004a:
            r21 = move-exception;
            monitor-exit(r22);	 Catch:{ all -> 0x004a }
            throw r21;
        L_0x004d:
            r0 = r26;
            r0 = r0.mEventQueue;	 Catch:{ all -> 0x031b }
            r21 = r0;
            r21 = r21.isEmpty();	 Catch:{ all -> 0x031b }
            if (r21 != 0) goto L_0x0076;
        L_0x0059:
            r0 = r26;
            r0 = r0.mEventQueue;	 Catch:{ all -> 0x031b }
            r21 = r0;
            r23 = 0;
            r0 = r21;
            r1 = r23;
            r21 = r0.remove(r1);	 Catch:{ all -> 0x031b }
            r0 = r21;
            r0 = (java.lang.Runnable) r0;	 Catch:{ all -> 0x031b }
            r9 = r0;
        L_0x006e:
            monitor-exit(r22);	 Catch:{ all -> 0x031b }
            if (r9 == 0) goto L_0x043a;
        L_0x0071:
            r9.run();	 Catch:{ all -> 0x031e }
            r9 = 0;
            goto L_0x002f;
        L_0x0076:
            r13 = 0;
            r0 = r26;
            r0 = r0.mPaused;	 Catch:{ all -> 0x031b }
            r21 = r0;
            r0 = r26;
            r0 = r0.mRequestPaused;	 Catch:{ all -> 0x031b }
            r23 = r0;
            r0 = r21;
            r1 = r23;
            if (r0 == r1) goto L_0x00d3;
        L_0x0089:
            r0 = r26;
            r13 = r0.mRequestPaused;	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mRequestPaused;	 Catch:{ all -> 0x031b }
            r21 = r0;
            r0 = r21;
            r1 = r26;
            r1.mPaused = r0;	 Catch:{ all -> 0x031b }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21.notifyAll();	 Catch:{ all -> 0x031b }
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "mPaused is now ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mPaused;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
        L_0x00d3:
            r0 = r26;
            r0 = r0.mShouldReleaseEglContext;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x010c;
        L_0x00db:
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "releasing EGL context because asked to tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
            r26.stopEglSurfaceLocked();	 Catch:{ all -> 0x031b }
            r26.stopEglContextLocked();	 Catch:{ all -> 0x031b }
            r21 = 0;
            r0 = r21;
            r1 = r26;
            r1.mShouldReleaseEglContext = r0;	 Catch:{ all -> 0x031b }
            r4 = 1;
        L_0x010c:
            if (r12 == 0) goto L_0x0115;
        L_0x010e:
            r26.stopEglSurfaceLocked();	 Catch:{ all -> 0x031b }
            r26.stopEglContextLocked();	 Catch:{ all -> 0x031b }
            r12 = 0;
        L_0x0115:
            if (r13 == 0) goto L_0x0144;
        L_0x0117:
            r0 = r26;
            r0 = r0.mHaveEglSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x0144;
        L_0x011f:
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "releasing EGL surface because paused tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
            r26.stopEglSurfaceLocked();	 Catch:{ all -> 0x031b }
        L_0x0144:
            if (r13 == 0) goto L_0x0194;
        L_0x0146:
            r0 = r26;
            r0 = r0.mHaveEglContext;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x0194;
        L_0x014e:
            r0 = r26;
            r0 = r0.mGLTextureViewWeakRef;	 Catch:{ all -> 0x031b }
            r21 = r0;
            r18 = r21.get();	 Catch:{ all -> 0x031b }
            r18 = (com.baidu.platform.comapi.map.GLTextureView) r18;	 Catch:{ all -> 0x031b }
            if (r18 == 0) goto L_0x032c;
        L_0x015c:
            r21 = r18.mPreserveEGLContextOnPause;	 Catch:{ all -> 0x031b }
            if (r21 == 0) goto L_0x032c;
        L_0x0162:
            r14 = 1;
        L_0x0163:
            if (r14 == 0) goto L_0x016f;
        L_0x0165:
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21 = r21.shouldReleaseEGLContextWhenPausing();	 Catch:{ all -> 0x031b }
            if (r21 == 0) goto L_0x0194;
        L_0x016f:
            r26.stopEglContextLocked();	 Catch:{ all -> 0x031b }
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "releasing EGL context because paused tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
        L_0x0194:
            if (r13 == 0) goto L_0x01cb;
        L_0x0196:
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21 = r21.shouldTerminateEGLWhenPausing();	 Catch:{ all -> 0x031b }
            if (r21 == 0) goto L_0x01cb;
        L_0x01a0:
            r0 = r26;
            r0 = r0.mEglHelper;	 Catch:{ all -> 0x031b }
            r21 = r0;
            r21.finish();	 Catch:{ all -> 0x031b }
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "terminating EGL because paused tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
        L_0x01cb:
            r0 = r26;
            r0 = r0.mHasSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 != 0) goto L_0x021f;
        L_0x01d3:
            r0 = r26;
            r0 = r0.mWaitingForSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 != 0) goto L_0x021f;
        L_0x01db:
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "noticed surfaceView surface lost tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mHaveEglSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x0208;
        L_0x0205:
            r26.stopEglSurfaceLocked();	 Catch:{ all -> 0x031b }
        L_0x0208:
            r21 = 1;
            r0 = r21;
            r1 = r26;
            r1.mWaitingForSurface = r0;	 Catch:{ all -> 0x031b }
            r21 = 0;
            r0 = r21;
            r1 = r26;
            r1.mSurfaceIsBad = r0;	 Catch:{ all -> 0x031b }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21.notifyAll();	 Catch:{ all -> 0x031b }
        L_0x021f:
            r0 = r26;
            r0 = r0.mHasSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x0260;
        L_0x0227:
            r0 = r26;
            r0 = r0.mWaitingForSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x0260;
        L_0x022f:
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "noticed surfaceView surface acquired tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
            r21 = 0;
            r0 = r21;
            r1 = r26;
            r1.mWaitingForSurface = r0;	 Catch:{ all -> 0x031b }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21.notifyAll();	 Catch:{ all -> 0x031b }
        L_0x0260:
            if (r8 == 0) goto L_0x0296;
        L_0x0262:
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "sending render notification tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
            r20 = 0;
            r8 = 0;
            r21 = 1;
            r0 = r21;
            r1 = r26;
            r1.mRenderComplete = r0;	 Catch:{ all -> 0x031b }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21.notifyAll();	 Catch:{ all -> 0x031b }
        L_0x0296:
            r21 = r26.readyToDraw();	 Catch:{ all -> 0x031b }
            if (r21 == 0) goto L_0x0365;
        L_0x029c:
            r0 = r26;
            r0 = r0.mHaveEglContext;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 != 0) goto L_0x02a7;
        L_0x02a4:
            if (r4 == 0) goto L_0x032f;
        L_0x02a6:
            r4 = 0;
        L_0x02a7:
            r0 = r26;
            r0 = r0.mHaveEglContext;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x02c2;
        L_0x02af:
            r0 = r26;
            r0 = r0.mHaveEglSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 != 0) goto L_0x02c2;
        L_0x02b7:
            r21 = 1;
            r0 = r21;
            r1 = r26;
            r1.mHaveEglSurface = r0;	 Catch:{ all -> 0x031b }
            r6 = 1;
            r7 = 1;
            r15 = 1;
        L_0x02c2:
            r0 = r26;
            r0 = r0.mHaveEglSurface;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x0365;
        L_0x02ca:
            r0 = r26;
            r0 = r0.mSizeChanged;	 Catch:{ all -> 0x031b }
            r21 = r0;
            if (r21 == 0) goto L_0x030a;
        L_0x02d2:
            r15 = 1;
            r0 = r26;
            r0 = r0.mWidth;	 Catch:{ all -> 0x031b }
            r19 = r0;
            r0 = r26;
            r11 = r0.mHeight;	 Catch:{ all -> 0x031b }
            r20 = 1;
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "noticing that we want render notification tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
            r6 = 1;
            r21 = 0;
            r0 = r21;
            r1 = r26;
            r1.mSizeChanged = r0;	 Catch:{ all -> 0x031b }
        L_0x030a:
            r21 = 0;
            r0 = r21;
            r1 = r26;
            r1.mRequestRender = r0;	 Catch:{ all -> 0x031b }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21.notifyAll();	 Catch:{ all -> 0x031b }
            goto L_0x006e;
        L_0x031b:
            r21 = move-exception;
            monitor-exit(r22);	 Catch:{ all -> 0x031b }
            throw r21;	 Catch:{ all -> 0x031e }
        L_0x031e:
            r21 = move-exception;
            r22 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;
            monitor-enter(r22);
            r26.stopEglSurfaceLocked();	 Catch:{ all -> 0x057a }
            r26.stopEglContextLocked();	 Catch:{ all -> 0x057a }
            monitor-exit(r22);	 Catch:{ all -> 0x057a }
            throw r21;
        L_0x032c:
            r14 = 0;
            goto L_0x0163;
        L_0x032f:
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r26;
            r21 = r0.tryAcquireEglContextLocked(r1);	 Catch:{ all -> 0x031b }
            if (r21 == 0) goto L_0x02a7;
        L_0x033d:
            r0 = r26;
            r0 = r0.mEglHelper;	 Catch:{ RuntimeException -> 0x0358 }
            r21 = r0;
            r21.start();	 Catch:{ RuntimeException -> 0x0358 }
            r21 = 1;
            r0 = r21;
            r1 = r26;
            r1.mHaveEglContext = r0;	 Catch:{ all -> 0x031b }
            r5 = 1;
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21.notifyAll();	 Catch:{ all -> 0x031b }
            goto L_0x02a7;
        L_0x0358:
            r17 = move-exception;
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r26;
            r0.releaseEglContextLocked(r1);	 Catch:{ all -> 0x031b }
            throw r17;	 Catch:{ all -> 0x031b }
        L_0x0365:
            r21 = "GLThread";
            r23 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031b }
            r23.<init>();	 Catch:{ all -> 0x031b }
            r24 = "waiting tid=";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = r26.getId();	 Catch:{ all -> 0x031b }
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mHaveEglContext: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mHaveEglContext;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mHaveEglSurface: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mHaveEglSurface;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mPaused: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mPaused;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mHasSurface: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mHasSurface;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mSurfaceIsBad: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mSurfaceIsBad;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mWaitingForSurface: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mWaitingForSurface;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mWidth: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mWidth;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mHeight: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mHeight;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mRequestRender: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mRequestRender;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r24 = " mRenderMode: ";
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r0 = r26;
            r0 = r0.mRenderMode;	 Catch:{ all -> 0x031b }
            r24 = r0;
            r23 = r23.append(r24);	 Catch:{ all -> 0x031b }
            r23 = r23.toString();	 Catch:{ all -> 0x031b }
            r0 = r21;
            r1 = r23;
            android.util.Log.i(r0, r1);	 Catch:{ all -> 0x031b }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031b }
            r21.wait();	 Catch:{ all -> 0x031b }
            goto L_0x0034;
        L_0x043a:
            if (r6 == 0) goto L_0x046c;
        L_0x043c:
            r21 = "GLThread";
            r22 = "egl createSurface";
            android.util.Log.w(r21, r22);	 Catch:{ all -> 0x031e }
            r0 = r26;
            r0 = r0.mEglHelper;	 Catch:{ all -> 0x031e }
            r21 = r0;
            r21 = r21.createSurface();	 Catch:{ all -> 0x031e }
            if (r21 != 0) goto L_0x046b;
        L_0x0451:
            r22 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031e }
            monitor-enter(r22);	 Catch:{ all -> 0x031e }
            r21 = 1;
            r0 = r21;
            r1 = r26;
            r1.mSurfaceIsBad = r0;	 Catch:{ all -> 0x0468 }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x0468 }
            r21.notifyAll();	 Catch:{ all -> 0x0468 }
            monitor-exit(r22);	 Catch:{ all -> 0x0468 }
            goto L_0x002f;
        L_0x0468:
            r21 = move-exception;
            monitor-exit(r22);	 Catch:{ all -> 0x0468 }
            throw r21;	 Catch:{ all -> 0x031e }
        L_0x046b:
            r6 = 0;
        L_0x046c:
            if (r7 == 0) goto L_0x0487;
        L_0x046e:
            r0 = r26;
            r0 = r0.mEglHelper;	 Catch:{ all -> 0x031e }
            r21 = r0;
            r21 = r21.createGL();	 Catch:{ all -> 0x031e }
            r0 = r21;
            r0 = (javax.microedition.khronos.opengles.GL10) r0;	 Catch:{ all -> 0x031e }
            r10 = r0;
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031e }
            r0 = r21;
            r0.checkGLDriver(r10);	 Catch:{ all -> 0x031e }
            r7 = 0;
        L_0x0487:
            if (r5 == 0) goto L_0x04b8;
        L_0x0489:
            r21 = "GLThread";
            r22 = "onSurfaceCreated";
            android.util.Log.w(r21, r22);	 Catch:{ all -> 0x031e }
            r0 = r26;
            r0 = r0.mGLTextureViewWeakRef;	 Catch:{ all -> 0x031e }
            r21 = r0;
            r18 = r21.get();	 Catch:{ all -> 0x031e }
            r18 = (com.baidu.platform.comapi.map.GLTextureView) r18;	 Catch:{ all -> 0x031e }
            if (r18 == 0) goto L_0x04b7;
        L_0x04a0:
            r21 = r18.mRenderer;	 Catch:{ all -> 0x031e }
            r0 = r26;
            r0 = r0.mEglHelper;	 Catch:{ all -> 0x031e }
            r22 = r0;
            r0 = r22;
            r0 = r0.mEglConfig;	 Catch:{ all -> 0x031e }
            r22 = r0;
            r0 = r21;
            r1 = r22;
            r0.onSurfaceCreated(r10, r1);	 Catch:{ all -> 0x031e }
        L_0x04b7:
            r5 = 0;
        L_0x04b8:
            if (r15 == 0) goto L_0x0506;
        L_0x04ba:
            r21 = "GLThread";
            r22 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031e }
            r22.<init>();	 Catch:{ all -> 0x031e }
            r23 = "onSurfaceChanged(";
            r22 = r22.append(r23);	 Catch:{ all -> 0x031e }
            r0 = r22;
            r1 = r19;
            r22 = r0.append(r1);	 Catch:{ all -> 0x031e }
            r23 = ", ";
            r22 = r22.append(r23);	 Catch:{ all -> 0x031e }
            r0 = r22;
            r22 = r0.append(r11);	 Catch:{ all -> 0x031e }
            r23 = ")";
            r22 = r22.append(r23);	 Catch:{ all -> 0x031e }
            r22 = r22.toString();	 Catch:{ all -> 0x031e }
            android.util.Log.w(r21, r22);	 Catch:{ all -> 0x031e }
            r0 = r26;
            r0 = r0.mGLTextureViewWeakRef;	 Catch:{ all -> 0x031e }
            r21 = r0;
            r18 = r21.get();	 Catch:{ all -> 0x031e }
            r18 = (com.baidu.platform.comapi.map.GLTextureView) r18;	 Catch:{ all -> 0x031e }
            if (r18 == 0) goto L_0x0505;
        L_0x04fa:
            r21 = r18.mRenderer;	 Catch:{ all -> 0x031e }
            r0 = r21;
            r1 = r19;
            r0.onSurfaceChanged(r10, r1, r11);	 Catch:{ all -> 0x031e }
        L_0x0505:
            r15 = 0;
        L_0x0506:
            r0 = r26;
            r0 = r0.mGLTextureViewWeakRef;	 Catch:{ all -> 0x031e }
            r21 = r0;
            r18 = r21.get();	 Catch:{ all -> 0x031e }
            r18 = (com.baidu.platform.comapi.map.GLTextureView) r18;	 Catch:{ all -> 0x031e }
            if (r18 == 0) goto L_0x051d;
        L_0x0514:
            r21 = r18.mRenderer;	 Catch:{ all -> 0x031e }
            r0 = r21;
            r0.onDrawFrame(r10);	 Catch:{ all -> 0x031e }
        L_0x051d:
            r0 = r26;
            r0 = r0.mEglHelper;	 Catch:{ all -> 0x031e }
            r21 = r0;
            r16 = r21.swap();	 Catch:{ all -> 0x031e }
            switch(r16) {
                case 12288: goto L_0x054e;
                case 12302: goto L_0x0553;
                default: goto L_0x052a;
            };	 Catch:{ all -> 0x031e }
        L_0x052a:
            r21 = "GLThread";
            r22 = "eglSwapBuffers";
            r0 = r21;
            r1 = r22;
            r2 = r16;
            com.baidu.platform.comapi.map.GLTextureView.EglHelper.logEglErrorAsWarning(r0, r1, r2);	 Catch:{ all -> 0x031e }
            r22 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x031e }
            monitor-enter(r22);	 Catch:{ all -> 0x031e }
            r21 = 1;
            r0 = r21;
            r1 = r26;
            r1.mSurfaceIsBad = r0;	 Catch:{ all -> 0x0577 }
            r21 = com.baidu.platform.comapi.map.GLTextureView.sGLThreadManager;	 Catch:{ all -> 0x0577 }
            r21.notifyAll();	 Catch:{ all -> 0x0577 }
            monitor-exit(r22);	 Catch:{ all -> 0x0577 }
        L_0x054e:
            if (r20 == 0) goto L_0x002f;
        L_0x0550:
            r8 = 1;
            goto L_0x002f;
        L_0x0553:
            r21 = "GLThread";
            r22 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031e }
            r22.<init>();	 Catch:{ all -> 0x031e }
            r23 = "egl context lost tid=";
            r22 = r22.append(r23);	 Catch:{ all -> 0x031e }
            r24 = r26.getId();	 Catch:{ all -> 0x031e }
            r0 = r22;
            r1 = r24;
            r22 = r0.append(r1);	 Catch:{ all -> 0x031e }
            r22 = r22.toString();	 Catch:{ all -> 0x031e }
            android.util.Log.i(r21, r22);	 Catch:{ all -> 0x031e }
            r12 = 1;
            goto L_0x054e;
        L_0x0577:
            r21 = move-exception;
            monitor-exit(r22);	 Catch:{ all -> 0x0577 }
            throw r21;	 Catch:{ all -> 0x031e }
        L_0x057a:
            r21 = move-exception;
            monitor-exit(r22);	 Catch:{ all -> 0x057a }
            throw r21;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.GLTextureView.GLThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int renderMode) {
            if (renderMode < 0 || renderMode > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLTextureView.sGLThreadManager) {
                this.mRenderMode = renderMode;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.sGLThreadManager) {
                this.mRequestRender = true;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public void surfaceCreated() {
            synchronized (GLTextureView.sGLThreadManager) {
                Log.i("GLThread", "surfaceCreated tid=" + getId());
                this.mHasSurface = true;
                GLTextureView.sGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mExited) {
                    try {
                        GLTextureView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLTextureView.sGLThreadManager) {
                Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                this.mHasSurface = false;
                GLTextureView.sGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        GLTextureView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (GLTextureView.sGLThreadManager) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.mRequestPaused = true;
                GLTextureView.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLTextureView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureView.sGLThreadManager) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GLTextureView.sGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLTextureView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int w, int h) {
            synchronized (GLTextureView.sGLThreadManager) {
                this.mWidth = w;
                this.mHeight = h;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GLTextureView.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLTextureView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (GLTextureView.sGLThreadManager) {
                this.mShouldExit = true;
                GLTextureView.sGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        GLTextureView.sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLTextureView.sGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable r) {
            if (r == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (GLTextureView.sGLThreadManager) {
                this.mEventQueue.add(r);
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }
    }

    private static class GLThreadManager {
        private static final Method GET_INT_METHOD;
        private static final Class SYSTEM_PROPERTIES_CLASS;
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        private GLThreadManager() {
        }

        static {
            try {
                SYSTEM_PROPERTIES_CLASS = Class.forName("android.os.SystemProperties");
                GET_INT_METHOD = SYSTEM_PROPERTIES_CLASS.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
                GET_INT_METHOD.setAccessible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized void threadExiting(GLThread thread) {
            Log.i("GLThread", "exiting tid=" + thread.getId());
            thread.mExited = true;
            if (this.mEglOwner == thread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public boolean tryAcquireEglContextLocked(GLThread thread) {
            if (this.mEglOwner == thread || this.mEglOwner == null) {
                this.mEglOwner = thread;
                notifyAll();
                return true;
            }
            checkGLESVersion();
            if (this.mMultipleGLESContextsAllowed) {
                return true;
            }
            if (this.mEglOwner != null) {
                this.mEglOwner.requestReleaseEglContextLocked();
            }
            return false;
        }

        public void releaseEglContextLocked(GLThread thread) {
            if (this.mEglOwner == thread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            return this.mLimitedGLESContexts;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public synchronized void checkGLDriver(GL10 gl) {
            boolean z = true;
            synchronized (this) {
                if (!this.mGLESDriverCheckComplete) {
                    checkGLESVersion();
                    String renderer = gl.glGetString(7937);
                    if (this.mGLESVersion < 131072) {
                        boolean z2;
                        if (renderer.startsWith(kMSM7K_RENDERER_PREFIX)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        this.mMultipleGLESContextsAllowed = z2;
                        notifyAll();
                    }
                    if (this.mMultipleGLESContextsAllowed) {
                        z = false;
                    }
                    this.mLimitedGLESContexts = z;
                    Log.w(TAG, "checkGLDriver renderer = \"" + renderer + "\" multipleContextsAllowed = " + this.mMultipleGLESContextsAllowed + " mLimitedGLESContexts = " + this.mLimitedGLESContexts);
                    this.mGLESDriverCheckComplete = true;
                }
            }
        }

        private void checkGLESVersion() {
            if (!this.mGLESVersionCheckComplete) {
                try {
                    this.mGLESVersion = ((Integer) GET_INT_METHOD.invoke(null, new Object[]{"ro.opengles.version", Integer.valueOf(0)})).intValue();
                } catch (Exception e) {
                    this.mGLESVersion = 65536;
                }
                if (this.mGLESVersion >= 131072) {
                    this.mMultipleGLESContextsAllowed = true;
                }
                Log.w(TAG, "checkGLESVersion mGLESVersion = " + this.mGLESVersion + " mMultipleGLESContextsAllowed = " + this.mMultipleGLESContextsAllowed);
                this.mGLESVersionCheckComplete = true;
            }
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] buf, int offset, int count) {
            for (int i = 0; i < count; i++) {
                char c = buf[offset + i];
                if (c == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                this.mBuilder.delete(0, this.mBuilder.length());
            }
        }
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean withDepthBuffer) {
            int i;
            if (withDepthBuffer) {
                i = 16;
            } else {
                i = 0;
            }
            super(8, 8, 8, 0, i, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        init();
    }

    public GLTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GLTextureView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this.layoutChangeListener);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void setGLWrapper(GLWrapper glWrapper) {
        this.mGLWrapper = glWrapper;
    }

    public void setDebugFlags(int debugFlags) {
        this.mDebugFlags = debugFlags;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean preserveOnPause) {
        this.mPreserveEGLContextOnPause = preserveOnPause;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        this.mGLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread.start();
    }

    public void setEGLContextFactory(EGLContextFactory factory) {
        checkRenderThreadState();
        this.mEGLContextFactory = factory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory factory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = factory;
    }

    public void setEGLConfigChooser(EGLConfigChooser configChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = configChooser;
    }

    public void setEGLConfigChooser(boolean needDepth) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(needDepth));
    }

    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        setEGLConfigChooser(new ComponentSizeChooser(redSize, greenSize, blueSize, alphaSize, depthSize, stencilSize));
    }

    public void setEGLContextClientVersion(int version) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = version;
    }

    public void setRenderMode(int renderMode) {
        this.mGLThread.setRenderMode(renderMode);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        if (this.mGLThread != null) {
            this.mGLThread.requestRender();
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        if (this.mGLThread != null) {
            this.mGLThread.surfaceCreated();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        if (this.mGLThread != null) {
            this.mGLThread.surfaceDestroyed();
        }
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int format, int w, int h) {
        if (this.mGLThread != null) {
            this.mGLThread.onWindowResize(w, h);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        surfaceCreated(surface);
        surfaceChanged(surface, 0, width, height);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        surfaceChanged(surface, 0, width, height);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        surfaceDestroyed(surface);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    public void onPause() {
        if (this.mGLThread != null) {
            this.mGLThread.onPause();
        }
    }

    public void onResume() {
        if (this.mGLThread != null) {
            this.mGLThread.onResume();
        }
    }

    public void queueEvent(Runnable r) {
        if (this.mGLThread != null) {
            this.mGLThread.queueEvent(r);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow reattach =" + this.mDetached);
        if (this.mDetached && this.mRenderer != null) {
            int renderMode = 1;
            if (this.mGLThread != null) {
                renderMode = this.mGLThread.getRenderMode();
            }
            this.mGLThread = new GLThread(this.mThisWeakRef);
            if (renderMode != 1) {
                this.mGLThread.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    protected void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow");
        if (this.mGLThread != null) {
            this.mGLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
