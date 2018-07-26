package com.baidu.carlife.p059c.p064d.p065a;

import android.app.Application;
import android.support.annotation.NonNull;
import com.baidu.carlife.p059c.C1105d;
import com.baidu.carlife.p059c.C1105d.C1091a;
import com.baidu.carlife.p059c.C1141f;
import com.baidu.carlife.p059c.p064d.C1109a;
import com.baidu.carlife.p059c.p064d.C1115c;
import com.baidu.carlife.p059c.p064d.C1116d;
import java.util.List;

/* compiled from: ListViewModel */
/* renamed from: com.baidu.carlife.c.d.a.a */
public abstract class C1110a<T> extends C1109a {
    /* renamed from: a */
    private C1115c<List<T>> f2884a = new C1115c();

    /* compiled from: ListViewModel */
    /* renamed from: com.baidu.carlife.c.d.a.a$1 */
    class C11061 extends C1105d<Void, List<T>> {
        /* renamed from: a */
        final /* synthetic */ C1110a f2881a;

        C11061(C1110a this$0) {
            this.f2881a = this$0;
        }

        /* renamed from: a */
        public void m3733a(Void input) {
            List<T> data = this.f2881a.m3750e();
            if (data == null) {
                m3729a().mo1408a();
            } else {
                m3729a().mo1409a(data);
            }
        }
    }

    /* compiled from: ListViewModel */
    /* renamed from: com.baidu.carlife.c.d.a.a$2 */
    class C11072 implements C1091a<List<T>> {
        /* renamed from: a */
        final /* synthetic */ C1110a f2882a;

        C11072(C1110a this$0) {
            this.f2882a = this$0;
        }

        /* renamed from: a */
        public void m3736a(List<T> output) {
            this.f2882a.f2884a.mo1419b(output);
        }

        /* renamed from: a */
        public void mo1408a() {
        }

        /* renamed from: b */
        public void mo1410b() {
        }
    }

    /* renamed from: e */
    protected abstract List<T> m3750e();

    public C1110a(@NonNull Application application) {
        super(application);
    }

    /* renamed from: a */
    public T m3742a(int position) {
        if (!m3741f()) {
            return ((List) this.f2884a.m3762b()).get(position);
        }
        throw new IllegalStateException("data unavailable");
    }

    /* renamed from: c */
    public void m3748c() {
        C1141f.m3839a().m3841a(new C11061(this), null, new C11072(this));
    }

    /* renamed from: d */
    public int m3749d() {
        if (m3741f()) {
            return 0;
        }
        return ((List) this.f2884a.m3762b()).size();
    }

    /* renamed from: f */
    private boolean m3741f() {
        return this.f2884a == null || this.f2884a.m3762b() == null || ((List) this.f2884a.m3762b()).isEmpty();
    }

    /* renamed from: b */
    public void m3746b(int position) {
        if (!m3741f()) {
            List<T> models = (List) this.f2884a.m3762b();
            if (position < models.size()) {
                models.remove(position);
                this.f2884a.mo1419b(models);
            }
        }
    }

    /* renamed from: a */
    public void m3744a(T model) {
        if (!m3741f()) {
            List<T> models = (List) this.f2884a.m3762b();
            models.remove(model);
            this.f2884a.mo1419b(models);
        }
    }

    /* renamed from: a */
    public void m3745a(T model, int position) {
        if (!m3741f()) {
            List<T> models = (List) this.f2884a.m3762b();
            if (position < models.size()) {
                models.set(position, model);
                this.f2884a.mo1419b(models);
            }
        }
    }

    /* renamed from: a */
    public void m3743a(C1116d<List<T>> observer) {
        this.f2884a.m3760a((C1116d) observer);
    }

    /* renamed from: b */
    public void m3747b(C1116d<List<T>> observer) {
        this.f2884a.m3763b((C1116d) observer);
    }
}
