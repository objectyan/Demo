package com.baidu.navisdk.ui.routeguide.subview;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

public abstract class RGBaseView
{
  protected Context mContext;
  protected ViewGroup mRootViewGroup;
  protected OnRGSubViewListener mSubViewListener;
  private boolean mVisibility;
  
  public abstract void destory();
  
  public void hide()
  {
    this.mVisibility = false;
    onHide();
  }
  
  public boolean isVisibility()
  {
    return this.mVisibility;
  }
  
  protected void onHide() {}
  
  protected void onShow() {}
  
  public void show()
  {
    this.mVisibility = true;
    onShow();
  }
  
  public abstract void updateData(Bundle paramBundle);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/RGBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */