package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContextListener;
import android.hardware.scontext.SContextManager;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.Timer;
import java.util.TimerTask;

public class SmotionActivity {
    /* renamed from: i */
    private static boolean f24666i;
    /* renamed from: o */
    private static Smotion f24667o = null;
    /* renamed from: q */
    private static final Object f24668q = new Object();
    /* renamed from: a */
    private Info f24669a;
    /* renamed from: b */
    private int f24670b;
    /* renamed from: c */
    private long f24671c;
    /* renamed from: d */
    private ChangeListener f24672d = null;
    /* renamed from: e */
    private C6068a f24673e = null;
    /* renamed from: f */
    private SContextListener f24674f = null;
    /* renamed from: g */
    private PowerManager f24675g;
    /* renamed from: h */
    private Display f24676h;
    /* renamed from: j */
    private boolean f24677j = false;
    /* renamed from: k */
    private boolean f24678k = false;
    /* renamed from: l */
    private boolean f24679l = false;
    /* renamed from: m */
    private Timer f24680m = null;
    /* renamed from: n */
    private long f24681n = 3000;
    /* renamed from: p */
    private boolean f24682p = false;

    public interface ChangeListener {
        void onChanged(int i, Info[] infoArr);
    }

    public static class Info {
        public static final int ACCURACY_HIGH = 2;
        public static final int ACCURACY_LOW = 0;
        public static final int ACCURACY_MID = 1;
        public static final int MODE_ALL = 0;
        public static final int MODE_BATCH = 2;
        public static final int MODE_REALTIME = 1;
        public static final int STATUS_RUN = 3;
        public static final int STATUS_STATIONARY = 1;
        public static final int STATUS_UNKNOWN = 0;
        public static final int STATUS_VEHICLE = 4;
        public static final int STATUS_WALK = 2;
        /* renamed from: a */
        private int f24662a;
        /* renamed from: b */
        private int f24663b;
        /* renamed from: c */
        private long f24664c;

        public Info() {
            if (SmotionActivity.f24667o == null) {
                throw new IllegalStateException("SmotionActivity.Info : SmotionActivity is not created. ");
            } else if (!SmotionActivity.f24666i) {
                throw new IllegalStateException("SmotionActivity.Info : This device is not supported. ");
            }
        }

        public int getAccuracy() {
            return this.f24663b;
        }

        public int getStatus() {
            return this.f24662a;
        }

        public long getTimeStamp() {
            return this.f24664c;
        }
    }

    /* renamed from: com.samsung.android.sdk.motion.SmotionActivity$a */
    private static class C6068a extends SContextManager {
        public C6068a(Looper looper) {
            super(looper);
        }

        public final boolean registerListener(SContextListener sContextListener, int i) {
            return super.registerListener(sContextListener, i);
        }

        public final void unregisterListener(SContextListener sContextListener, int i) {
            super.unregisterListener(sContextListener, i);
        }
    }

    /* renamed from: com.samsung.android.sdk.motion.SmotionActivity$b */
    private class C6069b extends TimerTask {
        /* renamed from: a */
        private /* synthetic */ SmotionActivity f24665a;

        private C6069b(SmotionActivity smotionActivity) {
            this.f24665a = smotionActivity;
        }

        public final void run() {
            this.f24665a.f24679l = true;
        }
    }

    public SmotionActivity(Looper looper, Smotion smotion) {
        if (looper == null) {
            throw new NullPointerException("SmotionActivity : Looper is null. ");
        } else if (smotion == null) {
            throw new NullPointerException("SmotionActivity : Smotion is null. ");
        } else if (smotion.f24655d == null) {
            throw new IllegalArgumentException("SmotionActivity : Smotion.initialize() is not called. ");
        } else if (smotion.f24654a) {
            this.f24673e = new C6068a(looper);
            synchronized (f24668q) {
                f24667o = smotion;
            }
            boolean isFeatureEnabled = f24667o.isFeatureEnabled(3);
            synchronized (f24668q) {
                f24666i = isFeatureEnabled;
            }
            this.f24675g = (PowerManager) smotion.f24655d.getSystemService("power");
            this.f24676h = ((WindowManager) smotion.f24655d.getSystemService("window")).getDefaultDisplay();
            if (!f24666i) {
                throw new IllegalStateException("SmotionActivity : This device is not supported. ");
            }
        } else {
            throw new IllegalStateException("SmotionActivity : Smotion.initialize() is not successful. ");
        }
    }

    /* renamed from: a */
    static /* synthetic */ Info m21604a(SmotionActivity smotionActivity, long j, int i, int i2) {
        Info info = new Info();
        info.f24664c = j;
        switch (i) {
            case 1:
                info.f24662a = 1;
                break;
            case 2:
                info.f24662a = 2;
                break;
            case 3:
                info.f24662a = 3;
                break;
            case 4:
            case 5:
                info.f24662a = 4;
                break;
            default:
                info.f24662a = 0;
                break;
        }
        switch (i2) {
            case 0:
                info.f24663b = 0;
                break;
            case 1:
                info.f24663b = 1;
                break;
            case 2:
                info.f24663b = 2;
                break;
        }
        return info;
    }

    /* renamed from: c */
    private void m21611c() {
        this.f24679l = false;
        if (this.f24680m != null) {
            this.f24680m.cancel();
            this.f24680m = null;
        }
    }

    /* renamed from: d */
    private boolean m21613d() {
        return VERSION.SDK_INT > 19 ? this.f24676h.getState() == 2 ? true : this.f24676h.getState() == 1 ? false : false : this.f24675g.isScreenOn();
    }

    public Info getInfo() {
        if (this.f24672d == null) {
            throw new IllegalStateException("SmotionActivity : start() is not called. ");
        } else if (this.f24670b == 2 || !this.f24677j) {
            return null;
        } else {
            if (!m21613d()) {
                this.f24678k = false;
                updateInfo();
                if (this.f24680m == null) {
                    this.f24680m = new Timer();
                    this.f24680m.schedule(new C6069b(), this.f24681n);
                }
                while (!this.f24678k) {
                    if (this.f24679l) {
                        Log.d("SmotionActivity", "SmotionActivity : getInfo() Time out !!");
                        break;
                    }
                }
                this.f24678k = false;
                m21611c();
            }
            return this.f24669a;
        }
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

    public boolean isUpdateInfoBatchModeSupport() {
        return Smotion.f24652b;
    }

    public void start(int i, ChangeListener changeListener) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("SmotionActivity : Mode value is wrong. ");
        }
        this.f24670b = i;
        if (changeListener == null) {
            throw new IllegalArgumentException("SmotionActivity : ChangeListener is null. ");
        } else if (!f24666i) {
            throw new IllegalStateException("SmotionActivity : This device is not supported. ");
        } else if (this.f24672d == null) {
            this.f24672d = changeListener;
            this.f24669a = new Info();
            this.f24674f = changeListener == null ? null : new C6074a(this, changeListener);
            if (this.f24670b == 1) {
                this.f24673e.registerListener(this.f24674f, 25);
                this.f24682p = true;
                updateInfo();
            } else if (this.f24670b == 2) {
                this.f24673e.registerListener(this.f24674f, 26);
                this.f24671c = System.currentTimeMillis();
            } else if (this.f24670b == 0) {
                this.f24673e.registerListener(this.f24674f, 25);
                this.f24682p = true;
                updateInfo();
                this.f24673e.registerListener(this.f24674f, 26);
            }
            try {
                f24667o.m21598a(f24667o.f24655d, "SmotionActivity.start()");
            } catch (SecurityException e) {
                throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
            }
        } else {
            throw new IllegalStateException("SmotionActivity : ChangeListener is already registered. ");
        }
    }

    public void stop() {
        if (this.f24672d == null) {
            throw new IllegalStateException("SmotionActivity : start() is not called. ");
        }
        if (this.f24673e != null) {
            if (this.f24670b == 1) {
                this.f24673e.unregisterListener(this.f24674f, 25);
            } else if (this.f24670b == 2) {
                this.f24673e.unregisterListener(this.f24674f, 26);
            } else if (this.f24670b == 0) {
                this.f24673e.unregisterListener(this.f24674f, 25);
                this.f24673e.unregisterListener(this.f24674f, 26);
            }
        }
        m21611c();
        this.f24670b = -1;
        this.f24672d = null;
        this.f24669a = null;
        this.f24674f = null;
        this.f24682p = false;
    }

    public void updateInfo() {
        if (this.f24674f == null) {
            throw new IllegalStateException("SmotionActivity : start() is not called. ");
        } else if (this.f24670b == 1) {
            if (!m21613d()) {
                this.f24673e.requestToUpdate(this.f24674f, 25);
            } else if (this.f24682p) {
                this.f24673e.requestToUpdate(this.f24674f, 25);
                this.f24682p = false;
            } else if (this.f24669a != null) {
                this.f24672d.onChanged(this.f24670b, new Info[]{this.f24669a});
            }
        } else if (this.f24670b == 2) {
            if (isUpdateInfoBatchModeSupport()) {
                this.f24673e.requestToUpdate(this.f24674f, 26);
            }
        } else if (this.f24670b == 0) {
            if (!m21613d()) {
                this.f24673e.requestToUpdate(this.f24674f, 25);
            } else if (this.f24682p) {
                this.f24673e.requestToUpdate(this.f24674f, 25);
                this.f24682p = false;
                return;
            } else if (this.f24669a != null) {
                this.f24672d.onChanged(1, new Info[]{this.f24669a});
            }
            if (isUpdateInfoBatchModeSupport()) {
                this.f24673e.requestToUpdate(this.f24674f, 26);
            }
        }
    }
}
