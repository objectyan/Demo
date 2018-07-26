package com.baidu.location.p191d;

import android.os.Looper;
import com.samsung.android.sdk.motion.Smotion;
import com.samsung.android.sdk.motion.SmotionActivityNotification;
import com.samsung.android.sdk.motion.SmotionActivityNotification.ChangeListener;
import com.samsung.android.sdk.motion.SmotionActivityNotification.Info;
import com.samsung.android.sdk.motion.SmotionActivityNotification.InfoFilter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.location.d.l */
public class C3319l {
    /* renamed from: a */
    private static Object f17986a = new Object();
    /* renamed from: b */
    private static C3319l f17987b = null;
    /* renamed from: c */
    private boolean f17988c = false;
    /* renamed from: d */
    private boolean f17989d = false;
    /* renamed from: e */
    private int f17990e = 0;
    /* renamed from: f */
    private Smotion f17991f;
    /* renamed from: g */
    private SmotionActivityNotification f17992g;
    /* renamed from: h */
    private InfoFilter f17993h;
    /* renamed from: i */
    private Info f17994i;
    /* renamed from: j */
    private Looper f17995j;
    /* renamed from: k */
    private List<C3318a> f17996k;
    /* renamed from: l */
    private ChangeListener f17997l = new C33171(this);

    /* renamed from: com.baidu.location.d.l$1 */
    class C33171 implements ChangeListener {
        /* renamed from: a */
        final /* synthetic */ C3319l f17982a;

        C33171(C3319l c3319l) {
            this.f17982a = c3319l;
        }

        public void onChanged(Info info) {
            if (this.f17982a.f17989d) {
                if (this.f17982a.f17996k == null) {
                    this.f17982a.f17996k = new ArrayList();
                }
                if (info != null) {
                    this.f17982a.f17994i = info;
                    this.f17982a.f17996k.add(new C3318a(this.f17982a, info, (long) ((int) (System.currentTimeMillis() / 1000))));
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.l$a */
    private class C3318a {
        /* renamed from: a */
        public Info f17983a;
        /* renamed from: b */
        public long f17984b;
        /* renamed from: c */
        final /* synthetic */ C3319l f17985c;

        C3318a(C3319l c3319l, Info info, long j) {
            this.f17985c = c3319l;
            this.f17983a = info;
            this.f17984b = j;
        }
    }

    /* renamed from: a */
    public static C3319l m13952a() {
        C3319l c3319l;
        synchronized (f17986a) {
            if (f17987b == null) {
                f17987b = new C3319l();
            }
            c3319l = f17987b;
        }
        return c3319l;
    }

    /* renamed from: a */
    public void m13957a(Looper looper) {
        if (looper != null) {
            this.f17995j = looper;
            if (this.f17988c) {
                this.f17992g = new SmotionActivityNotification(looper, this.f17991f);
                if (!this.f17992g.isActivitySupported(4)) {
                    this.f17988c = false;
                } else if (!this.f17992g.isActivitySupported(3)) {
                    this.f17988c = false;
                } else if (!this.f17992g.isActivitySupported(1)) {
                    this.f17988c = false;
                } else if (!this.f17992g.isActivitySupported(2)) {
                    this.f17988c = false;
                }
                if (this.f17988c) {
                    if (this.f17993h == null) {
                        this.f17993h = new InfoFilter();
                    }
                    this.f17993h.addActivity(4);
                    this.f17993h.addActivity(2);
                    this.f17993h.addActivity(1);
                    this.f17993h.addActivity(3);
                    return;
                }
                C3304i.m13904a().m13908b("support", 2);
            }
        }
    }

    /* renamed from: b */
    public void m13958b() {
        if (this.f17988c && !this.f17989d) {
            if (this.f17993h != null) {
                this.f17992g.start(this.f17993h, this.f17997l);
            }
            this.f17989d = true;
        }
    }

    /* renamed from: c */
    public void m13959c() {
        if (this.f17988c && this.f17989d) {
            if (this.f17993h != null) {
                this.f17992g.stop();
            }
            this.f17996k.clear();
            this.f17996k = null;
            this.f17994i = null;
            this.f17989d = false;
        }
    }

    /* renamed from: d */
    public List<Byte> m13960d() {
        if (this.f17996k == null || this.f17996k.size() <= 0) {
            return null;
        }
        int size = this.f17996k.size();
        List<Byte> arrayList = null == null ? new ArrayList() : null;
        arrayList.add(Byte.valueOf((byte) 82));
        arrayList.add(Byte.valueOf((byte) (size & 255)));
        for (int i = 0; i < size; i++) {
            int i2 = 0;
            if (((C3318a) this.f17996k.get(i)).f17983a.getStatus() == 1) {
                i2 = 0;
            } else if (((C3318a) this.f17996k.get(i)).f17983a.getStatus() == 3) {
                i2 = 2;
            } else if (((C3318a) this.f17996k.get(i)).f17983a.getStatus() == 2) {
                i2 = 1;
            } else if (((C3318a) this.f17996k.get(i)).f17983a.getStatus() == 4) {
                i2 = 3;
            } else if (((C3318a) this.f17996k.get(i)).f17983a.getStatus() == 0) {
                i2 = 5;
            }
            int i3 = ((C3318a) this.f17996k.get(i)).f17983a.getAccuracy() == 2 ? 0 : ((C3318a) this.f17996k.get(i)).f17983a.getAccuracy() == 1 ? 1 : ((C3318a) this.f17996k.get(i)).f17983a.getAccuracy() == 0 ? 2 : 0;
            arrayList.add(Byte.valueOf((byte) (((byte) (i3 & 15)) | ((byte) (((byte) (i2 & 15)) << 4)))));
            if (i == size - 1) {
                arrayList.add(Byte.valueOf((byte) ((int) (((System.currentTimeMillis() / 1000) - ((C3318a) this.f17996k.get(i)).f17984b) & 255))));
            } else {
                arrayList.add(Byte.valueOf((byte) ((int) ((((C3318a) this.f17996k.get(i + 1)).f17984b - ((C3318a) this.f17996k.get(i)).f17984b) & 255))));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public void m13961e() {
        if (this.f17996k != null && this.f17994i != null) {
            this.f17996k.clear();
            this.f17996k.add(new C3318a(this, this.f17994i, (long) ((int) (System.currentTimeMillis() / 1000))));
        }
    }
}
