package com.facebook.drawee.p147e;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.C5350k;
import com.facebook.drawee.p146d.C2929a;
import com.facebook.drawee.p146d.q$c;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: GenericDraweeHierarchyBuilder */
/* renamed from: com.facebook.drawee.e.b */
public class C2935b {
    /* renamed from: a */
    public static final int f12992a = 300;
    /* renamed from: b */
    public static final q$c f12993b = q$c.f22134f;
    /* renamed from: c */
    public static final q$c f12994c = q$c.f22135g;
    /* renamed from: d */
    private Resources f12995d;
    /* renamed from: e */
    private int f12996e;
    /* renamed from: f */
    private float f12997f;
    /* renamed from: g */
    private Drawable f12998g;
    @Nullable
    /* renamed from: h */
    private q$c f12999h;
    /* renamed from: i */
    private Drawable f13000i;
    /* renamed from: j */
    private q$c f13001j;
    /* renamed from: k */
    private Drawable f13002k;
    /* renamed from: l */
    private q$c f13003l;
    /* renamed from: m */
    private Drawable f13004m;
    /* renamed from: n */
    private q$c f13005n;
    /* renamed from: o */
    private q$c f13006o;
    /* renamed from: p */
    private Matrix f13007p;
    /* renamed from: q */
    private PointF f13008q;
    /* renamed from: r */
    private ColorFilter f13009r;
    /* renamed from: s */
    private Drawable f13010s;
    /* renamed from: t */
    private List<Drawable> f13011t;
    /* renamed from: u */
    private Drawable f13012u;
    /* renamed from: v */
    private C5419e f13013v;

    public C2935b(Resources resources) {
        this.f12995d = resources;
        m11487v();
    }

    /* renamed from: a */
    public static C2935b m11486a(Resources resources) {
        return new C2935b(resources);
    }

    /* renamed from: v */
    private void m11487v() {
        this.f12996e = 300;
        this.f12997f = 0.0f;
        this.f12998g = null;
        this.f12999h = f12993b;
        this.f13000i = null;
        this.f13001j = f12993b;
        this.f13002k = null;
        this.f13003l = f12993b;
        this.f13004m = null;
        this.f13005n = f12993b;
        this.f13006o = f12994c;
        this.f13007p = null;
        this.f13008q = null;
        this.f13009r = null;
        this.f13010s = null;
        this.f13011t = null;
        this.f13012u = null;
        this.f13013v = null;
    }

    /* renamed from: a */
    public C2935b m11489a() {
        m11487v();
        return this;
    }

    /* renamed from: b */
    public Resources m11501b() {
        return this.f12995d;
    }

    /* renamed from: a */
    public C2935b m11491a(int fadeDuration) {
        this.f12996e = fadeDuration;
        return this;
    }

    /* renamed from: c */
    public int m11508c() {
        return this.f12996e;
    }

    /* renamed from: a */
    public C2935b m11490a(float desiredAspectRatio) {
        this.f12997f = desiredAspectRatio;
        return this;
    }

    /* renamed from: d */
    public float m11514d() {
        return this.f12997f;
    }

    /* renamed from: a */
    public C2935b m11496a(@Nullable Drawable placeholderDrawable) {
        this.f12998g = placeholderDrawable;
        return this;
    }

    /* renamed from: b */
    public C2935b m11502b(int resourceId) {
        this.f12998g = this.f12995d.getDrawable(resourceId);
        return this;
    }

    @Nullable
    /* renamed from: e */
    public Drawable m11520e() {
        return this.f12998g;
    }

    /* renamed from: a */
    public C2935b m11498a(@Nullable q$c placeholderImageScaleType) {
        this.f12999h = placeholderImageScaleType;
        return this;
    }

    @Nullable
    /* renamed from: f */
    public q$c m11524f() {
        return this.f12999h;
    }

    /* renamed from: a */
    public C2935b m11497a(Drawable placeholderDrawable, @Nullable q$c placeholderImageScaleType) {
        this.f12998g = placeholderDrawable;
        this.f12999h = placeholderImageScaleType;
        return this;
    }

    /* renamed from: a */
    public C2935b m11492a(int resourceId, @Nullable q$c placeholderImageScaleType) {
        this.f12998g = this.f12995d.getDrawable(resourceId);
        this.f12999h = placeholderImageScaleType;
        return this;
    }

    /* renamed from: b */
    public C2935b m11504b(@Nullable Drawable retryDrawable) {
        this.f13000i = retryDrawable;
        return this;
    }

    /* renamed from: c */
    public C2935b m11509c(int resourceId) {
        this.f13000i = this.f12995d.getDrawable(resourceId);
        return this;
    }

    @Nullable
    /* renamed from: g */
    public Drawable m11526g() {
        return this.f13000i;
    }

    /* renamed from: b */
    public C2935b m11506b(@Nullable q$c retryImageScaleType) {
        this.f13001j = retryImageScaleType;
        return this;
    }

    @Nullable
    /* renamed from: h */
    public q$c m11528h() {
        return this.f13001j;
    }

    /* renamed from: b */
    public C2935b m11505b(Drawable retryDrawable, @Nullable q$c retryImageScaleType) {
        this.f13000i = retryDrawable;
        this.f13001j = retryImageScaleType;
        return this;
    }

    /* renamed from: b */
    public C2935b m11503b(int resourceId, @Nullable q$c retryImageScaleType) {
        this.f13000i = this.f12995d.getDrawable(resourceId);
        this.f13001j = retryImageScaleType;
        return this;
    }

    /* renamed from: c */
    public C2935b m11511c(@Nullable Drawable failureDrawable) {
        this.f13002k = failureDrawable;
        return this;
    }

    /* renamed from: d */
    public C2935b m11515d(int resourceId) {
        this.f13002k = this.f12995d.getDrawable(resourceId);
        return this;
    }

    @Nullable
    /* renamed from: i */
    public Drawable m11529i() {
        return this.f13002k;
    }

    /* renamed from: c */
    public C2935b m11513c(@Nullable q$c failureImageScaleType) {
        this.f13003l = failureImageScaleType;
        return this;
    }

    @Nullable
    /* renamed from: j */
    public q$c m11530j() {
        return this.f13003l;
    }

    /* renamed from: c */
    public C2935b m11512c(Drawable failureDrawable, @Nullable q$c failureImageScaleType) {
        this.f13002k = failureDrawable;
        this.f13003l = failureImageScaleType;
        return this;
    }

    /* renamed from: c */
    public C2935b m11510c(int resourceId, @Nullable q$c failureImageScaleType) {
        this.f13002k = this.f12995d.getDrawable(resourceId);
        this.f13003l = failureImageScaleType;
        return this;
    }

    /* renamed from: d */
    public C2935b m11517d(@Nullable Drawable progressBarDrawable) {
        this.f13004m = progressBarDrawable;
        return this;
    }

    /* renamed from: e */
    public C2935b m11521e(int resourceId) {
        this.f13004m = this.f12995d.getDrawable(resourceId);
        return this;
    }

    @Nullable
    /* renamed from: k */
    public Drawable m11531k() {
        return this.f13004m;
    }

    /* renamed from: d */
    public C2935b m11519d(@Nullable q$c progressBarImageScaleType) {
        this.f13005n = progressBarImageScaleType;
        return this;
    }

    @Nullable
    /* renamed from: l */
    public q$c m11532l() {
        return this.f13005n;
    }

    /* renamed from: d */
    public C2935b m11518d(Drawable progressBarDrawable, @Nullable q$c progressBarImageScaleType) {
        this.f13004m = progressBarDrawable;
        this.f13005n = progressBarImageScaleType;
        return this;
    }

    /* renamed from: d */
    public C2935b m11516d(int resourceId, @Nullable q$c progressBarImageScaleType) {
        this.f13004m = this.f12995d.getDrawable(resourceId);
        this.f13005n = progressBarImageScaleType;
        return this;
    }

    /* renamed from: e */
    public C2935b m11523e(@Nullable q$c actualImageScaleType) {
        this.f13006o = actualImageScaleType;
        this.f13007p = null;
        return this;
    }

    @Nullable
    /* renamed from: m */
    public q$c m11533m() {
        return this.f13006o;
    }

    @Deprecated
    /* renamed from: a */
    public C2935b m11494a(@Nullable Matrix actualImageMatrix) {
        this.f13007p = actualImageMatrix;
        this.f13006o = null;
        return this;
    }

    @Nullable
    /* renamed from: n */
    public Matrix m11534n() {
        return this.f13007p;
    }

    /* renamed from: a */
    public C2935b m11495a(@Nullable PointF focusPoint) {
        this.f13008q = focusPoint;
        return this;
    }

    @Nullable
    /* renamed from: o */
    public PointF m11535o() {
        return this.f13008q;
    }

    /* renamed from: a */
    public C2935b m11493a(@Nullable ColorFilter colorFilter) {
        this.f13009r = colorFilter;
        return this;
    }

    @Nullable
    /* renamed from: p */
    public ColorFilter m11536p() {
        return this.f13009r;
    }

    @Deprecated
    /* renamed from: a */
    public C2935b m11500a(@Nullable List<Drawable> backgrounds) {
        if (backgrounds == null) {
            this.f13010s = null;
        } else {
            this.f13010s = new C2929a((Drawable[]) backgrounds.toArray(new Drawable[backgrounds.size()]));
        }
        return this;
    }

    /* renamed from: e */
    public C2935b m11522e(@Nullable Drawable background) {
        this.f13010s = background;
        return this;
    }

    @Nullable
    /* renamed from: q */
    public Drawable m11537q() {
        return this.f13010s;
    }

    /* renamed from: b */
    public C2935b m11507b(@Nullable List<Drawable> overlays) {
        this.f13011t = overlays;
        return this;
    }

    /* renamed from: f */
    public C2935b m11525f(@Nullable Drawable overlay) {
        if (overlay == null) {
            this.f13011t = null;
        } else {
            this.f13011t = Arrays.asList(new Drawable[]{overlay});
        }
        return this;
    }

    @Nullable
    /* renamed from: r */
    public List<Drawable> m11538r() {
        return this.f13011t;
    }

    /* renamed from: g */
    public C2935b m11527g(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.f13012u = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.f13012u = stateListDrawable;
        }
        return this;
    }

    @Nullable
    /* renamed from: s */
    public Drawable m11539s() {
        return this.f13012u;
    }

    /* renamed from: a */
    public C2935b m11499a(@Nullable C5419e roundingParams) {
        this.f13013v = roundingParams;
        return this;
    }

    @Nullable
    /* renamed from: t */
    public C5419e m11540t() {
        return this.f13013v;
    }

    /* renamed from: w */
    private void m11488w() {
        if (this.f13011t != null) {
            for (Drawable overlay : this.f13011t) {
                C5350k.a(overlay);
            }
        }
    }

    /* renamed from: u */
    public C2934a m11541u() {
        m11488w();
        return new C2934a(this);
    }
}
