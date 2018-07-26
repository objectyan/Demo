package com.facebook.drawee.p146d;

import android.graphics.Matrix;
import android.graphics.Rect;
import javax.annotation.Nullable;

/* compiled from: ScalingUtils */
/* renamed from: com.facebook.drawee.d.q */
public class C2933q {

    /* compiled from: ScalingUtils */
    /* renamed from: com.facebook.drawee.d.q$b */
    public static class C2932b implements q$c, q$l {
        /* renamed from: i */
        private final q$c f12971i;
        /* renamed from: j */
        private final q$c f12972j;
        @Nullable
        /* renamed from: k */
        private final Rect f12973k;
        @Nullable
        /* renamed from: l */
        private final Rect f12974l;
        /* renamed from: m */
        private final float[] f12975m;
        /* renamed from: n */
        private final float[] f12976n;
        /* renamed from: o */
        private final float[] f12977o;
        /* renamed from: p */
        private float f12978p;

        public C2932b(q$c scaleTypeFrom, q$c scaleTypeTo, @Nullable Rect boundsFrom, @Nullable Rect boundsTo) {
            this.f12975m = new float[9];
            this.f12976n = new float[9];
            this.f12977o = new float[9];
            this.f12971i = scaleTypeFrom;
            this.f12972j = scaleTypeTo;
            this.f12973k = boundsFrom;
            this.f12974l = boundsTo;
        }

        public C2932b(q$c scaleTypeFrom, q$c scaleTypeTo) {
            this(scaleTypeFrom, scaleTypeTo, null, null);
        }

        /* renamed from: a */
        public q$c m11429a() {
            return this.f12971i;
        }

        /* renamed from: b */
        public q$c m11431b() {
            return this.f12972j;
        }

        @Nullable
        /* renamed from: c */
        public Rect m11432c() {
            return this.f12973k;
        }

        @Nullable
        /* renamed from: d */
        public Rect m11433d() {
            return this.f12974l;
        }

        /* renamed from: a */
        public void m11430a(float value) {
            this.f12978p = value;
        }

        /* renamed from: e */
        public float m11434e() {
            return this.f12978p;
        }

        /* renamed from: f */
        public Object m11435f() {
            return Float.valueOf(this.f12978p);
        }

        /* renamed from: a */
        public Matrix m11428a(Matrix transform, Rect parentBounds, int childWidth, int childHeight, float focusX, float focusY) {
            Rect boundsFrom;
            Rect boundsTo;
            if (this.f12973k != null) {
                boundsFrom = this.f12973k;
            } else {
                boundsFrom = parentBounds;
            }
            if (this.f12974l != null) {
                boundsTo = this.f12974l;
            } else {
                boundsTo = parentBounds;
            }
            this.f12971i.a(transform, boundsFrom, childWidth, childHeight, focusX, focusY);
            transform.getValues(this.f12975m);
            this.f12972j.a(transform, boundsTo, childWidth, childHeight, focusX, focusY);
            transform.getValues(this.f12976n);
            for (int i = 0; i < 9; i++) {
                this.f12977o[i] = (this.f12975m[i] * (1.0f - this.f12978p)) + (this.f12976n[i] * this.f12978p);
            }
            transform.setValues(this.f12977o);
            return transform;
        }
    }

    @Deprecated
    /* renamed from: a */
    public static Matrix m11436a(Matrix transform, Rect parentBounds, int childWidth, int childHeight, float focusX, float focusY, q$c scaleType) {
        return scaleType.a(transform, parentBounds, childWidth, childHeight, focusX, focusY);
    }
}
