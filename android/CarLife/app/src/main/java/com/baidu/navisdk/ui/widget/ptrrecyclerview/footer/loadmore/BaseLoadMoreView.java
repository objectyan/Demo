package com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.util.PullToRefreshRecyclerViewUtil;

public class BaseLoadMoreView
  extends RecyclerView.ItemDecoration
{
  protected static final int MSG_INVILIDATE = 1;
  protected Handler mInvalidateHanlder = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if ((BaseLoadMoreView.this.mRecyclerView == null) || (BaseLoadMoreView.this.mRecyclerView.getAdapter() == null)) {}
      int i;
      do
      {
        return;
        i = BaseLoadMoreView.this.mRecyclerView.getAdapter().getItemCount();
      } while (BaseLoadMoreView.this.mPtrrvUtil.findLastVisibleItemPosition(BaseLoadMoreView.this.mRecyclerView.getLayoutManager()) != i - 1);
      BaseLoadMoreView.this.mRecyclerView.invalidate();
    }
  };
  protected int mLoadMorePadding = 100;
  protected String mLoadMoreString;
  protected OnDrawListener mOnDrawListener;
  protected PullToRefreshRecyclerViewUtil mPtrrvUtil;
  protected RecyclerView mRecyclerView;
  protected long mUpdateTime = 150L;
  
  public BaseLoadMoreView(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
    this.mPtrrvUtil = new PullToRefreshRecyclerViewUtil();
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    if (paramInt == paramRecyclerView.getAdapter().getItemCount() - 1) {
      paramRect.set(0, 0, 0, getLoadMorePadding());
    }
  }
  
  public int getLoadMorePadding()
  {
    return this.mLoadMorePadding;
  }
  
  public String getLoadmoreString()
  {
    return this.mLoadMoreString;
  }
  
  protected void onDrawLoadMore(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    if ((this.mOnDrawListener != null) && (this.mOnDrawListener.onDrawLoadMore(paramCanvas, paramRecyclerView))) {}
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDrawOver(paramCanvas, paramRecyclerView, paramState);
    this.mInvalidateHanlder.removeMessages(1);
    onDrawLoadMore(paramCanvas, paramRecyclerView);
    this.mInvalidateHanlder.sendEmptyMessageDelayed(1, this.mUpdateTime);
  }
  
  public void release()
  {
    this.mRecyclerView = null;
  }
  
  public void setLoadMorePadding(int paramInt)
  {
    this.mLoadMorePadding = paramInt;
  }
  
  public void setLoadmoreString(String paramString)
  {
    this.mLoadMoreString = paramString;
  }
  
  public void setOnDrawListener(OnDrawListener paramOnDrawListener)
  {
    this.mOnDrawListener = paramOnDrawListener;
  }
  
  public static abstract interface OnDrawListener
  {
    public abstract boolean onDrawLoadMore(Canvas paramCanvas, RecyclerView paramRecyclerView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/footer/loadmore/BaseLoadMoreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */