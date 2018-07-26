package com.facebook.drawee.p143c;

import android.content.Context;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.drawee.p142g.C2925a;
import com.facebook.drawee.p142g.C5424d;
import com.facebook.drawee.p266b.C5394c;
import com.facebook.drawee.p267f.C5421a;
import com.facebook.p138c.C2918d;
import com.facebook.p138c.C5291e;
import com.facebook.p138c.C5293g;
import com.facebook.p138c.C5294h;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* compiled from: AbstractDraweeControllerBuilder */
/* renamed from: com.facebook.drawee.c.b */
public abstract class C2928b<BUILDER extends C2928b<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements C5424d {
    /* renamed from: a */
    private static final C5396d<Object> f12921a = new b$1();
    /* renamed from: b */
    private static final NullPointerException f12922b = new NullPointerException("No image request was specified!");
    /* renamed from: q */
    private static final AtomicLong f12923q = new AtomicLong();
    /* renamed from: c */
    private final Context f12924c;
    /* renamed from: d */
    private final Set<C5396d> f12925d;
    @Nullable
    /* renamed from: e */
    private Object f12926e;
    @Nullable
    /* renamed from: f */
    private REQUEST f12927f;
    @Nullable
    /* renamed from: g */
    private REQUEST f12928g;
    @Nullable
    /* renamed from: h */
    private REQUEST[] f12929h;
    /* renamed from: i */
    private boolean f12930i;
    @Nullable
    /* renamed from: j */
    private C5273m<C2918d<IMAGE>> f12931j;
    @Nullable
    /* renamed from: k */
    private C5396d<? super INFO> f12932k;
    /* renamed from: l */
    private boolean f12933l;
    /* renamed from: m */
    private boolean f12934m;
    /* renamed from: n */
    private boolean f12935n;
    /* renamed from: o */
    private String f12936o;
    @Nullable
    /* renamed from: p */
    private C2925a f12937p;

    /* renamed from: a */
    protected abstract C2918d<IMAGE> m11358a(REQUEST request, Object obj, boolean z);

    /* renamed from: c */
    protected abstract BUILDER m11373c();

    /* renamed from: d */
    protected abstract C2926a m11379d();

    /* renamed from: b */
    public /* synthetic */ C5424d m11371b(@Nullable C2925a c2925a) {
        return m11361a(c2925a);
    }

    /* renamed from: e */
    public /* synthetic */ C5424d m11381e(Object obj) {
        return m11362a(obj);
    }

    /* renamed from: w */
    public /* synthetic */ C2925a m11398w() {
        return m11393q();
    }

    protected C2928b(Context context, Set<C5396d> boundControllerListeners) {
        this.f12924c = context;
        this.f12925d = boundControllerListeners;
        m11356a();
    }

    /* renamed from: a */
    private void m11356a() {
        this.f12926e = null;
        this.f12927f = null;
        this.f12928g = null;
        this.f12929h = null;
        this.f12930i = true;
        this.f12932k = null;
        this.f12933l = false;
        this.f12934m = false;
        this.f12937p = null;
        this.f12936o = null;
    }

    /* renamed from: e */
    public BUILDER m11380e() {
        m11356a();
        return m11373c();
    }

    /* renamed from: a */
    public BUILDER m11362a(Object callerContext) {
        this.f12926e = callerContext;
        return m11373c();
    }

    @Nullable
    /* renamed from: f */
    public Object m11382f() {
        return this.f12926e;
    }

    /* renamed from: b */
    public BUILDER m11369b(REQUEST imageRequest) {
        this.f12927f = imageRequest;
        return m11373c();
    }

    @Nullable
    /* renamed from: g */
    public REQUEST m11383g() {
        return this.f12927f;
    }

    /* renamed from: c */
    public BUILDER m11374c(REQUEST lowResImageRequest) {
        this.f12928g = lowResImageRequest;
        return m11373c();
    }

    @Nullable
    /* renamed from: h */
    public REQUEST m11384h() {
        return this.f12928g;
    }

    /* renamed from: a */
    public BUILDER m11364a(REQUEST[] firstAvailableImageRequests) {
        return m11365a((Object[]) firstAvailableImageRequests, true);
    }

    /* renamed from: a */
    public BUILDER m11365a(REQUEST[] firstAvailableImageRequests, boolean tryCacheOnlyFirst) {
        this.f12929h = firstAvailableImageRequests;
        this.f12930i = tryCacheOnlyFirst;
        return m11373c();
    }

    @Nullable
    /* renamed from: i */
    public REQUEST[] m11385i() {
        return this.f12929h;
    }

    /* renamed from: a */
    public void m11366a(@Nullable C5273m<C2918d<IMAGE>> dataSourceSupplier) {
        this.f12931j = dataSourceSupplier;
    }

    @Nullable
    /* renamed from: j */
    public C5273m<C2918d<IMAGE>> m11386j() {
        return this.f12931j;
    }

    /* renamed from: a */
    public BUILDER m11363a(boolean enabled) {
        this.f12933l = enabled;
        return m11373c();
    }

    /* renamed from: k */
    public boolean m11387k() {
        return this.f12933l;
    }

    /* renamed from: b */
    public BUILDER m11370b(boolean enabled) {
        this.f12935n = enabled;
        return m11373c();
    }

    /* renamed from: l */
    public boolean m11388l() {
        return this.f12935n;
    }

    /* renamed from: c */
    public BUILDER m11376c(boolean enabled) {
        this.f12934m = enabled;
        return m11373c();
    }

    /* renamed from: m */
    public boolean m11389m() {
        return this.f12934m;
    }

    /* renamed from: a */
    public BUILDER m11360a(C5396d<? super INFO> controllerListener) {
        this.f12932k = controllerListener;
        return m11373c();
    }

    @Nullable
    /* renamed from: n */
    public C5396d<? super INFO> m11390n() {
        return this.f12932k;
    }

    /* renamed from: c */
    public BUILDER m11375c(String contentDescription) {
        this.f12936o = contentDescription;
        return m11373c();
    }

    @Nullable
    /* renamed from: o */
    public String m11391o() {
        return this.f12936o;
    }

    /* renamed from: a */
    public BUILDER m11361a(@Nullable C2925a oldController) {
        this.f12937p = oldController;
        return m11373c();
    }

    @Nullable
    /* renamed from: p */
    public C2925a m11392p() {
        return this.f12937p;
    }

    /* renamed from: q */
    public C2926a m11393q() {
        m11394r();
        if (this.f12927f == null && this.f12929h == null && this.f12928g != null) {
            this.f12927f = this.f12928g;
            this.f12928g = null;
        }
        return m11395s();
    }

    /* renamed from: r */
    protected void m11394r() {
        boolean z = false;
        boolean z2 = this.f12929h == null || this.f12927f == null;
        C5350k.b(z2, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.f12931j == null || (this.f12929h == null && this.f12927f == null && this.f12928g == null)) {
            z = true;
        }
        C5350k.b(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    /* renamed from: s */
    protected C2926a m11395s() {
        C2926a controller = m11379d();
        controller.m11315a(m11388l());
        controller.mo2021a(m11391o());
        m11372b(controller);
        m11367a(controller);
        return controller;
    }

    /* renamed from: t */
    protected static String m11357t() {
        return String.valueOf(f12923q.getAndIncrement());
    }

    /* renamed from: u */
    protected C5273m<C2918d<IMAGE>> m11396u() {
        if (this.f12931j != null) {
            return this.f12931j;
        }
        C5273m<C2918d<IMAGE>> supplier = null;
        if (this.f12927f != null) {
            supplier = m11378d(this.f12927f);
        } else if (this.f12929h != null) {
            supplier = m11368b(this.f12929h, this.f12930i);
        }
        if (!(supplier == null || this.f12928g == null)) {
            List<C5273m<C2918d<IMAGE>>> suppliers = new ArrayList(2);
            suppliers.add(supplier);
            suppliers.add(m11378d(this.f12928g));
            supplier = C5294h.a(suppliers);
        }
        if (supplier == null) {
            return C5291e.b(f12922b);
        }
        return supplier;
    }

    /* renamed from: b */
    protected C5273m<C2918d<IMAGE>> m11368b(REQUEST[] imageRequests, boolean tryBitmapCacheOnlyFirst) {
        List<C5273m<C2918d<IMAGE>>> suppliers = new ArrayList(imageRequests.length * 2);
        if (tryBitmapCacheOnlyFirst) {
            for (Object a : imageRequests) {
                suppliers.add(m11359a(a, true));
            }
        }
        for (Object a2 : imageRequests) {
            suppliers.add(m11378d(a2));
        }
        return C5293g.a(suppliers);
    }

    /* renamed from: d */
    protected C5273m<C2918d<IMAGE>> m11378d(REQUEST imageRequest) {
        return m11359a((Object) imageRequest, false);
    }

    /* renamed from: a */
    protected C5273m<C2918d<IMAGE>> m11359a(REQUEST imageRequest, boolean bitmapCacheOnly) {
        return new b$2(this, imageRequest, m11382f(), bitmapCacheOnly);
    }

    /* renamed from: a */
    protected void m11367a(C2926a controller) {
        if (this.f12925d != null) {
            for (C5396d listener : this.f12925d) {
                controller.m11309a(listener);
            }
        }
        if (this.f12932k != null) {
            controller.m11309a(this.f12932k);
        }
        if (this.f12934m) {
            controller.m11309a(f12921a);
        }
    }

    /* renamed from: b */
    protected void m11372b(C2926a controller) {
        if (this.f12933l) {
            C5394c retryManager = controller.m11328i();
            if (retryManager == null) {
                retryManager = new C5394c();
                controller.m11308a(retryManager);
            }
            retryManager.a(this.f12933l);
            m11377c(controller);
        }
    }

    /* renamed from: c */
    protected void m11377c(C2926a controller) {
        if (controller.m11329j() == null) {
            controller.m11310a(C5421a.a(this.f12924c));
        }
    }

    /* renamed from: v */
    protected Context m11397v() {
        return this.f12924c;
    }
}
