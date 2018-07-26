package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.C2923j;
import com.facebook.drawee.p142g.C2925a;
import com.facebook.drawee.p142g.C5422b;
import com.facebook.drawee.view.C5426a.C5425a;
import javax.annotation.Nullable;

public class DraweeView<DH extends C5422b> extends ImageView {
    /* renamed from: a */
    private final C5425a f13017a = new C5425a();
    /* renamed from: b */
    private float f13018b = 0.0f;
    /* renamed from: c */
    private C2939b<DH> f13019c;
    /* renamed from: d */
    private boolean f13020d = false;

    public DraweeView(Context context) {
        super(context);
        m11562a(context);
    }

    public DraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m11562a(context);
    }

    public DraweeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m11562a(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m11562a(context);
    }

    /* renamed from: a */
    private void m11562a(Context context) {
        if (!this.f13020d) {
            this.f13020d = true;
            this.f13019c = C2939b.m11569a(null, context);
            if (VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                }
            }
        }
    }

    public void setHierarchy(DH hierarchy) {
        this.f13019c.m11577a((C5422b) hierarchy);
        super.setImageDrawable(this.f13019c.m11588j());
    }

    public DH getHierarchy() {
        return this.f13019c.m11586h();
    }

    /* renamed from: a */
    public boolean m11563a() {
        return this.f13019c.m11587i();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.f13019c.m11588j();
    }

    public void setController(@Nullable C2925a draweeController) {
        this.f13019c.m11576a(draweeController);
        super.setImageDrawable(this.f13019c.m11588j());
    }

    @Nullable
    public C2925a getController() {
        return this.f13019c.m11585g();
    }

    /* renamed from: b */
    public boolean m11564b() {
        return this.f13019c.m11585g() != null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m11565c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m11566d();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m11566d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m11565c();
    }

    /* renamed from: c */
    protected void m11565c() {
        m11567e();
    }

    /* renamed from: d */
    protected void m11566d() {
        m11568f();
    }

    /* renamed from: e */
    protected void m11567e() {
        this.f13019c.m11582d();
    }

    /* renamed from: f */
    protected void m11568f() {
        this.f13019c.m11584f();
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.f13019c.m11579a(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        m11562a(getContext());
        this.f13019c.m11576a(null);
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageBitmap(Bitmap bm) {
        m11562a(getContext());
        this.f13019c.m11576a(null);
        super.setImageBitmap(bm);
    }

    @Deprecated
    public void setImageResource(int resId) {
        m11562a(getContext());
        this.f13019c.m11576a(null);
        super.setImageResource(resId);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        m11562a(getContext());
        this.f13019c.m11576a(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float aspectRatio) {
        if (aspectRatio != this.f13018b) {
            this.f13018b = aspectRatio;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.f13018b;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.f13017a.f22164a = widthMeasureSpec;
        this.f13017a.f22165b = heightMeasureSpec;
        C5426a.a(this.f13017a, this.f13018b, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.f13017a.f22164a, this.f13017a.f22165b);
    }

    public String toString() {
        return C2923j.m11271a((Object) this).a("holder", this.f13019c != null ? this.f13019c.toString() : "<no holder set>").toString();
    }
}
