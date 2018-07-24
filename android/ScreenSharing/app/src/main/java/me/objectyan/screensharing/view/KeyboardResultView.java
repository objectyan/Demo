package com.baidu.carlife.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.baidu.carlife.R;
import com.baidu.carlife.core.LogUtil;

public class KeyboardResultView extends ViewGroup {
    /* renamed from: a */
    private BaseAdapter f7175a;
    /* renamed from: b */
    private C2227c f7176b;
    /* renamed from: c */
    private C2225a f7177c;
    /* renamed from: d */
    private SparseArray<Integer> f7178d;
    /* renamed from: e */
    private int f7179e;
    /* renamed from: f */
    private C2226b f7180f;
    /* renamed from: g */
    private int f7181g;

    /* renamed from: com.baidu.carlife.view.KeyboardResultView$1 */
    class C22221 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ KeyboardResultView f7169a;

        C22221(KeyboardResultView this$0) {
            this.f7169a = this$0;
        }

        public void run() {
            this.f7169a.requestLayout();
        }
    }

    /* renamed from: com.baidu.carlife.view.KeyboardResultView$2 */
    class C22232 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ KeyboardResultView f7170a;

        C22232(KeyboardResultView this$0) {
            this.f7170a = this$0;
        }

        public void run() {
            this.f7170a.requestLayout();
        }
    }

    /* renamed from: com.baidu.carlife.view.KeyboardResultView$a */
    class C2225a extends DataSetObserver {
        /* renamed from: a */
        final /* synthetic */ KeyboardResultView f7174a;

        C2225a(KeyboardResultView this$0) {
            this.f7174a = this$0;
        }

        public void onChanged() {
            this.f7174a.m8454a(true);
        }

        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* renamed from: com.baidu.carlife.view.KeyboardResultView$b */
    public interface C2226b {
        /* renamed from: a */
        void mo1819a(boolean z, boolean z2, int i);
    }

    /* renamed from: com.baidu.carlife.view.KeyboardResultView$c */
    public interface C2227c {
        /* renamed from: a */
        void mo1800a(int i, View view);
    }

    public void setPageCallback(C2226b pageCallback) {
        this.f7180f = pageCallback;
    }

    public KeyboardResultView(Context context) {
        super(context);
        m8452a(context, null, 0);
    }

    public KeyboardResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m8452a(context, attrs, 0);
    }

    public KeyboardResultView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m8452a(context, attrs, defStyle);
    }

    /* renamed from: a */
    private void m8452a(Context context, AttributeSet attrs, int defStyle) {
        this.f7181g = context.getResources().getDimensionPixelSize(R.dimen.keyboard_result_item_spacing);
    }

    /* renamed from: a */
    public void m8455a() {
        if (this.f7178d.get(this.f7179e + 1) != null) {
            this.f7179e++;
            m8454a(false);
            new Handler().postDelayed(new C22221(this), 0);
        }
    }

    /* renamed from: b */
    public void m8456b() {
        if (this.f7179e > 0 && this.f7178d.get(this.f7179e - 1) != null) {
            this.f7179e--;
            m8454a(false);
            new Handler().postDelayed(new C22232(this), 0);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wantWidth = resolveSize(0, widthMeasureSpec);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int currentWidth = 0;
        int childHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            LayoutParams params = childView.getLayoutParams();
            childView.measure(getChildMeasureSpec(widthMeasureSpec, 0, params.width), getChildMeasureSpec(heightMeasureSpec, 0, params.height));
            int childWidth = childView.getMeasuredWidth();
            childHeight = childView.getMeasuredHeight();
            if (((paddingLeft + currentWidth) + childWidth) + paddingRight > wantWidth) {
                break;
            }
            currentWidth += this.f7181g + childWidth;
        }
        setMeasuredDimension(wantWidth, 0 + ((childHeight + paddingTop) + paddingBottom));
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = r - l;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int currentWidth = 0;
        int i = 0;
        while (i < getChildCount()) {
            View childView = getChildAt(i);
            if (i == 0) {
                childView.setSelected(true);
            } else {
                childView.setSelected(false);
            }
            int childWidth = childView.getMeasuredWidth();
            childView.layout(currentWidth, paddingTop, currentWidth + childWidth, paddingTop + childView.getMeasuredHeight());
            if (((paddingLeft + currentWidth) + childWidth) + paddingRight > width) {
                this.f7178d.put(this.f7179e + 1, Integer.valueOf(((Integer) this.f7178d.get(this.f7179e)).intValue() + i));
                break;
            } else {
                currentWidth += this.f7181g + childWidth;
                i++;
            }
        }
        if (this.f7180f != null) {
            this.f7180f.mo1819a(this.f7179e > 0, this.f7178d.get(this.f7179e + 1) != null, i);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setAdapter(BaseAdapter adapter) {
        if (this.f7175a == null) {
            this.f7175a = adapter;
            if (this.f7177c == null) {
                this.f7177c = new C2225a(this);
                this.f7175a.registerDataSetObserver(this.f7177c);
            }
            if (this.f7178d == null) {
                this.f7178d = new SparseArray();
            }
            m8454a(true);
        }
    }

    /* renamed from: a */
    private void m8454a(boolean needClear) {
        if (needClear) {
            this.f7178d.clear();
            if (this.f7180f != null) {
                this.f7180f.mo1819a(false, false, 0);
            }
            this.f7179e = 0;
            this.f7178d.put(0, Integer.valueOf(0));
        }
        removeAllViews();
        if (this.f7175a != null) {
            int count = this.f7175a.getCount();
            if (count != 0) {
                for (int i = ((Integer) this.f7178d.get(this.f7179e)).intValue(); i < count; i++) {
                    final View view = this.f7175a.getView(i, null, null);
                    final int position = i;
                    view.setOnClickListener(new OnClickListener(this) {
                        /* renamed from: c */
                        final /* synthetic */ KeyboardResultView f7173c;

                        public void onClick(View v) {
                            if (this.f7173c.f7176b != null) {
                                this.f7173c.f7176b.mo1800a(position, view);
                            }
                        }
                    });
                    try {
                        addView(view);
                    } catch (Exception e) {
                        LogUtil.m4445e("KeyboardResultView", e.toString());
                    }
                }
            }
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public void setItemClickListener(C2227c mListener) {
        this.f7176b = mListener;
    }
}
