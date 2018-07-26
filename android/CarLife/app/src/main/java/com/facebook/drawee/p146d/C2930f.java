package com.facebook.drawee.p146d;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import javax.annotation.Nullable;

/* compiled from: DrawableUtils */
/* renamed from: com.facebook.drawee.d.f */
public class C2930f {
    @Nullable
    /* renamed from: a */
    public static Drawable m11409a(Drawable drawable) {
        if (drawable instanceof C5403c) {
            return ((C5403c) drawable).d();
        }
        ConstantState constantState = drawable.getConstantState();
        return constantState != null ? constantState.newDrawable() : null;
    }

    /* renamed from: a */
    public static void m11411a(Drawable to, Drawable from) {
        if (from != null && to != null && to != from) {
            to.setBounds(from.getBounds());
            to.setChangingConfigurations(from.getChangingConfigurations());
            to.setLevel(from.getLevel());
            to.setVisible(from.isVisible(), false);
            to.setState(from.getState());
        }
    }

    /* renamed from: a */
    public static void m11412a(Drawable drawable, C5405e properties) {
        if (drawable != null && properties != null) {
            properties.a(drawable);
        }
    }

    /* renamed from: a */
    public static void m11410a(Drawable drawable, @Nullable Callback callback, @Nullable C5401s transformCallback) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof C5400r) {
                ((C5400r) drawable).a(transformCallback);
            }
        }
    }

    /* renamed from: a */
    public static int m11408a(int color, int alpha) {
        if (alpha == 255) {
            return color;
        }
        if (alpha == 0) {
            return color & 16777215;
        }
        return ((((color >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | (16777215 & color);
    }

    /* renamed from: a */
    public static int m11407a(int color) {
        int colorAlpha = color >>> 24;
        if (colorAlpha == 255) {
            return -1;
        }
        if (colorAlpha == 0) {
            return -2;
        }
        return -3;
    }
}
