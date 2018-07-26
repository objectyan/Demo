package com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.util.PullToRefreshRecyclerViewUtil;

public class BaseLoadMoreView extends ItemDecoration {
    protected static final int MSG_INVILIDATE = 1;
    protected Handler mInvalidateHanlder = new C46151();
    protected int mLoadMorePadding = 100;
    protected String mLoadMoreString;
    protected OnDrawListener mOnDrawListener;
    protected PullToRefreshRecyclerViewUtil mPtrrvUtil;
    protected RecyclerView mRecyclerView;
    protected long mUpdateTime = 150;

    public interface OnDrawListener {
        boolean onDrawLoadMore(Canvas canvas, RecyclerView recyclerView);
    }

    /* renamed from: com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView$1 */
    class C46151 extends Handler {
        C46151() {
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (BaseLoadMoreView.this.mRecyclerView != null && BaseLoadMoreView.this.mRecyclerView.getAdapter() != null && BaseLoadMoreView.this.mPtrrvUtil.findLastVisibleItemPosition(BaseLoadMoreView.this.mRecyclerView.getLayoutManager()) == BaseLoadMoreView.this.mRecyclerView.getAdapter().getItemCount() - 1) {
                BaseLoadMoreView.this.mRecyclerView.invalidate();
            }
        }
    }

    public BaseLoadMoreView(Context context, RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        this.mPtrrvUtil = new PullToRefreshRecyclerViewUtil();
    }

    public void setLoadmoreString(String str) {
        this.mLoadMoreString = str;
    }

    public String getLoadmoreString() {
        return this.mLoadMoreString;
    }

    public int getLoadMorePadding() {
        return this.mLoadMorePadding;
    }

    public void setLoadMorePadding(int padding) {
        this.mLoadMorePadding = padding;
    }

    public void onDrawOver(Canvas c, RecyclerView parent, State state) {
        super.onDrawOver(c, parent, state);
        this.mInvalidateHanlder.removeMessages(1);
        onDrawLoadMore(c, parent);
        this.mInvalidateHanlder.sendEmptyMessageDelayed(1, this.mUpdateTime);
    }

    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (itemPosition == parent.getAdapter().getItemCount() - 1) {
            outRect.set(0, 0, 0, getLoadMorePadding());
        }
    }

    protected void onDrawLoadMore(Canvas c, RecyclerView parent) {
        if (this.mOnDrawListener != null && !this.mOnDrawListener.onDrawLoadMore(c, parent)) {
        }
    }

    public void setOnDrawListener(OnDrawListener listener) {
        this.mOnDrawListener = listener;
    }

    public void release() {
        this.mRecyclerView = null;
    }
}
