package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.drawee.C5395b.C5388c;
import com.facebook.drawee.p142g.C5424d;
import com.facebook.drawee.p147e.C2934a;
import javax.annotation.Nullable;

public class SimpleDraweeView extends GenericDraweeView {
    /* renamed from: a */
    private static C5273m<? extends C5424d> f22162a;
    /* renamed from: b */
    private C5424d f22163b;

    /* renamed from: a */
    public static void m18650a(C5273m<? extends C5424d> draweeControllerBuilderSupplier) {
        f22162a = draweeControllerBuilderSupplier;
    }

    /* renamed from: g */
    public static void m18652g() {
        f22162a = null;
    }

    public SimpleDraweeView(Context context, C2934a hierarchy) {
        super(context, hierarchy);
        m18651b(context, null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        m18651b(context, null);
    }

    public SimpleDraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m18651b(context, attrs);
    }

    public SimpleDraweeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m18651b(context, attrs);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m18651b(context, attrs);
    }

    /* renamed from: b */
    private void m18651b(Context context, @Nullable AttributeSet attrs) {
        if (!isInEditMode()) {
            C5350k.m18311a(f22162a, (Object) "SimpleDraweeView was not initialized!");
            this.f22163b = (C5424d) f22162a.mo3969b();
            if (attrs != null) {
                TypedArray gdhAttrs = context.obtainStyledAttributes(attrs, C5388c.SimpleDraweeView);
                try {
                    if (gdhAttrs.hasValue(C5388c.SimpleDraweeView_actualImageUri)) {
                        setImageURI(Uri.parse(gdhAttrs.getString(C5388c.SimpleDraweeView_actualImageUri)), null);
                    }
                    gdhAttrs.recycle();
                } catch (Throwable th) {
                    gdhAttrs.recycle();
                }
            }
        }
    }

    protected C5424d getControllerBuilder() {
        return this.f22163b;
    }

    public void setImageURI(Uri uri) {
        setImageURI(uri, null);
    }

    public void setImageURI(@Nullable String uriString) {
        setImageURI(uriString, null);
    }

    public void setImageURI(Uri uri, @Nullable Object callerContext) {
        setController(this.f22163b.m18647e(callerContext).m18644b(uri).m18645b(getController()).m18648w());
    }

    public void setImageURI(@Nullable String uriString, @Nullable Object callerContext) {
        setImageURI(uriString != null ? Uri.parse(uriString) : null, callerContext);
    }
}
