package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;

public abstract class RGState
{
  public static final String CLASS_PREFIX = RGState.class.getSimpleName();
  public static final String METHOD_NAME_ENTER = "enter";
  public static final String METHOD_NAME_EXCUTE = "excute";
  public static final String METHOD_NAME_EXIT = "exit";
  public static final String PACKAGE_NAME = RGState.class.getPackage().getName();
  protected Bundle enterParams = null;
  
  public void enter()
  {
    enter(null);
  }
  
  public void enter(Bundle paramBundle)
  {
    this.enterParams = paramBundle;
  }
  
  public void excute()
  {
    excute(null);
  }
  
  public void excute(Bundle paramBundle)
  {
    this.enterParams = paramBundle;
    onActionUI();
    onActionNaviEngine();
    onActionLayers();
    onActionMapStatus();
  }
  
  public void exit() {}
  
  protected abstract void onActionLayers();
  
  protected abstract void onActionMapStatus();
  
  protected abstract void onActionNaviEngine();
  
  protected abstract void onActionUI();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */