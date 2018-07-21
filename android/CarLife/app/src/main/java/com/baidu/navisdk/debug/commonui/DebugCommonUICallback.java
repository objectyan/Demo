package com.baidu.navisdk.debug.commonui;

import java.util.List;

public abstract interface DebugCommonUICallback
{
  public abstract String getInfo();
  
  public abstract List<DebugCommonUIView.DebugViewKeyValueData> getKeyValues();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/debug/commonui/DebugCommonUICallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */