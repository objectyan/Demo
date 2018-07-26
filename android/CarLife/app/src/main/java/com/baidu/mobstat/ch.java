package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

class ch {
    /* renamed from: a */
    private static final ch f19569a = new ch();
    /* renamed from: o */
    private static HashMap<String, cm> f19570o = new HashMap();
    /* renamed from: b */
    private cn f19571b = new cn();
    /* renamed from: c */
    private cn f19572c = new cn();
    /* renamed from: d */
    private cn f19573d = new cn();
    /* renamed from: e */
    private cn f19574e = new cn();
    /* renamed from: f */
    private long f19575f = 0;
    /* renamed from: g */
    private boolean f19576g = true;
    /* renamed from: h */
    private boolean f19577h;
    /* renamed from: i */
    private cf f19578i = new cf();
    /* renamed from: j */
    private int f19579j = -1;
    /* renamed from: k */
    private volatile int f19580k;
    /* renamed from: l */
    private volatile long f19581l;
    /* renamed from: m */
    private Handler f19582m;
    /* renamed from: n */
    private Runnable f19583n = null;

    /* renamed from: a */
    public static ch m15571a() {
        return f19569a;
    }

    private ch() {
        HandlerThread handlerThread = new HandlerThread("SessionAnalysisThread");
        handlerThread.start();
        handlerThread.setPriority(10);
        this.f19582m = new Handler(handlerThread.getLooper());
    }

    /* renamed from: b */
    public int m15594b() {
        return this.f19580k;
    }

    /* renamed from: c */
    public int m15601c() {
        if (this.f19579j == -1) {
            this.f19579j = 30000;
        }
        return this.f19579j;
    }

    /* renamed from: a */
    public void m15584a(int i) {
        this.f19579j = i * 1000;
    }

    /* renamed from: d */
    public void m15602d() {
        this.f19578i.m15550a();
    }

    /* renamed from: a */
    public void m15585a(long j) {
        this.f19578i.m15552a(j);
    }

    /* renamed from: b */
    public void m15596b(long j) {
        this.f19578i.m15555b(j);
    }

    /* renamed from: b */
    public void m15595b(int i) {
        this.f19578i.m15551a(i);
    }

    /* renamed from: e */
    public long m15603e() {
        return this.f19578i.m15554b();
    }

    /* renamed from: g */
    private boolean m15581g() {
        return this.f19576g;
    }

    /* renamed from: a */
    private void m15576a(boolean z) {
        this.f19576g = z;
    }

    /* renamed from: a */
    public void m15588a(Context context, long j) {
        if (this.f19581l == 0) {
            this.f19582m.post(new ci(this, j));
        }
        this.f19581l = j;
    }

    /* renamed from: b */
    public void m15599b(Context context, long j) {
        this.f19582m.post(new cj(this, j, context));
    }

    /* renamed from: a */
    public void m15589a(Context context, long j, String str) {
        db.m15657a("AnalysisPageStart");
        if (TextUtils.isEmpty(str)) {
            db.m15663c("自定义页面 pageName 为 null");
            return;
        }
        cm b = m15578b(str);
        if (b == null) {
            db.m15663c("get page info, PageInfo null");
            return;
        }
        if (b.f19593b) {
            db.m15663c("遗漏StatService.onPageEnd() || missing StatService.onPageEnd()");
        }
        b.f19593b = true;
        b.f19594c = j;
        m15583i();
        if (!this.f19577h) {
            this.f19582m.post(new cp(this, this.f19575f, j, this.f19581l, context, null, null, m15582h(), 1));
            this.f19577h = true;
        }
        this.f19571b.f19597b = new WeakReference(context);
        this.f19571b.f19596a = j;
    }

    /* renamed from: h */
    private int m15582h() {
        Class cls;
        Class cls2;
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (ClassNotFoundException e) {
            cls = null;
        }
        try {
            cls2 = Class.forName("android.support.v4.app.Fragment");
        } catch (ClassNotFoundException e2) {
            cls2 = null;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            Object className = stackTrace[i].getClassName();
            Object methodName = stackTrace[i].getMethodName();
            if (!(TextUtils.isEmpty(className) || TextUtils.isEmpty(methodName) || !methodName.equals("onResume"))) {
                Class cls3;
                try {
                    cls3 = Class.forName(className);
                } catch (Throwable th) {
                    cls3 = null;
                }
                if (cls3 == null) {
                    continue;
                } else if (Activity.class.isAssignableFrom(cls3)) {
                    return 1;
                } else {
                    if (cls != null && cls.isAssignableFrom(cls3)) {
                        return 2;
                    }
                    if (cls2 != null && cls2.isAssignableFrom(cls3)) {
                        return 2;
                    }
                }
            }
        }
        return 3;
    }

    /* renamed from: a */
    public void m15590a(Context context, long j, String str, String str2, ExtraInfo extraInfo) {
        db.m15657a("post pause job");
        this.f19577h = false;
        if (TextUtils.isEmpty(str2)) {
            db.m15663c("自定义页面 pageName 无效值");
            return;
        }
        cm b = m15578b(str2);
        if (b == null) {
            db.m15663c("get page info, PageInfo null");
        } else if (b.f19593b) {
            b.f19593b = false;
            b.f19595d = j;
            this.f19582m.post(new co(this, j, context, null, b.f19594c, (Context) this.f19571b.f19597b.get(), null, 1, str2, null, null, str, false, extraInfo, b));
            m15580c(str2);
            this.f19575f = j;
        } else {
            db.m15663c("Please check (1)遗漏StatService.onPageStart() || missing StatService.onPageStart()");
        }
    }

    /* renamed from: a */
    public void m15593a(Fragment fragment, long j) {
        db.m15657a("post resume job");
        if (this.f19572c.f19598c) {
            db.m15663c("遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.f19572c.f19598c = true;
        m15583i();
        this.f19582m.post(new cp(this, this.f19575f, j, this.f19581l, null, fragment, null, 2, 2));
        this.f19572c.f19597b = new WeakReference(fragment);
        this.f19572c.f19596a = j;
    }

    @TargetApi(11)
    /* renamed from: a */
    public void m15586a(android.app.Fragment fragment, long j) {
        db.m15657a("post resume job");
        if (this.f19573d.f19598c) {
            db.m15663c("遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.f19573d.f19598c = true;
        m15583i();
        this.f19582m.post(new cp(this, this.f19575f, j, this.f19581l, null, null, fragment, 2, 3));
        this.f19573d.f19597b = new WeakReference(fragment);
        this.f19573d.f19596a = j;
    }

    /* renamed from: a */
    public void m15591a(Context context, long j, boolean z) {
        if (z) {
            this.f19574e.f19598c = true;
            this.f19574e.f19597b = new WeakReference(context);
            this.f19574e.f19596a = j;
        }
        db.m15657a("AnalysisResume job");
        if (!z && this.f19571b.f19598c) {
            db.m15663c("遗漏StatService.onPause() || missing StatService.onPause()");
        }
        if (!z) {
            this.f19571b.f19598c = true;
        }
        m15583i();
        if (!this.f19577h) {
            this.f19582m.post(new cp(this, this.f19575f, j, this.f19581l, context, null, null, 1, 1));
            this.f19577h = true;
        }
        this.f19571b.f19597b = new WeakReference(context);
        this.f19571b.f19596a = j;
    }

    /* renamed from: i */
    private void m15583i() {
        boolean g = m15581g();
        db.m15657a("isFirstResume:" + g);
        if (g) {
            m15576a(false);
            this.f19582m.post(new ck(this));
        }
    }

    /* renamed from: a */
    public void m15592a(Context context, long j, boolean z, ExtraInfo extraInfo) {
        db.m15657a("post pause job");
        this.f19577h = false;
        if (z) {
            this.f19574e.f19598c = false;
            this.f19582m.post(new co(this, j, context, null, this.f19574e.f19596a, (Context) this.f19574e.f19597b.get(), null, 1, null, null, null, null, z, extraInfo, null));
            this.f19575f = j;
        } else if (this.f19571b.f19598c) {
            this.f19571b.f19598c = false;
            this.f19582m.post(new co(this, j, context, null, this.f19571b.f19596a, (Context) this.f19571b.f19597b.get(), null, 1, null, null, null, null, z, extraInfo, null));
            this.f19575f = j;
        } else {
            db.m15663c("遗漏StatService.onResume() || missing StatService.onResume()");
        }
    }

    /* renamed from: b */
    public void m15600b(Fragment fragment, long j) {
        db.m15657a("post pause job");
        if (this.f19572c.f19598c) {
            this.f19572c.f19598c = false;
            this.f19582m.post(new co(this, j, null, fragment, this.f19572c.f19596a, null, (Fragment) this.f19572c.f19597b.get(), 2, null, null, null, null, false, null, null));
            this.f19575f = j;
            return;
        }
        db.m15663c("遗漏android.support.v4.app.Fragment StatService.onResume() || android.support.v4.app.Fragment missing StatService.onResume()");
    }

    @TargetApi(11)
    /* renamed from: b */
    public void m15597b(android.app.Fragment fragment, long j) {
        db.m15657a("post pause job");
        if (this.f19573d.f19598c) {
            this.f19573d.f19598c = false;
            this.f19582m.post(new co(this, j, null, null, this.f19573d.f19596a, null, null, 3, null, this.f19573d.f19597b.get(), fragment, null, false, null, null));
            this.f19575f = j;
            return;
        }
        db.m15663c("遗漏android.app.Fragment StatService.onResume() || android.app.Fragment missing StatService.onResume()");
    }

    /* renamed from: a */
    public void m15587a(Context context) {
        this.f19583n = new cl(this, context);
        this.f19582m.postDelayed(this.f19583n, (long) m15601c());
    }

    /* renamed from: f */
    public void m15604f() {
        Runnable runnable = this.f19583n;
        this.f19583n = null;
        if (runnable != null) {
            this.f19582m.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    private void m15572a(Context context, boolean z) {
        if (this.f19578i.m15556c() > 0) {
            String jSONObject = this.f19578i.m15558d().toString();
            db.m15657a("new session: " + jSONObject);
            DataCore.instance().putSession(jSONObject);
            DataCore.instance().flush(context);
            this.f19578i.m15559d(0);
        }
        if (z) {
            m15602d();
        }
        DataCore.instance().saveLogDataToSend(context, z, false);
        by.m15524a().m15541a(context);
        m15598b(context);
    }

    /* renamed from: c */
    private void m15579c(Context context) {
        String jSONObject = this.f19578i.m15558d().toString();
        this.f19580k = jSONObject.getBytes().length;
        db.m15657a("cacheString = " + jSONObject);
        cu.m15630a(context, de.m15706q(context) + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
    }

    /* renamed from: b */
    public void m15598b(Context context) {
        if (context == null) {
            db.m15657a("clearLastSession context is null, invalid");
            return;
        }
        cu.m15630a(context, de.m15706q(context) + Config.LAST_SESSION_FILE_NAME, new JSONObject().toString(), false);
    }

    /* renamed from: a */
    static Context m15569a(Object obj) {
        try {
            return (Context) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable th) {
            db.m15657a(th.getMessage());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m15575a(java.lang.String r4) {
        /*
        r3 = this;
        r1 = f19570o;
        monitor-enter(r1);
        if (r4 != 0) goto L_0x000d;
    L_0x0005:
        r0 = "page Object is null";
        com.baidu.mobstat.db.m15663c(r0);	 Catch:{ all -> 0x0021 }
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = new com.baidu.mobstat.cm;	 Catch:{ all -> 0x0021 }
        r0.<init>(r4);	 Catch:{ all -> 0x0021 }
        r2 = f19570o;	 Catch:{ all -> 0x0021 }
        r2 = r2.containsKey(r4);	 Catch:{ all -> 0x0021 }
        if (r2 != 0) goto L_0x001f;
    L_0x001a:
        r2 = f19570o;	 Catch:{ all -> 0x0021 }
        r2.put(r4, r0);	 Catch:{ all -> 0x0021 }
    L_0x001f:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        goto L_0x000c;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.ch.a(java.lang.String):void");
    }

    /* renamed from: b */
    private cm m15578b(String str) {
        cm cmVar;
        synchronized (f19570o) {
            if (!f19570o.containsKey(str)) {
                m15575a(str);
            }
            cmVar = (cm) f19570o.get(str);
        }
        return cmVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private void m15580c(java.lang.String r3) {
        /*
        r2 = this;
        r1 = f19570o;
        monitor-enter(r1);
        if (r3 != 0) goto L_0x000d;
    L_0x0005:
        r0 = "pageName is null";
        com.baidu.mobstat.db.m15663c(r0);	 Catch:{ all -> 0x001c }
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
    L_0x000c:
        return;
    L_0x000d:
        r0 = f19570o;	 Catch:{ all -> 0x001c }
        r0 = r0.containsKey(r3);	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x001a;
    L_0x0015:
        r0 = f19570o;	 Catch:{ all -> 0x001c }
        r0.remove(r3);	 Catch:{ all -> 0x001c }
    L_0x001a:
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        goto L_0x000c;
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.ch.c(java.lang.String):void");
    }
}
