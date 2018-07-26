package com.baidu.tts.p236h.p238b;

import android.content.Context;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p216j.C4958b;
import com.baidu.tts.p233f.C5089g;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/* compiled from: PersistentPool */
/* renamed from: com.baidu.tts.h.b.b */
public class C5107b implements C4958b {
    /* renamed from: a */
    private static volatile C5107b f21210a = null;
    /* renamed from: b */
    private Hashtable<WeakReference<Context>, C5106a> f21211b = new Hashtable();
    /* renamed from: c */
    private WeakReference<Context> f21212c;
    /* renamed from: d */
    private Hashtable<String, Object> f21213d = new Hashtable();

    private C5107b() {
        this.f21213d.put(C5089g.CTP.m17273a(), C2142b.f6818b);
        this.f21213d.put(C5089g.VERSION.m17273a(), "V2.3.0");
    }

    /* renamed from: a */
    public static C5107b m17306a() {
        if (f21210a == null) {
            synchronized (C5107b.class) {
                if (f21210a == null) {
                    f21210a = new C5107b();
                }
            }
        }
        return f21210a;
    }

    /* renamed from: b */
    public TtsError mo3782b() {
        return null;
    }

    /* renamed from: c */
    public void mo3784c() {
    }

    /* renamed from: d */
    public void mo3785d() {
    }

    /* renamed from: e */
    public void mo3786e() {
    }

    /* renamed from: f */
    public void mo3787f() {
        if (this.f21211b != null) {
            this.f21211b.clear();
        }
        this.f21212c = null;
    }

    /* renamed from: a */
    public C5106a m17307a(WeakReference<Context> weakReference) {
        if (weakReference == null) {
            return null;
        }
        C5106a c5106a = (C5106a) this.f21211b.get(weakReference);
        if (c5106a != null) {
            return c5106a;
        }
        c5106a = new C5106a(weakReference);
        this.f21211b.put(weakReference, c5106a);
        return c5106a;
    }

    /* renamed from: g */
    public C5106a m17315g() {
        return m17307a(this.f21212c);
    }

    /* renamed from: h */
    public Context m17316h() {
        return (Context) this.f21212c.get();
    }

    /* renamed from: a */
    public void m17309a(Context context) {
        this.f21212c = new WeakReference(context);
    }

    /* renamed from: a */
    public String m17308a(String str) {
        try {
            return (String) this.f21213d.get(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: i */
    public String m17317i() {
        String str = null;
        try {
            C5106a g = m17315g();
            if (g != null) {
                str = g.m17304a();
            }
        } catch (Exception e) {
        }
        return str;
    }

    /* renamed from: j */
    public String m17318j() {
        return m17308a(C5089g.VERSION.m17273a());
    }
}
