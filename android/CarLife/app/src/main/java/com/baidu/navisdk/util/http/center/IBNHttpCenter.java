package com.baidu.navisdk.util.http.center;

import java.util.HashMap;

public abstract interface IBNHttpCenter
{
  public abstract void get(String paramString, HashMap<String, String> paramHashMap, IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams);
  
  public abstract void post(String paramString, HashMap<String, String> paramHashMap, IBNHttpResponseHandler paramIBNHttpResponseHandler, BNHttpParams paramBNHttpParams);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/center/IBNHttpCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */