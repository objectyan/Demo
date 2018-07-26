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

public class SmotionPedometer {
    /* renamed from: f */
    private static boolean f24714f;
    /* renamed from: l */
    private static Smotion f24715l = null;
    /* renamed from: n */
    private static final Object f24716n = new Object();
    /* renamed from: a */
    private Info f24717a;
    /* renamed from: b */
    private C6072a f24718b;
    /* renamed from: c */
    private ChangeListener f24719c = null;
    /* renamed from: d */
    private SContextListener f24720d = null;
    /* renamed from: e */
    private PowerManager f24721e;
    /* renamed from: g */
    private boolean f24722g = false;
    /* renamed from: h */
    private Timer f24723h = null;
    /* renamed from: i */
    private boolean f24724i = false;
    /* renamed from: j */
    private boolean f24725j = false;
    /* renamed from: k */
    private long f24726k = 3000;
    /* renamed from: m */
    private boolean f24727m = false;
    /* renamed from: o */
    private Display f24728o;

    public interface ChangeListener {
        void onChanged(Info info);
    }

    public static class Info {
        public static final int COUNT_RUN_DOWN = 5;
        public static final int COUNT_RUN_FLAT = 6;
        public static final int COUNT_RUN_UP = 4;
        public static final int COUNT_TOTAL = 0;
        public static final int COUNT_WALK_DOWN = 2;
        public static final int COUNT_WALK_FLAT = 3;
        public static final int COUNT_WALK_UP = 1;
        public static final int STATUS_RUN_DOWN = 5;
        public static final int STATUS_RUN_FLAT = 6;
        public static final int STATUS_RUN_UP = 4;
        public static final int STATUS_STOP = 0;
        public static final int STATUS_UNKNOWN = -1;
        public static final int STATUS_WALK_DOWN = 2;
        public static final int STATUS_WALK_FLAT = 3;
        public static final int STATUS_WALK_UP = 1;
        /* renamed from: a */
        private long f24701a;
        /* renamed from: b */
        private long f24702b;
        /* renamed from: c */
        private long f24703c;
        /* renamed from: d */
        private long f24704d;
        /* renamed from: e */
        private long f24705e;
        /* renamed from: f */
        private long f24706f;
        /* renamed from: g */
        private long f24707g;
        /* renamed from: h */
        private double f24708h;
        /* renamed from: i */
        private double f24709i;
        /* renamed from: j */
        private double f24710j;
        /* renamed from: k */
        private int f24711k;
        /* renamed from: l */
        private long f24712l;

        public Info() {
            if (SmotionPedometer.f24715l == null) {
                throw new IllegalStateException("SmotionPedometer.Info : SmotionPedometer is not created. ");
            } else if (!SmotionPedometer.f24714f) {
                throw new IllegalStateException("SmotionPedometer.Info : This device is not supported. ");
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m21627a(Info info, int i, long j) {
            switch (i) {
                case 0:
                    info.f24701a = j;
                    return;
                case 1:
                    info.f24702b = j;
                    return;
                case 2:
                    info.f24703c = j;
                    return;
                case 3:
                    info.f24704d = j;
                    return;
                case 4:
                    info.f24705e = j;
                    return;
                case 5:
                    info.f24706f = j;
                    return;
                case 6:
                    info.f24707g = j;
                    return;
                default:
                    return;
            }
        }

        public double getCalorie() {
            return this.f24710j;
        }

        public long getCount(int i) {
            if (i < 0 || i > 6) {
                throw new IllegalArgumentException("SmotionPedometer : type value is wrong. ");
            }
            switch (i) {
                case 0:
                    return this.f24701a;
                case 1:
                    return this.f24702b;
                case 2:
                    return this.f24703c;
                case 3:
                    return this.f24704d;
                case 4:
                    return this.f24705e;
                case 5:
                    return this.f24706f;
                case 6:
                    return this.f24707g;
                default:
                    return 0;
            }
        }

        public double getDistance() {
            return this.f24709i;
        }

        public double getSpeed() {
            return this.f24708h;
        }

        public int getStatus() {
            return this.f24711k;
        }

        public long getTimeStamp() {
            return this.f24712l;
        }
    }

    /* renamed from: com.samsung.android.sdk.motion.SmotionPedometer$a */
    private static class C6072a extends SContextManager {
        public C6072a(Looper looper) {
            super(looper);
        }

        public final boolean registerListener(SContextListener sContextListener, int i) {
            return super.registerListener(sContextListener, i);
        }

        public final void unregisterListener(SContextListener sContextListener) {
            super.unregisterListener(sContextListener);
        }

        public final void unregisterListener(SContextListener sContextListener, int i) {
            super.unregisterListener(sContextListener, i);
        }
    }

    /* renamed from: com.samsung.android.sdk.motion.SmotionPedometer$b */
    private class C6073b extends TimerTask {
        /* renamed from: a */
        private /* synthetic */ SmotionPedometer f24713a;

        private C6073b(SmotionPedometer smotionPedometer) {
            this.f24713a = smotionPedometer;
        }

        public final void run() {
            this.f24713a.f24722g = true;
        }
    }

    public SmotionPedometer(Looper looper, Smotion smotion) {
        if (looper == null) {
            throw new NullPointerException("SmotionPedometer : Looper is null. ");
        } else if (smotion == null) {
            throw new NullPointerException("SmotionPedometer : Smotion is null. ");
        } else if (smotion.f24655d == null) {
            throw new IllegalArgumentException("SmotionPedometer : Smotion.initialize() is not called. ");
        } else if (smotion.f24654a) {
            this.f24718b = new C6072a(looper);
            synchronized (f24716n) {
                f24715l = smotion;
            }
            boolean isFeatureEnabled = f24715l.isFeatureEnabled(1);
            synchronized (f24716n) {
                f24714f = isFeatureEnabled;
            }
            this.f24721e = (PowerManager) smotion.f24655d.getSystemService("power");
            this.f24728o = ((WindowManager) smotion.f24655d.getSystemService("window")).getDefaultDisplay();
            if (!f24714f) {
                throw new IllegalStateException("SmotionPedometer : This device is not supported. ");
            }
        } else {
            throw new IllegalStateException("SmotionPedometer : Smotion.initialize() is not successful. ");
        }
    }

    /* renamed from: c */
    private boolean m21637c() {
        return VERSION.SDK_INT > 19 ? this.f24728o.getState() == 2 ? true : this.f24728o.getState() == 1 ? false : false : this.f24721e.isScreenOn();
    }

    /* renamed from: d */
    private void m21638d() {
        this.f24722g = false;
        if (this.f24723h != null) {
            this.f24723h.cancel();
            this.f24723h = null;
        }
    }

    public Info getInfo() {
        if (this.f24719c == null) {
            throw new IllegalStateException("SmotionPedometer : start() is not called. ");
        }
        if (!m21637c()) {
            this.f24724i = false;
            updateInfo();
            if (this.f24723h == null) {
                this.f24723h = new Timer();
                this.f24723h.schedule(new C6073b(), this.f24726k);
            }
            while (!this.f24724i) {
                if (this.f24722g) {
                    Log.d("SmotionPedometer", "SmotionPedometer : getInfo() Time out !!");
                    break;
                }
            }
            this.f24724i = false;
            m21638d();
        }
        return !this.f24725j ? null : this.f24717a;
    }

    public void start(ChangeListener changeListener) {
        if (changeListener == null) {
            throw new IllegalArgumentException("SmotionPedometer : Listener is null. ");
        } else if (!f24714f) {
            throw new IllegalStateException("SmotionPedometer : This device is not supported. ");
        } else if (this.f24719c == null) {
            this.f24719c = changeListener;
            this.f24717a = new Info();
            this.f24720d = changeListener == null ? null : new C6077d(this, changeListener);
            this.f24718b.registerListener(this.f24720d, 2);
            this.f24727m = true;
            updateInfo();
            try {
                f24715l.m21598a(f24715l.f24655d, "SmotionPedometer.start()");
            } catch (SecurityException e) {
                throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
            }
        } else {
            throw new IllegalStateException("SmotionPedometer : ChangeListener is already registered. ");
        }
    }

    public void stop() {
        if (this.f24719c == null) {
            throw new IllegalStateException("SmotionPedometer : start() is not called. ");
        }
        if (this.f24718b != null) {
            this.f24718b.unregisterListener(this.f24720d, 2);
        }
        m21638d();
        this.f24719c = null;
        this.f24717a = null;
        this.f24720d = null;
    }

    public void updateInfo() {
        if (this.f24720d == null) {
            throw new IllegalStateException("SmotionPedometer : start() is not called. ");
        } else if (!m21637c()) {
            this.f24718b.requestToUpdate(this.f24720d, 2);
        } else if (this.f24727m) {
            this.f24718b.requestToUpdate(this.f24720d, 2);
            this.f24727m = false;
        } else if (this.f24717a != null) {
            this.f24719c.onChanged(this.f24717a);
        }
    }
}
