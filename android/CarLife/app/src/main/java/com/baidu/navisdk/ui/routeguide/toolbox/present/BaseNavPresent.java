package com.baidu.navisdk.ui.routeguide.toolbox.present;

import android.view.View;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;

public abstract class BaseNavPresent
{
  protected abstract void initViewStatus();
  
  public abstract void onClick(View paramView, int paramInt);
  
  public abstract void onTopStatus();
  
  public abstract void setOnSubViewClickListener(OnRGSubViewListener paramOnRGSubViewListener);
  
  public void startInit()
  {
    initViewStatus();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/toolbox/present/BaseNavPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */