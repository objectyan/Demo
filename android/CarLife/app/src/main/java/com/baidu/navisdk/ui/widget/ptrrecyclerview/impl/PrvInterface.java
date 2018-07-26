package com.baidu.navisdk.ui.widget.ptrrecyclerview.impl;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.OnScrollListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.PagingableListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;

public interface PrvInterface {
    void addHeaderView(View view);

    void addOnScrollListener(OnScrollListener onScrollListener);

    LayoutManager getLayoutManager();

    BaseLoadMoreView getLoadMoreFooter();

    RecyclerView getRecyclerView();

    boolean isSwipeEnable();

    void onFinishLoading(boolean z, boolean z2);

    void release();

    void removeHeader();

    void scrollToPosition(int i);

    void setAdapter(Adapter adapter);

    void setEmptyView(View view);

    void setFooter(View view);

    void setLayoutManager(LayoutManager layoutManager);

    void setLoadMoreCount(int i);

    void setLoadMoreFooter(BaseLoadMoreView baseLoadMoreView);

    void setOnLoadMoreComplete();

    void setOnRefreshComplete();

    void setPagingableListener(PagingableListener pagingableListener);

    void setSwipeEnable(boolean z);

    void smoothScrollToPosition(int i);
}
