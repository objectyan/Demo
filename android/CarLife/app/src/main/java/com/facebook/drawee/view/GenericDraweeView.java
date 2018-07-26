package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.p147e.C2934a;
import com.facebook.drawee.p147e.C2935b;
import com.facebook.drawee.p147e.C2936c;
import javax.annotation.Nullable;

public class GenericDraweeView extends DraweeView<C2934a> {
    public GenericDraweeView(Context context, C2934a hierarchy) {
        super(context);
        setHierarchy(hierarchy);
    }

    public GenericDraweeView(Context context) {
        super(context);
        m18649a(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m18649a(context, attrs);
    }

    public GenericDraweeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m18649a(context, attrs);
    }

    @TargetApi(21)
    public GenericDraweeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m18649a(context, attrs);
    }

    /* renamed from: a */
    protected void m18649a(Context context, @Nullable AttributeSet attrs) {
        C2935b builder = C2936c.b(context, attrs);
        setAspectRatio(builder.d());
        setHierarchy(builder.u());
    }
}
