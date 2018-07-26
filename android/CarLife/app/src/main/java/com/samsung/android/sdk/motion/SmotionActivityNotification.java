package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContextListener;
import android.hardware.scontext.SContextManager;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;

public class SmotionActivityNotification {
    /* renamed from: d */
    private static boolean f24687d;
    /* renamed from: e */
    private static Smotion f24688e = null;
    /* renamed from: f */
    private static final Object f24689f = new Object();
    /* renamed from: a */
    private ChangeListener f24690a = null;
    /* renamed from: b */
    private C6070a f24691b = null;
    /* renamed from: c */
    private SContextListener f24692c = null;

    public interface ChangeListener {
        void onChanged(Info info);
    }

    public static class Info {
        public static final int ACCURACY_HIGH = 2;
        public static final int ACCURACY_LOW = 0;
        public static final int ACCURACY_MID = 1;
        public static final int STATUS_RUN = 3;
        public static final int STATUS_STATIONARY = 1;
        public static final int STATUS_UNKNOWN = 0;
        public static final int STATUS_VEHICLE = 4;
        public static final int STATUS_WALK = 2;
        /* renamed from: a */
        private int f24683a;
        /* renamed from: b */
        private int f24684b;
        /* renamed from: c */
        private long f24685c;

        public Info() {
            if (SmotionActivityNotification.f24688e == null) {
                throw new IllegalStateException("SmotionActivityNotification.Info : SmotionActivityNotification is not created. ");
            } else if (!SmotionActivityNotification.f24687d) {
                throw new IllegalStateException("SmotionActivityNotification.Info : This device is not supported. ");
            }
        }

        public int getAccuracy() {
            return this.f24684b;
        }

        public int getStatus() {
            return this.f24683a;
        }

        public long getTimeStamp() {
            return this.f24685c;
        }
    }

    public static class InfoFilter {
        /* renamed from: a */
        private ArrayList f24686a = null;

        public InfoFilter() {
            if (SmotionActivityNotification.f24688e == null) {
                throw new IllegalStateException("SmotionActivityNotification.InfoFilter : SmotionActivityNotification is not created. ");
            } else if (SmotionActivityNotification.f24687d) {
                this.f24686a = new ArrayList();
            } else {
                throw new IllegalStateException("SmotionActivityNotification.InfoFilter : This device is not supported. ");
            }
        }

        public void addActivity(int i) {
            if (this.f24686a == null) {
                throw new IllegalStateException("SmotionActivityNotification.InfoFilter : InfoFilter is not created.");
            } else if (i > 4 || i <= 0) {
                Log.e("SmotionActivityNotification", "This activity type is not supported.");
                throw new IllegalArgumentException("SmotionActivityNotification.InfoFilter : This activity type is invalid.");
            } else {
                for (int i2 = 0; i2 < this.f24686a.size(); i2++) {
                    if (((Integer) this.f24686a.get(i2)).intValue() == i) {
                        Log.e("SmotionActivityNotification", "This activity type is duplicated.");
                        return;
                    }
                }
                this.f24686a.add(Integer.valueOf(i));
            }
        }
    }

    /* renamed from: com.samsung.android.sdk.motion.SmotionActivityNotification$a */
    private static class C6070a extends SContextManager {
        public C6070a(Looper looper) {
            super(looper);
        }

        public final boolean registerListener(SContextListener sContextListener, int i) {
            return super.registerListener(sContextListener, i);
        }

        public final void unregisterListener(SContextListener sContextListener, int i) {
            super.unregisterListener(sContextListener, i);
        }
    }

    public SmotionActivityNotification(Looper looper, Smotion smotion) {
        if (looper == null) {
            throw new NullPointerException("SmotionActivityNotification : Looper is null. ");
        } else if (smotion == null) {
            throw new NullPointerException("SmotionActivityNotification : Smotion is null. ");
        } else if (smotion.f24655d == null) {
            throw new IllegalArgumentException("SmotionActivityNotification : Smotion.initialize() is not called. ");
        } else if (smotion.f24654a) {
            this.f24691b = new C6070a(looper);
            synchronized (f24689f) {
                f24688e = smotion;
            }
            boolean isFeatureEnabled = f24688e.isFeatureEnabled(4);
            synchronized (f24689f) {
                f24687d = isFeatureEnabled;
            }
            if (!f24687d) {
                throw new IllegalStateException("SmotionActivityNotification : This device is not supported. ");
            }
        } else {
            throw new IllegalStateException("SmotionActivityNotification : Smotion.initialize() is not successful.");
        }
    }

    /* renamed from: a */
    static /* synthetic */ Info m21619a(SmotionActivityNotification smotionActivityNotification, long j, int i, int i2) {
        Info info = new Info();
        info.f24685c = j;
        switch (i) {
            case 1:
                info.f24683a = 1;
                break;
            case 2:
                info.f24683a = 2;
                break;
            case 3:
                info.f24683a = 3;
                break;
            case 4:
            case 5:
                info.f24683a = 4;
                break;
            default:
                info.f24683a = 0;
                break;
        }
        switch (i2) {
            case 0:
                info.f24684b = 0;
                break;
            case 1:
                info.f24684b = 1;
                break;
            case 2:
                info.f24684b = 2;
                break;
        }
        return info;
    }

    public boolean isActivitySupported(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("SmotionActivity : activity value is wrong!!");
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return Smotion.f24653c;
            default:
                return false;
        }
    }

    public void start(InfoFilter infoFilter, ChangeListener changeListener) {
        if (infoFilter == null) {
            throw new IllegalArgumentException("SmotionActivityNotification : InfoFilter is null.");
        } else if (infoFilter.f24686a.isEmpty()) {
            throw new IllegalArgumentException("SmotionActivityNotification : InfoFilter is empty.");
        } else if (changeListener == null) {
            throw new IllegalArgumentException("SmotionActivityNotification : ChangeListener is null.");
        } else {
            int[] iArr = new int[infoFilter.f24686a.size()];
            if (this.f24690a == null) {
                this.f24690a = changeListener;
                if (f24687d) {
                    for (int i = 0; i < infoFilter.f24686a.size(); i++) {
                        iArr[i] = ((Integer) infoFilter.f24686a.get(i)).intValue();
                    }
                    this.f24692c = changeListener == null ? null : new C6075b(this, changeListener);
                    this.f24691b.registerListener(this.f24692c, 27, iArr);
                    try {
                        f24688e.m21598a(f24688e.f24655d, "SmotionActivityNotification.start()");
                        return;
                    } catch (SecurityException e) {
                        throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
                    }
                }
                throw new IllegalStateException("SmotionActivityNotification : This device is not supported.");
            }
            throw new IllegalStateException("SmotionActivityNotification : ChangeListener is already registered.");
        }
    }

    public void stop() {
        if (this.f24690a == null) {
            throw new IllegalStateException("SmotionActivityNotification : start() is not called");
        }
        if (this.f24691b != null) {
            this.f24691b.unregisterListener(this.f24692c, 27);
        }
        this.f24690a = null;
        this.f24692c = null;
    }
}
