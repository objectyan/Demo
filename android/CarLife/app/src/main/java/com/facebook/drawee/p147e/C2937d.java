package com.facebook.drawee.p147e;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.p146d.C5402h;
import com.facebook.drawee.p146d.C5416t;
import com.facebook.drawee.p146d.C5417u;
import javax.annotation.Nullable;

/* compiled from: RootDrawable */
/* renamed from: com.facebook.drawee.e.d */
public class C2937d extends C5402h implements C5416t {
    @VisibleForTesting
    @Nullable
    /* renamed from: a */
    Drawable f13014a = null;
    @Nullable
    /* renamed from: c */
    private C5417u f13015c;

    public C2937d(Drawable drawable) {
        super(drawable);
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    /* renamed from: a */
    public void m11548a(@Nullable C5417u visibilityCallback) {
        this.f13015c = visibilityCallback;
    }

    public boolean setVisible(boolean visible, boolean restart) {
        if (this.f13015c != null) {
            this.f13015c.a(visible);
        }
        return super.setVisible(visible, restart);
    }

    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.f13015c != null) {
                this.f13015c.c();
            }
            super.draw(canvas);
            if (this.f13014a != null) {
                this.f13014a.setBounds(getBounds());
                this.f13014a.draw(canvas);
            }
        }
    }

    /* renamed from: d */
    public void m11549d(@Nullable Drawable controllerOverlay) {
        this.f13014a = controllerOverlay;
        invalidateSelf();
    }
}
