package com.baidu.navisdk.util.http.center;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;

public class BNHttpCenter
  implements IBNHttpCenter
{
  public static final String TAG = BNHttpCenter.class.getSimpleName();
  private static BNHttpCenter sInstance = null;
  private static final Object sInstanceLock = new Object();
  private IBNHttpCenter mCurHttpCenter = null;
  
  public static IBNHttpCenter getInstance()
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new BNHttpCenter();
      }
      return sInstance;
    }
  }
  
  public static void init(IBNHttpCenter paramIBNHttpCenter)
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new BNHttpCenter();
      }
      if (paramIBNHttpCenter != null)
      {
        sInstance.setHttpCenter(paramIBNHttpCenter);
        LogUtil.e(TAG, "use the outer http cetner.");
        return;
      }
    }
    sInstance.setHttpCenter(BNInnerHttpCenter.getInstance());
    LogUtil.e(TAG, "use the inner http cetner.");
  }
  
  private void setHttpCenter(IBNHttpCenter paramIBNHttpCenter)
  {
    if (paramIBNHttpCenter == null)
    {
      LogUtil.e(TAG, "setHttpCenter() http center is null !!!");
      return;
    }
    if (this.mCurHttpCenter != null)
    {
      LogUtil.e(TAG, "setHttpCenter() return for cur http center is not null !!!");
      return;
    }
    this.mCurHttpCenter = paramIBNHttpCenter;
  }
  
  public void get(String paramString, HashMap<String, String> paramHashMap, IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams)
  {
    if (this.mCurHttpCenter != null)
    {
      this.mCurHttpCenter.get(paramString, paramHashMap, paramIBNHttpResponseHandler, paramBNHttpParams);
      return;
    }
    LogUtil.e(TAG, "get() the http center is null.");
  }
  
  public void post(String paramString, HashMap<String, String> paramHashMap, IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams)
  {
    if (this.mCurHttpCenter != null)
    {
      this.mCurHttpCenter.post(paramString, paramHashMap, paramIBNHttpResponseHandler, paramBNHttpParams);
      return;
    }
    LogUtil.e(TAG, "post() the http center is null.");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/center/BNHttpCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */