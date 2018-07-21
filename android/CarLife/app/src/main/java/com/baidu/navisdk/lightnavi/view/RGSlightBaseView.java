package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;

public abstract class RGSlightBaseView
{
  protected Context mContext;
  protected Handler mHandler;
  protected ViewGroup mRootViewGroup;
  
  public RGSlightBaseView(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.mRootViewGroup = paramViewGroup;
  }
  
  public RGSlightBaseView(Context paramContext, ViewGroup paramViewGroup, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mRootViewGroup = paramViewGroup;
    this.mHandler = paramHandler;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/RGSlightBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */