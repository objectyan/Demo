package com.baidu.carlife.view.pinnedheaderlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PinnedHeaderListView extends ListView implements OnScrollListener {
    /* renamed from: a */
    private OnScrollListener f7756a;
    /* renamed from: b */
    private C1005b f7757b;
    /* renamed from: c */
    private View f7758c;
    /* renamed from: d */
    private int f7759d = 0;
    /* renamed from: e */
    private float f7760e;
    /* renamed from: f */
    private boolean f7761f = true;
    /* renamed from: g */
    private int f7762g = 0;
    /* renamed from: h */
    private int f7763h;
    /* renamed from: i */
    private int f7764i;
    /* renamed from: j */
    private int f7765j = 0;
    /* renamed from: k */
    private int f7766k = 0;

    /* renamed from: com.baidu.carlife.view.pinnedheaderlistview.PinnedHeaderListView$b */
    public interface C1005b {
        /* renamed from: a */
        View mo1366a(int i, View view, ViewGroup viewGroup);

        /* renamed from: c */
        boolean mo1367c(int i);

        /* renamed from: d */
        int mo1368d(int i);

        /* renamed from: e */
        int mo1369e(int i);

        int getCount();
    }

    /* renamed from: com.baidu.carlife.view.pinnedheaderlistview.PinnedHeaderListView$a */
    public static abstract class C2351a implements OnItemClickListener {
        /* renamed from: a */
        public abstract void m8932a(AdapterView<?> adapterView, View view, int i, int i2, long j);

        /* renamed from: a */
        public abstract void m8933a(AdapterView<?> adapterView, View view, int i, long j);

        public void onItemClick(AdapterView<?> adapterView, View view, int rawPosition, long id) {
            C1006b adapter;
            if (adapterView.getAdapter().getClass().equals(HeaderViewListAdapter.class)) {
                adapter = (C1006b) ((HeaderViewListAdapter) adapterView.getAdapter()).getWrappedAdapter();
            } else {
                adapter = (C1006b) adapterView.getAdapter();
            }
            int section = adapter.mo1368d(rawPosition);
            int position = adapter.m3239f(rawPosition);
            if (position == -1) {
                m8933a(adapterView, view, section, id);
            } else {
                m8932a(adapterView, view, section, position, id);
            }
        }
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        super.setOnScrollListener(this);
    }

    public void setPinHeaders(boolean shouldPin) {
        this.f7761f = shouldPin;
    }

    public void setHorizontalMargin(int left, int right) {
        this.f7765j = left;
        this.f7766k = right;
    }

    public void setAdapter(ListAdapter adapter) {
        this.f7758c = null;
        this.f7757b = (C1005b) adapter;
        super.setAdapter(adapter);
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        View view2 = null;
        if (this.f7756a != null) {
            this.f7756a.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
        int i;
        View header;
        if (this.f7757b == null || this.f7757b.getCount() == 0 || !this.f7761f || firstVisibleItem < getHeaderViewsCount()) {
            this.f7758c = null;
            this.f7760e = 0.0f;
            for (i = firstVisibleItem; i < firstVisibleItem + visibleItemCount; i++) {
                header = getChildAt(i);
                if (header != null) {
                    header.setVisibility(0);
                }
            }
            return;
        }
        firstVisibleItem -= getHeaderViewsCount();
        int section = this.f7757b.mo1368d(firstVisibleItem);
        int viewType = this.f7757b.mo1369e(section);
        if (this.f7759d == viewType) {
            view2 = this.f7758c;
        }
        this.f7758c = m8934a(section, view2);
        m8935a(this.f7758c);
        this.f7759d = viewType;
        this.f7760e = 0.0f;
        for (i = firstVisibleItem; i < firstVisibleItem + visibleItemCount; i++) {
            if (this.f7757b.mo1367c(i)) {
                header = getChildAt(i - firstVisibleItem);
                float headerTop = (float) header.getTop();
                float pinnedHeaderHeight = (float) this.f7758c.getMeasuredHeight();
                header.setVisibility(0);
                if (pinnedHeaderHeight >= headerTop && headerTop > 0.0f) {
                    this.f7760e = headerTop - ((float) header.getHeight());
                } else if (headerTop <= 0.0f) {
                    header.setVisibility(4);
                }
            }
        }
        invalidate();
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (this.f7756a != null) {
            this.f7756a.onScrollStateChanged(view, scrollState);
        }
    }

    /* renamed from: a */
    private View m8934a(int section, View oldView) {
        boolean shouldLayout = section != this.f7762g || oldView == null;
        View view = this.f7757b.mo1366a(section, oldView, this);
        if (shouldLayout) {
            m8935a(view);
            this.f7762g = section;
        }
        return view;
    }

    /* renamed from: a */
    private void m8935a(View header) {
        if (header.isLayoutRequested()) {
            int heightSpec;
            int widthSpec = MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.f7765j) - this.f7766k, this.f7763h);
            LayoutParams layoutParams = header.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                heightSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                heightSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            header.measure(widthSpec, heightSpec);
            header.layout(0, 0, header.getMeasuredWidth(), header.getMeasuredHeight());
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f7757b != null && this.f7761f && this.f7758c != null) {
            int saveCount = canvas.save();
            canvas.translate((float) this.f7765j, this.f7760e);
            canvas.clipRect(0, 0, getWidth(), this.f7758c.getMeasuredHeight());
            this.f7758c.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    public void setOnScrollListener(OnScrollListener l) {
        this.f7756a = l;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.f7763h = MeasureSpec.getMode(widthMeasureSpec);
        this.f7764i = MeasureSpec.getMode(heightMeasureSpec);
    }

    public void setOnItemClickListener(C2351a listener) {
        super.setOnItemClickListener(listener);
    }
}
