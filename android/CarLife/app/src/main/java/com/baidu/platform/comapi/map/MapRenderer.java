package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLException;
import android.opengl.GLSurfaceView.Renderer;
import com.baidu.platform.comapi.util.C4835n;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MapRenderer implements Renderer {
    private static final boolean DEBUG = false;
    private static final float DEFBG_A = 1.0f;
    private static final float DEFBG_B = 0.94f;
    private static final float DEFBG_G = 0.95f;
    private static final float DEFBG_R = 0.96f;
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

    public interface ResourceRecycler {
        void onRecycle();
    }

    public interface CaptureMapViewListener {
        void onCompleted(Bitmap bitmap);
    }

    private static native void nativeDone(long j);

    private static native void nativeInit(long j);

    private static native int nativeRender(long j);

    private static native void nativeResize(long j, int i, int i2);

    public MapRenderer(WeakReference<BaiduGLSurfaceView> glViewRef, ResourceRecycler recycler) {
        this.mResourceRecycler = recycler;
        this.mGLSurfaceViewWeakRef = glViewRef;
    }

    public MapRenderer(GLTextureView glTextureView, ResourceRecycler recycler) {
        this.mTextureViewWeakRef = new WeakReference(glTextureView);
        this.mResourceRecycler = recycler;
    }

    public void setBaseMapId(int baseMapPtr) {
        this.mBaseMapPtr = baseMapPtr;
    }

    public void setMapResInitOk(boolean isOk) {
        this.mIsMapResOk = isOk;
    }

    private boolean checkBaseMap() {
        return this.mBaseMapPtr != 0 && this.mIsMapResOk;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        if (checkBaseMap()) {
            nativeInit((long) this.mBaseMapPtr);
            this.mResourceRecycler.onRecycle();
            String strVer = gl.glGetString(7938);
            SysOSAPIv2.getInstance().setGLInfo(gl.glGetString(7937), strVer);
        }
    }

    public void onSurfaceChanged(GL10 gl, int w, int h) {
        if (this.mBaseMapPtr != 0) {
            nativeResize((long) this.mBaseMapPtr, w, h);
        }
    }

    public void onDrawFrame(GL10 gl) {
        if (!checkBaseMap()) {
            drawEmptyBackground(gl);
        } else if (isReinit) {
            nativeRender((long) this.mBaseMapPtr);
            isReinit = false;
        } else {
            int ret = nativeRender((long) this.mBaseMapPtr);
            if (this.mGLSurfaceViewWeakRef != null) {
                BaiduGLSurfaceView view = (BaiduGLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (view != null) {
                    if (ret == 1) {
                        view.requestRender();
                    } else if (view.getRenderMode() != 0) {
                        view.setRenderMode(0);
                    }
                }
            }
            if (this.mTextureViewWeakRef != null) {
                GLTextureView view2 = (GLTextureView) this.mTextureViewWeakRef.get();
                if (view2 != null) {
                    if (ret == 1) {
                        view2.requestRender();
                    } else if (view2.getRenderMode() != 0) {
                        view2.setRenderMode(0);
                    }
                }
            }
            if (this.mIsCatureMap) {
                this.mIsCatureMap = false;
                if (this.mCaptureMapViewListener != null) {
                    final Bitmap bmp = createBitmapFromGLSurface(0, 0, this.mCaptureWidth, this.mCaptureHeight, gl);
                    C4835n.m16033a(new Runnable() {
                        public void run() {
                            MapRenderer.this.mCaptureMapViewListener.onCompleted(bmp);
                        }
                    });
                }
            }
        }
    }

    private void drawEmptyBackground(GL10 gl) {
        gl.glClear(16640);
        gl.glClearColor(DEFBG_R, DEFBG_G, DEFBG_B, 1.0f);
    }

    private Bitmap createBitmapFromGLSurface(int x, int y, int w, int h, GL10 gl) {
        int[] bitmapBuffer = new int[(w * h)];
        int[] bitmapSource = new int[(w * h)];
        IntBuffer intBuffer = IntBuffer.wrap(bitmapBuffer);
        intBuffer.position(0);
        try {
            gl.glReadPixels(x, y, w, h, 6408, 5121, intBuffer);
            for (int i = 0; i < h; i++) {
                int offset1 = i * w;
                int offset2 = ((h - i) - 1) * w;
                for (int j = 0; j < w; j++) {
                    int texturePixel = bitmapBuffer[offset1 + j];
                    bitmapSource[offset2 + j] = ((-16711936 & texturePixel) | ((texturePixel << 16) & 16711680)) | ((texturePixel >> 16) & 255);
                }
            }
            return Bitmap.createBitmap(bitmapSource, w, h, Config.ARGB_8888);
        } catch (GLException e) {
            return null;
        }
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int width, int height) {
        this.mIsCatureMap = true;
        this.mCaptureMapViewListener = captureMapViewListener;
        this.mCaptureWidth = width;
        this.mCaptureHeight = height;
    }
}
