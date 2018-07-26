package com.baidu.navisdk.ui.search.xpulltorefresh;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class XScrollView extends ScrollView implements OnScrollListener {
    private static final float OFFSET_RADIO = 1.8f;
    private static final int PULL_LOAD_MORE_DELTA = 50;
    private static final int SCROLL_BACK_FOOTER = 1;
    private static final int SCROLL_BACK_HEADER = 0;
    private static final int SCROLL_DURATION = 400;
    private Activity mActivity;
    private LinearLayout mContentLayout;
    private boolean mEnableAutoLoad = false;
    private boolean mEnablePullLoad = false;
    private boolean mEnablePullRefresh = false;
    private XFooterView mFooterView;
    private XHeaderView mHeader;
    private RelativeLayout mHeaderContent;
    private int mHeaderHeight;
    private TextView mHeaderTime;
    private float mLastY = -1.0f;
    private IXScrollViewListener mListener;
    private boolean mPullLoading = false;
    private boolean mPullRefreshing = false;
    private int mScrollBack;
    private OnScrollListener mScrollListener;
    private Scroller mScroller;
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.navisdk.ui.search.xpulltorefresh.XScrollView$1 */
    class C44871 implements OnGlobalLayoutListener {
        C44871() {
        }

        @TargetApi(16)
        public void onGlobalLayout() {
            XScrollView.this.mHeaderHeight = XScrollView.this.mHeaderContent.getHeight();
            ViewTreeObserver observer = XScrollView.this.getViewTreeObserver();
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

    /* renamed from: com.baidu.navisdk.ui.search.xpulltorefresh.XScrollView$2 */
    class C44882 implements OnClickListener {
        C44882() {
        }

        public void onClick(View v) {
            XScrollView.this.startLoadMore();
        }
    }

    public interface IXScrollViewListener {
        void onLoadMore();

        void onRefresh();
    }

    public interface OnXScrollListener extends OnScrollListener {
        void onXScrolling(View view);
    }

    public XScrollView(Context context) {
        super(context);
        initWithContext((Activity) context);
    }

    public XScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithContext((Activity) context);
    }

    public XScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initWithContext((Activity) context);
    }

    private void initWithContext(Activity mActivity) {
        disableEdgeEffect();
        disableEdgeGlow();
        this.mViewGroup = (ViewGroup) JarUtils.inflate(mActivity, C4048R.layout.layout_xpulltorefresh_crollview, null);
        this.mContentLayout = (LinearLayout) this.mViewGroup.findViewById(C4048R.id.content_layout);
        this.mScroller = new Scroller(mActivity, new DecelerateInterpolator());
        setOnScrollListener(this);
        this.mHeader = new XHeaderView(mActivity);
        this.mHeaderContent = (RelativeLayout) this.mHeader.findViewById(C4048R.id.header_content);
        this.mHeaderTime = (TextView) this.mHeader.findViewById(C4048R.id.header_hint_time);
        LinearLayout headerLayout = (LinearLayout) this.mViewGroup.findViewById(C4048R.id.header_layout);
        if (headerLayout != null) {
            headerLayout.addView(this.mHeader);
        }
        this.mFooterView = new XFooterView(mActivity);
        LayoutParams params = new LayoutParams(-1, -1);
        params.gravity = 17;
        LinearLayout footLayout = (LinearLayout) this.mViewGroup.findViewById(C4048R.id.footer_layout);
        if (footLayout != null) {
            footLayout.addView(this.mFooterView, params);
        }
        ViewTreeObserver observer = this.mHeader.getViewTreeObserver();
        if (observer != null) {
            observer.addOnGlobalLayoutListener(new C44871());
        }
        addView(this.mViewGroup);
    }

    public void setContentView(ViewGroup content) {
        if (this.mViewGroup != null) {
            if (this.mContentLayout == null) {
                this.mContentLayout = (LinearLayout) this.mViewGroup.findViewById(C4048R.id.content_layout);
            }
            if (this.mContentLayout != null && this.mContentLayout.getChildCount() > 0) {
                this.mContentLayout.removeAllViews();
            }
            if (this.mContentLayout != null) {
                this.mContentLayout.addView(content);
            }
        }
    }

    public void setView(View content) {
        if (this.mViewGroup != null) {
            if (this.mContentLayout == null) {
                this.mContentLayout = (LinearLayout) this.mViewGroup.findViewById(C4048R.id.content_layout);
            }
            if (this.mContentLayout != null) {
                this.mContentLayout.addView(content);
            }
        }
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
            this.mFooterView.setOnClickListener(new C44882());
            return;
        }
        this.mFooterView.setBottomMargin(0);
        this.mFooterView.hide();
        this.mFooterView.setPadding(0, 0, 0, this.mFooterView.getHeight() * -1);
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

    public void setIXScrollViewListener(IXScrollViewListener listener) {
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
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("updateHeaderHeight-" + getClass().getSimpleName(), null) {
            protected String execute() {
                XScrollView.this.fullScroll(33);
                return null;
            }
        }, new BNWorkerConfig(100, 0));
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
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("updateFooterHeight-" + getClass().getSimpleName(), null) {
            protected String execute() {
                XScrollView.this.fullScroll(130);
                return null;
            }
        }, new BNWorkerConfig(100, 0));
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
        if (!this.mPullLoading) {
            this.mPullLoading = true;
            this.mFooterView.setState(2);
            loadMore();
        }
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
                if (!isTop() || (this.mHeader.getVisibleHeight() <= 0 && deltaY <= 0.0f)) {
                    if (isBottom() && (this.mFooterView.getBottomMargin() > 0 || deltaY < 0.0f)) {
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
                resetHeaderOrBottom();
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void resetHeaderOrBottom() {
        if (isTop()) {
            if (this.mEnablePullRefresh && this.mHeader.getVisibleHeight() > this.mHeaderHeight) {
                this.mPullRefreshing = true;
                this.mHeader.setState(2);
                refresh();
            }
            resetHeaderHeight();
        } else if (isBottom()) {
            if (this.mEnablePullLoad && this.mFooterView.getBottomMargin() > 50) {
                startLoadMore();
            }
            resetFooterHeight();
        }
    }

    private boolean isTop() {
        return getScrollY() <= 0 || this.mHeader.getVisibleHeight() > this.mHeaderHeight;
    }

    private boolean isBottom() {
        return Math.abs((getScrollY() + getHeight()) - computeVerticalScrollRange()) <= 5 || (getScrollY() > 0 && this.mFooterView != null && this.mFooterView.getBottomMargin() > 0);
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
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        View view = getChildAt(getChildCount() - 1);
        if (view != null && view.getBottom() - (view.getHeight() + view.getScrollY()) == 0 && this.mEnableAutoLoad) {
            startLoadMore();
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
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
}
