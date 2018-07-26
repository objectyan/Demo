package com.facebook.drawee.p147e;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.C5395b.C5388c;
import com.facebook.drawee.p146d.C5404b;
import com.facebook.drawee.p146d.q$c;
import javax.annotation.Nullable;

/* compiled from: GenericDraweeHierarchyInflater */
/* renamed from: com.facebook.drawee.e.c */
public class C2936c {
    /* renamed from: a */
    public static C2934a m11544a(Context context, @Nullable AttributeSet attrs) {
        return C2936c.m11547b(context, attrs).m11541u();
    }

    /* renamed from: b */
    public static C2935b m11547b(Context context, @Nullable AttributeSet attrs) {
        return C2936c.m11545a(new C2935b(context.getResources()), context, attrs);
    }

    /* renamed from: a */
    public static C2935b m11545a(C2935b builder, Context context, @Nullable AttributeSet attrs) {
        int progressBarAutoRotateInterval = 0;
        int roundedCornerRadius = 0;
        boolean roundTopLeft = true;
        boolean roundTopRight = true;
        boolean roundBottomLeft = true;
        boolean roundBottomRight = true;
        if (attrs != null) {
            TypedArray gdhAttrs = context.obtainStyledAttributes(attrs, C5388c.GenericDraweeHierarchy);
            try {
                int indexCount = gdhAttrs.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int attr = gdhAttrs.getIndex(i);
                    if (attr == C5388c.GenericDraweeHierarchy_actualImageScaleType) {
                        builder.m11523e(C2936c.m11543a(gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_placeholderImage) {
                        builder.m11496a(C2936c.m11542a(context, gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_pressedStateOverlayImage) {
                        builder.m11527g(C2936c.m11542a(context, gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_progressBarImage) {
                        builder.m11517d(C2936c.m11542a(context, gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_fadeDuration) {
                        builder.m11491a(gdhAttrs.getInt(attr, 0));
                    } else if (attr == C5388c.GenericDraweeHierarchy_viewAspectRatio) {
                        builder.m11490a(gdhAttrs.getFloat(attr, 0.0f));
                    } else if (attr == C5388c.GenericDraweeHierarchy_placeholderImageScaleType) {
                        builder.m11498a(C2936c.m11543a(gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_retryImage) {
                        builder.m11504b(C2936c.m11542a(context, gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_retryImageScaleType) {
                        builder.m11506b(C2936c.m11543a(gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_failureImage) {
                        builder.m11511c(C2936c.m11542a(context, gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_failureImageScaleType) {
                        builder.m11513c(C2936c.m11543a(gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_progressBarImageScaleType) {
                        builder.m11519d(C2936c.m11543a(gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                        progressBarAutoRotateInterval = gdhAttrs.getInteger(attr, progressBarAutoRotateInterval);
                    } else if (attr == C5388c.GenericDraweeHierarchy_backgroundImage) {
                        builder.m11522e(C2936c.m11542a(context, gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_overlayImage) {
                        builder.m11525f(C2936c.m11542a(context, gdhAttrs, attr));
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundAsCircle) {
                        C2936c.m11546a(builder).a(gdhAttrs.getBoolean(attr, false));
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundedCornerRadius) {
                        roundedCornerRadius = gdhAttrs.getDimensionPixelSize(attr, roundedCornerRadius);
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundTopLeft) {
                        roundTopLeft = gdhAttrs.getBoolean(attr, roundTopLeft);
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundTopRight) {
                        roundTopRight = gdhAttrs.getBoolean(attr, roundTopRight);
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundBottomLeft) {
                        roundBottomLeft = gdhAttrs.getBoolean(attr, roundBottomLeft);
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundBottomRight) {
                        roundBottomRight = gdhAttrs.getBoolean(attr, roundBottomRight);
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundWithOverlayColor) {
                        C2936c.m11546a(builder).a(gdhAttrs.getColor(attr, 0));
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundingBorderWidth) {
                        C2936c.m11546a(builder).c((float) gdhAttrs.getDimensionPixelSize(attr, 0));
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundingBorderColor) {
                        C2936c.m11546a(builder).b(gdhAttrs.getColor(attr, 0));
                    } else if (attr == C5388c.GenericDraweeHierarchy_roundingBorderPadding) {
                        C2936c.m11546a(builder).d((float) gdhAttrs.getDimensionPixelSize(attr, 0));
                    }
                }
            } finally {
                gdhAttrs.recycle();
            }
        }
        if (builder.m11531k() != null && progressBarAutoRotateInterval > 0) {
            builder.m11517d(new C5404b(builder.m11531k(), progressBarAutoRotateInterval));
        }
        if (roundedCornerRadius > 0) {
            C2936c.m11546a(builder).a(roundTopLeft ? (float) roundedCornerRadius : 0.0f, roundTopRight ? (float) roundedCornerRadius : 0.0f, roundBottomRight ? (float) roundedCornerRadius : 0.0f, roundBottomLeft ? (float) roundedCornerRadius : 0.0f);
        }
        return builder;
    }

    /* renamed from: a */
    private static C5419e m11546a(C2935b builder) {
        if (builder.m11540t() == null) {
            builder.m11499a(new C5419e());
        }
        return builder.m11540t();
    }

    @Nullable
    /* renamed from: a */
    private static Drawable m11542a(Context context, TypedArray gdhAttrs, int attrId) {
        int resourceId = gdhAttrs.getResourceId(attrId, 0);
        return resourceId == 0 ? null : context.getResources().getDrawable(resourceId);
    }

    @Nullable
    /* renamed from: a */
    private static q$c m11543a(TypedArray gdhAttrs, int attrId) {
        switch (gdhAttrs.getInt(attrId, -2)) {
            case -1:
                return null;
            case 0:
                return q$c.f22129a;
            case 1:
                return q$c.f22130b;
            case 2:
                return q$c.f22131c;
            case 3:
                return q$c.f22132d;
            case 4:
                return q$c.f22133e;
            case 5:
                return q$c.f22134f;
            case 6:
                return q$c.f22135g;
            case 7:
                return q$c.f22136h;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
