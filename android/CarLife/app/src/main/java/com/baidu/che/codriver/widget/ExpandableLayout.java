package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;

public class ExpandableLayout extends ViewGroup {
    /* renamed from: a */
    private int f9442a = 10;
    /* renamed from: b */
    private C2876a f9443b;
    /* renamed from: c */
    private int f9444c;
    /* renamed from: d */
    private int f9445d;
    /* renamed from: e */
    private View f9446e;
    /* renamed from: f */
    private OnItemClickListener f9447f;

    /* renamed from: com.baidu.che.codriver.widget.ExpandableLayout$a */
    public interface C2876a {
        /* renamed from: a */
        int m10883a();

        /* renamed from: a */
        View m10884a(int i);
    }

    public ExpandableLayout(Context context) {
        super(context);
    }

    public ExpandableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int totalHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.layout(0, totalHeight, r, child.getMeasuredHeight() + totalHeight);
            totalHeight += child.getMeasuredHeight();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            height += getChildAt(i).getMeasuredHeight();
        }
        setMeasuredDimension(width, height);
    }

    /* renamed from: a */
    public void m10886a(View view) {
        this.f9446e = view;
        addView(this.f9446e, 0);
        invalidate();
        requestLayout();
    }

    public void setAdapter(C2876a adapter) {
        this.f9443b = adapter;
        this.f9444c = this.f9443b.m10883a();
        removeAllViews();
        m10885a();
        for (int i = 0; i < this.f9445d; i++) {
            addView(this.f9443b.m10884a(i));
        }
        invalidate();
        requestLayout();
    }

    public void setMaxShowNum(int max) {
        this.f9442a = max;
    }

    /* renamed from: a */
    private void m10885a() {
        this.f9445d = Math.min(this.f9444c, this.f9442a);
    }
}
