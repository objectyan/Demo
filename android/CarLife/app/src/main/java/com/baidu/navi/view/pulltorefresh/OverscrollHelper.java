package com.baidu.navi.view.pulltorefresh;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

@TargetApi(9)
public final class OverscrollHelper
{
  static final float DEFAULT_OVERSCROLL_SCALE = 1.0F;
  static final String LOG_TAG = "OverscrollHelper";
  
  static boolean isAndroidOverScrollEnabled(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 9)
    {
      bool1 = bool2;
      if (paramView.getOverScrollMode() != 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void overScrollBy(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean)
  {
    PullToRefreshBase.Mode localMode;
    switch (paramPullToRefreshBase.getPullToRefreshScrollDirection())
    {
    default: 
      paramInt2 = paramInt4;
      paramInt1 = paramPullToRefreshBase.getScrollY();
      if ((paramPullToRefreshBase.isPullToRefreshOverScrollEnabled()) && (!paramPullToRefreshBase.isRefreshing()))
      {
        localMode = paramPullToRefreshBase.getMode();
        if ((!localMode.permitsPullToRefresh()) || (paramBoolean) || (paramInt3 == 0)) {
          break label209;
        }
        paramInt2 = paramInt3 + paramInt2;
        if (paramInt2 >= 0 - paramInt6) {
          break label130;
        }
        if (localMode.showHeaderLoadingLayout())
        {
          if (paramInt1 == 0) {
            paramPullToRefreshBase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
          }
          paramPullToRefreshBase.setHeaderScroll((int)((paramInt1 + paramInt2) * paramFloat));
        }
      }
      break;
    }
    label130:
    label177:
    label209:
    while ((!paramBoolean) || (PullToRefreshBase.State.OVERSCROLLING != paramPullToRefreshBase.getState()))
    {
      do
      {
        do
        {
          return;
          paramInt3 = paramInt1;
          paramInt1 = paramPullToRefreshBase.getScrollX();
          break;
          if (paramInt2 <= paramInt5 + paramInt6) {
            break label177;
          }
        } while (!localMode.showFooterLoadingLayout());
        if (paramInt1 == 0) {
          paramPullToRefreshBase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
        }
        paramPullToRefreshBase.setHeaderScroll((int)((paramInt1 + paramInt2 - paramInt5) * paramFloat));
        return;
      } while ((Math.abs(paramInt2) > paramInt6) && (Math.abs(paramInt2 - paramInt5) > paramInt6));
      paramPullToRefreshBase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
      return;
    }
    paramPullToRefreshBase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
  }
  
  public static void overScrollBy(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    overScrollBy(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
  }
  
  public static void overScrollBy(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    overScrollBy(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/OverscrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */