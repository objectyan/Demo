package com.baidu.platform.comapi.map;

public abstract interface EngineMsgListener
{
  public abstract void onEnterIndoorMapMode(IndoorMapInfo paramIndoorMapInfo);
  
  public abstract void onExitIndoorMapMode();
  
  public abstract void onLongLinkConnect();
  
  public abstract void onLongLinkDisConnect();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/EngineMsgListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */