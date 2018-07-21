package com.baidu.location;

public abstract class BDAbstractLocationListener
{
  public void onConnectHotSpotMessage(String paramString, int paramInt) {}
  
  public void onLocDiagnosticMessage(int paramInt1, int paramInt2, String paramString) {}
  
  public abstract void onReceiveLocation(BDLocation paramBDLocation);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/BDAbstractLocationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */