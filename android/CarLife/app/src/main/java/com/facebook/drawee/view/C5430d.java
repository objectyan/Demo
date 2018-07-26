package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.p142g.C5422b;
import java.util.ArrayList;

/* compiled from: MultiDraweeHolder */
/* renamed from: com.facebook.drawee.view.d */
public class C5430d<DH extends C5422b> {
    @VisibleForTesting
    /* renamed from: a */
    boolean f22173a = false;
    @VisibleForTesting
    /* renamed from: b */
    ArrayList<C2939b<DH>> f22174b = new ArrayList();

    /* renamed from: a */
    public void m18658a() {
        if (!this.f22173a) {
            this.f22173a = true;
            for (int i = 0; i < this.f22174b.size(); i++) {
                ((C2939b) this.f22174b.get(i)).d();
            }
        }
    }

    /* renamed from: b */
    public void m18666b() {
        if (this.f22173a) {
            this.f22173a = false;
            for (int i = 0; i < this.f22174b.size(); i++) {
                ((C2939b) this.f22174b.get(i)).f();
            }
        }
    }

    /* renamed from: a */
    public boolean m18664a(MotionEvent event) {
        for (int i = 0; i < this.f22174b.size(); i++) {
            if (((C2939b) this.f22174b.get(i)).a(event)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m18667c() {
        if (this.f22173a) {
            for (int i = 0; i < this.f22174b.size(); i++) {
                ((C2939b) this.f22174b.get(i)).f();
            }
        }
        this.f22174b.clear();
    }

    /* renamed from: a */
    public void m18662a(C2939b<DH> holder) {
        m18660a(this.f22174b.size(), holder);
    }

    /* renamed from: a */
    public void m18660a(int index, C2939b<DH> holder) {
        C5350k.m18310a((Object) holder);
        C5350k.m18308a(index, this.f22174b.size() + 1);
        this.f22174b.add(index, holder);
        if (this.f22173a) {
            holder.d();
        }
    }

    /* renamed from: a */
    public void m18659a(int index) {
        C2939b<DH> holder = (C2939b) this.f22174b.get(index);
        if (this.f22173a) {
            holder.f();
        }
        this.f22174b.remove(index);
    }

    /* renamed from: b */
    public C2939b<DH> m18665b(int index) {
        return (C2939b) this.f22174b.get(index);
    }

    /* renamed from: d */
    public int m18668d() {
        return this.f22174b.size();
    }

    /* renamed from: a */
    public void m18661a(Canvas canvas) {
        for (int i = 0; i < this.f22174b.size(); i++) {
            Drawable drawable = m18665b(i).j();
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    /* renamed from: a */
    public boolean m18663a(Drawable who) {
        for (int i = 0; i < this.f22174b.size(); i++) {
            if (who == m18665b(i).j()) {
                return true;
            }
        }
        return false;
    }
}
