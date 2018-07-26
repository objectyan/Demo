package com.baidu.navisdk.ui.widget.ptrrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView.DragState;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.DefaultLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.header.Header;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.util.PullToRefreshRecyclerViewUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class PullToRefreshRecyclerView extends TwoStateScrollView implements PrvInterface {
    private static final int FINGER_SIZE = 5;
    private static final int INNER_VIEW_TOUCH_SIZE = 20;
    private static final String TAG = PullToRefreshRecyclerView.class.getSimpleName();
    private int downY;
    private boolean hasMoreItems;
    private boolean interceptHasActionDown;
    private int interceptLastY;
    private boolean isLoading;
    private AdapterObserver mAdapterObserver;
    private int mCurScroll;
    private View mEmptyView;
    private View mHeader;
    private InterOnScrollListener mInterOnScrollListener;
    private boolean mIsSwipeEnable;
    private int mLoadMoreCount;
    private BaseLoadMoreView mLoadMoreFooter;
    private OnScrollListener mOnScrollLinstener;
    private PagingableListener mPagingableListener;
    private PullToRefreshRecyclerViewUtil mPtrrvUtil;
    private RecyclerView mRecyclerView;
    private Header mRootHeader;
    private RelativeLayout mRootRelativeLayout;

    public interface PagingableListener {
        void onLoadMoreItems();
    }

    /* renamed from: com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView$1 */
    class C46141 implements OnGlobalLayoutListener {
        C46141() {
        }

        public void onGlobalLayout() {
            if (VERSION.SDK_INT >= 16) {
                PullToRefreshRecyclerView.this.mHeader.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                PullToRefreshRecyclerView.this.mHeader.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            if (PullToRefreshRecyclerView.this.getRecyclerView() != null && PullToRefreshRecyclerView.this.mHeader != null) {
                if (PullToRefreshRecyclerView.this.mRootHeader == null) {
                    PullToRefreshRecyclerView.this.mRootHeader = new Header();
                }
                PullToRefreshRecyclerView.this.mRootHeader.setHeight(PullToRefreshRecyclerView.this.mHeader.getMeasuredHeight());
                PullToRefreshRecyclerView.this.getRecyclerView().removeItemDecoration(PullToRefreshRecyclerView.this.mRootHeader);
                PullToRefreshRecyclerView.this.getRecyclerView().addItemDecoration(PullToRefreshRecyclerView.this.mRootHeader);
                PullToRefreshRecyclerView.this.getRecyclerView().getAdapter().notifyDataSetChanged();
            }
        }
    }

    private class AdapterObserver extends AdapterDataObserver {
        private AdapterObserver() {
        }

        public void onChanged() {
            super.onChanged();
            if (PullToRefreshRecyclerView.this.mRecyclerView != null) {
                Adapter<?> adapter = PullToRefreshRecyclerView.this.mRecyclerView.getAdapter();
                if (adapter != null && PullToRefreshRecyclerView.this.mEmptyView != null) {
                    if (adapter.getItemCount() == 0) {
                        if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
                            PullToRefreshRecyclerView.this.setEnabled(false);
                        }
                        if (PullToRefreshRecyclerView.this.mEmptyView.getParent() != PullToRefreshRecyclerView.this.mRootRelativeLayout) {
                            PullToRefreshRecyclerView.this.mRootRelativeLayout.addView(PullToRefreshRecyclerView.this.mEmptyView);
                        }
                        PullToRefreshRecyclerView.this.mEmptyView.setVisibility(0);
                        PullToRefreshRecyclerView.this.mRecyclerView.setVisibility(8);
                        return;
                    }
                    if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
                        PullToRefreshRecyclerView.this.setEnabled(true);
                    }
                    PullToRefreshRecyclerView.this.mEmptyView.setVisibility(8);
                    PullToRefreshRecyclerView.this.mRecyclerView.setVisibility(0);
                }
            }
        }
    }

    private class InterOnScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener {
        private InterOnScrollListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (PullToRefreshRecyclerView.this.mOnScrollLinstener != null) {
                PullToRefreshRecyclerView.this.mOnScrollLinstener.onScrollStateChanged(recyclerView, newState);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (PullToRefreshRecyclerView.this.getLayoutManager() != null) {
                PullToRefreshRecyclerView.this.mCurScroll = PullToRefreshRecyclerView.this.mCurScroll + dy;
                if (PullToRefreshRecyclerView.this.mHeader != null && VERSION.SDK_INT >= 11) {
                    PullToRefreshRecyclerView.this.mHeader.setTranslationY((float) (-PullToRefreshRecyclerView.this.mCurScroll));
                }
                int visibleItemCount = PullToRefreshRecyclerView.this.getLayoutManager().getChildCount();
                int totalItemCount = PullToRefreshRecyclerView.this.getLayoutManager().getItemCount();
                int firstVisibleItem = PullToRefreshRecyclerView.this.findFirstVisibleItemPosition();
                int lastVisibleItem = PullToRefreshRecyclerView.this.findLastVisibleItemPosition();
                if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
                    if (PullToRefreshRecyclerView.this.findFirstCompletelyVisibleItemPosition() != 0) {
                        PullToRefreshRecyclerView.this.setEnabled(false);
                    } else {
                        PullToRefreshRecyclerView.this.setEnabled(true);
                    }
                }
                if (totalItemCount < PullToRefreshRecyclerView.this.mLoadMoreCount) {
                    PullToRefreshRecyclerView.this.setHasMoreItems(false);
                    PullToRefreshRecyclerView.this.isLoading = false;
                } else if (!PullToRefreshRecyclerView.this.isLoading && PullToRefreshRecyclerView.this.hasMoreItems && lastVisibleItem + 1 == totalItemCount && PullToRefreshRecyclerView.this.mPagingableListener != null) {
                    PullToRefreshRecyclerView.this.isLoading = true;
                    PullToRefreshRecyclerView.this.mPagingableListener.onLoadMoreItems();
                }
                if (PullToRefreshRecyclerView.this.mOnScrollLinstener != null) {
                    PullToRefreshRecyclerView.this.mOnScrollLinstener.onScrolled(recyclerView, dx, dy);
                    PullToRefreshRecyclerView.this.mOnScrollLinstener.onScroll(recyclerView, firstVisibleItem, visibleItemCount, totalItemCount);
                }
            }
        }
    }

    public interface OnScrollListener {
        void onScroll(RecyclerView recyclerView, int i, int i2, int i3);

        void onScrollStateChanged(RecyclerView recyclerView, int i);

        void onScrolled(RecyclerView recyclerView, int i, int i2);
    }

    public PullToRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mLoadMoreCount = 10;
        this.mIsSwipeEnable = false;
        this.isLoading = false;
        this.hasMoreItems = false;
        this.interceptHasActionDown = false;
        this.interceptLastY = -1;
        this.downY = -1;
        setup(context);
    }

    private void setup(Context context) {
        this.mScroller = new Scroller(context);
        setupExtra();
        initView(context);
        setLinster();
    }

    public void setRefreshing(boolean refreshing) {
    }

    private void initView(Context context) {
        this.mRootRelativeLayout = (RelativeLayout) JarUtils.inflate((Activity) context, C4048R.layout.ptrrv_root_view, null);
        addView(this.mRootRelativeLayout);
        this.mRecyclerView = (RecyclerView) this.mRootRelativeLayout.findViewById(C4048R.id.recycler_view);
        this.mRecyclerView.setHasFixedSize(true);
        if (!this.mIsSwipeEnable) {
            setEnabled(false);
        }
    }

    private void setupExtra() {
        this.isLoading = false;
        this.hasMoreItems = false;
        this.mPtrrvUtil = new PullToRefreshRecyclerViewUtil();
    }

    private void setLinster() {
        this.mInterOnScrollListener = new InterOnScrollListener();
        this.mRecyclerView.setOnScrollListener(this.mInterOnScrollListener);
    }

    public void setOnRefreshComplete() {
        setRefreshing(false);
    }

    public void setOnLoadMoreComplete() {
        setHasMoreItems(false);
    }

    public void setPagingableListener(PagingableListener pagingableListener) {
        this.mPagingableListener = pagingableListener;
    }

    public void setEmptyView(View emptyView) {
        if (this.mEmptyView != null) {
            this.mRootRelativeLayout.removeView(this.mEmptyView);
        }
        this.mEmptyView = emptyView;
    }

    public void setAdapter(Adapter adapter) {
        this.mRecyclerView.setAdapter(adapter);
        if (this.mAdapterObserver == null) {
            this.mAdapterObserver = new AdapterObserver();
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mAdapterObserver);
            this.mAdapterObserver.onChanged();
        }
    }

    public void scrollToPosition(int position) {
        this.mRecyclerView.scrollToPosition(position);
    }

    public void smoothScrollToPosition(int position) {
        this.mRecyclerView.smoothScrollToPosition(position);
    }

    public void addHeaderView(View view) {
        if (this.mHeader != null) {
            this.mRootRelativeLayout.removeView(this.mHeader);
        }
        this.mHeader = view;
        if (this.mHeader != null) {
            this.mHeader.getViewTreeObserver().addOnGlobalLayoutListener(new C46141());
            this.mRootRelativeLayout.addView(this.mHeader);
        }
    }

    public void removeHeader() {
        if (this.mRootHeader != null) {
            getRecyclerView().removeItemDecoration(this.mRootHeader);
            this.mRootHeader = null;
        }
        if (this.mHeader != null) {
            this.mRootRelativeLayout.removeView(this.mHeader);
            this.mHeader = null;
        }
    }

    public void setFooter(View view) {
    }

    public void setLoadMoreFooter(BaseLoadMoreView loadMoreFooter) {
        this.mLoadMoreFooter = loadMoreFooter;
    }

    public BaseLoadMoreView getLoadMoreFooter() {
        return this.mLoadMoreFooter;
    }

    public void addOnScrollListener(OnScrollListener onScrollLinstener) {
        this.mOnScrollLinstener = onScrollLinstener;
    }

    public LayoutManager getLayoutManager() {
        if (this.mRecyclerView != null) {
            return this.mRecyclerView.getLayoutManager();
        }
        return null;
    }

    public void onFinishLoading(boolean hasMoreItems, boolean needSetSelection) {
        if (getLayoutManager() != null) {
            if (!(hasMoreItems || this.mLoadMoreFooter == null)) {
                this.mCurScroll -= this.mLoadMoreFooter.getLoadMorePadding();
            }
            if (getLayoutManager().getItemCount() < this.mLoadMoreCount) {
                hasMoreItems = false;
            }
            setHasMoreItems(hasMoreItems);
            this.isLoading = false;
            if (needSetSelection) {
                this.mRecyclerView.scrollToPosition(findFirstVisibleItemPosition() - 1);
            }
        }
    }

    public int findFirstVisibleItemPosition() {
        return this.mPtrrvUtil.findFirstVisibleItemPosition(getLayoutManager());
    }

    public int findLastVisibleItemPosition() {
        return this.mPtrrvUtil.findLastVisibleItemPosition(getLayoutManager());
    }

    public int findFirstCompletelyVisibleItemPosition() {
        return this.mPtrrvUtil.findFirstCompletelyVisibleItemPosition(getLayoutManager());
    }

    public void setSwipeEnable(boolean enable) {
        this.mIsSwipeEnable = enable;
        setEnabled(this.mIsSwipeEnable);
    }

    public boolean isSwipeEnable() {
        return this.mIsSwipeEnable;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setLayoutManager(layoutManager);
        }
    }

    public void setLoadMoreCount(int count) {
        this.mLoadMoreCount = count;
    }

    public void release() {
    }

    public void setLoadmoreString(String str) {
        if (this.mLoadMoreFooter != null) {
            this.mLoadMoreFooter.setLoadmoreString(str);
        }
    }

    private void setHasMoreItems(boolean hasMoreItems) {
        this.hasMoreItems = hasMoreItems;
        if (this.mLoadMoreFooter == null) {
            this.mLoadMoreFooter = new DefaultLoadMoreView(getContext(), getRecyclerView());
        }
        if (this.hasMoreItems) {
            this.mRecyclerView.removeItemDecoration(this.mLoadMoreFooter);
            this.mRecyclerView.addItemDecoration(this.mLoadMoreFooter);
            return;
        }
        this.mRecyclerView.removeItemDecoration(this.mLoadMoreFooter);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!this.needScroll) {
            return super.onInterceptTouchEvent(event);
        }
        int action = event.getAction();
        LogUtil.m15791e(TAG, "onInterceptTouchEvent : isScrolling --> " + this.isScrolling + ", action: " + action);
        if (this.isScrolling && action != 0) {
            return false;
        }
        int y = (int) event.getY();
        obtainVelocity(event);
        switch (action) {
            case 0:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                    this.isScrolling = false;
                }
                this.mScrollStart = getScrollY();
                LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_DOWN): mScrollStart --> " + this.mScrollStart);
                if (!(getLayoutManager() == null || getLayoutManager().getChildAt(0) == null)) {
                    int firstItemTop = getLayoutManager().getChildAt(0).getTop();
                    LogUtil.m15791e(TAG, "onInterceptTouchEvent: firstItemTop --> " + firstItemTop);
                    if (firstItemTop == -1 && VERSION.SDK_INT >= 11) {
                        getLayoutManager().getChildAt(0).setTop(0);
                    }
                }
                int firstCompletelyVisibleItem = findFirstCompletelyVisibleItemPosition();
                LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_DOWN): firstCompletelyVisibleItem --> " + firstCompletelyVisibleItem);
                if (this.mScrollStart < (-this.foldableHeight) / 2) {
                    this.status = DragState.BOTTOM;
                } else {
                    this.status = DragState.TOP;
                }
                if (this.status == DragState.TOP && this.mScrollStart == 0 && firstCompletelyVisibleItem == 0) {
                    this.interceptHasActionDown = true;
                } else if (this.status == DragState.BOTTOM && this.mScrollStart == (-this.foldableHeight)) {
                    this.interceptHasActionDown = true;
                }
                this.interceptLastY = y;
                this.downY = y;
                LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_DOWN): status --> " + this.status);
                if (this.status == DragState.BOTTOM) {
                    if (!this.isScrolling && y < this.blankSpaceHeight) {
                        this.interceptHasActionDown = false;
                        LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_DOWN): --> blank space clicked: " + y);
                        return false;
                    }
                } else if (!this.isScrolling && y < (getMeasuredHeight() - this.persistantHeight) - this.foldableHeight) {
                    this.interceptHasActionDown = false;
                    LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_DOWN): --> beyond view range: " + y);
                    return false;
                }
                this.hasActionDown = true;
                this.mLastY = y;
                break;
            case 1:
                LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_UP): interceptHasActionDown --> " + this.interceptHasActionDown);
                this.interceptHasActionDown = false;
                this.interceptLastY = y;
                break;
            case 2:
                LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE): interceptHasActionDown --> " + this.interceptHasActionDown);
                if (!this.interceptHasActionDown) {
                    return false;
                }
                this.interceptHasActionDown = false;
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                int dy = y - this.interceptLastY;
                int dyToDown = y - this.downY;
                LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE): --> status: " + this.status + ", dy: " + dy);
                if (this.status != DragState.TOP) {
                    boolean containerEvent = false;
                    if (dyToDown < -20) {
                        LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 7: - outer view event");
                        containerEvent = true;
                    } else {
                        LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 8: - inner view event");
                        this.interceptHasActionDown = true;
                    }
                    if (dy < 0) {
                        LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 4: - scroll up");
                        scrollBy(0, -dy);
                    } else if (dy > 5) {
                        LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 5: - scroll down");
                        containerEvent = true;
                    } else {
                        LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 6: - touch equivalent");
                        this.interceptHasActionDown = true;
                    }
                    this.mLastY = y;
                    this.interceptLastY = y;
                    LogUtil.m15791e(TAG, "onInterceptTouchEvent: containerEvent --> " + containerEvent + ", dyToDown: " + dyToDown);
                    return containerEvent;
                } else if (dy > 0) {
                    LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 1: - scroll down");
                    scrollBy(0, -dy);
                    this.interceptLastY = y;
                    this.mLastY = y;
                    return true;
                } else if (dy < -5) {
                    LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 2: - scroll up");
                    this.interceptLastY = y;
                    this.mLastY = y;
                    break;
                } else {
                    LogUtil.m15791e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 3: - touch equivalent");
                    this.interceptLastY = y;
                    this.mLastY = y;
                    this.interceptHasActionDown = true;
                    return false;
                }
        }
        return false;
    }
}
