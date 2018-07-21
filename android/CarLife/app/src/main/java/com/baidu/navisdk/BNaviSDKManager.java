package com.baidu.navisdk;

public class BNaviSDKManager
{
  private static BNaviSDKManager instance = new BNaviSDKManager();
  
  public static BNaviSDKManager getInstance()
  {
    if (instance == null) {
      instance = new BNaviSDKManager();
    }
    return instance;
  }
  
  public void SDKNavigatorInit() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/BNaviSDKManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */