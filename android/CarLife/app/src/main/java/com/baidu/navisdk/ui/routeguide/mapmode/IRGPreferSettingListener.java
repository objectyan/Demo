package com.baidu.navisdk.ui.routeguide.mapmode;

public abstract interface IRGPreferSettingListener
{
  public abstract boolean isSupportAvoidJam();
  
  public abstract boolean[] onGetLastPreferenceCheck();
  
  public abstract int onGetLastPreferenceValue();
  
  public abstract boolean[] onGetPreferenceCheck();
  
  public abstract void onSetLastPreferenceValue(int paramInt);
  
  public abstract void onSetPreferenceCheck(boolean paramBoolean, int paramInt);
  
  public abstract void onSetPreferenceCheck(boolean[] paramArrayOfBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/IRGPreferSettingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */