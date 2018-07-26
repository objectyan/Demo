package com.baidu.navi.view.xpulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class XListView extends ListView implements OnScrollListener {
    private static final float OFFSET_RADIO = 1.8f;
    private static final int PULL_LOAD_MORE_DELTA = 50;
    private static final int SCROLL_BACK_FOOTER = 1;
    private static final int SCROLL_BACK_HEADER = 0;
    private static final int SCROLL_DURATION = 400;
    private boolean mEnableAutoLoad = false;
    private boolean mEnablePullLoad = false;
    private boolean mEnablePullRefresh = false;
    private LinearLayout mFooterLayout;
    private XFooterView mFooterView;
    private XHeaderView mHeader;
    private RelativeLayout mHeaderContent;
    private int mHeaderHeight;
    private TextView mHeaderTime;
    private boolean mIsFooterReady = false;
    private float mLastY = -1.0f;
    private IXListViewListener mListener;
    private boolean mPullLoading = false;
    private boolean mPullRefreshing = false;
    private int mScrollBack;
    private OnScrollListener mScrollListener;
    private Scroller mScroller;
    private int mTotalItemCount;

    public interface IXListViewListener {
        void onLoadMore();

        void onRefresh();
    }

    /* renamed from: com.baidu.navi.view.xpulltorefresh.XListView$1 */
    class C40391 implements OnGlobalLayoutListener {
        C40391() {
        }

        @TargetApi(16)
        public void onGlobalLayout() {
            XListView.this.mHeaderHeight = XListView.this.mHeaderContent.getHeight();
            ViewTreeObserver observer = XListView.this.getViewTreeObserver();
            if (observer == null) {
                return;
            }
            if (VERSION.SDK_INT < 16) {
                observer.removeGlobalOnLayoutListener(this);
            } else {
                observer.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* renamed from: com.baidu.navi.view.xpulltorefresh.XListView$2 */
    class C40402 implements OnClickListener {
        C40402() {
        }

        public void onClick(View v) {
            XListView.this.startLoadMore();
        }
    }

    /* renamed from: com.baidu.navi.view.xpulltorefresh.XListView$3 */
    class C40413 implements OnClickListener {
        C40413() {
        }

        public void onClick(View v) {
            XListView.this.startLoadMore();
        }
    }

    public interface OnXScrollListener extends OnScrollListener {
        void onXScrolling(View view);
    }

    public XListView(Context context) {
        super(context);
        initWithContext(context);
    }

    public XListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithContext(context);
    }

    public XListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initWithContext(context);
    }

    private void initWithContext(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);
        setCacheColorHint(0);
        disableEdgeEffect();
        disableEdgeGlow();
        this.mHeader = new XHeaderView(context);
        this.mHeaderContent = (RelativeLayout) this.mHeader.findViewById(C0965R.id.header_content);
        this.mHeaderTime = (TextView) this.mHeader.findViewById(C0965R.id.header_hint_time);
        addHeaderView(this.mHeader);
        this.mFooterView = new XFooterView(context);
        this.mFooterLayout = new LinearLayout(context);
        LayoutParams params = new LayoutParams(-1, -1);
        params.gravity = 17;
        this.mFooterLayout.addView(this.mFooterView, params);
        ViewTreeObserver observer = this.mHeader.getViewTreeObserver();
        if (observer != null) {
            observer.addOnGlobalLayoutListener(new C40391());
        }
    }

    public void setAdapter(ListAdapter adapter) {
        if (!this.mIsFooterReady) {
            this.mIsFooterReady = true;
            addFooterView(this.mFooterLayout);
        }
        super.setAdapter(adapter);
    }

    public void setPullRefreshEnable(boolean enable) {
        this.mEnablePullRefresh = enable;
        this.mHeaderContent.setVisibility(enable ? 0 : 4);
    }

    public void setPullLoadEnable(boolean enable) {
        this.mEnablePullLoad = enable;
        if (this.mEnablePullLoad) {
            this.mPullLoading = false;
            this.mFooterView.setPadding(0, 0, 0, 0);
            this.mFooterView.show();
            this.mFooterView.setState(0);
            this.mFooterView.setOnClickListener(new C40402());
            return;
        }
        this.mFooterView.setBottomMargin(0);
        this.mFooterView.hide();
        this.mFooterView.setPadding(0, 0, 0, this.mFooterView.getHeight() * -1);
        this.mFooterView.setOnClickListener(null);
    }

    public void setPullLoadEnable(boolean enable, boolean showFooter) {
        this.mEnablePullLoad = enable;
        if (this.mEnablePullLoad) {
            this.mPullLoading = false;
            this.mFooterView.setPadding(0, 0, 0, 0);
            this.mFooterView.show();
            this.mFooterView.setState(0);
            this.mFooterView.setOnClickListener(new C40413());
            return;
        }
        if (showFooter) {
            this.mFooterView.setPadding(0, 0, 0, 0);
            this.mFooterView.show();
            this.mFooterView.setState(0);
        } else {
            this.mFooterView.setBottomMargin(0);
            this.mFooterView.hide();
            this.mFooterView.setPadding(0, 0, 0, this.mFooterView.getHeight() * -1);
        }
        this.mFooterView.setOnClickListener(null);
    }

    public void setAutoLoadEnable(boolean enable) {
        this.mEnableAutoLoad = enable;
    }

    public void stopRefresh() {
        if (this.mPullRefreshing) {
            this.mPullRefreshing = false;
            resetHeaderHeight();
        }
    }

    public void stopLoadMore() {
        if (this.mPullLoading) {
            this.mPullLoading = false;
            this.mFooterView.setState(0);
        }
    }

    public void setRefreshTime(String time) {
        this.mHeaderTime.setText(time);
    }

    public void setXListViewListener(IXListViewListener listener) {
        this.mListener = listener;
    }

    public void autoRefresh() {
        this.mHeader.setVisibleHeight(this.mHeaderHeight);
        if (this.mEnablePullRefresh && !this.mPullRefreshing) {
            if (this.mHeader.getVisibleHeight() > this.mHeaderHeight) {
                this.mHeader.setState(1);
            } else {
                this.mHeader.setState(0);
            }
        }
        this.mPullRefreshing = true;
        this.mHeader.setState(2);
        refresh();
    }

    private void invokeOnScrolling() {
        if (this.mScrollListener instanceof OnXScrollListener) {
            this.mScrollListener.onXScrolling(this);
        }
    }

    private void updateHeaderHeight(float delta) {
        this.mHeader.setVisibleHeight(((int) delta) + this.mHeader.getVisibleHeight());
        if (this.mEnablePullRefresh && !this.mPullRefreshing) {
            if (this.mHeader.getVisibleHeight() > this.mHeaderHeight) {
                this.mHeader.setState(1);
            } else {
                this.mHeader.setState(0);
            }
        }
        setSelection(0);
    }

    private void resetHeaderHeight() {
        int height = this.mHeader.getVisibleHeight();
        if (height != 0) {
            if (!this.mPullRefreshing || height > this.mHeaderHeight) {
                int finalHeight = 0;
                if (this.mPullRefreshing && height > this.mHeaderHeight) {
                    finalHeight = this.mHeaderHeight;
                }
                this.mScrollBack = 0;
                this.mScroller.startScroll(0, height, 0, finalHeight - height, 400);
                invalidate();
            }
        }
    }

    private void updateFooterHeight(float delta) {
        int height = this.mFooterView.getBottomMargin() + ((int) delta);
        if (this.mEnablePullLoad && !this.mPullLoading) {
            if (height > 50) {
                this.mFooterView.setState(1);
            } else {
                this.mFooterView.setState(0);
            }
        }
        this.mFooterView.setBottomMargin(height);
    }

    private void resetFooterHeight() {
        int bottomMargin = this.mFooterView.getBottomMargin();
        if (bottomMargin > 0) {
            this.mScrollBack = 1;
            this.mScroller.startScroll(0, bottomMargin, 0, -bottomMargin, 400);
            invalidate();
        }
    }

    private void startLoadMore() {
        this.mPullLoading = true;
        this.mFooterView.setState(2);
        loadMore();
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.mLastY == -1.0f) {
            this.mLastY = ev.getRawY();
        }
        switch (ev.getAction()) {
            case 0:
                this.mLastY = ev.getRawY();
                break;
            case 2:
                float deltaY = ev.getRawY() - this.mLastY;
                this.mLastY = ev.getRawY();
                if (getFirstVisiblePosition() != 0 || (this.mHeader.getVisibleHeight() <= 0 && deltaY <= 0.0f)) {
                    if (getLastVisiblePosition() == this.mTotalItemCount - 1 && (this.mFooterView.getBottomMargin() > 0 || deltaY < 0.0f)) {
                        updateFooterHeight((-deltaY) / OFFSET_RADIO);
                        break;
                    }
                }
                updateHeaderHeight(deltaY / OFFSET_RADIO);
                invokeOnScrolling();
                break;
                break;
            default:
                this.mLastY = -1.0f;
                if (getFirstVisiblePosition() != 0) {
                    if (getLastVisiblePosition() == this.mTotalItemCount - 1) {
                        if (this.mEnablePullLoad && this.mFooterView.getBottomMargin() > 50) {
                            startLoadMore();
                        }
                        resetFooterHeight();
                        break;
                    }
                }
                if (this.mEnablePullRefresh && this.mHeader.getVisibleHeight() > this.mHeaderHeight) {
                    this.mPullRefreshing = true;
                    this.mHeader.setState(2);
                    refresh();
                }
                resetHeaderHeight();
                break;
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScrollBack == 0) {
                this.mHeader.setVisibleHeight(this.mScroller.getCurrY());
            } else {
                this.mFooterView.setBottomMargin(this.mScroller.getCurrY());
            }
            postInvalidate();
            invokeOnScrolling();
        }
        super.computeScroll();
    }

    public void setOnScrollListener(OnScrollListener l) {
        this.mScrollListener = l;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (this.mScrollListener != null) {
            this.mScrollListener.onScrollStateChanged(view, scrollState);
        }
        if (scrollState == 0 && this.mEnableAutoLoad && getLastVisiblePosition() == getCount() - 1) {
            startLoadMore();
        }
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.mTotalItemCount = totalItemCount;
        if (this.mScrollListener != null) {
            this.mScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    private void refresh() {
        if (this.mEnablePullRefresh && this.mListener != null) {
            this.mListener.onRefresh();
        }
    }

    private void loadMore() {
        if (this.mEnablePullLoad && this.mListener != null) {
            this.mListener.onLoadMore();
        }
    }

    private void disableEdgeGlow() {
        try {
            Class absListView = Class.forName("android.widget.AbsListView");
            if (absListView != null) {
                Constructor constructor = Class.forName("android.widget.EdgeGlow").getConstructor(new Class[]{Drawable.class, Drawable.class});
                Object mTop = constructor.newInstance(new Object[]{new ColorDrawable(17170445), new ColorDrawable(17170445)});
                Object mBottom = constructor.newInstance(new Object[]{new ColorDrawable(17170445), new ColorDrawable(17170445)});
                Field mEdgeGlowTop = absListView.getDeclaredField("mEdgeGlowTop");
                Field mEdgeGlowBottom = absListView.getDeclaredField("mEdgeGlowBottom");
                if (mEdgeGlowTop != null) {
                    mEdgeGlowTop.setAccessible(true);
                    mEdgeGlowTop.set(this, mTop);
                }
                if (mEdgeGlowBottom != null) {
                    mEdgeGlowBottom.setAccessible(true);
                    mEdgeGlowBottom.set(this, mBottom);
                }
            }
        } catch (Exception e) {
        }
    }

    private void disableEdgeEffect() {
        try {
            Class absListView = Class.forName("android.widget.AbsListView");
            if (absListView != null) {
                Class edageEffectClass = Class.forName("android.widget.EdgeEffect");
                Constructor constructor = edageEffectClass.getConstructor(new Class[]{Context.class});
                Object mTop = constructor.newInstance(new Object[]{getContext()});
                Object mBottom = constructor.newInstance(new Object[]{getContext()});
                Field mEdge = edageEffectClass.getDeclaredField("mEdge");
                Field mGlow = edageEffectClass.getDeclaredField("mGlow");
                mEdge.setAccessible(true);
                mGlow.setAccessible(true);
                mEdge.set(mTop, new ColorDrawable(17170445));
                mEdge.set(mBottom, new ColorDrawable(17170445));
                mGlow.set(mTop, new ColorDrawable(17170445));
                mGlow.set(mBottom, new ColorDrawable(17170445));
                Field mEdgeGlowTop = absListView.getDeclaredField("mEdgeGlowTop");
                Field mEdgeGlowBottom = absListView.getDeclaredField("mEdgeGlowBottom");
                if (mEdgeGlowTop != null) {
                    mEdgeGlowTop.setAccessible(true);
                    mEdgeGlowTop.set(this, mTop);
                }
                if (mEdgeGlowBottom != null) {
                    mEdgeGlowBottom.setAccessible(true);
                    mEdgeGlowBottom.set(this, mBottom);
                }
            }
        } catch (Exception e) {
        }
    }

    public XFooterView getXFooterView() {
        return this.mFooterView;
    }

    public XHeaderView getXHeaderView() {
        return this.mHeader;
    }

    public void setXFooterBgColor(int color) {
        if (this.mFooterView != null) {
            this.mFooterView.setBackgroundColor(color);
        }
    }

    public void setXHeaderBgColor(int color) {
        if (this.mHeader != null) {
            this.mHeader.setBackgroundColor(color);
        }
    }

    public void setXFooterText(int resid) {
        if (this.mFooterView != null) {
            this.mFooterView.setText(resid);
        }
    }

    public void setTextColor(int color) {
        if (this.mFooterView != null) {
            this.mFooterView.setTextColor(color);
        }
        if (this.mHeader != null) {
            this.mHeader.setTextColor(color);
        }
    }
}
