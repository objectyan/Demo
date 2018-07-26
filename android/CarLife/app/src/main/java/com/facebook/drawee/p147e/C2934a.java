package com.facebook.drawee.p147e;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.C5350k;
import com.facebook.drawee.p142g.C5423c;
import com.facebook.drawee.p146d.C5399d;
import com.facebook.drawee.p146d.C5402h;
import com.facebook.drawee.p146d.C5406g;
import com.facebook.drawee.p146d.C5407i;
import com.facebook.drawee.p146d.C5415p;
import com.facebook.drawee.p146d.q$c;
import javax.annotation.Nullable;

/* compiled from: GenericDraweeHierarchy */
/* renamed from: com.facebook.drawee.e.a */
public class C2934a implements C5423c {
    /* renamed from: a */
    private static final int f12979a = 0;
    /* renamed from: b */
    private static final int f12980b = 1;
    /* renamed from: c */
    private static final int f12981c = 2;
    /* renamed from: d */
    private static final int f12982d = 3;
    /* renamed from: e */
    private static final int f12983e = 4;
    /* renamed from: f */
    private static final int f12984f = 5;
    /* renamed from: g */
    private static final int f12985g = 6;
    /* renamed from: h */
    private final Drawable f12986h = new ColorDrawable(0);
    /* renamed from: i */
    private final Resources f12987i;
    @Nullable
    /* renamed from: j */
    private C5419e f12988j;
    /* renamed from: k */
    private final C2937d f12989k;
    /* renamed from: l */
    private final C5406g f12990l;
    /* renamed from: m */
    private final C5402h f12991m;

    C2934a(C2935b builder) {
        this.f12987i = builder.m11501b();
        this.f12988j = builder.m11540t();
        this.f12991m = new C5402h(this.f12986h);
        int numOverlays = (builder.m11538r() != null ? builder.m11538r().size() : 1) + (builder.m11539s() != null ? 1 : 0);
        Drawable[] layers = new Drawable[(numOverlays + 6)];
        layers[0] = m11440e(builder.m11537q(), null);
        layers[1] = m11440e(builder.m11520e(), builder.m11524f());
        layers[2] = m11437a(this.f12991m, builder.m11533m(), builder.m11535o(), builder.m11534n(), builder.m11536p());
        layers[3] = m11440e(builder.m11531k(), builder.m11532l());
        layers[4] = m11440e(builder.m11526g(), builder.m11528h());
        layers[5] = m11440e(builder.m11529i(), builder.m11530j());
        if (numOverlays > 0) {
            int index = 0;
            if (builder.m11538r() != null) {
                for (Drawable overlay : builder.m11538r()) {
                    int index2 = index + 1;
                    layers[index + 6] = m11440e(overlay, null);
                    index = index2;
                }
            } else {
                index = 1;
            }
            if (builder.m11539s() != null) {
                layers[index + 6] = m11440e(builder.m11539s(), null);
            }
        }
        this.f12990l = new C5406g(layers);
        this.f12990l.c(builder.m11508c());
        this.f12989k = new C2937d(C2938f.m11553a(this.f12990l, this.f12988j));
        this.f12989k.mutate();
        m11445h();
    }

    @Nullable
    /* renamed from: a */
    private Drawable m11437a(Drawable drawable, @Nullable q$c scaleType, @Nullable PointF focusPoint, @Nullable Matrix matrix, @Nullable ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return C2938f.m11550a(C2938f.m11552a(drawable, scaleType, focusPoint), matrix);
    }

    @Nullable
    /* renamed from: e */
    private Drawable m11440e(@Nullable Drawable drawable, @Nullable q$c scaleType) {
        return C2938f.m11551a(C2938f.m11554a(drawable, this.f12988j, this.f12987i), scaleType);
    }

    /* renamed from: g */
    private void m11442g() {
        this.f12991m.a(this.f12986h);
    }

    /* renamed from: h */
    private void m11445h() {
        if (this.f12990l != null) {
            this.f12990l.b();
            this.f12990l.f();
            m11447i();
            m11441f(1);
            this.f12990l.h();
            this.f12990l.c();
        }
    }

    /* renamed from: i */
    private void m11447i() {
        m11443g(1);
        m11443g(2);
        m11443g(3);
        m11443g(4);
        m11443g(5);
    }

    /* renamed from: f */
    private void m11441f(int index) {
        if (index >= 0) {
            this.f12990l.d(index);
        }
    }

    /* renamed from: g */
    private void m11443g(int index) {
        if (index >= 0) {
            this.f12990l.e(index);
        }
    }

    /* renamed from: a */
    private void m11438a(float progress) {
        Drawable progressBarDrawable = m11444h(3).a();
        if (progressBarDrawable != null) {
            if (progress >= 0.999f) {
                if (progressBarDrawable instanceof Animatable) {
                    ((Animatable) progressBarDrawable).stop();
                }
                m11443g(3);
            } else {
                if (progressBarDrawable instanceof Animatable) {
                    ((Animatable) progressBarDrawable).start();
                }
                m11441f(3);
            }
            progressBarDrawable.setLevel(Math.round(10000.0f * progress));
        }
    }

    /* renamed from: a */
    public Drawable m11449a() {
        return this.f12989k;
    }

    /* renamed from: b */
    public void m11463b() {
        m11442g();
        m11445h();
    }

    /* renamed from: a */
    public void m11458a(Drawable drawable, float progress, boolean immediate) {
        drawable = C2938f.m11554a(drawable, this.f12988j, this.f12987i);
        drawable.mutate();
        this.f12991m.a(drawable);
        this.f12990l.b();
        m11447i();
        m11441f(2);
        m11438a(progress);
        if (immediate) {
            this.f12990l.h();
        }
        this.f12990l.c();
    }

    /* renamed from: a */
    public void m11450a(float progress, boolean immediate) {
        this.f12990l.b();
        m11438a(progress);
        if (immediate) {
            this.f12990l.h();
        }
        this.f12990l.c();
    }

    /* renamed from: a */
    public void m11462a(Throwable throwable) {
        this.f12990l.b();
        m11447i();
        if (this.f12990l.a(5) != null) {
            m11441f(5);
        } else {
            m11441f(1);
        }
        this.f12990l.c();
    }

    /* renamed from: b */
    public void m11469b(Throwable throwable) {
        this.f12990l.b();
        m11447i();
        if (this.f12990l.a(4) != null) {
            m11441f(4);
        } else {
            m11441f(1);
        }
        this.f12990l.c();
    }

    /* renamed from: a */
    public void m11457a(@Nullable Drawable drawable) {
        this.f12989k.m11549d(drawable);
    }

    /* renamed from: h */
    private C5399d m11444h(int index) {
        C5399d parent = this.f12990l.b(index);
        if (parent.a() instanceof C5407i) {
            parent = (C5407i) parent.a();
        }
        if (parent.a() instanceof C5415p) {
            return (C5415p) parent.a();
        }
        return parent;
    }

    /* renamed from: b */
    private void m11439b(int index, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.f12990l.a(index, null);
            return;
        }
        m11444h(index).a(C2938f.m11554a(drawable, this.f12988j, this.f12987i));
    }

    /* renamed from: i */
    private C5415p m11446i(int index) {
        C5399d parent = m11444h(index);
        if (parent instanceof C5415p) {
            return (C5415p) parent;
        }
        return C2938f.m11556a(parent, q$c.f22129a);
    }

    /* renamed from: j */
    private boolean m11448j(int index) {
        return m11444h(index) instanceof C5415p;
    }

    /* renamed from: a */
    public void m11451a(int durationMs) {
        this.f12990l.c(durationMs);
    }

    /* renamed from: c */
    public int m11470c() {
        return this.f12990l.d();
    }

    /* renamed from: a */
    public void m11455a(PointF focusPoint) {
        C5350k.a(focusPoint);
        m11446i(2).a(focusPoint);
    }

    /* renamed from: a */
    public void m11460a(q$c scaleType) {
        C5350k.a(scaleType);
        m11446i(2).a(scaleType);
    }

    @Nullable
    /* renamed from: d */
    public q$c m11475d() {
        if (m11448j(2)) {
            return m11446i(2).b();
        }
        return null;
    }

    /* renamed from: a */
    public void m11454a(ColorFilter colorfilter) {
        this.f12991m.setColorFilter(colorfilter);
    }

    /* renamed from: a */
    public void m11456a(RectF outBounds) {
        this.f12991m.b(outBounds);
    }

    /* renamed from: b */
    public void m11467b(@Nullable Drawable drawable) {
        m11439b(1, drawable);
    }

    /* renamed from: a */
    public void m11459a(Drawable drawable, q$c scaleType) {
        m11439b(1, drawable);
        m11446i(1).a(scaleType);
    }

    /* renamed from: e */
    public boolean m11482e() {
        return m11444h(1) != null;
    }

    /* renamed from: b */
    public void m11466b(PointF focusPoint) {
        C5350k.a(focusPoint);
        m11446i(1).a(focusPoint);
    }

    /* renamed from: b */
    public void m11464b(int resourceId) {
        m11467b(this.f12987i.getDrawable(resourceId));
    }

    /* renamed from: a */
    public void m11453a(int resourceId, q$c scaleType) {
        m11459a(this.f12987i.getDrawable(resourceId), scaleType);
    }

    /* renamed from: c */
    public void m11473c(@Nullable Drawable drawable) {
        m11439b(5, drawable);
    }

    /* renamed from: b */
    public void m11468b(Drawable drawable, q$c scaleType) {
        m11439b(5, drawable);
        m11446i(5).a(scaleType);
    }

    /* renamed from: c */
    public void m11471c(int resourceId) {
        m11473c(this.f12987i.getDrawable(resourceId));
    }

    /* renamed from: b */
    public void m11465b(int resourceId, q$c scaleType) {
        m11468b(this.f12987i.getDrawable(resourceId), scaleType);
    }

    /* renamed from: d */
    public void m11478d(@Nullable Drawable drawable) {
        m11439b(4, drawable);
    }

    /* renamed from: c */
    public void m11474c(Drawable drawable, q$c scaleType) {
        m11439b(4, drawable);
        m11446i(4).a(scaleType);
    }

    /* renamed from: d */
    public void m11476d(int resourceId) {
        m11478d(this.f12987i.getDrawable(resourceId));
    }

    /* renamed from: c */
    public void m11472c(int resourceId, q$c scaleType) {
        m11474c(this.f12987i.getDrawable(resourceId), scaleType);
    }

    /* renamed from: e */
    public void m11481e(@Nullable Drawable drawable) {
        m11439b(3, drawable);
    }

    /* renamed from: d */
    public void m11479d(Drawable drawable, q$c scaleType) {
        m11439b(3, drawable);
        m11446i(3).a(scaleType);
    }

    /* renamed from: e */
    public void m11480e(int resourceId) {
        m11481e(this.f12987i.getDrawable(resourceId));
    }

    /* renamed from: d */
    public void m11477d(int resourceId, q$c scaleType) {
        m11479d(this.f12987i.getDrawable(resourceId), scaleType);
    }

    /* renamed from: f */
    public void m11484f(@Nullable Drawable drawable) {
        m11439b(0, drawable);
    }

    /* renamed from: a */
    public void m11452a(int index, @Nullable Drawable drawable) {
        boolean z = index >= 0 && index + 6 < this.f12990l.a();
        C5350k.a(z, "The given index does not correspond to an overlay image.");
        m11439b(index + 6, drawable);
    }

    /* renamed from: g */
    public void m11485g(@Nullable Drawable drawable) {
        m11452a(0, drawable);
    }

    /* renamed from: a */
    public void m11461a(@Nullable C5419e roundingParams) {
        this.f12988j = roundingParams;
        C2938f.m11557a(this.f12989k, this.f12988j);
        for (int i = 0; i < this.f12990l.a(); i++) {
            C2938f.m11558a(m11444h(i), this.f12988j, this.f12987i);
        }
    }

    @Nullable
    /* renamed from: f */
    public C5419e m11483f() {
        return this.f12988j;
    }
}
