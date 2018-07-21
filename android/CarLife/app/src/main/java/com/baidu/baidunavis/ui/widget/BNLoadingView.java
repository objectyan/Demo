package com.baidu.baidunavis.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.baidu.mapframework.widget.RouteErrorView;

public class BNLoadingView
  extends RelativeLayout
{
  public static final int LOAD_END = 2;
  public static final int LOAD_FAIL = 3;
  public static final int LOAD_START = 1;
  private RelativeLayout mLoadFailTab = null;
  private RelativeLayout mLoadStartTab = null;
  private View mRootView = null;
  private RouteErrorView mRouteErrorView = null;
  
  public BNLoadingView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
    setMapClickable(false);
  }
  
  private void initView(Context paramContext)
  {
    this.mRootView = LayoutInflater.from(paramContext).inflate(2130968621, this);
    if (this.mRootView == null) {
      return;
    }
    this.mRootView.findViewById(2131624237).setBackgroundColor(0);
    this.mLoadStartTab = ((RelativeLayout)this.mRootView.findViewById(2131624238));
    this.mLoadFailTab = ((RelativeLayout)this.mRootView.findViewById(2131624240));
    this.mRouteErrorView = ((RouteErrorView)this.mRootView.findViewById(2131624241));
  }
  
  private void setMapClickable(boolean paramBoolean)
  {
    if (this.mLoadStartTab != null)
    {
      if (!paramBoolean) {
        this.mLoadStartTab.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView) {}
        });
      }
    }
    else {
      return;
    }
    this.mLoadStartTab.setOnClickListener(null);
  }
  
  public void resetBottomLoadtab(int paramInt)
  {
    if (paramInt == 1)
    {
      setVisibility(0);
      if (this.mLoadStartTab != null) {
        this.mLoadStartTab.setVisibility(0);
      }
      if (this.mLoadFailTab != null) {
        this.mLoadFailTab.setVisibility(8);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 3) {
            break;
          }
          setVisibility(0);
          if (this.mLoadStartTab != null) {
            this.mLoadStartTab.setVisibility(8);
          }
        } while (this.mLoadFailTab == null);
        this.mLoadFailTab.setVisibility(0);
        return;
      } while (paramInt != 2);
      setVisibility(8);
      if (this.mLoadStartTab != null) {
        this.mLoadStartTab.setVisibility(8);
      }
    } while (this.mLoadFailTab == null);
    this.mLoadFailTab.setVisibility(8);
  }
  
  public void setLoadFailAction(String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mRouteErrorView != null))
    {
      this.mRouteErrorView.setText(paramString);
      this.mRouteErrorView.setRepeatButtonListener(paramOnClickListener);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/widget/BNLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */