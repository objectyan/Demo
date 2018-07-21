package com.baidu.navisdk.ui.widget.ptrrecyclerview.impl;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.OnScrollListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.PagingableListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;

public abstract interface PrvInterface
{
  public abstract void addHeaderView(View paramView);
  
  public abstract void addOnScrollListener(PullToRefreshRecyclerView.OnScrollListener paramOnScrollListener);
  
  public abstract RecyclerView.LayoutManager getLayoutManager();
  
  public abstract BaseLoadMoreView getLoadMoreFooter();
  
  public abstract RecyclerView getRecyclerView();
  
  public abstract boolean isSwipeEnable();
  
  public abstract void onFinishLoading(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void release();
  
  public abstract void removeHeader();
  
  public abstract void scrollToPosition(int paramInt);
  
  public abstract void setAdapter(RecyclerView.Adapter paramAdapter);
  
  public abstract void setEmptyView(View paramView);
  
  public abstract void setFooter(View paramView);
  
  public abstract void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager);
  
  public abstract void setLoadMoreCount(int paramInt);
  
  public abstract void setLoadMoreFooter(BaseLoadMoreView paramBaseLoadMoreView);
  
  public abstract void setOnLoadMoreComplete();
  
  public abstract void setOnRefreshComplete();
  
  public abstract void setPagingableListener(PullToRefreshRecyclerView.PagingableListener paramPagingableListener);
  
  public abstract void setSwipeEnable(boolean paramBoolean);
  
  public abstract void smoothScrollToPosition(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/impl/PrvInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */