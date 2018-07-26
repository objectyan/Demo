package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p257e.C5320a;
import com.facebook.common.p258g.C5326d;
import com.facebook.common.p258g.C5327e;
import com.facebook.drawee.p142g.C2925a;
import com.facebook.drawee.p142g.C5422b;
import com.facebook.drawee.p146d.C5416t;
import com.facebook.drawee.p146d.C5417u;
import com.facebook.drawee.p266b.C5393b;
import com.facebook.drawee.p266b.C5393b.C5392a;
import javax.annotation.Nullable;

/* compiled from: DraweeHolder */
/* renamed from: com.facebook.drawee.view.b */
public class C2939b<DH extends C5422b> implements C5326d, C5417u {
    /* renamed from: a */
    private boolean f13021a = false;
    /* renamed from: b */
    private boolean f13022b = false;
    /* renamed from: c */
    private boolean f13023c = true;
    /* renamed from: d */
    private boolean f13024d = false;
    /* renamed from: e */
    private DH f13025e;
    /* renamed from: f */
    private C2925a f13026f = null;
    /* renamed from: g */
    private final C5393b f13027g = C5393b.a();

    /* renamed from: a */
    public static <DH extends C5422b> C2939b<DH> m11569a(@Nullable DH hierarchy, Context context) {
        C2939b<DH> holder = new C2939b(hierarchy);
        holder.m11575a(context);
        C5327e.a(holder);
        return holder;
    }

    /* renamed from: a */
    public void m11575a(Context context) {
    }

    public C2939b(@Nullable DH hierarchy) {
        if (hierarchy != null) {
            m11577a((C5422b) hierarchy);
        }
    }

    /* renamed from: d */
    public void m11582d() {
        this.f13027g.a(C5392a.f22019o);
        this.f13022b = true;
        m11573n();
    }

    /* renamed from: e */
    public boolean m11583e() {
        return this.f13022b;
    }

    /* renamed from: f */
    public void m11584f() {
        this.f13027g.a(C5392a.f22020p);
        this.f13022b = false;
        m11573n();
    }

    /* renamed from: a */
    public void m11574a() {
        this.f13027g.a(C5392a.f22021q);
        this.f13024d = true;
        m11573n();
    }

    /* renamed from: b */
    public void m11580b() {
        this.f13027g.a(C5392a.f22022r);
        this.f13024d = false;
        m11573n();
    }

    /* renamed from: a */
    public boolean m11579a(MotionEvent event) {
        if (this.f13026f == null) {
            return false;
        }
        return this.f13026f.mo2022a(event);
    }

    /* renamed from: a */
    public void m11578a(boolean isVisible) {
        if (this.f13023c != isVisible) {
            this.f13027g.a(isVisible ? C5392a.f22023s : C5392a.f22024t);
            this.f13023c = isVisible;
            m11573n();
        }
    }

    /* renamed from: c */
    public void m11581c() {
        if (!this.f13021a) {
            if (!this.f13024d) {
                C5320a.f(C5393b.class, "%x: Draw requested for a non-attached controller %x. %s", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f13026f)), toString()});
            }
            this.f13024d = false;
            this.f13022b = true;
            this.f13023c = true;
            m11573n();
        }
    }

    /* renamed from: a */
    private void m11570a(@Nullable C5417u visibilityCallback) {
        Drawable drawable = m11588j();
        if (drawable instanceof C5416t) {
            ((C5416t) drawable).a(visibilityCallback);
        }
    }

    /* renamed from: a */
    public void m11576a(@Nullable C2925a draweeController) {
        boolean wasAttached = this.f13021a;
        if (wasAttached) {
            m11572m();
        }
        if (this.f13026f != null) {
            this.f13027g.a(C5392a.f22008d);
            this.f13026f.mo2020a(null);
        }
        this.f13026f = draweeController;
        if (this.f13026f != null) {
            this.f13027g.a(C5392a.f22007c);
            this.f13026f.mo2020a(this.f13025e);
        } else {
            this.f13027g.a(C5392a.f22009e);
        }
        if (wasAttached) {
            m11571l();
        }
    }

    @Nullable
    /* renamed from: g */
    public C2925a m11585g() {
        return this.f13026f;
    }

    /* renamed from: a */
    public void m11577a(DH hierarchy) {
        this.f13027g.a(C5392a.f22005a);
        m11570a(null);
        this.f13025e = (C5422b) C5350k.a(hierarchy);
        Drawable drawable = this.f13025e.a();
        boolean z = drawable == null || drawable.isVisible();
        m11578a(z);
        m11570a((C5417u) this);
        if (this.f13026f != null) {
            this.f13026f.mo2020a((C5422b) hierarchy);
        }
    }

    /* renamed from: h */
    public DH m11586h() {
        return (C5422b) C5350k.a(this.f13025e);
    }

    /* renamed from: i */
    public boolean m11587i() {
        return this.f13025e != null;
    }

    /* renamed from: j */
    public Drawable m11588j() {
        return this.f13025e == null ? null : this.f13025e.a();
    }

    /* renamed from: k */
    protected C5393b m11589k() {
        return this.f13027g;
    }

    /* renamed from: l */
    private void m11571l() {
        if (!this.f13021a) {
            this.f13027g.a(C5392a.f22011g);
            this.f13021a = true;
            if (this.f13026f != null && this.f13026f.mo2024m() != null) {
                this.f13026f.mo2025o();
            }
        }
    }

    /* renamed from: m */
    private void m11572m() {
        if (this.f13021a) {
            this.f13027g.a(C5392a.f22012h);
            this.f13021a = false;
            if (this.f13026f != null) {
                this.f13026f.mo2026p();
            }
        }
    }

    /* renamed from: n */
    private void m11573n() {
        if (this.f13022b && this.f13023c && !this.f13024d) {
            m11571l();
        } else {
            m11572m();
        }
    }

    public String toString() {
        return C2923j.m11271a((Object) this).a("controllerAttached", this.f13021a).a("holderAttached", this.f13022b).a("drawableVisible", this.f13023c).a("trimmed", this.f13024d).a("events", this.f13027g.toString()).toString();
    }
}
