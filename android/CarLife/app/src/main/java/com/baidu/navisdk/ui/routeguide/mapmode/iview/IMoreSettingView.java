package com.baidu.navisdk.ui.routeguide.mapmode.iview;

public abstract interface IMoreSettingView
{
  public abstract void getIsShowMapSwitch(int paramInt);
  
  public abstract void getMapMode(int paramInt);
  
  public abstract void getNaviDayAndNightMode(int paramInt);
  
  public abstract void getPlayTTsVoiceMode(int paramInt);
  
  public abstract void getVoiceMode(int paramInt);
  
  public abstract void jumpCarLogoPage();
  
  public abstract void onBlueToothRedGuide(boolean paramBoolean);
  
  public abstract void onCarLogoRedGuide(boolean paramBoolean);
  
  public abstract void onCarPlateInputLayoutVisible(int paramInt);
  
  public abstract void onVoiceRedGuide(boolean paramBoolean);
  
  public abstract void setVoiceSpeakSetting(int paramInt1, int paramInt2);
  
  public abstract void showBlueToothChannelGuide(boolean paramBoolean);
  
  public abstract void showCarPlate(String paramString);
  
  public abstract void updateCheckDrawable(int paramInt);
  
  public abstract void updateVoiceName(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/iview/IMoreSettingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */