package com.baidu.navisdk.comapi.voicecommand;

public abstract interface APPVoiceFuncCallback
{
  public abstract boolean changeLocationMode(int paramInt);
  
  public abstract boolean exitAPP();
  
  public abstract int getPageType();
  
  public abstract boolean goHome();
  
  public abstract boolean goOffice();
  
  public abstract boolean limitLine();
  
  public abstract String myLoc();
  
  public abstract boolean nameSearch(String paramString);
  
  public abstract boolean onFullview();
  
  public abstract boolean onOtherVoiceFunc(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void poiDataNotNew();
  
  public abstract void showVoiceHelp();
  
  public abstract boolean spaceSearch(String paramString);
  
  public abstract boolean switchDayNightMode(int paramInt);
  
  public abstract boolean washCar();
  
  public abstract boolean weather();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/voicecommand/APPVoiceFuncCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */