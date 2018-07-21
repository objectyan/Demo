package com.baidu.navisdk.ui.widget.ptrrecyclerview.util;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;

public class PullToRefreshRecyclerViewUtil
{
  public int findFirstCompletelyVisibleItemPosition(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager != null)
    {
      if ((paramLayoutManager instanceof LinearLayoutManager)) {
        return ((LinearLayoutManager)paramLayoutManager).findFirstCompletelyVisibleItemPosition();
      }
      if ((paramLayoutManager instanceof GridLayoutManager)) {
        return ((GridLayoutManager)paramLayoutManager).findFirstCompletelyVisibleItemPosition();
      }
    }
    return -1;
  }
  
  public int findFirstVisibleItemPosition(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager != null)
    {
      if ((paramLayoutManager instanceof LinearLayoutManager)) {
        return ((LinearLayoutManager)paramLayoutManager).findFirstVisibleItemPosition();
      }
      if ((paramLayoutManager instanceof GridLayoutManager)) {
        return ((GridLayoutManager)paramLayoutManager).findFirstVisibleItemPosition();
      }
    }
    return -1;
  }
  
  public int findLastVisibleItemPosition(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager != null)
    {
      if ((paramLayoutManager instanceof LinearLayoutManager)) {
        return ((LinearLayoutManager)paramLayoutManager).findLastVisibleItemPosition();
      }
      if ((paramLayoutManager instanceof GridLayoutManager)) {
        return ((GridLayoutManager)paramLayoutManager).findLastVisibleItemPosition();
      }
    }
    return -1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/util/PullToRefreshRecyclerViewUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */