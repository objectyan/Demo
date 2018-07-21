package com.baidu.navisdk.ui.routeguide.toolbox.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;

public abstract interface IRGToolBoxView
{
  public abstract void closeToolBox();
  
  public abstract void closeToolBox(boolean paramBoolean);
  
  public abstract void hideToolBox();
  
  public abstract View inflate();
  
  public abstract void onDestroy();
  
  public abstract void onOrientationChange(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void openToolBox();
  
  public abstract void setCurStateTips(String paramString);
  
  public abstract void showToolBox();
  
  public abstract void switchToolBarMode(int paramInt);
  
  public abstract void updateArriveTime(String paramString);
  
  public abstract void updateRemainTimeAndDist(String paramString);
  
  public abstract void updateStyle(boolean paramBoolean);
  
  public abstract void updateSubListener(OnRGSubViewListener paramOnRGSubViewListener);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/toolbox/view/IRGToolBoxView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */