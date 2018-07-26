package com.facebook.drawee.p143c;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p257e.C5320a;
import com.facebook.drawee.p142g.C2925a;
import com.facebook.drawee.p142g.C5422b;
import com.facebook.drawee.p142g.C5423c;
import com.facebook.drawee.p266b.C5391a;
import com.facebook.drawee.p266b.C5391a.C5390a;
import com.facebook.drawee.p266b.C5393b;
import com.facebook.drawee.p266b.C5393b.C5392a;
import com.facebook.drawee.p266b.C5394c;
import com.facebook.drawee.p267f.C5421a;
import com.facebook.drawee.p267f.C5421a.C5420a;
import com.facebook.p138c.C2918d;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: AbstractDraweeController */
/* renamed from: com.facebook.drawee.c.a */
public abstract class C2926a<T, INFO> implements C5390a, C5420a, C2925a {
    /* renamed from: a */
    private static final Class<?> f12895a = C2926a.class;
    /* renamed from: b */
    private final C5393b f12896b = C5393b.a();
    /* renamed from: c */
    private final C5391a f12897c;
    /* renamed from: d */
    private final Executor f12898d;
    @Nullable
    /* renamed from: e */
    private C5394c f12899e;
    @Nullable
    /* renamed from: f */
    private C5421a f12900f;
    @Nullable
    /* renamed from: g */
    private C5396d<INFO> f12901g;
    @Nullable
    /* renamed from: h */
    private C5423c f12902h;
    @Nullable
    /* renamed from: i */
    private Drawable f12903i;
    /* renamed from: j */
    private String f12904j;
    /* renamed from: k */
    private Object f12905k;
    /* renamed from: l */
    private boolean f12906l;
    /* renamed from: m */
    private boolean f12907m;
    /* renamed from: n */
    private boolean f12908n;
    /* renamed from: o */
    private boolean f12909o;
    @Nullable
    /* renamed from: p */
    private String f12910p;
    @Nullable
    /* renamed from: q */
    private C2918d<T> f12911q;
    @Nullable
    /* renamed from: r */
    private T f12912r;
    @Nullable
    /* renamed from: s */
    private Drawable f12913s;

    /* renamed from: a */
    protected abstract void mo2029a(@Nullable Drawable drawable);

    /* renamed from: a */
    protected abstract void mo2030a(@Nullable T t);

    /* renamed from: b */
    protected abstract C2918d<T> mo2032b();

    @Nullable
    /* renamed from: c */
    protected abstract INFO mo2034c(T t);

    /* renamed from: d */
    protected abstract Drawable mo2035d(T t);

    public C2926a(C5391a deferredReleaser, Executor uiThreadImmediateExecutor, String id, Object callerContext) {
        this.f12897c = deferredReleaser;
        this.f12898d = uiThreadImmediateExecutor;
        m11302a(id, callerContext, true);
    }

    /* renamed from: a */
    protected void m11314a(String id, Object callerContext) {
        m11302a(id, callerContext, false);
    }

    /* renamed from: a */
    private void m11302a(String id, Object callerContext, boolean justConstructed) {
        this.f12896b.a(C5392a.f22010f);
        if (!(justConstructed || this.f12897c == null)) {
            this.f12897c.b(this);
        }
        this.f12906l = false;
        mo2028a();
        this.f12909o = false;
        if (this.f12899e != null) {
            this.f12899e.b();
        }
        if (this.f12900f != null) {
            this.f12900f.a();
            this.f12900f.a(this);
        }
        if (this.f12901g instanceof a$a) {
            ((a$a) this.f12901g).b();
        } else {
            this.f12901g = null;
        }
        if (this.f12902h != null) {
            this.f12902h.b();
            this.f12902h.a(null);
            this.f12902h = null;
        }
        this.f12903i = null;
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f12904j, id);
        }
        this.f12904j = id;
        this.f12905k = callerContext;
    }

    /* renamed from: f */
    public void m11325f() {
        this.f12896b.a(C5392a.f22013i);
        if (this.f12899e != null) {
            this.f12899e.c();
        }
        if (this.f12900f != null) {
            this.f12900f.b();
        }
        if (this.f12902h != null) {
            this.f12902h.b();
        }
        mo2028a();
    }

    /* renamed from: a */
    private void mo2028a() {
        boolean wasRequestSubmitted = this.f12907m;
        this.f12907m = false;
        this.f12908n = false;
        if (this.f12911q != null) {
            this.f12911q.mo2019h();
            this.f12911q = null;
        }
        if (this.f12913s != null) {
            mo2029a(this.f12913s);
        }
        if (this.f12910p != null) {
            this.f12910p = null;
        }
        this.f12913s = null;
        if (this.f12912r != null) {
            m11305b("release", this.f12912r);
            mo2030a(this.f12912r);
            this.f12912r = null;
        }
        if (wasRequestSubmitted) {
            m11331l().a(this.f12904j);
        }
    }

    /* renamed from: g */
    public String m11326g() {
        return this.f12904j;
    }

    /* renamed from: h */
    public Object m11327h() {
        return this.f12905k;
    }

    @Nullable
    /* renamed from: i */
    protected C5394c m11328i() {
        return this.f12899e;
    }

    /* renamed from: a */
    protected void m11308a(@Nullable C5394c retryManager) {
        this.f12899e = retryManager;
    }

    @Nullable
    /* renamed from: j */
    protected C5421a m11329j() {
        return this.f12900f;
    }

    /* renamed from: a */
    protected void m11310a(@Nullable C5421a gestureDetector) {
        this.f12900f = gestureDetector;
        if (this.f12900f != null) {
            this.f12900f.a(this);
        }
    }

    /* renamed from: a */
    protected void m11315a(boolean enabled) {
        this.f12909o = enabled;
    }

    @Nullable
    /* renamed from: k */
    public String mo2023k() {
        return this.f12910p;
    }

    /* renamed from: a */
    public void mo2021a(@Nullable String contentDescription) {
        this.f12910p = contentDescription;
    }

    /* renamed from: a */
    public void m11309a(C5396d<? super INFO> controllerListener) {
        C5350k.a(controllerListener);
        if (this.f12901g instanceof a$a) {
            ((a$a) this.f12901g).b(controllerListener);
        } else if (this.f12901g != null) {
            this.f12901g = a$a.a(this.f12901g, controllerListener);
        } else {
            this.f12901g = controllerListener;
        }
    }

    /* renamed from: b */
    public void m11320b(C5396d<? super INFO> controllerListener) {
        C5350k.a(controllerListener);
        if (this.f12901g instanceof a$a) {
            ((a$a) this.f12901g).c(controllerListener);
        } else if (this.f12901g == controllerListener) {
            this.f12901g = null;
        }
    }

    /* renamed from: l */
    protected C5396d<INFO> m11331l() {
        if (this.f12901g == null) {
            return C5398c.a();
        }
        return this.f12901g;
    }

    @Nullable
    /* renamed from: m */
    public C5422b mo2024m() {
        return this.f12902h;
    }

    /* renamed from: a */
    public void mo2020a(@Nullable C5422b hierarchy) {
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f12904j, hierarchy);
        }
        this.f12896b.a(hierarchy != null ? C5392a.f22005a : C5392a.f22006b);
        if (this.f12907m) {
            this.f12897c.b(this);
            m11325f();
        }
        if (this.f12902h != null) {
            this.f12902h.a(null);
            this.f12902h = null;
        }
        if (hierarchy != null) {
            C5350k.a(hierarchy instanceof C5423c);
            this.f12902h = (C5423c) hierarchy;
            this.f12902h.a(this.f12903i);
        }
    }

    /* renamed from: b */
    protected void m11319b(@Nullable Drawable controllerOverlay) {
        this.f12903i = controllerOverlay;
        if (this.f12902h != null) {
            this.f12902h.a(this.f12903i);
        }
    }

    @Nullable
    /* renamed from: n */
    protected Drawable m11333n() {
        return this.f12903i;
    }

    /* renamed from: o */
    public void mo2025o() {
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f12904j, this.f12907m ? "request already submitted" : "request needs submit");
        }
        this.f12896b.a(C5392a.f22011g);
        C5350k.a(this.f12902h);
        this.f12897c.b(this);
        this.f12906l = true;
        if (!this.f12907m) {
            m11338s();
        }
    }

    /* renamed from: p */
    public void mo2026p() {
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f12904j);
        }
        this.f12896b.a(C5392a.f22012h);
        this.f12906l = false;
        this.f12897c.a(this);
    }

    /* renamed from: a */
    public boolean mo2022a(MotionEvent event) {
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f12904j, event);
        }
        if (this.f12900f == null) {
            return false;
        }
        if (!this.f12900f.c() && !m11336q()) {
            return false;
        }
        this.f12900f.a(event);
        return true;
    }

    /* renamed from: q */
    protected boolean m11336q() {
        return mo2033c();
    }

    /* renamed from: c */
    private boolean mo2033c() {
        return this.f12908n && this.f12899e != null && this.f12899e.e();
    }

    /* renamed from: r */
    public boolean m11337r() {
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.f12904j);
        }
        if (!mo2033c()) {
            return false;
        }
        this.f12899e.f();
        this.f12902h.b();
        m11338s();
        return true;
    }

    /* renamed from: s */
    protected void m11338s() {
        T closeableImage = mo2036e();
        if (closeableImage != null) {
            this.f12911q = null;
            this.f12907m = true;
            this.f12908n = false;
            this.f12896b.a(C5392a.f22030z);
            m11331l().a(this.f12904j, this.f12905k);
            m11300a(this.f12904j, this.f12911q, closeableImage, 1.0f, true, true);
            return;
        }
        this.f12896b.a(C5392a.f22014j);
        m11331l().a(this.f12904j, this.f12905k);
        this.f12902h.a(0.0f, true);
        this.f12907m = true;
        this.f12908n = false;
        this.f12911q = mo2032b();
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f12904j, Integer.valueOf(System.identityHashCode(this.f12911q)));
        }
        this.f12911q.mo2011a(new a$1(this, this.f12904j, this.f12911q.mo2014c()), this.f12898d);
    }

    /* renamed from: a */
    private void m11300a(String id, C2918d<T> dataSource, @Nullable T image, float progress, boolean isFinished, boolean wasImmediate) {
        if (m11304a(id, (C2918d) dataSource)) {
            this.f12896b.a(isFinished ? C5392a.f22015k : C5392a.f22016l);
            try {
                Drawable drawable = mo2035d(image);
                Object previousImage = this.f12912r;
                Drawable previousDrawable = this.f12913s;
                this.f12912r = image;
                this.f12913s = drawable;
                if (isFinished) {
                    try {
                        m11305b("set_final_result @ onNewResult", image);
                        this.f12911q = null;
                        this.f12902h.a(drawable, 1.0f, wasImmediate);
                        m11331l().a(id, mo2034c(image), mo2027t());
                    } catch (Throwable th) {
                        if (!(previousDrawable == null || previousDrawable == drawable)) {
                            mo2029a(previousDrawable);
                        }
                        if (!(previousImage == null || previousImage == image)) {
                            m11305b("release_previous_result @ onNewResult", previousImage);
                            mo2030a(previousImage);
                        }
                    }
                } else {
                    m11305b("set_intermediate_result @ onNewResult", image);
                    this.f12902h.a(drawable, progress, wasImmediate);
                    m11331l().b(id, mo2034c(image));
                }
                if (!(previousDrawable == null || previousDrawable == drawable)) {
                    mo2029a(previousDrawable);
                }
                if (previousImage != null && previousImage != image) {
                    m11305b("release_previous_result @ onNewResult", previousImage);
                    mo2030a(previousImage);
                    return;
                }
                return;
            } catch (Throwable exception) {
                m11305b("drawable_failed @ onNewResult", image);
                mo2030a((Object) image);
                m11301a(id, (C2918d) dataSource, exception, isFinished);
                return;
            }
        }
        m11305b("ignore_old_datasource @ onNewResult", image);
        mo2030a((Object) image);
        dataSource.mo2019h();
    }

    /* renamed from: a */
    private void m11301a(String id, C2918d<T> dataSource, Throwable throwable, boolean isFinished) {
        if (m11304a(id, (C2918d) dataSource)) {
            this.f12896b.a(isFinished ? C5392a.f22017m : C5392a.f22018n);
            if (isFinished) {
                m11303a("final_failed @ onFailure", throwable);
                this.f12911q = null;
                this.f12908n = true;
                if (this.f12909o && this.f12913s != null) {
                    this.f12902h.a(this.f12913s, 1.0f, true);
                } else if (mo2033c()) {
                    this.f12902h.b(throwable);
                } else {
                    this.f12902h.a(throwable);
                }
                m11331l().b(this.f12904j, throwable);
                return;
            }
            m11303a("intermediate_failed @ onFailure", throwable);
            m11331l().a(this.f12904j, throwable);
            return;
        }
        m11303a("ignore_old_datasource @ onFailure", throwable);
        dataSource.mo2019h();
    }

    /* renamed from: a */
    private void m11299a(String id, C2918d<T> dataSource, float progress, boolean isFinished) {
        if (!m11304a(id, (C2918d) dataSource)) {
            m11303a("ignore_old_datasource @ onProgress", null);
            dataSource.mo2019h();
        } else if (!isFinished) {
            this.f12902h.a(progress, false);
        }
    }

    /* renamed from: a */
    private boolean m11304a(String id, C2918d<T> dataSource) {
        if (dataSource == null && this.f12911q == null) {
            return true;
        }
        if (id.equals(this.f12904j) && dataSource == this.f12911q && this.f12907m) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m11305b(String messageAndMethod, T image) {
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: %s: image: %s %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), this.f12904j, messageAndMethod, m11324e(image), Integer.valueOf(mo2031b((Object) image))});
        }
    }

    /* renamed from: a */
    private void m11303a(String messageAndMethod, Throwable throwable) {
        if (C5320a.a(2)) {
            C5320a.a(f12895a, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.f12904j, messageAndMethod, throwable);
        }
    }

    @Nullable
    /* renamed from: t */
    public Animatable mo2027t() {
        return this.f12913s instanceof Animatable ? (Animatable) this.f12913s : null;
    }

    /* renamed from: e */
    protected String m11324e(@Nullable T image) {
        return image != null ? image.getClass().getSimpleName() : "<null>";
    }

    /* renamed from: b */
    protected int mo2031b(@Nullable T image) {
        return System.identityHashCode(image);
    }

    public String toString() {
        return C2923j.m11271a((Object) this).a("isAttached", this.f12906l).a("isRequestSubmitted", this.f12907m).a("hasFetchFailed", this.f12908n).a("fetchedImage", mo2031b(this.f12912r)).a("events", this.f12896b.toString()).toString();
    }

    /* renamed from: e */
    protected T mo2036e() {
        return null;
    }
}
