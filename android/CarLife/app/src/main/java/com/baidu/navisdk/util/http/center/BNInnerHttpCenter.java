package com.baidu.navisdk.util.http.center;

import java.util.HashMap;

public class BNInnerHttpCenter
  implements IBNHttpCenter
{
  private static IBNHttpCenter sInstance = null;
  private static final Object sInstanceLock = new Object();
  
  public static IBNHttpCenter getInstance()
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new BNInnerHttpCenter();
      }
      return sInstance;
    }
  }
  
  public void get(String paramString, HashMap<String, String> paramHashMap, IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams)
  {
    if (paramBNHttpParams == null) {
      new BNHttpParams();
    }
  }
  
  public void post(String paramString, HashMap<String, String> paramHashMap, IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams)
  {
    if (paramBNHttpParams == null) {
      new BNHttpParams();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/center/BNInnerHttpCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */