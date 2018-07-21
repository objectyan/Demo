package com.baidu.navisdk.ui.widget;

import android.view.View;
import android.view.ViewGroup;

public class BNLoadingViewProxy
{
  public static abstract interface LoadingProxy
  {
    public static final int LOADING_TYPE_DEFAULT = 1;
    public static final int LOADING_TYPE_DIALOG = 2;
    
    public abstract View getLoadingView();
    
    public abstract void onLoadingEnd(int paramInt, boolean paramBoolean, ViewGroup paramViewGroup, BNLoadingViewProxy.ViewActionListener paramViewActionListener);
    
    public abstract void onLoadingStart(int paramInt, ViewGroup paramViewGroup);
  }
  
  public static abstract interface ViewActionListener
  {
    public static final int ACTION_RETRY = 1;
    
    public abstract void onAction(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNLoadingViewProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */