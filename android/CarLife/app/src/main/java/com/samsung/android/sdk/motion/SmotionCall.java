package com.samsung.android.sdk.motion;

import android.hardware.motion.MRListener;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Looper;

public class SmotionCall {
    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 1;
    /* renamed from: d */
    private static final Object f24695d = new Object();
    /* renamed from: e */
    private static boolean f24696e;
    /* renamed from: f */
    private static Smotion f24697f = null;
    /* renamed from: a */
    private C6071a f24698a;
    /* renamed from: b */
    private ChangeListener f24699b = null;
    /* renamed from: c */
    private MRListener f24700c = null;

    public interface ChangeListener {
        void onChanged(Info info);
    }

    public static class Info {
        /* renamed from: a */
        private int f24693a;
        /* renamed from: b */
        private long f24694b;

        public Info() {
            if (SmotionCall.f24697f == null) {
                throw new IllegalStateException("SmotionCall.Info : SmotionCall is not created. ");
            } else if (!SmotionCall.f24696e) {
                throw new IllegalStateException("SmotionCall.Info : This device is not supported. ");
            }
        }

        /* renamed from: a */
        final void m21622a(int i) {
            this.f24693a = i;
        }

        public int getCallPosition() {
            return this.f24693a;
        }

        public long getTimeStamp() {
            return this.f24694b;
        }
    }

    /* renamed from: com.samsung.android.sdk.motion.SmotionCall$a */
    private static class C6071a extends MotionRecognitionManager {
        public C6071a(Looper looper) {
            super(looper);
        }

        public final void unregisterListener(MRListener mRListener) {
            super.unregisterListener(mRListener);
        }

        public final void unregisterListener(MRListener mRListener, int i) {
            super.unregisterListener(mRListener, i);
        }
    }

    public SmotionCall(Looper looper, Smotion smotion) throws NullPointerException, IllegalArgumentException {
        if (looper == null) {
            throw new NullPointerException("SmotionCall : Looper is null. ");
        } else if (smotion == null) {
            throw new NullPointerException("SmotionCall : Smotion is null. ");
        } else if (smotion.f24655d == null) {
            throw new IllegalArgumentException("SmotionCall : Smotion.initialize() is not called. ");
        } else if (smotion.f24654a) {
            this.f24698a = new C6071a(looper);
            synchronized (f24695d) {
                f24697f = smotion;
            }
            boolean isFeatureEnabled = f24697f.isFeatureEnabled(0);
            synchronized (f24695d) {
                f24696e = isFeatureEnabled;
            }
            if (!f24696e) {
                throw new IllegalStateException("SmotionCall : This device is not supported. ");
            }
        } else {
            throw new IllegalStateException("SmotionCall : Smotion.initialize() is not successful. ");
        }
    }

    public void start(ChangeListener changeListener) {
        if (changeListener == null) {
            throw new IllegalArgumentException("SmotionCall : ChangeListener is null. ");
        } else if (!f24696e) {
            throw new IllegalStateException("SmotionCall : This device is not supported. ");
        } else if (this.f24699b == null) {
            this.f24699b = changeListener;
            ChangeListener changeListener2 = this.f24699b;
            this.f24700c = changeListener2 == null ? null : new C6076c(this, changeListener2);
            this.f24698a.registerListenerEvent(this.f24700c, 1073741824, 1024, null);
            try {
                f24697f.m21598a(f24697f.f24655d, "SmotionCall.start()");
            } catch (SecurityException e) {
                throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
            }
        } else {
            throw new IllegalStateException("SmotionCall : ChangeListener is already registered.");
        }
    }

    public void stop() {
        if (this.f24699b == null) {
            throw new IllegalStateException("SmotionCall : start() is not called. ");
        }
        if (this.f24698a != null) {
            this.f24698a.unregisterListener(this.f24700c, 1024);
        }
        this.f24700c = null;
        this.f24699b = null;
    }
}
